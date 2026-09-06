package com.opos.exoplayer.core.c.f;

import android.util.Pair;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double[] f6341a = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String b;
    private com.opos.exoplayer.core.c.n c;
    private boolean d;
    private long e;
    private final boolean[] f = new boolean[4];
    private final a g = new a(128);
    private long h;
    private boolean i;
    private long j;
    private long k;
    private long l;
    private boolean m;
    private boolean n;

    private static final class a {
        private static final byte[] d = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6342a;
        public int b;
        public byte[] c;
        private boolean e;

        public a(int i) {
            this.c = new byte[i];
        }

        public void a() {
            this.e = false;
            this.f6342a = 0;
            this.b = 0;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.e) {
                int i3 = i2 - i;
                byte[] bArr2 = this.c;
                int length = bArr2.length;
                int i4 = this.f6342a + i3;
                if (length < i4) {
                    this.c = Arrays.copyOf(bArr2, i4 * 2);
                }
                System.arraycopy(bArr, i, this.c, this.f6342a, i3);
                this.f6342a += i3;
            }
        }

        public boolean a(int i, int i2) {
            if (this.e) {
                int i3 = this.f6342a - i2;
                this.f6342a = i3;
                if (this.b != 0 || i != 181) {
                    this.e = false;
                    return true;
                }
                this.b = i3;
            } else if (i == 179) {
                this.e = true;
            }
            byte[] bArr = d;
            a(bArr, 0, bArr.length);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0066  */
    /* JADX WARN: Code duplicated, block: B:16:0x006b  */
    /* JADX WARN: Code duplicated, block: B:18:0x007a  */
    /* JADX WARN: Code duplicated, block: B:20:0x008b  */
    private static Pair<Format, Long> a(a aVar, String str) {
        float f;
        int i;
        float f2;
        int i2;
        long j;
        double[] dArr;
        double d;
        int i3;
        int i4;
        byte[] bArrCopyOf = Arrays.copyOf(aVar.c, aVar.f6342a);
        int i5 = bArrCopyOf[4] & 255;
        byte b = bArrCopyOf[5];
        int i6 = (i5 << 4) | ((b & 255) >> 4);
        int i7 = ((b & 15) << 8) | (bArrCopyOf[6] & 255);
        int i8 = (bArrCopyOf[7] & 240) >> 4;
        if (i8 == 2) {
            f = i7 * 4;
            i = i6 * 3;
        } else {
            if (i8 != 3) {
                if (i8 != 4) {
                    f2 = 1.0f;
                } else {
                    f = i7 * 121;
                    i = i6 * 100;
                }
                Format formatA = Format.a(str, MimeTypes.VIDEO_MPEG2, (String) null, -1, -1, i6, i7, -1.0f, (List<byte[]>) Collections.singletonList(bArrCopyOf), -1, f2, (DrmInitData) null);
                i2 = (bArrCopyOf[7] & 15) - 1;
                if (i2 >= 0) {
                    dArr = f6341a;
                    if (i2 < dArr.length) {
                        d = dArr[i2];
                        byte b2 = bArrCopyOf[aVar.b + 9];
                        i3 = (b2 & 96) >> 5;
                        i4 = b2 & Ascii.US;
                        if (i3 != i4) {
                            d *= (((double) i3) + 1.0d) / ((double) (i4 + 1));
                        }
                        j = (long) (1000000.0d / d);
                    } else {
                        j = 0;
                    }
                } else {
                    j = 0;
                }
                return Pair.create(formatA, Long.valueOf(j));
            }
            f = i7 * 16;
            i = i6 * 9;
        }
        f2 = f / i;
        Format formatA2 = Format.a(str, MimeTypes.VIDEO_MPEG2, (String) null, -1, -1, i6, i7, -1.0f, (List<byte[]>) Collections.singletonList(bArrCopyOf), -1, f2, (DrmInitData) null);
        i2 = (bArrCopyOf[7] & 15) - 1;
        if (i2 >= 0) {
            dArr = f6341a;
            if (i2 < dArr.length) {
                d = dArr[i2];
                byte b3 = bArrCopyOf[aVar.b + 9];
                i3 = (b3 & 96) >> 5;
                i4 = b3 & Ascii.US;
                if (i3 != i4) {
                    d *= (((double) i3) + 1.0d) / ((double) (i4 + 1));
                }
                j = (long) (1000000.0d / d);
            } else {
                j = 0;
            }
        } else {
            j = 0;
        }
        return Pair.create(formatA2, Long.valueOf(j));
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        com.opos.exoplayer.core.i.n.a(this.f);
        this.g.a();
        this.h = 0L;
        this.i = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        this.j = j;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.b = dVar.c();
        this.c = gVar.a(dVar.b(), 2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.p pVar) {
        boolean z;
        boolean z2;
        int iD = pVar.d();
        int iC = pVar.c();
        byte[] bArr = pVar.f6510a;
        this.h += (long) pVar.b();
        this.c.a(pVar, pVar.b());
        while (true) {
            int iA = com.opos.exoplayer.core.i.n.a(bArr, iD, iC, this.f);
            if (iA == iC) {
                break;
            }
            int i = iA + 3;
            int i2 = pVar.f6510a[i] & 255;
            if (!this.d) {
                int i3 = iA - iD;
                if (i3 > 0) {
                    this.g.a(bArr, iD, iA);
                }
                if (this.g.a(i2, i3 < 0 ? -i3 : 0)) {
                    Pair<Format, Long> pairA = a(this.g, this.b);
                    this.c.a((Format) pairA.first);
                    this.e = ((Long) pairA.second).longValue();
                    this.d = true;
                }
            }
            if (i2 == 0 || i2 == 179) {
                int i4 = iC - iA;
                if (this.i && this.n && this.d) {
                    this.c.a(this.l, this.m ? 1 : 0, ((int) (this.h - this.k)) - i4, i4, null);
                }
                boolean z3 = this.i;
                if (!z3 || this.n) {
                    this.k = this.h - ((long) i4);
                    long j = this.j;
                    if (j == -9223372036854775807L) {
                        j = z3 ? this.l + this.e : 0L;
                    }
                    this.l = j;
                    z = false;
                    this.m = false;
                    this.j = -9223372036854775807L;
                    z2 = true;
                    this.i = true;
                } else {
                    z = false;
                    z2 = true;
                }
                this.n = i2 == 0 ? z2 : z;
            } else if (i2 == 184) {
                this.m = true;
            }
            iD = i;
        }
        if (this.d) {
            return;
        }
        this.g.a(bArr, iD, iC);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
