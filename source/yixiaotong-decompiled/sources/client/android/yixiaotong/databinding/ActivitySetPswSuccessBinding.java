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
public final class ActivitySetPswSuccessBinding implements ViewBinding {
    public final Button btnBack;
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvPsw;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivitySetPswSuccessBinding(LinearLayout linearLayout, Button button, TitleBar titleBar, TextView textView) {
        this.rootView = linearLayout;
        this.btnBack = button;
        this.titlebar = titleBar;
        this.tvPsw = textView;
    }

    public static ActivitySetPswSuccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySetPswSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_set_psw_success, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySetPswSuccessBinding bind(View view) {
        int i = R.id.btn_back;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.titlebar;
            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
            if (titleBar != null) {
                i = R.id.tv_psw;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new ActivitySetPswSuccessBinding((LinearLayout) view, button, titleBar, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
