package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityYktbindBinding implements ViewBinding {
    public final Button btnBind;
    public final EditText etAccount;
    public final EditText etPsw;
    public final RelativeLayout relAccount;
    public final RelativeLayout relPsw;
    private final ConstraintLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvAccounttext;
    public final TextView tvPswtext;

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    private ActivityYktbindBinding(ConstraintLayout constraintLayout, Button button, EditText editText, EditText editText2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TitleBar titleBar, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnBind = button;
        this.etAccount = editText;
        this.etPsw = editText2;
        this.relAccount = relativeLayout;
        this.relPsw = relativeLayout2;
        this.titlebar = titleBar;
        this.tvAccounttext = textView;
        this.tvPswtext = textView2;
    }

    public static ActivityYktbindBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityYktbindBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_yktbind, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityYktbindBinding bind(View view) {
        int i = R.id.btn_bind;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_account;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et_psw;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.rel_account;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = R.id.rel_psw;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout2 != null) {
                            i = R.id.titlebar;
                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                            if (titleBar != null) {
                                i = R.id.tv_accounttext;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tv_pswtext;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        return new ActivityYktbindBinding((ConstraintLayout) view, button, editText, editText2, relativeLayout, relativeLayout2, titleBar, textView, textView2);
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
