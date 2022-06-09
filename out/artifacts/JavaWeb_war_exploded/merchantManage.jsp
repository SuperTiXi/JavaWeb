<%@ page import="ztx.javaweb.service.MerchantService" %>
<%@ page import="java.util.List" %>
<%@ page import="ztx.javaweb.bean.Merchant" %>
<%@ page import="ztx.javaweb.bean.Admin" %><%--
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
    <title>Bootstrap Order Details Table with Search Filter</title>
<%--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">--%>
<%--    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>

<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>


<%--    <script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>--%>
    <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<%--    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">--%>


    <script language="JavaScript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
<%--    <script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>--%>
<%--    <script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>--%>

<%--    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">--%>
    <link rel="stylesheet" type="text/css" href="css/merchantManage.css">
    <link rel="stylesheet" type="text/css" href="css/googleapis.css"
<%--    <script type="text/javascript">--%>
<%--        $(document).ready(function(){--%>
<%--            $('#datatable').dataTable( {--%>
<%--                "searching": false--%>
<%--            } );--%>
<%--            $('[data-toggle="tooltip"]').tooltip();--%>
<%--        });--%>
<%--    </script>--%>

</head>
<body>
<script>
    <%! Admin curAdmin; %>
    <% curAdmin = (Admin)request.getSession().getAttribute("admin"); %>
    const msg = "<%=request.getAttribute("kind")%>";
    const admin = "<%= curAdmin.getName()%>";
    alert(msg + "成功，欢迎" + admin);
</script>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-4">
                    <h2> <b>商家管理</b></h2>
                </div>
                <div class="col-sm-8">
                    <a href="#" class="btn btn-primary" id = "btn-primary" onclick="setPage()"><i class="material-icons">&#xE863;</i> <span>刷新</span></a>
                    <a href="#" class="btn btn-info" id = "btn-info"><i class="material-icons">&#xE24D;</i> <span>导出Excel</span></a>
                </div>
            </div>
        </div>
        <div class="table-filter">
            <div class="row">
                <div class="col-sm-3">

                </div>
                <div class="col-sm-9">
<%--                    <button type="button" class="btn btn-primary"><i class="fa fa-search"></i></button>--%>
<%--                    <div class="filter-group">--%>
<%--                        <label>狀態</label>--%>
<%--                        <select class="form-control">--%>
<%--                            <option>全部</option>--%>
<%--                            <option>停用</option>--%>
<%--                            <option>正常</option>--%>

<%--                        </select>--%>

<%--                    </div>--%>
                    <div class="filter-group">
                        <label>日期范围</label>
                        <input type="date" class="form-control">
                    </div>
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

            <tbody id="body">
            <%!MerchantService merchantService = new MerchantService();
                List<Merchant> merchants = merchantService.getMerchants();
            %>

            <% for(Merchant m : merchants){%>
            <tr>
                <td><%=m.getId()%></td>
                <td><%=m.getName()%></td>
                <td><%=m.getPassword()%></td>
                <td><%=m.getRegisterDate()%></td>
                <td><%=m.getInfo()%></td>
                <td><a href="#" class="ui-button" title="修改商家" data-toggle="tooltip"><i class="material-icons">settings</i></a></td>
            </tr>
            <%}%>
            </tbody>
        </table>

    </div>
</div>
<script>
    function setPage(){
        const arr = <%=new MerchantService().getJSONList()%>;
        <%System.out.println(new MerchantService().getJSONList());%>
        let str = '';
        
        arr.forEach(function (item,key) {
            str = str+
            "<tr>"+
                "<td>${item.id}</td>"+
                "<td>${item.name}</td>"+
                "<td>${item.password}</td>"+
                "<td>${item.registerDate}</td>"+
                "<td>${item.info}</td">+
                "<td><a href=\"#\" class=\"ui-button\" title=\"修改商家\" data-toggle=\"tooltip\"><i class=\"material-icons\">settings</i></a></td>"+
            "</tr>";

        })
        const tbody = document.getElementById("body")
        tbody.innerHTML = str;
    }
</script>
</body>
</html>
