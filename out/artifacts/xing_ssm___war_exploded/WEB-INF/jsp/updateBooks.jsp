<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改图书信息</title>
    <%--引用BootStarp--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
          rel="stylesheet">

</head>
<body>
<div class="container" style="margin: 100px auto">
    <h2>
        修改图书信息
    </h2>
    <form class="form-horizontal" method="post" action="/book/updateBooks">

        <div class="form-group">
            <label for="bookID" class="col-sm-2 control-label">ID</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" disabled name="bookID" id="bookID" value="${books.bookID}">
            </div>
        </div>
        <div class="form-group">
            <label for="bookName" class="col-sm-2 control-label">书名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="bookName" id="bookName" value="${books.bookName}">
            </div>
        </div>
        <div class="form-group">
            <label for="bookCounts" class="col-sm-2 control-label">库存</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  name="bookCounts" id="bookCounts" value="${books.bookCounts}">
            </div>
        </div>
        <div class="form-group">
            <label for="detail" class="col-sm-2 control-label">描述</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="detail"  name="detail" value="${books.detail}">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">修改</button>
                <input type="hidden" name="bookID" value="${books.bookID}"/>
            </div>
        </div>
    </form>
</div>

</body>
</html>
