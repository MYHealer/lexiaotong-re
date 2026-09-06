package com.jd.ad.sdk.jad_jt;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.packet.e;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.hihonor.adsdk.base.g.j.e.a;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;
import com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.jad_qd.jad_jw;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.multi.BuildConfig;
import com.jd.android.sdk.coreinfo.CoreInfo;
import com.umeng.analytics.pro.am;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JADRequestBuilder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_hu {
    public static JSONArray jad_an(JADSlot jADSlot) throws JSONException {
        JSONArray jSONArrayJad_bo;
        JSONArray jSONArray = new JSONArray();
        Object[] objArrSplit = new String[0];
        if (!TextUtils.isEmpty(jADSlot.getSlotID())) {
            objArrSplit = jADSlot.getSlotID().split(",");
        }
        for (Object obj : objArrSplit) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", UUIDUtils.uuid());
            jSONObject.put("tagid", obj);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.WIDTH, jADSlot.getAdImageWidth());
            jSONObject2.put(IAdInterListener.AdReqParam.HEIGHT, jADSlot.getAdImageHeight());
            jSONObject2.put(a.Q0, 1);
            jSONObject2.put("imgnum", 1);
            jSONObject.put("native", jSONObject2);
            jSONObject.put("isdeeplink", true);
            jSONObject.put(ClientCookie.SECURE_ATTR, 1);
            if (jADSlot.getDynamicRenderTemplateHelper() != null && (jSONArrayJad_bo = jADSlot.getDynamicRenderTemplateHelper().jad_bo()) != null && jSONArrayJad_bo.length() > 0) {
                jSONObject.put("template_list", jADSlot.getDynamicRenderTemplateHelper().jad_bo());
            }
            jSONObject.put("render_form", jADSlot.isFromNativeAd() ? 1 : 0);
            jSONObject.put("display_scene", jADSlot.getDisplayScene());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static byte[] jad_bo(JADSlot jADSlot) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", jADSlot.getRequestId());
            jSONObject.put("version", "4.1");
            jSONObject.put("imp", jad_an(jADSlot));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", JADYunSdk.getAppId());
            jSONObject2.put("bundle", jad_jw.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()));
            jSONObject2.put("sdkversion", BuildConfig.VERSION_NAME);
            jSONObject.put("app", jSONObject2);
            jSONObject.put(e.n, jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()));
            jSONObject.put("anti", jad_an());
        } catch (Exception e) {
            String requestId = jADSlot != null ? jADSlot.getRequestId() : "";
            int i = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_JSON_ERROR.jad_an;
            String slotID = jADSlot != null ? jADSlot.getSlotID() : "";
            int adType = jADSlot != null ? jADSlot.getAdType() : 0;
            String strJad_an = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_OTHER_ERROR.jad_an(e.getMessage());
            JSONObject jSONObject3 = new JSONObject();
            JsonUtils.put(jSONObject3, "pid", slotID);
            JsonUtils.put(jSONObject3, OapsKey.KEY_ADAPTER_TYPE, Integer.valueOf(adType));
            JsonUtils.put(jSONObject3, "error", strJad_an);
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(requestId, 3, i, jSONObject3.toString(), jADSlot != null ? jADSlot.getSen() : 0);
        }
        Logger.d("Gateway API Request: " + jSONObject);
        String string = jSONObject.toString();
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null || !"1".equals(jad_anVarJad_an.jad_bo)) {
            string = ANEProxy.jd(jSONObject.toString());
            if (TextUtils.isEmpty(string)) {
                return null;
            }
        }
        return string.getBytes(StandardCharsets.UTF_8);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0105  */
    /* JADX WARN: Code duplicated, block: B:21:0x0106 A[Catch: Exception -> 0x0120, TryCatch #0 {Exception -> 0x0120, blocks: (B:18:0x00ff, B:21:0x0106, B:23:0x010e, B:24:0x0113), top: B:37:0x00ff }] */
    /* JADX WARN: Code duplicated, block: B:23:0x010e A[Catch: Exception -> 0x0120, TryCatch #0 {Exception -> 0x0120, blocks: (B:18:0x00ff, B:21:0x0106, B:23:0x010e, B:24:0x0113), top: B:37:0x00ff }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0113 A[Catch: Exception -> 0x0120, TRY_LEAVE, TryCatch #0 {Exception -> 0x0120, blocks: (B:18:0x00ff, B:21:0x0106, B:23:0x010e, B:24:0x0113), top: B:37:0x00ff }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v36, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v37 */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:33:0x0120
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static java.lang.String jad_an() {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_jt.jad_hu.jad_an():java.lang.String");
    }

    public static JSONObject jad_an(Context context) throws JSONException {
        String strJad_an;
        String strJad_an2;
        String strJad_bo;
        int iJad_an;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(am.x, "android");
        jSONObject.put("osv", com.jd.ad.sdk.jad_qd.jad_hu.jad_an());
        String strJad_an3 = jad_jw.jad_an();
        if (!TextUtils.isEmpty(strJad_an3)) {
            Logger.i("imei获取正常", new Object[0]);
        }
        jSONObject.put("didmd5", strJad_an3);
        jSONObject.put("oid", jad_jw.jad_bo());
        try {
            com.jd.ad.sdk.jad_qd.jad_fs jad_fsVar = com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an;
            strJad_an2 = jad_fsVar.jad_an();
            if (jad_fsVar.jad_jt) {
                if (jad_fsVar.jad_an("ip")) {
                    strJad_an = com.jd.ad.sdk.jad_fq.jad_hu.jad_an();
                    try {
                        if (TextUtils.isEmpty(strJad_an)) {
                            strJad_an = "0.0.0.0";
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    strJad_an = "0.0.0.0";
                }
                strJad_an2 = strJad_an;
            }
        } catch (Exception unused2) {
            strJad_an = null;
        }
        if (TextUtils.isEmpty(strJad_an2)) {
            Logger.w("ip地址获取不正常，请注意实现接口", new Object[0]);
            jSONObject.put("ipenc", "");
        } else {
            Logger.i("ip地址获取正常", new Object[0]);
            jSONObject.put("ipenc", Base64.encodeToString(strJad_an2.getBytes(), 10));
        }
        jSONObject.put("ua", com.jd.ad.sdk.jad_qd.jad_hu.jad_dq());
        jSONObject.put("connectiontype", com.jd.ad.sdk.jad_qd.jad_iv.jad_an(context));
        jSONObject.put("make", com.jd.ad.sdk.jad_qd.jad_an.jad_mz());
        jSONObject.put("model", com.jd.ad.sdk.jad_qd.jad_an.jad_na());
        jSONObject.put(am.P, jad_jw.jad_bo(context));
        jSONObject.put("screenheight", JADScreenInfoUtils.getScreenHeight(context));
        jSONObject.put("screenwidth", JADScreenInfoUtils.getScreenWidth(context));
        double[] dArrJad_an = com.jd.ad.sdk.jad_qd.jad_dq.jad_an;
        try {
            com.jd.ad.sdk.jad_qd.jad_fs jad_fsVar2 = com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an;
            if (!jad_fsVar2.jad_fs) {
                JADLocation jADLocation = jad_fsVar2.jad_dq;
                if (jADLocation != null) {
                    dArrJad_an = jADLocation.toDoubleArray();
                }
            } else if (jad_fsVar2.jad_an(a.H0)) {
                dArrJad_an = com.jd.ad.sdk.jad_qd.jad_jt.jad_an.jad_an.jad_an(context);
            }
        } catch (Exception unused3) {
        }
        JSONObject jSONObject2 = new JSONObject();
        if (Double.compare(dArrJad_an[0], -1.0d) == 0 && Double.compare(dArrJad_an[1], -1.0d) == 0) {
            String strEncodeToString = Base64.encodeToString("-1".getBytes(), 10);
            jSONObject2.put("latenc", strEncodeToString);
            jSONObject2.put("lonenc", strEncodeToString);
            jSONObject2.put("latppc", strEncodeToString);
            jSONObject2.put("lonppc", strEncodeToString);
        } else {
            jSONObject2.put("latenc", Base64.encodeToString(Double.valueOf(dArrJad_an[0]).toString().getBytes(), 10));
            jSONObject2.put("lonenc", Base64.encodeToString(Double.valueOf(dArrJad_an[1]).toString().getBytes(), 10));
            jSONObject2.put("latppc", Base64.encodeToString(com.jd.ad.sdk.jad_fq.jad_iv.jad_an(dArrJad_an[0]).getBytes(), 10));
            jSONObject2.put("lonppc", Base64.encodeToString(com.jd.ad.sdk.jad_fq.jad_iv.jad_an(dArrJad_an[1]).getBytes(), 10));
        }
        jSONObject.put(a.H0, jSONObject2);
        jSONObject.put("jailbreak", String.valueOf(com.jd.ad.sdk.jad_qd.jad_an.jad_tg()));
        jSONObject.put("osupdatetime", com.jd.ad.sdk.jad_qd.jad_hu.jad_bo());
        jSONObject.put("hwmodel", com.jd.ad.sdk.jad_qd.jad_er.jad_bo());
        jSONObject.put("hardware", com.jd.ad.sdk.jad_qd.jad_an.jad_iv());
        try {
            if (com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("hwName")) {
                String strJad_iv = com.jd.ad.sdk.jad_qd.jad_an.jad_iv();
                strJad_bo = TextUtils.isEmpty(strJad_iv) ? "" : com.jd.ad.sdk.jad_fq.jad_fs.jad_bo(strJad_iv.toUpperCase());
            } else {
                strJad_bo = "";
            }
        } catch (Exception unused4) {
            strJad_bo = "";
        }
        jSONObject.put("hwname", strJad_bo);
        String str = "";
        try {
            if (com.jd.ad.sdk.jad_qd.jad_an.jad_an("hwMachine", true)) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                if (jad_anVar.jad_an("hwMachine", true)) {
                    str = (String) jad_anVar.jad_bo("hwMachine");
                } else {
                    str = Build.ID;
                    jad_anVar.jad_bo("hwMachine", str);
                }
            }
        } catch (Exception unused5) {
        }
        jSONObject.put("hwmachine", str);
        String country = "";
        if (com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("countryCode")) {
            try {
                country = Locale.getDefault().getCountry();
            } catch (Exception unused6) {
            }
        }
        jSONObject.put("countrycode", country);
        jSONObject.put("sysmemory", com.jd.ad.sdk.jad_qd.jad_er.jad_cp());
        jSONObject.put("sysdisksize", com.jd.ad.sdk.jad_qd.jad_er.jad_bo(context));
        jSONObject.put("board", com.jd.ad.sdk.jad_qd.jad_er.jad_an());
        String bootloaderVersion = "";
        try {
            if (com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an.jad_an("bootloader")) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                if (jad_anVar2.jad_an("bootloader", true)) {
                    bootloaderVersion = (String) jad_anVar2.jad_bo("bootloader");
                } else {
                    bootloaderVersion = "";
                    try {
                        if (com.jd.ad.sdk.jad_qd.jad_an.jad_an("bootloader", true)) {
                            if (jad_anVar2.jad_an("bootloader", true)) {
                                bootloaderVersion = (String) jad_anVar2.jad_bo("bootloader");
                            } else {
                                bootloaderVersion = CoreInfo.Device.getBootloaderVersion();
                                jad_anVar2.jad_bo("bootloader", bootloaderVersion);
                            }
                        }
                    } catch (Exception unused7) {
                    }
                    com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo("bootloader", bootloaderVersion);
                }
            }
        } catch (Exception unused8) {
        }
        jSONObject.put("bootloader", bootloaderVersion);
        jSONObject.put("display", com.jd.ad.sdk.jad_qd.jad_an.jad_hu());
        jSONObject.put("freediskspace", com.jd.ad.sdk.jad_qd.jad_an.jad_an(context));
        jSONObject.put("cpufrequency", com.jd.ad.sdk.jad_qd.jad_an.jad_er());
        jSONObject.put("cputype", com.jd.ad.sdk.jad_qd.jad_an.jad_dq());
        jSONObject.put("physicalcpu", com.jd.ad.sdk.jad_qd.jad_an.jad_ob());
        jSONObject.put("remainingbatterylevel", com.jd.ad.sdk.jad_qd.jad_an.jad_bo(context));
        jSONObject.put("sdkapilevel", com.jd.ad.sdk.jad_qd.jad_hu.jad_cp());
        synchronized (com.jd.ad.sdk.jad_qd.jad_hu.class) {
            iJad_an = com.jd.ad.sdk.jad_qd.jad_hu.jad_an(false);
        }
        jSONObject.put("jdappinstalled", iJad_an);
        return jSONObject;
    }

    public static String jad_an(com.jd.ad.sdk.jad_pc.jad_cp jad_cpVar, String str) {
        if (jad_cpVar == null) {
            return "";
        }
        com.jd.ad.sdk.jad_yl.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_ob.jad_jt.jad_an(str);
        if (jad_anVarJad_an != null && jad_anVarJad_an.jad_cp == 4) {
            String str2 = jad_cpVar.jad_an.jad_bo;
            Logger.w("The url is currently in a non-online environment ", new Object[0]);
            return str2;
        }
        Logger.i("The url is currently in a online environment ", new Object[0]);
        return jad_cpVar.jad_an.jad_an;
    }
}
