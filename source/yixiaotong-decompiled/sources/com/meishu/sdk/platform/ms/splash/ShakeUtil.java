package com.meishu.sdk.platform.ms.splash;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.q0;
import com.meishu.sdk.core.utils.u0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ShakeUtil {
    public SensorManager c;
    public float e;
    public String h;
    public long i;
    public int indexLocal;
    public MeishuAdInfo.DClickData j;
    public Sensor k;
    public Sensor l;
    public Sensor m;
    public boolean n;
    public List<d> x;
    public List<d> y;
    public List<d> z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5233a = 1;
    public long b = 500;
    public boolean d = false;
    public float[] f = new float[3];
    public List<com.meishu.sdk.platform.ms.splash.c> g = new ArrayList();
    public SensorEventListener o = new a();
    public float p = 0.0f;
    public float q = 0.0f;
    public float r = 0.0f;
    public float s = 0.0f;
    public float t = 0.0f;
    public float u = 0.0f;
    public final float[] v = new float[3];
    public int w = 0;

    public class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                if (sensorEvent.sensor.getType() == 4) {
                    ShakeUtil shakeUtil = ShakeUtil.this;
                    shakeUtil.getClass();
                    try {
                        float f = shakeUtil.e;
                        if (f != 0.0f && shakeUtil.d) {
                            float f2 = sensorEvent.timestamp;
                            if ((f2 - f) * 1.0E-9f >= 10.0f) {
                                shakeUtil.e = f2;
                            }
                            float f3 = (f2 - shakeUtil.e) * 1.0E-9f;
                            float[] fArr = sensorEvent.values;
                            shakeUtil.a(fArr[0], fArr[1], fArr[2], f3);
                        }
                        shakeUtil.e = sensorEvent.timestamp;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (sensorEvent.sensor.getType() == 1 || sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 9) {
                    ShakeUtil.a(ShakeUtil.this, sensorEvent);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ShakeUtil f5235a = new ShakeUtil();
    }

    public interface c {
        void onShake(int i, boolean z, int i2, ShakeResult shakeResult);
    }

    public ShakeUtil() {
        new ArrayList();
        new ArrayList();
        new ArrayList();
        this.x = new ArrayList();
        this.y = new ArrayList();
        this.z = new ArrayList();
    }

    public static void a(ShakeUtil shakeUtil, SensorEvent sensorEvent) {
        shakeUtil.getClass();
        try {
            if (shakeUtil.d) {
                int type = sensorEvent.sensor.getType();
                if (type != 1) {
                    if (type != 4) {
                        if (type != 9) {
                            return;
                        }
                        float[] fArr = sensorEvent.values;
                        shakeUtil.s = fArr[0];
                        shakeUtil.t = fArr[1];
                        shakeUtil.u = fArr[2];
                        return;
                    }
                    for (com.meishu.sdk.platform.ms.splash.c cVar : shakeUtil.g) {
                        int i = cVar.f;
                        if (i == 1 || i == 3 || i == 4 || i == 5) {
                            if (cVar.g && cVar.h == 1 && cVar.b != null && (i == 4 || i == 5)) {
                                if (cVar.s) {
                                    float[] fArr2 = sensorEvent.values;
                                    float f = fArr2[0];
                                    float f2 = fArr2[1];
                                    float f3 = fArr2[2];
                                    if (Math.abs(f) > 2.0f || Math.abs(f2) > 2.0f || Math.abs(f3) > 2.0f) {
                                        shakeUtil.x.add(new d(f, f2, f3, System.currentTimeMillis()));
                                    }
                                }
                            }
                        }
                    }
                    return;
                }
                float[] fArr3 = sensorEvent.values;
                float f4 = fArr3[0];
                shakeUtil.p = f4;
                float f5 = fArr3[1];
                shakeUtil.q = f5;
                float f6 = fArr3[2];
                shakeUtil.r = f6;
                try {
                    float[] fArr4 = shakeUtil.v;
                    float f7 = fArr4[0];
                    if (f7 == 0.0f && fArr4[1] == 0.0f && fArr4[2] == 0.0f) {
                        fArr4[0] = f4;
                        fArr4[1] = f5;
                        fArr4[2] = f6;
                        return;
                    }
                    shakeUtil.w = 0;
                    if (f7 == f4) {
                        shakeUtil.w = 1;
                    }
                    if (fArr4[1] == f5) {
                        shakeUtil.w++;
                    }
                    if (fArr4[2] == f6) {
                        shakeUtil.w++;
                    }
                    if (shakeUtil.w >= 2) {
                        fArr4[0] = f4;
                        fArr4[1] = f5;
                        fArr4[2] = f6;
                        return;
                    }
                    fArr4[0] = f4;
                    fArr4[1] = f5;
                    fArr4[2] = f6;
                    float f8 = f4 - shakeUtil.s;
                    float f9 = f5 - shakeUtil.t;
                    float f10 = f6 - shakeUtil.u;
                    double dSqrt = Math.sqrt((f10 * f10) + (f9 * f9) + (f8 * f8));
                    if ((shakeUtil.s == 0.0f && shakeUtil.t == 0.0f && shakeUtil.u == 0.0f) || (shakeUtil.p == 0.0f && shakeUtil.q == 0.0f && shakeUtil.r == 0.0f)) {
                        dSqrt -= 9.8d;
                    }
                    double dAtan = (dSqrt * 100.0d) / 30.0d;
                    if (80.0d < dAtan) {
                        dAtan = (((Math.atan((dAtan - 80.0d) / 30.0d) * 20.0d) * 2.0d) / 3.141592653589793d) + 80.0d;
                    }
                    shakeUtil.a(dAtan, shakeUtil.p, shakeUtil.q, shakeUtil.r, sensorEvent);
                } catch (Throwable th) {
                    float[] fArr5 = shakeUtil.v;
                    float[] fArr6 = sensorEvent.values;
                    fArr5[0] = fArr6[0];
                    fArr5[1] = fArr6[1];
                    fArr5[2] = fArr6[2];
                    throw th;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ShakeUtil getInstance() {
        return b.f5235a;
    }

    public void a(String str, long j, MeishuAdInfo.DClickData dClickData) {
        this.h = str;
        this.i = j;
        this.j = dClickData;
    }

    public final boolean c() {
        float f;
        try {
            float fMax = 0.0f;
            float fMax2 = 0.0f;
            float fMax3 = 0.0f;
            for (d dVar : this.x) {
                fMax = Math.max(fMax, Math.abs(dVar.f5242a));
                fMax2 = Math.max(fMax2, Math.abs(dVar.b));
                fMax3 = Math.max(fMax3, Math.abs(dVar.c));
            }
            char c2 = (fMax < fMax2 || fMax < fMax3) ? (fMax2 < fMax || fMax2 < fMax3) ? 'Z' : 'Y' : 'X';
            boolean z = false;
            boolean z2 = false;
            for (d dVar2 : this.x) {
                switch (c2) {
                    case 'X':
                        f = dVar2.f5242a;
                        break;
                    case 'Y':
                        f = dVar2.b;
                        break;
                    case 'Z':
                        f = dVar2.c;
                        break;
                    default:
                        f = 0.0f;
                        break;
                }
                if (f > 0.0f) {
                    z = true;
                }
                if (f < 0.0f) {
                    z2 = true;
                }
                if (z && z2) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public final void d() {
        u0.a aVar = u0.f4949a.get(this.h + this.i);
        if (aVar == null) {
            aVar = new u0.a();
            aVar.f4950a = true;
            u0.a(this.h, 5);
            u0.a(this.h, 7);
        } else if (!aVar.b) {
            u0.a(this.h, 5);
            u0.a(this.h, 7);
        }
        u0.f4949a.put(this.h + this.i, aVar);
    }

    public final void b(com.meishu.sdk.platform.ms.splash.c cVar, boolean z, int i, float f, float f2, float f3) {
        try {
            this.d = false;
            this.e = 0.0f;
            float[] fArr = this.f;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            ShakeResult shakeResult = new ShakeResult();
            shakeResult.setTurnX(f);
            shakeResult.setTurnY(f2);
            shakeResult.setTurnZ(f3);
            int i2 = cVar.f;
            if (i2 != 6 && i2 != 7 && i2 != 8) {
                cVar.b.onShake(8, z, i, shakeResult);
            } else {
                cVar.b.onShake(256, z, i, shakeResult);
            }
            this.g.remove(cVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void e() {
        this.n = true;
        SensorManager sensorManager = this.c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.o);
        }
    }

    public void f() {
        try {
            this.n = false;
            SensorManager sensorManager = this.c;
            if (sensorManager != null) {
                this.c.registerListener(this.o, sensorManager.getDefaultSensor(4), 2);
                this.c.registerListener(this.o, this.c.getDefaultSensor(9), 1);
                this.c.registerListener(this.o, this.c.getDefaultSensor(1), 2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int b() {
        return (int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d);
    }

    public void a(int i, int i2, int i3, long j, int i4, int i5, int i6, c cVar) {
        try {
            AdSdk.getContext();
            this.b = j;
            float[] fArr = this.f;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            float[] fArr2 = this.v;
            fArr2[0] = 0.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = 0.0f;
            this.p = 0.0f;
            this.q = 0.0f;
            this.r = 0.0f;
            this.s = 0.0f;
            this.t = 0.0f;
            this.u = 0.0f;
            this.f5233a = i3;
            com.meishu.sdk.platform.ms.splash.c cVar2 = new com.meishu.sdk.platform.ms.splash.c();
            cVar2.h = 1;
            cVar2.i = this.h;
            cVar2.k = this.j;
            cVar2.j = this.i;
            cVar2.m = i4;
            cVar2.f5241a = i5;
            cVar2.c = i6;
            cVar2.b = cVar;
            cVar2.d = i2;
            if (i2 >= 1 && i2 <= 100) {
                double d = (((double) i2) * 90.0d) / 100.0d;
                cVar2.q = d;
                if (d < 2.0d) {
                    cVar2.q = 2.0d;
                }
            } else {
                cVar2.d = 50;
                cVar2.q = 20.0d;
            }
            if (i <= 0 || i > 100) {
                i = cVar2.d;
            }
            cVar2.e = i;
            cVar2.f = i3;
            cVar2.g = true;
            cVar2.b();
            this.g.add(cVar2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.n = false;
    }

    public final void a(double d, float f, float f2, float f3, SensorEvent sensorEvent) {
        try {
            List<com.meishu.sdk.platform.ms.splash.c> list = this.g;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (com.meishu.sdk.platform.ms.splash.c cVar : this.g) {
                int i = cVar.f;
                if (i == 1 || i == 3 || i == 4 || i == 5 || i == 7) {
                    if (cVar.g && cVar.h == 1 && cVar.b != null) {
                        if (i == 4 || i == 5) {
                            long j = q0.g;
                            if (j <= 0) {
                                j = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
                            }
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (jCurrentTimeMillis - cVar.u > j) {
                                this.x.clear();
                                this.y.clear();
                                cVar.t = false;
                                cVar.s = false;
                            }
                            if (!cVar.s) {
                                if (d < cVar.d) {
                                    return;
                                }
                                cVar.s = true;
                                cVar.u = jCurrentTimeMillis;
                            }
                            if (!cVar.t) {
                                if (c() || a(f, f2, f3)) {
                                    cVar.t = true;
                                    this.x.clear();
                                    this.y.clear();
                                    return;
                                }
                                return;
                            }
                            if (d >= cVar.e) {
                                cVar.c();
                                if (cVar.n > cVar.m) {
                                    a(cVar, false, (int) d, f, f2, f3);
                                }
                            } else if (cVar.a() && d >= cVar.o) {
                                cVar.c();
                                if (cVar.n > cVar.m) {
                                    a(cVar, true, (int) d, f, f2, f3);
                                }
                            }
                            this.y.clear();
                            this.x.clear();
                        } else if (d >= cVar.d) {
                            cVar.c();
                            if (cVar.n > cVar.m) {
                                a(cVar, false, (int) d, f, f2, f3);
                            }
                        } else if (cVar.a() && d >= cVar.o) {
                            cVar.c();
                            if (cVar.n > cVar.m) {
                                a(cVar, true, (int) d, f, f2, f3);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean a(float f, float f2, float f3) {
        float fAcos;
        if (this.y.size() == 0) {
            this.y.add(new d(f - this.s, f2 - this.t, f3 - this.u, System.currentTimeMillis()));
        } else {
            List<d> list = this.y;
            d dVar = list.get(list.size() - 1);
            float f4 = dVar.f5242a;
            float f5 = dVar.b;
            float f6 = dVar.c;
            float f7 = f - this.s;
            float f8 = f2 - this.t;
            float f9 = f3 - this.u;
            if ((Math.abs(f4) >= 2.0f || Math.abs(f5) >= 2.0f || Math.abs(f6) >= 2.0f) && (Math.abs(f7) >= 2.0f || Math.abs(f8) >= 2.0f || Math.abs(f9) >= 2.0f)) {
                fAcos = (float) (Math.acos(((double) ((f6 * f9) + ((f5 * f8) + (f4 * f7)))) / (Math.sqrt(Math.pow(f6, 2.0d) + (Math.pow(f5, 2.0d) + Math.pow(f4, 2.0d))) * Math.sqrt(Math.pow(f9, 2.0d) + (Math.pow(f8, 2.0d) + Math.pow(f7, 2.0d))))) * 57.29577951308232d);
            } else {
                fAcos = 0.0f;
            }
            if (fAcos > 60.0f) {
                this.y.add(new d(f - this.s, f2 - this.t, f3 - this.u, System.currentTimeMillis()));
            }
        }
        long j = q0.g;
        if (j <= 0) {
            j = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        }
        if (this.y.size() <= 0) {
            return false;
        }
        Iterator<d> it = this.y.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (System.currentTimeMillis() - it.next().d > j) {
                it.remove();
            } else {
                i++;
            }
        }
        return i >= 5;
    }

    public final void a(com.meishu.sdk.platform.ms.splash.c cVar, boolean z, int i, float f, float f2, float f3) {
        if (z) {
            try {
                d();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.d = false;
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 0.0f;
        ShakeResult shakeResult = new ShakeResult();
        shakeResult.setShakeX(f);
        shakeResult.setShakeY(f2);
        shakeResult.setShakeZ(f3);
        int i2 = cVar.f;
        if (i2 != 4 && i2 != 5) {
            cVar.b.onShake(4, z, i, shakeResult);
        } else {
            cVar.b.onShake(64, z, i, shakeResult);
        }
        this.g.remove(cVar);
    }

    public final void a(float f, float f2, float f3, float f4) {
        float degrees;
        float degrees2;
        float degrees3;
        List<com.meishu.sdk.platform.ms.splash.c> list = this.g;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.meishu.sdk.platform.ms.splash.c cVar : this.g) {
            int i = cVar.f;
            if (i == 2 || i == 3 || i == 5 || i == 6 || i == 7 || i == 8) {
                if (cVar.g && cVar.h == 1 && cVar.b != null) {
                    double d = cVar.q;
                    int i2 = 0;
                    if (i != 6 && i != 7 && i != 8) {
                        float[] fArr = this.f;
                        float f5 = (f * f4) + fArr[0];
                        fArr[0] = f5;
                        fArr[1] = (f2 * f4) + fArr[1];
                        fArr[2] = (f3 * f4) + fArr[2];
                        degrees = (float) Math.toDegrees(f5);
                        degrees3 = (float) Math.toDegrees(this.f[1]);
                        degrees2 = (float) Math.toDegrees(this.f[2]);
                    } else {
                        long j = q0.g;
                        if (j <= 0) {
                            j = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (jCurrentTimeMillis - cVar.u > j) {
                            this.z.clear();
                            cVar.u = jCurrentTimeMillis;
                            cVar.t = false;
                            cVar.s = false;
                            float[] fArr2 = this.f;
                            fArr2[0] = 0.0f;
                            fArr2[1] = 0.0f;
                            fArr2[2] = 0.0f;
                        }
                        float[] fArr3 = this.f;
                        float f6 = (f * f4) + fArr3[0];
                        fArr3[0] = f6;
                        if (f6 * f < 0.0f) {
                            fArr3[0] = 0.0f;
                        }
                        float f7 = (f2 * f4) + fArr3[1];
                        fArr3[1] = f7;
                        if (f7 * f2 < 0.0f) {
                            fArr3[1] = 0.0f;
                        }
                        float f8 = (f3 * f4) + fArr3[2];
                        fArr3[2] = f8;
                        if (f8 * f3 < 0.0f) {
                            fArr3[2] = 0.0f;
                        }
                        float degrees4 = (float) Math.toDegrees(fArr3[0]);
                        float degrees5 = (float) Math.toDegrees(this.f[1]);
                        float degrees6 = (float) Math.toDegrees(this.f[2]);
                        cVar.a();
                        double d2 = cVar.q;
                        double d3 = cVar.e;
                        if (Math.abs(degrees4) > 2.0f || Math.abs(degrees5) > 2.0f || Math.abs(degrees6) > 2.0f) {
                            this.z.add(new d(degrees4, degrees5, degrees6, System.currentTimeMillis()));
                        }
                        if (this.z.isEmpty()) {
                            return;
                        }
                        long j2 = q0.g;
                        long j3 = j2 > 0 ? j2 : C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
                        Iterator<d> it = this.z.iterator();
                        double d4 = d2;
                        double d5 = d4;
                        double d6 = d5;
                        int i3 = 0;
                        int i4 = 0;
                        while (it.hasNext()) {
                            d next = it.next();
                            degrees5 = degrees5;
                            if (System.currentTimeMillis() - next.d > j3) {
                                it.remove();
                            } else {
                                float f9 = next.f5242a;
                                float f10 = next.b;
                                float f11 = next.c;
                                float f12 = degrees6;
                                if (Math.abs(f9) > d4) {
                                    i2 = f9 > 0.0f ? i2 | 1 : i2 | 2;
                                    d4 = d3;
                                }
                                if (Math.abs(f10) > d5) {
                                    i3 = f10 > 0.0f ? i3 | 1 : i3 | 2;
                                    d5 = d3;
                                }
                                if (Math.abs(f11) > d6) {
                                    i4 = f11 > 0.0f ? i4 | 1 : i4 | 2;
                                    d6 = d3;
                                }
                                if (i2 == 3 || i3 == 3 || i4 == 3) {
                                    d = cVar.e;
                                    this.z.clear();
                                    degrees = degrees4;
                                    degrees2 = f12;
                                    degrees3 = degrees5;
                                } else {
                                    degrees6 = f12;
                                }
                            }
                        }
                        return;
                    }
                    int iMax = Math.max((int) Math.abs(degrees), Math.max((int) Math.abs(degrees3), (int) Math.abs(degrees2)));
                    double d7 = iMax;
                    if (d7 >= d) {
                        cVar.c();
                        if (cVar.n > cVar.m) {
                            b(cVar, false, (iMax * 100) / 90, degrees, degrees3, degrees2);
                        }
                    } else if (cVar.a()) {
                        if (d7 >= cVar.p) {
                            cVar.c();
                        }
                        if (cVar.n > cVar.m) {
                            d();
                            b(cVar, true, (iMax * 100) / 90, degrees, degrees3, degrees2);
                        }
                    }
                }
            }
        }
    }

    public void a(boolean z) {
        this.d = z;
        try {
            new Handler().postDelayed(new e(this), this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(int i, boolean z) {
        List<com.meishu.sdk.platform.ms.splash.c> list = this.g;
        if (list == null || list.size() == 0) {
            return;
        }
        boolean z2 = true;
        for (com.meishu.sdk.platform.ms.splash.c cVar : this.g) {
            if (i == cVar.f5241a) {
                cVar.g = z;
            }
            if (cVar.g) {
                z2 = false;
            }
        }
        if (z2) {
            e();
        } else {
            f();
        }
        SdkHandler.getInstance().postDelay(new f(this), 1000L);
    }

    public void a(int i) {
        List<com.meishu.sdk.platform.ms.splash.c> list = this.g;
        if (list != null && list.size() != 0) {
            Iterator<com.meishu.sdk.platform.ms.splash.c> it = this.g.iterator();
            while (it.hasNext()) {
                if (i == it.next().f5241a) {
                    it.remove();
                }
            }
            SdkHandler.getInstance().postDelay(new f(this), 1000L);
            return;
        }
        a();
    }

    public void a() {
        this.d = false;
        this.n = false;
        float[] fArr = this.f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        this.e = 0.0f;
        List<d> list = this.x;
        if (list != null) {
            list.clear();
        }
        List<d> list2 = this.z;
        if (list2 != null) {
            list2.clear();
        }
        List<d> list3 = this.y;
        if (list3 != null) {
            list3.clear();
        }
        SensorManager sensorManager = this.c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.o);
            this.c = null;
            this.l = null;
            this.m = null;
            this.k = null;
        }
        List<com.meishu.sdk.platform.ms.splash.c> list4 = this.g;
        if (list4 != null) {
            list4.clear();
        }
        float[] fArr2 = this.v;
        fArr2[0] = 0.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 0.0f;
    }
}
