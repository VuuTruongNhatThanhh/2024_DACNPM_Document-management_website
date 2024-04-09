
      <!-- footer  section start -->
      <div class="footer_section layout_padding">
         <div class="container">
            <div class="footer_menu">
               <ul>
                  <li><a href="index.html">Home</a></li>
                  <li><a href="movies.html">Movies</a></li>
                  <li><a href="tv.html">TV</a></li>
                  <li><a href="celebs.html">Celebs</a></li>
                  <li><a href="#">Sports</a></li>
                  <li><a href="#">News</a></li>
               </ul>
            </div>
            <div class="social_icon">
               <ul>
                  <li><a href="#"><img src="../images/fb-icon.png"></a></li>
                  <li><a href="#"><img src="../images/twitter-icon.png"></a></li>
                  <li><a href="#"><img src="../images/linkedin-icon.png"></a></li>
                  <li><a href="#"><img src="../images/instagram-icon.png"></a></li>
               </ul>
            </div>
         </div>
      </div>
      <!-- footer  section end -->
      <!-- copyright section start -->
      <div class="copyright_section">
         <div class="container">
            <div class="copyright_text">Copyright 2019 All Right Reserved By <a href="https://html.design">Free html Templates</a></div>
         </div>
      </div>
      <!-- copyright section end -->
      <!-- Javascript files-->
      <script src="../js/jquery.min.js"></script>
      <script src="../js/popper.min.js"></script>
      <script src="../js/bootstrap.bundle.min.js"></script>
      <script src="../js/jquery-3.0.0.min.js"></script>
      <!-- sidebar -->
      <script src="../js/jquery.mCustomScrollbar.concat.min.js"></script>
      <script src="../js/custom.js"></script>
      <!-- javascript --> 
      <script src="../js/owl.carousel.js"></script>
      <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
      <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
      <script>
         $('#datepicker').datepicker({
             uiLibrary: 'bootstrap4'
         });
      </script>
      <script type="text/javascript">
	function showReg() {
		
		var xmlhttp=new XMLHttpRequest();
	  	xmlhttp.onreadystatechange=function() {
	    	if (this.readyState==4 && this.status==200) {
	    		document.getElementById("login-div").innerHTML=this.responseText;
	      		
	    	}
	  	}
	  	xmlhttp.open("GET","/showReg",true);
	  	xmlhttp.send();
	}

</script>
<script type="text/javascript">
function isValidForm() {

	var username=document.getElementById("in-user").value;
	var pw=document.getElementById("pas").value;
	var xmlhttp=new XMLHttpRequest();
	
  	xmlhttp.onreadystatechange=function() {
    	if (this.readyState==4 && this.status==200) {
      		document.getElementById("u-error").innerHTML=this.responseText;
      		
      		
    	}
  	}
  	xmlhttp.open("Get","/loginCheckU?username="+username,false);
  	xmlhttp.send();
  	
  	
  	
  	
	var xmlhttp2=new XMLHttpRequest();
	
  	xmlhttp2.onreadystatechange=function() {
    	if (this.readyState==4 && this.status==200) {
      		document.getElementById("p-error").innerHTML=this.responseText;
      		
      		
    	}
  	}
  	xmlhttp2.open("Get","/loginCheckP?username="+username+"&pw="+pw,false);
  	xmlhttp2.send();
  	var b=document.getElementById("u-error").innerHTML;
  	var b1=document.getElementById("p-error").innerHTML;
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
	<script type="text/javascript">
	function blurS() {
		document.getElementById("res_container").innerHTML="";
	}
</script>
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
   </body>
</html>