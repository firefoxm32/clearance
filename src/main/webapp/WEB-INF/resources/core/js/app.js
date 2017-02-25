student = function() {
   var id = null;
   var info = {
      name : 'Erick',
      lastname: 'Laxamana'
   };
   
   var initialize = function() {
	   console.log('init app js');
	   showInfo();
	   console.log('Your name is ' + getName());
	   sendMessage('Hello');
   };
   
   var showInfo = function() {
	   console.log(info.name);
	   console.log(info.lastname);
   };
   
   var getName = function() {
	   return info.name + ' ' + info.lastname;
   };
   
   var sendMessage = function(message) {
	 console.log('Send:' + message);  
   };
   
   return {init: initialize, studentName: getName}
}();

student.init;
//student.show();