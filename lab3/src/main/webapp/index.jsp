<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
	Cookie[] cookies = request.getCookies();
	String num1 = "";
	String num2 = "";
	String num3 = "";

	if (cookies != null) { 
		for (Cookie cookie : cookies) { 
			if (cookie.getName().equals("num1")) { 
				num1 = cookie.getValue(); 
			} else if (cookie.getName().equals("num2")) { 
				num2 = cookie.getValue(); 
			} else if (cookie.getName().equals("num3")) { 
				num3 = cookie.getValue(); 
			} 
		} 
	}

	

%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="..css/style.css">
		<title>Calculator</title>
	</head>
	<body>
		<h1>y=ax!</h1>
		<hr />
		<form>
			<p> from:
			<input
				type="text"
				class="form-field"
				placeholder="Число 1"
				name="number1"
				value="<%= num1 %>"
			/>
			to:
			<input
				type="text"
				class="form-field"
				placeholder="Число 2"
				name="number2"
				value="<%= num2 %>"
			/>
			step:
			<input
				type="text"
				class="form-field"
				placeholder="Число 3"
				name="number3"
				value="<%= num3 %>"
			/>
		</p> <br>
			<p> from:
			<input
				type="text"
				class="form-field"
				placeholder="Число 1"
				name="number1"
				value="<%= num1 %>"
			/>
			to:
			<input
				type="text"
				class="form-field"
				placeholder="Число 2"
				name="number2"
				value="<%= num2 %>"
			/>
			step:
			<input
				type="text"
				class="form-field"
				placeholder="Число 3"
				name="number3"
				value="<%= num3 %>"
			/>
		</p> <br>
			<p> from:
			<input
				type="text"
				class="form-field"
				placeholder="Число 1"
				name="number1"
				value="<%= num1 %>"
			/>
			to:
			<input
				type="text"
				class="form-field"
				placeholder="Число 2"
				name="number2"
				value="<%= num2 %>"
			/>
			step:
			<input
				type="text"
				class="form-field"
				placeholder="Число 3"
				name="number3"
				value="<%= num3 %>"
			/>
		</p> <br>
			<p> from:
			<input
				type="text"
				class="form-field"
				placeholder="Число 1"
				name="number1"
				value="<%= num1 %>"
			/>
			to:
			<input
				type="text"
				class="form-field"
				placeholder="Число 2"
				name="number2"
				value="<%= num2 %>"
			/>
			step:
			<input
				type="text"
				class="form-field"
				placeholder="Число 3"
				name="number3"
				value="<%= num3 %>"
			/>
		</p> <br>
		</form>
		<hr />
		<% if 
		<table border="1">
			<tr>
				<td>a</td>
				<td>x</td>
				<td>y</td>
			</tr>

		</table>
		%>
	</body>
</html>
