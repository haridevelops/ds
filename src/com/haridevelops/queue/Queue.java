package com.haridevelops.queue;

public interface Queue<T> {
	public void enQueue(T element);
	public T deQueue();
	public int size();
	public boolean contains(T element);
	public T access(int position);
}
