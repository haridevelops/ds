package com.haridevelops.stack;

public class BasicStack<T> implements Stack<T> {
	private T[] data;
	private int pointer;
	
	@SuppressWarnings("unchecked")
	public BasicStack() {
		data = (T[]) new Object[1000];
		pointer = 0;
	}
	
	@Override
	public T pop() {
		if (pointer == 0) {
			throw new IllegalStateException("No items on stack");
		}
		
		return data[--pointer];
	}

	@Override
	public void push(T element) {
		data[pointer++] = element;
	}
	
	@Override
	public boolean contains(T element) {
		boolean found = false;
		
		for (int i = 0; i < pointer; i++) {
			if (data[i].equals(element)) {
				found = true;
				break;
			}
		}
		
		return found;
	}
	
	@Override
	public T access(T element) {
		while (pointer > 0) {
			T tempElement = pop();
			if (element.equals(tempElement)) {
				return tempElement;
			}
		}
		
		throw new IllegalArgumentException("Argument not found in the stack");
	}

	@Override
	public int size() {
		return pointer;
	}
}
