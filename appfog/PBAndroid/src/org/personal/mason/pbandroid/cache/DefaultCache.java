package org.personal.mason.pbandroid.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class DefaultCache<K, V> implements Cache<K, V> {

private long expired;
private Map<K, Long> expiredControll;
private Map<K, V> localCache;

public DefaultCache(long expired, TimeUnit unit) {
	this.expired = unit.toNanos(expired);
	this.expiredControll = new HashMap<K, Long>();
	this.localCache = new HashMap<K, V>();
}

@Override
public V get(K key) {
	deleteExpiredEntity();
	return localCache.get(key);
}

@Override
public synchronized V put(K key, V value) {
	localCache.put(key, value);
	expiredControll.put(key, System.nanoTime());
	return value;
}

@Override
public void remove(K key) {
	if(expiredControll.containsKey(key)){
		localCache.remove(key);
		expiredControll.remove(key);
	}
}

@Override
public void clear() {
	this.expiredControll = new HashMap<K, Long>();
	this.localCache = new HashMap<K, V>();
}

@Override
public int size() {
	deleteExpiredEntity();
	return localCache.size();
}

@Override
public boolean isEmpty() {
	return size() == 0;
}

@Override
public boolean containsKey(Object key) {
	deleteExpiredEntity();
	return expiredControll.containsKey(key);
}

private synchronized void deleteExpiredEntity() {
	long deadline = System.nanoTime() - expired;
	List<K> keys = new ArrayList<K>();
	for (Entry<K, Long> entry : expiredControll.entrySet()) {
		if(entry.getValue() < deadline){
			keys.add(entry.getKey());
		}
	}
	
	for (K key : keys) {
		expiredControll.remove(key);
		localCache.remove(key);
	}
}
}
