package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV3RegisterBinding implements ViewBinding {
    public final Button btnGetverifica;
    public final Button btnHasaccount;
    public final Button btnRegister;
    public final EditText etPhone;
    public final EditText etPsw1;
    public final EditText etPsw2;
    public final EditText etVerification;
    public final ImageView ivAgree;
    public final ImageView ivBack;
    public final ImageView ivPhone;
    public final ImageView ivPsw1;
    public final ImageView ivPsw2;
    public final ImageView ivVerification;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvAgree1;
    public final TextView tvAgree2;
    public final TextView tvAgreetext;
    public final TextView tvAgreetext2;
    public final TextView tvRegistertext;
    public final TextView tvSchoolname;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityV3RegisterBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, EditText editText, EditText editText2, EditText editText3, EditText editText4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.btnGetverifica = button;
        this.btnHasaccount = button2;
        this.btnRegister = button3;
        this.etPhone = editText;
        this.etPsw1 = editText2;
        this.etPsw2 = editText3;
        this.etVerification = editText4;
        this.ivAgree = imageView;
        this.ivBack = imageView2;
        this.ivPhone = imageView3;
        this.ivPsw1 = imageView4;
        this.ivPsw2 = imageView5;
        this.ivVerification = imageView6;
        this.titleBar = titleBar;
        this.tvAgree1 = textView;
        this.tvAgree2 = textView2;
        this.tvAgreetext = textView3;
        this.tvAgreetext2 = textView4;
        this.tvRegistertext = textView5;
        this.tvSchoolname = textView6;
    }

    public static ActivityV3RegisterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV3RegisterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v3_register, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV3RegisterBinding bind(View view) {
        int i = R.id.btn_getverifica;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_hasaccount;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.btn_register;
                Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                if (button3 != null) {
                    i = R.id.et_phone;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText != null) {
                        i = R.id.et_psw1;
                        EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText2 != null) {
                            i = R.id.et_psw2;
                            EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText3 != null) {
                                i = R.id.et_verification;
                                EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText4 != null) {
                                    i = R.id.iv_agree;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = R.id.iv_back;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView2 != null) {
                                            i = R.id.iv_phone;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView3 != null) {
                                                i = R.id.iv_psw1;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView4 != null) {
                                                    i = R.id.iv_psw2;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView5 != null) {
                                                        i = R.id.iv_verification;
                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView6 != null) {
                                                            i = R.id.titleBar;
                                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                            if (titleBar != null) {
                                                                i = R.id.tv_agree1;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView != null) {
                                                                    i = R.id.tv_agree2;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView2 != null) {
                                                                        i = R.id.tv_agreetext;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView3 != null) {
                                                                            i = R.id.tv_agreetext2;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView4 != null) {
                                                                                i = R.id.tv_registertext;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView5 != null) {
                                                                                    i = R.id.tv_schoolname;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView6 != null) {
                                                                                        return new ActivityV3RegisterBinding((LinearLayout) view, button, button2, button3, editText, editText2, editText3, editText4, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, titleBar, textView, textView2, textView3, textView4, textView5, textView6);
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
