package com.senla.task7.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {

	private static class Entity {
		public final Object value;
		public final long dieAt;

		public Entity(Object value, long dieAt) {
			this.value = value;
			this.dieAt = dieAt;
		}

		public boolean isExpired() {
			return System.currentTimeMillis() > dieAt;
		}
	}

	private static Map<Object, Entity> storage = new ConcurrentHashMap<Object, Entity>();

	private static long defaultLifetime = 10000L;

	public static void setDefaultTimeout(Long newTimeout) {
		defaultLifetime = newTimeout;
	}

	public static Object get(Object key) {
		Entity e = storage.get(key);
		if (e != null) {
			if (!e.isExpired()) {
				return e.value;
			}
		}
		return null;
	}

	public static void put(Object key, Object value) {
		put(key, value, defaultLifetime);
	}

	public static void put(Object key, Object value, Long timeout) {
		storage.put(key, new Entity(value, System.currentTimeMillis() + timeout));
	}

	public static void remove(Object key) {
		storage.remove(key);
	}

	public static void clear() {
		storage.clear();
	}

	public static void expire() {
		for (Object key : storage.keySet()) {
			if (storage.get(key).isExpired()) {
				storage.remove(key);
			}
		}
	}
}
