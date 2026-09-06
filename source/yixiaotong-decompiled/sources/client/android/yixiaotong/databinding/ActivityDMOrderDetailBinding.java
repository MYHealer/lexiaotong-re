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
public final class ActivityDMOrderDetailBinding implements ViewBinding {
    public final RelativeLayout relCreatetime;
    public final RelativeLayout relMoney;
    public final RelativeLayout relOrderid;
    public final RelativeLayout relPayplan;
    public final RelativeLayout relPaytime;
    public final RelativeLayout relPayway;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvCurrentstate;
    public final TextView tvMoney;
    public final TextView tvMoneytext;
    public final TextView tvOrderid;
    public final TextView tvOrdertime;
    public final TextView tvOrdettimetext;
    public final TextView tvPayflag;
    public final TextView tvPaytime;
    public final TextView tvPaytimetext;
    public final TextView tvPayway;
    public final TextView tvPaywaytext;
    public final TextView tvPaywaytext1;
    public final TextView tvTimetext;
    public final View vLine1;
    public final View vLine21;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityDMOrderDetailBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, View view, View view2) {
        this.rootView = linearLayout;
        this.relCreatetime = relativeLayout;
        this.relMoney = relativeLayout2;
        this.relOrderid = relativeLayout3;
        this.relPayplan = relativeLayout4;
        this.relPaytime = relativeLayout5;
        this.relPayway = relativeLayout6;
        this.titleBar = titleBar;
        this.tvCurrentstate = textView;
        this.tvMoney = textView2;
        this.tvMoneytext = textView3;
        this.tvOrderid = textView4;
        this.tvOrdertime = textView5;
        this.tvOrdettimetext = textView6;
        this.tvPayflag = textView7;
        this.tvPaytime = textView8;
        this.tvPaytimetext = textView9;
        this.tvPayway = textView10;
        this.tvPaywaytext = textView11;
        this.tvPaywaytext1 = textView12;
        this.tvTimetext = textView13;
        this.vLine1 = view;
        this.vLine21 = view2;
    }

    public static ActivityDMOrderDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDMOrderDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_d_m_order_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDMOrderDetailBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.rel_createtime;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.rel_money;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout2 != null) {
                i = R.id.rel_orderid;
                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout3 != null) {
                    i = R.id.rel_payplan;
                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout4 != null) {
                        i = R.id.rel_paytime;
                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout5 != null) {
                            i = R.id.rel_payway;
                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout6 != null) {
                                i = R.id.titleBar;
                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                if (titleBar != null) {
                                    i = R.id.tv_currentstate;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.tv_money;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.tv_moneytext;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.tv_orderid;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.tv_ordertime;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.tv_ordettimetext;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            i = R.id.tv_payflag;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView7 != null) {
                                                                i = R.id.tv_paytime;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView8 != null) {
                                                                    i = R.id.tv_paytimetext;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView9 != null) {
                                                                        i = R.id.tv_payway;
                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView10 != null) {
                                                                            i = R.id.tv_paywaytext;
                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView11 != null) {
                                                                                i = R.id.tv_paywaytext1;
                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView12 != null) {
                                                                                    i = R.id.tv_timetext;
                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView13 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_line1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.v_line21))) != null) {
                                                                                        return new ActivityDMOrderDetailBinding((LinearLayout) view, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, viewFindChildViewById, viewFindChildViewById2);
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
