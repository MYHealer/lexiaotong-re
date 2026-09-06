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
public final class ActivityCardDetailBinding implements ViewBinding {
    public final Button btnActivacard;
    public final Button btnMeknow;
    public final Button btnRefundcard;
    public final ImageView iv0;
    public final ImageView iv1;
    public final ImageView iv2;
    public final ImageView iv3;
    public final ImageView iv4;
    public final ImageView ivIcon;
    public final RelativeLayout relCardbg;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvDay;
    public final TextView tvDiscount;
    public final TextView tvDiscounttext;
    public final TextView tvName;
    public final TextView tvNoactivate;
    public final TextView tvRule;
    public final TextView tvServername;
    public final TextView tvTian;
    public final TextView tvTian2;
    public final TextView tvTimetext;
    public final TextView tvUseserver;
    public final TextView tvUseservertext;
    public final TextView tvUsesruletext;
    public final TextView tvUsetime;
    public final TextView tvUsetype;
    public final TextView tvUsetypetext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityCardDetailBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, RelativeLayout relativeLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16) {
        this.rootView = linearLayout;
        this.btnActivacard = button;
        this.btnMeknow = button2;
        this.btnRefundcard = button3;
        this.iv0 = imageView;
        this.iv1 = imageView2;
        this.iv2 = imageView3;
        this.iv3 = imageView4;
        this.iv4 = imageView5;
        this.ivIcon = imageView6;
        this.relCardbg = relativeLayout;
        this.titleBar = titleBar;
        this.tvDay = textView;
        this.tvDiscount = textView2;
        this.tvDiscounttext = textView3;
        this.tvName = textView4;
        this.tvNoactivate = textView5;
        this.tvRule = textView6;
        this.tvServername = textView7;
        this.tvTian = textView8;
        this.tvTian2 = textView9;
        this.tvTimetext = textView10;
        this.tvUseserver = textView11;
        this.tvUseservertext = textView12;
        this.tvUsesruletext = textView13;
        this.tvUsetime = textView14;
        this.tvUsetype = textView15;
        this.tvUsetypetext = textView16;
    }

    public static ActivityCardDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityCardDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_card_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCardDetailBinding bind(View view) {
        int i = R.id.btn_activacard;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_meknow;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.btn_refundcard;
                Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                if (button3 != null) {
                    i = R.id.iv0;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.iv1;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.iv2;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.iv3;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView4 != null) {
                                    i = R.id.iv4;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView5 != null) {
                                        i = R.id.iv_icon;
                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView6 != null) {
                                            i = R.id.rel_cardbg;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout != null) {
                                                i = R.id.titleBar;
                                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                if (titleBar != null) {
                                                    i = R.id.tv_day;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView != null) {
                                                        i = R.id.tv_discount;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView2 != null) {
                                                            i = R.id.tv_discounttext;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView3 != null) {
                                                                i = R.id.tv_name;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView4 != null) {
                                                                    i = R.id.tv_noactivate;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.tv_rule;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.tv_servername;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView7 != null) {
                                                                                i = R.id.tv_tian;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.tv_tian2;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.tv_timetext;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView10 != null) {
                                                                                            i = R.id.tv_useserver;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView11 != null) {
                                                                                                i = R.id.tv_useservertext;
                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView12 != null) {
                                                                                                    i = R.id.tv_usesruletext;
                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView13 != null) {
                                                                                                        i = R.id.tv_usetime;
                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView14 != null) {
                                                                                                            i = R.id.tv_usetype;
                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView15 != null) {
                                                                                                                i = R.id.tv_usetypetext;
                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView16 != null) {
                                                                                                                    return new ActivityCardDetailBinding((LinearLayout) view, button, button2, button3, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, relativeLayout, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16);
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
