package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.CrossEditText;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityLoginBinding implements ViewBinding {
    public final ImageButton btnViewPsw;
    public final EditText etCode;
    public final TextView forgetPassword;
    public final ImageView imgChangelanguage;
    public final ImageView ivAgree;
    public final ImageView ivCode;
    public final Button loginBtn;
    public final CrossEditText loginPassWordText;
    public final CrossEditText loginPhotoNumberText;
    public final RadioButton radioBeta;
    public final RadioButton radioBeta2;
    public final RadioButton radioDevelop;
    public final RadioButton radioRelease;
    public final RadioButton radioTest;
    public final RadioGroup radiogroupServer;
    public final TextView registerBtn;
    public final RelativeLayout relAgreement;
    public final RelativeLayout relPlatform;
    private final LinearLayout rootView;
    public final ScrollView scrollview;
    public final TextView tvAgree1;
    public final TextView tvAgree2;
    public final TextView tvAgreetext;
    public final TextView tvAgreetext2;
    public final TextView tvGetcode;
    public final TextView tvPasslogin;
    public final TextView tvPlatformschoolname;
    public final TextView tvText;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityLoginBinding(LinearLayout linearLayout, ImageButton imageButton, EditText editText, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, Button button, CrossEditText crossEditText, CrossEditText crossEditText2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioGroup radioGroup, TextView textView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ScrollView scrollView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.rootView = linearLayout;
        this.btnViewPsw = imageButton;
        this.etCode = editText;
        this.forgetPassword = textView;
        this.imgChangelanguage = imageView;
        this.ivAgree = imageView2;
        this.ivCode = imageView3;
        this.loginBtn = button;
        this.loginPassWordText = crossEditText;
        this.loginPhotoNumberText = crossEditText2;
        this.radioBeta = radioButton;
        this.radioBeta2 = radioButton2;
        this.radioDevelop = radioButton3;
        this.radioRelease = radioButton4;
        this.radioTest = radioButton5;
        this.radiogroupServer = radioGroup;
        this.registerBtn = textView2;
        this.relAgreement = relativeLayout;
        this.relPlatform = relativeLayout2;
        this.scrollview = scrollView;
        this.tvAgree1 = textView3;
        this.tvAgree2 = textView4;
        this.tvAgreetext = textView5;
        this.tvAgreetext2 = textView6;
        this.tvGetcode = textView7;
        this.tvPasslogin = textView8;
        this.tvPlatformschoolname = textView9;
        this.tvText = textView10;
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_login, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityLoginBinding bind(View view) {
        int i = R.id.btn_view_psw;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.et_code;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.forget_password;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.img_changelanguage;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.iv_agree;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.iv_code;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.login_btn;
                                Button button = (Button) ViewBindings.findChildViewById(view, i);
                                if (button != null) {
                                    i = R.id.login_pass_word_text;
                                    CrossEditText crossEditText = (CrossEditText) ViewBindings.findChildViewById(view, i);
                                    if (crossEditText != null) {
                                        i = R.id.login_photo_number_text;
                                        CrossEditText crossEditText2 = (CrossEditText) ViewBindings.findChildViewById(view, i);
                                        if (crossEditText2 != null) {
                                            i = R.id.radio_beta;
                                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                                            if (radioButton != null) {
                                                i = R.id.radio_beta2;
                                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                if (radioButton2 != null) {
                                                    i = R.id.radio_develop;
                                                    RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                    if (radioButton3 != null) {
                                                        i = R.id.radio_release;
                                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                        if (radioButton4 != null) {
                                                            i = R.id.radio_test;
                                                            RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                            if (radioButton5 != null) {
                                                                i = R.id.radiogroup_server;
                                                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                                                                if (radioGroup != null) {
                                                                    i = R.id.register_btn;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView2 != null) {
                                                                        i = R.id.rel_agreement;
                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (relativeLayout != null) {
                                                                            i = R.id.rel_platform;
                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (relativeLayout2 != null) {
                                                                                i = R.id.scrollview;
                                                                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                                if (scrollView != null) {
                                                                                    i = R.id.tv_agree1;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView3 != null) {
                                                                                        i = R.id.tv_agree2;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView4 != null) {
                                                                                            i = R.id.tv_agreetext;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView5 != null) {
                                                                                                i = R.id.tv_agreetext2;
                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView6 != null) {
                                                                                                    i = R.id.tv_getcode;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView7 != null) {
                                                                                                        i = R.id.tv_passlogin;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView8 != null) {
                                                                                                            i = R.id.tv_platformschoolname;
                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView9 != null) {
                                                                                                                i = R.id.tv_text;
                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView10 != null) {
                                                                                                                    return new ActivityLoginBinding((LinearLayout) view, imageButton, editText, textView, imageView, imageView2, imageView3, button, crossEditText, crossEditText2, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioGroup, textView2, relativeLayout, relativeLayout2, scrollView, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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
