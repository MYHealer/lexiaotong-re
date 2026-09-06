package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityFindPassword2Binding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvPsw;
    public final TextView tvPsw1;
    public final TextView tvPswjiu;
    public final TextView tvText;
    public final Button vBtnFinish;
    public final EditText vEtOldPassword;
    public final EditText vEtPassword;
    public final EditText vEtPasswordAgain;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityFindPassword2Binding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, Button button, EditText editText, EditText editText2, EditText editText3, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.tvPsw = textView;
        this.tvPsw1 = textView2;
        this.tvPswjiu = textView3;
        this.tvText = textView4;
        this.vBtnFinish = button;
        this.vEtOldPassword = editText;
        this.vEtPassword = editText2;
        this.vEtPasswordAgain = editText3;
        this.vTitleBar = titleBar;
    }

    public static ActivityFindPassword2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFindPassword2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_find_password2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFindPassword2Binding bind(View view) {
        int i = R.id.tv_psw;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.tv_psw1;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.tv_pswjiu;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.tv_text;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.v_btn_finish;
                        Button button = (Button) ViewBindings.findChildViewById(view, i);
                        if (button != null) {
                            i = R.id.v_et_old_password;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText != null) {
                                i = R.id.v_et_password;
                                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText2 != null) {
                                    i = R.id.v_et_password_again;
                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText3 != null) {
                                        i = R.id.v_titleBar;
                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                        if (titleBar != null) {
                                            return new ActivityFindPassword2Binding((LinearLayout) view, textView, textView2, textView3, textView4, button, editText, editText2, editText3, titleBar);
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
