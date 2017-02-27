<%-- 
    Document   : student-templates
    Created on : Feb 25, 2017, 5:26:00 PM
    Author     : All
--%>

<script type="text/template" id="student_course_template">
    <option value="">SELECT YEAR</option>
    {{#courseYears}}
        <option value="{{id}}">{{yearName}}</option>
    {{/courseYears}}
</script>

<script type="text/template" id="student_section_template">
    <option value="">SELECT SECTION</option>
    {{#items}}
        <option value="{{sectionId}}">{{sectionName}}</option>
    {{/items}}
</script>

<script type="text/template" id="student_table_template">
        {{#items}}
        <td>{{student.studentId}}</td>
        <td>{{student.name}}</td>
        <td>{{student.gender}}</td>
        <td>{{student.address}}</td>
        <td>{{student.email}}</td>
        <td>{{semester}}</td>
        <td><button class="js-btn-update" data-id="{{student.studentId}}">UPDATE</button></td>
    {{/items}}
</script>
