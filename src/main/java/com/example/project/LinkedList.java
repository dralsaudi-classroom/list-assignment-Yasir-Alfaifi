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
        if (empty()) {
            throw new IllegalStateException("The list is empty.");
        }

        Node<T> temp = head;
        T mostFrequent = null;
        int maxFrequency = 0;

        while (temp != null) {
            T data = temp.data;
            int frequency = 0;
            Node<T> innerTemp = head;

            while (innerTemp != null) {
                if (innerTemp.data.equals(data)) {
                    frequency++;
                }
                innerTemp = innerTemp.next;
            }

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequent = data;
            }

            temp = temp.next;
        }

        return mostFrequent;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
