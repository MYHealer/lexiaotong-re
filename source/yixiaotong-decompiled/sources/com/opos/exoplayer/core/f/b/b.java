package com.opos.exoplayer.core.f.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.opos.exoplayer.core.i.o;
import com.opos.exoplayer.core.i.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f6424a = {0, 7, 8, 15};
    private static final byte[] b = {0, 119, -120, -1};
    private static final byte[] c = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint d;
    private final Paint e;
    private final Canvas f;
    private final C0923b g;
    private final a h;
    private final h i;
    private Bitmap j;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6425a;
        public final int[] b;
        public final int[] c;
        public final int[] d;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f6425a = i;
            this.b = iArr;
            this.c = iArr2;
            this.d = iArr3;
        }
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.f.b.b$b, reason: collision with other inner class name */
    private static final class C0923b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6426a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public C0923b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f6426a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6427a;
        public final boolean b;
        public final byte[] c;
        public final byte[] d;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.f6427a = i;
            this.b = z;
            this.c = bArr;
            this.d = bArr2;
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6428a;
        public final int b;
        public final SparseArray<e> c;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.f6428a = i2;
            this.b = i3;
            this.c = sparseArray;
        }
    }

    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6429a;
        public final int b;

        public e(int i, int i2) {
            this.f6429a = i;
            this.b = i2;
        }
    }

    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6430a;
        public final boolean b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final SparseArray<g> j;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.f6430a = i;
            this.b = z;
            this.c = i2;
            this.d = i3;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
            this.j = sparseArray;
        }

        public void a(f fVar) {
            if (fVar == null) {
                return;
            }
            SparseArray<g> sparseArray = fVar.j;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.j.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
    }

    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6431a;
        public final int b;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f6431a = i3;
            this.b = i4;
        }
    }

    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6432a;
        public final int b;
        public final SparseArray<f> c = new SparseArray<>();
        public final SparseArray<a> d = new SparseArray<>();
        public final SparseArray<c> e = new SparseArray<>();
        public final SparseArray<a> f = new SparseArray<>();
        public final SparseArray<c> g = new SparseArray<>();
        public C0923b h;
        public d i;

        public h(int i, int i2) {
            this.f6432a = i;
            this.b = i2;
        }

        public void a() {
            this.c.clear();
            this.d.clear();
            this.e.clear();
            this.f.clear();
            this.g.clear();
            this.h = null;
            this.i = null;
        }
    }

    public b(int i, int i2) {
        Paint paint = new Paint();
        this.d = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f = new Canvas();
        this.g = new C0923b(AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 575, 0, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 0, 575);
        this.h = new a(0, b(), c(), d());
        this.i = new h(i, i2);
    }

    private static int a(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static int a(o oVar, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int i3;
        int iC;
        int i4 = i;
        boolean z = false;
        while (true) {
            int iC2 = oVar.c(2);
            if (iC2 != 0) {
                z = z;
                i3 = 1;
            } else {
                if (oVar.e()) {
                    iC = oVar.c(3) + 3;
                } else {
                    if (oVar.e()) {
                        i3 = 1;
                    } else {
                        int iC3 = oVar.c(2);
                        if (iC3 == 0) {
                            z = true;
                        } else if (iC3 == 1) {
                            i3 = 2;
                        } else if (iC3 == 2) {
                            iC = oVar.c(4) + 12;
                        } else if (iC3 != 3) {
                            z = z;
                        } else {
                            iC = oVar.c(8) + 29;
                        }
                        iC2 = 0;
                        i3 = 0;
                    }
                    iC2 = 0;
                }
                z = z;
                i3 = iC;
                iC2 = oVar.c(2);
            }
            if (i3 != 0 && paint != null) {
                if (bArr != null) {
                    iC2 = bArr[iC2];
                }
                paint.setColor(iArr[iC2]);
                canvas.drawRect(i4, i2, i4 + i3, i2 + 1, paint);
            }
            i4 += i3;
            if (z) {
                return i4;
            }
            z = z;
        }
    }

    private static C0923b a(o oVar) {
        int i;
        int i2;
        int i3;
        int iC;
        oVar.b(4);
        boolean zE = oVar.e();
        oVar.b(3);
        int iC2 = oVar.c(16);
        int iC3 = oVar.c(16);
        if (zE) {
            int iC4 = oVar.c(16);
            int iC5 = oVar.c(16);
            int iC6 = oVar.c(16);
            iC = oVar.c(16);
            i3 = iC5;
            i2 = iC6;
            i = iC4;
        } else {
            i = 0;
            i2 = 0;
            i3 = iC2;
            iC = iC3;
        }
        return new C0923b(iC2, iC3, i, i3, i2, iC);
    }

    private static d a(o oVar, int i) {
        int iC = oVar.c(8);
        int iC2 = oVar.c(4);
        int iC3 = oVar.c(2);
        oVar.b(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int iC4 = oVar.c(8);
            oVar.b(8);
            i2 -= 6;
            sparseArray.put(iC4, new e(oVar.c(16), oVar.c(16)));
        }
        return new d(iC, iC2, iC3, sparseArray);
    }

    private static void a(c cVar, a aVar, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i == 3) {
            iArr = aVar.d;
        } else {
            iArr = i == 2 ? aVar.c : aVar.b;
        }
        int[] iArr2 = iArr;
        a(cVar.c, iArr2, i, i2, i3, paint, canvas);
        a(cVar.d, iArr2, i, i2, i3 + 1, paint, canvas);
    }

    private static void a(o oVar, h hVar) {
        SparseArray sparseArray;
        a aVar;
        int i;
        Object obj;
        c cVar;
        int iC = oVar.c(8);
        int iC2 = oVar.c(16);
        int iC3 = oVar.c(16);
        int iC4 = oVar.c() + iC3;
        if (iC3 * 8 > oVar.a()) {
            com.opos.cmn.an.f.a.c("DvbParser", "Data field length exceeds limit");
            oVar.b(oVar.a());
            return;
        }
        switch (iC) {
            case 16:
                if (iC2 == hVar.f6432a) {
                    d dVar = hVar.i;
                    d dVarA = a(oVar, iC3);
                    if (dVarA.b != 0) {
                        hVar.i = dVarA;
                        hVar.c.clear();
                        hVar.d.clear();
                        hVar.e.clear();
                    } else if (dVar != null && dVar.f6428a != dVarA.f6428a) {
                        hVar.i = dVarA;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.i;
                if (iC2 == hVar.f6432a && dVar2 != null) {
                    f fVarB = b(oVar, iC3);
                    if (dVar2.b == 0) {
                        fVarB.a(hVar.c.get(fVarB.f6430a));
                    }
                    hVar.c.put(fVarB.f6430a, fVarB);
                }
                break;
            case 18:
                if (iC2 == hVar.f6432a) {
                    a aVarC = c(oVar, iC3);
                    sparseArray = hVar.d;
                    aVar = aVarC;
                } else if (iC2 == hVar.b) {
                    a aVarC2 = c(oVar, iC3);
                    sparseArray = hVar.f;
                    aVar = aVarC2;
                }
                i = aVar.f6425a;
                obj = aVar;
                sparseArray.put(i, obj);
                break;
            case 19:
                if (iC2 == hVar.f6432a) {
                    c cVarB = b(oVar);
                    sparseArray = hVar.e;
                    cVar = cVarB;
                } else if (iC2 == hVar.b) {
                    c cVarB2 = b(oVar);
                    sparseArray = hVar.g;
                    cVar = cVarB2;
                }
                i = cVar.f6427a;
                obj = cVar;
                sparseArray.put(i, obj);
                break;
            case 20:
                if (iC2 == hVar.f6432a) {
                    hVar.h = a(oVar);
                }
                break;
        }
        oVar.d(iC4 - oVar.c());
    }

    private static void a(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        o oVar = new o(bArr);
        int iA = i2;
        int i4 = i3;
        byte[] bArrA = null;
        byte[] bArrA2 = null;
        while (oVar.a() != 0) {
            int iC = oVar.c(8);
            if (iC != 240) {
                switch (iC) {
                    case 16:
                        if (i == 3) {
                            if (bArrA == null) {
                                bArr3 = b;
                                bArr2 = bArr3;
                            } else {
                                bArr2 = bArrA;
                            }
                        } else if (i != 2) {
                            bArr2 = null;
                        } else if (bArrA2 == null) {
                            bArr3 = f6424a;
                            bArr2 = bArr3;
                        } else {
                            bArr2 = bArrA2;
                        }
                        iA = a(oVar, iArr, bArr2, iA, i4, paint, canvas);
                        break;
                    case 17:
                        iA = b(oVar, iArr, i == 3 ? c : null, iA, i4, paint, canvas);
                        break;
                    case 18:
                        iA = c(oVar, iArr, null, iA, i4, paint, canvas);
                        continue;
                    default:
                        switch (iC) {
                            case 32:
                                bArrA2 = a(4, 4, oVar);
                                break;
                            case 33:
                                bArrA = a(4, 8, oVar);
                                break;
                            case 34:
                                bArrA = a(16, 8, oVar);
                                break;
                            default:
                                continue;
                        }
                        break;
                }
                oVar.f();
            } else {
                i4 += 2;
                iA = i2;
            }
        }
    }

    private static byte[] a(int i, int i2, o oVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) oVar.c(i2);
        }
        return bArr;
    }

    private static int b(o oVar, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int i3;
        int iC;
        int i4 = i;
        boolean z = false;
        while (true) {
            int iC2 = oVar.c(4);
            if (iC2 != 0) {
                z = z;
                i3 = 1;
            } else if (oVar.e()) {
                if (oVar.e()) {
                    int iC3 = oVar.c(2);
                    if (iC3 == 0) {
                        i3 = 1;
                    } else if (iC3 == 1) {
                        i3 = 2;
                    } else if (iC3 == 2) {
                        iC = oVar.c(4) + 9;
                    } else if (iC3 != 3) {
                        z = z;
                        iC2 = 0;
                        i3 = 0;
                    } else {
                        iC = oVar.c(8) + 25;
                    }
                    iC2 = 0;
                } else {
                    iC = oVar.c(2) + 4;
                }
                z = z;
                i3 = iC;
                iC2 = oVar.c(4);
            } else {
                int iC4 = oVar.c(3);
                if (iC4 != 0) {
                    i3 = iC4 + 2;
                    iC2 = 0;
                } else {
                    z = true;
                    iC2 = 0;
                    i3 = 0;
                }
            }
            if (i3 != 0 && paint != null) {
                if (bArr != null) {
                    iC2 = bArr[iC2];
                }
                paint.setColor(iArr[iC2]);
                canvas.drawRect(i4, i2, i4 + i3, i2 + 1, paint);
            }
            i4 += i3;
            if (z) {
                return i4;
            }
            z = z;
        }
    }

    private static c b(o oVar) {
        byte[] bArr;
        int iC = oVar.c(16);
        oVar.b(4);
        int iC2 = oVar.c(2);
        boolean zE = oVar.e();
        oVar.b(1);
        byte[] bArr2 = null;
        if (iC2 != 1) {
            if (iC2 == 0) {
                int iC3 = oVar.c(16);
                int iC4 = oVar.c(16);
                if (iC3 > 0) {
                    bArr2 = new byte[iC3];
                    oVar.b(bArr2, 0, iC3);
                }
                if (iC4 > 0) {
                    bArr = new byte[iC4];
                    oVar.b(bArr, 0, iC4);
                }
            }
            return new c(iC, zE, bArr2, bArr);
        }
        oVar.b(oVar.c(8) * 16);
        bArr = bArr2;
        return new c(iC, zE, bArr2, bArr);
    }

    private static f b(o oVar, int i) {
        int i2;
        int iC;
        int iC2;
        int iC3 = oVar.c(8);
        oVar.b(4);
        boolean zE = oVar.e();
        oVar.b(3);
        int i3 = 16;
        int iC4 = oVar.c(16);
        int iC5 = oVar.c(16);
        int iC6 = oVar.c(3);
        int iC7 = oVar.c(3);
        int i4 = 2;
        oVar.b(2);
        int iC8 = oVar.c(8);
        int iC9 = oVar.c(8);
        int iC10 = oVar.c(4);
        int iC11 = oVar.c(2);
        oVar.b(2);
        int i5 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i5 > 0) {
            int iC12 = oVar.c(i3);
            int iC13 = oVar.c(i4);
            int iC14 = oVar.c(i4);
            int iC15 = oVar.c(12);
            int i6 = iC11;
            oVar.b(4);
            int iC16 = oVar.c(12);
            int i7 = i5 - 6;
            if (iC13 != 1) {
                i2 = 2;
                if (iC13 != 2) {
                    iC = 0;
                    iC2 = 0;
                    i5 = i7;
                }
                sparseArray.put(iC12, new g(iC13, iC14, iC15, iC16, iC, iC2));
                i4 = i2;
                iC11 = i6;
                i3 = 16;
            } else {
                i2 = 2;
            }
            i5 -= 8;
            iC = oVar.c(8);
            iC2 = oVar.c(8);
            sparseArray.put(iC12, new g(iC13, iC14, iC15, iC16, iC, iC2));
            i4 = i2;
            iC11 = i6;
            i3 = 16;
        }
        return new f(iC3, zE, iC4, iC5, iC6, iC7, iC8, iC9, iC10, iC11, sparseArray);
    }

    private static int[] b() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int c(o oVar, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        boolean z;
        int iC;
        int i3 = i;
        boolean z2 = false;
        while (true) {
            int iC2 = oVar.c(8);
            if (iC2 != 0) {
                z = z2;
                iC = 1;
            } else if (oVar.e()) {
                z = z2;
                iC = oVar.c(7);
                iC2 = oVar.c(8);
            } else {
                int iC3 = oVar.c(7);
                if (iC3 != 0) {
                    z = z2;
                    iC = iC3;
                    iC2 = 0;
                } else {
                    z = true;
                    iC2 = 0;
                    iC = 0;
                }
            }
            if (iC != 0 && paint != null) {
                if (bArr != null) {
                    iC2 = bArr[iC2];
                }
                paint.setColor(iArr[iC2]);
                canvas.drawRect(i3, i2, i3 + iC, i2 + 1, paint);
            }
            i3 += iC;
            if (z) {
                return i3;
            }
            z2 = z;
        }
    }

    private static a c(o oVar, int i) {
        int[] iArr;
        int iC;
        int i2;
        int iC2;
        int iC3;
        int iC4;
        int i3 = 8;
        int iC5 = oVar.c(8);
        oVar.b(8);
        int i4 = 2;
        int i5 = i - 2;
        int[] iArrB = b();
        int[] iArrC = c();
        int[] iArrD = d();
        while (i5 > 0) {
            int iC6 = oVar.c(i3);
            int iC7 = oVar.c(i3);
            if ((iC7 & 128) != 0) {
                iArr = iArrB;
            } else {
                iArr = (iC7 & 64) != 0 ? iArrC : iArrD;
            }
            if ((iC7 & 1) != 0) {
                iC3 = oVar.c(i3);
                iC4 = oVar.c(i3);
                iC = oVar.c(i3);
                iC2 = oVar.c(i3);
                i2 = i5 - 6;
            } else {
                int iC8 = oVar.c(6) << i4;
                int iC9 = oVar.c(4) << 4;
                iC = oVar.c(4) << 4;
                i2 = i5 - 4;
                iC2 = oVar.c(i4) << 6;
                iC3 = iC8;
                iC4 = iC9;
            }
            if (iC3 == 0) {
                iC2 = 255;
                iC4 = 0;
                iC = 0;
            }
            double d2 = iC3;
            double d3 = iC4 - 128;
            double d4 = iC - 128;
            iArr[iC6] = a((byte) (255 - (iC2 & 255)), y.a((int) (d2 + (1.402d * d3)), 0, 255), y.a((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), y.a((int) (d2 + (d4 * 1.772d)), 0, 255));
            i5 = i2;
            iC5 = iC5;
            i3 = 8;
            i4 = 2;
        }
        return new a(iC5, iArrB, iArrC, iArrD);
    }

    private static int[] c() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                iArr[i] = a(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                iArr[i] = a(255, (i & 1) != 0 ? 127 : 0, (i & 2) != 0 ? 127 : 0, (i & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] d() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i < 8) {
                iArr[i] = a(63, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) == 0 ? 0 : 255);
            } else {
                int i2 = i & MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH;
                if (i2 == 0) {
                    iArr[i] = a(255, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 8) {
                    iArr[i] = a(127, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 128) {
                    iArr[i] = a(255, ((i & 1) != 0 ? 43 : 0) + 127 + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + 127 + ((i & 64) == 0 ? 0 : 85));
                } else if (i2 == 136) {
                    iArr[i] = a(255, ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public List<com.opos.exoplayer.core.f.b> a(byte[] bArr, int i) {
        o oVar = new o(bArr, i);
        while (oVar.a() >= 48 && oVar.c(8) == 15) {
            a(oVar, this.i);
        }
        h hVar = this.i;
        if (hVar.i == null) {
            return Collections.emptyList();
        }
        C0923b c0923b = hVar.h;
        if (c0923b == null) {
            c0923b = this.g;
        }
        Bitmap bitmap = this.j;
        if (bitmap == null || c0923b.f6426a + 1 != bitmap.getWidth() || c0923b.b + 1 != this.j.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(c0923b.f6426a + 1, c0923b.b + 1, Bitmap.Config.ARGB_8888);
            this.j = bitmapCreateBitmap;
            this.f.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray = this.i.i.c;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            e eVarValueAt = sparseArray.valueAt(i2);
            f fVar = this.i.c.get(sparseArray.keyAt(i2));
            int i3 = eVarValueAt.f6429a + c0923b.c;
            int i4 = eVarValueAt.b + c0923b.e;
            float f2 = i3;
            float f3 = i4;
            this.f.clipRect(f2, f3, Math.min(fVar.c + i3, c0923b.d), Math.min(fVar.d + i4, c0923b.f), Region.Op.REPLACE);
            a aVar = this.i.d.get(fVar.f);
            if (aVar == null && (aVar = this.i.f.get(fVar.f)) == null) {
                aVar = this.h;
            }
            int i5 = 0;
            for (SparseArray<g> sparseArray2 = fVar.j; i5 < sparseArray2.size(); sparseArray2 = sparseArray2) {
                int iKeyAt = sparseArray2.keyAt(i5);
                g gVarValueAt = sparseArray2.valueAt(i5);
                c cVar = this.i.e.get(iKeyAt);
                c cVar2 = cVar == null ? this.i.g.get(iKeyAt) : cVar;
                if (cVar2 != null) {
                    a(cVar2, aVar, fVar.e, gVarValueAt.f6431a + i3, i4 + gVarValueAt.b, cVar2.b ? null : this.d, this.f);
                }
                i5++;
            }
            if (fVar.b) {
                int i6 = fVar.e;
                this.e.setColor(i6 == 3 ? aVar.d[fVar.g] : i6 == 2 ? aVar.c[fVar.h] : aVar.b[fVar.i]);
                this.f.drawRect(f2, f3, fVar.c + i3, fVar.d + i4, this.e);
            }
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.j, i3, i4, fVar.c, fVar.d);
            float f4 = c0923b.f6426a;
            float f5 = c0923b.b;
            arrayList.add(new com.opos.exoplayer.core.f.b(bitmapCreateBitmap2, f2 / f4, 0, f3 / f5, 0, fVar.c / f4, fVar.d / f5));
            this.f.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return arrayList;
    }

    public void a() {
        this.i.a();
    }
}
