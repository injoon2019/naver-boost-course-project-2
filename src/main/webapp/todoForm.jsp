<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/todo/css/common.css">
<link rel="stylesheet" type="text/css" href="/todo/css/todoForm.css">
</head>
<body>
  <header>
    <p class="header-title">할일 등록</p>
  </header>
  <main>
    <div class="questions">
      <form action="/todo/add" method="post" name="todoForm" accept-charset="utf-8">
        <label for="title-box" >어떤 일인가요?</label>
        <input type="text" name="title" id = "title-box" class="input-box" placeholder="자바스크립트 공부하기(24자까지)" maxlength="24" required/>

        <label for="name-box">누가 할일인가요??</label>    
        <input type="text" name="name" id="name-box" class="input-box" placeholder="홍길동" maxlength="10" required/>
  
        <label  class="question-label">우선 순위를 선택하세요</label>
        <input type="radio" name="rank" value="1" class = "select-button" required/>1순위
        <input type="radio" name="rank" value="2" class = "select-button" required/>2순위
        <input type="radio" name="rank" value="3"  id="select-last-button" class = "select-button" required/>3순위

        <div class="bottom-buttons">
          <a id="prev-button" onClick="history.back()">&lt;이전</a>
          <input type="submit" class="blue-button"></ipnut>
          <button class="blue-button" type="reset">내용지우기</button>
        </div>
      </form>
    </div>
  </main>
</body>
</html>