package com.opos.exoplayer.core.metadata.id3;

import com.huawei.openalliance.ad.constant.bj;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.d;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.apache.commons.codec.CharEncoding;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a implements com.opos.exoplayer.core.metadata.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6535a = y.f("ID3");
    private final InterfaceC0929a b;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.metadata.id3.a$a, reason: collision with other inner class name */
    public interface InterfaceC0929a {
        boolean a(int i, int i2, int i3, int i4, int i5);
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6536a;
        private final boolean b;
        private final int c;

        public b(int i, boolean z, int i2) {
            this.f6536a = i;
            this.b = z;
            this.c = i2;
        }
    }

    public a() {
        this(null);
    }

    public a(InterfaceC0929a interfaceC0929a) {
        this.b = interfaceC0929a;
    }

    private static int a(byte[] bArr, int i, int i2) {
        int iB = b(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iB;
        }
        while (iB < bArr.length - 1) {
            if (iB % 2 == 0 && bArr[iB + 1] == 0) {
                return iB;
            }
            iB = b(bArr, iB + 1);
        }
        return bArr.length;
    }

    private static ApicFrame a(p pVar, int i, int i2) {
        int iB;
        String str;
        int iG = pVar.g();
        String strA = a(iG);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        pVar.a(bArr, 0, i3);
        if (i2 == 2) {
            str = "image/" + y.d(new String(bArr, 0, 3, "ISO-8859-1"));
            if (str.equals(bj.I)) {
                str = "image/jpeg";
            }
            iB = 2;
        } else {
            iB = b(bArr, 0);
            String strD = y.d(new String(bArr, 0, iB, "ISO-8859-1"));
            str = strD.indexOf(47) == -1 ? "image/" + strD : strD;
        }
        int i4 = bArr[iB + 1] & 255;
        int i5 = iB + 2;
        int iA = a(bArr, i5, iG);
        return new ApicFrame(str, new String(bArr, i5, iA - i5, strA), i4, b(bArr, iA + b(iG), i3));
    }

    private static ChapterFrame a(p pVar, int i, int i2, boolean z, int i3, InterfaceC0929a interfaceC0929a) {
        int iD = pVar.d();
        int iB = b(pVar.f6510a, iD);
        String str = new String(pVar.f6510a, iD, iB - iD, "ISO-8859-1");
        pVar.c(iB + 1);
        int iO = pVar.o();
        int iO2 = pVar.o();
        long jM = pVar.m();
        long j = jM == 4294967295L ? -1L : jM;
        long jM2 = pVar.m();
        long j2 = jM2 == 4294967295L ? -1L : jM2;
        ArrayList arrayList = new ArrayList();
        int i4 = iD + i;
        while (pVar.d() < i4) {
            Id3Frame id3FrameA = a(i2, pVar, z, i3, interfaceC0929a);
            if (id3FrameA != null) {
                arrayList.add(id3FrameA);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, iO, iO2, j, j2, id3FrameArr);
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0198  */
    /* JADX WARN: Code duplicated, block: B:140:0x01a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:152:0x01dd A[Catch: all -> 0x012f, UnsupportedEncodingException -> 0x0209, Merged into TryCatch #1 {all -> 0x012f, UnsupportedEncodingException -> 0x0209, blocks: (B:91:0x011d, B:154:0x01e7, B:157:0x0209, B:93:0x0125, B:102:0x013e, B:104:0x0146, B:112:0x0160, B:121:0x0178, B:132:0x0193, B:139:0x01a4, B:145:0x01b3, B:151:0x01cd, B:152:0x01dd), top: B:164:0x0113 }] */
    private static Id3Frame a(int i, p pVar, boolean z, int i2, InterfaceC0929a interfaceC0929a) {
        int iU;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Id3Frame id3FrameC;
        int iG = pVar.g();
        int iG2 = pVar.g();
        int iG3 = pVar.g();
        int iG4 = i >= 3 ? pVar.g() : 0;
        if (i == 4) {
            iU = pVar.u();
            if (!z) {
                iU = (((iU >> 24) & 255) << 21) | (iU & 255) | (((iU >> 8) & 255) << 7) | (((iU >> 16) & 255) << 14);
            }
        } else {
            iU = i == 3 ? pVar.u() : pVar.k();
        }
        int i4 = iU;
        int iH = i >= 3 ? pVar.h() : 0;
        if (iG == 0 && iG2 == 0 && iG3 == 0 && iG4 == 0 && i4 == 0 && iH == 0) {
            pVar.c(pVar.c());
            return null;
        }
        int iD = pVar.d() + i4;
        if (iD > pVar.c()) {
            com.opos.cmn.an.f.a.c("Id3Decoder", "Frame size exceeds remaining tag data");
            pVar.c(pVar.c());
            return null;
        }
        if (interfaceC0929a != null) {
            i3 = iD;
            if (!interfaceC0929a.a(i, iG, iG2, iG3, iG4)) {
                pVar.c(i3);
                return null;
            }
        } else {
            i3 = iD;
        }
        if (i == 3) {
            int i5 = iH;
            z6 = (i5 & 128) != 0;
            z4 = (i5 & 64) != 0;
            z5 = false;
            z2 = (i5 & 32) != 0;
            z3 = z6;
        } else {
            int i6 = iH;
            if (i == 4) {
                z2 = (i6 & 64) != 0;
                z3 = (i6 & 8) != 0;
                z4 = (i6 & 4) != 0;
                z5 = (i6 & 2) != 0;
                if ((i6 & 1) != 0) {
                    z6 = true;
                }
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
            }
            z6 = false;
        }
        if (z3 || z4) {
            com.opos.cmn.an.f.a.c((String) r4, "Skipping unsupported compressed or encrypted frame");
            pVar.c(i3);
            return null;
        }
        if (z2) {
            i4--;
            pVar.d(1);
        }
        if (z6) {
            i4 -= 4;
            pVar.d(4);
        }
        int iF = i4;
        if (z5) {
            iF = f(pVar, iF);
        }
        int i7 = iF;
        try {
            if (iG == 84 && iG2 == 88 && iG3 == 88 && (i == 2 || iG4 == 88)) {
                id3FrameC = a(pVar, i7);
            } else if (iG == 84) {
                id3FrameC = a(pVar, i7, a(i, iG, iG2, iG3, iG4));
            } else if (iG == 87 && iG2 == 88 && iG3 == 88 && (i == 2 || iG4 == 88)) {
                id3FrameC = b(pVar, i7);
            } else if (iG == 87) {
                id3FrameC = b(pVar, i7, a(i, iG, iG2, iG3, iG4));
            } else if (iG == 80 && iG2 == 82 && iG3 == 73 && iG4 == 86) {
                id3FrameC = c(pVar, i7);
            } else if (iG == 71 && iG2 == 69 && iG3 == 79 && (iG4 == 66 || i == 2)) {
                id3FrameC = d(pVar, i7);
            } else if (i == 2) {
                if (iG == 80 && iG2 == 73 && iG3 == 67) {
                    id3FrameC = a(pVar, i7, i);
                } else if (iG != 67 && iG2 == 79 && iG3 == 77 && (iG4 == 77 || i == 2)) {
                    id3FrameC = e(pVar, i7);
                } else if (iG != 67 && iG2 == 72 && iG3 == 65 && iG4 == 80) {
                    id3FrameC = a(pVar, i7, i, z, i2, interfaceC0929a);
                } else if (iG != 67 && iG2 == 84 && iG3 == 79 && iG4 == 67) {
                    id3FrameC = b(pVar, i7, i, z, i2, interfaceC0929a);
                } else {
                    id3FrameC = c(pVar, i7, a(i, iG, iG2, iG3, iG4));
                }
            } else if (iG == 65 && iG2 == 80 && iG3 == 73 && iG4 == 67) {
                id3FrameC = a(pVar, i7, i);
            } else if (iG != 67) {
                if (iG != 67) {
                    if (iG != 67) {
                        id3FrameC = c(pVar, i7, a(i, iG, iG2, iG3, iG4));
                    } else {
                        id3FrameC = c(pVar, i7, a(i, iG, iG2, iG3, iG4));
                    }
                } else if (iG != 67) {
                    id3FrameC = c(pVar, i7, a(i, iG, iG2, iG3, iG4));
                } else {
                    id3FrameC = c(pVar, i7, a(i, iG, iG2, iG3, iG4));
                }
            } else if (iG != 67) {
                if (iG != 67) {
                    id3FrameC = c(pVar, i7, a(i, iG, iG2, iG3, iG4));
                } else {
                    id3FrameC = c(pVar, i7, a(i, iG, iG2, iG3, iG4));
                }
            } else if (iG != 67) {
                id3FrameC = c(pVar, i7, a(i, iG, iG2, iG3, iG4));
            } else {
                id3FrameC = c(pVar, i7, a(i, iG, iG2, iG3, iG4));
            }
            if (id3FrameC == null) {
                com.opos.cmn.an.f.a.c("Id3Decoder", "Failed to decode frame: id=" + a(i, iG, iG2, iG3, iG4) + ", frameSize=" + i7);
            }
            pVar.c(i3);
            return id3FrameC;
        } catch (UnsupportedEncodingException unused) {
            com.opos.cmn.an.f.a.c((String) r4, "Unsupported character encoding");
            return null;
        } finally {
            pVar.c(i3);
        }
    }

    private static TextInformationFrame a(p pVar, int i) {
        if (i < 1) {
            return null;
        }
        int iG = pVar.g();
        String strA = a(iG);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        pVar.a(bArr, 0, i2);
        int iA = a(bArr, 0, iG);
        String str = new String(bArr, 0, iA, strA);
        int iB = iA + b(iG);
        return new TextInformationFrame("TXXX", str, a(bArr, iB, a(bArr, iB, iG), strA));
    }

    private static TextInformationFrame a(p pVar, int i, String str) {
        if (i < 1) {
            return null;
        }
        int iG = pVar.g();
        String strA = a(iG);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        pVar.a(bArr, 0, i2);
        return new TextInformationFrame(str, null, new String(bArr, 0, a(bArr, 0, iG), strA));
    }

    private static b a(p pVar) {
        StringBuilder sb;
        String string;
        if (pVar.b() < 10) {
            string = "Data too short to be an ID3 tag";
        } else {
            int iK = pVar.k();
            if (iK == f6535a) {
                iK = pVar.g();
                pVar.d(1);
                int iG = pVar.g();
                int iT = pVar.t();
                if (iK == 2) {
                    if ((iG & 64) != 0) {
                        string = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme";
                    }
                } else if (iK == 3) {
                    if ((iG & 64) != 0) {
                        int iO = pVar.o();
                        pVar.d(iO);
                        iT -= iO + 4;
                    }
                } else if (iK == 4) {
                    if ((iG & 64) != 0) {
                        int iT2 = pVar.t();
                        pVar.d(iT2 - 4);
                        iT -= iT2;
                    }
                    if ((iG & 16) != 0) {
                        iT -= 10;
                    }
                } else {
                    sb = new StringBuilder("Skipped ID3 tag with unsupported majorVersion=");
                }
                return new b(iK, iK < 4 && (iG & 128) != 0, iT);
            }
            sb = new StringBuilder("Unexpected first three bytes of ID3 tag header: ");
            string = sb.append(iK).toString();
        }
        com.opos.cmn.an.f.a.c("Id3Decoder", string);
        return null;
    }

    private static String a(int i) {
        if (i == 1) {
            return "UTF-16";
        }
        if (i != 2) {
            return i != 3 ? "ISO-8859-1" : "UTF-8";
        }
        return CharEncoding.UTF_16BE;
    }

    private static String a(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static String a(byte[] bArr, int i, int i2, String str) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0087 A[PHI: r3
  0x0087: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:39:0x0084, B:31:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    private static boolean a(p pVar, int i, int i2, boolean z) {
        int iK;
        long jK;
        int iH;
        int i3;
        int iD = pVar.d();
        while (true) {
            try {
                boolean z2 = true;
                if (pVar.b() < i2) {
                    pVar.c(iD);
                    return true;
                }
                if (i >= 3) {
                    iK = pVar.o();
                    jK = pVar.m();
                    iH = pVar.h();
                } else {
                    iK = pVar.k();
                    jK = pVar.k();
                    iH = 0;
                }
                if (iK == 0 && jK == 0 && iH == 0) {
                    pVar.c(iD);
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & jK) != 0) {
                        pVar.c(iD);
                        return false;
                    }
                    jK = (((jK >> 24) & 255) << 21) | (jK & 255) | (((jK >> 8) & 255) << 7) | (((jK >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i3 = (iH & 64) != 0 ? 1 : 0;
                    if ((iH & 1) == 0) {
                        z2 = false;
                    }
                } else if (i == 3) {
                    i3 = (iH & 32) != 0 ? 1 : 0;
                    if ((iH & 128) == 0) {
                        z2 = false;
                    }
                } else {
                    i3 = 0;
                    z2 = false;
                }
                if (z2) {
                    i3 += 4;
                }
                if (jK < i3) {
                    pVar.c(iD);
                    return false;
                }
                if (pVar.b() < jK) {
                    pVar.c(iD);
                    return false;
                }
                pVar.d((int) jK);
            } catch (Throwable th) {
                pVar.c(iD);
                throw th;
            }
        }
    }

    private static int b(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int b(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static ChapterTocFrame b(p pVar, int i, int i2, boolean z, int i3, InterfaceC0929a interfaceC0929a) {
        int iD = pVar.d();
        int iB = b(pVar.f6510a, iD);
        String str = new String(pVar.f6510a, iD, iB - iD, "ISO-8859-1");
        pVar.c(iB + 1);
        int iG = pVar.g();
        boolean z2 = (iG & 2) != 0;
        boolean z3 = (iG & 1) != 0;
        int iG2 = pVar.g();
        String[] strArr = new String[iG2];
        for (int i4 = 0; i4 < iG2; i4++) {
            int iD2 = pVar.d();
            int iB2 = b(pVar.f6510a, iD2);
            strArr[i4] = new String(pVar.f6510a, iD2, iB2 - iD2, "ISO-8859-1");
            pVar.c(iB2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = iD + i;
        while (pVar.d() < i5) {
            Id3Frame id3FrameA = a(i2, pVar, z, i3, interfaceC0929a);
            if (id3FrameA != null) {
                arrayList.add(id3FrameA);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    private static UrlLinkFrame b(p pVar, int i) {
        if (i < 1) {
            return null;
        }
        int iG = pVar.g();
        String strA = a(iG);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        pVar.a(bArr, 0, i2);
        int iA = a(bArr, 0, iG);
        String str = new String(bArr, 0, iA, strA);
        int iB = iA + b(iG);
        return new UrlLinkFrame("WXXX", str, a(bArr, iB, b(bArr, iB), "ISO-8859-1"));
    }

    private static UrlLinkFrame b(p pVar, int i, String str) {
        byte[] bArr = new byte[i];
        pVar.a(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    private static byte[] b(byte[] bArr, int i, int i2) {
        return i2 <= i ? new byte[0] : Arrays.copyOfRange(bArr, i, i2);
    }

    private static BinaryFrame c(p pVar, int i, String str) {
        byte[] bArr = new byte[i];
        pVar.a(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    private static PrivFrame c(p pVar, int i) {
        byte[] bArr = new byte[i];
        pVar.a(bArr, 0, i);
        int iB = b(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iB, "ISO-8859-1"), b(bArr, iB + 1, i));
    }

    private static GeobFrame d(p pVar, int i) {
        int iG = pVar.g();
        String strA = a(iG);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        pVar.a(bArr, 0, i2);
        int iB = b(bArr, 0);
        String str = new String(bArr, 0, iB, "ISO-8859-1");
        int i3 = iB + 1;
        int iA = a(bArr, i3, iG);
        String strA2 = a(bArr, i3, iA, strA);
        int iB2 = iA + b(iG);
        int iA2 = a(bArr, iB2, iG);
        return new GeobFrame(str, strA2, a(bArr, iB2, iA2, strA), b(bArr, iA2 + b(iG), i2));
    }

    private static CommentFrame e(p pVar, int i) {
        if (i < 4) {
            return null;
        }
        int iG = pVar.g();
        String strA = a(iG);
        byte[] bArr = new byte[3];
        pVar.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        pVar.a(bArr2, 0, i2);
        int iA = a(bArr2, 0, iG);
        String str2 = new String(bArr2, 0, iA, strA);
        int iB = iA + b(iG);
        return new CommentFrame(str, str2, a(bArr2, iB, a(bArr2, iB, iG), strA));
    }

    private static int f(p pVar, int i) {
        byte[] bArr = pVar.f6510a;
        int iD = pVar.d();
        while (true) {
            int i2 = iD + 1;
            if (i2 >= i) {
                return i;
            }
            if ((bArr[iD] & 255) == 255 && bArr[i2] == 0) {
                System.arraycopy(bArr, iD + 2, bArr, i2, (i - iD) - 2);
                i--;
            }
            iD = i2;
        }
    }

    @Override // com.opos.exoplayer.core.metadata.a
    public Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.b;
        return a(byteBuffer.array(), byteBuffer.limit());
    }

    public Metadata a(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        p pVar = new p(bArr, i);
        b bVarA = a(pVar);
        if (bVarA == null) {
            return null;
        }
        int iD = pVar.d();
        int i2 = bVarA.f6536a == 2 ? 6 : 10;
        int iF = bVarA.c;
        if (bVarA.b) {
            iF = f(pVar, bVarA.c);
        }
        pVar.b(iD + iF);
        boolean z = false;
        if (!a(pVar, bVarA.f6536a, i2, false)) {
            if (bVarA.f6536a != 4 || !a(pVar, 4, i2, true)) {
                com.opos.cmn.an.f.a.c("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + bVarA.f6536a);
                return null;
            }
            z = true;
        }
        while (pVar.b() >= i2) {
            Id3Frame id3FrameA = a(bVarA.f6536a, pVar, z, i2, this.b);
            if (id3FrameA != null) {
                arrayList.add(id3FrameA);
            }
        }
        return new Metadata(arrayList);
    }
}
