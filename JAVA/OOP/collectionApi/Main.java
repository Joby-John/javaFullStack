package JAVA.OOP.collectionApi;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Iterator;

public class Main {
    public static void main(String args[])
    {
        // ---------------------------
        // ArrayList
        // ---------------------------
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        System.out.println("ArrayList: " + nums);

        // Thread-safe version of ArrayList
        List<Integer> threadSafeList = Collections.synchronizedList(new ArrayList<>());
        threadSafeList.add(1);
        threadSafeList.add(2);
        System.out.println("Thread-safe ArrayList: " + threadSafeList);

        // Iteration using Iterator
        Iterator<Integer> listIterator = nums.iterator();
        System.out.println("Iterating ArrayList using Iterator:");
        while(listIterator.hasNext()) {
            //we can safely remove in running loop if we are using iterator
            Integer n = listIterator.next();
            if(n == 2)
            {
                listIterator.remove();
                continue;
            }
            System.out.println(n);
        }

        // ---------------------------
        // Set interface examples
        // ---------------------------
        HashSet<Integer> numsSet = new HashSet<>();
        numsSet.add(1);
        numsSet.add(2);
        numsSet.add(1); // duplicate ignored
        numsSet.add(3);
        System.out.println("HashSet: " + numsSet);

        // LinkedHashSet: maintains insertion order
        LinkedHashSet<Integer> linkedSet = new LinkedHashSet<>();
        linkedSet.add(3);
        linkedSet.add(1);
        linkedSet.add(2);
        System.out.println("LinkedHashSet: " + linkedSet);

        // TreeSet: sorted order
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(9);
        treeSet.add(2);
        System.out.println("TreeSet: " + treeSet);

        // Iterating Set using Iterator
        System.out.println("Iterating HashSet using Iterator:");
        Iterator<Integer> setIterator = numsSet.iterator();
        while(setIterator.hasNext()) {
            System.out.println(setIterator.next());
        }

        // ---------------------------
        // Map interface examples
        // ---------------------------
        Map<Integer, String> numMap = new HashMap<>();
        numMap.put(1, "One");
        numMap.put(2, "Two");
        numMap.put(3, "Three");
        System.out.println("HashMap: " + numMap);

        // Iterating Map using Iterator
        System.out.println("Iterating HashMap using Iterator:");
        Iterator<Map.Entry<Integer, String>> mapIterator = numMap.entrySet().iterator();
        while(mapIterator.hasNext()) {
            Map.Entry<Integer, String> entry = mapIterator.next();
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Thread-safe Map
        Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<>());
        syncMap.put(1, "One");
        syncMap.put(2, "Two");

        // LinkedHashMap: maintains insertion order
        Map<Integer, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(3, "Three");
        linkedMap.put(1, "One");
        linkedMap.put(2, "Two");
        System.out.println("LinkedHashMap: " + linkedMap);

        // TreeMap: sorted by keys
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(5, "Five");
        treeMap.put(2, "Two");
        treeMap.put(9, "Nine");
        System.out.println("TreeMap: " + treeMap);

        /*
         * ---------------------------
         * Notes on Collections
         * ---------------------------
         * 1. List:
         *    - Ordered collection, allows duplicates
         *    - Common implementations: ArrayList (fast random access), LinkedList (fast insertion/deletion)
         *    - Thread-safe version: Collections.synchronizedList()
         *
         * 2. Set:
         *    - Unordered, no duplicates
         *    - Implementations:
         *       a) HashSet – unordered, fast (O(1) average)
         *       b) LinkedHashSet – maintains insertion order
         *       c) TreeSet – sorted order (O(log n))
         *
         * 3. Map:
         *    - Key-value pairs, keys are unique
         *    - Implementations:
         *       a) HashMap – unordered, allows null key/value
         *       b) LinkedHashMap – maintains insertion order
         *       c) TreeMap – sorted by keys
         *       d) Synchronized/Concurrent Maps – thread-safe
         *
         * 4. Thread-Safe Collections:
         *    - Use Collections.synchronizedList(), Collections.synchronizedMap() to prevent race conditions.
         *    - Alternatively, use ConcurrentHashMap, CopyOnWriteArrayList for better concurrency.
         *
         * 5. Iteration:
         *    - Enhanced for-loop: for(Type var : collection)
         *       - Simple and readable
         *       - Cannot safely remove elements during iteration
         *    - Iterator:
         *       - Obtain via collection.iterator()
         *       - Use hasNext() and next() to traverse
         *       - Supports safe removal of elements via iterator.remove()
         *    - Use Iterator when you need to modify the collection while iterating.
         *
         * 6. Best Practices:
         *    - Program to interfaces: List<Integer> list = new ArrayList<>(); Map<K,V> map = new HashMap<>();
         *    - Use Set when uniqueness is required
         *    - Use Linked or Tree variants when order matters
         *    - Use thread-safe versions for multi-threaded scenarios
         */
    }
}
