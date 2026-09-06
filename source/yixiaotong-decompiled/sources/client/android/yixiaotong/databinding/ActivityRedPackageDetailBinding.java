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
public final class ActivityRedPackageDetailBinding implements ViewBinding {
    public final ImageView ivFws;
    public final ImageView ivSysb;
    public final ImageView ivSysd;
    public final ImageView ivYxq;
    public final LinearLayout linHbbg;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvFwstext;
    public final TextView tvMoney;
    public final TextView tvRenmimbi;
    public final TextView tvServername;
    public final TextView tvSysbtext;
    public final TextView tvSysdtext;
    public final TextView tvTime;
    public final TextView tvUsedevice;
    public final TextView tvUseserver;
    public final TextView tvUsetext;
    public final TextView tvUsetime;
    public final TextView tvUsetime2;
    public final TextView tvYxqtext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityRedPackageDetailBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        this.rootView = linearLayout;
        this.ivFws = imageView;
        this.ivSysb = imageView2;
        this.ivSysd = imageView3;
        this.ivYxq = imageView4;
        this.linHbbg = linearLayout2;
        this.titleBar = titleBar;
        this.tvFwstext = textView;
        this.tvMoney = textView2;
        this.tvRenmimbi = textView3;
        this.tvServername = textView4;
        this.tvSysbtext = textView5;
        this.tvSysdtext = textView6;
        this.tvTime = textView7;
        this.tvUsedevice = textView8;
        this.tvUseserver = textView9;
        this.tvUsetext = textView10;
        this.tvUsetime = textView11;
        this.tvUsetime2 = textView12;
        this.tvYxqtext = textView13;
    }

    public static ActivityRedPackageDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRedPackageDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_red_package_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRedPackageDetailBinding bind(View view) {
        int i = R.id.iv_fws;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_sysb;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_sysd;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.iv_yxq;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.lin_hbbg;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.titleBar;
                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                            if (titleBar != null) {
                                i = R.id.tv_fwstext;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tv_money;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.tv_renmimbi;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.tv_servername;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.tv_sysbtext;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.tv_sysdtext;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.tv_time;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            i = R.id.tv_usedevice;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView8 != null) {
                                                                i = R.id.tv_useserver;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView9 != null) {
                                                                    i = R.id.tv_usetext;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView10 != null) {
                                                                        i = R.id.tv_usetime;
                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView11 != null) {
                                                                            i = R.id.tv_usetime2;
                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView12 != null) {
                                                                                i = R.id.tv_yxqtext;
                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView13 != null) {
                                                                                    return new ActivityRedPackageDetailBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4, linearLayout, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13);
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
