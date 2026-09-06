package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityAmmeterWalletDetailBinding implements ViewBinding {
    public final RelativeLayout accountInfoLayout;
    public final Button btn0;
    public final Button btn1;
    public final Button btn2;
    public final Button btn3;
    public final Button btn4;
    public final Button btn5;
    public final Button btn6;
    public final Button btn7;
    public final Button btn8;
    public final Button btn9;
    public final ImageButton btnD;
    public final Button btnT;
    public final TextView kwh;
    public final LinearLayout linInputmoney;
    public final LinearLayout linInputmoney1;
    public final RelativeLayout relOrder;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final LinearLayout tableNum;
    public final TextView tvAmmeterBalance;
    public final TextView tvAmmeterbalancetext;
    public final TextView tvBalance;
    public final TextView tvBalancetext;
    public final TextView tvDevicename;
    public final TextView tvKwh;
    public final TextView tvMoney;
    public final TextView tvRecharge;
    public final Button vBtnRecharge;
    public final Button vBtnRecord;
    public final ImageView vBtnUnionAlipay;
    public final ImageView vBtnUnionOnline;
    public final ImageView vBtnUnionWechat;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityAmmeterWalletDetailBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, ImageButton imageButton, Button button11, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout2, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, Button button12, Button button13, ImageView imageView, ImageView imageView2, ImageView imageView3, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.accountInfoLayout = relativeLayout;
        this.btn0 = button;
        this.btn1 = button2;
        this.btn2 = button3;
        this.btn3 = button4;
        this.btn4 = button5;
        this.btn5 = button6;
        this.btn6 = button7;
        this.btn7 = button8;
        this.btn8 = button9;
        this.btn9 = button10;
        this.btnD = imageButton;
        this.btnT = button11;
        this.kwh = textView;
        this.linInputmoney = linearLayout2;
        this.linInputmoney1 = linearLayout3;
        this.relOrder = relativeLayout2;
        this.rootLayout = linearLayout4;
        this.tableNum = linearLayout5;
        this.tvAmmeterBalance = textView2;
        this.tvAmmeterbalancetext = textView3;
        this.tvBalance = textView4;
        this.tvBalancetext = textView5;
        this.tvDevicename = textView6;
        this.tvKwh = textView7;
        this.tvMoney = textView8;
        this.tvRecharge = textView9;
        this.vBtnRecharge = button12;
        this.vBtnRecord = button13;
        this.vBtnUnionAlipay = imageView;
        this.vBtnUnionOnline = imageView2;
        this.vBtnUnionWechat = imageView3;
        this.vTitleBar = titleBar;
    }

    public static ActivityAmmeterWalletDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAmmeterWalletDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_ammeter_wallet_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAmmeterWalletDetailBinding bind(View view) {
        int i = R.id.account_info_layout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.btn_0;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.btn_1;
                Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                if (button2 != null) {
                    i = R.id.btn_2;
                    Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                    if (button3 != null) {
                        i = R.id.btn_3;
                        Button button4 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button4 != null) {
                            i = R.id.btn_4;
                            Button button5 = (Button) ViewBindings.findChildViewById(view, i);
                            if (button5 != null) {
                                i = R.id.btn_5;
                                Button button6 = (Button) ViewBindings.findChildViewById(view, i);
                                if (button6 != null) {
                                    i = R.id.btn_6;
                                    Button button7 = (Button) ViewBindings.findChildViewById(view, i);
                                    if (button7 != null) {
                                        i = R.id.btn_7;
                                        Button button8 = (Button) ViewBindings.findChildViewById(view, i);
                                        if (button8 != null) {
                                            i = R.id.btn_8;
                                            Button button9 = (Button) ViewBindings.findChildViewById(view, i);
                                            if (button9 != null) {
                                                i = R.id.btn_9;
                                                Button button10 = (Button) ViewBindings.findChildViewById(view, i);
                                                if (button10 != null) {
                                                    i = R.id.btn_d;
                                                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
                                                    if (imageButton != null) {
                                                        i = R.id.btn_t;
                                                        Button button11 = (Button) ViewBindings.findChildViewById(view, i);
                                                        if (button11 != null) {
                                                            i = R.id.kwh;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView != null) {
                                                                i = R.id.lin_inputmoney;
                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout != null) {
                                                                    i = R.id.lin_inputmoney1;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout2 != null) {
                                                                        i = R.id.rel_order;
                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (relativeLayout2 != null) {
                                                                            i = R.id.root_layout;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.table_num;
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout4 != null) {
                                                                                    i = R.id.tv_ammeter_balance;
                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView2 != null) {
                                                                                        i = R.id.tv_ammeterbalancetext;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.tv_balance;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.tv_balancetext;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.tv_devicename;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.tv_kwh;
                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView7 != null) {
                                                                                                            i = R.id.tv_money;
                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView8 != null) {
                                                                                                                i = R.id.tv_recharge;
                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView9 != null) {
                                                                                                                    i = R.id.v_btn_recharge;
                                                                                                                    Button button12 = (Button) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (button12 != null) {
                                                                                                                        i = R.id.v_btn_record;
                                                                                                                        Button button13 = (Button) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (button13 != null) {
                                                                                                                            i = R.id.v_btn_union_alipay;
                                                                                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (imageView != null) {
                                                                                                                                i = R.id.v_btn_union_online;
                                                                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (imageView2 != null) {
                                                                                                                                    i = R.id.v_btn_union_wechat;
                                                                                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (imageView3 != null) {
                                                                                                                                        i = R.id.v_titleBar;
                                                                                                                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (titleBar != null) {
                                                                                                                                            return new ActivityAmmeterWalletDetailBinding((LinearLayout) view, relativeLayout, button, button2, button3, button4, button5, button6, button7, button8, button9, button10, imageButton, button11, textView, linearLayout, linearLayout2, relativeLayout2, linearLayout3, linearLayout4, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, button12, button13, imageView, imageView2, imageView3, titleBar);
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
