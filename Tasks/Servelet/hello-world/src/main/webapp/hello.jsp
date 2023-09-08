<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
<h1>Hello world!</h1>
<br />
time is <%= new java.util.Date() %>

<%
for (int i=0; i<10; i++) {
    out.println("-TEST-");
}
%>


</body>
</html>