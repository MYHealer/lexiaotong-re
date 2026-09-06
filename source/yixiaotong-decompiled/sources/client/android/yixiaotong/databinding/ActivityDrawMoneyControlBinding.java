package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDrawMoneyControlBinding implements ViewBinding {
    public final RelativeLayout flContainer;
    public final ImageView ivDrawmoneyhelp;
    public final ImageView ivScan;
    public final ImageView ivWddd;
    public final RelativeLayout relMyorder;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvAdvname;
    public final TextView tvWdddtext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityDrawMoneyControlBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2, TitleBar titleBar, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.flContainer = relativeLayout;
        this.ivDrawmoneyhelp = imageView;
        this.ivScan = imageView2;
        this.ivWddd = imageView3;
        this.relMyorder = relativeLayout2;
        this.titleBar = titleBar;
        this.tvAdvname = textView;
        this.tvWdddtext = textView2;
    }

    public static ActivityDrawMoneyControlBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDrawMoneyControlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_draw_money_control, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDrawMoneyControlBinding bind(View view) {
        int i = R.id.flContainer;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.iv_drawmoneyhelp;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_scan;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.iv_wddd;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.rel_myorder;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout2 != null) {
                            i = R.id.titleBar;
                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                            if (titleBar != null) {
                                i = R.id.tv_advname;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tv_wdddtext;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        return new ActivityDrawMoneyControlBinding((LinearLayout) view, relativeLayout, imageView, imageView2, imageView3, relativeLayout2, titleBar, textView, textView2);
                                    }
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
