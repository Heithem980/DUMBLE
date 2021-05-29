<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


   <form action="<%=request.getContextPath()%>/SearchServlet"
		method="post">
		Dumble Search: <input type="text" required name="searchString"><br>

		<input type="submit"  value = "search">
	</form>

<%
	// get the results
	ArrayList<ArrayList<String>> allTables = (ArrayList<ArrayList<String>>) request.getAttribute("allTables");
	// Remove this for a fun error
	
	boolean results = false;
	
	for(int i = 0; i < allTables.size(); i++){
		if(!(allTables.get(i).isEmpty())){
			results = true;
		}
	}
	
	
	if (results) {
		
		out.print("<ul>");
		for (int i = 0; i < allTables.size(); i++) {
			
			for (int x = 0; x < allTables.get(i).size(); x++){ 
				out.print("<li>");
				out.print(allTables.get(i).get(x));
				out.print("</li>");
				out.print("<br>");

			}
		}
		
		out.print("</ul>");
		
	}else {out.print("<h2>No results found</h2>");
	}
	
	
	%>


</body>
</html>