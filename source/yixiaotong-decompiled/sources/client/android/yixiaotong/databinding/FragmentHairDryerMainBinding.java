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
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class FragmentHairDryerMainBinding implements ViewBinding {
    public final ImageView img;
    public final ImageView imgSex;
    public final SimpleDraweeView ivMeIcon;
    public final LinearLayout lin;
    public final LinearLayout llMeInfo;
    public final ImageView qidong;
    public final RelativeLayout rel1;
    public final RelativeLayout relMoney;
    private final RelativeLayout rootView;
    public final TitleBar tbName;
    public final TextView text;
    public final TextView tvBalance;
    public final TextView tvCaptureMoney;
    public final TextView tvChakanrecord;
    public final TextView tvMeId;
    public final TextView tvMeName;
    public final TextView tvMeXuehao;
    public final TextView tvQiehuandevice;
    public final TextView tvText;
    public final TextView tvText1;
    public final TextView tvText2;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private FragmentHairDryerMainBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, SimpleDraweeView simpleDraweeView, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView3, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = relativeLayout;
        this.img = imageView;
        this.imgSex = imageView2;
        this.ivMeIcon = simpleDraweeView;
        this.lin = linearLayout;
        this.llMeInfo = linearLayout2;
        this.qidong = imageView3;
        this.rel1 = relativeLayout2;
        this.relMoney = relativeLayout3;
        this.tbName = titleBar;
        this.text = textView;
        this.tvBalance = textView2;
        this.tvCaptureMoney = textView3;
        this.tvChakanrecord = textView4;
        this.tvMeId = textView5;
        this.tvMeName = textView6;
        this.tvMeXuehao = textView7;
        this.tvQiehuandevice = textView8;
        this.tvText = textView9;
        this.tvText1 = textView10;
        this.tvText2 = textView11;
    }

    public static FragmentHairDryerMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHairDryerMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_hair_dryer_main, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHairDryerMainBinding bind(View view) {
        int i = R.id.img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img_sex;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_me_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i);
                if (simpleDraweeView != null) {
                    i = R.id.lin;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.ll_me_info;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R.id.qidong;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.rel1;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout != null) {
                                    i = R.id.rel_money;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout2 != null) {
                                        i = R.id.tb_name;
                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                        if (titleBar != null) {
                                            i = R.id.text;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = R.id.tv_balance;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.tv_capture_money;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.tv_chakanrecord;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.tv_me_id;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R.id.tv_me_name;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView6 != null) {
                                                                    i = R.id.tv_me_xuehao;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView7 != null) {
                                                                        i = R.id.tv_qiehuandevice;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView8 != null) {
                                                                            i = R.id.tv_text;
                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView9 != null) {
                                                                                i = R.id.tv_text1;
                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView10 != null) {
                                                                                    i = R.id.tv_text2;
                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView11 != null) {
                                                                                        return new FragmentHairDryerMainBinding((RelativeLayout) view, imageView, imageView2, simpleDraweeView, linearLayout, linearLayout2, imageView3, relativeLayout, relativeLayout2, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
