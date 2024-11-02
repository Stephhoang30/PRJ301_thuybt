<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function selectRow(button) {
                var row = button.parentNode.parentNode;
                var executionId = row.cells[0].textContent.trim();
                var array = row.cells[1].textContent.trim();
                var result = row.cells[2].textContent.trim();

                // Split the array by whitespace and join back to form a string
                var arrayItems = array.split(/\s+/).join(' ');

                document.getElementById("executionId").value = executionId;
                document.getElementById("array").value = arrayItems;
                document.getElementById("result").value = result;
            }

            function deleteRow(button) {
                var row = button.parentNode.parentNode;
                row.parentNode.removeChild(row);
            }
        </script>
    </head>
    <body>
        List of execution
        <table border="1">
            <thead>
                <tr>
                    <th>ExecutionId</th>
                    <th>Array</th>
                    <th>Result</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listEx}" var="obj">
                    <tr>
                        <td><a href="#" onclick="selectRow(this)">${obj.getExecutionID()}</a></td>
                        <td>
                            <c:forEach items="${listItem}" var="i">
                                <c:if test="${i.getExecutionID() == obj.getExecutionID()}">
                                    ${i.getArrayItem()}
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>${obj.getResult()}</td>
                        <td>
                            <button type="button" onclick="deleteRow(this)">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form action="show" method="post">
            <table>
                <tr>
                    <td>Execution ID: </td>
                    <td>
                        <input type="text" id="executionId" name="executionId" />
                    </td>
                </tr>
                <tr>
                    <td>Array:</td>
                    <td>
                        <input type="text" id="array" name="array" />
                    </td>
                </tr>
                <tr>
                    <td>Result:</td>
                    <td>
                        <input type="text" id="result" name="result" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="submit">Delete</button>
                    </td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>
