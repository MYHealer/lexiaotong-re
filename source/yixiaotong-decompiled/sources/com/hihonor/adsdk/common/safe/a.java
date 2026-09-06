package com.hihonor.adsdk.common.safe;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a<K, V> extends ConcurrentHashMap<K, V> {
    private static final String hnadsd = "SafeConcurrentHashMap";

    @Override // java.util.concurrent.ConcurrentHashMap
    public boolean contains(Object obj) {
        if (!Objects.isNull(obj)) {
            return super.contains(obj);
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "contains, value is null", new Object[0]);
        return false;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (!Objects.isNull(obj)) {
            return super.containsKey(obj);
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "containsKey, key is null", new Object[0]);
        return false;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (!Objects.isNull(obj)) {
            return super.containsValue(obj);
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "containsValue, value is null", new Object[0]);
        return false;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (!Objects.isNull(obj)) {
            return (V) super.get(obj);
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "get, key is null", new Object[0]);
        return null;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (!Objects.isNull(k) && !Objects.isNull(v)) {
            return (V) super.put(k, v);
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "put, key is null: " + Objects.isNull(k) + ", value is null: " + Objects.isNull(v), new Object[0]);
        return null;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        if (Objects.isNull(map)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "putAll, map is null", new Object[0]);
        } else {
            super.putAll(map);
        }
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (!Objects.isNull(obj)) {
            return super.remove(obj, obj2);
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "remove, key is null", new Object[0]);
        return false;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (Objects.isNull(obj)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "remove, key is null", new Object[0]);
            return null;
        }
        return (V) super.remove(obj);
    }
}
