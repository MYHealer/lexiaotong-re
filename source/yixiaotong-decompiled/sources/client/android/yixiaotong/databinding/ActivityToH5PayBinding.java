package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityToH5PayBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TitleBar titlebar;
    public final WebView webView;

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    private ActivityToH5PayBinding(ConstraintLayout constraintLayout, TitleBar titleBar, WebView webView) {
        this.rootView = constraintLayout;
        this.titlebar = titleBar;
        this.webView = webView;
    }

    public static ActivityToH5PayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityToH5PayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_to_h5_pay, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityToH5PayBinding bind(View view) {
        int i = R.id.titlebar;
        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
        if (titleBar != null) {
            i = R.id.web_view;
            WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
            if (webView != null) {
                return new ActivityToH5PayBinding((ConstraintLayout) view, titleBar, webView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
