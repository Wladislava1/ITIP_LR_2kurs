import java.util.LinkedList;

public class HashTable<K, V> {
    
    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 10;

    private LinkedList<Entry<K, V>>[] table;

    private int size;


    @SuppressWarnings("unchecked")
    public HashTable() {
        table = (LinkedList<Entry<K, V>>[]) new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }
   
    private int hash(K key) {
        return Math.abs(key.hashCode()) % DEFAULT_CAPACITY;
    }

    public void put(K key, V value) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++; 
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue(); 
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return;
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                table[index].remove(entry);
                size--; 
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("Студент из России", 5);
        hashTable.put("Преподаватель из США", 3);
        hashTable.put("Директор из Турции", 7);

        System.out.println("Значение по ключу 'Студент из России': " + hashTable.get("Студент из России"));  
        System.out.println("Значение по ключу 'Преподаватель из США': " + hashTable.get("Преподаватель из США")); 
        System.out.println("Значение по ключу 'Директор из Турции': " + hashTable.get("Директор из Турции")); 

        hashTable.remove("Директор из Турции");

        System.out.println("Size: " + hashTable.size());

        System.out.println("Is empty: " + hashTable.isEmpty());
    }
}
