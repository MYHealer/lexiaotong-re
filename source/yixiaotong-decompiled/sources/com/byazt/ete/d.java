package com.byazt.ete;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.cdo.oaps.ad.OapsKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 512})
public class d {
    public static final Set<ve> tt = new CopyOnWriteArraySet();
    public static boolean c = false;
    public static final Object ve = new Object();

    public interface c {
        void c(ve veVar);

        void tt(ve veVar);
    }

    public static Set<ve> c() {
        return tt;
    }

    public static void c(JSONObject jSONObject, c cVar) {
        if (jSONObject == null) {
            return;
        }
        com.byazt.aas.aw.c().c(cVar);
        c = jSONObject.optBoolean("h5_cache_resources_enable", false);
        tt(jSONObject, cVar);
    }

    private static void tt(JSONObject jSONObject, final c cVar) {
        if (c) {
            final HashSet hashSet = new HashSet();
            String str = "h5_cache_resources";
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("h5_cache_resources");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        hashSet.add(new ve(jSONObjectOptJSONObject));
                    }
                }
            }
            com.byazt.bzd.x.c(new com.byazt.bwm.sp(str) { // from class: com.byazt.ete.d.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.aas.aw.c().c(hashSet, cVar);
                }
            });
        }
    }

    public static void c(com.byazt.it.n nVar) {
        synchronized (ve) {
            try {
                c = nVar.get("h5_cache_resources_enable", false);
                JSONArray jSONArray = new JSONArray(nVar.get("h5_cache_resources", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        tt.add(new ve(jSONObjectOptJSONObject));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void tt(com.byazt.it.n nVar) {
        nVar.put("h5_cache_resources_enable", c);
    }

    public static void c(com.byazt.it.n nVar, ve veVar) {
        synchronized (ve) {
            tt.add(veVar);
            ve(nVar);
        }
    }

    public static void tt(com.byazt.it.n nVar, ve veVar) {
        synchronized (ve) {
            tt.remove(veVar);
            ve(nVar);
        }
    }

    private static void ve(com.byazt.it.n nVar) {
        JSONArray jSONArray = new JSONArray();
        final JSONObject jSONObject = new JSONObject();
        try {
            Set<ve> set = tt;
            jSONObject.put("res_length", set.size());
            JSONArray jSONArray2 = new JSONArray();
            for (ve veVar : set) {
                jSONArray.put(veVar.n());
                jSONArray2.put(veVar.c + "$" + veVar.tt + "$" + (veVar.ve() == null ? "" : veVar.ve().c()));
            }
            jSONObject.put("res_infos", jSONArray2);
            com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.ete.d.2
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() {
                    com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("h5_resource_report");
                    ttVarC.tt(jSONObject.toString());
                    return ttVarC;
                }
            }, "h5_resource_report");
            nVar.put("h5_cache_resources", jSONArray.toString());
        } catch (OutOfMemoryError e) {
            com.byazt.ukr.yp.c().c("h5_resource_oom", jSONObject, e);
        } catch (JSONException unused) {
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS})
    public static class ve {
        public final String c;
        public final String tt;
        public final List<uj> ve = new ArrayList();

        public String c() {
            return this.c;
        }

        public List<uj> getResources() {
            return this.ve;
        }

        public String tt() {
            return this.tt;
        }

        public ve(JSONObject jSONObject) {
            this.c = jSONObject.optString("channel");
            this.tt = jSONObject.optString("prefix");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resource");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.ve.add(new uj(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public uj ve() {
            if (this.ve.isEmpty()) {
                return null;
            }
            return this.ve.get(0);
        }

        public String uj() {
            String str = this.c;
            return ve() != null ? str + "$" + com.byazt.nr.a.tt(ve().tt()) : str;
        }

        public JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channel", this.c);
                jSONObject.put("prefix", this.tt);
                JSONArray jSONArray = new JSONArray();
                Iterator<uj> it = this.ve.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().uj());
                }
                jSONObject.put("resource", jSONArray);
            } catch (JSONException e) {
                com.byazt.nr.m.c(e);
            }
            return jSONObject;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                ve veVar = (ve) obj;
                if (!Objects.equals(this.c, veVar.c) || !Objects.equals(this.tt, veVar.tt)) {
                    return false;
                }
                uj ujVarVe = ve();
                uj ujVarVe2 = veVar.ve();
                if (ujVarVe != null && ujVarVe2 != null) {
                    return Objects.equals(ujVarVe.c(), ujVarVe2.c()) && Objects.equals(ujVarVe.tt(), ujVarVe2.tt());
                }
                if (ujVarVe == ujVarVe2) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            String str = this.c;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.tt;
            int iHashCode2 = iHashCode + (str2 != null ? str2.hashCode() : 0);
            uj ujVarVe = ve();
            if (ujVarVe == null) {
                return iHashCode2;
            }
            String strC = ujVarVe.c();
            String strTt = ujVarVe.tt();
            return (((iHashCode2 * 31) + (strC != null ? strC.hashCode() : 0)) * 31) + (strTt != null ? strTt.hashCode() : 0);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 8, 307})
    public static class uj {
        public final String c;
        public final String tt;
        public final List<tt> ve = new ArrayList();

        public String c() {
            return this.c;
        }

        public String tt() {
            return this.tt;
        }

        public List<tt> ve() {
            return this.ve;
        }

        public uj(JSONObject jSONObject) {
            this.c = jSONObject.optString("resource_url");
            this.tt = jSONObject.optString("content_hash");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("channel_resource_list");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        this.ve.add(new tt(jSONObjectOptJSONObject));
                    }
                }
            }
        }

        public JSONObject uj() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resource_url", this.c);
                jSONObject.put("content_hash", this.tt);
                JSONArray jSONArray = new JSONArray();
                Iterator<tt> it = this.ve.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().ve());
                }
                jSONObject.put("channel_resource_list", jSONArray);
            } catch (JSONException e) {
                com.byazt.nr.m.c(e);
            }
            return jSONObject;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD})
    public static class tt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2170a;
        public final long c;
        public final String n;
        public final String tt;
        public final String uj;
        public final String ve;

        public String c() {
            return this.n;
        }

        public String tt() {
            return this.f2170a;
        }

        public tt(JSONObject jSONObject) {
            this.c = jSONObject.optLong(OapsKey.KEY_SIZE, 0L);
            this.tt = jSONObject.optString("md5");
            this.ve = jSONObject.optString("content_hash");
            this.uj = jSONObject.optString("url");
            this.n = jSONObject.optString("mime_type");
            this.f2170a = jSONObject.optString("file_name");
        }

        public JSONObject ve() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(OapsKey.KEY_SIZE, this.c);
                jSONObject.put("md5", this.tt);
                jSONObject.put("content_hash", this.ve);
                jSONObject.put("mime_type", this.n);
                jSONObject.put("file_name", this.f2170a);
                jSONObject.put("url", this.uj);
            } catch (JSONException e) {
                com.byazt.nr.m.c(e);
            }
            return jSONObject;
        }
    }
}
