function LinkedList(){

	var Node = function(element){
		this.element = element;
		this.next = null;
	}

	var length = 0;
	var head = null;

	/*append method is to add an element to the end of a linkedlist
	first, build the new Node and a reference to current node,
	second, if this linkedlist is empty, which means head == null
	then the now node becomes head. Otherwise, head becomes the current element
	third, iterating the linkedlist, make the next element to the current one,
	the last element doesn't have .next attribute, so let the node to be the last.
	In the end, adding 1 to the length of this linkedList.*/
	this.append = function(element){

		var node = new Node(element);
		var current;

		if(head == null){
			head = node;
		}
		else{
			current = head;

			while(current.next){
				current = current.next;
			}

			current.next = node;
		}

		length ++;
	};


	this.insert = function(position, element){

		if(position < 0 || position > length){
			return false;

		}else{
			var node = new Node(element);
			var current = head;
			var previous;
			index = 0;

			/*if position is 0, make the first one to the second (node.next),
			and make the node to be the head.*/
			if(position === 0){

				node.next = current;
				head = node;

			}else{

				current = head;

				while(index ++ < position){
					previous = current;
					current = current.next;
				}

				/*while (index == position), let node = privious
				which means the current node*/
				node.next = current;
				previous.next = node;
			}

			length ++;

			return true;
		}
	};


	this.removeAt = function(position){

		if(position < 0 || position > length){
			return null;
		}else{

			var current = head;
			var previous;
			var index = 0;

			if(position === 0){
				head = current.next;
			}else{

				while(index ++ < position){
					previous = current;
					current = current.next;
				}

				/*this removes the element after the previous and before current.next
				which means the current element*/
				previous.next = current.next;
			}
			length --;
			return  current.element;
		}

	};
	
	this.remove = function(element){
		var index = indexOf(element);
		return removeAt(inde);
	};

	this.indexOf = function(element){

		var current = head;
		var index = -1;

		while (current){
			if(element == current.element){
				return index;
			}

			index++;
			current = current.next;
		}

		return -1;
	};

	this.isEmpty = function(){

		return length ===0;
	};

	this.size = function(){
		return length;

	};

//head is private attribute, which means it cannot be modified outside the class
this.getHead = function(){
	return head;
};


this.toString = function(){

	var current = head;
	var string = '';

	while(current){
		string = current.element;
		current = current.next;
	}
	return string;
};
this.print = function(){};
}