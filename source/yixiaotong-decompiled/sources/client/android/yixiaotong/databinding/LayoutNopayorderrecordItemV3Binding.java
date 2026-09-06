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
public final class LayoutNopayorderrecordItemV3Binding implements ViewBinding {
    public final ImageView ivCheck;
    private final RelativeLayout rootView;
    public final TextView tvMoney;
    public final TextView tvOrderid;
    public final TextView tvState;
    public final TextView tvType;
    public final View vLine;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private LayoutNopayorderrecordItemV3Binding(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view) {
        this.rootView = relativeLayout;
        this.ivCheck = imageView;
        this.tvMoney = textView;
        this.tvOrderid = textView2;
        this.tvState = textView3;
        this.tvType = textView4;
        this.vLine = view;
    }

    public static LayoutNopayorderrecordItemV3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutNopayorderrecordItemV3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_nopayorderrecord_item_v3, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutNopayorderrecordItemV3Binding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.iv_check;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.tv_money;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_orderid;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_state;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.tv_type;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_line))) != null) {
                            return new LayoutNopayorderrecordItemV3Binding((RelativeLayout) view, imageView, textView, textView2, textView3, textView4, viewFindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
