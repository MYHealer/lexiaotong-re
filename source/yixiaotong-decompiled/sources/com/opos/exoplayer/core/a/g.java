package com.opos.exoplayer.core.a;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.p;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class g implements com.opos.exoplayer.core.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6249a;
    public static boolean b;
    private long A;
    private p B;
    private p C;
    private long D;
    private long E;
    private ByteBuffer F;
    private int G;
    private int H;
    private int I;
    private long J;
    private long K;
    private boolean L;
    private long M;
    private Method N;
    private int O;
    private long P;
    private long Q;
    private int R;
    private long S;
    private long T;
    private int U;
    private int V;
    private long W;
    private long X;
    private long Y;
    private float Z;
    private com.opos.exoplayer.core.a.d[] aa;
    private ByteBuffer[] ab;
    private ByteBuffer ac;
    private ByteBuffer ad;
    private byte[] ae;
    private int af;
    private int ag;
    private boolean ah;
    private boolean ai;
    private int aj;
    private boolean ak;
    private boolean al;
    private long am;
    private final com.opos.exoplayer.core.a.c c;
    private final boolean d;
    private final k e;
    private final o f;
    private final j g;
    private final com.opos.exoplayer.core.a.d[] h;
    private final com.opos.exoplayer.core.a.d[] i;
    private final ConditionVariable j;
    private final long[] k;
    private final d l;
    private final ArrayDeque<f> m;
    private com.opos.exoplayer.core.a.f.c n;
    private AudioTrack o;
    private AudioTrack p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private com.opos.exoplayer.core.a.b w;
    private boolean x;
    private boolean y;
    private int z;

    public static final class a extends com.opos.exoplayer.core.i.d {
        public a(String str) {
            super(str);
        }

        @Override // com.opos.exoplayer.core.i.d
        public String a() {
            return "InvalidAudioTrackTimestampException";
        }
    }

    class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioTrack f6250a;

        b(AudioTrack audioTrack) {
            this.f6250a = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f6250a.flush();
                this.f6250a.release();
            } finally {
                g.this.j.open();
            }
        }
    }

    class c extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioTrack f6251a;

        c(g gVar, AudioTrack audioTrack) {
            this.f6251a = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f6251a.release();
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected AudioTrack f6252a;
        private boolean b;
        private int c;
        private long d;
        private long e;
        private long f;
        private long g;
        private long h;
        private long i;
        private long j;

        private d() {
        }

        /* synthetic */ d(b bVar) {
            this();
        }

        public void a() {
            if (this.g != -9223372036854775807L) {
                return;
            }
            this.f6252a.pause();
        }

        public void a(long j) {
            this.i = b();
            this.g = SystemClock.elapsedRealtime() * 1000;
            this.j = j;
            this.f6252a.stop();
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.f6252a = audioTrack;
            this.b = z;
            this.g = -9223372036854775807L;
            this.h = -9223372036854775807L;
            this.d = 0L;
            this.e = 0L;
            this.f = 0L;
            if (audioTrack != null) {
                this.c = audioTrack.getSampleRate();
            }
        }

        public long b() {
            if (this.g != -9223372036854775807L) {
                return Math.min(this.j, this.i + ((((SystemClock.elapsedRealtime() * 1000) - this.g) * ((long) this.c)) / 1000000));
            }
            int playState = this.f6252a.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = ((long) this.f6252a.getPlaybackHeadPosition()) & 4294967295L;
            if (this.b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f = this.d;
                }
                playbackHeadPosition += this.f;
            }
            if (y.f6517a <= 28) {
                if (playbackHeadPosition == 0 && this.d > 0 && playState == 3) {
                    if (this.h == -9223372036854775807L) {
                        this.h = SystemClock.elapsedRealtime();
                    }
                    return this.d;
                }
                this.h = -9223372036854775807L;
            }
            if (this.d > playbackHeadPosition) {
                this.e++;
            }
            this.d = playbackHeadPosition;
            return playbackHeadPosition + (this.e << 32);
        }

        public boolean b(long j) {
            return this.h != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.h >= 200;
        }

        public long c() {
            return (b() * 1000000) / ((long) this.c);
        }

        public boolean d() {
            return false;
        }

        public long e() {
            throw new UnsupportedOperationException();
        }

        public long f() {
            throw new UnsupportedOperationException();
        }
    }

    private static class e extends d {
        private final AudioTimestamp b;
        private long c;
        private long d;
        private long e;

        public e() {
            super(null);
            this.b = new AudioTimestamp();
        }

        @Override // com.opos.exoplayer.core.a.g.d
        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.c = 0L;
            this.d = 0L;
            this.e = 0L;
        }

        @Override // com.opos.exoplayer.core.a.g.d
        public boolean d() {
            boolean timestamp = this.f6252a.getTimestamp(this.b);
            if (timestamp) {
                long j = this.b.framePosition;
                if (this.d > j) {
                    this.c++;
                }
                this.d = j;
                this.e = j + (this.c << 32);
            }
            return timestamp;
        }

        @Override // com.opos.exoplayer.core.a.g.d
        public long e() {
            return this.b.nanoTime;
        }

        @Override // com.opos.exoplayer.core.a.g.d
        public long f() {
            return this.e;
        }
    }

    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p f6253a;
        private final long b;
        private final long c;

        private f(p pVar, long j, long j2) {
            this.f6253a = pVar;
            this.b = j;
            this.c = j2;
        }

        /* synthetic */ f(p pVar, long j, long j2, b bVar) {
            this(pVar, j, j2);
        }
    }

    public g(com.opos.exoplayer.core.a.c cVar, com.opos.exoplayer.core.a.d[] dVarArr) {
        this(cVar, dVarArr, false);
    }

    public g(com.opos.exoplayer.core.a.c cVar, com.opos.exoplayer.core.a.d[] dVarArr, boolean z) {
        this.c = cVar;
        this.d = z;
        this.j = new ConditionVariable(true);
        b bVar = null;
        if (y.f6517a >= 18) {
            try {
                this.N = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.l = y.f6517a >= 19 ? new e() : new d(bVar);
        k kVar = new k();
        this.e = kVar;
        o oVar = new o();
        this.f = oVar;
        j jVar = new j();
        this.g = jVar;
        com.opos.exoplayer.core.a.d[] dVarArr2 = new com.opos.exoplayer.core.a.d[dVarArr.length + 4];
        this.h = dVarArr2;
        dVarArr2[0] = new m();
        dVarArr2[1] = kVar;
        dVarArr2[2] = oVar;
        System.arraycopy(dVarArr, 0, dVarArr2, 3, dVarArr.length);
        dVarArr2[dVarArr.length + 3] = jVar;
        this.i = new com.opos.exoplayer.core.a.d[]{new l()};
        this.k = new long[10];
        this.Z = 1.0f;
        this.V = 0;
        this.w = com.opos.exoplayer.core.a.b.f6236a;
        this.aj = 0;
        this.C = p.f6545a;
        this.ag = -1;
        this.aa = new com.opos.exoplayer.core.a.d[0];
        this.ab = new ByteBuffer[0];
        this.m = new ArrayDeque<>();
    }

    private static int a(int i, ByteBuffer byteBuffer) {
        if (i == 7 || i == 8) {
            return h.a(byteBuffer);
        }
        if (i == 5) {
            return com.opos.exoplayer.core.a.a.a();
        }
        if (i == 6) {
            return com.opos.exoplayer.core.a.a.a(byteBuffer);
        }
        if (i == 14) {
            return com.opos.exoplayer.core.a.a.b(byteBuffer) * 8;
        }
        throw new IllegalStateException("Unexpected audio encoding: " + i);
    }

    private static int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        if (this.F == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.F = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.F.putInt(1431633921);
        }
        if (this.G == 0) {
            this.F.putInt(4, i);
            this.F.putLong(8, j * 1000);
            this.F.position(0);
            this.G = i;
        }
        int iRemaining = this.F.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.F, iRemaining, 1);
            if (iWrite < 0) {
                this.G = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iA = a(audioTrack, byteBuffer, i);
        if (iA < 0) {
            this.G = 0;
            return iA;
        }
        this.G -= iA;
        return iA;
    }

    private void a(long j) throws com.opos.exoplayer.core.a.f.d {
        ByteBuffer byteBuffer;
        int length = this.aa.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.ab[i - 1];
            } else {
                byteBuffer = this.ac;
                if (byteBuffer == null) {
                    byteBuffer = com.opos.exoplayer.core.a.d.f6239a;
                }
            }
            if (i == length) {
                b(byteBuffer, j);
            } else {
                com.opos.exoplayer.core.a.d dVar = this.aa[i];
                dVar.a(byteBuffer);
                ByteBuffer byteBufferF = dVar.f();
                this.ab[i] = byteBufferF;
                if (byteBufferF.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    private static void a(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private long b(long j) {
        long j2;
        long jA;
        while (!this.m.isEmpty() && j >= this.m.getFirst().c) {
            f fVarRemove = this.m.remove();
            this.C = fVarRemove.f6253a;
            this.E = fVarRemove.c;
            this.D = fVarRemove.b - this.W;
        }
        if (this.C.b == 1.0f) {
            return (j + this.D) - this.E;
        }
        if (this.m.isEmpty()) {
            j2 = this.D;
            jA = this.g.a(j - this.E);
        } else {
            j2 = this.D;
            jA = y.a(j - this.E, this.C.b);
        }
        return j2 + jA;
    }

    private static void b(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private void b(ByteBuffer byteBuffer, long j) throws com.opos.exoplayer.core.a.f.d {
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.ad;
            int iA = 0;
            if (byteBuffer2 != null) {
                com.opos.exoplayer.core.i.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.ad = byteBuffer;
                if (y.f6517a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.ae;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.ae = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.ae, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.af = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            if (y.f6517a < 21) {
                int iB = this.z - ((int) (this.S - (this.l.b() * ((long) this.R))));
                if (iB > 0) {
                    iA = this.p.write(this.ae, this.af, Math.min(iRemaining2, iB));
                    if (iA > 0) {
                        this.af += iA;
                        byteBuffer.position(byteBuffer.position() + iA);
                    }
                }
            } else if (this.ak) {
                com.opos.exoplayer.core.i.a.b(j != -9223372036854775807L);
                iA = a(this.p, byteBuffer, iRemaining2, j);
            } else {
                iA = a(this.p, byteBuffer, iRemaining2);
            }
            this.am = SystemClock.elapsedRealtime();
            if (iA < 0) {
                throw new com.opos.exoplayer.core.a.f.d(iA);
            }
            boolean z = this.q;
            if (z) {
                this.S += (long) iA;
            }
            if (iA == iRemaining2) {
                if (!z) {
                    this.T += (long) this.U;
                }
                this.ad = null;
            }
        }
    }

    private long c(long j) {
        return (j * 1000000) / ((long) this.s);
    }

    private AudioTrack c(int i) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i);
    }

    private long d(long j) {
        return (j * 1000000) / ((long) this.t);
    }

    private static boolean d(int i) {
        return i == 3 || i == 2 || i == Integer.MIN_VALUE || i == 1073741824 || i == 4;
    }

    private long e(long j) {
        return (j * ((long) this.t)) / 1000000;
    }

    private void k() {
        ArrayList arrayList = new ArrayList();
        for (com.opos.exoplayer.core.a.d dVar : z()) {
            if (dVar.a()) {
                arrayList.add(dVar);
            } else {
                dVar.h();
            }
        }
        int size = arrayList.size();
        this.aa = (com.opos.exoplayer.core.a.d[]) arrayList.toArray(new com.opos.exoplayer.core.a.d[size]);
        this.ab = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            com.opos.exoplayer.core.a.d dVar2 = this.aa[i];
            dVar2.h();
            this.ab[i] = dVar2.f();
        }
    }

    private void l() {
        this.j.block();
        this.p = x();
        a(this.C);
        k();
        int audioSessionId = this.p.getAudioSessionId();
        if (f6249a && y.f6517a < 21) {
            AudioTrack audioTrack = this.o;
            if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                o();
            }
            if (this.o == null) {
                this.o = c(audioSessionId);
            }
        }
        if (this.aj != audioSessionId) {
            this.aj = audioSessionId;
            com.opos.exoplayer.core.a.f.c cVar = this.n;
            if (cVar != null) {
                cVar.a(audioSessionId);
            }
        }
        this.l.a(this.p, v());
        n();
        this.al = false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021  */
    /* JADX WARN: Code duplicated, block: B:14:0x0025  */
    /* JADX WARN: Code duplicated, block: B:17:0x0031 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x0032  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0032 -> B:8:0x0010). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private boolean m() {
        /*
            r9 = this;
            int r0 = r9.ag
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L14
            boolean r0 = r9.x
            if (r0 == 0) goto Ld
            r0 = r2
            goto L10
        Ld:
            com.opos.exoplayer.core.a.d[] r0 = r9.aa
            int r0 = r0.length
        L10:
            r9.ag = r0
            r0 = r1
            goto L15
        L14:
            r0 = r2
        L15:
            int r4 = r9.ag
            com.opos.exoplayer.core.a.d[] r5 = r9.aa
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L36
            r4 = r5[r4]
            if (r0 == 0) goto L28
            r4.e()
        L28:
            r9.a(r7)
            boolean r0 = r4.g()
            if (r0 != 0) goto L32
            return r2
        L32:
            int r0 = r9.ag
            int r0 = r0 + r1
            goto L10
        L36:
            java.nio.ByteBuffer r0 = r9.ad
            if (r0 == 0) goto L42
            r9.b(r0, r7)
            java.nio.ByteBuffer r0 = r9.ad
            if (r0 == 0) goto L42
            return r2
        L42:
            r9.ag = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.a.g.m():boolean");
    }

    private void n() {
        if (r()) {
            if (y.f6517a >= 21) {
                a(this.p, this.Z);
            } else {
                b(this.p, this.Z);
            }
        }
    }

    private void o() {
        AudioTrack audioTrack = this.o;
        if (audioTrack == null) {
            return;
        }
        this.o = null;
        new c(this, audioTrack).start();
    }

    private boolean p() {
        return r() && this.V != 0;
    }

    private void q() {
        String str;
        long jC = this.l.c();
        if (jC == 0) {
            return;
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (jNanoTime - this.K >= 30000) {
            long[] jArr = this.k;
            int i = this.H;
            jArr[i] = jC - jNanoTime;
            this.H = (i + 1) % 10;
            int i2 = this.I;
            if (i2 < 10) {
                this.I = i2 + 1;
            }
            this.K = jNanoTime;
            this.J = 0L;
            int i3 = 0;
            while (true) {
                int i4 = this.I;
                if (i3 >= i4) {
                    break;
                }
                this.J += this.k[i3] / ((long) i4);
                i3++;
            }
        }
        if (!v() && jNanoTime - this.M >= 500000) {
            boolean zD = this.l.d();
            this.L = zD;
            if (zD) {
                long jE = this.l.e() / 1000;
                long jF = this.l.f();
                if (jE >= this.X) {
                    if (Math.abs(jE - jNanoTime) > 5000000) {
                        str = "Spurious audio timestamp (system clock mismatch): " + jF + ", " + jE + ", " + jNanoTime + ", " + jC + ", " + s() + ", " + t();
                        if (b) {
                            throw new a(str);
                        }
                    } else if (Math.abs(d(jF) - jC) > 5000000) {
                        str = "Spurious audio timestamp (frame position mismatch): " + jF + ", " + jE + ", " + jNanoTime + ", " + jC + ", " + s() + ", " + t();
                        if (b) {
                            throw new a(str);
                        }
                    }
                    com.opos.cmn.an.f.a.c("AudioTrack", str);
                    this.L = false;
                } else {
                    this.L = false;
                }
            }
            Method method = this.N;
            if (method != null && this.q) {
                try {
                    long jIntValue = (((long) ((Integer) method.invoke(this.p, null)).intValue()) * 1000) - this.A;
                    this.Y = jIntValue;
                    long jMax = Math.max(jIntValue, 0L);
                    this.Y = jMax;
                    if (jMax > 5000000) {
                        com.opos.cmn.an.f.a.c("AudioTrack", "Ignoring impossibly large audio latency: " + this.Y);
                        this.Y = 0L;
                    }
                } catch (Exception unused) {
                    this.N = null;
                }
            }
            this.M = jNanoTime;
        }
    }

    private boolean r() {
        return this.p != null;
    }

    private long s() {
        return this.q ? this.P / ((long) this.O) : this.Q;
    }

    private long t() {
        return this.q ? this.S / ((long) this.R) : this.T;
    }

    private void u() {
        this.J = 0L;
        this.I = 0;
        this.H = 0;
        this.K = 0L;
        this.L = false;
        this.M = 0L;
    }

    private boolean v() {
        int i;
        return y.f6517a < 23 && ((i = this.v) == 5 || i == 6);
    }

    private boolean w() {
        return v() && this.p.getPlayState() == 2 && this.p.getPlaybackHeadPosition() == 0;
    }

    private AudioTrack x() throws com.opos.exoplayer.core.a.f.b {
        AudioTrack audioTrack;
        if (y.f6517a >= 21) {
            audioTrack = y();
        } else {
            int iD = y.d(this.w.d);
            int i = this.aj;
            int i2 = this.t;
            int i3 = this.u;
            int i4 = this.v;
            int i5 = this.z;
            audioTrack = i == 0 ? new AudioTrack(iD, i2, i3, i4, i5, 1) : new AudioTrack(iD, i2, i3, i4, i5, 1, i);
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception unused) {
        }
        throw new com.opos.exoplayer.core.a.f.b(state, this.t, this.u, this.z);
    }

    private AudioTrack y() {
        AudioAttributes audioAttributesBuild = this.ak ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : this.w.a();
        AudioFormat audioFormatBuild = new AudioFormat.Builder().setChannelMask(this.u).setEncoding(this.v).setSampleRate(this.t).build();
        int i = this.aj;
        if (i == 0) {
            i = 0;
        }
        return new AudioTrack(audioAttributesBuild, audioFormatBuild, this.z, 1, i);
    }

    private com.opos.exoplayer.core.a.d[] z() {
        return this.r ? this.i : this.h;
    }

    @Override // com.opos.exoplayer.core.a.f
    public long a(boolean z) {
        long jC;
        if (!p()) {
            return Long.MIN_VALUE;
        }
        if (this.p.getPlayState() == 3) {
            q();
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (this.L) {
            jC = d(this.l.f() + e(jNanoTime - (this.l.e() / 1000)));
        } else {
            jC = this.I == 0 ? this.l.c() : jNanoTime + this.J;
            if (!z) {
                jC -= this.Y;
            }
        }
        return this.W + b(Math.min(jC, d(t())));
    }

    @Override // com.opos.exoplayer.core.a.f
    public p a(p pVar) {
        if (r() && !this.y) {
            p pVar2 = p.f6545a;
            this.C = pVar2;
            return pVar2;
        }
        p pVar3 = new p(this.g.a(pVar.b), this.g.b(pVar.c));
        p pVar4 = this.B;
        if (pVar4 == null) {
            pVar4 = !this.m.isEmpty() ? this.m.getLast().f6253a : this.C;
        }
        if (!pVar3.equals(pVar4)) {
            if (r()) {
                this.B = pVar3;
            } else {
                this.C = pVar3;
            }
        }
        return this.C;
    }

    @Override // com.opos.exoplayer.core.a.f
    public void a() {
        this.ai = true;
        if (r()) {
            this.X = System.nanoTime() / 1000;
            this.p.play();
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void a(float f2) {
        if (this.Z != f2) {
            this.Z = f2;
            n();
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0179  */
    /* JADX WARN: Code duplicated, block: B:105:0x0180  */
    /* JADX WARN: Code duplicated, block: B:106:0x018b  */
    /* JADX WARN: Code duplicated, block: B:113:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0068  */
    /* JADX WARN: Code duplicated, block: B:33:0x0075  */
    /* JADX WARN: Code duplicated, block: B:38:0x0091  */
    /* JADX WARN: Code duplicated, block: B:41:0x009c  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:48:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:71:0x0102  */
    /* JADX WARN: Code duplicated, block: B:84:0x0127  */
    /* JADX WARN: Code duplicated, block: B:87:0x0132  */
    /* JADX WARN: Code duplicated, block: B:89:0x0136  */
    /* JADX WARN: Code duplicated, block: B:92:0x0140  */
    /* JADX WARN: Code duplicated, block: B:94:0x0167  */
    /* JADX WARN: Instruction removed from duplicated block: B:27:0x004c, please report this as an issue */
    @Override // com.opos.exoplayer.core.a.f
    public void a(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) throws com.opos.exoplayer.core.a.f.a {
        int iC;
        boolean z;
        boolean z2;
        int iD;
        boolean zA;
        int iB;
        int i7;
        int i8;
        int i9;
        long jD;
        int i10;
        int iA = i4;
        this.s = i3;
        this.q = d(i);
        this.r = this.d && a(1073741824) && y.c(i);
        if (this.q) {
            this.O = y.b(i, i2);
        }
        int i11 = 4;
        if (this.q) {
            iC = i;
            z = iC != 4;
            if (z || this.r) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.y = z2;
            if (z) {
                this.f.a(i5, i6);
                this.e.a(iArr);
                iD = i3;
                zA = false;
                iB = i2;
                for (com.opos.exoplayer.core.a.d dVar : z()) {
                    try {
                        zA |= dVar.a(iD, iB, iC);
                        if (dVar.a()) {
                            iB = dVar.b();
                            iD = dVar.d();
                            iC = dVar.c();
                        }
                    } catch (com.opos.exoplayer.core.a.d.a e2) {
                        throw new com.opos.exoplayer.core.a.f.a(e2);
                    }
                }
            } else {
                iD = i3;
                zA = false;
                iB = i2;
            }
            i7 = MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF;
            switch (iB) {
                case 1:
                    break;
                case 2:
                    i11 = 12;
                    break;
                case 3:
                    i11 = 28;
                    break;
                case 4:
                    i11 = 204;
                    break;
                case 5:
                    i11 = 220;
                    break;
                case 6:
                    i11 = 252;
                    break;
                case 7:
                    i11 = 1276;
                    break;
                case 8:
                    i11 = com.opos.exoplayer.core.b.f6270a;
                    break;
                default:
                    throw new com.opos.exoplayer.core.a.f.a("Unsupported channel count: " + iB);
            }
            if (y.f6517a <= 23 || !"foster".equals(y.b) || !"NVIDIA".equals(y.c)) {
                i7 = i11;
            } else if (iB != 3 && iB != 5) {
                if (iB != 7) {
                    i7 = i11;
                } else {
                    i7 = com.opos.exoplayer.core.b.f6270a;
                }
            }
            i8 = (y.f6517a <= 25 || !"fugu".equals(y.b) || this.q || iB != 1) ? i7 : 12;
            if (zA && r() && this.v == iC && this.t == iD && this.u == i8) {
                return;
            }
            i();
            this.x = z;
            this.t = iD;
            this.u = i8;
            this.v = iC;
            if (this.q) {
                this.R = y.b(iC, iB);
            }
            if (iA == 0) {
                if (this.q) {
                    int minBufferSize = AudioTrack.getMinBufferSize(iD, i8, this.v);
                    com.opos.exoplayer.core.i.a.b(minBufferSize != -2);
                    iA = y.a(minBufferSize * 4, ((int) e(250000L)) * this.R, (int) Math.max(minBufferSize, e(750000L) * ((long) this.R)));
                } else {
                    i9 = this.v;
                    if (i9 != 5 || i9 == 6) {
                        iA = CacheDataSink.DEFAULT_BUFFER_SIZE;
                    } else {
                        iA = i9 == 7 ? 49152 : 294912;
                    }
                }
            }
            this.z = iA;
            if (this.q) {
                jD = d(this.z / this.R);
            } else {
                jD = -9223372036854775807L;
            }
            this.A = jD;
        }
        iC = i;
        if (z) {
            z2 = false;
        } else {
            z2 = false;
        }
        this.y = z2;
        if (z) {
            this.f.a(i5, i6);
            this.e.a(iArr);
            iD = i3;
            zA = false;
            iB = i2;
            while (i10 < r9) {
                zA |= dVar.a(iD, iB, iC);
                if (dVar.a()) {
                    iB = dVar.b();
                    iD = dVar.d();
                    iC = dVar.c();
                }
            }
        } else {
            iD = i3;
            zA = false;
            iB = i2;
        }
        i7 = MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF;
        switch (iB) {
            case 1:
                break;
            case 2:
                i11 = 12;
                break;
            case 3:
                i11 = 28;
                break;
            case 4:
                i11 = 204;
                break;
            case 5:
                i11 = 220;
                break;
            case 6:
                i11 = 252;
                break;
            case 7:
                i11 = 1276;
                break;
            case 8:
                i11 = com.opos.exoplayer.core.b.f6270a;
                break;
            default:
                throw new com.opos.exoplayer.core.a.f.a("Unsupported channel count: " + iB);
        }
        if (y.f6517a <= 23) {
            i7 = i11;
        } else {
            i7 = i11;
        }
        if (y.f6517a <= 25) {
        }
        if (zA) {
        }
        i();
        this.x = z;
        this.t = iD;
        this.u = i8;
        this.v = iC;
        if (this.q) {
            this.R = y.b(iC, iB);
        }
        if (iA == 0) {
            if (this.q) {
                int minBufferSize2 = AudioTrack.getMinBufferSize(iD, i8, this.v);
                com.opos.exoplayer.core.i.a.b(minBufferSize2 != -2);
                iA = y.a(minBufferSize2 * 4, ((int) e(250000L)) * this.R, (int) Math.max(minBufferSize2, e(750000L) * ((long) this.R)));
            } else {
                i9 = this.v;
                if (i9 != 5) {
                    iA = CacheDataSink.DEFAULT_BUFFER_SIZE;
                } else {
                    iA = CacheDataSink.DEFAULT_BUFFER_SIZE;
                }
            }
        }
        this.z = iA;
        if (this.q) {
            jD = d(this.z / this.R);
        } else {
            jD = -9223372036854775807L;
        }
        this.A = jD;
    }

    @Override // com.opos.exoplayer.core.a.f
    public void a(com.opos.exoplayer.core.a.b bVar) {
        if (this.w.equals(bVar)) {
            return;
        }
        this.w = bVar;
        if (this.ak) {
            return;
        }
        i();
        this.aj = 0;
    }

    @Override // com.opos.exoplayer.core.a.f
    public void a(com.opos.exoplayer.core.a.f.c cVar) {
        this.n = cVar;
    }

    @Override // com.opos.exoplayer.core.a.f
    public boolean a(int i) {
        if (d(i)) {
            return i != 4 || y.f6517a >= 21;
        }
        com.opos.exoplayer.core.a.c cVar = this.c;
        return cVar != null && cVar.a(i);
    }

    @Override // com.opos.exoplayer.core.a.f
    public boolean a(ByteBuffer byteBuffer, long j) throws com.opos.exoplayer.core.a.f.d {
        String str;
        int i;
        ByteBuffer byteBuffer2 = this.ac;
        com.opos.exoplayer.core.i.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!r()) {
            l();
            if (this.ai) {
                a();
            }
        }
        if (v()) {
            if (this.p.getPlayState() == 2) {
                this.al = false;
                return false;
            }
            if (this.p.getPlayState() == 1 && this.l.b() != 0) {
                return false;
            }
        }
        boolean z = this.al;
        boolean zE = e();
        this.al = zE;
        if (z && !zE && this.p.getPlayState() != 1 && this.n != null) {
            this.n.a(this.z, com.opos.exoplayer.core.b.a(this.A), SystemClock.elapsedRealtime() - this.am);
        }
        if (this.ac != null) {
            str = "AudioTrack";
        } else {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.q && this.U == 0) {
                int iA = a(this.v, byteBuffer);
                this.U = iA;
                if (iA == 0) {
                    return true;
                }
            }
            if (this.B != null) {
                if (!m()) {
                    return false;
                }
                this.m.add(new f(this.B, Math.max(0L, j), d(t()), null));
                this.B = null;
                k();
            }
            if (this.V == 0) {
                this.W = Math.max(0L, j);
                this.V = 1;
                str = "AudioTrack";
            } else {
                long jC = this.W + c(s());
                if (this.V != 1 || Math.abs(jC - j) <= 200000) {
                    str = r10;
                    i = 2;
                } else {
                    str = r10;
                    com.opos.cmn.an.f.a.d(str, "Discontinuity detected [expected " + jC + ", got " + j + "]");
                    i = 2;
                    this.V = 2;
                }
                if (this.V == i) {
                    this.W += j - jC;
                    this.V = 1;
                    com.opos.exoplayer.core.a.f.c cVar = this.n;
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            }
            if (this.q) {
                this.P += (long) byteBuffer.remaining();
            } else {
                this.Q += (long) this.U;
            }
            this.ac = byteBuffer;
        }
        if (this.x) {
            a(j);
        } else {
            b(this.ac, j);
        }
        if (!this.ac.hasRemaining()) {
            this.ac = null;
            return true;
        }
        if (!this.l.b(t())) {
            return false;
        }
        com.opos.cmn.an.f.a.c(str, "Resetting stalled audio track");
        i();
        return true;
    }

    @Override // com.opos.exoplayer.core.a.f
    public void b() {
        if (this.V == 1) {
            this.V = 2;
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void b(int i) {
        com.opos.exoplayer.core.i.a.b(y.f6517a >= 21);
        if (this.ak && this.aj == i) {
            return;
        }
        this.ak = true;
        this.aj = i;
        i();
    }

    @Override // com.opos.exoplayer.core.a.f
    public void c() {
        if (!this.ah && r() && m()) {
            this.l.a(t());
            this.G = 0;
            this.ah = true;
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public boolean d() {
        return !r() || (this.ah && !e());
    }

    @Override // com.opos.exoplayer.core.a.f
    public boolean e() {
        return r() && (t() > this.l.b() || w());
    }

    @Override // com.opos.exoplayer.core.a.f
    public p f() {
        return this.C;
    }

    @Override // com.opos.exoplayer.core.a.f
    public void g() {
        if (this.ak) {
            this.ak = false;
            this.aj = 0;
            i();
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void h() {
        this.ai = false;
        if (r()) {
            u();
            this.l.a();
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void i() {
        if (r()) {
            this.P = 0L;
            this.Q = 0L;
            this.S = 0L;
            this.T = 0L;
            this.U = 0;
            p pVar = this.B;
            if (pVar != null) {
                this.C = pVar;
                this.B = null;
            } else if (!this.m.isEmpty()) {
                this.C = this.m.getLast().f6253a;
            }
            this.m.clear();
            this.D = 0L;
            this.E = 0L;
            this.ac = null;
            this.ad = null;
            int i = 0;
            while (true) {
                com.opos.exoplayer.core.a.d[] dVarArr = this.aa;
                if (i >= dVarArr.length) {
                    break;
                }
                com.opos.exoplayer.core.a.d dVar = dVarArr[i];
                dVar.h();
                this.ab[i] = dVar.f();
                i++;
            }
            this.ah = false;
            this.ag = -1;
            this.F = null;
            this.G = 0;
            this.V = 0;
            this.Y = 0L;
            u();
            if (this.p.getPlayState() == 3) {
                this.p.pause();
            }
            AudioTrack audioTrack = this.p;
            this.p = null;
            this.l.a(null, false);
            this.j.close();
            new b(audioTrack).start();
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void j() {
        i();
        o();
        for (com.opos.exoplayer.core.a.d dVar : this.h) {
            dVar.i();
        }
        for (com.opos.exoplayer.core.a.d dVar2 : this.i) {
            dVar2.i();
        }
        this.aj = 0;
        this.ai = false;
    }
}
