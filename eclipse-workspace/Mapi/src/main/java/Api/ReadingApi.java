package Api;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Random;
import java.util.Scanner;

import com.google.gson.Gson;

public class ReadingApi {

	public static void ReadFromApi() throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://universities.hipolabs.com/search?country=United+States"))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
		}

		System.out.println(response.body());

		Gson gson = new Gson();

		TopApi []topapi = gson.fromJson(response.body().toString(), TopApi[].class);
		for(TopApi s:topapi) {
			
			System.out.println(s.getAlpha_two_code());
			System.out.println(s.getName());
			System.out.println(s.getCountry());
			System.out.println(s.getState_province());
			System.out.println(s.getDomains());
			System.out.println(s.getWeb_pages());

		}
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	public static void CreateApiTable() {
		
		String url = "jdbc:mysql://localhost:3306/Mapi";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE ApiInfo "+
		"(web_pages TEXT not NULL, "
				+ " state_province  VARCHAR(225)not NULL, "
				
				+ " alpha_two_code  VARCHAR(225)not NULL, " +
				" name  VARCHAR(225)not NULL," +
				"country VARCHAR(225)not NULL , " +
				" domains TEXT not NULL)";
		java.sql.Connection conn = null;
		
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			java.sql.Statement st = conn.createStatement();
			int m = st.executeUpdate(sqlDB);
			if (m >= 1) {
				System.out.println("Created table in given database...");
				return;
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public static void InsertValue() {
		
		
		System.out.println("How many number of rows you want to add?");

		
		Scanner sa = new Scanner(System.in);

		System.out.println("How many number of rows you want to add?");
		int a = sa.nextInt();

		String url = "jdbc:mysql://localhost:3306/Mapi";

		String user = "root";
		String pass = "root";
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		
		String web_pages = "http://www.marywood.edu";
		String state_province = "null";
		String name = "Marywood University";
		String country = "United States";
		String domains =  "marywood.edu";

		for (int i = 0; i < a; i++) {

			String sql = "INSERT INTO  ApiInfo VALUES ("+ i + numberToAdd + ",'" + (web_pages + i) + "','"
					+ (state_province + i) + "','" + (name + "/" + i) + "','" + (country + "/" + i) + "','"
					+ (domains + i) + "'"+")";
			java.sql.Connection conn = null;
			try {
				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver);
				conn = DriverManager.getConnection(url, user, pass);
				java.sql.Statement st = conn.createStatement();
				int m = st.executeUpdate(sql);
				if (m >= 1) {
					System.out.println("inserted data successfuly...");

				} else {
					System.out.println(" faild inserted data...");
				}
				conn.close();
			} catch (Exception ex) {
				System.err.println(ex);
			}

		}

	}
}
