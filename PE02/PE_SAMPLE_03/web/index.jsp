<%-- 
    Document   : index
    Created on : Jul 22, 2024, 9:05:11 PM
    Author     : stephhoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List</title>
    </head>
    <body>

        <form action="list?action=searchBySBID" method="POST">
            List of Subjects: 
            <select name="subjectID" onchange="return this.closest('form').submit()">
                <c:forEach items="${listSubject}" var="s">
                    <option value="${s.getSubjectID()}" ${subjectID == s.getSubjectID() ? 'selected' : ''}>
                        ${s.getSubjectName()}
                    </option>
                </c:forEach>
            </select>
        </form>



        <br/>

        List of Students
        <table border="1">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Date of birth</th>
                    <th>Gender</th>
                    <th>Subject</th>
                    <th>Select</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listStudent}" var="stu">
                    <tr>
                        <td name="id">${stu.getStudentID()}</td>
                        <td name="name">${stu.getStudentName()}</td>
                        <td name="bod">${stu.getBirthDate()}</td>
                        <td name="gender">${stu.isGender() == true ? 'Male' : 'Female'}</td>
                        <td name="sbjname">
                            <c:forEach items="${listSubject}" var="sbj">
                                <c:if test="${sbj.getSubjectID() == stu.getSubjectID()}">
                                    ${sbj.getSubjectName()}
                                </c:if>                                   
                            </c:forEach>

                        </td>
                        <td>
                            <a href="#" onclick="selectItem(this)">Select</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <br/>

        <form id="detail-information">
            Detail information:
            <table border="0">
                <tbody>
                    <tr>
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
                        <td>Subject:</td>
                        <td>
                            <select name="subject">
                                <c:forEach items="${listSubject}" var="s">
                                    <option value="${s.getSubjectID()}">
                                        ${s.getSubjectName()}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                        <td></td>
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
                let sbjname = tr.querySelector('td[name="sbjname"]').innerText.trim();
                
                // lay ra form
                let form = document.querySelector('#detail-information');
                form.querySelector('input[name="code"]').value = id;
                form.querySelector('input[name="name"]').value = name;
                form.querySelector('input[name="dob"]').value = bod;
                
                // xu li gender
                if (gender === 'Male') {
                    form.querySelector('input[name="gender"][value="Male"]').checked = true;
                } else {
                    form.querySelector('input[name="gender"][value="Female"]').checked = true;
                }
                               
                // xu li option
                form.querySelector('select[name="subject"]')
                        .querySelectorAll('option').forEach(option => {
                    if (option.innerText.trim() === sbjname) {
                        option.selected = true;
                    }
                });
            }
        </script>


    </body>
</html>
