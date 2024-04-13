<%@page import="com.boot.music.entity.Document"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><%@ include file="header.jsp" %> <div class="content">
    <div class="row">
    <% List<Document> listDocument = (List<Document>) request.getAttribute("listDocument"); %>
      <div class="col-sm-6">
        <h3 style="margin-left: 15px;">Danh sách văn bản được Phê duyệt</h3>
        <div class="Wrap" style="height: 240px">
          <div class="clear"></div>
          <ul class="next">
          <% for (Document docObj : listDocument) { %>
            <li class="item">
              <a class="title" href="#" onclick="contentDocDisplay(<%= docObj.getId() %>);"> <%= docObj.getTitle() %> <span class="datetime">- ( <span class="date"><%= docObj.getDateStart() %></span> ) </span>
              </a>
            </li>   
           <% } %>    
          </ul>
        </div>
      </div>
      <div class="col-sm-6">
      <% for (Document docObj : listDocument) { %>
      	<div id="contentDoc-<%= docObj.getId() %>" style="display: none;">
      		<%= docObj.getSumary() %>
      	</div>
      <% } %> 
      </div>
    </div>
  </div>
  <div class="footer">
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
      <tbody>
        <tr>
          <td>
            <div class="UIFooterControl">
              <div class="row">
                <div class="col-sm-6">
                  <div class="head">
                    <div>
                      <h2>
                        <span>ĐỒ ÁN CÔNG NGHỆ PHẦN MỀM</span>
                      </h2>
                      <p>Nhóm: <strong> Lion </strong></p>
                    </div>
                  </div>
                </div>
                <div class="col-sm-6">
                  
                </div>
              </div>
              <hr>
              <div class="row">
                <div class="col-sm-12" style="text-align: center">
                  <p>Copyright © 2024. </p>
                </div>
              </div>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  </div>
  <script>
  	function contentDocDisplay(idDoc) {
  		var idCurrent = "contentDoc-".concat(idDoc);
  		$("[id^=contentDoc-]").each(function(idx, obj){
  			var idElm = obj.id;
  			if (idCurrent == idElm) {
  				$("#".concat(idCurrent)).show();
  			} else {
  				$("#".concat(obj.id)).hide();
  			}
		});
  	}
  
  </script>
  </body></html>