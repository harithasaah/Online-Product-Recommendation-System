<%
 
if(request.getParameter("ITEM")!= null)
{
 
String item = request.getParameter("ITEM").trim();
cluster.Db_connection db = new cluster.Db_connection();
db.removeItem(item);
}

RequestDispatcher RD = request.getRequestDispatcher("/wishlist.jsp");
RD.forward(request, response);


%>
