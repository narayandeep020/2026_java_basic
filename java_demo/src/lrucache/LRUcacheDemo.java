package lrucache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUcacheDemo {

	private int capacity;
	private Map<Integer, Integer> cacheMap;
	private LinkedList<Integer> lruList;

	 // Constructor to initialize the cache with a given capacity
	LRUcacheDemo(int capacity) {
		this.capacity = capacity;
		this.cacheMap = new HashMap<>();
		this.lruList = new LinkedList<>();
	}

	public int get(int key) {
		if (!cacheMap.containsKey(key)) {
			return -1;
		}

		lruList.remove(Integer.valueOf(key));
		lruList.addFirst(key);

		return cacheMap.get(key);
	}

	public void put(int key, int value) {
		if (cacheMap.containsKey(key)) {
			
			 // Update the value
			cacheMap.put(key, value);
			
			// Move the accessed key to the front
			lruList.remove(Integer.valueOf(key));
		} else {
			if (cacheMap.size() >= capacity) {

				int leastUsedKey = lruList.removeLast();
				cacheMap.remove(leastUsedKey);
			}

			cacheMap.put(key, value);
		}
		lruList.addFirst(key);
	}

	public static void main(String[] args) {

		LRUcacheDemo lruCache = new LRUcacheDemo(2);

		lruCache.put(1, 1);
		lruCache.put(2, 2);
		System.out.println(lruCache.get(1));
		lruCache.put(3, 3);
		System.out.println(lruCache.get(2));
		lruCache.put(4, 4);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(3));
		System.out.println(lruCache.get(4));

	}

}
