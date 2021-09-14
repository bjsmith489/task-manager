<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/styles.css">

</head>
<header class="task-header">
	<h1 class="task-header__h1">Welcome ${user}, to your task manager!!!</h1>
</header>
<body>
	<h2>View your tasks here</h2>
	<div class="task-display">
			<table class="task-display__table">
				<tr class="task-display__tr">
					<th>Start Date</th>
					<th>End Date</th>
					<th>Description</th>
					<th>Email</th>
					<th>Severity</th>
				</tr>
				<c:forEach var="task" items="${tasks}">
				<tr class="task-display__tr">
					<td>${task.startDate}</td>
					<td>${task.endDate}</td>
					<td>${task.description}</td>
					<td>${task.email}</td>
					<td>${task.severity}</td>
					<td>
						<form method='POST' action="direct-to-edit-task">
							<input type="hidden" name="id" value="${task.id}">
							<button type="submit" class="task-display__button">edit</button>
						</form>
					</td>
					<td>
							<form method='POST' action="delete-task">
								<input type="hidden" name="id" value="${task.id}">
								<button
									class="task-display__button"
									onclick="return confirm('Completing will delete the task, is that ok?')"
									type="submit">complete</button>
							</form>
					</td>
				</tr>
				</c:forEach>
			</table>
	</div>
	<div class="task-add">
		<h2 class="task-add__h2">Please add a new task:</h2>
		<form action="setTask" method='POST'>
			<table class="display-task__table">
				<tr class="display-task__tr">
					<td class="display-task__td">
						<label for="startDate"><b>Startdate:</b></label> 
					</td>
					<td class="display-task__td">
						<input type="date" id="startdate" name="startdate" required class="task-add__input"> <input
						type="hidden" id="name" name="name" value="${user}">
					</td>
				</tr>
				<tr class="display-task__tr">
					<td class="display-task__td">
						<label for=enddate><b>Enddate:</b></label>
					</td>
					<td class="display-task__td">
						<input type="date" id="enddate" name="enddate" required class="task-add__input">
					</td>
				</tr>
				<tr class="display-task__tr">
					<td class="display-task__td">
						<label for="description"><b>Description:</b></label>
					</td>
					<td class="display-task__td">
						<input type="text" id="description" name="description" required class="task-add__input">
					</td>
				</tr>
				<tr class="display-task__tr">
				<td class="display-task__td">
						<label for="eamil"><b>Email:</b></label>
					</td>
					<td class="display-task__td">
						<input type="text" id="email" name="email" required class="task-add__input">
					</td>
				</tr>
				<tr class="display-task__tr">
					<td class="display-task__td">       
				 		<label for="severity"><b>Severity:</b></label>
				 	</td>
				 	<td class="display-task__td">
				 		<select name = "severity" class="task-add__input">
		            		<option value = "low" selected>low</option>
		            		<option value = "active">active</option>
		            		<option value = "critical">critical</option>
		         		</select>
		         		<input type="checkbox" name="isChecked" checked="checked" value="true"/>
    					<label for="send-email">Send a confirmation email?</label>
		         	</td>
		         </tr>
			</table>
			<button type="submit" class="task-add__btn">submit</button>
		</form>
		<a href="/logout"><button class="task-display__logout-btn">logout</button></a>
	</div>

</body>
<footer class="footer">

</footer>
</html>