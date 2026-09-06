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
public final class FaqGridItemBinding implements ViewBinding {
    public final TextView griditem;
    public final ImageView img;
    public final View line1;
    public final View line2;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private FaqGridItemBinding(RelativeLayout relativeLayout, TextView textView, ImageView imageView, View view, View view2) {
        this.rootView = relativeLayout;
        this.griditem = textView;
        this.img = imageView;
        this.line1 = view;
        this.line2 = view2;
    }

    public static FaqGridItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FaqGridItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.faq_grid_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FaqGridItemBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.griditem;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.img;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.line2))) != null) {
                return new FaqGridItemBinding((RelativeLayout) view, textView, imageView, viewFindChildViewById, viewFindChildViewById2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
