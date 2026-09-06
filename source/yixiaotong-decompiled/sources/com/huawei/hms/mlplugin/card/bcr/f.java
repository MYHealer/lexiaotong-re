package com.huawei.hms.mlplugin.card.bcr;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import com.huawei.hms.ml.camera.CameraExposureData;
import com.huawei.hms.ml.camera.CameraManager;
import com.huawei.hms.ml.common.utils.SmartLog;
import com.huawei.hms.mlplugin.card.bcr.common.CustomInfo;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: DecodeHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CameraManager f4173a;
    private WeakReference<Context> b;
    private CustomInfo c;
    private CustomView.OnSnCheckRule d;

    public f(Context context, CameraManager cameraManager, CustomInfo customInfo, CustomView.OnSnCheckRule onSnCheckRule) {
        this.b = new WeakReference<>(context);
        this.f4173a = cameraManager;
        this.c = customInfo;
        this.d = onSnCheckRule;
    }

    public int a() {
        return this.f4173a.getCameraOrientation();
    }

    public Rect b() {
        return t.a(t.e(this.b.get()), 0.63084f, t.g(this.b.get()));
    }

    public Point c() {
        return this.f4173a.getCameraSize();
    }

    public int d() {
        return this.c.mRecMode;
    }

    public int e() {
        return this.c.mRecType;
    }

    public int f() {
        return this.c.mResultType;
    }

    public Rect g() {
        return this.c.mRect;
    }

    public CustomView.OnSnCheckRule h() {
        return this.d;
    }

    public boolean i() {
        return this.c.mIsCustom;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0063 A[PHI: r8
  0x0063: PHI (r8v15 float) = (r8v3 float), (r8v4 float) binds: [B:22:0x0061, B:25:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    public void a(boolean z) {
        CameraExposureData cameraExposureData = this.f4173a.getCameraExposureData();
        if (cameraExposureData == null) {
            return;
        }
        int maxValue = cameraExposureData.getMaxValue();
        int minValue = cameraExposureData.getMinValue();
        float currentValue = cameraExposureData.getCurrentValue();
        int iCeil = (int) (maxValue > 0 ? Math.ceil(maxValue * 0.5f) : Math.floor(maxValue * 0.5f));
        int iCeil2 = (int) (minValue > 0 ? Math.ceil(minValue * 0.5f) : Math.floor(minValue * 0.5f));
        float fAbs = Math.abs((int) (minValue > 0 ? Math.ceil(iCeil2 * 0.1f) : Math.floor(iCeil2 * 0.1f)));
        float f = currentValue + (z ? fAbs : -fAbs);
        float f2 = iCeil;
        if (Float.compare(f, f2) > 0) {
            f = f2;
        } else {
            f2 = iCeil2;
            if (Float.compare(f, f2) < 0) {
                f = f2;
            }
        }
        this.f4173a.setCameraExposureValue((int) f);
        SmartLog.i("DecodeHelper", "max = " + maxValue + ", min = " + minValue + ", step = " + fAbs + ", current = " + f);
    }
}
