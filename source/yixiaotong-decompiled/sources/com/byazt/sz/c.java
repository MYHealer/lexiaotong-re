package com.byazt.sz;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2726a;
    public String c;
    public long n;
    public float tt;
    public long uj;
    public List<C0276c> ve;

    public String a() {
        return this.f2726a;
    }

    public String c() {
        return this.c;
    }

    public void c(float f) {
        this.tt = f;
    }

    public void c(long j) {
        this.uj = j;
    }

    public void c(String str) {
        this.c = str;
    }

    public void c(List<C0276c> list) {
        this.ve = list;
    }

    public long n() {
        return this.n;
    }

    public float tt() {
        return this.tt;
    }

    public void tt(long j) {
        this.n = j;
    }

    public void tt(String str) {
        this.f2726a = str;
    }

    public long uj() {
        return this.uj;
    }

    public List<C0276c> ve() {
        return this.ve;
    }

    public static c c(String str, com.byazt.xj.ve veVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return c(new JSONObject(str), veVar);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    public static c c(JSONObject jSONObject, com.byazt.xj.ve veVar) {
        return c(jSONObject, null, veVar);
    }

    public static c c(JSONObject jSONObject, JSONObject jSONObject2, com.byazt.xj.ve veVar) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.c(jSONObject.optString("ordering"));
        String strOptString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", strOptString)) {
            cVar.c(-1.0f);
        } else {
            try {
                cVar.c(Float.parseFloat(strOptString));
            } catch (NumberFormatException unused) {
                cVar.c(0.0f);
            }
        }
        cVar.c(jSONObject.optLong("duration", 0L));
        cVar.tt(com.byazt.cd.ve.c(com.byazt.wj.tt.c(jSONObject.optString("startDelay"), veVar.da()), 0L));
        cVar.tt(jSONObject.optString("loopMode"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animators");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObject2 != null) {
                    com.byazt.cd.tt.c(jSONObject2, jSONObjectOptJSONObject);
                }
                arrayList.add(C0276c.c(jSONObjectOptJSONObject, veVar));
            }
            cVar.c(arrayList);
        }
        return cVar;
    }

    /* JADX INFO: renamed from: com.byazt.sz.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB, 44})
    public static class C0276c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f2727a;
        public long c;
        public String da;
        public String i;
        public String n;
        public float sp;
        public float tt;
        public long uj;
        public String ve;
        public float[] x;

        public float a() {
            return this.sp;
        }

        public long c() {
            return this.c;
        }

        public void c(float f) {
            this.tt = f;
        }

        public void c(long j) {
            this.c = j;
        }

        public void c(String str) {
            this.ve = str;
        }

        public void c(float[] fArr) {
            this.x = fArr;
        }

        public String getType() {
            return this.n;
        }

        public String i() {
            return this.da;
        }

        public float n() {
            return this.f2727a;
        }

        public float[] sp() {
            return this.x;
        }

        public float tt() {
            return this.tt;
        }

        public void tt(float f) {
            this.f2727a = f;
        }

        public void tt(long j) {
            this.uj = j;
        }

        public void tt(String str) {
            this.n = str;
        }

        public long uj() {
            return this.uj;
        }

        public void uj(String str) {
            this.i = str;
        }

        public String ve() {
            return this.ve;
        }

        public void ve(float f) {
            this.sp = f;
        }

        public void ve(String str) {
            this.da = str;
        }

        public String x() {
            return this.i;
        }

        public static C0276c c(JSONObject jSONObject, com.byazt.xj.ve veVar) {
            if (jSONObject == null) {
                return null;
            }
            C0276c c0276c = new C0276c();
            c0276c.c(jSONObject.optLong("duration"));
            String strOptString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", strOptString)) {
                c0276c.c(-1.0f);
            } else {
                try {
                    c0276c.c(Float.parseFloat(strOptString));
                } catch (NumberFormatException unused) {
                    c0276c.c(0.0f);
                }
            }
            c0276c.c(jSONObject.optString("loopMode"));
            c0276c.tt(jSONObject.optString("type"));
            if (TextUtils.equals(c0276c.getType(), "ripple")) {
                c0276c.ve(jSONObject.optString("rippleColor"));
            }
            View viewI = veVar.i();
            Context context = viewI != null ? viewI.getContext() : null;
            if (TextUtils.equals(c0276c.getType(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                String strC = com.byazt.wj.tt.c(jSONObject.optString("valueTo"), veVar.da());
                int iC = com.byazt.cd.c.c(jSONObject.optString("valueFrom"));
                int iC2 = com.byazt.cd.c.c(strC);
                c0276c.tt(iC);
                c0276c.ve(iC2);
            } else if ((TextUtils.equals(c0276c.getType(), "translateX") || TextUtils.equals(c0276c.getType(), "translateY")) && context != null) {
                try {
                    float fC = com.byazt.cd.x.c(context, (float) jSONObject.optDouble("valueFrom"));
                    float fC2 = com.byazt.cd.x.c(context, (float) jSONObject.optDouble("valueTo"));
                    c0276c.tt(fC);
                    c0276c.ve(fC2);
                } catch (Exception unused2) {
                    com.byazt.nr.m.uj("animation", "animation ");
                }
            } else {
                c0276c.tt((float) jSONObject.optDouble("valueFrom"));
                c0276c.ve((float) jSONObject.optDouble("valueTo"));
            }
            c0276c.uj(jSONObject.optString("interpolator"));
            c0276c.tt(com.byazt.cd.ve.c(com.byazt.wj.tt.c(jSONObject.optString("startDelay"), veVar.da()), 0L));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                float[] fArr = new float[jSONArrayOptJSONArray.length()];
                int i = 0;
                if ((TextUtils.equals(c0276c.getType(), "translateX") || TextUtils.equals(c0276c.getType(), "translateY")) && context != null) {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = com.byazt.cd.x.c(context, (float) c.c(jSONArrayOptJSONArray.optString(i), veVar.da()));
                        i++;
                    }
                } else {
                    while (i < jSONArrayOptJSONArray.length()) {
                        fArr[i] = (float) c.c(jSONArrayOptJSONArray.optString(i), veVar.da());
                        i++;
                    }
                }
                c0276c.c(fArr);
            }
            return c0276c;
        }
    }

    public static double c(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.byazt.cd.ve.c(com.byazt.wj.tt.c((String) obj, jSONObject), 0.0d);
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Long) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Integer) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }
}
