function DoublyLinkedList(){

	var Node = function(element){
		this.element = element;
		this.next = null;
		this.prev = null; //adda reference to the previous node
	};

	var lenth = 0;
	var head = null;
	var tail = null; //add a new element which is the last of list

	/*adding a new node to a doublylinkedlist is quite familiar with linkedlist
	difference is that we have to control two reverences which are next and prev */
	this.insert(position, element){

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


}