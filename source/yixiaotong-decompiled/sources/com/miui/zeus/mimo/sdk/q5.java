package com.miui.zeus.mimo.sdk;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q5 implements SensorEventListener {
    public static final String O = "q5";
    public int B;
    public int C;
    public int D;
    public double E;
    public HandlerThread M;
    public Handler N;
    public b e;
    public SensorManager f;
    public Sensor g;
    public TimerTask l;
    public Sensor m;
    public int[] u;
    public int[] v;
    public int[] w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingDeque<Float> f5572a = new LinkedBlockingDeque<>(5);
    public final LinkedBlockingDeque<Boolean> b = new LinkedBlockingDeque<>(10);
    public int c = 500;
    public long d = -1;
    public int h = 15;
    public long i = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    public boolean j = false;
    public Timer k = new Timer();
    public float[] n = new float[9];
    public float[] o = new float[3];
    public boolean p = false;
    public double q = 0.0d;
    public double r = 0.0d;
    public double s = 0.0d;
    public int t = 35;
    public int x = 100;
    public int y = 0;
    public int z = 0;
    public int A = 0;
    public long F = 0;
    public Timer G = new Timer();
    public boolean H = false;
    public boolean I = false;
    public boolean J = false;
    public boolean K = false;
    public int L = 3;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q5.a(q5.this);
        }
    }

    public interface b {
    }

    public static void a(q5 q5Var) {
        if (q5Var.j) {
            return;
        }
        q5Var.j = true;
        long jCurrentTimeMillis = System.currentTimeMillis() - q5Var.d;
        b bVar = q5Var.e;
        int i = q5Var.B;
        int i2 = q5Var.C;
        int i3 = q5Var.D;
        double d = q5Var.E;
        k8.b bVar2 = (k8.b) bVar;
        k8.this.a();
        if (k8.this.g != null) {
            System.out.println(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 95, 5, 91, 80, 69, Ascii.EM, 37, 8, 5, 93, 0, 95}, "e7d05e") + i + ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 73, 121, 94, 2, 9, 4, 94}, "4080ee") + i2 + ijiami_1011.s.s.s.d(new byte[]{70, Ascii.EM, 37, 13, 4, 8, 4, 94}, "fcdccd") + i3 + ijiami_1011.s.s.s.d(new byte[]{70, 6, 76, 67, 88, Ascii.NAK, 8, 11, 8, 88}, "fb919a") + jCurrentTimeMillis);
            k8 k8Var = k8.this;
            l6 l6Var = new l6();
            l6Var.d = i + "";
            l6Var.e = i2 + "";
            l6Var.f = i3 + "";
            l6Var.h = jCurrentTimeMillis;
            l6Var.g = d + "";
            l6Var.i = ijiami_1011.s.s.s.d(new byte[]{101, 16, 67, 15}, "1e1a4a");
            k8Var.h = l6Var;
            k8 k8Var2 = k8.this;
            k8Var2.g.onClick(k8Var2, k8Var2.getClickAreaType());
        }
        q5Var.b();
    }

    public final void a() {
        if (c()) {
            x8.e(new a());
        }
    }

    public final boolean a(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        if (iArr[2] == 0) {
            return (i >= 0 && i <= iArr[0]) || (i >= iArr[1] && i <= 360);
        }
        return i >= iArr[0] && i <= iArr[1];
    }

    public final boolean a(LinkedBlockingDeque<Float> linkedBlockingDeque) {
        Iterator<Float> it = linkedBlockingDeque.iterator();
        float f = Float.MAX_VALUE;
        float f2 = Float.MIN_VALUE;
        while (it.hasNext()) {
            float fFloatValue = it.next().floatValue();
            if (fFloatValue < f) {
                f = fFloatValue;
            }
            if (fFloatValue > f2) {
                f2 = fFloatValue;
            }
        }
        return (f == Float.MAX_VALUE || f2 == Float.MIN_VALUE || f2 - f <= 2.0f) ? false : true;
    }

    public final int[] a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (i2 >= 180) {
            i2 = 179;
        }
        int i6 = i - i2;
        int i7 = 0;
        int i8 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        if (i6 >= 0 && (i5 = i + i2) <= 360) {
            i8 = i5;
        } else if (i6 <= 0 && (i4 = i + i2) <= 360) {
            i8 = i6 + MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
            i7 = 1;
            i6 = i4;
        } else if (i6 < 0 || (i3 = i + i2) < 360) {
            i6 = 0;
        } else {
            i8 = i6;
            i7 = 1;
            i6 = i3 - MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        }
        return new int[]{i6, i8, i7};
    }

    public void b() {
        SensorManager sensorManager = this.f;
        if (sensorManager != null) {
            Sensor sensor = this.g;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
                this.g = null;
            }
            Sensor sensor2 = this.m;
            if (sensor2 != null) {
                this.f.unregisterListener(this, sensor2);
                this.m = null;
            }
            this.f = null;
        }
        TimerTask timerTask = this.l;
        if (timerTask != null) {
            timerTask.cancel();
            this.l = null;
        }
        Timer timer = this.k;
        if (timer != null) {
            timer.cancel();
            this.k = null;
        }
        Timer timer2 = this.G;
        if (timer2 != null) {
            timer2.cancel();
            this.G = null;
        }
        HandlerThread handlerThread = this.M;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.M = null;
            this.N = null;
        }
    }

    public final boolean b(LinkedBlockingDeque<Boolean> linkedBlockingDeque) {
        Iterator<Boolean> it = linkedBlockingDeque.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().booleanValue()) {
                i++;
            }
        }
        return i >= ((int) (((float) linkedBlockingDeque.size()) * 0.3f));
    }

    public final boolean c() {
        int i = this.L;
        if (i == 1) {
            return this.J || this.I || a(this.f5572a) || b(this.b);
        }
        if (i == 2) {
            return this.J || this.I;
        }
        return this.J && this.I;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Code duplicated, block: B:108:0x023a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0243  */
    /* JADX WARN: Code duplicated, block: B:112:0x0251  */
    /* JADX WARN: Code duplicated, block: B:113:0x025f  */
    /* JADX WARN: Code duplicated, block: B:125:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:131:0x029e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x013a  */
    /* JADX WARN: Code duplicated, block: B:62:0x0143  */
    /* JADX WARN: Code duplicated, block: B:65:0x0153  */
    /* JADX WARN: Code duplicated, block: B:72:0x0173  */
    /* JADX WARN: Code duplicated, block: B:74:0x019a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:78:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:84:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:88:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:90:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:93:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:95:0x01f1  */
    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        int i;
        int iAbs;
        boolean z;
        int i2;
        if (this.d < 0) {
            this.d = System.currentTimeMillis() + ((long) this.c);
        }
        if (System.currentTimeMillis() <= this.d || sensorEvent == null) {
            return;
        }
        if (sensorEvent.sensor.getType() == 11 && (fArr = sensorEvent.values) != null && fArr.length > 2 && Float.compare(fArr[0], 0.0f) != 0 && Float.compare(sensorEvent.values[1], 0.0f) != 0 && Float.compare(sensorEvent.values[2], 0.0f) != 0 && this.f != null) {
            SensorManager.getRotationMatrixFromVector(this.n, sensorEvent.values);
            SensorManager.getOrientation(this.n, this.o);
            if (this.p) {
                this.B = (int) (Math.toDegrees(this.o[1]) + 90.0d);
                double degrees = Math.toDegrees(this.o[2]);
                if (degrees <= 0.0d) {
                    degrees += 360.0d;
                }
                this.C = (int) degrees;
                double degrees2 = Math.toDegrees(this.o[0]);
                if (degrees2 <= 0.0d) {
                    degrees2 += 360.0d;
                }
                this.D = (int) degrees2;
                boolean zA = a(this.B, this.u);
                boolean zA2 = a(this.C, this.v);
                boolean zA3 = a(this.D, this.w);
                if ((zA || zA3 || zA2) && !this.I) {
                    this.I = true;
                    if (this.L == 1) {
                        a();
                    } else if (this.i - 1000 >= 0) {
                        if (System.currentTimeMillis() - this.F >= this.x) {
                            this.F = System.currentTimeMillis();
                            i = this.y;
                            if (i != 0 && this.z == 0 && this.A == 0) {
                                this.y = this.B;
                                this.z = this.C;
                                this.A = this.D;
                            } else {
                                int iAbs2 = Math.abs(this.B - i);
                                int iAbs3 = Math.abs(this.C - this.z);
                                iAbs = Math.abs(this.D - this.A);
                                this.y = this.B;
                                this.z = this.C;
                                this.A = this.D;
                                if (iAbs < 2 || iAbs2 >= 2 || iAbs3 >= 2) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (this.b.size() < 10) {
                                    this.b.add(Boolean.valueOf(z));
                                } else {
                                    this.b.removeFirst();
                                    this.b.add(Boolean.valueOf(z));
                                    if (this.L == 1 && !b(this.b)) {
                                        this.H = false;
                                        this.G.cancel();
                                    } else if (!this.H) {
                                        this.H = true;
                                        try {
                                            this.G.schedule(new r5(this), this.i - 1000);
                                        } catch (Exception unused) {
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.I) {
                        m.b(O, ijiami_1011.s.s.s.d(new byte[]{93, 16, 8, 1, 91, Ascii.NAK, 0, 16, 15, 13, 95, 69, 83, 1, Ascii.NAK, 13, 90, 15, 65, 10, 9, 66, 69, 12, 95, 7}, "2bad5a"));
                        a();
                    }
                } else if (this.i - 1000 >= 0) {
                    if (System.currentTimeMillis() - this.F >= this.x) {
                        this.F = System.currentTimeMillis();
                        i = this.y;
                        if (i != 0) {
                            int iAbs4 = Math.abs(this.B - i);
                            int iAbs5 = Math.abs(this.C - this.z);
                            iAbs = Math.abs(this.D - this.A);
                            this.y = this.B;
                            this.z = this.C;
                            this.A = this.D;
                            if (iAbs < 2) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (this.b.size() < 10) {
                                this.b.add(Boolean.valueOf(z));
                            } else {
                                this.b.removeFirst();
                                this.b.add(Boolean.valueOf(z));
                                if (this.L == 1) {
                                    if (!this.H) {
                                        this.H = true;
                                        this.G.schedule(new r5(this), this.i - 1000);
                                    }
                                } else if (!this.H) {
                                    this.H = true;
                                    this.G.schedule(new r5(this), this.i - 1000);
                                }
                            }
                        } else {
                            int iAbs6 = Math.abs(this.B - i);
                            int iAbs7 = Math.abs(this.C - this.z);
                            iAbs = Math.abs(this.D - this.A);
                            this.y = this.B;
                            this.z = this.C;
                            this.A = this.D;
                            if (iAbs < 2) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (this.b.size() < 10) {
                                this.b.add(Boolean.valueOf(z));
                            } else {
                                this.b.removeFirst();
                                this.b.add(Boolean.valueOf(z));
                                if (this.L == 1) {
                                    if (!this.H) {
                                        this.H = true;
                                        this.G.schedule(new r5(this), this.i - 1000);
                                    }
                                } else if (!this.H) {
                                    this.H = true;
                                    this.G.schedule(new r5(this), this.i - 1000);
                                }
                            }
                        }
                    }
                } else if (this.I) {
                    m.b(O, ijiami_1011.s.s.s.d(new byte[]{93, 16, 8, 1, 91, Ascii.NAK, 0, 16, 15, 13, 95, 69, 83, 1, Ascii.NAK, 13, 90, 15, 65, 10, 9, 66, 69, 12, 95, 7}, "2bad5a"));
                    a();
                }
            } else {
                this.q = Math.toDegrees(this.o[1]) + 90.0d;
                double degrees3 = Math.toDegrees(this.o[2]);
                if (degrees3 <= 0.0d) {
                    degrees3 += 360.0d;
                }
                this.r = degrees3;
                double degrees4 = Math.toDegrees(this.o[0]);
                if (degrees4 <= 0.0d) {
                    degrees4 += 360.0d;
                }
                this.s = degrees4;
                int i3 = (int) this.q;
                int i4 = this.t;
                int i5 = i3 - i4;
                int i6 = 180;
                if (i5 < 0) {
                    i5 = i3 + i4;
                    i2 = 1;
                } else {
                    int i7 = i3 + i4;
                    if (i7 > 180) {
                        i2 = 1;
                        i6 = i5;
                        i5 = 0;
                    } else if (i5 <= 0 || i7 >= 180) {
                        i2 = 0;
                        i5 = 0;
                    } else {
                        i6 = i7;
                        i2 = 0;
                    }
                }
                this.u = new int[]{i5, i6, i2};
                this.v = a((int) this.r, i4);
                this.w = a((int) this.s, this.t);
                this.p = true;
            }
        }
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr2 = sensorEvent.values;
            float f = fArr2[0];
            float f2 = fArr2[1];
            float f3 = fArr2[2];
            double dSqrt = Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
            this.E = dSqrt;
            if (!this.J) {
                boolean z2 = dSqrt > ((double) this.h);
                this.J = z2;
                if (this.L != 1 || !z2) {
                    if (this.i - 500 >= 0) {
                        if (this.f5572a.size() < 5) {
                            this.f5572a.add(Float.valueOf((float) (this.E - 9.800000190734863d)));
                            return;
                        }
                        this.f5572a.removeFirst();
                        this.f5572a.add(Float.valueOf((float) (this.E - 9.800000190734863d)));
                        if (this.L != 1) {
                        }
                        if (!this.K) {
                            r5 r5Var = new r5(this);
                            this.l = r5Var;
                            this.k.schedule(r5Var, this.i - 500);
                        }
                        this.K = true;
                        return;
                    }
                    if (!this.J) {
                        return;
                    }
                }
            } else {
                if (this.i - 500 >= 0) {
                    if (this.f5572a.size() < 5) {
                        this.f5572a.add(Float.valueOf((float) (this.E - 9.800000190734863d)));
                        return;
                    }
                    this.f5572a.removeFirst();
                    this.f5572a.add(Float.valueOf((float) (this.E - 9.800000190734863d)));
                    if (this.L != 1 || a(this.f5572a)) {
                        if (!this.K) {
                            try {
                                r5 r5Var2 = new r5(this);
                                this.l = r5Var2;
                                this.k.schedule(r5Var2, this.i - 500);
                            } catch (Exception unused2) {
                            }
                        }
                        this.K = true;
                        return;
                    }
                    m.a(O, ijiami_1011.s.s.s.d(new byte[]{87, 90, 87, Ascii.EM, Ascii.SYN, 17, 14, Ascii.DC4, 70, 17, 89, 4, 93, 92}, "6949ee"));
                    this.K = false;
                    TimerTask timerTask = this.l;
                    if (timerTask != null) {
                        timerTask.cancel();
                        return;
                    }
                    return;
                }
                if (!this.J) {
                    return;
                }
            }
            a();
        }
    }
}
