package stepDefinitions;

import io.cucumber.java.en.Given;
import manage.QueryManage;
import org.testng.Assert;
import utilities.JDBCReusableMethods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class Update_Query extends JDBCReusableMethods {

	String QUERY;
	int intResult;
	int InsertID = 400;
	String insertFirstname= "Team145";


	ResultSet  resultSet;
	PreparedStatement preparedStatement;

	QueryManage queryManage = new QueryManage();


	@Given("Database baglantisi olusturulur.")
	public void database_baglantisi_olusturulur() {

		JDBCReusableMethods.getConnection();

	}
	@Given("InsertQuery hazirlanir ve calistirilir.")
	public void ınsert_query_hazirlanir_ve_calistirilir() throws SQLException {

		QUERY = queryManage.getInsertQuery();
		preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(QUERY);
		// INSERT INTO users (id, firstname, lastname,username,email, password)VALUES (?,?,?,?,?,?);

		preparedStatement.setInt(1,InsertID);
		preparedStatement.setString(2,insertFirstname);
		preparedStatement.setString(3,"WiseQuarter");
		preparedStatement.setString(4,"JDBC");
		preparedStatement.setString(5,"t145@gmail.com");
		preparedStatement.setString(6,"team12345");


		intResult = preparedStatement.executeUpdate();

		System.out.println(intResult);

	}
	@Given("Verinin kaydedildigi dogrulanir.")
	public void verinin_kaydedildigi_dogrulanir() throws SQLException {

		assertEquals(1,intResult);
		//************************************************

		preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(queryManage.getInsertDogrulama());
		// SELECT firstname FROM users WHERE id = ?;
		preparedStatement.setInt(1,InsertID);

		resultSet = preparedStatement.executeQuery();

		String expectedData = insertFirstname;

		resultSet.next();
		assertEquals(expectedData, resultSet.getString(1));
	}
	@Given("Database baglantisi sonlandirilir.")
	public void database_baglantisi_sonlandirilir() {
		JDBCReusableMethods.closeConnection();
	}





}
