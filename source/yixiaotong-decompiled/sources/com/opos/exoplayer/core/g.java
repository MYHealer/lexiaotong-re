package com.opos.exoplayer.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6464a;
    private final com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> b;
    private final int c;
    private final long d;

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar) {
        this(context, bVar, 0);
    }

    public g(Context context, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, int i) {
        this(context, bVar, i, 5000L);
    }

    public g(Context context, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, int i, long j) {
        this.f6464a = context;
        this.b = bVar;
        this.c = i;
        this.d = j;
    }

    protected void a(Context context, Handler handler, int i, ArrayList<t> arrayList) {
    }

    protected void a(Context context, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, long j, Handler handler, com.opos.exoplayer.core.video.f fVar, int i, ArrayList<t> arrayList) {
        arrayList.add(new com.opos.exoplayer.core.video.c(context, com.opos.exoplayer.core.d.c.f6377a, j, bVar, false, handler, fVar, 50));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            arrayList.add(size, (t) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, com.opos.exoplayer.core.video.f.class, Integer.TYPE).newInstance(true, Long.valueOf(j), handler, fVar, 50));
            com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
        } catch (ClassNotFoundException unused) {
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating VP9 extension", e);
        }
    }

    protected void a(Context context, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, com.opos.exoplayer.core.a.d[] dVarArr, Handler handler, com.opos.exoplayer.core.a.e eVar, int i, ArrayList<t> arrayList) {
        int i2;
        int i3;
        arrayList.add(new com.opos.exoplayer.core.a.i(com.opos.exoplayer.core.d.c.f6377a, bVar, true, handler, eVar, com.opos.exoplayer.core.a.c.a(context), dVarArr));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (t) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                    com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i2;
                    i2 = size;
                }
            } catch (ClassNotFoundException unused2) {
            }
            try {
                try {
                    i3 = i2 + 1;
                    try {
                        arrayList.add(i2, (t) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                        com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                    } catch (ClassNotFoundException unused3) {
                        i2 = i3;
                        i3 = i2;
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating FLAC extension", e);
                }
            } catch (ClassNotFoundException unused4) {
            }
            try {
                arrayList.add(i3, (t) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
            } catch (ClassNotFoundException unused5) {
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e2);
            }
        } catch (Exception e3) {
            throw new RuntimeException("Error instantiating Opus extension", e3);
        }
    }

    protected void a(Context context, com.opos.exoplayer.core.f.j jVar, Looper looper, int i, ArrayList<t> arrayList) {
        arrayList.add(new com.opos.exoplayer.core.f.k(jVar, looper));
    }

    protected void a(Context context, com.opos.exoplayer.core.metadata.e eVar, Looper looper, int i, ArrayList<t> arrayList) {
        arrayList.add(new com.opos.exoplayer.core.metadata.f(eVar, looper));
    }

    protected com.opos.exoplayer.core.a.d[] a() {
        return new com.opos.exoplayer.core.a.d[0];
    }

    @Override // com.opos.exoplayer.core.w
    public t[] a(Handler handler, com.opos.exoplayer.core.video.f fVar, com.opos.exoplayer.core.a.e eVar, com.opos.exoplayer.core.f.j jVar, com.opos.exoplayer.core.metadata.e eVar2) {
        ArrayList<t> arrayList = new ArrayList<>();
        a(this.f6464a, this.b, this.d, handler, fVar, this.c, arrayList);
        a(this.f6464a, this.b, a(), handler, eVar, this.c, arrayList);
        a(this.f6464a, jVar, handler.getLooper(), this.c, arrayList);
        a(this.f6464a, eVar2, handler.getLooper(), this.c, arrayList);
        a(this.f6464a, handler, this.c, arrayList);
        return (t[]) arrayList.toArray(new t[arrayList.size()]);
    }
}
