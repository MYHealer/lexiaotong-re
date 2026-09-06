package com.yfanads.android.custom.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yfanads.ads.R;
import com.yfanads.android.core.f;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.TLTemplateData;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdTLViewHolder {
    private static final String TAG = "AdTLViewHolder";
    public RelativeLayout adCard;
    public View adCloseDelay;
    public YFRoundedImageView adIcon;
    public ImageView closeBtn;
    public ImageView dislikeBtn;
    public RelativeLayout iconArea;
    public ImageView shakeArea;
    public TextView title;

    public AdTLViewHolder(View view) {
        this.adCard = (RelativeLayout) view.findViewById(R.id.adCard);
        this.iconArea = (RelativeLayout) view.findViewById(R.id.icon_area);
        this.title = (TextView) view.findViewById(R.id.titleText);
        this.adIcon = (YFRoundedImageView) view.findViewById(R.id.adIcon);
        this.closeBtn = (ImageView) view.findViewById(R.id.closeButton);
        this.adCloseDelay = view.findViewById(R.id.ad_close_delay_area);
        this.dislikeBtn = (ImageView) view.findViewById(R.id.dislike_btn);
        this.shakeArea = (ImageView) view.findViewById(R.id.shake_area);
    }

    private GradientDrawable createGradientDrawable(View view, int i) {
        if (view == null) {
            return null;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            return (GradientDrawable) background;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    private void startCloseDelay(BaseTemplateData baseTemplateData) {
        View view;
        baseTemplateData.setCloseShowTime(System.currentTimeMillis());
        if (!baseTemplateData.isSupportClose() || (view = this.adCloseDelay) == null) {
            return;
        }
        view.setVisibility(0);
        YFUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.view.AdTLViewHolder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1245x929ca101();
            }
        }, baseTemplateData.getCloseDelay());
    }

    private void updateBG(Context context, TLTemplateData tLTemplateData) {
        GradientDrawable gradientDrawableCreateGradientDrawable;
        try {
            this.adCard.setBackgroundColor(tLTemplateData.getBgColor());
        } catch (Exception e) {
            f.a(e, new StringBuilder("AdTLViewHolder updateBG error: "));
        }
        try {
            if (tLTemplateData.getRadius() <= 0 || (gradientDrawableCreateGradientDrawable = createGradientDrawable(this.adCard, tLTemplateData.getBgColor())) == null) {
                return;
            }
            gradientDrawableCreateGradientDrawable.setCornerRadius(ScreenUtil.dip2px(context, tLTemplateData.getRadius()));
            this.adCard.setBackground(gradientDrawableCreateGradientDrawable);
        } catch (Exception e2) {
            f.a(e2, new StringBuilder("AdTLViewHolder updateBG setCornerRadius: "));
        }
    }

    private void updateClose(TLTemplateData tLTemplateData) {
        try {
            this.closeBtn.setImageResource(tLTemplateData.getCloseRes());
        } catch (Exception e) {
            f.a(e, new StringBuilder("AdTLViewHolder updateClose "));
        }
    }

    private void updateFeedView(TLTemplateData tLTemplateData) {
        int i = tLTemplateData.adLogo;
        if (i > 0) {
            this.dislikeBtn.setImageResource(i);
        }
    }

    private void updateText(TLTemplateData tLTemplateData) {
        try {
            this.title.setTextColor(tLTemplateData.getFontColor());
        } catch (Exception e) {
            f.a(e, new StringBuilder("AdTLViewHolder updateText setTextColor: "));
        }
        try {
            this.title.setTextSize(tLTemplateData.getFontSize());
        } catch (Exception e2) {
            f.a(e2, new StringBuilder("AdTLViewHolder updateText setTextSize: "));
        }
    }

    public View getCloseView(BaseTemplateData baseTemplateData) {
        startCloseDelay(baseTemplateData);
        return this.closeBtn;
    }

    /* JADX INFO: renamed from: lambda$startCloseDelay$0$com-yfanads-android-custom-view-AdTLViewHolder, reason: not valid java name */
    /* synthetic */ void m1245x929ca101() {
        this.adCloseDelay.setVisibility(8);
    }

    public void loadAdIcon(boolean z, String str, int i) {
        try {
            if (!TextUtils.isEmpty(str) && !z) {
                this.adIcon.setVisibility(0);
                if (i > 0) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iconArea.getLayoutParams();
                    layoutParams.width = i;
                    layoutParams.height = i;
                }
                ViewUtils.loadImageByCircle(str, this.adIcon);
                return;
            }
            this.adIcon.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.title.getLayoutParams()).setMarginStart(0);
            YFLog.debug("has not adIcon " + z);
        } catch (Exception e) {
            f.a(e, new StringBuilder("AdTLViewHolder loadAdIcon error: "));
        }
    }

    public void updateShowView(Context context, TLTemplateData tLTemplateData) {
        if (tLTemplateData == null) {
            return;
        }
        updateBG(context, tLTemplateData);
        updateText(tLTemplateData);
        updateClose(tLTemplateData);
        updateFeedView(tLTemplateData);
    }
}
