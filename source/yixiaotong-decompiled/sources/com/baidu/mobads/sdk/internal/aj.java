package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class aj implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f1719a;

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(JSONObject jSONObject) {
    }

    aj(ae aeVar) {
        this.f1719a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f1719a.f());
        map.put("interstitial_container", viewGroup);
        map.put("entry", 2);
        map.put("channelId", Integer.valueOf(this.f1719a.w[0]));
        this.f1719a.a(cz.u, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f1719a.f());
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.f1719a.g()));
        map.put("entry", 2);
        map.put("channelId", Integer.valueOf(this.f1719a.w[0]));
        map.put("novel_info", jSONObject);
        this.f1719a.a(cz.v, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f1719a.f());
        map.put("banner_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.f1719a.g()));
        map.put("entry", 2);
        map.put("channelId", Integer.valueOf(this.f1719a.w[0]));
        map.put("novel_info", jSONObject);
        this.f1719a.a(cz.w, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f1719a.f());
        map.put("banner_container", viewGroup2);
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.f1719a.g()));
        map.put("entry", 2);
        map.put("channelId", Integer.valueOf(this.f1719a.w[0]));
        map.put(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, Integer.valueOf(i));
        this.f1719a.a(cz.z, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String strI = this.f1719a.i("get_cuid");
        String strI2 = this.f1719a.i("get_oaid");
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
        this.f1719a.k.a("单次阅读器打开时长 = " + j);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", viewGroup.getContext());
        map.put("banner_container", viewGroup);
        map.put("entry", 2);
        map.put("channelId", Integer.valueOf(this.f1719a.w[0]));
        this.f1719a.a(cz.y, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, int i) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f1719a.f());
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.f1719a.g()));
        map.put("entry", 2);
        map.put("channelId", Integer.valueOf(this.f1719a.w[0]));
        map.put("count_down", Integer.valueOf(i));
        this.f1719a.a(cz.A, map);
    }
}
