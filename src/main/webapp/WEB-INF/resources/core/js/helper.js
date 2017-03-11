
/**
 * 
 * Global functions
 */
var Helper = {
    selectors: {
        cmbSemester: $('.js-select-semester'),
    },
    add: function(a,b) {
        return a + b;
    },
    subtract: function(a, b) {
        return a - b;
    },
    semChange: function() {
        console.log(this.selectors.cmbSemester.val());
    }
};