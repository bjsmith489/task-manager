<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<header class="edit-task__header">

</header>
<body>	
	<h2>
	 Edit Task
	</h2>
	<div class="edit-green-box">
		<p>
			Please ensure all fields are entered before submitting edit.
		</p>
		<form action="update-task" method='POST'>
			<input type="hidden" id="id" name="id" value="${task.id}">
			<input type=hidden id="name"name="name" value="${task.name}">
			<input type="hidden" id="email" name="email" value="${task.email}">
				<table class="display-task__table">
					<tr class="display-task__tr">
						<td class="display-task__td">
							<label for="startDate"><b>Startdate:</b></label> 
						</td>
						<td class="display-task__td">
							<input type="date" id="startdate" name="startdate" class="task-add__input">
						</td>
					</tr>
					<tr class="display-task__tr">
						<td class="display-task__td">
							<label for=enddate><b>Enddate:</b></label>
						</td>
						<td class="display-task__td">
							<input type="date" id="enddate" name="enddate" class="task-add__input">
						</td>
					</tr>
					<tr class="display-task__tr">
						<td class="display-task__td">
							<label for="description"><b>Description:</b></label>
						</td>
						<td class="display-task__td">
							<input type="text" id="description" name="description" class="task-add__input">
						</td>
					</tr>
	
					<tr class="display-task__tr">
						<td class="display-task__td">       
					 		<label for="severity"><b>Severity:</b></label>
					 	</td>
					 	<td class="display-task__td">
					 		<select name = "severity" class="task-add__input">
					 			<option value="no change">no change</option>
			            		<option value = "low">low</option>
			            		<option value = "active">active</option>
			            		<option value = "critical">critical</option>
			         		</select>
			         	</td>
			         </tr>
				</table>
				<button type="submit" class="task-add__btn">submit</button>
			</form>
		<a href="/"><button class="task-add__btn">return</button></a>
	</div>
</body>

<footer class="edit-task__footer">

</footer>
</html>