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
import client.android.yixiaotong.ui.widget.WaterWaveView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDrinkWaterCleanDataBinding implements ViewBinding {
    public final ImageView ivHelp;
    public final ImageView playSoundwave;
    public final TextView regText;
    public final RelativeLayout rootLayout;
    public final RelativeLayout rootLayout1;
    private final LinearLayout rootView;
    public final WaterWaveView rv;
    public final TextView tvPlaytip;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityDrinkWaterCleanDataBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, WaterWaveView waterWaveView, TextView textView2, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.ivHelp = imageView;
        this.playSoundwave = imageView2;
        this.regText = textView;
        this.rootLayout = relativeLayout;
        this.rootLayout1 = relativeLayout2;
        this.rv = waterWaveView;
        this.tvPlaytip = textView2;
        this.vTitleBar = titleBar;
    }

    public static ActivityDrinkWaterCleanDataBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDrinkWaterCleanDataBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_drink_water_clean_data, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDrinkWaterCleanDataBinding bind(View view) {
        int i = R.id.iv_help;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.play_soundwave;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.regText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.root_layout;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = R.id.root_layout1;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout2 != null) {
                            i = R.id.rv;
                            WaterWaveView waterWaveView = (WaterWaveView) ViewBindings.findChildViewById(view, i);
                            if (waterWaveView != null) {
                                i = R.id.tv_playtip;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.v_titleBar;
                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                    if (titleBar != null) {
                                        return new ActivityDrinkWaterCleanDataBinding((LinearLayout) view, imageView, imageView2, textView, relativeLayout, relativeLayout2, waterWaveView, textView2, titleBar);
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
