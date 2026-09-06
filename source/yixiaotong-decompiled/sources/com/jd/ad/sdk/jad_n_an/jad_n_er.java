package com.jd.ad.sdk.jad_n_an;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.bl.adinteraction.deeplink.OnUserCancelJdJumpCallback;
import com.jd.ad.sdk.bl.dynamicrender.ShakeListener;
import com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeInteractionListener;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: JADNativeViewController.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_n_er {
    public JADNative jad_n_an;
    public JADNativeInteractionListener jad_n_bo;
    public ViewGroup jad_n_fs;
    public List<View> jad_n_jt;
    public ShakeListener jad_n_kx;
    public Application jad_n_ly;
    public int jad_n_mz;
    public jad_n_dq jad_n_na;
    public boolean jad_n_cp = false;
    public int jad_n_dq = 0;
    public int jad_n_er = 100;
    public int jad_n_hu = 0;
    public int jad_n_iv = 0;
    public int jad_n_jw = CommonConstants.AdTriggerSourceType.CLICK.ordinal();
    public final Application.ActivityLifecycleCallbacks jad_n_ob = new jad_n_an();

    /* JADX INFO: compiled from: JADNativeViewController.java */
    public class jad_n_an implements Application.ActivityLifecycleCallbacks {
        public jad_n_an() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
            int iHashCode = activity.hashCode();
            jad_n_er jad_n_erVar = jad_n_er.this;
            if (iHashCode == jad_n_erVar.jad_n_mz) {
                jad_n_erVar.jad_n_an(true);
                jad_n_er jad_n_erVar2 = jad_n_er.this;
                Application application = jad_n_erVar2.jad_n_ly;
                if (application != null && (activityLifecycleCallbacks = jad_n_erVar2.jad_n_ob) != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
                jad_n_er.this.jad_n_an();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            int iHashCode = activity.hashCode();
            jad_n_er jad_n_erVar = jad_n_er.this;
            if (iHashCode == jad_n_erVar.jad_n_mz) {
                jad_n_er.jad_n_an(jad_n_erVar, true);
                jad_n_er.this.jad_n_an(false);
                jad_n_er.jad_n_bo(jad_n_er.this, false);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            int iHashCode = activity.hashCode();
            jad_n_er jad_n_erVar = jad_n_er.this;
            if (iHashCode == jad_n_erVar.jad_n_mz) {
                jad_n_er.jad_n_an(jad_n_erVar, false);
                jad_n_er jad_n_erVar2 = jad_n_er.this;
                if (jad_n_erVar2.jad_n_cp) {
                    return;
                }
                jad_n_erVar2.jad_n_jt();
                jad_n_er.jad_n_bo(jad_n_er.this, true);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            int iHashCode = activity.hashCode();
            jad_n_er jad_n_erVar = jad_n_er.this;
            if (iHashCode == jad_n_erVar.jad_n_mz) {
                jad_n_er.jad_n_an(jad_n_erVar, true);
                jad_n_er.this.jad_n_an(false);
                jad_n_er.jad_n_bo(jad_n_er.this, false);
            }
        }
    }

    /* JADX INFO: compiled from: JADNativeViewController.java */
    public class jad_n_bo implements View.OnTouchListener {
        public jad_n_bo() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (jad_n_er.this.jad_n_an == null) {
                return false;
            }
            JADMediator.getInstance().getTouchService().onViewTouch(view, motionEvent, jad_n_er.this.jad_n_an.getInstanceId());
            return false;
        }
    }

    /* JADX INFO: compiled from: JADNativeViewController.java */
    public class jad_n_cp implements OnUserCancelJdJumpCallback {
        public jad_n_cp() {
        }

        @Override // com.jd.ad.sdk.bl.adinteraction.deeplink.OnUserCancelJdJumpCallback
        public void callback(int i) {
            jad_n_er.this.jad_n_an(i);
        }
    }

    /* JADX INFO: compiled from: JADNativeViewController.java */
    public class jad_n_dq implements ViewTreeObserver.OnWindowFocusChangeListener {
        public jad_n_dq() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            jad_n_er jad_n_erVar = jad_n_er.this;
            if (jad_n_erVar.jad_n_cp) {
                return;
            }
            if (!z) {
                jad_n_erVar.jad_n_hu();
                return;
            }
            ShakeListener shakeListener = jad_n_erVar.jad_n_kx;
            if (shakeListener != null) {
                shakeListener.register();
            }
        }
    }

    public static /* synthetic */ boolean jad_n_an(jad_n_er jad_n_erVar, boolean z) {
        jad_n_erVar.getClass();
        return z;
    }

    public final String jad_n_er() {
        JADNative jADNative = this.jad_n_an;
        return (jADNative == null || jADNative.getSlot() == null) ? "" : this.jad_n_an.getSlot().getRequestId();
    }

    public final String jad_n_fs() {
        return jad_n_dq() != null ? jad_n_dq().getSlotID() : "";
    }

    public static boolean jad_n_an(jad_n_er jad_n_erVar, View view) {
        jad_n_erVar.getClass();
        return view != null && view.getGlobalVisibleRect(new Rect()) && view.isShown();
    }

    public final JADSlot jad_n_dq() {
        JADNative jADNative = this.jad_n_an;
        if (jADNative != null) {
            return jADNative.getSlot();
        }
        return null;
    }

    public final void jad_n_hu() {
        ShakeListener shakeListener = this.jad_n_kx;
        if (shakeListener != null) {
            shakeListener.unregister();
        }
    }

    public final void jad_n_bo(View view) {
        if (view == null || this.jad_n_fs == null || this.jad_n_an == null) {
            return;
        }
        JADMediator.getInstance().getExposureService().setViewForceExposure(this.jad_n_an.getInstanceId());
        jad_n_an(JADMediator.getInstance().getTouchService().onViewClicked(view.getContext(), view, this.jad_n_an.getInstanceId(), new jad_n_cp()));
        JADNativeInteractionListener jADNativeInteractionListener = this.jad_n_bo;
        if (jADNativeInteractionListener != null) {
            jADNativeInteractionListener.onClick(view);
        }
    }

    public final void jad_n_cp(View view) {
        if (view == null || this.jad_n_an == null) {
            return;
        }
        JADMediator.getInstance().getTouchService().registerTouchView(this.jad_n_an.getInstanceId());
        view.setClickable(true);
        view.setOnTouchListener(new jad_n_bo());
    }

    public final void jad_n_jt() {
        ViewGroup viewGroup = this.jad_n_fs;
        if (viewGroup != null && this.jad_n_na == null) {
            this.jad_n_na = new jad_n_dq();
            viewGroup.getViewTreeObserver().addOnWindowFocusChangeListener(this.jad_n_na);
        }
    }

    public static int jad_n_an(jad_n_er jad_n_erVar, float f, float f2, float f3) {
        jad_n_erVar.getClass();
        CommonConstants.AdTriggerSourceType adTriggerSourceType = CommonConstants.AdTriggerSourceType.SHAKE;
        int iOrdinal = adTriggerSourceType.ordinal();
        if (f3 > 0.0f) {
            if (f > 0.0f && f2 > 0.0f) {
                return CommonConstants.AdTriggerSourceType.SHAKE_ALL.ordinal();
            }
            if (f > 0.0f) {
                return CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_TIME.ordinal();
            }
            return f2 > 0.0f ? CommonConstants.AdTriggerSourceType.SHAKE_ANGLE_TIME.ordinal() : iOrdinal;
        }
        if (f > 0.0f && f2 > 0.0f) {
            return CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_ANGLE.ordinal();
        }
        if (f > 0.0f) {
            return adTriggerSourceType.ordinal();
        }
        return f2 > 0.0f ? CommonConstants.AdTriggerSourceType.SHAKE_ANGLE.ordinal() : iOrdinal;
    }

    public final int jad_n_cp() {
        if (jad_n_dq() != null) {
            return jad_n_dq().getEventInteractionType();
        }
        return CommonConstants.AdTriggerSourceType.CLICK.ordinal();
    }

    public final int jad_n_bo() {
        if (jad_n_dq() != null) {
            return jad_n_dq().getAdType();
        }
        return 0;
    }

    public static void jad_n_bo(jad_n_er jad_n_erVar, boolean z) {
        if (z) {
            ShakeListener shakeListener = jad_n_erVar.jad_n_kx;
            if (shakeListener != null) {
                shakeListener.register();
                return;
            }
            return;
        }
        jad_n_erVar.jad_n_hu();
    }

    public static boolean jad_n_an(jad_n_er jad_n_erVar, Context context, String str) {
        ConcurrentHashMap<String, WeakReference<View>> nativeExposureFeedShakeViewMap;
        WeakReference<View> weakReference;
        jad_n_erVar.getClass();
        if (context == null || TextUtils.isEmpty(str) || (nativeExposureFeedShakeViewMap = JADMediator.getInstance().getExposureService().getNativeExposureFeedShakeViewMap()) == null) {
            return false;
        }
        int screenWidth = JADScreenInfoUtils.getScreenWidth(context) / 2;
        int screenHeight = JADScreenInfoUtils.getScreenHeight(context) / 2;
        double d = Double.MAX_VALUE;
        String str2 = "";
        for (String str3 : nativeExposureFeedShakeViewMap.keySet()) {
            if (!TextUtils.isEmpty(str3) && (weakReference = nativeExposureFeedShakeViewMap.get(str3)) != null && weakReference.get() != null) {
                View view = weakReference.get();
                if (jad_n_erVar.jad_n_an(view)) {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    int i = iArr[0];
                    int i2 = iArr[1];
                    int width = view.getWidth();
                    int height = (view.getHeight() / 2) + i2;
                    int iAbs = Math.abs(((width / 2) + i) - screenWidth);
                    int iAbs2 = Math.abs(height - screenHeight);
                    double dSqrt = Math.sqrt((iAbs2 * iAbs2) + (iAbs * iAbs));
                    if (dSqrt < d) {
                        str2 = str3;
                        d = dSqrt;
                    }
                }
            }
        }
        JADNative jADNative = jad_n_erVar.jad_n_an;
        return jADNative != null && str2.equals(jADNative.getInstanceId());
    }

    public static void jad_n_an(jad_n_er jad_n_erVar, boolean z, String str, int i) {
        int i2;
        long j;
        long j2;
        int i3;
        long j3;
        long j4;
        List<View> list;
        View next;
        JADNative jADNative;
        jad_n_erVar.getClass();
        try {
            jad_n_erVar.jad_n_dq = 0;
            jad_n_erVar.jad_n_er = 0;
            if (jad_n_erVar.jad_n_fs != null && (list = jad_n_erVar.jad_n_jt) != null && list.size() != 0) {
                JADNative jADNative2 = jad_n_erVar.jad_n_an;
                if (jADNative2 != null && jADNative2.getSlot() != null && jad_n_erVar.jad_n_an.getSlot().getAdType() != 1) {
                    jad_n_erVar.jad_n_dq = 0;
                    jad_n_erVar.jad_n_er = 100;
                    jad_n_erVar.jad_n_an.getSlot().setSspt(jad_n_erVar.jad_n_dq);
                    jad_n_erVar.jad_n_an.getSlot().setScav(jad_n_erVar.jad_n_er);
                } else {
                    Iterator<View> it = jad_n_erVar.jad_n_jt.iterator();
                    int measuredWidth = 0;
                    while (it.hasNext() && (next = it.next()) != null && (jADNative = jad_n_erVar.jad_n_an) != null && jADNative.getSlot() != null) {
                        int measuredWidth2 = (int) (jad_n_erVar.jad_n_fs.getMeasuredWidth() * jad_n_erVar.jad_n_fs.getMeasuredHeight());
                        measuredWidth += next.getMeasuredWidth() * next.getMeasuredHeight();
                        if (measuredWidth2 > 0) {
                            jad_n_erVar.jad_n_er = (measuredWidth * 100) / measuredWidth2;
                            if (measuredWidth < measuredWidth2) {
                                jad_n_erVar.jad_n_dq = 5;
                            } else {
                                jad_n_erVar.jad_n_dq = 4;
                            }
                        } else {
                            jad_n_erVar.jad_n_dq = 0;
                            jad_n_erVar.jad_n_er = 0;
                        }
                        jad_n_erVar.jad_n_an.getSlot().setSspt(jad_n_erVar.jad_n_dq);
                        jad_n_erVar.jad_n_an.getSlot().setScav(jad_n_erVar.jad_n_er);
                    }
                }
            }
        } catch (Exception e) {
            Logger.w(a.a("Exception while calculate area: ").append(e.getMessage()).toString(), new Object[0]);
        }
        if (z) {
            String strJad_n_er = jad_n_erVar.jad_n_er();
            String strJad_n_fs = jad_n_erVar.jad_n_fs();
            int iJad_n_bo = jad_n_erVar.jad_n_bo();
            if (jad_n_erVar.jad_n_dq() != null) {
                int modelClickAreaType = jad_n_erVar.jad_n_dq().getModelClickAreaType();
                jad_n_erVar.jad_n_dq().setDelayShowTime(System.currentTimeMillis());
                long delayShowTime = jad_n_erVar.jad_n_dq().getDelayShowTime() - jad_n_erVar.jad_n_dq().getLoadTime();
                long delayShowTime2 = jad_n_erVar.jad_n_dq().getDelayShowTime() - jad_n_erVar.jad_n_dq().getLoadSucTime();
                jad_n_erVar.jad_n_dq().setSedu(delayShowTime);
                jad_n_erVar.jad_n_dq().setDedu(delayShowTime2);
                jad_n_erVar.jad_n_dq().setExposureExtend(str);
                jad_n_erVar.jad_n_dq().setDstp(jad_n_erVar.jad_n_hu);
                jad_n_erVar.jad_n_dq().setSrtp(jad_n_erVar.jad_n_iv);
                i3 = modelClickAreaType;
                j3 = delayShowTime;
                j4 = delayShowTime2;
            } else {
                i3 = 0;
                j3 = 0;
                j4 = 0;
            }
            JADMediator.getInstance().getEventService().reportExposureEvent(strJad_n_er, strJad_n_fs, iJad_n_bo, CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), JADMediator.getInstance().getInitService().getSen(strJad_n_fs), 2, i, j3, j4, jad_n_erVar.jad_n_dq, jad_n_erVar.jad_n_er, jad_n_erVar.jad_n_cp(), i3, str, jad_n_erVar.jad_n_hu, jad_n_erVar.jad_n_iv);
            JADNativeInteractionListener jADNativeInteractionListener = jad_n_erVar.jad_n_bo;
            if (jADNativeInteractionListener != null) {
                jADNativeInteractionListener.onExposure();
                return;
            }
            return;
        }
        String strJad_n_er2 = jad_n_erVar.jad_n_er();
        String strJad_n_fs2 = jad_n_erVar.jad_n_fs();
        int iJad_n_bo2 = jad_n_erVar.jad_n_bo();
        if (jad_n_erVar.jad_n_dq() != null) {
            int modelClickAreaType2 = jad_n_erVar.jad_n_dq().getModelClickAreaType();
            jad_n_erVar.jad_n_dq().setShowTime(System.currentTimeMillis());
            long showTime = jad_n_erVar.jad_n_dq().getShowTime() - jad_n_erVar.jad_n_dq().getLoadTime();
            long showTime2 = jad_n_erVar.jad_n_dq().getShowTime() - jad_n_erVar.jad_n_dq().getLoadSucTime();
            jad_n_erVar.jad_n_dq().setSedu(showTime);
            jad_n_erVar.jad_n_dq().setDedu(showTime2);
            jad_n_erVar.jad_n_dq().setExposureExtend(str);
            jad_n_erVar.jad_n_dq().setDstp(jad_n_erVar.jad_n_hu);
            jad_n_erVar.jad_n_dq().setSrtp(jad_n_erVar.jad_n_iv);
            i2 = modelClickAreaType2;
            j = showTime;
            j2 = showTime2;
        } else {
            i2 = 0;
            j = 0;
            j2 = 0;
        }
        JADMediator.getInstance().getEventService().reportExposureEvent(strJad_n_er2, strJad_n_fs2, iJad_n_bo2, CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), JADMediator.getInstance().getInitService().getSen(strJad_n_fs2), 2, i, j, j2, jad_n_erVar.jad_n_dq, jad_n_erVar.jad_n_er, jad_n_erVar.jad_n_cp(), i2, str, jad_n_erVar.jad_n_hu, jad_n_erVar.jad_n_iv);
    }

    public final boolean jad_n_an(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect) || !view.isShown() || rect.top <= 0) {
            return false;
        }
        int iWidth = rect.width() * rect.height();
        int height = view.getHeight() * view.getWidth();
        if (iWidth == 0 || height == 0) {
            return false;
        }
        return ((int) (new BigDecimal(String.valueOf(iWidth)).divide(new BigDecimal(String.valueOf(height)), 2, RoundingMode.HALF_UP).floatValue() * 100.0f)) == 100;
    }

    public static void jad_n_an(jad_n_er jad_n_erVar, View view, boolean z) {
        long j;
        long j2;
        long j3;
        if (jad_n_erVar.jad_n_cp) {
            return;
        }
        if (jad_n_erVar.jad_n_an != null) {
            try {
                JADMediator.getInstance().getExposureService().setViewForceExposure(jad_n_erVar.jad_n_an.getInstanceId());
                if (jad_n_erVar.jad_n_an.getSlot() != null && jad_n_erVar.jad_n_an.getSlot().getAdType() != 4) {
                    JADMediator.getInstance().getTouchService().unregisterTouchView(jad_n_erVar.jad_n_an.getInstanceId());
                }
                if (jad_n_erVar.jad_n_an.getSlot() != null && jad_n_erVar.jad_n_an.getSlot().getAdType() == 2) {
                    JADMediator.getInstance().getExposureService().unregisterNativeExposureFeedShakeView(jad_n_erVar.jad_n_an.getInstanceId());
                }
                jad_n_erVar.jad_n_hu();
                jad_n_erVar.jad_n_an(true);
            } catch (Exception e) {
                Logger.w(a.a("Exception while close: ").append(e.getMessage()).toString(), new Object[0]);
            }
        }
        jad_n_erVar.jad_n_cp = true;
        if (z) {
            String strJad_n_er = jad_n_erVar.jad_n_er();
            String strJad_n_fs = jad_n_erVar.jad_n_fs();
            int iJad_n_bo = jad_n_erVar.jad_n_bo();
            if (jad_n_erVar.jad_n_dq() != null) {
                jad_n_erVar.jad_n_dq().setClickTime(System.currentTimeMillis());
                long clickTime = jad_n_erVar.jad_n_dq().getClickTime() - jad_n_erVar.jad_n_dq().getLoadTime();
                long clickTime2 = jad_n_erVar.jad_n_dq().getClickTime() - jad_n_erVar.jad_n_dq().getLoadSucTime();
                long clickTime3 = jad_n_erVar.jad_n_dq().getClickTime() - jad_n_erVar.jad_n_dq().getShowTime();
                jad_n_erVar.jad_n_dq().setScdu(clickTime);
                jad_n_erVar.jad_n_dq().setDcdu(clickTime2);
                jad_n_erVar.jad_n_dq().setEcdu(clickTime3);
                j2 = clickTime2;
                j3 = clickTime3;
                j = clickTime;
            } else {
                j = 0;
                j2 = 0;
                j3 = 0;
            }
            JADMediator.getInstance().getEventService().reportCloseEvent(strJad_n_er, strJad_n_fs, iJad_n_bo, CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), JADMediator.getInstance().getInitService().getSen(strJad_n_fs), 2, -1, j, j2, j3, jad_n_erVar.jad_n_dq, jad_n_erVar.jad_n_er, CommonConstants.ClickFrom.CLOSE.ordinal(), jad_n_erVar.jad_n_hu, jad_n_erVar.jad_n_iv);
        }
        JADNativeInteractionListener jADNativeInteractionListener = jad_n_erVar.jad_n_bo;
        if (jADNativeInteractionListener != null) {
            jADNativeInteractionListener.onClose(view);
            jad_n_erVar.jad_n_bo = null;
        }
    }

    public void jad_n_an() {
        try {
            jad_n_hu();
            if (this.jad_n_kx != null) {
                this.jad_n_kx = null;
            }
            jad_n_an(true);
            if (this.jad_n_an != null) {
                JADMediator.getInstance().getExposureService().unregisterExposureView(this.jad_n_an.getInstanceId());
                JADMediator.getInstance().getTouchService().unregisterTouchView(this.jad_n_an.getInstanceId());
                if (this.jad_n_an.getSlot() != null && this.jad_n_an.getSlot().getAdType() == 2) {
                    JADMediator.getInstance().getExposureService().unregisterNativeExposureFeedShakeView(this.jad_n_an.getInstanceId());
                }
            }
            this.jad_n_bo = null;
            this.jad_n_an = null;
            this.jad_n_fs = null;
            this.jad_n_jt = null;
        } catch (Exception e) {
            Logger.w(a.a("Exception while destroy: ").append(e.getMessage()).toString(), new Object[0]);
        }
    }

    public void jad_n_an(int i) {
        long j;
        long j2;
        long j3;
        int i2;
        if (i == -2) {
            return;
        }
        String strJad_n_er = jad_n_er();
        String strJad_n_fs = jad_n_fs();
        int iJad_n_bo = jad_n_bo();
        int iJad_n_cp = jad_n_cp();
        if (jad_n_dq() != null) {
            int modelClickAreaType = jad_n_dq().getModelClickAreaType();
            jad_n_dq().setClickTime(System.currentTimeMillis());
            long clickTime = jad_n_dq().getClickTime() - jad_n_dq().getLoadTime();
            long clickTime2 = jad_n_dq().getClickTime() - jad_n_dq().getLoadSucTime();
            long clickTime3 = jad_n_dq().getClickTime() - jad_n_dq().getShowTime();
            jad_n_dq().setScdu(clickTime);
            jad_n_dq().setDcdu(clickTime2);
            jad_n_dq().setEcdu(clickTime3);
            jad_n_dq().setAtst(this.jad_n_jw);
            i2 = modelClickAreaType;
            j3 = clickTime3;
            j2 = clickTime2;
            j = clickTime;
        } else {
            j = 0;
            j2 = 0;
            j3 = 0;
            i2 = 0;
        }
        JADMediator.getInstance().getEventService().reportClickEvent(strJad_n_er, strJad_n_fs, iJad_n_bo, CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), JADMediator.getInstance().getInitService().getSen(strJad_n_fs), 2, i, j, j2, j3, this.jad_n_dq, this.jad_n_er, iJad_n_cp, this.jad_n_jw, i2, this.jad_n_hu, this.jad_n_iv);
    }

    public final void jad_n_an(boolean z) {
        ViewGroup viewGroup = this.jad_n_fs;
        if (viewGroup == null || this.jad_n_na == null) {
            return;
        }
        viewGroup.getViewTreeObserver().removeOnWindowFocusChangeListener(this.jad_n_na);
        if (z) {
            this.jad_n_na = null;
        }
    }
}
