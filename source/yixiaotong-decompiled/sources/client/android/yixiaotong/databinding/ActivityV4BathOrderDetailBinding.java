package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4BathOrderDetailBinding implements ViewBinding {
    public final TextView paymoney;
    public final RelativeLayout relAddress;
    public final RelativeLayout relAlipayDiscount;
    public final RelativeLayout relConsumemoney;
    public final RelativeLayout relConsumetime;
    public final RelativeLayout relDevicemac;
    public final RelativeLayout relDevicename;
    public final RelativeLayout relDiscount;
    public final RelativeLayout relFinishtime;
    public final RelativeLayout relMode;
    public final RelativeLayout relPaystate;
    public final RelativeLayout relPayway;
    public final RelativeLayout relShifu;
    public final RelativeLayout relYouhui;
    private final RelativeLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvAddress;
    public final TextView tvAddresstext;
    public final TextView tvAlipayDiscount;
    public final TextView tvAlipayDiscountText;
    public final TextView tvConsumemoney;
    public final TextView tvConsumetime;
    public final TextView tvDestext;
    public final TextView tvDevicemac;
    public final TextView tvDevicemactext;
    public final TextView tvDevicename;
    public final TextView tvDevicenametext;
    public final TextView tvDiscountamount;
    public final TextView tvDiscounttext;
    public final TextView tvFinishtime;
    public final TextView tvFinishtimetext1;
    public final TextView tvMode;
    public final TextView tvModetext;
    public final TextView tvMoneytext;
    public final TextView tvOrderdes;
    public final TextView tvOrderid;
    public final TextView tvOrderidtext;
    public final TextView tvPattimetext;
    public final TextView tvPayflag;
    public final TextView tvPaytext;
    public final TextView tvPaytime;
    public final TextView tvPayway;
    public final TextView tvPaywaytext;
    public final TextView tvPaywaytext1;
    public final TextView tvTimetext;
    public final View vLine1;
    public final View vLine2;
    public final View vLine4;
    public final View vLine5;
    public final View vLinefinishtime;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4BathOrderDetailBinding(RelativeLayout relativeLayout, TextView textView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, RelativeLayout relativeLayout11, RelativeLayout relativeLayout12, RelativeLayout relativeLayout13, RelativeLayout relativeLayout14, TitleBar titleBar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, TextView textView29, TextView textView30, View view, View view2, View view3, View view4, View view5) {
        this.rootView = relativeLayout;
        this.paymoney = textView;
        this.relAddress = relativeLayout2;
        this.relAlipayDiscount = relativeLayout3;
        this.relConsumemoney = relativeLayout4;
        this.relConsumetime = relativeLayout5;
        this.relDevicemac = relativeLayout6;
        this.relDevicename = relativeLayout7;
        this.relDiscount = relativeLayout8;
        this.relFinishtime = relativeLayout9;
        this.relMode = relativeLayout10;
        this.relPaystate = relativeLayout11;
        this.relPayway = relativeLayout12;
        this.relShifu = relativeLayout13;
        this.relYouhui = relativeLayout14;
        this.titleBar = titleBar;
        this.tvAddress = textView2;
        this.tvAddresstext = textView3;
        this.tvAlipayDiscount = textView4;
        this.tvAlipayDiscountText = textView5;
        this.tvConsumemoney = textView6;
        this.tvConsumetime = textView7;
        this.tvDestext = textView8;
        this.tvDevicemac = textView9;
        this.tvDevicemactext = textView10;
        this.tvDevicename = textView11;
        this.tvDevicenametext = textView12;
        this.tvDiscountamount = textView13;
        this.tvDiscounttext = textView14;
        this.tvFinishtime = textView15;
        this.tvFinishtimetext1 = textView16;
        this.tvMode = textView17;
        this.tvModetext = textView18;
        this.tvMoneytext = textView19;
        this.tvOrderdes = textView20;
        this.tvOrderid = textView21;
        this.tvOrderidtext = textView22;
        this.tvPattimetext = textView23;
        this.tvPayflag = textView24;
        this.tvPaytext = textView25;
        this.tvPaytime = textView26;
        this.tvPayway = textView27;
        this.tvPaywaytext = textView28;
        this.tvPaywaytext1 = textView29;
        this.tvTimetext = textView30;
        this.vLine1 = view;
        this.vLine2 = view2;
        this.vLine4 = view3;
        this.vLine5 = view4;
        this.vLinefinishtime = view5;
    }

    public static ActivityV4BathOrderDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4BathOrderDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_bath_order_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4BathOrderDetailBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        int i = R.id.paymoney;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.rel_address;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.rel_alipay_discount;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout2 != null) {
                    i = R.id.rel_consumemoney;
                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout3 != null) {
                        i = R.id.rel_consumetime;
                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout4 != null) {
                            i = R.id.rel_devicemac;
                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout5 != null) {
                                i = R.id.rel_devicename;
                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout6 != null) {
                                    i = R.id.rel_discount;
                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout7 != null) {
                                        i = R.id.rel_finishtime;
                                        RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout8 != null) {
                                            i = R.id.rel_mode;
                                            RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout9 != null) {
                                                i = R.id.rel_paystate;
                                                RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout10 != null) {
                                                    i = R.id.rel_payway;
                                                    RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout11 != null) {
                                                        i = R.id.rel_shifu;
                                                        RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                        if (relativeLayout12 != null) {
                                                            i = R.id.rel_youhui;
                                                            RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout13 != null) {
                                                                i = R.id.titleBar;
                                                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                if (titleBar != null) {
                                                                    i = R.id.tv_address;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView2 != null) {
                                                                        i = R.id.tv_addresstext;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView3 != null) {
                                                                            i = R.id.tv_alipay_discount;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView4 != null) {
                                                                                i = R.id.tv_alipay_discount_text;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView5 != null) {
                                                                                    i = R.id.tv_consumemoney;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.tv_consumetime;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.tv_destext;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView8 != null) {
                                                                                                i = R.id.tv_devicemac;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.tv_devicemactext;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.tv_devicename;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView11 != null) {
                                                                                                            i = R.id.tv_devicenametext;
                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView12 != null) {
                                                                                                                i = R.id.tv_discountamount;
                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView13 != null) {
                                                                                                                    i = R.id.tv_discounttext;
                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView14 != null) {
                                                                                                                        i = R.id.tv_finishtime;
                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView15 != null) {
                                                                                                                            i = R.id.tv_finishtimetext1;
                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView16 != null) {
                                                                                                                                i = R.id.tv_mode;
                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView17 != null) {
                                                                                                                                    i = R.id.tv_modetext;
                                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView18 != null) {
                                                                                                                                        i = R.id.tv_moneytext;
                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView19 != null) {
                                                                                                                                            i = R.id.tv_orderdes;
                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView20 != null) {
                                                                                                                                                i = R.id.tv_orderid;
                                                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView21 != null) {
                                                                                                                                                    i = R.id.tv_orderidtext;
                                                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView22 != null) {
                                                                                                                                                        i = R.id.tv_pattimetext;
                                                                                                                                                        TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView23 != null) {
                                                                                                                                                            i = R.id.tv_payflag;
                                                                                                                                                            TextView textView24 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (textView24 != null) {
                                                                                                                                                                i = R.id.tv_paytext;
                                                                                                                                                                TextView textView25 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView25 != null) {
                                                                                                                                                                    i = R.id.tv_paytime;
                                                                                                                                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView26 != null) {
                                                                                                                                                                        i = R.id.tv_payway;
                                                                                                                                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (textView27 != null) {
                                                                                                                                                                            i = R.id.tv_paywaytext;
                                                                                                                                                                            TextView textView28 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (textView28 != null) {
                                                                                                                                                                                i = R.id.tv_paywaytext1;
                                                                                                                                                                                TextView textView29 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (textView29 != null) {
                                                                                                                                                                                    i = R.id.tv_timetext;
                                                                                                                                                                                    TextView textView30 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (textView30 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_line1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.v_line2))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.v_line4))) != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.v_line5))) != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.v_linefinishtime))) != null) {
                                                                                                                                                                                        return new ActivityV4BathOrderDetailBinding((RelativeLayout) view, textView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, relativeLayout10, relativeLayout11, relativeLayout12, relativeLayout13, titleBar, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5);
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
