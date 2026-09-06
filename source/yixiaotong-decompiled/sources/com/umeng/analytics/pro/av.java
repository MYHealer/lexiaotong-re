package com.umeng.analytics.pro;

import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bc;
import java.io.Serializable;

/* JADX INFO: compiled from: TBase.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface av<T extends av<?, ?>, F extends bc> extends Serializable {
    void clear();

    av<T, F> deepCopy();

    F fieldForId(int i);

    void read(bu buVar) throws bb;

    void write(bu buVar) throws bb;
}
