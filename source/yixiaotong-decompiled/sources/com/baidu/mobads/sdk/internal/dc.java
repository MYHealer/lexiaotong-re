package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class dc implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ cz f1802a;

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(JSONObject jSONObject) {
    }

    dc(cz czVar) {
        this.f1802a = czVar;
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f1802a.f());
        map.put("interstitial_container", viewGroup);
        map.put("entry", Integer.valueOf(this.f1802a.G));
        map.put("channelId", Integer.valueOf(this.f1802a.H));
        map.put("novel_id", this.f1802a.I);
        this.f1802a.a(cz.u, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f1802a.f());
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.f1802a.g()));
        map.put("entry", Integer.valueOf(this.f1802a.G));
        map.put("channelId", Integer.valueOf(this.f1802a.H));
        map.put("novel_id", this.f1802a.I);
        map.put("novel_info", jSONObject);
        this.f1802a.a(cz.v, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f1802a.f());
        map.put("banner_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.f1802a.g()));
        map.put("entry", Integer.valueOf(this.f1802a.G));
        map.put("channelId", Integer.valueOf(this.f1802a.H));
        map.put("novel_id", this.f1802a.I);
        map.put("novel_info", jSONObject);
        this.f1802a.a(cz.w, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f1802a.f());
        map.put("banner_container", viewGroup2);
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.f1802a.g()));
        map.put("entry", Integer.valueOf(this.f1802a.G));
        map.put("channelId", Integer.valueOf(this.f1802a.H));
        map.put("novel_id", this.f1802a.I);
        map.put(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, Integer.valueOf(i));
        this.f1802a.a(cz.z, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String strI = this.f1802a.i("get_cuid");
        String strI2 = this.f1802a.i("get_oaid");
        try {
            jSONObject.put("cuid", strI);
            jSONObject.put("imei", "");
            jSONObject.put("oaid", strI2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(long j) {
        if (this.f1802a.K != null) {
            this.f1802a.K.onReadTime(j);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", viewGroup.getContext());
        map.put("banner_container", viewGroup);
        map.put("entry", Integer.valueOf(this.f1802a.G));
        map.put("channelId", Integer.valueOf(this.f1802a.H));
        map.put("novel_id", this.f1802a.I);
        map.put("isnight", Boolean.valueOf(this.f1802a.x()));
        this.f1802a.a(cz.y, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, int i) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f1802a.f());
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.f1802a.g()));
        map.put("entry", Integer.valueOf(this.f1802a.G));
        map.put("channelId", Integer.valueOf(this.f1802a.H));
        map.put("novel_id", this.f1802a.I);
        map.put("count_down", Integer.valueOf(i));
        this.f1802a.a(cz.A, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(boolean z) {
        RelativeLayout relativeLayout;
        if (this.f1802a.L == null || (relativeLayout = (RelativeLayout) this.f1802a.L.get()) == null) {
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", (Activity) this.f1802a.i);
        map.put("interstitial_container", null);
        map.put("banner_container", relativeLayout);
        map.put("entry", Integer.valueOf(this.f1802a.G));
        map.put("channelId", Integer.valueOf(this.f1802a.H));
        map.put("novel_id", this.f1802a.I);
        map.put("isnight", Boolean.valueOf(this.f1802a.x()));
        this.f1802a.a(cz.z, map);
    }
}
