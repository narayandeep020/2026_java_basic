package repository.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.StudentDTO;
import util.DbConnectUtil;

public class StudentRepository {

	public static void main(String[] args) throws SQLException {

		StudentDTO sdto = new StudentDTO();
		sdto.setStudentName("Gojo Saturu");
		sdto.setStudentCode("STUO10");
		sdto.setStudentAddress("Satna,MP");
		sdto.setStudentEmail("gojo321@gmail.com");
		sdto.setStudentPhone("+91 9876453276");
		sdto.setStudentCredit(45);

		StudentRepository strepo = new StudentRepository();
		sdto = strepo.addStudent(sdto);
		System.out.println("Student added successfully" + sdto);

		StudentDTO stdto = strepo.getStudentById(5019);
		System.out.println("Student Detail" + stdto);

	}

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public StudentDTO addStudent(StudentDTO sdto) throws SQLException {
		StudentDTO savestu = null;
		String insertQuery = "INSERT INTO student_detail(student_name, student_code, student_address, student_email, student_phone, student_credit)VALUES(?, ?, ?, ?, ?, ?)";
		try {
			conn = DbConnectUtil.getConnection();
			pstmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, sdto.getStudentName());
			pstmt.setString(2, sdto.getStudentCode());
			pstmt.setString(3, sdto.getStudentAddress());
			pstmt.setString(4, sdto.getStudentEmail());
			pstmt.setString(5, sdto.getStudentPhone());
			pstmt.setInt(6, sdto.getStudentCredit());

			int rowAffected = pstmt.executeUpdate();

			if (rowAffected > 0) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int sId = rs.getInt(1);
					savestu = getStudentById(sId);
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			pstmt.close();
			conn.close();
		}
		System.out.println("Record inserted successfully" + savestu);
		return savestu;
	}

	public StudentDTO getStudentById(int sId) throws SQLException {
		StudentDTO studentD = new StudentDTO();
		String selectQ = "SELECT student_id, student_name, student_code, student_address, student_email, student_phone, student_credit "
				+ "FROM student_detail WHERE student_id = ? AND is_deleted = 'N'";

		try {
			pstmt = DbConnectUtil.getConnection().prepareStatement(selectQ);
			pstmt.setInt(1, sId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("student_id"));
				System.out.println(rs.getString("student_name"));
				System.out.println(rs.getString("student_code"));
				System.out.println(rs.getString("student_address"));
				System.out.println(rs.getString("student_email"));
				System.out.println(rs.getString("student_phone"));
				System.out.println(rs.getInt("student_credit"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			pstmt.close();
			rs.close();
			DbConnectUtil.closeConnection(conn);
		}
		return studentD;
	}

}
