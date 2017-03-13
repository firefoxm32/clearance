
    $selectCourse = $('.js-select-course');
    $selectYear = $('.js-select-year');
    $selectSection = $('.js-select-section');
    $.populateSelectYear = function (id, $selector, $val) {
        $.ajax({
            type: 'GET',
            url: "/clearance/api/course/" + id,
            success: function (result) {
                $selectYear.empty();
                renderSelectYear(result, $selector, $val);
            }
        });
    };

    renderSelectYear = function (data, $selector, $val) {
        var template = $('#student_course_template').html();
        var rendered = Mustache.render(template, data);
        $selector.find($selectYear).append(rendered);
        if($val !== ""){
            $selectYear.val($val);
        }
    };

    $.populateSelectSection = function (id, $selector, $val) {
        $.ajax({
            type: 'GET',
            url: "/clearance/api/sections/" + id,
            success: function (data) {
                renderSelectSection(data, $selector, $val);
            },
            error: function (errorThrown) {
                console.log(errorThrown);
            }
        });
    };

    renderSelectSection = function (data, $selector, $val) {
        $selectSection.empty();
        var template = $('#student_section_template').html();
        var html = Mustache.render(template, data);
        $selector.find($selectSection).append(html);
        if($val !== ""){
            $selectSection.val($val);
        }
    };