package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityLocalDetailBinding implements ViewBinding {
    public final GridView grid;
    public final ImageView imgHelp1;
    public final LinearLayout lin;
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvNumber;
    public final TextView tvText1;
    public final TextView tvTime;
    public final Button yuyuebtn;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityLocalDetailBinding(LinearLayout linearLayout, GridView gridView, ImageView imageView, LinearLayout linearLayout2, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, Button button) {
        this.rootView = linearLayout;
        this.grid = gridView;
        this.imgHelp1 = imageView;
        this.lin = linearLayout2;
        this.titlebar = titleBar;
        this.tvNumber = textView;
        this.tvText1 = textView2;
        this.tvTime = textView3;
        this.yuyuebtn = button;
    }

    public static ActivityLocalDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityLocalDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_local_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityLocalDetailBinding bind(View view) {
        int i = R.id.grid;
        GridView gridView = (GridView) ViewBindings.findChildViewById(view, i);
        if (gridView != null) {
            i = R.id.img_help1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.lin;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.titlebar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        i = R.id.tv_number;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_text1;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.tv_time;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.yuyuebtn;
                                    Button button = (Button) ViewBindings.findChildViewById(view, i);
                                    if (button != null) {
                                        return new ActivityLocalDetailBinding((LinearLayout) view, gridView, imageView, linearLayout, titleBar, textView, textView2, textView3, button);
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
