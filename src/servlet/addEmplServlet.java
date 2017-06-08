package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/addEmplServlet")
public class addEmplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Context context=null;
		
		try {
			context = new InitialContext();
		} catch (NamingException e1) {

			e1.printStackTrace();
		}
		
		try {
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Employees");
			Connection conn = dataSource.getConnection();
			String sql = "insert into employees(emp_no, birth_date, first_name, last_name, gender) values (?, ?, ?, ?, ?)";
			PreparedStatement prepStat = conn.prepareStatement(sql);
			prepStat.setString(1, request.getParameter("matr"));
			prepStat.setString(2, request.getParameter("date"));
			prepStat.setString(3, request.getParameter("name"));
			prepStat.setString(4, request.getParameter("cogn"));
			prepStat.setString(5, request.getParameter("gender"));
			prepStat.executeUpdate();
			
			String sql1 = "insert into dept_emp(emp_no, dept_no, from_date) values(?, ?, ?)";
			PreparedStatement prepStat1 = conn.prepareStatement(sql1);
			prepStat1.setString(1, request.getParameter("matr"));
			prepStat1.setString(2, request.getParameter("dep"));
			prepStat1.setString(3, request.getParameter("date_start"));
			prepStat1.executeUpdate();
			
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");		
			rd.forward(request, response);
		
			prepStat1.close();
			prepStat.close();
			conn.close();
			
		} catch (NamingException | SQLException e) {
		
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
