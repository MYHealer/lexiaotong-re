package com.opos.mobad.m;

import android.view.View;
import com.google.android.exoplayer2.ExoPlayer;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f7137a;
    private com.opos.mobad.b b;
    private String c;
    private AdItemData d;
    private MaterialData e;
    private long h;
    private int k;
    private long f = -1;
    private boolean g = false;
    private boolean i = false;
    private boolean j = false;

    public interface a {
        void b();

        void b(long j);

        void b(String str);

        void g_();
    }

    public d(com.opos.mobad.b bVar, String str, a aVar) {
        this.f7137a = aVar;
        this.b = bVar;
        this.c = str;
    }

    private boolean a(long j, long j2, float f) {
        boolean z = false;
        if (0 != j) {
            try {
                if (b(j, this.f) < f && b(j, j2) >= f) {
                    z = true;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("VideoPlayPresenter", "meetVideoPercent percent=" + f + ",result=" + z);
        return z;
    }

    private float b(long j, long j2) {
        float f = 0 != j ? j2 / (j * 1.0f) : 0.0f;
        com.opos.cmn.an.f.a.b("VideoPlayPresenter", "getVideoPercent=" + f);
        return f;
    }

    private void b() {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.m.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f7137a != null) {
                    d.this.f7137a.b();
                }
            }
        });
    }

    private void b(long j) {
        try {
            if (this.g) {
                return;
            }
            b.b(this.b, this.c, this.d, this.e, true, j);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
    }

    private long c(long j) {
        return j > 0 ? j : this.h;
    }

    public void a() {
        this.g = true;
    }

    public void a(final int i, String str, Map<String, String> map) {
        com.opos.cmn.an.f.a.b("VideoPlayPresenter", "onPlayError code=", Integer.valueOf(i), ", msg=", str);
        try {
            if (this.g) {
                return;
            }
            com.opos.mobad.cmn.func.b.e.a(this.b, this.c, this.d, this.e, true, String.valueOf(this.k), com.opos.mobad.cmn.func.b.e.a(i, str, map));
            final String strA = com.opos.mobad.ad.a.a(i);
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.m.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.g || d.this.f7137a == null) {
                        return;
                    }
                    a aVar = d.this.f7137a;
                    StringBuilder sbAppend = new StringBuilder("code=").append(i).append(",msg=");
                    String str2 = strA;
                    if (str2 == null) {
                        str2 = "";
                    }
                    aVar.b(sbAppend.append(str2).toString());
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("VideoPlayPresenter", "onPlayError", e);
        }
    }

    public void a(long j) {
        try {
            if (this.g) {
                return;
            }
            if (this.i) {
                com.opos.cmn.an.f.a.b("VideoPlayPresenter", "video has complete");
                return;
            }
            b.a(this.b, this.c, this.d, this.e, true, c(j));
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.m.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.f7137a != null) {
                        d.this.f7137a.g_();
                    }
                }
            });
            this.i = true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
    }

    public void a(long j, long j2) {
        MaterialData materialData;
        com.opos.mobad.b bVar;
        String str;
        AdItemData adItemData;
        MaterialData materialData2;
        boolean z;
        String str2;
        try {
            if (this.g) {
                return;
            }
            if (this.i) {
                com.opos.cmn.an.f.a.b("VideoPlayPresenter", "onProcess but has completed");
                return;
            }
            if (j2 <= 0) {
                j2 = this.h;
            } else if (!this.j && (materialData = this.e) != null && materialData.D() != null && this.e.D().size() > 0 && Math.abs(this.e.s() - j2) >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                this.j = true;
                this.b.i().a(this.e.X(), this.e.D().get(0).a(), this.e.s(), j2);
            }
            long j3 = j2;
            if (this.f == -1) {
                b();
            }
            if (a(j3, j, 0.25f)) {
                bVar = this.b;
                str = this.c;
                adItemData = this.d;
                materialData2 = this.e;
                z = true;
                str2 = "25";
            } else {
                if (!a(j3, j, 0.5f)) {
                    if (a(j3, j, 0.75f)) {
                        bVar = this.b;
                        str = this.c;
                        adItemData = this.d;
                        materialData2 = this.e;
                        z = true;
                        str2 = "75";
                    } else if (this.f == -1) {
                        b(j3);
                    }
                    this.f = j;
                }
                bVar = this.b;
                str = this.c;
                adItemData = this.d;
                materialData2 = this.e;
                z = true;
                str2 = "50";
            }
            b.a(bVar, str, adItemData, materialData2, z, str2, (int) j, j3);
            this.f = j;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
    }

    public void a(View view, int[] iArr, final long j) {
        try {
            if (this.g) {
                return;
            }
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.m.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.g || d.this.f7137a == null) {
                        return;
                    }
                    d.this.f7137a.b(j);
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
    }

    public void a(AdItemData adItemData, MaterialData materialData, long j, int i) {
        this.d = adItemData;
        this.e = materialData;
        this.f = -1L;
        this.i = false;
        if (j <= 0) {
            this.h = materialData.s();
        } else {
            this.h = j;
        }
        this.j = false;
        this.k = i;
    }
}
