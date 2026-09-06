package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import com.yxcorp.kuaishou.addfp.android.a.c;
import com.yxcorp.kuaishou.addfp.android.b.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ KWEGIDDFP f9690a;

    a(KWEGIDDFP kwegiddfp) {
        this.f9690a = kwegiddfp;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f9690a.mParamContext == null) {
                this.f9690a.mCallBack.onFailed(-3, "parameter error");
                return;
            }
            Context unused = this.f9690a.mParamContext;
            int i = e.c;
            if (Build.VERSION.SDK_INT >= 28) {
                e.a();
            }
            KWEGIDDFP kwegiddfp = this.f9690a;
            kwegiddfp.mPkgName = kwegiddfp.mParamContext.getPackageName();
            c.c().b(this.f9690a.mPkgName);
            KWEGIDDFP kwegiddfp2 = this.f9690a;
            kwegiddfp2.getEGid(kwegiddfp2.mCallBack);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
