package com.jd.ad.sdk.feed;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.cdo.oaps.ad.OapsKey;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: JADFeedRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_f_bo {
    public WeakReference<Context> jad_f_an;
    public final JADSlot jad_f_bo;
    public List<String> jad_f_cp;
    public String jad_f_dq;
    public String jad_f_er;
    public int jad_f_fs;
    public String jad_f_hu;
    public View jad_f_iv;
    public String jad_f_jt;
    public View.OnAttachStateChangeListener jad_f_jw;
    public jad_f_an jad_f_kx;

    /* JADX INFO: compiled from: JADFeedRender.java */
    public interface jad_f_an {
    }

    public jad_f_bo(Context context, JADSlot jADSlot, String str, List<String> list, String str2, String str3) {
        this.jad_f_cp = new ArrayList();
        this.jad_f_dq = "";
        this.jad_f_er = "";
        this.jad_f_fs = 0;
        this.jad_f_jt = "";
        this.jad_f_hu = "";
        if (context == null) {
            Logger.w("Context can not be null !!!", new Object[0]);
        } else {
            this.jad_f_an = new WeakReference<>(context);
        }
        this.jad_f_bo = jADSlot;
        if (jADSlot != null) {
            this.jad_f_er = jADSlot.getRequestId();
            this.jad_f_fs = jADSlot.getSen();
        }
        this.jad_f_dq = str;
        this.jad_f_cp = list;
        this.jad_f_jt = str2;
        this.jad_f_hu = str3;
    }

    public final Context jad_f_bo() {
        WeakReference<Context> weakReference = this.jad_f_an;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final String jad_f_cp() {
        List<String> list = this.jad_f_cp;
        return (list == null || list.isEmpty()) ? "" : this.jad_f_cp.get(0);
    }

    public final boolean jad_f_dq() {
        return this.jad_f_bo.getTemplateId() == CommonConstants.AdTmp.TEMPLATE_GROUP_IMAGE.getTemplateId();
    }

    public String jad_f_bo(String str) {
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.jad_f_bo;
        JsonUtils.put(jSONObject, "pid", jADSlot != null ? jADSlot.getSlotID() : "");
        JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, 2);
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    public final ImageView jad_f_an(String str) {
        View view = this.jad_f_iv;
        if (view == null) {
            return null;
        }
        try {
            return (ImageView) view.findViewById(ResourceUtils.getResourceId(view.getContext(), str, "id"));
        } catch (Exception e) {
            Logger.w("Exception while get image: " + e, new Object[0]);
            return null;
        }
    }

    public void jad_f_an() {
        try {
            View view = this.jad_f_iv;
            if (view != null) {
                View.OnAttachStateChangeListener onAttachStateChangeListener = this.jad_f_jw;
                if (onAttachStateChangeListener != null) {
                    view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
                    this.jad_f_jw = null;
                }
                JADMediator.getInstance().getExposureService().unregisterExposureView(this.jad_f_dq);
                JADMediator.getInstance().getTouchService().unregisterTouchView(this.jad_f_dq);
                this.jad_f_iv = null;
            }
            this.jad_f_kx = null;
        } catch (Exception e) {
            Logger.w(a.a("Exception while destroy: ").append(e.getMessage()).toString(), new Object[0]);
        }
    }

    public void jad_f_an(View view, boolean z, String str, int i) {
        jad_f_an jad_f_anVar = this.jad_f_kx;
        if (jad_f_anVar != null) {
            JADFeed.jad_f_dq jad_f_dqVar = (JADFeed.jad_f_dq) jad_f_anVar;
            if (z) {
                JADFeed.this.reportDelayExposureEvent(str, i);
                JADFeed.this.callbackAdShowedOnUiThread();
            } else {
                JADFeed.this.reportExposureEvent(str, i);
            }
        }
    }

    public void jad_f_an(int i, String str) {
        jad_f_an jad_f_anVar = this.jad_f_kx;
        if (jad_f_anVar != null) {
            JADFeed.this.callbackAdRenderFailedOnUiThread(i, str);
        }
    }

    public void jad_f_an(View view, int i) {
        JADMediator.getInstance().getExposureService().setViewForceExposure(this.jad_f_dq);
        jad_f_an jad_f_anVar = this.jad_f_kx;
        if (jad_f_anVar != null) {
            JADFeed.jad_f_dq jad_f_dqVar = (JADFeed.jad_f_dq) jad_f_anVar;
            JADFeed.this.reportCloseEvent(i);
            JADFeed.this.callbackAdCloseOnUiThread();
        }
    }
}
