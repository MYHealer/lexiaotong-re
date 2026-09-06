package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapGridView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityYuYueBinding implements ViewBinding {
    public final WrapGridView grid;
    public final LinearLayout lin;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final Button yuyuebtn;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityYuYueBinding(LinearLayout linearLayout, WrapGridView wrapGridView, LinearLayout linearLayout2, TitleBar titleBar, Button button) {
        this.rootView = linearLayout;
        this.grid = wrapGridView;
        this.lin = linearLayout2;
        this.titleBar = titleBar;
        this.yuyuebtn = button;
    }

    public static ActivityYuYueBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityYuYueBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_yu_yue, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityYuYueBinding bind(View view) {
        int i = R.id.grid;
        WrapGridView wrapGridView = (WrapGridView) ViewBindings.findChildViewById(view, i);
        if (wrapGridView != null) {
            i = R.id.lin;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.titleBar;
                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                if (titleBar != null) {
                    i = R.id.yuyuebtn;
                    Button button = (Button) ViewBindings.findChildViewById(view, i);
                    if (button != null) {
                        return new ActivityYuYueBinding((LinearLayout) view, wrapGridView, linearLayout, titleBar, button);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
