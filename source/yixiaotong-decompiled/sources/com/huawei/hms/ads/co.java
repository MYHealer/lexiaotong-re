package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class co {
    private static final String Code = "ActivityStarter";
    private static final int I = 1;
    private static final String V = "com.huawei.hms.pps.action.PPS_DETAIL";

    private static String Code() {
        return Build.VERSION.SDK_INT == 26 ? com.huawei.openalliance.ad.constant.x.dd : com.huawei.openalliance.ad.constant.x.db;
    }

    public static void Code(Context context, View view, AdContentData adContentData) {
        fh.V(Code, "jump to domestic dsa activity.");
        if (context == null) {
            fh.I(Code, "context is null");
            return;
        }
        if (adContentData == null || !adContentData.aQ() || com.huawei.openalliance.ad.utils.bc.Code(adContentData.aP())) {
            fh.V(Code, "start domestic dsa activity failed, switch close or empty url.");
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        fh.V(Code, "startDomesticDsaActivity, anchorView.getLocationInWindow [x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
        V(context, view, iArr, adContentData);
    }

    public static void Code(Context context, View view, int[] iArr, AdContentData adContentData) {
        fh.V(Code, "jump to domestic dsa activity.");
        if (context == null) {
            fh.I(Code, "context is null");
        } else if (adContentData == null || !adContentData.aQ() || com.huawei.openalliance.ad.utils.bc.Code(adContentData.aP())) {
            fh.V(Code, "start domestic dsa activity failed, switch close or empty url.");
        } else {
            V(context, view, iArr, adContentData);
        }
    }

    private static void Code(Context context, AdContentData adContentData, Intent intent) {
        intent.putExtra("content_id", adContentData.a());
        intent.putExtra("sdk_version", "13.4.81.300");
        intent.putExtra("show_id", adContentData.D());
        intent.putExtra("request_id", adContentData.M());
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.A, context.getPackageName());
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.P, adContentData.at());
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.Q, adContentData.au());
        intent.putExtra("templateId", adContentData.aE());
        intent.putExtra("slotid", adContentData.L());
        intent.putExtra("apiVer", adContentData.aF());
    }

    private static void Code(Context context, AdContentData adContentData, ez ezVar, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            Code(adContentData, jSONObject);
            jSONObject.put(com.huawei.openalliance.ad.constant.bf.d, adContentData.x());
            jSONObject.put(com.huawei.openalliance.ad.constant.bf.k, adContentData.A());
            jSONObject.put("unique_id", adContentData.aa());
            jSONObject.put(com.huawei.openalliance.ad.constant.bf.ba, z);
            Code(jSONObject, ezVar);
            com.huawei.openalliance.ad.ipc.h.Code(context, adContentData.ap()).Code(com.huawei.openalliance.ad.constant.s.f4444a, jSONObject.toString(), null, null);
        } catch (JSONException e) {
            fh.I(Code, "startAdActivityViaAidl, e:" + e.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, AdContentData adContentData, ez ezVar, boolean z, boolean z2) {
        try {
            if (!(context instanceof Activity) || adContentData.ap()) {
                Code(context, adContentData, ezVar, z2);
                return;
            }
            fh.V(Code, "activity context");
            Intent intent = new Intent();
            intent.setAction(V);
            intent.setPackage(com.huawei.openalliance.ad.utils.z.Z(context));
            Code(context, adContentData, intent);
            intent.putExtra(com.huawei.openalliance.ad.constant.bf.d, adContentData.x());
            intent.putExtra(com.huawei.openalliance.ad.constant.bf.k, adContentData.A());
            intent.putExtra("unique_id", adContentData.aa());
            intent.putExtra(com.huawei.openalliance.ad.constant.bf.ba, z2);
            Code(intent, adContentData);
            Code(intent, ezVar);
            if (z) {
                intent.addFlags(268959744);
            }
            intent.setClipData(com.huawei.openalliance.ad.constant.x.cU);
            ((Activity) context).startActivityForResult(intent, 1);
        } catch (Throwable th) {
            fh.Code(3, th);
            fh.V(Code, "startAdActivity error, %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, AdContentData adContentData, MaterialClickInfo materialClickInfo) {
        fh.V(Code, "jump to landing details start.");
        if (context == null) {
            fh.I(Code, "context is null");
            return;
        }
        if (adContentData == null || adContentData.y() == null || TextUtils.isEmpty(adContentData.y().u())) {
            fh.V(Code, "jump to landing details detailUrl is empty.");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.putExtra("content_id", adContentData.a());
            intent.putExtra("templateId", adContentData.aE());
            intent.putExtra("slotid", adContentData.L());
            intent.putExtra("apiVer", adContentData.aF());
            intent.putExtra(com.huawei.openalliance.ad.constant.bf.A, context.getPackageName());
            intent.putExtra("show_id", adContentData.D());
            intent.putExtra("request_id", adContentData.M());
            Code(intent, adContentData);
            if (materialClickInfo != null && com.huawei.openalliance.ad.utils.bc.L(materialClickInfo.I()) && materialClickInfo.Code() != null) {
                intent.putExtra("click_info", com.huawei.openalliance.ad.utils.ad.V(materialClickInfo));
            }
            intent.setAction(Code());
            intent.setPackage(com.huawei.openalliance.ad.utils.z.Z(context));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.huawei.openalliance.ad.inter.data.AppInfo appInfoY = adContentData.y();
            if (appInfoY != null) {
                intent.putExtra("unique_id", appInfoY.e());
            }
            com.huawei.openalliance.ad.utils.bg.Code(context, intent);
        } catch (Throwable th) {
            fh.Z(Code, "start ac failed: %s", th.getClass().getSimpleName());
        }
    }

    private static void Code(Intent intent, ez ezVar) {
        fh.Code(Code, "parseLinkedAdConfig");
        if (intent == null || ezVar == null) {
            return;
        }
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.p, ezVar.C());
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.m, ezVar.S());
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.q, ezVar.Code());
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.aV, ezVar.V());
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.s, ezVar.Z());
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.r, ezVar.I());
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.aO, ezVar.D());
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.aP, ezVar.L());
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.aQ, ezVar.F());
        intent.putExtra("videoAutoPlay", ezVar.b());
        intent.putExtra("videoPlaySound", ezVar.c());
        if (ezVar.a() != null) {
            intent.putExtra(com.huawei.openalliance.ad.constant.bf.n, ezVar.a().getAutoPlayNetwork());
            intent.putExtra(com.huawei.openalliance.ad.constant.bf.o, ezVar.a().isStartMuted());
        }
    }

    private static void Code(Intent intent, AdContentData adContentData) {
        ApkInfo apkInfoE;
        MetaData metaDataS = adContentData.S();
        if (metaDataS == null || (apkInfoE = metaDataS.e()) == null) {
            return;
        }
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.aM, com.huawei.openalliance.ad.utils.bc.V(apkInfoE.p()));
        intent.putExtra(com.huawei.openalliance.ad.constant.bf.aN, com.huawei.openalliance.ad.utils.bc.V(apkInfoE.q()));
    }

    private static void Code(Intent intent, JSONObject jSONObject, Map<String, String> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return;
        }
        String strV = com.huawei.openalliance.ad.utils.ad.V(map);
        if (com.huawei.openalliance.ad.utils.bc.Code(strV)) {
            return;
        }
        if (z) {
            intent.putExtra(com.huawei.openalliance.ad.constant.bf.R, strV);
            return;
        }
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.bf.R, strV);
        } catch (JSONException e) {
            fh.Z(Code, "set ar linked params error," + e.getClass().getSimpleName());
        }
    }

    private static void Code(AdContentData adContentData, JSONObject jSONObject) throws JSONException {
        jSONObject.put("content_id", adContentData.a());
        jSONObject.put("sdk_version", "13.4.81.300");
        jSONObject.put("show_id", adContentData.D());
        jSONObject.put("request_id", adContentData.M());
        jSONObject.put(com.huawei.openalliance.ad.constant.bf.P, adContentData.at());
        jSONObject.put(com.huawei.openalliance.ad.constant.bf.Q, adContentData.au());
        jSONObject.put("templateId", adContentData.aE());
        jSONObject.put("slotid", adContentData.L());
        jSONObject.put("apiVer", adContentData.aF());
    }

    public static void Code(JSONObject jSONObject, ez ezVar) {
        if (jSONObject == null || ezVar == null) {
            return;
        }
        fh.Code(Code, "parseLinkedAdConfigViaAid");
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.bf.p, ezVar.C());
            jSONObject.put(com.huawei.openalliance.ad.constant.bf.m, ezVar.S());
            jSONObject.put(com.huawei.openalliance.ad.constant.bf.q, ezVar.Code());
            jSONObject.put(com.huawei.openalliance.ad.constant.bf.s, ezVar.Z());
            jSONObject.put(com.huawei.openalliance.ad.constant.bf.r, ezVar.I());
        } catch (JSONException e) {
            fh.I(Code, "startAdActivityViaAidl, e:" + e.getClass().getSimpleName());
        }
    }

    public static boolean Code(Context context, String str) {
        fh.V(Code, "startTransparencyActivity");
        if (context == null || TextUtils.isEmpty(str)) {
            fh.I(Code, "param is null");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.huawei.openalliance.ad.constant.bf.aw, str);
            com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.E, jSONObject.toString(), null, null);
            return true;
        } catch (JSONException e) {
            fh.I(Code, "startTransparencyActivity, ex:" + e.getClass().getSimpleName());
            return true;
        }
    }

    private static void V(Context context, View view, int[] iArr, AdContentData adContentData) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new com.huawei.openalliance.ad.activity.a.ViewTreeObserverOnGlobalLayoutListenerC0530a(view, context, iArr2));
        int[] iArr3 = {view.getMeasuredWidth(), view.getMeasuredHeight()};
        try {
            Intent intent = new Intent();
            intent.setAction(com.huawei.openalliance.ad.constant.x.dc);
            intent.setPackage(com.huawei.openalliance.ad.utils.z.Z(context));
            intent.putExtra(com.huawei.openalliance.ad.constant.bf.au, com.huawei.openalliance.ad.utils.ad.V(adContentData));
            intent.putExtra(com.huawei.openalliance.ad.constant.bf.av, iArr);
            intent.putExtra(com.huawei.openalliance.ad.constant.bf.ay, iArr3);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.huawei.openalliance.ad.utils.bg.Code(context, intent);
        } catch (Throwable th) {
            fh.Z(Code, "start ac failed: %s", th.getClass().getSimpleName());
        }
    }
}
