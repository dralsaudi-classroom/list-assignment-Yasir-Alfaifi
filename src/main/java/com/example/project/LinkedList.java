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
            current = head = new Node<>(e);
        } else {
            Node<T> tmp = current.next;
            current.next = new Node<>(e);
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
        if (empty()) {
            throw new IllegalStateException("List is empty.");
        }

        Map<T, Integer> frequencyMap = new HashMap<>();
        Node<T> temp = head;
        T mostFrequent = null;
        int maxFrequency = 0;

        while (temp != null) {
            frequencyMap.put(temp.data, frequencyMap.getOrDefault(temp.data, 0) + 1);
            if (frequencyMap.get(temp.data) > maxFrequency) {
                mostFrequent = temp.data;
                maxFrequency = frequencyMap.get(temp.data);
            }
            temp = temp.next;
        }

        return mostFrequent;
    }
}
