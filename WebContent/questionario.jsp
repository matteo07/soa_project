<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Questionario clinica - questionario</title>
</head>
<body>
	<p>Questionario</p>

	<form action="risultati.php" method="post">
		<fieldset>
			<legend>Problematiche riscontrate</legend><br>
			<input type="checkbox" name="dom1" value="dom1" />Domanda 1<br />
			<input type="checkbox" name="dom2" value="dom2" />Domanda 2<br />
			<input type="checkbox" name="dom3" value="dom3" />Domanda 3<br /> 
			<input type="checkbox" name="dom4" value="dom4" />Domanda 4<br /> 
			<input type="checkbox" name="dom5" value="dom5" />Domanda 5<br /> 
			
			<input id="cf" name="cf" type="hidden" value="<%= request.getParameter("cf") %>"> 
			<input id="tel" name="tel" type="hidden" value="<%= request.getParameter("tel") %>">
			
			<input type="submit">
		</fieldset>
	</form>
</body>
</html>
