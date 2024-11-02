<%-- 
    Author     : 4USER-FPT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        List of instructor
        <br/>
        <table border="1">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>DOB</th>
                    <th>Gender</th>
                    <th>Select</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ls}" var="s">
                    <tr>
                        <td name="code">${s.getStudentID()}</td>
                        <td name="name">${s.getStudentName()}</td>
                        <td name="dob">${s.getBirthDate()}</td>
                        <td name="gender">${s.isGender() == true ? 'Male' : 'Female'}</td>
                        <td style="display: none" name="class">${s.getClassID()}</td>
                        <td>
                            <a href="#" onclick="selectItem(this)">Select</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form action="update" method="POST" id="formUpdate">
            <table border="0">
                <tbody>
                <input type="hidden" name="oldId" value=""/>
                    <tr>
                        <td>Code</td>
                        <td>
                            <input type="text" name="code" value="" />
                        </td>
                        <td>Name</td>
                        <td>
                            <input type="text" name="name" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            DOB
                        </td>
                        <td>
                            <input type="text" name="dob" value="" />
                        </td>
                        <td>
                            Gender
                        </td>
                        <td>
                            <input type="radio" name="gender" value="Male" /> Male
                            <input type="radio" name="gender" value="Female" /> Female
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Class
                        </td>
                        <td>
                            <select name="class">
                                <c:forEach items="${lc}" var="c">
                                    <option value="${c.getClassID()}">${c.getClassName()}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <input type="submit" value="Update" />
                        </td>
                        <td></td>
                    </tr>
                </tbody>
            </table>

        </form>   

        <script>
            function selectItem(element) {
                //tim ra the tr gan nhat
                let tr = element.closest('tr');
                
                let code = tr.querySelector('td[name=code]').innerText.trim();
                let name = tr.querySelector('td[name=name]').innerText.trim();
                let dob = tr.querySelector('td[name=dob]').innerText.trim();
                let gender = tr.querySelector('td[name=gender]').innerText.trim();
                let classes = tr.querySelector('td[name=class]').innerText.trim();
                
                let form = document.querySelector('#formUpdate');
                form.querySelector('input[name=code]').value = code;
                form.querySelector('input[name=oldId]').value = code;
                form.querySelector('input[name=name]').value = name;
                form.querySelector('input[name=dob]').value = dob;
                if(form.querySelector('input[name=gender][value=Male]').value == gender) {
                    form.querySelector('input[name=gender][value=Male]').checked = true;
                }else {
                    form.querySelector('input[name=gender][value=Female]').checked = true;
                }
                
                form.querySelector('select[name=class]')
                        .querySelectorAll('option').forEach(option => {
                        if(option.value === classes) {
                            option.selected = true;
                        }
                });
            }
        </script>
    </body>
</html>
