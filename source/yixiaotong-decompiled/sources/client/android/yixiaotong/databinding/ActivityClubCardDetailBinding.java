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
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityClubCardDetailBinding implements ViewBinding {
    public final TextView paymoney;
    public final RelativeLayout relDiscount;
    public final RelativeLayout relPaystate;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvConsumemoney;
    public final TextView tvConsumetime;
    public final TextView tvDiscountamount;
    public final TextView tvDiscounttext;
    public final TextView tvMoneytext;
    public final TextView tvOrderid;
    public final TextView tvPattimetext;
    public final TextView tvPaytext;
    public final TextView tvPaytime;
    public final TextView tvPayway;
    public final TextView tvPaywaytext;
    public final TextView tvServertext;
    public final TextView tvState;
    public final TextView tvTimetext;
    public final TextView tvUseserver;
    public final TextView tvUsetype;
    public final TextView tvUsetypetext;
    public final View vLine1;
    public final View vLine2;
    public final View vLine3;
    public final View vLine4;
    public final View vLine5;
    public final View vLine6;
    public final View vLine7;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityClubCardDetailBinding(LinearLayout linearLayout, TextView textView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TitleBar titleBar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, View view, View view2, View view3, View view4, View view5, View view6, View view7) {
        this.rootView = linearLayout;
        this.paymoney = textView;
        this.relDiscount = relativeLayout;
        this.relPaystate = relativeLayout2;
        this.titleBar = titleBar;
        this.tvConsumemoney = textView2;
        this.tvConsumetime = textView3;
        this.tvDiscountamount = textView4;
        this.tvDiscounttext = textView5;
        this.tvMoneytext = textView6;
        this.tvOrderid = textView7;
        this.tvPattimetext = textView8;
        this.tvPaytext = textView9;
        this.tvPaytime = textView10;
        this.tvPayway = textView11;
        this.tvPaywaytext = textView12;
        this.tvServertext = textView13;
        this.tvState = textView14;
        this.tvTimetext = textView15;
        this.tvUseserver = textView16;
        this.tvUsetype = textView17;
        this.tvUsetypetext = textView18;
        this.vLine1 = view;
        this.vLine2 = view2;
        this.vLine3 = view3;
        this.vLine4 = view4;
        this.vLine5 = view5;
        this.vLine6 = view6;
        this.vLine7 = view7;
    }

    public static ActivityClubCardDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityClubCardDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_club_card_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityClubCardDetailBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        View viewFindChildViewById6;
        View viewFindChildViewById7;
        int i = R.id.paymoney;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.rel_discount;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.rel_paystate;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout2 != null) {
                    i = R.id.titleBar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        i = R.id.tv_consumemoney;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_consumetime;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.tv_discountamount;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.tv_discounttext;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.tv_moneytext;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R.id.tv_orderid;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                i = R.id.tv_pattimetext;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView8 != null) {
                                                    i = R.id.tv_paytext;
                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView9 != null) {
                                                        i = R.id.tv_paytime;
                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView10 != null) {
                                                            i = R.id.tv_payway;
                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView11 != null) {
                                                                i = R.id.tv_paywaytext;
                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView12 != null) {
                                                                    i = R.id.tv_servertext;
                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView13 != null) {
                                                                        i = R.id.tv_state;
                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView14 != null) {
                                                                            i = R.id.tv_timetext;
                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView15 != null) {
                                                                                i = R.id.tv_useserver;
                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView16 != null) {
                                                                                    i = R.id.tv_usetype;
                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView17 != null) {
                                                                                        i = R.id.tv_usetypetext;
                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView18 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_line1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.v_line2))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.v_line3))) != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.v_line4))) != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.v_line5))) != null && (viewFindChildViewById6 = ViewBindings.findChildViewById(view, (i = R.id.v_line6))) != null && (viewFindChildViewById7 = ViewBindings.findChildViewById(view, (i = R.id.v_line7))) != null) {
                                                                                            return new ActivityClubCardDetailBinding((LinearLayout) view, textView, relativeLayout, relativeLayout2, titleBar, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7);
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
