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
     <h1 style="color: yellow; font-size: 40px; text-align: center;">Tìm kiếm theo: <%=sValue %></h1>
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
            <div class="movies_section_2 layout_padding">
               <div class="movies_main">
                  <div class="iamge_movies_main">
            <%for (int i=index;i<index+5;i++) {
            	SongDTO s=l.get(i); 
            	
            %>
                   <div class="iamge_movies">
                        <div class="image_3">
                           <img width="196px" height="285px" src="<%=s.getSongIMG() %>" class="image" >
                           <div class="middle">
                              <div class="playnow_bt"><a href="http://localhost:8080/song/song?id=<%=s.getSongID()%>">Play Now</a></div>
                           </div>
                         
                        </div>
                        <h1 class="code_text"><%=w.format(s.getTitle()) %></h1>
                        <p class="there_text"><%=w.format(s.getArtistName()) %> </p>
                        <div class="star_icon">
                           <ul>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                           </ul>
                        </div>
                     </div>
                  
                  <%} %>
                    
				</div>
               </div>
            </div>
                       <div class="movies_section_2 layout_padding">
               <div class="movies_main">
                  <div class="iamge_movies_main">
            <%index+=5;
            for (int i=index;i<index+5;i++) {
            	SongDTO s=l.get(i); 
            	
            %>
                   <div class="iamge_movies">
                        <div class="image_3">
                           <img width="196px" height="285px" src="<%=s.getSongIMG() %>" class="image" >
                           <div class="middle">
                              <div class="playnow_bt"><a href="http://localhost:8080/song/song?id=<%=s.getSongID()%>">Play Now</a></div>
                           </div>
                         
                        </div>
                        <h1 class="code_text"><%=w.format(s.getTitle()) %></h1>
                        <p class="there_text"><%=w.format(s.getArtistName()) %> </p>
                        <div class="star_icon">
                           <ul>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                           </ul>
                        </div>
                     </div>
                  
                  <%} %>
                    
				</div>
               </div>
            </div>
                       <div class="movies_section_2 layout_padding">
               <div class="movies_main">
                  <div class="iamge_movies_main">
            <%index+=5;
            for (int i=index;i<index+5;i++) {
            	SongDTO s=l.get(i); 
            	
            %>
                   <div class="iamge_movies">
                        <div class="image_3">
                           <img width="196px" height="285px" src="<%=s.getSongIMG() %>" class="image" >
                           <div class="middle">
                              <div class="playnow_bt"><a href="http://localhost:8080/song/song?id=<%=s.getSongID()%>">Play Now</a></div>
                           </div>
                         
                        </div>
                        <h1 class="code_text"><%=w.format(s.getTitle()) %></h1>
                        <p class="there_text"><%=w.format(s.getArtistName()) %> </p>
                        <div class="star_icon">
                           <ul>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                           </ul>
                        </div>
                     </div>
                  
                  <%} %>
                    
				</div>
               </div>
            </div>
                       <div class="movies_section_2 layout_padding">
               <div class="movies_main">
                  <div class="iamge_movies_main">
            <%index+=5;
            for (int i=index;i<l.size();i++) {
            	SongDTO s=l.get(i); 
            	index++;
            %>
                   <div class="iamge_movies">
                        <div class="image_3">
                           <img width="196px" height="285px" src="<%=s.getSongIMG() %>" class="image" >
                           <div class="middle">
                              <div class="playnow_bt"><a href="http://localhost:8080/song/song?id=<%=s.getSongID()%>">Play Now</a></div>
                           </div>
                         
                        </div>
                        <h1 class="code_text"><%=w.format(s.getTitle()) %></h1>
                        <p class="there_text"><%=w.format(s.getArtistName()) %> </p>
                        <div class="star_icon">
                           <ul>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                              <li><a href="#"><img src="../images/star-icon.png"></a></li>
                           </ul>
                        </div>
                     </div>
                  
                  <%} %>
                    
				</div>
               </div>
               </div>
               
            </div>
           <div id="login-div"></div>
           </div>
            <div style="text-align: center">
            <%if(pages<=5){
            	for(int i=1;i<=pages;i++){
            	%>
            
               <button style="font-size: 25px; width:30px; padding: 1px" onclick="location.href='http://localhost:8080/allSongs?p=<%=i%>'"><%=i %></button>
              <%}}
            else if((indexPage-2>0)&&(indexPage<pages-2)){
            	for(int i=indexPage-2;i<=indexPage+2;i++){
            		%>
            		 <button style="font-size: 25px; width:30px; padding: 1px" onclick="location.href='http://localhost:8080/allSongs?p=<%=i%>'"><%=i %></button>
            	<%
            	}
            	
            }
            else if((indexPage<=2)&&(indexPage<pages-2)){
            	 for(int i=1;i<=5;i++){
             		%>
             		 <button style="font-size: 25px; width:30px; padding: 1px" onclick="location.href='http://localhost:8080/allSongs?p=<%=i%>'"><%=i %></button>
             	<%
             	}
             }
             else{
            	for(int i=pages-5;i<=pages;i++){
            		%>
            		 <button style="font-size: 25px; width:30px; padding: 1px" onclick="location.href='http://localhost:8080/allSongs?p=<%=i%>'"><%=i %></button>
            	<%}
            }
              %>
              <div>
              <h1 id="h1-move">Chuyển đến trang</h1><form id="form-id-right" action="allSongs?p=5" onsubmit="return setAction(this)"  >
              <input style="width: 30px" id="page-input" type="text" ></form>
              
              </div>
              <script type="text/javascript">
              function setAction(form) {
            	  var s=document.getElementById("page-input").value;
            	  var i="allSongs?p="+s;
            	  location.href = "http://localhost:8080/allSongs?p="+s;
            	  form.action = "allSongs?p=5";
            	 
            	  return false;
            	}
             </script>
               </div>
      <!-- movies section end -->
   <%@ include file="footer.jsp" %>