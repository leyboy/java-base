package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

import org.junit.Test;

public class TestCollections {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList2 = new ArrayList<>();
		arrayList2.add(1);
		arrayList2.add(2);
		arrayList2.add(3);
		arrayList2.add(4);
		System.out.println(arrayList2.removeIf(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				int tmp = t;
				if (tmp % 2 == 0) {
					return true;
				}
				return false;
			}
		}));
		System.out.println(Arrays.asList(arrayList2));
	}

	protected void test() {
		List<String> list = new ArrayList<>();
		list = new Stack<>();
		list = new Vector<>();
		LinkedList<String> linkedList = new LinkedList<>();
		ListIterator<String> listItr;
		Collection<String> collection = linkedList;
		System.out.println(collection.toArray().getClass());
		ReentrantLock reentrantLock;
		ConcurrentHashMap<?, ?> concurrentHashMap;
	}

	private static Vector<Integer> list = new Vector<>();

	@Test
	public void testFailFast() {

		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Iterator<Integer> iterator = list.iterator();
				while (iterator.hasNext()) {
					int i = iterator.next();
					System.out.println("Thread-0遍历: " + i);
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int i = 0;
				while (i < 6) {
					System.out.println("Thread-2: " + i);
					if (i == 3) {
						list.remove(i);
					}
					i++;
				}
			}
		});

		thread.start();
		thread2.start();
	}

	@Test
	public void testMapFailFast() {
		Map<String, String> premiumPhone = new HashMap<String, String>();
		premiumPhone.put("Apple", "iPhone");
		premiumPhone.put("HTC", "HTC one");
		premiumPhone.put("Samsung", "S5");

		Iterator<String> iterator = premiumPhone.keySet().iterator();

		while (iterator.hasNext()) {
			System.out.println(premiumPhone.get(iterator.next()));
			premiumPhone.put("Sony", "Xperia Z");
		}
	}
}



