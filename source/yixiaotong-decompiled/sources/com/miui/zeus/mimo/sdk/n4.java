package com.miui.zeus.mimo.sdk;

import android.widget.Toast;
import com.miui.zeus.mimo.sdk.download.AutoDownloadController;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class n4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AutoDownloadController f5536a;

    public n4(AutoDownloadController autoDownloadController) {
        this.f5536a = autoDownloadController;
    }

    @Override // java.lang.Runnable
    public void run() {
        AutoDownloadController autoDownloadController = this.f5536a;
        if (autoDownloadController.b == -4) {
            autoDownloadController.getClass();
            Toast.makeText(y8.f5752a, ijiami_1011.s.s.s.d(new byte[]{-35, -39, -69, -33, -113, -118, -124, -64, -41, -118, -123, -64}, "9a0727"), 0).show();
        }
    }
}
