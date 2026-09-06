package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.v3.ui.weight.SlideToUnlockView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DialogBathFirstTipBinding implements ViewBinding {
    public final ImageView ivClose;
    public final View line;
    private final RelativeLayout rootView;
    public final SlideToUnlockView slideToUnlockView;
    public final TextView tvAddress;
    public final TextView tvAddresstext;
    public final Button tvCanle;
    public final TextView tvContent1;
    public final TextView tvMac;
    public final TextView tvMactext;
    public final Button tvPositive;
    public final TextView tvTitle;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private DialogBathFirstTipBinding(RelativeLayout relativeLayout, ImageView imageView, View view, SlideToUnlockView slideToUnlockView, TextView textView, TextView textView2, Button button, TextView textView3, TextView textView4, TextView textView5, Button button2, TextView textView6) {
        this.rootView = relativeLayout;
        this.ivClose = imageView;
        this.line = view;
        this.slideToUnlockView = slideToUnlockView;
        this.tvAddress = textView;
        this.tvAddresstext = textView2;
        this.tvCanle = button;
        this.tvContent1 = textView3;
        this.tvMac = textView4;
        this.tvMactext = textView5;
        this.tvPositive = button2;
        this.tvTitle = textView6;
    }

    public static DialogBathFirstTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogBathFirstTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_bath_first_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogBathFirstTipBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.iv_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line))) != null) {
            i = R.id.slideToUnlockView;
            SlideToUnlockView slideToUnlockView = (SlideToUnlockView) ViewBindings.findChildViewById(view, i);
            if (slideToUnlockView != null) {
                i = R.id.tv_address;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_addresstext;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_canle;
                        Button button = (Button) ViewBindings.findChildViewById(view, i);
                        if (button != null) {
                            i = R.id.tv_content1;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.tv_mac;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.tv_mactext;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.tv_positive;
                                        Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                                        if (button2 != null) {
                                            i = R.id.tv_title;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                return new DialogBathFirstTipBinding((RelativeLayout) view, imageView, viewFindChildViewById, slideToUnlockView, textView, textView2, button, textView3, textView4, textView5, button2, textView6);
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
