package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

import object.Departments;


@WebServlet("/ListDepartServlet")
public class ListDepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Context context=null;
		List<Departments> list=new ArrayList<Departments>();   
		
		try {
			context = new InitialContext();
		} catch (NamingException e1) {

			e1.printStackTrace();
		}
		try {
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Employees");
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM departments");
			while(rs.next()){
				list.add(new Departments(rs.getString(1), rs.getString(2)));
			}
			
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/lista_dipartimenti.jsp");		
			rd.forward(request, response);
			
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (NamingException | SQLException e) {
		
			e.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
