package com.byazt.tl;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.bwm.sp;
import com.byazt.ete.bm;
import com.byazt.ete.ic;
import com.byazt.nc.a;
import com.byazt.nr.h;
import com.byazt.nr.m;
import com.byazt.omf.gr;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.openalliance.ad.constant.x;
import com.umeng.analytics.pro.am;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 467, 46})
public class n implements com.byazt.sif.c {
    public final ic c;
    public boolean n;
    public final WeakReference<Context> tt;
    public String uj;
    public final uj ve;

    public n(ic icVar, Context context, uj ujVar, boolean z) {
        this.c = icVar;
        this.tt = new WeakReference<>(context);
        this.ve = ujVar;
        this.n = z;
    }

    @Override // com.byazt.sif.c
    public boolean c(String str, Dialog dialog) {
        if (TextUtils.isEmpty(str) || this.tt.get() == null || !str.startsWith("#oncall#")) {
            return false;
        }
        return c(this.tt.get(), str, dialog);
    }

    @Override // com.byazt.sif.c
    public boolean c(a aVar, String str, Dialog dialog) {
        com.byazt.vo.ve veVarC = uj.c();
        if (veVarC == null || !TextUtils.equals(aVar.getId(), veVarC.getId()) || !TextUtils.equals(aVar.getName(), veVarC.getName())) {
            return false;
        }
        m.tt("TTAdDislikeImpl", "click feedback :" + aVar.getName() + x.bQ + aVar.getId());
        if (!this.n) {
            return c(this.tt.get(), str, dialog);
        }
        if (this.uj != null) {
            return true;
        }
        String string = UUID.randomUUID().toString();
        this.uj = string;
        c(string, str);
        c(this.uj);
        return true;
    }

    private void c(String str) {
        try {
            Context context = this.tt.get();
            if (context == null) {
                return;
            }
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
        } catch (Throwable unused) {
        }
    }

    public boolean c(Context context, final String str, Dialog dialog) {
        try {
            if (this.uj == null) {
                this.uj = UUID.randomUUID().toString();
            }
            if (dialog != null) {
                dialog.dismiss();
            }
            new AlertDialog.Builder(context).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.byazt.tl.n.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    n nVar = n.this;
                    nVar.c(nVar.uj, str);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.byazt.tl.n.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setMessage(this.ve.uj() + "\n\n您此次反馈的id为：" + this.uj).setCancelable(true).create().show();
            return true;
        } catch (Exception e) {
            m.c(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(final String str) {
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.tl.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.tt.get() != null) {
                    h.c((Context) n.this.tt.get(), str, 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str, final String str2) {
        tt("反馈上传中，请您稍等！");
        com.byazt.bwm.n.tt(new sp("upload_oncall") { // from class: com.byazt.tl.n.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.tt(str, str2);
                } catch (Throwable th) {
                    m.tt("#oncall#", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(String str, String str2) throws Throwable {
        HashMap map = null;
        File file = new File(com.byazt.nr.sp.tt(gt.getContext(), false, null), str);
        file.mkdirs();
        gr grVar = (gr) gt.c();
        com.byazt.dj.tt ttVarIj = this.c.ij();
        JSONObject jSONObjectC = grVar.c(ttVarIj, new bm(), ttVarIj.gt(), false, 6, false);
        if (jSONObjectC == null) {
            return;
        }
        com.byazt.bzd.n.c(com.byazt.by.a.c().tt(jSONObjectC.toString()).uj().toString(), new File(file, "request.info"));
        com.byazt.bzd.n.c(com.byazt.nr.c.c(com.byazt.ogz.x.c((com.byazt.ogz.n) null).a()).toString(), new File(file, "setting.info"));
        com.byazt.bzd.n.c(com.byazt.nr.c.c(this.c.yg()).toString(), new File(file, "meta.info"));
        File fileC = com.byazt.bzd.n.c(file, str + ".zip");
        String strVe = ve(str2, str);
        HashMap map2 = new HashMap();
        Pair<Integer, JSONObject> pairC = com.byazt.by.a.c().c(strVe, false);
        if (pairC != null) {
            map = new HashMap();
            map2.put("deviceInfo", ((JSONObject) pairC.second).optString(CrashHianalyticsData.MESSAGE));
            map.put("x-pglcypher", String.valueOf(pairC.first));
        }
        new com.byazt.sml.c().c(this.ve.ve(), fileC, map2, new com.byazt.sml.c.InterfaceC0271c() { // from class: com.byazt.tl.n.5
            @Override // com.byazt.sml.c.InterfaceC0271c
            public void c(String str3) {
                n nVar = n.this;
                nVar.tt(nVar.n ? "已复制广告ID\r\n请前往应用内上报问题" : "反馈上传成功！");
            }

            @Override // com.byazt.sml.c.InterfaceC0271c
            public void c(int i, String str3) {
                n nVar = n.this;
                nVar.tt(nVar.n ? "反馈失败\r\n 请重新复制" : "反馈失败");
            }
        }, map);
        fileC.delete();
        com.byazt.bzd.n.tt(file);
    }

    private String ve(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("app_name", com.byazt.omf.x.m().qy());
            jSONObject.putOpt("app_id", com.byazt.omf.x.m().rl());
            jSONObject.putOpt("os_api", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("os_version", Build.VERSION.RELEASE);
            jSONObject.putOpt("manufacturer", Build.MANUFACTURER);
            jSONObject.putOpt("did", ((com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog")).getDid());
            jSONObject.putOpt("sdk_version", 7611);
            jSONObject.putOpt("sdk_api_version", Integer.valueOf(p.uj));
            jSONObject.putOpt("live_sdk_version", com.byazt.apd.tt.c().sp());
            jSONObject.putOpt("msg", str);
            jSONObject.putOpt("recordId", str2);
            jSONObject.putOpt(am.x, "Android");
            jSONObject.putOpt("ad_info", this.c.mk());
            com.byazt.dj.tt ttVarIj = this.c.ij();
            if (ttVarIj != null) {
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(ttVarIj.gt()));
                jSONObject.putOpt("rit", ttVarIj.my());
            }
            return jSONObject.toString();
        } catch (Exception e) {
            m.tt("#oncall#", e);
            return str;
        }
    }

    public static void c(Context context, com.byazt.dyf.tt ttVar, ic icVar) {
        if (ttVar == null || icVar == null) {
            return;
        }
        boolean zCg = gt.tt().cg();
        uj ujVarIj = gt.tt().ij();
        if (ujVarIj == null || TextUtils.isEmpty(ujVarIj.ve())) {
            return;
        }
        if (ujVarIj.tt() || zCg) {
            ttVar.addInterceptor(new n(icVar, context, ujVarIj, zCg));
        }
    }
}
