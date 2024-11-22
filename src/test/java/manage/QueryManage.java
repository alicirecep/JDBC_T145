package manage;

public class QueryManage {

	private String QUERY2 = "SELECT firstname, lastname, email FROM users WHERE country_code = 'TR';";
	private String QUERY03 = "SELECT firstname, lastname FROM users WHERE email = 'muratdonmezdemir.user@easybus.com';";




	// GETTER's


	public String getQUERY2() {
		return QUERY2;
	}

	public String getQUERY03() {
		return QUERY03;
	}


}
