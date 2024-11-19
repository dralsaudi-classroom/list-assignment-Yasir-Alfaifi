package com.example.project;

public class LinkedList<T> implements List<T> {
	private Node<T> head;
	private Node<T> current;

	public LinkedList() {
		head = current = null;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean last() {
		return current.next == null;
	}

	public boolean full() {
		return false;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.next;
	}

	public T retrieve() {
		return current.data;
	}

	public void update(T e) {
		current.data = e;
	}

	public void insert(T e) {
		if (empty()) {
			current = head = new Node<T>(e);
		} else {
			Node<T> tmp = current.next;
			current.next = new Node<T>(e);
			current = current.next;
			current.next = tmp;
		}
	}

	public void remove() {
		if (current == head) {
			head = head.next;
		} else {
			Node<T> tmp = head;
			while (tmp.next != current) {
				tmp = tmp.next;
			}
			tmp.next = current.next;
		}
		if (current.next == null) {
			current = head;
		} else {
			current = current.next;
		}
	}

	public T mostFrequentElement() {
		/*Node<T> mostFrequent = head, currentFrequent = head;
    	int mostFrequency = 1, currentFrequency;
    	
    	while (currentFrequent != null) {
    		
    		//reset
    		current = currentFrequent;
    		currentFrequency = 0;
    		
    		//check frequency
    		while (current != null) {
    			if (current.data.equals(currentFrequent.data))
    				currentFrequency++;
    			current = current.next;
    		}
    		
    		//update most frequent
    		if (currentFrequency > mostFrequency) {
    			mostFrequent = currentFrequent;
    			mostFrequency = currentFrequency;
    		}

    		//update current frequent
    		currentFrequent = currentFrequent.next;
    	}
    	return mostFrequent.data;*/
		T mfe = null;
		int max = 0;
		Node<T> p = head;
		while (p != null) {
			Node<T> q = p;
			int count = 0;
			while (q != null) {
				if (q.data == p.data)
					count++;
				q = q.next;
			}
			if (count > max) {
				mfe = p.data;
				max = count;
			}
			p = p.next;
		}
		return mfe;
			
    }
}
