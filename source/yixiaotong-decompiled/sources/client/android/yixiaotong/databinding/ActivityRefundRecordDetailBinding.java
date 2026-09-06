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
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityRefundRecordDetailBinding implements ViewBinding {
    public final Button btnTry;
    public final ImageView imgIcon1;
    public final ImageView imgIcon2;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvBalance;
    public final TextView tvCreatetime;
    public final TextView tvCreatetimetext;
    public final TextView tvDeviceaddress;
    public final TextView tvDeviceaddresstext;
    public final TextView tvDeviceinfono;
    public final TextView tvDeviceinfonotext;
    public final TextView tvDevicestatue;
    public final TextView tvDevicestatutext;
    public final TextView tvOrderid;
    public final TextView tvOrderidtext;
    public final TextView tvPhone;
    public final TextView tvPhonetext;
    public final TextView tvRechargemoney;
    public final TextView tvRefundaccount;
    public final TextView tvRefundaccounttext;
    public final TextView tvRefundusername;
    public final TextView tvRefundusertext;
    public final TextView tvState;
    public final TextView tvUpdatetime;
    public final View vLine;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityRefundRecordDetailBinding(LinearLayout linearLayout, Button button, ImageView imageView, ImageView imageView2, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, View view) {
        this.rootView = linearLayout;
        this.btnTry = button;
        this.imgIcon1 = imageView;
        this.imgIcon2 = imageView2;
        this.titleBar = titleBar;
        this.tvBalance = textView;
        this.tvCreatetime = textView2;
        this.tvCreatetimetext = textView3;
        this.tvDeviceaddress = textView4;
        this.tvDeviceaddresstext = textView5;
        this.tvDeviceinfono = textView6;
        this.tvDeviceinfonotext = textView7;
        this.tvDevicestatue = textView8;
        this.tvDevicestatutext = textView9;
        this.tvOrderid = textView10;
        this.tvOrderidtext = textView11;
        this.tvPhone = textView12;
        this.tvPhonetext = textView13;
        this.tvRechargemoney = textView14;
        this.tvRefundaccount = textView15;
        this.tvRefundaccounttext = textView16;
        this.tvRefundusername = textView17;
        this.tvRefundusertext = textView18;
        this.tvState = textView19;
        this.tvUpdatetime = textView20;
        this.vLine = view;
    }

    public static ActivityRefundRecordDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRefundRecordDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_refund_record_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRefundRecordDetailBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.btn_try;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.img_icon1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.img_icon2;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.titleBar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        i = R.id.tv_balance;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_createtime;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.tv_createtimetext;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.tv_deviceaddress;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.tv_deviceaddresstext;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.tv_deviceinfono;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.tv_deviceinfonotext;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView7 != null) {
                                                    i = R.id.tv_devicestatue;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView8 != null) {
                                                        i = R.id.tv_devicestatutext;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView9 != null) {
                                                            i = R.id.tv_orderid;
                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView10 != null) {
                                                                i = R.id.tv_orderidtext;
                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView11 != null) {
                                                                    i = R.id.tv_phone;
                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView12 != null) {
                                                                        i = R.id.tv_phonetext;
                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView13 != null) {
                                                                            i = R.id.tv_rechargemoney;
                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView14 != null) {
                                                                                i = R.id.tv_refundaccount;
                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView15 != null) {
                                                                                    i = R.id.tv_refundaccounttext;
                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView16 != null) {
                                                                                        i = R.id.tv_refundusername;
                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView17 != null) {
                                                                                            i = R.id.tv_refundusertext;
                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView18 != null) {
                                                                                                i = R.id.tv_state;
                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView19 != null) {
                                                                                                    i = R.id.tv_updatetime;
                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView20 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_line))) != null) {
                                                                                                        return new ActivityRefundRecordDetailBinding((LinearLayout) view, button, imageView, imageView2, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, viewFindChildViewById);
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
