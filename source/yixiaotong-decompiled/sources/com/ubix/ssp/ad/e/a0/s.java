package com.ubix.ssp.ad.e.a0;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
import com.stub.StubApp;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class s implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ScheduledExecutorService f8725a;
    float A;
    float B;
    float C;
    private float D;
    private float E;
    private float F;
    private c G;
    private boolean H;
    private boolean I;
    private boolean J;
    private float K;
    boolean L;
    private float M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private boolean V;
    private boolean W;
    private Context b;
    private SensorManager c;
    private Sensor d;
    private Sensor e;
    private float f;
    private float g;
    private float h;
    private boolean i;
    private boolean j;
    private boolean k;
    long l;
    public double m;
    public int n;
    private e o;
    private ObjectAnimator p;
    int[] q;
    boolean r;
    private long s;
    d[] t;
    long u;
    boolean v;
    float w;
    private int x;
    private double y;
    private long z;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f8726a;

        a(ImageView imageView) {
            this.f8726a = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (s.this.p != null) {
                    s.this.p.cancel();
                    s.this.p.removeAllListeners();
                    s.this.p = null;
                }
            } catch (Throwable unused) {
            }
            ImageView imageView = this.f8726a;
            imageView.setPivotX(imageView.getWidth());
            ImageView imageView2 = this.f8726a;
            imageView2.setPivotY(imageView2.getWidth());
            s.this.p = ObjectAnimator.ofFloat(this.f8726a, Key.ROTATION, 0.0f, 2.0f, -6.0f, 6.0f, -6.0f, 3.0f, 0.0f);
            s.this.p.setStartDelay(500L);
            s.this.p.setDuration(1800L);
            s.this.p.setInterpolator(new AccelerateDecelerateInterpolator());
            s.this.p.setRepeatCount(-1);
            s.this.p.start();
        }
    }

    class b implements ThreadFactory {
        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Ubix.SSMonitorThread");
        }
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8728a;

        public c(String str) {
            this.f8728a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (s.this.V && s.this.W && TextUtils.isEmpty(this.f8728a)) {
                    return;
                }
                Bundle bundleA = s.this.a(this.f8728a, "{\"acc\":" + s.this.V + ",\"angle\":" + s.this.W + com.alipay.sdk.util.i.d);
                if (s.this.o != null) {
                    s.this.o.a(bundleA);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class d {
        private float d;
        private long[] e;
        private int[] f;
        private float[] g;
        private boolean h;
        private int i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f8729a = 0.0f;
        private float b = 0.0f;
        private float c = 0.0f;
        private long j = 0;
        private int k = 0;
        private float l = 0.0f;
        private float m = 0.0f;

        public d(int i, float f) {
            this.d = f;
            this.e = new long[i];
            this.f = new int[i];
            this.g = new float[i];
        }

        private int a(boolean z) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (z) {
                return 1;
            }
            long j = this.e[0];
            if (j == 0 || jCurrentTimeMillis - j <= s.this.x) {
                return this.i;
            }
            return 1;
        }

        private void a(float f) {
            float fAbs = Math.abs(f - this.b);
            int[] iArr = s.this.q;
            int i = this.k;
            if (fAbs <= iArr[i % iArr.length] || f - this.b >= 0.0f) {
                this.b = (int) Math.max(this.b, f);
                return;
            }
            if (i >= iArr.length) {
                this.k = 0;
            } else {
                this.k = i + 1;
            }
            long[] jArr = this.e;
            long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, jArr.length != 1 ? 1 : 0, jArr.length);
            if (jArrCopyOfRange.length != 0) {
                long[] jArrCopyOf = Arrays.copyOf(jArrCopyOfRange, s.this.q.length);
                this.e = jArrCopyOf;
                jArrCopyOf[jArrCopyOf.length - 1] = System.currentTimeMillis();
            }
            boolean z = !this.h;
            this.h = z;
            int[] iArr2 = this.f;
            int[] iArr3 = s.this.q;
            iArr2[iArr3.length - 1] = z ? 1 : -1;
            this.g[iArr3.length - 1] = Math.abs(f - this.b) * (this.h ? 1 : -1);
            this.c = 0.0f;
            this.b = 0.0f;
            this.f8729a = 0.0f;
            StringBuilder sbAppend = new StringBuilder("runDimensionInfo =").append(this.m).append(";正数达到");
            int[] iArr4 = s.this.q;
            u.e(sbAppend.append(iArr4[this.k % iArr4.length]).append(com.huawei.openalliance.ad.constant.x.A).append(this.i).append(";").append(Arrays.toString(this.g)).append(";").append(Arrays.toString(this.e)).append(";").append(this).toString());
        }

        private void b(float f) {
            float fAbs = Math.abs(f - this.c);
            int[] iArr = s.this.q;
            int i = this.k;
            if (fAbs <= iArr[i % iArr.length] || f - this.c <= 0.0f) {
                this.c = (int) Math.min(this.c, f);
                return;
            }
            if (i >= iArr.length) {
                this.k = 0;
            } else {
                this.k = i + 1;
            }
            long[] jArr = this.e;
            long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, jArr.length != 1 ? 1 : 0, jArr.length);
            if (jArrCopyOfRange.length != 0) {
                long[] jArrCopyOf = Arrays.copyOf(jArrCopyOfRange, s.this.q.length);
                this.e = jArrCopyOf;
                jArrCopyOf[jArrCopyOf.length - 1] = System.currentTimeMillis();
            }
            boolean z = !this.h;
            this.h = z;
            int[] iArr2 = this.f;
            int[] iArr3 = s.this.q;
            iArr2[iArr3.length - 1] = z ? 1 : -1;
            this.g[iArr3.length - 1] = Math.abs(f - this.c) * (this.h ? 1 : -1);
            this.c = 0.0f;
            this.b = 0.0f;
            this.f8729a = 0.0f;
            StringBuilder sbAppend = new StringBuilder("runDimensionInfo =").append(this.m).append(";负数达到");
            int[] iArr4 = s.this.q;
            u.e(sbAppend.append(iArr4[this.k % iArr4.length]).append(com.huawei.openalliance.ad.constant.x.A).append(this.i).append(";").append(Arrays.toString(this.g)).append(";").append(Arrays.toString(this.e)).append(";").append(this).toString());
        }

        private void c(float f) {
            float fAbs = Math.abs(f - this.b);
            int[] iArr = s.this.q;
            int i = this.i;
            if (fAbs <= iArr[i] || f - this.b >= 0.0f) {
                this.b = (int) Math.max(this.b, f);
                return;
            }
            this.e[i] = System.currentTimeMillis();
            boolean z = !this.h;
            this.h = z;
            int[] iArr2 = this.f;
            int i2 = this.i;
            iArr2[i2] = z ? 1 : -1;
            this.g[i2] = Math.abs(f - this.b) * (this.h ? 1 : -1);
            u.e("runDimensionInfo =" + this.m + ";正数达到" + s.this.q[this.i] + com.huawei.openalliance.ad.constant.x.A + this.i + ";" + Arrays.toString(this.g) + ";" + Arrays.toString(this.e) + ";" + this);
            this.i++;
            long[] jArrCopyOfRange = Arrays.copyOfRange(this.e, a(false), this.i);
            if (jArrCopyOfRange.length != 0) {
                this.e = Arrays.copyOf(jArrCopyOfRange, s.this.q.length);
                this.i--;
            }
            this.c = 0.0f;
            this.b = 0.0f;
            this.f8729a = 0.0f;
        }

        private void d(float f) {
            float fAbs = Math.abs(f - this.c);
            int[] iArr = s.this.q;
            int i = this.i;
            if (fAbs <= iArr[i] || f - this.c <= 0.0f) {
                this.c = (int) Math.min(this.c, f);
                return;
            }
            this.e[i] = System.currentTimeMillis();
            boolean z = !this.h;
            this.h = z;
            int[] iArr2 = this.f;
            int i2 = this.i;
            iArr2[i2] = z ? 1 : -1;
            this.g[i2] = Math.abs(f - this.c) * (this.h ? 1 : -1);
            u.e("runDimensionInfo =" + this.m + ";负数达到" + s.this.q[this.i] + com.huawei.openalliance.ad.constant.x.A + this.i + ";" + Arrays.toString(this.g) + ";" + Arrays.toString(this.e) + ";" + this);
            this.i++;
            long[] jArrCopyOfRange = Arrays.copyOfRange(this.e, a(false), this.i);
            if (jArrCopyOfRange.length != 0) {
                this.e = Arrays.copyOf(jArrCopyOfRange, s.this.q.length);
                this.i--;
            }
            this.c = 0.0f;
            this.b = 0.0f;
            this.f8729a = 0.0f;
        }

        public void a(float f, float f2) {
            try {
                float f3 = f2 * f;
                float f4 = this.l + f3;
                this.l = f4;
                this.m = (float) Math.toDegrees(f4);
                float f5 = this.f8729a + f3;
                this.f8729a = f5;
                float degrees = (float) Math.toDegrees(f5);
                u.e("runDimensionInfo =" + this.m + ";" + degrees + ";" + this.h + ";" + this);
                if (!s.this.I) {
                    int i = this.i;
                    if (i != 0) {
                        if (i < s.this.q.length) {
                            if (this.h) {
                                c(degrees);
                                return;
                            } else {
                                d(degrees);
                                return;
                            }
                        }
                        if (this.h) {
                            a(degrees);
                            return;
                        } else {
                            b(degrees);
                            return;
                        }
                    }
                    this.c = (int) Math.min(this.c, degrees);
                    float fMax = (int) Math.max(this.b, degrees);
                    this.b = fMax;
                    float f6 = fMax - this.c;
                    int[] iArr = s.this.q;
                    int i2 = this.i;
                    if (f6 > iArr[i2]) {
                        this.e[i2] = System.currentTimeMillis();
                        boolean z = degrees > 0.0f;
                        this.h = z;
                        int[] iArr2 = this.f;
                        int i3 = this.i;
                        iArr2[i3] = z ? 1 : -1;
                        this.g[i3] = (this.b - this.c) * (z ? 1 : -1);
                        u.e((!z ? new StringBuilder("runDimensionInfo =").append(this.m).append(";正数达到").append(s.this.q[this.i]).append(com.huawei.openalliance.ad.constant.x.A).append(this.i).append(";").append(Arrays.toString(this.g)).append(";").append(Arrays.toString(this.e)).append(";").append(this) : new StringBuilder("runDimensionInfo =").append(this.m).append(";负数达到").append(s.this.q[this.i]).append(com.huawei.openalliance.ad.constant.x.A).append(this.i).append(";").append(Arrays.toString(this.g)).append(";").append(Arrays.toString(this.e)).append(";").append(this)).toString());
                        this.i++;
                        this.c = 0.0f;
                        this.b = 0.0f;
                        this.f8729a = 0.0f;
                        return;
                    }
                    return;
                }
                if (this.i < s.this.q.length) {
                    float fAbs = Math.abs(this.m);
                    int[] iArr3 = s.this.q;
                    int i4 = this.i;
                    if (fAbs <= iArr3[i4] || this.m <= 0.0f || (i4 != 0 && this.h)) {
                        float fAbs2 = Math.abs(this.m);
                        int[] iArr4 = s.this.q;
                        int i5 = this.i;
                        if (fAbs2 <= iArr4[i5] || this.m >= 0.0f) {
                            return;
                        }
                        if (i5 != 0 && !this.h) {
                            return;
                        }
                        this.e[i5] = System.currentTimeMillis();
                        this.h = false;
                        int[] iArr5 = this.f;
                        int i6 = this.i;
                        iArr5[i6] = -1;
                        this.g[i6] = Math.abs(this.m) * (-1.0f);
                        u.e("runDimensionInfo =" + this.m + ";负数达到" + s.this.q[this.i] + com.huawei.openalliance.ad.constant.x.A + this.i + ";" + Arrays.toString(this.g) + ";" + Arrays.toString(this.e) + ";" + this);
                    } else {
                        this.e[i4] = System.currentTimeMillis();
                        this.h = true;
                        int[] iArr6 = this.f;
                        int i7 = this.i;
                        iArr6[i7] = 1;
                        this.g[i7] = Math.abs(this.m) * 1.0f;
                        u.e("runDimensionInfo =" + this.m + ";正数达到" + s.this.q[this.i] + com.huawei.openalliance.ad.constant.x.A + this.i + ";" + Arrays.toString(this.g) + ";" + Arrays.toString(this.e) + ";" + this);
                    }
                } else {
                    float fAbs3 = Math.abs(this.m);
                    int[] iArr7 = s.this.q;
                    if (fAbs3 <= iArr7[this.i % iArr7.length] || this.m <= 0.0f || this.h) {
                        float fAbs4 = Math.abs(this.m);
                        int[] iArr8 = s.this.q;
                        if (fAbs4 <= iArr8[this.i % iArr8.length] || this.m >= 0.0f || !this.h) {
                            return;
                        }
                        long[] jArr = this.e;
                        long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, jArr.length == 1 ? 0 : 1, jArr.length);
                        if (jArrCopyOfRange.length != 0) {
                            long[] jArrCopyOf = Arrays.copyOf(jArrCopyOfRange, s.this.q.length);
                            this.e = jArrCopyOf;
                            jArrCopyOf[jArrCopyOf.length - 1] = System.currentTimeMillis();
                        }
                        boolean z2 = !this.h;
                        this.h = z2;
                        int[] iArr9 = this.f;
                        int[] iArr10 = s.this.q;
                        iArr9[iArr10.length - 1] = z2 ? 1 : -1;
                        this.g[iArr10.length - 1] = Math.abs(this.m) * (this.h ? 1 : -1);
                        StringBuilder sbAppend = new StringBuilder("runDimensionInfo =").append(this.m).append(";负数达到");
                        int[] iArr11 = s.this.q;
                        u.e(sbAppend.append(iArr11[this.i % iArr11.length]).append(com.huawei.openalliance.ad.constant.x.A).append(this.i).append(";").append(Arrays.toString(this.g)).append(";").append(Arrays.toString(this.e)).append(";").append(this).toString());
                    } else {
                        long[] jArr2 = this.e;
                        long[] jArrCopyOfRange2 = Arrays.copyOfRange(jArr2, jArr2.length == 1 ? 0 : 1, jArr2.length);
                        if (jArrCopyOfRange2.length != 0) {
                            long[] jArrCopyOf2 = Arrays.copyOf(jArrCopyOfRange2, s.this.q.length);
                            this.e = jArrCopyOf2;
                            jArrCopyOf2[jArrCopyOf2.length - 1] = System.currentTimeMillis();
                        }
                        boolean z3 = !this.h;
                        this.h = z3;
                        int[] iArr12 = this.f;
                        int[] iArr13 = s.this.q;
                        iArr12[iArr13.length - 1] = z3 ? 1 : -1;
                        this.g[iArr13.length - 1] = Math.abs(this.m) * (this.h ? 1 : -1);
                        StringBuilder sbAppend2 = new StringBuilder("runDimensionInfo =").append(this.m).append(";正数达到");
                        int[] iArr14 = s.this.q;
                        u.e(sbAppend2.append(iArr14[this.i % iArr14.length]).append(com.huawei.openalliance.ad.constant.x.A).append(this.i).append(";").append(Arrays.toString(this.g)).append(";").append(Arrays.toString(this.e)).append(";").append(this).toString());
                    }
                }
                this.i++;
            } catch (Exception e) {
                e.printStackTrace();
                this.i = 0;
                this.c = 0.0f;
                this.b = 0.0f;
                this.f8729a = 0.0f;
            }
        }

        public int[] a() {
            return this.f;
        }

        public long b() {
            try {
                return this.e[0];
            } catch (Exception e) {
                e.printStackTrace();
                return 0L;
            }
        }

        public float c() {
            return this.m;
        }

        public float d() {
            float f = this.m % 360.0f;
            if (f >= 0.0f) {
                return f > 180.0f ? f - 360.0f : f;
            }
            return Math.abs(f) > 180.0f ? f + 360.0f : f;
        }

        public long[] e() {
            return this.e;
        }

        public boolean f() {
            long[] jArr = this.e;
            if (jArr.length == 1 && jArr[0] > 0) {
                return true;
            }
            long j = jArr[jArr.length - 1] - jArr[0];
            return j > 0 && j < ((long) s.this.x);
        }
    }

    public interface e {
        void a(float f, float f2);

        void a(Bundle bundle);
    }

    public s(Context context, double d2, int i, double d3) {
        this.i = false;
        this.j = true;
        this.k = true;
        this.m = 3.0d;
        this.n = 5;
        this.q = new int[]{35, 35};
        this.r = false;
        this.s = 0L;
        this.t = new d[3];
        this.u = 0L;
        this.v = false;
        this.x = 5000;
        this.z = 0L;
        this.H = false;
        this.J = false;
        this.K = 0.0f;
        this.L = true;
        this.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.y = d3;
        if (d2 <= 0.0d) {
            this.m = 3.0d;
        } else {
            this.m = d2;
        }
        if (i > 0) {
            this.n = i;
        }
    }

    public s(Context context, double d2, int[] iArr, int i, double d3, boolean z, boolean z2) {
        this.i = false;
        this.j = true;
        this.k = true;
        this.m = 3.0d;
        this.n = 5;
        this.q = new int[]{35, 35};
        this.r = false;
        this.s = 0L;
        this.t = new d[3];
        this.u = 0L;
        this.v = false;
        this.x = 5000;
        this.z = 0L;
        this.H = false;
        this.J = false;
        this.K = 0.0f;
        this.L = true;
        this.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.I = z;
        this.J = z2;
        this.r = true;
        this.y = d3;
        if (d2 <= 0.0d) {
            this.m = 3.0d;
        } else {
            this.m = d2;
        }
        if (iArr.length > 0) {
            this.q = iArr;
        }
        if (i > 0) {
            this.x = i;
        } else {
            this.x = 5000;
        }
    }

    private float a(float f, float f2) {
        return Math.abs(f2) > Math.abs(f) ? f2 : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("__SENSOR_INFO_TYPE__", 0);
        bundle.putString("__SENSOR_UN_RECEIVE__", str2);
        bundle.putString("__SENSOR_UN_SUPPORT_LIST__", str);
        return bundle;
    }

    private void a(SensorEvent sensorEvent) {
        boolean z;
        Bundle bundleB;
        e eVar;
        this.l = System.currentTimeMillis();
        if (sensorEvent.sensor.getType() == 1) {
            this.V = true;
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            this.D = f;
            float f2 = fArr[1];
            this.E = f2;
            float f3 = fArr[2];
            this.F = f3;
            float fAbs = Math.abs((float) (Math.sqrt(((f * f) + (f2 * f2)) + (f3 * f3)) - 9.81d));
            u.a("runDimensionInfo_delta=" + fAbs);
            this.A = a(this.A, this.D);
            this.B = a(this.B, this.E);
            this.C = a(this.C, this.F);
            if (fAbs <= this.m) {
                return;
            }
            this.K = fAbs;
            u.a("runDimensionInfo_delta达到触发值=" + fAbs + ";" + this.m);
            this.v = true;
            this.s = System.currentTimeMillis();
            this.w = Math.round(fAbs * 100.0f) / 100.0f;
            if (!this.j) {
                u.b("ShakeSensor ", "shake trigger： " + fAbs + " server load value ： " + this.m);
                if (this.o == null) {
                    return;
                }
            } else {
                if (!this.i) {
                    return;
                }
                long jMax = 0;
                for (d dVar : this.t) {
                    if (dVar != null) {
                        jMax = Math.max(jMax, dVar.b());
                    }
                }
                if (this.s - jMax >= this.x) {
                    return;
                }
                u.b("ShakeSensor ", "shake trigger： " + fAbs + " server load value ： " + this.m);
                if (this.o == null) {
                    return;
                }
            }
            bundleB = b();
            e();
            eVar = this.o;
        } else {
            if (sensorEvent.sensor.getType() != 4) {
                return;
            }
            float f4 = this.f;
            if (f4 == 0.0f && this.g == 0.0f && this.h == 0.0f) {
                if (this.L) {
                    this.L = false;
                    return;
                }
                int i = 0;
                while (true) {
                    d[] dVarArr = this.t;
                    if (i >= dVarArr.length) {
                        float[] fArr2 = sensorEvent.values;
                        this.f = fArr2[0];
                        this.g = fArr2[1];
                        this.h = fArr2[2];
                        this.u = sensorEvent.timestamp;
                        this.z = System.currentTimeMillis();
                        return;
                    }
                    dVarArr[i] = new d(this.q.length, sensorEvent.values[i]);
                    i++;
                }
            } else {
                if (Math.abs(sensorEvent.values[0] - f4) > 180.0f) {
                    Math.abs(sensorEvent.values[0] - this.f);
                }
                Math.abs(this.h - sensorEvent.values[2]);
                this.W = true;
                this.t[0].a((sensorEvent.timestamp - this.u) * 1.0E-9f, sensorEvent.values[0]);
                this.t[1].a((sensorEvent.timestamp - this.u) * 1.0E-9f, sensorEvent.values[1]);
                this.t[2].a((sensorEvent.timestamp - this.u) * 1.0E-9f, sensorEvent.values[2]);
                if (u.a()) {
                    u.b("ShakeSensor111 ", String.format("event=%s,;Azimuth=%.2f,;Pitch=%.2f,;Roll=%.2f", Integer.valueOf(sensorEvent.sensor.getType()), Float.valueOf(sensorEvent.values[0]), Float.valueOf(sensorEvent.values[1]), Float.valueOf(sensorEvent.values[2])));
                    u.b("ShakeSensor222 ", "event=" + sensorEvent.sensor.getType() + ";x=" + (sensorEvent.values[0] - this.f) + ";y=" + sensorEvent.values[1] + ";z=" + (this.h - sensorEvent.values[2]));
                    u.b("ShakeSensor333 ", "event=" + this.t[0].f() + ";dir=" + Arrays.toString(this.t[0].a()) + ";time=" + Arrays.toString(this.t[0].e()));
                    u.b("ShakeSensor444 ", "event=" + this.t[2].f() + ";dir=" + Arrays.toString(this.t[2].a()) + ";time=" + Arrays.toString(this.t[2].e()));
                    u.b("ShakeSensor888 ", "event=" + this.t[1].f() + ";dir=" + Arrays.toString(this.t[1].a()) + ";time=" + Arrays.toString(this.t[1].e()));
                    Float fValueOf = Float.valueOf((sensorEvent.timestamp - this.u) * 1.0E-9f);
                    float f5 = this.M + (sensorEvent.values[0] * (sensorEvent.timestamp - this.u) * 1.0E-9f);
                    this.M = f5;
                    Double dValueOf = Double.valueOf(Math.toDegrees(f5));
                    float f6 = this.N + (sensorEvent.values[1] * (sensorEvent.timestamp - this.u) * 1.0E-9f);
                    this.N = f6;
                    Double dValueOf2 = Double.valueOf(Math.toDegrees(f6));
                    float f7 = this.O + (sensorEvent.values[2] * (sensorEvent.timestamp - this.u) * 1.0E-9f);
                    this.O = f7;
                    u.b("ShakeSensor555 ", String.format("event=%s,;Azimuth=%.2f,;Pitch=%.2f,;Roll=%.2f", fValueOf, dValueOf, dValueOf2, Double.valueOf(Math.toDegrees(f7))));
                    u.b("ShakeSensor666 ", "yv=" + a(this.t[1], this.s) + " ;zv=" + a(this.t[1], this.s));
                    u.b("ShakeSensor777 ", "rrX=" + this.t[0].d() + " ;rrY=" + this.t[1].d() + " ;rrZ=" + this.t[2].d());
                }
                this.u = sensorEvent.timestamp;
                if (Math.abs(this.t[0].d()) < 5.0f && Math.abs(this.t[1].d()) < 5.0f && Math.abs(this.t[2].d()) < 5.0f) {
                    this.z = System.currentTimeMillis();
                }
                if (this.J && this.t[0].f()) {
                    z = true;
                } else {
                    z = true;
                    if (!this.t[1].f() && !this.t[2].f()) {
                        return;
                    }
                }
                this.i = z;
                if (!this.k) {
                    bundleB = b();
                    u.b("ShakeSensor ", "rotate trigger： " + this.K + " server load value ： " + this.m);
                    e();
                    eVar = this.o;
                    if (eVar == null) {
                        return;
                    }
                } else {
                    if ((!this.J || !a(this.t[0], this.s)) && !a(this.t[1], this.s) && !a(this.t[2], this.s)) {
                        return;
                    }
                    bundleB = b();
                    u.b("ShakeSensor ", "rotate trigger： " + this.K + " server load value ： " + this.m);
                    e();
                    eVar = this.o;
                    if (eVar == null) {
                        return;
                    }
                }
            }
        }
        eVar.a(bundleB);
        this.o.a(this.w, (float) this.m);
    }

    private boolean a(d dVar, long j) {
        try {
            return dVar.f() && Math.abs(j - dVar.b()) < ((long) this.x);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt("__SENSOR_INFO_TYPE__", 1);
        if (this.t[1].f()) {
            bundle.putInt("__UBIX_TURN_TARGET__", 1);
        } else {
            bundle.putInt("__UBIX_TURN_TARGET__", 2);
        }
        bundle.putFloat("__UBIX_ACC_X__", this.D);
        bundle.putFloat("__UBIX_ACC_Y__", this.E);
        bundle.putFloat("__UBIX_ACC_Z__", this.F);
        bundle.putFloat("__X_MAX_ACC__", this.A);
        bundle.putFloat("__Y_MAX_ACC__", this.B);
        bundle.putFloat("__Z_MAX_ACC__", this.C);
        bundle.putLong("__TURN_TIME__", System.currentTimeMillis() - this.z);
        bundle.putFloat("__TURN_X__", this.t[0].c());
        bundle.putFloat("__TURN_Y__", this.t[1].c());
        bundle.putFloat("__TURN_Z__", this.t[2].c());
        return bundle;
    }

    private void b(SensorEvent sensorEvent) {
        this.l = System.currentTimeMillis();
        if (sensorEvent.sensor.getType() == 1) {
            this.V = true;
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            this.D = f;
            float f2 = fArr[1];
            this.E = f2;
            float f3 = fArr[2];
            this.F = f3;
            float fAbs = Math.abs((float) (Math.sqrt(((f * f) + (f2 * f2)) + (f3 * f3)) - 9.81d));
            this.A = a(this.A, this.D);
            this.B = a(this.B, this.E);
            this.C = a(this.C, this.F);
            if (fAbs > this.m) {
                if (!this.j || this.i) {
                    u.b("ShakeSensor ", "shake trigger： " + fAbs + " server load value ： " + this.m);
                    if (this.o != null) {
                        Bundle bundleC = c();
                        e();
                        float fRound = Math.round(fAbs * 100.0f) / 100.0f;
                        this.o.a(bundleC);
                        this.o.a(fRound, (float) this.m);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (sensorEvent.sensor.getType() == 3) {
            float f4 = this.f;
            if (f4 == 0.0f && this.g == 0.0f && this.h == 0.0f) {
                if (this.L) {
                    this.L = false;
                    return;
                }
                float[] fArr2 = sensorEvent.values;
                this.f = fArr2[0];
                this.g = fArr2[1];
                this.h = fArr2[2];
                this.z = System.currentTimeMillis();
                return;
            }
            this.W = true;
            float fAbs2 = Math.abs(sensorEvent.values[0] - f4);
            this.P = fAbs2;
            if (fAbs2 > 180.0f) {
                this.P = 360.0f - Math.abs(sensorEvent.values[0] - this.f);
            }
            this.R = Math.abs(this.h - sensorEvent.values[2]);
            this.Q = Math.abs(this.g - sensorEvent.values[1]);
            if (u.a()) {
                u.b("ShakeSensor111 ", "event=" + sensorEvent.sensor.getType() + ";x=" + sensorEvent.values[1] + ";y=" + sensorEvent.values[2] + ";z=" + (Math.abs(Math.abs(sensorEvent.values[0]) - 180.0f) - Math.abs(Math.abs(this.f) - 180.0f)));
                u.b("ShakeSensor222 ", "event=" + sensorEvent.sensor.getType() + ";x=" + ((sensorEvent.values[0] - 180.0f) - (this.f - 180.0f)) + ";y=" + (sensorEvent.values[1] - this.g) + ";z=" + (sensorEvent.values[2] - this.h));
                u.b("ShakeSensor333 ", "event=" + sensorEvent.sensor.getType() + ";x=" + ((sensorEvent.values[1] - this.g) * (-1.0f)) + ";y=" + ((sensorEvent.values[2] - this.h) * (-1.0f)) + ";z=" + (((sensorEvent.values[0] - 180.0f) - (this.f - 180.0f)) * (-1.0f)));
                u.b("ShakeSensor444 ", "event=" + sensorEvent.sensor.getType() + ";x=" + sensorEvent.values[1] + ";y=" + sensorEvent.values[2] + ";z=" + (this.P * (sensorEvent.values[0] - this.f > 0.0f ? 1 : -1)));
                u.b("ShakeSensor555 ", "event=" + sensorEvent.sensor.getType() + ";x=" + sensorEvent.values[1] + ";y=" + sensorEvent.values[2] + ";z=" + sensorEvent.values[0]);
                u.b("ShakeSensor666 ", "event=" + sensorEvent.sensor.getType() + ";x=" + sensorEvent.values[0] + ";y=" + sensorEvent.values[2] + ";z=" + sensorEvent.values[1]);
            }
            if (this.P < 5.0f && this.Q < 5.0f && this.R < 5.0f) {
                this.z = System.currentTimeMillis();
            }
            float f5 = this.P;
            float f6 = this.n;
            if (f5 <= f6 && this.R <= f6) {
                this.i = false;
                return;
            }
            float[] fArr3 = sensorEvent.values;
            this.S = (fArr3[1] - this.g) * (-1.0f);
            this.T = (fArr3[2] - this.h) * (-1.0f);
            this.U = f5 * (fArr3[0] - this.f > 0.0f ? 1 : -1);
            this.i = true;
        }
    }

    private Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt("__SENSOR_INFO_TYPE__", 1);
        bundle.putInt("__UBIX_TURN_TARGET__", this.P > ((float) this.n) ? 0 : 2);
        bundle.putLong("__TURN_TIME__", System.currentTimeMillis() - this.z);
        bundle.putFloat("__TURN_X__", this.S);
        bundle.putFloat("__TURN_Y__", this.T);
        bundle.putFloat("__TURN_Z__", this.U);
        bundle.putFloat("__X_MAX_ACC__", this.A);
        bundle.putFloat("__Y_MAX_ACC__", this.B);
        bundle.putFloat("__Z_MAX_ACC__", this.C);
        bundle.putFloat("__UBIX_ACC_X__", this.D);
        bundle.putFloat("__UBIX_ACC_Y__", this.E);
        bundle.putFloat("__UBIX_ACC_Z__", this.F);
        bundle.putFloat("__TURN_INIT_X__", this.f);
        bundle.putFloat("__TURN_INIT_Y__", this.g);
        bundle.putFloat("__TURN_INIT_Z__", this.h);
        return bundle;
    }

    private void d() {
        String string;
        try {
            if (this.d == null || this.c == null) {
                SensorManager sensorManager = (SensorManager) this.b.getSystemService("sensor");
                this.c = sensorManager;
                int i = this.r ? 4 : 3;
                List<Sensor> sensorList = sensorManager.getSensorList(1);
                if (sensorList == null || sensorList.isEmpty()) {
                    this.k = false;
                    string = "1";
                } else {
                    this.d = this.c.getDefaultSensor(1);
                    string = "";
                }
                List<Sensor> sensorList2 = this.c.getSensorList(i);
                if (sensorList2 == null || sensorList2.isEmpty()) {
                    string = (!string.isEmpty() ? new StringBuilder().append(string).append(",").append(i) : new StringBuilder().append(i).append("")).toString();
                    double d2 = this.y;
                    if (d2 <= 0.0d) {
                        this.m = 1.0d;
                    } else {
                        this.m = d2;
                    }
                    this.j = false;
                } else {
                    this.e = this.c.getDefaultSensor(i);
                }
                this.l = System.currentTimeMillis();
            } else {
                string = "";
            }
            if (this.d != null) {
                u.b("reg shakeSensor " + this.c.registerListener(this, this.d, 1));
            }
            if (this.e != null) {
                u.b("reg rotateSensor " + this.c.registerListener(this, this.e, 1));
            }
            try {
                if (!this.k && !this.j) {
                    Bundle bundleA = a(string, "");
                    e eVar = this.o;
                    if (eVar != null) {
                        eVar.a(bundleA);
                        return;
                    }
                    return;
                }
                if (this.H) {
                    return;
                }
                this.H = true;
                ScheduledExecutorService scheduledExecutorService = f8725a;
                if (scheduledExecutorService == null || scheduledExecutorService.isTerminated()) {
                    f8725a = Executors.newScheduledThreadPool(2, new b());
                }
                c cVar = new c(string);
                this.G = cVar;
                f8725a.schedule(cVar, 1L, TimeUnit.SECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void e() {
        this.U = 0.0f;
        this.T = 0.0f;
        this.S = 0.0f;
        this.R = 0.0f;
        this.Q = 0.0f;
        this.P = 0.0f;
        this.h = 0.0f;
        this.g = 0.0f;
        this.f = 0.0f;
        this.C = 0.0f;
        this.B = 0.0f;
        this.A = 0.0f;
        this.i = false;
    }

    public void a() {
        try {
            ObjectAnimator objectAnimator = this.p;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.p.removeAllListeners();
                this.p = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        try {
            if (this.p != null) {
                return;
            }
            imageView.post(new a(imageView));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(e eVar) {
        this.o = eVar;
        d();
    }

    public void f() {
        try {
            synchronized (this) {
                try {
                    SensorManager sensorManager = this.c;
                    if (sensorManager != null) {
                        Sensor sensor = this.d;
                        if (sensor != null) {
                            sensorManager.unregisterListener(this, sensor);
                            this.d = null;
                        }
                        Sensor sensor2 = this.e;
                        if (sensor2 != null) {
                            this.c.unregisterListener(this, sensor2);
                            this.e = null;
                        }
                        this.c = null;
                        this.o = null;
                        e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (this.r) {
                a(sensorEvent);
            } else {
                b(sensorEvent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
