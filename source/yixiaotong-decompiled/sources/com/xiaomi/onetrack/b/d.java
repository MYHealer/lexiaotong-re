package com.xiaomi.onetrack.b;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9451a;
    public final /* synthetic */ a.b b;

    public d(a.b bVar, String str) {
        this.b = bVar;
        this.f9451a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b((List<String>) Arrays.asList(this.f9451a));
        a.A.put(this.f9451a, Boolean.FALSE);
    }
}
