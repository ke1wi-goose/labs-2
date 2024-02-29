<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<% Cookie[] cookies = request.getCookies(); %>
<% String num1 = ""; %>
<% String num2 = ""; %>

<% if (cookies != null) { %>
    <% for (Cookie cookie : cookies) { %>
        <% if (cookie.getName().equals("num1")) { %>
            <% num1 = cookie.getValue(); %>
        <% } else if (cookie.getName().equals("num2")) { %>
            <% num2 = cookie.getValue(); %>
        <% } %>
    <% } %>
<% } %>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Лабораторна робота №2</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
	<body>
		<style></style>
		<h1 align="center">Calculator</h1><br>
		<form action="calculate" class="form-group" method="post">
			<input
				type="text"
				class="form-field"
				placeholder="Число 1"
				name="number1"
				value="<%= num1 %>"
			/>
			<select name="select" id="dropdown">
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
			</select>
			<input
				type="text"
				class="form-field"
				placeholder="Число 2"
				name="number2"
				value="<%= num2 %>"
			/>
			<button class="btn">=</button>
		</form>
	</body>
</html>
