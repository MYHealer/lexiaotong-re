package com.adprof.sdk;

import com.ubixnow.ooooo.o0OO000o;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class y0 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1529a;
    public int b;
    public int c;
    public int d;
    public int e;

    public y0() {
    }

    public y0(JSONObject jSONObject) {
        this.f1529a = jSONObject.optInt("req_freq");
        this.b = jSONObject.optInt("imp_freq");
        this.c = jSONObject.optInt("min_req_interval");
        this.d = jSONObject.optInt("countdown");
        jSONObject.optInt("slot_id");
        jSONObject.optInt(ClientCookie.SECURE_ATTR);
        jSONObject.optInt(o0OO000o.o000o0o);
        jSONObject.optInt("bid_floor");
        jSONObject.optInt("video_sound");
        this.e = jSONObject.optInt("close_countdown");
        jSONObject.optInt("shake_sensitivity");
        jSONObject.optInt("min_slide_distance");
        jSONObject.optInt("full_screen_click");
        jSONObject.optInt("template_type");
        jSONObject.optInt("charge_type");
    }
}
