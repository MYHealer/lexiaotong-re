package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityBathOpenBinding implements ViewBinding {
    public final FrameLayout flContainer;
    private final LinearLayout rootView;
    public final TextView time;
    public final TitleBar titleBar;
    public final TextView tvOpensuccess;
    public final TextView tvText;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityBathOpenBinding(LinearLayout linearLayout, FrameLayout frameLayout, TextView textView, TitleBar titleBar, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.flContainer = frameLayout;
        this.time = textView;
        this.titleBar = titleBar;
        this.tvOpensuccess = textView2;
        this.tvText = textView3;
    }

    public static ActivityBathOpenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBathOpenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_bath_open, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBathOpenBinding bind(View view) {
        int i = R.id.flContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.time;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.titleBar;
                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                if (titleBar != null) {
                    i = R.id.tv_opensuccess;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_text;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new ActivityBathOpenBinding((LinearLayout) view, frameLayout, textView, titleBar, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
