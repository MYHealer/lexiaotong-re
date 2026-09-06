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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityNbdrinkSelectAddressBinding implements ViewBinding {
    public final ImageView img1;
    public final ImageView img2;
    public final RelativeLayout relLoudong;
    public final RelativeLayout relQuyu;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvAddress1;
    public final TextView tvAddress2;
    public final Button vBtnNext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityNbdrinkSelectAddressBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TitleBar titleBar, TextView textView, TextView textView2, Button button) {
        this.rootView = linearLayout;
        this.img1 = imageView;
        this.img2 = imageView2;
        this.relLoudong = relativeLayout;
        this.relQuyu = relativeLayout2;
        this.titleBar = titleBar;
        this.tvAddress1 = textView;
        this.tvAddress2 = textView2;
        this.vBtnNext = button;
    }

    public static ActivityNbdrinkSelectAddressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityNbdrinkSelectAddressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_nbdrink_select_address, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityNbdrinkSelectAddressBinding bind(View view) {
        int i = R.id.img1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.rel_loudong;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.rel_quyu;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = R.id.titleBar;
                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                        if (titleBar != null) {
                            i = R.id.tv_address1;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tv_address2;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.v_btn_next;
                                    Button button = (Button) ViewBindings.findChildViewById(view, i);
                                    if (button != null) {
                                        return new ActivityNbdrinkSelectAddressBinding((LinearLayout) view, imageView, imageView2, relativeLayout, relativeLayout2, titleBar, textView, textView2, button);
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
