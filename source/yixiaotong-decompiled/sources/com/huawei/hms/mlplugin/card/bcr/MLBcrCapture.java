package com.huawei.hms.mlplugin.card.bcr;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.widget.Toast;
import client.android.yixiaotong.util.permission.PermissionUtil;
import com.huawei.hms.ml.common.utils.SmartLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class MLBcrCapture {
    private static final String g = "MLBcrCapture";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MLBcrCaptureResult f4158a;
    private Callback b;
    private int c;
    private int d;
    private boolean e;
    private MLBcrCaptureConfig f;

    public interface Callback {
        void onCanceled();

        void onDenied();

        void onFailure(int i, Bitmap bitmap);

        void onSuccess(MLBcrCaptureResult mLBcrCaptureResult);
    }

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static MLBcrCapture f4159a = new MLBcrCapture(null);

        public static MLBcrCapture a() {
            return f4159a;
        }
    }

    /* synthetic */ MLBcrCapture(a aVar) {
        this();
    }

    public static synchronized MLBcrCapture c() {
        return b.a();
    }

    public MLBcrCaptureConfig a() {
        return this.f;
    }

    public void a(int i) {
        this.c = i;
    }

    void a(MLBcrCaptureConfig mLBcrCaptureConfig) {
        this.f = mLBcrCaptureConfig;
    }

    void a(MLBcrCaptureResult mLBcrCaptureResult) {
        this.f4158a = mLBcrCaptureResult;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void captureFrame(Context context, Callback callback) {
        if (!a(context, Arrays.asList(PermissionUtil.PERSSION_CAMERA))) {
            Toast.makeText(context, R.string.mlkit_bcr_permission_tip, 1).show();
            return;
        }
        boolean z = this.e;
        if (z) {
            return;
        }
        this.b = callback;
        this.f4158a = null;
        this.c = -1;
        if (z) {
            return;
        }
        this.e = true;
        try {
            context.startActivity(new Intent(context, (Class<?>) CaptureActivity.class));
        } catch (Exception unused) {
            SmartLog.e(g, "Exception : open camera faild.");
            this.b.onDenied();
        }
    }

    private MLBcrCapture() {
        this.d = -1;
        this.e = false;
        this.f = new MLBcrCaptureConfig.Factory().create();
    }

    private boolean a(Context context, List<String> list) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (packageManager.checkPermission(it.next(), packageName) == -1) {
                return false;
            }
        }
        return true;
    }

    public void b() {
        Callback callback = this.b;
        if (callback != null) {
            int i = this.c;
            if (i == -2) {
                callback.onCanceled();
            } else if (i == -1) {
                int i2 = this.d;
                MLBcrCaptureResult mLBcrCaptureResult = this.f4158a;
                callback.onFailure(i2, mLBcrCaptureResult == null ? null : mLBcrCaptureResult.getOriginalBitmap());
            } else if (i == 0) {
                callback.onSuccess(this.f4158a);
            }
            this.b = null;
        }
        this.f4158a = null;
        a(-1);
    }
}
