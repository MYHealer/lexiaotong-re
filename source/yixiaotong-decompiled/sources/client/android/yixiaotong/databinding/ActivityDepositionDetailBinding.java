package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapListView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDepositionDetailBinding implements ViewBinding {
    public final Button btnPay;
    public final Button btnRecord;
    public final ImageView imgXjhb;
    public final LinearLayout linPayway;
    public final WrapListView listview;
    public final RelativeLayout relEndsuccess;
    private final RelativeLayout rootView;
    public final TextView textpayway;
    public final TitleBar titleBar;
    public final TextView tvCashredpacket;
    public final TextView tvMoney;
    public final TextView tvText1;
    public final TextView tvTip;
    public final TextView tvUnit;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityDepositionDetailBinding(RelativeLayout relativeLayout, Button button, Button button2, ImageView imageView, LinearLayout linearLayout, WrapListView wrapListView, RelativeLayout relativeLayout2, TextView textView, TitleBar titleBar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = relativeLayout;
        this.btnPay = button;
        this.btnRecord = button2;
        this.imgXjhb = imageView;
        this.linPayway = linearLayout;
        this.listview = wrapListView;
        this.relEndsuccess = relativeLayout2;
        this.textpayway = textView;
        this.titleBar = titleBar;
        this.tvCashredpacket = textView2;
        this.tvMoney = textView3;
        this.tvText1 = textView4;
        this.tvTip = textView5;
        this.tvUnit = textView6;
    }

    public static ActivityDepositionDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDepositionDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_deposition_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDepositionDetailBinding bind(View view) {
        int i = R.id.btn_pay;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_record;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.img_xjhb;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.lin_payway;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.listview;
                        WrapListView wrapListView = (WrapListView) ViewBindings.findChildViewById(view, i);
                        if (wrapListView != null) {
                            i = R.id.rel_endsuccess;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout != null) {
                                i = R.id.textpayway;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.titleBar;
                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                    if (titleBar != null) {
                                        i = R.id.tv_cashredpacket;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.tv_money;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.tv_text1;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R.id.tv_tip;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.tv_unit;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            return new ActivityDepositionDetailBinding((RelativeLayout) view, button, button2, imageView, linearLayout, wrapListView, relativeLayout, textView, titleBar, textView2, textView3, textView4, textView5, textView6);
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
