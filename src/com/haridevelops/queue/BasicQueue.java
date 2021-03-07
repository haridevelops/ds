package com.haridevelops.queue;

public class BasicQueue<T> implements Queue<T> {
	private T[] data;
	private int front;
	private int end;
	
	public BasicQueue() {
		this(1000);
	}
	
	public BasicQueue(int size) {
		data = (T[]) new Object[size];
		front = end = -1;
	}
	
	public int size() {
		if (front == -1 && end == -1) return 0;
		return end - front + 1;
	}
	
	public void enQueue(T element) {
		if ((end + 1) % data.length == front) {
			throw new IllegalStateException("Queue is full");
		}
		
		if (size() == 0) front++;
		
		data[++end] = element;
	}
	
	public T deQueue() {
		if (size() == 0) throw new IllegalStateException("no data to DeQueue");
		
		T element = null;
		
		if (front == end) {
			// last element
			element = data[front];
			data[front] = null;
			front = -1; 
			end = -1;
		} else {
			element = data[front];
			data[front] = null;
			front++;
		}
		
		return element;
	}
	
	public boolean contains(T element) {
		boolean found = false;
		
		if (size() == 0) {
			return found;
		}
		
		for (int i = front; i < end; i++) {
			if (data[i].equals(element)) {
				found = true;
				break;
			}
		}
		
		return found;
	}
	
	public T access(int position) {
		if (size() == 0 || position > size()) {
			throw new IllegalArgumentException("No items in the queue");
		}
		
		int trueIndex = 0;
		for (int i = front; i < end; i++) {
			if (trueIndex == position) {
				return data[i];
			}
			trueIndex++;
		}
		
		throw new IllegalStateException("no item found at the position");
	}

}
