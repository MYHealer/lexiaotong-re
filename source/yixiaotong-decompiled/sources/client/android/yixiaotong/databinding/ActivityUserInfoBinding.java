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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityUserInfoBinding implements ViewBinding {
    public final Button btnExitApp;
    public final ImageView ivArrow;
    public final ImageView ivArrow10;
    public final ImageView ivArrow11;
    public final ImageView ivArrow12;
    public final ImageView ivArrow13;
    public final ImageView ivArrow2;
    public final ImageView ivArrow3;
    public final ImageView ivArrow4;
    public final ImageView ivArrow6;
    public final ImageView ivArrow7;
    public final ImageView ivArrow8;
    public final ImageView ivArrow9;
    private final LinearLayout rootView;
    public final Spinner schollSpinner;
    public final ScrollView scrollview;
    public final RadioButton sexBoy;
    public final RadioButton sexGirl;
    public final RadioGroup sexGroup;
    public final TitleBar titleBar;
    public final TextView tvBindingSch;
    public final EditText vEtAddress;
    public final EditText vEtIdentificationId;
    public final EditText vEtName;
    public final EditText vEtNum;
    public final TextView vEtPhotoId;
    public final SimpleDraweeView vIvMeIcon;
    public final RelativeLayout vLlIcon;
    public final TextView vTvEditPassword;
    public final TextView vTvEditPayPassword;
    public final TextView vTvEditShouquanpassword;
    public final TextView vTvEditXiushouquanpassword;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityUserInfoBinding(LinearLayout linearLayout, Button button, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, Spinner spinner, ScrollView scrollView, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, TitleBar titleBar, TextView textView, EditText editText, EditText editText2, EditText editText3, EditText editText4, TextView textView2, SimpleDraweeView simpleDraweeView, RelativeLayout relativeLayout, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.btnExitApp = button;
        this.ivArrow = imageView;
        this.ivArrow10 = imageView2;
        this.ivArrow11 = imageView3;
        this.ivArrow12 = imageView4;
        this.ivArrow13 = imageView5;
        this.ivArrow2 = imageView6;
        this.ivArrow3 = imageView7;
        this.ivArrow4 = imageView8;
        this.ivArrow6 = imageView9;
        this.ivArrow7 = imageView10;
        this.ivArrow8 = imageView11;
        this.ivArrow9 = imageView12;
        this.schollSpinner = spinner;
        this.scrollview = scrollView;
        this.sexBoy = radioButton;
        this.sexGirl = radioButton2;
        this.sexGroup = radioGroup;
        this.titleBar = titleBar;
        this.tvBindingSch = textView;
        this.vEtAddress = editText;
        this.vEtIdentificationId = editText2;
        this.vEtName = editText3;
        this.vEtNum = editText4;
        this.vEtPhotoId = textView2;
        this.vIvMeIcon = simpleDraweeView;
        this.vLlIcon = relativeLayout;
        this.vTvEditPassword = textView3;
        this.vTvEditPayPassword = textView4;
        this.vTvEditShouquanpassword = textView5;
        this.vTvEditXiushouquanpassword = textView6;
    }

    public static ActivityUserInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityUserInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_user_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityUserInfoBinding bind(View view) {
        int i = R.id.btn_exit_app;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.iv_arrow;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_arrow10;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.iv_arrow11;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.iv_arrow12;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = R.id.iv_arrow13;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView5 != null) {
                                i = R.id.iv_arrow2;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView6 != null) {
                                    i = R.id.iv_arrow3;
                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView7 != null) {
                                        i = R.id.iv_arrow4;
                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView8 != null) {
                                            i = R.id.iv_arrow6;
                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView9 != null) {
                                                i = R.id.iv_arrow7;
                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView10 != null) {
                                                    i = R.id.iv_arrow8;
                                                    ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView11 != null) {
                                                        i = R.id.iv_arrow9;
                                                        ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView12 != null) {
                                                            i = R.id.scholl_spinner;
                                                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, i);
                                                            if (spinner != null) {
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
                                                                                    i = R.id.tv_binding_sch;
                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView != null) {
                                                                                        i = R.id.v_et_address;
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
                                                                                                        i = R.id.v_et_photo_id;
                                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView2 != null) {
                                                                                                            i = R.id.v_iv_me_icon;
                                                                                                            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (simpleDraweeView != null) {
                                                                                                                i = R.id.v_ll_icon;
                                                                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (relativeLayout != null) {
                                                                                                                    i = R.id.v_tv_edit_password;
                                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView3 != null) {
                                                                                                                        i = R.id.v_tv_edit_pay_password;
                                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView4 != null) {
                                                                                                                            i = R.id.v_tv_edit_shouquanpassword;
                                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView5 != null) {
                                                                                                                                i = R.id.v_tv_edit_xiushouquanpassword;
                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView6 != null) {
                                                                                                                                    return new ActivityUserInfoBinding((LinearLayout) view, button, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, spinner, scrollView, radioButton, radioButton2, radioGroup, titleBar, textView, editText, editText2, editText3, editText4, textView2, simpleDraweeView, relativeLayout, textView3, textView4, textView5, textView6);
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
