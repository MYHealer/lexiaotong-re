package com.byazt.yzg;

import android.content.Context;
import android.view.View;
import com.byazt.eia.sp;
import com.byazt.ete.ic;
import com.byazt.ete.zb;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.wz.x;
import com.byazt.xs.da;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 776, 54})
public class ve {
    public ic c;
    public com.byazt.av.c n;
    public Context tt;
    public c ve;
    public boolean uj = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2907a = false;
    public int sp = 0;
    public boolean x = false;
    public int i = -1;

    public void c(int i) {
        this.sp = i;
    }

    public void c(com.byazt.av.c cVar) {
        this.n = cVar;
    }

    public void c(boolean z) {
        this.uj = z;
    }

    public void tt(int i) {
        this.i = i;
    }

    public void tt(boolean z) {
        this.f2907a = z;
    }

    public void ve(boolean z) {
        this.x = z;
    }

    public ve(Context context, ic icVar) {
        this.tt = context;
        this.c = icVar;
    }

    public void c(c cVar) {
        c(cVar, this.c);
    }

    public void c(c cVar, sp spVar) {
        this.ve = cVar;
        if (cVar == null) {
            return;
        }
        cVar.c(this.tt);
        cVar.c(spVar);
        cVar.c(this.uj);
    }

    public boolean uj(boolean z) {
        c cVar = this.ve;
        if (cVar == null) {
            return true;
        }
        cVar.tt(z || this.x);
        c cVar2 = this.ve;
        if (cVar2 instanceof tt) {
            tt ttVar = (tt) cVar2;
            ttVar.ve(this.f2907a);
            ttVar.c(this.sp);
        }
        int i = this.i;
        if (i == 1) {
            this.ve.uj = 4;
            return true;
        }
        if (i == 0) {
            return false;
        }
        return this.ve.c();
    }

    public void c(String str, com.byazt.av.tt ttVar) {
        if (this.c == null) {
            return;
        }
        c((com.byazt.ete.uj) null, str, ttVar);
    }

