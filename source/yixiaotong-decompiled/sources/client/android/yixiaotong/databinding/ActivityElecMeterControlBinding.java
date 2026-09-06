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
public final class ActivityElecMeterControlBinding implements ViewBinding {
    public final ImageView ivAnalysis;
    public final ImageView ivChargeroom;
    public final ImageView ivHome;
    public final ImageView ivNext;
    public final ImageView ivRecharge;
    public final ImageView ivRechargerecord;
    public final ImageView ivTime;
    public final RelativeLayout relAnalysis;
    public final RelativeLayout relBottomtime;
    public final RelativeLayout relChangeroom;
    public final RelativeLayout relRecharge;
    public final RelativeLayout relRechargerecord;
    private final LinearLayout rootView;
    public final ScrollView scrollview;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titlebar;
    public final TextView tvAddress;
    public final TextView tvBalance;
    public final TextView tvTime;
    public final TextView tvTimetext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityElecMeterControlBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, ScrollView scrollView, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.ivAnalysis = imageView;
        this.ivChargeroom = imageView2;
        this.ivHome = imageView3;
        this.ivNext = imageView4;
        this.ivRecharge = imageView5;
        this.ivRechargerecord = imageView6;
        this.ivTime = imageView7;
        this.relAnalysis = relativeLayout;
        this.relBottomtime = relativeLayout2;
        this.relChangeroom = relativeLayout3;
        this.relRecharge = relativeLayout4;
        this.relRechargerecord = relativeLayout5;
        this.scrollview = scrollView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titlebar = titleBar;
        this.tvAddress = textView;
        this.tvBalance = textView2;
        this.tvTime = textView3;
        this.tvTimetext = textView4;
    }

    public static ActivityElecMeterControlBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityElecMeterControlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_elec_meter_control, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityElecMeterControlBinding bind(View view) {
        int i = R.id.iv_analysis;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_chargeroom;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_home;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.iv_next;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.iv_recharge;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView5 != null) {
                            i = R.id.iv_rechargerecord;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView6 != null) {
                                i = R.id.iv_time;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView7 != null) {
                                    i = R.id.rel_analysis;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout != null) {
                                        i = R.id.rel_bottomtime;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout2 != null) {
                                            i = R.id.rel_changeroom;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout3 != null) {
                                                i = R.id.rel_recharge;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout4 != null) {
                                                    i = R.id.rel_rechargerecord;
                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout5 != null) {
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
                                                                        i = R.id.tv_balance;
                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView2 != null) {
                                                                            i = R.id.tv_time;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView3 != null) {
                                                                                i = R.id.tv_timetext;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView4 != null) {
                                                                                    return new ActivityElecMeterControlBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, scrollView, pullRefreshLayout, titleBar, textView, textView2, textView3, textView4);
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
