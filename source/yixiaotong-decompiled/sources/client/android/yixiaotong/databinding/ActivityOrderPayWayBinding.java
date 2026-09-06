package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapListView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityOrderPayWayBinding implements ViewBinding {
    public final Button btnPay;
    public final LinearLayout linPayway;
    public final WrapListView listview;
    private final LinearLayout rootView;
    public final TextView textpayway;
    public final TitleBar titleBar;
    public final TextView tvPaymoney;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityOrderPayWayBinding(LinearLayout linearLayout, Button button, LinearLayout linearLayout2, WrapListView wrapListView, TextView textView, TitleBar titleBar, TextView textView2) {
        this.rootView = linearLayout;
        this.btnPay = button;
        this.linPayway = linearLayout2;
        this.listview = wrapListView;
        this.textpayway = textView;
        this.titleBar = titleBar;
        this.tvPaymoney = textView2;
    }

    public static ActivityOrderPayWayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityOrderPayWayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_order_pay_way, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityOrderPayWayBinding bind(View view) {
        int i = R.id.btn_pay;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.lin_payway;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.listview;
                WrapListView wrapListView = (WrapListView) ViewBindings.findChildViewById(view, i);
                if (wrapListView != null) {
                    i = R.id.textpayway;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.titleBar;
                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                        if (titleBar != null) {
                            i = R.id.tv_paymoney;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new ActivityOrderPayWayBinding((LinearLayout) view, button, linearLayout, wrapListView, textView, titleBar, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
