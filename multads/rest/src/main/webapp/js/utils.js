$(document).ready(function() {
	
	  $(".money").maskMoney({
		    prefix: 'R$ ',
		    thousands: '.',
		    decimal: ','
		  });
	 
	  $(".money").maskMoney('mask');
});