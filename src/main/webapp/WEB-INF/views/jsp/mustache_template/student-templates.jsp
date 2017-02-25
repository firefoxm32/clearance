<%-- 
    Document   : student-templates
    Created on : Feb 25, 2017, 5:26:00 PM
    Author     : All
--%>

<script type="text/template" id="student_section_template">
    <option value="0">SELECT SECTION</option>
    {{#items}}
        <option value="{{sectionId}}">{{sectionName}}</option>
    {{/items}}
</script>
