<html>
<body>


	<p>${message}</p>

	<form action="update" method="post">
		<input type="hidden" name="id" value="${todo.id}"> <br> <input
			type="${idRenName}" name="name" value="${todo.name}"> <br>
		<textarea rows="3" cols="" name="desc" style="display: ${idRenText}">${todo.desc}</textarea>
		<br> <input type="${idRenDate}" name="dueDate"
			value="${todo.formatedDate()}"> <br>
		<button style="display: ${idRenBtn}">Update Todo</button>
	</form>

</body>
</html>