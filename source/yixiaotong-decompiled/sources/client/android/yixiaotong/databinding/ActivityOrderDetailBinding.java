package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityOrderDetailBinding implements ViewBinding {
    public final Button btnTakecard;
    public final TextView paymoney;
    public final RelativeLayout relBottom;
    public final RelativeLayout relConsumemoney;
    public final RelativeLayout relConsumetime;
    public final RelativeLayout relDevicename;
    public final RelativeLayout relDiscount;
    public final RelativeLayout relFinishtime;
    public final RelativeLayout relMaichong1;
    public final RelativeLayout relMaichong2;
    public final RelativeLayout relMode;
    public final RelativeLayout relPayable;
    public final RelativeLayout relPayplan;
    public final RelativeLayout relPaystate;
    public final RelativeLayout relPayway;
    public final RelativeLayout relUse1;
    public final RelativeLayout relUse2;
    public final RelativeLayout relUsetime;
    public final RelativeLayout relYouhui;
    private final RelativeLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvConsumemoney;
    public final TextView tvConsumetime;
    public final TextView tvDestext;
    public final TextView tvDevicename;
    public final TextView tvDevicenametext;
    public final TextView tvDiscountamount;
    public final TextView tvDiscounttext;
    public final TextView tvFinishtime;
    public final TextView tvFinishtimetext1;
    public final TextView tvMaichong1;
    public final TextView tvMaichong2;
    public final TextView tvMaichongtext1;
    public final TextView tvMaichongtext2;
    public final TextView tvMode;
    public final TextView tvModetext;
    public final TextView tvMoneytext;
    public final TextView tvOrderdes;
    public final TextView tvOrderid;
    public final TextView tvPattimetext;
    public final TextView tvPayflag;
    public final TextView tvPaytext;
    public final TextView tvPaytime;
    public final TextView tvPayway;
    public final TextView tvPaywaytext;
    public final TextView tvPaywaytext1;
    public final TextView tvState;
    public final TextView tvTimetext;
    public final TextView tvUse1;
    public final TextView tvUse2;
    public final TextView tvUsetext1;
    public final TextView tvUsetext2;
    public final TextView tvUsetime;
    public final TextView tvUsetimetext;
    public final View vLine1;
    public final View vLine2;
    public final View vLine4;
    public final View vLine5;
    public final View vLinefinishtime;
    public final View vLineuse1;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityOrderDetailBinding(RelativeLayout relativeLayout, Button button, TextView textView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, RelativeLayout relativeLayout11, RelativeLayout relativeLayout12, RelativeLayout relativeLayout13, RelativeLayout relativeLayout14, RelativeLayout relativeLayout15, RelativeLayout relativeLayout16, RelativeLayout relativeLayout17, RelativeLayout relativeLayout18, TitleBar titleBar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, TextView textView29, TextView textView30, TextView textView31, TextView textView32, TextView textView33, TextView textView34, View view, View view2, View view3, View view4, View view5, View view6) {
        this.rootView = relativeLayout;
        this.btnTakecard = button;
        this.paymoney = textView;
        this.relBottom = relativeLayout2;
        this.relConsumemoney = relativeLayout3;
        this.relConsumetime = relativeLayout4;
        this.relDevicename = relativeLayout5;
        this.relDiscount = relativeLayout6;
        this.relFinishtime = relativeLayout7;
        this.relMaichong1 = relativeLayout8;
        this.relMaichong2 = relativeLayout9;
        this.relMode = relativeLayout10;
        this.relPayable = relativeLayout11;
        this.relPayplan = relativeLayout12;
        this.relPaystate = relativeLayout13;
        this.relPayway = relativeLayout14;
        this.relUse1 = relativeLayout15;
        this.relUse2 = relativeLayout16;
        this.relUsetime = relativeLayout17;
        this.relYouhui = relativeLayout18;
        this.titleBar = titleBar;
        this.tvConsumemoney = textView2;
        this.tvConsumetime = textView3;
        this.tvDestext = textView4;
        this.tvDevicename = textView5;
        this.tvDevicenametext = textView6;
        this.tvDiscountamount = textView7;
        this.tvDiscounttext = textView8;
        this.tvFinishtime = textView9;
        this.tvFinishtimetext1 = textView10;
        this.tvMaichong1 = textView11;
        this.tvMaichong2 = textView12;
        this.tvMaichongtext1 = textView13;
        this.tvMaichongtext2 = textView14;
        this.tvMode = textView15;
        this.tvModetext = textView16;
        this.tvMoneytext = textView17;
        this.tvOrderdes = textView18;
        this.tvOrderid = textView19;
        this.tvPattimetext = textView20;
        this.tvPayflag = textView21;
        this.tvPaytext = textView22;
        this.tvPaytime = textView23;
        this.tvPayway = textView24;
        this.tvPaywaytext = textView25;
        this.tvPaywaytext1 = textView26;
        this.tvState = textView27;
        this.tvTimetext = textView28;
        this.tvUse1 = textView29;
        this.tvUse2 = textView30;
        this.tvUsetext1 = textView31;
        this.tvUsetext2 = textView32;
        this.tvUsetime = textView33;
        this.tvUsetimetext = textView34;
        this.vLine1 = view;
        this.vLine2 = view2;
        this.vLine4 = view3;
        this.vLine5 = view4;
        this.vLinefinishtime = view5;
        this.vLineuse1 = view6;
    }

    public static ActivityOrderDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityOrderDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_order_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityOrderDetailBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        View viewFindChildViewById6;
        int i = R.id.btn_takecard;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.paymoney;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.rel_bottom;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.rel_consumemoney;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = R.id.rel_consumetime;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout3 != null) {
                            i = R.id.rel_devicename;
                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout4 != null) {
                                i = R.id.rel_discount;
                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout5 != null) {
                                    i = R.id.rel_finishtime;
                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout6 != null) {
                                        i = R.id.rel_maichong1;
                                        RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout7 != null) {
                                            i = R.id.rel_maichong2;
                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout8 != null) {
                                                i = R.id.rel_mode;
                                                RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout9 != null) {
                                                    i = R.id.rel_payable;
                                                    RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout10 != null) {
                                                        i = R.id.rel_payplan;
                                                        RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                        if (relativeLayout11 != null) {
                                                            i = R.id.rel_paystate;
                                                            RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout12 != null) {
                                                                i = R.id.rel_payway;
                                                                RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout13 != null) {
                                                                    i = R.id.rel_use1;
                                                                    RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (relativeLayout14 != null) {
                                                                        i = R.id.rel_use2;
                                                                        RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (relativeLayout15 != null) {
                                                                            i = R.id.rel_usetime;
                                                                            RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (relativeLayout16 != null) {
                                                                                i = R.id.rel_youhui;
                                                                                RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (relativeLayout17 != null) {
                                                                                    i = R.id.titleBar;
                                                                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                                    if (titleBar != null) {
                                                                                        i = R.id.tv_consumemoney;
                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView2 != null) {
                                                                                            i = R.id.tv_consumetime;
                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView3 != null) {
                                                                                                i = R.id.tv_destext;
                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView4 != null) {
                                                                                                    i = R.id.tv_devicename;
                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView5 != null) {
                                                                                                        i = R.id.tv_devicenametext;
                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView6 != null) {
                                                                                                            i = R.id.tv_discountamount;
                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView7 != null) {
                                                                                                                i = R.id.tv_discounttext;
                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView8 != null) {
                                                                                                                    i = R.id.tv_finishtime;
                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView9 != null) {
                                                                                                                        i = R.id.tv_finishtimetext1;
                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView10 != null) {
                                                                                                                            i = R.id.tv_maichong1;
                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView11 != null) {
                                                                                                                                i = R.id.tv_maichong2;
                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView12 != null) {
                                                                                                                                    i = R.id.tv_maichongtext1;
                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView13 != null) {
                                                                                                                                        i = R.id.tv_maichongtext2;
                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView14 != null) {
                                                                                                                                            i = R.id.tv_mode;
                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView15 != null) {
                                                                                                                                                i = R.id.tv_modetext;
                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView16 != null) {
                                                                                                                                                    i = R.id.tv_moneytext;
                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                        i = R.id.tv_orderdes;
                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                            i = R.id.tv_orderid;
                                                                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (textView19 != null) {
                                                                                                                                                                i = R.id.tv_pattimetext;
                                                                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView20 != null) {
                                                                                                                                                                    i = R.id.tv_payflag;
                                                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                                        i = R.id.tv_paytext;
                                                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                                            i = R.id.tv_paytime;
                                                                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (textView23 != null) {
                                                                                                                                                                                i = R.id.tv_payway;
                                                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                    i = R.id.tv_paywaytext;
                                                                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                                                        i = R.id.tv_paywaytext1;
                                                                                                                                                                                        TextView textView26 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (textView26 != null) {
                                                                                                                                                                                            i = R.id.tv_state;
                                                                                                                                                                                            TextView textView27 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (textView27 != null) {
                                                                                                                                                                                                i = R.id.tv_timetext;
                                                                                                                                                                                                TextView textView28 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (textView28 != null) {
                                                                                                                                                                                                    i = R.id.tv_use1;
                                                                                                                                                                                                    TextView textView29 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (textView29 != null) {
                                                                                                                                                                                                        i = R.id.tv_use2;
                                                                                                                                                                                                        TextView textView30 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (textView30 != null) {
                                                                                                                                                                                                            i = R.id.tv_usetext1;
                                                                                                                                                                                                            TextView textView31 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (textView31 != null) {
                                                                                                                                                                                                                i = R.id.tv_usetext2;
                                                                                                                                                                                                                TextView textView32 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (textView32 != null) {
                                                                                                                                                                                                                    i = R.id.tv_usetime;
                                                                                                                                                                                                                    TextView textView33 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                    if (textView33 != null) {
                                                                                                                                                                                                                        i = R.id.tv_usetimetext;
                                                                                                                                                                                                                        TextView textView34 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                        if (textView34 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_line1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.v_line2))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.v_line4))) != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.v_line5))) != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.v_linefinishtime))) != null && (viewFindChildViewById6 = ViewBindings.findChildViewById(view, (i = R.id.v_lineuse1))) != null) {
                                                                                                                                                                                                                            return new ActivityOrderDetailBinding((RelativeLayout) view, button, textView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, relativeLayout10, relativeLayout11, relativeLayout12, relativeLayout13, relativeLayout14, relativeLayout15, relativeLayout16, relativeLayout17, titleBar, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31, textView32, textView33, textView34, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6);
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
