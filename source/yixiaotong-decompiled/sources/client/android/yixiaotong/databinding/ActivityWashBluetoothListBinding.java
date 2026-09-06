package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityWashBluetoothListBinding implements ViewBinding {
    public final ImageView imgRefresh;
    public final ImageView imgReset;
    public final ListView recyclerView;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvQuyu;
    public final TextView tvSetquyu;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityWashBluetoothListBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ListView listView, TitleBar titleBar, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.imgRefresh = imageView;
        this.imgReset = imageView2;
        this.recyclerView = listView;
        this.titleBar = titleBar;
        this.tvQuyu = textView;
        this.tvSetquyu = textView2;
    }

    public static ActivityWashBluetoothListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWashBluetoothListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_wash_bluetooth_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWashBluetoothListBinding bind(View view) {
        int i = R.id.img_refresh;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img_reset;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.recycler_view;
                ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                if (listView != null) {
                    i = R.id.titleBar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        i = R.id.tv_quyu;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_setquyu;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new ActivityWashBluetoothListBinding((LinearLayout) view, imageView, imageView2, listView, titleBar, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
