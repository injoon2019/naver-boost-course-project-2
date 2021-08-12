package com.ntscorp.project2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntscorp.project2.dao.TodoDao;
import com.ntscorp.project2.dto.TodoDto;
import com.ntscorp.project2.util.TodoUtils;


public class TodoAddServlet extends HttpServlet {

	private static final TodoDao todoDao = TodoDao.getInstance();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		Integer rank = Integer.parseInt(request.getParameter("rank"));
		
		if (TodoUtils.validateInput(title, name)) {
			TodoDto todoDto = new TodoDto(title, name, rank, Type.TODO.name());
			todoDao.addTodo(todoDto);
			response.sendRedirect("/todo/main");
		} else {
			response.sendRedirect("/todo/error/404code.jsp");
		}

	}
}
