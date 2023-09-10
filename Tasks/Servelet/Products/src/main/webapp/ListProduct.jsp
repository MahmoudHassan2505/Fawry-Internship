<%@ page import="java.util.List" %>
<%@ page import="org.example.ProductModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Product</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>Product Name</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<ProductModel> products = (List) request.getAttribute("productList");
            for(ProductModel product :products){
        %>
        <tr>
            <th><%=product.getId()%></th>
            <th><%=product.getName()%></th>
            <th>
                <a href="/product/remove?id=${product.getId()}&ProductName=${product.getName()}">Remove</a>
            </th>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <hr>
    <form name="AddProductForm" method="get" action="add">
        <input type="submit" value="Add New Product" />
    </form>

</body>
</html>