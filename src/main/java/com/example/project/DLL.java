package com.example.project;

class DLLNode<T> {
    T data;
    DLLNode<T> next;
    DLLNode<T> previous;

    public DLLNode(T val) {
        data = val;
        next = previous = null;
    }
}

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
        if (current != null)
            current = current.next;
    }

    public void findPrevious() {
        if (current != null)
            current = current.previous;
    }

    public T retrieve() {
        return current != null ? current.data : null;
    }

    public void update(T val) {
        if (current != null)
            current.data = val;
    }

    public void insert(T val) {
        DLLNode<T> tmp = new DLLNode<>(val);
        if (empty()) {
            current = head = tmp;
        } else {
            tmp.next = current.next;
            tmp.previous = current;
            if (current.next != null)
                current.next.previous = tmp;
            current.next = tmp;
            current = tmp;
        }
    }

    public void remove() {
        if (current == null) return;

        if (current == head) {
            head = head.next;
            if (head != null)
                head.previous = null;
        } else {
            current.previous.next = current.next;
            if (current.next != null)
                current.next.previous = current.previous;
        }
        current = (current.next == null) ? head : current.next;
    }

    public void removeBetween(T e1, T e2) {
        DLLNode<T> e1Node = null;
        DLLNode<T> e2Node = null;

        current = head;
        while (current != null) {
            if (current.data.equals(e1)) {
                e1Node = current;
                break;
            }
            current = current.next;
        }

        if (e1Node == null) return;

        current = e1Node.next;
        while (current != null) {
            if (current.data.equals(e2)) {
                e2Node = current;
                break;
            }
            current = current.next;
        }

        if (e2Node == null) return;

        e1Node.next = e2Node;
        e2Node.previous = e1Node;
    }
}
