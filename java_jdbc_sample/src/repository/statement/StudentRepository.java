package repository.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.StudentDTO;
import util.DbConnectUtil;

public class StudentRepository {
	public static void main(String[] args) throws Exception {

		StudentDTO studentdto = new StudentDTO();
		studentdto.setStudentName("DeepNarayan");
		studentdto.setStudentCode("DN0004");
		studentdto.setStudentAddress("Maiher,Satna");
		studentdto.setStudentEmail("narayandeep004@gmali.com");
		studentdto.setStudentPhone("+91 8839422237");
		studentdto.setStudentCredit(50);
		studentdto.setBookId(3008);
		studentdto.setCreatedAdmin(4008);

		StudentRepository sturepo = new StudentRepository();
		StudentDTO sdto = sturepo.addStudent(studentdto);
		System.out.println("Saved Student Details" + sdto);
	}

	private static Connection con;

	private StudentDTO addStudent(StudentDTO studentdto) throws Exception {
		StudentDTO sdto = null;
		Statement st = null;
		try {
			con = DbConnectUtil.getConnection();
			st = con.createStatement();
			String insertsql = "insert into student_detail(student_name, student_code, student_address, student_email, student_phone, student_credit, book_id, created_by_admin)"
					+ "values('" + studentdto.getStudentName() + "','" + studentdto.getStudentCode() + "','"
					+ studentdto.getStudentAddress() + "','" + studentdto.getStudentEmail() + "','"
					+ studentdto.getStudentPhone() + "','" + studentdto.getStudentCredit() + "','"
					+ studentdto.getBookId() + "','" + studentdto.getCreatedAdmin() + "')";

			int rowAffected = st.executeUpdate(insertsql, Statement.RETURN_GENERATED_KEYS);
			if (rowAffected > 0) {
				ResultSet result = st.getGeneratedKeys();
				if (result.next()) {
					studentdto.setStudentId(result.getInt(1));
					sdto = getPublisherById(studentdto.getStudentId());
				}
			}
		} catch (SQLException | RuntimeException e) {
			e.printStackTrace();
		} finally {
			st.close();
			DbConnectUtil.closeConnection(con);
		}
		return sdto;
	}

	private StudentDTO getPublisherById(int studentId) throws Exception {
		StudentDTO studto = new StudentDTO();
		Statement st = null;
		try {
			con = DbConnectUtil.getConnection();
			st = con.createStatement();
			String fetchsql = "select * from student_detail";
			ResultSet rs = st.executeQuery(fetchsql);

			while (rs.next()) {
				studto.setStudentId(rs.getInt("student_id"));
				studto.setStudentName(rs.getString("student_name"));
				studto.setStudentCode(rs.getString("student_code"));
				studto.setStudentAddress(rs.getString("student_address"));
				studto.setStudentEmail(rs.getString("student_email"));
				studto.setStudentPhone(rs.getString("student_phone"));
				studto.setStudentCredit(rs.getInt("student_credit"));
				studto.setCreatedAdmin(rs.getInt("created_by_admin"));
				studto.setUpdatedAdmin(rs.getInt("updated_by_admin"));
				studto.setCreatedDate(rs.getDate("created_date"));
				studto.setUpdatedDate(rs.getDate("updated_date"));
				studto.setIsDeleted(rs.getString("is_deleted"));
			}
		} catch (SQLException | RuntimeException e) {
			e.printStackTrace();
		} finally {
			st.close();
			DbConnectUtil.closeConnection(con);
		}

		return studto;
	}

}
