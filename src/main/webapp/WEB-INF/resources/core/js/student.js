student = function (){
    
    $datePicker = $('.js-date-picker');
    
    var initialize = function (){
        loadDatePicker();
    };
    
    var loadDatePicker = function (){
        $datePicker.datepicker();
    };
    
    var testFunction = function (){
        console.log('test');
    };
    
    return {
        init: initialize()
    };
    
}();
student.init;
