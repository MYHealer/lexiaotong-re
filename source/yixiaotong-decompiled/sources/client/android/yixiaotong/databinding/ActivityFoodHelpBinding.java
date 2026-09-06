package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.unionpay.ProgressWebView;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityFoodHelpBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final ProgressWebView wvWebview;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityFoodHelpBinding(LinearLayout linearLayout, TitleBar titleBar, ProgressWebView progressWebView) {
        this.rootView = linearLayout;
        this.titlebar = titleBar;
        this.wvWebview = progressWebView;
    }

    public static ActivityFoodHelpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFoodHelpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_food_help, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFoodHelpBinding bind(View view) {
        int i = R.id.titlebar;
        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
        if (titleBar != null) {
            i = R.id.wv_webview;
            ProgressWebView progressWebView = (ProgressWebView) ViewBindings.findChildViewById(view, i);
            if (progressWebView != null) {
                return new ActivityFoodHelpBinding((LinearLayout) view, titleBar, progressWebView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
