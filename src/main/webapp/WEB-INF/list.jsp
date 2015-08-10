<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>


	<ul>

		<c:forEach items="${todos}" var="todo">

			<c:if test="${todo.done}">
				<h2>
					<li><strike>${todo.name} ${todo.desc}</strike>
						<form action="list" method="post">
							<button name="idD" value="${todo.id}">Undone</button>
						</form></li>

				</h2>
			</c:if>

			<c:if test="${!todo.done}">
				<h2>
					<li>${todo.name}${todo.desc}$
						<form action="list" method="post">
							<button name="idD" value="${todo.id}">Done</button>
						</form>

						<form action="update">
							<input type="hidden" name="id" value="${todo.id}">
							<button>Edit</button>
						</form>

					</li>
				</h2>
			</c:if>

		</c:forEach>

	</ul>


</body>
</html>
