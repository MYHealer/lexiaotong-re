package com.adprof.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.adprof.sdk.api.AFNativeAdMediaView;
import com.adprof.sdk.api.AdAppInfo;
import com.adprof.sdk.api.NativeAdData;
import com.adprof.sdk.api.NativeAdEventListener;
import com.adprof.sdk.base.fb.FBView;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ef implements NativeAdData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AdAppInfo f246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public df f247a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final f0 f248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final i0 f249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pf f250a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd f251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f253a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f254b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final String f255c;
    public final String d;

    public ef(d dVar, df dfVar, int i, int i2, wd wdVar) {
        this.f252a = dVar.j();
        this.f254b = dVar.g();
        this.d = dVar.d();
        this.f255c = dVar.i();
        this.f253a = dVar.m595a();
        this.f1149a = dVar.c();
        this.b = dVar.a();
        this.c = dVar.b();
        this.f246a = dVar.m588a();
        this.f249a = dVar.m589a();
        this.f247a = dfVar;
        this.f251a = wdVar;
        f0 f0Var = new f0();
        this.f248a = f0Var;
        f0Var.a(dVar, this);
        a(dVar, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00f7  */
    public final void a(d dVar, int i, int i2) {
        pf qfVar;
        Bundle bundle = new Bundle();
        int i3 = dVar.f180a;
        int i4 = 2;
        if (dVar.m605f()) {
            if (i3 == 5) {
                i3 = 1;
            } else if (i3 == 6) {
                i3 = 2;
            }
        }
        wd wdVar = this.f251a;
        boolean z = (wdVar == null || wdVar.f794a == null || !wdVar.f794a.getIsExpressAd().booleanValue()) ? false : true;
        pk.a("---------is_express_AD = " + z);
        if (z) {
            Context context = AdprofSdk.getInstance().getContext();
            pf.d = i3;
            pk.a("templateId =======" + i3);
            if (i3 == 2) {
                qfVar = new qf(context);
            } else if (i3 == 3) {
                qfVar = new vf(context);
            } else if (i3 == 4) {
                qfVar = new yf(context);
            } else if (i3 != 5) {
                qfVar = i3 != 6 ? new zf(context) : new rf(context);
            } else {
                qfVar = new ag(context);
            }
            this.f250a = qfVar;
        }
        if (this.f250a != null) {
            bundle.putInt("AD_WIDTH", i);
            bundle.putInt("AD_HEIGHT", i2);
            pf pfVar = this.f250a;
            pfVar.getClass();
            try {
                pfVar.f582a = dVar;
                int iNextInt = new Random().nextInt(100) + 1;
                pfVar.c = iNextInt;
                pfVar.f582a.h = iNextInt;
                pfVar.f1365a = bundle.getInt("AD_WIDTH");
                pfVar.b = bundle.getInt("AD_HEIGHT");
                String str = dVar.f202d;
                pfVar.f589b = str;
                if (TextUtils.isEmpty(str)) {
                    pfVar.f589b = !dVar.f203e.isEmpty() ? dVar.f203e : "";
                }
                pfVar.f586a = dVar.m594a();
                pfVar.a(bundle, dVar);
                pfVar.b();
                int i5 = dVar.f180a;
                if (!dVar.m605f()) {
                    i4 = i5;
                } else if (i5 == 5) {
                    i4 = 1;
                } else if (i5 != 6) {
                    i4 = i5;
                }
                pfVar.a(i4);
                pfVar.m704a(dVar, i4);
                fn.a(new ff(pfVar), 500L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f250a.f583a = this;
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public void bindMediaView(ViewGroup viewGroup, NativeAdData.NativeAdMediaListener nativeAdMediaListener) {
        pk.a("NativeAdUnitObject bindMediaView: " + viewGroup + PPSLabelView.Code + nativeAdMediaListener);
        try {
            f0 f0Var = this.f248a;
            if (f0Var != null) {
                f0Var.a(viewGroup, getVideoWidth(), getVideoHeight(), nativeAdMediaListener);
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public void bindViewForInteraction(View view, List list, NativeAdEventListener nativeAdEventListener) {
        pk.a("NativeAdUnitObject bindViewForInteraction: " + view + PPSLabelView.Code + list);
        try {
            f0 f0Var = this.f248a;
            if (f0Var != null) {
                f0Var.a(view, list, nativeAdEventListener);
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public void destroy() {
        we weVar;
        pk.a("NativeAdUnitObject destroy");
        f0 f0Var = this.f248a;
        if (f0Var != null) {
            f0Var.getClass();
            try {
                f0Var.f284a = false;
                ll.a(f0Var.f277a);
                Object[] objArr = new Object[1];
                d dVar = f0Var.f277a;
                objArr[0] = dVar != null ? dVar.l : "null";
                pk.c(String.format("native ad data %s is Destroy", objArr));
                f0Var.a(f0Var.f282a, (View.OnTouchListener) null);
                f0Var.a(f0Var.f283a, (View.OnTouchListener) null);
                f0Var.f282a.clear();
                List list = f0Var.f283a;
                if (list != null) {
                    list.clear();
                }
                f0Var.f275a = null;
                xe xeVarM619a = f0Var.m619a();
                if (xeVarM619a != null) {
                    ((n5) xeVarM619a).f511a = null;
                }
                AFNativeAdMediaView aFNativeAdMediaView = f0Var.f272a;
                if (aFNativeAdMediaView != null) {
                    hp.m656a((View) aFNativeAdMediaView);
                    f0Var.f272a.destroy();
                    f0Var.f272a = null;
                }
                q qVar = f0Var.f279a;
                if (qVar != null) {
                    qVar.a();
                    f0.f1160a.remove(f0Var.f279a);
                    hp.m656a((View) f0Var.f279a);
                    f0Var.f279a = null;
                }
                f0Var.f273a = null;
                d dVar2 = f0Var.f277a;
                h2 h2Var = h2.f1202a;
                if (dVar2 != null && !TextUtils.isEmpty(dVar2.k())) {
                    ((HashMap) h2.f330a).remove(dVar2.k());
                }
                k kVar = f0Var.f278a;
                if (kVar != null) {
                    kVar.setAdVisibilityStatusChangeListener(null);
                    hp.m656a((View) f0Var.f278a);
                    f0Var.f278a = null;
                }
                ze zeVar = f0Var.f281a;
                if (zeVar != null && (weVar = zeVar.f912a) != null) {
                    weVar.b();
                    zeVar.f912a = null;
                }
                ImageView imageView = f0Var.f270a;
                if (imageView != null) {
                    if (imageView.getParent() != null) {
                        ((ViewGroup) f0Var.f270a.getParent()).removeView(f0Var.f270a);
                    }
                    f0Var.f270a = null;
                }
                FBView fBView = f0Var.f276a;
                if (fBView != null) {
                    hp.m656a((View) fBView);
                    f0Var.f276a = null;
                }
                TextView textView = f0Var.f271a;
                if (textView != null) {
                    hp.m656a((View) textView);
                    f0Var.f271a = null;
                }
                d dVar3 = f0Var.f277a;
                if (dVar3 != null) {
                    dVar3.m596a();
                }
            } catch (Exception e) {
                pk.a(e);
                oh.b(e);
            }
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public AdAppInfo getAdAppInfo() {
        return this.f246a;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public int getAdInteractiveType() {
        pk.a("NativeAdUnitObject getAdInteractiveType: " + this.c);
        return this.c;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public Bitmap getAdLogoBitmap() {
        try {
            Drawable adLogoDrawable = getAdLogoDrawable();
            if (adLogoDrawable == null) {
                return null;
            }
            int intrinsicWidth = adLogoDrawable.getIntrinsicWidth();
            int intrinsicHeight = adLogoDrawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0) {
                intrinsicWidth = 1;
            }
            if (intrinsicHeight <= 0) {
                intrinsicHeight = 1;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            adLogoDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            adLogoDrawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public Drawable getAdLogoDrawable() {
        try {
            Context context = AdprofSdk.getInstance().getContext();
            if (context != null) {
                return context.getDrawable(R.drawable.adprof_ad_logo);
            }
            return null;
        } catch (Exception e) {
            pk.b("NativeAdUnitObject getAdLogoDrawable error", e);
            Context context2 = AdprofSdk.getInstance().getContext();
            if (context2 == null) {
                return null;
            }
            try {
                int identifier = context2.getResources().getIdentifier("adprof_ad_logo", "drawable", BuildConfig.LIBRARY_PACKAGE_NAME);
                if (identifier != 0) {
                    return context2.getDrawable(identifier);
                }
                return null;
            } catch (Exception e2) {
                pk.b("NativeAdUnitObject getAdLogoDrawable fallback error", e2);
                return null;
            }
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public int getAdPatternType() {
        pk.a("NativeAdUnitObject getAdPatternType: " + this.b);
        return this.b;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public int getBidPrice() {
        pk.a("NativeAdUnitObject getPrice: " + this.f1149a);
        return this.f1149a;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public String getCTAText() {
        pk.a("NativeAdUnitObject getCTAText: " + this.d);
        return this.d;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public String getDesc() {
        pk.a("NativeAdUnitObject getDesc: " + this.f254b);
        return this.f254b;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public View getFeedView() {
        return this.f250a;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public String getIconUrl() {
        pk.a("NativeAdUnitObject getIconUrl: " + this.f255c);
        return this.f255c;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public List getImageList() {
        pk.a("NativeAdUnitObject getImageList: " + this.f253a);
        return this.f253a;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public View getMediaView(Context context) {
        try {
            f0 f0Var = this.f248a;
            if (f0Var == null) {
                return null;
            }
            f0Var.getClass();
            try {
                if (f0Var.f272a == null) {
                    f0Var.f272a = new AFNativeAdMediaView(context);
                }
                f0Var.b();
                f0Var.c();
            } catch (Throwable th) {
                pk.a(th);
                oh.b(th);
            }
            return f0Var.f272a;
        } catch (Throwable th2) {
            pk.a(th2);
            oh.b(th2);
            return null;
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public String getTitle() {
        pk.a("NativeAdUnitObject getTitle: " + this.f252a);
        return this.f252a;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public double getVideoDuration() {
        j0 j0VarM617a;
        pk.a("NativeAdUnitObject getVideoDuration");
        f0 f0Var = this.f248a;
        double duration = 0.0d;
        if (f0Var != null && (j0VarM617a = f0Var.m617a()) != null) {
            po poVarA = ((k0) j0VarM617a).a();
            duration = (poVarA == null || poVarA.getDuration() == 0) ? 0 : (int) (poVarA.getDuration() / 1000);
        }
        pk.a("NativeAdUnitObject getVideoDuration ret: " + duration);
        return duration;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public int getVideoHeight() {
        i0 i0Var = this.f249a;
        int i = i0Var != null ? i0Var.b : 0;
        pk.a("NativeAdUnitObject getVideoHeight hei: " + i);
        return i;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public int getVideoWidth() {
        i0 i0Var = this.f249a;
        int i = i0Var != null ? i0Var.f1219a : 0;
        pk.a("NativeAdUnitObject getVideoWidth ret: " + i + " video: " + this.f249a);
        return i;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public View getWidgetView(int i, int i2) {
        q qVarA;
        try {
            f0 f0Var = this.f248a;
            qVarA = f0Var != null ? f0Var.a(i, i2) : null;
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
        pk.a("NativeAdUnitObject getWidgetView ret: " + qVarA + " w: " + i + PPSLabelView.Code + i2);
        return qVarA;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public boolean isExpressAd() {
        return this.f250a != null;
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public void pauseVideo() {
        j0 j0VarM617a;
        pk.a("NativeAdUnitObject pauseVideo");
        f0 f0Var = this.f248a;
        if (f0Var == null || (j0VarM617a = f0Var.m617a()) == null) {
            return;
        }
        f0Var.b = true;
        ((k0) j0VarM617a).m666a();
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public void resumeVideo() {
        j0 j0VarM617a;
        po poVarA;
        pk.a("NativeAdUnitObject resumeVideo");
        f0 f0Var = this.f248a;
        if (f0Var == null || (j0VarM617a = f0Var.m617a()) == null || (poVarA = ((k0) j0VarM617a).a()) == null) {
            return;
        }
        poVarA.e();
    }

    @Override // com.adprof.sdk.api.IBiddingNotify
    public void sendLossNotify(Map map) {
        pk.a("NativeAdUnitObject sendLossNotification: " + this.f247a + " map = " + map);
        df dfVar = this.f247a;
        if (dfVar != null) {
            dfVar.sendLossNotify(map);
        }
    }

    @Override // com.adprof.sdk.api.IBiddingNotify
    public void sendWinNotify(Map map) {
        pk.a("NativeAdUnitObject sendWinNotification: " + this.f247a + " map = " + map);
        df dfVar = this.f247a;
        if (dfVar != null) {
            dfVar.sendWinNotify(map);
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public void setMediaListener(NativeAdData.NativeAdMediaListener nativeAdMediaListener) {
        pk.a("NativeAdUnitObject setMediaListener: " + nativeAdMediaListener);
        try {
            f0 f0Var = this.f248a;
            if (f0Var != null) {
                f0Var.f273a = nativeAdMediaListener;
                if (f0Var.f272a != null) {
                    f0Var.b();
                    f0Var.c();
                    pk.a("NativeAdRender setMediaListener ");
                    f0Var.f273a = nativeAdMediaListener;
                    j0 videoAdController = f0Var.f272a.getVideoAdController();
                    if (videoAdController != null) {
                        ((k0) videoAdController).f1257a = new x(f0Var);
                    }
                }
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public void setNativeAdEventListener(NativeAdEventListener nativeAdEventListener) {
        pf pfVar = this.f250a;
        if (pfVar != null) {
            pfVar.setNativeAdEventListener(nativeAdEventListener);
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public void setNativeAdMediaListener(NativeAdData.NativeAdMediaListener nativeAdMediaListener) {
        pf pfVar = this.f250a;
        if (pfVar != null) {
            pfVar.setNativeAdMediaListener(nativeAdMediaListener);
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public void setVideoMute(boolean z) {
        j0 j0VarM617a;
        po poVarA;
        pk.a("NativeAdUnitObject setVideoMute: " + z);
        f0 f0Var = this.f248a;
        if (f0Var == null || (j0VarM617a = f0Var.m617a()) == null || (poVarA = ((k0) j0VarM617a).a()) == null) {
            return;
        }
        poVarA.setSoundChange(z);
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public void showCloseView(boolean z) {
        f0 f0Var = this.f248a;
        if (f0Var != null) {
            f0Var.f = z;
            ImageView imageView = f0Var.f270a;
            if (imageView != null) {
                imageView.post(new y(f0Var, z));
            }
        }
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public void startVideo() {
        j0 j0VarM617a;
        pk.a("NativeAdUnitObject startVideo");
        f0 f0Var = this.f248a;
        if (f0Var == null || (j0VarM617a = f0Var.m617a()) == null) {
            return;
        }
        ((k0) j0VarM617a).a(f0Var.f277a);
    }

    @Override // com.adprof.sdk.api.NativeAdData
    public void stopVideo() {
        j0 j0VarM617a;
        po poVarA;
        pk.a("NativeAdUnitObject stopVideo");
        f0 f0Var = this.f248a;
        if (f0Var == null || (j0VarM617a = f0Var.m617a()) == null || (poVarA = ((k0) j0VarM617a).a()) == null) {
            return;
        }
        poVarA.m();
    }

    public String toString() {
        return "NativeAdUnitObject{mTitle='" + this.f252a + "', mDescription='" + this.f254b + "', mIconUrl='" + this.f255c + "', mSourceUrl='null', mCTAText='" + this.d + "', mPrice=" + this.f1149a + ", mImageList=" + this.f253a + ", mVideo=" + this.f249a + ", mAdPatternType=" + this.b + ", mAdInteractiveType=" + this.c + ", adAppInfo=" + this.f246a + ", mNativeAdRender=" + this.f248a + ", adManager=" + this.f247a + '}';
    }
}
