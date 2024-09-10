<%-- 
    Document   : insert
    Created on : Sep 10, 2024, 10:01:21 PM
    Author     : stephhoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Page</title>
    </head>
    <body>
        
        <table border="0">
            <tbody>
                <tr>
                    <td>Nhap ban kinh r: </td>
                    <td>
                        <input type="text" name="r" id="bk"/>
                    </td>
                </tr>
                <tr>
                    <td>Nhap x: </td>
                    <td>
                        <input type="text" name="x" id="toadoy"/>
                    </td>
                </tr>
                <tr>
                    <td>Nhap y: </td>
                    <td>
                        <input type="text" name="y" id="toadox"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="button" value="Add circle" onclick="addCircle()"/>
                        <form action="circle" method="POST"> 
                            <div id="container">
                            </div>

                            <input type="submit" value="Save"/>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>


        <script>
            var idcircle = 0;
            var bk;
            var x;
            var y;
            var container;
            function addCircle() {
                idcircle++;
                bk = document.getElementById("bk").value;
                x = document.getElementById("toadox").value;
                y = document.getElementById("toadoy").value;
                container = document.getElementById("container");
                container.innerHTML += `<div>\${idcircle}: \${bk}, \${x}, \${y}</div>
                    <input type ="hidden" value = "\${idcircle}" name = "circleid" />
                    <input type ="hidden" value = "\${bk}" name = "bk\${idcircle}" />
                    <input type ="hidden" value = "\${x}" name = "x\${idcircle}" />
                    <input type ="hidden" value = "\${y}" name = "y\${idcircle}" />`;
            }
        </script>

    </body>
</html>
