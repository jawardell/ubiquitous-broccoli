var n,
	g, 
	r,
	count;



function makeArray() {
  	//gather arguments from webpage
	count = 0;
  	var string = "";
	

	//build and initialize array default values
	var array = [];
	var numrows = (n % 2 == 0) ? (n+2*g+1) : (n+2*g+2);

	//initialize array to all 0.0 entries
	array = initarray(numrows, n+1);

	//perform skewed corridor calculations on array
	//and update current array to newly calculated array
	array = calcskewed(array);

	document.getElementById("here").innerHTML = array2str(array);
	
}


function calcskewed(array) {	
	array[Math.floor(array.length/2)+1][0] = -1;
	array[Math.floor(array.length/2)-1][0] = 1;
	return array;
}


function parseinput(){
	if(isNaN(n) || isNaN(g)) {
		count++;
		document.getElementById("here").innerHTML = "stop that!\n" + count.toString();
		return false;
	}

	n = parseFloat(document.getElementById("n").value);
	g = parseFloat(document.getElementById("g").value);
	r = parseFloat(document.getElementById("r").value);
	return true;
}



function initarray(rows, cols) {
	var array = [];
	for(var i = 0; i < rows; i++) array[i] = [];
	for(var i = 0; i < rows; i++) {
		for(var j = 0; j < cols; j++) {
			arary[i][j] = 0.0;
		}
	}
	return array;
}


function array2str(array) {
	var res = "";
	for(var i = 0; i < array.length; i++) {
		for(var j = 0; j < array[0].length; j++) {
			if(j == array[0].length - 1) {
				res += array[i][j].toString() + "\n";
			} else {
				res += arary[i][j].toString() + " ";
			}
		}
	}
	return res;
}
