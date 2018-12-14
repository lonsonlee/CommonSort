package com.commonsort.function;

import static org.junit.Assert.*;

import java.util.Random;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import com.commonsort.collect.DQueueList;

public class ContainerOperatorTest {

	@Test
	public void testConverse() {
		long starttime=System.currentTimeMillis();
		DQueueList source = new DQueueList();
		int seed=20;
		Random rand= new Random();
		for(int i=0;i<seed;i++) {
			source.addFirst(rand.nextInt(seed));			
		}
		rand=null;
		System.out.println(source.toString());
		DQueueList dest=ContainerOperator.converse(source);
		long endtime=System.currentTimeMillis();
		System.out.println(dest.toString());
		System.out.println("start ="+starttime+"/end  ="+endtime+"/cost is="+(endtime-starttime));
		Assert.assertNotNull(dest);
	}

	@Test
	public void testConverseSpeed() {
		long starttime=System.currentTimeMillis();
		DQueueList source = new DQueueList();
		int seed=1000;
		Random rand= new Random();
		for(int i=0;i<seed;i++) {
			source.addFirst(rand.nextInt(seed));			
		}
		rand=null;
		System.out.println(source.toString());
		DQueueList dest=ContainerOperator.converse(source);
		long endtime=System.currentTimeMillis();
		System.out.println(dest.toString());
		System.out.println("start ="+starttime+"/end  ="+endtime+"/cost is="+(endtime-starttime));
		Assert.assertNotNull(dest);
	}
	
}
