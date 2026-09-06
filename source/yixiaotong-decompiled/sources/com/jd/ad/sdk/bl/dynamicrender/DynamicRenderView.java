package com.jd.ad.sdk.bl.dynamicrender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.hihonor.adsdk.base.g.j.e.a;
import com.huawei.openalliance.ad.constant.x;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.jad_hu.jad_hu;
import com.jd.ad.sdk.jad_hu.jad_iv;
import com.jd.ad.sdk.jad_lu.jad_jt;
import com.jd.ad.sdk.jad_lu.jad_na;
import com.jd.ad.sdk.jad_lu.jad_sf;
import com.jd.ad.sdk.jad_mx.jad_ly;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.lottie.LottieAnimationView;
import com.jd.ad.sdk.multi.R;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class DynamicRenderView extends FrameLayout {
    public static final /* synthetic */ int jad_sd = 0;
    public double jad_an;
    public double jad_bo;
    public IDynamicRenderCallback jad_cn;
    public double jad_cp;
    public IDynamicCountdownListener jad_do;
    public double jad_dq;
    public int jad_ep;
    public double jad_er;
    public final CountDownLatch jad_fq;
    public boolean jad_fs;
    public boolean jad_gr;
    public Exception jad_hs;
    public ShakeListener jad_hu;
    public Exception jad_it;
    public String jad_iv;
    public int jad_jt;
    public int jad_ju;
    public double jad_jw;
    public float jad_kv;
    public double jad_kx;
    public float jad_lw;
    public String jad_ly;
    public float jad_mx;
    public double jad_mz;
    public double jad_na;
    public float jad_ny;
    public int jad_ob;
    public float jad_oz;
    public boolean jad_pa;
    public int jad_pc;
    public jad_er jad_qb;
    public int jad_qd;
    public final Runnable jad_rc;
    public int jad_re;
    public LottieAnimationView jad_sf;
    public List<String> jad_tg;
    public List<String> jad_uh;
    public List<String> jad_vi;
    public final Map<String, com.jd.ad.sdk.jad_hu.jad_an> jad_wj;
    public String jad_xk;
    public final JSONObject jad_yl;
    public final Map<String, Bitmap> jad_zm;

    public interface IDynamicRenderCallback {
        default void onAnimationEnd() {
        }

        void onDynamicRenderFailed(int i, String str);

        void onDynamicRenderSuccess(View view);

        default void onFullLottieViewClick(Context context) {
        }
    }

    public class jad_an implements Runnable {
        public jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DynamicRenderView dynamicRenderView = DynamicRenderView.this;
            IDynamicCountdownListener iDynamicCountdownListener = dynamicRenderView.jad_do;
            if (iDynamicCountdownListener != null) {
                iDynamicCountdownListener.onAdCountdown(dynamicRenderView.jad_ep);
            }
            DynamicRenderView dynamicRenderView2 = DynamicRenderView.this;
            if (dynamicRenderView2.jad_fs) {
                dynamicRenderView2.jad_ep--;
            }
            if (dynamicRenderView2.jad_ep > 0) {
                dynamicRenderView2.postDelayed(dynamicRenderView2.jad_rc, 1000L);
            } else {
                dynamicRenderView2.removeCallbacks(dynamicRenderView2.jad_rc);
            }
        }
    }

    public class jad_bo extends com.jd.ad.sdk.jad_fo.jad_an<Bitmap> {
        public final /* synthetic */ jad_na jad_dq;
        public final /* synthetic */ Map jad_er;

        public jad_bo(jad_na jad_naVar, Map map) {
            this.jad_dq = jad_naVar;
            this.jad_er = map;
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_er
        public void jad_an(Drawable drawable) {
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_er
        public void jad_an(Object obj, com.jd.ad.sdk.jad_gp.jad_bo jad_boVar) {
            jad_na jad_naVar = this.jad_dq;
            DynamicRenderView.this.jad_zm.put(this.jad_dq.jad_cp, jad_hu.jad_an((Bitmap) obj, jad_naVar.jad_an, jad_naVar.jad_bo));
            Map map = this.jad_er;
            if (map == null || map.size() != DynamicRenderView.this.jad_zm.size()) {
                return;
            }
            try {
                DynamicRenderView.this.jad_fq.await();
                DynamicRenderView dynamicRenderView = DynamicRenderView.this;
                IDynamicRenderCallback iDynamicRenderCallback = dynamicRenderView.jad_cn;
                if (iDynamicRenderCallback != null) {
                    if (dynamicRenderView.jad_gr) {
                        iDynamicRenderCallback.onDynamicRenderSuccess(dynamicRenderView);
                    } else {
                        JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                        iDynamicRenderCallback.onDynamicRenderFailed(jADError.getCode(), jADError.getMessage(new String[0]));
                    }
                }
            } catch (Exception unused) {
                IDynamicRenderCallback iDynamicRenderCallback2 = DynamicRenderView.this.jad_cn;
                if (iDynamicRenderCallback2 != null) {
                    JADError jADError2 = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                    iDynamicRenderCallback2.onDynamicRenderFailed(jADError2.getCode(), jADError2.getMessage(new String[0]));
                }
            }
        }

        @Override // com.jd.ad.sdk.jad_fo.jad_an, com.jd.ad.sdk.jad_fo.jad_er
        public void jad_cp(Drawable drawable) {
            IDynamicRenderCallback iDynamicRenderCallback;
            DynamicRenderView dynamicRenderView = DynamicRenderView.this;
            if (dynamicRenderView.jad_pa || (iDynamicRenderCallback = dynamicRenderView.jad_cn) == null) {
                return;
            }
            dynamicRenderView.jad_pa = true;
            JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
            iDynamicRenderCallback.onDynamicRenderFailed(jADError.getCode(), jADError.getMessage(new String[0]));
        }
    }

    public class jad_cp implements Runnable {
        public final /* synthetic */ Context jad_an;

        public jad_cp(Context context) {
            this.jad_an = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            DynamicRenderView dynamicRenderView;
            LottieAnimationView lottieAnimationView;
            try {
                try {
                    DynamicRenderView dynamicRenderView2 = DynamicRenderView.this;
                    jad_sf<jad_jt> jad_sfVarJad_an = com.jd.ad.sdk.jad_lu.jad_hu.jad_an(DynamicRenderView.jad_an(DynamicRenderView.this, dynamicRenderView2.jad_an(this.jad_an, dynamicRenderView2.jad_iv, dynamicRenderView2.jad_ly, dynamicRenderView2.jad_ob, dynamicRenderView2)), (String) null);
                    Throwable th = jad_sfVarJad_an.jad_bo;
                    if (th != null) {
                        DynamicRenderView.this.jad_gr = false;
                        DynamicRenderView dynamicRenderView3 = DynamicRenderView.this;
                        StringBuilder sb = new StringBuilder();
                        com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOTTIE_PARSE_ERROR;
                        dynamicRenderView3.jad_it = new Exception(sb.append(jad_anVar.jad_an).append(x.A).append(jad_anVar.jad_an(new String[0])).toString(), th);
                    } else {
                        jad_jt jad_jtVar = jad_sfVarJad_an.jad_an;
                        if (jad_jtVar == null) {
                            DynamicRenderView.this.jad_gr = false;
                            DynamicRenderView dynamicRenderView4 = DynamicRenderView.this;
                            StringBuilder sb2 = new StringBuilder();
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOTTIE_PARSE_ERROR;
                            dynamicRenderView4.jad_it = new Exception(sb2.append(jad_anVar2.jad_an).append(x.A).append(jad_anVar2.jad_an(new String[0])).toString());
                        } else {
                            DynamicRenderView.this.jad_sf.setComposition(jad_jtVar);
                            DynamicRenderView.jad_an(DynamicRenderView.this, this.jad_an);
                            LottieAnimationView lottieAnimationView2 = DynamicRenderView.this.jad_sf;
                            if (lottieAnimationView2 != null) {
                                try {
                                    lottieAnimationView2.setFontAssetDelegate(new com.jd.ad.sdk.jad_hu.jad_er());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            DynamicRenderView dynamicRenderView5 = DynamicRenderView.this;
                            LottieAnimationView lottieAnimationView3 = dynamicRenderView5.jad_sf;
                            Context context = this.jad_an;
                            Map<String, Bitmap> map = dynamicRenderView5.jad_zm;
                            if (lottieAnimationView3 != null && context != null) {
                                lottieAnimationView3.setImageAssetDelegate(new com.jd.ad.sdk.jad_hu.jad_jt(map, context));
                            }
                            DynamicRenderView dynamicRenderView6 = DynamicRenderView.this;
                            Context context2 = this.jad_an;
                            LottieAnimationView lottieAnimationView4 = dynamicRenderView6.jad_sf;
                            if (lottieAnimationView4 != null && context2 != null) {
                                lottieAnimationView4.jad_er.jad_cp.jad_bo.add(new com.jd.ad.sdk.bl.dynamicrender.jad_an(dynamicRenderView6, context2));
                            }
                            DynamicRenderView dynamicRenderView7 = DynamicRenderView.this;
                            double d = dynamicRenderView7.jad_kx;
                            if (d > 0.0d) {
                                double d2 = dynamicRenderView7.jad_er;
                                if (d2 > 0.0d && dynamicRenderView7.jad_jw / d != dynamicRenderView7.jad_dq / d2 && (lottieAnimationView = dynamicRenderView7.jad_sf) != null) {
                                    lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
                                }
                            }
                            DynamicRenderView.jad_an(DynamicRenderView.this);
                        }
                    }
                    dynamicRenderView = DynamicRenderView.this;
                } catch (Exception e2) {
                    Thread.currentThread().interrupt();
                    DynamicRenderView.this.jad_gr = false;
                    DynamicRenderView dynamicRenderView8 = DynamicRenderView.this;
                    StringBuilder sb3 = new StringBuilder();
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOTTIE_PARSE_ERROR;
                    dynamicRenderView8.jad_it = new Exception(sb3.append(jad_anVar3.jad_an).append(x.A).append(jad_anVar3.jad_an(new String[0])).toString(), e2);
                    dynamicRenderView = DynamicRenderView.this;
                } finally {
                    DynamicRenderView.this.jad_fq.countDown();
                }
                CountDownLatch countDownLatch = dynamicRenderView.jad_fq;
            } catch (Exception e3) {
                StringBuilder sb4 = new StringBuilder();
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_VAR_REPLACE_ERROR;
                throw new Exception(sb4.append(jad_anVar4.jad_an).append(x.A).append(jad_anVar4.jad_an(new String[0])).toString(), e3);
            }
        }
    }

    public class jad_dq implements Runnable {
        public final /* synthetic */ DynamicRenderView jad_an;
        public final /* synthetic */ Context jad_bo;
        public final /* synthetic */ JSONObject jad_cp;
        public final /* synthetic */ String jad_dq;

        public jad_dq(DynamicRenderView dynamicRenderView, DynamicRenderView dynamicRenderView2, Context context, JSONObject jSONObject, String str) {
            this.jad_an = dynamicRenderView2;
            this.jad_bo = context;
            this.jad_cp = jSONObject;
            this.jad_dq = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DynamicRenderView dynamicRenderView = this.jad_an;
                if (dynamicRenderView != null) {
                    dynamicRenderView.jad_an(this.jad_bo, this.jad_cp, this.jad_dq);
                }
            } catch (Exception unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public class jad_er implements ActLifecycle.jad_an {
        public jad_er() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_an() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_bo() {
            DynamicRenderView dynamicRenderView = DynamicRenderView.this;
            int i = DynamicRenderView.jad_sd;
            dynamicRenderView.jad_dq();
        }
    }

    public static class jad_fs {
        public String jad_an;
        public float jad_bo;
        public float jad_cp;
        public List<String> jad_dq = new ArrayList();
        public List<String> jad_er = new ArrayList();
        public List<String> jad_fs = new ArrayList();
        public int jad_hu;
        public int jad_iv;
        public IDynamicRenderCallback jad_jt;
        public String jad_jw;
        public float jad_kx;
        public float jad_ly;
        public int jad_mz;
    }

    public DynamicRenderView(Context context, jad_fs jad_fsVar) {
        super(context);
        this.jad_an = 1.0d;
        this.jad_bo = 1.0d;
        this.jad_cp = 1.0d;
        this.jad_fs = true;
        this.jad_jt = 0;
        this.jad_tg = new ArrayList();
        this.jad_uh = new ArrayList();
        this.jad_vi = new ArrayList();
        this.jad_wj = new HashMap();
        this.jad_yl = new JSONObject();
        this.jad_zm = new HashMap();
        this.jad_gr = true;
        this.jad_hs = null;
        this.jad_it = null;
        this.jad_ju = 100;
        this.jad_kv = 0.0f;
        this.jad_lw = 1.0f;
        this.jad_mx = 0.0f;
        this.jad_ny = 0.0f;
        this.jad_oz = 45.0f;
        this.jad_pa = false;
        this.jad_rc = new jad_an();
        jad_bo();
        jad_an();
        this.jad_fq = new CountDownLatch(1);
        jad_an(jad_fsVar, context);
        jad_an(context);
    }

    private void setCanvasWH(JSONObject jSONObject) {
        this.jad_dq = jSONObject.getInt(IAdInterListener.AdReqParam.WIDTH);
        this.jad_er = jSONObject.getInt(IAdInterListener.AdReqParam.HEIGHT);
    }

    private void setFixedLayerPosition(JSONArray jSONArray) throws JSONException {
        Double dValueOf;
        Double dValueOf2;
        Double dValueOf3 = Double.valueOf(jSONArray.getDouble(0));
        Double dValueOf4 = Double.valueOf(jSONArray.getDouble(1));
        if (dValueOf3.doubleValue() > this.jad_dq / 2.0d) {
            double dDoubleValue = dValueOf3.doubleValue();
            double d = this.jad_an;
            dValueOf = Double.valueOf((dDoubleValue * d) - ((d - 1.0d) * this.jad_dq));
        } else {
            dValueOf = Double.valueOf(dValueOf3.doubleValue() * this.jad_an);
        }
        if (dValueOf4.doubleValue() > this.jad_er / 2.0d) {
            double dDoubleValue2 = dValueOf4.doubleValue();
            double d2 = this.jad_bo;
            dValueOf2 = Double.valueOf((dDoubleValue2 * d2) - ((d2 - 1.0d) * this.jad_er));
        } else {
            dValueOf2 = Double.valueOf(dValueOf4.doubleValue() * this.jad_bo);
        }
        jSONArray.put(0, dValueOf);
        jSONArray.put(1, dValueOf2);
    }

    private void setTransformParams(JSONObject jSONObject) {
        setCanvasWH(jSONObject);
        int i = this.jad_pc;
        double d = this.jad_dq;
        if (d > 0.0d && i > 0) {
            double d2 = this.jad_jw;
            if (d2 > 0.0d) {
                double d3 = d / ((double) i);
                this.jad_an = (d / d3) / d2;
                this.jad_bo = (this.jad_er / d3) / this.jad_kx;
            }
        }
        double d4 = this.jad_kx;
        if (d4 <= 0.0d || d <= 0.0d) {
            return;
        }
        double d5 = this.jad_er;
        if (d5 <= 0.0d) {
            return;
        }
        this.jad_cp = (this.jad_jw / d4) / (d / d5);
    }

    public void destroy() {
        try {
            jad_dq();
            jad_er jad_erVar = this.jad_qb;
            CopyOnWriteArrayList<ActLifecycle.jad_an> copyOnWriteArrayList = ActLifecycle.jad_bo;
            if (jad_erVar != null) {
                copyOnWriteArrayList.remove(jad_erVar);
            }
            this.jad_qb = null;
        } catch (Exception unused) {
        }
    }

    public int getAdAnimationType() {
        return this.jad_jt;
    }

    public int getAdClickAreaValue() {
        return this.jad_ju;
    }

    public Exception getDynamicInitException() {
        return this.jad_it;
    }

    public Exception getLoadImagesException() {
        return this.jad_hs;
    }

    public LottieAnimationView getLottieView() {
        return this.jad_sf;
    }

    public final void jad_an() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null) {
            return;
        }
        this.jad_kv = jad_anVarJad_an.jad_cp;
        float f = jad_anVarJad_an.jad_dq;
        this.jad_lw = f;
        float f2 = jad_anVarJad_an.jad_jw;
        this.jad_oz = f2;
        this.jad_mx = jad_anVarJad_an.jad_er;
        this.jad_ny = jad_anVarJad_an.jad_fs;
        if (f <= 0.0f) {
            this.jad_lw = 1.0f;
        }
        if (f2 <= 0.0f) {
            this.jad_oz = 45.0f;
        }
    }

    public final void jad_bo() {
        jad_er jad_erVar = new jad_er();
        this.jad_qb = jad_erVar;
        ActLifecycle.jad_an(jad_erVar);
    }

    public final void jad_cp() {
        if (this.jad_qd == CommonConstants.AdTriggerSourceType.CLICK.ordinal()) {
            if (this.jad_re == CommonConstants.ClickAreaType.FULL_SCREEN_CLICK.getTemplateId()) {
                this.jad_jt = 1;
                return;
            } else {
                this.jad_jt = 0;
                return;
            }
        }
        if (this.jad_qd == CommonConstants.AdTriggerSourceType.SHAKE.ordinal()) {
            this.jad_jt = 2;
        } else if (this.jad_qd == CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal()) {
            this.jad_jt = 3;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LottieAnimationView lottieAnimationView = this.jad_sf;
        if (lottieAnimationView != null) {
            lottieAnimationView.destroyDrawingCache();
            this.jad_sf = null;
        }
        jad_dq();
        jad_er jad_erVar = this.jad_qb;
        CopyOnWriteArrayList<ActLifecycle.jad_an> copyOnWriteArrayList = ActLifecycle.jad_bo;
        if (jad_erVar != null) {
            copyOnWriteArrayList.remove(jad_erVar);
        }
        this.jad_qb = null;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.jad_fs = z;
        if (!z) {
            removeCallbacks(this.jad_rc);
        } else if (this.jad_do != null && this.jad_ep > 0) {
            post(this.jad_rc);
        }
        if (!this.jad_fs) {
            jad_dq();
            return;
        }
        ShakeListener shakeListener = this.jad_hu;
        if (shakeListener != null) {
            shakeListener.register();
        }
    }

    public final void jad_dq() {
        ShakeListener shakeListener = this.jad_hu;
        if (shakeListener != null) {
            shakeListener.unregister();
        }
    }

    public void play() {
        LottieAnimationView lottieAnimationView = this.jad_sf;
        if (lottieAnimationView != null) {
            lottieAnimationView.jad_dq();
        } else {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_PLAY_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
        }
    }

    public void startCount(IDynamicCountdownListener iDynamicCountdownListener) {
        if (iDynamicCountdownListener == null) {
            return;
        }
        this.jad_do = iDynamicCountdownListener;
        int i = this.jad_ep;
        if (i < 1 || i > 30) {
            this.jad_ep = 5;
        }
        Runnable runnable = this.jad_rc;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0109  */
    public static String jad_an(DynamicRenderView dynamicRenderView, String str) throws Exception {
        String str2;
        int i;
        String str3 = "a";
        String str4 = "layers";
        String str5 = t.f4727a;
        dynamicRenderView.getClass();
        int i2 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            dynamicRenderView.jad_cp();
            dynamicRenderView.setTransformParams(jSONObject);
            JSONArray jSONArray = jSONObject.getJSONArray("layers");
            JSONArray jSONArray2 = new JSONArray();
            int i3 = 0;
            while (i3 < jSONArray.length()) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                String str6 = (String) jSONObject2.get("nm");
                if (dynamicRenderView.jad_vi.contains(str6)) {
                    str3 = str3;
                    str4 = str4;
                    str2 = str5;
                    jSONObject = jSONObject;
                    jSONArray = jSONArray;
                    jSONArray2 = jSONArray2;
                } else {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(MediationConstant.ADN_KS);
                    JSONArray jSONArray3 = jSONObject3.getJSONObject("p").getJSONArray(str5);
                    JSONArray jSONArray4 = jSONObject3.getJSONObject("s").getJSONArray(str5);
                    JSONArray jSONArray5 = jSONObject3.getJSONObject(str3).getJSONArray(str5);
                    double d = jSONArray4.getDouble(i2);
                    double d2 = jSONArray4.getDouble(1);
                    if (dynamicRenderView.jad_tg.contains(str6)) {
                        jSONArray4.put(0, dynamicRenderView.jad_an * d);
                        jSONArray4.put(1, dynamicRenderView.jad_bo * d2);
                        dynamicRenderView.setFixedLayerPosition(jSONArray3);
                    }
                    if (dynamicRenderView.jad_uh.contains(str6)) {
                        jSONArray4.put(1, dynamicRenderView.jad_cp * d2);
                        jSONArray3.put(1, Double.valueOf(Double.valueOf(jSONArray3.getDouble(1)).doubleValue() - (jSONObject3.getJSONObject(str3).getJSONArray(str5).getDouble(1) * (dynamicRenderView.jad_cp - 1.0d))));
                    }
                    if ("sdkMaterialImage".equals(str6)) {
                        double d3 = dynamicRenderView.jad_mz;
                        if (d3 != 0.0d) {
                            str2 = str5;
                            double d4 = dynamicRenderView.jad_jw;
                            if (d4 != 0.0d) {
                                double d5 = ((dynamicRenderView.jad_kx / d4) / (dynamicRenderView.jad_na / d3)) * d;
                                double d6 = 100.0d;
                                if (d5 < 100.0d) {
                                    double d7 = (100.0d / d5) * 100.0d;
                                    i = 0;
                                    d5 = 100.0d;
                                    d6 = d7;
                                } else {
                                    i = 0;
                                }
                                jSONArray4.put(i, d5);
                                jSONArray4.put(1, d6);
                            }
                        } else {
                            str2 = str5;
                        }
                    } else {
                        str2 = str5;
                    }
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(a.L0, i3);
                    jSONObject4.put("rect", dynamicRenderView.jad_an(jSONArray3, jSONArray5, jSONObject2, jSONArray4));
                    dynamicRenderView.jad_yl.put(str6, jSONObject4);
                    jSONArray2.put(jSONObject2);
                }
                i3++;
                jSONArray2 = jSONArray2;
                str5 = str2;
                str3 = str3;
                str4 = str4;
                jSONObject = jSONObject;
                jSONArray = jSONArray;
                i2 = 0;
            }
            JSONObject jSONObject5 = jSONObject;
            jSONObject5.put(str4, jSONArray2);
            return jSONObject5.toString();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_JSON_PARSE_ERROR;
            throw new Exception(sb.append(jad_anVar.jad_an).append(x.A).append(jad_anVar.jad_an(new String[0])).toString(), e);
        }
    }

    public static boolean jad_an(DynamicRenderView dynamicRenderView, View view) {
        dynamicRenderView.getClass();
        return view != null && view.getGlobalVisibleRect(new Rect()) && view.isShown();
    }

    public void jad_an(String str, com.jd.ad.sdk.jad_hu.jad_an jad_anVar) throws Exception {
        try {
            JSONObject jSONObjectOptJSONObject = this.jad_yl.optJSONObject(str);
            if (jSONObjectOptJSONObject == null) {
                Logger.d("动态化渲染不阻断问题：" + str + "不存在");
                return;
            }
            int i = jSONObjectOptJSONObject.getInt(a.L0);
            Rect rect = (Rect) jSONObjectOptJSONObject.get("rect");
            jad_anVar.jad_cp = i;
            jad_anVar.jad_bo = rect;
            this.jad_wj.put(str, jad_anVar);
            if (str.equals(this.jad_xk)) {
                int iWidth = rect.width();
                int iHeight = rect.height();
                int i2 = (int) (this.jad_jw * this.jad_kx);
                if (i2 > 0) {
                    this.jad_ju = ((iWidth * iHeight) * 100) / i2;
                }
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_ADD_EVENT_ERROR;
            throw new Exception(sb.append(jad_anVar2.jad_an).append(x.A).append(jad_anVar2.jad_an(new String[0])).toString(), e);
        }
    }

    public void jad_an(Context context, JSONObject jSONObject, String str) {
        try {
            Map<String, jad_na> mapJad_an = jad_an(jSONObject, str);
            if (mapJad_an != null && !mapJad_an.isEmpty()) {
                this.jad_pa = false;
                Iterator<String> it = mapJad_an.keySet().iterator();
                while (it.hasNext()) {
                    jad_na jad_naVar = mapJad_an.get(it.next());
                    if (jad_naVar == null) {
                        IDynamicRenderCallback iDynamicRenderCallback = this.jad_cn;
                        if (iDynamicRenderCallback != null) {
                            JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                            iDynamicRenderCallback.onDynamicRenderFailed(jADError.getCode(), jADError.getMessage(new String[0]));
                            return;
                        }
                        return;
                    }
                    com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(context).jad_er().jad_an(jad_ly.jad_bo).jad_an(jad_naVar.jad_dq).jad_an(new jad_bo(jad_naVar, mapJad_an));
                }
                return;
            }
            if (!this.jad_gr) {
                IDynamicRenderCallback iDynamicRenderCallback2 = this.jad_cn;
                if (iDynamicRenderCallback2 != null) {
                    JADError jADError2 = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                    iDynamicRenderCallback2.onDynamicRenderFailed(jADError2.getCode(), jADError2.getMessage(new String[0]));
                    return;
                }
                return;
            }
            this.jad_fq.await();
            IDynamicRenderCallback iDynamicRenderCallback3 = this.jad_cn;
            if (iDynamicRenderCallback3 == null || !this.jad_gr) {
                return;
            }
            iDynamicRenderCallback3.onDynamicRenderSuccess(this);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOAD_IMAGES_ERROR;
            this.jad_hs = new Exception(sb.append(jad_anVar.jad_an).append(x.A).append(jad_anVar.jad_an(new String[0])).toString(), e);
        }
    }

    public final void jad_an(Context context) {
        try {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.jad_dynamic_render_layout, (ViewGroup) null);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) viewInflate.findViewById(R.id.animation_view);
            this.jad_sf = lottieAnimationView;
            lottieAnimationView.setCacheComposition(false);
            addView(viewInflate);
            WorkExecutor.execute(new jad_cp(context));
            this.jad_fq.countDown();
        } catch (Throwable th) {
            try {
                this.jad_gr = false;
                StringBuilder sb = new StringBuilder();
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_DYNAMIC_INIT_VIEW_OTHER_ERROR;
                throw new Throwable(sb.append(jad_anVar.jad_an).append(x.A).append(jad_anVar.jad_an(new String[0])).toString(), th);
            } catch (Throwable th2) {
                this.jad_fq.countDown();
                throw th2;
            }
        }
    }

    public static void jad_an(DynamicRenderView dynamicRenderView) {
        ViewGroup.LayoutParams layoutParams = dynamicRenderView.getLayoutParams();
        int i = (int) dynamicRenderView.jad_jw;
        int i2 = (int) dynamicRenderView.jad_kx;
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(i, i2);
        } else {
            layoutParams.height = i2;
            layoutParams.width = i;
        }
        dynamicRenderView.setLayoutParams(layoutParams);
    }

    public String jad_an(Context context, String str, String str2, int i, DynamicRenderView dynamicRenderView) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        WorkExecutor.execute(new jad_dq(this, dynamicRenderView, context, jSONObject, str2));
        int iOptInt = jSONObject.optInt("fr");
        if (i > 5) {
            JSONArray jSONArray = jSONObject.getJSONArray("layers");
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                String string = jSONObject2.getString("nm");
                int i3 = (i - 5) * iOptInt;
                if (string.equals("sdkStaticSkipButton")) {
                    jSONObject2.put("op", i3);
                }
                if (string.equals("sdkSkipButton")) {
                    jSONObject2.put("ip", i3);
                }
            }
            str = jSONObject.toString();
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("countDownTemplate");
        if (jSONObjectOptJSONObject != null) {
            String string2 = jSONObjectOptJSONObject.toString();
            StringBuilder sb = new StringBuilder();
            int i4 = i <= 5 ? i : 5;
            for (int i5 = i4; i5 > 0; i5--) {
                int i6 = (i - i5) * iOptInt;
                String strReplaceAll = string2.replace("${startTime}", com.jd.ad.sdk.jad_bo.jad_bo.jad_an("").append(i6).toString()).replace("${endTime}", com.jd.ad.sdk.jad_bo.jad_bo.jad_an("").append(i6 + iOptInt).toString()).replaceAll("\\$\\{count\\}", "" + i5);
                if (i5 != i4) {
                    sb.append(",");
                }
                sb.append(strReplaceAll);
            }
            str = str.replace("\"${countDown}\"", sb.toString());
        }
        return str.replace("${materialImage}", str2).replace("${totalTime}", "" + (i * iOptInt));
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

    public static void jad_an(DynamicRenderView dynamicRenderView, Context context) {
        LottieAnimationView lottieAnimationView = dynamicRenderView.jad_sf;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.setOnTouchListener(new jad_iv(dynamicRenderView, context));
        dynamicRenderView.jad_sf.setOnClickListener(new com.jd.ad.sdk.bl.dynamicrender.jad_bo(dynamicRenderView, context));
    }

    public static String jad_an(DynamicRenderView dynamicRenderView, int i, int i2) {
        Iterator<String> it = dynamicRenderView.jad_wj.keySet().iterator();
        com.jd.ad.sdk.jad_hu.jad_an jad_anVar = null;
        while (it.hasNext()) {
            com.jd.ad.sdk.jad_hu.jad_an jad_anVar2 = dynamicRenderView.jad_wj.get(it.next());
            if (jad_anVar2 != null && jad_anVar2.jad_bo.contains(i, i2) && (jad_anVar == null || jad_anVar.jad_cp > jad_anVar2.jad_cp)) {
                jad_anVar = jad_anVar2;
            }
        }
        return jad_anVar == null ? "" : jad_anVar.jad_an;
    }

    public final Rect jad_an(JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject, JSONArray jSONArray3) {
        Double dValueOf;
        Double dValueOf2;
        double d = this.jad_dq;
        double d2 = d > 0.0d ? this.jad_jw / d : 1.0d;
        double d3 = this.jad_er;
        double d4 = d3 > 0.0d ? this.jad_kx / d3 : 1.0d;
        if (jSONObject.getInt(com.alipay.sdk.sys.a.g) == 1) {
            dValueOf = Double.valueOf(jSONObject.getDouble("sw"));
            dValueOf2 = Double.valueOf(jSONObject.getDouble("sh"));
        } else {
            dValueOf = Double.valueOf(jSONObject.getDouble(IAdInterListener.AdReqParam.WIDTH));
            dValueOf2 = Double.valueOf(jSONObject.getDouble(IAdInterListener.AdReqParam.HEIGHT));
        }
        double d5 = jSONArray3.getDouble(0) / 100.0d;
        double d6 = jSONArray3.getDouble(1) / 100.0d;
        int i = (int) (((jSONArray.getDouble(0) - jSONArray2.getDouble(0)) - ((d5 - 1.0d) * (dValueOf.doubleValue() / 2.0d))) * d2);
        int i2 = (int) (((jSONArray.getDouble(1) - jSONArray2.getDouble(1)) - ((d6 - 1.0d) * (dValueOf2.doubleValue() / 2.0d))) * d4);
        return new Rect(i, i2, ((int) (dValueOf.doubleValue() * d5 * d2)) + i, ((int) (dValueOf2.doubleValue() * d6 * d4)) + i2);
    }

    public final void jad_an(jad_fs jad_fsVar, Context context) {
        this.jad_iv = jad_fsVar.jad_an;
        this.jad_jw = jad_fsVar.jad_bo;
        this.jad_kx = jad_fsVar.jad_cp;
        this.jad_ly = jad_fsVar.jad_jw;
        this.jad_mz = jad_fsVar.jad_kx;
        this.jad_na = jad_fsVar.jad_ly;
        int i = jad_fsVar.jad_mz;
        this.jad_ob = i;
        this.jad_ep = i;
        this.jad_tg = jad_fsVar.jad_dq;
        this.jad_uh = jad_fsVar.jad_er;
        this.jad_vi = jad_fsVar.jad_fs;
        this.jad_cn = jad_fsVar.jad_jt;
        this.jad_pc = ScreenUtils.getPhoneWidth(context);
        this.jad_qd = jad_fsVar.jad_hu;
        this.jad_re = jad_fsVar.jad_iv;
    }
}
