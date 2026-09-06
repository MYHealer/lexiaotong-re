package com.byazt.atv;

import com.byazt.sz.qy;
import com.byazt.xl.u;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 134, 13})
public class tt extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1985a;
    public JSONObject c;
    public boolean n;
    public qy tt;
    public float uj;
    public float ve;

    public boolean cu() {
        return this.n;
    }

    public float d() {
        return this.ve;
    }

    public float eo() {
        return this.uj;
    }

    public qy or() {
        return this.tt;
    }

    public int qp() {
        return this.f1985a;
    }

    public JSONObject zb() {
        return this.c;
    }

    public tt(c cVar) {
        super(cVar);
        this.f1985a = 3;
        this.c = cVar.c;
        this.tt = cVar.tt;
        this.ve = cVar.ve;
        this.uj = cVar.uj;
        this.n = cVar.n;
        this.f1985a = cVar.f1986a;
    }

    @com.byazt.zqa.c(c = {0, 1, 134, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c extends u.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1986a;
        public JSONObject c;
        public boolean n;
        public qy tt;
        public float uj;
        public float ve;

        public c c(float f) {
            this.ve = f;
            return this;
        }

        public c c(qy qyVar) {
            this.tt = qyVar;
            return this;
        }

        public c n(JSONObject jSONObject) {
            this.c = jSONObject;
            return this;
        }

        public c n(boolean z) {
            this.n = z;
            return this;
        }

        public c sl(int i) {
            this.f1986a = i;
            return this;
        }

        public c tt(float f) {
            this.uj = f;
            return this;
        }

        @Override // com.byazt.xl.u.c
        /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
        public tt c() {
            return new tt(this);
        }
    }
}
