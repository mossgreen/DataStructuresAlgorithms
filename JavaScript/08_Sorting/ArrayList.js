function ArrayList(){
	var array = [];

	this.insert = function(item){
		array.push(item);
	}

	var swap = function(index1, index2){
		var aux = array[index1];
		array[index1] = array[index2];
		array[index2] = aux;
	}

	this.toString = function(){
		return array.join();
	};

	this.quickSort = function(){
		quick(array, 0, array.length - 1);
	};

	var partition = function(array, left, right){
		var pivot = array[Math.floor((right + left)/2)];
		var i = left;
		var j = right;

		console.log('pivot is '+ pivot + '; left is '+ left + ';right is '+ right);

		while( i <= j){
			while(array[i] < pivot){
				i++;
				console.log('i = '+ i);
			}

			while(array[j] > pivot){
				j --;
				console.log('j = '+ j);
			}

			if(i < j){
				console.log('swap '+ array[i] + ' with '+ array[j]);
				swapQuickStort(array ,i, j);
				i++;
				j--;
			}

		}
			return i;
	};

	var swapquickStort = function(array, index1, index2){
		var aux = array[index1];
		array[inde1] = array[index2];
		array[index2] = aux;
	};

	var quick = function(array, left, right){
		var index;
		if(array.length > 1){
			index = partition(array, left, right);

			if(left < index - 1){
				quick(array, left, index - 1);
			}

			if(index < right){
				quick(array, index, right);
			}
		}
		return array;
	};


}