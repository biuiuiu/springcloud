package com.zya.cloud.two.ui;

public class NodeReverse {
	public static void main(String[] args) {
		int[] array = {23,25,29,30,87,98};
		Node head = buildLink(array);
		printLink(head);
		Node node = reverseLink(head);
		printLink(node);
	}

	private static Node buildLink(int[] array) {
		Node head = new Node();
		Node temp = head;
		Node now = null;
		for (int i = 0; i < array.length; i++) {
			String value = String.valueOf(array[i]);
			now = new Node();
			now.setData(value);
			temp.setNext(now);
			temp = now;
		}
		temp.setNext(null);
		return head;
	}

	private static void printLink(Node node) {
		if (node.getNext() == null) {
			return;
		}
		while (node.getNext() != null) {
			System.out.print((node.getData()==null?"head": node.getData()) + "--->");
			node = node.getNext();
		}
		System.out.print(node.getData());
		System.out.println();
	}
	
	private static Node reverseLink(Node node){
		if (null == node || null == node.getNext()) {
			return node;
		}
		Node newHead = new Node();
		Node first = node.getNext();
		Node next = first.getNext();
		Node pre = first;
		first.setNext(null);
		newHead.setNext(first);
		while (next != null) {
			Node temp = next.getNext();
			next.setNext(pre);
			newHead.setNext(next);
			pre = next;
			next = temp;
		}
		return newHead;
	}

	private static class Node {
		private String data;
		private Node next;

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}
}
