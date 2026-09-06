package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityHamamDetailAdapterBinding implements ViewBinding {
    public final GridView grid;
    public final LinearLayout lin;
    public final RelativeLayout rel;
    private final LinearLayout rootView;
    public final TextView text;
    public final TitleBar titleBar;
    public final LinearLayout top;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityHamamDetailAdapterBinding(LinearLayout linearLayout, GridView gridView, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView, TitleBar titleBar, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.grid = gridView;
        this.lin = linearLayout2;
        this.rel = relativeLayout;
        this.text = textView;
        this.titleBar = titleBar;
        this.top = linearLayout3;
    }

    public static ActivityHamamDetailAdapterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityHamamDetailAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_hamam_detail_adapter, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityHamamDetailAdapterBinding bind(View view) {
        int i = R.id.grid;
        GridView gridView = (GridView) ViewBindings.findChildViewById(view, i);
        if (gridView != null) {
            i = R.id.lin;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.rel;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.titleBar;
                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                        if (titleBar != null) {
                            i = R.id.top;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                return new ActivityHamamDetailAdapterBinding((LinearLayout) view, gridView, linearLayout, relativeLayout, textView, titleBar, linearLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
