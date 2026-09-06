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
public final class ActivityChangePhoneGetVerifyNewBinding implements ViewBinding {
    public final Button btnGetverifica;
    public final Button btnNext;
    public final EditText etPhone;
    public final EditText etVerification;
    public final ImageView ivPhone;
    public final ImageView ivVerification;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvTip;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityChangePhoneGetVerifyNewBinding(LinearLayout linearLayout, Button button, Button button2, EditText editText, EditText editText2, ImageView imageView, ImageView imageView2, TitleBar titleBar, TextView textView) {
        this.rootView = linearLayout;
        this.btnGetverifica = button;
        this.btnNext = button2;
        this.etPhone = editText;
        this.etVerification = editText2;
        this.ivPhone = imageView;
        this.ivVerification = imageView2;
        this.titleBar = titleBar;
        this.tvTip = textView;
    }

    public static ActivityChangePhoneGetVerifyNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityChangePhoneGetVerifyNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_change_phone_get_verify_new, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityChangePhoneGetVerifyNewBinding bind(View view) {
        int i = R.id.btn_getverifica;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_next;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.et_phone;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = R.id.et_verification;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText2 != null) {
                        i = R.id.iv_phone;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.iv_verification;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.titleBar;
                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                if (titleBar != null) {
                                    i = R.id.tv_tip;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        return new ActivityChangePhoneGetVerifyNewBinding((LinearLayout) view, button, button2, editText, editText2, imageView, imageView2, titleBar, textView);
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
