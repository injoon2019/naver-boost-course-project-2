<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/todo/css/common.css">
<link rel="stylesheet" type="text/css" href="/todo/css/main.css">
</head>
<body>
  <header>
    <div class="header-title">나의 해야할 일들</div>
    <a class="header-button" href="/todo/todoForm.jsp">새로운 TODO 등록</a>
  </header>
  <main>
    <ul class="cell-column">
      <li class="cell-title">TODO</li>
      	<div class="todo">
		  	<c:forEach items="${todoMap['TODO']}" var="todoTodo">
		  	<div class="cell-todo">
		  		<p class="cell-todo-title">${todoTodo.title }</p>
		  		<p class="cell-todo-content">등록날짜: ${todoTodo.regDate}, ${todoTodo.name}, 우선순위: ${todoTodo.sequence}</p>
		  		<button class="cell-todo-button" id="${todoTodo.id}@${todoTodo.type}">
		  			<img id="next-button-id" class="todo-button-image" src="/todo/images/rightArrow.png" alt="오른쪽 화살표">
		  		</button>
		  	</div>
		  	</c:forEach>
      	</div>
    </ul>
    <ul class="cell-column">
      <li class="cell-title">DOING</li>
      	<div class="doing">
		  	<c:forEach items="${todoMap['DOING']}" var="todoDoing">
		  	<div class="cell-todo">
		  		<p class="cell-todo-title">${todoDoing.title}</p>
		  		<p class="cell-todo-content">등록날짜: ${todoDoing.regDate}, ${todoDoing.name}, 우선순위: ${todoDoing.sequence}</p>
		  		<button class="cell-todo-button" id="${todoDoing.id}@${todoDoing.type}">
		  			<img id="next-button-id" class="todo-button-image" src="/todo/images/rightArrow.png" alt="오른쪽 화살표">
		  		</button>
		  	</div>
	  		</c:forEach>      	
      	</div>
    </ul>
    <ul class="cell-column">
      <li class="cell-title">DONE</li>
      	<div class="done">
		  	<c:forEach items="${todoMap['DONE']}" var="todoDone">
		  	<div class="cell-todo">
		  		<p class="cell-todo-title"><c:out value="${todoDone.title}"/></p>
		  		<p class="cell-todo-content" id="${todoDone.id}@${todoDone.type}">등록날짜: ${todoDone.regDate}, ${todoDone.name}, 우선순위: ${todoDone.sequence}</p>
		  	</div>
		  	</c:forEach>
      	</div>
    </ul>
    <script type="text/javascript" src= "/todo/js/main.js"></script>	
  </main>
</html>