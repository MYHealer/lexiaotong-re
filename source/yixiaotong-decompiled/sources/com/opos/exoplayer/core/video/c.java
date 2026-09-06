package com.opos.exoplayer.core.video;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.x;
import com.opos.exoplayer.core.i.y;
import com.stub.StubApp;
import java.nio.ByteBuffer;
import org.videolan.libvlc.MediaDiscoverer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends com.opos.exoplayer.core.d.b {
    private static final int[] c = {1920, 1600, 1440, MediaDiscoverer.Event.Started, 960, 854, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON, 480};
    private int A;
    private int B;
    private float C;
    private int D;
    private int E;
    private int F;
    private float G;
    private boolean H;
    private int I;
    private long J;
    private int K;
    C0930c b;
    private final Context d;
    private final d e;
    private final f.a f;
    private final long g;
    private final int h;
    private final boolean i;
    private final long[] j;
    private Format[] k;
    private a l;
    private boolean m;
    private Surface n;
    private Surface o;
    private int p;
    private boolean q;
    private long r;
    private long s;
    private int t;
    private int u;
    private int v;
    private long w;
    private int x;
    private float y;
    private int z;

    protected static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6553a;
        public final int b;
        public final int c;

        public a(int i, int i2, int i3) {
            this.f6553a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    static /* synthetic */ class b {
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.video.c$c, reason: collision with other inner class name */
    private final class C0930c implements MediaCodec.OnFrameRenderedListener {
        private C0930c(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        /* synthetic */ C0930c(c cVar, MediaCodec mediaCodec, b bVar) {
            this(mediaCodec);
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            c cVar = c.this;
            if (this != cVar.b) {
                return;
            }
            cVar.v();
        }
    }

    public c(Context context, com.opos.exoplayer.core.d.c cVar, long j, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, boolean z, Handler handler, f fVar, int i) {
        super(2, cVar, bVar, z);
        this.g = j;
        this.h = i;
        this.d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.e = new d(context);
        this.f = new f.a(handler, fVar);
        this.i = K();
        this.j = new long[10];
        this.J = -9223372036854775807L;
        this.r = -9223372036854775807L;
        this.z = -1;
        this.A = -1;
        this.C = -1.0f;
        this.y = -1.0f;
        this.p = 1;
        G();
    }

    private void D() {
        this.r = this.g > 0 ? SystemClock.elapsedRealtime() + this.g : -9223372036854775807L;
    }

    private void E() {
        MediaCodec mediaCodecY;
        this.q = false;
        if (y.f6517a < 23 || !this.H || (mediaCodecY = y()) == null) {
            return;
        }
        this.b = new C0930c(this, mediaCodecY, null);
    }

    private void F() {
        if (this.q) {
            this.f.a(this.n);
        }
    }

    private void G() {
        this.D = -1;
        this.E = -1;
        this.G = -1.0f;
        this.F = -1;
    }

    private void H() {
        int i = this.z;
        if (i == -1 && this.A == -1) {
            return;
        }
        if (this.D == i && this.E == this.A && this.F == this.B && this.G == this.C) {
            return;
        }
        this.f.a(i, this.A, this.B, this.C);
        this.D = this.z;
        this.E = this.A;
        this.F = this.B;
        this.G = this.C;
    }

    private void I() {
        int i = this.D;
        if (i == -1 && this.E == -1) {
            return;
        }
        this.f.a(i, this.E, this.F, this.G);
    }

    private void J() {
        if (this.t > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f.a(this.t, jElapsedRealtime - this.s);
            this.t = 0;
            this.s = jElapsedRealtime;
        }
    }

    private static boolean K() {
        return y.f6517a <= 22 && "foster".equals(y.b) && "NVIDIA".equals(y.c);
    }

    private static int a(String str, int i, int i2) {
        int iA;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        str.hashCode();
        int i3 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                iA = i * i2;
                i3 = 2;
                return (iA * 3) / (i3 * 2);
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                iA = i * i2;
                return (iA * 3) / (i3 * 2);
            case "video/avc":
                if ("BRAVIA 4K 2015".equals(y.d)) {
                    return -1;
                }
                iA = y.a(i, 16) * y.a(i2, 16) * 256;
                i3 = 2;
                return (iA * 3) / (i3 * 2);
            default:
                return -1;
        }
    }

    private static Point a(com.opos.exoplayer.core.d.a aVar, Format format) {
        boolean z = format.k > format.j;
        int i = z ? format.k : format.j;
        int i2 = z ? format.j : format.k;
        float f = i2 / i;
        for (int i3 : c) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                break;
            }
            if (y.f6517a >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point pointA = aVar.a(i5, i3);
                if (aVar.a(pointA.x, pointA.y, format.l)) {
                    return pointA;
                }
            } else {
                int iA = y.a(i3, 16) * 16;
                int iA2 = y.a(i4, 16) * 16;
                if (iA * iA2 <= com.opos.exoplayer.core.d.d.b()) {
                    int i6 = z ? iA2 : iA;
                    if (!z) {
                        iA = iA2;
                    }
                    return new Point(i6, iA);
                }
            }
        }
        return null;
    }

    private static void a(MediaCodec mediaCodec, int i) {
        mediaCodec.setVideoScalingMode(i);
    }

    private static void a(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    private static void a(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    private void a(Surface surface) {
        if (surface == null) {
            Surface surface2 = this.o;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.opos.exoplayer.core.d.a aVarZ = z();
                if (aVarZ != null && b(aVarZ)) {
                    surface = DummySurface.a(this.d, aVarZ.d);
                    this.o = surface;
                }
            }
        }
        if (this.n == surface) {
            if (surface == null || surface == this.o) {
                return;
            }
            I();
            F();
            return;
        }
        this.n = surface;
        int iA_ = a_();
        if (iA_ == 1 || iA_ == 2) {
            MediaCodec mediaCodecY = y();
            if (y.f6517a < 23 || mediaCodecY == null || surface == null || this.m) {
                A();
                x();
            } else {
                a(mediaCodecY, surface);
            }
        }
        if (surface == null || surface == this.o) {
            G();
            E();
            return;
        }
        I();
        E();
        if (iA_ == 2) {
            D();
        }
    }

    private static boolean a(String str) {
        return (("deb".equals(y.b) || "flo".equals(y.b) || "mido".equals(y.b) || "santoni".equals(y.b)) && "OMX.qcom.video.decoder.avc".equals(str)) || (("tcl_eu".equals(y.b) || "SVP-DTV15".equals(y.b) || "BRAVIA_ATV2".equals(y.b) || y.b.startsWith("panell_") || "F3311".equals(y.b) || "M5c".equals(y.b) || "A7010a48".equals(y.b)) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str)) || (("ALE-L21".equals(y.d) || "CAM-L21".equals(y.d)) && "OMX.k3.video.decoder.avc".equals(str));
    }

    private static boolean a(boolean z, Format format, Format format2) {
        return format.f.equals(format2.f) && f(format) == f(format2) && (z || (format.j == format2.j && format.k == format2.k));
    }

    private boolean b(com.opos.exoplayer.core.d.a aVar) {
        return y.f6517a >= 23 && !this.H && !a(aVar.f6374a) && (!aVar.d || DummySurface.a(this.d));
    }

    private static int d(Format format) {
        if (format.g == -1) {
            return a(format.f, format.j, format.k);
        }
        int size = format.h.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += format.h.get(i).length;
        }
        return format.g + length;
    }

    private static boolean d(long j) {
        return j < -30000;
    }

    private static float e(Format format) {
        float f = format.n;
        if (f == -1.0f) {
            return 1.0f;
        }
        return f;
    }

    private static boolean e(long j) {
        return j < -500000;
    }

    private static int f(Format format) {
        int i = format.m;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void A() {
        try {
            super.A();
            this.v = 0;
            Surface surface = this.o;
            if (surface != null) {
                if (this.n == surface) {
                    this.n = null;
                }
            }
        } finally {
            this.v = 0;
            Surface surface2 = this.o;
            if (surface2 != null) {
                if (this.n == surface2) {
                    this.n = null;
                }
                this.o.release();
                this.o = null;
            }
        }
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void B() {
        super.B();
        this.v = 0;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected int a(com.opos.exoplayer.core.d.c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, Format format) {
        boolean z;
        int i;
        int i2;
        String str = format.f;
        if (!m.b(str)) {
            return 0;
        }
        DrmInitData drmInitData = format.i;
        if (drmInitData != null) {
            z = false;
            for (int i3 = 0; i3 < drmInitData.b; i3++) {
                z |= drmInitData.a(i3).c;
            }
        } else {
            z = false;
        }
        com.opos.exoplayer.core.d.a aVarA = cVar.a(str, z);
        if (aVarA == null) {
            return (!z || cVar.a(str, false) == null) ? 1 : 2;
        }
        if (!com.opos.exoplayer.core.a.a(bVar, drmInitData)) {
            return 2;
        }
        boolean zB = aVarA.b(format.c);
        if (zB && (i = format.j) > 0 && (i2 = format.k) > 0) {
            if (y.f6517a >= 21) {
                zB = aVarA.a(i, i2, format.l);
            } else {
                boolean z2 = i * i2 <= com.opos.exoplayer.core.d.d.b();
                if (!z2) {
                    com.opos.cmn.an.f.a.b("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.j + "x" + format.k + "] [" + y.e + "]");
                }
                zB = z2;
            }
        }
        return (zB ? 4 : 3) | (aVarA.b ? 16 : 8) | (aVarA.c ? 32 : 0);
    }

    protected MediaFormat a(Format format, a aVar, boolean z, int i) {
        MediaFormat mediaFormatC = c(format);
        mediaFormatC.setInteger("max-width", aVar.f6553a);
        mediaFormatC.setInteger("max-height", aVar.b);
        int i2 = aVar.c;
        if (i2 != -1) {
            mediaFormatC.setInteger("max-input-size", i2);
        }
        if (z) {
            mediaFormatC.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            a(mediaFormatC, i);
        }
        return mediaFormatC;
    }

    protected a a(com.opos.exoplayer.core.d.a aVar, Format format, Format[] formatArr) {
        int iMax = format.j;
        int iMax2 = format.k;
        int iD = d(format);
        if (formatArr.length == 1) {
            return new a(iMax, iMax2, iD);
        }
        boolean z = false;
        for (Format format2 : formatArr) {
            if (a(aVar.b, format, format2)) {
                z |= format2.j == -1 || format2.k == -1;
                iMax = Math.max(iMax, format2.j);
                iMax2 = Math.max(iMax2, format2.k);
                iD = Math.max(iD, d(format2));
            }
        }
        if (z) {
            com.opos.cmn.an.f.a.c("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointA = a(aVar, format);
            if (pointA != null) {
                iMax = Math.max(iMax, pointA.x);
                iMax2 = Math.max(iMax2, pointA.y);
                iD = Math.max(iD, a(format.f, iMax, iMax2));
                com.opos.cmn.an.f.a.c("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new a(iMax, iMax2, iD);
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.r.b
    public void a(int i, Object obj) {
        if (i == 1) {
            a((Surface) obj);
            return;
        }
        if (i != 4) {
            super.a(i, obj);
            return;
        }
        this.p = ((Integer) obj).intValue();
        MediaCodec mediaCodecY = y();
        if (mediaCodecY != null) {
            a(mediaCodecY, this.p);
        }
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void a(long j, boolean z) {
        super.a(j, z);
        E();
        this.u = 0;
        int i = this.K;
        if (i != 0) {
            this.J = this.j[i - 1];
            this.K = 0;
        }
        if (z) {
            D();
        } else {
            this.r = -9223372036854775807L;
        }
    }

    protected void a(MediaCodec mediaCodec, int i, long j) {
        x.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        x.a();
        ((com.opos.exoplayer.core.d.b) this).f6375a.f++;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        this.z = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        this.A = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        this.C = this.y;
        if (y.f6517a >= 21) {
            int i = this.x;
            if (i == 90 || i == 270) {
                int i2 = this.z;
                this.z = this.A;
                this.A = i2;
                this.C = 1.0f / this.C;
            }
        } else {
            this.B = this.x;
        }
        a(mediaCodec, this.p);
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(com.opos.exoplayer.core.b.e eVar) {
        this.v++;
        if (y.f6517a >= 23 || !this.H) {
            return;
        }
        v();
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(com.opos.exoplayer.core.d.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        a aVarA = a(aVar, format, this.k);
        this.l = aVarA;
        MediaFormat mediaFormatA = a(format, aVarA, this.i, this.I);
        if (this.n == null) {
            com.opos.exoplayer.core.i.a.b(b(aVar));
            if (this.o == null) {
                this.o = DummySurface.a(this.d, aVar.d);
            }
            this.n = this.o;
        }
        mediaCodec.configure(mediaFormatA, this.n, mediaCrypto, 0);
        if (y.f6517a < 23 || !this.H) {
            return;
        }
        this.b = new C0930c(this, mediaCodec, null);
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(String str, long j, long j2) {
        this.f.a(str, j, j2);
        this.m = a(str);
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void a(boolean z) {
        super.a(z);
        int i = q().b;
        this.I = i;
        this.H = i != 0;
        this.f.a(((com.opos.exoplayer.core.d.b) this).f6375a);
        this.e.a();
    }

    @Override // com.opos.exoplayer.core.a
    protected void a(Format[] formatArr, long j) {
        this.k = formatArr;
        if (this.J == -9223372036854775807L) {
            this.J = j;
        } else {
            int i = this.K;
            if (i == this.j.length) {
                com.opos.cmn.an.f.a.c("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.j[this.K - 1]);
            } else {
                this.K = i + 1;
            }
            this.j[this.K - 1] = j;
        }
        super.a(formatArr, j);
    }

    @Override // com.opos.exoplayer.core.d.b
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        while (true) {
            int i3 = this.K;
            if (i3 == 0) {
                break;
            }
            long[] jArr = this.j;
            long j4 = jArr[0];
            if (j3 < j4) {
                break;
            }
            this.J = j4;
            int i4 = i3 - 1;
            this.K = i4;
            System.arraycopy(jArr, 1, jArr, 0, i4);
        }
        long j5 = j3 - this.J;
        if (z) {
            a(mediaCodec, i, j5);
            return true;
        }
        long j6 = j3 - j;
        if (this.n == this.o) {
            if (!d(j6)) {
                return false;
            }
            a(mediaCodec, i, j5);
            return true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        boolean z2 = a_() == 2;
        if (!this.q || (z2 && d(j6, jElapsedRealtime - this.w))) {
            if (y.f6517a >= 21) {
                b(mediaCodec, i, j5, System.nanoTime());
                return true;
            }
            c(mediaCodec, i, j5);
            return true;
        }
        if (!z2) {
            return false;
        }
        long j7 = j6 - (jElapsedRealtime - j2);
        long jNanoTime = System.nanoTime();
        long jA = this.e.a(j3, (j7 * 1000) + jNanoTime);
        long j8 = (jA - jNanoTime) / 1000;
        if (c(j8, j2) && a(mediaCodec, i, j5, j)) {
            return false;
        }
        if (b(j8, j2)) {
            b(mediaCodec, i, j5);
            return true;
        }
        if (y.f6517a >= 21) {
            if (j8 >= 50000) {
                return false;
            }
            b(mediaCodec, i, j5, jA);
            return true;
        }
        if (j8 >= 30000) {
            return false;
        }
        if (j8 > 11000) {
            try {
                Thread.sleep((j8 - ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) / 1000);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        c(mediaCodec, i, j5);
        return true;
    }

    protected boolean a(MediaCodec mediaCodec, int i, long j, long j2) {
        int iB = b(j2);
        if (iB == 0) {
            return false;
        }
        ((com.opos.exoplayer.core.d.b) this).f6375a.i++;
        b(this.v + iB);
        B();
        return true;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        if (a(z, format, format2)) {
            int i = format2.j;
            a aVar = this.l;
            if (i <= aVar.f6553a && format2.k <= aVar.b && d(format2) <= this.l.c) {
                return true;
            }
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected boolean a(com.opos.exoplayer.core.d.a aVar) {
        return this.n != null || b(aVar);
    }

    protected void b(int i) {
        com.opos.exoplayer.core.b.d dVar = ((com.opos.exoplayer.core.d.b) this).f6375a;
        dVar.g += i;
        this.t += i;
        int i2 = this.u + i;
        this.u = i2;
        dVar.h = Math.max(i2, dVar.h);
        if (this.t >= this.h) {
            J();
        }
    }

    protected void b(MediaCodec mediaCodec, int i, long j) {
        x.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        x.a();
        b(1);
    }

    protected void b(MediaCodec mediaCodec, int i, long j, long j2) {
        H();
        x.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        x.a();
        this.w = SystemClock.elapsedRealtime() * 1000;
        ((com.opos.exoplayer.core.d.b) this).f6375a.e++;
        this.u = 0;
        v();
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void b(Format format) {
        super.b(format);
        this.f.a(format);
        this.y = e(format);
        this.x = f(format);
    }

    protected boolean b(long j, long j2) {
        return d(j);
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void c(long j) {
        this.v--;
    }

    protected void c(MediaCodec mediaCodec, int i, long j) {
        H();
        x.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        x.a();
        this.w = SystemClock.elapsedRealtime() * 1000;
        ((com.opos.exoplayer.core.d.b) this).f6375a.e++;
        this.u = 0;
        v();
    }

    protected boolean c(long j, long j2) {
        return e(j);
    }

    protected boolean d(long j, long j2) {
        return d(j) && j2 > 100000;
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void n() {
        super.n();
        this.t = 0;
        this.s = SystemClock.elapsedRealtime();
        this.w = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void o() {
        this.r = -9223372036854775807L;
        J();
        super.o();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void p() {
        this.z = -1;
        this.A = -1;
        this.C = -1.0f;
        this.y = -1.0f;
        this.J = -9223372036854775807L;
        this.K = 0;
        G();
        E();
        this.e.b();
        this.b = null;
        this.H = false;
        try {
            super.p();
        } finally {
            ((com.opos.exoplayer.core.d.b) this).f6375a.a();
            this.f.b(((com.opos.exoplayer.core.d.b) this).f6375a);
        }
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.t
    public boolean t() {
        Surface surface;
        if (super.t() && (this.q || (((surface = this.o) != null && this.n == surface) || y() == null || this.H))) {
            this.r = -9223372036854775807L;
            return true;
        }
        if (this.r == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.r) {
            return true;
        }
        this.r = -9223372036854775807L;
        return false;
    }

    void v() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.f.a(this.n);
    }
}
