package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityInitAmmeterBinding implements ViewBinding {
    public final Spinner deviceTypeSpinner;
    public final EditText etInitmoney;
    public final ImageView imgAddress;
    public final ImageView ivArrow1;
    public final ImageView ivArrow10;
    public final ImageView ivArrow11;
    public final ImageView ivArrow2;
    public final ImageView ivArrow3;
    public final RelativeLayout relAddress;
    private final LinearLayout rootView;
    public final Spinner schollSpinner;
    public final TitleBar titleBar;
    public final TextView tvAddress;
    public final TextView tvInitmomey;
    public final Spinner useTypeSpinner;
    public final Button vBtnNext;
    public final TextView vEtAddress;
    public final EditText vEtOwner;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityInitAmmeterBinding(LinearLayout linearLayout, Spinner spinner, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, RelativeLayout relativeLayout, Spinner spinner2, TitleBar titleBar, TextView textView, TextView textView2, Spinner spinner3, Button button, TextView textView3, EditText editText2) {
        this.rootView = linearLayout;
        this.deviceTypeSpinner = spinner;
        this.etInitmoney = editText;
        this.imgAddress = imageView;
        this.ivArrow1 = imageView2;
        this.ivArrow10 = imageView3;
        this.ivArrow11 = imageView4;
        this.ivArrow2 = imageView5;
        this.ivArrow3 = imageView6;
        this.relAddress = relativeLayout;
        this.schollSpinner = spinner2;
        this.titleBar = titleBar;
        this.tvAddress = textView;
        this.tvInitmomey = textView2;
        this.useTypeSpinner = spinner3;
        this.vBtnNext = button;
        this.vEtAddress = textView3;
        this.vEtOwner = editText2;
    }

    public static ActivityInitAmmeterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityInitAmmeterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_init_ammeter, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityInitAmmeterBinding bind(View view) {
        int i = R.id.device_type_spinner;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, i);
        if (spinner != null) {
            i = R.id.et_initmoney;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.img_address;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.iv_arrow1;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.iv_arrow10;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.iv_arrow11;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView4 != null) {
                                i = R.id.iv_arrow2;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView5 != null) {
                                    i = R.id.iv_arrow3;
                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView6 != null) {
                                        i = R.id.rel_address;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout != null) {
                                            i = R.id.scholl_spinner;
                                            Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, i);
                                            if (spinner2 != null) {
                                                i = R.id.titleBar;
                                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                if (titleBar != null) {
                                                    i = R.id.tv_address;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView != null) {
                                                        i = R.id.tv_initmomey;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView2 != null) {
                                                            i = R.id.use_type_spinner;
                                                            Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(view, i);
                                                            if (spinner3 != null) {
                                                                i = R.id.v_btn_next;
                                                                Button button = (Button) ViewBindings.findChildViewById(view, i);
                                                                if (button != null) {
                                                                    i = R.id.v_et_address;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView3 != null) {
                                                                        i = R.id.v_et_owner;
                                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                        if (editText2 != null) {
                                                                            return new ActivityInitAmmeterBinding((LinearLayout) view, spinner, editText, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, relativeLayout, spinner2, titleBar, textView, textView2, spinner3, button, textView3, editText2);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
