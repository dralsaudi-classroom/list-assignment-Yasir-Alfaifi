package com.example.project;

public class ListTester {
    public static <T> void circularLeftShift(List<T> list, int n) {
        if (list.empty() || n <= 0) {
            return;
        }

        list.findFirst();
        int size = 1;
        while (!list.last()) {
            list.findNext();
            size++;
        }

        n = n % size;
        for (int i = 0; i < n; i++) {
            list.findFirst();
            T firstElement = list.retrieve();
            list.remove();

            list.findFirst();
            while (!list.last()) {
                list.findNext();
            }

            list.insert(firstElement);
        }
    }

    public static <T> void reverseCopy(DLL<T> l1, DLL<T> l2) {
        if (l1.empty()) {
            return;
        }

        l1.findFirst();
        while (!l1.last()) {
            l1.findNext();
        }

        do {
            l2.insert(l1.retrieve());
            l1.findPrevious();
        } while (!l1.first());

        l2.insert(l1.retrieve());
    }
}

