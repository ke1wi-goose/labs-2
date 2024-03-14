<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>
<% Cookie[] cookies = request.getCookies();
String from_a = "";
String to_a = "";
String step_a = "";
String from_b = "";
String to_b = "";
String step_b = "";
String from_c = "";
String to_c = "";
String step_c = "";
String from_d = "";
String to_d = "";
String step_d = "";
if (cookies != null) {
	for (Cookie cookie : cookies) {
		switch (cookie.getName()) {
			case "from_a":
				from_a = cookie.getValue();
				break;
			case "from_b":
				from_b = cookie.getValue();
				break;
			case "from_c":
				from_c = cookie.getValue();
				break;
			case "from_d":
				from_d = cookie.getValue();
				break;
			case "to_a":
				to_a = cookie.getValue();
				break;
			case "to_b":
				to_b = cookie.getValue();
				break;
			case "to_c":
				to_c = cookie.getValue();
				break;
			case "to_d":
				to_d = cookie.getValue();
				break;
			case "step_a":
				step_a = cookie.getValue();
				break;
			case "step_b":
				step_b = cookie.getValue();
				break;
			case "step_c":
				step_c = cookie.getValue();
				break;
			case "step_d":
				step_d = cookie.getValue();
				break;

			default:
				break;
		}
	}
} %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="widtd=device-widtd, initial-scale=1.0" />
		<link rel="stylesheet" href="css/style.css" />
		<title>Calculator</title>
	</head>
	<body>
		<img src="img/1.png" alt="y = ((5 * a) / (Math.sin(a))) + (Math.sqrt((Math.tanh(Math.abs(b) + c)) / Math.log(d)))" class="img-1">
		<form class="form-group" action="calculate" method="post">
			<section class="section-container">
				<section class="section-group">
					<p>'a' parameter</p>
					from:
					<input
						type="text"
						class="form-field"
						placeholder="Число 1"
						name="from_a"
						value="<%= from_a %>"
					/>
					<br />
					to: <label class="transparent-text">...</label>
					<input
						type="text"
						class="form-field"
						placeholder="Число 2"
						name="to_a"
						value="<%= to_a %>"
					/>
					<br />
					step:
					<input
						type="text"
						class="form-field"
						placeholder="Число 3"
						name="step_a"
						value="<%= step_a %>"
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
						value="<%= from_b %>"
					/>
					<br />
					to: <label class="transparent-text">...</label>
					<input
						type="text"
						class="form-field"
						placeholder="Число 2"
						name="to_b"
						value="<%= to_b %>"
					/>
					<br />
					step:
					<input
						type="text"
						class="form-field"
						placeholder="Число 3"
						name="step_b"
						value="<%= step_b %>"
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
						value="<%= from_c %>"
					/>
					<br />
					to: <label class="transparent-text">...</label>
					<input
						type="text"
						class="form-field"
						placeholder="Число 2"
						name="to_c"
						value="<%= to_c %>"
					/>
					<br />
					step:
					<input
						type="text"
						class="form-field"
						placeholder="Число 3"
						name="step_c"
						value="<%= step_c %>"
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
						value="<%= from_d %>"
					/>
					<br />
					to: <label class="transparent-text">...</label>
					<input
						type="text"
						class="form-field"
						placeholder="Число 2"
						name="to_d"
						value="<%= to_d %>"
					/>
					<br />
					step:
					<input
						type="text"
						class="form-field"
						placeholder="Число 3"
						name="step_d"
						value="<%= step_d %>"
					/>
				</section>
			</section>
			<button class="btn">Calculate</button>
		</form>
		<hr />
		<% 
			Object numberOfIterObj = request.getAttribute("Number_of_iter");
			int numberOfIter = 0;
			if (numberOfIterObj != null) {
				numberOfIter = (int) numberOfIterObj;
			}

			%>
			<table border="1" class="table">
				<tr>
					<th>y</th>
					<th>a</th>
					<th>b</th>
					<th>c</th>
					<th>d</th>
				</tr>
				<%
				for (int i = 1; i < numberOfIter; i++) {
					Object iterationObj = request.getAttribute("Iteration " + i);
					if (iterationObj != null && iterationObj instanceof ArrayList) {
						ArrayList<Double> vars = (ArrayList<Double>) iterationObj;
						DecimalFormat df = new DecimalFormat("0.000");
						String y;
						Double result, a, b, c, d;
						result = vars.get(0);
						if (result == Double.NaN){
							y = "Impossible to calculate";
						} else { y = df.format(vars.get(0)); }
						a = vars.get(1);
						b = vars.get(2);
						c = vars.get(3);
						d = vars.get(4);
				%>
				<tr>
					<td><%= y %></td>
					<td><%= a %></td>
					<td><%= b %></td>
					<td><%= c %></td>
					<td><%= d %></td>
				</tr>
				<%
					}
				}
				%>
			</table>
	</body>
</html>
