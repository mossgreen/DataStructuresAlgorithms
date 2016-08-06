function HashTableSeparateChaining(){
	var table [];

	var ValuePair = function(key,value){
		this.key = key;
		this.value = value;

		this.toString = function(){
			return '[' + this.key +' - '+ this.value+']';
		}
	};

	var loseloseHashCode = function(key){ };

	var hashCode = function(key){};

	this.put = function(key, value){};

	this.get = function(key){};

	this.remove = function(key){};

	this.print = function(){};


}