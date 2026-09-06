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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DialogIcbcPaywayBinding implements ViewBinding {
    public final Button btnTopay;
    public final ImageView imgBack;
    public final ImageView imgIcbc;
    public final ImageView imgIcbcweixin;
    public final ImageView imgIcbczfb;
    public final ImageView imgSelecte;
    public final ImageView imgSelectwx;
    public final ImageView imgSelectzfb;
    public final ImageView imgUnpay;
    public final RelativeLayout relIcbce;
    public final RelativeLayout relIcbcweixin;
    public final RelativeLayout relIcbczfb;
    private final LinearLayout rootView;
    public final TextView tvMoney;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private DialogIcbcPaywayBinding(LinearLayout linearLayout, Button button, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView) {
        this.rootView = linearLayout;
        this.btnTopay = button;
        this.imgBack = imageView;
        this.imgIcbc = imageView2;
        this.imgIcbcweixin = imageView3;
        this.imgIcbczfb = imageView4;
        this.imgSelecte = imageView5;
        this.imgSelectwx = imageView6;
        this.imgSelectzfb = imageView7;
        this.imgUnpay = imageView8;
        this.relIcbce = relativeLayout;
        this.relIcbcweixin = relativeLayout2;
        this.relIcbczfb = relativeLayout3;
        this.tvMoney = textView;
    }

    public static DialogIcbcPaywayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogIcbcPaywayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_icbc_payway, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogIcbcPaywayBinding bind(View view) {
        int i = R.id.btn_topay;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.img_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.img_icbc;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.img_icbcweixin;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.img_icbczfb;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = R.id.img_selecte;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView5 != null) {
                                i = R.id.img_selectwx;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView6 != null) {
                                    i = R.id.img_selectzfb;
                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView7 != null) {
                                        i = R.id.img_unpay;
                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView8 != null) {
                                            i = R.id.rel_icbce;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout != null) {
                                                i = R.id.rel_icbcweixin;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.rel_icbczfb;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout3 != null) {
                                                        i = R.id.tv_money;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView != null) {
                                                            return new DialogIcbcPaywayBinding((LinearLayout) view, button, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, relativeLayout, relativeLayout2, relativeLayout3, textView);
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
