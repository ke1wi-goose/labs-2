<%@ page contentType="text/html; charset=UTF-8" language="java" %> <% Cookie[]
cookies = request.getCookies(); String num1 = ""; String num2 = ""; String num3
= ""; if (cookies != null) { for (Cookie cookie : cookies) { if
(cookie.getName().equals("num1")) { num1 = cookie.getValue(); } else if
(cookie.getName().equals("num2")) { num2 = cookie.getValue(); } else if
(cookie.getName().equals("num3")) { num3 = cookie.getValue(); } } } %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/style.css" />
		<title>Calculator</title>
	</head>
	<body>
		<h1>y=ax!</h1>
		<hr />
		<form class="form-group">
			<section class="section-container">
				<section class="section-group">
					<p>'a' parameter</p>
					from:
					<input
						type="text"
						class="form-field"
						placeholder="Число 1"
						name="from_a"
						value="<%= num1 %>"
					/>
					<br />
					to: <label class="transparent-text">...</label>
					<input
						type="text"
						class="form-field"
						placeholder="Число 2"
						name="to_a"
						value="<%= num2 %>"
					/>
					<br />
					step:
					<input
						type="text"
						class="form-field"
						placeholder="Число 3"
						name="step_a"
						value="<%= num3 %>"
					/>
				</section>
				<div id="divider"></div>
				<section class="section-group">
					<p>'b' parameter</p>
					from:
					<input
						type="text"
						class="form-field"
						placeholder="Число 1"
						name="from_b"
						value="<%= num1 %>"
					/>
					<br />
					to: <label class="transparent-text">...</label>
					<input
						type="text"
						class="form-field"
						placeholder="Число 2"
						name="to_b"
						value="<%= num2 %>"
					/>
					<br />
					step:
					<input
						type="text"
						class="form-field"
						placeholder="Число 3"
						name="step_b"
						value="<%= num3 %>"
					/>
				</section>
				<div id="divider"></div>
				<section class="section-group">
					<p>'c' parameter</p>
					from:
					<input
						type="text"
						class="form-field"
						placeholder="Число 1"
						name="from_c"
						value="<%= num1 %>"
					/>
					<br />
					to: <label class="transparent-text">...</label>
					<input
						type="text"
						class="form-field"
						placeholder="Число 2"
						name="to_c"
						value="<%= num2 %>"
					/>
					<br />
					step:
					<input
						type="text"
						class="form-field"
						placeholder="Число 3"
						name="step_c"
						value="<%= num3 %>"
					/>
				</section>
				<div id="divider"></div>
				<section class="section-group">
					<p>'d' parameter</p>
					from:
					<input
						type="text"
						class="form-field"
						placeholder="Число 1"
						name="from_d"
						value="<%= num1 %>"
					/>
					<br />
					to: <label class="transparent-text">...</label>
					<input
						type="text"
						class="form-field"
						placeholder="Число 2"
						name="to_d"
						value="<%= num2 %>"
					/>
					<br />
					step:
					<input
						type="text"
						class="form-field"
						placeholder="Число 3"
						name="step_d"
						value="<%= num3 %>"
					/>
				</section>
			</section>

			<button class="btn">Calculate</button>
		</form>
		<hr />
		<table border="1">
			<tr>
				<td>a</td>
				<td>x</td>
				<td>y</td>
			</tr>
		</table>
	</body>
</html>
