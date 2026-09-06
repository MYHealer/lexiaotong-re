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
public final class AmmeterSubsidyListItemBinding implements ViewBinding {
    public final LinearLayout lin;
    public final View line;
    public final TextView orderId;
    public final RelativeLayout rel;
    private final LinearLayout rootView;
    public final TextView state;
    public final TextView tvOrderId;
    public final TextView tvState;
    public final TextView tvSubsidymoney;
    public final TextView tvText;
    public final TextView tvTime;
    public final TextView tvType;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private AmmeterSubsidyListItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, View view, TextView textView, RelativeLayout relativeLayout, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = linearLayout;
        this.lin = linearLayout2;
        this.line = view;
        this.orderId = textView;
        this.rel = relativeLayout;
        this.state = textView2;
        this.tvOrderId = textView3;
        this.tvState = textView4;
        this.tvSubsidymoney = textView5;
        this.tvText = textView6;
        this.tvTime = textView7;
        this.tvType = textView8;
    }

    public static AmmeterSubsidyListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AmmeterSubsidyListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.ammeter_subsidy_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AmmeterSubsidyListItemBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.lin;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line))) != null) {
            i = R.id.orderId;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.rel;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.state;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_orderId;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_state;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.tv_subsidymoney;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.tv_text;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null) {
                                        i = R.id.tv_time;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView7 != null) {
                                            i = R.id.tv_type;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView8 != null) {
                                                return new AmmeterSubsidyListItemBinding((LinearLayout) view, linearLayout, viewFindChildViewById, textView, relativeLayout, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                            }
                                        }
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
