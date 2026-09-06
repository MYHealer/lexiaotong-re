package com.opos.cmn.func.dl.base;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.opos.cmn.an.j.a f6112a;

    public static ThreadPoolExecutor a() {
        if (f6112a == null) {
            synchronized (b.class) {
                if (f6112a == null) {
                    f6112a = new com.opos.cmn.an.j.a.C0869a().b(1).a(1).a("single_tp_thread").c(0).a(new LinkedBlockingQueue()).a();
                }
            }
        }
        return f6112a;
    }
}
