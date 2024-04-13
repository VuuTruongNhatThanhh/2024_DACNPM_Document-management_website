<%@ page import="com.boot.music.entity.Document" %>
<%@ page import="java.util.List" %>
<%@ page import="com.boot.music.entity.Status" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="admin-header.jsp" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>Document List</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item">
              <a href="#">Home</a>
            </li>
            <li class="breadcrumb-item active">Document List</li>
          </ol>
        </div>
      </div>
    </div>

    <div class="col-sm-2 d-flex justify-content-start">
      <form id="filterForm" action="/documents" method="get">
        <div class="input-group">
          <select class="custom-select" id="filterSelect" name="filterOption">
            <option value="">Tất cả</option>
            <!-- Kiểm tra xem danh sách statuses có tồn tại và không rỗng -->

            <% List<Status> statuses = (List<Status>) request.getAttribute("statuses");
              if (statuses != null && !statuses.isEmpty()) {
                for (Status status : statuses) { %>
            <option value="<%= status.getId() %>"><%= status.getName() %></option>
            <%    }
            } %>
          </select>
          <div class="input-group-append">
            <button id="filterBtn" class="btn btn-secondary" type="button" onclick="filter()" >Filter</button>
          </div>
        </div>
      </form>
    </div>

    <!-- /.container-fluid -->
  </section>
  <!-- Main content -->
  <section class="content">
    <div class="row">
      <div class="col-md-12">
        <div class="card">

          <div class="card-body">
            <table id="example1" class="table table-bordered table-striped">
              <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Content</th>
                <th>Status</th>
                <th>Action</th>
              </tr>
              </thead>
              <tbody>
              <% List<Document> documents = (List<Document>) request.getAttribute("documents"); %>
              <% for (Document document : documents) { %>
              <tr>
                <td><%= document.getId() %></td>
                <td><%= document.getTitle() %></td>
                <td><%= document.getContent() %></td>
                <td><%= document.getStatus().getStatusValue() %></td>
                <td>
                  <div class="btn-toolbar" role="toolbar">
                    <div class="btn-group mr-2" role="group">
                      <button type="button" class="btn" style="background-color: #04AA6D;" data-toggle="modal" data-target="#documentViewModal">View</button>
                    </div>
                    <div class="btn-group mr-2" role="group">
                      <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#documentEditModal">Edit</button>
                    </div>
                    <div class="btn-group" role="group">
                      <button id="approveBtn" type="button" class="btn btn-primary">Approve</button>
                    </div>
                  </div>
                </td>
              </tr>
              <% } %>
              </tbody>
              <tfoot>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Content</th>
                <th>Status</th>
                <th>Action</th>
              </tr>
              </tfoot>
            </table>

          </div>
          <!-- /.card-body -->
        </div>
        <!-- /.card -->
      </div>
      <!-- /.col-->
    </div>
    <!-- ./row -->
  </section>
  <!-- Modal view -->
  <div class="modal fade" id="documentViewModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Tên văn bản</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body"> Nội dung tài liệu... </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
  <!-- Modal edit -->
  <div class="modal fade" id="documentEditModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="col-12 modal-title text-center" id="">Tên văn bản</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <div class="form-group">
                <span>
                  <i>Người kiểm duyệt</i>
                </span>
            <span style="float:right;">
                  <i>Create date: 2024/04/10</i>
                </span>
            <hr>
          </div>
          <div class="form-group">
            <label>Văn bản</label>
            <textarea class="form-control" rows="3" placeholder="Nội dung Tài liệu ..."></textarea>
          </div>
          <div class="form-group">
            <label>Phản hồi</label>
            <textarea class="form-control" rows="3" placeholder="Nội dung phản hồi ..."></textarea>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Save</button>
        </div>
      </div>
    </div>
  </div>
  <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<footer class="main-footer">
  <div class="float-right d-none d-sm-block">
    <b>DACNPM</b>
  </div>
  <strong>Copyright &copy; 2024 Chinhphu.vn.</strong> All rights reserved.
</footer>
<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
  <!-- Control sidebar content goes here -->
</aside>
<!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<!-- jQuery -->
<script src="../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables  & Plugins -->
<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="../plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="../plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="../plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="../plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="../plugins/jszip/jszip.min.js"></script>
<script src="../plugins/pdfmake/pdfmake.min.js"></script>
<script src="../plugins/pdfmake/vfs_fonts.js"></script>
<script src="../plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="../plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="../plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<!-- AdminLTE App -->
<script src="../js/adminlte.min.js"></script>

<script>
  function filter(){
    var selectElement =
            document.querySelector('#filterSelect');
    var  str = selectElement.value;
    var xmlhttp= new XMLHttpRequest();
    xmlhttp.onreadystatechange=function (){
      document.getElementById("example1").innerHTML=this.responseText;
    }
    xmlhttp.open("GET","/filtered-documents?filterOption="+str,true);
    xmlhttp.send();
  }



</script>


<script>
  $(function() {
    $("#example1").DataTable({
      "responsive": true,
      "lengthChange": false,
      "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');

    $("#approveBtn").click(function() {
      confirm("Approve?");
    });
  });
</script>
</body>
</html>
