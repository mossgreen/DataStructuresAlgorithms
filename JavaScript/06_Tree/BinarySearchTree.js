function BinarySearchTree(){
	var Node = function(key){
		this.key = key;
		this.left = null;
		this.right = null;
	};

	var root = null;

	this.insert = function(key){
		var newNode = new Node(key);

		//special case - first element
		if(root == null){
			root = newNode;
		}else{
			insertNode(root, newNode);
		}
	};

	var insertNode = function(node, newNode){
		if(newNode.key < node.key){
			if(node.left === null){
				node.left = newNode;
			}else{
				insertNode(node.left, newNode);
			}
		}else{
			if(node.right === null){
				node.right = newNode;
			}else{
				insertNode(node.right, newNode);
			}
		}
	};

	this.getRoot = function(){
		return root;
	};

	this.search = function(key){
		return searchNode(root,key);
	};

	var searchNode = function(node, key){
		if(node === null){
			return false;
		}
		if(key < node.key){
			return searchNode(node.left, key);
		}else if(key > node.key){
			return searchNode(node.right, key);
		}else{
			//element is equal to node.item
			return true;
		}
	};

	this.inOrderTraverse = function(callback){
		inOrderTraverseNode(root, callback);
	};

	var inOrderTraverseNode = function(node, callback){
		if(node !== null){
			inOrderTraverseNode(node.left, callback);
			callback(node.key);
			inOrderTraverseNode(node.right, callback);
		}
	};

	this.preorderTraverse = function(callback){};

	var preorderTraverseNode = function(node, callback){};

	this.postOrderTraverse = function(callback){};

	var postOrderTraverseNode = function(node, callback){};

	this.min = function(){};

	var minNode = function(node){};

	this.max = function(){};

	var maxNode = function(node){};

	this.remove = function(element){};

	var findMinNode = function(node){};

	var removeNode = function(node, element){};
}