package com.huawei.hms.mlplugin.card.bcr;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.ml.camera.CameraManager;
import com.huawei.hms.ml.common.utils.SmartLog;
import com.huawei.hms.mlplugin.card.bcr.common.CustomInfo;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: CaptureActivityHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a extends Handler {
    private static final String g = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CameraManager f4164a;
    private final WeakReference<Context> b;
    private g c;
    private f d;
    private final h e;
    private CustomInfo f;

    public a(Context context, CameraManager cameraManager, h hVar, CustomInfo customInfo, CustomView.OnSnCheckRule onSnCheckRule) {
        this.f4164a = cameraManager;
        this.b = new WeakReference<>(context);
        this.e = hVar;
        this.f = customInfo;
        this.d = new f(context, cameraManager, customInfo, onSnCheckRule);
    }

    public void a() {
        g gVar = new g(this.b.get(), this);
        this.c = gVar;
        gVar.a(this.d);
        this.c.start();
        this.f4164a.setFrameCallback(new d(this.c));
        d();
    }

    public void b() {
        this.f4164a.stopPreview();
        Message.obtain(this.c.a(), R.id.mlkit_bcr_quit).sendToTarget();
        try {
            this.c.join(500L);
        } catch (InterruptedException e) {
            SmartLog.e(g, "InterruptedException e = " + e.getMessage());
        }
        removeMessages(R.id.mlkit_bcr_decode_succeeded);
        removeMessages(R.id.mlkit_bcr_decode_failed);
    }

    public void c() {
        this.f4164a.requestFocus(1000);
    }

    public void d() {
        this.f4164a.startPreview();
        this.f4164a.requestPreviewFrame();
        c();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == R.id.mlkit_bcr_decode_succeeded) {
            if (!this.f.mIsCustom) {
                ((CaptureActivity) this.b.get()).a((MLBcrCaptureResult) message.obj);
                return;
            } else if (this.d.e() == 1) {
                this.e.a((MLSnCaptureResult) message.obj);
                return;
            } else {
                this.e.a((MLBcrCaptureResult) message.obj);
                return;
            }
        }
        if (i == R.id.mlkit_bcr_decode_failed) {
            this.f4164a.requestPreviewFrame();
        } else if (i == R.id.mlkit_bcr_rec_failed) {
            if (this.f.mIsCustom) {
                this.e.a((MLBcrCaptureResult) message.obj);
            } else {
                ((CaptureActivity) this.b.get()).b((MLBcrCaptureResult) message.obj);
            }
        }
    }
}
