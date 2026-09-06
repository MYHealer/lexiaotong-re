package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TelEdittext;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityFindPassword1Binding implements ViewBinding {
    private final LinearLayout rootView;
    public final ScrollView scrollview;
    public final TextView tvPhone;
    public final TextView tvPsw;
    public final TextView tvPsw1;
    public final TextView tvText;
    public final TextView tvVerify;
    public final Button vBtnNext;
    public final Button vBtnVerify;
    public final EditText vEtPassword;
    public final EditText vEtPasswordAgain;
    public final TelEdittext vEtPhone;
    public final EditText vEtVerify;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityFindPassword1Binding(LinearLayout linearLayout, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, Button button, Button button2, EditText editText, EditText editText2, TelEdittext telEdittext, EditText editText3, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.scrollview = scrollView;
        this.tvPhone = textView;
        this.tvPsw = textView2;
        this.tvPsw1 = textView3;
        this.tvText = textView4;
        this.tvVerify = textView5;
        this.vBtnNext = button;
        this.vBtnVerify = button2;
        this.vEtPassword = editText;
        this.vEtPasswordAgain = editText2;
        this.vEtPhone = telEdittext;
        this.vEtVerify = editText3;
        this.vTitleBar = titleBar;
    }

    public static ActivityFindPassword1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFindPassword1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_find_password1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFindPassword1Binding bind(View view) {
        int i = R.id.scrollview;
        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
        if (scrollView != null) {
            i = R.id.tv_phone;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_psw;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_psw1;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.tv_text;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.tv_verify;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.v_btn_next;
                                Button button = (Button) ViewBindings.findChildViewById(view, i);
                                if (button != null) {
                                    i = R.id.v_btn_verify;
                                    Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                                    if (button2 != null) {
                                        i = R.id.v_et_password;
                                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                        if (editText != null) {
                                            i = R.id.v_et_password_again;
                                            EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                            if (editText2 != null) {
                                                i = R.id.v_et_phone;
                                                TelEdittext telEdittext = (TelEdittext) ViewBindings.findChildViewById(view, i);
                                                if (telEdittext != null) {
                                                    i = R.id.v_et_verify;
                                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                                    if (editText3 != null) {
                                                        i = R.id.v_titleBar;
                                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                        if (titleBar != null) {
                                                            return new ActivityFindPassword1Binding((LinearLayout) view, scrollView, textView, textView2, textView3, textView4, textView5, button, button2, editText, editText2, telEdittext, editText3, titleBar);
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
