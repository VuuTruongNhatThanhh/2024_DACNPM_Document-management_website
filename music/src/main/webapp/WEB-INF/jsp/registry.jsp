<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header2.jsp" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 	 	  <div class="bg-img">
      <div class="content">
      <div id="close-div"><button onclick="closeLog()" id="close">X</button></div>
        <header id="he" >ĐĂNG KÝ</header>
   
        <form method="post" action="/regisCheck" onsubmit="return isValidForm1()" >
        
         <div class="field">
            <span class="fa fa-user"></span>
            <input id="in-user1" type="text" required placeholder="Tên người dùng"/>
          </div>
          <div id="u-error" style="height: 25px;color: #a2f125;font-weight: bold;"></div>
          
           <div class="field">
            <span class="fa fa-user"></span>
            <input id="in-name" type="text" required placeholder="Họ và tên"/>
          </div>
          <div id="n-error" style="height: 25px;color: #a2f125;font-weight: bold;"></div>
          
           <div class="field">
            <span class="fa fa-envelope"></span>
            <input id="in-mail" type="email" required placeholder="Email"/>
          </div>
          <div id="m-error" style="height: 25px;color: #a2f125;font-weight: bold;"></div>
          
          
          
          <div class="field space" style="margin-top: 0px">
            <span class="fa fa-lock"></span>
            <input type="password1"  id="pas" class="pass-key" required placeholder="Mật khẩu">
          </div>
          <div id="p-error" style="height: 25px;color: #a2f125;font-weight: bold;"></div>           
          
          
          <div class="field">
            <input id="login-submit" type="submit" value="Đăng ký">
          </div>
        </form>
       
      </div>
   </div>

<script type="text/javascript">
function isValidForm1() {

	var username=document.getElementById("in-user1").value;
	var mail=document.getElementById("in-mail").value;
	var xmlhttp=new XMLHttpRequest();
	
  	xmlhttp.onreadystatechange=function() {
    	if (this.readyState==4 && this.status==200) {
      		document.getElementById("u-error").innerHTML=this.responseText;
      		
      		
    	}
  	}
  	xmlhttp.open("Get","/regisCheckU?username="+username,false);
  	xmlhttp.send();
  	
  	
  	
  	
	var xmlhttp2=new XMLHttpRequest();
	
  	xmlhttp2.onreadystatechange=function() {
    	if (this.readyState==4 && this.status==200) {
      		document.getElementById("m-error").innerHTML=this.responseText;
      		
      		
    	}
  	}
  	xmlhttp2.open("Get","/regisCheckM?mail="+mail,false);
  	xmlhttp2.send();
  	var b=document.getElementById("u-error").innerHTML;
  	var b1=document.getElementById("m-error").innerHTML;
  	if(b!==""||b1!==""){
		return false;
	}
	return true;
	
	
}
</script>
<script type="text/javascript">
function closeLog() {
	document.getElementById("login-div").innerHTML="";
}

</script>

    <script>
      const pass_field = document.querySelector('.pass-key');
      const showBtn = document.querySelector('.show');
      showBtn.addEventListener('click', function(){
       if(pass_field.type === "password"){
         pass_field.type = "text";
         showBtn.textContent = "HIDE";
         showBtn.style.color = "#3498db";
       }else{
         pass_field.type = "password";
         showBtn.textContent = "SHOW";
         showBtn.style.color = "#222";
       }
      });
    </script>
	
	
	

  

  
  </body>
</html>
