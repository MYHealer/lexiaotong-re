package com.opos.exoplayer.core.h;

import android.content.Context;
import android.net.Uri;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.opos.exoplayer.core.i.y;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class l implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6487a;
    private final t<? super g> b;
    private final g c;
    private g d;
    private g e;
    private g f;
    private g g;
    private g h;
    private g i;
    private g j;

    public l(Context context, t<? super g> tVar, g gVar) {
        this.f6487a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.b = tVar;
        this.c = (g) com.opos.exoplayer.core.i.a.a(gVar);
    }

    private g c() {
        if (this.d == null) {
            this.d = new p(this.b);
        }
        return this.d;
    }

    private g d() {
        if (this.e == null) {
            this.e = new c(this.f6487a, this.b);
        }
        return this.e;
    }

    private g e() {
        if (this.f == null) {
            this.f = new e(this.f6487a, this.b);
        }
        return this.f;
    }

    private g f() {
        if (this.g == null) {
            try {
                this.g = (g) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
                com.opos.cmn.an.f.a.c("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e) {
                throw new RuntimeException("Error instantiating RTMP extension", e);
            }
            if (this.g == null) {
                this.g = this.c;
            }
        }
        return this.g;
    }

    private g g() {
        if (this.h == null) {
            this.h = new f();
        }
        return this.h;
    }

    private g h() {
        if (this.i == null) {
            this.i = new s(this.f6487a, this.b);
        }
        return this.i;
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i, int i2) {
        return this.j.a(bArr, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0034  */
    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) {
        g gVarH;
        com.opos.exoplayer.core.i.a.b(this.j == null);
        String scheme = iVar.f6483a.getScheme();
        if (y.a(iVar.f6483a)) {
            if (iVar.f6483a.getPath().startsWith("/android_asset/")) {
                gVarH = d();
            } else {
                gVarH = c();
            }
        } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
            gVarH = d();
        } else if ("content".equals(scheme)) {
            gVarH = e();
        } else if (LiveConfigKey.RTMP.equals(scheme)) {
            gVarH = f();
        } else if ("data".equals(scheme)) {
            gVarH = g();
        } else {
            gVarH = RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(scheme) ? h() : this.c;
        }
        this.j = gVarH;
        return this.j.a(iVar);
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        g gVar = this.j;
        if (gVar == null) {
            return null;
        }
        return gVar.a();
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        g gVar = this.j;
        if (gVar != null) {
            try {
                gVar.b();
            } finally {
                this.j = null;
            }
        }
    }
}
