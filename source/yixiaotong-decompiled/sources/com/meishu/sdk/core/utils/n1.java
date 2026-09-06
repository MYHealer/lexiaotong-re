package com.meishu.sdk.core.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ThreadSerialManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Runnable> f4924a;
    public Object b;
    public int c;
    public volatile boolean d;

    public n1() {
        this(null, 2);
    }

    public n1(Object obj, int i) {
        this.b = new Object();
        this.c = 2;
        if (i > 0) {
            this.c = i;
        } else {
            this.c = Integer.MAX_VALUE;
        }
        this.f4924a = Collections.synchronizedList(new ArrayList());
    }

    public final void a() {
        try {
            Runnable runnable = this.f4924a.get(0);
            try {
                synchronized (this.b) {
                    try {
                        try {
                            runnable.run();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            this.f4924a.remove(runnable);
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
    }
}
