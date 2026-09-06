package com.huawei.hms.mlplugin.card.bcr;

import java.util.LinkedList;

/* JADX INFO: compiled from: EvictingQueue.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c<T> extends LinkedList<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4168a;

    public c(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("size cannot be less than or equal to 0");
        }
        this.f4168a = i;
    }

    public int a() {
        return this.f4168a;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(T t) {
        if (b()) {
            remove();
        }
        return super.add(t);
    }

    public boolean b() {
        return size() >= a();
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public boolean offer(T t) {
        if (b()) {
            remove();
        }
        return super.offer(t);
    }
}
