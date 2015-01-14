import java.sql.*;

public class DBConnect {
	private Connection connect;
	private Statement st;
	private ResultSet rs;
	
	public DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testBook", "root", "");
			st = connect.createStatement();
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public String getData() {
		try {
			String query = "select * from Book";
			rs = st.executeQuery(query);
			System.out.println("Records from Database");
			while (rs.next()) {
				String ISBN = rs.getString("ISBN");
				String Title = rs.getString("Book_Title");
				String Author = rs.getString("Author");
				return ISBN + " " + Title + " " + Author + "\n";
			}
			return "Empty";
		}catch(Exception ex) {
			return ex.toString();
		}
	}
	
	public void setData(String i, String ti, String au) {
		try {
			String query = "INSERT INTO Book (ISBN, Book_Title, Author)"
					+ " VALUES (?, ?, ?)";
			
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			preparedStmt.setString(1, i);
			preparedStmt.setString(2, ti);
			preparedStmt.setString(3, au);
			preparedStmt.execute();
			
			connect.close();

		}catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
