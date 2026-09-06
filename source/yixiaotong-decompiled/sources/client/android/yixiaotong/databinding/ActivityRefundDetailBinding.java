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
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityRefundDetailBinding implements ViewBinding {
    public final ImageView img1;
    public final ImageView img2;
    public final ImageView img3;
    public final ImageView imgFail;
    public final View line;
    public final RelativeLayout relFail;
    private final LinearLayout rootView;
    public final TextView text1;
    public final TextView text2;
    public final TextView text3;
    public final TitleBar titlebar;
    public final TextView tvAccount;
    public final TextView tvContent;
    public final TextView tvContent2;
    public final TextView tvDate;
    public final TextView tvDate2;
    public final TextView tvDate3;
    public final TextView tvFailtime;
    public final TextView tvGetmoneytime;
    public final TextView tvMoney;
    public final TextView tvRefundtime;
    public final TextView tvRenson;
    public final TextView tvStatus;
    public final TextView tvTime;
    public final TextView tvTime2;
    public final TextView tvTime3;
    public final View view1;
    public final View view2;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityRefundDetailBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TitleBar titleBar, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, View view2, View view3) {
        this.rootView = linearLayout;
        this.img1 = imageView;
        this.img2 = imageView2;
        this.img3 = imageView3;
        this.imgFail = imageView4;
        this.line = view;
        this.relFail = relativeLayout;
        this.text1 = textView;
        this.text2 = textView2;
        this.text3 = textView3;
        this.titlebar = titleBar;
        this.tvAccount = textView4;
        this.tvContent = textView5;
        this.tvContent2 = textView6;
        this.tvDate = textView7;
        this.tvDate2 = textView8;
        this.tvDate3 = textView9;
        this.tvFailtime = textView10;
        this.tvGetmoneytime = textView11;
        this.tvMoney = textView12;
        this.tvRefundtime = textView13;
        this.tvRenson = textView14;
        this.tvStatus = textView15;
        this.tvTime = textView16;
        this.tvTime2 = textView17;
        this.tvTime3 = textView18;
        this.view1 = view2;
        this.view2 = view3;
    }

    public static ActivityRefundDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRefundDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_refund_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRefundDetailBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        int i = R.id.img1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.img3;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.img_fail;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line))) != null) {
                        i = R.id.rel_fail;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = R.id.text1;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.text2;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.text3;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.titlebar;
                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                        if (titleBar != null) {
                                            i = R.id.tv_account;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.tv_content;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.tv_content2;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.tv_date;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            i = R.id.tv_date2;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView8 != null) {
                                                                i = R.id.tv_date3;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView9 != null) {
                                                                    i = R.id.tv_failtime;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView10 != null) {
                                                                        i = R.id.tv_getmoneytime;
                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView11 != null) {
                                                                            i = R.id.tv_money;
                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView12 != null) {
                                                                                i = R.id.tv_refundtime;
                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView13 != null) {
                                                                                    i = R.id.tv_renson;
                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView14 != null) {
                                                                                        i = R.id.tv_status;
                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView15 != null) {
                                                                                            i = R.id.tv_time;
                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView16 != null) {
                                                                                                i = R.id.tv_time2;
                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView17 != null) {
                                                                                                    i = R.id.tv_time3;
                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView18 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view1))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.view2))) != null) {
                                                                                                        return new ActivityRefundDetailBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4, viewFindChildViewById, relativeLayout, textView, textView2, textView3, titleBar, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, viewFindChildViewById2, viewFindChildViewById3);
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
