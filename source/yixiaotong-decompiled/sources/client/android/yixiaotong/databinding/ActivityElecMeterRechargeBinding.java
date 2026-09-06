package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
public final class ActivityElecMeterRechargeBinding implements ViewBinding {
    public final Button btnPay;
    public final LinearLayout linBaseinfo;
    public final LinearLayout linRechargemoney;
    public final WrapListView listview;
    public final WrapGridView lvChongzhi;
    public final RelativeLayout relBottom;
    private final RelativeLayout rootView;
    public final TextView textpayway;
    public final TitleBar titlebar;
    public final TextView tvDeviceno;
    public final TextView tvDevicenotext;
    public final TextView tvMoney;
    public final TextView tvNopay;
    public final TextView tvRoomaddress;
    public final TextView tvRoomaddresstext;
    public final TextView tvSelectbalancetext;
    public final TextView tvUnit;
    public final TextView tvUserno;
    public final TextView tvUsernotext;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityElecMeterRechargeBinding(RelativeLayout relativeLayout, Button button, LinearLayout linearLayout, LinearLayout linearLayout2, WrapListView wrapListView, WrapGridView wrapGridView, RelativeLayout relativeLayout2, TextView textView, TitleBar titleBar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = relativeLayout;
        this.btnPay = button;
        this.linBaseinfo = linearLayout;
        this.linRechargemoney = linearLayout2;
        this.listview = wrapListView;
        this.lvChongzhi = wrapGridView;
        this.relBottom = relativeLayout2;
        this.textpayway = textView;
        this.titlebar = titleBar;
        this.tvDeviceno = textView2;
        this.tvDevicenotext = textView3;
        this.tvMoney = textView4;
        this.tvNopay = textView5;
        this.tvRoomaddress = textView6;
        this.tvRoomaddresstext = textView7;
        this.tvSelectbalancetext = textView8;
        this.tvUnit = textView9;
        this.tvUserno = textView10;
        this.tvUsernotext = textView11;
    }

    public static ActivityElecMeterRechargeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityElecMeterRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_elec_meter_recharge, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityElecMeterRechargeBinding bind(View view) {
        int i = R.id.btn_pay;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.lin_baseinfo;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.lin_rechargemoney;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.listview;
                    WrapListView wrapListView = (WrapListView) ViewBindings.findChildViewById(view, i);
                    if (wrapListView != null) {
                        i = R.id.lv_chongzhi;
                        WrapGridView wrapGridView = (WrapGridView) ViewBindings.findChildViewById(view, i);
                        if (wrapGridView != null) {
                            i = R.id.rel_bottom;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout != null) {
                                i = R.id.textpayway;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.titlebar;
                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                    if (titleBar != null) {
                                        i = R.id.tv_deviceno;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.tv_devicenotext;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.tv_money;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.tv_nopay;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.tv_roomaddress;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            i = R.id.tv_roomaddresstext;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView7 != null) {
                                                                i = R.id.tv_selectbalancetext;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView8 != null) {
                                                                    i = R.id.tv_unit;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView9 != null) {
                                                                        i = R.id.tv_userno;
                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView10 != null) {
                                                                            i = R.id.tv_usernotext;
                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView11 != null) {
                                                                                return new ActivityElecMeterRechargeBinding((RelativeLayout) view, button, linearLayout, linearLayout2, wrapListView, wrapGridView, relativeLayout, textView, titleBar, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
