package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class AmmeterRecordListItemBinding implements ViewBinding {
    public final LinearLayout lin;
    public final RelativeLayout rel;
    private final LinearLayout rootView;
    public final TextView tv1;
    public final TextView tvChongzhistate;
    public final TextView tvDataTimeTop;
    public final TextView tvDatetime;
    public final TextView tvMoney;
    public final TextView tvOrderId;
    public final View view;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private AmmeterRecordListItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view) {
        this.rootView = linearLayout;
        this.lin = linearLayout2;
        this.rel = relativeLayout;
        this.tv1 = textView;
        this.tvChongzhistate = textView2;
        this.tvDataTimeTop = textView3;
        this.tvDatetime = textView4;
        this.tvMoney = textView5;
        this.tvOrderId = textView6;
        this.view = view;
    }

    public static AmmeterRecordListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AmmeterRecordListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.ammeter_record_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AmmeterRecordListItemBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.lin;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.rel;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.tv1;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_chongzhistate;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_dataTimeTop;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_datetime;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.tv_money;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.tv_orderId;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view))) != null) {
                                        return new AmmeterRecordListItemBinding((LinearLayout) view, linearLayout, relativeLayout, textView, textView2, textView3, textView4, textView5, textView6, viewFindChildViewById);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
