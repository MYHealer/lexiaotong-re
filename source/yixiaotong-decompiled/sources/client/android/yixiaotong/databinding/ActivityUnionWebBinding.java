package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.unionpay.ProgressWebView;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityUnionWebBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TitleBar titleBar;
    public final ProgressWebView webView;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityUnionWebBinding(RelativeLayout relativeLayout, TitleBar titleBar, ProgressWebView progressWebView) {
        this.rootView = relativeLayout;
        this.titleBar = titleBar;
        this.webView = progressWebView;
    }

    public static ActivityUnionWebBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityUnionWebBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_union_web, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityUnionWebBinding bind(View view) {
        int i = R.id.titleBar;
        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
        if (titleBar != null) {
            i = R.id.web_view;
            ProgressWebView progressWebView = (ProgressWebView) ViewBindings.findChildViewById(view, i);
            if (progressWebView != null) {
                return new ActivityUnionWebBinding((RelativeLayout) view, titleBar, progressWebView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
