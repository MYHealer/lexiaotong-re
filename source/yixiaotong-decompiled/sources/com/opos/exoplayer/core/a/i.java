package com.opos.exoplayer.core.a;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.y;
import com.opos.exoplayer.core.p;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i extends com.opos.exoplayer.core.d.b implements com.opos.exoplayer.core.i.l {
    private final e.a b;
    private final f c;
    private boolean d;
    private boolean e;
    private MediaFormat f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long k;
    private boolean l;
    private boolean m;

    static /* synthetic */ class a {
    }

    private final class b implements f.c {
        private b() {
        }

        /* synthetic */ b(i iVar, a aVar) {
            this();
        }

        @Override // com.opos.exoplayer.core.a.f.c
        public void a() {
            i.this.v();
            i.this.m = true;
        }

        @Override // com.opos.exoplayer.core.a.f.c
        public void a(int i) {
            i.this.b.a(i);
            i.this.b(i);
        }

        @Override // com.opos.exoplayer.core.a.f.c
        public void a(int i, long j, long j2) {
            i.this.b.a(i, j, j2);
            i.this.a(i, j, j2);
        }
    }

    public i(com.opos.exoplayer.core.d.c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, boolean z, Handler handler, e eVar, c cVar2, d... dVarArr) {
        this(cVar, bVar, z, handler, eVar, new g(cVar2, dVarArr));
    }

    public i(com.opos.exoplayer.core.d.c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, boolean z, Handler handler, e eVar, f fVar) {
        super(1, cVar, bVar, z);
        this.b = new e.a(handler, eVar);
        this.c = fVar;
        fVar.a(new b(this, null));
    }

    private void D() {
        long jA = this.c.a(u());
        if (jA != Long.MIN_VALUE) {
            if (!this.m) {
                jA = Math.max(this.k, jA);
            }
            this.k = jA;
            this.m = false;
        }
    }

    private static boolean b(String str) {
        return y.f6517a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(y.c) && (y.b.startsWith("zeroflte") || y.b.startsWith("herolte") || y.b.startsWith("heroqlte"));
    }

    @Override // com.opos.exoplayer.core.d.b
    protected int a(com.opos.exoplayer.core.d.c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, Format format) {
        boolean z;
        int i;
        int i2;
        String str = format.f;
        if (!com.opos.exoplayer.core.i.m.a(str)) {
            return 0;
        }
        int i3 = y.f6517a >= 21 ? 32 : 0;
        boolean zA = com.opos.exoplayer.core.a.a(bVar, format.i);
        if (zA && a(str) && cVar.a() != null) {
            return i3 | 12;
        }
        if ((MimeTypes.AUDIO_RAW.equals(str) && !this.c.a(format.t)) || !this.c.a(2)) {
            return 1;
        }
        DrmInitData drmInitData = format.i;
        if (drmInitData != null) {
            z = false;
            for (int i4 = 0; i4 < drmInitData.b; i4++) {
                z |= drmInitData.a(i4).c;
            }
        } else {
            z = false;
        }
        com.opos.exoplayer.core.d.a aVarA = cVar.a(str, z);
        if (aVarA == null) {
            return (!z || cVar.a(str, false) == null) ? 1 : 2;
        }
        if (zA) {
            return ((y.f6517a < 21 || (((i = format.s) == -1 || aVarA.a(i)) && ((i2 = format.r) == -1 || aVarA.b(i2)))) ? 4 : 3) | i3 | 8;
        }
        return 2;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected com.opos.exoplayer.core.d.a a(com.opos.exoplayer.core.d.c cVar, Format format, boolean z) {
        com.opos.exoplayer.core.d.a aVarA;
        if (!a(format.f) || (aVarA = cVar.a()) == null) {
            this.d = false;
            return super.a(cVar, format, z);
        }
        this.d = true;
        return aVarA;
    }

    @Override // com.opos.exoplayer.core.i.l
    public p a(p pVar) {
        return this.c.a(pVar);
    }

    protected void a(int i, long j, long j2) {
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.r.b
    public void a(int i, Object obj) {
        if (i == 2) {
            this.c.a(((Float) obj).floatValue());
        } else if (i != 3) {
            super.a(i, obj);
        } else {
            this.c.a((com.opos.exoplayer.core.a.b) obj);
        }
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.t
    public void a(long j, long j2) throws com.opos.exoplayer.core.h {
        try {
            super.a(j, j2);
        } catch (Exception e) {
            throw com.opos.exoplayer.core.h.b(e, 0);
        }
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void a(long j, boolean z) {
        super.a(j, z);
        this.c.i();
        this.k = j;
        this.l = true;
        this.m = true;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws com.opos.exoplayer.core.h {
        int iF;
        int[] iArr;
        int i;
        MediaFormat mediaFormat2 = this.f;
        if (mediaFormat2 != null) {
            iF = com.opos.exoplayer.core.i.m.f(mediaFormat2.getString("mime"));
            mediaFormat = this.f;
        } else {
            iF = this.g;
        }
        int i2 = iF;
        int integer = mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT);
        int integer2 = mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
        if (this.e && integer == 6 && (i = this.h) < 6) {
            iArr = new int[i];
            for (int i3 = 0; i3 < this.h; i3++) {
                iArr[i3] = i3;
            }
        } else {
            iArr = null;
        }
        try {
            this.c.a(i2, integer, integer2, 0, iArr, this.i, this.j);
        } catch (f.a e) {
            String strA = y.a(e);
            com.opos.exoplayer.core.h hVarA = com.opos.exoplayer.core.h.a(e, r());
            hVarA.a(strA);
            throw hVarA;
        }
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(com.opos.exoplayer.core.b.e eVar) {
        if (!this.l || eVar.d_()) {
            return;
        }
        if (Math.abs(eVar.c - this.k) > 500000) {
            this.k = eVar.c;
        }
        this.l = false;
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(com.opos.exoplayer.core.d.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.e = b(aVar.f6374a);
        MediaFormat mediaFormatC = c(format);
        if (!this.d) {
            mediaCodec.configure(mediaFormatC, (Surface) null, mediaCrypto, 0);
            this.f = null;
        } else {
            this.f = mediaFormatC;
            mediaFormatC.setString("mime", MimeTypes.AUDIO_RAW);
            mediaCodec.configure(this.f, (Surface) null, mediaCrypto, 0);
            this.f.setString("mime", format.f);
        }
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void a(String str, long j, long j2) {
        this.b.a(str, j, j2);
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void a(boolean z) {
        super.a(z);
        this.b.a(((com.opos.exoplayer.core.d.b) this).f6375a);
        int i = q().b;
        if (i != 0) {
            this.c.b(i);
        } else {
            this.c.g();
        }
    }

    @Override // com.opos.exoplayer.core.d.b
    protected boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws com.opos.exoplayer.core.h {
        if (this.d && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            ((com.opos.exoplayer.core.d.b) this).f6375a.f++;
            this.c.b();
            return true;
        }
        try {
            if (!this.c.a(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            ((com.opos.exoplayer.core.d.b) this).f6375a.e++;
            return true;
        } catch (f.b | f.d e) {
            String strA = y.a(e);
            com.opos.exoplayer.core.h hVarA = com.opos.exoplayer.core.h.a(e, r());
            hVarA.a(strA);
            throw hVarA;
        }
    }

    protected boolean a(String str) {
        int iF = com.opos.exoplayer.core.i.m.f(str);
        return iF != 0 && this.c.a(iF);
    }

    protected void b(int i) {
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void b(Format format) {
        super.b(format);
        this.b.a(format);
        this.g = MimeTypes.AUDIO_RAW.equals(format.f) ? format.t : 2;
        this.h = format.r;
        int i = format.u;
        if (i == -1) {
            i = 0;
        }
        this.i = i;
        int i2 = format.v;
        this.j = i2 != -1 ? i2 : 0;
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.t
    public com.opos.exoplayer.core.i.l c() {
        return this;
    }

    @Override // com.opos.exoplayer.core.i.l
    public long d() {
        if (a_() == 2) {
            D();
        }
        return this.k;
    }

    @Override // com.opos.exoplayer.core.i.l
    public p e() {
        return this.c.f();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void n() {
        super.n();
        this.c.a();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void o() {
        this.c.h();
        D();
        super.o();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    protected void p() {
        try {
            this.c.j();
            try {
                super.p();
            } finally {
                ((com.opos.exoplayer.core.d.b) this).f6375a.a();
                this.b.b(((com.opos.exoplayer.core.d.b) this).f6375a);
            }
        } catch (Throwable th) {
            try {
                super.p();
                throw th;
            } finally {
                ((com.opos.exoplayer.core.d.b) this).f6375a.a();
                this.b.b(((com.opos.exoplayer.core.d.b) this).f6375a);
            }
        }
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.t
    public boolean t() {
        return this.c.e() || super.t();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.t
    public boolean u() {
        return super.u() && this.c.d();
    }

    protected void v() {
    }

    @Override // com.opos.exoplayer.core.d.b
    protected void w() throws com.opos.exoplayer.core.h {
        try {
            this.c.c();
        } catch (f.d e) {
            String strA = y.a(e);
            com.opos.exoplayer.core.h hVarA = com.opos.exoplayer.core.h.a(e, r());
            hVarA.a(strA);
            throw hVarA;
        }
    }
}
