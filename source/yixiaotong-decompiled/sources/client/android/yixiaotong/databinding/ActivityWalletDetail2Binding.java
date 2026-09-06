package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityWalletDetail2Binding implements ViewBinding {
    public final Button btnPay;
    public final EditText etInputmoney;
    public final ImageView imgXjhb;
    public final LinearLayout linDefined;
    public final LinearLayout linOthermoney;
    public final WrapListView listview;
    public final WrapGridView lvChongzhi;
    public final TextView otherrechargemoneytext;
    public final RelativeLayout relBg;
    public final RelativeLayout relEndsuccess;
    public final RelativeLayout relPay;
    public final RelativeLayout relRechargerecord;
    public final RelativeLayout relRefund;
    public final RelativeLayout relWallet;
    public final RelativeLayout relWallet2;
    private final RelativeLayout rootView;
    public final ScrollView scrollview;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TextView textpayway;
    public final TitleBar titleBar;
    public final TextView tvApplyrefundtext;
    public final TextView tvBalance;
    public final TextView tvBalancetext;
    public final TextView tvCashredpacket;
    public final TextView tvMoney;
    public final TextView tvNopay;
    public final TextView tvOrderrecordtext;
    public final TextView tvRefundtip;
    public final TextView tvSelectbalancetext;
    public final TextView tvServerphone;
    public final TextView tvServertime;
    public final TextView tvTip;
    public final TextView tvUnit;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityWalletDetail2Binding(RelativeLayout relativeLayout, Button button, EditText editText, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, WrapListView wrapListView, WrapGridView wrapGridView, TextView textView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, ScrollView scrollView, PullRefreshLayout pullRefreshLayout, TextView textView2, TitleBar titleBar, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        this.rootView = relativeLayout;
        this.btnPay = button;
        this.etInputmoney = editText;
        this.imgXjhb = imageView;
        this.linDefined = linearLayout;
        this.linOthermoney = linearLayout2;
        this.listview = wrapListView;
        this.lvChongzhi = wrapGridView;
        this.otherrechargemoneytext = textView;
        this.relBg = relativeLayout2;
        this.relEndsuccess = relativeLayout3;
        this.relPay = relativeLayout4;
        this.relRechargerecord = relativeLayout5;
        this.relRefund = relativeLayout6;
        this.relWallet = relativeLayout7;
        this.relWallet2 = relativeLayout8;
        this.scrollview = scrollView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.textpayway = textView2;
        this.titleBar = titleBar;
        this.tvApplyrefundtext = textView3;
        this.tvBalance = textView4;
        this.tvBalancetext = textView5;
        this.tvCashredpacket = textView6;
        this.tvMoney = textView7;
        this.tvNopay = textView8;
        this.tvOrderrecordtext = textView9;
        this.tvRefundtip = textView10;
        this.tvSelectbalancetext = textView11;
        this.tvServerphone = textView12;
        this.tvServertime = textView13;
        this.tvTip = textView14;
        this.tvUnit = textView15;
    }

    public static ActivityWalletDetail2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWalletDetail2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_wallet_detail2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWalletDetail2Binding bind(View view) {
        int i = R.id.btn_pay;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_inputmoney;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.img_xjhb;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.lin_defined;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.lin_othermoney;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
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
                                            i = R.id.rel_endsuccess;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout2 != null) {
                                                i = R.id.rel_pay;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout3 != null) {
                                                    i = R.id.rel_rechargerecord;
                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout4 != null) {
                                                        i = R.id.rel_refund;
                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                        if (relativeLayout5 != null) {
                                                            i = R.id.rel_wallet;
                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout6 != null) {
                                                                i = R.id.rel_wallet2;
                                                                RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout7 != null) {
                                                                    i = R.id.scrollview;
                                                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                    if (scrollView != null) {
                                                                        i = R.id.swipeRefreshLayout;
                                                                        PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (pullRefreshLayout != null) {
                                                                            i = R.id.textpayway;
                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView2 != null) {
                                                                                i = R.id.titleBar;
                                                                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                                if (titleBar != null) {
                                                                                    i = R.id.tv_applyrefundtext;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView3 != null) {
                                                                                        i = R.id.tv_balance;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView4 != null) {
                                                                                            i = R.id.tv_balancetext;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView5 != null) {
                                                                                                i = R.id.tv_cashredpacket;
                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView6 != null) {
                                                                                                    i = R.id.tv_money;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView7 != null) {
                                                                                                        i = R.id.tv_nopay;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView8 != null) {
                                                                                                            i = R.id.tv_orderrecordtext;
                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView9 != null) {
                                                                                                                i = R.id.tv_refundtip;
                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView10 != null) {
                                                                                                                    i = R.id.tv_selectbalancetext;
                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView11 != null) {
                                                                                                                        i = R.id.tv_serverphone;
                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView12 != null) {
                                                                                                                            i = R.id.tv_servertime;
                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView13 != null) {
                                                                                                                                i = R.id.tv_tip;
                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView14 != null) {
                                                                                                                                    i = R.id.tv_unit;
                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView15 != null) {
                                                                                                                                        return new ActivityWalletDetail2Binding((RelativeLayout) view, button, editText, imageView, linearLayout, linearLayout2, wrapListView, wrapGridView, textView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, scrollView, pullRefreshLayout, textView2, titleBar, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15);
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
