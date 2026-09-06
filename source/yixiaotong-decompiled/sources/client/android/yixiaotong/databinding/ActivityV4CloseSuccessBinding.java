package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4CloseSuccessBinding implements ViewBinding {
    public final Button btnTolauhch;
    public final ImageView ivConnected;
    public final RelativeLayout rlContainer;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvAdvnameright;
    public final TextView tvContent;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4CloseSuccessBinding(LinearLayout linearLayout, Button button, ImageView imageView, RelativeLayout relativeLayout, TitleBar titleBar, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnTolauhch = button;
        this.ivConnected = imageView;
        this.rlContainer = relativeLayout;
        this.titleBar = titleBar;
        this.tvAdvnameright = textView;
        this.tvContent = textView2;
    }

    public static ActivityV4CloseSuccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4CloseSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_close_success, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4CloseSuccessBinding bind(View view) {
        int i = R.id.btn_tolauhch;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.iv_connected;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.rlContainer;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.titleBar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        i = R.id.tv_advnameright;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_content;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new ActivityV4CloseSuccessBinding((LinearLayout) view, button, imageView, relativeLayout, titleBar, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
