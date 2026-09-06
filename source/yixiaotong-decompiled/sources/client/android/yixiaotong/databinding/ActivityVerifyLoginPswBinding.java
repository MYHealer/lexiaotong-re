package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityVerifyLoginPswBinding implements ViewBinding {
    public final Button btnNext;
    public final EditText etPsw;
    public final RelativeLayout rel;
    private final LinearLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvText1;
    public final TextView tvText2;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityVerifyLoginPswBinding(LinearLayout linearLayout, Button button, EditText editText, RelativeLayout relativeLayout, TitleBar titleBar, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnNext = button;
        this.etPsw = editText;
        this.rel = relativeLayout;
        this.titlebar = titleBar;
        this.tvText1 = textView;
        this.tvText2 = textView2;
    }

    public static ActivityVerifyLoginPswBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityVerifyLoginPswBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_verify_login_psw, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityVerifyLoginPswBinding bind(View view) {
        int i = R.id.btn_next;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_psw;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.rel;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.titlebar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        i = R.id.tv_text1;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_text2;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new ActivityVerifyLoginPswBinding((LinearLayout) view, button, editText, relativeLayout, titleBar, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
