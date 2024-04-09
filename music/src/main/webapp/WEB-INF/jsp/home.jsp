<%@page import="com.boot.music.util.WFormater"%>
<%@page import="com.boot.music.dto.SongDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="com.boot.music.entity.Song"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.boot.music.entity.Category"%>
<%@ include file="header2.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%
	List<Category> l=(List<Category>)request.getAttribute("cate_list"); 
	List<SongDTO> l1=(List<SongDTO>)request.getAttribute("cate1"); 
	List<SongDTO> l2=(List<SongDTO>)request.getAttribute("cate2"); 
	List<SongDTO> l3=(List<SongDTO>)request.getAttribute("cate3"); 
	String a=(String) request.getAttribute("a");
	 WFormater w= new WFormater();
%>

      <!-- banner section end -->
      <div class="banner_section layout_padding">
         <div class="container">
            <div class="row">
               <div class="col-md-6">
                  <div class="banner_taital">Music <br>Effervescent Empathy Touching  </div>
                  <p class="banner_text">We will bring you through all your feeling.<br> Welcome to Musik Garden. </p>
                  <div class="see_bt"><a href="#">BẮT ĐẦU</a></div>
               </div>
               <div class="col-md-6">
                  <div class="play_icon"><a href="#"><img src="../images/play-icon.png"></a></div>
               </div>
            </div>
         </div>
      </div>
      <!-- banner section end -->
      <!-- arrival section start -->
      <div id="login-div">
	


 	 	
  
  

  

</div>
      <div class="arrival_section layout_padding">
         <div class="container">
            <div class="row">
               <div class="col-sm-6 col-lg-4">
                  <div class="image_1">
                     <h2 class="jesusroch_text">Â M N H Ạ C</h2>
                     <p class="movie_text">Xoa dịu và kết nối</p>
                  </div>
               </div>
               <div class="col-sm-6 col-lg-4">
                  <div class="image_2">
                     <h2 class="jesusroch_text">K Ĩ T H U Ậ T S Ố</h2>
                     <p class="movie_text">Bên bạn mọi lúc</p>
                  </div>
               </div>
               <div class="col-sm-8 col-lg-4">
                  <h1 class="arrival_text">WEBSITE NGHE NHẠC CHẤT LƯỢNG</h1>
                 
                  <p class="long_text">Được đánh giá cao bởi người dùng</p>
                  <div class="rating_main">
                     <div class="row">
                        <div class="col-sm-6 col-lg-6">
                           <div class="icon_2"><img src="../images/icon-2.png"><span class="padding_10">4.6 Điểm đánh giá</span></div>
                        </div>
                        <div class="col-sm-6 col-lg-6">
                           
                        </div>
                     </div>
                  </div>
                  <div class="paly_bt"><a href="http://localhost:8080/allSongs?p=1">Phát ngay</a></div>
               </div>
            </div>
         </div>
      </div>
      <!-- arrival section end -->
      <!-- movies section start -->
      <div class="movies_section layout_padding">
         <div class="container">
            <div class="movies_menu">
               <ul>
            
              <% for(int i=0;i<l.size();i++){ 
              		Category c= l.get(i);
              %>
               <li><a href="http://localhost:8080/byCategory?c=<%=c.getId()%>&p=1"><%=c.getCategoryName() %></a></li>
                
              <%} %>
                 
               </ul>
            </div>
            <div class="movies_section_2 layout_padding">
               <h2 class="letest_text" "><%=l.get(l1.get(0).getCateID().getId()-1).getCategoryName() %></h2>
               <div class="seemore_bt"><a href="http://localhost:8080/byCategory?c=<%=l1.get(0).getCateID().getId()%>&p=1">Xem thêm</a></div>
               <div class="movies_main">
                  <div class="iamge_movies_main">
            <%for (int i=0;i<5;i++) {
            	SongDTO s=l1.get(i); 
            %>
                   <div class="iamge_movies">
                        <div class="image_3">
                           <img width="196px" height="285px" src="<%=s.getSongIMG() %>" class="image" >
                           <div class="middle">
                              <div class="playnow_bt"><a href="http://localhost:8080/song/song?id=<%=s.getSongID()%>">Play Now</a></div>
                           </div>
                         
                        </div>
                        <h1 class="code_text"><%=w.format( s.getTitle()) %></h1>
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
               <h2 class="letest_text"><%=l.get(l2.get(0).getCateID().getId()-1).getCategoryName() %></h2>
               <div class="seemore_bt"><a href="http://localhost:8080/byCategory?c=<%=l2.get(0).getCateID().getId()%>&p=1">Xem thêm</a></div>
               <div class="movies_main">
                  <div class="iamge_movies_main">
                   <%for (int i=0;i<5;i++) {
            	SongDTO s=l2.get(i); 
            %>
                     <div class="iamge_movies">
                        <div class="image_3">
                           <img src="<%=s.getSongIMG() %>" width="196px" height="285px" class="image" style="width:100%">
                           <div class="middle">
                              <div class="playnow_bt"><a href="http://localhost:8080/song/song?id=<%=s.getSongID()%>">Mở</a></div>
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
               <h2 class="letest_text"><%=l.get(l3.get(0).getCateID().getId()-1).getCategoryName() %></h2>
               <div class="seemore_bt"><a href="http://localhost:8080/byCategory?c=<%=l3.get(0).getCateID().getId()%>&p=1">Xem thêm</a></div>
               <div class="movies_main">
                  <div class="iamge_movies_main">
                   <%for (int i=0;i<5;i++) {
            	SongDTO s=l3.get(i); 
            %>
                     <div class="iamge_movies">
                        <div class="image_3">
                           <img src="<%=s.getSongIMG() %>" width="196px" height="285px" class="image" style="width:100%">
                           <div class="middle">
                              <div class="playnow_bt"><a href="http://localhost:8080/song/song?id=<%=s.getSongID()%>">Mở</a></div>
                           </div>
                        </div>
                        <h1 class="code_text"><%=w.format(s.getTitle() )%></h1>
                        <p class="there_text"><%= w.format(s.getArtistName()) %> </p>
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
           <div class="seebt_1"><a href="http://localhost:8080/allSongs?p=1">Xem tất cả</a></div>
         </div>
      </div>
      <!-- movies section end -->
      <!-- newsletter section start -->
      <div class="newsletter_section layout_padding">
         <div class="container">
            <h1 class="newsletter_text">ĐĂNG KÝ NHẬN THÔNG BÁO</h1>
            <div class="box_main">
               <p class="dummy_text">Để lại thông tin hộp thư của bạn và chúng tôi sẽ thông báo cho bạn mỗi khi có cập nhật mới</p>
               <div class="mail_main">
                  <input type="text" class="email_text" placeholder="Nhập email của bạn" name="Enter Your email">
                  <div class="right_arrow">
                     <a href="#"><img src="../images/right-arrow.png"></a>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- newsletter section end -->
      <!-- cooming  section start -->
      <div class="cooming_section layout_padding">
         <div class="container">
            <div class="row">
               <div class="col-md-6">
                  <div class="image_17">
                     <div class="image_17"><img src="../images/img-17.png"></div>
                  </div>
               </div>
               <div class="col-md-6">
                  
                  <h1 class="Cooming_soon_taital">Sắp có</h1>
                  <p class="long_text_1">Bạn sẽ sớm có thể xem những bộ phim yêu thích</p>
                  <div class="paly_bt"><a href="#">Phát ngay</a></div>
               </div>
            </div>
         </div>
      </div>
      <!-- cooming  section end -->
<%@ include file="footer.jsp" %>