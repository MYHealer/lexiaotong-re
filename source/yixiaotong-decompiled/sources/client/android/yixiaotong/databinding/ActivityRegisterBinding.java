package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TelEdittext;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityRegisterBinding implements ViewBinding {
    public final ImageButton btnViewPsw;
    private final LinearLayout rootView;
    public final TextView tvText;
    public final Button vBtnNext;
    public final Button vBtnVerify;
    public final EditText vEtPassword;
    public final TelEdittext vEtPhone;
    public final EditText vEtVerify;
    public final TitleBar vTitleBar;
    public final TextView vUserFile;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityRegisterBinding(LinearLayout linearLayout, ImageButton imageButton, TextView textView, Button button, Button button2, EditText editText, TelEdittext telEdittext, EditText editText2, TitleBar titleBar, TextView textView2) {
        this.rootView = linearLayout;
        this.btnViewPsw = imageButton;
        this.tvText = textView;
        this.vBtnNext = button;
        this.vBtnVerify = button2;
        this.vEtPassword = editText;
        this.vEtPhone = telEdittext;
        this.vEtVerify = editText2;
        this.vTitleBar = titleBar;
        this.vUserFile = textView2;
    }

    public static ActivityRegisterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRegisterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_register, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRegisterBinding bind(View view) {
        int i = R.id.btn_view_psw;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.tv_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.v_btn_next;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    i = R.id.v_btn_verify;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                    if (button2 != null) {
                        i = R.id.v_et_password;
                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText != null) {
                            i = R.id.v_et_phone;
                            TelEdittext telEdittext = (TelEdittext) ViewBindings.findChildViewById(view, i);
                            if (telEdittext != null) {
                                i = R.id.v_et_verify;
                                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText2 != null) {
                                    i = R.id.v_titleBar;
                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                    if (titleBar != null) {
                                        i = R.id.v_user_file;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            return new ActivityRegisterBinding((LinearLayout) view, imageButton, textView, button, button2, editText, telEdittext, editText2, titleBar, textView2);
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
