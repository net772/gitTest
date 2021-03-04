package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.DAO;
import com.model.DTO;

@WebServlet("/JoinProgram")
public class JoinProgram extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");


		DAO dao = new DAO();
		DTO dto = new DTO(id,pw,name);
		
		int cnt = dao.join(dto);
			
			if (cnt > 0) {
				System.out.print("회원가입 성공");
				response.sendRedirect("main.jsp");
			} else {
				System.out.print("회원가입 실패");
				response.sendRedirect("join.jsp");
			}
			

			
		
	}

}
