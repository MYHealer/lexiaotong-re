package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityFindPswBinding implements ViewBinding {
    public final Button btnGetverifica;
    public final Button btnReset;
    public final EditText etPhone;
    public final EditText etPsw1;
    public final EditText etPsw2;
    public final EditText etVerification;
    public final ImageView ivPhone;
    public final ImageView ivPsw1;
    public final ImageView ivPsw2;
    public final ImageView ivVerification;
    private final LinearLayout rootView;
    public final TitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityFindPswBinding(LinearLayout linearLayout, Button button, Button button2, EditText editText, EditText editText2, EditText editText3, EditText editText4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.btnGetverifica = button;
        this.btnReset = button2;
        this.etPhone = editText;
        this.etPsw1 = editText2;
        this.etPsw2 = editText3;
        this.etVerification = editText4;
        this.ivPhone = imageView;
        this.ivPsw1 = imageView2;
        this.ivPsw2 = imageView3;
        this.ivVerification = imageView4;
        this.titleBar = titleBar;
    }

    public static ActivityFindPswBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFindPswBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_find_psw, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFindPswBinding bind(View view) {
        int i = R.id.btn_getverifica;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_reset;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.et_phone;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = R.id.et_psw1;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText2 != null) {
                        i = R.id.et_psw2;
                        EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText3 != null) {
                            i = R.id.et_verification;
                            EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText4 != null) {
                                i = R.id.iv_phone;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R.id.iv_psw1;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView2 != null) {
                                        i = R.id.iv_psw2;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.iv_verification;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView4 != null) {
                                                i = R.id.titleBar;
                                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                if (titleBar != null) {
                                                    return new ActivityFindPswBinding((LinearLayout) view, button, button2, editText, editText2, editText3, editText4, imageView, imageView2, imageView3, imageView4, titleBar);
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
