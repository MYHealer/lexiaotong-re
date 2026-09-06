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
public final class ActivityOrderCenterBinding implements ViewBinding {
    public final ImageView ivDeposit;
    public final ImageView ivRefunddd;
    public final ImageView ivWddd;
    public final ImageView ivWdqb;
    public final RelativeLayout relClubcardorder;
    public final RelativeLayout relDepositrechargerefundorder;
    public final RelativeLayout relDeviceorder;
    public final RelativeLayout relNone;
    public final RelativeLayout relRechargerefundorder;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvDeposittext;
    public final TextView tvRefundddtext;
    public final TextView tvWdddtext;
    public final TextView tvWdqbtext;
    public final View view1;
    public final View view2;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityOrderCenterBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view, View view2) {
        this.rootView = linearLayout;
        this.ivDeposit = imageView;
        this.ivRefunddd = imageView2;
        this.ivWddd = imageView3;
        this.ivWdqb = imageView4;
        this.relClubcardorder = relativeLayout;
        this.relDepositrechargerefundorder = relativeLayout2;
        this.relDeviceorder = relativeLayout3;
        this.relNone = relativeLayout4;
        this.relRechargerefundorder = relativeLayout5;
        this.titleBar = titleBar;
        this.tvDeposittext = textView;
        this.tvRefundddtext = textView2;
        this.tvWdddtext = textView3;
        this.tvWdqbtext = textView4;
        this.view1 = view;
        this.view2 = view2;
    }

    public static ActivityOrderCenterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityOrderCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_order_center, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityOrderCenterBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.iv_deposit;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_refunddd;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_wddd;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.iv_wdqb;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.rel_clubcardorder;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = R.id.rel_depositrechargerefundorder;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout2 != null) {
                                i = R.id.rel_deviceorder;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout3 != null) {
                                    i = R.id.rel_none;
                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout4 != null) {
                                        i = R.id.rel_rechargerefundorder;
                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout5 != null) {
                                            i = R.id.titleBar;
                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                            if (titleBar != null) {
                                                i = R.id.tv_deposittext;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = R.id.tv_refundddtext;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R.id.tv_wdddtext;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_wdqbtext;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view2))) != null) {
                                                                return new ActivityOrderCenterBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, titleBar, textView, textView2, textView3, textView4, viewFindChildViewById, viewFindChildViewById2);
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
