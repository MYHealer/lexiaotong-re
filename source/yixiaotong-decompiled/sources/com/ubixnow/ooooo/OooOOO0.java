package com.ubixnow.ooooo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ubixnow.adtype.banner.api.UMNBannerParams;
import com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter;
import com.ubixnow.core.R;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.common.ui.UMNFrameLayout;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.core.utils.img.CustomImageView;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class OooOOO0 extends UMNCustomBannerAdapter {
    public CustomImageView OooO;
    public UMNBannerParams OooO00o;
    public ImageView OooO0O0;
    public TextView OooO0OO;
    public TextView OooO0Oo;
    public ViewGroup OooO0o;
    public TextView OooO0o0;
    public UMNFrameLayout OooO0oO;
    public LinearLayout OooO0oo;
    public Bitmap OooOO0;
    private ViewGroup OooOO0O;
    public View OooOO0o;
    public WeakReference<Context> OooOOo0;
    public int OooOOO0 = 0;
    public int OooOOO = 0;
    public List<View> OooOOOO = new ArrayList();
    public UMNNativeExtraInfo OooOOOo = new UMNNativeExtraInfo();

    public class OooO00o implements Runnable {
        public OooO00o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OooOOO0.this.OooO0Oo();
        }
    }

    public class OooO0O0 implements View.OnClickListener {
        public OooO0O0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (OooOOO0.this.OooOO0O != null) {
                    OooOOO0.this.OooOO0O.removeAllViews();
                }
                OooOOO0.this.destory();
                OooOOO0.this.closeAd();
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
    }

    public class OooO0OO implements oO0000Oo.OooO0o {
        public final /* synthetic */ boolean OooO00o;
        public final /* synthetic */ oo00o OooO0O0;

        public OooO0OO(boolean z, oo00o oo00oVar) {
            this.OooO00o = z;
            this.OooO0O0 = oo00oVar;
        }

        @Override // com.ubixnow.ooooo.oO0000Oo.OooO0o
        public void OooO00o(Bitmap bitmap, byte[] bArr, String str, String str2) {
            OooOOO0 oooOOO0 = OooOOO0.this;
            oooOOO0.OooOO0 = bitmap;
            if (bitmap == null || str2 == null) {
                oooOOO0.showLog(o00OO0O0.TAG, " img download error ");
                if (this.OooO00o) {
                    this.OooO0O0.checkMaterialStatus = 11;
                }
            }
            if (this.OooO00o) {
                OooOOO0.this.loadListener.onAdCacheSuccess(this.OooO0O0);
            }
        }
    }

    private void OooO00o() {
        ImageView imageView = this.OooO0O0;
        if (imageView != null) {
            imageView.setOnClickListener(new OooO0O0());
        }
    }

    private void OooO00o(TextView textView, int i, float f) {
        textView.setTextSize(i * f);
    }

    private void OooO0O0() {
        this.OooOOO0 = oOO00000.OooO00o(this.OooO00o.width);
        this.OooOOO = oOO00000.OooO00o(this.OooO00o.height);
        if (this.OooOOO0 <= 0) {
            this.OooOOO0 = oOO00000.OooO0o(BaseUtils.getContext());
        }
        if (this.OooOOO <= 0) {
            this.OooOOO = (this.OooOOO0 * 5) / 32;
        }
        int i = this.OooOOO0 * 5;
        int i2 = this.OooOOO * 32;
        if (i >= i2) {
            this.OooOOO0 = i2 / 5;
        } else {
            this.OooOOO = i / 32;
        }
    }

    private void OooO0OO() {
        ViewGroup.LayoutParams layoutParams = this.OooO0oo.getLayoutParams();
        layoutParams.width = this.OooOOO0;
        layoutParams.height = this.OooOOO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO0Oo() {
        int measuredWidth = this.OooO0oo.getMeasuredWidth();
        if (measuredWidth < 0) {
            measuredWidth = this.OooOOO0;
        }
        float f = measuredWidth / (Resources.getSystem().getDisplayMetrics().density * (this.OooO0oO.getResources().getConfiguration().orientation == 1 ? 360.0f : 640.0f));
        this.OooO0o0.setPadding(oOO00000.OooO00o(8.0f * f), 0, 0, 0);
        OooO00o(this.OooO0o0, 12, f);
        ViewGroup.LayoutParams layoutParams = this.OooO0OO.getLayoutParams();
        layoutParams.width = (int) (layoutParams.width * f);
        layoutParams.height = (int) (layoutParams.height * f);
        OooO00o(this.OooO0OO, 9, f);
        float fMin = Math.min(f, 1.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.OooO0O0.getLayoutParams();
        int iOooO00o = (int) (oOO00000.OooO00o(11.0f) * fMin);
        layoutParams2.width = iOooO00o;
        int iMax = Math.max(iOooO00o, oOO00000.OooO00o(4.0f));
        layoutParams2.width = iMax;
        layoutParams2.height = iMax;
        layoutParams2.topMargin = (int) (oOO00000.OooO00o(5.0f) * fMin);
        layoutParams2.rightMargin = (int) (oOO00000.OooO00o(5.0f) * fMin);
        this.OooO0Oo.setPadding((int) (oOO00000.OooO00o(3.0f) * fMin), (int) (oOO00000.OooO00o(1.0f) * fMin), (int) (oOO00000.OooO00o(3.0f) * fMin), (int) (oOO00000.OooO00o(1.0f) * fMin));
        OooO00o(this.OooO0Oo, 6, fMin);
    }

    public abstract void closeAd();

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        try {
            Bitmap bitmap = this.OooOO0;
            if (bitmap != null) {
                bitmap.recycle();
                this.OooOO0 = null;
            }
            WeakReference<Context> weakReference = this.OooOOo0;
            if (weakReference != null) {
                weakReference.clear();
            }
            ViewGroup viewGroup = this.OooO0o;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                if (this.OooO0o.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.OooO0o.getParent()).removeView(this.OooO0o);
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public ViewGroup getCustomView() {
        return null;
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public View getView() {
        return getCustomView() != null ? getCustomView() : this.OooO0o;
    }

    public void inflate(String str, String str2, UMNBannerParams uMNBannerParams, boolean z) {
        o00OO0O0.TAG = "------" + getClass().getSimpleName();
        this.OooO00o = uMNBannerParams;
        WeakReference<Context> weakReference = this.OooOOo0;
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) ((weakReference == null || weakReference.get() == null) ? BaseUtils.getContext() : this.OooOOo0.get()).getSystemService("layout_inflater")).inflate(R.layout.umn_custom_banner, (ViewGroup) null);
        this.OooO0o = viewGroup;
        viewGroup.setTag("Root ViewGroup");
        this.OooO0oo = (LinearLayout) this.OooO0o.findViewById(R.id.ll_container);
        this.OooO0oO = (UMNFrameLayout) this.OooO0o.findViewById(R.id.fl_container);
        this.OooO = (CustomImageView) this.OooO0o.findViewById(R.id.splash_img);
        this.OooO0o0 = (TextView) this.OooO0o.findViewById(R.id.tv_title);
        this.OooO0O0 = (ImageView) this.OooO0o.findViewById(R.id.iv_close);
        TextView textView = (TextView) this.OooO0o.findViewById(R.id.tv_detail_btn);
        this.OooO0OO = textView;
        textView.setText(z ? "立即下载" : "查看详情");
        this.OooO0o0.setText(str2);
        TextView textView2 = (TextView) this.OooO0o.findViewById(R.id.tv_logo);
        this.OooO0Oo = textView2;
        textView2.setText(str);
        OooO0O0();
        OooO0OO();
        this.OooO0o.post(new OooO00o());
        OooO00o();
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public void loadBannerAd(Context context, o00O000 o00o000) {
        this.OooOOo0 = new WeakReference<>(context);
    }

    public void loadImg(String str, oo00o oo00oVar) {
        loadImg(str, oo00oVar, true);
    }

    public void loadImg(String str, oo00o oo00oVar, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                this.loadListener.onAdDataLoaded(oo00oVar);
            }
            oO0000Oo.OooO00o(BaseUtils.getContext()).OooO00o(str, 10, new OooO0OO(z, oo00oVar));
        } else if (z) {
            oo00oVar.checkMaterialStatus = 11;
            this.loadListener.onAdCacheSuccess(oo00oVar);
        }
    }

    public void onAdDataLoadSuc() {
        showLog(o00OO0O0.TAG, "onAdDataLoadSuc");
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onAdDataLoaded(this.absUbixInfo);
        }
    }

    public void onRenderFail(int i, String str) {
        showLog(o00OO0O0.TAG, "onRenderFail code=" + i + " msg=" + str);
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onAdRenderFail(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) this.absUbixInfo));
        }
    }

    public void register(ViewGroup viewGroup) {
        this.OooOOOO.add(this.OooO0OO);
        this.OooOOOO.add(this.OooO0oo);
        UMNNativeExtraInfo uMNNativeExtraInfo = new UMNNativeExtraInfo();
        this.OooOOOo = uMNNativeExtraInfo;
        uMNNativeExtraInfo.setCloseView(this.OooO0O0);
        this.OooOOOo.setClickViewList(this.OooOOOO);
        Bitmap bitmap = this.OooOO0;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.OooO0oO.setBackground(new BitmapDrawable(viewGroup.getResources(), ooOOO00O.OooO00o(this.OooOO0)));
        if (this.OooOO0o == null) {
            this.OooO.setImageBitmap(this.OooOO0);
        }
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public void show(ViewGroup viewGroup) {
        try {
            this.OooOO0O = viewGroup;
            if (this.OooOO0o != null) {
                this.OooO.setVisibility(4);
                this.OooO0oO.addView(this.OooOO0o);
            }
            ViewGroup customView = getCustomView();
            if (customView != null) {
                customView.addView(this.OooO0o);
                if (customView.getParent() != null) {
                    ((ViewGroup) customView.getParent()).removeAllViews();
                }
                this.OooOO0O.addView(customView);
            } else {
                if (this.OooO0o.getParent() != null) {
                    ((ViewGroup) this.OooO0o.getParent()).removeAllViews();
                }
                this.OooOO0O.addView(this.OooO0o);
            }
            register(this.OooO0o);
        } catch (Throwable th) {
            showLog(o00OO0O0.TAG, "  show  e " + th.getMessage());
        }
    }
}
