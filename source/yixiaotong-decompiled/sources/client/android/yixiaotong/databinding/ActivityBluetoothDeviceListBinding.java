package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityBluetoothDeviceListBinding implements ViewBinding {
    public final ImageView imgRefresh;
    public final ListView recyclerView;
    private final LinearLayout rootView;
    public final TitleBar titlebar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityBluetoothDeviceListBinding(LinearLayout linearLayout, ImageView imageView, ListView listView, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.imgRefresh = imageView;
        this.recyclerView = listView;
        this.titlebar = titleBar;
    }

    public static ActivityBluetoothDeviceListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBluetoothDeviceListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_bluetooth_device_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBluetoothDeviceListBinding bind(View view) {
        int i = R.id.img_refresh;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.recycler_view;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
            if (listView != null) {
                i = R.id.titlebar;
                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                if (titleBar != null) {
                    return new ActivityBluetoothDeviceListBinding((LinearLayout) view, imageView, listView, titleBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
