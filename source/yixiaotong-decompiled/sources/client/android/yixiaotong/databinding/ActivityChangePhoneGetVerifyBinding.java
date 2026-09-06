package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityChangePhoneGetVerifyBinding implements ViewBinding {
    public final Button btnGetverifica;
    public final Button btnNext;
    public final EditText etVerification;
    public final ImageView ivVerification;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvPhone;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityChangePhoneGetVerifyBinding(LinearLayout linearLayout, Button button, Button button2, EditText editText, ImageView imageView, TitleBar titleBar, TextView textView) {
        this.rootView = linearLayout;
        this.btnGetverifica = button;
        this.btnNext = button2;
        this.etVerification = editText;
        this.ivVerification = imageView;
        this.titleBar = titleBar;
        this.tvPhone = textView;
    }

    public static ActivityChangePhoneGetVerifyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityChangePhoneGetVerifyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_change_phone_get_verify, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityChangePhoneGetVerifyBinding bind(View view) {
        int i = R.id.btn_getverifica;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_next;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.et_verification;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = R.id.iv_verification;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.titleBar;
                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                        if (titleBar != null) {
                            i = R.id.tv_phone;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new ActivityChangePhoneGetVerifyBinding((LinearLayout) view, button, button2, editText, imageView, titleBar, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
