import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App2 {

	public static void main(String[] args) {

		final String dbUrl = "jdbc:mysql://localhost:3306/hrdb2";
		final String dbUid = "root";
		final String dbPwd = "root";

		final String qry = "SELECT empId,ename,sal FROM emps";

		try (Connection con = DriverManager.getConnection(dbUrl, dbUid, dbPwd);
				PreparedStatement pst = con.prepareStatement(qry);) {

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				System.out.println( rs.getInt("empId") + "\t" + rs.getString("ename") + "\t" + rs.getDouble("sal"));
			}
			
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
		}
	}

}
