student = function (){
    
    $datePicker = $('.js-date-picker');
    $formStudent = $('.form-student-container');
    $selectCourse = $('.js-select-course');
    $selectYear = $('.js-select-year');
    $selectSection = $('.js-select-section');
    
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
            var ids = [1];
        });
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
    
    return {
        init: initialize()
    };
    
}();
student.init;
