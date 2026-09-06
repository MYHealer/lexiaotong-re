package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDeviceDetailBinding implements ViewBinding {
    public final ImageView imgDown;
    public final ListView listview;
    public final RelativeLayout relAddress;
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvAreaname;
    public final View viewBackground;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityDeviceDetailBinding(LinearLayout linearLayout, ImageView imageView, ListView listView, RelativeLayout relativeLayout, TitleBar titleBar, TextView textView, View view) {
        this.rootView = linearLayout;
        this.imgDown = imageView;
        this.listview = listView;
        this.relAddress = relativeLayout;
        this.titlebar = titleBar;
        this.tvAreaname = textView;
        this.viewBackground = view;
    }

    public static ActivityDeviceDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDeviceDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_device_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDeviceDetailBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.img_down;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.listview;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
            if (listView != null) {
                i = R.id.rel_address;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.titlebar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        i = R.id.tv_areaname;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_background))) != null) {
                            return new ActivityDeviceDetailBinding((LinearLayout) view, imageView, listView, relativeLayout, titleBar, textView, viewFindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
