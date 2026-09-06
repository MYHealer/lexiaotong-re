package com.yfanads.android.custom.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yfanads.ads.R;
import com.yfanads.android.libs.utils.YFOptional;
import com.yfanads.android.model.template.ShopMallTemplateData;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdShopMallHolder {
    private int closeMargin;
    private final ImageView floatingCloseIV;
    private LinearLayout floatingContentView;
    private RelativeLayout floatingRed;
    private final RelativeLayout rootView;
    private long showCloseTime = 0;
    private int size168dp;
    private int size18dp;
    private int size28dp;
    private int size2p5dp;
    private int size55dp;
    private int size60dp;
    private int size8dp;
    private int size98dp;
    private final RelativeLayout targetView;
    private String type;

    /* JADX INFO: renamed from: com.yfanads.android.custom.view.AdShopMallHolder$1, reason: invalid class name */
    public class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ FloatingCallback val$callback;
        final /* synthetic */ long val$floatingTime;
        final /* synthetic */ boolean val$isLeftIcon;
        final /* synthetic */ View val$targetView;

        public AnonymousClass1(View view, boolean z, FloatingCallback floatingCallback, long j) {
            this.val$targetView = view;
            this.val$isLeftIcon = z;
            this.val$callback = floatingCallback;
            this.val$floatingTime = j;
        }

        /* JADX INFO: renamed from: lambda$onAnimationEnd$0$com-yfanads-android-custom-view-AdShopMallHolder$1, reason: not valid java name */
        /* synthetic */ void m1241xa731f418(final View view, final boolean z, final FloatingCallback floatingCallback) {
            view.animate().scaleX(0.0f).alpha(0.0f).translationX(-15.0f).setDuration(800L).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.yfanads.android.custom.view.AdShopMallHolder.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    AdShopMallHolder.this.resetTargetView(z, view, floatingCallback);
                }
            }).start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            Handler handler = YFUtil.MAIN_HANDLER;
            final View view = this.val$targetView;
            final boolean z = this.val$isLeftIcon;
            final FloatingCallback floatingCallback = this.val$callback;
            handler.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.view.AdShopMallHolder$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1241xa731f418(view, z, floatingCallback);
                }
            }, this.val$floatingTime);
        }
    }

    public interface FloatingCallback {
        void draggingResult(boolean z);
    }

    public AdShopMallHolder(String str, View view) {
        if (TemplateRes.SHOP_MALL_RED_PACKET.equals(str)) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            this.rootView = relativeLayout;
            this.targetView = (RelativeLayout) relativeLayout.findViewById(R.id.red_pocket_area);
            this.floatingCloseIV = (ImageView) relativeLayout.findViewById(R.id.ad_close);
        } else {
            RelativeLayout relativeLayout2 = (RelativeLayout) view;
            this.rootView = relativeLayout2;
            this.floatingContentView = (LinearLayout) relativeLayout2.findViewById(R.id.yf_floating_content);
            this.floatingRed = (RelativeLayout) relativeLayout2.findViewById(R.id.yf_floating_red);
            this.targetView = (RelativeLayout) relativeLayout2.findViewById(R.id.yf_floating);
            this.floatingCloseIV = (ImageView) relativeLayout2.findViewById(R.id.yf_floating_close);
        }
        initSize(view.getContext());
    }

    private void initSize(Context context) {
        this.size18dp = ScreenUtil.dip2px(context, 18.0f);
        this.size55dp = ScreenUtil.dip2px(context, 55.0f);
        this.size168dp = ScreenUtil.dip2px(context, 168.0f);
        this.size28dp = ScreenUtil.dip2px(context, 28.0f);
        this.size98dp = ScreenUtil.dip2px(context, 98.0f);
        this.size8dp = ScreenUtil.dip2px(context, 8.0f);
        this.size2p5dp = ScreenUtil.dip2px(context, 2.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetTargetView(boolean z, View view, final FloatingCallback floatingCallback) {
        this.showCloseTime = System.currentTimeMillis();
        view.setVisibility(8);
        this.floatingCloseIV.setVisibility(0);
        YFOptional.ofNullable(floatingCallback).ifPresentRun(new YFOptional.Consumer() { // from class: com.yfanads.android.custom.view.AdShopMallHolder$$ExternalSyntheticLambda1
            @Override // com.yfanads.android.libs.utils.YFOptional.Consumer
            public final void accept(Object obj) {
                floatingCallback.draggingResult(true);
            }
        });
        if (z) {
            updMarginByRView(this.floatingCloseIV, this.size55dp - this.closeMargin);
            return;
        }
        RelativeLayout relativeLayout = this.floatingRed;
        int i = this.closeMargin;
        updMarginByRView(relativeLayout, i, i);
        updMarginByRView(this.floatingCloseIV, 0);
        this.rootView.setVisibility(4);
        this.rootView.setAlpha(0.0f);
        this.rootView.animate().alpha(1.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.yfanads.android.custom.view.AdShopMallHolder.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                AdShopMallHolder.this.rootView.setVisibility(0);
            }
        }).start();
    }

    private void startIconAnimation(boolean z, int i, long j, View view, final FloatingCallback floatingCallback) {
        YFOptional.ofNullable(floatingCallback).ifPresentRun(new YFOptional.Consumer() { // from class: com.yfanads.android.custom.view.AdShopMallHolder$$ExternalSyntheticLambda0
            @Override // com.yfanads.android.libs.utils.YFOptional.Consumer
            public final void accept(Object obj) {
                floatingCallback.draggingResult(false);
            }
        });
        view.setScaleX(0.0f);
        view.setAlpha(0.0f);
        view.setPivotX(z ? i : this.size168dp - i);
        view.setVisibility(0);
        view.animate().alpha(1.0f).scaleX(1.0f).translationX(0.0f).setDuration(800L).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(new AnonymousClass1(view, z, floatingCallback, j)).start();
    }

    private void updMarginByRView(View view, int... iArr) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        int length = iArr.length;
        layoutParams.setMargins(length > 0 ? iArr[0] : 0, length > 1 ? iArr[1] : 0, length > 2 ? iArr[2] : 0, length > 3 ? iArr[3] : 0);
        view.setLayoutParams(layoutParams);
    }

    public long getFCloseShowTime() {
        return this.showCloseTime;
    }

    public ImageView getFloatingCloseIV() {
        return this.floatingCloseIV;
    }

    public View getRootView() {
        return this.rootView;
    }

    public View getTargetView() {
        return this.targetView;
    }

    public void updFloatingIconView(Context context, ShopMallTemplateData shopMallTemplateData, FloatingCallback floatingCallback) {
        int floatingLoc = shopMallTemplateData.getFloatingLoc();
        long floatingTime = shopMallTemplateData.getFloatingTime();
        int v3CloseSize = shopMallTemplateData.getV3CloseSize(context);
        boolean z = floatingLoc == 2 || floatingLoc == 1;
        int i = (v3CloseSize / 2) + this.size2p5dp;
        this.closeMargin = i;
        updMarginByRView(this.targetView, 0, i);
        LinearLayout linearLayout = this.floatingContentView;
        int[] iArr = new int[1];
        iArr[0] = z ? this.size55dp : this.size18dp;
        updMarginByRView(linearLayout, iArr);
        this.floatingCloseIV.setImageResource(shopMallTemplateData.getBlackCloseRes());
        if (!z) {
            floatingTime = 0;
        }
        if (floatingTime > 0) {
            RelativeLayout relativeLayout = this.floatingRed;
            int[] iArr2 = new int[2];
            iArr2[0] = z ? 0 : this.size168dp - this.size55dp;
            iArr2[1] = this.closeMargin;
            updMarginByRView(relativeLayout, iArr2);
            TextView textView = (TextView) this.rootView.findViewById(R.id.yf_floating_text_top);
            TextView textView2 = (TextView) this.rootView.findViewById(R.id.yf_floating_text_bottom);
            textView.setText(shopMallTemplateData.getFloatingContentTop(context));
            textView2.setText(shopMallTemplateData.getFloatingContentBottom(context));
            startIconAnimation(z, this.size55dp / 2, floatingTime, this.targetView, floatingCallback);
            return;
        }
        RelativeLayout relativeLayout2 = this.floatingRed;
        int[] iArr3 = new int[2];
        iArr3[0] = z ? 0 : this.closeMargin;
        iArr3[1] = this.closeMargin;
        updMarginByRView(relativeLayout2, iArr3);
        ImageView imageView = this.floatingCloseIV;
        int[] iArr4 = new int[1];
        iArr4[0] = z ? this.size55dp - this.closeMargin : 0;
        updMarginByRView(imageView, iArr4);
        this.showCloseTime = System.currentTimeMillis();
        this.floatingCloseIV.setVisibility(0);
    }

    public void updFloatingView(boolean z) {
        ImageView imageView = this.floatingCloseIV;
        int[] iArr = new int[1];
        iArr[0] = z ? this.size55dp - this.closeMargin : 0;
        updMarginByRView(imageView, iArr);
        RelativeLayout relativeLayout = this.floatingRed;
        int[] iArr2 = new int[2];
        iArr2[0] = z ? 0 : this.closeMargin;
        iArr2[1] = this.closeMargin;
        updMarginByRView(relativeLayout, iArr2);
    }

    public void updRedPacketView(Context context, ShopMallTemplateData shopMallTemplateData) {
        this.showCloseTime = System.currentTimeMillis();
        this.targetView.setBackgroundResource(shopMallTemplateData.getRedPocketBgRes());
        int closeLoc = shopMallTemplateData.getCloseLoc();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (closeLoc == 1) {
            layoutParams.addRule(18, R.id.red_pocket_area);
            layoutParams.setMargins(shopMallTemplateData.isRedPocketCops() ? this.size18dp : this.size28dp, shopMallTemplateData.isRedPocketCops() ? this.size18dp : this.size98dp, 0, 0);
        } else if (closeLoc != 2) {
            layoutParams.addRule(18, R.id.red_pocket_area);
            layoutParams.addRule(19, R.id.red_pocket_area);
            layoutParams.addRule(3, R.id.red_pocket_area);
            layoutParams.setMargins(0, this.size8dp, 0, 0);
        } else {
            layoutParams.addRule(19, R.id.red_pocket_area);
            layoutParams.setMargins(0, shopMallTemplateData.isRedPocketCops() ? this.size18dp : this.size98dp, shopMallTemplateData.isRedPocketCops() ? this.size18dp : this.size28dp, 0);
        }
        if (shopMallTemplateData.isRedPocketCops()) {
            ((LinearLayout) this.rootView.findViewById(R.id.red_pocket_coupon)).setVisibility(0);
            TextView textView = (TextView) this.rootView.findViewById(R.id.coupon_number0);
            TextView textView2 = (TextView) this.rootView.findViewById(R.id.coupon_number);
            TextView textView3 = (TextView) this.rootView.findViewById(R.id.coupon_number1);
            if (shopMallTemplateData.isHideMoneyDes()) {
                textView.setVisibility(8);
                textView2.setVisibility(8);
                textView3.setVisibility(0);
                textView3.setText(shopMallTemplateData.getRedPocketMoney(context));
            } else {
                textView.setVisibility(0);
                textView2.setVisibility(0);
                textView2.setText(shopMallTemplateData.getRedPocketMoney(context));
                textView3.setVisibility(0);
            }
        }
        this.floatingCloseIV.setImageResource(shopMallTemplateData.getBlackCloseRes());
        this.floatingCloseIV.setLayoutParams(layoutParams);
    }
}
