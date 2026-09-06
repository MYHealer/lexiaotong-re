package com.huawei.hms.ml.camera;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.huawei.hms.mlkit.common.ha.HianalyticsLog;
import com.huawei.hms.mlkit.common.ha.HianalyticsLogProvider;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: compiled from: HiAnalyticsThread.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class g extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f4134a;
    public Handler b;

    public g(Context context) {
        this.f4134a = new WeakReference<>(context);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.b = new a(this.f4134a);
        Looper.loop();
    }

    /* JADX INFO: compiled from: HiAnalyticsThread.java */
    public static class a extends Handler {
        public WeakReference<Context> b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4135a = true;
        public HashMap<String, HianalyticsLog> c = new HashMap<>();

        public a(WeakReference<Context> weakReference) {
            this.b = weakReference;
        }

        public final HianalyticsLog a(String str) {
            String string;
            Bundle bundle = null;
            if (HianalyticsLogProvider.getInstance().sdkForbiddenHiLog(this.b.get())) {
                return null;
            }
            com.huawei.hms.ml.camera.a aVar = new com.huawei.hms.ml.camera.a(this.b.get());
            if (aVar.f4127a.get() != null) {
                bundle = new Bundle();
                bundle.putString("packageName", aVar.f4127a.get().getPackageName() == null ? "camera.cannot.get.package.name" : aVar.f4127a.get().getPackageName());
                bundle.putString("appid", "com.huawei.hms.ml.camera");
                bundle.putString("com.huawei.hms.client.service.name:ml-computer-vision", "ml-computer-vision:3.7.0.302");
                Context context = aVar.f4127a.get();
                try {
                    PackageManager packageManager = context.getPackageManager();
                    string = packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
                } catch (PackageManager.NameNotFoundException | RuntimeException e) {
                    Log.e("com.huawei.hms.ml.camera.a", "readManifest failed:" + e.getMessage());
                    string = "";
                }
                bundle.putString("appName", string);
                bundle.putBoolean("openHa", aVar.a(aVar.f4127a.get()));
                bundle.putString("countryCode", new CountryCodeBean(aVar.f4127a.get(), false).getCountryCode());
            }
            return HianalyticsLogProvider.getInstance().logBegin(this.b.get(), bundle).setModuleName(str).setApiName(str).setApkVersion("3.7.0.302");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f4135a) {
                int i = message.what;
                if (i == R.id.mlkit_camera_preview_ha_begin) {
                    this.c.put("preview", a((String) message.obj));
                    return;
                }
                if (i == R.id.mlkit_camera_preview_ha_end) {
                    HianalyticsLog hianalyticsLog = this.c.get("preview");
                    if (hianalyticsLog != null) {
                        HianalyticsLogProvider.getInstance().logEnd(hianalyticsLog);
                    }
                    this.c.put("preview", null);
                    return;
                }
                if (i == R.id.mlkit_camera_picture_ha_begin) {
                    this.c.put("picture", a((String) message.obj));
                    return;
                }
                if (i == R.id.mlkit_camera_picture_ha_end) {
                    HianalyticsLog hianalyticsLog2 = this.c.get("picture");
                    if (hianalyticsLog2 != null) {
                        HianalyticsLogProvider.getInstance().logEnd(hianalyticsLog2);
                    }
                    this.c.put("picture", null);
                    return;
                }
                if (i == R.id.mlkit_camera_ha_quit) {
                    this.f4135a = false;
                    Looper.myLooper().quit();
                } else {
                    Log.w(CameraManager.TAG, "HiAnalyticsThread::handleMessage unknown message");
                }
            }
        }
    }
}
