package com.commonsort.collect;

import java.util.NoSuchElementException;


import com.commonsort.entity.NodeData;

public class DQueueList implements DQueue, java.io.Serializable {
	transient int size = 0;
	transient NodeData first;
	transient NodeData last;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1459954277465339308L;

    public DQueueList() {
    }
	public void addFirst(int v) {
		final NodeData f = first;
		final NodeData newNode = new NodeData(null, v, f);
		first = newNode;
		if (f == null)
			last = newNode;
		else
			f.setParent(newNode);
		size++;

	}

	public void addLast(int e) {

		final NodeData tail = last;
		final NodeData newNode = new NodeData(tail, e, null);
		last = newNode;
		if (tail == null)
			first = newNode;
		else
			tail.setChild(newNode);
		size++;

	}

	public int getFirst() {

		final NodeData f = first;
		if (f == null)
			throw new NoSuchElementException();
		return f.getValue();
	}

	public int getLast() {
		final NodeData l = last;
		if (l == null)
			throw new NoSuchElementException();
		return l.getValue();
	}

	public int removeFirst() {
		final NodeData f = first;
		if (f == null)
			throw new NoSuchElementException();
		final int value = f.getValue();
		final NodeData child = f.getChild();
		f.setValue(0);
		f.setChild(null);
		first = child;
		if (child == null)
			last = null;
		else
			child.setParent(null);
		size--;
		return value;
	}

	public int removeLast() {

		final NodeData l = last;
		if (l == null)
			throw new NoSuchElementException();
		final int value = l.getValue();
		final NodeData prev = l.getParent();
		l.setValue(0);
		l.setParent(null);
		last = prev;
		if (prev == null)
			first = null;
		else
			prev.setChild(null);
		size--;
		return value;
	}

	public int size() {
		return size;
	}
	

    public int[] toArray() {
    	int[] result = new int[size];
        int i = 0;
        for (NodeData n = first;n != null; n = n.getChild())
            result[i++] =n.getValue();
        return result;
    }
    
    public String toString() {
    	StringBuffer buf= new StringBuffer();
        int i = 0;
        for (NodeData n = first;n != null; n = n.getChild())
            buf.append((i++) +":"+n.getValue()+",\n");
        
        
        
        return buf.substring(0,buf.length()-2);
    }
}
