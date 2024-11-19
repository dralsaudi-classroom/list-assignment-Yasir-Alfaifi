package com.example.project;

public class DLL<T> {
	private DLLNode<T> head;
	private DLLNode<T> current;

    public DLL() {
        head = current = null;
    }
    public boolean empty() {
        return head == null;
    }
    public boolean last() {
        return current.next == null;
    }
    public boolean first() {
        return current.previous == null;
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
    public void findPrevious() {
        current = current.previous;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T val) {
        current.data = val;
    }
    public void insert(T val) {
        DLLNode<T> tmp = new DLLNode<T>(val);
        if(empty()) {
            current = head = tmp;
        }
        else {
            tmp.next = current.next;
            tmp.previous = current;
            if(current.next != null)
                current.next.previous = tmp;
            current.next = tmp;
            current = tmp;
        }
    }
    public void remove() {
        if(current == head) {
            head = head.next;
            if(head != null)
               head.previous = null;
        }
        else {
            current.previous.next = current.next;
            if(current.next != null)
               current.next.previous = current.previous;
        }
        if(current.next == null)
            current = head;
        else
            current = current.next;
    }
    public void removeBetween(T e1, T e2) {  
    	DLLNode<T> e1Node = null;
    	DLLNode<T> e2Node = null;
    	
    	current = head;
    	
    	while(current != null) {
    		if(current.data.equals(e1)) {
    			e1Node = current;
    			current = current.next;
    			break;
    		}
    		else if(current.next == null)
    			return;
    		
    		current = current.next;
    	}
    	
    	while(current != null) {
    		if(current.data.equals(e2)) {
    			e2Node = current;
    			break;
    		}
    		else if(current.next == null)
    			return;
    		
    		current = current.next;
    	}
    	if(e1Node != null && e2Node != null) {
    		e1Node.next = e2Node;
    		e2Node.previous = e1Node;
    	}
    
    	current = head;
    }
}
