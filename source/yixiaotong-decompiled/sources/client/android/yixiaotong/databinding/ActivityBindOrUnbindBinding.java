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
public final class ActivityBindOrUnbindBinding implements ViewBinding {
    public final TextView bindDormAddress;
    public final TextView egBindDormAddress;
    public final TextView egOnclickBind;
    public final TextView egText;
    public final ImageView img1;
    public final ImageView img2;
    public final ImageView img3;
    public final TextView onclickBind;
    public final TextView pbBindDormAddress;
    public final TextView pbOnclickBind;
    public final TextView pbText;
    public final RelativeLayout relPbBindOrUnbind;
    private final LinearLayout rootView;
    public final TextView text;
    public final TitleBar titleBar;
    public final RelativeLayout tvBindOrUnbind;
    public final RelativeLayout tvEgBindOrUnbind;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityBindOrUnbindBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView5, TextView textView6, TextView textView7, TextView textView8, RelativeLayout relativeLayout, TextView textView9, TitleBar titleBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3) {
        this.rootView = linearLayout;
        this.bindDormAddress = textView;
        this.egBindDormAddress = textView2;
        this.egOnclickBind = textView3;
        this.egText = textView4;
        this.img1 = imageView;
        this.img2 = imageView2;
        this.img3 = imageView3;
        this.onclickBind = textView5;
        this.pbBindDormAddress = textView6;
        this.pbOnclickBind = textView7;
        this.pbText = textView8;
        this.relPbBindOrUnbind = relativeLayout;
        this.text = textView9;
        this.titleBar = titleBar;
        this.tvBindOrUnbind = relativeLayout2;
        this.tvEgBindOrUnbind = relativeLayout3;
    }

    public static ActivityBindOrUnbindBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBindOrUnbindBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_bind_or_unbind, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBindOrUnbindBinding bind(View view) {
        int i = R.id.bind_dorm_address;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.eg_bind_dorm_address;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.eg_onclick_bind;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.eg_text;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.img1;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.img2;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.img3;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.onclick_bind;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.pb_bind_dorm_address;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R.id.pb_onclick_bind;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                i = R.id.pb_text;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView8 != null) {
                                                    i = R.id.rel_pb_bind_or_unbind;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout != null) {
                                                        i = R.id.text;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView9 != null) {
                                                            i = R.id.titleBar;
                                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                            if (titleBar != null) {
                                                                i = R.id.tv_bind_or_unbind;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout2 != null) {
                                                                    i = R.id.tv_eg_bind_or_unbind;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (relativeLayout3 != null) {
                                                                        return new ActivityBindOrUnbindBinding((LinearLayout) view, textView, textView2, textView3, textView4, imageView, imageView2, imageView3, textView5, textView6, textView7, textView8, relativeLayout, textView9, titleBar, relativeLayout2, relativeLayout3);
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
