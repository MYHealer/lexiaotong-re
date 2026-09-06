package com.j256.ormlite.dao;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface ObjectCache {
    <T> void clear(Class<T> cls);

    void clearAll();

    <T, ID> T get(Class<T> cls, ID id);

    <T, ID> void put(Class<T> cls, ID id, T t);

    <T> void registerClass(Class<T> cls);

    <T, ID> void remove(Class<T> cls, ID id);

    <T> int size(Class<T> cls);

    int sizeAll();

    <T, ID> T updateId(Class<T> cls, ID id, ID id2);
}
