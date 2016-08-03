function CircularLinkedList(){
	var Node = function(element){
		this.element = element;
		this.next = null;
	};

	var length = 0;
	var head = null;
	//there is no tail, since the tail points to the head

	this.append = function(element){
		var node = new Node(element);
		var current;

		if(head === null){ 
			head = node;
		}else{

			current = head;

			//loop the list untail find last item
			while(current.next != head){
				current = current.next;
			}

			//get last item and assign next to added item
			current.next = node;
		}

		//set node.next to head in order to have circular list
		node.next = head;

		length ++; //update size of list
	};

	this.insert = function(position, element){

		//check for out-of-bounds values
		if(position >= 0 && position <= length){

			var node = new Node(element);
			var current = head;
			var previous ;
			var index = 0;

			if(position === 0){
				//current node will follow the new node
				node.next = current;

				//update last element since it has to point to the head
				while(current.next !== head){
					current = current.next;
				}

				//this element -> .next === head
				head = node;
				current.next = head;
			}else{
				//iterating previous items
				while(index++ < position){
					previous = current;
					current = current.next;
				}
				node.next = current;
				previous.next = node;

				if(node.next === null){//update in case last item
					node.next = head;
				}
			}

			length ++;
			return true;
		}else{
			return false;
		}
	};

this.removeAt(position){
	if(position > -1 && position < length){
		var current = head;
		var previous;
		var index = 0;

		//removing first item
		if(position === 0){
			//needs to update last element first
			while(current.next !== head){ 
				current = current.next;
			}

			head = head.next;
			current.next = head;
		}else{
			//no need to update last element for circular list
			while(index ++ < position){
				previous = current;
				current = current.next;
			}

			//link previous with current's next
			//skip it to remove
			previous.next = current.next;
		}
		length --;

		return current.element;
	}else{
		return null;
	}
};




















}