package com.commonsort.function;

import com.commonsort.collect.DQueueList;

/*
 * such additional operation to container 
 */
public class ContainerOperator {
	private static final int MAX_COMPARE_LEN = 1 << 8;

	@SuppressWarnings("null")
	public static DQueueList converse(DQueueList dqueue) {
		final DQueueList queue = new DQueueList();
		int[] arrays = (int[]) dqueue.toArray();
		int len = dqueue.size();
		if (len == 0)
			return queue;
		if (MAX_COMPARE_LEN >= len) {
			System.out.println("use buble");
			bubbleSort(queue, arrays);

		} else {
			System.out.println("use quick");
			quickSort(arrays, 0, len-1);
		}

		for (int i = 0; i < len; i++) {
			queue.addFirst(arrays[i]);
		}

		return queue;
	}

	public static String getStringOfDQueue(DQueueList dqueue) {

		return dqueue.toString();
	}

	private static void bubbleSort(DQueueList que, int[] numbers) {
		int temp = 0;
		int size = numbers.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) // ��������λ��
				{
					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}

	private static void quickSort(int[] numbers,int low,int high)
    {
		int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = numbers[low];
 
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=numbers[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=numbers[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = t;
            }
 
        }
        //最后将基准为与i和j相等位置的数字交换
        numbers[low] = numbers[i];
        numbers[i] = temp;
        //递归调用左半数组
        quickSort(numbers, low, j-1);
        //递归调用右半数组
        quickSort(numbers, j+1, high);
    
    }



}
