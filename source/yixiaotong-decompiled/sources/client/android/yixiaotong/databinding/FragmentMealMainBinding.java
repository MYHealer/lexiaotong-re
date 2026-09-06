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
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class FragmentMealMainBinding implements ViewBinding {
    public final Button btnRefresh;
    public final TextView id1;
    public final TextView id2;
    public final ImageView img;
    public final ImageView imgSex;
    public final SimpleDraweeView ivMeIcon;
    public final LinearLayout lin;
    public final LinearLayout llMeInfo;
    public final ImageView qrcode;
    public final RelativeLayout rel2;
    public final RelativeLayout relMoney;
    private final RelativeLayout rootView;
    public final TitleBar tbName;
    public final TextView text;
    public final TextView tvBalance;
    public final TextView tvChakanrecord;
    public final TextView tvMeId;
    public final TextView tvMeName;
    public final TextView tvMeXuehao;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private FragmentMealMainBinding(RelativeLayout relativeLayout, Button button, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, SimpleDraweeView simpleDraweeView, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView3, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TitleBar titleBar, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = relativeLayout;
        this.btnRefresh = button;
        this.id1 = textView;
        this.id2 = textView2;
        this.img = imageView;
        this.imgSex = imageView2;
        this.ivMeIcon = simpleDraweeView;
        this.lin = linearLayout;
        this.llMeInfo = linearLayout2;
        this.qrcode = imageView3;
        this.rel2 = relativeLayout2;
        this.relMoney = relativeLayout3;
        this.tbName = titleBar;
        this.text = textView3;
        this.tvBalance = textView4;
        this.tvChakanrecord = textView5;
        this.tvMeId = textView6;
        this.tvMeName = textView7;
        this.tvMeXuehao = textView8;
    }

    public static FragmentMealMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMealMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_meal_main, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentMealMainBinding bind(View view) {
        int i = R.id.btn_refresh;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.id1;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.id2;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.img;
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
                                        i = R.id.qrcode;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.rel2;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout != null) {
                                                i = R.id.rel_money;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.tb_name;
                                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                    if (titleBar != null) {
                                                        i = R.id.text;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_balance;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_chakanrecord;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_me_id;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        i = R.id.tv_me_name;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.tv_me_xuehao;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView8 != null) {
                                                                                return new FragmentMealMainBinding((RelativeLayout) view, button, textView, textView2, imageView, imageView2, simpleDraweeView, linearLayout, linearLayout2, imageView3, relativeLayout, relativeLayout2, titleBar, textView3, textView4, textView5, textView6, textView7, textView8);
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
