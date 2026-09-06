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
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDoorLockMainBinding implements ViewBinding {
    public final Button btnDelectcard;
    public final ImageView imgDangertip;
    public final ImageView imgEye1;
    public final ImageView imgEye2;
    public final ImageView imgEye3;
    public final ImageView imgEye4;
    public final SimpleDraweeView ivMeIcon;
    public final LinearLayout linCard;
    public final LinearLayout linMain;
    public final LinearLayout linPress;
    public final LinearLayout linPsw;
    public final LinearLayout llMeInfo;
    public final WrapListView lvKey;
    public final WrapListView lvPresskey;
    public final RelativeLayout relAddcard;
    public final RelativeLayout relAddpresskey;
    public final RelativeLayout relAddpswkey;
    public final RelativeLayout relCard;
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvAddcard;
    public final TextView tvAddcardtime;
    public final TextView tvAddpresskey;
    public final TextView tvAddpswkey;
    public final TextView tvAddress;
    public final TextView tvAddtime;
    public final TextView tvCardopen;
    public final TextView tvCenter;
    public final TextView tvIdtext;
    public final TextView tvMeId;
    public final TextView tvMeName;
    public final TextView tvPressopen;
    public final TextView tvPswopen;
    public final TextView tvQrcodeopen;
    public final TextView tvRoomcard;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityDoorLockMainBinding(LinearLayout linearLayout, Button button, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, SimpleDraweeView simpleDraweeView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, WrapListView wrapListView, WrapListView wrapListView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        this.rootView = linearLayout;
        this.btnDelectcard = button;
        this.imgDangertip = imageView;
        this.imgEye1 = imageView2;
        this.imgEye2 = imageView3;
        this.imgEye3 = imageView4;
        this.imgEye4 = imageView5;
        this.ivMeIcon = simpleDraweeView;
        this.linCard = linearLayout2;
        this.linMain = linearLayout3;
        this.linPress = linearLayout4;
        this.linPsw = linearLayout5;
        this.llMeInfo = linearLayout6;
        this.lvKey = wrapListView;
        this.lvPresskey = wrapListView2;
        this.relAddcard = relativeLayout;
        this.relAddpresskey = relativeLayout2;
        this.relAddpswkey = relativeLayout3;
        this.relCard = relativeLayout4;
        this.titlebar = titleBar;
        this.tvAddcard = textView;
        this.tvAddcardtime = textView2;
        this.tvAddpresskey = textView3;
        this.tvAddpswkey = textView4;
        this.tvAddress = textView5;
        this.tvAddtime = textView6;
        this.tvCardopen = textView7;
        this.tvCenter = textView8;
        this.tvIdtext = textView9;
        this.tvMeId = textView10;
        this.tvMeName = textView11;
        this.tvPressopen = textView12;
        this.tvPswopen = textView13;
        this.tvQrcodeopen = textView14;
        this.tvRoomcard = textView15;
    }

    public static ActivityDoorLockMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDoorLockMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_door_lock_main, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDoorLockMainBinding bind(View view) {
        int i = R.id.btn_delectcard;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.img_dangertip;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.img_eye1;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.img_eye2;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.img_eye3;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = R.id.img_eye4;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView5 != null) {
                                i = R.id.iv_me_icon;
                                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i);
                                if (simpleDraweeView != null) {
                                    i = R.id.lin_card;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        LinearLayout linearLayout2 = (LinearLayout) view;
                                        i = R.id.lin_press;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.lin_psw;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout4 != null) {
                                                i = R.id.ll_me_info;
                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout5 != null) {
                                                    i = R.id.lv_key;
                                                    WrapListView wrapListView = (WrapListView) ViewBindings.findChildViewById(view, i);
                                                    if (wrapListView != null) {
                                                        i = R.id.lv_presskey;
                                                        WrapListView wrapListView2 = (WrapListView) ViewBindings.findChildViewById(view, i);
                                                        if (wrapListView2 != null) {
                                                            i = R.id.rel_addcard;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout != null) {
                                                                i = R.id.rel_addpresskey;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout2 != null) {
                                                                    i = R.id.rel_addpswkey;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (relativeLayout3 != null) {
                                                                        i = R.id.rel_card;
                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (relativeLayout4 != null) {
                                                                            i = R.id.titlebar;
                                                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                            if (titleBar != null) {
                                                                                i = R.id.tv_addcard;
                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView != null) {
                                                                                    i = R.id.tv_addcardtime;
                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView2 != null) {
                                                                                        i = R.id.tv_addpresskey;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.tv_addpswkey;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.tv_address;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.tv_addtime;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.tv_cardopen;
                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView7 != null) {
                                                                                                            i = R.id.tv_center;
                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView8 != null) {
                                                                                                                i = R.id.tv_idtext;
                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView9 != null) {
                                                                                                                    i = R.id.tv_me_id;
                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView10 != null) {
                                                                                                                        i = R.id.tv_me_name;
                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView11 != null) {
                                                                                                                            i = R.id.tv_pressopen;
                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView12 != null) {
                                                                                                                                i = R.id.tv_pswopen;
                                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView13 != null) {
                                                                                                                                    i = R.id.tv_qrcodeopen;
                                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView14 != null) {
                                                                                                                                        i = R.id.tv_roomcard;
                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView15 != null) {
                                                                                                                                            return new ActivityDoorLockMainBinding(linearLayout2, button, imageView, imageView2, imageView3, imageView4, imageView5, simpleDraweeView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, wrapListView, wrapListView2, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
