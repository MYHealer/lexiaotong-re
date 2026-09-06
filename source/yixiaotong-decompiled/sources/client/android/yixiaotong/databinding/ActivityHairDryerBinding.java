package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityHairDryerBinding implements ViewBinding {
    public final FrameLayout flContainer;
    private final RelativeLayout rootView;
    public final TextView time;
    public final TitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityHairDryerBinding(RelativeLayout relativeLayout, FrameLayout frameLayout, TextView textView, TitleBar titleBar) {
        this.rootView = relativeLayout;
        this.flContainer = frameLayout;
        this.time = textView;
        this.titleBar = titleBar;
    }

    public static ActivityHairDryerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityHairDryerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_hair_dryer, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityHairDryerBinding bind(View view) {
        int i = R.id.flContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.time;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.titleBar;
                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                if (titleBar != null) {
                    return new ActivityHairDryerBinding((RelativeLayout) view, frameLayout, textView, titleBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
