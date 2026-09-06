package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class FragmentV3ServerBinding implements ViewBinding {
    public final ImageView imgServerphone;
    public final ImageView imgServertime;
    public final ImageView ivNext1;
    public final ImageView ivNext2;
    public final ImageView ivNextcash;
    public final ImageView ivNextzkt;
    public final ImageView ivServerimg;
    public final ImageView ivYeicon;
    public final ImageView ivYeiconcash;
    public final ImageView ivYjicon;
    public final ImageView ivZkticon;
    public final RelativeLayout relBalance;
    public final RelativeLayout relCashbalance;
    public final RelativeLayout relDeposit;
    public final RelativeLayout relError;
    public final RelativeLayout relServerinfo;
    public final RelativeLayout relZhikatong;
    private final LinearLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TextView tvBalance;
    public final TextView tvCashbalance;
    public final TextView tvCashredpackagetext;
    public final TextView tvCashrefunding;
    public final TextView tvCashyuan;
    public final TextView tvProvidertext;
    public final TextView tvServer;
    public final TextView tvServerdes;
    public final TextView tvServername;
    public final TextView tvServerphone;
    public final TextView tvServerphonetext;
    public final TextView tvServertime;
    public final TextView tvServertimetext;
    public final TextView tvYuan;
    public final TextView tvZktstate;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private FragmentV3ServerBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, PullRefreshLayout pullRefreshLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        this.rootView = linearLayout;
        this.imgServerphone = imageView;
        this.imgServertime = imageView2;
        this.ivNext1 = imageView3;
        this.ivNext2 = imageView4;
        this.ivNextcash = imageView5;
        this.ivNextzkt = imageView6;
        this.ivServerimg = imageView7;
        this.ivYeicon = imageView8;
        this.ivYeiconcash = imageView9;
        this.ivYjicon = imageView10;
        this.ivZkticon = imageView11;
        this.relBalance = relativeLayout;
        this.relCashbalance = relativeLayout2;
        this.relDeposit = relativeLayout3;
        this.relError = relativeLayout4;
        this.relServerinfo = relativeLayout5;
        this.relZhikatong = relativeLayout6;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.tvBalance = textView;
        this.tvCashbalance = textView2;
        this.tvCashredpackagetext = textView3;
        this.tvCashrefunding = textView4;
        this.tvCashyuan = textView5;
        this.tvProvidertext = textView6;
        this.tvServer = textView7;
        this.tvServerdes = textView8;
        this.tvServername = textView9;
        this.tvServerphone = textView10;
        this.tvServerphonetext = textView11;
        this.tvServertime = textView12;
        this.tvServertimetext = textView13;
        this.tvYuan = textView14;
        this.tvZktstate = textView15;
    }

    public static FragmentV3ServerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentV3ServerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v3_server, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentV3ServerBinding bind(View view) {
        int i = R.id.img_serverphone;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img_servertime;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_next1;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.iv_next2;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.iv_nextcash;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView5 != null) {
                            i = R.id.iv_nextzkt;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView6 != null) {
                                i = R.id.iv_serverimg;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView7 != null) {
                                    i = R.id.iv_yeicon;
                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView8 != null) {
                                        i = R.id.iv_yeiconcash;
                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView9 != null) {
                                            i = R.id.iv_yjicon;
                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView10 != null) {
                                                i = R.id.iv_zkticon;
                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView11 != null) {
                                                    i = R.id.rel_balance;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout != null) {
                                                        i = R.id.rel_cashbalance;
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                        if (relativeLayout2 != null) {
                                                            i = R.id.rel_deposit;
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout3 != null) {
                                                                i = R.id.rel_error;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout4 != null) {
                                                                    i = R.id.rel_serverinfo;
                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (relativeLayout5 != null) {
                                                                        i = R.id.rel_zhikatong;
                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (relativeLayout6 != null) {
                                                                            i = R.id.swipeRefreshLayout;
                                                                            PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (pullRefreshLayout != null) {
                                                                                i = R.id.tv_balance;
                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView != null) {
                                                                                    i = R.id.tv_cashbalance;
                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView2 != null) {
                                                                                        i = R.id.tv_cashredpackagetext;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.tv_cashrefunding;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.tv_cashyuan;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.tv_providertext;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.tv_server;
                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView7 != null) {
                                                                                                            i = R.id.tv_serverdes;
                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView8 != null) {
                                                                                                                i = R.id.tv_servername;
                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView9 != null) {
                                                                                                                    i = R.id.tv_serverphone;
                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView10 != null) {
                                                                                                                        i = R.id.tv_serverphonetext;
                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView11 != null) {
                                                                                                                            i = R.id.tv_servertime;
                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView12 != null) {
                                                                                                                                i = R.id.tv_servertimetext;
                                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView13 != null) {
                                                                                                                                    i = R.id.tv_yuan;
                                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView14 != null) {
                                                                                                                                        i = R.id.tv_zktstate;
                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView15 != null) {
                                                                                                                                            return new FragmentV3ServerBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, pullRefreshLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15);
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
