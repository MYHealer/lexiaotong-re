package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TelEdittext;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityFillInfoBinding implements ViewBinding {
    public final ImageView ivAgree;
    public final ImageView ivArrow10;
    public final ImageView ivArrow8;
    private final LinearLayout rootView;
    public final ScrollView scrollview;
    public final RadioButton sexBoy;
    public final RadioButton sexGirl;
    public final RadioGroup sexGroup;
    public final TitleBar titleBar;
    public final TextView tvAgree1;
    public final TextView tvAgree2;
    public final TextView tvAgreetext;
    public final TextView tvAgreetext2;
    public final TextView tvBindingSch;
    public final TextView tvName;
    public final TextView tvPhone;
    public final TextView tvPsw;
    public final TextView tvSchool;
    public final TextView tvSex;
    public final TextView tvText;
    public final TextView tvVerify;
    public final TextView tvXuehao;
    public final Button vBtnNext;
    public final Button vBtnVerify;
    public final EditText vEtAuthorizedPassword;
    public final EditText vEtIdentificationId;
    public final EditText vEtName;
    public final EditText vEtNum;
    public final EditText vEtPassword;
    public final TelEdittext vEtPhone;
    public final EditText vEtVerify;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityFillInfoBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ScrollView scrollView, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, Button button, Button button2, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, TelEdittext telEdittext, EditText editText6) {
        this.rootView = linearLayout;
        this.ivAgree = imageView;
        this.ivArrow10 = imageView2;
        this.ivArrow8 = imageView3;
        this.scrollview = scrollView;
        this.sexBoy = radioButton;
        this.sexGirl = radioButton2;
        this.sexGroup = radioGroup;
        this.titleBar = titleBar;
        this.tvAgree1 = textView;
        this.tvAgree2 = textView2;
        this.tvAgreetext = textView3;
        this.tvAgreetext2 = textView4;
        this.tvBindingSch = textView5;
        this.tvName = textView6;
        this.tvPhone = textView7;
        this.tvPsw = textView8;
        this.tvSchool = textView9;
        this.tvSex = textView10;
        this.tvText = textView11;
        this.tvVerify = textView12;
        this.tvXuehao = textView13;
        this.vBtnNext = button;
        this.vBtnVerify = button2;
        this.vEtAuthorizedPassword = editText;
        this.vEtIdentificationId = editText2;
        this.vEtName = editText3;
        this.vEtNum = editText4;
        this.vEtPassword = editText5;
        this.vEtPhone = telEdittext;
        this.vEtVerify = editText6;
    }

    public static ActivityFillInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFillInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_fill_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFillInfoBinding bind(View view) {
        int i = R.id.iv_agree;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_arrow10;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_arrow8;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.scrollview;
                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                    if (scrollView != null) {
                        i = R.id.sex_boy;
                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                        if (radioButton != null) {
                            i = R.id.sex_girl;
                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                            if (radioButton2 != null) {
                                i = R.id.sex_group;
                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                                if (radioGroup != null) {
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
                                                        i = R.id.tv_binding_sch;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_name;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = R.id.tv_phone;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.tv_psw;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.tv_school;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView9 != null) {
                                                                            i = R.id.tv_sex;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView10 != null) {
                                                                                i = R.id.tv_text;
                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView11 != null) {
                                                                                    i = R.id.tv_verify;
                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView12 != null) {
                                                                                        i = R.id.tv_xuehao;
                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView13 != null) {
                                                                                            i = R.id.v_btn_next;
                                                                                            Button button = (Button) ViewBindings.findChildViewById(view, i);
                                                                                            if (button != null) {
                                                                                                i = R.id.v_btn_verify;
                                                                                                Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                                                                                                if (button2 != null) {
                                                                                                    i = R.id.v_et_authorizedPassword;
                                                                                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                    if (editText != null) {
                                                                                                        i = R.id.v_et_identification_id;
                                                                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                        if (editText2 != null) {
                                                                                                            i = R.id.v_et_name;
                                                                                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                            if (editText3 != null) {
                                                                                                                i = R.id.v_et_num;
                                                                                                                EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                                if (editText4 != null) {
                                                                                                                    i = R.id.v_et_password;
                                                                                                                    EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (editText5 != null) {
                                                                                                                        i = R.id.v_et_phone;
                                                                                                                        TelEdittext telEdittext = (TelEdittext) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (telEdittext != null) {
                                                                                                                            i = R.id.v_et_verify;
                                                                                                                            EditText editText6 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (editText6 != null) {
                                                                                                                                return new ActivityFillInfoBinding((LinearLayout) view, imageView, imageView2, imageView3, scrollView, radioButton, radioButton2, radioGroup, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, button, button2, editText, editText2, editText3, editText4, editText5, telEdittext, editText6);
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
