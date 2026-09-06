package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4DeviceBalanceDetailBinding implements ViewBinding {
    public final Button btnSycn;
    private final LinearLayout rootView;
    public final TextView text1;
    public final TextView text2;
    public final TitleBar titlebar;
    public final TextView tvBalance1;
    public final TextView tvBalance2;
    public final TextView tvTip;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4DeviceBalanceDetailBinding(LinearLayout linearLayout, Button button, TextView textView, TextView textView2, TitleBar titleBar, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btnSycn = button;
        this.text1 = textView;
        this.text2 = textView2;
        this.titlebar = titleBar;
        this.tvBalance1 = textView3;
        this.tvBalance2 = textView4;
        this.tvTip = textView5;
    }

    public static ActivityV4DeviceBalanceDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4DeviceBalanceDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_device_balance_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4DeviceBalanceDetailBinding bind(View view) {
        int i = R.id.btn_sycn;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.text1;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.text2;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.titlebar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        i = R.id.tv_balance1;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_balance2;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.tv_tip;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    return new ActivityV4DeviceBalanceDetailBinding((LinearLayout) view, button, textView, textView2, titleBar, textView3, textView4, textView5);
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
