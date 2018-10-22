package ru.otus;

public interface CacheEngine<K, V> {
    void put(CacheElem<K, V> element);

    CacheElem<K, V> get(K key);

    int getHitCount();

    int getMissCount();

    void dispose();
}
