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
public final class ActivityWashSettingBinding implements ViewBinding {
    public final Button btnSet;
    public final EditText editAddress;
    private final LinearLayout rootView;
    public final TextView tvLine;
    public final EditText vEtAddress;
    public final EditText vEtAddress1;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityWashSettingBinding(LinearLayout linearLayout, Button button, EditText editText, TextView textView, EditText editText2, EditText editText3, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.btnSet = button;
        this.editAddress = editText;
        this.tvLine = textView;
        this.vEtAddress = editText2;
        this.vEtAddress1 = editText3;
        this.vTitleBar = titleBar;
    }

    public static ActivityWashSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWashSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_wash_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWashSettingBinding bind(View view) {
        int i = R.id.btn_set;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.edit_address;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.tv_line;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.v_et_address;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText2 != null) {
                        i = R.id.v_et_address1;
                        EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText3 != null) {
                            i = R.id.v_titleBar;
                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                            if (titleBar != null) {
                                return new ActivityWashSettingBinding((LinearLayout) view, button, editText, textView, editText2, editText3, titleBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
