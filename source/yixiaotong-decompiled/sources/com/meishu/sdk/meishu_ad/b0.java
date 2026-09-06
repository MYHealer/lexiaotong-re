package com.meishu.sdk.meishu_ad;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b0 extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f5002a;
    public final /* synthetic */ CountDownLatch b;
    public final /* synthetic */ a0 c;

    public b0(a0 a0Var, Bitmap bitmap, CountDownLatch countDownLatch) {
        this.c = a0Var;
        this.f5002a = bitmap;
        this.b = countDownLatch;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            Bitmap bitmap = this.f5002a;
            if (bitmap != null) {
                Bitmap.Config config = bitmap.getConfig();
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                Bitmap bitmapCopy = config == config2 ? this.f5002a : this.f5002a.copy(config2, true);
                if (bitmapCopy != null) {
                    this.c.l.f5096a.getApplicationContext();
                    Bitmap bitmapA = com.meishu.sdk.core.utils.e0.a(bitmapCopy, 25);
                    if (bitmapA != null) {
                        this.c.j.setImageBitmap(bitmapA);
                    }
                }
            }
            this.b.countDown();
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                this.b.countDown();
            }
        }
    }
}
