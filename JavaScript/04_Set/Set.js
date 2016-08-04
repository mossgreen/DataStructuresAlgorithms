function Set(){
	var items = {};

	this.add = function(value){
		if(!this.has(value)){
			items[value] = value;
			return true;
		}
		return false;
	};

	this.remove = function(value){
		if(this.has(value)){
			delete items[value];
			return true;
		}
		return false;
	};

	this.has = function(value){
		return items.hasOwnProperty(value);
		//return value in items
	};

	this.clear = function(){

		items = {};
	};

	/*modern browers function, IE9+*/
	this.size = function(){
		return Object.keys(items).length;
	};

	/*cross brower compatibility*/
	this.sizeLegacy = function(){
		var count = 0;
		for(var prop in items){
			++count;
		}
		return count;
	};

	/*modern browers function, IE9+*/
	this.values = function(){
		return Object.keys(items);
	};

	/*cross brower compatibility*/
	this.valuesLegacy = function(){

		var keys =[];
		for(var key in items){
			keys.push(key);
		}

		return keys;
	};

	this.getItems = function(){
		return items;
	};

	this.union = function(otherSet){
		var unionSet = new Set();

		var values = this.values();
		for(var i=0; i<values.length; i++){
			unionSet.add(values[i]);
		}

		values = otherSet.values();
		for(var i=0; i<values.length; i++){
			unionSet.add(values[i]);
		}
		return unionSet;
	};

	this.intersection = function(otherSet){
		var intersectionSet = new Set();

		var values = this.values();
		for(var i=0; i<values.length; i++){
			if(otherSet.has(values[i])){
				intersectionSet.add(values[i]);
			}
		}
		return intersectionSet;
	};

	this.difference = function(otherSet){
		var differenceSet = new Set();
		var values = this.values();
		for(var i=0; i< values.length; i++){
			if(!otherSet.has(values[i])){
				differenceSet.add(values[i]);
			}
		}
		return differenceSet;
	};

	this.subset = function(otherSet){
		if(this.size() > otherSet.size()){
			return false;
		}else{
			var values = this.values();
			for(var i=0; i<values.length; i++){
				if(!otherSet.has(values[i])){
					return false;
				}
			}
			return true;
		}
	};	

}