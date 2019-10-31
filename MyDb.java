package testpack;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/db")
public class MyDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MyDb() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String url = "jdbc:mysql://localhost:3306/sys";
		final String driver = "com.mysql.cj.jdbc.Driver";
		final String uname = "root";
		final String upass = "Asd_gad1";
		Connection conn;
		
		Statement st;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uname, upass);
			
			st = conn.createStatement();
			
			String sql = "select curdate() as date, curtime() as time";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				String cdate = rs.getString(1);
				
				String ctime = rs.getString(2);
				
				request.getSession().setAttribute("date", cdate);
				
				request.getSession().setAttribute("time", ctime);
			}
		}
		catch(Exception e) {
			e.printStackTrace(); 
			}
		response.sendRedirect("theresult");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
