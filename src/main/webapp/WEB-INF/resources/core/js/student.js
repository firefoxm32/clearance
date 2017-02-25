student = function (){
    
    $datePicker = $('.js-date-picker');
    
    var initialize = function (){
        loadDatePicker();
    };
    
    var loadDatePicker = function (){
        $datePicker.datepicker();
    };
    
    return {
        init: initialize()
    };
    
}();
student.init();
