package com.huawei.hms.scankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import client.android.yixiaotong.sdk.qrcode.decode.DecodeThread;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.d7;
import com.huawei.hms.scankit.p.f1;
import com.huawei.hms.scankit.p.g0;
import com.huawei.hms.scankit.p.m4;
import com.huawei.hms.scankit.p.n4;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.x5;
import com.huawei.hms.scankit.p.y5;
import com.huawei.hms.scankit.p.z5;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: CaptureHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a extends Handler implements z5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n4 f4184a;
    private d b;
    private final int c;
    private EnumC0528a d;
    private Context e;
    private final g0 f;
    private final ViewfinderView g;
    private boolean h;
    private boolean i;
    private boolean j;
    private m4 k;
    private boolean l;

    /* JADX INFO: renamed from: com.huawei.hms.scankit.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CaptureHandler.java */
    private enum EnumC0528a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    a(Context context, ViewfinderView viewfinderView, n4 n4Var, Collection<BarcodeFormat> collection, Map<f1, ?> map, String str, g0 g0Var, Rect rect, int i, boolean z, boolean z2) {
        this.g = viewfinderView;
        this.f4184a = n4Var;
        this.c = i;
        this.e = context;
        d dVar = new d(context, g0Var, this, collection, map, str, this);
        this.b = dVar;
        dVar.a(rect);
        this.b.a(z2);
        this.b.start();
        this.l = z;
        g0Var.a(new j(this.b));
        this.d = EnumC0528a.SUCCESS;
        this.f = g0Var;
        g0Var.p();
        x3.a("scan-time", "start preview time:" + System.currentTimeMillis());
        f();
        x5.c(null);
    }

    public void a(m4 m4Var) {
        this.k = m4Var;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public int b() {
        return this.c;
    }

    public void b(boolean z) {
        this.j = z;
    }

    public void c(boolean z) {
        this.h = z;
    }

    public boolean c() {
        return this.i;
    }

    public boolean d() {
        return this.j;
    }

    public void e() {
        this.d = EnumC0528a.DONE;
        this.f.q();
        Message.obtain(this.b.a(), R.id.scankit_quit).sendToTarget();
        try {
            this.b.b();
            this.b.join(50L);
        } catch (InterruptedException unused) {
            x3.d("CaptureHandler", "quitSynchronously   wait interrupt");
        }
        this.b = null;
        removeMessages(R.id.scankit_decode_succeeded);
        removeMessages(R.id.scankit_decode_failed);
    }

    public void f() {
        if (this.d == EnumC0528a.SUCCESS) {
            this.d = EnumC0528a.PREVIEW;
            this.f.o();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HmsScan hmsScan;
        int i = message.what;
        if (i == R.id.scankit_restart_preview) {
            f();
            return;
        }
        if (i != R.id.scankit_decode_succeeded) {
            if (i == R.id.scankit_decode_failed) {
                this.d = EnumC0528a.PREVIEW;
                this.f.o();
                return;
            }
            return;
        }
        this.d = EnumC0528a.SUCCESS;
        Object obj = message.obj;
        if (obj instanceof HmsScan[]) {
            HmsScan[] hmsScanArr = (HmsScan[]) obj;
            if (hmsScanArr.length <= 0 || (hmsScan = hmsScanArr[0]) == null || TextUtils.isEmpty(hmsScan.originalValue)) {
                x3.c("CaptureHandler", "retrieve  HmsScan lenth is 0");
            } else {
                x3.c("CaptureHandler", "scan successful");
                Bitmap bitmapDecodeByteArray = null;
                float f = 0.0f;
                if (this.i) {
                    x3.c("CaptureHandler", "scan successful & return bitmap");
                    Bundle data = message.getData();
                    if (data != null) {
                        byte[] byteArray = data.getByteArray(DecodeThread.BARCODE_BITMAP);
                        f = data.getFloat("barcode_scaled_factor", 0.0f);
                        if (byteArray != null && byteArray.length > 0) {
                            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                        }
                    }
                    this.f4184a.a(hmsScanArr, bitmapDecodeByteArray, f);
                } else {
                    this.f4184a.a(hmsScanArr, null, 0.0f);
                }
                if (!this.l) {
                    return;
                }
            }
            f();
        }
    }

    private y5 b(y5 y5Var) {
        float fB;
        float fC;
        int iMax;
        Point pointB = d7.b(this.e);
        Point pointE = this.f.e();
        int i = pointB.x;
        int i2 = pointB.y;
        if (i < i2) {
            float f = (i * 1.0f) / pointE.y;
            float f2 = (i2 * 1.0f) / pointE.x;
            fB = (y5Var.b() * f) - (Math.max(pointB.x, pointE.y) / 2.0f);
            fC = y5Var.c() * f2;
            iMax = Math.min(pointB.y, pointE.x);
        } else {
            float f3 = (i * 1.0f) / pointE.x;
            float f4 = (i2 * 1.0f) / pointE.y;
            fB = (y5Var.b() * f3) - (Math.min(pointB.y, pointE.y) / 2.0f);
            fC = y5Var.c() * f4;
            iMax = Math.max(pointB.x, pointE.x);
        }
        return new y5(fB, fC - (iMax / 2.0f));
    }

    public boolean a() {
        m4 m4Var = this.k;
        if (m4Var != null) {
            return m4Var.a();
        }
        return false;
    }

    @Override // com.huawei.hms.scankit.p.z5
    public void a(y5 y5Var) {
        if (this.g != null) {
            this.g.a(b(y5Var));
        }
    }
}
