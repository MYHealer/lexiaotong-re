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
public final class ChongzhiPopwindowBinding implements ViewBinding {
    public final LinearLayout lin;
    public final View line;
    private final LinearLayout rootView;
    public final TextView tvName;
    public final ImageView tvSelect;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ChongzhiPopwindowBinding(LinearLayout linearLayout, LinearLayout linearLayout2, View view, TextView textView, ImageView imageView) {
        this.rootView = linearLayout;
        this.lin = linearLayout2;
        this.line = view;
        this.tvName = textView;
        this.tvSelect = imageView;
    }

    public static ChongzhiPopwindowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ChongzhiPopwindowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.chongzhi_popwindow, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChongzhiPopwindowBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.line;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById != null) {
            i = R.id.tv_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_select;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    return new ChongzhiPopwindowBinding(linearLayout, linearLayout, viewFindChildViewById, textView, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
