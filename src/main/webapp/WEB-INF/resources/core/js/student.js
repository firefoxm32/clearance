student = function (){
    
    $datePicker = $('.js-date-picker');
    $formStudent = $('.form-student-container');
    $selectCourse = $('.js-select-course');
    $selectYear = $('.js-select-year');
    $selectSection = $('.js-select-section');
    $table = $('.js-table');
    
    var initialize = function (){
        loadDatePicker();
        bindEventListener();
    };
    
    var loadDatePicker = function (){
        $datePicker.datepicker({
            dateFormat: 'yy-mm-dd'
        });
        
    };
   
    var bindEventListener = function () {
        $formStudent.find($selectYear).change(function () {
            populateSelectSection($selectYear.val());
        });
        populateTable();
//        $(document).ready(populateTable());
    };
    
    var populateSelectSection = function (id) {
        $.ajax({
            type: 'GET',
            url: "/clearance/api/sections/"+id,
            success: function (data) {
                renderSelectSection(data);
            },
            error: function (errorThrown) {
                console.log(errorThrown);
            }
        });
    };
    
    var renderSelectSection = function (data) {
        $selectSection.empty();
        var template = $('#student_section_template').html();
        var html = Mustache.render(template, data);
        $selectSection.append(html);
    };
    
    var populateTable = function (){
        $courseId = $selectCourse.val();
        $yearId = $selectYear.val();
        $sectionId = $selectSection.val();
        $.ajax({
            type: 'GET',
            url: "/clearance/api/students/",
            data: {
                course_id: 1,
                year_id: 1,
                section_id:1
            },
            success: function (result) {
                console.log(result);
                renderTable(result);
            },
            error: function (errorThrown) {
                console.log(errorThrown);
            }
        });
    };
    
    var renderTable = function (data) {
        console.log(data);
        $table.find('tbody').empty();
        var template = $('#student_table_template').html();
        var html = Mustache.render(template, data);
        $table.find('tbody').append(html);
    };
    
    return {
        init: initialize()
    };
    
}();
student.init;
