package com.byazt.lvl;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.byazt.aas.rl;
import com.byazt.bzd.uj;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.eti.n;
import com.byazt.nr.m;
import com.byazt.nr.sp;
import com.byazt.nr.x;
import com.byazt.omf.gt;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.ba;
import com.stub.StubApp;
import com.ubixnow.ooooo.o0OO000o;
import java.io.File;
import java.io.FileFilter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2208, 20})
public class c {
    public static volatile c c;
    public final Context tt;
    public long uj;
    public final tt ve;

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c(gt.getContext());
                }
            }
        }
        return c;
    }

    private c(Context context) {
        this.tt = context == null ? gt.getContext() : StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.ve = new tt();
    }

    public void tt() {
        File fileUj;
        File[] fileArrListFiles;
        n.c(7).c();
        n.c(8).c();
        if (("mounted".equals(uj.c()) || !Environment.isExternalStorageRemovable()) && sp.uj(this.tt, false, null) != null) {
            fileUj = sp.uj(this.tt, false, null);
        } else {
            fileUj = sp.tt(this.tt, false, null);
        }
        if (fileUj == null || !fileUj.exists() || !fileUj.isDirectory() || (fileArrListFiles = fileUj.listFiles(new FileFilter() { // from class: com.byazt.lvl.c.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null) {
                    return file.getName().contains("reward_video_cache");
                }
                return false;
            }
        })) == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file : fileArrListFiles) {
            try {
                x.ve(file);
            } catch (Throwable unused) {
            }
        }
    }

    public String c(boolean z, String str) {
        long jVe = gt.tt().ve(str);
        if (jVe > 0 && System.currentTimeMillis() - this.uj < jVe) {
            return "1";
        }
        int i = z ? 7 : 8;
        ic icVarTt = tt(z, str);
        if (icVarTt == null) {
            return "0";
        }
        if (icVarTt.dz() + icVarTt.b() < System.currentTimeMillis()) {
            n.c(i).c(str);
            return "1";
        }
        JSONObject jSONObjectC = c(icVarTt);
        if (jSONObjectC == null) {
            return "0";
        }
        this.uj = System.currentTimeMillis();
        return jSONObjectC.toString();
    }

    private JSONObject c(ic icVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("req_id", icVar.oz());
            jSONObject.put("aid", Long.valueOf(icVar.gu()));
            jSONObject.put(ba.D, Long.valueOf(icVar.uj()));
            jSONObject.put(OapsKey.KEY_PRICE, icVar.j());
            jSONObject.put("material_key", icVar.y());
            jSONObject.put("s_send_ts", icVar.dz());
            jSONObject.put("cache_time", icVar.b());
            jSONObject.put(o0OO000o.o00O0O0O, icVar.q());
            return jSONObject;
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public void c(com.byazt.dj.tt ttVar, String str) {
        this.ve.c(str, ttVar);
    }

    public com.byazt.dj.tt c(ic icVar, String str) {
        return this.ve.c(icVar == null ? null : icVar.jl(), str);
    }

    public void tt(com.byazt.dj.tt ttVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c(ttVar, str);
    }

    public synchronized ic tt(boolean z, String str) {
        ic icVarC;
        try {
            if (z) {
                icVarC = com.byazt.cf.sp.c().c(str, 0);
            } else {
                icVarC = com.byazt.cf.tt.c().c(str, 0);
            }
            if (icVarC == null) {
                return null;
            }
            if (rl.ve(icVarC)) {
                if (TextUtils.isEmpty(str) || !str.endsWith("again")) {
                    return icVarC;
                }
                return null;
            }
            if (com.byazt.ex.c.c(icVarC)) {
                return icVarC;
            }
            if (xd.z(icVarC) == null) {
                return null;
            }
            return icVarC;
        } catch (Throwable th) {
            throw th;
        }
    }
}
