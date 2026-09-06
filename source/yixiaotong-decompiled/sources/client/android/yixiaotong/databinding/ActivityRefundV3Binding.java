package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
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
public final class ActivityRefundV3Binding implements ViewBinding {
    public final Button btnRefund;
    public final EditText etRefunddes;
    public final EditText etStudentno;
    public final GridView gridimg;
    public final ImageView img;
    public final ImageView img1;
    public final ImageView imgAdd;
    public final ImageView imgSelectAli;
    public final ImageView imgSelectUnion;
    public final ImageView imgSelectWeixin;
    public final ImageView imgunion;
    public final LinearLayout linRefunddes;
    public final LinearLayout linStudentno;
    public final WrapListView listview;
    public final RelativeLayout relAlipay;
    public final RelativeLayout relUnionpay;
    public final RelativeLayout relWechat;
    private final LinearLayout rootView;
    public final TextView textali;
    public final TextView textunion;
    public final TextView textweixin;
    public final TextView tvCount;
    public final TextView tvRefundtext;
    public final TextView tvStudentnotext;
    public final TextView tvTip;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityRefundV3Binding(LinearLayout linearLayout, Button button, EditText editText, EditText editText2, GridView gridView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, LinearLayout linearLayout2, LinearLayout linearLayout3, WrapListView wrapListView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.btnRefund = button;
        this.etRefunddes = editText;
        this.etStudentno = editText2;
        this.gridimg = gridView;
        this.img = imageView;
        this.img1 = imageView2;
        this.imgAdd = imageView3;
        this.imgSelectAli = imageView4;
        this.imgSelectUnion = imageView5;
        this.imgSelectWeixin = imageView6;
        this.imgunion = imageView7;
        this.linRefunddes = linearLayout2;
        this.linStudentno = linearLayout3;
        this.listview = wrapListView;
        this.relAlipay = relativeLayout;
        this.relUnionpay = relativeLayout2;
        this.relWechat = relativeLayout3;
        this.textali = textView;
        this.textunion = textView2;
        this.textweixin = textView3;
        this.tvCount = textView4;
        this.tvRefundtext = textView5;
        this.tvStudentnotext = textView6;
        this.tvTip = textView7;
        this.vTitleBar = titleBar;
    }

    public static ActivityRefundV3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRefundV3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_refund_v3, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRefundV3Binding bind(View view) {
        int i = R.id.btn_refund;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_refunddes;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et_studentno;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.gridimg;
                    GridView gridView = (GridView) ViewBindings.findChildViewById(view, i);
                    if (gridView != null) {
                        i = R.id.img;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.img1;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.img_add;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.img_select_ali;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView4 != null) {
                                        i = R.id.img_select_union;
                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView5 != null) {
                                            i = R.id.img_select_weixin;
                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView6 != null) {
                                                i = R.id.imgunion;
                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView7 != null) {
                                                    i = R.id.lin_refunddes;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout != null) {
                                                        i = R.id.lin_studentno;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.listview;
                                                            WrapListView wrapListView = (WrapListView) ViewBindings.findChildViewById(view, i);
                                                            if (wrapListView != null) {
                                                                i = R.id.rel_alipay;
                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout != null) {
                                                                    i = R.id.rel_unionpay;
                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (relativeLayout2 != null) {
                                                                        i = R.id.rel_wechat;
                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (relativeLayout3 != null) {
                                                                            i = R.id.textali;
                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView != null) {
                                                                                i = R.id.textunion;
                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView2 != null) {
                                                                                    i = R.id.textweixin;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView3 != null) {
                                                                                        i = R.id.tv_count;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView4 != null) {
                                                                                            i = R.id.tv_refundtext;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView5 != null) {
                                                                                                i = R.id.tv_studentnotext;
                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView6 != null) {
                                                                                                    i = R.id.tv_tip;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView7 != null) {
                                                                                                        i = R.id.v_titleBar;
                                                                                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                                                        if (titleBar != null) {
                                                                                                            return new ActivityRefundV3Binding((LinearLayout) view, button, editText, editText2, gridView, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, linearLayout, linearLayout2, wrapListView, relativeLayout, relativeLayout2, relativeLayout3, textView, textView2, textView3, textView4, textView5, textView6, textView7, titleBar);
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
