package com.haridevelops.stack;

public interface Stack<T> {
	public T pop();

	public void push(T element);

	public boolean contains(T element);

	public T access(T element);

	public int size();
}
