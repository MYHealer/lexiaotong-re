package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDrinkWaterControlBinding implements ViewBinding {
    public final RelativeLayout flContainer;
    public final ImageView ivDrinkwaterhelp;
    public final ImageView ivPswopen;
    public final ImageView ivPswopentop;
    public final ImageView ivScan;
    public final ImageView ivWddd;
    public final ImageView ivWdddtop;
    public final ImageView ivWdqb;
    public final ImageView ivWdqbtop;
    public final RelativeLayout relMyorder;
    public final RelativeLayout relMywallet;
    public final RelativeLayout relPswopen;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvAdvname;
    public final TextView tvPswopentext;
    public final TextView tvWdddtext;
    public final TextView tvWdqbtext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityDrinkWaterControlBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.flContainer = relativeLayout;
        this.ivDrinkwaterhelp = imageView;
        this.ivPswopen = imageView2;
        this.ivPswopentop = imageView3;
        this.ivScan = imageView4;
        this.ivWddd = imageView5;
        this.ivWdddtop = imageView6;
        this.ivWdqb = imageView7;
        this.ivWdqbtop = imageView8;
        this.relMyorder = relativeLayout2;
        this.relMywallet = relativeLayout3;
        this.relPswopen = relativeLayout4;
        this.titleBar = titleBar;
        this.tvAdvname = textView;
        this.tvPswopentext = textView2;
        this.tvWdddtext = textView3;
        this.tvWdqbtext = textView4;
    }

    public static ActivityDrinkWaterControlBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDrinkWaterControlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_drink_water_control, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDrinkWaterControlBinding bind(View view) {
        int i = R.id.flContainer;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.iv_drinkwaterhelp;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_pswopen;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.iv_pswopentop;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.iv_scan;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = R.id.iv_wddd;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView5 != null) {
                                i = R.id.iv_wdddtop;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView6 != null) {
                                    i = R.id.iv_wdqb;
                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView7 != null) {
                                        i = R.id.iv_wdqbtop;
                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView8 != null) {
                                            i = R.id.rel_myorder;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout2 != null) {
                                                i = R.id.rel_mywallet;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout3 != null) {
                                                    i = R.id.rel_pswopen;
                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout4 != null) {
                                                        i = R.id.titleBar;
                                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                        if (titleBar != null) {
                                                            i = R.id.tv_advname;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView != null) {
                                                                i = R.id.tv_pswopentext;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView2 != null) {
                                                                    i = R.id.tv_wdddtext;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView3 != null) {
                                                                        i = R.id.tv_wdqbtext;
                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView4 != null) {
                                                                            return new ActivityDrinkWaterControlBinding((LinearLayout) view, relativeLayout, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, relativeLayout2, relativeLayout3, relativeLayout4, titleBar, textView, textView2, textView3, textView4);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
