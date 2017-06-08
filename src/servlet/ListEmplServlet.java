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

import object.Employees;
import object.Employees.Gender;

@WebServlet("/ListEmplServlet")
public class ListEmplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Context context=null;
		List<Employees> list=new ArrayList<Employees>(); 
		
		try {
			context = new InitialContext();
		} catch (NamingException e1) {

			e1.printStackTrace();
		}
		try {
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Employees");
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from employees inner join dept_emp "
					+ "on employees.emp_no=dept_emp.emp_no where dept_no='"+request.getParameter("dep")+"' "
					+ "and employees.birth_date>'1965-01-30'");
			while(rs.next()){
				list.add(new Employees((Integer)rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), 
						Gender.valueOf(rs.getString(5)) , rs.getDate(6) ));
			}
			
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/lista_dipendenti.jsp");		
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
