package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapGridView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityWalletDetailBinding implements ViewBinding {
    public final RelativeLayout accountInfoLayout;
    public final TextView btnButie;
    public final TextView btnChongzhi;
    public final Button btnRecord;
    public final Button btnRefund;
    public final EditText edtMoney;
    public final ImageView img;
    public final ImageView img1;
    public final ImageView img2;
    public final ImageView img3;
    public final ImageView imgNext;
    public final ImageView imgSelectAbc;
    public final ImageView imgSelectAli;
    public final ImageView imgSelectUnion;
    public final ImageView imgSelectWeixin;
    public final LinearLayout linCard;
    public final LinearLayout linLinCard;
    public final WrapGridView lvChongzhi;
    public final RelativeLayout relChongzhi;
    public final RelativeLayout relPayway;
    public final RelativeLayout relTip;
    public final RelativeLayout relTowalletdetail;
    private final RelativeLayout rootView;
    public final ScrollView scrollview;
    public final TextView textabc;
    public final TextView textali;
    public final TextView textjiner;
    public final TextView textpayway;
    public final TextView textunion;
    public final TextView textweixin;
    public final TextView tv1;
    public final TextView tv2;
    public final TextView tvAppname;
    public final TextView tvBalance;
    public final TextView tvBalancetext1;
    public final TextView tvMoney1;
    public final TextView tvRefundrecord;
    public final TextView tvServertelephone;
    public final TextView tvTip;
    public final TextView tvTowalletdetail;
    public final RelativeLayout vBtnAbc;
    public final RelativeLayout vBtnUnionAlipay;
    public final RelativeLayout vBtnUnionOnline;
    public final RelativeLayout vBtnUnionWechat;
    public final TitleBar vTitleBar;
    public final View view1;
    public final View view2;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityWalletDetailBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, Button button, Button button2, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, LinearLayout linearLayout, LinearLayout linearLayout2, WrapGridView wrapGridView, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, ScrollView scrollView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, TitleBar titleBar, View view, View view2) {
        this.rootView = relativeLayout;
        this.accountInfoLayout = relativeLayout2;
        this.btnButie = textView;
        this.btnChongzhi = textView2;
        this.btnRecord = button;
        this.btnRefund = button2;
        this.edtMoney = editText;
        this.img = imageView;
        this.img1 = imageView2;
        this.img2 = imageView3;
        this.img3 = imageView4;
        this.imgNext = imageView5;
        this.imgSelectAbc = imageView6;
        this.imgSelectAli = imageView7;
        this.imgSelectUnion = imageView8;
        this.imgSelectWeixin = imageView9;
        this.linCard = linearLayout;
        this.linLinCard = linearLayout2;
        this.lvChongzhi = wrapGridView;
        this.relChongzhi = relativeLayout3;
        this.relPayway = relativeLayout4;
        this.relTip = relativeLayout5;
        this.relTowalletdetail = relativeLayout6;
        this.scrollview = scrollView;
        this.textabc = textView3;
        this.textali = textView4;
        this.textjiner = textView5;
        this.textpayway = textView6;
        this.textunion = textView7;
        this.textweixin = textView8;
        this.tv1 = textView9;
        this.tv2 = textView10;
        this.tvAppname = textView11;
        this.tvBalance = textView12;
        this.tvBalancetext1 = textView13;
        this.tvMoney1 = textView14;
        this.tvRefundrecord = textView15;
        this.tvServertelephone = textView16;
        this.tvTip = textView17;
        this.tvTowalletdetail = textView18;
        this.vBtnAbc = relativeLayout7;
        this.vBtnUnionAlipay = relativeLayout8;
        this.vBtnUnionOnline = relativeLayout9;
        this.vBtnUnionWechat = relativeLayout10;
        this.vTitleBar = titleBar;
        this.view1 = view;
        this.view2 = view2;
    }

    public static ActivityWalletDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWalletDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_wallet_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWalletDetailBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.account_info_layout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.btn_butie;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.btn_chongzhi;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.btn_record;
                    Button button = (Button) ViewBindings.findChildViewById(view, i);
                    if (button != null) {
                        i = R.id.btn_refund;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button2 != null) {
                            i = R.id.edt_money;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText != null) {
                                i = R.id.img;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R.id.img1;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = R.id.img2;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.img3;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView4 != null) {
                                                i = R.id.img_next;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView5 != null) {
                                                    i = R.id.img_select_abc;
                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView6 != null) {
                                                        i = R.id.img_select_ali;
                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView7 != null) {
                                                            i = R.id.img_select_union;
                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView8 != null) {
                                                                i = R.id.img_select_weixin;
                                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView9 != null) {
                                                                    i = R.id.lin_card;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout != null) {
                                                                        i = R.id.lin_lin_card;
                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout2 != null) {
                                                                            i = R.id.lv_chongzhi;
                                                                            WrapGridView wrapGridView = (WrapGridView) ViewBindings.findChildViewById(view, i);
                                                                            if (wrapGridView != null) {
                                                                                i = R.id.rel_chongzhi;
                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (relativeLayout2 != null) {
                                                                                    i = R.id.rel_payway;
                                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (relativeLayout3 != null) {
                                                                                        i = R.id.rel_tip;
                                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (relativeLayout4 != null) {
                                                                                            i = R.id.rel_towalletdetail;
                                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (relativeLayout5 != null) {
                                                                                                i = R.id.scrollview;
                                                                                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                                                if (scrollView != null) {
                                                                                                    i = R.id.textabc;
                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView3 != null) {
                                                                                                        i = R.id.textali;
                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView4 != null) {
                                                                                                            i = R.id.textjiner;
                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView5 != null) {
                                                                                                                i = R.id.textpayway;
                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView6 != null) {
                                                                                                                    i = R.id.textunion;
                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView7 != null) {
                                                                                                                        i = R.id.textweixin;
                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView8 != null) {
                                                                                                                            i = R.id.tv1;
                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView9 != null) {
                                                                                                                                i = R.id.tv2;
                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView10 != null) {
                                                                                                                                    i = R.id.tv_appname;
                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView11 != null) {
                                                                                                                                        i = R.id.tv_balance;
                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView12 != null) {
                                                                                                                                            i = R.id.tv_balancetext1;
                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView13 != null) {
                                                                                                                                                i = R.id.tv_money1;
                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView14 != null) {
                                                                                                                                                    i = R.id.tv_refundrecord;
                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                        i = R.id.tv_servertelephone;
                                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                            i = R.id.tv_tip;
                                                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (textView17 != null) {
                                                                                                                                                                i = R.id.tv_towalletdetail;
                                                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView18 != null) {
                                                                                                                                                                    i = R.id.v_btn_abc;
                                                                                                                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (relativeLayout6 != null) {
                                                                                                                                                                        i = R.id.v_btn_union_alipay;
                                                                                                                                                                        RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (relativeLayout7 != null) {
                                                                                                                                                                            i = R.id.v_btn_union_online;
                                                                                                                                                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (relativeLayout8 != null) {
                                                                                                                                                                                i = R.id.v_btn_union_wechat;
                                                                                                                                                                                RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (relativeLayout9 != null) {
                                                                                                                                                                                    i = R.id.v_titleBar;
                                                                                                                                                                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (titleBar != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view2))) != null) {
                                                                                                                                                                                        return new ActivityWalletDetailBinding((RelativeLayout) view, relativeLayout, textView, textView2, button, button2, editText, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, linearLayout, linearLayout2, wrapGridView, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, scrollView, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, titleBar, viewFindChildViewById, viewFindChildViewById2);
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
