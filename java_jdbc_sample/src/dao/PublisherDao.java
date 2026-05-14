package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.PublisherDTO;
import util.AppConstants;
import util.DateUtility;
import util.DbConnectUtil;

public class PublisherDao {

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
	public String toString() {
		return count+" ";
	}
	}

	public ProcedureResult callPublisherCrudProc(int publisherId, String publisherName, String publisherCode,
			String publisherAddress, String publisherEmail, String publisherPhone, int createAdmin, int updateAdmin,
			Date createDate, Date updateDate, String isDeleted, String operationType) {

		try {
			conn = DbConnectUtil.getConnection();
			String callQuery = "{call proc_publisher_detail(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cstmt = conn.prepareCall(callQuery);

			cstmt.setInt(1, publisherId);
			cstmt.setString(2, publisherName);
			cstmt.setString(3, publisherCode);
			cstmt.setString(4, publisherAddress);
			cstmt.setString(5, publisherEmail);
			cstmt.setString(6, publisherPhone);
			cstmt.setInt(7, createAdmin);
			cstmt.setInt(8, updateAdmin);
			cstmt.setDate(9, DateUtility.convertUtilToSqlDate(createDate));
			cstmt.setDate(10, DateUtility.convertUtilToSqlDate(updateDate));

			cstmt.setString(11, isDeleted);
			cstmt.setString(12, operationType);
			cstmt.registerOutParameter(13, Types.INTEGER);
			cstmt.execute();

			int count = cstmt.getInt(13);
			return new ProcedureResult(count);
		} catch (Exception e) {
			System.out.println("Error calling proc publisher detail: " + e.getMessage());
			e.printStackTrace();
			return new ProcedureResult(-1);
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				System.out.println("Error closing proc resources: " + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public PublisherDTO getPublisherById(int publisherId) {
		try {
			conn = DbConnectUtil.getConnection();
			String queryById = "{call proc_publisher_detail(?, null, null, null, null, null, 0, 0, null, null, null, ?, ?)}";
			cstmt = conn.prepareCall(queryById);

			cstmt.setInt(1, publisherId);
			cstmt.setString(2, AppConstants.READ);
			cstmt.setInt(3, Types.INTEGER);
			rs = cstmt.executeQuery();

			PublisherDTO publisher = null;
			while (rs.next()) {
				publisher = new PublisherDTO(rs.getInt("publisher_id"), rs.getString("publisher_name"),
						rs.getString("publisher_code"), rs.getString("publisher_address"),
						rs.getString("publisher_email"), rs.getString("publisher_phone"), rs.getInt("created_by_admin"),
						rs.getInt("updated_by_admin"), rs.getDate("created_date"), rs.getDate("updated_date"),
						AppConstants.NOT_DELETED);
			}
			return publisher;
		} catch (Exception e) {
			System.out.println("Error getting publisher by Id: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.out.println("Error closing stmt by ID: " + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public List<PublisherDTO> getAllPublisher() {
		try {
			conn = DbConnectUtil.getConnection();
			String queryForAll = "{call proc_publisher_detail(0, null, null, null, null, null, 0, 0, null, null, null, ?, ?)}";
			cstmt = conn.prepareCall(queryForAll);

			cstmt.setString(1, AppConstants.READ_ALL);
			cstmt.setInt(2, Types.INTEGER);
			rs = cstmt.executeQuery();

			List<PublisherDTO> publishers = new ArrayList<>();
			while (rs.next()) {
				PublisherDTO publisher = new PublisherDTO(rs.getInt("publisher_id"), rs.getString("publisher_name"),
						rs.getString("publisher_code"), rs.getString("publisher_address"),
						rs.getString("publisher_email"), rs.getString("publisher_phone"), rs.getInt("created_by_admin"),
						rs.getInt("updated_by_admin"), rs.getDate("created_date"), rs.getDate("updated_date"),
						AppConstants.NOT_DELETED);
				publishers.add(publisher);
			}
			return publishers;
		} catch (Exception e) {
			System.out.println("Error getting all publisher: " + e.getMessage());
			return new ArrayList<>();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.out.println("Error closing all Statement: " + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public ProcedureResult createPublisher(PublisherDTO publisher) {
		return callPublisherCrudProc(publisher.getPublisherId(), publisher.getPublisherName(),
				publisher.getPublisherCode(), publisher.getPublisherAddress(), publisher.getPublisherEmail(),
				publisher.getPublisherPhone(), publisher.getCreateAdmin(), publisher.getUpdatedAdmin(),
				publisher.getCreateDate(), publisher.getUpdatedDate(), AppConstants.NOT_DELETED, AppConstants.INSERT);
	}

	public ProcedureResult updatePublisher(PublisherDTO publisher) {
		return callPublisherCrudProc(publisher.getPublisherId(), publisher.getPublisherName(),
				publisher.getPublisherCode(), publisher.getPublisherAddress(), publisher.getPublisherEmail(),
				publisher.getPublisherPhone(), publisher.getCreateAdmin(), publisher.getUpdatedAdmin(),
				publisher.getCreateDate(), publisher.getUpdatedDate(), AppConstants.NOT_DELETED, AppConstants.UPDATE);
	}

	public ProcedureResult deletePublisher(int publisherId) {
		return callPublisherCrudProc(publisherId, null, null, null, null, null, 0, 0, null, null,
				AppConstants.SOFT_DELETED, AppConstants.DELETE);
	}

	public List<PublisherDTO> searchPublisher(String publisherName, String publisherCode) {
		try {
			conn = DbConnectUtil.getConnection();
			String searchQuery = "{call proc_publisher_detail(0, ?, ?, null, null, null, 0, 0, null, null, null, ?, ?)}";
			cstmt = conn.prepareCall(searchQuery);

			cstmt.setString(1, publisherName);
			cstmt.setString(2, publisherCode);
			cstmt.setString(3, AppConstants.SEARCH);
			cstmt.setInt(4, Types.INTEGER);

			rs = cstmt.executeQuery();
			List<PublisherDTO> publishers = new ArrayList<>();
			while (rs.next()) {
				PublisherDTO publisher = new PublisherDTO(rs.getInt("publisher_id"), rs.getString("publisher_name"),
						rs.getString("publisher_code"), rs.getString("publisher_address"),
						rs.getString("publisher_email"), rs.getString("publisher_phone"), rs.getInt("created_by_admin"),
						rs.getInt("updated_by_admin"), rs.getDate("created_date"), rs.getDate("updated_date"),
						AppConstants.NOT_DELETED);
				publishers.add(publisher);
			}
			return publishers;

		} catch (Exception e) {
			System.out.println("Error for search publisher: " + e.getMessage());
			return new ArrayList<>();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.out.println("Error serach close statement: " + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public static void main(String[] args) {

		PublisherDao pdao = new PublisherDao();
		PublisherDTO pdto = new PublisherDTO();
		pdto.setPublisherName("Suryakant");
		pdto.setPublisherCode("STN009");
		pdto.setPublisherAddress("Utter Pradesh");
		pdto.setPublisherEmail("suryakant@gmail.com");
		pdto.setPublisherPhone("+1-999-2345-24");
		pdto.setCreateAdmin(4004);
//
//		ProcedureResult createNew = pdao.createPublisher(pdto);
//		System.out.println("Create New Publisher: " + createNew);

		List<PublisherDTO> allPublisher = pdao.getAllPublisher();
		System.out.println("Get all publisher: " + allPublisher.size());
		allPublisher.forEach(System.out::println);

		List<PublisherDTO> searchPublisher = pdao.searchPublisher("CombStay Press", "CSP012");
		System.out.println(" Search Publisher: " + searchPublisher);
		searchPublisher.forEach(System.out::println);

//		PublisherDTO pub = pdao.getPublisherById(2020);
//		if (pub != null) {
//			System.out.println("Found Publisher: " + pub);
//
//			pub.setPublisherName("SuryaVeer");
//			pub.setPublisherCode("SSV005");
//			pub.setPublisherAddress("Jabalpur, MP");
//			pub.setPublisherEmail("suryaaa123@gmail.com");
//			pub.setPublisherPhone("+91 9876504321");
//			pub.setCreateAdmin(4007);
//			ProcedureResult update = pdao.updatePublisher(pub);
//			System.out.println("Updated Result: " + update);
//		}
//		ProcedureResult delete = pdao.deletePublisher(2019);
//		System.out.println("After Deleted Result: " + delete);

	}

}
