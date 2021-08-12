package com.ntscorp.project2.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ntscorp.project2.dto.TodoDto;

public class TodoUtils {
	
	private static final int TITLE_MAX_LENGTH = 24;
	private static final int NAME_MAX_LENGTH = 24;
	
	public static void classifyTodo(List<TodoDto> todoList, Map<String, ArrayList<TodoDto>> todoMap) {
		
		for (TodoDto todo : todoList) {
			String date = extractDate(todo.getRegDate()); 
			todo.setRegDate(date);
			
			if (!todoMap.containsKey(todo.getType())) {
				todoMap.put(todo.getType(), new ArrayList<TodoDto>());
			}
			todoMap.get(todo.getType()).add(todo);
		}
	}
	
	public static String extractDate(String dateTime) { // 2021-07-21 16:33:51.0 -> 2021-07-21
		String date = dateTime.split("\\s")[0];
		return date;
	}

	public static boolean validateInput(String title, String name) {
		return title.length() <= TITLE_MAX_LENGTH && name.length() <= NAME_MAX_LENGTH;
	}
}
