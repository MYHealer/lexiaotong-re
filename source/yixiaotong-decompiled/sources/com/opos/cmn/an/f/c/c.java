package com.opos.cmn.an.f.c;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<?> f5916a;

    public c(Class<?> cls) {
        this.f5916a = cls;
    }

    public Method a(String str, Class<?>... clsArr) {
        try {
            if (this.f5916a == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f5916a.getDeclaredMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
