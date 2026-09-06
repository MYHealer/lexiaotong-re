package com.ubix.ssp.ad.e.t.a;

import android.graphics.Bitmap;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends Thread {
    private d A;
    private boolean B;
    private byte[] C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private int I;
    private int J;
    private short[] K;
    private byte[] L;
    private byte[] M;
    private byte[] N;
    private d O;
    private d P;
    private int Q;
    private b R;
    private byte[] S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8862a;
    public int b;
    private InputStream c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private Bitmap y;
    private Bitmap z;

    public c(InputStream inputStream, b bVar) {
        this.g = 1;
        this.A = null;
        this.B = false;
        this.C = new byte[256];
        this.D = 0;
        this.F = 0;
        this.G = 0;
        this.H = false;
        this.I = 0;
        this.S = null;
        this.c = inputStream;
        this.R = bVar;
    }

    public c(byte[] bArr, b bVar) {
        this.g = 1;
        this.A = null;
        this.B = false;
        this.C = new byte[256];
        this.D = 0;
        this.F = 0;
        this.G = 0;
        this.H = false;
        this.I = 0;
        this.S = bArr;
        this.R = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [short] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private void a() {
        int i;
        short s;
        int i2 = this.s * this.t;
        byte[] bArr = this.N;
        if (bArr == null || bArr.length < i2) {
            this.N = new byte[i2];
        }
        if (this.K == null) {
            this.K = new short[4096];
        }
        if (this.L == null) {
            this.L = new byte[4096];
        }
        if (this.M == null) {
            this.M = new byte[4097];
        }
        int iH = h();
        int i3 = 1 << iH;
        int i4 = i3 + 1;
        int i5 = i3 + 2;
        int i6 = iH + 1;
        int i7 = (1 << i6) - 1;
        for (int i8 = 0; i8 < i3; i8++) {
            this.K[i8] = 0;
            this.L[i8] = (byte) i8;
        }
        int i9 = i6;
        int i10 = i7;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = -1;
        int i20 = i5;
        while (i12 < i2) {
            if (i13 != 0) {
                i = i6;
            } else if (i14 < i9) {
                if (i16 == 0) {
                    i16 = i();
                    if (i16 <= 0) {
                        break;
                    } else {
                        i17 = 0;
                    }
                }
                i15 += (this.C[i17] & 255) << i14;
                i14 += 8;
                i17++;
                i16--;
            } else {
                int i21 = i15 & i10;
                i15 >>= i9;
                i14 -= i9;
                if (i21 > i20 || i21 == i4) {
                    break;
                }
                if (i21 == i3) {
                    i9 = i6;
                    i20 = i5;
                    i10 = i7;
                    i19 = -1;
                } else if (i19 == -1) {
                    this.M[i13] = this.L[i21];
                    i11 = i21;
                    i19 = i11;
                    i13++;
                } else {
                    if (i21 == i20) {
                        this.M[i13] = (byte) i11;
                        s = i19;
                        i13++;
                    } else {
                        s = i21;
                    }
                    while (s > i3) {
                        this.M[i13] = this.L[s];
                        s = this.K[s];
                        i13++;
                        i6 = i6;
                    }
                    i = i6;
                    byte[] bArr2 = this.L;
                    i11 = bArr2[s] & 255;
                    if (i20 >= 4096) {
                        break;
                    }
                    int i22 = i13 + 1;
                    byte b = (byte) i11;
                    this.M[i13] = b;
                    this.K[i20] = (short) i19;
                    bArr2[i20] = b;
                    i20++;
                    if ((i20 & i10) == 0 && i20 < 4096) {
                        i9++;
                        i10 += i20;
                    }
                    i13 = i22;
                    i19 = i21;
                }
            }
            i13--;
            this.N[i18] = this.M[i13];
            i12++;
            i18++;
            i6 = i;
        }
        for (int i23 = i18; i23 < i2; i23++) {
            this.N[i23] = 0;
        }
    }

    private boolean b() {
        return this.d != 0;
    }

    private int[] c(int i) {
        int i2;
        int i3 = i * 3;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.c.read(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        if (i2 < i3) {
            this.d = 1;
            return null;
        }
        int[] iArr = new int[256];
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = bArr[i4] & 255;
            int i7 = i4 + 2;
            int i8 = bArr[i4 + 1] & 255;
            i4 += 3;
            iArr[i5] = (i8 << 8) | (i6 << 16) | (-16777216) | (bArr[i7] & 255);
        }
        return iArr;
    }

    private void f() {
        this.d = 0;
        this.Q = 0;
        this.O = null;
        this.h = null;
        this.i = null;
    }

    private int h() {
        try {
            return this.c.read();
        } catch (Exception unused) {
            this.d = 1;
            return 0;
        }
    }

    private int i() {
        int i;
        int iH = h();
        this.D = iH;
        int i2 = 0;
        if (iH > 0) {
            while (true) {
                try {
                    int i3 = this.D;
                    if (i2 >= i3 || (i = this.c.read(this.C, i2, i3 - i2)) == -1) {
                        break;
                    }
                    i2 += i;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i2 < this.D) {
                this.d = 1;
            }
        }
        return i2;
    }

    private int j() {
        this.c = new ByteArrayInputStream(this.S);
        this.S = null;
        return r();
    }

    private void k() {
        boolean z = false;
        while (!z && !b()) {
            int iH = h();
            if (iH != 0) {
                if (iH == 33) {
                    int iH2 = h();
                    if (iH2 != 249) {
                        if (iH2 == 255) {
                            i();
                            StringBuffer stringBuffer = new StringBuffer();
                            for (int i = 0; i < 11; i++) {
                                stringBuffer.append((char) this.C[i]);
                            }
                            if (stringBuffer.toString().equals("NETSCAPE2.0")) {
                                p();
                            }
                        }
                        u();
                    } else {
                        l();
                    }
                } else if (iH == 44) {
                    n();
                } else if (iH != 59) {
                    this.d = 1;
                } else {
                    z = true;
                }
            }
        }
    }

    private void l() {
        h();
        int iH = h();
        int i = (iH & 28) >> 2;
        this.F = i;
        if (i == 0) {
            this.F = 1;
        }
        this.H = (iH & 1) != 0;
        this.I = q() * 10;
        this.J = h();
        h();
    }

    private void m() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append((char) h());
        }
        if (!stringBuffer.toString().startsWith("GIF")) {
            this.d = 1;
            return;
        }
        o();
        if (!this.e || b()) {
            return;
        }
        int[] iArrC = c(this.f);
        this.h = iArrC;
        this.l = iArrC[this.k];
    }

    private void n() {
        this.q = q();
        this.r = q();
        this.s = q();
        this.t = q();
        int iH = h();
        int i = 0;
        boolean z = (iH & 128) != 0;
        this.n = z;
        this.o = (iH & 64) != 0;
        int i2 = 2 << (iH & 7);
        this.p = i2;
        if (z) {
            int[] iArrC = c(i2);
            this.i = iArrC;
            this.j = iArrC;
        } else {
            this.j = this.h;
            if (this.k == this.J) {
                this.l = 0;
            }
        }
        if (this.H) {
            int[] iArr = this.j;
            int i3 = this.J;
            int i4 = iArr[i3];
            iArr[i3] = 0;
            i = i4;
        }
        if (this.j == null) {
            this.d = 1;
        }
        if (b()) {
            return;
        }
        a();
        u();
        if (b()) {
            return;
        }
        this.Q++;
        Bitmap bitmapA = a.a().a(1);
        this.y = bitmapA;
        if (bitmapA == null) {
            this.y = Bitmap.createBitmap(this.f8862a, this.b, Bitmap.Config.ARGB_4444);
            a.a().a(1, this.y);
        }
        t();
        int iHashCode = this.y.hashCode();
        a.a().a(this.y);
        if (this.O == null) {
            d dVar = new d(a.a().a(iHashCode), this.I);
            this.O = dVar;
            this.A = dVar;
        } else {
            d dVar2 = this.P;
            if (dVar2 == null) {
                this.P = new d(a.a().a(iHashCode), this.I);
            } else {
                dVar2.c = new d(a.a().a(iHashCode), this.I);
                this.P = this.P.c;
            }
            d dVar3 = this.O;
            if (dVar3.c == null) {
                dVar3.c = this.P;
            }
        }
        if (this.H) {
            this.j[this.J] = i;
        }
        s();
        this.R.a(true, this.Q);
    }

    private void o() {
        this.f8862a = q();
        this.b = q();
        int iH = h();
        this.e = (iH & 128) != 0;
        this.f = 2 << (iH & 7);
        this.k = h();
        this.E = h();
    }

    private void p() {
        do {
            i();
            byte[] bArr = this.C;
            if (bArr[0] == 1) {
                this.g = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.D <= 0) {
                return;
            }
        } while (!b());
    }

    private int q() {
        return h() | (h() << 8);
    }

    private int r() {
        f();
        if (this.c != null) {
            m();
            if (!b()) {
                k();
                if (this.Q < 0) {
                    this.d = 1;
                    this.R.a(false, -1);
                } else {
                    this.d = -1;
                    this.R.a(true, -1);
                }
            }
            InputStream inputStream = this.c;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.d = 2;
            this.R.a(false, -1);
        }
        return this.d;
    }

    private void s() {
        this.G = this.F;
        this.u = this.q;
        this.v = this.r;
        this.w = this.s;
        this.x = this.t;
        this.z = this.y;
        this.m = this.l;
        this.F = 0;
        this.H = false;
        this.I = 0;
        this.i = null;
    }

    private void t() {
        int i;
        int[] iArr = new int[this.f8862a * this.b];
        int i2 = this.G;
        int i3 = 0;
        if (i2 > 0) {
            if (i2 == 3) {
                int i4 = this.Q;
                this.z = i4 + (-2) > 0 ? b(i4 - 3) : null;
            }
            Bitmap bitmap = this.z;
            if (bitmap != null) {
                int i5 = this.f8862a;
                bitmap.getPixels(iArr, 0, i5, 0, 0, i5, this.b);
                if (this.G == 2) {
                    int i6 = !this.H ? this.m : 0;
                    for (int i7 = 0; i7 < this.x; i7++) {
                        int i8 = ((this.v + i7) * this.f8862a) + this.u;
                        int i9 = this.w + i8;
                        while (i8 < i9) {
                            iArr[i8] = i6;
                            i8++;
                        }
                    }
                }
            }
        }
        int i10 = 8;
        int i11 = 1;
        int i12 = 0;
        while (true) {
            int i13 = this.t;
            if (i3 >= i13) {
                this.y = Bitmap.createBitmap(iArr, this.f8862a, this.b, Bitmap.Config.ARGB_4444);
                return;
            }
            if (this.o) {
                if (i12 >= i13) {
                    i11++;
                    if (i11 == 2) {
                        i12 = 4;
                    } else if (i11 == 3) {
                        i10 = 4;
                        i12 = 2;
                    } else if (i11 == 4) {
                        i12 = 1;
                        i10 = 2;
                    }
                }
                i = i12 + i10;
            } else {
                i = i12;
                i12 = i3;
            }
            int i14 = i12 + this.r;
            if (i14 < this.b) {
                int i15 = this.f8862a;
                int i16 = i14 * i15;
                int i17 = this.q + i16;
                int i18 = this.s;
                int i19 = i17 + i18;
                int i20 = i16 + i15;
                if (i20 < i19) {
                    i19 = i20;
                }
                int i21 = i18 * i3;
                while (i17 < i19) {
                    int i22 = i21 + 1;
                    int i23 = this.j[this.N[i21] & 255];
                    if (i23 != 0) {
                        iArr[i17] = i23;
                    }
                    i17++;
                    i21 = i22;
                }
            }
            i3++;
            i12 = i;
        }
    }

    private void u() {
        do {
            i();
            if (this.D <= 0) {
                return;
            }
        } while (!b());
    }

    public d a(int i) {
        d dVar = this.O;
        int i2 = 0;
        while (dVar != null) {
            if (i2 == i) {
                return dVar;
            }
            dVar = dVar.c;
            i2++;
        }
        return null;
    }

    public Bitmap b(int i) {
        d dVarA = a(i);
        if (dVarA == null) {
            return null;
        }
        return dVarA.f8863a;
    }

    public void c() {
        d dVar = this.O;
        while (dVar != null) {
            if (!dVar.f8863a.isRecycled()) {
                dVar.f8863a.recycle();
                dVar.f8863a = null;
            }
            dVar = this.O.c;
            this.O = dVar;
        }
        InputStream inputStream = this.c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.S = null;
    }

    public int d() {
        return this.Q;
    }

    public Bitmap e() {
        return b(0);
    }

    public d g() {
        d dVar;
        if (!this.B) {
            this.B = true;
            return this.O;
        }
        if (this.d == 0) {
            dVar = this.A.c;
            if (dVar != null) {
                this.A = dVar;
            }
        } else {
            d dVar2 = this.A.c;
            this.A = dVar2;
            if (dVar2 == null) {
                dVar = this.O;
                this.A = dVar;
            }
        }
        return this.A;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (this.c != null) {
                r();
            } else if (this.S != null) {
                j();
            }
        } catch (Exception e) {
            e.printStackTrace();
            c();
        } catch (Throwable unused) {
            c();
            this.R.a(this.S);
        }
    }
}
