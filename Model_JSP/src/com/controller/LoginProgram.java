package com.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.DAO;
import com.model.DTO;

@WebServlet("/LoginProgram")
public class LoginProgram extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		
		DAO dao = new DAO();
		DTO dto = new DTO(id,pw);
		
		String name = dao.login(dto);
		
			if(name != null){
				response.sendRedirect("loginSuccess.jsp?name1="+URLEncoder.encode(name,"EUC-KR"));
				
			}else{
				response.sendRedirect("loginFail.jsp");
			}
			
		
	}

}
