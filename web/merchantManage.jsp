<%@ page import="ztx.javaweb.service.MerchantService" %>
<%@ page import="ztx.javaweb.bean.Merchant" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangtianxiang
  Date: 2022/6/2
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>商家管理</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

    <script language="JavaScript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>

    <link rel="stylesheet" type="text/css" href="css/merchantManage.css">
    <link rel="stylesheet" type="text/css" href="css/googleapis.css">

</head>
<body>
<%! List<Merchant> list; int i;%>
<% list = (List<Merchant>) request.getAttribute("merchantList");
    i =0;
%>
<script language="JavaScript" type="application/javascript">
    function del(id) {
        if(confirm("确定删除该条记录吗？")){
            location.href = "empdel?id=" + id;
        }
    }
</script>

<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-4">
                    <h2> <b>商家管理</b></h2>
                </div>
                <div class="col-sm-8">
                    <a href="#" class="btn btn-primary" id = "btn-primary" onclick="window.location.reload()"><i class="material-icons">&#xE863;</i> <span>刷新</span></a>
                    <a href="#" class="btn btn-info" id = "btn-info"><i class="material-icons">&#xE24D;</i> <span>导出Excel</span></a>
                </div>
            </div>
        </div>
        <div class="table-filter">
            <div class="row">
                <div class="col-sm-3">

                </div>
                <div class="col-sm-9">
                    <div class="filter-group">
                        <label>ID</label>
                        <input type="text" class="form-control">
                    </div>

                    <span class="filter-icon"><i class="fa fa-filter"></i></span>
                </div>
            </div>
        </div>

        <table id="datatable"  class="table table-striped table-hover">
            <thead>

            <tr>
                <th>ID</th>
                <th>商家名称</th>
                <th>密码</th>
                <th>加入时间</th>
                <th>信息</th>
                <th>操作</th>
            </tr>
            </thead>
            <% for(;i<list.size();i++) { %>
            <% Merchant m = list.get(i); %>
                <tr id = "tr+<%=i%>">
                    <td><%=m.getId()%></td>
                    <td><%=m.getName()%></td>
                    <td><%=m.getPassword()%></td>
                    <td><%=m.getRegisterDate()%></td>
                    <td><%=m.getInfo()%></td>
                    <td><button  value="" onclick="del()"/>&nbsp;&nbsp;
                        <button  value="修改" onclick=""/></td>
                </tr>
            <%}%>


        </table>

    </div>
</div>
</body>
</html>
