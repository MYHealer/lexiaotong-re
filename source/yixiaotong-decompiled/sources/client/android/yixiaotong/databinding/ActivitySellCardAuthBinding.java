package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WaterWaveView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivitySellCardAuthBinding implements ViewBinding {
    public final Button btntoast;
    public final ImageView playSoundwave;
    public final RelativeLayout rootLayout;
    private final RelativeLayout rootView;
    public final WaterWaveView rv;
    public final TitleBar titleBar;
    public final TextView tvShowPlay;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivitySellCardAuthBinding(RelativeLayout relativeLayout, Button button, ImageView imageView, RelativeLayout relativeLayout2, WaterWaveView waterWaveView, TitleBar titleBar, TextView textView) {
        this.rootView = relativeLayout;
        this.btntoast = button;
        this.playSoundwave = imageView;
        this.rootLayout = relativeLayout2;
        this.rv = waterWaveView;
        this.titleBar = titleBar;
        this.tvShowPlay = textView;
    }

    public static ActivitySellCardAuthBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySellCardAuthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_sell_card_auth, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySellCardAuthBinding bind(View view) {
        int i = R.id.btntoast;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.play_soundwave;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.root_layout;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.rv;
                    WaterWaveView waterWaveView = (WaterWaveView) ViewBindings.findChildViewById(view, i);
                    if (waterWaveView != null) {
                        i = R.id.titleBar;
                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                        if (titleBar != null) {
                            i = R.id.tv_show_play;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new ActivitySellCardAuthBinding((RelativeLayout) view, button, imageView, relativeLayout, waterWaveView, titleBar, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
