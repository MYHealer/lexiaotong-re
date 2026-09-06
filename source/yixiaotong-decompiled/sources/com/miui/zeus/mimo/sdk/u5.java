package com.miui.zeus.mimo.sdk;

import android.app.Application;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class u5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<Class<? extends s5>> f5633a;

    public static void a(Application application) {
        s5 s5VarNewInstance;
        if (f5633a == null) {
            ArrayList arrayList = new ArrayList();
            f5633a = arrayList;
            arrayList.add(v5.class);
            f5633a.add(w5.class);
            f5633a.add(t5.class);
            f5633a.add(z5.class);
            f5633a.add(x5.class);
            f5633a.add(y5.class);
            f5633a.add(a6.class);
        }
        for (Class<? extends s5> cls : f5633a) {
            if (cls != null) {
                try {
                    s5VarNewInstance = cls.newInstance();
                } catch (Exception unused) {
                    s5VarNewInstance = null;
                }
                if (s5VarNewInstance != null) {
                    try {
                        s5VarNewInstance.a(application);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
    }
}
