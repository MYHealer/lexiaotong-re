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
public final class ActivityV4AirControlBinding implements ViewBinding {
    public final ImageView ivSweeping;
    public final ImageView ivWinddirection;
    public final ImageView ivWindspeed;
    public final LinearLayout main;
    public final RelativeLayout relOpenclose;
    public final RelativeLayout relWinddirection;
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvTemperature;
    public final TextView tvUnit;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4AirControlBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TitleBar titleBar, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.ivSweeping = imageView;
        this.ivWinddirection = imageView2;
        this.ivWindspeed = imageView3;
        this.main = linearLayout2;
        this.relOpenclose = relativeLayout;
        this.relWinddirection = relativeLayout2;
        this.titlebar = titleBar;
        this.tvTemperature = textView;
        this.tvUnit = textView2;
    }

    public static ActivityV4AirControlBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4AirControlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_air_control, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4AirControlBinding bind(View view) {
        int i = R.id.iv_sweeping;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_winddirection;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_windspeed;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i = R.id.rel_openclose;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = R.id.rel_winddirection;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout2 != null) {
                            i = R.id.titlebar;
                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                            if (titleBar != null) {
                                i = R.id.tv_temperature;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tv_unit;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        return new ActivityV4AirControlBinding(linearLayout, imageView, imageView2, imageView3, linearLayout, relativeLayout, relativeLayout2, titleBar, textView, textView2);
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
