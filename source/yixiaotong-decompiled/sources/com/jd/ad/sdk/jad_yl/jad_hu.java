package com.jd.ad.sdk.jad_yl;

import com.cdo.oaps.ad.OapsKey;
import com.hihonor.adsdk.base.g.j.e.a;
import com.huawei.openalliance.ad.constant.bi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JADSeatbid.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_hu {
    public List<jad_dq> jad_an;

    public List<jad_dq> jad_an() {
        return this.jad_an;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.jd.ad.sdk.jad_yl.jad_fs] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.jd.ad.sdk.jad_yl.jad_cp] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public static jad_hu jad_an(JSONObject jSONObject) throws JSONException {
        jad_dq jad_dqVar;
        JSONArray jSONArray;
        jad_iv jad_ivVar;
        ?? jad_fsVar;
        String str;
        JSONArray jSONArray2;
        jad_er jad_erVar;
        ?? r9;
        jad_dq jad_dqVar2 = null;
        if (jSONObject == null) {
            return null;
        }
        jad_hu jad_huVar = new jad_hu();
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray3 = jSONObject.getJSONArray("bid");
        if (jSONArray3 != null && jSONArray3.length() > 0) {
            int i = 0;
            while (i < jSONArray3.length()) {
                JSONObject jSONObject2 = jSONArray3.getJSONObject(i);
                if (jSONObject2 == null) {
                    jSONArray = jSONArray3;
                    jad_dqVar = jad_dqVar2;
                } else {
                    jad_dqVar = new jad_dq();
                    String str2 = "id";
                    jSONObject2.optString("id");
                    jSONObject2.optString("impid");
                    jSONObject2.optString(OapsKey.KEY_ADID);
                    jSONObject2.optString("ad_type");
                    jad_dqVar.jad_an = jSONObject2.optDouble(OapsKey.KEY_PRICE);
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("adm");
                    if (jSONObjectOptJSONObject == null) {
                        jSONArray = jSONArray3;
                        r9 = jad_dqVar2;
                    } else {
                        jad_cp jad_cpVar = new jad_cp();
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("items");
                        ArrayList arrayList2 = new ArrayList();
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                            int i2 = 0;
                            while (i2 < jSONArrayOptJSONArray.length()) {
                                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                                if (jSONObjectOptJSONObject2 == null) {
                                    jSONArray3 = jSONArray3;
                                    jad_fsVar = jad_dqVar2;
                                    str = str2;
                                    jSONArray2 = jSONArrayOptJSONArray;
                                } else {
                                    jad_fsVar = new jad_fs();
                                    jad_fsVar.jad_an = jSONObjectOptJSONObject2.optString("title");
                                    jad_fsVar.jad_bo = jSONObjectOptJSONObject2.optString("desc");
                                    jSONObjectOptJSONObject2.optString(str2);
                                    jad_fsVar.jad_cp = jSONObjectOptJSONObject2.optString("click_url");
                                    jad_fsVar.jad_dq = jSONObjectOptJSONObject2.optString("dpl_url");
                                    jad_fsVar.jad_ly = jSONObjectOptJSONObject2.optString("media_style");
                                    jad_fsVar.jad_mz = jSONObjectOptJSONObject2.optString("download_url");
                                    jad_fsVar.jad_er = jSONObjectOptJSONObject2.optString(bi.Code);
                                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("imgs");
                                    ArrayList arrayList3 = new ArrayList();
                                    if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                                        int i3 = 0;
                                        while (i3 < jSONArrayOptJSONArray2.length()) {
                                            JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i3);
                                            if (jSONObjectOptJSONObject3 == null) {
                                                jad_erVar = null;
                                            } else {
                                                jad_erVar = new jad_er();
                                                jSONObjectOptJSONObject3.optString(str2);
                                                jad_erVar.jad_an = jSONObjectOptJSONObject3.optString("url");
                                            }
                                            arrayList3.add(jad_erVar);
                                            i3++;
                                            jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                            str2 = str2;
                                        }
                                    }
                                    str = str2;
                                    jSONArray2 = jSONArrayOptJSONArray;
                                    jad_fsVar.jad_fs = arrayList3;
                                    jad_fsVar.jad_na = jSONObjectOptJSONObject2.optString("video");
                                    jad_fsVar.jad_iv = jSONObjectOptJSONObject2.optString("ad_resource");
                                    JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray("exposal_urls");
                                    ArrayList arrayList4 = new ArrayList();
                                    if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                                        for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                                            arrayList4.add(jSONArrayOptJSONArray3.optString(i4));
                                        }
                                    }
                                    jad_fsVar.jad_jw = arrayList4;
                                    JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject2.optJSONArray("click_monitor_urls");
                                    ArrayList arrayList5 = new ArrayList();
                                    if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                                        for (int i5 = 0; i5 < jSONArrayOptJSONArray4.length(); i5++) {
                                            arrayList5.add(jSONArrayOptJSONArray4.optString(i5));
                                        }
                                    }
                                    jad_fsVar.jad_kx = arrayList5;
                                    jSONObjectOptJSONObject2.optString("video_start_url");
                                    jSONObjectOptJSONObject2.optString("video_valid_url");
                                    jSONObjectOptJSONObject2.optString("video_finish_url");
                                    jad_fsVar.jad_ob = jSONObjectOptJSONObject2.optInt("video_voice");
                                    jad_fsVar.jad_pc = jSONObjectOptJSONObject2.optInt("video_auto_play");
                                    jad_fsVar.jad_qd = jSONObjectOptJSONObject2.optInt("video_duration");
                                    jad_fsVar.jad_re = jSONObjectOptJSONObject2.optInt("video_width");
                                    jad_fsVar.jad_sf = jSONObjectOptJSONObject2.optInt("video_height");
                                    jad_fsVar.jad_jt = jSONObjectOptJSONObject2.optInt("img_width");
                                    jad_fsVar.jad_hu = jSONObjectOptJSONObject2.optInt("img_height");
                                }
                                arrayList2.add(jad_fsVar);
                                i2++;
                                jSONArray3 = jSONArray3;
                                jSONArrayOptJSONArray = jSONArray2;
                                str2 = str;
                                jad_dqVar2 = null;
                            }
                        }
                        jSONArray = jSONArray3;
                        jad_cpVar.jad_an = arrayList2;
                        JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("template");
                        if (jSONObjectOptJSONObject4 == null || jSONObjectOptJSONObject4.length() == 0) {
                            jad_ivVar = null;
                        } else {
                            jad_ivVar = new jad_iv();
                            jad_ivVar.jad_an = jSONObjectOptJSONObject4.optInt(a.W0);
                            jad_ivVar.jad_bo = jSONObjectOptJSONObject4.optString("template_update_timestamp");
                            jad_ivVar.jad_cp = jSONObjectOptJSONObject4.optString("template_json");
                        }
                        jad_cpVar.jad_bo = jad_ivVar;
                        jad_cpVar.jad_cp = jSONObjectOptJSONObject.optInt("spec_set_id");
                        jad_cpVar.jad_dq = jSONObjectOptJSONObject.optInt("template_style_id");
                        jad_cpVar.jad_er = jSONObjectOptJSONObject.optInt("creative_interactive_type");
                        jad_cpVar.jad_fs = jSONObjectOptJSONObject.optInt("area_click_type");
                        r9 = jad_cpVar;
                    }
                    jad_dqVar.jad_bo = r9;
                }
                arrayList.add(jad_dqVar);
                i++;
                jSONArray3 = jSONArray;
                jad_dqVar2 = null;
            }
        }
        jad_huVar.jad_an = arrayList;
        return jad_huVar;
    }
}
