package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityHamamBindBinding implements ViewBinding {
    public final GridView grid;
    public final RelativeLayout rel;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final RelativeLayout top;
    public final TextView tvAppname;
    public final TextView tvQiehuan;
    public final Button vBtnNext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityHamamBindBinding(LinearLayout linearLayout, GridView gridView, RelativeLayout relativeLayout, TitleBar titleBar, RelativeLayout relativeLayout2, TextView textView, TextView textView2, Button button) {
        this.rootView = linearLayout;
        this.grid = gridView;
        this.rel = relativeLayout;
        this.titleBar = titleBar;
        this.top = relativeLayout2;
        this.tvAppname = textView;
        this.tvQiehuan = textView2;
        this.vBtnNext = button;
    }

    public static ActivityHamamBindBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityHamamBindBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_hamam_bind, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityHamamBindBinding bind(View view) {
        int i = R.id.grid;
        GridView gridView = (GridView) ViewBindings.findChildViewById(view, i);
        if (gridView != null) {
            i = R.id.rel;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.titleBar;
                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                if (titleBar != null) {
                    i = R.id.top;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = R.id.tv_appname;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_qiehuan;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.v_btn_next;
                                Button button = (Button) ViewBindings.findChildViewById(view, i);
                                if (button != null) {
                                    return new ActivityHamamBindBinding((LinearLayout) view, gridView, relativeLayout, titleBar, relativeLayout2, textView, textView2, button);
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
