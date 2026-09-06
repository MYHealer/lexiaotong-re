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
public final class ActivityRefundProgressBinding implements ViewBinding {
    public final ImageView img;
    public final ImageView img2;
    public final RelativeLayout rel;
    private final LinearLayout rootView;
    public final TextView tvBalance;
    public final TextView tvBalancetext;
    public final TextView tvContent;
    public final TextView tvContent2;
    public final TextView tvDate;
    public final TextView tvDate2;
    public final TextView tvDate3;
    public final TextView tvText1;
    public final TextView tvText2;
    public final TextView tvText3;
    public final TextView tvTime;
    public final TextView tvTime2;
    public final TextView tvTime3;
    public final TitleBar vTitleBar;
    public final View view1;
    public final View view2;
    public final ImageView view3;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityRefundProgressBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TitleBar titleBar, View view, View view2, ImageView imageView3) {
        this.rootView = linearLayout;
        this.img = imageView;
        this.img2 = imageView2;
        this.rel = relativeLayout;
        this.tvBalance = textView;
        this.tvBalancetext = textView2;
        this.tvContent = textView3;
        this.tvContent2 = textView4;
        this.tvDate = textView5;
        this.tvDate2 = textView6;
        this.tvDate3 = textView7;
        this.tvText1 = textView8;
        this.tvText2 = textView9;
        this.tvText3 = textView10;
        this.tvTime = textView11;
        this.tvTime2 = textView12;
        this.tvTime3 = textView13;
        this.vTitleBar = titleBar;
        this.view1 = view;
        this.view2 = view2;
        this.view3 = imageView3;
    }

    public static ActivityRefundProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRefundProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_refund_progress, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRefundProgressBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.rel;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.tv_balance;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tv_balancetext;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_content;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.tv_content2;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.tv_date;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.tv_date2;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R.id.tv_date3;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                i = R.id.tv_text1;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView8 != null) {
                                                    i = R.id.tv_text2;
                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView9 != null) {
                                                        i = R.id.tv_text3;
                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView10 != null) {
                                                            i = R.id.tv_time;
                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView11 != null) {
                                                                i = R.id.tv_time2;
                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView12 != null) {
                                                                    i = R.id.tv_time3;
                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView13 != null) {
                                                                        i = R.id.v_titleBar;
                                                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                        if (titleBar != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view2))) != null) {
                                                                            i = R.id.view3;
                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView3 != null) {
                                                                                return new ActivityRefundProgressBinding((LinearLayout) view, imageView, imageView2, relativeLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, titleBar, viewFindChildViewById, viewFindChildViewById2, imageView3);
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
