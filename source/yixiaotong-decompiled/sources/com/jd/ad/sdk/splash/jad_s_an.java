package com.jd.ad.sdk.splash;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.constant.x;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.jad_s_an.jad_s_hu;
import com.jd.ad.sdk.jad_s_an.jad_s_iv;
import com.jd.ad.sdk.jad_s_an.jad_s_jt;
import com.jd.ad.sdk.jad_s_an.jad_s_jw;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JADSplashRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_s_an implements DynamicRenderView.IDynamicRenderCallback {
    public WeakReference<Context> jad_s_an;
    public final JADSlot jad_s_bo;
    public String jad_s_cp;
    public String jad_s_dq;
    public String jad_s_er;
    public int jad_s_fs;
    public jad_s_cp jad_s_hu;
    public View jad_s_iv;
    public View jad_s_jt;
    public int jad_s_jw;
    public JADSplashSkipView jad_s_kx;
    public JADSplashCountDownListener jad_s_ly;
    public JADSplashVideoListener jad_s_mz;
    public boolean jad_s_na;
    public boolean jad_s_ob;
    public jad_s_jw jad_s_pc;
    public int jad_s_re;
    public int jad_s_sf;
    public int jad_s_tg;
    public long jad_s_qd = 0;
    public OnVideoRenderListener jad_s_uh = null;
    public VideoLoadListener jad_s_vi = null;

    /* JADX INFO: renamed from: com.jd.ad.sdk.splash.jad_s_an$jad_s_an, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JADSplashRender.java */
    public class C0589jad_s_an implements OnImageLoadListener {
        public final /* synthetic */ ImageView jad_s_an;
        public final /* synthetic */ View jad_s_bo;

        public C0589jad_s_an(ImageView imageView, View view) {
            this.jad_s_an = imageView;
            this.jad_s_bo = view;
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadFailed(int i, String str, Drawable drawable) {
            jad_s_an jad_s_anVar = jad_s_an.this;
            JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_an.this.jad_s_er, jADError.getCode(), jad_s_anVar.jad_s_an(jADError.getMessage(new String[0])), jad_s_an.this.jad_s_fs);
            jad_s_an.jad_s_an(jad_s_an.this, jADError.getCode(), jADError.getMessage(new String[0]));
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadSuccess(Drawable drawable) {
            ImageView imageView = this.jad_s_an;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
            jad_s_an.this.jad_s_an(this.jad_s_bo, 1);
        }
    }

    /* JADX INFO: compiled from: JADSplashRender.java */
    public class jad_s_bo implements View.OnTouchListener {
        public jad_s_bo(jad_s_an jad_s_anVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: compiled from: JADSplashRender.java */
    public interface jad_s_cp {
    }

    public jad_s_an(Context context, JADSlot jADSlot, String str, String str2) {
        this.jad_s_cp = "";
        this.jad_s_dq = "";
        this.jad_s_er = "";
        this.jad_s_fs = 0;
        if (context == null) {
            Logger.w("Context can not be null !!!", new Object[0]);
        } else {
            this.jad_s_an = new WeakReference<>(context);
        }
        this.jad_s_bo = jADSlot;
        if (jADSlot != null) {
            this.jad_s_er = jADSlot.getRequestId();
            this.jad_s_fs = jADSlot.getSen();
        }
        this.jad_s_dq = str;
        this.jad_s_cp = str2;
    }

    public static void jad_s_an(jad_s_an jad_s_anVar, View view) {
        jad_s_anVar.getClass();
        JADMediator.getInstance().getExposureService().setViewForceExposure(jad_s_anVar.jad_s_dq);
        jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.jad_s_er jad_s_erVar = (JADSplash.jad_s_er) jad_s_cpVar;
            JADSplash.this.reportCloseEvent(CommonConstants.ClickFrom.CLOSE.ordinal());
            if (view != null) {
                JADSplash.this.callbackAdCloseOnUiThread();
            }
        }
    }

    public void jad_s_bo(int i, String str) {
        try {
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, i, jad_s_an(str), this.jad_s_fs);
            jad_s_cp jad_s_cpVar = this.jad_s_hu;
            if (jad_s_cpVar != null) {
                JADSplash.this.callbackAdRenderFailedOnUiThread(i, str);
            }
        } catch (Exception e) {
            Logger.d(Log.getStackTraceString(e));
        }
    }

    public DynamicRenderView jad_s_cp() {
        View view = this.jad_s_jt;
        if (view == null || !(view instanceof DynamicRenderView)) {
            return null;
        }
        return (DynamicRenderView) view;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public void onDynamicRenderFailed(int i, String str) {
        if (jad_s_an() == null) {
            JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, jADError.getCode(), jad_s_an(jADError.getMessage(new String[0])), this.jad_s_fs);
            jad_s_an(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        Context contextJad_s_an = jad_s_an();
        JADError jADError2 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
        int code = jADError2.getCode();
        String message = jADError2.getMessage(new String[0]);
        if (contextJad_s_an == null || this.jad_s_bo == null) {
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, code, message, this.jad_s_fs);
            jad_s_an(code, message);
        }
        this.jad_s_bo.setRem(1);
        int templateId = this.jad_s_bo.getTemplateId();
        View viewInflate = null;
        if (templateId == CommonConstants.AdTmp.TEMPLATE_SPLASH_SINGLE_IMAGE_4.getTemplateId() || templateId == CommonConstants.AdTmp.TEMPLATE_SPLASH_SINGLE_IMAGE_8.getTemplateId()) {
            try {
                viewInflate = LayoutInflater.from(contextJad_s_an).inflate(ResourceUtils.getResourceId(contextJad_s_an, "jad_splash_layout", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
            } catch (Exception e) {
                Logger.w("Exception while render: " + e, new Object[0]);
            }
        } else {
            JADError jADError3 = JADError.RENDER_SPLASH_RESPONSE_TEMPLATE_ID_ERROR;
            code = jADError3.getCode();
            message = jADError3.getMessage(new String[0]);
        }
        if (viewInflate == null) {
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, code, message, this.jad_s_fs);
            jad_s_an(code, message);
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
        int iDip2px = (int) ScreenUtils.dip2px(contextJad_s_an, this.jad_s_bo.getWidth());
        int iDip2px2 = (int) ScreenUtils.dip2px(contextJad_s_an, this.jad_s_bo.getHeight());
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(iDip2px, iDip2px2);
        } else {
            layoutParams.height = iDip2px2;
            layoutParams.width = iDip2px;
        }
        viewInflate.setLayoutParams(layoutParams);
        try {
            this.jad_s_kx = (JADSplashSkipView) viewInflate.findViewById(ResourceUtils.getResourceId(contextJad_s_an, "jad_splash_skip_btn", "id"));
        } catch (Exception e2) {
            Logger.d("Exception while render: " + e2);
        }
        if (this.jad_s_kx != null) {
            if (this.jad_s_bo.isHideSkip()) {
                this.jad_s_kx.setVisibility(8);
            } else {
                this.jad_s_kx.setVisibility(0);
            }
            JADSplashSkipView jADSplashSkipView = this.jad_s_kx;
            int skipTime = this.jad_s_bo.getSkipTime();
            com.jd.ad.sdk.splash.jad_s_cp jad_s_cpVar = new com.jd.ad.sdk.splash.jad_s_cp(this);
            jADSplashSkipView.jad_s_an = skipTime;
            jADSplashSkipView.jad_s_bo = jad_s_cpVar;
            jADSplashSkipView.setOnClickListener(new jad_s_er(jADSplashSkipView));
        }
        try {
            ImageView imageView = (ImageView) viewInflate.findViewById(ResourceUtils.getResourceId(jad_s_an(), "jad_splash_image", "id"));
            jad_s_an(imageView, viewInflate);
            jad_s_an(jad_s_an(), viewInflate, imageView);
        } catch (Exception e3) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String str2 = this.jad_s_er;
            JADError jADError4 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService.reportRenderFailedEvent(str2, jADError4.getCode(), jADError4.getMessage(e3.toString()), this.jad_s_fs);
            jad_s_an(jADError4.getCode(), jADError4.getMessage(e3.toString()));
        }
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public void onDynamicRenderSuccess(View view) {
        try {
            JADError jADError = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            int code = jADError.getCode();
            String message = jADError.getMessage(new String[0]);
            if (view != null && this.jad_s_bo != null) {
                this.jad_s_iv = view;
                jad_s_an(view, 3);
                return;
            }
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, code, message, this.jad_s_fs);
            jad_s_an(code, message);
        } catch (Exception e) {
            JADError jADError2 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            jad_s_an(jADError2.getCode(), jADError2.getMessage(e.toString()));
        }
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public void onAnimationEnd() {
        jad_s_cp jad_s_cpVar = this.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.jad_s_er jad_s_erVar = (JADSplash.jad_s_er) jad_s_cpVar;
            JADSplash.this.callbackAdCloseOnUiThread();
            JADSplash.this.destroy();
        }
    }

    public final FrameLayout.LayoutParams jad_s_bo() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    public static float jad_s_an(jad_s_an jad_s_anVar, float f) {
        jad_s_anVar.getClass();
        StringBuilder sbAppend = new StringBuilder("xlog--transferDuration:").append(f).append(",result: ");
        float f2 = f / 1000.0f;
        Logger.d(sbAppend.append(f2).toString());
        return f2;
    }

    public final Context jad_s_an() {
        WeakReference<Context> weakReference = this.jad_s_an;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public JSONObject jad_s_an(Exception exc) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String message = exc.getMessage();
        int code = JADError.RENDER_DYNAMIC_VIEW_INIT_OTHER_ERROR.getCode();
        try {
            for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
                String message2 = cause.getMessage();
                if (!TextUtils.isEmpty(message2) && message2.startsWith(BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER)) {
                    String[] strArrSplit = message2.split(x.A);
                    code = Integer.parseInt(strArrSplit[0]);
                    message = message + "|" + strArrSplit[1];
                } else {
                    message = message + "|" + message2;
                }
            }
        } catch (Exception unused) {
            Logger.d("错误信息拼接异常");
        } finally {
            jSONObject.put("code", code);
            jSONObject.put("msg", message);
        }
        return jSONObject;
    }

    public String jad_s_an(String str) {
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.jad_s_bo;
        JsonUtils.put(jSONObject, "pid", jADSlot != null ? jADSlot.getSlotID() : "");
        JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, 1);
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    public final void jad_s_an(Context context, View view, ImageView imageView) {
        int i;
        if (context == null || this.jad_s_bo == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(ResourceUtils.getResourceId(jad_s_an(), "jad_splash_click_area_container", "id"));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        int modelClickAreaType = this.jad_s_bo.getModelClickAreaType();
        if (modelClickAreaType == 1) {
            i = 2;
        } else if (modelClickAreaType == 2) {
            i = 3;
        } else if (modelClickAreaType == 3) {
            i = 4;
        } else {
            i = modelClickAreaType == 4 ? 5 : 1;
        }
        int iJad_s_an = jad_s_iv.jad_s_an(i);
        if (iJad_s_an == 1) {
            frameLayout.addView(layoutInflaterFrom.inflate(ResourceUtils.getResourceId(context, "jad_splash_click_area_type1", TtmlNode.TAG_LAYOUT), (ViewGroup) null), jad_s_bo());
            frameLayout.setVisibility(0);
            this.jad_s_iv = view;
            this.jad_s_jw = 1;
            return;
        }
        if (iJad_s_an == 3) {
            frameLayout.setVisibility(8);
            this.jad_s_iv = view;
            this.jad_s_jw = 3;
        } else {
            if (iJad_s_an != 4) {
                View viewInflate = layoutInflaterFrom.inflate(ResourceUtils.getResourceId(context, "jad_splash_click_area_type2", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                imageView.setOnTouchListener(new jad_s_bo(this));
                frameLayout.addView(viewInflate, jad_s_bo());
                frameLayout.setVisibility(0);
                this.jad_s_iv = viewInflate;
                this.jad_s_jw = 2;
                return;
            }
            frameLayout.addView(layoutInflaterFrom.inflate(ResourceUtils.getResourceId(context, "jad_splash_click_area_type2", TtmlNode.TAG_LAYOUT), (ViewGroup) null), jad_s_bo());
            frameLayout.setVisibility(0);
            this.jad_s_iv = view;
            this.jad_s_jw = 4;
        }
    }

    public final void jad_s_an(ImageView imageView, View view) {
        if (jad_s_an() != null) {
            if (TextUtils.isEmpty(this.jad_s_cp)) {
                JADEventService eventService = JADMediator.getInstance().getEventService();
                String str = this.jad_s_er;
                JADError jADError = JADError.RENDER_IMAGE_URL_IS_NULL_ERROR;
                eventService.reportRenderFailedEvent(str, jADError.getCode(), jad_s_an(jADError.getMessage(new String[0])), this.jad_s_fs);
                jad_s_an(jADError.getCode(), jADError.getMessage(new String[0]));
                return;
            }
            JADMediator.getInstance().getFoundationService().loadImage(jad_s_an(), this.jad_s_cp, new C0589jad_s_an(imageView, view));
            return;
        }
        JADEventService eventService2 = JADMediator.getInstance().getEventService();
        String str2 = this.jad_s_er;
        JADError jADError2 = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
        eventService2.reportRenderFailedEvent(str2, jADError2.getCode(), jad_s_an(jADError2.getMessage(new String[0])), this.jad_s_fs);
        jad_s_an(jADError2.getCode(), jADError2.getMessage(new String[0]));
    }

    public static void jad_s_an(jad_s_an jad_s_anVar, Context context, View view, int i, int i2, int i3) {
        jad_s_anVar.jad_s_tg = i;
        jad_s_anVar.jad_s_re = i2;
        jad_s_anVar.jad_s_sf = i3;
        if (jad_s_anVar.jad_s_jt != null) {
            JADMediator.getInstance().getExposureService().setViewForceExposure(jad_s_anVar.jad_s_dq);
        }
        int iOnViewClicked = JADMediator.getInstance().getTouchService().onViewClicked(context, view, jad_s_anVar.jad_s_dq, new com.jd.ad.sdk.splash.jad_s_bo(jad_s_anVar));
        jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.jad_s_er jad_s_erVar = (JADSplash.jad_s_er) jad_s_cpVar;
            JADSplash.this.reportClickEvent(iOnViewClicked, i, i2, i3);
            JADSplash.this.callbackAdClickOnUiThread();
        }
    }

    public static void jad_s_an(jad_s_an jad_s_anVar, View view, boolean z, String str, int i, int i2) {
        jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.jad_s_er jad_s_erVar = (JADSplash.jad_s_er) jad_s_cpVar;
            JADSplash.this.calculateClickArea();
            if (z) {
                JADSplash.this.reportDelayExposureEvent(str, i, i2);
                JADSplash.this.callbackAdShowedOnUiThread();
            } else {
                JADSplash.this.reportExposureEvent(str, i, i2);
            }
        }
    }

    public static void jad_s_an(jad_s_an jad_s_anVar) {
        jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.jad_s_er jad_s_erVar = (JADSplash.jad_s_er) jad_s_cpVar;
            JADSplash.this.callbackAdCloseOnUiThread();
            JADSplash.this.destroy();
        }
    }

    public static void jad_s_an(jad_s_an jad_s_anVar, int i, String str) {
        jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.this.callbackAdRenderFailedOnUiThread(i, str);
        }
    }

    public final void jad_s_an(int i, String str) {
        jad_s_cp jad_s_cpVar = this.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.this.callbackAdRenderFailedOnUiThread(i, str);
        }
    }

    public final void jad_s_an(View view, int i) {
        this.jad_s_jt = view;
        if (view != null) {
            JADMediator.getInstance().getExposureService().registerExposureView(this.jad_s_dq);
            View view2 = this.jad_s_jt;
            JADMediator.getInstance().getExposureService().setViewExposureCallback(this.jad_s_dq, 1, view2, new com.jd.ad.sdk.jad_s_an.jad_s_er(this, i, view2));
        }
        if (this.jad_s_iv != null) {
            JADMediator.getInstance().getTouchService().registerTouchView(this.jad_s_dq);
            if (i == 3) {
                try {
                    if (jad_s_an() != null) {
                        JADMediator.getInstance().getDynamicRenderService().registerAdViewClick(jad_s_an(), (DynamicRenderView) this.jad_s_jt, new com.jd.ad.sdk.jad_s_an.jad_s_fs(this));
                    }
                } catch (Exception e) {
                    Logger.d(Log.getStackTraceString(e));
                }
            } else if (this.jad_s_ob) {
                try {
                    if (jad_s_an() != null) {
                        JADMediator.getInstance().getVideoRenderService().registerAdViewClick(jad_s_an(), (VideoRenderView) this.jad_s_jt, new jad_s_jt(this));
                    }
                } catch (Exception e2) {
                    Logger.d(Log.getStackTraceString(e2));
                }
            } else {
                View view3 = this.jad_s_iv;
                if (view3 != null) {
                    view3.setClickable(true);
                    this.jad_s_iv.setOnTouchListener(new jad_s_hu(this));
                    this.jad_s_iv.setOnClickListener(new com.jd.ad.sdk.jad_s_an.jad_s_an(this));
                }
            }
        }
        jad_s_cp jad_s_cpVar = this.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.this.callbackAdReadyOnUiThread(view);
        }
    }

    public static void jad_s_an(jad_s_an jad_s_anVar, int i) {
        jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.this.callbackAdCountDownOnUiThread(i);
        }
    }
}
