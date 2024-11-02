<%-- 
    Document   : index
    Created on : Jul 24, 2024, 12:47:43 AM
    Author     : stephhoang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Instructors</title>
    </head>
    <body>
        List of Instructors:
        <table border="1">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Date of birth</th>
                    <th>Gender</th>
                    <th>Select</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${listIns}" var="ins">
                    <tr>
                        <td name="id">${ins.getInstructorID()}</td>
                        <td name="name">${ins.getInstructorName()}</td>
                        <td name="bod">${ins.getBirthDate()}</td>
                        <td name="gender">${ins.isGender() == true ? 'Male' : 'Female'}</td>
                        <td style="display:none" name="classID">${ins.getClassID()}</td>
                        <td>
                            <a href="#" onclick="selectItem(this)">Select</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <br/>

        <form action="update" method="post" id="detail-information">
            Detail information:
            <table border="0">
                <tbody>
                    <tr>
                        <input type="hidden" name="oldID"/>

                        <td>Code:</td>
                        <td name="code">
                            <input type="text" name="code"/>
                        </td>
                        <td>Name:</td>
                        <td name="name">
                            <input type="text" name="name"/>
                        </td>
                    </tr>

                    <tr>
                        <td>Date of birth:</td>
                        <td name="bod">
                            <input type="text" name="dob"/>
                        </td>
                        <td>Gender:</td>
                        <td name="gender">
                            <input type="radio" name="gender" value="Male"/>Male
                            <input type="radio" name="gender" value="Female" checked="checked" />Female
                        </td>
                    </tr>

                    <tr>
                        <td>Class:</td>
                        <td>
                            <select name="classSelect">
                                <c:forEach items="${listClass}" var="cl">
                                    <option value="${cl.getClassID()}">${cl.getClassName()}</option>
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

                // lay data tu table
                let tr = element.closest('tr');
                let id = tr.querySelector('td[name="id"]').innerText.trim();
                let name = tr.querySelector('td[name="name"]').innerText.trim();
                let bod = tr.querySelector('td[name="bod"]').innerText.trim();
                let gender = tr.querySelector('td[name="gender"]').innerText.trim();
                let classID = tr.querySelector('td[name="classID"]').innerText.trim();

                // lay ra form
                let form = document.querySelector('#detail-information');

                // dien vao form
                form.querySelector('input[name="code"]').value = id;
                form.querySelector('input[name="name"]').value = name;
                form.querySelector('input[name="dob"]').value = bod;
                form.querySelector('input[name="oldID"]').value = id;


                // xu li gender
                if (gender === 'Male') {
                    form.querySelector('input[name="gender"][value="Male"]').checked = true;
                } else {
                    form.querySelector('input[name="gender"][value="Female"]').checked = true;
                }

                form.querySelector('select[name="classSelect"]')
                        .querySelectorAll('option').forEach(option => {
                    if (option.value === classID) {
                        option.selected = true;
                    }
                });
            }
        </script>
    </body>
</html>
