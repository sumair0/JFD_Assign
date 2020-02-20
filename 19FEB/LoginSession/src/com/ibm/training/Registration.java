//package com.ibm.training;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class Registration
// */
//@WebServlet("/Registration")
//public class Registration extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Registration() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.setContentType("text/html");
//		
//		try {
//			String name = request.getParameter("name");
//			String password = request.getParameter("password") ;
//			Class.forName("com.mysql.jdbc.Driver"); 
//
//			Connection dbCon = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/logins?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
//					"root", "");
//			
//			String query = "INSERT INTO user_details(SerialNumber,UserName,Password) VALUES(NULL, ? , ?);" ;
//			
//			PreparedStatement prepStat = dbCon.prepareStatement(query);
//			
//			prepStat.setString(1, name);
//			prepStat.setString(2, password);
//			
//			prepStat.executeUpdate() ;
//			
//			PrintWriter out = response.getWriter();
//			
//			out.println("Success") ;
//					
//			
//		} catch (SQLException | ClassNotFoundException e) {
//			System.out.println("Something went wrong here: " + e.getMessage());
//		}
//		
//		
//		
//		
//		
//		
//		doGet(request, response);
//	}
//
//}
