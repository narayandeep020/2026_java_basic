package repository.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.PublisherDTO;
import util.DbConnectUtil;

public class PublisherRepository {

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rset;

	public PublisherDTO addPublisher(PublisherDTO newPublisher) throws SQLException {
		PublisherDTO savedto = new PublisherDTO();
		String driverClass = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/library_management_db";
		String userName = "*****";
		String passWord = "******";
		String insertQuery = "INSERT INTO publisher_detail(publisher_name, publisher_code, publisher_address, publisher_email, publisher_phone)"
				+ "VALUES(?, ?, ?, ?, ?)";
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, userName, passWord);

			pstmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, newPublisher.getPublisherName());
			pstmt.setString(2, newPublisher.getPublisherCode());
			pstmt.setString(3, newPublisher.getPublisherAddress());
			pstmt.setString(4, newPublisher.getPublisherEmail());
			pstmt.setString(5, newPublisher.getPublisherPhone());

			int rowAffected = pstmt.executeUpdate();

			if (rowAffected > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int newPublisherId = rs.getInt(1);
					savedto = getPublisherById(newPublisherId);
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			pstmt.close();
			conn.close();
		}
		System.out.println("Record inserted successfully" + savedto);
		return savedto;
	}

	public PublisherDTO getPublisherById(int newPublisherId) throws SQLException {
		PublisherDTO pdto = null;
		String selectSql = "SELECT publisher_id, publisher_name, publisher_code, publisher_address, publisher_email, publisher_phone "
				+ "FROM publisher_detail WHERE publisher_id =?" + "AND is_deleted = 'N'";

		try {
			pstmt = DbConnectUtil.getConnection().prepareStatement(selectSql);
			pstmt.setInt(1, newPublisherId);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				System.out.println(rset.getInt("publisher_id"));
				System.out.println(rset.getString("publisher_name"));
				System.out.println(rset.getString("publisher_code"));
				System.out.println(rset.getString("publisher_address"));
				System.out.println(rset.getString("publisher_email"));
				System.out.println(rset.getString("publisher_phone"));
				System.out.println(rset.getString("is_deleted"));

//				pdto.setPublisherId(rset.getInt("publisher_id"));
//				pdto.setPublisherName(rset.getString("publisher_name"));
//				pdto.setPublisherCode(rset.getString("publisher_code"));
//				pdto.setPublisherAddress(rset.getString("publisher_address"));
//				pdto.setPublisherEmail(rset.getString("publisher_email"));
//				pdto.setPublisherPhone(rset.getString("publisher_phone"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			pstmt.close();
			rset.close();
			DbConnectUtil.closeConnection(conn);
		}
		return pdto;
	}

	public static void main(String args[]) throws SQLException {
		PublisherDTO newPublisher = new PublisherDTO();
		newPublisher.setPublisherName("Naman Esten");
		newPublisher.setPublisherCode("NEW009");
		newPublisher.setPublisherAddress("Pawai");
		newPublisher.setPublisherEmail("estenpawai@gmail.com");
		newPublisher.setPublisherPhone("9876543425");

		PublisherRepository publisherRepo = new PublisherRepository();
		newPublisher = publisherRepo.addPublisher(newPublisher);
		System.out.println("Publisher added successfully" + newPublisher);

		PublisherDTO publisherDTO = publisherRepo.getPublisherById(2015);
		System.out.println("Publisher details" + publisherDTO);
	}

}
