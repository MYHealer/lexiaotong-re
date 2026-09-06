package com.byazt.ddx;

import android.text.TextUtils;
import com.byazt.ete.gu;
import com.byazt.ete.ic;
import com.byazt.ete.nu;
import com.byazt.omf.or;
import com.huawei.openalliance.ad.constant.ba;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 483, 71})
public class x {
    public static volatile x c;

    public static x c() {
        if (c == null) {
            synchronized (x.class) {
                if (c == null) {
                    c = new x();
                }
            }
        }
        return c;
    }

    private x() {
    }

    public void c(final ic icVar, final String str, final boolean z, final boolean z2, final i.c cVar) {
        if (icVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.cl.c.c(1);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        new i().c(new i.c() { // from class: com.byazt.ddx.x.1
            public boolean x = false;

            @Override // com.byazt.ddx.i.c
            public void c(long j) {
                i.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(j);
                }
                c(false, ba.ag);
                if (!z) {
                    c(str, z2);
                }
                com.byazt.omf.tt.c().put("dpl_reject_by_dialog", true);
                uj.c(icVar, str, "dpl_popup", System.currentTimeMillis() - jCurrentTimeMillis);
                if (j > gu.tt()) {
                    com.byazt.cl.c.c(2);
                } else {
                    com.byazt.cl.c.c(3);
                }
            }

            @Override // com.byazt.ddx.i.c
            public void c(String str2) {
                i.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(str2);
                }
                c(false, str2);
            }

            @Override // com.byazt.ddx.i.c
            public void c(boolean z3) {
                i.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(z3);
                }
                this.x = z3;
                c(z3, "stop");
                if (!this.x && !z) {
                    c(str, z2);
                }
                com.byazt.omf.tt.c().put("dpl_reject_by_dialog", false);
            }

            private void c(String str2, boolean z3) {
                ic icVar2 = icVar;
                if (icVar2 == null || this.x) {
                    return;
                }
                boolean zNu = icVar2.nu();
                nu nuVarYp = icVar.yp();
                if (nuVarYp == null || nuVarYp.c()) {
                    return;
                }
                int iVe = nuVarYp.ve();
                if (zNu) {
                    return;
                }
                if (iVe == 1 || iVe == 2) {
                    or.c(icVar, str2, z3);
                }
            }

            private void c(final boolean z3, final String str2) {
                com.byazt.bwm.n.c(new com.byazt.bwm.sp("EventData") { // from class: com.byazt.ddx.x.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z) {
                            uj.ve(icVar, str, z3 ? "lp_dpl_success" : "lp_dpl_failed");
                            return;
                        }
                        String str3 = z3 ? "dpl_success" : "dpl_failed";
                        HashMap map = new HashMap();
                        boolean zC = com.byazt.omf.x.m().c();
                        map.put("has_focus", Boolean.valueOf(com.byazt.omf.x.m().c(true)));
                        map.put("is_background", Boolean.valueOf(zC));
                        map.put("life", str2);
                        map.put("total_duration", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        uj.i(icVar, str, str3, map);
                        if (icVar == null || !z3) {
                            return;
                        }
                        x.tt(icVar, str);
                    }
                }, 5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(ic icVar, String str) {
        if (icVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
        veVarC.put("save_jump_success_time", System.currentTimeMillis());
        JSONObject jSONObjectYg = icVar.yg();
        if (jSONObjectYg == null) {
            return;
        }
        veVarC.put("save_dpl_success_materialmeta", jSONObjectYg.toString());
        veVarC.put("save_jump_success_ad_tag", str);
    }
}
