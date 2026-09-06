package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityBuyCardBinding implements ViewBinding {
    public final Button btnBuycard;
    public final ImageView ivBuycardrecord;
    public final LinearLayout llContainer;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final ViewPager vpCard;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityBuyCardBinding(LinearLayout linearLayout, Button button, ImageView imageView, LinearLayout linearLayout2, TitleBar titleBar, ViewPager viewPager) {
        this.rootView = linearLayout;
        this.btnBuycard = button;
        this.ivBuycardrecord = imageView;
        this.llContainer = linearLayout2;
        this.titleBar = titleBar;
        this.vpCard = viewPager;
    }

    public static ActivityBuyCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBuyCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_buy_card, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBuyCardBinding bind(View view) {
        int i = R.id.btn_buycard;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.iv_buycardrecord;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.ll_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.titleBar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        i = R.id.vp_card;
                        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i);
                        if (viewPager != null) {
                            return new ActivityBuyCardBinding((LinearLayout) view, button, imageView, linearLayout, titleBar, viewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
