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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDrinkWaterCloseBinding implements ViewBinding {
    public final Button btnClose;
    public final TextView connecttiptext;
    public final ImageView ivConnected;
    public final RelativeLayout relClose;
    private final RelativeLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvConnectedtext;
    public final TextView tvMac;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityDrinkWaterCloseBinding(RelativeLayout relativeLayout, Button button, TextView textView, ImageView imageView, RelativeLayout relativeLayout2, TitleBar titleBar, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.btnClose = button;
        this.connecttiptext = textView;
        this.ivConnected = imageView;
        this.relClose = relativeLayout2;
        this.titleBar = titleBar;
        this.tvConnectedtext = textView2;
        this.tvMac = textView3;
    }

    public static ActivityDrinkWaterCloseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDrinkWaterCloseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_drink_water_close, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDrinkWaterCloseBinding bind(View view) {
        int i = R.id.btn_close;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.connecttiptext;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.iv_connected;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.rel_close;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = R.id.titleBar;
                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                        if (titleBar != null) {
                            i = R.id.tv_connectedtext;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.tv_mac;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new ActivityDrinkWaterCloseBinding((RelativeLayout) view, button, textView, imageView, relativeLayout, titleBar, textView2, textView3);
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
