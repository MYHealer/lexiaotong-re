package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4SubmitRefundBinding implements ViewBinding {
    public final Button btnRefund;
    public final EditText etAliaccount;
    public final EditText etName;
    public final EditText etPhone;
    public final EditText etRefunddes;
    public final EditText etStudentno;
    public final LinearLayout linRefunddes;
    public final RelativeLayout relAli;
    public final RelativeLayout relRefundMethod;
    public final RelativeLayout relStudentno;
    public final RadioGroup rgRefundMethod;
    private final LinearLayout rootView;
    public final TextView textali;
    public final TextView textname;
    public final TextView textno;
    public final TextView textphone;
    public final TextView tvCount;
    public final TextView tvRefundMethodLabel;
    public final TextView tvRefundrule;
    public final TextView tvRefundtext;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4SubmitRefundBinding(LinearLayout linearLayout, Button button, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, LinearLayout linearLayout2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RadioGroup radioGroup, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.btnRefund = button;
        this.etAliaccount = editText;
        this.etName = editText2;
        this.etPhone = editText3;
        this.etRefunddes = editText4;
        this.etStudentno = editText5;
        this.linRefunddes = linearLayout2;
        this.relAli = relativeLayout;
        this.relRefundMethod = relativeLayout2;
        this.relStudentno = relativeLayout3;
        this.rgRefundMethod = radioGroup;
        this.textali = textView;
        this.textname = textView2;
        this.textno = textView3;
        this.textphone = textView4;
        this.tvCount = textView5;
        this.tvRefundMethodLabel = textView6;
        this.tvRefundrule = textView7;
        this.tvRefundtext = textView8;
        this.vTitleBar = titleBar;
    }

    public static ActivityV4SubmitRefundBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4SubmitRefundBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_submit_refund, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4SubmitRefundBinding bind(View view) {
        int i = R.id.btn_refund;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_aliaccount;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et_name;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.et_phone;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText3 != null) {
                        i = R.id.et_refunddes;
                        EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText4 != null) {
                            i = R.id.et_studentno;
                            EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText5 != null) {
                                i = R.id.lin_refunddes;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.rel_ali;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout != null) {
                                        i = R.id.rel_refund_method;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout2 != null) {
                                            i = R.id.rel_studentno;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout3 != null) {
                                                i = R.id.rg_refund_method;
                                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                                                if (radioGroup != null) {
                                                    i = R.id.textali;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView != null) {
                                                        i = R.id.textname;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView2 != null) {
                                                            i = R.id.textno;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView3 != null) {
                                                                i = R.id.textphone;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView4 != null) {
                                                                    i = R.id.tv_count;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.tv_refund_method_label;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.tv_refundrule;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView7 != null) {
                                                                                i = R.id.tv_refundtext;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.v_titleBar;
                                                                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                                    if (titleBar != null) {
                                                                                        return new ActivityV4SubmitRefundBinding((LinearLayout) view, button, editText, editText2, editText3, editText4, editText5, linearLayout, relativeLayout, relativeLayout2, relativeLayout3, radioGroup, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, titleBar);
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
