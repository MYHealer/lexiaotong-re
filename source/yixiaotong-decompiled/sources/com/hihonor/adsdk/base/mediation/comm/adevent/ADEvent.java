package com.hihonor.adsdk.base.mediation.comm.adevent;

import com.hihonor.adsdk.common.b.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class ADEvent {
    private static final String TAG = "ADEvent";
    private final Object[] mParams;
    private final int mType;

    public ADEvent(int i, Object... objArr) {
        this.mType = i;
        this.mParams = objArr;
        if (i < 100) {
            b.hnadsb(TAG, "EventId 错误" + i, new Object[0]);
        }
    }

    public <T> T getParam(Class<T> cls) {
        return (T) getParam(0, cls);
    }

    public int getType() {
        return this.mType;
    }

    public <T> T getParam(int i, Class<T> cls) {
        Object[] objArr;
        if (cls != null && (objArr = this.mParams) != null && i < objArr.length) {
            T t = (T) objArr[i];
            if (cls.isInstance(t)) {
                return t;
            }
            b.hnadsb(TAG, TAG + this.mType + " 参数类型错误,期望类型" + cls.getName() + "实际类型 " + t.getClass().getName(), new Object[0]);
        }
        return null;
    }
}
