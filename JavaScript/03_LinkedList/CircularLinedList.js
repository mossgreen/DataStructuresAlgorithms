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




















}