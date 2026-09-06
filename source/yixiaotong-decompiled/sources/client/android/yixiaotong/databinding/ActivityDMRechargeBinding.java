package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapGridView;
import client.android.yixiaotong.ui.widget.WrapListView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDMRechargeBinding implements ViewBinding {
    public final Button btnPay;
    public final EditText etInputmoney;
    public final LinearLayout linMoney;
    public final LinearLayout linOthermoney;
    public final LinearLayout linPayway;
    public final WrapListView listview;
    public final WrapGridView lvChongzhi;
    public final TextView otherrechargemoneytext;
    public final RelativeLayout relPay;
    public final RelativeLayout relTip;
    private final RelativeLayout rootView;
    public final TextView textpayway;
    public final TitleBar titleBar;
    public final TextView tvMoney;
    public final TextView tvNopay;
    public final TextView tvSelectbalancetext;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityDMRechargeBinding(RelativeLayout relativeLayout, Button button, EditText editText, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, WrapListView wrapListView, WrapGridView wrapGridView, TextView textView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView2, TitleBar titleBar, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = relativeLayout;
        this.btnPay = button;
        this.etInputmoney = editText;
        this.linMoney = linearLayout;
        this.linOthermoney = linearLayout2;
        this.linPayway = linearLayout3;
        this.listview = wrapListView;
        this.lvChongzhi = wrapGridView;
        this.otherrechargemoneytext = textView;
        this.relPay = relativeLayout2;
        this.relTip = relativeLayout3;
        this.textpayway = textView2;
        this.titleBar = titleBar;
        this.tvMoney = textView3;
        this.tvNopay = textView4;
        this.tvSelectbalancetext = textView5;
    }

    public static ActivityDMRechargeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDMRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_d_m_recharge, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDMRechargeBinding bind(View view) {
        int i = R.id.btn_pay;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_inputmoney;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.lin_money;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.lin_othermoney;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.lin_payway;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null) {
                            i = R.id.listview;
                            WrapListView wrapListView = (WrapListView) ViewBindings.findChildViewById(view, i);
                            if (wrapListView != null) {
                                i = R.id.lv_chongzhi;
                                WrapGridView wrapGridView = (WrapGridView) ViewBindings.findChildViewById(view, i);
                                if (wrapGridView != null) {
                                    i = R.id.otherrechargemoneytext;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.rel_pay;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout != null) {
                                            i = R.id.rel_tip;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout2 != null) {
                                                i = R.id.textpayway;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.titleBar;
                                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                    if (titleBar != null) {
                                                        i = R.id.tv_money;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_nopay;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_selectbalancetext;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    return new ActivityDMRechargeBinding((RelativeLayout) view, button, editText, linearLayout, linearLayout2, linearLayout3, wrapListView, wrapGridView, textView, relativeLayout, relativeLayout2, textView2, titleBar, textView3, textView4, textView5);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
