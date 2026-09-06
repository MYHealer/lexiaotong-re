package com.byazt.hn;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.byazt.cd.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.cdo.oaps.ad.OapsKey;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 25, 13})
public final class tt {
    public final ve c;
    public final List<uj> tt;

    public ve c() {
        return this.c;
    }

    public List<uj> tt() {
        return this.tt;
    }

    public static int c(String str) {
        if ("line".equals(str)) {
            return 1;
        }
        if ("rectangle".equals(str)) {
            return 2;
        }
        if (TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE.equals(str)) {
            return 3;
        }
        return "sphere".equals(str) ? 4 : 0;
    }

    public static int tt(String str) {
        if ("outline".equals(str)) {
            return 1;
        }
        return "surface".equals(str) ? 2 : 0;
    }

    public static int ve(String str) {
        if ("rect".equals(str)) {
            return 1;
        }
        return "star".equals(str) ? 2 : 0;
    }

    public static int uj(String str) {
        if ("additive".equals(str)) {
            return 1;
        }
        if ("backToFront".equals(str) || "oldestFirst".equals(str)) {
            return 3;
        }
        return "oldestLast".equals(str) ? 4 : 0;
    }

    private tt(ve veVar, List<uj> list) {
        this.c = veVar;
        this.tt = list;
    }

    public boolean ve() {
        List<uj> list = this.tt;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static tt c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return c(context, new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static tt c(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ve veVarC = ve.c(jSONObject.optJSONObject("layer"));
        List<uj> listC = c(context, jSONObject.optJSONArray("particles"));
        if (listC.isEmpty()) {
            return null;
        }
        return new tt(veVarC, listC);
    }

    private static List<uj> c(Context context, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(uj.c(context, jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }

    @com.byazt.zqa.c(c = {0, 1, 25, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX})
    public static final class ve {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2301a;
        public final String c;
        public final C0170tt da;
        public final C0170tt i;
        public final int n;
        public final C0170tt sp;
        public final String tt;
        public final int uj;
        public final String ve;
        public final C0170tt x;

        private ve(String str, String str2, String str3, C0170tt c0170tt, C0170tt c0170tt2, C0170tt c0170tt3, C0170tt c0170tt4) {
            this.c = str;
            this.tt = str2;
            this.ve = str3;
            this.uj = tt.c(str);
            this.n = tt.tt(str2);
            this.f2301a = tt.uj(str3);
            this.sp = c0170tt;
            this.x = c0170tt2;
            this.i = c0170tt3;
            this.da = c0170tt4;
        }

        public static ve c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            String strOptString = jSONObject.optString("emitterShape", OapsKey.KEY_POINT);
            String strOptString2 = jSONObject.optString("emitterMode", "points");
            String strOptString3 = jSONObject.optString("renderMode", "unordered");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("emitterPosition");
            C0170tt c0170ttC = C0170tt.c(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.opt("x") : null, new C0170tt(0.5f, true));
            C0170tt c0170ttC2 = C0170tt.c(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.opt("y") : null, new C0170tt(0.0f, true));
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("emitterSize");
            return new ve(strOptString, strOptString2, strOptString3, c0170ttC, c0170ttC2, C0170tt.c(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.opt(IAdInterListener.AdReqParam.WIDTH) : null, new C0170tt(1.0f, true)), C0170tt.c(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.opt(IAdInterListener.AdReqParam.HEIGHT) : null, new C0170tt(1.0f, true)));
        }

        private static ve c() {
            return new ve(OapsKey.KEY_POINT, "points", "unordered", new C0170tt(0.5f, true), new C0170tt(0.0f, true), new C0170tt(1.0f, true), new C0170tt(1.0f, true));
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 25, 1886})
    public static final class uj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f2300a;
        public final String c;
        public final float da;
        public final float i;
        public final float n;
        public final float sl;
        public final float sp;
        public final c t;
        public final float tt;
        public final float uj;
        public final float ve;
        public final float x;

        private uj(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, c cVar) {
            this.c = str;
            this.tt = f;
            this.ve = f2;
            this.uj = f3;
            this.n = f4;
            this.f2300a = f5;
            this.sp = f6;
            this.x = f7;
            this.i = f8;
            this.da = f9;
            this.sl = f10;
            this.t = cVar;
        }

        public static uj c(Context context, JSONObject jSONObject) {
            return new uj(jSONObject.optString("name", ""), (float) jSONObject.optDouble("birthRate", 1.0d), (float) jSONObject.optDouble("lifetime", 1.0d), (float) jSONObject.optDouble("lifetimeRange", 0.0d), (float) jSONObject.optDouble("scale", 1.0d), (float) jSONObject.optDouble("scaleRange", 0.0d), (float) jSONObject.optDouble("velocity", 0.0d), (float) jSONObject.optDouble("velocityRange", 0.0d), (float) jSONObject.optDouble("emissionRange", 0.0d), (float) jSONObject.optDouble("alphaRange", 0.0d), (float) jSONObject.optDouble("alphaSpeed", 0.0d), c.c(context, jSONObject.optJSONObject("content")));
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 25, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static final class c {
        public final String c;
        public final int n;
        public final int tt;
        public final float uj;
        public final float ve;

        private c(String str, float f, float f2, int i) {
            this.c = str;
            this.tt = tt.ve(str);
            this.ve = f;
            this.uj = f2;
            this.n = i;
        }

        public static c c(Context context, JSONObject jSONObject) {
            if (jSONObject == null) {
                return new c(TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE, x.c(context, 6.0f), x.c(context, 6.0f), -1);
            }
            return new c(jSONObject.optString("shape", TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE), x.c(context, (float) jSONObject.optDouble("width", 6.0d)), x.c(context, (float) jSONObject.optDouble("height", 6.0d)), com.byazt.cd.c.c(jSONObject.optString("color", "#FFFFFF"), -1));
        }
    }

    /* JADX INFO: renamed from: com.byazt.hn.tt$tt, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 25, 240})
    public static final class C0170tt {
        public final float c;
        public final boolean tt;

        public float c(float f) {
            return this.tt ? f * this.c : this.c;
        }

        public C0170tt(float f, boolean z) {
            this.c = f;
            this.tt = z;
        }

        public static C0170tt c(Object obj, C0170tt c0170tt) {
            if (obj == null) {
                return c0170tt;
            }
            if (obj instanceof Number) {
                return new C0170tt(((Number) obj).floatValue(), false);
            }
            String strTrim = obj.toString().trim();
            if (TextUtils.isEmpty(strTrim)) {
                return c0170tt;
            }
            try {
                if (strTrim.endsWith("%")) {
                    return new C0170tt(Float.parseFloat(strTrim.substring(0, strTrim.length() - 1)) / 100.0f, true);
                }
                return new C0170tt(Float.parseFloat(strTrim), false);
            } catch (NumberFormatException unused) {
                return c0170tt;
            }
        }
    }
}
