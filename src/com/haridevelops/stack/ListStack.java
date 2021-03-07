package com.haridevelops.stack;

import java.util.ArrayList;

public class ListStack<T> implements Stack<T> {
	private ArrayList<T> data;
	private int pointer;
	
	
	public ListStack() {
		data = new ArrayList<T>();
		pointer = 0;
	}
	
	@Override
	public T pop() {
		if (pointer == 0) throw new IllegalStateException("No more items to pop");
		
		return data.get(--pointer);
	}

	@Override
	public void push(T element) {
		data.add(element);
		pointer++;
	}

	@Override
	public boolean contains(T element) {
		boolean found = false;
		
		for (T elem: data) {
			if (elem.equals(element)) {
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
		
		throw new IllegalArgumentException("element not found");
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return pointer;
	}

}
