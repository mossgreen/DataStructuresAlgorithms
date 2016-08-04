function(){
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

	this.size = function(){
		return Object.keys(items).length;
	};

	this.sizeLegacy = function(){
		var count = 0;
		for(var prop in items){
			++count;
		}
		return count;
	};

	this.values = function(){
		return Object.keys(items);
	};

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












}