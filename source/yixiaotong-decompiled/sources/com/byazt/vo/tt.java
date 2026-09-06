package com.byazt.vo;

import android.text.TextUtils;
import com.byazt.nc.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ubixnow.ooooo.o0OO000o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP_FPS_LIMIT, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2823a;
    public final int c;
    public final String n;
    public String sp;
    public final List<a> tt = new ArrayList();
    public final boolean uj;
    public String ve;
    public boolean x;

    public boolean a() {
        return this.c == 1;
    }

    public List<a> c() {
        return this.tt;
    }

    public void c(String str) {
        this.ve = str;
    }

    public boolean i() {
        return this.uj;
    }

    public String n() {
        return this.f2823a;
    }

    public void tt(String str) {
        this.sp = str;
    }

    public boolean tt() {
        return this.x;
    }

    public String uj() {
        return this.n;
    }

    public String ve() {
        return this.ve;
    }

    public String x() {
        return this.sp;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0064  */
    public tt(JSONObject jSONObject, ve veVar) {
        boolean z = false;
        this.c = jSONObject.optInt("dislike_control", 0);
        this.uj = jSONObject.optBoolean("close_on_dislike", false);
        String id = veVar != null ? veVar.getId() : "";
        this.x = veVar != null ? veVar.isNewUi() : false;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filter_words");
        if (jSONArrayOptJSONArray != null) {
            boolean zEquals = false;
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                ve fromJson = ve.parseFromJson(jSONArrayOptJSONArray.optJSONObject(i));
                fromJson.setNewUi(this.x);
                if (this.x && fromJson != null) {
                    String id2 = fromJson.getId();
                    if (!"8:1".equals(id2) && !"99:1".equals(id2)) {
                        if (fromJson == null) {
                        }
                    }
                } else if (fromJson == null && fromJson.isValid()) {
                    this.tt.add(fromJson);
                    if (!zEquals) {
                        zEquals = TextUtils.equals(fromJson.getId(), id);
                    }
                }
            }
            z = zEquals;
        }
        if (veVar != null && !z) {
            this.tt.add(veVar);
        }
        this.n = jSONObject.optString("ad_id");
        this.f2823a = jSONObject.optString(o0OO000o.o00O0O0O);
    }

    public void c(JSONObject jSONObject) throws JSONException {
        jSONObject.put("dislike_control", this.c);
        jSONObject.put("filter_words", sp());
        jSONObject.put("close_on_dislike", i());
    }

    public JSONArray sp() {
        JSONObject json;
        JSONArray jSONArray = new JSONArray();
        List<a> list = this.tt;
        if (list != null) {
            for (a aVar : list) {
                if ((aVar instanceof ve) && (json = ((ve) aVar).toJson()) != null) {
                    jSONArray.put(json);
                }
            }
        }
        return jSONArray;
    }
}
