package com.adprof.sdk;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class ve extends AbstractList implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1480a;
    public List b;

    public ve(List list) {
        this.f1480a = list;
        this.b = list;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.b);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        if (this.b == this.f1480a) {
            this.b = new ArrayList(this.f1480a);
        }
        this.b.add(i, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        return this.b.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i) {
        if (this.b == this.f1480a) {
            this.b = new ArrayList(this.f1480a);
        }
        return this.b.remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        if (this.b == this.f1480a) {
            this.b = new ArrayList(this.f1480a);
        }
        return this.b.set(i, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.b.size();
    }
}
