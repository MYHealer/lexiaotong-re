package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
public final class ActivityPrepaymentWalletBinding implements ViewBinding {
    public final Button btnPay;
    public final ImageView imgEye;
    public final ImageView imgTip;
    public final WrapListView listview;
    public final WrapGridView lvChongzhi;
    public final RelativeLayout relPay;
    public final RelativeLayout relUpdatebalance;
    public final RelativeLayout relWallet;
    private final RelativeLayout rootView;
    public final ScrollView scrollview;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TextView textpayway;
    public final TitleBar titleBar;
    public final TextView tvBalance;
    public final TextView tvBalancetext;
    public final TextView tvChangedevice;
    public final TextView tvDeviceaddress;
    public final TextView tvDeviceaddresstext;
    public final TextView tvDeviceinfono;
    public final TextView tvDeviceinfonotext;
    public final TextView tvDeviceinfotext;
    public final TextView tvDevicestatue;
    public final TextView tvDevicestatutext;
    public final TextView tvMoney;
    public final TextView tvMoneyunit;
    public final TextView tvName;
    public final TextView tvNopay;
    public final TextView tvRecord;
    public final TextView tvSelectbalancetext;
    public final TextView tvUpdatebalance;
    public final TextView tvUpdatebalancetext;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityPrepaymentWalletBinding(RelativeLayout relativeLayout, Button button, ImageView imageView, ImageView imageView2, WrapListView wrapListView, WrapGridView wrapGridView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, ScrollView scrollView, PullRefreshLayout pullRefreshLayout, TextView textView, TitleBar titleBar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19) {
        this.rootView = relativeLayout;
        this.btnPay = button;
        this.imgEye = imageView;
        this.imgTip = imageView2;
        this.listview = wrapListView;
        this.lvChongzhi = wrapGridView;
        this.relPay = relativeLayout2;
        this.relUpdatebalance = relativeLayout3;
        this.relWallet = relativeLayout4;
        this.scrollview = scrollView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.textpayway = textView;
        this.titleBar = titleBar;
        this.tvBalance = textView2;
        this.tvBalancetext = textView3;
        this.tvChangedevice = textView4;
        this.tvDeviceaddress = textView5;
        this.tvDeviceaddresstext = textView6;
        this.tvDeviceinfono = textView7;
        this.tvDeviceinfonotext = textView8;
        this.tvDeviceinfotext = textView9;
        this.tvDevicestatue = textView10;
        this.tvDevicestatutext = textView11;
        this.tvMoney = textView12;
        this.tvMoneyunit = textView13;
        this.tvName = textView14;
        this.tvNopay = textView15;
        this.tvRecord = textView16;
        this.tvSelectbalancetext = textView17;
        this.tvUpdatebalance = textView18;
        this.tvUpdatebalancetext = textView19;
    }

    public static ActivityPrepaymentWalletBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPrepaymentWalletBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_prepayment_wallet, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPrepaymentWalletBinding bind(View view) {
        int i = R.id.btn_pay;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.img_eye;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.img_tip;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.listview;
                    WrapListView wrapListView = (WrapListView) ViewBindings.findChildViewById(view, i);
                    if (wrapListView != null) {
                        i = R.id.lv_chongzhi;
                        WrapGridView wrapGridView = (WrapGridView) ViewBindings.findChildViewById(view, i);
                        if (wrapGridView != null) {
                            i = R.id.rel_pay;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout != null) {
                                i = R.id.rel_updatebalance;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout2 != null) {
                                    i = R.id.rel_wallet;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout3 != null) {
                                        i = R.id.scrollview;
                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                        if (scrollView != null) {
                                            i = R.id.swipeRefreshLayout;
                                            PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                            if (pullRefreshLayout != null) {
                                                i = R.id.textpayway;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = R.id.titleBar;
                                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                    if (titleBar != null) {
                                                        i = R.id.tv_balance;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView2 != null) {
                                                            i = R.id.tv_balancetext;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView3 != null) {
                                                                i = R.id.tv_changedevice;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView4 != null) {
                                                                    i = R.id.tv_deviceaddress;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.tv_deviceaddresstext;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.tv_deviceinfono;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView7 != null) {
                                                                                i = R.id.tv_deviceinfonotext;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.tv_deviceinfotext;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.tv_devicestatue;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView10 != null) {
                                                                                            i = R.id.tv_devicestatutext;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView11 != null) {
                                                                                                i = R.id.tv_money;
                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView12 != null) {
                                                                                                    i = R.id.tv_moneyunit;
                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView13 != null) {
                                                                                                        i = R.id.tv_name;
                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView14 != null) {
                                                                                                            i = R.id.tv_nopay;
                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView15 != null) {
                                                                                                                i = R.id.tv_record;
                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView16 != null) {
                                                                                                                    i = R.id.tv_selectbalancetext;
                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView17 != null) {
                                                                                                                        i = R.id.tv_updatebalance;
                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView18 != null) {
                                                                                                                            i = R.id.tv_updatebalancetext;
                                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView19 != null) {
                                                                                                                                return new ActivityPrepaymentWalletBinding((RelativeLayout) view, button, imageView, imageView2, wrapListView, wrapGridView, relativeLayout, relativeLayout2, relativeLayout3, scrollView, pullRefreshLayout, textView, titleBar, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19);
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
