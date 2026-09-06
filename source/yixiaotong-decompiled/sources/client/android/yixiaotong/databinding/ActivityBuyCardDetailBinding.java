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
public final class ActivityBuyCardDetailBinding implements ViewBinding {
    public final Button btnBuycard;
    public final Button btnCancel;
    public final Button btnMeknow;
    public final ImageView iv0;
    public final ImageView iv1;
    public final ImageView iv2;
    public final ImageView iv3;
    public final ImageView iv4;
    public final ImageView ivIcon;
    public final LinearLayout linPayway;
    public final WrapListView listview;
    public final RelativeLayout relBg;
    private final LinearLayout rootView;
    public final TextView textpayway;
    public final TitleBar titleBar;
    public final TextView tvDay;
    public final TextView tvDiscount;
    public final TextView tvDiscounttext;
    public final TextView tvMoney;
    public final TextView tvName;
    public final TextView tvNoactivate;
    public final TextView tvRule;
    public final TextView tvServername;
    public final TextView tvTian;
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

    private ActivityBuyCardDetailBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout2, WrapListView wrapListView, RelativeLayout relativeLayout, TextView textView, TitleBar titleBar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17) {
        this.rootView = linearLayout;
        this.btnBuycard = button;
        this.btnCancel = button2;
        this.btnMeknow = button3;
        this.iv0 = imageView;
        this.iv1 = imageView2;
        this.iv2 = imageView3;
        this.iv3 = imageView4;
        this.iv4 = imageView5;
        this.ivIcon = imageView6;
        this.linPayway = linearLayout2;
        this.listview = wrapListView;
        this.relBg = relativeLayout;
        this.textpayway = textView;
        this.titleBar = titleBar;
        this.tvDay = textView2;
        this.tvDiscount = textView3;
        this.tvDiscounttext = textView4;
        this.tvMoney = textView5;
        this.tvName = textView6;
        this.tvNoactivate = textView7;
        this.tvRule = textView8;
        this.tvServername = textView9;
        this.tvTian = textView10;
        this.tvTimetext = textView11;
        this.tvUseserver = textView12;
        this.tvUseservertext = textView13;
        this.tvUsesruletext = textView14;
        this.tvUsetime = textView15;
        this.tvUsetype = textView16;
        this.tvUsetypetext = textView17;
    }

    public static ActivityBuyCardDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBuyCardDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_buy_card_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBuyCardDetailBinding bind(View view) {
        int i = R.id.btn_buycard;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_cancel;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.btn_meknow;
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
                                            i = R.id.lin_payway;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout != null) {
                                                i = R.id.listview;
                                                WrapListView wrapListView = (WrapListView) ViewBindings.findChildViewById(view, i);
                                                if (wrapListView != null) {
                                                    i = R.id.rel_bg;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout != null) {
                                                        i = R.id.textpayway;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView != null) {
                                                            i = R.id.titleBar;
                                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                            if (titleBar != null) {
                                                                i = R.id.tv_day;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView2 != null) {
                                                                    i = R.id.tv_discount;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView3 != null) {
                                                                        i = R.id.tv_discounttext;
                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView4 != null) {
                                                                            i = R.id.tv_money;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView5 != null) {
                                                                                i = R.id.tv_name;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.tv_noactivate;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.tv_rule;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.tv_servername;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.tv_tian;
                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView10 != null) {
                                                                                                    i = R.id.tv_timetext;
                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView11 != null) {
                                                                                                        i = R.id.tv_useserver;
                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView12 != null) {
                                                                                                            i = R.id.tv_useservertext;
                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView13 != null) {
                                                                                                                i = R.id.tv_usesruletext;
                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView14 != null) {
                                                                                                                    i = R.id.tv_usetime;
                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView15 != null) {
                                                                                                                        i = R.id.tv_usetype;
                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView16 != null) {
                                                                                                                            i = R.id.tv_usetypetext;
                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView17 != null) {
                                                                                                                                return new ActivityBuyCardDetailBinding((LinearLayout) view, button, button2, button3, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, linearLayout, wrapListView, relativeLayout, textView, titleBar, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
