package com.ubixnow.ooooo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.stub.StubApp;
import com.ubixnow.adtype.nativead.api.UMNNativeEventListener;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.adtype.reward.api.UMNRewardParams;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;
import com.ubixnow.core.api.UMNImageInfo;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.common.ui.UMNCustomRewardVideoActivity;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.utils.BaseUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o0000Ooo extends UMNCustomRewardAdapter implements Application.ActivityLifecycleCallbacks, o0000.OooO00o {
    private o00000OO OooO;
    public UMNRewardParams OooO00o;
    public Bitmap OooO0O0;
    public Bitmap OooO0OO;
    public UMNCustomNativeAd OooO0oO;
    private o0000 OooO0oo;
    private o000OO OooOO0;
    public Activity OooOO0o;
    public long OooOOO;
    private o0O0O0o0 OooOOOO;
    public final List<View> OooO0Oo = new ArrayList();
    public final UMNNativeExtraInfo OooO0o0 = new UMNNativeExtraInfo();
    public final oo000o<o0000Ooo> OooO0o = new OooO00o();
    private String OooOO0O = "";
    private int OooOOO0 = 0;
    public final View.OnClickListener OooOOOo = new OooO0O0();
    public final UMNNativeEventListener OooOOo0 = new OooO0OO();
    public final o0O0O00 OooOOo = new OooO0o();

    public class OooO extends o00000OO.OooO0O0 {
        public OooO() {
        }

        @Override // com.ubixnow.ooooo.o00000OO.OooO0O0
        public void OooO00o(long j) {
            if (o0000Ooo.this.OooOO0 != null) {
                o0000Ooo.this.OooOO0.OooO00o(j);
            }
        }

        @Override // com.ubixnow.ooooo.o00000OO.OooO0O0
        public void OooO0O0() {
            if (o0000Ooo.this.OooOO0 != null) {
                o0000Ooo.this.OooOO0.OooOO0();
            }
            if (o0000Ooo.this.OooO0oo != null) {
                o0000Ooo.this.OooO0oo.OooO0o0();
            }
        }
    }

    public class OooO00o extends oo000o<o0000Ooo> {
        public OooO00o() {
        }
    }

    public class OooO0O0 implements View.OnClickListener {
        public OooO0O0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UMNCustomNativeAd uMNCustomNativeAd = o0000Ooo.this.OooO0oO;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.notifyAdDislikeClick();
            }
        }
    }

    public class OooO0OO implements UMNNativeEventListener {
        public OooO0OO() {
        }

        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
        public void onAdClicked() {
            o0000Ooo.this.showLog(o00OO0O0.TAG, "onAdClicked");
            if (o0000Ooo.this.OooOOOO != null) {
                o0000Ooo.this.OooOOOO.OooO0o0();
            }
            if (o0000Ooo.this.OooO0oo != null) {
                o0000Ooo.this.OooO0oo.onAdClicked();
            }
        }

        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
        public void onAdClose() {
            o0000Ooo.this.showLog(o00OO0O0.TAG, "onAdClose");
            if (o0000Ooo.this.OooO0oo != null) {
                o0000Ooo.this.OooO0oo.onAdClose();
            }
            o0000Ooo.this.destory();
        }

        @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
        public void onAdExposure() {
            o0000Ooo.this.showLog(o00OO0O0.TAG, "onAdExposure");
            if (o0000Ooo.this.OooO0oo != null) {
                o0000Ooo.this.OooO0oo.onAdExposure();
            }
        }
    }

    public class OooO0o extends o0O0O00 {
        public OooO0o() {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            o0000Ooo.this.showLog(o00OO0O0.TAG, "onAdCacheSuccess");
            o0000Ooo.this.callAdCacheSuccess(oo00oVar);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
            o0000Ooo.this.showLog(o00OO0O0.TAG, "onAdDataLoaded");
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
            o0000Ooo.this.showLog(o00OO0O0.TAG, "onAdRenderFail");
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
            o0000Ooo.this.showLog(o00OO0O0.TAG, "onAdFailed: " + errorInfo.toString());
            o0000Ooo.this.callNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, errorInfo.platFormCode, errorInfo.platFormMsg).setInfo((Object) o0000Ooo.this.absUbixInfo));
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
            o0000Ooo.this.showLog(o00OO0O0.TAG, "onTimeout");
        }
    }

    public class OooOO0 implements Runnable {
        public OooOO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o0000Ooo.this.OooO0OO();
        }
    }

    public class OooOO0O implements oO0000Oo.OooO0o {
        public final /* synthetic */ oo00o OooO00o;

        public OooOO0O(oo00o oo00oVar) {
            this.OooO00o = oo00oVar;
        }

        @Override // com.ubixnow.ooooo.oO0000Oo.OooO0o
        public void OooO00o(Bitmap bitmap, byte[] bArr, String str, String str2) {
            o0000Ooo o0000ooo = o0000Ooo.this;
            o0000ooo.OooO0O0 = bitmap;
            if (bitmap == null || str2 == null) {
                o0000ooo.showLog(o00OO0O0.TAG, " img download error ");
                this.OooO00o.checkMaterialStatus = 11;
            }
            o0000Ooo.this.loadListener.onAdCacheSuccess(this.OooO00o);
        }
    }

    public class OooOOO implements oO0000Oo.OooO0o {
        public OooOOO() {
        }

        @Override // com.ubixnow.ooooo.oO0000Oo.OooO0o
        public void OooO00o(Bitmap bitmap, byte[] bArr, String str, String str2) {
            o0000Ooo.this.OooO0O0 = bitmap;
        }
    }

    public class OooOOO0 implements oO0000Oo.OooO0o {
        public OooOOO0() {
        }

        @Override // com.ubixnow.ooooo.oO0000Oo.OooO0o
        public void OooO00o(Bitmap bitmap, byte[] bArr, String str, String str2) {
            o0000Ooo.this.OooO0OO = bitmap;
        }
    }

    static {
        o00OO0O0.TAG = "------o0000Ooo";
    }

    private void OooO00o() {
        oO0000Oo.OooO00o(BaseUtils.getContext()).OooO00o(getAppIconUrl(), 10, new OooOOO0());
    }

    private void OooO00o(Activity activity) {
        o000OO o0000o;
        LinearLayout linearLayout = new LinearLayout(activity);
        activity.setContentView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        o000OO.OooO00o oooO00o = new o000OO.OooO00o();
        oooO00o.OooO00o = this.OooO0oO;
        oooO00o.OooO0OO = this.OooO0o;
        oooO00o.OooO0O0 = this;
        oooO00o.OooO0Oo = this.OooO0O0;
        oooO00o.OooO0o0 = this.OooO0OO;
        oooO00o.OooO0oO = oOO00000.OooO00o(this.OooO00o.width);
        oooO00o.OooO0oo = oOO00000.OooO00o(this.OooO00o.height);
        if (this.OooOOO0 == 1) {
            activity.setRequestedOrientation(1);
            o0000o = new o0000OO0(activity, oooO00o);
        } else {
            activity.setRequestedOrientation(0);
            o0000o = new o0000O(activity, oooO00o);
        }
        this.OooOO0 = o0000o;
        this.OooOO0.OooO0OO.post(new OooOO0());
        o00O000 baseAdConfig = this.absUbixInfo.getBaseAdConfig();
        oo00o<UMNCustomRewardAdapter> oo00oVar = this.absUbixInfo;
        o000OO o000oo = this.OooOO0;
        o0O0O0o0 o0o0o0o0 = new o0O0O0o0(baseAdConfig, oo00oVar, o000oo.OooO0OO, o000oo.OooO0oO, oooO00o.OooO0oO, oooO00o.OooO0oo);
        this.OooOOOO = o0o0o0o0;
        o0o0o0o0.OooO0OO();
        linearLayout.addView(this.OooOO0.OooO0OO);
        regist(this.OooOO0.OooO0o0);
    }

    private void OooO00o(UMNNativeExtraInfo uMNNativeExtraInfo) {
        View closeView;
        if (uMNNativeExtraInfo == null || uMNNativeExtraInfo.getCloseView() == null || (closeView = uMNNativeExtraInfo.getCloseView()) == null) {
            return;
        }
        closeView.setOnClickListener(this.OooOOOo);
    }

    private void OooO00o(String str) {
        o0000 o0000Var = this.OooO0oo;
        if (o0000Var != null) {
            o0000Var.OooO00o(oOO00O0.ubix_show_error, str);
            this.OooO0oo.onAdClose();
        }
    }

    private void OooO0O0() {
        oO0000Oo.OooO00o(BaseUtils.getContext()).OooO00o(getVideoCoverUrl(), 10, new OooOOO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO0OO() {
        try {
            this.OooO.OooO0oO();
            o0000 o0000Var = this.OooO0oo;
            if (o0000Var != null) {
                o0000Var.OooO0o();
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    public void callAdCacheSuccess(oo00o oo00oVar) {
        try {
            this.OooO0oO = ((oo000o) oo00oVar).OooO00o.get(0);
            if (this.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                showLog(o00OO0O0.TAG, "price:" + oo00oVar.getBiddingEcpm());
                this.absUbixInfo.setBiddingEcpm(oo00oVar.getBiddingEcpm());
            }
            oo00o<UMNCustomRewardAdapter> oo00oVar2 = this.absUbixInfo;
            oo00oVar2.material = oo00oVar.material;
            oo00oVar2.materialStatus = oo00oVar.materialStatus;
            int i = oo00oVar.checkMaterialStatus;
            oo00oVar2.checkMaterialStatus = i;
            if (i > 0) {
                this.loadListener.onAdCacheSuccess(oo00oVar);
                return;
            }
            if (isVideo()) {
                OooO0O0();
                o00O00o0 o00o00o0 = this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onAdCacheSuccess(oo00oVar);
                }
            } else {
                loadImg(getMainImageUrl(), this.absUbixInfo);
            }
            OooO00o();
            UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.setNativeEventListener(this.OooOOo0);
                this.OooO0oO.setNativeMediaListener(this.OooO0oo);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    public void callNoAdError(ErrorInfo errorInfo) {
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(errorInfo);
        }
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void createADInfo(o00O000 o00o000) {
        super.createADInfo(o00o000);
        this.OooO0o.setAbsBaseAdapter(this);
        this.OooO0o.setBaseAdConfig(o00o000);
        oo000o<o0000Ooo> oo000oVar = this.OooO0o;
        oo000oVar.isMuteIndependent = true;
        oo000oVar.isAutoPlayIndependent = true;
        oo000oVar.adType = "12";
        this.OooOOO0 = BaseUtils.getContext().getResources().getConfiguration().orientation;
        UMNRewardParams uMNRewardParams = (UMNRewardParams) o00o000.OooO0o0;
        this.OooO00o = uMNRewardParams;
        uMNRewardParams.width = oOO00000.OooO0O0(oOO00000.OooO0Oo(BaseUtils.getContext()));
        this.OooO00o.height = oOO00000.OooO0O0(oOO00000.OooO0OO(BaseUtils.getContext()));
        o0000 o0000VarOooO0O0 = o0000.OooO0O0(this.absUbixInfo);
        this.OooO0oo = o0000VarOooO0O0;
        o0000VarOooO0O0.OooO0o = this;
        long j = this.absUbixInfo.getBaseAdConfig().OooOOO0.OoooO0O;
        this.OooOOO = j;
        if (j < 10 || j > 30) {
            this.OooOOO = 15L;
        }
        this.OooO = new o00000OO(this.OooOOO, new OooO());
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            o0000 o0000Var = this.OooO0oo;
            if (o0000Var != null) {
                o0000Var.OooO0OO();
            }
            UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.destroy();
            }
            o00000OO o00000oo = this.OooO;
            if (o00000oo != null) {
                o00000oo.OooO00o();
            }
            Bitmap bitmap = this.OooO0O0;
            if (bitmap != null) {
                bitmap.recycle();
                this.OooO0O0 = null;
            }
            Bitmap bitmap2 = this.OooO0OO;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.OooO0OO = null;
            }
            ((Application) StubApp.getOrigApplicationContext(BaseUtils.getContext().getApplicationContext())).unregisterActivityLifecycleCallbacks(this);
            o000OO o000oo = this.OooOO0;
            if (o000oo != null) {
                o000oo.OooO0OO();
            }
            Activity activity = this.OooOO0o;
            if (activity != null) {
                activity.finish();
                this.OooOO0o = null;
            }
        } catch (Throwable th) {
            showLog(o00OO0O0.TAG, "destroy  e " + th.getMessage());
        }
    }

    @Override // com.ubixnow.ooooo.o0000.OooO00o
    public Bitmap getAppIconBitmap() {
        return this.OooO0OO;
    }

    public String getAppIconUrl() {
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        return uMNCustomNativeAd == null ? "" : uMNCustomNativeAd.getIconImageUrl();
    }

    @Override // com.ubixnow.ooooo.o0000.OooO00o
    public View getClickView() {
        if (this.OooO0Oo.isEmpty()) {
            return null;
        }
        return this.OooO0Oo.get(0);
    }

    @Override // com.ubixnow.ooooo.o0000.OooO00o
    public long getCountDownSeconds() {
        return this.OooOOO;
    }

    public abstract String getLogoText();

    public String getMainImageUrl() {
        List<UMNImageInfo> imageUrlList;
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        if (uMNCustomNativeAd == null) {
            return "";
        }
        String mainImageUrl = uMNCustomNativeAd.getMainImageUrl();
        return (!TextUtils.isEmpty(mainImageUrl) || (imageUrlList = this.OooO0oO.getImageUrlList()) == null || imageUrlList.isEmpty()) ? mainImageUrl : imageUrlList.get(0).url;
    }

    @Override // com.ubixnow.ooooo.o0000.OooO00o
    public ViewGroup getPopWindowRoot() {
        o000OO o000oo = this.OooOO0;
        if (o000oo != null) {
            return o000oo.OooO0Oo;
        }
        return null;
    }

    public UMNNativeParams getUMNNativeParams() {
        return new UMNNativeParams.Builder().setSlotId(this.mBaseAdConfig.OooO00o.OooO0o0).setHeight(oOO00000.OooO00o(this.OooO00o.height)).setWidth(oOO00000.OooO00o(this.OooO00o.width)).build();
    }

    public String getVideoCoverUrl() {
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        return uMNCustomNativeAd == null ? "" : uMNCustomNativeAd.getVideoCoverUrl();
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        if (uMNCustomNativeAd != null) {
            return uMNCustomNativeAd.isValid();
        }
        return false;
    }

    public boolean isVideo() {
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        return uMNCustomNativeAd != null && "1".equals(uMNCustomNativeAd.getAdType());
    }

    public void loadImg(String str, oo00o oo00oVar) {
        if (TextUtils.isEmpty(str)) {
            oo00oVar.checkMaterialStatus = 11;
            this.loadListener.onAdCacheSuccess(oo00oVar);
        } else {
            this.loadListener.onAdDataLoaded(oo00oVar);
            oO0000Oo.OooO00o(BaseUtils.getContext()).OooO00o(str, 10, new OooOO0O(oo00oVar));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.notifyLoss(o00oo0oo);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
            if (uMNCustomNativeAd != null) {
                uMNCustomNativeAd.notifyWin(o00oo0oo);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.OooOO0O.equals(activity.getIntent().getStringExtra("uniqueId"))) {
            this.OooOO0o = activity;
            try {
                OooO00o(activity);
            } catch (Throwable th) {
                ooooO000.OooO00o(th);
                OooO00o(th.getMessage());
                if (this.OooOO0o != null) {
                    this.OooOO0o.finish();
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity == this.OooOO0o) {
            this.OooOO0o = null;
            destory();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (activity == this.OooOO0o) {
            o00000OO o00000oo = this.OooO;
            if (o00000oo != null) {
                o00000oo.OooO0Oo();
            }
            o0000 o0000Var = this.OooO0oo;
            if (o0000Var != null) {
                o0000Var.OooO0oO();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity == this.OooOO0o) {
            o00000OO o00000oo = this.OooO;
            if (o00000oo != null) {
                o00000oo.OooO0o();
            }
            o0000 o0000Var = this.OooO0oo;
            if (o0000Var != null) {
                o0000Var.OooO0oo();
            }
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
    }

    @Override // com.ubixnow.ooooo.o0000.OooO00o
    public void onRewardVerify(oo00o oo00oVar) {
        o00000OO o00000oo = this.OooO;
        if (o00000oo != null) {
            o00000oo.OooO00o();
        }
        o000OO o000oo = this.OooOO0;
        if (o000oo != null) {
            o000oo.OooOO0();
        }
    }

    public void regist(ViewGroup viewGroup) {
        View viewOooO0Oo;
        this.OooO0Oo.addAll(this.OooOO0.OooO0o);
        View viewOooO0O0 = this.OooOOOO.OooO0O0();
        if (viewOooO0O0 != null) {
            this.OooO0Oo.add(viewOooO0O0);
        }
        o0000 o0000Var = this.OooO0oo;
        if (o0000Var != null && (viewOooO0Oo = o0000Var.OooO0Oo()) != null) {
            this.OooO0Oo.add(viewOooO0Oo);
        }
        this.OooO0o0.setCloseView(this.OooOO0.OooO0oO);
        this.OooO0o0.setClickViewList(this.OooO0Oo);
        OooO00o(this.OooO0o0);
        UMNCustomNativeAd uMNCustomNativeAd = this.OooO0oO;
        if (uMNCustomNativeAd != null) {
            uMNCustomNativeAd.regist(viewGroup, this.OooO0o0);
        }
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void show(Activity activity) {
        try {
            this.OooO0oo.OooO0o0 = this.eventListener;
            Context context = BaseUtils.getContext();
            ((Application) StubApp.getOrigApplicationContext(context.getApplicationContext())).registerActivityLifecycleCallbacks(this);
            Intent intent = new Intent(context, (Class<?>) UMNCustomRewardVideoActivity.class);
            String string = UUID.randomUUID().toString();
            this.OooOO0O = string;
            intent.putExtra("uniqueId", string);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            OooO00o(th.getMessage());
            destory();
        }
    }
}
