package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4ElecMeterControlBinding implements ViewBinding {
    public final RelativeLayout flContainer;
    public final ImageView ivAircontrol;
    public final ImageView ivAnalysis;
    public final ImageView ivChargeroom;
    public final ImageView ivHome;
    public final ImageView ivNext;
    public final ImageView ivNext2;
    public final ImageView ivRecharge;
    public final ImageView ivRechargerecord;
    public final ImageView ivTime;
    public final RelativeLayout relAircontrol;
    public final RelativeLayout relAnalysis;
    public final RelativeLayout relBalance;
    public final RelativeLayout relBottomtime;
    public final RelativeLayout relChangeroom;
    public final RelativeLayout relHousemaster;
    public final RelativeLayout relOther;
    public final RelativeLayout relRecharge;
    public final RelativeLayout relRechargerecord;
    private final LinearLayout rootView;
    public final ScrollView scrollview;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titlebar;
    public final TextView tvAddress;
    public final TextView tvAircontroltext;
    public final TextView tvAnalysis;
    public final TextView tvBalabcetext;
    public final TextView tvBalance;
    public final TextView tvHousemastertip;
    public final TextView tvName;
    public final TextView tvRechargetext;
    public final TextView tvRefunding;
    public final TextView tvTime;
    public final TextView tvTimetext;
    public final TextView tvTiptext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4ElecMeterControlBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, ScrollView scrollView, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = linearLayout;
        this.flContainer = relativeLayout;
        this.ivAircontrol = imageView;
        this.ivAnalysis = imageView2;
        this.ivChargeroom = imageView3;
        this.ivHome = imageView4;
        this.ivNext = imageView5;
        this.ivNext2 = imageView6;
        this.ivRecharge = imageView7;
        this.ivRechargerecord = imageView8;
        this.ivTime = imageView9;
        this.relAircontrol = relativeLayout2;
        this.relAnalysis = relativeLayout3;
        this.relBalance = relativeLayout4;
        this.relBottomtime = relativeLayout5;
        this.relChangeroom = relativeLayout6;
        this.relHousemaster = relativeLayout7;
        this.relOther = relativeLayout8;
        this.relRecharge = relativeLayout9;
        this.relRechargerecord = relativeLayout10;
        this.scrollview = scrollView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titlebar = titleBar;
        this.tvAddress = textView;
        this.tvAircontroltext = textView2;
        this.tvAnalysis = textView3;
        this.tvBalabcetext = textView4;
        this.tvBalance = textView5;
        this.tvHousemastertip = textView6;
        this.tvName = textView7;
        this.tvRechargetext = textView8;
        this.tvRefunding = textView9;
        this.tvTime = textView10;
        this.tvTimetext = textView11;
        this.tvTiptext = textView12;
    }

    public static ActivityV4ElecMeterControlBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4ElecMeterControlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_elec_meter_control, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4ElecMeterControlBinding bind(View view) {
        int i = R.id.flContainer;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.iv_aircontrol;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_analysis;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.iv_chargeroom;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.iv_home;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = R.id.iv_next;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView5 != null) {
                                i = R.id.iv_next2;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView6 != null) {
                                    i = R.id.iv_recharge;
                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView7 != null) {
                                        i = R.id.iv_rechargerecord;
                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView8 != null) {
                                            i = R.id.iv_time;
                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView9 != null) {
                                                i = R.id.rel_aircontrol;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.rel_analysis;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout3 != null) {
                                                        i = R.id.rel_balance;
                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                        if (relativeLayout4 != null) {
                                                            i = R.id.rel_bottomtime;
                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout5 != null) {
                                                                i = R.id.rel_changeroom;
                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout6 != null) {
                                                                    i = R.id.rel_housemaster;
                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (relativeLayout7 != null) {
                                                                        i = R.id.rel_other;
                                                                        RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (relativeLayout8 != null) {
                                                                            i = R.id.rel_recharge;
                                                                            RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (relativeLayout9 != null) {
                                                                                i = R.id.rel_rechargerecord;
                                                                                RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (relativeLayout10 != null) {
                                                                                    i = R.id.scrollview;
                                                                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                                    if (scrollView != null) {
                                                                                        i = R.id.swipeRefreshLayout;
                                                                                        PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (pullRefreshLayout != null) {
                                                                                            i = R.id.titlebar;
                                                                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                                            if (titleBar != null) {
                                                                                                i = R.id.tv_address;
                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView != null) {
                                                                                                    i = R.id.tv_aircontroltext;
                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView2 != null) {
                                                                                                        i = R.id.tv_analysis;
                                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView3 != null) {
                                                                                                            i = R.id.tv_balabcetext;
                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView4 != null) {
                                                                                                                i = R.id.tv_balance;
                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView5 != null) {
                                                                                                                    i = R.id.tv_housemastertip;
                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView6 != null) {
                                                                                                                        i = R.id.tv_name;
                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView7 != null) {
                                                                                                                            i = R.id.tv_rechargetext;
                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView8 != null) {
                                                                                                                                i = R.id.tv_refunding;
                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView9 != null) {
                                                                                                                                    i = R.id.tv_time;
                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView10 != null) {
                                                                                                                                        i = R.id.tv_timetext;
                                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView11 != null) {
                                                                                                                                            i = R.id.tv_tiptext;
                                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView12 != null) {
                                                                                                                                                return new ActivityV4ElecMeterControlBinding((LinearLayout) view, relativeLayout, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, relativeLayout10, scrollView, pullRefreshLayout, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
