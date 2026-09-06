package com.adprof.sdk;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cg f1023a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fj f6a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ni f7a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f8a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set f9a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ThreadPoolExecutor f10a;

    public a3(cg cgVar, int i, int i2) {
        this(cgVar, i, i2, new w8(jn.b()));
    }

    public a3(cg cgVar, int i, int i2, fj fjVar) {
        new AtomicInteger();
        this.f9a = new HashSet();
        this.f7a = new ni();
        this.f8a = new ArrayList();
        this.f10a = null;
        this.f1023a = cgVar;
        this.f6a = fjVar;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, 60L, TimeUnit.SECONDS, this.f7a, new np(), new ThreadPoolExecutor.DiscardOldestPolicy());
        this.f10a = threadPoolExecutor;
        this.f7a.f1326a = threadPoolExecutor;
        new HashMap(10);
    }

    public li a(li liVar) {
        if (TextUtils.isEmpty(liVar.m674a())) {
            return null;
        }
        try {
            this.f10a.submit(new dg(this.f1023a, liVar, this.f6a));
            return liVar;
        } catch (Exception e) {
            Log.e("GT-Volley", lp.a("add request error", new Object[0]), e);
            return liVar;
        }
    }
}
