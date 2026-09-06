package com.miui.zeus.mimo.sdk.ad.nativead;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.NativeAd;
import com.miui.zeus.mimo.sdk.ad.nativead.view.NativeAdView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.c6;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.CommonActionHandler;
import com.miui.zeus.mimo.sdk.common.CommonEventImpl;
import com.miui.zeus.mimo.sdk.common.ViewEventHelper;
import com.miui.zeus.mimo.sdk.common.ViewMeasureHelper;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.j6;
import com.miui.zeus.mimo.sdk.k6;
import com.miui.zeus.mimo.sdk.l6;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.m4;
import com.miui.zeus.mimo.sdk.n6;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.utils.ApkTools;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;
import com.miui.zeus.mimo.sdk.view.AdImpressMonitor;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;
import com.miui.zeus.mimo.sdk.y8;
import com.xiaomi.mediationannotation.HideMethod;
import ijiami_1011.s.s.s;
import java.util.Map;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class NativeAdUIController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f5302a;
    public NativeAdViewBinder b;
    public CommonActionHandler c;
    public MimoAdInfo d;
    public final CommonEventImpl e;
    public b f;
    public final Handler g;
    public AdImpressMonitor h;
    public String i;
    public String j;
    public boolean k;
    public ViewEventHelper l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final float q;
    public ImageView r;
    public TextView s;
    public SixElementsView t;
    public View u;
    public View v;
    public View w;
    public MimoMediaView x;
    public Map<String, String> y;

    public class a implements CommonActionHandler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClickAreaType f5303a;
        public final /* synthetic */ n6 b;
        public final /* synthetic */ c6 c;

        public a(ClickAreaType clickAreaType, n6 n6Var, c6 c6Var) {
            this.f5303a = clickAreaType;
            this.b = n6Var;
            this.c = c6Var;
        }

        @Override // com.miui.zeus.mimo.sdk.click.CommonActionHandler.c
        public void a(boolean z) {
            Map<String, String> map;
            ClickAreaType clickAreaType = this.f5303a;
            if (clickAreaType != ClickAreaType.TYPE_NATIVE_SHAKE || (map = NativeAdUIController.this.y) == null) {
                NativeAdUIController nativeAdUIController = NativeAdUIController.this;
                AdEvent adEvent = AdEvent.CLICK;
                n6 n6Var = this.b;
                if (z) {
                    clickAreaType = ClickAreaType.TYPE_CPM_BUTTON;
                }
                com.miui.zeus.mimo.sdk.b.a(adEvent, nativeAdUIController.d, n6Var, k6.a(clickAreaType, this.c.f5387a));
            } else {
                String str = map.get(s.d(new byte[]{106, 60, 44, 112, 104, 106, 32, 39, 37}, "2ca105"));
                String str2 = NativeAdUIController.this.y.get(s.d(new byte[]{Utf8.REPLACEMENT_BYTE, 60, 41, 112, 107, 103, 32, 39, 37}, "fcd138"));
                String str3 = NativeAdUIController.this.y.get(s.d(new byte[]{57, 106, 43, 39, 110, 109, 32, 39, 37}, "c5ff62"));
                NativeAdUIController nativeAdUIController2 = NativeAdUIController.this;
                AdEvent adEvent2 = AdEvent.CLICK;
                n6 n6Var2 = this.b;
                ClickAreaType clickAreaType2 = z ? ClickAreaType.TYPE_CPM_BUTTON : this.f5303a;
                j6 j6Var = this.c.f5387a;
                l6 l6Var = new l6();
                l6Var.f5521a = str;
                l6Var.b = str2;
                l6Var.c = str3;
                l6Var.i = s.d(new byte[]{96, 88, 88, 13, 4}, "309fac");
                com.miui.zeus.mimo.sdk.b.a(adEvent2, nativeAdUIController2.d, n6Var2, k6.a(null, clickAreaType2, j6Var, l6Var));
            }
            b bVar = NativeAdUIController.this.f;
            if (bVar != null) {
                bVar.onAdClick();
            }
        }
    }

    public interface b extends NativeAd.NativeAdInteractionListener {
    }

    public NativeAdUIController() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.g = handler;
        this.e = new CommonEventImpl(y8.a());
        this.m = f9.a(y8.a(), 18.0f);
        this.n = f9.a(y8.a(), 60.0f);
        this.o = f9.a(y8.a(), 70.0f);
        this.p = f9.a(y8.a(), 7.0f);
        this.q = f9.a(y8.a(), 41.0f);
        this.h = new AdImpressMonitor(handler);
    }

    public static void a(NativeAdUIController nativeAdUIController) {
        ViewMeasureHelper viewMeasureHelper = new ViewMeasureHelper(nativeAdUIController.f5302a, nativeAdUIController.v, nativeAdUIController.w, new View[]{nativeAdUIController.u}, true, true, false);
        nativeAdUIController.d.V = true;
        nativeAdUIController.f5302a.setTag(Boolean.TRUE);
        com.miui.zeus.mimo.sdk.b.a(AdEvent.VIEW, nativeAdUIController.d, (n6) null, k6.a(nativeAdUIController.j, viewMeasureHelper.f5396a));
        com.miui.zeus.mimo.sdk.b.c(nativeAdUIController.i);
        b bVar = nativeAdUIController.f;
        if (bVar != null) {
            bVar.onAdShow();
        }
    }

    public final SixElementsView a(NativeAdView nativeAdView) {
        SixElementsView sixElementsView = new SixElementsView(nativeAdView.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = f9.a(nativeAdView.getContext(), 20.0f);
        layoutParams.rightMargin = f9.a(nativeAdView.getContext(), 20.0f);
        sixElementsView.setTextColor(-2144128205);
        layoutParams.gravity = BadgeDrawable.BOTTOM_START;
        layoutParams.bottomMargin = f9.a(nativeAdView.getContext(), 8.0f);
        nativeAdView.addView(sixElementsView, layoutParams);
        return sixElementsView;
    }

    public void a() {
        CommonActionHandler commonActionHandler = this.c;
        if (commonActionHandler != null) {
            commonActionHandler.a();
        }
        AdImpressMonitor adImpressMonitor = this.h;
        if (adImpressMonitor != null) {
            this.g.removeCallbacks(adImpressMonitor);
        }
        View view = this.f5302a;
        if (view == null || !(view instanceof NativeAdView)) {
            return;
        }
        ((NativeAdView) view).removeAllViews();
        NativeAdViewBinder nativeAdViewBinder = this.b;
        if (nativeAdViewBinder != null) {
            nativeAdViewBinder.destroy();
            this.b = null;
        }
        this.f5302a = null;
        this.d = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
    }

    public final void a(MimoAdError mimoAdError) {
        b bVar = this.f;
        if (bVar != null) {
            ((NativeAdImpl) bVar).b(mimoAdError, m4.a(DiagnosisStep.KEY_EXCEPTION_WHEN_SHOW_AD, mimoAdError));
        }
    }

    public final boolean a(View view, int i) {
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            if (gradientDrawable.getColor() != null) {
                int colorForState = gradientDrawable.getColor().getColorForState(view.getDrawableState(), 0);
                if (Color.alpha(colorForState) < 255) {
                    return ((double) (Color.alpha(i) - Color.alpha(colorForState))) < 102.0d;
                }
                return ColorUtils.calculateContrast(i, colorForState) <= 1.5d;
            }
        } else if (background instanceof ColorDrawable) {
            int color = ((ColorDrawable) background).getColor();
            if (Color.alpha(color) < 255) {
                return ((double) (Color.alpha(i) - Color.alpha(color))) < 102.0d;
            }
            return ColorUtils.calculateContrast(i, color) <= 1.5d;
        }
        return false;
    }

    @HideMethod(false)
    public boolean a(int i) {
        ClickAreaType clickAreaType;
        if (this.f5302a == null) {
            return true;
        }
        if (i != 1) {
            if (i == 2) {
                clickAreaType = ClickAreaType.TYPE_NATIVE_SCROLL;
            }
            return false;
        }
        clickAreaType = ClickAreaType.TYPE_NATIVE_SHAKE;
        MimoAdInfo mimoAdInfo = this.d;
        if (mimoAdInfo != null) {
            return mimoAdInfo.a(mimoAdInfo.Y, clickAreaType.getTag());
        }
        return false;
    }

    public final void a(View view, ClickAreaType clickAreaType) {
        n6 viewEventInfo;
        if (ApkTools.a() || clickAreaType == ClickAreaType.TYPE_NATIVE_SHAKE || clickAreaType == ClickAreaType.TYPE_NATIVE_SCROLL || clickAreaType == ClickAreaType.TYPE_UNIVERSAL_SLIDE || clickAreaType == ClickAreaType.TYPE_SWIPEUP) {
            if (this.d == null) {
                m.b(s.d(new byte[]{47, 81, 65, 89, Ascii.DC2, 6, 32, 0, 51, 43, 114, 10, 15, 68, 71, 95, 8, 15, 4, Ascii.SYN}, "a050dc"), s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 3, 74, 5, 13, 68, 12, 39, 10, 11, 82, 14, 16, 11, 121, 7, 43, 88, 7, 11, 70, 11, 66, 69, 94, 19, 84, 15}, "0f8cb6"));
                return;
            }
            if (com.miui.zeus.mimo.sdk.b.b(this.f5302a) < this.d.U0) {
                m.b(s.d(new byte[]{42, 4, 77, 90, 19, 1, 32, 0, 51, 43, 114, 10, 10, 17, 75, 92, 9, 8, 4, Ascii.SYN}, "de93ed"), s.d(new byte[]{-125, -79, -115, -36, -80, -38, -123, -36, -21, -121, -94, -24, -127, -119, -96, 3}, "d3497a") + MimoAdError.ERROR_9003.getErrorMsg());
                com.miui.zeus.mimo.sdk.b.a(this.d, s.d(new byte[]{122, 46, 44, 123, 121, 109, 47, 43, 57, 48, 116, 54, 105, 45, 43, 107, 119}, "9be822"), s.d(new byte[]{-42, -73, -127, -127, -80, -113, -123, -36, -21, -121, -94, -24, -44, -113, -84, 94, -46, -115, -34, -127, -9, -24, -44, -53, -120, -48, -95, -52, -48, -82, -27, -115, -26, -19, -41, -3, -65, -48, -126, -62, Ascii.ESC, -47, -18, -53, -114, -31, -116, -128, -98, -119, -48, -29, -125, -47, -40, -37, -125, -13, -69, -125, -90, -107, -34, -41, -94, -47, -48, -15, -127, -58, -117}, "158d74"), System.currentTimeMillis(), (String) null, s.d(new byte[]{-125, -114, -38, -36, -13, -77, -124, -54, -33, -121, -88, -51, -127, -83, -31, -48, -30, -74, -121, -4, -24, -121, -117, -61, 74, -46, -22, -106, -118, -70, -36, -127, -55, -34, -39, -30, -46, -46, -36, -122, -121, -88, -21, -126, -15, -62, -41, -42, -13, -46, -44, -84, -123, -99, -37}, "f7e9b9"));
                return;
            }
            View view2 = this.f5302a;
            n6 n6Var = null;
            if (view2 instanceof NativeAdView) {
                viewEventInfo = ((NativeAdView) view2).getViewEventInfo();
                if (!this.c.c(this.d, clickAreaType)) {
                    return;
                }
                if (clickAreaType != ClickAreaType.TYPE_NATIVE_SHAKE) {
                    View view3 = this.f5302a;
                    if ((view3 instanceof NativeAdView) && ((NativeAdView) view3).getEvent() == 0) {
                        return;
                    }
                }
            } else {
                viewEventInfo = null;
            }
            if (viewEventInfo == null) {
                ViewEventHelper viewEventHelper = this.l;
                if (viewEventHelper != null) {
                    n6Var = viewEventHelper.f5395a;
                }
            } else {
                n6Var = viewEventInfo;
            }
            c6 c6Var = new c6(view, this.f5302a, this.v, this.w, new View[]{this.u}, n6Var, true, true);
            m.a(s.d(new byte[]{127, 88, 66, 80, Ascii.DC4, 81, 32, 0, 51, 43, 114, 10, 95, 77, 68, 86, 14, 88, 4, Ascii.SYN}, "1969b4"), s.d(new byte[]{92, 12, 37, 95, 95, 6, 10, 1, 2}, "3bf36e"));
            View view4 = this.f5302a;
            if (view4 instanceof NativeAdView) {
                ((NativeAdView) view4).resetEvent();
            }
            CommonActionHandler commonActionHandler = this.c;
            commonActionHandler.b = new a(clickAreaType, n6Var, c6Var);
            commonActionHandler.a(this.d, clickAreaType);
        }
    }
}
