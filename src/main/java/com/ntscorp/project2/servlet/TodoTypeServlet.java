package com.ntscorp.project2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntscorp.project2.dao.TodoDao;
import com.ntscorp.project2.dto.ResponseDto;

public class TodoTypeServlet extends HttpServlet {

	private static final TodoDao TODO_DAO = TodoDao.getInstance();
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long todoId = Long.valueOf(request.getParameter("todoId"));
		String todoType = request.getParameter("todoType");
		
		String newType = updateDtoType(todoId, todoType);
		ResponseDto responseDto = new ResponseDto(todoId, newType);
		String todoJson = OBJECT_MAPPER.writeValueAsString(responseDto);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("applictaion/json");
		PrintWriter htmlWriter = response.getWriter();
		htmlWriter.println(todoJson);
		htmlWriter.close();
	}

	private String updateDtoType(Long todoId, String todoType) {
		Type[] types = Type.values();
		
		for(int ti = 0; ti < types.length - 1; ti++) {
			if (types[ti].name().equals(todoType)) {
				TodoDao.updateTodoType(todoId, types[ti+1].name());
				return types[ti+1].name();
			}
		}
		return "Not found";
	}
}
