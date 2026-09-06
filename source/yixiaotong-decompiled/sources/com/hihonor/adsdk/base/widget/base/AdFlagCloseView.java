package com.hihonor.adsdk.base.widget.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.NegativeFeedback;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.DislikeInfo;
import com.hihonor.adsdk.base.callback.DislikeItemClickListener;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.widget.AutoScaleSizeRelativeLayout;
import com.hihonor.adsdk.common.f.h;
import com.hihonor.adsdk.common.f.j;
import com.hihonor.adsdk.common.f.k;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AdFlagCloseView extends AutoScaleSizeRelativeLayout {
    private static final String LOG_TAG = "AdFlagCloseView";
    private BaseAd baseAd;
    private DislikeItemClickListener dislikeItemClickListener;
    private com.hihonor.adsdk.base.widget.dislike.a dislikePopupWindow;
    private ImageView ivClose;
    private LinearLayout rootView;
    private TextView tvAdFlag;

    class a implements DislikeItemClickListener {
        a() {
        }

        @Override // com.hihonor.adsdk.base.callback.DislikeItemClickListener
        public void onCancel() {
            AdFlagCloseView.this.reportByClick(null);
            if (AdFlagCloseView.this.dislikeItemClickListener != null) {
                AdFlagCloseView.this.dislikeItemClickListener.onCancel();
            }
        }

        @Override // com.hihonor.adsdk.base.callback.DislikeItemClickListener
        public void onFeedItemClick(int i, DislikeInfo dislikeInfo, View view) {
            AdFlagCloseView.this.reportByClick(dislikeInfo);
            if (AdFlagCloseView.this.dislikeItemClickListener != null) {
                AdFlagCloseView.this.dislikeItemClickListener.onFeedItemClick(i, dislikeInfo, view);
            }
        }

        @Override // com.hihonor.adsdk.base.callback.DislikeItemClickListener
        public void onShow() {
            AdFlagCloseView.this.reportByShow();
            if (AdFlagCloseView.this.dislikeItemClickListener != null) {
                AdFlagCloseView.this.dislikeItemClickListener.onShow();
            }
        }
    }

    public AdFlagCloseView(Context context) {
        super(context);
        initView(context, null);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.honor_ads_close_view, this).findViewById(R.id.ll_ad_flag_layout);
        this.rootView = linearLayout;
        this.tvAdFlag = (TextView) linearLayout.findViewById(R.id.tv_flag);
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.iv_close);
        this.ivClose = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.base.AdFlagCloseView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m900x99c24b4b(view);
            }
        });
        parseTypeArray(context, attributeSet);
    }

    private void parseTypeArray(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            com.hihonor.adsdk.common.b.b.hnadse(LOG_TAG, "Attribute Set is null", new Object[0]);
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdFlagCloseView);
        try {
            try {
                setBgColor(typedArrayObtainStyledAttributes.getColor(R.styleable.AdFlagCloseView_ads_bgColor, context.getResources().getColor(R.color.honor_ads_magic_mask_thin)));
                int color = typedArrayObtainStyledAttributes.getColor(R.styleable.AdFlagCloseView_ads_adFlagTextColor, context.getResources().getColor(R.color.honor_ads_magic_text_primary_inverse));
                if (color > 0) {
                    setAdFlagTextColor(color);
                }
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.AdFlagCloseView_ads_closeIconDrawable);
                if (drawable != null) {
                    setCloseIconDrawable(drawable);
                }
                setCloseIconShow(typedArrayObtainStyledAttributes.getBoolean(R.styleable.AdFlagCloseView_ads_isShowCloseIcon, true));
                setAdFlagShow(typedArrayObtainStyledAttributes.getBoolean(R.styleable.AdFlagCloseView_ads_isShowAdFlag, true));
                String string = typedArrayObtainStyledAttributes.getString(R.styleable.AdFlagCloseView_ads_adFlagText);
                if (!TextUtils.isEmpty(string)) {
                    setAdFlagText(string);
                }
                setRectCornerRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AdFlagCloseView_ads_radius, j.hnadsa(context, 16.0f)));
                setSingleAdFlag(typedArrayObtainStyledAttributes.getBoolean(R.styleable.AdFlagCloseView_ads_singleAdFlagShow, false));
                this.tvAdFlag.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AdFlagCloseView_ads_adFlagTextSize, (int) TypedValue.applyDimension(2, 9.0f, getResources().getDisplayMetrics())));
                int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AdFlagCloseView_ads_adFlagPadding, (int) context.getResources().getDimension(R.dimen.honor_ads_magic_dimens_element_vertical_middle));
                com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "paddingHorizontal:" + dimensionPixelSize, new Object[0]);
                this.rootView.setPaddingRelative(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadse(LOG_TAG, "parseTypeArray, Parse close view attribute exception: " + e.getMessage(), new Object[0]);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportByClick(DislikeInfo dislikeInfo) {
        if (getAdBean() == null) {
            com.hihonor.adsdk.common.b.b.hnadse(LOG_TAG, "reportByClick but ad is null. ", new Object[0]);
            return;
        }
        String text = dislikeInfo != null ? dislikeInfo.getText() : NegativeFeedback.POOR_CANCEL.getDesc();
        new com.hihonor.adsdk.base.g.j.d.g(this.baseAd.getAdUnitId(), getAdBean(), text).hnadsa("type", String.valueOf(dislikeInfo != null ? dislikeInfo.getCode() : NegativeFeedback.POOR_CANCEL.getReason())).hnadse();
        com.hihonor.adsdk.base.g.k.c.c cVar = new com.hihonor.adsdk.base.g.k.c.c(text);
        BaseAd baseAd = this.baseAd;
        cVar.hnadsa(baseAd, baseAd.getTrackUrl().getCommons());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportByShow() {
        if (getAdBean() == null) {
            com.hihonor.adsdk.common.b.b.hnadse(LOG_TAG, "reportByShow but ad is null. ", new Object[0]);
        } else {
            new x(this.baseAd.getAdUnitId(), getAdBean(), ErrorCode.AD_DISLIKE_SHOW, ErrorCode.STR_AD_DISLIKE_SHOW).hnadse();
        }
    }

    private void reportByShowError(String str) {
        if (getAdBean() == null) {
            com.hihonor.adsdk.common.b.b.hnadse(LOG_TAG, "reportByShowError but ad is null. ", new Object[0]);
        } else {
            new x(this.baseAd.getAdUnitId(), getAdBean(), ErrorCode.AD_DISLIKE_SHOW_EXCEPTION, ErrorCode.STR_AD_DISLIKE_SHOW_EXCEPTION + str).hnadse();
        }
    }

    private void showDislikeWindow() {
        if (!h.hnadsa(this.rootView)) {
            com.hihonor.adsdk.common.b.b.hnadse(LOG_TAG, "showDislikeWindow rootView is disable", new Object[0]);
            reportByShowError("showDislikeWindow rootView is disable");
            return;
        }
        if (this.dislikePopupWindow == null) {
            this.dislikePopupWindow = new com.hihonor.adsdk.base.widget.dislike.a();
        }
        this.dislikePopupWindow.hnadsa(new a());
        try {
            this.dislikePopupWindow.hnadsb(this.rootView);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(LOG_TAG, "showDislikeWindow error msg =" + e.getMessage(), new Object[0]);
            reportByShowError(e.getMessage());
        }
    }

    private void updateHotArea() {
        post(new Runnable() { // from class: com.hihonor.adsdk.base.widget.base.AdFlagCloseView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m901xff3203a8();
            }
        });
    }

    public void dismissDislike() {
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "code dismiss dislike popup window.", new Object[0]);
        dismissDislikePopupWindow();
    }

    void dismissDislikePopupWindow() {
        com.hihonor.adsdk.base.widget.dislike.a aVar = this.dislikePopupWindow;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        this.dislikePopupWindow.dismiss();
    }

    /* JADX INFO: renamed from: lambda$updateHotArea$1$com-hihonor-adsdk-base-widget-base-AdFlagCloseView, reason: not valid java name */
    /* synthetic */ void m901xff3203a8() {
        if (this.ivClose.getVisibility() != 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "close icon un display,so don't set touch bounds.", new Object[0]);
            setTouchDelegate(null);
        } else {
            if (getTouchDelegate() != null) {
                return;
            }
            Rect rect = new Rect();
            this.ivClose.getHitRect(rect);
            int iHnadsa = j.hnadsa(getContext(), 12.0f);
            rect.left -= iHnadsa;
            rect.top -= iHnadsa;
            rect.right += iHnadsa;
            rect.bottom += iHnadsa;
            setTouchDelegate(new TouchDelegate(rect, this.ivClose));
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dismissDislikePopupWindow();
    }

    public void setAdFlagShow(boolean z) {
        this.tvAdFlag.setVisibility(z ? 0 : 8);
    }

    public void setAdFlagText(CharSequence charSequence) {
        this.tvAdFlag.setText(charSequence);
    }

    public void setAdFlagTextColor(int i) {
        this.tvAdFlag.setTextColor(i);
    }

    public void setBaseAd(BaseAd baseAd) {
        this.baseAd = baseAd;
    }

    public void setBgColor(int i) {
        this.rootView.setBackgroundColor(i);
    }

    public void setCloseIconDrawable(Drawable drawable) {
        if (drawable == null) {
            drawable = k.hnadsa(getContext(), R.drawable.ic_honor_ads_close_white);
        }
        this.ivClose.setImageDrawable(drawable);
    }

    public void setCloseIconShow(boolean z) {
        this.ivClose.setVisibility(z ? 0 : 8);
        updateHotArea();
    }

    public void setDislikeItemClickListener(DislikeItemClickListener dislikeItemClickListener) {
        this.dislikeItemClickListener = dislikeItemClickListener;
    }

    public void setSingleAdFlag(boolean z) {
        if (!z) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, j.hnadsa(getContext(), 18.0f));
            int dimension = (int) HnAds.get().getContext().getResources().getDimension(R.dimen.honor_ads_magic_dimens_element_vertical_middle);
            this.rootView.setLayoutParams(layoutParams);
            this.rootView.setPaddingRelative(dimension, 0, dimension, 0);
            return;
        }
        setAdFlagShow(true);
        setCloseIconShow(false);
        this.rootView.setPaddingRelative(1, 0, 1, 0);
        this.rootView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        setRectCornerRadius(j.hnadsa(getContext(), 2.0f));
    }

    public void setViewPadding(int i, int i2, int i3, int i4) {
        this.rootView.setPaddingRelative(i, i2, i3, i4);
    }

    private com.hihonor.adsdk.base.g.j.d.h1.a getAdBean() {
        BaseAd baseAd = this.baseAd;
        if (baseAd != null) {
            return com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
        }
        com.hihonor.adsdk.common.b.b.hnadse(LOG_TAG, "getAdBean but ad is null. ", new Object[0]);
        return null;
    }

    /* JADX INFO: renamed from: lambda$initView$0$com-hihonor-adsdk-base-widget-base-AdFlagCloseView, reason: not valid java name */
    /* synthetic */ void m900x99c24b4b(View view) {
        BaseAd baseAd = this.baseAd;
        if (baseAd != null) {
            com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
            BaseAd baseAd2 = this.baseAd;
            new com.hihonor.adsdk.base.g.j.d.h(baseAd2, baseAd2.getAdUnitId(), aVarHnadsa).hnadse();
            com.hihonor.adsdk.base.g.k.c.d dVar = new com.hihonor.adsdk.base.g.k.c.d();
            BaseAd baseAd3 = this.baseAd;
            dVar.hnadsa(baseAd3, baseAd3.getTrackUrl().getCommons());
        }
        showDislikeWindow();
    }

    public AdFlagCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet);
    }

    public AdFlagCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context, attributeSet);
    }
}
