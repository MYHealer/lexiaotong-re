package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDeviceInitMainBinding implements ViewBinding {
    public final GridView gvInit;
    private final LinearLayout rootView;
    public final TitleBar tbName;
    public final TextView text1;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityDeviceInitMainBinding(LinearLayout linearLayout, GridView gridView, TitleBar titleBar, TextView textView) {
        this.rootView = linearLayout;
        this.gvInit = gridView;
        this.tbName = titleBar;
        this.text1 = textView;
    }

    public static ActivityDeviceInitMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDeviceInitMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_device_init_main, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDeviceInitMainBinding bind(View view) {
        int i = R.id.gv_init;
        GridView gridView = (GridView) ViewBindings.findChildViewById(view, i);
        if (gridView != null) {
            i = R.id.tb_name;
            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
            if (titleBar != null) {
                i = R.id.text1;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new ActivityDeviceInitMainBinding((LinearLayout) view, gridView, titleBar, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
