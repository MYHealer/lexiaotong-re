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
public final class FragmentHamamMainBinding implements ViewBinding {
    public final LinearLayout devicedetail;
    public final TextView id1;
    public final TextView id2;
    public final ImageView img;
    public final ImageView imgBindcard;
    public final ImageView imgDateil;
    public final ImageView imgSex;
    public final ImageView imgtip;
    public final SimpleDraweeView ivMeIcon;
    public final LinearLayout lin;
    public final LinearLayout llMeInfo;
    public final ImageView qidong;
    public final LinearLayout record;
    public final RelativeLayout relMoney;
    public final RelativeLayout relTip;
    public final LinearLayout resetPsw;
    private final RelativeLayout rootView;
    public final TitleBar tbName;
    public final TextView text;
    public final ImageView tip1;
    public final TextView tip2;
    public final TextView tip3;
    public final TextView tvBalance;
    public final TextView tvMeId;
    public final TextView tvMeName;
    public final TextView tvMeXuehao;
    public final TextView tvRoomAddress;
    public final LinearLayout unbind;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private FragmentHamamMainBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, SimpleDraweeView simpleDraweeView, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView6, LinearLayout linearLayout4, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, LinearLayout linearLayout5, TitleBar titleBar, TextView textView3, ImageView imageView7, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, LinearLayout linearLayout6) {
        this.rootView = relativeLayout;
        this.devicedetail = linearLayout;
        this.id1 = textView;
        this.id2 = textView2;
        this.img = imageView;
        this.imgBindcard = imageView2;
        this.imgDateil = imageView3;
        this.imgSex = imageView4;
        this.imgtip = imageView5;
        this.ivMeIcon = simpleDraweeView;
        this.lin = linearLayout2;
        this.llMeInfo = linearLayout3;
        this.qidong = imageView6;
        this.record = linearLayout4;
        this.relMoney = relativeLayout2;
        this.relTip = relativeLayout3;
        this.resetPsw = linearLayout5;
        this.tbName = titleBar;
        this.text = textView3;
        this.tip1 = imageView7;
        this.tip2 = textView4;
        this.tip3 = textView5;
        this.tvBalance = textView6;
        this.tvMeId = textView7;
        this.tvMeName = textView8;
        this.tvMeXuehao = textView9;
        this.tvRoomAddress = textView10;
        this.unbind = linearLayout6;
    }

    public static FragmentHamamMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHamamMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_hamam_main, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHamamMainBinding bind(View view) {
        int i = R.id.devicedetail;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.id1;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.id2;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.img;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.img_bindcard;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.img_dateil;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.img_sex;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView4 != null) {
                                    i = R.id.imgtip;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView5 != null) {
                                        i = R.id.iv_me_icon;
                                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i);
                                        if (simpleDraweeView != null) {
                                            i = R.id.lin;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout2 != null) {
                                                i = R.id.ll_me_info;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout3 != null) {
                                                    i = R.id.qidong;
                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView6 != null) {
                                                        i = R.id.record;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout4 != null) {
                                                            i = R.id.rel_money;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout != null) {
                                                                i = R.id.rel_tip;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout2 != null) {
                                                                    i = R.id.reset_psw;
                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout5 != null) {
                                                                        i = R.id.tb_name;
                                                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                        if (titleBar != null) {
                                                                            i = R.id.text;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView3 != null) {
                                                                                i = R.id.tip1;
                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView7 != null) {
                                                                                    i = R.id.tip2;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView4 != null) {
                                                                                        i = R.id.tip3;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView5 != null) {
                                                                                            i = R.id.tv_balance;
                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView6 != null) {
                                                                                                i = R.id.tv_me_id;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView7 != null) {
                                                                                                    i = R.id.tv_me_name;
                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView8 != null) {
                                                                                                        i = R.id.tv_me_xuehao;
                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView9 != null) {
                                                                                                            i = R.id.tv_room_address;
                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView10 != null) {
                                                                                                                i = R.id.unbind;
                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (linearLayout6 != null) {
                                                                                                                    return new FragmentHamamMainBinding((RelativeLayout) view, linearLayout, textView, textView2, imageView, imageView2, imageView3, imageView4, imageView5, simpleDraweeView, linearLayout2, linearLayout3, imageView6, linearLayout4, relativeLayout, relativeLayout2, linearLayout5, titleBar, textView3, imageView7, textView4, textView5, textView6, textView7, textView8, textView9, textView10, linearLayout6);
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
