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
   	 <c:forEach var="order" items="${order}">
    <tr>
	<td><c:out value="${order.samazonproduct.productname}" /></td>
	<td><c:out value="${order.samazonproduct.price}" /> <td>
	<td> <img src="<c:out value="${order.samazonproduct.image}" />"height="50" width="50" alt=""/>
	 <td>
	
	<form action="DeleteServlet" method="post">
	<input type ="hidden" name ="productid" id="productid" value="${order.samazonproduct.productid}" />
	<input type="image" src="images/close.png"  class="hvr-skew-backward" height="50" width="50" alt="Submit">
	</form>
	
	</td>
	</tr>
	</c:forEach>
	</table>
	
	<h3>Total cart amount : <c:out value="${totalprice}"/>   </h3>
	
	
	<form action="confirm.jsp" method="post">
	<div class="produced">
		<input type="submit" value="Proceed to Checkout" class="hvr-skew-backward" alt="submit">
	 </div>
	 </form>

		<jsp:include page="Footer.jsp"></jsp:include>							
</body>
</html>