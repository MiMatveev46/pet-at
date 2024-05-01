package at.common.context;

import java.util.Optional;

public interface AutoTestContext<K, V> {
    void put(K key, V value);


    void clear();


    void removeByKey(K key);


    boolean containsKey(K key);

    boolean containsValue(V value);


    V get(K key);

    <R> R get(K key, Class<R> type);


    V getNotNull(K key);

    <R> R getNotNull(K key, Class<R> type);


    V getOrDefault(K key, V defaultValue);

    <R> R getOrDefault(K key, R defaultValue, Class<R> type);


    Optional<V> getOptional(K key);

    <R> Optional<R> getOptional(K key, Class<R> type);
}
