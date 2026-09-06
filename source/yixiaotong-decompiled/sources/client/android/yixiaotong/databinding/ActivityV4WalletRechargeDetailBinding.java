package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4WalletRechargeDetailBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvGiftamount;
    public final TextView tvOrderid;
    public final TextView tvPayway;
    public final TextView tvPrice;
    public final TextView tvTime;
    public final TextView tvUsername;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4WalletRechargeDetailBinding(LinearLayout linearLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.titleBar = titleBar;
        this.tvGiftamount = textView;
        this.tvOrderid = textView2;
        this.tvPayway = textView3;
        this.tvPrice = textView4;
        this.tvTime = textView5;
        this.tvUsername = textView6;
    }

    public static ActivityV4WalletRechargeDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4WalletRechargeDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_wallet_recharge_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4WalletRechargeDetailBinding bind(View view) {
        int i = R.id.titleBar;
        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
        if (titleBar != null) {
            i = R.id.tv_giftamount;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_orderid;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_payway;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.tv_price;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.tv_time;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.tv_username;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    return new ActivityV4WalletRechargeDetailBinding((LinearLayout) view, titleBar, textView, textView2, textView3, textView4, textView5, textView6);
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
