package com.byazt.tb;

import android.util.SparseArray;
import com.byazt.nr.m;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1771, 20})
public abstract class c implements tt {
    public SparseArray<Method> c = new SparseArray<>();
    public Object tt;

    public abstract String c();

    @Override // com.byazt.tb.tt
    public void c(Object obj) {
        this.tt = obj;
    }

    @Override // com.byazt.tb.tt
    public <T> T call(int i, Object... objArr) {
        Object obj;
        Method method = this.c.get(i);
        if (method == null || (obj = this.tt) == null) {
            m.tt(c(), "call method " + i + " failed for null ");
            return null;
        }
        try {
            if (obj instanceof Class) {
                return (T) method.invoke(null, objArr);
            }
            return (T) method.invoke(obj, objArr);
        } catch (Throwable th) {
            m.tt(c(), "call method " + i + " failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.byazt.tb.tt
    public void c(int i, Method method) {
        this.c.put(i, method);
    }
}
