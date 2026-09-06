package com.meishu.sdk.platform.ms.splash;

import android.hardware.SensorManager;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: compiled from: ShakeUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShakeUtil f5243a;

    public e(ShakeUtil shakeUtil) {
        this.f5243a = shakeUtil;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            if (this.f5243a.c == null && AdSdk.getContext() != null) {
                this.f5243a.c = (SensorManager) AdSdk.getContext().getSystemService("sensor");
            }
            ShakeUtil shakeUtil = this.f5243a;
            SensorManager sensorManager = shakeUtil.c;
            if (sensorManager != null) {
                int i = shakeUtil.f5233a;
                if (i == 2 || i == 6) {
                    if (shakeUtil.k == null) {
                        shakeUtil.k = sensorManager.getDefaultSensor(4);
                    }
                    ShakeUtil shakeUtil2 = this.f5243a;
                    shakeUtil2.c.registerListener(shakeUtil2.o, shakeUtil2.k, 2);
                } else if (i == 1 || i == 4) {
                    if (shakeUtil.l == null) {
                        shakeUtil.l = sensorManager.getDefaultSensor(9);
                    }
                    ShakeUtil shakeUtil3 = this.f5243a;
                    if (shakeUtil3.m == null) {
                        shakeUtil3.m = shakeUtil3.c.getDefaultSensor(1);
                    }
                    ShakeUtil shakeUtil4 = this.f5243a;
                    if (shakeUtil4.k == null) {
                        shakeUtil4.k = shakeUtil4.c.getDefaultSensor(4);
                    }
                    ShakeUtil shakeUtil5 = this.f5243a;
                    shakeUtil5.c.registerListener(shakeUtil5.o, shakeUtil5.l, 1);
                    ShakeUtil shakeUtil6 = this.f5243a;
                    shakeUtil6.c.registerListener(shakeUtil6.o, shakeUtil6.k, 2);
                    ShakeUtil shakeUtil7 = this.f5243a;
                    shakeUtil7.c.registerListener(shakeUtil7.o, shakeUtil7.m, 2);
                } else if (i == 3 || i == 5 || i == 7 || i == 8) {
                    if (shakeUtil.k == null) {
                        shakeUtil.k = sensorManager.getDefaultSensor(4);
                    }
                    ShakeUtil shakeUtil8 = this.f5243a;
                    shakeUtil8.c.registerListener(shakeUtil8.o, shakeUtil8.k, 2);
                    ShakeUtil shakeUtil9 = this.f5243a;
                    if (shakeUtil9.l == null) {
                        shakeUtil9.l = shakeUtil9.c.getDefaultSensor(9);
                    }
                    ShakeUtil shakeUtil10 = this.f5243a;
                    shakeUtil10.c.registerListener(shakeUtil10.o, shakeUtil10.l, 1);
                    ShakeUtil shakeUtil11 = this.f5243a;
                    if (shakeUtil11.m == null) {
                        shakeUtil11.m = shakeUtil11.c.getDefaultSensor(1);
                    }
                    ShakeUtil shakeUtil12 = this.f5243a;
                    shakeUtil12.c.registerListener(shakeUtil12.o, shakeUtil12.m, 2);
                }
                ShakeUtil shakeUtil13 = this.f5243a;
                if (shakeUtil13.n) {
                    shakeUtil13.c.unregisterListener(shakeUtil13.o);
                    LogUtil.dev("ShakeUtil", "initSensorPause");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
