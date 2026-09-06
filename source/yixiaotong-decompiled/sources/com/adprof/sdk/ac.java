package com.adprof.sdk;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class ac extends AbstractList implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1030a;

    public ac(List list) {
        this.f1030a = new ArrayList(list);
    }

    private Object writeReplace() throws ObjectStreamException {
        return Collections.unmodifiableList(this.f1030a);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        return this.f1030a.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1030a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.f1030a.toArray();
    }
}
