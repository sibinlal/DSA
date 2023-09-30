package com.javalab.ds;



public class LabLinkedList {

	private Node head;
	private Node tail;
	public int size;

	public LabLinkedList() {
		this.size = 0;
	}

	public void insertFirst(int value) {
		Node node = new Node(value);
		node.next = head;
		head = node;

		if (tail == null) {
			tail = head;
		}

		size += 1;
	}

	public void insert(int value) {

		Node node = new Node(value);
		if (head == null) { // first element.
			head = node;
			tail = head;
			size += 1;
			return;
		}
		tail.next = node;
		tail = node;

		size += 1;
	}

	public void insertToIndex(int value, int index) {

		if (index == 0) {
			insertFirst(value);
			return;
		}

		if(index > size){
			return;
		}

		if (index == size) {
			insert(value);
			return;
		}

		Node temp = head;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}

		Node node = new Node(value, temp.next);
		temp.next = node;

		size += 1;
	}

	public void deleteFirst() {
		if (head == null) {
			return;
		}
		if (head.next == null) {
			head = null;
			tail = null;
			size--;
			return;
		}
		head = head.next;
		size--;
	}

	public void deleteLast() {

		if (head == null) {
			return;
		}

		if (size == 1) {
			deleteFirst();
		}

		Node lastTobeNode = get(size - 2);
		lastTobeNode.next = null;
		tail = lastTobeNode;
		size--;
	}

	public int getNodeValue(int index) {
		return get(index).data;
	}

	public Node get(int index) {

		if (index == 0) {
			return head;
		}

		if (index >= size) {
			return tail;
		}

		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	public void display() {
		Node temp = head;
		System.out.println("****************");
		while (temp != null) {
			System.out.print(" " + temp.data);
			temp = temp.next;
		}
		System.out.println("\n list size is: " + size);
	}

	private static class Node {

		private final int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

}

class Test {
	public static void main(String[] args){
		LabLinkedList list = new LabLinkedList();
		list.insertFirst(5);
		list.insert(10);
		list.insert(8);
		list.display();

		list.deleteFirst();
		list.display();

		list.deleteLast();
		list.display();

		list.insertToIndex(20,1);
		list.display();
	}
}


