<%-- 
    Document   : EditNote
    Created on : Feb 1, 2021, 6:19:31 PM
    Author     : 807930
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note </h2>
        <form method="post" action="note">
            <b>Title: </b><input type="text" name="editTitle" value="${editTitle}"><br>
            <b>Contents:</b> <textarea name="editContent" value="${editContent}">
            ${editContent}
            </textarea><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
