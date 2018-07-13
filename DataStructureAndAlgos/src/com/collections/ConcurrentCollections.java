package com.collections;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollections {

	public static void main(String[] args) {
		advancedCollections();
		duplicateKeysInMap();

	}

	private static void duplicateKeysInMap() {
		Map<String, String> map = new ConcurrentHashMap<>();
		String key1 = "PRAVIN";
		String key2 = "Pranjal";
		map.put(key1, "Ghumre");
		map.put(key2, "Patil");
		map.put(key1, "Patil");

		for (Map.Entry entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + map.get(entry.getKey()));
		}
	}

	private static void advancedCollections() {
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("India");
		list.add("UK");
		list.add("US");

		Iterator<String> iterator = list.iterator();

		list.remove("US");
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			iterator.remove();
			System.out.println(string);

		}

		for (String value : list) {
			System.out.println(value);
		}
	}
}
