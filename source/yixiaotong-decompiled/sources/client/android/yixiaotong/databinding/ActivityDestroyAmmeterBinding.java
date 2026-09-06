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
public final class ActivityDestroyAmmeterBinding implements ViewBinding {
    public final Button btnDestroy;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvBalance;
    public final TextView tvKwh;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityDestroyAmmeterBinding(LinearLayout linearLayout, Button button, TitleBar titleBar, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnDestroy = button;
        this.titleBar = titleBar;
        this.tvBalance = textView;
        this.tvKwh = textView2;
    }

    public static ActivityDestroyAmmeterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDestroyAmmeterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_destroy_ammeter, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDestroyAmmeterBinding bind(View view) {
        int i = R.id.btn_destroy;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.titleBar;
            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
            if (titleBar != null) {
                i = R.id.tv_balance;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_kwh;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new ActivityDestroyAmmeterBinding((LinearLayout) view, button, titleBar, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
