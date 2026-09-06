package com.jd.ad.sdk.bl.dynamicrender;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.hihonor.adsdk.base.g.j.e.a;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.jad_hu.jad_cp;
import com.jd.ad.sdk.jad_qd.jad_jw;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.jd.ad.sdk.jad_yl.jad_dq;
import com.jd.ad.sdk.jad_yl.jad_hu;
import com.jd.ad.sdk.jad_yl.jad_iv;
import com.jd.ad.sdk.jad_yl.jad_jt;
import com.jd.ad.sdk.logger.Logger;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class DynamicRenderTemplateHelper {
    public static com.jd.ad.sdk.jad_hu.jad_bo jad_dq;
    public final String jad_an;
    public final List<jad_cp> jad_bo;
    public String jad_cp;

    public class jad_an implements Runnable {
        public final /* synthetic */ jad_cp jad_an;

        public jad_an(DynamicRenderTemplateHelper dynamicRenderTemplateHelper, jad_cp jad_cpVar) {
            this.jad_an = jad_cpVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                DynamicRenderTemplateHelper.jad_dq.jad_an(this.jad_an);
                return;
            }
            jad_cp jad_cpVar = this.jad_an;
            List<String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
            if (jad_cpVar == null) {
                return;
            }
            try {
                ContentResolver contentResolverJad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an();
                if (contentResolverJad_an == null) {
                    return;
                }
                Uri uri = Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_dynamic_render/update");
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Integer.valueOf(jad_cpVar.jad_an));
                contentValues.put("templateID", Integer.valueOf(jad_cpVar.jad_cp));
                contentValues.put("templateUpdateTimeStamp", jad_cpVar.jad_dq);
                contentValues.put("templateJSON", jad_cpVar.jad_er);
                contentValues.put("timeStampInterval", jad_cpVar.jad_fs);
                contentValues.put("appIdPid", jad_cpVar.jad_bo);
                contentResolverJad_an.update(uri, contentValues, null, null);
            } catch (Exception e) {
                Logger.w("Exception while multi process update template: ", e.getMessage());
            }
        }
    }

    public DynamicRenderTemplateHelper(Context context, String str) {
        this.jad_an = str;
        if (!jad_jw.jad_dq(context)) {
            this.jad_bo = com.jd.ad.sdk.jad_tg.jad_an.jad_cp(str);
            return;
        }
        if (jad_dq == null) {
            com.jd.ad.sdk.jad_hu.jad_bo jad_boVarJad_an = com.jd.ad.sdk.jad_hu.jad_bo.jad_an(context, "jaddb.db", 2);
            jad_dq = jad_boVarJad_an;
            jad_boVarJad_an.jad_cp();
        }
        this.jad_bo = jad_dq.jad_an(str);
    }

    public void jad_an(String str) {
        jad_jt jad_jtVarJad_an;
        jad_hu jad_huVar;
        List<jad_dq> list;
        jad_dq jad_dqVar;
        com.jd.ad.sdk.jad_yl.jad_cp jad_cpVar;
        jad_cp jad_cpVar2 = null;
        if (TextUtils.isEmpty(str)) {
            jad_jtVarJad_an = null;
        } else {
            try {
                jad_jtVarJad_an = jad_jt.jad_an(str);
            } catch (JSONException e) {
                e.printStackTrace();
                jad_jtVarJad_an = null;
            }
        }
        jad_iv jad_ivVar = (jad_jtVarJad_an == null || (jad_huVar = jad_jtVarJad_an.jad_cp) == null || (list = jad_huVar.jad_an) == null || list.isEmpty() || (jad_dqVar = list.get(0)) == null || (jad_cpVar = jad_dqVar.jad_bo) == null) ? null : jad_cpVar.jad_bo;
        if (jad_ivVar == null) {
            return;
        }
        int i = jad_ivVar.jad_an;
        String str2 = jad_ivVar.jad_bo;
        String str3 = jad_ivVar.jad_cp;
        if (i != -1) {
            if (this.jad_bo.size() != 0) {
                for (jad_cp jad_cpVar3 : this.jad_bo) {
                    if (jad_cpVar3.jad_cp == i) {
                        jad_cpVar2 = jad_cpVar3;
                        break;
                    }
                }
            }
        } else {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_GW_RESPONSE_TEMPLATE_ID_NULL_ERROR;
            jad_fs.jad_an("", 10, jad_anVar.jad_an, jad_anVar.jad_an(new String[0]), 0);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.jad_cp = str3;
            if (jad_cpVar2 == null) {
                jad_cpVar2 = new jad_cp(0, this.jad_an, i, str2, str3, System.currentTimeMillis() + "");
            } else {
                jad_cpVar2.jad_er = str3;
                if (!TextUtils.isEmpty(str2)) {
                    jad_cpVar2.jad_dq = str2;
                }
                jad_cpVar2.jad_fs = System.currentTimeMillis() + "";
            }
        } else {
            if (jad_cpVar2 == null) {
                if (i == -1) {
                    return;
                }
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_LOCAL_TEMPLATE_NULL_ERROR;
                jad_fs.jad_an("", 10, jad_anVar2.jad_an, jad_anVar2.jad_an(new String[0]), 0);
                return;
            }
            String str4 = jad_cpVar2.jad_er;
            if (TextUtils.isEmpty(str4)) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_LOCAL_TEMPLATE_JSON_NULL_ERROR;
                jad_fs.jad_an("", 10, jad_anVar3.jad_an, jad_anVar3.jad_an(new String[0]), 0);
                return;
            } else {
                this.jad_cp = str4;
                jad_cpVar2.jad_fs = System.currentTimeMillis() + "";
            }
        }
        if (jad_cpVar2 != null) {
            WorkExecutor.execute(new jad_an(this, jad_cpVar2));
        }
    }

    public JSONArray jad_bo() throws JSONException {
        if (this.jad_bo == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (jad_cp jad_cpVar : this.jad_bo) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(a.W0, jad_cpVar.jad_cp);
            jSONObject.put("template_update_timestamp", jad_cpVar.jad_dq);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static boolean jad_an() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        return jad_anVarJad_an != null && "1".equals(jad_anVarJad_an.jad_na);
    }
}
