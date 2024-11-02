<%-- 
    Author     : 4USER-FPT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="execute" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Enter n: </td>
                        <td>
                            <input type="text" name="n" value="${n}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Result:
                        </td>
                        <td>
                            <input type="text" name="result" value="${result}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Execute" />
                        </td>
                        <td>
                            ${error}
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
