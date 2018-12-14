package com.commonsort.collect;

public interface DQueue {

    void addFirst(int e);
    void addLast(int e);
    
    int getFirst();
    int getLast();

    int removeFirst();
    int removeLast();
    
    public int size();
}
