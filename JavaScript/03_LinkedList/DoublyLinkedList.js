function DoublyLinkedList(){

	var Node = function(element){
		this.element = element;
		this.next = null;
		this.prev = null; //adda reference to the previous node
	};

	var lenth = 0;
	var head = null;
	var tail = null; //add a new element which is the last of list

	this.append = function(element){

		var node = new Node(element);
		var current;

		if(head === null){ //means this is the first node in list
			head = node;
			tail = node;
		}else{ //attach to the tail node
			tail.next = node;//pointing the tail to the node
			node.pre = tail;// pointing the node to tail
			tail = node; //exchange the position of node and tail
		}
		length ++;
	};

	/*adding a new node to a doublylinkedlist is quite familiar with linkedlist
	difference is that we have to control two reverences which are next and prev */
	this.insert = function(position, element){

		if(position >= 0 && position <= lenth){
			var node = new Node(element);
			var current = head;
			var previous;
			var index = 0;

			if(position === 0){ //adding node to the first place

				if(!head){ //if head is not exists
					head = node;
					tail = tail;
				}else{	//if head exists
					node.next = current;
					current.prev = node;
					head = node;
				}
			}else if(position === length){ // adding the node to the last
				current = tail;
				current.next = node;
				node.prev = current;
				tail = node;
			}else{
				while(index++ < position){
					previous = current;
					current = current.next;
				}

				node.next = current;
				previous.next = node;

				current.prev = node;
				node.prev = previous;
			}

			lenth ++;
			return true;
		}else{
			return false;
		}
	};

	this.removeAt = function(position){

		if(position > -1 && position <= length){
			var current = head;
			var previous;
			var index = 0;

			if(position === 0){
				head = current.next;

				/* if this linklist only has one node, after deleting it won't have tail
				if it has more than one node, after deleting it won't have prev*/
					if(length ===1){
						tail = null;
					}else{
						head.prev = null;
					}
			}else if(position === length -1){ //deleting the last node
				current = tail;
				tail = current.prev;
				tail.next = null;
			}else{ // iterating the list, find the right position
				while(index ++ < position ){
					previous = current;
					current = current.next;
				}

				previous.next = current.next;
				current.next.prev = previous;
			}

			length --;
			return current.element;
		}else{
			return null;
		}
	};
	

	this.remove = function(element){
		var index = this.indexOf(element);
		return this.removeAt(index);
	};

	this.indexOf = function(element){
		var current = head ;
		var index = -1;

			if(element == current.element){//check the first node
				return 0;
			}
			index ++;

			while(current.next){ //iterating the following nodes
				if(element == current.element){
					return index;
				}

				current = current.next; //exchange the position
				index ++;
			}

			if(element == current.element){ //check the last node
				return index;
			}

			return -1; // didn't find the element, return -1
		};

		this.isEmpty = function(){
			return length === 0;
		}

		this.size = function(){
			return length;
		}

		this.toString = function(){
			var current = head;
			var s = current?current.element:'';

			while(current && current.next){
				current = current.next;
				s += ', '+ current.element;
			}
			return s;
		};

		this.inversetoString = function(){
			var current = tail;
			var s = current? current.element:'';

			while(current && current.prev){
				current = current.prev;
				s += ', '+ current.element;
			}

			return s;
		};

		this.print = function(){
			console.log(this.toString());
		};

		this.printinverse = function(){
			console.log(this.inversetoString());
		};

		this.getHead = function(){
			return head;
		};

		this.getTail = function(){
			return tail;
		};


	}