package com.byazt.nr;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ExoPlayer;
import com.stub.StubApp;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 482})
public class zm implements SensorEventListener {
    public static yv tx;
    public ve b;
    public JSONObject cu;
    public int gr;
    public float ic;
    public Context kk;
    public Sensor m;
    public int my;
    public float n;
    public Sensor nu;
    public float pf;
    public boolean q;
    public float rh;
    public sl sl;
    public volatile long sp;
    public float sv;
    public volatile long tt;
    public float uj;
    public int v;
    public float ve;
    public Sensor yp;
    public float yv;
    public Sensor z;
    public final long c = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2533a = false;
    public float x = 13.0f;
    public float i = 50.0f;
    public int da = 0;
    public c t = null;
    public tt u = null;
    public final long gt = 500;
    public volatile long rl = 0;
    public volatile boolean qy = false;
    public volatile boolean gu = false;
    public final float zm = 1.0E-9f;
    public float[] p = new float[3];
    public long md = 0;
    public float h = 0.0f;
    public float d = 4.0f;
    public float eo = 0.0f;
    public float[] zb = new float[3];
    public final float or = 0.0f;
    public boolean qp = false;
    public boolean nb = false;
    public boolean bx = false;
    public boolean aw = false;
    public int hd = 0;
    public int bm = 0;
    public int lr = 0;
    public int l = 0;
    public int lo = 0;
    public int pu = 0;
    public boolean lt = false;
    public int to = 0;
    public int tk = 0;
    public float kp = 0.0f;

    public interface c {
        void c(int i);
    }

    public interface tt {
        void c(float f, float f2, float f3);
    }

    public interface ve {
        void c();
    }

    private int a(float f) {
        return f < 0.0f ? 1 : 2;
    }

    private void a() {
        this.rl = 0L;
        this.qy = false;
        this.gu = false;
        this.hd = 0;
        this.bm = 0;
        this.lr = 0;
        this.l = 0;
        this.lo = 0;
        this.pu = 0;
    }

    private float c(double d) {
        if (d <= 0.0d || d > 180.0d) {
            d = 50.0d;
        }
        return (float) d;
    }

    private void c(int i, int i2, int i3, boolean z) {
        if (z) {
            this.hd = 0;
            this.bm = 0;
            this.lr = 0;
            this.l = 0;
            this.lo = 0;
            this.pu = 0;
            return;
        }
        if (i == 0) {
            i = this.hd;
        }
        this.hd = i;
        if (i2 == 0) {
            i2 = this.bm;
        }
        this.bm = i2;
        if (i3 == 0) {
            i3 = this.lr;
        }
        this.lr = i3;
    }

    public static void c(yv yvVar) {
        tx = yvVar;
    }

    private boolean c(float f, float f2) {
        return f2 > 0.0f && f > f2;
    }

    private boolean c(int i, int i2) {
        return (i | i2) == 3;
    }

    private boolean c(int i, int i2, int i3) {
        return i2 == 3 && (i | i3) == 3;
    }

    private int getType() {
        return this.gr == 2 ? 2 : 1;
    }

    private void sp() {
        this.hd = 0;
        this.bm = 0;
        this.lr = 0;
    }

    private boolean x() {
        return this.rh > this.x;
    }

    public void c(float f) {
        this.x = f;
    }

    public void c(c cVar) {
        this.t = cVar;
    }

    public void c(tt ttVar) {
        this.u = ttVar;
    }

    public void c(ve veVar) {
        this.b = veVar;
    }

    public boolean c() {
        return this.qy;
    }

