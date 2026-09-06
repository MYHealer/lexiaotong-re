package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityInitDeviceTwoBinding implements ViewBinding {
    public final TextView deviceTypeSpinner;
    public final RadioGroup radioGroup;
    public final RadioButton radioHas;
    public final RadioButton radioNo;
    private final LinearLayout rootView;
    public final TextView schollSpinner;
    public final ScrollView scrollview;
    public final TitleBar titleBar;
    public final TextView tvLine;
    public final TextView tvSchoolnametext;
    public final Button vBtnNext;
    public final EditText vEtAddress;
    public final EditText vEtAddress1;
    public final TextView vEtAddressTitle;
    public final EditText vEtAnzhuangAddress;
    public final TextView vEtAnzhuangAddressTitle;
    public final EditText vEtOwner;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityInitDeviceTwoBinding(LinearLayout linearLayout, TextView textView, RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2, TextView textView2, ScrollView scrollView, TitleBar titleBar, TextView textView3, TextView textView4, Button button, EditText editText, EditText editText2, TextView textView5, EditText editText3, TextView textView6, EditText editText4) {
        this.rootView = linearLayout;
        this.deviceTypeSpinner = textView;
        this.radioGroup = radioGroup;
        this.radioHas = radioButton;
        this.radioNo = radioButton2;
        this.schollSpinner = textView2;
        this.scrollview = scrollView;
        this.titleBar = titleBar;
        this.tvLine = textView3;
        this.tvSchoolnametext = textView4;
        this.vBtnNext = button;
        this.vEtAddress = editText;
        this.vEtAddress1 = editText2;
        this.vEtAddressTitle = textView5;
        this.vEtAnzhuangAddress = editText3;
        this.vEtAnzhuangAddressTitle = textView6;
        this.vEtOwner = editText4;
    }

    public static ActivityInitDeviceTwoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityInitDeviceTwoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_init_device_two, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityInitDeviceTwoBinding bind(View view) {
        int i = R.id.device_type_spinner;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.radio_group;
            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
            if (radioGroup != null) {
                i = R.id.radio_has;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                if (radioButton != null) {
                    i = R.id.radio_no;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                    if (radioButton2 != null) {
                        i = R.id.scholl_spinner;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.scrollview;
                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                            if (scrollView != null) {
                                i = R.id.titleBar;
                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                if (titleBar != null) {
                                    i = R.id.tv_line;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.tv_schoolnametext;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.v_btn_next;
                                            Button button = (Button) ViewBindings.findChildViewById(view, i);
                                            if (button != null) {
                                                i = R.id.v_et_address;
                                                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                if (editText != null) {
                                                    i = R.id.v_et_address1;
                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                                    if (editText2 != null) {
                                                        i = R.id.v_et_address_title;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.v_et_anzhuang_address;
                                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                                            if (editText3 != null) {
                                                                i = R.id.v_et_anzhuang_address_title;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView6 != null) {
                                                                    i = R.id.v_et_owner;
                                                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                    if (editText4 != null) {
                                                                        return new ActivityInitDeviceTwoBinding((LinearLayout) view, textView, radioGroup, radioButton, radioButton2, textView2, scrollView, titleBar, textView3, textView4, button, editText, editText2, textView5, editText3, textView6, editText4);
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
