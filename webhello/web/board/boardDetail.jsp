<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>

   <table>
       <tr>
           <td>title</td>
           <td>${boards.title}</td>
       </tr>
       <tr>
           <td>writer</td>
           <td>${boards.writer}</td>
       </tr>
       <tr>
           <td>pw</td>
           <td>${boards.pw}</td>
       </tr>
       <tr>
           <td>content</td>
           <td>${boards.content}</td>
       </tr>
   </table>

  <input type="button" value="목록" onclick="goListForm()" />
  <input type="button" value="삭제" onclick="goDelForm(${boards.id})" />
  <input type="button" value="수정" onclick="goUpdateForm(${boards.id})" />
  </body>
</html>

<script language="javascript">
    function goListForm() {
        location.href = "list";
    }
    function goDelForm(key) {
        var nextpage = "del?id=" + key;
        location.href = nextpage;
    }
    function goUpdateForm(key) {
        var nextpage = "update?id=" + key;
        location.href = nextpage;
    }
</script>