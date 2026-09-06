package com.jd.ad.sdk.jad_jt;

import android.app.Application;
import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper;
import com.jd.ad.sdk.bl.initsdk.JADPrivateController;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.JADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.jad_lu.jad_na;
import com.jd.ad.sdk.jad_mx.jad_ly;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JADLoader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jt {
    public int jad_an = 0;
    public DynamicRenderTemplateHelper jad_bo = null;

    public static void jad_an(jad_jt jad_jtVar, JADSlot jADSlot) {
        int i;
        int iRound;
        int iRound2;
        int templateId;
        jad_jtVar.getClass();
        int i2 = 0;
        if (jADSlot.isFromNativeAd()) {
            jADSlot.setRem(2);
        } else {
            int adType = jADSlot.getAdType();
            synchronized (jad_jtVar) {
                com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
                if (jad_anVarJad_an == null || !"1".equals(jad_anVarJad_an.jad_na)) {
                    boolean z = 1 != adType;
                    if (!z) {
                        String str = JADYunSdk.getAppId() + jADSlot.getSlotID();
                        if (jad_jtVar.jad_bo == null) {
                            jad_jtVar.jad_bo = new DynamicRenderTemplateHelper(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), str);
                        }
                        jADSlot.setDynamicRenderTemplateHelper(jad_jtVar.jad_bo);
                        jADSlot.setRem(3);
                    }
                }
            }
            jADSlot.setRem(1);
        }
        try {
            iRound2 = Math.round(jADSlot.getWidth());
            try {
                iRound = Math.round(jADSlot.getHeight());
                if (jADSlot.getRem() == 2) {
                    iRound2 = Math.round(jADSlot.getAdImageWidth());
                    iRound = Math.round(jADSlot.getAdImageHeight());
                }
            } catch (Exception unused) {
                i2 = iRound2;
                i = 0;
                int i3 = i2;
                iRound = i;
                iRound2 = i3;
            }
        } catch (Exception unused2) {
            i = 0;
        }
        jADSlot.setAdImageWidth(iRound2);
        jADSlot.setAdImageHeight(iRound);
        jADSlot.getSlotID();
        jADSlot.getAdType();
        jADSlot.isFromNativeAd();
        synchronized (jad_jtVar) {
            templateId = CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId();
        }
        jADSlot.setTemplateId(templateId);
        jADSlot.setSen(JADMediator.getInstance().getInitService().getSen(jADSlot.getSlotID()));
    }

    public static void jad_bo(jad_jt jad_jtVar, JADSlot jADSlot) {
        jad_jtVar.getClass();
        if (jADSlot == null) {
            return;
        }
        jADSlot.setLoadSucTime(System.currentTimeMillis());
        String requestId = jADSlot.getRequestId();
        String slotID = jADSlot.getSlotID();
        int adType = jADSlot.getAdType();
        int sen = jADSlot.getSen();
        int rem = jADSlot.getRem();
        int templateId = jADSlot.getTemplateId();
        long loadSucTime = jADSlot.getLoadSucTime() - jADSlot.getLoadTime();
        int eventInteractionType = jADSlot.getEventInteractionType();
        int modelClickAreaType = jADSlot.getModelClickAreaType();
        int mediaSpecSetType = jADSlot.getMediaSpecSetType();
        int ds = JADMediator.getInstance().getInitService().getDs(jADSlot.getSlotID());
        int r = JADMediator.getInstance().getInitService().getR(jADSlot.getSlotID());
        if (jADSlot.getAdDataRequestSourceType() == 1 || jADSlot.getAdDataRequestSourceType() == 2) {
            JADMediator.getInstance().getEventService().reportPreloadResponseEvent(requestId, slotID, adType, templateId, sen, rem, loadSucTime, eventInteractionType, modelClickAreaType, mediaSpecSetType, ds, r);
        } else {
            JADMediator.getInstance().getEventService().reportResponseEvent(requestId, slotID, adType, templateId, sen, rem, loadSucTime, eventInteractionType, modelClickAreaType, mediaSpecSetType, ds, r);
        }
    }

    public static void jad_an(jad_jt jad_jtVar, JADSlot jADSlot, String str) {
        Application applicationJad_an;
        Application applicationJad_an2;
        Map<String, jad_na> mapJad_an;
        jad_na jad_naVar;
        jad_jtVar.getClass();
        String str2 = JADYunSdk.getAppId() + jADSlot.getSlotID();
        com.jd.ad.sdk.jad_kx.jad_er jad_erVar = com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an;
        if (jad_erVar.jad_bo(str2)) {
            return;
        }
        com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_kx.jad_cp(0, str2, jADSlot.getRequestId(), str, System.currentTimeMillis() + "");
        com.jd.ad.sdk.jad_kx.jad_fs jad_fsVar = jad_erVar.jad_bo;
        if (jad_fsVar != null) {
            synchronized (jad_fsVar) {
                ArrayList<com.jd.ad.sdk.jad_kx.jad_cp> arrayList = jad_fsVar.jad_an.get(str2);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(jad_cpVar);
                jad_fsVar.jad_an.put(str2, arrayList);
            }
        }
        if (jad_erVar.jad_jt) {
            com.jd.ad.sdk.jad_kx.jad_an jad_anVar = jad_erVar.jad_an;
            if (jad_anVar != null) {
                jad_anVar.jad_an(jad_cpVar);
            }
        } else {
            synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                String str3 = com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_preload_ad/update";
                try {
                    ContentResolver contentResolverJad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an();
                    if (contentResolverJad_an != null) {
                        contentResolverJad_an.update(Uri.parse(str3), com.jd.ad.sdk.jad_tg.jad_an.jad_an(jad_cpVar), null, null);
                    }
                } catch (Throwable th) {
                    Logger.w("Exception while saving preload ad data: ", th.getMessage());
                }
            }
        }
        if (jADSlot.getDynamicRenderTemplateHelper() != null) {
            jADSlot.getDynamicRenderTemplateHelper().jad_an(str);
            String strJad_cp = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an.jad_cp(str);
            String str4 = jADSlot.getDynamicRenderTemplateHelper().jad_cp;
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(strJad_cp)) {
                return;
            }
            try {
                Application applicationJad_an3 = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
                if (applicationJad_an3 != null && (mapJad_an = jad_jtVar.jad_an(new JSONObject(str4), strJad_cp)) != null && !mapJad_an.isEmpty()) {
                    Iterator<String> it = mapJad_an.keySet().iterator();
                    while (it.hasNext() && (jad_naVar = mapJad_an.get(it.next())) != null) {
                        com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(applicationJad_an3).jad_an(jad_naVar.jad_dq).jad_an(jad_ly.jad_bo).jad_bo(new jad_er(jad_jtVar)).jad_dq();
                    }
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        com.jd.ad.sdk.jad_na.jad_bo jad_boVar = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an;
        com.jd.ad.sdk.jad_yl.jad_cp jad_cpVarJad_an = jad_boVar.jad_an(str);
        if (jad_cpVarJad_an != null && jad_cpVarJad_an.jad_cp == 10005) {
            com.jd.ad.sdk.jad_yl.jad_fs jad_fsVarJad_dq = jad_boVar.jad_dq(str);
            List<com.jd.ad.sdk.jad_yl.jad_er> list = jad_fsVarJad_dq != null ? jad_fsVarJad_dq.jad_fs : null;
            if (list == null || list.size() != 3 || (applicationJad_an2 = com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) == null) {
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null && !TextUtils.isEmpty(list.get(i).jad_an)) {
                    com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(applicationJad_an2).jad_an(list.get(i).jad_an).jad_an(jad_ly.jad_bo).jad_bo(new jad_dq(jad_jtVar)).jad_dq();
                }
            }
            return;
        }
        String strJad_cp2 = jad_boVar.jad_cp(str);
        if (TextUtils.isEmpty(strJad_cp2) || (applicationJad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) == null) {
            return;
        }
        com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(applicationJad_an).jad_an(strJad_cp2).jad_an(jad_ly.jad_bo).jad_bo(new jad_cp(jad_jtVar)).jad_dq();
    }

    public static void jad_an(jad_jt jad_jtVar, String str, String str2) {
        com.jd.ad.sdk.jad_yl.jad_hu jad_huVar;
        List<com.jd.ad.sdk.jad_yl.jad_dq> list;
        com.jd.ad.sdk.jad_yl.jad_dq jad_dqVar;
        jad_jtVar.getClass();
        JADExtra jADExtra = new JADExtra();
        com.jd.ad.sdk.jad_yl.jad_jt jad_jtVarJad_an = null;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jad_jtVarJad_an = com.jd.ad.sdk.jad_yl.jad_jt.jad_an(str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jADExtra.setPrice((jad_jtVarJad_an == null || (jad_huVar = jad_jtVarJad_an.jad_cp) == null || (list = jad_huVar.jad_an) == null || list.isEmpty() || (jad_dqVar = list.get(0)) == null) ? 0.0d : jad_dqVar.jad_an);
        com.jd.ad.sdk.jad_na.jad_cp jad_cpVar = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an;
        jad_cpVar.jad_bo.put(str, jADExtra);
        jad_cpVar.jad_an.put(str, str2);
    }

    public static void jad_an(jad_jt jad_jtVar, JADAdLoadListener jADAdLoadListener, int i) {
        jad_jtVar.getClass();
        if (jADAdLoadListener == null) {
            return;
        }
        if (i == 2) {
            if (jad_jtVar.jad_an != 1) {
                jad_jtVar.jad_an = 2;
                jADAdLoadListener.onLoadSuccess();
                return;
            }
            return;
        }
        if (jad_jtVar.jad_an != 2) {
            jad_jtVar.jad_an = 1;
            jADAdLoadListener.onLoadSuccess();
        }
    }

    public final boolean jad_an(JADSlot jADSlot, JADAdLoadListener jADAdLoadListener) {
        int iRound;
        int iRound2;
        com.jd.ad.sdk.jad_wj.jad_an jad_anVar;
        if (TextUtils.isEmpty(jADSlot.getSlotID())) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String requestId = jADSlot.getRequestId();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_SLOT_ID_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(requestId, jad_anVar2.jad_an, jad_an(jADSlot.getSlotID(), jADSlot.getAdType(), jad_anVar2.jad_an(new String[0])));
            jad_an(jADAdLoadListener, jad_anVar2.jad_an, jad_anVar2.jad_an(new String[0]));
            return false;
        }
        if (jADSlot.getAdDataRequestSourceType() == 1) {
            com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
            if (jad_anVarJad_an != null && jad_anVarJad_an.jad_pc == 1) {
                JADEventService eventService2 = JADMediator.getInstance().getEventService();
                String requestId2 = jADSlot.getRequestId();
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_FORBID_PRELOAD_ERROR;
                eventService2.reportExceptionEvent(requestId2, jad_anVar3.jad_an, jad_anVar3.jad_an(new String[0]));
                Logger.d("preload 禁用预加载接口功能 - 中断网络请求");
                return false;
            }
            if (com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an.jad_bo(JADYunSdk.getAppId() + jADSlot.getSlotID())) {
                JADEventService eventService3 = JADMediator.getInstance().getEventService();
                String requestId3 = jADSlot.getRequestId();
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_PRELOAD_AD_DARA_EXCEEDED_UPPER_LIMIT_ERROR;
                eventService3.reportRequestErrorEvent(requestId3, jad_anVar4.jad_an, jad_an(jADSlot.getSlotID(), jADSlot.getAdType(), jad_anVar4.jad_an(new String[0])));
                jad_an(jADAdLoadListener, jad_anVar4.jad_an, jad_anVar4.jad_an(new String[0]));
                return false;
            }
        }
        int adType = jADSlot.getAdType();
        String slotID = jADSlot.getSlotID();
        boolean zIsFromNativeAd = jADSlot.isFromNativeAd();
        com.jd.ad.sdk.jad_ob.jad_dq jad_dqVar = com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an;
        boolean zJad_an = jad_dqVar.jad_an(jad_dqVar.jad_an(zIsFromNativeAd, adType), slotID);
        byte b = 2;
        if (zJad_an) {
            int adType2 = jADSlot.getAdType();
            boolean zIsFromNativeAd2 = jADSlot.isFromNativeAd();
            synchronized (this) {
                if (adType2 != 1) {
                    if (adType2 != 2) {
                        b = 4;
                        if (adType2 == 4) {
                            b = zIsFromNativeAd2 ? (byte) 7 : (byte) 3;
                        } else if (adType2 != 5) {
                            b = -1;
                        } else if (zIsFromNativeAd2) {
                            b = 8;
                        }
                    } else {
                        b = zIsFromNativeAd2 ? (byte) 9 : (byte) 5;
                    }
                } else if (zIsFromNativeAd2) {
                    b = 6;
                }
                try {
                    switch (b) {
                        case 2:
                            jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_TEMPLATE_SPLASH_FORBIDDEN_ERROR;
                            break;
                        case 3:
                            jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_TEMPLATE_INTERSTITIAL_FORBIDDEN_ERROR;
                            break;
                        case 4:
                            jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_TEMPLATE_BANNER_FORBIDDEN_ERROR;
                            break;
                        case 5:
                            jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_TEMPLATE_FEED_FORBIDDEN_ERROR;
                            break;
                        case 6:
                            jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_NATIVE_SPLASH_FORBIDDEN_ERROR;
                            break;
                        case 7:
                            jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_NATIVE_INTERSTITIAL_FORBIDDEN_ERROR;
                            break;
                        case 8:
                            jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_NATIVE_BANNER_FORBIDDEN_ERROR;
                            break;
                        case 9:
                            jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_NATIVE_FEED_FORBIDDEN_ERROR;
                            break;
                        default:
                            jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_FORBIDDEN_ERROR;
                            break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            JADMediator.getInstance().getEventService().reportRequestErrorEvent(jADSlot.getRequestId(), jad_anVar.jad_an, jad_an(jADSlot.getSlotID(), jADSlot.getAdType(), jad_anVar.jad_an(new String[0])));
            jad_an(jADAdLoadListener, jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
            return false;
        }
        JADPrivateController privateController = JADYunSdk.getPrivateController();
        if (privateController == null) {
            Logger.w("oaid获取不正常，请注意实现oaid接口", new Object[0]);
        } else if (TextUtils.isEmpty(privateController.getOaid())) {
            Logger.w("oaid获取不正常，请注意实现oaid接口", new Object[0]);
        } else {
            Logger.i("oaid获取正常", new Object[0]);
        }
        try {
            iRound = Math.round(jADSlot.getWidth());
            try {
                iRound2 = Math.round(jADSlot.getHeight());
                try {
                    if (jADSlot.isFromNativeAd()) {
                        iRound = Math.round(jADSlot.getAdImageWidth());
                        iRound2 = Math.round(jADSlot.getAdImageHeight());
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                iRound2 = 0;
            }
        } catch (Exception unused3) {
            iRound = 0;
            iRound2 = 0;
        }
        if (iRound > 0 && (jADSlot.getAdType() == 2 || iRound2 > 0)) {
            return true;
        }
        JADEventService eventService4 = JADMediator.getInstance().getEventService();
        String requestId4 = jADSlot.getRequestId();
        com.jd.ad.sdk.jad_wj.jad_an jad_anVar5 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_SIZE_ERROR;
        int i = jad_anVar5.jad_an;
        String slotID2 = jADSlot.getSlotID();
        int adType3 = jADSlot.getAdType();
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "pid", slotID2);
        JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, Integer.valueOf(adType3));
        JsonUtils.put(jSONObject, "plwd", Float.valueOf(iRound));
        JsonUtils.put(jSONObject, "plht", Float.valueOf(iRound2));
        JsonUtils.put(jSONObject, "error", jad_anVar5.jad_an(new String[0]));
        eventService4.reportRequestErrorEvent(requestId4, i, jSONObject.toString());
        jad_an(jADAdLoadListener, jad_anVar5.jad_an, jad_anVar5.jad_an("(" + iRound + " , " + iRound2 + ")"));
        return false;
    }

    public final Map<String, jad_na> jad_an(JSONObject jSONObject, String str) throws JSONException {
        int length;
        JSONArray jSONArray = jSONObject.getJSONArray("assets");
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            String strOptString = jSONObjectOptJSONObject.optString("p");
            String strOptString2 = jSONObjectOptJSONObject.optString("u");
            String strOptString3 = jSONObjectOptJSONObject.optString("id");
            int iOptInt = jSONObjectOptJSONObject.optInt(IAdInterListener.AdReqParam.WIDTH);
            int iOptInt2 = jSONObjectOptJSONObject.optInt(IAdInterListener.AdReqParam.HEIGHT);
            if (!TextUtils.isEmpty(strOptString)) {
                map.put(strOptString3, new jad_na(iOptInt, iOptInt2, strOptString3, strOptString.equals("${materialImage}") ? str : strOptString, strOptString2));
            }
        }
        return map;
    }

    public final String jad_an(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "pid", str);
        JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, Integer.valueOf(i));
        JsonUtils.put(jSONObject, "error", str2);
        return jSONObject.toString();
    }

    public final void jad_an(JADAdLoadListener jADAdLoadListener, int i, String str) {
        if (jADAdLoadListener == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        if (this.jad_an != 2) {
            jADAdLoadListener.onLoadFailure(i, str);
        }
    }
}
