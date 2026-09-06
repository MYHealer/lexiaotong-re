package com.byazt.sz;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB, 42})
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f2728a;
    public JSONObject c;
    public boolean da;
    public float i;
    public String n;
    public boolean sp;
    public JSONObject tt;
    public JSONObject uj;
    public String ve;
    public float x;

    public void c(float f, float f2) {
        this.x = f;
        this.i = f2;
    }

    public String tt() {
        return this.ve;
    }

    public boolean uj() {
        return this.sp;
    }

    public i(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    public i(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        JSONObject jSONObjectOptJSONObject;
        this.da = true;
        if (jSONObject != null) {
            if (jSONObject.has(TtmlNode.TAG_BODY)) {
                this.c = jSONObject.optJSONObject(TtmlNode.TAG_BODY);
            } else {
                this.c = jSONObject.optJSONObject("main_template");
            }
            this.tt = jSONObject.optJSONObject("sub_templates");
            if (jSONObject.has("meta")) {
                jSONObjectOptJSONObject = jSONObject.optJSONObject("meta");
            } else {
                jSONObjectOptJSONObject = jSONObject.optJSONObject("template_info");
            }
            if (jSONObjectOptJSONObject != null) {
                if (jSONObject.has(TtmlNode.TAG_BODY)) {
                    this.sp = true;
                    String strOptString = jSONObjectOptJSONObject.optString("version");
                    this.ve = strOptString;
                    if (TextUtils.isEmpty(strOptString)) {
                        this.ve = "3.0";
                    }
                } else {
                    this.ve = jSONObjectOptJSONObject.optString("sdk_version");
                }
                if (jSONObjectOptJSONObject.has("adType")) {
                    this.n = jSONObjectOptJSONObject.optString("adType");
                }
                if (jSONObjectOptJSONObject.has("gestureThrough")) {
                    this.da = com.byazt.cd.ve.c(jSONObjectOptJSONObject.optString("gestureThrough"), true);
                }
            } else if (jSONObject.has(TtmlNode.TAG_BODY)) {
                this.ve = "3.0";
                this.sp = true;
            }
            this.uj = jSONObject2;
            this.f2728a = jSONObject3;
        }
    }

    public c c() {
        return n();
    }

    private c n() {
        if (!uj()) {
            return c(this.c, (c) null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flexDirection", Constant.KEY_ROW);
            jSONObject.put("justifyContent", "flex_start");
            jSONObject.put("alignItems", "flex_start");
            jSONObject.put("clickable", false);
            jSONObject.put("width", "match_parent");
            jSONObject.put("height", "wrap_content");
            float f = this.x;
            if (f > 0.0f) {
                jSONObject.put("width", f);
            }
            float f2 = this.i;
            if (f2 > 0.0f) {
                jSONObject.put("height", f2);
            }
            JSONObject jSONObject2 = this.uj;
            if (jSONObject2 != null) {
                String strOptString = jSONObject2.optString("xSize");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject3 = new JSONObject(strOptString);
                    if (jSONObject3.optInt("width") > 0) {
                        jSONObject.put("width", jSONObject3.optInt("width"));
                    }
                    if (jSONObject3.optInt("height") > 0) {
                        jSONObject.put("height", jSONObject3.optInt("height"));
                    }
                }
            }
        } catch (JSONException unused) {
        }
        c cVar = new c();
        cVar.tt = "View";
        cVar.c = "virtualNode";
        cVar.ve = jSONObject;
        cVar.f2729a = null;
        cVar.sp = this.ve;
        cVar.i = this.da;
        cVar.x = this.n;
        cVar.c(c(this.c, cVar));
        return cVar;
    }

    public List<c> ve() {
        if (this.tt == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = this.tt.keys();
        while (itKeys.hasNext()) {
            c cVarC = c(this.tt.optJSONObject(itKeys.next()), (c) null);
            if (cVarC != null) {
                arrayList.add(cVarC);
            }
        }
        return arrayList;
    }

    private c c(JSONObject jSONObject, c cVar) {
        String strOptString;
        String strOptString2;
        c cVarC;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.has("type")) {
            strOptString = jSONObject.optString("type");
        } else {
            strOptString = jSONObject.optString("name");
        }
        String strOptString3 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    com.byazt.nr.m.c(e);
                }
            }
        }
        c cVar2 = new c();
        cVar2.c = strOptString3;
        if (!this.sp || !TextUtils.equals("Video", strOptString)) {
            cVar2.tt = strOptString;
        } else {
            cVar2.tt = strOptString + "V3";
        }
        cVar2.ve = jSONObject2;
        cVar2.f2729a = cVar;
        cVar2.sp = this.ve;
        cVar2.i = this.da;
        cVar2.x = this.n;
        if (jSONObject2.has("i18n")) {
            cVar2.uj = jSONObject2.optJSONObject("i18n");
        }
        if (TextUtils.equals(strOptString, "CustomComponent")) {
            c(jSONObject, cVar2.ve);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObject.has("type")) {
                    strOptString2 = jSONObject.optString("type");
                } else {
                    strOptString2 = jSONObject.optString("name");
                }
                String strC = com.byazt.wj.tt.c(jSONObjectOptJSONObject.optString("id"), this.uj);
                if (TextUtils.equals(strOptString2, "Template")) {
                    JSONObject jSONObject3 = this.tt;
                    if (jSONObject3 != null) {
                        jSONObjectOptJSONObject = jSONObject3.optJSONObject(strC);
                        cVarC = c(jSONObjectOptJSONObject, cVar2);
                    } else {
                        cVarC = null;
                    }
                } else {
                    cVarC = c(jSONObjectOptJSONObject, cVar2);
                }
                if (cVarC != null) {
                    cVarC.tt(tt(cVarC));
                    cVarC.c(c(cVarC));
                }
                if (ve(cVarC)) {
                    i++;
                    cVar2.tt(cVarC);
                } else if (cVarC != null) {
                    cVar2.c(i2 - i, cVarC);
                }
            }
        }
        return cVar2;
    }

    public boolean c(c cVar) {
        JSONObject jSONObjectN;
        if (cVar == null || (jSONObjectN = cVar.n()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectN.optString("width"), "match_parent");
    }

    public boolean tt(c cVar) {
        JSONObject jSONObjectN;
        if (cVar == null || (jSONObjectN = cVar.n()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectN.optString("height"), "match_parent");
    }

    public boolean ve(c cVar) {
        JSONObject jSONObjectN;
        if (cVar == null || (jSONObjectN = cVar.n()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectN.optString("position"), "absolute");
    }

    private void c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.f2728a == null || jSONObject2 == null) {
            return;
        }
        try {
            String strOptString = this.f2728a.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(strOptString);
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("targetProps");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object objOpt = jSONObjectOptJSONObject.opt(next);
                    if (TextUtils.equals(next, "events") && jSONObject3.has("events")) {
                        if (objOpt instanceof JSONArray) {
                            com.byazt.cd.tt.c(jSONObject3.optJSONArray("events"), (JSONArray) objOpt);
                        }
                    } else {
                        jSONObject3.put(next, objOpt);
                    }
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                jSONArrayOptJSONArray.put(jSONObject3);
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", jSONArrayOptJSONArray);
            }
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    public static boolean uj(c cVar) {
        return (cVar == null || cVar.ve == null) ? false : true;
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB, 64})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f2729a;
        public String c;
        public boolean da;
        public boolean i;
        public LinkedList<c> n;
        public boolean sl;
        public String sp;
        public String tt;
        public JSONObject uj;
        public JSONObject ve;
        public String x;

        public List<c> a() {
            return this.n;
        }

        public String c() {
            return this.c;
        }

        public void c(String str) {
            this.tt = str;
        }

        public void c(boolean z) {
            this.da = z;
        }

        public JSONObject n() {
            return this.ve;
        }

        public JSONObject sp() {
            return this.uj;
        }

        public String tt() {
            return this.sp;
        }

        public void tt(boolean z) {
            this.sl = z;
        }

        public String uj() {
            return this.tt;
        }

        public boolean ve() {
            return this.i;
        }

        public void c(c cVar) {
            if (this.n == null) {
                this.n = new LinkedList<>();
            }
            this.n.add(cVar);
        }

        public void tt(c cVar) {
            if (this.n == null) {
                this.n = new LinkedList<>();
            }
            this.n.addLast(cVar);
        }

        public void c(int i, c cVar) {
            if (this.n == null) {
                this.n = new LinkedList<>();
            }
            this.n.add(i, cVar);
        }

        public String toString() {
            return "UGNode{id='" + this.c + "', name='" + this.tt + "'}";
        }
    }
}
