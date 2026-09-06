package com.heytap.nearx.a.a.a;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
final class c<T> extends AbstractList<T> implements Serializable, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<T> f3483a;
    private final List<T> b;

    c(List<T> list) {
        this.b = list;
        this.f3483a = list;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.f3483a);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        if (this.f3483a == this.b) {
            this.f3483a = new ArrayList(this.b);
        }
        this.f3483a.add(i, t);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        return this.f3483a.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i) {
        if (this.f3483a == this.b) {
            this.f3483a = new ArrayList(this.b);
        }
        return this.f3483a.remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        if (this.f3483a == this.b) {
            this.f3483a = new ArrayList(this.b);
        }
        return this.f3483a.set(i, t);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f3483a.size();
    }
}
