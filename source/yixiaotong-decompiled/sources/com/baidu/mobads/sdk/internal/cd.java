package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class cd extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ cb f1768a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    cd(cb cbVar, Looper looper) {
        super(looper);
        this.f1768a = cbVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String string = message.getData().getString(cb.n);
        bz bzVar = (bz) message.getData().getParcelable(cb.m);
        if (!"OK".equals(string)) {
            this.f1768a.z.a(cb.f1765a, "mOnApkDownloadCompleted: download failed, code: " + string);
            this.f1768a.a(false);
            if (this.f1768a.A) {
                this.f1768a.A = false;
                this.f1768a.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        bu buVar = new bu(bzVar.e(), this.f1768a.y, bzVar);
        try {
            try {
                if (this.f1768a.u != cb.t) {
                    this.f1768a.a(buVar);
                    buVar.a(cb.f());
                    this.f1768a.a(true);
                } else {
                    buVar.a();
                    buVar.a(cb.f());
                    if (cb.p != null) {
                        cb.p.b = bzVar.b();
                    }
                    this.f1768a.l();
                    if (this.f1768a.A) {
                        this.f1768a.A = false;
                        cb cbVar = this.f1768a;
                        cbVar.a(cbVar.p(), "load remote file just downloaded");
                    }
                }
            } catch (cb.a e) {
                String str = "download apk file failed: " + e.toString();
                this.f1768a.a(false);
                this.f1768a.z.a(cb.f1765a, str);
            }
        } finally {
            buVar.delete();
        }
    }
}
