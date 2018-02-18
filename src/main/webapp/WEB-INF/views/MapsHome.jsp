<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title></title>
	<script type="text/javascript">
	function showTable(){
		var rows = document.getElementById('rows').value
		if(rows == null)
			return false;
		var table = '<form method="get" action="/getLocation"><table width="50%" margin="1">';

	     table += '<tr><th>Latitude</th><th>Longitude</th></tr>';
	    for(var i = 0;i < rows; i++) {
	        table += '<tr><td><input type="text" name="latitude"></td>';
	        table += '<td><input type="text" name="longitude"></td></tr>'
	      }
	    table += '</table><input type="submit" value="Submit"/></form>';
	    document.getElementById("form").innerHTML = table;
	    return false;
	}	
	</script>
</head>

<body>
<form onsubmit="return showTable();">
Enter number of rows: <input type="text" id="rows" />
<input type="submit" value="Submit" />
</form>
<p id = "form">
</p>
</body>
</html>