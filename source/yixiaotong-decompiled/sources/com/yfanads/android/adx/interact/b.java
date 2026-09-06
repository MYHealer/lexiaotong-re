package com.yfanads.android.adx.interact;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: ShakeDetector.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f9604a = 11.0f;
    public final C1173b b = new C1173b();
    public final a c;
    public SensorManager d;
    public Sensor e;

    /* JADX INFO: compiled from: ShakeDetector.java */
    public interface a {
    }

    /* JADX INFO: renamed from: com.yfanads.android.adx.interact.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ShakeDetector.java */
    public static class C1173b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C1174b f9605a = new C1174b();
        public a b;
        public a c;
        public int d;
        public int e;

        /* JADX INFO: renamed from: com.yfanads.android.adx.interact.b$b$a */
        /* JADX INFO: compiled from: ShakeDetector.java */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f9606a;
            public boolean b;
            public a c;
        }

        /* JADX INFO: renamed from: com.yfanads.android.adx.interact.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ShakeDetector.java */
        public static class C1174b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public a f9607a;
        }
    }

    public b(com.yfanads.android.adx.interact.a aVar) {
        this.c = aVar;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i;
        C1173b.a aVar;
        C1173b c1173b;
        C1173b.a aVar2;
        float[] fArr = sensorEvent.values;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        double d = (f3 * f3) + (f2 * f2) + (f * f);
        float f4 = this.f9604a;
        boolean z = d > ((double) (f4 * f4));
        long j = sensorEvent.timestamp;
        C1173b c1173b2 = this.b;
        long j2 = j - 500000000;
        while (true) {
            i = c1173b2.d;
            if (i < 4 || (aVar2 = c1173b2.b) == null || j2 - aVar2.f9606a <= 0) {
                break;
            }
            if (aVar2.b) {
                c1173b2.e--;
            }
            c1173b2.d = i - 1;
            C1173b.a aVar3 = aVar2.c;
            c1173b2.b = aVar3;
            if (aVar3 == null) {
                c1173b2.c = null;
            }
            C1173b.C1174b c1174b = c1173b2.f9605a;
            aVar2.c = c1174b.f9607a;
            c1174b.f9607a = aVar2;
        }
        C1173b.C1174b c1174b2 = c1173b2.f9605a;
        C1173b.a aVar4 = c1174b2.f9607a;
        if (aVar4 == null) {
            aVar4 = new C1173b.a();
        } else {
            c1174b2.f9607a = aVar4.c;
        }
        aVar4.f9606a = j;
        aVar4.b = z;
        aVar4.c = null;
        C1173b.a aVar5 = c1173b2.c;
        if (aVar5 != null) {
            aVar5.c = aVar4;
        }
        c1173b2.c = aVar4;
        if (c1173b2.b == null) {
            c1173b2.b = aVar4;
        }
        c1173b2.d = i + 1;
        if (z) {
            c1173b2.e++;
        }
        C1173b c1173b3 = this.b;
        C1173b.a aVar6 = c1173b3.c;
        if (aVar6 == null || (aVar = c1173b3.b) == null || aVar6.f9606a - aVar.f9606a < 250000000 || c1173b3.e < (c1173b3.d >> 1)) {
            return;
        }
        float f5 = sensorEvent.values[0];
        a aVar7 = this.c;
        int i2 = f5 > 0.0f ? 0 : 1;
        ThreadPoolExecutor threadPoolExecutor = com.yfanads.android.adx.utils.b.f9622a;
        String[] strArr = new String[5];
        try {
            strArr[0] = String.valueOf(((int) f5) * 100);
            strArr[1] = String.valueOf(((int) sensorEvent.values[1]) * 100);
            strArr[2] = String.valueOf(((int) sensorEvent.values[2]) * 100);
            while (true) {
                C1173b.a aVar8 = c1173b.b;
                if (aVar8 == null) {
                    c1173b.c = null;
                    c1173b.d = 0;
                    c1173b.e = 0;
                    return;
                } else {
                    c1173b.b = aVar8.c;
                    C1173b.C1174b c1174b3 = c1173b.f9605a;
                    aVar8.c = c1174b3.f9607a;
                    c1174b3.f9607a = aVar8;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.yfanads.android.adx.interact.a aVar9 = (com.yfanads.android.adx.interact.a) aVar7;
        aVar9.getClass();
        com.yfanads.android.adx.utils.a.a("action hearShake " + i2 + PPSLabelView.Code + Arrays.toString(strArr));
        aVar9.a(i2, 1, strArr);
        c1173b = this.b;
    }

    public final void a(SensorManager sensorManager) {
        if (this.e != null) {
            return;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        this.e = defaultSensor;
        if (defaultSensor != null) {
            this.d = sensorManager;
            sensorManager.registerListener(this, defaultSensor, 1);
        }
    }

    public final void a() {
        if (this.e != null) {
            C1173b c1173b = this.b;
            while (true) {
                C1173b.a aVar = c1173b.b;
                if (aVar == null) {
                    break;
                }
                c1173b.b = aVar.c;
                C1173b.C1174b c1174b = c1173b.f9605a;
                aVar.c = c1174b.f9607a;
                c1174b.f9607a = aVar;
            }
            c1173b.c = null;
            c1173b.d = 0;
            c1173b.e = 0;
            SensorManager sensorManager = this.d;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this, this.e);
            }
            this.d = null;
            this.e = null;
        }
    }
}
