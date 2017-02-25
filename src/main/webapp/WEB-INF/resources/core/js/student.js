student = function (){
    
    $datePicker = $('.js-date-picker');
    
    var initialize = function (){
        loadDatePicker();
    };
    
    var loadDatePicker = function (){
        $datePicker.datepicker();
    };
    
    var test = function () {
        console.log('test another to test another');
    };
    
    return {
        init: initialize()
    };
    
}();
student.init;
