package com.huawei.hms.ads;

import android.graphics.Bitmap;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class dx {
    private static final int B = 1;
    private static final int C = 2;
    private static final int D = 33;
    private static final int F = 44;
    private static final int I = 4096;
    private static final int L = 249;
    private static final int S = 3;
    private static final int Z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f3821a = 62914560;
    private static final String b = "dx";
    public int Code;
    private int[] E;
    private int G;
    private Bitmap J;
    private int[] K;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int T;
    private int U;
    public int V;
    private int W;
    private final int c;
    private InputStream d;
    private boolean j;
    private boolean k;
    private boolean l;
    private short[] m;
    private byte[] n;
    private byte[] p;
    private byte[] q;
    private int r;
    private int v;
    private int w;
    private int x;
    private int y;
    private final Object e = new Object();
    private final Object f = new Object();
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private byte[] o = new byte[512];
    private int s = 100;
    private int t = 0;
    private int u = 0;
    private int[] z = null;
    private int[] A = null;
    private int H = 0;
    private int M = 0;
    private int X = 0;
    private int[] Y = null;

    public dx(InputStream inputStream, int i) {
        this.d = inputStream;
        this.c = i;
        Z();
    }

    private void B() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append((char) C());
        }
        if (!stringBuffer.toString().startsWith("GIF")) {
            this.u = 1;
            return;
        }
        S();
        if (!this.j || D()) {
            return;
        }
        int[] iArrCode = Code(this.v);
        this.z = iArrCode;
        this.y = iArrCode[this.x];
    }

    private int C() {
        try {
            return this.d.read();
        } catch (Exception unused) {
            this.u = 1;
            return 0;
        }
    }

    private Bitmap Code(int[] iArr, int i, int i2, Bitmap bitmap) {
        if (bitmap == null) {
            Bitmap.Config config = com.huawei.openalliance.ad.utils.z.V() > f3821a ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (fh.Code()) {
                fh.Code(b, "create image with config %s", config);
            }
            bitmap = Bitmap.createBitmap(i, i2, config);
        }
        bitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return bitmap;
    }

    private void Code(boolean z) {
        synchronized (this.f) {
            this.h = z;
        }
    }

    private int[] Code(int i) {
        int i2;
        int[] iArr = new int[256];
        int i3 = i * 3;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.d.read(bArr);
        } catch (Exception unused) {
            fh.I(b, "read color table fail");
            i2 = 0;
        }
        if (i2 < i3) {
            this.u = 1;
        } else {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = bArr[i4] & 255;
                int i7 = i4 + 2;
                int i8 = bArr[i4 + 1] & 255;
                i4 += 3;
                iArr[i5] = (i8 << 8) | (i6 << 16) | (-16777216) | (bArr[i7] & 255);
            }
        }
        return iArr;
    }

    private boolean D() {
        return this.u != 0;
    }

    private int F() {
        return C() | (C() << 8);
    }

    private dz L() {
        dz dzVar = null;
        try {
            int iA = a();
            if (D()) {
                return null;
            }
            b();
            d();
            if (D()) {
                return null;
            }
            e();
            if (D()) {
                return null;
            }
            if (this.J != null) {
                this.M++;
                dzVar = new dz(this.M, this.J, this.s);
            }
            if (this.i) {
                this.E[this.G] = iA;
            }
            g();
        } catch (Exception | StackOverflowError unused) {
            this.u = 1;
            fh.I(b, "read image error");
        } catch (OutOfMemoryError unused2) {
            this.u = 1;
            fh.I(b, "run out of memory");
            f();
        }
        return dzVar;
    }

    private void S() {
        this.Code = F();
        this.V = F();
        int iC = C();
        this.j = (iC & 128) != 0;
        this.v = (int) Math.pow(2.0d, (iC & 7) + 1);
        this.x = C();
        C();
    }

    private void V(int i) {
        byte[] bArr = this.q;
        if (bArr == null || bArr.length < i) {
            this.q = new byte[i];
        }
        if (this.m == null) {
            this.m = new short[4096];
        }
        if (this.n == null) {
            this.n = new byte[4096];
        }
        if (this.p == null) {
            this.p = new byte[4097];
        }
    }

    private void Z() {
        if (this.d == null) {
            Code(true);
            return;
        }
        B();
        if (D()) {
            Code(true);
            V();
        }
    }

    private int a() {
        int[] iArr;
        this.N = F();
        this.O = F();
        this.P = F();
        this.Q = F();
        int iC = C();
        int i = 0;
        this.k = (iC & 128) != 0;
        this.l = (iC & 64) != 0;
        int iPow = (int) Math.pow(2.0d, (iC & 7) + 1);
        this.w = iPow;
        if (this.k) {
            int[] iArrCode = Code(iPow);
            this.A = iArrCode;
            this.E = iArrCode;
        } else {
            this.E = this.z;
            if (this.x == this.G) {
                this.y = 0;
            }
        }
        if (this.i && (iArr = this.E) != null && iArr.length > 0) {
            int length = iArr.length;
            int i2 = this.G;
            if (length > i2) {
                int i3 = iArr[i2];
                iArr[i2] = 0;
                i = i3;
            }
        }
        if (this.E == null) {
            this.u = 1;
        }
        return i;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 2851. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private void b() {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.dx.b():void");
    }

    private void c() {
        C();
        int iC = C();
        int i = (iC & 28) >> 2;
        this.t = i;
        if (i == 0) {
            this.t = 1;
        }
        this.i = (iC & 1) != 0;
        int iF = F() * 10;
        this.s = iF;
        int i2 = this.c;
        if (i2 > iF) {
            this.s = i2;
        }
        this.G = C();
        C();
    }

    private void d() {
        do {
            h();
            if (this.X <= 0) {
                return;
            }
        } while (!D());
    }

    private void e() {
        int i;
        try {
            i();
            int i2 = 0;
            int i3 = 1;
            int i4 = 8;
            int i5 = 0;
            while (true) {
                int i6 = this.Q;
                if (i2 >= i6) {
                    this.J = Code(this.Y, this.Code, this.V, this.J);
                    return;
                }
                if (this.l) {
                    if (i5 >= i6) {
                        i3++;
                        if (i3 == 2) {
                            i5 = 4;
                        } else if (i3 == 3) {
                            i4 = 4;
                            i5 = 2;
                        } else if (i3 == 4) {
                            i5 = 1;
                            i4 = 2;
                        }
                    }
                    i = i5 + i4;
                } else {
                    i = i5;
                    i5 = i2;
                }
                int i7 = i5 + this.O;
                if (i7 < this.V) {
                    int i8 = this.Code;
                    int i9 = i7 * i8;
                    int i10 = this.N + i9;
                    int i11 = this.P;
                    int i12 = i10 + i11;
                    if (i9 + i8 < i12) {
                        i12 = i9 + i8;
                    }
                    int i13 = i11 * i2;
                    while (i10 < i12) {
                        int i14 = i13 + 1;
                        int i15 = this.E[this.q[i13] & 255];
                        if (i15 != 0) {
                            this.Y[i10] = i15;
                        }
                        i10++;
                        i13 = i14;
                    }
                }
                i2++;
                i5 = i;
            }
        } catch (Exception | StackOverflowError unused) {
            this.u = 1;
            fh.I(b, "set pixel error");
        }
    }

    private void f() {
        this.u = 3;
    }

    private void g() {
        this.H = this.t;
        this.R = this.N;
        this.T = this.O;
        this.U = this.P;
        this.W = this.Q;
        this.r = this.y;
        this.K = this.Y;
        this.i = false;
        this.t = 0;
        this.A = null;
        this.s = this.c;
    }

    private int h() {
        String str;
        String str2;
        int i;
        int iC = C();
        this.X = iC;
        int i2 = 0;
        if (iC > 0) {
            while (true) {
                try {
                    int i3 = this.X;
                    if (i2 >= i3 || (i = this.d.read(this.o, i2, i3 - i2)) == -1) {
                        break;
                    }
                    i2 += i;
                } catch (IOException unused) {
                    str = b;
                    str2 = "read block IOException";
                    fh.I(str, str2);
                } catch (Exception unused2) {
                    str = b;
                    str2 = "read block fail";
                    fh.I(str, str2);
                }
            }
            if (i2 < this.X) {
                this.u = 1;
            }
        }
        return i2;
    }

    private void i() {
        if (this.Y == null) {
            this.Y = new int[this.Code * this.V];
        }
        int i = this.H;
        if (i > 0) {
            if (3 == i) {
                this.K = null;
            }
            int[] iArr = this.K;
            if (iArr != null) {
                this.Y = iArr;
                if (2 == i) {
                    int i2 = !this.i ? this.r : 0;
                    for (int i3 = 0; i3 < this.W; i3++) {
                        int i4 = ((this.T + i3) * this.Code) + this.R;
                        int i5 = this.U + i4;
                        while (i4 < i5) {
                            this.Y[i4] = i2;
                            i4++;
                        }
                    }
                }
            }
        }
    }

    private boolean j() {
        boolean z;
        synchronized (this.f) {
            z = this.h;
        }
        return z;
    }

    public dz Code() {
        if (I()) {
            Code(true);
            return null;
        }
        while (!j()) {
            if (D()) {
                Code(true);
                break;
            }
            int iC = C();
            if (iC != 0) {
                if (iC != 33) {
                    if (iC == 44) {
                        dz dzVarL = L();
                        if (dzVarL != null) {
                            return dzVarL;
                        }
                    } else if (iC != 59) {
                        this.u = 1;
                    } else {
                        Code(true);
                    }
                } else if (249 == C()) {
                    c();
                } else {
                    d();
                }
            }
        }
        if (j()) {
            V();
        }
        return null;
    }

    public boolean I() {
        boolean z;
        synchronized (this.e) {
            z = this.g;
        }
        return z;
    }

    public void V() {
        synchronized (this.e) {
            if (!this.g) {
                this.g = true;
                com.huawei.openalliance.ad.utils.bb.Code((Closeable) this.d);
            }
        }
    }
}
