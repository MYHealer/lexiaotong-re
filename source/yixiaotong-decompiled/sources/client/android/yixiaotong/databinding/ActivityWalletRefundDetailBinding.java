package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityWalletRefundDetailBinding implements ViewBinding {
    public final ListView lvMessage;
    public final RelativeLayout relAccount;
    public final RelativeLayout relAccounttime;
    public final RelativeLayout relOrderno;
    public final RelativeLayout relPromotion;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvAccount;
    public final TextView tvBeizhu;
    public final TextView tvMessagetext;
    public final TextView tvOrderno;
    public final TextView tvPromotion;
    public final TextView tvRefundmoney;
    public final TextView tvRefundway;
    public final TextView tvState;
    public final TextView tvTime;
    public final TextView tvTimeend;
    public final View vLine;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityWalletRefundDetailBinding(LinearLayout linearLayout, ListView listView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, View view) {
        this.rootView = linearLayout;
        this.lvMessage = listView;
        this.relAccount = relativeLayout;
        this.relAccounttime = relativeLayout2;
        this.relOrderno = relativeLayout3;
        this.relPromotion = relativeLayout4;
        this.titleBar = titleBar;
        this.tvAccount = textView;
        this.tvBeizhu = textView2;
        this.tvMessagetext = textView3;
        this.tvOrderno = textView4;
        this.tvPromotion = textView5;
        this.tvRefundmoney = textView6;
        this.tvRefundway = textView7;
        this.tvState = textView8;
        this.tvTime = textView9;
        this.tvTimeend = textView10;
        this.vLine = view;
    }

    public static ActivityWalletRefundDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWalletRefundDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_wallet_refund_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWalletRefundDetailBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.lv_message;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
        if (listView != null) {
            i = R.id.rel_account;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.rel_accounttime;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout2 != null) {
                    i = R.id.rel_orderno;
                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout3 != null) {
                        i = R.id.rel_promotion;
                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout4 != null) {
                            i = R.id.titleBar;
                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                            if (titleBar != null) {
                                i = R.id.tv_account;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tv_beizhu;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.tv_messagetext;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.tv_orderno;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.tv_promotion;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.tv_refundmoney;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.tv_refundway;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            i = R.id.tv_state;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView8 != null) {
                                                                i = R.id.tv_time;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView9 != null) {
                                                                    i = R.id.tv_timeend;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView10 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_line))) != null) {
                                                                        return new ActivityWalletRefundDetailBinding((LinearLayout) view, listView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, viewFindChildViewById);
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
