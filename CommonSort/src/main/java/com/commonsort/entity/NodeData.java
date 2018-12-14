package com.commonsort.entity;
/*
 *  struct node of container 
 *  maybe used by DQueueList .etc. 
 * @author lonson
 */
public class NodeData implements Comparable<NodeData>
{
	int value;
	NodeData parent;
	NodeData child;
    public NodeData( NodeData parent,int v, NodeData child)
    {
        this.value=v;
        this.parent = parent;
        this.child = child;
    }
    
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public NodeData getParent() {
		return parent;
	}

	public void setParent(NodeData parent) {
		this.parent = parent;
	}

	public NodeData getChild() {
		return child;
	}

	public void setChild(NodeData child) {
		this.child = child;
	}

	public int compareTo(NodeData node) {
		return this.value-node.getValue();
	}

	
}