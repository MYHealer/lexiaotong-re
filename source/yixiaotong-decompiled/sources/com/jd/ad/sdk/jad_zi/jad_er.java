package com.jd.ad.sdk.jad_zi;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.x;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADDynamicRenderService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JADDynamicRenderServiceImplementor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er implements JADDynamicRenderService {
    @Override // com.jd.ad.sdk.mdt.service.JADDynamicRenderService
    public DynamicRenderView createDynamicView(Context context, String str, JADSlot jADSlot, DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback) throws JSONException {
        JADMaterialData jADMaterialData;
        List<String> imageUrls;
        try {
            String str2 = jADSlot.getDynamicRenderTemplateHelper().jad_cp;
            if (TextUtils.isEmpty(str2)) {
                throw new Exception("dynamic render templateJSON is null");
            }
            int iDip2px = (int) ScreenUtils.dip2px(context, jADSlot.getWidth());
            int iDip2px2 = (int) ScreenUtils.dip2px(context, jADSlot.getHeight());
            ArrayList arrayList = new ArrayList(Arrays.asList("sdkSkipButton", "sdkSkipArea", "sdkLogo", "sdkStaticSkipButton"));
            ArrayList arrayList2 = new ArrayList(Arrays.asList("sdkLimitClickArea", "sdkSkipInformation", "sdkInteractiveShake", "sdkLimitSlideArea"));
            ArrayList arrayList3 = new ArrayList();
            if (jADSlot.isHideSkip()) {
                arrayList3.add("sdkStaticSkipButton");
                arrayList3.add("sdkSkipButton");
                arrayList3.add("sdkSkipArea");
            }
            if (!jADSlot.isHideSkip() && jADSlot.getSkipTime() <= 5) {
                arrayList3.add("sdkStaticSkipButton");
            }
            List<JADMaterialData> jADMaterialDataList = JADMediator.getInstance().getAdService().getJADMaterialDataList(str);
            if (jADMaterialDataList != null && jADMaterialDataList.size() > 0 && (jADMaterialData = JADMediator.getInstance().getAdService().getJADMaterialDataList(str).get(0)) != null && (imageUrls = jADMaterialData.getImageUrls()) != null && imageUrls.size() > 0) {
                String str3 = imageUrls.get(0);
                if (TextUtils.isEmpty(str3)) {
                    return null;
                }
                String str4 = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an.jad_an.get(str);
                if (TextUtils.isEmpty(str4)) {
                    str4 = "";
                }
                com.jd.ad.sdk.jad_na.jad_bo jad_boVar = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an;
                com.jd.ad.sdk.jad_yl.jad_fs jad_fsVarJad_dq = jad_boVar.jad_dq(str4);
                int i = jad_fsVarJad_dq == null ? 0 : jad_fsVarJad_dq.jad_jt;
                com.jd.ad.sdk.jad_yl.jad_fs jad_fsVarJad_dq2 = jad_boVar.jad_dq(str4);
                int i2 = jad_fsVarJad_dq2 == null ? 0 : jad_fsVarJad_dq2.jad_hu;
                DynamicRenderView.jad_fs jad_fsVar = new DynamicRenderView.jad_fs();
                jad_fsVar.jad_bo = iDip2px;
                jad_fsVar.jad_cp = iDip2px2;
                jad_fsVar.jad_jw = str3;
                jad_fsVar.jad_kx = i;
                jad_fsVar.jad_ly = i2;
                jad_fsVar.jad_mz = jADSlot.getSkipTime();
                jad_fsVar.jad_dq = arrayList;
                jad_fsVar.jad_er = arrayList2;
                jad_fsVar.jad_fs = arrayList3;
                jad_fsVar.jad_an = str2;
                jad_fsVar.jad_jt = iDynamicRenderCallback;
                jad_fsVar.jad_hu = jADSlot.getEventInteractionType();
                jad_fsVar.jad_iv = jADSlot.getModelClickAreaType();
                DynamicRenderView dynamicRenderView = new DynamicRenderView(context, jad_fsVar);
                Exception loadImagesException = dynamicRenderView.getLoadImagesException();
                if (loadImagesException != null) {
                    throw loadImagesException;
                }
                Exception dynamicInitException = dynamicRenderView.getDynamicInitException();
                if (dynamicInitException == null) {
                    return dynamicRenderView;
                }
                throw dynamicInitException;
            }
            return null;
        } catch (Throwable th) {
            int sen = jADSlot != null ? jADSlot.getSen() : 0;
            Exception exc = new Exception("dynamic render view init error", th);
            JSONObject jSONObject = new JSONObject();
            String message = exc.getMessage();
            int code = JADError.RENDER_DYNAMIC_VIEW_INIT_OTHER_ERROR.getCode();
            try {
                try {
                    for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
                        String message2 = cause.getMessage();
                        if (TextUtils.isEmpty(message2) || !message2.startsWith(BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER)) {
                            message = message + "|" + message2;
                        } else {
                            String[] strArrSplit = message2.split(x.A);
                            code = Integer.parseInt(strArrSplit[0]);
                            message = message + "|" + strArrSplit[1];
                        }
                    }
                    jSONObject.put("code", code);
                    jSONObject.put("msg", message);
                } catch (Exception unused) {
                    Logger.d("错误信息拼接异常");
                    jSONObject.put("code", code);
                    jSONObject.put("msg", message);
                }
                int iOptInt = jSONObject.optInt("code");
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", 5, iOptInt, jSONObject.optString("msg"), sen);
                Logger.w(iOptInt + ": dynamic render view error：" + Log.getStackTraceString(exc), new Object[0]);
                return null;
            } catch (Throwable th2) {
                jSONObject.put("code", code);
                jSONObject.put("msg", message);
                throw th2;
            }
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADDynamicRenderService
    public void registerAdViewClick(Context context, DynamicRenderView dynamicRenderView, IDynamicInteractionListener iDynamicInteractionListener) throws Exception {
        dynamicRenderView.jad_an("sdkSkipArea", new jad_cp(this, "sdkSkipArea", iDynamicInteractionListener));
        int adAnimationType = dynamicRenderView.getAdAnimationType();
        String str = adAnimationType == 1 ? "sdkMaterialImage" : "sdkLimitClickArea";
        if (adAnimationType == 3) {
            str = "sdkLimitSlideArea";
        }
        if (adAnimationType == 2) {
            str = "sdkInteractiveShake";
        }
        jad_dq jad_dqVar = new jad_dq(this, str, str, adAnimationType, iDynamicInteractionListener);
        dynamicRenderView.jad_xk = str;
        dynamicRenderView.jad_an(str, jad_dqVar);
    }
}
