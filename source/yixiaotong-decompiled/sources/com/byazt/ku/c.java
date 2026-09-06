package com.byazt.ku;

import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1781, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, c> f2440a = new ConcurrentHashMap();
    public String c;
    public tt n;
    public String tt;
    public List<C0205c> uj;
    public String ve;

    public Map<String, c> c() {
        return this.f2440a;
    }

    public void c(tt ttVar) {
        this.n = ttVar;
    }

    public void c(String str) {
        this.c = str;
    }

    public tt n() {
        return this.n;
    }

    public String tt() {
        return this.c;
    }

    public void tt(String str) {
        this.tt = str;
    }

    public String uj() {
        return this.ve;
    }

    public String ve() {
        return this.tt;
    }

    public void ve(String str) {
        this.ve = str;
    }

    public List<C0205c> getResources() {
        if (this.uj == null) {
            this.uj = new ArrayList();
        }
        return this.uj;
    }

    public void c(List<C0205c> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.uj = list;
    }

    public boolean a() {
        return (TextUtils.isEmpty(uj()) || TextUtils.isEmpty(ve()) || TextUtils.isEmpty(tt())) ? false : true;
    }

    public JSONObject sp() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", tt());
            jSONObject.putOpt("version", ve());
            jSONObject.putOpt("main", uj());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (C0205c c0205c : getResources()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0205c.c());
                    jSONObject2.putOpt("md5", c0205c.tt());
                    jSONObject2.putOpt("level", Integer.valueOf(c0205c.ve()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.f2440a.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z = false;
                for (String str : this.f2440a.keySet()) {
                    c cVar = this.f2440a.get(str);
                    if (cVar != null) {
                        jSONObject3.put(str, cVar.sp());
                        z = true;
                    }
                }
                if (z) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            tt ttVarN = n();
            if (ttVarN != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", ttVarN.c);
                jSONObject4.put("md5", ttVarN.tt);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> listTt = ttVarN.tt();
                if (listTt != null) {
                    for (Pair<String, String> pair : listTt) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String x() {
        JSONObject jSONObjectSp;
        if (!a() || (jSONObjectSp = sp()) == null) {
            return null;
        }
        return jSONObjectSp.toString();
    }

    /* JADX INFO: renamed from: com.byazt.ku.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1781, 44})
    public static class C0205c {
        public String c;
        public String tt;
        public int ve;

        public String c() {
            return this.c;
        }

        public void c(int i) {
            this.ve = i;
        }

        public void c(String str) {
            this.c = str;
        }

        public String tt() {
            return this.tt;
        }

        public void tt(String str) {
            this.tt = str;
        }

        public int ve() {
            return this.ve;
        }

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof C0205c)) {
                return super.equals(obj);
            }
            String str2 = this.c;
            if (str2 != null) {
                C0205c c0205c = (C0205c) obj;
                if (str2.equals(c0205c.c()) && (str = this.tt) != null && str.equals(c0205c.tt())) {
                    return true;
                }
            }
            return false;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 1781, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class tt {
        public String c;
        public String tt;
        public List<Pair<String, String>> ve;

        public String c() {
            return this.c;
        }

        public void c(String str) {
            this.c = str;
        }

        public void c(List<Pair<String, String>> list) {
            this.ve = list;
        }

        public List<Pair<String, String>> tt() {
            return this.ve;
        }

        public void tt(String str) {
            this.tt = str;
        }
    }

    public static c uj(String str) {
        if (str == null) {
            return null;
        }
        try {
            return c(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static c c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.c(jSONObject.optString("name"));
        cVar.tt(jSONObject.optString("version"));
        cVar.ve(jSONObject.optString("main"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                C0205c c0205c = new C0205c();
                c0205c.c(jSONObjectOptJSONObject2.optString("url"));
                c0205c.tt(jSONObjectOptJSONObject2.optString("md5"));
                c0205c.c(jSONObjectOptJSONObject2.optInt("level"));
                arrayList.add(c0205c);
            }
        }
        cVar.c(arrayList);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("engines");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    c cVarC = c(jSONObjectOptJSONObject3.optJSONObject(next));
                    if (cVarC != null) {
                        cVar.c().put(next, cVarC);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            tt ttVar = new tt();
            ttVar.c(jSONObjectOptJSONObject.optString("url"));
            ttVar.tt(jSONObjectOptJSONObject.optString("md5"));
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    arrayList2.add(new Pair<>(next2, jSONObjectOptJSONObject4.optString(next2)));
                }
                ttVar.c(arrayList2);
            }
            cVar.c(ttVar);
        }
        if (cVar.a()) {
            return cVar;
        }
        return null;
    }
}
