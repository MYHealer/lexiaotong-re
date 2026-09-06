package com.byazt.whk;

import android.text.TextUtils;
import com.byazt.ete.ic;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 908, 158})
public class sl {
    public static final HashMap<String, t> c = new HashMap<>();

    public static void c(ic icVar) {
        ve veVar = (ve) com.byazt.ut.uj.getService("pitaya");
        if (veVar != null && veVar.isPitayaInitSuccess() && veVar.isPitayaEnvAvailable() && da.tt() && icVar != null && icVar.ij() != null) {
            String strQy = icVar.qy();
            String strGu = icVar.gu();
            String strUj = icVar.ij().uj();
            if (TextUtils.isEmpty(strUj)) {
                return;
            }
            t tVar = new t();
            tVar.c(1);
            tVar.c(strQy);
            tVar.tt(strGu);
            c.put(strUj, tVar);
        }
    }
}
