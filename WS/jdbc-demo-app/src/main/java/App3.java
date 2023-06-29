import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class App3 {

	public static void main(String[] args) {

		final String dbUrl = "jdbc:mysql://localhost:3306/hrdb2";
		final String dbUid = "root";
		final String dbPwd = "root";

		final String qry = "INSERT INTO emps(empid,ename,sal) VALUES(?,?,?)";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("EmpId: ");
		int empId = scan.nextInt();
		System.out.println("Name: ");
		String name = scan.next();
		System.out.println("Salary: ");
		double salary = scan.nextDouble();

		try (
				Connection con = DriverManager.getConnection(dbUrl, dbUid, dbPwd);
				PreparedStatement pst = con.prepareStatement(qry);) {
			
			pst.setInt(1, empId);
			pst.setString(2, name);
			pst.setDouble(3, salary);
			
			int rowsEffected = pst.executeUpdate();
			
			System.out.println(rowsEffected + " rows inserted");
			
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
		}
		
		scan.close();
	}

}
