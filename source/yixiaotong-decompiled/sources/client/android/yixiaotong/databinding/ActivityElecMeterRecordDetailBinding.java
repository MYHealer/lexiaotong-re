package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityElecMeterRecordDetailBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvCompletiontime;
    public final TextView tvCompletiontimetext;
    public final TextView tvCreatetime;
    public final TextView tvCreatetimetext;
    public final TextView tvDeviceno;
    public final TextView tvDevicenotext;
    public final TextView tvOrderid;
    public final TextView tvOrderidtext;
    public final TextView tvPaytime;
    public final TextView tvPaytimetext;
    public final TextView tvPayway;
    public final TextView tvPaywaytext;
    public final TextView tvRechargemoney;
    public final TextView tvRechargemoneytext;
    public final TextView tvState;
    public final TextView tvUserno;
    public final TextView tvUsernotext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityElecMeterRecordDetailBinding(LinearLayout linearLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17) {
        this.rootView = linearLayout;
        this.titlebar = titleBar;
        this.tvCompletiontime = textView;
        this.tvCompletiontimetext = textView2;
        this.tvCreatetime = textView3;
        this.tvCreatetimetext = textView4;
        this.tvDeviceno = textView5;
        this.tvDevicenotext = textView6;
        this.tvOrderid = textView7;
        this.tvOrderidtext = textView8;
        this.tvPaytime = textView9;
        this.tvPaytimetext = textView10;
        this.tvPayway = textView11;
        this.tvPaywaytext = textView12;
        this.tvRechargemoney = textView13;
        this.tvRechargemoneytext = textView14;
        this.tvState = textView15;
        this.tvUserno = textView16;
        this.tvUsernotext = textView17;
    }

    public static ActivityElecMeterRecordDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityElecMeterRecordDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_elec_meter_record_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityElecMeterRecordDetailBinding bind(View view) {
        int i = R.id.titlebar;
        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
        if (titleBar != null) {
            i = R.id.tv_completiontime;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_completiontimetext;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_createtime;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.tv_createtimetext;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.tv_deviceno;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.tv_devicenotext;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = R.id.tv_orderid;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView7 != null) {
                                        i = R.id.tv_orderidtext;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView8 != null) {
                                            i = R.id.tv_paytime;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView9 != null) {
                                                i = R.id.tv_paytimetext;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView10 != null) {
                                                    i = R.id.tv_payway;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView11 != null) {
                                                        i = R.id.tv_paywaytext;
                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView12 != null) {
                                                            i = R.id.tv_rechargemoney;
                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView13 != null) {
                                                                i = R.id.tv_rechargemoneytext;
                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView14 != null) {
                                                                    i = R.id.tv_state;
                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView15 != null) {
                                                                        i = R.id.tv_userno;
                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView16 != null) {
                                                                            i = R.id.tv_usernotext;
                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView17 != null) {
                                                                                return new ActivityElecMeterRecordDetailBinding((LinearLayout) view, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17);
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
