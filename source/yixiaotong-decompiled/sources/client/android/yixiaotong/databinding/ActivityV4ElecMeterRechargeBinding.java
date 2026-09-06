package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapGridView;
import client.android.yixiaotong.ui.widget.WrapListView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4ElecMeterRechargeBinding implements ViewBinding {
    public final Button btnPay;
    public final EditText etInputmoney;
    public final LinearLayout linBaseinfo;
    public final LinearLayout linDefined;
    public final LinearLayout linOthermoney;
    public final LinearLayout linRechargemoney;
    public final WrapListView listview;
    public final WrapGridView lvChongzhi;
    public final TextView otherrechargemoneytext;
    public final RelativeLayout relBg;
    public final RelativeLayout relBottom;
    public final RelativeLayout relUserno;
    private final RelativeLayout rootView;
    public final ScrollView scrollview;
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

    private ActivityV4ElecMeterRechargeBinding(RelativeLayout relativeLayout, Button button, EditText editText, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, WrapListView wrapListView, WrapGridView wrapGridView, TextView textView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, ScrollView scrollView, TextView textView2, TitleBar titleBar, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = relativeLayout;
        this.btnPay = button;
        this.etInputmoney = editText;
        this.linBaseinfo = linearLayout;
        this.linDefined = linearLayout2;
        this.linOthermoney = linearLayout3;
        this.linRechargemoney = linearLayout4;
        this.listview = wrapListView;
        this.lvChongzhi = wrapGridView;
        this.otherrechargemoneytext = textView;
        this.relBg = relativeLayout2;
        this.relBottom = relativeLayout3;
        this.relUserno = relativeLayout4;
        this.scrollview = scrollView;
        this.textpayway = textView2;
        this.titlebar = titleBar;
        this.tvDeviceno = textView3;
        this.tvDevicenotext = textView4;
        this.tvMoney = textView5;
        this.tvNopay = textView6;
        this.tvRoomaddress = textView7;
        this.tvRoomaddresstext = textView8;
        this.tvSelectbalancetext = textView9;
        this.tvUnit = textView10;
        this.tvUserno = textView11;
        this.tvUsernotext = textView12;
    }

    public static ActivityV4ElecMeterRechargeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4ElecMeterRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_elec_meter_recharge, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4ElecMeterRechargeBinding bind(View view) {
        int i = R.id.btn_pay;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_inputmoney;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.lin_baseinfo;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.lin_defined;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.lin_othermoney;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null) {
                            i = R.id.lin_rechargemoney;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout4 != null) {
                                i = R.id.listview;
                                WrapListView wrapListView = (WrapListView) ViewBindings.findChildViewById(view, i);
                                if (wrapListView != null) {
                                    i = R.id.lv_chongzhi;
                                    WrapGridView wrapGridView = (WrapGridView) ViewBindings.findChildViewById(view, i);
                                    if (wrapGridView != null) {
                                        i = R.id.otherrechargemoneytext;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.rel_bg;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout != null) {
                                                i = R.id.rel_bottom;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.rel_userno;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout3 != null) {
                                                        i = R.id.scrollview;
                                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                        if (scrollView != null) {
                                                            i = R.id.textpayway;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView2 != null) {
                                                                i = R.id.titlebar;
                                                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                if (titleBar != null) {
                                                                    i = R.id.tv_deviceno;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView3 != null) {
                                                                        i = R.id.tv_devicenotext;
                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView4 != null) {
                                                                            i = R.id.tv_money;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView5 != null) {
                                                                                i = R.id.tv_nopay;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.tv_roomaddress;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.tv_roomaddresstext;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.tv_selectbalancetext;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.tv_unit;
                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView10 != null) {
                                                                                                    i = R.id.tv_userno;
                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView11 != null) {
                                                                                                        i = R.id.tv_usernotext;
                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView12 != null) {
                                                                                                            return new ActivityV4ElecMeterRechargeBinding((RelativeLayout) view, button, editText, linearLayout, linearLayout2, linearLayout3, linearLayout4, wrapListView, wrapGridView, textView, relativeLayout, relativeLayout2, relativeLayout3, scrollView, textView2, titleBar, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
