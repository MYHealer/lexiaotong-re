package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityMainSmartBinding implements ViewBinding {
    public final ImageView imgDrink;
    public final ImageView imgElec;
    public final ImageView ivImg1;
    public final ImageView ivImg2;
    public final ImageView ivImg3;
    public final ImageView ivImg4;
    public final LinearLayout main;
    public final RelativeLayout relAir;
    private final LinearLayout rootView;
    public final ScrollView scrollview;
    public final TitleBar titlebar;
    public final TextView tvAddress;
    public final TextView tvAirtext;
    public final TextView tvBalance;
    public final TextView tvDu;
    public final TextView tvSisatext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityMainSmartBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout2, RelativeLayout relativeLayout, ScrollView scrollView, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.imgDrink = imageView;
        this.imgElec = imageView2;
        this.ivImg1 = imageView3;
        this.ivImg2 = imageView4;
        this.ivImg3 = imageView5;
        this.ivImg4 = imageView6;
        this.main = linearLayout2;
        this.relAir = relativeLayout;
        this.scrollview = scrollView;
        this.titlebar = titleBar;
        this.tvAddress = textView;
        this.tvAirtext = textView2;
        this.tvBalance = textView3;
        this.tvDu = textView4;
        this.tvSisatext = textView5;
    }

    public static ActivityMainSmartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMainSmartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_main_smart, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityMainSmartBinding bind(View view) {
        int i = R.id.img_drink;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img_elec;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_img1;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.iv_img2;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.iv_img3;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView5 != null) {
                            i = R.id.iv_img4;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView6 != null) {
                                LinearLayout linearLayout = (LinearLayout) view;
                                i = R.id.rel_air;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout != null) {
                                    i = R.id.scrollview;
                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                    if (scrollView != null) {
                                        i = R.id.titlebar;
                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                        if (titleBar != null) {
                                            i = R.id.tv_address;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = R.id.tv_airtext;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.tv_balance;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.tv_du;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.tv_sisatext;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                return new ActivityMainSmartBinding(linearLayout, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, linearLayout, relativeLayout, scrollView, titleBar, textView, textView2, textView3, textView4, textView5);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
