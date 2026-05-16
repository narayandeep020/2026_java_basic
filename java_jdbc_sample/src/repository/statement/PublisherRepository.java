package repository.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.PublisherDTO;
import util.DbConnectUtil;

public class PublisherRepository {

	public static void main(String[] args) throws Exception {

		PublisherDTO publishdto = new PublisherDTO();
		publishdto.setPublisherName("Hakuna Matata");
		publishdto.setPublisherCode("HMT012");
		publishdto.setPublisherAddress("25 TimboStreet,NewYork");
		publishdto.setPublisherEmail("matata4321@gmail.com");
		publishdto.setPublisherPhone("+1-134-654-5083");
		publishdto.setCreateAdmin(4004);

		PublisherRepository publicrepo = new PublisherRepository();
		PublisherDTO pdto = publicrepo.addPublisher(publishdto);
		System.out.println("Saved Publisher Detail" + pdto);
	}

	private static Connection con;

	private PublisherDTO addPublisher(PublisherDTO publishdto) throws Exception {
		PublisherDTO pdto = null;
		Statement stm = null;

		try {
			con = DbConnectUtil.getConnection();
			stm = con.createStatement();
			String insertSql = "insert into publisher_detail(publisher_name, publisher_code, publisher_address, publisher_email, publisher_phone, created_by_admin)"
					+ "values('" + publishdto.getPublisherName() + "','" + publishdto.getPublisherCode() + "','"
					+ publishdto.getPublisherAddress() + "','" + publishdto.getPublisherEmail() + "','"
					+ publishdto.getPublisherPhone() + "','" + publishdto.getCreateAdmin() + "')";

			int rowAffected = stm.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);

			if (rowAffected > 0) {
				ResultSet result = stm.getGeneratedKeys();
				if (result.next()) {
					publishdto.setPublisherId(result.getInt(1));
					pdto = getPublisherById(publishdto.getPublisherId());
				}
			}

		} catch (SQLException | RuntimeException e) {
			System.out.println(e);
		} finally {
			stm.close();
			DbConnectUtil.closeConnection(con);
		}

		return pdto;
	}

	private PublisherDTO getPublisherById(int publisherId) throws Exception {
		PublisherDTO pdto = new PublisherDTO();
		Statement st = null;
		try {
			con = DbConnectUtil.getConnection();
			st = con.createStatement();
			String fetchSql = "select * from publisher_detail";
			ResultSet rs = st.executeQuery(fetchSql);

			while (rs.next()) {
				pdto.setPublisherId(rs.getInt("publisher_id"));
				pdto.setPublisherName(rs.getString("publisher_name"));
				pdto.setPublisherCode(rs.getString("publisher_code"));
				pdto.setPublisherAddress(rs.getString("publisher_address"));
				pdto.setPublisherEmail(rs.getString("publisher_email"));
				pdto.setPublisherPhone(rs.getString("publisher_phone"));
				pdto.setCreateAdmin(rs.getInt("created_by_admin"));
				pdto.setUpdatedAdmin(rs.getInt("updated_by_admin"));
				pdto.setCreateDate(rs.getDate("created_date"));
				pdto.setUpdatedDate(rs.getDate("updated_date"));
				pdto.setIsDeleted(rs.getString("is_deleted"));
			}
		} catch (SQLException | RuntimeException e) {
			System.out.println(e);
		} finally {
			st.close();
			DbConnectUtil.closeConnection(con);
		}

		return pdto;
	}

}
