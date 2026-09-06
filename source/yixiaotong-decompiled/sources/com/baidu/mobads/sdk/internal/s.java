package com.baidu.mobads.sdk.internal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile s f1823a;
    private List<aa.a> b = new CopyOnWriteArrayList();

    private s() {
    }

    public static s a() {
        if (f1823a == null) {
            synchronized (s.class) {
                if (f1823a == null) {
                    f1823a = new s();
                }
            }
        }
        return f1823a;
    }

    public void a(aa.a aVar) {
        if (aVar == null || this.b.contains(aVar)) {
            return;
        }
        this.b.add(aVar);
    }

    public void a(int i) {
        for (aa.a aVar : this.b) {
            if (i == 1) {
                aVar.onSuccess();
            } else if (i == 2) {
                aVar.onFailure();
            }
            b(aVar);
        }
    }

    private void b(aa.a aVar) {
        if (this.b.contains(aVar)) {
            this.b.remove(aVar);
        }
    }
}
