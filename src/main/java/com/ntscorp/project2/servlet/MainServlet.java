package com.ntscorp.project2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ntscorp.project2.dao.TodoDao;
import com.ntscorp.project2.dto.TodoDto;
import com.ntscorp.project2.util.TodoUtils;

public class MainServlet extends HttpServlet {
    
	private static TodoDao todoDao = TodoDao.getInstance();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<TodoDto> todoList = todoDao.getTodos();
		Map<String, ArrayList<TodoDto>> todoMap = new ConcurrentHashMap<>();
		TodoUtils.classifyTodo(todoList, todoMap);

		request.setAttribute("todoMap", todoMap);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main.jsp");
		requestDispatcher.forward(request, response);
	}
}
