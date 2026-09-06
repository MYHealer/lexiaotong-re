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
public final class ActivitySelectAmmeterAddressBinding implements ViewBinding {
    public final ImageView img1;
    public final ImageView img2;
    public final ImageView img3;
    public final ImageView img4;
    public final RelativeLayout relFanghao;
    public final RelativeLayout relLoucheng;
    public final RelativeLayout relLoudong;
    public final RelativeLayout relQuyu;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvAddress1;
    public final TextView tvAddress2;
    public final TextView tvAddress3;
    public final TextView tvAddress4;
    public final Button vBtnNext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivitySelectAmmeterAddressBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, Button button) {
        this.rootView = linearLayout;
        this.img1 = imageView;
        this.img2 = imageView2;
        this.img3 = imageView3;
        this.img4 = imageView4;
        this.relFanghao = relativeLayout;
        this.relLoucheng = relativeLayout2;
        this.relLoudong = relativeLayout3;
        this.relQuyu = relativeLayout4;
        this.titleBar = titleBar;
        this.tvAddress1 = textView;
        this.tvAddress2 = textView2;
        this.tvAddress3 = textView3;
        this.tvAddress4 = textView4;
        this.vBtnNext = button;
    }

    public static ActivitySelectAmmeterAddressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySelectAmmeterAddressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_select_ammeter_address, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySelectAmmeterAddressBinding bind(View view) {
        int i = R.id.img1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.img3;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.img4;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.rel_fanghao;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = R.id.rel_loucheng;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout2 != null) {
                                i = R.id.rel_loudong;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout3 != null) {
                                    i = R.id.rel_quyu;
                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout4 != null) {
                                        i = R.id.titleBar;
                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                        if (titleBar != null) {
                                            i = R.id.tv_address1;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = R.id.tv_address2;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.tv_address3;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.tv_address4;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.v_btn_next;
                                                            Button button = (Button) ViewBindings.findChildViewById(view, i);
                                                            if (button != null) {
                                                                return new ActivitySelectAmmeterAddressBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, titleBar, textView, textView2, textView3, textView4, button);
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
