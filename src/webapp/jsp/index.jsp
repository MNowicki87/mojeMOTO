<%@ page import="java.time.LocalDateTime" %>
<%@ page language="java" contentType="text/html" %>

<html>
<head>
    <title>Home page</title>
</head>

<body>
Nasz pierwszy jsp

<h1><% out.print("Hello World ! " + LocalDateTime.now());%></h1>

<h2><% for (int i = 0 ; i < 100 ;i++) {
  out.print(i + " ");
  if(i> 1 && i %10 == 0) {
    out.print("<br>");
  }
}%></h2>


</body>

</html>
