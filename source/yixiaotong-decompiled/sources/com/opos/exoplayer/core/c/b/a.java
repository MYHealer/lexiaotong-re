package com.opos.exoplayer.core.c.b;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.g;
import com.opos.exoplayer.core.c.h;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.k;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.o;
import com.opos.exoplayer.core.video.ColorInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a implements com.opos.exoplayer.core.c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f6283a = new C0906a();
    private static final byte[] b = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] c = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] d = y.c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] e = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] f = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID g = new UUID(72057594037932032L, -9223371306706625679L);
    private c A;
    private boolean B;
    private int C;
    private long D;
    private boolean E;
    private long F;
    private long G;
    private long H;
    private k I;
    private k J;
    private boolean K;
    private int L;
    private long M;
    private long N;
    private int O;
    private int P;
    private int[] Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private byte Z;
    private int aa;
    private int ab;
    private int ac;
    private boolean ad;
    private boolean ae;
    private g af;
    private final com.opos.exoplayer.core.c.b.c h;
    private final f i;
    private final SparseArray<c> j;
    private final boolean k;
    private final p l;
    private final p m;
    private final p n;
    private final p o;
    private final p p;
    private final p q;
    private final p r;
    private final p s;
    private final p t;
    private ByteBuffer u;
    private long v;
    private long w;
    private long x;
    private long y;
    private long z;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.c.b.a$a, reason: collision with other inner class name */
    static class C0906a implements h {
        C0906a() {
        }

        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    }

    private final class b implements com.opos.exoplayer.core.c.b.d {
        private b() {
        }

        /* synthetic */ b(a aVar, C0906a c0906a) {
            this();
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public int a(int i) {
            return a.this.a(i);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i, double d) {
            a.this.a(i, d);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i, int i2, com.opos.exoplayer.core.c.f fVar) throws o {
            a.this.a(i, i2, fVar);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i, long j) throws o {
            a.this.a(i, j);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i, long j, long j2) throws o {
            a.this.a(i, j, j2);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void a(int i, String str) throws o {
            a.this.a(i, str);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public boolean b(int i) {
            return a.this.b(i);
        }

        @Override // com.opos.exoplayer.core.c.b.d
        public void c(int i) throws o {
            a.this.c(i);
        }
    }

    private static final class c {
        public float A;
        public float B;
        public float C;
        public float D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public long J;
        public long K;
        public d L;
        public boolean M;
        public boolean N;
        public n O;
        public int P;
        private String Q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6285a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        public byte[] f;
        public n.a g;
        public byte[] h;
        public DrmInitData i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public byte[] o;
        public int p;
        public boolean q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public float w;
        public float x;
        public float y;
        public float z;

        private c() {
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = null;
            this.p = -1;
            this.q = false;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = 1000;
            this.v = 200;
            this.w = -1.0f;
            this.x = -1.0f;
            this.y = -1.0f;
            this.z = -1.0f;
            this.A = -1.0f;
            this.B = -1.0f;
            this.C = -1.0f;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 1;
            this.H = -1;
            this.I = 8000;
            this.J = 0L;
            this.K = 0L;
            this.N = true;
            this.Q = "eng";
        }

        /* synthetic */ c(C0906a c0906a) {
            this();
        }

        private static List<byte[]> a(p pVar) throws o {
            try {
                pVar.d(16);
                if (pVar.n() != 826496599) {
                    return null;
                }
                byte[] bArr = pVar.f6510a;
                for (int iD = pVar.d() + 20; iD < bArr.length - 4; iD++) {
                    if (bArr[iD] == 0 && bArr[iD + 1] == 0 && bArr[iD + 2] == 1 && bArr[iD + 3] == 15) {
                        return Collections.singletonList(Arrays.copyOfRange(bArr, iD, bArr.length));
                    }
                }
                throw new o("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new o("Error parsing FourCC VC1 codec private");
            }
        }

        private static List<byte[]> a(byte[] bArr) throws o {
            int i;
            int i2;
            try {
                if (bArr[0] != 2) {
                    throw new o("Error parsing vorbis codec private");
                }
                int i3 = 0;
                int i4 = 1;
                while (true) {
                    i = bArr[i4];
                    if (i != -1) {
                        break;
                    }
                    i3 += 255;
                    i4++;
                }
                int i5 = i4 + 1;
                int i6 = i3 + i;
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5];
                    if (i2 != -1) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + i2;
                if (bArr[i8] != 1) {
                    throw new o("Error parsing vorbis codec private");
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i8, bArr2, 0, i6);
                int i10 = i8 + i6;
                if (bArr[i10] != 3) {
                    throw new o("Error parsing vorbis codec private");
                }
                int i11 = i10 + i9;
                if (bArr[i11] != 5) {
                    throw new o("Error parsing vorbis codec private");
                }
                byte[] bArr3 = new byte[bArr.length - i11];
                System.arraycopy(bArr, i11, bArr3, 0, bArr.length - i11);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new o("Error parsing vorbis codec private");
            }
        }

        private static boolean b(p pVar) throws o {
            try {
                int i = pVar.i();
                if (i == 1) {
                    return true;
                }
                if (i != 65534) {
                    return false;
                }
                pVar.c(24);
                return pVar.q() == a.g.getMostSignificantBits() && pVar.q() == a.g.getLeastSignificantBits();
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new o("Error parsing MS/ACM codec private");
            }
        }

        private byte[] c() {
            if (this.w == -1.0f || this.x == -1.0f || this.y == -1.0f || this.z == -1.0f || this.A == -1.0f || this.B == -1.0f || this.C == -1.0f || this.D == -1.0f || this.E == -1.0f || this.F == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.put((byte) 0);
            byteBufferWrap.putShort((short) ((this.w * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.x * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.y * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.z * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.A * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.B * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.C * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.D * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) (this.E + 0.5f));
            byteBufferWrap.putShort((short) (this.F + 0.5f));
            byteBufferWrap.putShort((short) this.u);
            byteBufferWrap.putShort((short) this.v);
            return bArr;
        }

        public void a() {
            d dVar = this.L;
            if (dVar != null) {
                dVar.a(this);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:136:0x0240 A[PHI: r1
  0x0240: PHI (r1v88 int) = (r1v66 int), (r1v97 int) binds: [B:168:0x02fd, B:133:0x0229] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:178:0x0323  */
        /* JADX WARN: Code duplicated, block: B:181:0x032b  */
        /* JADX WARN: Code duplicated, block: B:182:0x0351  */
        /* JADX WARN: Code duplicated, block: B:184:0x0357  */
        /* JADX WARN: Code duplicated, block: B:186:0x035b  */
        /* JADX WARN: Code duplicated, block: B:188:0x0360  */
        /* JADX WARN: Code duplicated, block: B:191:0x0368  */
        /* JADX WARN: Code duplicated, block: B:193:0x036d  */
        /* JADX WARN: Code duplicated, block: B:196:0x0372  */
        /* JADX WARN: Code duplicated, block: B:199:0x0380  */
        /* JADX WARN: Code duplicated, block: B:202:0x0388  */
        /* JADX WARN: Code duplicated, block: B:203:0x039a  */
        /* JADX WARN: Code duplicated, block: B:205:0x03c7  */
        /* JADX WARN: Code duplicated, block: B:207:0x03cd  */
        /* JADX WARN: Code duplicated, block: B:209:0x03dc  */
        /* JADX WARN: Code duplicated, block: B:211:0x03e2  */
        /* JADX WARN: Code duplicated, block: B:212:0x0415  */
        /* JADX WARN: Code duplicated, block: B:214:0x041b  */
        /* JADX WARN: Code duplicated, block: B:4:0x0015  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public void a(g gVar, int i) throws o {
            byte b;
            String str;
            List<byte[]> listSingletonList;
            String string;
            int iB;
            StringBuilder sb;
            List<byte[]> listA;
            String str2;
            int i2;
            String str3;
            String str4;
            int i3;
            List<byte[]> listSingletonList2;
            int i4;
            int i5;
            Format formatA;
            int i6;
            int i7;
            float f;
            ColorInfo colorInfo;
            int i8;
            int i9;
            int i10;
            String str5 = this.f6285a;
            str5.hashCode();
            int i11 = 1;
            switch (str5.hashCode()) {
                case -2095576542:
                    if (!str5.equals("V_MPEG4/ISO/AP")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case -2095575984:
                    if (!str5.equals("V_MPEG4/ISO/SP")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case -1985379776:
                    if (!str5.equals("A_MS/ACM")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case -1784763192:
                    if (!str5.equals("A_TRUEHD")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case -1730367663:
                    if (!str5.equals("A_VORBIS")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case -1482641358:
                    if (!str5.equals("A_MPEG/L2")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case -1482641357:
                    if (!str5.equals("A_MPEG/L3")) {
                        b = -1;
                    } else {
                        b = 6;
                    }
                    break;
                case -1373388978:
                    if (!str5.equals("V_MS/VFW/FOURCC")) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case -933872740:
                    if (!str5.equals("S_DVBSUB")) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case -538363189:
                    if (!str5.equals("V_MPEG4/ISO/ASP")) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case -538363109:
                    if (!str5.equals("V_MPEG4/ISO/AVC")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case -425012669:
                    if (!str5.equals("S_VOBSUB")) {
                        b = -1;
                    } else {
                        b = 11;
                    }
                    break;
                case -356037306:
                    if (!str5.equals("A_DTS/LOSSLESS")) {
                        b = -1;
                    } else {
                        b = 12;
                    }
                    break;
                case 62923557:
                    if (!str5.equals("A_AAC")) {
                        b = -1;
                    } else {
                        b = 13;
                    }
                    break;
                case 62923603:
                    if (!str5.equals("A_AC3")) {
                        b = -1;
                    } else {
                        b = 14;
                    }
                    break;
                case 62927045:
                    if (!str5.equals("A_DTS")) {
                        b = -1;
                    } else {
                        b = 15;
                    }
                    break;
                case 82338133:
                    if (!str5.equals("V_VP8")) {
                        b = -1;
                    } else {
                        b = 16;
                    }
                    break;
                case 82338134:
                    if (!str5.equals("V_VP9")) {
                        b = -1;
                    } else {
                        b = 17;
                    }
                    break;
                case 99146302:
                    if (!str5.equals("S_HDMV/PGS")) {
                        b = -1;
                    } else {
                        b = Ascii.DC2;
                    }
                    break;
                case 444813526:
                    if (!str5.equals("V_THEORA")) {
                        b = -1;
                    } else {
                        b = 19;
                    }
                    break;
                case 542569478:
                    if (!str5.equals("A_DTS/EXPRESS")) {
                        b = -1;
                    } else {
                        b = Ascii.DC4;
                    }
                    break;
                case 725957860:
                    if (!str5.equals("A_PCM/INT/LIT")) {
                        b = -1;
                    } else {
                        b = Ascii.NAK;
                    }
                    break;
                case 738597099:
                    if (!str5.equals("S_TEXT/ASS")) {
                        b = -1;
                    } else {
                        b = Ascii.SYN;
                    }
                    break;
                case 855502857:
                    if (!str5.equals("V_MPEGH/ISO/HEVC")) {
                        b = -1;
                    } else {
                        b = Ascii.ETB;
                    }
                    break;
                case 1422270023:
                    if (!str5.equals("S_TEXT/UTF8")) {
                        b = -1;
                    } else {
                        b = Ascii.CAN;
                    }
                    break;
                case 1809237540:
                    if (!str5.equals("V_MPEG2")) {
                        b = -1;
                    } else {
                        b = Ascii.EM;
                    }
                    break;
                case 1950749482:
                    if (!str5.equals("A_EAC3")) {
                        b = -1;
                    } else {
                        b = 26;
                    }
                    break;
                case 1950789798:
                    if (!str5.equals("A_FLAC")) {
                        b = -1;
                    } else {
                        b = Ascii.ESC;
                    }
                    break;
                case 1951062397:
                    if (!str5.equals("A_OPUS")) {
                        b = -1;
                    } else {
                        b = Ascii.FS;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                case 1:
                case 9:
                    byte[] bArr = this.h;
                    str = MimeTypes.VIDEO_MP4V;
                    if (bArr != null) {
                        listSingletonList = Collections.singletonList(bArr);
                        listSingletonList2 = listSingletonList;
                        str4 = str;
                        i4 = -1;
                        i3 = -1;
                        i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                        if (m.a(str4)) {
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                        } else if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6 || (i8 = this.m) == i6) {
                                f = -1.0f;
                            } else {
                                f = (this.k * i7) / (this.j * i8);
                            }
                            float f2 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f2, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(a.d);
                                arrayList.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4) && !MimeTypes.APPLICATION_PGS.equals(str4) && !MimeTypes.APPLICATION_DVBSUBS.equals(str4)) {
                                    throw new o("Unexpected MIME type.");
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        n nVarA = gVar.a(this.b, i11);
                        this.O = nVarA;
                        nVarA.a(formatA);
                        return;
                    }
                    str4 = str;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    } else if (m.b(str4)) {
                        if (this.n == 0) {
                            i9 = this.l;
                            i6 = -1;
                            if (i9 == -1) {
                                i9 = this.j;
                            }
                            this.l = i9;
                            i10 = this.m;
                            if (i10 == -1) {
                                i10 = this.k;
                            }
                            this.m = i10;
                        } else {
                            i6 = -1;
                        }
                        i7 = this.l;
                        if (i7 != i6) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        float f3 = f;
                        if (this.q) {
                            colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                        } else {
                            colorInfo = null;
                        }
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f3, this.o, this.p, colorInfo, this.i);
                        i11 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                            formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                        } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                            ArrayList arrayList2 = new ArrayList(2);
                            arrayList2.add(a.d);
                            arrayList2.add(this.h);
                            formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList2);
                        } else {
                            if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                        }
                        i11 = 3;
                    }
                    n nVarA2 = gVar.a(this.b, i11);
                    this.O = nVarA2;
                    nVarA2.a(formatA);
                    return;
                case 2:
                    if (b(new p(this.h))) {
                        iB = y.b(this.H);
                        if (iB == 0) {
                            sb = new StringBuilder("Unsupported PCM bit depth: ");
                            string = sb.append(this.H).append(". Setting mimeType to audio/x-unknown").toString();
                        } else {
                            i4 = iB;
                            str4 = MimeTypes.AUDIO_RAW;
                            listSingletonList2 = null;
                        }
                        i3 = -1;
                        i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                        if (m.a(str4)) {
                            if (m.b(str4)) {
                                if (this.n == 0) {
                                    i9 = this.l;
                                    i6 = -1;
                                    if (i9 == -1) {
                                        i9 = this.j;
                                    }
                                    this.l = i9;
                                    i10 = this.m;
                                    if (i10 == -1) {
                                        i10 = this.k;
                                    }
                                    this.m = i10;
                                } else {
                                    i6 = -1;
                                }
                                i7 = this.l;
                                if (i7 != i6) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                float f4 = f;
                                if (this.q) {
                                    colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                                } else {
                                    colorInfo = null;
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f4, this.o, this.p, colorInfo, this.i);
                                i11 = 2;
                            } else {
                                if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                    formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                                } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                    ArrayList arrayList3 = new ArrayList(2);
                                    arrayList3.add(a.d);
                                    arrayList3.add(this.h);
                                    formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList3);
                                } else {
                                    if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                    }
                                    formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                                }
                                i11 = 3;
                            }
                            break;
                        } else {
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                        }
                        n nVarA3 = gVar.a(this.b, i11);
                        this.O = nVarA3;
                        nVarA3.a(formatA);
                        return;
                    }
                    string = "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown";
                    com.opos.cmn.an.f.a.c("MatroskaExtractor", string);
                    str4 = MimeTypes.AUDIO_UNKNOWN;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f5 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f5, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList4 = new ArrayList(2);
                                arrayList4.add(a.d);
                                arrayList4.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList4);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA4 = gVar.a(this.b, i11);
                    this.O = nVarA4;
                    nVarA4.a(formatA);
                    return;
                case 3:
                    this.L = new d();
                    str = MimeTypes.AUDIO_TRUEHD;
                    str4 = str;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f6 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f6, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList5 = new ArrayList(2);
                                arrayList5.add(a.d);
                                arrayList5.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList5);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA5 = gVar.a(this.b, i11);
                    this.O = nVarA5;
                    nVarA5.a(formatA);
                    return;
                case 4:
                    listA = a(this.h);
                    str2 = MimeTypes.AUDIO_VORBIS;
                    i2 = 8192;
                    listSingletonList2 = listA;
                    str4 = str2;
                    i3 = i2;
                    i4 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f7 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f7, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList6 = new ArrayList(2);
                                arrayList6.add(a.d);
                                arrayList6.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList6);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA6 = gVar.a(this.b, i11);
                    this.O = nVarA6;
                    nVarA6.a(formatA);
                    return;
                case 5:
                    str3 = MimeTypes.AUDIO_MPEG_L2;
                    str4 = str3;
                    i3 = 4096;
                    listSingletonList2 = null;
                    i4 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f8 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f8, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList7 = new ArrayList(2);
                                arrayList7.add(a.d);
                                arrayList7.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList7);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA7 = gVar.a(this.b, i11);
                    this.O = nVarA7;
                    nVarA7.a(formatA);
                    return;
                case 6:
                    str3 = MimeTypes.AUDIO_MPEG;
                    str4 = str3;
                    i3 = 4096;
                    listSingletonList2 = null;
                    i4 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f9 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f9, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList8 = new ArrayList(2);
                                arrayList8.add(a.d);
                                arrayList8.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList8);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA8 = gVar.a(this.b, i11);
                    this.O = nVarA8;
                    nVarA8.a(formatA);
                    return;
                case 7:
                    listSingletonList = a(new p(this.h));
                    if (listSingletonList != null) {
                        str = MimeTypes.VIDEO_VC1;
                        listSingletonList2 = listSingletonList;
                        str4 = str;
                    } else {
                        com.opos.cmn.an.f.a.c("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                        listSingletonList2 = listSingletonList;
                        str4 = MimeTypes.VIDEO_UNKNOWN;
                    }
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f10 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f10, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList9 = new ArrayList(2);
                                arrayList9.add(a.d);
                                arrayList9.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList9);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA9 = gVar.a(this.b, i11);
                    this.O = nVarA9;
                    nVarA9.a(formatA);
                    return;
                case 8:
                    byte[] bArr2 = this.h;
                    listSingletonList2 = Collections.singletonList(new byte[]{bArr2[0], bArr2[1], bArr2[2], bArr2[3]});
                    str4 = MimeTypes.APPLICATION_DVBSUBS;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f11 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f11, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList10 = new ArrayList(2);
                                arrayList10.add(a.d);
                                arrayList10.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList10);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA10 = gVar.a(this.b, i11);
                    this.O = nVarA10;
                    nVarA10.a(formatA);
                    return;
                case 10:
                    com.opos.exoplayer.core.video.a aVarA = com.opos.exoplayer.core.video.a.a(new p(this.h));
                    listSingletonList2 = aVarA.f6551a;
                    this.P = aVarA.b;
                    str = MimeTypes.VIDEO_H264;
                    str4 = str;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f12 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f12, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList11 = new ArrayList(2);
                                arrayList11.add(a.d);
                                arrayList11.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList11);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA11 = gVar.a(this.b, i11);
                    this.O = nVarA11;
                    nVarA11.a(formatA);
                    return;
                case 11:
                    listSingletonList2 = Collections.singletonList(this.h);
                    str4 = MimeTypes.APPLICATION_VOBSUB;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f13 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f13, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList12 = new ArrayList(2);
                                arrayList12.add(a.d);
                                arrayList12.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList12);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA12 = gVar.a(this.b, i11);
                    this.O = nVarA12;
                    nVarA12.a(formatA);
                    return;
                case 12:
                    str = MimeTypes.AUDIO_DTS_HD;
                    str4 = str;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f14 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f14, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList13 = new ArrayList(2);
                                arrayList13.add(a.d);
                                arrayList13.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList13);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA13 = gVar.a(this.b, i11);
                    this.O = nVarA13;
                    nVarA13.a(formatA);
                    return;
                case 13:
                    listSingletonList = Collections.singletonList(this.h);
                    str = MimeTypes.AUDIO_AAC;
                    listSingletonList2 = listSingletonList;
                    str4 = str;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f15 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f15, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList14 = new ArrayList(2);
                                arrayList14.add(a.d);
                                arrayList14.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList14);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA14 = gVar.a(this.b, i11);
                    this.O = nVarA14;
                    nVarA14.a(formatA);
                    return;
                case 14:
                    str = MimeTypes.AUDIO_AC3;
                    str4 = str;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f16 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f16, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList15 = new ArrayList(2);
                                arrayList15.add(a.d);
                                arrayList15.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList15);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA15 = gVar.a(this.b, i11);
                    this.O = nVarA15;
                    nVarA15.a(formatA);
                    return;
                case 15:
                case 20:
                    str = MimeTypes.AUDIO_DTS;
                    str4 = str;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f17 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f17, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList16 = new ArrayList(2);
                                arrayList16.add(a.d);
                                arrayList16.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList16);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA16 = gVar.a(this.b, i11);
                    this.O = nVarA16;
                    nVarA16.a(formatA);
                    return;
                case 16:
                    str = MimeTypes.VIDEO_VP8;
                    str4 = str;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f18 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f18, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList17 = new ArrayList(2);
                                arrayList17.add(a.d);
                                arrayList17.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList17);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA17 = gVar.a(this.b, i11);
                    this.O = nVarA17;
                    nVarA17.a(formatA);
                    return;
                case 17:
                    str = MimeTypes.VIDEO_VP9;
                    str4 = str;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f19 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f19, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList18 = new ArrayList(2);
                                arrayList18.add(a.d);
                                arrayList18.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList18);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA18 = gVar.a(this.b, i11);
                    this.O = nVarA18;
                    nVarA18.a(formatA);
                    return;
                case 18:
                    str4 = MimeTypes.APPLICATION_PGS;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f110 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f110, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList19 = new ArrayList(2);
                                arrayList19.add(a.d);
                                arrayList19.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList19);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA19 = gVar.a(this.b, i11);
                    this.O = nVarA19;
                    nVarA19.a(formatA);
                    return;
                case 19:
                    str4 = MimeTypes.VIDEO_UNKNOWN;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f111 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f111, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList110 = new ArrayList(2);
                                arrayList110.add(a.d);
                                arrayList110.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList110);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA110 = gVar.a(this.b, i11);
                    this.O = nVarA110;
                    nVarA110.a(formatA);
                    return;
                case 21:
                    iB = y.b(this.H);
                    if (iB == 0) {
                        sb = new StringBuilder("Unsupported PCM bit depth: ");
                        string = sb.append(this.H).append(". Setting mimeType to audio/x-unknown").toString();
                        com.opos.cmn.an.f.a.c("MatroskaExtractor", string);
                        str4 = MimeTypes.AUDIO_UNKNOWN;
                        listSingletonList2 = null;
                        i4 = -1;
                    } else {
                        i4 = iB;
                        str4 = MimeTypes.AUDIO_RAW;
                        listSingletonList2 = null;
                    }
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f112 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f112, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList111 = new ArrayList(2);
                                arrayList111.add(a.d);
                                arrayList111.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList111);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA111 = gVar.a(this.b, i11);
                    this.O = nVarA111;
                    nVarA111.a(formatA);
                    return;
                case 22:
                    str4 = MimeTypes.TEXT_SSA;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f113 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f113, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList112 = new ArrayList(2);
                                arrayList112.add(a.d);
                                arrayList112.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList112);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA112 = gVar.a(this.b, i11);
                    this.O = nVarA112;
                    nVarA112.a(formatA);
                    return;
                case 23:
                    com.opos.exoplayer.core.video.b bVarA = com.opos.exoplayer.core.video.b.a(new p(this.h));
                    listSingletonList2 = bVarA.f6552a;
                    this.P = bVarA.b;
                    str = MimeTypes.VIDEO_H265;
                    str4 = str;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f114 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f114, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList113 = new ArrayList(2);
                                arrayList113.add(a.d);
                                arrayList113.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList113);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA113 = gVar.a(this.b, i11);
                    this.O = nVarA113;
                    nVarA113.a(formatA);
                    return;
                case 24:
                    str4 = MimeTypes.APPLICATION_SUBRIP;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f115 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f115, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList114 = new ArrayList(2);
                                arrayList114.add(a.d);
                                arrayList114.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList114);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA114 = gVar.a(this.b, i11);
                    this.O = nVarA114;
                    nVarA114.a(formatA);
                    return;
                case 25:
                    str = MimeTypes.VIDEO_MPEG2;
                    str4 = str;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f116 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f116, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList115 = new ArrayList(2);
                                arrayList115.add(a.d);
                                arrayList115.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList115);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA115 = gVar.a(this.b, i11);
                    this.O = nVarA115;
                    nVarA115.a(formatA);
                    return;
                case 26:
                    str = MimeTypes.AUDIO_E_AC3;
                    str4 = str;
                    listSingletonList2 = null;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f117 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f117, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList116 = new ArrayList(2);
                                arrayList116.add(a.d);
                                arrayList116.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList116);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA116 = gVar.a(this.b, i11);
                    this.O = nVarA116;
                    nVarA116.a(formatA);
                    return;
                case 27:
                    listSingletonList = Collections.singletonList(this.h);
                    str = MimeTypes.AUDIO_FLAC;
                    listSingletonList2 = listSingletonList;
                    str4 = str;
                    i4 = -1;
                    i3 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f118 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f118, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList117 = new ArrayList(2);
                                arrayList117.add(a.d);
                                arrayList117.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList117);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA117 = gVar.a(this.b, i11);
                    this.O = nVarA117;
                    nVarA117.a(formatA);
                    return;
                case 28:
                    listA = new ArrayList<>(3);
                    listA.add(this.h);
                    listA.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.J).array());
                    listA.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.K).array());
                    str2 = MimeTypes.AUDIO_OPUS;
                    i2 = 5760;
                    listSingletonList2 = listA;
                    str4 = str2;
                    i3 = i2;
                    i4 = -1;
                    i5 = (this.N ? 1 : 0) | (this.M ? 2 : 0);
                    if (m.a(str4)) {
                        if (m.b(str4)) {
                            if (this.n == 0) {
                                i9 = this.l;
                                i6 = -1;
                                if (i9 == -1) {
                                    i9 = this.j;
                                }
                                this.l = i9;
                                i10 = this.m;
                                if (i10 == -1) {
                                    i10 = this.k;
                                }
                                this.m = i10;
                            } else {
                                i6 = -1;
                            }
                            i7 = this.l;
                            if (i7 != i6) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            float f119 = f;
                            if (this.q) {
                                colorInfo = new ColorInfo(this.r, this.t, this.s, c());
                            } else {
                                colorInfo = null;
                            }
                            formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList2, -1, f119, this.o, this.p, colorInfo, this.i);
                            i11 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str4)) {
                                formatA = Format.a(Integer.toString(i), str4, i5, this.Q, this.i);
                            } else if (MimeTypes.TEXT_SSA.equals(str4)) {
                                ArrayList arrayList118 = new ArrayList(2);
                                arrayList118.add(a.d);
                                arrayList118.add(this.h);
                                formatA = Format.a(Integer.toString(i), str4, null, -1, i5, this.Q, -1, this.i, Long.MAX_VALUE, arrayList118);
                            } else {
                                if (MimeTypes.APPLICATION_VOBSUB.equals(str4)) {
                                }
                                formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i5, listSingletonList2, this.Q, this.i);
                            }
                            i11 = 3;
                        }
                        break;
                    } else {
                        formatA = Format.a(Integer.toString(i), str4, (String) null, -1, i3, this.G, this.I, i4, listSingletonList2, this.i, i5, this.Q);
                    }
                    n nVarA118 = gVar.a(this.b, i11);
                    this.O = nVarA118;
                    nVarA118.a(formatA);
                    return;
                default:
                    throw new o("Unrecognized codec identifier.");
            }
        }

        public void b() {
            d dVar = this.L;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f6286a = new byte[12];
        private boolean b;
        private int c;
        private int d;
        private long e;
        private int f;

        public void a() {
            this.b = false;
        }

        public void a(c cVar) {
            if (!this.b || this.c <= 0) {
                return;
            }
            cVar.O.a(this.e, this.f, this.d, 0, cVar.g);
            this.c = 0;
        }

        public void a(c cVar, long j) {
            if (this.b) {
                int i = this.c;
                int i2 = i + 1;
                this.c = i2;
                if (i == 0) {
                    this.e = j;
                }
                if (i2 < 8) {
                    return;
                }
                cVar.O.a(this.e, this.f, this.d, 0, cVar.g);
                this.c = 0;
            }
        }

        public void a(com.opos.exoplayer.core.c.f fVar, int i, int i2) {
            if (!this.b) {
                fVar.c(this.f6286a, 0, 12);
                fVar.a();
                if (com.opos.exoplayer.core.a.a.b(this.f6286a) == -1) {
                    return;
                }
                this.b = true;
                this.c = 0;
            }
            if (this.c == 0) {
                this.f = i;
                this.d = 0;
            }
            this.d += i2;
        }
    }

    public a() {
        this(0);
    }

    public a(int i) {
        this(new com.opos.exoplayer.core.c.b.b(), i);
    }

    a(com.opos.exoplayer.core.c.b.c cVar, int i) {
        this.w = -1L;
        this.x = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.z = -9223372036854775807L;
        this.F = -1L;
        this.G = -1L;
        this.H = -9223372036854775807L;
        this.h = cVar;
        cVar.a(new b(this, null));
        this.k = (i & 1) == 0;
        this.i = new f();
        this.j = new SparseArray<>();
        this.n = new p(4);
        this.o = new p(ByteBuffer.allocate(4).putInt(-1).array());
        this.p = new p(4);
        this.l = new p(com.opos.exoplayer.core.i.n.f6506a);
        this.m = new p(4);
        this.q = new p();
        this.r = new p();
        this.s = new p(8);
        this.t = new p();
    }

    private int a(com.opos.exoplayer.core.c.f fVar, n nVar, int i) {
        int iA;
        int iB = this.q.b();
        if (iB > 0) {
            iA = Math.min(i, iB);
            nVar.a(this.q, iA);
        } else {
            iA = nVar.a(fVar, i, false);
        }
        this.U += iA;
        this.ac += iA;
        return iA;
    }

    private long a(long j) throws o {
        long j2 = this.x;
        if (j2 != -9223372036854775807L) {
            return y.d(j, j2, 1000L);
        }
        throw new o("Can't scale timecode prior to timecodeScale being set.");
    }

    private void a(c cVar, long j) {
        d dVar = cVar.L;
        if (dVar != null) {
            dVar.a(cVar, j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f6285a)) {
                a(cVar, "%02d:%02d:%02d,%03d", 19, 1000L, c);
            } else if ("S_TEXT/ASS".equals(cVar.f6285a)) {
                a(cVar, "%01d:%02d:%02d:%02d", 21, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, f);
            }
            cVar.O.a(j, this.T, this.ac, 0, cVar.g);
        }
        this.ad = true;
        d();
    }

    private void a(c cVar, String str, int i, long j, byte[] bArr) {
        a(this.r.f6510a, this.N, str, i, j, bArr);
        n nVar = cVar.O;
        p pVar = this.r;
        nVar.a(pVar, pVar.c());
        this.ac += this.r.c();
    }

    private void a(com.opos.exoplayer.core.c.f fVar, int i) {
        if (this.n.c() >= i) {
            return;
        }
        if (this.n.e() < i) {
            p pVar = this.n;
            byte[] bArr = pVar.f6510a;
            pVar.a(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i)), this.n.c());
        }
        p pVar2 = this.n;
        fVar.b(pVar2.f6510a, pVar2.c(), i - this.n.c());
        this.n.b(i);
    }

    private void a(com.opos.exoplayer.core.c.f fVar, c cVar, int i) throws o {
        int i2;
        if ("S_TEXT/UTF8".equals(cVar.f6285a)) {
            a(fVar, b, i);
            return;
        }
        if ("S_TEXT/ASS".equals(cVar.f6285a)) {
            a(fVar, e, i);
            return;
        }
        n nVar = cVar.O;
        if (!this.V) {
            if (cVar.e) {
                this.T &= -1073741825;
                if (!this.W) {
                    fVar.b(this.n.f6510a, 0, 1);
                    this.U++;
                    byte b2 = this.n.f6510a[0];
                    if ((b2 & 128) == 128) {
                        throw new o("Extension bit is set in signal byte");
                    }
                    this.Z = b2;
                    this.W = true;
                }
                byte b3 = this.Z;
                if ((b3 & 1) == 1) {
                    boolean z = (b3 & 2) == 2;
                    this.T |= 1073741824;
                    if (!this.X) {
                        fVar.b(this.s.f6510a, 0, 8);
                        this.U += 8;
                        this.X = true;
                        this.n.f6510a[0] = (byte) ((z ? 128 : 0) | 8);
                        this.n.c(0);
                        nVar.a(this.n, 1);
                        this.ac++;
                        this.s.c(0);
                        nVar.a(this.s, 8);
                        this.ac += 8;
                    }
                    if (z) {
                        if (!this.Y) {
                            fVar.b(this.n.f6510a, 0, 1);
                            this.U++;
                            this.n.c(0);
                            this.aa = this.n.g();
                            this.Y = true;
                        }
                        int i3 = this.aa * 4;
                        this.n.a(i3);
                        fVar.b(this.n.f6510a, 0, i3);
                        this.U += i3;
                        short s = (short) ((this.aa / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.u;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.u = ByteBuffer.allocate(i4);
                        }
                        this.u.position(0);
                        this.u.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.aa;
                            if (i5 >= i2) {
                                break;
                            }
                            int iU = this.n.u();
                            if (i5 % 2 == 0) {
                                this.u.putShort((short) (iU - i6));
                            } else {
                                this.u.putInt(iU - i6);
                            }
                            i5++;
                            i6 = iU;
                        }
                        int i7 = (i - this.U) - i6;
                        int i8 = i2 % 2;
                        ByteBuffer byteBuffer2 = this.u;
                        if (i8 == 1) {
                            byteBuffer2.putInt(i7);
                        } else {
                            byteBuffer2.putShort((short) i7);
                            this.u.putInt(0);
                        }
                        this.t.a(this.u.array(), i4);
                        nVar.a(this.t, i4);
                        this.ac += i4;
                    }
                }
            } else {
                byte[] bArr = cVar.f;
                if (bArr != null) {
                    this.q.a(bArr, bArr.length);
                }
            }
            this.V = true;
        }
        int iC = i + this.q.c();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f6285a) && !"V_MPEGH/ISO/HEVC".equals(cVar.f6285a)) {
            if (cVar.L != null) {
                com.opos.exoplayer.core.i.a.b(this.q.c() == 0);
                cVar.L.a(fVar, this.T, iC);
            }
            while (true) {
                int i9 = this.U;
                if (i9 >= iC) {
                    break;
                } else {
                    a(fVar, nVar, iC - i9);
                }
            }
        } else {
            byte[] bArr2 = this.m.f6510a;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i10 = cVar.P;
            int i11 = 4 - i10;
            while (this.U < iC) {
                int i12 = this.ab;
                if (i12 == 0) {
                    a(fVar, bArr2, i11, i10);
                    this.m.c(0);
                    this.ab = this.m.u();
                    this.l.c(0);
                    nVar.a(this.l, 4);
                    this.ac += 4;
                } else {
                    this.ab = i12 - a(fVar, nVar, i12);
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f6285a)) {
            this.o.c(0);
            nVar.a(this.o, 4);
            this.ac += 4;
        }
    }

    private void a(com.opos.exoplayer.core.c.f fVar, byte[] bArr, int i) {
        int length = bArr.length + i;
        if (this.r.e() < length) {
            this.r.f6510a = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.r.f6510a, 0, bArr.length);
        }
        fVar.b(this.r.f6510a, bArr.length, i);
        this.r.a(length);
    }

    private void a(com.opos.exoplayer.core.c.f fVar, byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, this.q.b());
        fVar.b(bArr, i + iMin, i2 - iMin);
        if (iMin > 0) {
            this.q.a(bArr, i, iMin);
        }
        this.U += i2;
    }

    private static void a(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        byte[] bArrC;
        if (j == -9223372036854775807L) {
            bArrC = bArr2;
        } else {
            int i2 = (int) (j / 3600000000L);
            long j3 = j - (((long) (i2 * 3600)) * 1000000);
            int i3 = (int) (j3 / 60000000);
            long j4 = j3 - (((long) (i3 * 60)) * 1000000);
            int i4 = (int) (j4 / 1000000);
            bArrC = y.c(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j4 - (((long) i4) * 1000000)) / j2))));
        }
        System.arraycopy(bArrC, 0, bArr, i, bArr2.length);
    }

    private boolean a(com.opos.exoplayer.core.c.k kVar, long j) {
        if (this.E) {
            this.G = j;
            kVar.f6369a = this.F;
            this.E = false;
            return true;
        }
        if (this.B) {
            long j2 = this.G;
            if (j2 != -1) {
                kVar.f6369a = j2;
                this.G = -1L;
                return true;
            }
        }
        return false;
    }

    private static boolean a(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    private static int[] a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    private void d() {
        this.U = 0;
        this.ac = 0;
        this.ab = 0;
        this.V = false;
        this.W = false;
        this.Y = false;
        this.aa = 0;
        this.Z = (byte) 0;
        this.X = false;
        this.q.a();
    }

    private l e() {
        k kVar;
        k kVar2;
        if (this.w == -1 || this.z == -9223372036854775807L || (kVar = this.I) == null || kVar.a() == 0 || (kVar2 = this.J) == null || kVar2.a() != this.I.a()) {
            this.I = null;
            this.J = null;
            return new l.b(this.z);
        }
        int iA = this.I.a();
        int[] iArr = new int[iA];
        long[] jArr = new long[iA];
        long[] jArr2 = new long[iA];
        long[] jArr3 = new long[iA];
        int i = 0;
        for (int i2 = 0; i2 < iA; i2++) {
            jArr3[i2] = this.I.a(i2);
            jArr[i2] = this.w + this.J.a(i2);
        }
        while (true) {
            int i3 = iA - 1;
            if (i >= i3) {
                iArr[i3] = (int) ((this.w + this.v) - jArr[i3]);
                jArr2[i3] = this.z - jArr3[i3];
                this.I = null;
                this.J = null;
                return new com.opos.exoplayer.core.c.a(iArr, jArr, jArr2, jArr3);
            }
            int i4 = i + 1;
            iArr[i] = (int) (jArr[i4] - jArr[i]);
            jArr2[i] = jArr3[i4] - jArr3[i];
            i = i4;
        }
    }

    int a(int i) {
        switch (i) {
            case 131:
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH /* 136 */:
            case 155:
            case 159:
            case 176:
            case 179:
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS /* 186 */:
            case 215:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR /* 231 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE /* 241 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR /* 251 */:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE /* 174 */:
            case 183:
            case 187:
            case 224:
            case JfifUtil.MARKER_APP1 /* 225 */:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        this.ad = false;
        boolean zA = true;
        while (zA && !this.ad) {
            zA = this.h.a(fVar);
            if (zA && a(kVar, fVar.c())) {
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i = 0; i < this.j.size(); i++) {
            this.j.valueAt(i).a();
        }
        return -1;
    }

    void a(int i, double d2) {
        if (i == 181) {
            this.A.I = (int) d2;
        }
        if (i == 17545) {
            this.y = (long) d2;
            return;
        }
        switch (i) {
            case 21969:
                this.A.w = (float) d2;
                break;
            case 21970:
                this.A.x = (float) d2;
                break;
            case 21971:
                this.A.y = (float) d2;
                break;
            case 21972:
                this.A.z = (float) d2;
                break;
            case 21973:
                this.A.A = (float) d2;
                break;
            case 21974:
                this.A.B = (float) d2;
                break;
            case 21975:
                this.A.C = (float) d2;
                break;
            case 21976:
                this.A.D = (float) d2;
                break;
            case 21977:
                this.A.E = (float) d2;
                break;
            case 21978:
                this.A.F = (float) d2;
                break;
        }
    }

    void a(int i, int i2, com.opos.exoplayer.core.c.f fVar) throws o {
        int i3;
        long j;
        int i4;
        int i5;
        int i6;
        int i7 = 1;
        int i8 = 0;
        if (i != 161 && i != 163) {
            if (i == 16981) {
                c cVar = this.A;
                cVar.f = new byte[i2];
                fVar.b(cVar.f, 0, i2);
                return;
            }
            if (i == 18402) {
                byte[] bArr = new byte[i2];
                fVar.b(bArr, 0, i2);
                this.A.g = new n.a(1, bArr, 0, 0);
                return;
            }
            if (i == 21419) {
                Arrays.fill(this.p.f6510a, (byte) 0);
                fVar.b(this.p.f6510a, 4 - i2, i2);
                this.p.c(0);
                this.C = (int) this.p.m();
                return;
            }
            if (i == 25506) {
                c cVar2 = this.A;
                cVar2.h = new byte[i2];
                fVar.b(cVar2.h, 0, i2);
                return;
            } else {
                if (i != 30322) {
                    throw new o("Unexpected id: " + i);
                }
                c cVar3 = this.A;
                cVar3.o = new byte[i2];
                fVar.b(cVar3.o, 0, i2);
                return;
            }
        }
        if (this.L == 0) {
            this.R = (int) this.i.a(fVar, false, true, 8);
            this.S = this.i.b();
            this.N = -9223372036854775807L;
            this.L = 1;
            this.n.a();
        }
        c cVar4 = this.j.get(this.R);
        if (cVar4 == null) {
            fVar.b(i2 - this.S);
            this.L = 0;
            return;
        }
        if (this.L == 1) {
            a(fVar, 3);
            int i9 = (this.n.f6510a[2] & 6) >> 1;
            byte b2 = 255;
            if (i9 == 0) {
                this.P = 1;
                int[] iArrA = a(this.Q, 1);
                this.Q = iArrA;
                iArrA[0] = (i2 - this.S) - 3;
            } else {
                if (i != 163) {
                    throw new o("Lacing only supported in SimpleBlocks.");
                }
                int i10 = 4;
                a(fVar, 4);
                int i11 = (this.n.f6510a[3] & 255) + 1;
                this.P = i11;
                int[] iArrA2 = a(this.Q, i11);
                this.Q = iArrA2;
                if (i9 == 2) {
                    int i12 = (i2 - this.S) - 4;
                    int i13 = this.P;
                    Arrays.fill(iArrA2, 0, i13, i12 / i13);
                } else if (i9 == 1) {
                    int i14 = 0;
                    int i15 = 0;
                    while (true) {
                        i4 = this.P - 1;
                        if (i14 >= i4) {
                            break;
                        }
                        this.Q[i14] = 0;
                        while (true) {
                            i5 = i10 + 1;
                            a(fVar, i5);
                            int i16 = this.n.f6510a[i10] & 255;
                            int[] iArr = this.Q;
                            i6 = iArr[i14] + i16;
                            iArr[i14] = i6;
                            if (i16 != 255) {
                                break;
                            } else {
                                i10 = i5;
                            }
                        }
                        i15 += i6;
                        i14++;
                        i10 = i5;
                    }
                    this.Q[i4] = ((i2 - this.S) - i10) - i15;
                } else {
                    if (i9 != 3) {
                        throw new o("Unexpected lacing value: " + i9);
                    }
                    int i17 = 0;
                    int i18 = 0;
                    while (true) {
                        int i19 = this.P - i7;
                        if (i17 >= i19) {
                            this.Q[i19] = ((i2 - this.S) - i10) - i18;
                            break;
                        }
                        this.Q[i17] = i8;
                        int i20 = i10 + 1;
                        a(fVar, i20);
                        if (this.n.f6510a[i10] == 0) {
                            throw new o("No valid varint length mask found");
                        }
                        int i21 = i8;
                        while (true) {
                            if (i21 >= 8) {
                                j = 0;
                                break;
                            }
                            int i22 = i7 << (7 - i21);
                            if ((this.n.f6510a[i10] & i22) != 0) {
                                i20 += i21;
                                a(fVar, i20);
                                j = (~i22) & this.n.f6510a[i10] & b2;
                                int i23 = i10 + 1;
                                while (i23 < i20) {
                                    j = (j << 8) | ((long) (this.n.f6510a[i23] & b2));
                                    i23++;
                                    b2 = 255;
                                }
                                if (i17 <= 0) {
                                    break;
                                }
                                j -= (1 << ((i21 * 7) + 6)) - 1;
                                break;
                            }
                            i21++;
                            i7 = 1;
                            b2 = 255;
                        }
                        i10 = i20;
                        if (j < -2147483648L || j > 2147483647L) {
                            throw new o("EBML lacing sample size out of range.");
                        }
                        int i24 = (int) j;
                        int[] iArr2 = this.Q;
                        if (i17 != 0) {
                            i24 += iArr2[i17 - 1];
                        }
                        iArr2[i17] = i24;
                        i18 += i24;
                        i17++;
                        i7 = 1;
                        i8 = 0;
                        b2 = 255;
                    }
                }
            }
            byte[] bArr2 = this.n.f6510a;
            this.M = this.H + a((bArr2[1] & 255) | (bArr2[0] << 8));
            this.T = ((this.n.f6510a[2] & 8) == 8 ? Integer.MIN_VALUE : 0) | ((cVar4.c == 2 || (i == 163 && (this.n.f6510a[2] & 128) == 128)) ? 1 : 0);
            this.L = 2;
            this.O = 0;
            i3 = 163;
        } else {
            i3 = 163;
        }
        if (i != i3) {
            a(fVar, cVar4, this.Q[0]);
            return;
        }
        while (true) {
            int i25 = this.O;
            if (i25 >= this.P) {
                this.L = 0;
                return;
            } else {
                a(fVar, cVar4, this.Q[i25]);
                a(cVar4, this.M + ((long) ((this.O * cVar4.d) / 1000)));
                this.O++;
            }
        }
    }

    void a(int i, long j) throws o {
        if (i == 20529) {
            if (j != 0) {
                throw new o("ContentEncodingOrder " + j + " not supported");
            }
            return;
        }
        if (i == 20530) {
            if (j != 1) {
                throw new o("ContentEncodingScope " + j + " not supported");
            }
            return;
        }
        switch (i) {
            case 131:
                this.A.c = (int) j;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH /* 136 */:
                this.A.M = j == 1;
                return;
            case 155:
                this.N = a(j);
                return;
            case 159:
                this.A.G = (int) j;
                return;
            case 176:
                this.A.j = (int) j;
                return;
            case 179:
                this.I.a(a(j));
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS /* 186 */:
                this.A.k = (int) j;
                return;
            case 215:
                this.A.b = (int) j;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR /* 231 */:
                this.H = a(j);
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE /* 241 */:
                if (this.K) {
                    return;
                }
                this.J.a(j);
                this.K = true;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR /* 251 */:
                this.ae = true;
                return;
            case 16980:
                if (j != 3) {
                    throw new o("ContentCompAlgo " + j + " not supported");
                }
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    throw new o("DocTypeReadVersion " + j + " not supported");
                }
                return;
            case 17143:
                if (j != 1) {
                    throw new o("EBMLReadVersion " + j + " not supported");
                }
                return;
            case 18401:
                if (j != 5) {
                    throw new o("ContentEncAlgo " + j + " not supported");
                }
                return;
            case 18408:
                if (j != 1) {
                    throw new o("AESSettingsCipherMode " + j + " not supported");
                }
                return;
            case 21420:
                this.D = j + this.w;
                return;
            case 21432:
                int i2 = (int) j;
                if (i2 == 0) {
                    this.A.p = 0;
                    return;
                }
                if (i2 == 1) {
                    this.A.p = 2;
                    return;
                } else if (i2 == 3) {
                    this.A.p = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.A.p = 3;
                    return;
                }
            case 21680:
                this.A.l = (int) j;
                return;
            case 21682:
                this.A.n = (int) j;
                return;
            case 21690:
                this.A.m = (int) j;
                return;
            case 21930:
                this.A.N = j == 1;
                return;
            case 22186:
                this.A.J = j;
                return;
            case 22203:
                this.A.K = j;
                return;
            case 25188:
                this.A.H = (int) j;
                return;
            case 2352003:
                this.A.d = (int) j;
                return;
            case 2807729:
                this.x = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i3 = (int) j;
                        if (i3 == 1) {
                            this.A.t = 2;
                            return;
                        } else {
                            if (i3 != 2) {
                                return;
                            }
                            this.A.t = 1;
                            return;
                        }
                    case 21946:
                        int i4 = (int) j;
                        if (i4 != 1) {
                            if (i4 == 16) {
                                this.A.s = 6;
                                return;
                            } else if (i4 == 18) {
                                this.A.s = 7;
                                return;
                            } else if (i4 != 6 && i4 != 7) {
                                return;
                            }
                        }
                        this.A.s = 3;
                        return;
                    case 21947:
                        c cVar = this.A;
                        cVar.q = true;
                        int i5 = (int) j;
                        if (i5 == 1) {
                            cVar.r = 1;
                            return;
                        }
                        if (i5 == 9) {
                            cVar.r = 6;
                            return;
                        } else {
                            if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                cVar.r = 2;
                                return;
                            }
                            return;
                        }
                    case 21948:
                        this.A.u = (int) j;
                        return;
                    case 21949:
                        this.A.v = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    void a(int i, long j, long j2) throws o {
        if (i == 160) {
            this.ae = false;
            return;
        }
        if (i == 174) {
            this.A = new c(null);
            return;
        }
        if (i == 187) {
            this.K = false;
            return;
        }
        if (i == 19899) {
            this.C = -1;
            this.D = -1L;
            return;
        }
        if (i == 20533) {
            this.A.e = true;
            return;
        }
        if (i == 21968) {
            this.A.q = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.w;
            if (j3 != -1 && j3 != j) {
                throw new o("Multiple Segment elements not supported");
            }
            this.w = j;
            this.v = j2;
            return;
        }
        if (i == 475249515) {
            this.I = new k();
            this.J = new k();
        } else if (i == 524531317 && !this.B) {
            if (this.k && this.F != -1) {
                this.E = true;
            } else {
                this.af.a(new l.b(this.z));
                this.B = true;
            }
        }
    }

    void a(int i, String str) throws o {
        if (i == 134) {
            this.A.f6285a = str;
            return;
        }
        if (i != 17026) {
            if (i != 2274716) {
                return;
            }
            this.A.Q = str;
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw new o("DocType " + str + " not supported");
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        this.H = -9223372036854775807L;
        this.L = 0;
        this.h.a();
        this.i.a();
        d();
        for (int i = 0; i < this.j.size(); i++) {
            this.j.valueAt(i).b();
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(g gVar) {
        this.af = gVar;
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        return new e().a(fVar);
    }

    boolean b(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }

    void c(int i) throws o {
        if (i == 160) {
            if (this.L != 2) {
                return;
            }
            if (!this.ae) {
                this.T |= 1;
            }
            a(this.j.get(this.R), this.M);
            this.L = 0;
            return;
        }
        if (i == 174) {
            if (a(this.A.f6285a)) {
                c cVar = this.A;
                cVar.a(this.af, cVar.b);
                SparseArray<c> sparseArray = this.j;
                c cVar2 = this.A;
                sparseArray.put(cVar2.b, cVar2);
            }
            this.A = null;
            return;
        }
        if (i == 19899) {
            int i2 = this.C;
            if (i2 != -1) {
                long j = this.D;
                if (j != -1) {
                    if (i2 == 475249515) {
                        this.F = j;
                        return;
                    }
                    return;
                }
            }
            throw new o("Mandatory element SeekID or SeekPosition not found");
        }
        if (i == 25152) {
            c cVar3 = this.A;
            if (cVar3.e) {
                n.a aVar = cVar3.g;
                if (aVar == null) {
                    throw new o("Encrypted Track found but ContentEncKeyID was not found");
                }
                cVar3.i = new DrmInitData(new DrmInitData.SchemeData(com.opos.exoplayer.core.b.b, MimeTypes.VIDEO_WEBM, aVar.b));
                return;
            }
            return;
        }
        if (i == 28032) {
            c cVar4 = this.A;
            if (cVar4.e && cVar4.f != null) {
                throw new o("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i == 357149030) {
            if (this.x == -9223372036854775807L) {
                this.x = 1000000L;
            }
            long j2 = this.y;
            if (j2 != -9223372036854775807L) {
                this.z = a(j2);
                return;
            }
            return;
        }
        if (i == 374648427) {
            if (this.j.size() == 0) {
                throw new o("No valid tracks were found");
            }
            this.af.a();
        } else if (i == 475249515 && !this.B) {
            this.af.a(e());
            this.B = true;
        }
    }
}
