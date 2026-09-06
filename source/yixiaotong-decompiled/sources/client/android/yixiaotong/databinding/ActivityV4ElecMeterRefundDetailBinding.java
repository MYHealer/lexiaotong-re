package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4ElecMeterRefundDetailBinding implements ViewBinding {
    public final ImageView ivReasonIcon;
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvApplicant;
    public final TextView tvApplicantaccount;
    public final TextView tvApplicantaccounttext;
    public final TextView tvApplicanttext;
    public final TextView tvCreatetime;
    public final TextView tvCreatetimetext;
    public final TextView tvOrderid;
    public final TextView tvOrderidtext;
    public final TextView tvReason;
    public final TextView tvReasontext;
    public final TextView tvRefundmoney;
    public final TextView tvRefundmoneytext;
    public final TextView tvState;
    public final TextView tvStatetext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4ElecMeterRefundDetailBinding(LinearLayout linearLayout, ImageView imageView, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        this.rootView = linearLayout;
        this.ivReasonIcon = imageView;
        this.titlebar = titleBar;
        this.tvApplicant = textView;
        this.tvApplicantaccount = textView2;
        this.tvApplicantaccounttext = textView3;
        this.tvApplicanttext = textView4;
        this.tvCreatetime = textView5;
        this.tvCreatetimetext = textView6;
        this.tvOrderid = textView7;
        this.tvOrderidtext = textView8;
        this.tvReason = textView9;
        this.tvReasontext = textView10;
        this.tvRefundmoney = textView11;
        this.tvRefundmoneytext = textView12;
        this.tvState = textView13;
        this.tvStatetext = textView14;
    }

    public static ActivityV4ElecMeterRefundDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4ElecMeterRefundDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_elec_meter_refund_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4ElecMeterRefundDetailBinding bind(View view) {
        int i = R.id.iv_reason_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.titlebar;
            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
            if (titleBar != null) {
                i = R.id.tv_applicant;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_applicantaccount;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_applicantaccounttext;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_applicanttext;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.tv_createtime;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.tv_createtimetext;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null) {
                                        i = R.id.tv_orderid;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView7 != null) {
                                            i = R.id.tv_orderidtext;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView8 != null) {
                                                i = R.id.tv_reason;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView9 != null) {
                                                    i = R.id.tv_reasontext;
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView10 != null) {
                                                        i = R.id.tv_refundmoney;
                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView11 != null) {
                                                            i = R.id.tv_refundmoneytext;
                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView12 != null) {
                                                                i = R.id.tv_state;
                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView13 != null) {
                                                                    i = R.id.tv_statetext;
                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView14 != null) {
                                                                        return new ActivityV4ElecMeterRefundDetailBinding((LinearLayout) view, imageView, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
