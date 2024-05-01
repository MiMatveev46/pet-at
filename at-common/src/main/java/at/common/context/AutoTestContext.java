package at.common.context;

public interface AutoTestContext<K, V> {
    V put(K key, V value);


    V get(K key);

}
