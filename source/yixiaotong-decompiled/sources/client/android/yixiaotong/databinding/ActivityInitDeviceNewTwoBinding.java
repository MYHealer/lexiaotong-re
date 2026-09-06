package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityInitDeviceNewTwoBinding implements ViewBinding {
    public final TextView deviceTypeSpinner;
    public final TextView initTvBingRoom;
    public final RadioGroup radioGroup;
    public final RadioButton radioHas;
    public final RadioButton radioNo;
    public final RelativeLayout relDushu;
    public final RelativeLayout relName;
    public final RelativeLayout rlBindRoom;
    private final LinearLayout rootView;
    public final TextView schollSpinner;
    public final ScrollView scrollview;
    public final TitleBar titleBar;
    public final TextView tvChooseRoom;
    public final TextView tvLine;
    public final TextView tvSchoolnametext;
    public final Button vBtnNext;
    public final EditText vEtAddress;
    public final EditText vEtAddress1;
    public final TextView vEtAddressTitle;
    public final EditText vEtAnzhuangAddress;
    public final TextView vEtAnzhuangAddressTitle;
    public final EditText vEtDushu;
    public final EditText vEtOwner;
    public final TextView vTextDushu;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityInitDeviceNewTwoBinding(LinearLayout linearLayout, TextView textView, TextView textView2, RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView3, ScrollView scrollView, TitleBar titleBar, TextView textView4, TextView textView5, TextView textView6, Button button, EditText editText, EditText editText2, TextView textView7, EditText editText3, TextView textView8, EditText editText4, EditText editText5, TextView textView9) {
        this.rootView = linearLayout;
        this.deviceTypeSpinner = textView;
        this.initTvBingRoom = textView2;
        this.radioGroup = radioGroup;
        this.radioHas = radioButton;
        this.radioNo = radioButton2;
        this.relDushu = relativeLayout;
        this.relName = relativeLayout2;
        this.rlBindRoom = relativeLayout3;
        this.schollSpinner = textView3;
        this.scrollview = scrollView;
        this.titleBar = titleBar;
        this.tvChooseRoom = textView4;
        this.tvLine = textView5;
        this.tvSchoolnametext = textView6;
        this.vBtnNext = button;
        this.vEtAddress = editText;
        this.vEtAddress1 = editText2;
        this.vEtAddressTitle = textView7;
        this.vEtAnzhuangAddress = editText3;
        this.vEtAnzhuangAddressTitle = textView8;
        this.vEtDushu = editText4;
        this.vEtOwner = editText5;
        this.vTextDushu = textView9;
    }

    public static ActivityInitDeviceNewTwoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityInitDeviceNewTwoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_init_device_new_two, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityInitDeviceNewTwoBinding bind(View view) {
        int i = R.id.device_type_spinner;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.init_tv_bing_room;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.radio_group;
                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                if (radioGroup != null) {
                    i = R.id.radio_has;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                    if (radioButton != null) {
                        i = R.id.radio_no;
                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                        if (radioButton2 != null) {
                            i = R.id.rel_dushu;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout != null) {
                                i = R.id.rel_name;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout2 != null) {
                                    i = R.id.rl_bind_room;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout3 != null) {
                                        i = R.id.scholl_spinner;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.scrollview;
                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                            if (scrollView != null) {
                                                i = R.id.titleBar;
                                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                if (titleBar != null) {
                                                    i = R.id.tv_choose_room;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_line;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_schoolnametext;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
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
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView7 != null) {
                                                                                i = R.id.v_et_anzhuang_address;
                                                                                EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                if (editText3 != null) {
                                                                                    i = R.id.v_et_anzhuang_address_title;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.v_et_dushu;
                                                                                        EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                        if (editText4 != null) {
                                                                                            i = R.id.v_et_owner;
                                                                                            EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                            if (editText5 != null) {
                                                                                                i = R.id.v_text_dushu;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView9 != null) {
                                                                                                    return new ActivityInitDeviceNewTwoBinding((LinearLayout) view, textView, textView2, radioGroup, radioButton, radioButton2, relativeLayout, relativeLayout2, relativeLayout3, textView3, scrollView, titleBar, textView4, textView5, textView6, button, editText, editText2, textView7, editText3, textView8, editText4, editText5, textView9);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
