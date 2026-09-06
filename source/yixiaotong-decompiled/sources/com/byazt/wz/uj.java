package com.byazt.wz;

import android.app.Activity;
import android.content.Context;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.omf.or;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 65, 15})
public abstract class uj implements com.byazt.pop.ve {
    public WeakReference<com.byazt.ua.c.InterfaceC0286c> p;
    public boolean yv = true;

    @Override // com.byazt.pop.ve
    public void c(Activity activity, boolean z) {
    }

    @Override // com.byazt.pop.ve
    public void c(boolean z) {
        this.yv = z;
    }

    @Override // com.byazt.pop.ve
    public void c(com.byazt.ua.c.InterfaceC0286c interfaceC0286c) {
        this.p = new WeakReference<>(interfaceC0286c);
    }

    public boolean c(Context context, ic icVar, String str) {
        if (!this.yv || !com.byazt.aas.n.c(icVar) || !or.c(context, icVar, nb.uj(str), str, x())) {
            return false;
        }
        TTNativePageActivity.c(this);
        return true;
    }

    private String x() {
        com.byazt.ua.c.InterfaceC0286c interfaceC0286c;
        com.byazt.ua.c videoModel;
        WeakReference<com.byazt.ua.c.InterfaceC0286c> weakReference = this.p;
        if (weakReference == null || (interfaceC0286c = weakReference.get()) == null || (videoModel = interfaceC0286c.getVideoModel()) == null) {
            return null;
        }
        return videoModel.c().toString();
    }

    public int gt() {
        return hashCode();
    }
}
