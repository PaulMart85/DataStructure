package ru.geekbrains.lesson4;

public class HashMap<K, V> {

    private static final int INIT_BUCKET_COUNT = 16;


    private Bucket[] buckets;

    class Entity{
        K key;
        V value;
    }

    class Bucket<K, V>{

        Node head;

        class Node{

            Node next;
            Entity value;
        }

        /**
         * Получить значение элемента по ключу
         * @param key Ключ
         * @return Знаение элемента
         */
        public V get(K key){
            Node node = head;
            while (node != null){
                if (node.value.key.equals(key))
                    return (V)node.value.value;
                node = node.next;
            }
            return null;
        }

        /**
         * Добавление нового элемента
         * @param entity Элемент (ключ-значение)
         * @return Значение предыдущего элемента (после замены, для нового - null)
         */
        public V add(Entity entity){
            Node node = new Node();
            node.value = entity;

            if (head == null){
                head = node;
                return null;
            }

            Node currentNode = head;
            while (true){
                if (currentNode.value.key.equals(entity.key)){
                    V buf = (V)currentNode.value.value;
                    currentNode.value.value = entity.value;
                    return buf;
                }

                if (currentNode.next != null){
                    currentNode = currentNode.next;
                }
                else{
                    currentNode.next = node;
                    return null;
                }

            }

        }

        /**
         * Удаление элемента
         * @param key Ключ
         * @return Значение (null - элемент не найден)
         */
        public V remove(K key){
            if (head == null)
                return null;
            if (head.value.key.equals(key)){
                V buf = (V)head.value.value;
                head = head.next;
                return buf;
            }
            else {
                Node node = head;
                while (node.next != null){

                    if (node.next.value.key.equals(key)){
                        V buf = (V)node.value.value;
                        node.next = node.next.next;
                        return buf;
                    }

                    node = node.next;
                }
                return null;
            }
        }

    }

    private int calculateBucketIndex(K key){
        int index = key.hashCode() % buckets.length;
        if (index < 0)
            index = index *-1;
        return index;
    }


    /**
     * Добавление нового элемента
     * @param key Ключ
     * @param value Значение
     * @return Значение предыдущего элемента (после замены, для нового - null)
     */
    public V put(K key, V value){
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null){
            bucket = new Bucket();
            buckets[index] = bucket;
        }

        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        return (V)bucket.add(entity);

    }

    /**
     * Удаление элемента по ключу
     * @param key Ключ
     * @return Значение элемента (null - элемент не найден)
     */
    public V remove(K key){
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        return (V)bucket.remove(key);
    }

    /**
     * Получение значения элемента по ключу
     * @param key Ключ
     * @return Значение элемента (null - элемент не найден)
     */
    public V get(K key){
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        return (V)bucket.get(key);
    }

    public HashMap(){
        this(INIT_BUCKET_COUNT);
    }

    public HashMap(int initCount){
        buckets = new Bucket[initCount];
    }


}
