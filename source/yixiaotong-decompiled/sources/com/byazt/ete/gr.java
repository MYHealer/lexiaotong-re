package com.byazt.ete;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class gr implements com.byazt.sr.ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2173a;
    public final float c;
    public final int da;
    public JSONObject gt;
    public final int i;
    public final byte m;
    public int my;
    public final long n;
    public SparseArray<com.byazt.hkv.uj.c> nu;
    public String rh;
    public final String sl;
    public final int sp;
    public final String t;
    public final float tt;
    public final String u;
    public final float uj;
    public final float ve;
    public final int x;
    public final String yp;
    public final boolean z;

    /* JADX INFO: renamed from: com.byazt.ete.gr$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME})
    static /* synthetic */ class AnonymousClass1 {
    }

    public /* synthetic */ gr(c cVar, AnonymousClass1 anonymousClass1) {
        this(cVar);
    }

    private gr(c cVar) {
        this.my = -1;
        this.c = cVar.sp;
        this.tt = cVar.f2174a;
        this.ve = cVar.n;
        this.uj = cVar.uj;
        this.n = cVar.ve;
        this.f2173a = cVar.tt;
        this.sp = cVar.x;
        this.x = cVar.i;
        this.i = cVar.da;
        this.da = cVar.sl;
        this.sl = cVar.t;
        this.nu = cVar.c;
        this.z = cVar.m;
        this.gt = cVar.nu;
        this.t = cVar.u;
        this.u = cVar.yp;
        this.yp = cVar.z;
        this.rh = cVar.rh;
        this.my = cVar.my;
        this.m = cVar.gt;
    }

    public JSONObject c() {
        if (this.gt == null) {
            this.gt = new JSONObject();
        }
        return this.gt;
    }

    @com.byazt.zqa.c(c = {0, 1, 8, 1489})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f2174a;
        public int da;
        public int i;
        public boolean m;
        public float n;
        public JSONObject nu;
        public String rh;
        public int sl;
        public float sp;
        public String t;
        public long tt;
        public String u;
        public float uj;
        public long ve;
        public int x;
        public String yp;
        public String z;
        public SparseArray<com.byazt.hkv.uj.c> c = new SparseArray<>();
        public int my = -1;
        public byte gt = 0;

        public c c(byte b) {
            this.gt = b;
            return this;
        }

        public c c(float f) {
            this.uj = f;
            return this;
        }

        public c c(int i) {
            this.x = i;
            return this;
        }

        public c c(long j) {
            this.tt = j;
            return this;
        }

        public c c(SparseArray<com.byazt.hkv.uj.c> sparseArray) {
            this.c = sparseArray;
            return this;
        }

        public c c(String str) {
            this.t = str;
            return this;
        }

        public c c(JSONObject jSONObject) {
            this.nu = jSONObject;
            return this;
        }

        public c c(boolean z) {
            this.m = z;
            return this;
        }

        public c n(int i) {
            this.my = i;
            return this;
        }

        public c n(String str) {
            this.rh = str;
            return this;
        }

        public c tt(float f) {
            this.n = f;
            return this;
        }

        public c tt(int i) {
            this.i = i;
            return this;
        }

        public c tt(long j) {
            this.ve = j;
            return this;
        }

        public c tt(String str) {
            this.u = str;
            return this;
        }

        public c uj(float f) {
            this.sp = f;
            return this;
        }

        public c uj(int i) {
            this.sl = i;
            return this;
        }

        public c uj(String str) {
            this.z = str;
            return this;
        }

        public c ve(float f) {
            this.f2174a = f;
            return this;
        }

        public c ve(int i) {
            this.da = i;
            return this;
        }

        public c ve(String str) {
            this.yp = str;
            return this;
        }

        public gr c() {
            return new gr(this, null);
        }
    }
}
