package com.alipay.sdk.widget;

import com.alipay.sdk.widget.a.AlertDialogC0084a;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f1672a;

    b(a aVar) {
        this.f1672a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1672a.e == null) {
            a aVar = this.f1672a;
            a aVar2 = this.f1672a;
            aVar.e = aVar2.new AlertDialogC0084a(aVar2.f);
            this.f1672a.e.setCancelable(this.f1672a.k);
        }
        try {
            if (this.f1672a.e.isShowing()) {
                return;
            }
            this.f1672a.e.show();
            this.f1672a.l.sendEmptyMessageDelayed(1, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        } catch (Exception e) {
            com.alipay.sdk.util.c.a(e);
        }
    }
}
