package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WaterWaveView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDryingBinding implements ViewBinding {
    public final FrameLayout flContainer;
    public final ImageView ivWashPlay;
    private final RelativeLayout rootView;
    public final WaterWaveView rv;
    public final TextView time;
    public final TextView tvTip;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityDryingBinding(RelativeLayout relativeLayout, FrameLayout frameLayout, ImageView imageView, WaterWaveView waterWaveView, TextView textView, TextView textView2, TitleBar titleBar) {
        this.rootView = relativeLayout;
        this.flContainer = frameLayout;
        this.ivWashPlay = imageView;
        this.rv = waterWaveView;
        this.time = textView;
        this.tvTip = textView2;
        this.vTitleBar = titleBar;
    }

    public static ActivityDryingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDryingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_drying, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDryingBinding bind(View view) {
        int i = R.id.flContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.iv_wash_play;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.rv;
                WaterWaveView waterWaveView = (WaterWaveView) ViewBindings.findChildViewById(view, i);
                if (waterWaveView != null) {
                    i = R.id.time;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tv_tip;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.v_titleBar;
                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                            if (titleBar != null) {
                                return new ActivityDryingBinding((RelativeLayout) view, frameLayout, imageView, waterWaveView, textView, textView2, titleBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
