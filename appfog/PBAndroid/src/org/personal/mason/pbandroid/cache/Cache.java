package org.personal.mason.pbandroid.cache;

public interface Cache<K, V> {

public V get(K key);

public V put(K key, V value);

public void remove(K key);

public void clear();

public int size();

public boolean isEmpty();

public boolean containsKey(Object key);

}

