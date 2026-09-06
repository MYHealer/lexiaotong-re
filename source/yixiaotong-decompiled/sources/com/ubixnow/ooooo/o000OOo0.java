package com.ubixnow.ooooo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ubixnow.adtype.nativead.api.UMNNativeShakeView;
import com.ubixnow.adtype.nativead.api.UMNNativeTemplateAdView;
import com.ubixnow.adtype.splash.api.UMNSplashParams;
import com.ubixnow.adtype.splash.common.CountdownView;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.R;
import com.ubixnow.core.api.UMNAdConstant;
import com.ubixnow.core.api.UbixDefaultConstants;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.common.ui.UMNFrameLayout;
import com.ubixnow.core.utils.img.CustomImageView;
import com.ubixnow.utils.BaseUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o000OOo0 extends UMNCustomSplashAdapter {
    private UMNFrameLayout OooO;
    public CustomImageView OooO00o;
    public TextView OooO0O0;
    public View OooO0OO;
    private CountdownView OooO0Oo;
    private Timer OooO0o;
    public boolean OooO0o0;
    public ViewGroup OooO0oo;
    private UMNSplashParams OooOO0;
    private TimerTask OooOO0O;
    public Bitmap OooOO0o;
    public View OooOOO0;
    public UMNNativeTemplateAdView OooOOo;
    private View OooOOo0;
    public TextView OooOOoo;
    public int OooOo0;
    public TextView OooOo00;
    public int OooOo0O;
    public o0O0OO0 OooOoO;
    public boolean OooOoO0;
    private int OooO0oO = 5;
    public List<View> OooOOO = new ArrayList();
    public int OooOOOO = 2;
    public UMNNativeExtraInfo OooOOOo = new UMNNativeExtraInfo();
    public float OooOo0o = 0.0f;
    public float OooOo = 0.0f;

    public class OooO00o implements oO0000Oo.OooO0o {
        public final /* synthetic */ boolean OooO00o;
        public final /* synthetic */ oo00o OooO0O0;

        public OooO00o(boolean z, oo00o oo00oVar) {
            this.OooO00o = z;
            this.OooO0O0 = oo00oVar;
        }

        @Override // com.ubixnow.ooooo.oO0000Oo.OooO0o
        public void OooO00o(Bitmap bitmap, byte[] bArr, String str, String str2) {
            o000OOo0 o000ooo0 = o000OOo0.this;
            o000ooo0.OooOO0o = bitmap;
            if (bitmap == null || str2 == null) {
                o000ooo0.showLog(o00OO0O0.TAG, " img download error ");
                if (this.OooO00o) {
                    this.OooO0O0.checkMaterialStatus = 11;
                }
            }
            if (this.OooO00o) {
                o000OOo0.this.loadListener.onAdCacheSuccess(this.OooO0O0);
            }
        }
    }

    public class OooO0O0 implements View.OnClickListener {
        public OooO0O0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o000OOo0.this.OooO0o0();
        }
    }

    public class OooO0OO implements View.OnClickListener {
        public OooO0OO() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o000OOo0.this.OooO0o0();
        }
    }

    public class OooO0o extends TimerTask {

        public class OooO00o implements Runnable {
            public OooO00o() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    o000OOo0.this.OooO0oO--;
                    if (o000OOo0.this.OooO0oO != 0) {
                        TextView textView = o000OOo0.this.OooO0O0;
                        if (textView != null) {
                            textView.setText("跳过" + o000OOo0.this.OooO0oO);
                        }
                    } else if (o000OOo0.this.eventListener != null) {
                        o000OOo0.this.eventListener.onAdDismiss(o000OOo0.this.splashInfo);
                        OooO0o.this.cancel();
                        if (o000OOo0.this.OooO0o != null) {
                            o000OOo0.this.OooO0o.cancel();
                        }
                    }
                } catch (Throwable th) {
                    ooooO000.OooO00o(th);
                }
            }
        }

        public OooO0o() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            BaseUtils.runInMainThread(new OooO00o());
        }
    }

    private void OooO00o() {
        o0O0OO0 o0o0oo0 = new o0O0OO0(this.mBaseAdConfig, this.splashInfo, this.OooO0oo, this.OooOOo0);
        this.OooOoO = o0o0oo0;
        o0o0oo0.OooO0OO();
        this.OooOOO.add(this.OooOOO0);
        View viewOooO0O0 = this.OooOoO.OooO0O0();
        if (viewOooO0O0 != null) {
            this.OooOOO.add(viewOooO0O0);
        }
    }

    private void OooO00o(ViewGroup viewGroup) {
        Bitmap bitmap = this.OooOO0o;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.OooO.setBackground(new BitmapDrawable(viewGroup.getResources(), ooOOO00O.OooO00o(this.OooOO0o)));
        if (this.OooO0OO == null) {
            this.OooO00o.setImageBitmap(this.OooOO0o);
        }
    }

    private void OooO00o(FrameLayout.LayoutParams layoutParams, float f) {
        float f2 = layoutParams.width;
        float f3 = layoutParams.height * f;
        if (f2 > f3) {
            layoutParams.width = (int) f3;
        } else {
            layoutParams.height = (int) (f2 / f);
        }
    }

    private void OooO0O0() {
        int i = this.OooOO0.width;
        this.OooOo0 = i < 1 ? oOO00000.OooO0o(BaseUtils.getContext()) : oOO00000.OooO00o(i);
        int i2 = this.OooOO0.height;
        this.OooOo0O = i2 < 1 ? oOO00000.OooO0o0(BaseUtils.getContext()) : oOO00000.OooO00o(i2);
        boolean z = this.OooO.getResources().getConfiguration().orientation == 2;
        this.OooOoO0 = z;
        if (z) {
            this.OooOo0o = this.OooOo0 / 640.0f;
            this.OooOo = this.OooOo0O / 360.0f;
        } else {
            this.OooOo0o = this.OooOo0 / 360.0f;
            this.OooOo = this.OooOo0O / 640.0f;
        }
    }

    private void OooO0OO() {
        this.OooOO0O = new OooO0o();
    }

    private void OooO0Oo() {
        if (this.OooO0OO != null) {
            this.OooO00o.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.OooOo0, this.OooOo0O);
            layoutParams.gravity = 17;
            float videoWidthHeightRatio = getVideoWidthHeightRatio();
            if (videoWidthHeightRatio > 0.0f) {
                OooO00o(layoutParams, videoWidthHeightRatio);
            } else {
                int i = this.mBaseAdConfig.OooO00o.OooO0OO;
                if (i == 17 || i == 1) {
                    videoWidthHeightRatio = this.OooOoO0 ? 1.7777778f : 0.5625f;
                    OooO00o(layoutParams, videoWidthHeightRatio);
                }
            }
            this.OooO.addView(this.OooO0OO, layoutParams);
        }
    }

    private void OooO0o() {
        try {
            TextView textView = this.OooO0O0;
            if (textView != null) {
                textView.setText("跳过" + this.OooO0oO);
                this.OooO0o = new Timer("umn_native_splash");
                OooO0OO();
                this.OooO0o.schedule(this.OooOO0O, 1000L, 1000L);
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO0o0() {
        if (this.eventListener != null) {
            try {
                TimerTask timerTask = this.OooOO0O;
                if (timerTask != null) {
                    timerTask.cancel();
                }
                Timer timer = this.OooO0o;
                if (timer != null) {
                    timer.cancel();
                }
                this.splashInfo.OooO00o = true;
                showLog("------skip", "hashcode: " + this.splashInfo.hashCode());
                this.eventListener.onAdDismiss(this.splashInfo);
            } catch (Throwable th) {
                ooooO000.OooO00o(th);
            }
        }
    }

    private void OooO0oO() {
        float f = Resources.getSystem().getDisplayMetrics().density;
        if (f <= 0.0f) {
            f = 3.0f;
        }
        float fMin = Math.min(this.OooOo0o / f, this.OooOo / f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((ImageView) this.OooO0oo.findViewById(R.id.right_arrow)).getLayoutParams();
        layoutParams.rightMargin = (int) Math.min(this.OooOo0o * 18.0f, oOO00000.OooO00o(18.0f));
        int iMin = (int) Math.min(f * fMin * 20.0f, oOO00000.OooO00o(20.0f));
        layoutParams.width = iMin;
        layoutParams.height = iMin;
        TextView textView = (TextView) this.OooO0oo.findViewById(R.id.btn_title_text);
        this.OooOOoo.setTextSize(2, Math.min(fMin * 18.0f, this.OooOoO0 ? 17.0f : 18.0f));
        textView.setTextSize(2, Math.min(fMin * 12.0f, 12.0f));
        ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = (int) Math.min(this.OooOo * 6.0f, oOO00000.OooO00o(this.OooOoO0 ? 2.0f : 6.0f));
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.OooOOO0.getLayoutParams();
        layoutParams2.addRule(14);
        layoutParams2.width = (int) Math.min(this.OooOo0o * 317.0f, oOO00000.OooO00o(this.OooOoO0 ? 316.0f : 317.0f));
        layoutParams2.height = (int) Math.min(this.OooOo * 66.0f, oOO00000.OooO00o(this.OooOoO0 ? 60.0f : 66.0f));
        layoutParams2.bottomMargin = (int) (this.OooOo * 25.0f);
        this.OooOo00.setTextSize(2, fMin * 11.0f);
        TextView textView2 = this.OooOo00;
        int i = (int) (this.OooOo0o * 5.0f);
        int i2 = (int) (this.OooOo * 3.0f);
        textView2.setPadding(i, i2, i, i2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.OooOo00.getLayoutParams();
        layoutParams3.leftMargin = (int) (this.OooOo0o * 18.0f);
        layoutParams3.bottomMargin = (int) (this.OooOo * 65.0f);
    }

    private void parseConfig() {
        Map<String, Object> map;
        UMNSplashParams uMNSplashParams = this.OooOO0;
        if (uMNSplashParams == null || (map = uMNSplashParams.map) == null || !map.containsKey(UMNAdConstant.SplashConstant.NEW_SKIP_STYLE)) {
            return;
        }
        Object obj = this.OooOO0.map.get(UMNAdConstant.SplashConstant.NEW_SKIP_STYLE);
        if (obj instanceof Boolean) {
            this.OooO0o0 = ((Boolean) obj).booleanValue();
        }
    }

    public void callAdClick() {
        o0O0OO0 o0o0oo0 = this.OooOoO;
        if (o0o0oo0 != null) {
            o0o0oo0.OooO0o0();
        }
        o000O0O0 o000o0o0 = this.eventListener;
        if (o000o0o0 != null) {
            o000o0o0.onAdClick(this.splashInfo);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO00O, com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            Bitmap bitmap = this.OooOO0o;
            if (bitmap != null) {
                bitmap.recycle();
                this.OooOO0o = null;
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    public ViewGroup getCustomView() {
        return null;
    }

    public abstract View getShakeView(ViewGroup viewGroup);

    public abstract float getVideoWidthHeightRatio();

    public void handleSkip() {
        try {
            parseConfig();
            this.OooO0O0 = (TextView) this.OooO0oo.findViewById(R.id.timerTv);
            CountdownView countdownView = (CountdownView) this.OooO0oo.findViewById(R.id.ubix_ctdv);
            this.OooO0Oo = countdownView;
            if (this.OooO0o0) {
                this.OooOOo0 = countdownView;
                countdownView.setVisibility(0);
                this.OooO0Oo.setDuration(((long) this.OooO0oO) * 1000);
                this.OooO0O0.setVisibility(4);
                this.OooO0Oo.OooO0OO();
                this.OooO0Oo.setOnClickListener(new OooO0O0());
            } else {
                TextView textView = this.OooO0O0;
                this.OooOOo0 = textView;
                textView.setVisibility(0);
                this.OooO0Oo.setVisibility(4);
                this.OooO0O0.setOnClickListener(new OooO0OO());
            }
            OooO0o();
            ooooO000.OooO0O0(o00OO0O0.TAG, "-----skip ");
        } catch (Throwable th) {
            ooooO000.OooO0O0(o00OO0O0.TAG, "-----skip e: " + th.getMessage());
        }
    }

    public void inflate(String str, UMNSplashParams uMNSplashParams) {
        o00OO0O0.TAG = "------" + getClass().getSimpleName();
        this.OooOO0 = uMNSplashParams;
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) BaseUtils.getContext().getSystemService("layout_inflater")).inflate(R.layout.umn_custom_splash, (ViewGroup) null);
        this.OooO0oo = viewGroup;
        viewGroup.setTag("Root ViewGroup");
        UMNFrameLayout uMNFrameLayout = (UMNFrameLayout) this.OooO0oo.findViewById(R.id.fl_media_container);
        this.OooO = uMNFrameLayout;
        uMNFrameLayout.setFlag(true);
        this.OooO00o = (CustomImageView) this.OooO0oo.findViewById(R.id.splash_img);
        this.OooOOO0 = this.OooO0oo.findViewById(R.id.ubix_iv_click_btn);
        this.OooOOoo = (TextView) this.OooO0oo.findViewById(R.id.btn_subtitle_text);
        this.OooOo00 = (TextView) this.OooO0oo.findViewById(R.id.tv_logo);
        OooO0O0();
        OooO0oO();
        this.OooOo00.setText(str);
    }

    @Override // com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter
    public void internalShow(o00OOOOo o00ooooo, o000O0O0 o000o0o0) {
        this.eventListener = o000o0o0;
        show(o00ooooo.OooO0O0());
    }

    public boolean isCanGetShakeView() {
        return this.splashInfo.getBaseAdConfig().OooO00o.OooOOoo != null && this.splashInfo.getBaseAdConfig().OooO00o.OooOOoo.OooO0OO;
    }

    public void loadImg(String str, oo00o oo00oVar) {
        loadImg(str, oo00oVar, true);
    }

    public void loadImg(String str, oo00o oo00oVar, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                this.loadListener.onAdDataLoaded(oo00oVar);
            }
            oO0000Oo.OooO00o(BaseUtils.getContext()).OooO00o(str, 10, new OooO00o(z, oo00oVar));
        } else if (z) {
            oo00oVar.checkMaterialStatus = 11;
            this.loadListener.onAdCacheSuccess(oo00oVar);
        }
    }

    public void regist(ViewGroup viewGroup) {
        UMNNativeExtraInfo uMNNativeExtraInfo;
        View view;
        oOO00O ooo00o;
        o00O000 o00o000 = this.mBaseAdConfig;
        if (o00o000 != null && (ooo00o = o00o000.OooOOO0) != null) {
            this.OooOOOO = ooo00o.Oooo00o;
        }
        this.OooOOOo = new UMNNativeExtraInfo();
        OooO00o();
        if (this.OooO0o0) {
            uMNNativeExtraInfo = this.OooOOOo;
            view = this.OooO0Oo;
        } else {
            uMNNativeExtraInfo = this.OooOOOo;
            view = this.OooO0O0;
        }
        uMNNativeExtraInfo.setCloseView(view);
        this.OooOOOo.setClickViewList(this.OooOOO);
        OooO0Oo();
        OooO00o(viewGroup);
    }

    public ViewGroup renderShakeView(ViewGroup viewGroup) {
        this.OooOOo = new UMNNativeTemplateAdView(BaseUtils.getContext());
        View shakeView = isCanGetShakeView() ? getShakeView(this.OooOOo) : null;
        if (!this.OooOOo.isCanAddShakeView(this.splashInfo.getBaseAdConfig(), shakeView)) {
            this.OooOOoo.setText("点击此处");
            return viewGroup;
        }
        this.OooOOoo.setText("摇动或点击");
        if (!(shakeView instanceof UMNNativeShakeView)) {
            this.OooOOO0.setVisibility(4);
        }
        oo000o oo000oVar = new oo000o();
        oo000oVar.setAbsBaseAdapter(this);
        oo000oVar.setBaseAdConfig(this.splashInfo.getBaseAdConfig());
        oo000oVar.adType = "7";
        this.OooOOo.renderTemplateView(viewGroup);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int iMin = Math.min((int) (this.OooOo0o * 89.0f), oOO00000.OooO00o(this.OooOoO0 ? 75.0f : 89.0f));
        layoutParams.width = iMin;
        layoutParams.height = iMin;
        layoutParams.addRule(2, this.OooOOO0.getId());
        layoutParams.addRule(14);
        layoutParams.bottomMargin = Math.min((int) (this.OooOo * 51.0f), oOO00000.OooO00o(this.OooOoO0 ? 14.0f : 51.0f));
        this.OooOOo.showShakeView((ViewGroup) this.OooOOO0.getParent(), oo000oVar.getBaseAdConfig(), shakeView, layoutParams, layoutParams.height);
        return this.OooOOo;
    }

    @Override // com.ubixnow.ooooo.o00OO00O
    public void show(ViewGroup viewGroup) {
        try {
            int i = this.OooOO0.skipTime;
            if (i >= UbixDefaultConstants.splashSkipTime) {
                this.OooO0oO = i;
            }
            int i2 = this.splashInfo.OooO0O0;
            if (i2 > 0) {
                this.OooO0oO = i2;
            }
            handleSkip();
            ViewGroup viewGroupRenderShakeView = renderShakeView(this.OooO0oo);
            ViewGroup customView = getCustomView();
            if (customView != null) {
                customView.addView(viewGroupRenderShakeView);
                if (customView.getParent() != null) {
                    ((ViewGroup) customView.getParent()).removeAllViews();
                }
                viewGroup.addView(customView);
            } else {
                if (viewGroupRenderShakeView.getParent() != null) {
                    ((ViewGroup) viewGroupRenderShakeView.getParent()).removeAllViews();
                }
                viewGroup.addView(viewGroupRenderShakeView);
            }
            regist(viewGroup);
        } catch (Throwable th) {
            showLog(o00OO0O0.TAG, "  show  e " + th.getMessage());
        }
    }
}
