<%@ page session="false" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%
Object o = request.getAttribute("content");
if(o==null||o.equals("")){
	out.println("OK");
}else{
	out.println(o);
}
%>