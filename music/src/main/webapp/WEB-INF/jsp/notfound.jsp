<%@page import="com.boot.music.util.WFormater"%>
<%@page import="com.boot.music.entity.Category"%>
<%@page import="com.boot.music.dto.SongDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<%@page import="java.util.List"%>
<%
	
List<SongDTO> l=(List<SongDTO>)request.getAttribute("list"); 
List<Category> cate=(List<Category>)request.getAttribute("cate"); 
int pages=(Integer)request.getAttribute("totalPages");
int indexPage=(Integer)request.getAttribute("currentPage");
session.setAttribute("currentPage", indexPage);
String sValue=(String)request.getAttribute("searchValue");
int index=0;
WFormater w= new WFormater();
%>
<%@ include file="header2.jsp" %>
      <!-- header section end -->
      <!-- movies section start -->
     <div class="movies_section layout_padding">
     <h1 style="color: yellow; font-size: 40px; text-align: center;">Không có kết quả</h1>
         <div class="container">
            <div class="movies_menu">
               <ul>
            
              <% for(int i=0;i<cate.size();i++){ 
              		Category c= cate.get(i);
              %>
               <li><a href="http://localhost:8080/byCategory?c=<%=c.getId()%>&p=1"><%=c.getCategoryName() %></a></li>
                
              <%} %>
                 
               </ul>
            </div>
          </div>
               </div>
      <!-- movies section end -->
   <%@ include file="footer.jsp" %>