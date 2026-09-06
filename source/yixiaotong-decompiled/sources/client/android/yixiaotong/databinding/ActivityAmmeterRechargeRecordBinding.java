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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityAmmeterRechargeRecordBinding implements ViewBinding {
    public final Button read;
    private final LinearLayout rootView;
    public final TextView tvAllmoney;
    public final TextView tvChongzhicount;
    public final TextView tvDate;
    public final TextView tvElectricityconsumption;
    public final TextView tvLastChongzhimoney;
    public final TextView tvShengyumoney;
    public final TextView tvType;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityAmmeterRechargeRecordBinding(LinearLayout linearLayout, Button button, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.read = button;
        this.tvAllmoney = textView;
        this.tvChongzhicount = textView2;
        this.tvDate = textView3;
        this.tvElectricityconsumption = textView4;
        this.tvLastChongzhimoney = textView5;
        this.tvShengyumoney = textView6;
        this.tvType = textView7;
        this.vTitleBar = titleBar;
    }

    public static ActivityAmmeterRechargeRecordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAmmeterRechargeRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_ammeter_recharge_record, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAmmeterRechargeRecordBinding bind(View view) {
        int i = R.id.read;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.tv_allmoney;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_chongzhicount;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_date;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.tv_electricityconsumption;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.tv_last_chongzhimoney;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.tv_shengyumoney;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = R.id.tv_type;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView7 != null) {
                                        i = R.id.v_titleBar;
                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                        if (titleBar != null) {
                                            return new ActivityAmmeterRechargeRecordBinding((LinearLayout) view, button, textView, textView2, textView3, textView4, textView5, textView6, textView7, titleBar);
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
