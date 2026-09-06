package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DialogBindcardTipBinding implements ViewBinding {
    public final Button btnComfirt;
    public final ImageView iv1;
    public final ImageView iv2;
    public final ImageView iv3;
    public final ImageView ivTop;
    public final LinearLayout linTip;
    private final LinearLayout rootView;
    public final TextView tv11;
    public final TextView tv12;
    public final TextView tv13;
    public final TextView tv21;
    public final TextView tv22;
    public final TextView tv23;
    public final TextView tv31;
    public final TextView tv32;
    public final TextView tv33;
    public final TextView tvTitle;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private DialogBindcardTipBinding(LinearLayout linearLayout, Button button, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.rootView = linearLayout;
        this.btnComfirt = button;
        this.iv1 = imageView;
        this.iv2 = imageView2;
        this.iv3 = imageView3;
        this.ivTop = imageView4;
        this.linTip = linearLayout2;
        this.tv11 = textView;
        this.tv12 = textView2;
        this.tv13 = textView3;
        this.tv21 = textView4;
        this.tv22 = textView5;
        this.tv23 = textView6;
        this.tv31 = textView7;
        this.tv32 = textView8;
        this.tv33 = textView9;
        this.tvTitle = textView10;
    }

    public static DialogBindcardTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogBindcardTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_bindcard_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogBindcardTipBinding bind(View view) {
        int i = R.id.btn_comfirt;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.iv1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv2;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.iv3;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.iv_top;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = R.id.lin_tip;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.tv11;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tv12;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.tv13;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.tv21;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.tv22;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.tv23;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.tv31;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            i = R.id.tv32;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView8 != null) {
                                                                i = R.id.tv33;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView9 != null) {
                                                                    i = R.id.tv_title;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView10 != null) {
                                                                        return new DialogBindcardTipBinding((LinearLayout) view, button, imageView, imageView2, imageView3, imageView4, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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
