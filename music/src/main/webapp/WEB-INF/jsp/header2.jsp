<%@page import="com.boot.music.entity.Account"%>
<%@page import="com.boot.music.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<!DOCTYPE html>
<html>

 <head>
      <!-- basic -->
      <%Account u=(Account)session.getAttribute("Acc");
      %>


<meta charset="utf-8">
 <link rel="stylesheet" href="../css/login.css">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>Musik Garden</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- bootstrap css -->
      <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" type="text/css" href="../css/style6.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="../css/responsive.css">
      <!-- fevicon -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
      <link rel="icon" href="../images/fevicon.png" type="image/gif" />
       <script src="../js/playerjs (3).js" type="text/javascript"></script>
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="../css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <!-- owl stylesheets --> 
      <link rel="stylesheet" href="../css/owl.carousel.min.css">
        <script src=" https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js "></script>
   <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"> </script>
      <link rel="stylesheet" href="../css/owl.theme.default.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
      <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
   </head>
      <body>
      <!-- header section start -->
     
      <div class="header_section">
         <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="logo" href="index.html"><img src="../images/logo1.png"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
               <ul class="navbar-nav mr-auto">
                  <li class="nav-item active">
                     <a class="nav-link" href="http://localhost:8080/home">Trang chủ</a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link" href="<%=request. getContextPath( )%>/allSongs?p=1">Bài hát</a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link" href="tv.html">Nghệ sĩ</a>
                  </li>
                  <li class="nav-item">
                     <a class="nav-link" href="celebs.html">Billboard</a>
                  </li>
               </ul>
                <div  id="search" class="search_icon"><a href="#"><img src="../images/search-icon.png"></a></div>
              	<div id="search2">
              		<form style="margin-left: 2%"  onsubmit="return setAction1(this)" >
              		<input  id="search-input" placeholder="Search..." type="text" size="30" onkeyup="showResult(this.value)">
              		<div onblur="blurS()" id="res_container" style="border: none">
              			
              	
              		</div>
              		
              		</form>
              	
              	</div>
              <%if(u!=null){ %>
               <div class="search_icon"><a href="#"><img src="../images/user-icon.png"><span class="padding_left_15"><%=u.getUsername() %></span></a></div>
               <div class="search_icon"><a href="#"><img src="../images/eye-icon.png"><span class="padding_left_15">Hồ sơ</span></a></div>
               <div  class="search_icon"><a href="/logout"><img src="../images/logout.png"><span class="padding_left_15">Đăng xuất</span></a></div>
              <%}else {%>
             
             <div onclick="log()" class="search_icon"><a href="#"><img src="../images/user-icon.png"><span class="padding_left_15">Đăng nhập</span></a></div>
 <%} %>

            
 <script type="text/javascript">
 	function open_search_bar() {
 		var search= document.getElementById("bar");
 		
		search.innerHTML='<form><input placeholder="Search..." type="text" size="30" onkeyup="showResult(this.value)"><div id="livesearch"></div></form>';
		
	}
 </script>
   <script type="text/javascript">
              function setAction1(form) {
            	  var s=document.getElementById("search-input").value;
            	  
            	  location.href = "http://localhost:8080/searchBy?s="+s+"&p=1";
            	 
            	 
            	  return false;
            	}
             </script>
  <script>
	function showResult(str) {
  		if (str.length==0) {
    		document.getElementById("res_container").innerHTML="";
    		document.getElementById("res_container").style.border="0px";
    	return;
  	}	
  	var xmlhttp=new XMLHttpRequest();
  	xmlhttp.onreadystatechange=function() {
    	if (this.readyState==4 && this.status==200) {
      		document.getElementById("res_container").innerHTML=this.responseText;
      		document.getElementById("res_container").style.border="1px solid #A5ACB2";
    	}
  	}
  	xmlhttp.open("GET","/search?s="+str,true);
  	xmlhttp.send();
}
</script>
 <script>
	function log() {
		
		var xmlhttp=new XMLHttpRequest();
	  	xmlhttp.onreadystatechange=function() {
	    	if (this.readyState==4 && this.status==200) {
	    		document.getElementById("login-div").innerHTML=this.responseText;
	      		
	    	}
	  	}
	  	xmlhttp.open("GET","/loginHTML",true);
	  	xmlhttp.send();
}
</script>
            </div>
         </nav>
      </div>
      <!-- header section end -->