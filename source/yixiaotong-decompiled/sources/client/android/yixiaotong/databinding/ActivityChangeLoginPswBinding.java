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
public final class ActivityChangeLoginPswBinding implements ViewBinding {
    public final Button btnReset;
    public final EditText etNewpsw1;
    public final EditText etNewpsw2;
    public final EditText etOldpsw;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvText1;
    public final TextView tvText2;
    public final TextView tvText3;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityChangeLoginPswBinding(LinearLayout linearLayout, Button button, EditText editText, EditText editText2, EditText editText3, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnReset = button;
        this.etNewpsw1 = editText;
        this.etNewpsw2 = editText2;
        this.etOldpsw = editText3;
        this.titleBar = titleBar;
        this.tvText1 = textView;
        this.tvText2 = textView2;
        this.tvText3 = textView3;
    }

    public static ActivityChangeLoginPswBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityChangeLoginPswBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_change_login_psw, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityChangeLoginPswBinding bind(View view) {
        int i = R.id.btn_reset;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_newpsw1;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et_newpsw2;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.et_oldpsw;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText3 != null) {
                        i = R.id.titleBar;
                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                        if (titleBar != null) {
                            i = R.id.tv_text1;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tv_text2;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.tv_text3;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        return new ActivityChangeLoginPswBinding((LinearLayout) view, button, editText, editText2, editText3, titleBar, textView, textView2, textView3);
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