    public void c(com.byazt.ete.uj ujVar, final String str, final String str2, final com.byazt.av.tt ttVar) {
        ic icVar = this.c;
        if (icVar == null) {
            return;
        }
        if (ujVar != null || icVar.st() != 2 || (this.ve instanceof n)) {
            c(ujVar, str, ttVar);
        } else {
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("tt_download_check") { // from class: com.byazt.yzg.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    ve.this.c(gt.c().c(ve.this.c, str2), str, ttVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.ete.uj ujVar, String str, com.byazt.av.tt ttVar) {
        String strFv;
        String strVe;
        String strC;
        com.byazt.aas.n.c cVarTt = tt(str, ttVar);
        try {
            if (ujVar != null) {
                com.byazt.ete.a aVarRh = this.c.rh();
                if (aVarRh != null) {
                    ujVar.c(aVarRh.uj());
                    ujVar.c(aVarRh.ve());
                }
                strFv = ujVar.x();
                strVe = ujVar.c();
                strC = ujVar.uj();
            } else {
                strFv = this.c.fv();
                strVe = x.ve(this.c);
                zb zbVarTe = this.c.te();
                strC = zbVarTe != null ? zbVarTe.c() : "";
            }
            if (da.i(this.c)) {
                if (!da.c(this.tt, this.c, strVe)) {
                    ic icVar = this.c;
                    c(icVar, str, da.tt(this.tt, icVar, strVe), 0, "");
                }
            } else {
                com.byazt.ddx.uj.tt(this.c, str, "pop_up", c());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dialog_title", strVe);
            jSONObject.put("dialog_icon_url", strC);
            jSONObject.put("dialog_app_description", this.c.op());
            String strC2 = c(strFv);
            tt(str);
            com.byazt.av.c cVar = this.n;
            if (cVar != null) {
                cVar.c();
            }
            if (da.c(this.tt, this.c, strVe)) {
                c(str, cVarTt, strC2, strC, jSONObject);
            } else {
                com.byazt.aas.n.c(this.tt, this.c.uj(), strC2, jSONObject.toString(), cVarTt, this.c);
            }
        } catch (JSONException e) {
            m.c(e);
        }
    }

    private String c(String str) {
        int iZ = com.byazt.ete.gt.z(this.c);
        try {
            if (iZ != 4) {
                if (iZ != 3) {
                    return str;
                }
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("hand_icon_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/ugeno-source/download_hand_tap.json");
                return jSONObject.toString();
            }
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject2.put("ugen_url", com.byazt.ete.gt.nu(this.c));
            jSONObject2.put("ugen_md5", com.byazt.ete.gt.rh(this.c));
            jSONObject2.put("download_num", tt(this.c.ru()));
            com.byazt.ete.n nVarZ = this.c.z();
            if (nVarZ == null) {
                return jSONObject2.toString();
            }
            jSONObject2.put("app_size", ve(nVarZ.sp()));
            jSONObject2.put("comment_num", c(nVarZ.a()));
            return jSONObject2.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    private void tt(final String str) {
        if (com.byazt.ete.gt.z(this.c) != 4) {
            return;
        }
        TTDelegateActivity.c(new com.byazt.ux.sp() { // from class: com.byazt.yzg.ve.2
            @Override // com.byazt.ux.sp
            public void c(int i, String str2) {
                ve.this.c(str, 1, str2);
                TTDelegateActivity.c((com.byazt.ux.sp) null);
            }

            @Override // com.byazt.ux.sp
            public void c(com.byazt.xj.ve<View> veVar) {
                ve.this.c(str, 0, "");
                TTDelegateActivity.c((com.byazt.ux.sp) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, int i, String str2) {
        JSONObject jSONObjectC = c();
        try {
            jSONObjectC.put("ugen_dl_render_fail_msg", str2);
            jSONObjectC.put("ugen_dl_render_fail", i);
        } catch (Exception unused) {
        }
        com.byazt.ddx.uj.tt(this.c, str, "pop_up", jSONObjectC);
    }

    public String c(long j) {
        if (j >= 100000000) {
            return String.format("%d亿+", Long.valueOf(j / 100000000));
        }
        if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return String.format("%d万+", Long.valueOf(j / ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT));
        }
        return j > 0 ? String.valueOf(j) : com.huawei.openalliance.ad.constant.x.A;
    }

    public String tt(long j) {
        if (j >= 100000000) {
            return String.format("%d亿+", Long.valueOf(Math.round(j / 1.0E8d)));
        }
        if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return String.format("%d万+", Long.valueOf(Math.round(j / 10000.0d)));
        }
        return j > 0 ? String.valueOf(j) : com.huawei.openalliance.ad.constant.x.A;
    }

    public String ve(long j) {
        return j <= 0 ? com.huawei.openalliance.ad.constant.x.A : String.format("%.1fMB", Double.valueOf((j / 1024.0d) / 1024.0d));
    }

    private void c(String str, com.byazt.aas.n.c cVar, String str2, String str3, JSONObject jSONObject) throws JSONException {
        jSONObject.put("is_easy_dl_dialog_pop_up_style", true);
        com.byazt.aas.n.c(this.tt, this.c.uj(), da.c(this.tt, str2, this.c, str3), jSONObject.toString(), cVar, ve(str), this.c);
    }

    private com.byazt.ux.sp ve(final String str) {
        return new com.byazt.ux.sp() { // from class: com.byazt.yzg.ve.3
            @Override // com.byazt.ux.sp
            public void c(int i, String str2) {
                ve veVar = ve.this;
                veVar.c(veVar.c, str, 6, i, str2);
                TTDelegateActivity.c((com.byazt.ux.sp) null);
            }

            @Override // com.byazt.ux.sp
            public void c(com.byazt.xj.ve<View> veVar) {
                ve veVar2 = ve.this;
                veVar2.c(veVar2.c, str, 5, 0, "");
                TTDelegateActivity.c((com.byazt.ux.sp) null);
            }
        };
    }

    private com.byazt.aas.n.c tt(final String str, final com.byazt.av.tt ttVar) {
        return new com.byazt.aas.n.c() { // from class: com.byazt.yzg.ve.4
            @Override // com.byazt.aas.n.c
            public void tt() {
            }

            @Override // com.byazt.aas.n.c
            public void c() {
                com.byazt.av.tt ttVar2 = ttVar;
                if (ttVar2 != null) {
                    ttVar2.c();
                }
                if (ve.this.n != null) {
                    ve.this.n.ve();
                    ve.this.n.tt();
                }
                a.tt = true;
                com.byazt.ddx.uj.tt(ve.this.c, str, "pop_up_download", ve.this.c());
            }

            @Override // com.byazt.aas.n.c
            public void ve() {
                com.byazt.ddx.uj.tt(ve.this.c, str, "pop_up_cancel", ve.this.c());
                if (ve.this.n != null) {
                    ve.this.n.tt();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ic icVar, String str, int i, int i2, String str2) {
        JSONObject jSONObjectC = c();
        if (6 == i) {
            try {
                jSONObjectC.put("easy_dl_render_fail_code", i2);
                if (icVar != null) {
                    String strVe = icVar.po().ve();
                    jSONObjectC.put("easy_dl_render_fail_msg", str2);
                    jSONObjectC.put("easy_dl_render_fail_dsl", uj(strVe));
                }
            } catch (Exception unused) {
            }
        }
        jSONObjectC.put("show_easy_dl_dialog_code", i);
        com.byazt.ddx.uj.tt(this.c, str, "pop_up", jSONObjectC);
    }

    private String uj(String str) {
        com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
        if (veVarC == null) {
            return null;
        }
        return veVarC.get(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            c cVar = this.ve;
            jSONObject.put("download_type", cVar != null ? cVar.tt() : -2);
        } catch (Exception e) {
            m.c(e);
        }
        return jSONObject;
    }
}
