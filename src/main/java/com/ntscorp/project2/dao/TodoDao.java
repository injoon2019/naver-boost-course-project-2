package com.ntscorp.project2.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.ntscorp.project2.dto.TodoDto;

public class TodoDao {
	
	private static final TodoDao todoDao = new TodoDao();
	
	private static final String DB_URL = "jdbc:mysql://10.113.116.52:13306/user06";
	private static final String DB_USER = "user06";
	private static final String DB_PASSWORD = "user06";
	private static final String SQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
	
	private TodoDao() {
	}

	public static TodoDao getInstance() {
		initializeSettings();
		return todoDao;
	}
	
	private static void initializeSettings() {
		try {
			Class.forName(SQL_DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int addTodo(TodoDto todo) {
		int insertCount = 0;
		
		String sql = "INSERT INTO todo(id, title, name, sequence, type)"
				+ "VALUES(?, ?, ?, ?, ?)";
		
		try (Connection connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql)) {
			
			preparedStatement.setLong(1, todo.getId());
			preparedStatement.setString(2, todo.getTitle());
			preparedStatement.setString(3, todo.getName());
			preparedStatement.setInt(4, todo.getSequence());
			preparedStatement.setString(5, todo.getType());
			
			insertCount = preparedStatement.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	
	public List<TodoDto> getTodos() {
		List<TodoDto> todoList = new ArrayList<>();
		
		String sql = "SELECT id, title, name, sequence, type, regdate FROM todo ORDER BY regdate";
		
		try (Connection connection = (Connection)DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery()) {
				while(resultSet.next()) {
					long id = resultSet.getLong("id");
					String title = resultSet.getString("title");
					String name = resultSet.getString("name");
					int sequence = resultSet.getInt("sequence");
					String type = resultSet.getString("type");
					String regdate = resultSet.getString("regdate");
					TodoDto todoDto = new TodoDto(id, title, name, sequence, type, regdate);
					todoList.add(todoDto);
				}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return todoList;
	}
	
	public int updateTodo(TodoDto todoDto) {
		int updateCount = 0;
		
		String sql = "UPDATE todo set title = ?, name = ?, sequence = ?, type = ?, regdate = ? WHERE id = ?";
		
		try (Connection connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql)) {
			
			preparedStatement.setString(1, todoDto.getTitle());
			preparedStatement.setString(2, todoDto.getName());
			preparedStatement.setInt(3, todoDto.getSequence());
			preparedStatement.setString(4, todoDto.getType());
			preparedStatement.setString(5, todoDto.getRegDate());
			preparedStatement.setLong(6,  todoDto.getId());
			
			updateCount = preparedStatement.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return updateCount;
	}

	public TodoDto selectById(Long todoId) {
		String sql = "SELECT id, title, name, sequence, type, regdate FROM todo WHERE id = ?";
		TodoDto findTodoDto = null;
		
		try (Connection connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql)) {
			
			preparedStatement.setLong(1, todoId);
			
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					long id = resultSet.getLong("id");
					String title = resultSet.getString("title");
					String name = resultSet.getString("name");
					int sequence = resultSet.getInt("sequence");
					String type = resultSet.getString("type");
					String regdate = resultSet.getString("regdate");
					findTodoDto = new TodoDto(id, title, name, sequence, type, regdate);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return findTodoDto;
	}

	public static void updateTodoType(Long todoId, String todoType) {
		
		String sql = "UPDATE todo set type = ? WHERE id = ?";
		
		try (Connection connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql)) {
			preparedStatement.setString(1, todoType);
			preparedStatement.setLong(2, todoId);
			preparedStatement.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
