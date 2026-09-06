package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class ForegroundBusResponseMgr {
    private static final ForegroundBusResponseMgr b = new ForegroundBusResponseMgr();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, BusResponseCallback> f3793a = new HashMap();

    public static ForegroundBusResponseMgr getInstance() {
        return b;
    }

    public BusResponseCallback get(String str) {
        BusResponseCallback busResponseCallback;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f3793a) {
            busResponseCallback = this.f3793a.get(str);
        }
        return busResponseCallback;
    }

    public void registerObserver(String str, BusResponseCallback busResponseCallback) {
        if (TextUtils.isEmpty(str) || busResponseCallback == null) {
            return;
        }
        synchronized (this.f3793a) {
            if (!this.f3793a.containsKey(str)) {
                this.f3793a.put(str, busResponseCallback);
            }
        }
    }

    public void unRegisterObserver(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f3793a) {
            this.f3793a.remove(str);
        }
    }
}
