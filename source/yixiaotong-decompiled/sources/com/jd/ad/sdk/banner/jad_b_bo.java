package com.jd.ad.sdk.banner;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import com.cdo.oaps.ad.OapsKey;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: JADBannerRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_b_bo {
    public WeakReference<Context> jad_b_an;
    public final JADSlot jad_b_bo;
    public String jad_b_cp;
    public String jad_b_dq;
    public String jad_b_er;
    public int jad_b_fs;
    public Drawable jad_b_hu;
    public InterfaceC0545jad_b_bo jad_b_iv;
    public View jad_b_jt;

    /* JADX INFO: compiled from: JADBannerRender.java */
    public class jad_b_an implements OnImageLoadListener {
        public final /* synthetic */ ValueCallback jad_b_an;

        public jad_b_an(ValueCallback valueCallback) {
            this.jad_b_an = valueCallback;
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadFailed(int i, String str, Drawable drawable) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String str2 = jad_b_bo.this.jad_b_er;
            JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
            eventService.reportRenderFailedEvent(str2, jADError.getCode(), jad_b_bo.this.jad_b_an(jADError.getMessage(new String[0])), jad_b_bo.this.jad_b_fs);
            jad_b_bo.this.jad_b_an(jADError.getCode(), jADError.getMessage(new String[0]));
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadSuccess(Drawable drawable) {
            JADBanner.jad_b_jw jad_b_jwVar;
            WeakReference<JADBanner> weakReference;
            ValueCallback valueCallback = this.jad_b_an;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(drawable);
            }
            jad_b_bo jad_b_boVar = jad_b_bo.this;
            View view = jad_b_boVar.jad_b_jt;
            InterfaceC0545jad_b_bo interfaceC0545jad_b_bo = jad_b_boVar.jad_b_iv;
            if (interfaceC0545jad_b_bo == null || (weakReference = (jad_b_jwVar = (JADBanner.jad_b_jw) interfaceC0545jad_b_bo).jad_b_an) == null || weakReference.get() == null) {
                return;
            }
            jad_b_jwVar.jad_b_an.get().callbackAdReadyOnUiThread(view);
        }
    }

    /* JADX INFO: renamed from: com.jd.ad.sdk.banner.jad_b_bo$jad_b_bo, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JADBannerRender.java */
    public interface InterfaceC0545jad_b_bo {
    }

    public jad_b_bo(Context context, JADSlot jADSlot, String str, String str2) {
        this.jad_b_cp = "";
        this.jad_b_dq = "";
        this.jad_b_er = "";
        this.jad_b_fs = 0;
        if (context == null) {
            Logger.w("Context can not be null !!!", new Object[0]);
        } else {
            this.jad_b_an = new WeakReference<>(context);
            if (context instanceof Activity) {
                context.hashCode();
            }
        }
        this.jad_b_bo = jADSlot;
        if (jADSlot != null) {
            this.jad_b_er = jADSlot.getRequestId();
            this.jad_b_fs = jADSlot.getSen();
        }
        this.jad_b_dq = str;
        this.jad_b_cp = str2;
    }

    public final Context jad_b_bo() {
        WeakReference<Context> weakReference = this.jad_b_an;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void jad_b_an() {
        if (this.jad_b_jt != null) {
            JADMediator.getInstance().getExposureService().unregisterExposureView(this.jad_b_dq);
            this.jad_b_jt = null;
        }
        this.jad_b_iv = null;
    }

    public void jad_b_an(View view, boolean z, String str, int i) {
        JADBanner.jad_b_jw jad_b_jwVar;
        WeakReference<JADBanner> weakReference;
        InterfaceC0545jad_b_bo interfaceC0545jad_b_bo = this.jad_b_iv;
        if (interfaceC0545jad_b_bo == null || (weakReference = (jad_b_jwVar = (JADBanner.jad_b_jw) interfaceC0545jad_b_bo).jad_b_an) == null || weakReference.get() == null) {
            return;
        }
        JADBanner jADBanner = jad_b_jwVar.jad_b_an.get();
        if (z) {
            jADBanner.reportDelayExposureEvent(str, i);
            jADBanner.callbackAdShowedOnUiThread();
        } else {
            jADBanner.reportExposureEvent(str, i);
        }
    }

    public void jad_b_an(int i, String str) {
        JADBanner.jad_b_jw jad_b_jwVar;
        WeakReference<JADBanner> weakReference;
        InterfaceC0545jad_b_bo interfaceC0545jad_b_bo = this.jad_b_iv;
        if (interfaceC0545jad_b_bo == null || (weakReference = (jad_b_jwVar = (JADBanner.jad_b_jw) interfaceC0545jad_b_bo).jad_b_an) == null || weakReference.get() == null) {
            return;
        }
        jad_b_jwVar.jad_b_an.get().callbackAdRenderFailedOnUiThread(i, str);
    }

    public void jad_b_an(View view, int i) {
        JADBanner.jad_b_jw jad_b_jwVar;
        WeakReference<JADBanner> weakReference;
        if (this.jad_b_jt != null) {
            JADMediator.getInstance().getExposureService().setViewForceExposure(this.jad_b_dq);
        }
        InterfaceC0545jad_b_bo interfaceC0545jad_b_bo = this.jad_b_iv;
        if (interfaceC0545jad_b_bo == null || (weakReference = (jad_b_jwVar = (JADBanner.jad_b_jw) interfaceC0545jad_b_bo).jad_b_an) == null || weakReference.get() == null) {
            return;
        }
        JADBanner jADBanner = jad_b_jwVar.jad_b_an.get();
        jADBanner.reportCloseEvent(i);
        jADBanner.callbackAdCloseOnUiThread();
        jADBanner.destroy();
    }

    public final void jad_b_an(ValueCallback<Drawable> valueCallback) {
        if (jad_b_bo() == null) {
            return;
        }
        if (TextUtils.isEmpty(this.jad_b_cp)) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String str = this.jad_b_er;
            JADError jADError = JADError.RENDER_IMAGE_URL_IS_NULL_ERROR;
            eventService.reportRenderFailedEvent(str, jADError.getCode(), jad_b_an(jADError.getMessage(new String[0])), this.jad_b_fs);
            jad_b_an(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        JADMediator.getInstance().getFoundationService().loadImage(jad_b_bo(), this.jad_b_cp, new jad_b_an(valueCallback));
    }

    public String jad_b_an(String str) {
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.jad_b_bo;
        JsonUtils.put(jSONObject, "pid", jADSlot != null ? jADSlot.getSlotID() : "");
        JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, 5);
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }
}
