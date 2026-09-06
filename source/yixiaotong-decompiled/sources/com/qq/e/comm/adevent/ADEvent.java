package com.qq.e.comm.adevent;

import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ADEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8494a;
    private final Object[] b;

    public ADEvent(int i, Object... objArr) {
        this.f8494a = i;
        this.b = objArr;
        if (i < 100) {
            a("EventId 错误" + i);
        }
    }

    private void a(String str) {
        GDTLogger.e(str);
    }

    public <T> T getParam(int i, Class<T> cls) {
        Object[] objArr;
        if (cls == null || (objArr = this.b) == null || objArr.length <= i) {
            return null;
        }
        T t = (T) objArr[i];
        if (t == null) {
            GDTLogger.e("ADEvent 参数为空,type:" + this.f8494a);
            return null;
        }
        if (cls.isInstance(t)) {
            return t;
        }
        return null;
    }

    public int getType() {
        return this.f8494a;
    }

    public <T> T getParam(Class<T> cls) {
        return (T) getParam(0, cls);
    }
}
