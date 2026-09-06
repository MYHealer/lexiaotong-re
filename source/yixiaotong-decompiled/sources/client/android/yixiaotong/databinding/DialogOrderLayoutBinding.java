package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DialogOrderLayoutBinding implements ViewBinding {
    public final ImageView imgRotate;
    public final ImageView imgTick;
    public final View line1;
    public final View line2;
    private final LinearLayout rootView;
    public final TextView tvText;
    public final TextView tvText2;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private DialogOrderLayoutBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, View view, View view2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.imgRotate = imageView;
        this.imgTick = imageView2;
        this.line1 = view;
        this.line2 = view2;
        this.tvText = textView;
        this.tvText2 = textView2;
    }

    public static DialogOrderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogOrderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_order_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogOrderLayoutBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.img_rotate;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img_tick;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.line2))) != null) {
                i = R.id.tv_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_text2;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new DialogOrderLayoutBinding((LinearLayout) view, imageView, imageView2, viewFindChildViewById, viewFindChildViewById2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
