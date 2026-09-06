package com.byazt.dz;

import android.content.Context;
import com.byazt.nr.da;
import com.byazt.nr.gt;
import com.byazt.nr.m;
import com.byazt.nr.sp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 106, 20})
public class c {
    public static volatile boolean c;

    private static void c(Context context, tt ttVar) {
        if (ttVar != null && com.byazt.zlb.tt.c == null && gt.c(com.byazt.omf.gt.getContext()) && ttVar.uj()) {
            String path = sp.tt(context, false, null).getPath();
            String string = com.byazt.nys.tt.c(context).toString();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("buffer_dir_path", path + "/aa");
                jSONObject.putOpt("log_dir_path", string + "/aa");
                jSONObject.putOpt("compress", Boolean.TRUE);
                jSONObject.putOpt("encrypt", Boolean.TRUE);
                jSONObject.putOpt("level", Integer.valueOf(ttVar.c()));
                jSONObject.putOpt("log_file_exp_days", Integer.valueOf(ttVar.tt()));
                jSONObject.putOpt("max_dir_size", Integer.valueOf(ttVar.ve() * 1048576));
                jSONObject.putOpt("per_size", 2097152);
                jSONObject.putOpt("offload_main_write", Boolean.TRUE);
                if (ve.c(context, jSONObject)) {
                    m.c(new n());
                    ve.c(context, "3892", ((com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog")).getDid());
                    ve.c("mon.zijieapi.com");
                    c = true;
                    ve.ve();
                    return;
                }
                m.uj("ACL", "init failed");
            } catch (JSONException e) {
                m.uj("ACL", "init failed:" + e.getMessage());
            }
        }
    }

    public static void c(tt ttVar) {
        if (!c) {
            c(com.byazt.omf.gt.getContext(), ttVar);
        } else if (ttVar == null || !ttVar.uj()) {
            ve.c();
        } else {
            ve.c(ttVar.c());
            da.c().postDelayed(new Runnable() { // from class: com.byazt.dz.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.tt();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt() {
        com.byazt.bwm.n.tt(new com.byazt.bwm.sp("fetch_lg_command") { // from class: com.byazt.dz.c.2
            @Override // java.lang.Runnable
            public void run() {
                ve.tt();
            }
        });
    }

    public static void c(String str, String str2) {
        if (c) {
            ve.c(str, str2);
        }
    }

    public static void tt(String str, String str2) {
        if (c) {
            ve.tt(str, str2);
        }
    }

    public static void ve(String str, String str2) {
        if (c) {
            ve.ve(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (c) {
            ve.c(str, str2, th);
        }
    }

    public static void uj(String str, String str2) {
        if (c) {
            ve.uj(str, str2);
        }
    }

    public static void tt(String str, String str2, Throwable th) {
        if (c) {
            ve.tt(str, str2, th);
        }
    }

    public static void c(String str, Throwable th) {
        if (c) {
            ve.c(str, th);
        }
    }
}
