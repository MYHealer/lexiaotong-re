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
public final class ActivityCardWalletBinding implements ViewBinding {
    public final ImageView ivHelp;
    public final LinearLayout linSaoma;
    public final LinearLayout linSelectSaoma;
    public final LinearLayout linSelectSoundwave;
    public final LinearLayout linSoundwave;
    public final ImageView playSoundwave;
    public final ImageView qrcode;
    public final RelativeLayout rootLayout1;
    private final LinearLayout rootView;
    public final TextView tvPlaytip;
    public final TextView tvQrcodetip;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityCardWalletBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout, TextView textView, TextView textView2, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.ivHelp = imageView;
        this.linSaoma = linearLayout2;
        this.linSelectSaoma = linearLayout3;
        this.linSelectSoundwave = linearLayout4;
        this.linSoundwave = linearLayout5;
        this.playSoundwave = imageView2;
        this.qrcode = imageView3;
        this.rootLayout1 = relativeLayout;
        this.tvPlaytip = textView;
        this.tvQrcodetip = textView2;
        this.vTitleBar = titleBar;
    }

    public static ActivityCardWalletBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityCardWalletBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_card_wallet, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCardWalletBinding bind(View view) {
        int i = R.id.iv_help;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.lin_saoma;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.lin_select_saoma;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.lin_select_soundwave;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout3 != null) {
                        i = R.id.lin_soundwave;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout4 != null) {
                            i = R.id.play_soundwave;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.qrcode;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.root_layout1;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout != null) {
                                        i = R.id.tv_playtip;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.tv_qrcodetip;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.v_titleBar;
                                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                if (titleBar != null) {
                                                    return new ActivityCardWalletBinding((LinearLayout) view, imageView, linearLayout, linearLayout2, linearLayout3, linearLayout4, imageView2, imageView3, relativeLayout, textView, textView2, titleBar);
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
