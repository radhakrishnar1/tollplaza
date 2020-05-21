$(document).ready(function(){

$(function(){
	$('form[id="userform"]').validate({
		  rules: {
			  firstName: 'required',
			  lastName: 'required',
			  gender:'required',
			  dob:'required',
			 

			  email: {
		      required: true,
		      email: true,
		    },
		    phoneNumber: {
		      required: true,
		      minlength: 10,
		    }
		  },
		  messages: {
			  firstName: 'FirstName is mandatory',
			  lastName: 'LastName is mandatory',
		    	email: 'Enter a valid email',
		    	userGender:'select gender',
		    	phoneNumber: {
		    		required:'MobieNo is mandatory',
		      minlength: 'MobileNo must be 10 digits'
		    }
		  },
		  submitHandler: function(form) {
		    form.submit();
		  }
		});
   });
});