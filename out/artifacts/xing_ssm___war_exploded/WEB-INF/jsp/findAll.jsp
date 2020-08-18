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
<div class="container">
    <div class="row clearfix">&nbsp;</div>
    <div class="row clearfix">&nbsp;</div>
    <%--    标题--%>
    <div class="row clearfix">
        <div class="col-md-4 column">
            <a class="btn btn-primary"
               href="${pageContext.request.contextPath}/book/toAddBook">新增</a>
        </div>

        <div class=" col-md-8 column pull-right">
            <form class="form-inline pull-right" method="get" action="/book/findBooksWith">
                <div class="form-group">
                    <label class="sr-only" for="flag">请输入</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="flag" id="flag" placeholder="请输入.....">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">搜书</button>
            </form>
        </div>
    </div>
    <div class="row clearfix">&nbsp;</div>
    <%--    增加--%>

    <%--    展示页面,修改,删除--%>

    <table  class="table table-hover table-striped">
        <thead>
        <tr>
            <td>id</td>
            <td>书名</td>
            <td>库存</td>
            <td>描述</td>
            <td class="col-md-2 column text-center">操作</td>
        </tr>

        </thead>


        <c:forEach var="book" items="${listBooks}">
            <tbody>
                <tr>
                    <td>${book.bookID}</td>
                    <td>${book.bookName}</td>
                    <td>${book.bookCounts}</td>
                    <td>${book.detail}</td>
                    <td class="text-center col-md-2 column">
                        <a href="${pageContext.request.contextPath}/book/toUpdateBooks?bookID=${book.bookID}">修改</a>
                        &nbsp; | &nbsp;
                        <a href="${pageContext.request.contextPath}/book/deleteBooksById/${book.bookID}">删除</a>
                    </td>
                </tr>
            </tbody>

        </c:forEach>
    </table>


</div>
</body>
</html>
