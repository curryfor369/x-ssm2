<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部书籍</title>
    <%--引用BootStarp--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
          rel="stylesheet">

</head>
<body>
<div class="container" style="margin: 100px auto">
    <h2>
        新增图书
    </h2>
    <form class="form-horizontal" method="post" action="/book/addBook">

        <div class="form-group">
            <label for="bookName" class="col-sm-2 control-label">书名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="bookName" id="bookName" value="${book.bookName}">
            </div>
        </div>
        <div class="form-group">
            <label for="bookCounts" class="col-sm-2 control-label">库存</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"  name="bookCounts" id="bookCounts" value="${book.bookCounts}">
            </div>
        </div>
        <div class="form-group">
            <label for="detail" class="col-sm-2 control-label">描述</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="detail"  name="detail" value="${book.detail}">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">添加</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
