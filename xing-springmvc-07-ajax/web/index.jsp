
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>
    <script>
      function loadDate() {
        var html = ""
        $.post("/getUserList",function (data) {
            console.log(data)
            for (let i = 0; i < data.length; i++) {
                html += "<tr>" +
                        "<td>" + data[i].id + "</td>" +
                        "<td>" + data[i].name + "</td>" +
                        "<td>" + data[i].age + "</td>" +
                        "</tr>"
            }

            $("table").html(html);
        })
      }

    </script>
  </head>

  <body>
      <button onclick="loadDate()">加载</button>
      <table id="listUsers" border="1">

      </table>
  </body>
</html>
