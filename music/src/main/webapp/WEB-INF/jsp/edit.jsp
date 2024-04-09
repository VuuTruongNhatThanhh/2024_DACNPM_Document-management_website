<%@page import="com.boot.music.dto.SongDTO"%>
<%@page import="com.boot.music.entity.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="header1.jsp" %>
  <%List<SongDTO> l=(List<SongDTO>)request.getAttribute("list"); 




 %>
 
  
<div id="edit" style="z-index: 9"> 
 		  <div class="bg-img">
      <div class="content">
      <div id="close-div"><button onclick="closeEdit()" id="close">X</button></div>
   		<header id="he" >Sửa</header>
   
        <form method="post" action="/updateSong" onsubmit="return isValidForm1()" >
        
         <div class="field">
           	<label class="labl" >ID</label>
            <input id="SID" name="id" type="text" value="<%=l.get(0).getSongID() %>"/>
          </div>
          <div id="u-error" style="height: 25px;color: #a2f125;font-weight: bold;"></div>
          
           <div class="field">
           	<label class="labl" >Tiêu đề</label>
            <input name="title" type="text"  value="<%=l.get(0).getTitle() %>"/>
          </div>
          <div id="n-error" style="height: 25px;color: #a2f125;font-weight: bold;"></div>
          
           <div class="field">
           	<label class="labl" >Nghệ sĩ</label>
            <input name="artist" type="text"  value="<%=l.get(0).getArtistName() %>"/>
          </div>
          <div id="m-error" style="height: 25px;color: #a2f125;font-weight: bold;"></div>
          
          
          
          <div class="field space" style="margin-top: 0px">
            	<label class="labl" >Ảnh</label>
            <input type="text"  name="img" class="pass-key"  value="<%=l.get(0).getSongIMG() %>">
          </div>
          <div id="p-error" style="height: 25px;color: #a2f125;font-weight: bold;"></div>           
          
          
           <div class="field space" style="margin-top: 0px">
            	<label class="labl" >Đường dẫn</label>
            <input type="text"  name="mp3" class="pass-key"  value="<%=l.get(0).getMp3_link() %>">
          </div>
          <div id="p-error" style="height: 25px;color: #a2f125;font-weight: bold;"></div>           
     
      <div class="field space" style="margin-top: 0px">
            	<label class="labl" >Thể loại</label>
            <input type="text" name="cate" class="pass-key"  value="<%=l.get(0).getCateID().getCategoryName() %>">
          </div>
          <div id="p-error" style="height: 25px;color: #a2f125;font-weight: bold;"></div>           
     
      <div class="field space" style="margin-top: 0px">
            	<label class="labl" >Quốc gia</label>
            <input type="text" name="reg" class="pass-key"  value="<%=l.get(0).getRegionID().getCountry() %>">
          </div>
          <div id="p-error" style="height: 25px;color: #a2f125;font-weight: bold;"></div>           
     
          
          <div class="field">
            <input id="login-submit" type="submit" value="Sửa">
          </div>
        </form>
       
      </div>
   </div>
 
 </div>
 <%@ include file="footer.jsp" %>