package DesignPatternDemo;

import java.util.Iterator;

/**
 * @author hufan
 * @date 2020/5/31 8:55 下午
 * @annotation 这是传统没有实现迭代器模式的打印集合内部数据的方式
 */
public class IteratorPattern {
    public static void main(String[] args) {
//        ArrayList arrayList = new ArrayList();
//        for (Object var : arrayList.elements) {
//            System.out.println(var);
//        }
//
//        LinkiedList linkiedList = new LinkiedList();
//        Node node = linkiedList.node;
//        while (node != null) {
//            System.out.println(node.values);
//            node = node.next;
//        }

        ArrayList arrayList = new ArrayList();
        arrayList.forEach(System.out::println);

        LinkiedList linkiedList = new LinkiedList();
        linkiedList.forEach(System.out::println);
    }
}

class ArrayListIterator implements Iterator {
    int currentIndex = 0;
    Object[] elements;

    public ArrayListIterator(Object[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < elements.length;
    }

    @Override
    public Object next() {
        return elements[currentIndex++];
    }
}

class ArrayList implements Iterable {
    Object[] elements;

    @Override
    public Iterator iterator() {
        return new ArrayListIterator(this.elements);
    }
}

class LinkedListIterator implements Iterator {
    Node head;

    public LinkedListIterator(Node head) {
        this.head = head;
    }

    @Override
    public boolean hasNext() {
        return head.next != null;
    }

    @Override
    public Object next() {
        head = head.next;
        return head;
    }
}

class LinkiedList implements Iterable {
    Node node;

    @Override
    public Iterator iterator() {
        return new LinkedListIterator(this.node);
    }
}

class Node {
    Object values;
    Node next;
}
