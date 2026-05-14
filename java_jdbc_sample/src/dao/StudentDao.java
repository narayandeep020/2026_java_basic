package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.StudentDTO;
import util.AppConstants;
import util.DateUtility;
import util.DbConnectUtil;

public class StudentDao {
	private Connection conn;
	private CallableStatement cstmt;
	private ResultSet rs;

	public static class ProcedureResult {
		private int count;

		public ProcedureResult(int count) {
			this.count = count;
		}

		public int getCount() {
			return count;
		}

//		public String toString() {
//			return count + " ";
//		}
	}

	public ProcedureResult callStudentCrudProc(int studentId, String studentName, String studentCode,
			String studentAddress, String studentEmail, String studentPhone, int studentCredit, int bookId,
			int createdAdmin, int updatedAdmin, Date createdDate, Date updatedDate, String isDeleted,
			String operationType) {
		try {
			conn = DbConnectUtil.getConnection();
			String callQuery = "{call proc_student_detail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cstmt = conn.prepareCall(callQuery);

			cstmt.setInt(1, studentId);
			cstmt.setString(2, studentName);
			cstmt.setString(3, studentCode);
			cstmt.setString(4, studentAddress);
			cstmt.setString(5, studentEmail);
			cstmt.setString(6, studentPhone);
			cstmt.setInt(7, studentCredit);
			cstmt.setInt(8, bookId);
			cstmt.setInt(9, createdAdmin);
			cstmt.setInt(10, updatedAdmin);
			cstmt.setDate(11, DateUtility.convertUtilToSqlDate(createdDate));
			cstmt.setDate(12, DateUtility.convertUtilToSqlDate(updatedDate));
			cstmt.setString(13, isDeleted);
			cstmt.setString(14, operationType);
			cstmt.registerOutParameter(15, Types.INTEGER);

			cstmt.execute();
			int count = cstmt.getInt(15);
			return new ProcedureResult(count);

		} catch (Exception e) {
			System.out.println("Error calling proc student detail: " + e.getMessage());
			e.printStackTrace();
			return new ProcedureResult(-1);
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.out.println("Error closing resources:" + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public StudentDTO getStudentById(int studentId) {
		try {
			conn = DbConnectUtil.getConnection();
			String idQuery = "{call proc_student_detail(? , null, null, null, null, null, 0, 0, 0, 0, null, null, null ,?,?)}";
			cstmt = conn.prepareCall(idQuery);

			cstmt.setInt(1, studentId);
			cstmt.setString(2, AppConstants.READ);
			cstmt.setInt(3, Types.INTEGER);

			rs = cstmt.executeQuery();

			StudentDTO stdto = null;
			if (rs.next()) {
				stdto = new StudentDTO(rs.getInt("student_id"), rs.getString("student_name"),
						rs.getString("student_code"), rs.getString("student_address"), rs.getString("student_email"),
						rs.getString("student_phone"), rs.getInt("student_credit"), rs.getInt("book_id"),
						rs.getInt("created_by_admin"), rs.getInt("updated_by_admin"), rs.getDate("created_date"),
						rs.getDate("updated_date"), AppConstants.NOT_DELETED);
			}
			return stdto;
		} catch (Exception e) {
			System.out.println(" Error author get by Id: " + e.getMessage());
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public List<StudentDTO> getAllStudent() {
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			conn = DbConnectUtil.getConnection();
			String getQuery = "{call proc_student_detail(0, null, null, null, null, null, 0, 0, 0, 0, null, null, null, ?,?)}";
			cstmt = conn.prepareCall(getQuery);

			cstmt.setString(1, AppConstants.READ_ALL);
			cstmt.setInt(2, Types.INTEGER);
			rs = cstmt.executeQuery();

			List<StudentDTO> students = new ArrayList<>();
			while (rs.next()) {
				StudentDTO student = new StudentDTO(rs.getInt("student_id"), rs.getString("student_name"),
						rs.getString("student_code"), rs.getString("student_address"), rs.getString("student_email"),
						rs.getString("student_phone"), rs.getInt("student_credit"), rs.getInt("book_id"),
						rs.getInt("created_by_admin"), rs.getInt("updated_by_admin"), rs.getDate("created_date"),
						rs.getDate("updated_date"), AppConstants.NOT_DELETED);
				students.add(student);
			}
			return students;
		} catch (Exception e) {
			System.out.println("Error getting all students: " + e.getMessage());
			return new ArrayList<>();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.out.println("Error closing resources: " + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public ProcedureResult createStudent(StudentDTO student) {
		return callStudentCrudProc(student.getStudentId(), student.getStudentName(), student.getStudentCode(),
				student.getStudentAddress(), student.getStudentEmail(), student.getStudentPhone(),
				student.getStudentCredit(), student.getBookId(), student.getCreatedAdmin(), student.getUpdatedAdmin(),
				student.getCreatedDate(), student.getUpdatedDate(), AppConstants.NOT_DELETED, AppConstants.INSERT);
	}

	public ProcedureResult updateStudent(StudentDTO student) {
		return callStudentCrudProc(student.getStudentId(), student.getStudentName(), student.getStudentCode(),
				student.getStudentAddress(), student.getStudentEmail(), student.getStudentPhone(),
				student.getStudentCredit(), student.getBookId(), student.getCreatedAdmin(), student.getUpdatedAdmin(),
				student.getCreatedDate(), student.getUpdatedDate(), AppConstants.NOT_DELETED, AppConstants.UPDATE);
	}

	public ProcedureResult deleteStudent(int studentId) {
		return callStudentCrudProc(studentId, null, null, null, null, null, 0, 0, 0, 0, null, null,
				AppConstants.NOT_DELETED, AppConstants.DELETE);
	}

	public List<StudentDTO> searchStudent(String studentName, String studentCode) {
		try {
			conn = DbConnectUtil.getConnection();
			String searchQuery = "{call proc_student_detail(0, ?, ?, null, null, null, 0, 0, 0, 0, null, null, null, ?, ?)}";
			cstmt = conn.prepareCall(searchQuery);

			cstmt.setString(1, studentName);
			cstmt.setString(2, studentCode);
			cstmt.setString(3, AppConstants.SEARCH);
			cstmt.setInt(4, Types.INTEGER);

			rs = cstmt.executeQuery();
			List<StudentDTO> students = new ArrayList<>();
			while (rs.next()) {
				StudentDTO student = new StudentDTO(rs.getInt("student_id"), rs.getString("student_name"),
						rs.getString("student_code"), rs.getString("student_address"), rs.getString("student_email"),
						rs.getString("student_phone"), rs.getInt("student_credit"), rs.getInt("book_id"),
						rs.getInt("created_by_admin"), rs.getInt("updated_by_admin"), rs.getDate("created_date"),
						rs.getDate("updated_date"), AppConstants.NOT_DELETED);
				students.add(student);
			}
			return students;
		} catch (Exception e) {
			System.out.println("Error searching student: " + e.getMessage());
			return new ArrayList<>();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.out.println("Error closing resources: " + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public static void main(String[] args) {
		StudentDao sdao = new StudentDao();

		StudentDTO sdto = new StudentDTO();
		sdto.setStudentName("Satyam Sai");
		sdto.setStudentCode("COD008");
		sdto.setStudentAddress("katni, MP");
		sdto.setStudentEmail("Saiiii123@gmail.com");
		sdto.setStudentPhone("+918885556677");
		sdto.setStudentCredit(55);
		sdto.setBookId(3008);
		sdto.setCreatedAdmin(4007);

//		ProcedureResult create = sdao.createStudent(sdto);
//		System.out.println("New Admin inserted: " + create);

		List<StudentDTO> allStudent = sdao.getAllStudent();
		System.out.println("All Students: " + allStudent.size());
		allStudent.forEach(System.out::println);

		List<StudentDTO> searchStudent = sdao.searchStudent("Alice", "DN0004");
		System.out.println("Search Student in table: " + searchStudent);
		searchStudent.forEach(System.out::println);
//
//		ProcedureResult delete = sdao.deleteStudent(5014);
//		System.out.println("Deleted Student: " + delete);
	}

}
