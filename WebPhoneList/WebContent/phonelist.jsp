<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form method="post" action="editPhoneListServlet">
		
			<table>
				<c:forEach items="${requestScope.allItems}" var="currentItem">
					<tr>
						<td><input type="radio" name="id" value="${currentItem.id}"></td>
						<td>${currentItem.brand}</td>
						<td>${currentItem.item}</td>
						<td>${currentItem.price}</td>
					</tr>
				</c:forEach>
			</table>
		
			<input type="submit" value="Edit Selected Item" name="doThisToItem">
			<input type="submit" value="Delete Selected Item" name="doThisToItem">
			<input type="submit" value="Add New Item" name="doThisToItem">
			
		</form>
	</body>
</html>