import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App1 {

	public static void main(String[] args) {
		
		final String dbUrl = "jdbc:mysql://localhost:3306/hrdb2";
		final String dbUid = "root";
		final String dbPwd = "root";
		
		try(Connection con = DriverManager.getConnection(dbUrl, dbUid, dbPwd)){
			System.out.println("Database got connected!");
		}catch(SQLException exp) {
			System.out.println(exp.getMessage());
		}
	}

}
