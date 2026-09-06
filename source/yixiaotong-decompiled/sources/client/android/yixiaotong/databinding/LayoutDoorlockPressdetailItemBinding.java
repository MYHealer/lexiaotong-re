package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class LayoutDoorlockPressdetailItemBinding implements ViewBinding {
    public final ImageView imgPress;
    private final RelativeLayout rootView;
    public final TextView tvDelectkey;
    public final TextView tvKeyname;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private LayoutDoorlockPressdetailItemBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.imgPress = imageView;
        this.tvDelectkey = textView;
        this.tvKeyname = textView2;
    }

    public static LayoutDoorlockPressdetailItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutDoorlockPressdetailItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_doorlock_pressdetail_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutDoorlockPressdetailItemBinding bind(View view) {
        int i = R.id.img_press;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.tv_delectkey;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_keyname;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new LayoutDoorlockPressdetailItemBinding((RelativeLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
