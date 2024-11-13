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
    if (empty()) return; // If the list is empty, nothing to remove.

    
    DLLNode<T> node1 = head;
    while (node1 != null && !node1.data.equals(e1)) {
        node1 = node1.next;
    }

    
    if (node1 == null || node1.next == null) return;

   
    DLLNode<T> node2 = node1.next;
    while (node2 != null && !node2.data.equals(e2)) {
        node2 = node2.next;
    }

  
    if (node2 == null) return;

   
    DLLNode<T> temp = node1.next;
    while (temp != node2) {
        DLLNode<T> nextTemp = temp.next; 
        temp.next = null; // Break the forward link.
        temp.previous = null; // Break the backward link.
        temp = nextTemp; // Move to the next node.
    }

    
    node1.next = node2;
    node2.previous = node1;

    
    current = head;
}
