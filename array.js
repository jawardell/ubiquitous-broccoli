	var count = 0;
	function dummy() {
		document.getElementById("here").innerHTML = "yep<br />ok";
		var array = [];
		var string = "";
		for(var i = 0; i < 4; i++) array[i] = [];
		for(var i = 0; i < array.length; i++) {
			for(var j = 0; j < 4; j++) {
				array[i][j] = 5.0;
				string += " " + array[i][j].toString() + " ";
				if(j == 3) {
					string += "<br />";
				}
			}
		}
			
		document.getElementById("here").innerHTML = string;
	}


	function makeArray(n, g, r) {
	  	//gather arguments from webpage
		n = parseFloat(document.getElementById("n").value);
		g = parseFloat(document.getElementById("g").value);
		r = parseFloat(document.getElementById("r").value);
	  	var string = "";
		if(isNaN(n) || isNaN(g)) {
			count++;
			document.getElementById("here").innerHTML = "stop that!\n" + count.toString();
			return;
		}


		//build and initialize array default values
		var array = [];
		var numrows = (n % 2 == 0) ? (n+2*g+1) : (n+2*g+2);
		for(var i = 0; i < numrows; i++) array[i] = [];	
		for(var i = 0; i < array.length; i++) {
			for(var j = 0; j < n+1; j++) {
				array[i][j] = 0;
			}
		}
		array[Math.floor(numrows/2)+1][0] = -1;
		array[Math.floor(numrows/2)-1][0] = 1;






		//prepare output string and put on page
		for(var i = 0; i < array.length; i++) {
			for(var j = 0; j < n+1; j++) {	
				string += "\t" + array[i][j].toString() + "\t";
				if(j == n) {
					string += "\n";
				}
			}
		}
		document.getElementById("here").innerHTML = string;
	
	}