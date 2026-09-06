package com.byazt.ete;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES})
public class hq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2177a;
    public String c;
    public int n;
    public String sp;
    public int tt;
    public String uj;
    public String ve;
    public String x;

    public int a() {
        return this.f2177a;
    }

    public String c() {
        return this.c;
    }

    public void c(int i) {
        this.tt = i;
    }

    public void c(String str) {
        this.c = str;
    }

    public int n() {
        return this.n;
    }

    public void n(String str) {
        this.x = str;
    }

    public String sp() {
        return this.sp;
    }

    public int tt() {
        return this.tt;
    }

    public void tt(int i) {
        this.n = i;
    }

    public void tt(String str) {
        this.ve = str;
    }

    public String uj() {
        return this.uj;
    }

    public void uj(String str) {
        this.sp = str;
    }

    public String ve() {
        return this.ve;
    }

    public void ve(int i) {
        this.f2177a = i;
    }

    public void ve(String str) {
        this.uj = str;
    }

    public String x() {
        return this.x;
    }

    public String toString() {
        return i().toString();
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wc_skip_type", tt());
            jSONObject.put("wc_miniapp_link", c());
            jSONObject.put("adv_id", ve());
            jSONObject.put("site_id", uj());
            jSONObject.put("wc_open_method", a());
            jSONObject.put("wc_miniapp_sdk", sp());
            jSONObject.put("wc_appid", x());
        } catch (Throwable th) {
            com.byazt.nr.m.tt("toString failed:" + th.getMessage());
        }
        return jSONObject;
    }

    public static hq c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        hq hqVar = new hq();
        try {
            hqVar.c(jSONObject.optInt("wc_skip_type"));
            hqVar.c(jSONObject.optString("wc_miniapp_link"));
            hqVar.tt(jSONObject.optString("adv_id"));
            hqVar.ve(jSONObject.optString("site_id"));
            hqVar.ve(jSONObject.optInt("wc_open_method"));
            hqVar.uj(jSONObject.optString("wc_miniapp_sdk"));
            hqVar.n(jSONObject.optString("wc_appid"));
        } catch (Throwable th) {
            com.byazt.nr.m.tt("parse WechatData failed:" + th.getMessage());
        }
        return hqVar;
    }
}
