package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.os.Bundle;
import com.byazt.x.c;
import com.byazt.z.DownloadHandlerService;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DownloadHandleNotificationActivity extends Activity {
    private static final String[] c;
    private DownloadHandlerService tt = new DownloadHandlerService();

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    static {
        StubApp.interface11(41997);
        c = new String[]{x.cK};
    }

    private void c() {
        try {
            requestPermissions(c, 1000);
        } catch (Throwable th) {
            c.tt("DownloadNotificationJumpActivity", "requestNotificationPermissionError:".concat(String.valueOf(th)));
        }
    }
}
