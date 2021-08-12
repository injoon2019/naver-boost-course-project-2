 var buttons = document.querySelectorAll("button");
  		
 for (var bi = 0; bi < buttons.length; bi++) {
 	buttons[bi].addEventListener("click", move);
 }
  		
 function move() {
  	var todoId = this.id.split("@")[0];
  	var todoType = this.id.split("@")[1];
	var copyCell = this.parentNode.cloneNode(true);
 	this.parentNode.remove(this);
 	appendAndPost(copyCell, todoId, todoType)
 }
  		
 function appendAndPost(copyCell, todoId, todoType) {

  var httpRequest = new XMLHttpRequest();
  httpRequest.onload = function() {
  	todoJson = JSON.parse(this.responseText);
  	var id = todoJson['id'];
	var type = todoJson['type'];
 	if (type === 'DOING') {
  		var parent = document.querySelector('.doing');
  	} else if (type === 'DONE'){
  		var parent = document.querySelector('.done');
  	}
	var buttonElement = copyCell.getElementsByTagName('button')[0];
	buttonElement.id = id+"@"+type;
	buttonElement.addEventListener("click", move);
	parent.appendChild(copyCell);
  };

  httpRequest.onerror = function() {
	alert('서버와의 연결이 되지 않습니다');
  };

  httpRequest.open('POST', '/todo/type', true);
  httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
  httpRequest.send('todoId=' + todoId +'&todoType=' +todoType);
 } 