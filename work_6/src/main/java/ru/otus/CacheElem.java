package ru.otus;

import lombok.Getter;

@Getter
public class CacheElem<K, V> {
    private final K key;
    private final V value;
    private final long creationTime;
    private long lastAccessTime;

    public CacheElem(K key, V value) {
        this.key = key;
        this.value = value;
        this.creationTime = getCurrentTime();
        this.lastAccessTime = getCurrentTime();
    }

    public K getKey() {
        return key;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }

    private long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public void setAccessed() {
        lastAccessTime = getCurrentTime();
    }
}
