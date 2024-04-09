<%@page import="java.util.List"%>
<%@page import="com.boot.music.entity.Category"%>
<%@page import="com.boot.music.dto.SongDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="header1.jsp" %>
 
 
 
 
 <%List<SongDTO> l=(List<SongDTO>)request.getAttribute("list"); 
 List<Category> cate=(List<Category>)request.getAttribute("cate"); 
 int pages=(Integer)request.getAttribute("totalPages");
 int indexPage=(Integer)request.getAttribute("currentPage");
 session.setAttribute("currentPage", indexPage);

 %>

 
 <div>
 <table id="tb-admin">
    <thead>
       <div style=" font-size: 35px;font-weight: bold;text-align: center;margin-top: 10px"><h1>Danh sách bài hát</h1></div>
    </thead>
    <tbody>
        <tr>
            <td style="font-size: 22px;font-weight: bold;" class="tb-com">ID</td>
            <td style="font-size: 22px;font-weight: bold;" class="tb-com">Tên bài hát</td>
            <td style="font-size: 22px;font-weight: bold;" class="tb-com">Nghệ sĩ</td>
            <td style="font-size: 22px;font-weight: bold;" class="tb-com">Ảnh</td>
            <td style="font-size: 22px;font-weight: bold;" class="tb-com">Đường dẫn</td>
            <td style="font-size: 22px;font-weight: bold;" class="tb-com">Thể loại</td>
            <td style="font-size: 22px;font-weight: bold;" class="tb-com">Quốc gia</td>
            <td style="font-size: 22px;font-weight: bold;" class="tb-com">Sửa</td>
            <td style="font-size: 22px;font-weight: bold;" class="tb-com">Xóa</td>
        </tr>
        <%for(int i=0;i<l.size();i++){
        	%>
        	 <tr>
            <td id="idtb" class="tb-com"><%=l.get(i).getSongID() %></td>
            <td class="tb-com"><%=l.get(i).getTitle() %></td>
            <td class="tb-com"><%=l.get(i).getArtistName() %></td>
            <td class="tb-com"><%=l.get(i).getSongIMG() %></td>
            <td class="tb-com"><%=l.get(i).getMp3_link() %></td>
            <td class="tb-com"><%=l.get(i).getCateID().getCategoryName() %></td>
            <td class="tb-com"><%=l.get(i).getRegionID().getCountry() %></td>
            
            <td class="tb-com"> <form  method="post" action="/edit"><input type="text" name="id" value="<%=l.get(i).getSongID() %>" hidden="true"><input type="submit" value="Sửa"></form></td>
            <td class="tb-com"> <form  method="post" action="/delete"><input type="text" name="id" value="<%=l.get(i).getSongID() %>" hidden="true"><input type="submit" value="Xóa"></form></td>
        </tr>
        <%} %>
       
    </tbody>
</table>
 
    <div style="text-align: center">
            <%if(pages<=5){
            	for(int i=1;i<=pages;i++){
            	%>
            
               <button style="font-size: 25px; width:30px; padding: 1px" onclick="location.href='http://localhost:8080/admin?p=<%=i%>'"><%=i %></button>
              <%}}
            else if((indexPage-2>0)&&(indexPage<pages-2)){
            	for(int i=indexPage-2;i<=indexPage+2;i++){
            		%>
            		 <button style="font-size: 25px; width:30px; padding: 1px" onclick="location.href='http://localhost:8080/admin?p=<%=i%>'"><%=i %></button>
            	<%
            	}
            	
            }
            else if((indexPage<=2)&&(indexPage<pages-2)){
            	 for(int i=1;i<=5;i++){
             		%>
             		 <button style="font-size: 25px; width:30px; padding: 1px" onclick="location.href='http://localhost:8080/admin?p=<%=i%>'"><%=i %></button>
             	<%
             	}
             }
             else{
            	for(int i=pages-5;i<=pages;i++){
            		%>
            		 <button style="font-size: 25px; width:30px; padding: 1px" onclick="location.href='http://localhost:8080/admin?p=<%=i%>'"><%=i %></button>
            	<%}
            }
              %>
              <div>
              <h1 id="h1-move">Chuyển đến trang</h1><form id="form-id-right" action="allSongs?p=5" onsubmit="return setAction(this)"  >
              <input style="width: 30px" id="page-input" type="text" ></form>
              
              </div>
 
 

 </div>
   <script type="text/javascript">
              function setAction(form) {
            	  var s=document.getElementById("page-input").value;
            	  
            	  location.href = "http://localhost:8080/admin?p="+s;
            	  form.action = "allSongs?p=5";
            	 
            	  return false;
            	}
             </script>
 <script type="text/javascript">
              function setAction12(form) {
            	  var s=document.getElementById("idtb").value;
            	  
            	  location.href = "http://localhost:8080/edit?id="+s;
            	 
            	 
            	  return false;
            	}
             </script>
 
 
 <script>
 	function closeEdit() {
 		document.getElementById("edit").innerHTML="";
	}
 </script>
 
 <script>
 	function edit(id) {
 		var id=document.getElementById("edit").innerHTML=this.responseText;
 		  window.location ='/edit?id='+id;
	}
 </script>
 
 
  <%@ include file="footer.jsp" %>