    public void n(int i) {
        this.da = i;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void tt(float f) {
        this.i = f;
    }

    public void ve(float f) {
        this.rh = f;
    }

    public zm(Context context, int i, boolean z) {
        this.sl = null;
        this.q = z;
        this.gr = i;
        if (context == null) {
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.kk = origApplicationContext;
        if (origApplicationContext == null) {
            return;
        }
        m.c("xgc_cus", "cus:" + z);
        if (z) {
            this.sl = n.c(context);
        }
    }

    public void c(boolean z) {
        Context context;
        m.c("xgcc", "cus:" + z + " m:" + this.q + " equ:" + (this.sl != null));
        if (z) {
            if (this.q || this.sl != null || (context = this.kk) == null) {
                return;
            }
            this.sl = n.c(context);
            return;
        }
        sl slVar = this.sl;
        if (slVar != null) {
            slVar.c(this);
            this.sl = null;
        }
    }

    private boolean tt() {
        sl slVar = this.sl;
        if (slVar == null) {
            return false;
        }
        try {
            if (this.da == 4) {
                return ve();
            }
            if (this.yp == null) {
                this.yp = slVar.c(1);
            }
            boolean zC = this.sl.c(this, this.yp, 3);
            a();
            return zC;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean ve() {
        int i;
        sl slVar = this.sl;
        boolean zC = false;
        if (slVar == null) {
            return false;
        }
        try {
            if (this.my == 0) {
                if (this.z == null) {
                    this.z = slVar.c(15);
                }
                this.f2533a = false;
                zC = this.sl.c(this, this.z, 1);
            }
            int i2 = this.my;
            if (i2 == 3 || i2 == 2 || i2 == 4 || i2 == 7) {
                if (this.m == null) {
                    this.m = this.sl.c(4);
                }
                float f = this.d;
                if (f != 0.0f && ((i = this.my) == 2 || i == 4)) {
                    this.kp = (float) Math.pow(f, 2.0d);
                    if (this.nu == null) {
                        this.nu = this.sl.c(10);
                    }
                    this.sl.c(this, this.nu, 1);
                }
                zC = this.sl.c(this, this.m, 1);
            }
            sp();
        } catch (Throwable unused) {
        }
        return zC;
    }

    public boolean c(int i) {
        yv yvVar;
        i(i);
        if (i > 0 && (yvVar = tx) != null && !yvVar.c(i)) {
            tx.c(i, hashCode(), new Runnable() { // from class: com.byazt.nr.zm.1
                @Override // java.lang.Runnable
                public void run() {
                    zm.this.uj();
                }
            });
            return true;
        }
        return uj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uj() {
        if (this.sl == null || this.lt) {
            return false;
        }
        int i = this.gr;
        if (i == 1) {
            return tt();
        }
        if (i == 2) {
            return ve();
        }
        return false;
    }

    public void tt(int i) {
        n();
        this.v = i;
        yv yvVar = tx;
        if (yvVar != null) {
            yvVar.c(i, hashCode());
        }
        da();
    }

    private void n() {
        sl slVar = this.sl;
        if (slVar == null) {
            return;
        }
        slVar.c(this);
    }

    public void ve(int i) {
        this.lt = false;
        c(i);
    }

    public void uj(int i) {
        this.lt = true;
        tt(i);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        ve veVar = this.b;
        if (veVar != null) {
            veVar.c();
        }
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        if (fArr == null || fArr.length < 3) {
            return;
        }
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[1]);
        float fAbs3 = Math.abs(fArr[2]);
        if (type == 1) {
            if (this.t == null || System.currentTimeMillis() - this.tt <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                return;
            }
            int i = this.da;
            if (i == 1) {
                double dSqrt = Math.sqrt(Math.pow(fAbs, 2.0d) + Math.pow(fAbs2, 2.0d) + Math.pow(fAbs3, 2.0d));
                c(dSqrt > ((double) this.x), dSqrt, sensorEvent);
                return;
            } else if (i == 2) {
                tt(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.x), sensorEvent);
                return;
            } else if (i == 3) {
                c(Math.sqrt((Math.pow((double) fAbs, 2.0d) + Math.pow((double) fAbs2, 2.0d)) + Math.pow((double) fAbs3, 2.0d)) > ((double) this.x), sensorEvent);
                return;
            } else {
                double dC = c(fAbs, fAbs2, fAbs3);
                c(dC > ((double) this.x), dC, sensorEvent);
                return;
            }
        }
        if (type == 4) {
            int i2 = this.my;
            if (i2 == 3) {
                tt(sensorEvent);
                return;
            } else {
                if (i2 == 2 || i2 == 4 || i2 == 7) {
                    c(sensorEvent);
                    return;
                }
                return;
            }
        }
        if (type == 10) {
            this.eo = (float) (Math.pow(sensorEvent.values[0], 2.0d) + Math.pow(sensorEvent.values[1], 2.0d) + Math.pow(sensorEvent.values[2], 2.0d));
            return;
        }
        if (type != 15) {
            return;
        }
        float fAbs4 = Math.abs(fArr[0]);
        float fAbs5 = Math.abs(fArr[1]);
        float fAbs6 = Math.abs(fArr[2]);
        tt ttVar = this.u;
        if (ttVar != null) {
            ttVar.c(fArr[0], fArr[1], fArr[2]);
        }
        if (fAbs4 == 0.0f && fAbs5 == 0.0f && fAbs6 == 0.0f) {
            return;
        }
        if (!this.f2533a) {
            this.f2533a = true;
            this.ve = fAbs4;
            this.uj = fAbs5;
            this.n = fAbs6;
            return;
        }
        float fAbs7 = Math.abs(fAbs4 - this.ve) * 180.0f;
        float fAbs8 = Math.abs(fAbs5 - this.uj) * 180.0f;
        float fAbs9 = Math.abs(fAbs6 - this.n) * 180.0f;
        float[] fArr2 = {fAbs7, fAbs8, fAbs9};
        if (!this.qp) {
            float f = this.i;
            if ((fAbs7 > f || fAbs8 > f || fAbs9 > f) && this.t != null && System.currentTimeMillis() - this.sp > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                c(2, fArr2);
                x(11);
                this.t.c(getType());
                this.sp = System.currentTimeMillis();
                this.f2533a = false;
                return;
            }
            return;
        }
        boolean z = this.nb && fAbs7 > this.pf;
        boolean z2 = this.bx && fAbs8 > this.sv;
        boolean z3 = this.aw && fAbs9 > this.ic;
        if ((z || z2 || z3) && this.t != null && System.currentTimeMillis() - this.sp > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            c(2, fArr2);
            x(11);
            this.t.c(getType());
            this.sp = System.currentTimeMillis();
            this.f2533a = false;
        }
    }

    private void c(SensorEvent sensorEvent) {
        if (this.md != 0) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            float f4 = (sensorEvent.timestamp - this.md) * 1.0E-9f;
            float f5 = this.h;
            if (f5 == 0.0f) {
                float f6 = this.kp;
                if (f6 != 0.0f && this.eo >= f6) {
                    tt(true);
                } else {
                    c(f, f2, f3, f4);
                }
            } else if (!tt(f5, f) || !tt(this.h, f2) || !tt(this.h, f3)) {
                tt(true);
            } else {
                c(f, f2, f3, f4);
            }
            if (this.my == 7) {
                sp(this.i);
            } else {
                uj(this.i);
            }
            tt ttVar = this.u;
            if (ttVar != null) {
                float[] fArr = this.zb;
                ttVar.c(fArr[0], fArr[1], fArr[2]);
            }
        }
        this.md = sensorEvent.timestamp;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:39:0x00dd  */
    private void tt(SensorEvent sensorEvent) {
        if (this.yv != 0.0f) {
            float f = (sensorEvent.timestamp - this.yv) * 1.0E-9f;
            float[] fArr = this.p;
            fArr[0] = fArr[0] + (sensorEvent.values[0] * f);
            float[] fArr2 = this.p;
            fArr2[1] = fArr2[1] + (sensorEvent.values[1] * f);
            float[] fArr3 = this.p;
            fArr3[2] = fArr3[2] + (sensorEvent.values[2] * f);
            float fAbs = Math.abs((float) Math.toDegrees(this.p[0]));
            float fAbs2 = Math.abs((float) Math.toDegrees(this.p[1]));
            float fAbs3 = Math.abs((float) Math.toDegrees(this.p[2]));
            if (this.qp) {
                boolean z = this.nb && c(fAbs, this.pf);
                boolean z2 = this.bx && c(fAbs2, this.sv);
                boolean z3 = this.aw && c(fAbs3, this.ic);
                if (z || z2 || z3) {
                    c(2, this.p);
                    float[] fArr4 = this.p;
                    fArr4[0] = 0.0f;
                    fArr4[1] = 0.0f;
                    fArr4[2] = 0.0f;
                    if (System.currentTimeMillis() - this.sp > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                        if (this.t != null) {
                            x(11);
                            this.t.c(getType());
                        }
                        this.sp = System.currentTimeMillis();
                    }
                }
            } else if (c(fAbs, this.i) || c(fAbs2, this.i) || c(fAbs3, this.i)) {
                c(2, this.p);
                float[] fArr5 = this.p;
                fArr5[0] = 0.0f;
                fArr5[1] = 0.0f;
                fArr5[2] = 0.0f;
                if (System.currentTimeMillis() - this.sp > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                    if (this.t != null) {
                        x(11);
                        this.t.c(getType());
                    }
                    this.sp = System.currentTimeMillis();
                }
            }
            tt ttVar = this.u;
            if (ttVar != null) {
                float[] fArr6 = this.p;
                ttVar.c(fArr6[0], fArr6[1], fArr6[2]);
            }
        }
        this.yv = sensorEvent.timestamp;
    }

    private void uj(float f) {
        boolean z = this.my == 4;
        if (!c(z, f) || System.currentTimeMillis() - this.sp <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return;
        }
        if (this.t != null) {
            x(z ? 12 : 11);
            this.t.c(getType());
        }
        this.sp = System.currentTimeMillis();
    }

    private boolean c(boolean z, float f) {
        float fAbs = Math.abs((float) Math.toDegrees(this.zb[0]));
        float fAbs2 = Math.abs((float) Math.toDegrees(this.zb[1]));
        float fAbs3 = Math.abs((float) Math.toDegrees(this.zb[2]));
        if (this.qp) {
            boolean z2 = this.nb && c(fAbs, this.pf);
            boolean z3 = this.bx && c(fAbs2, this.sv);
            boolean z4 = this.aw && c(fAbs3, this.ic);
            if (!z2 && !z3 && !z4) {
                return false;
            }
            c(2, this.zb);
            return c(z, z2, z3, z4);
        }
        boolean zC = c(fAbs, f);
        boolean zC2 = c(fAbs2, f);
        boolean zC3 = c(fAbs3, f);
        if (!zC && !zC2 && !zC3) {
            return false;
        }
        c(2, this.zb);
        return c(z, zC, zC2, zC3);
    }

    private void c(float f, float f2, float f3, float f4) {
        float[] fArr = this.zb;
        fArr[0] = fArr[0] + (f * f4);
        fArr[1] = fArr[1] + (f2 * f4);
        fArr[2] = fArr[2] + (f3 * f4);
    }

    private boolean tt(float f, float f2) {
        return Math.abs(f2) < f;
    }

    private void tt(boolean z) {
        float[] fArr = this.zb;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    public void c(JSONObject jSONObject) {
        if (this.gr != 2) {
            return;
        }
        this.cu = jSONObject;
        if (jSONObject == null) {
            this.nb = false;
            this.bx = false;
            this.aw = false;
        } else {
            this.nb = jSONObject.has("x_threshold");
            this.pf = c(this.cu.optDouble("x_threshold", 50.0d));
            this.bx = this.cu.has("y_threshold");
            this.sv = c(this.cu.optDouble("y_threshold", 50.0d));
            this.aw = this.cu.has("z_threshold");
            this.ic = c(this.cu.optDouble("z_threshold", 50.0d));
        }
        this.qp = this.nb || this.bx || this.aw;
    }

    public void tt(JSONObject jSONObject) {
        if (this.gr != 2) {
            return;
        }
        if (jSONObject == null) {
            this.tk = 0;
        } else {
            this.tk = jSONObject.optInt("double_direct_match", 0);
        }
    }

    public void ve(JSONObject jSONObject) {
        if (this.gr != 1) {
            return;
        }
        if (jSONObject == null) {
            this.to = 0;
            this.tk = 0;
        } else {
            this.to = jSONObject.optInt("double_direct_conf", 0);
            this.tk = jSONObject.optInt("double_direct_match", 0);
        }
    }

    private void n(float f) {
        if (System.currentTimeMillis() - this.rl >= 500) {
            this.qy = false;
            i();
        } else if (f >= this.rh) {
            this.qy = true;
            i();
        }
    }

    private void sp(int i) {
        if (this.t != null) {
            x(i);
            this.t.c(getType());
        }
        this.tt = System.currentTimeMillis();
    }

    private void i() {
        sp(1);
        this.rl = 0L;
        this.gu = false;
    }

    private float c(float f, float f2, float f3) {
        return Math.max(Math.max(f2, f), f3);
    }

    public void a(int i) {
        sl slVar = this.sl;
        if (slVar == null) {
            return;
        }
        if (i == 3 || i == 2 || i == 4 || i == 7) {
            if (this.m == null && slVar != null) {
                this.m = slVar.c(4);
            }
            if (this.m != null) {
                this.my = i;
                return;
            }
        }
        this.my = 0;
    }

    private void c(boolean z, double d, SensorEvent sensorEvent) {
        if (!x() && z) {
            sp(1);
        } else if (z) {
            this.rl = System.currentTimeMillis();
            this.gu = true;
            n((float) d);
        } else if (this.gu && System.currentTimeMillis() - this.rl >= 500) {
            this.qy = false;
            i();
        }
        if (z) {
            c(1, sensorEvent.values);
        }
    }

    private void c(boolean z, SensorEvent sensorEvent) {
        if (z) {
            float[] fArr = sensorEvent.values;
            int iC = c(fArr[0], this.hd);
            int iC2 = c(fArr[1], this.bm);
            int iC3 = c(fArr[2], this.lr);
            if (tt(iC, iC2, iC3, false)) {
                c(iC, iC2, iC3, true);
                sp(3);
            } else {
                this.hd |= iC;
                if (iC <= 0) {
                    iC = this.l;
                }
                this.l = iC;
                this.bm |= iC2;
                if (iC2 <= 0) {
                    iC2 = this.lo;
                }
                this.lo = iC2;
                this.lr |= iC3;
                if (iC3 <= 0) {
                    iC3 = this.pu;
                }
                this.pu = iC3;
            }
            c(1, sensorEvent.values);
        }
    }

    private void tt(boolean z, SensorEvent sensorEvent) {
        if (z) {
            float[] fArr = sensorEvent.values;
            int iC = c(fArr[0], this.hd);
            int iC2 = c(fArr[1], this.bm);
            int iC3 = c(fArr[2], this.lr);
            if (tt(iC, iC2, iC3, true)) {
                c(iC, iC2, iC3, true);
                sp(2);
            } else if (this.tk == 1) {
                this.hd = iC;
                this.bm = iC2;
                this.lr = iC3;
            } else {
                this.hd = iC | this.hd;
                this.bm |= iC2;
                this.lr = iC3 | this.lr;
            }
            c(1, sensorEvent.values);
        }
    }

    private boolean c(boolean z, boolean z2, boolean z3, boolean z4) {
        if (!z) {
            tt(false);
            return true;
        }
        int iA = z2 ? a(this.zb[0]) : 0;
        int iA2 = z3 ? a(this.zb[1]) : 0;
        int iA3 = z4 ? a(this.zb[2]) : 0;
        if (this.my != 7) {
            tt(false);
        }
        if (c(iA, this.hd) || c(iA2, this.bm) || c(iA3, this.lr)) {
            c(iA, iA2, iA3, true);
            return true;
        }
        if (this.tk != 1) {
            c(iA, iA2, iA3, false);
        } else if (z2 || z3 || z4) {
            this.hd = iA;
            this.bm = iA2;
            this.lr = iA3;
        }
        return false;
    }

    private int c(float f, int i) {
        if (f != 0.0f) {
            return a(f);
        }
        if (i == 0) {
            return 0;
        }
        return i == 2 ? 1 : 2;
    }

    private boolean tt(int i, int i2, int i3, boolean z) {
        boolean zC;
        boolean zC2;
        boolean zC3;
        boolean zC4;
        int i4 = this.to;
        if (i4 == 1) {
            int i5 = this.lr;
            if (z) {
                zC = c(i3, i5);
            } else {
                zC = c(i3, i5, this.pu);
            }
        } else if (i4 == 2) {
            int i6 = this.bm;
            if (z) {
                zC = c(i2, i6);
            } else {
                zC = c(i2, i6, this.lo);
            }
        } else {
            if (i4 != 4) {
                if (i4 != 7) {
                    if (z) {
                        zC2 = c(i, this.hd);
                        zC3 = c(i2, this.bm);
                        zC4 = c(i3, this.lr);
                    } else {
                        zC2 = c(i, this.hd, this.l);
                        zC3 = c(i2, this.bm, this.lo);
                        zC4 = c(i3, this.lr, this.pu);
                    }
                    if (zC2 || zC3 || zC4) {
                        return true;
                    }
                } else if (z) {
                    if (c(i, this.hd) && c(i2, this.bm) && c(i3, this.lr)) {
                        return true;
                    }
                } else if (c(i, this.hd, this.l) && c(i2, this.bm, this.lo) && c(i3, this.lr, this.pu)) {
                    return true;
                }
                return false;
            }
            int i7 = this.hd;
            if (z) {
                zC = c(i, i7);
            } else {
                zC = c(i, i7, this.l);
            }
        }
        return zC;
    }

    private void sp(float f) {
        if (!c(this.my == 7, f) || System.currentTimeMillis() - this.sp <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return;
        }
        tt(false);
        if (this.t != null) {
            x(13);
            this.t.c(getType());
        }
        this.sp = System.currentTimeMillis();
    }

    private void x(int i) {
        gr.c().c(this.v, i);
    }

    private void i(int i) {
        try {
            this.v = i;
            gr.c().c(this.v, "calculation_method", Integer.valueOf(this.da));
            gr.c().c(this.v, "calculation_method_twist", Integer.valueOf(this.my));
            gr.c().c(this.v, "shake_threshold", Float.valueOf(this.x));
            gr.c().c(this.v, "twist_threshold", Float.valueOf(this.i));
            gr.c().c(this.v, "twist_single_threshold", Boolean.valueOf(this.qp));
            gr.c().c(this.v, "twist_x_threshold", Float.valueOf(this.pf));
            gr.c().c(this.v, "twist_y_threshold", Float.valueOf(this.sv));
            gr.c().c(this.v, "twist_z_threshold", Float.valueOf(this.ic));
        } catch (Throwable unused) {
        }
    }

    private void da() {
        gr.c().ve(this.v);
    }

    private void c(int i, float[] fArr) {
        gr.c().c(this.v, i, fArr);
    }
}
