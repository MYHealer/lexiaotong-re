package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class FragmentV3ServerDemoBinding implements ViewBinding {
    public final ImageView imgServerphone;
    public final ImageView imgServertime;
    public final ImageView ivMmicon;
    public final ImageView ivNext1;
    public final ImageView ivNext2;
    public final ImageView ivNext3;
    public final ImageView ivNext4;
    public final ImageView ivNextzkt;
    public final ImageView ivServerimg;
    public final ImageView ivSpicon;
    public final ImageView ivYeicon;
    public final ImageView ivYjicon;
    public final ImageView ivZkticon;
    public final RelativeLayout relBalance;
    public final RelativeLayout relDeposit;
    public final RelativeLayout relNopsw;
    public final RelativeLayout relServerinfo;
    public final RelativeLayout relWaterbalance;
    public final RelativeLayout relZhikatong;
    private final RelativeLayout rootView;
    public final TextView tvBalance;
    public final TextView tvProvidertext;
    public final TextView tvServer;
    public final TextView tvServerdes;
    public final TextView tvServername;
    public final TextView tvServerphone;
    public final TextView tvServerphonetext;
    public final TextView tvServertime;
    public final TextView tvServertimetext;
    public final TextView tvWaterbalance;
    public final TextView tvZktstate;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private FragmentV3ServerDemoBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = relativeLayout;
        this.imgServerphone = imageView;
        this.imgServertime = imageView2;
        this.ivMmicon = imageView3;
        this.ivNext1 = imageView4;
        this.ivNext2 = imageView5;
        this.ivNext3 = imageView6;
        this.ivNext4 = imageView7;
        this.ivNextzkt = imageView8;
        this.ivServerimg = imageView9;
        this.ivSpicon = imageView10;
        this.ivYeicon = imageView11;
        this.ivYjicon = imageView12;
        this.ivZkticon = imageView13;
        this.relBalance = relativeLayout2;
        this.relDeposit = relativeLayout3;
        this.relNopsw = relativeLayout4;
        this.relServerinfo = relativeLayout5;
        this.relWaterbalance = relativeLayout6;
        this.relZhikatong = relativeLayout7;
        this.tvBalance = textView;
        this.tvProvidertext = textView2;
        this.tvServer = textView3;
        this.tvServerdes = textView4;
        this.tvServername = textView5;
        this.tvServerphone = textView6;
        this.tvServerphonetext = textView7;
        this.tvServertime = textView8;
        this.tvServertimetext = textView9;
        this.tvWaterbalance = textView10;
        this.tvZktstate = textView11;
    }

    public static FragmentV3ServerDemoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentV3ServerDemoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v3_server_demo, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentV3ServerDemoBinding bind(View view) {
        int i = R.id.img_serverphone;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img_servertime;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_mmicon;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.iv_next1;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.iv_next2;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView5 != null) {
                            i = R.id.iv_next3;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView6 != null) {
                                i = R.id.iv_next4;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView7 != null) {
                                    i = R.id.iv_nextzkt;
                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView8 != null) {
                                        i = R.id.iv_serverimg;
                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView9 != null) {
                                            i = R.id.iv_spicon;
                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView10 != null) {
                                                i = R.id.iv_yeicon;
                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView11 != null) {
                                                    i = R.id.iv_yjicon;
                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView12 != null) {
                                                        i = R.id.iv_zkticon;
                                                        ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView13 != null) {
                                                            i = R.id.rel_balance;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout != null) {
                                                                i = R.id.rel_deposit;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout2 != null) {
                                                                    i = R.id.rel_nopsw;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (relativeLayout3 != null) {
                                                                        i = R.id.rel_serverinfo;
                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (relativeLayout4 != null) {
                                                                            i = R.id.rel_waterbalance;
                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (relativeLayout5 != null) {
                                                                                i = R.id.rel_zhikatong;
                                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (relativeLayout6 != null) {
                                                                                    i = R.id.tv_balance;
                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView != null) {
                                                                                        i = R.id.tv_providertext;
                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView2 != null) {
                                                                                            i = R.id.tv_server;
                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView3 != null) {
                                                                                                i = R.id.tv_serverdes;
                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView4 != null) {
                                                                                                    i = R.id.tv_servername;
                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView5 != null) {
                                                                                                        i = R.id.tv_serverphone;
                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView6 != null) {
                                                                                                            i = R.id.tv_serverphonetext;
                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView7 != null) {
                                                                                                                i = R.id.tv_servertime;
                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView8 != null) {
                                                                                                                    i = R.id.tv_servertimetext;
                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView9 != null) {
                                                                                                                        i = R.id.tv_waterbalance;
                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView10 != null) {
                                                                                                                            i = R.id.tv_zktstate;
                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView11 != null) {
                                                                                                                                return new FragmentV3ServerDemoBinding((RelativeLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
