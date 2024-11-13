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
    if (empty() || e1 == null || e2 == null || e1.equals(e2)) {
        return;
    }

    DLLNode<T> node1 = null;
    DLLNode<T> node2 = null;
    DLLNode<T> temp = head;

    while (temp != null) {
        if (temp.data.equals(e1)) {
            node1 = temp;
        } else if (temp.data.equals(e2)) {
            node2 = temp;
            break;
        }
        temp = temp.next;
    }

    if (node1 == null || node2 == null || node1 == node2 || node1.next == node2) {
        return;
    }

    DLLNode<T> start = node1.next;
    DLLNode<T> end = node2;

    node1.next = end;
    end.previous = node1;

    while (start != end) {
        DLLNode<T> next = start.next;
        start.next = start.previous = null;
        start = next;
    }

    current = head;
}}
