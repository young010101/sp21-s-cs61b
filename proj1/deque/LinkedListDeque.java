package deque;

public class LinkedListDeque<T> {
    /** nested nake linked list class */
    private class IntNode {
        public IntNode(T item, IntNode next) {
            this.item = item;
            this.next = next;
        }
        T item;
        IntNode next;
        IntNode pre;
    }

    private int size;
    private IntNode sentinel;

    /** first item of deque is always in `sentinel.next` */
    public LinkedListDeque() {
        sentinel = new IntNode(null, null);
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new IntNode(item, sentinel.next);
        sentinel.next.pre = sentinel;
        sentinel.next.next.pre = sentinel.next;
        size++;
    }

    public void addLast(T item) {
        sentinel.pre = new IntNode(item, sentinel.pre);
        sentinel.pre.next = sentinel;
        sentinel.pre.pre.next = sentinel.pre;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        while (sentinel.next != null) {
            System.out.print(sentinel.next + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (sentinel.next == null) {
            return null;
        }

        T item;
        item = sentinel.next.item;

        sentinel.next = sentinel.next.next;
        sentinel.next.pre = sentinel;

        return item;
    }

    public T removeLast() {
        if (sentinel.next == null) {
            return null;
        }

        T item;
        item = sentinel.pre.item;

        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.next = sentinel;

        return item;

    }

    public T get(int index) {
        IntNode next = sentinel.next;
        T getItem = next.item;
        
        if (index >= size) {
            return null;
        }

        for (int j = 0; j <= index; j++) {
            getItem = next.item;
            next = next.next;
        }
        return getItem;
    }

    // TODO: instanceof
//    public Iterator<T> iterator() {
//
//    }
//    public boolean equals(Object o);
}
