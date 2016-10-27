<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>


    <table>
   	 <c:forEach var="product" items="${product}">
    <tr>
	<td><c:out value="${product.productname}" /></td>
	<td><c:out value="${product.productdescription}" /><td>
	<td><c:out value="${product.price}" /> </td>
	<td> <img src="<c:out value="${product.image}" />"height="190" width="190" alt=""/>
	 <td>
	
	<form action="CartServlet" method="post">
	<input type ="hidden" name ="productid" id="productid" value="${product.productid}" />
	<input type="image" src="images/ca.png"  alt="Submit">
	</form>	
	</td>
	</tr>

	</c:forEach>

	</table> 



			
		<jsp:include page="Footer.jsp"></jsp:include>							
</body>
</html>