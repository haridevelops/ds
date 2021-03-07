package com.haridevelops.ll;

public class BasicLinkedList<T> {
	private Node first;
	private Node last;
	private int nodeCount;

	public BasicLinkedList() {
		first = last = null;
		nodeCount = 0;
	}
	
	public void add(T element) {
		Node node = new Node(element);
		if (first == null) {
			first = last = node;
		} else {
			last.setNextNode(node);
			last = node;
		}
		nodeCount++;
	}
	
	public void insert(T element, int position) {
		if (position > size()) throw new IllegalStateException("position to insert is larger than the node count");
		
		Node currentNode = first;
		
		for (int i = 0; i < position && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}
		
		Node node = new Node(element);
		node.setNextNode(currentNode.getNextNode());
		currentNode.setNextNode(node);
		nodeCount++;		
	}
	
	public T removeAt(int position) {
		if (position > size()) throw new IllegalStateException("position to remove is larger than the node count");
		
		Node currentNode = first;
		Node prevNode = first;
		
		for (int i = 0; i < position-1 && currentNode != null; i++) {
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		T dataRemoved = currentNode.getData();
		prevNode.setNextNode(currentNode.getNextNode());
		nodeCount--;
		return dataRemoved;
	}
	
	public T get(int position) {
		if (position > size()) throw new IllegalStateException("position to retrieve is larger than the node count");
		
		Node currentNode = first;
		
		for (int i = 0; i < position && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}
		
		return currentNode != null ? currentNode.getData(): null;
	}
	
	public int find(T element) {
		if (first == null) throw new IllegalStateException("LL is empty");
				
		Node currentNode = first;
		
		for (int i = 0; i < size() && currentNode != null; i++) {
			if (currentNode.getData().equals(element)) {
				return i;
			}
			currentNode = currentNode.getNextNode();
		}
		return -1;
	}
	
	public String toString() {
		StringBuffer contents = new StringBuffer();
		Node currentNode = first;
		while (currentNode != null) {
			contents.append(currentNode.getData());
			currentNode = currentNode.getNextNode();
			if (currentNode != null) contents.append(", ");
		}
		return contents.toString();
	}
	
	public T remove() {
		if (first == null) {
			throw new IllegalStateException("LL is empty");
		}
		
		T data = first.getData();
		first = first.getNextNode();
		nodeCount--;
		
		return data;
	}
	
	public int size() {
		return nodeCount;
	}
	
	private class Node {
		private T data;
		private Node nextNode;
		
		public Node(T data) {
			this.data = data;
			nextNode = null;
		}
		
		public T getData() {
			return data;
		}
		
		public Node getNextNode() {
			return nextNode;
		}
		
		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
	}
	
}
