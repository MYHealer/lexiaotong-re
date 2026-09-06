package com.opos.exoplayer.core.d;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.b.e;
import com.opos.exoplayer.core.h;
import com.opos.exoplayer.core.i.n;
import com.opos.exoplayer.core.i.x;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class b extends com.opos.exoplayer.core.a {
    private static final byte[] b = y.g("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private long A;
    private int B;
    private int C;
    private ByteBuffer D;
    private boolean E;
    private boolean F;
    private int G;
    private int H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.opos.exoplayer.core.b.d f6375a;
    private final c c;
    private final com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> d;
    private final boolean e;
    private final e f;
    private final e g;
    private final l h;
    private final List<Long> i;
    private final MediaCodec.BufferInfo j;
    private Format k;
    private com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> l;
    private com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> m;
    private MediaCodec n;
    private com.opos.exoplayer.core.d.a o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private ByteBuffer[] y;
    private ByteBuffer[] z;

    public static class a extends com.opos.exoplayer.core.i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6376a;
        public final boolean b;
        public final String c;
        public final String d;

        public a(Format format, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + format, th);
            this.f6376a = format.f;
            this.b = z;
            this.c = null;
            this.d = a(i);
        }

        public a(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + format, th);
            this.f6376a = format.f;
            this.b = z;
            this.c = str;
            this.d = y.f6517a >= 21 ? a(th) : null;
        }

        private static String a(int i) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        private static String a(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        @Override // com.opos.exoplayer.core.i.b
        public String a() {
            return "DecoderInitializationException";
        }
    }

    public b(int i, c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, boolean z) {
        super(i);
        com.opos.exoplayer.core.i.a.b(y.f6517a >= 16);
        this.c = (c) com.opos.exoplayer.core.i.a.a(cVar);
        this.d = bVar;
        this.e = z;
        this.f = new e(0);
        this.g = e.e();
        this.h = new l();
        this.i = new ArrayList();
        this.j = new MediaCodec.BufferInfo();
        this.G = 0;
        this.H = 0;
    }

    private void D() {
        if (y.f6517a < 21) {
            this.y = this.n.getInputBuffers();
            this.z = this.n.getOutputBuffers();
        }
    }

    private void E() {
        if (y.f6517a < 21) {
            this.y = null;
            this.z = null;
        }
    }

    private boolean F() {
        return this.C >= 0;
    }

    private void G() {
        this.B = -1;
        this.f.b = null;
    }

    private void H() {
        this.C = -1;
        this.D = null;
    }

    private void I() {
        MediaFormat outputFormat = this.n.getOutputFormat();
        if (this.p != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.x = true;
            return;
        }
        if (this.v) {
            outputFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT, 1);
        }
        a(this.n, outputFormat);
    }

    private void J() {
        if (y.f6517a < 21) {
            this.z = this.n.getOutputBuffers();
        }
    }

    private void K() {
        if (this.H == 2) {
            A();
            x();
        } else {
            this.L = true;
            w();
        }
    }

    private static MediaCodec.CryptoInfo a(e eVar, int i) {
        MediaCodec.CryptoInfo cryptoInfoA = eVar.f6275a.a();
        if (i == 0) {
            return cryptoInfoA;
        }
        if (cryptoInfoA.numBytesOfClearData == null) {
            cryptoInfoA.numBytesOfClearData = new int[1];
        }
        int[] iArr = cryptoInfoA.numBytesOfClearData;
        iArr[0] = iArr[0] + i;
        return cryptoInfoA;
    }

    private static void a(MediaFormat mediaFormat) {
        mediaFormat.setInteger("priority", 0);
    }

    private void a(a aVar) throws h {
        String strA = y.a(aVar);
        h hVarA = h.a(aVar, r());
        hVarA.a(strA);
        throw hVarA;
    }

    private static boolean a(String str) {
        int i = y.f6517a;
        return i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (y.f6517a == 19 && y.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean a(String str, Format format) {
        return y.f6517a < 21 && format.h.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private int b(String str) {
        if (y.f6517a <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (y.d.startsWith("SM-T585") || y.d.startsWith("SM-A510") || y.d.startsWith("SM-A520") || y.d.startsWith("SM-J700"))) {
            return 2;
        }
        if (y.f6517a >= 24) {
            return 0;
        }
        if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
            return ("flounder".equals(y.b) || "flounder_lte".equals(y.b) || "grouper".equals(y.b) || "tilapia".equals(y.b)) ? 1 : 0;
        }
        return 0;
    }

    private ByteBuffer b(int i) {
        return y.f6517a >= 21 ? this.n.getInputBuffer(i) : this.y[i];
    }

    private boolean b(long j, long j2) {
        boolean zA;
        int iDequeueOutputBuffer;
        if (!F()) {
            if (this.u && this.J) {
                try {
                    iDequeueOutputBuffer = this.n.dequeueOutputBuffer(this.j, C());
                } catch (IllegalStateException unused) {
                    K();
                    if (this.L) {
                        A();
                    }
                    return false;
                }
            } else {
                iDequeueOutputBuffer = this.n.dequeueOutputBuffer(this.j, C());
            }
            if (iDequeueOutputBuffer < 0) {
                if (iDequeueOutputBuffer == -2) {
                    I();
                    return true;
                }
                if (iDequeueOutputBuffer == -3) {
                    J();
                    return true;
                }
                if (this.s && (this.K || this.H == 2)) {
                    K();
                }
                return false;
            }
            if (this.x) {
                this.x = false;
                this.n.releaseOutputBuffer(iDequeueOutputBuffer, false);
                return true;
            }
            if ((this.j.flags & 4) != 0) {
                K();
                return false;
            }
            this.C = iDequeueOutputBuffer;
            ByteBuffer byteBufferC = c(iDequeueOutputBuffer);
            this.D = byteBufferC;
            if (byteBufferC != null) {
                byteBufferC.position(this.j.offset);
                ByteBuffer byteBuffer = this.D;
                MediaCodec.BufferInfo bufferInfo = this.j;
                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            }
            this.E = d(this.j.presentationTimeUs);
        }
        if (this.u && this.J) {
            try {
                zA = a(j, j2, this.n, this.D, this.C, this.j.flags, this.j.presentationTimeUs, this.E);
            } catch (IllegalStateException unused2) {
                K();
                if (this.L) {
                    A();
                }
                return false;
            }
        } else {
            MediaCodec mediaCodec = this.n;
            ByteBuffer byteBuffer2 = this.D;
            int i = this.C;
            MediaCodec.BufferInfo bufferInfo2 = this.j;
            zA = a(j, j2, mediaCodec, byteBuffer2, i, bufferInfo2.flags, bufferInfo2.presentationTimeUs, this.E);
        }
        if (!zA) {
            return false;
        }
        c(this.j.presentationTimeUs);
        H();
        return true;
    }

    private static boolean b(String str, Format format) {
        return y.f6517a <= 18 && format.r == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private boolean b(boolean z) throws h {
        com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar = this.l;
        if (aVar == null || (!z && this.e)) {
            return false;
        }
        int iA = aVar.a();
        if (iA != 1) {
            return iA != 4;
        }
        String strA = y.a(this.l.b());
        h hVarA = h.a(this.l.b(), r());
        hVarA.a(strA);
        throw hVarA;
    }

    private ByteBuffer c(int i) {
        return y.f6517a >= 21 ? this.n.getOutputBuffer(i) : this.z[i];
    }

    private static boolean c(String str) {
        return y.f6517a <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    private boolean d(long j) {
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            if (this.i.get(i).longValue() == j) {
                this.i.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean d(String str) {
        return (y.f6517a <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (y.f6517a <= 19 && "hb2000".equals(y.b) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    private static boolean e(String str) {
        return y.f6517a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private boolean v() throws h {
        int iPosition;
        int iA;
        MediaCodec mediaCodec = this.n;
        if (mediaCodec == null || this.H == 2 || this.K) {
            return false;
        }
        if (this.B < 0) {
            int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.B = iDequeueInputBuffer;
            if (iDequeueInputBuffer < 0) {
                return false;
            }
            this.f.b = b(iDequeueInputBuffer);
            this.f.a();
        }
        if (this.H == 1) {
            if (!this.s) {
                this.J = true;
                this.n.queueInputBuffer(this.B, 0, 0, 0L, 4);
                G();
            }
            this.H = 2;
            return false;
        }
        if (this.w) {
            this.w = false;
            ByteBuffer byteBuffer = this.f.b;
            byte[] bArr = b;
            byteBuffer.put(bArr);
            this.n.queueInputBuffer(this.B, 0, bArr.length, 0L, 0);
            G();
            this.I = true;
            return true;
        }
        if (this.M) {
            iA = -4;
            iPosition = 0;
        } else {
            if (this.G == 1) {
                for (int i = 0; i < this.k.h.size(); i++) {
                    this.f.b.put(this.k.h.get(i));
                }
                this.G = 2;
            }
            iPosition = this.f.b.position();
            iA = a(this.h, this.f, false);
        }
        if (iA == -3) {
            return false;
        }
        if (iA == -5) {
            if (this.G == 2) {
                this.f.a();
                this.G = 1;
            }
            b(this.h.f6520a);
            return true;
        }
        if (this.f.c()) {
            if (this.G == 2) {
                this.f.a();
                this.G = 1;
            }
            this.K = true;
            if (!this.I) {
                K();
                return false;
            }
            try {
                if (!this.s) {
                    this.J = true;
                    this.n.queueInputBuffer(this.B, 0, 0, 0L, 4);
                    G();
                }
                return false;
            } catch (MediaCodec.CryptoException e) {
                String strA = y.a(e);
                h hVarA = h.a(e, r());
                hVarA.a(strA);
                throw hVarA;
            }
        }
        if (this.N && !this.f.d()) {
            this.f.a();
            if (this.G == 2) {
                this.G = 1;
            }
            return true;
        }
        this.N = false;
        boolean zG = this.f.g();
        boolean zB = b(zG);
        this.M = zB;
        if (zB) {
            return false;
        }
        if (this.q && !zG) {
            n.a(this.f.b);
            if (this.f.b.position() == 0) {
                return true;
            }
            this.q = false;
        }
        try {
            long j = this.f.c;
            if (this.f.d_()) {
                this.i.add(Long.valueOf(j));
            }
            this.f.h();
            a(this.f);
            if (zG) {
                this.n.queueSecureInputBuffer(this.B, 0, a(this.f, iPosition), j, 0);
            } else {
                this.n.queueInputBuffer(this.B, 0, this.f.b.limit(), j, 0);
            }
            G();
            this.I = true;
            this.G = 0;
            this.f6375a.c++;
            return true;
        } catch (MediaCodec.CryptoException e2) {
            String strA2 = y.a(e2);
            h hVarA2 = h.a(e2, r());
            hVarA2.a(strA2);
            throw hVarA2;
        }
    }

    protected void A() {
        this.A = -9223372036854775807L;
        G();
        H();
        this.M = false;
        this.E = false;
        this.i.clear();
        E();
        this.o = null;
        this.F = false;
        this.I = false;
        this.q = false;
        this.r = false;
        this.p = 0;
        this.s = false;
        this.t = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.J = false;
        this.G = 0;
        this.H = 0;
        MediaCodec mediaCodec = this.n;
        if (mediaCodec != null) {
            this.f6375a.b++;
            try {
                mediaCodec.stop();
                try {
                    this.n.release();
                    this.n = null;
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar = this.l;
                    if (aVar == null || this.m == aVar) {
                        return;
                    }
                    try {
                        this.d.a(aVar);
                    } finally {
                        this.l = null;
                    }
                } catch (Throwable th) {
                    this.n = null;
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar2 = this.l;
                    if (aVar2 != null && this.m != aVar2) {
                        try {
                            this.d.a(aVar2);
                        } finally {
                            this.l = null;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.n.release();
                    this.n = null;
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar3 = this.l;
                    if (aVar3 != null && this.m != aVar3) {
                        try {
                            this.d.a(aVar3);
                        } finally {
                            this.l = null;
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.n = null;
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar4 = this.l;
                    if (aVar4 != null && this.m != aVar4) {
                        try {
                            this.d.a(aVar4);
                        } finally {
                            this.l = null;
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    protected void B() {
        this.A = -9223372036854775807L;
        G();
        H();
        this.N = true;
        this.M = false;
        this.E = false;
        this.i.clear();
        this.w = false;
        this.x = false;
        if (this.r || ((this.t && this.J) || this.H != 0)) {
            A();
            x();
        } else {
            this.n.flush();
            this.I = false;
        }
        if (!this.F || this.k == null) {
            return;
        }
        this.G = 1;
    }

    protected long C() {
        return 0L;
    }

    @Override // com.opos.exoplayer.core.u
    public final int a(Format format) throws h {
        try {
            return a(this.c, this.d, format);
        } catch (d.a e) {
            String strA = y.a(e);
            h hVarA = h.a(e, r());
            hVarA.a(strA);
            throw hVarA;
        }
    }

    protected abstract int a(c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, Format format);

    protected com.opos.exoplayer.core.d.a a(c cVar, Format format, boolean z) {
        return cVar.a(format.f, z);
    }

    @Override // com.opos.exoplayer.core.t
    public void a(long j, long j2) {
        if (this.L) {
            w();
            return;
        }
        if (this.k == null) {
            this.g.a();
            int iA = a(this.h, this.g, true);
            if (iA != -5) {
                if (iA == -4) {
                    com.opos.exoplayer.core.i.a.b(this.g.c());
                    this.K = true;
                    K();
                    return;
                }
                return;
            }
            b(this.h.f6520a);
        }
        x();
        if (this.n != null) {
            x.a("drainAndFeed");
            while (b(j, j2)) {
            }
            while (v()) {
            }
            x.a();
        } else {
            this.f6375a.d += b(j);
            this.g.a();
            int iA2 = a(this.h, this.g, false);
            if (iA2 == -5) {
                b(this.h.f6520a);
            } else if (iA2 == -4) {
                com.opos.exoplayer.core.i.a.b(this.g.c());
                this.K = true;
                K();
            }
        }
        this.f6375a.a();
    }

    @Override // com.opos.exoplayer.core.a
    protected void a(long j, boolean z) {
        this.K = false;
        this.L = false;
        if (this.n != null) {
            B();
        }
    }

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    protected void a(e eVar) {
    }

    protected abstract void a(com.opos.exoplayer.core.d.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    protected void a(String str, long j, long j2) {
    }

    @Override // com.opos.exoplayer.core.a
    protected void a(boolean z) {
        this.f6375a = new com.opos.exoplayer.core.b.d();
    }

    protected abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return false;
    }

    protected boolean a(com.opos.exoplayer.core.d.a aVar) {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0080  */
    protected void b(Format format) {
        MediaCodec mediaCodec;
        Format format2 = this.k;
        this.k = format;
        boolean z = true;
        if (!y.a(format.i, format2 == null ? null : format2.i)) {
            if (this.k.i != null) {
                com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar = this.d;
                if (bVar == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("Media requires a DrmSessionManager");
                    String strA = y.a(illegalStateException);
                    h hVarA = h.a(illegalStateException, r());
                    hVarA.a(strA);
                    throw hVarA;
                }
                com.opos.exoplayer.core.drm.a aVarA = bVar.a(Looper.myLooper(), this.k.i);
                this.m = aVarA;
                if (aVarA == this.l) {
                    this.d.a(aVarA);
                }
            } else {
                this.m = null;
            }
        }
        if (this.m != this.l || (mediaCodec = this.n) == null || !a(mediaCodec, this.o.b, format2, this.k)) {
            if (this.I) {
                this.H = 1;
                return;
            } else {
                A();
                x();
                return;
            }
        }
        this.F = true;
        this.G = 1;
        int i = this.p;
        if (i != 2) {
            if (i == 1) {
                Format format3 = this.k;
                if (format3.j != format2.j || format3.k != format2.k) {
                    z = false;
                }
            } else {
                z = false;
            }
        }
        this.w = z;
    }

    protected final MediaFormat c(Format format) {
        MediaFormat mediaFormatB = format.b();
        if (y.f6517a >= 23) {
            a(mediaFormatB);
        }
        return mediaFormatB;
    }

    protected void c(long j) {
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.u
    public final int m() {
        return 8;
    }

    @Override // com.opos.exoplayer.core.a
    protected void n() {
    }

    @Override // com.opos.exoplayer.core.a
    protected void o() {
    }

    @Override // com.opos.exoplayer.core.a
    protected void p() {
        this.k = null;
        try {
            A();
            try {
                com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar = this.l;
                if (aVar != null) {
                    this.d.a(aVar);
                }
                try {
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar2 = this.m;
                    if (aVar2 != null && aVar2 != this.l) {
                        this.d.a(aVar2);
                    }
                } finally {
                    this.l = null;
                    this.m = null;
                }
            } catch (Throwable th) {
                try {
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar3 = this.m;
                    if (aVar3 != null && aVar3 != this.l) {
                        this.d.a(aVar3);
                    }
                    throw th;
                } finally {
                    this.l = null;
                    this.m = null;
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.l != null) {
                    this.d.a(this.l);
                }
                try {
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar4 = this.m;
                    if (aVar4 != null && aVar4 != this.l) {
                        this.d.a(aVar4);
                    }
                    throw th2;
                } finally {
                    this.l = null;
                    this.m = null;
                }
            } catch (Throwable th3) {
                try {
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar5 = this.m;
                    if (aVar5 != null && aVar5 != this.l) {
                        this.d.a(aVar5);
                    }
                    throw th3;
                } finally {
                    this.l = null;
                    this.m = null;
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.t
    public boolean t() {
        return (this.k == null || this.M || (!s() && !F() && (this.A == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.A))) ? false : true;
    }

    @Override // com.opos.exoplayer.core.t
    public boolean u() {
        return this.L;
    }

    protected void w() {
    }

    protected final void x() {
        Format format;
        boolean zA;
        MediaCrypto mediaCryptoA;
        if (this.n != null || (format = this.k) == null) {
            return;
        }
        this.l = this.m;
        String str = format.f;
        com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar = this.l;
        if (aVar == null) {
            zA = false;
            mediaCryptoA = null;
        } else {
            com.opos.exoplayer.core.drm.d dVar = (com.opos.exoplayer.core.drm.d) aVar.c();
            if (dVar == null) {
                if (this.l.b() == null) {
                    return;
                }
                zA = false;
                mediaCryptoA = null;
            } else {
                mediaCryptoA = dVar.a();
                zA = dVar.a(str);
            }
        }
        if (this.o == null) {
            try {
                com.opos.exoplayer.core.d.a aVarA = a(this.c, this.k, zA);
                this.o = aVarA;
                if (aVarA == null && zA) {
                    com.opos.exoplayer.core.d.a aVarA2 = a(this.c, this.k, false);
                    this.o = aVarA2;
                    if (aVarA2 != null) {
                        com.opos.cmn.an.f.a.c("MediaCodecRenderer", "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.o.f6374a + ".");
                    }
                }
            } catch (d.a e) {
                a(new a(this.k, e, zA, -49998));
            }
            if (this.o == null) {
                a(new a(this.k, (Throwable) null, zA, -49999));
            }
        }
        if (a(this.o)) {
            String str2 = this.o.f6374a;
            this.p = b(str2);
            this.q = a(str2, this.k);
            this.r = a(str2);
            this.s = c(str2);
            this.t = d(str2);
            this.u = e(str2);
            this.v = b(str2, this.k);
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                x.a("createCodec:" + str2);
                this.n = MediaCodec.createByCodecName(str2);
                x.a();
                x.a("configureCodec");
                a(this.o, this.n, this.k, mediaCryptoA);
                x.a();
                x.a("startCodec");
                this.n.start();
                x.a();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                a(str2, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
                D();
            } catch (Exception e2) {
                a(new a(this.k, e2, zA, str2));
            }
            this.A = a_() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
            G();
            H();
            this.N = true;
            this.f6375a.f6274a++;
        }
    }

    protected final MediaCodec y() {
        return this.n;
    }

    protected final com.opos.exoplayer.core.d.a z() {
        return this.o;
    }
}
