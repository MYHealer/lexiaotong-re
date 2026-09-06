package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityInitDeviceV1Binding implements ViewBinding {
    public final TextView deviceTypeSpinner;
    public final TextView initTvBing;
    public final TextView initTvBingRoom;
    public final ImageView ivArrow9;
    public final RadioButton radio;
    public final RadioButton radio1;
    public final RadioGroup radiogroud;
    public final RelativeLayout relDushu;
    public final RelativeLayout relName;
    public final RelativeLayout rlBind;
    public final RelativeLayout rlBindRoom;
    private final RelativeLayout rootView;
    public final Spinner schollSpinner;
    public final TitleBar titleBar;
    public final TextView tvChooseRoom;
    public final TextView tvLine;
    public final Button vBtnNext;
    public final EditText vEtAddress;
    public final EditText vEtAddress1;
    public final TextView vEtAddressTitle;
    public final TextView vEtAnzhuangAddressTitle;
    public final EditText vEtDevicename;
    public final EditText vEtDushu;
    public final EditText vEtOwner;
    public final TextView vTextDushu;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityInitDeviceV1Binding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, Spinner spinner, TitleBar titleBar, TextView textView4, TextView textView5, Button button, EditText editText, EditText editText2, TextView textView6, TextView textView7, EditText editText3, EditText editText4, EditText editText5, TextView textView8) {
        this.rootView = relativeLayout;
        this.deviceTypeSpinner = textView;
        this.initTvBing = textView2;
        this.initTvBingRoom = textView3;
        this.ivArrow9 = imageView;
        this.radio = radioButton;
        this.radio1 = radioButton2;
        this.radiogroud = radioGroup;
        this.relDushu = relativeLayout2;
        this.relName = relativeLayout3;
        this.rlBind = relativeLayout4;
        this.rlBindRoom = relativeLayout5;
        this.schollSpinner = spinner;
        this.titleBar = titleBar;
        this.tvChooseRoom = textView4;
        this.tvLine = textView5;
        this.vBtnNext = button;
        this.vEtAddress = editText;
        this.vEtAddress1 = editText2;
        this.vEtAddressTitle = textView6;
        this.vEtAnzhuangAddressTitle = textView7;
        this.vEtDevicename = editText3;
        this.vEtDushu = editText4;
        this.vEtOwner = editText5;
        this.vTextDushu = textView8;
    }

    public static ActivityInitDeviceV1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityInitDeviceV1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_init_device_v1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityInitDeviceV1Binding bind(View view) {
        int i = R.id.device_type_spinner;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.init_tv_bing;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.init_tv_bing_room;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.iv_arrow9;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.radio;
                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                        if (radioButton != null) {
                            i = R.id.radio1;
                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                            if (radioButton2 != null) {
                                i = R.id.radiogroud;
                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                                if (radioGroup != null) {
                                    i = R.id.rel_dushu;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout != null) {
                                        i = R.id.rel_name;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout2 != null) {
                                            i = R.id.rl_bind;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout3 != null) {
                                                i = R.id.rl_bind_room;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout4 != null) {
                                                    i = R.id.scholl_spinner;
                                                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, i);
                                                    if (spinner != null) {
                                                        i = R.id.titleBar;
                                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                        if (titleBar != null) {
                                                            i = R.id.tv_choose_room;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_line;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
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
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.v_et_anzhuang_address_title;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.v_et_devicename;
                                                                                        EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                        if (editText3 != null) {
                                                                                            i = R.id.v_et_dushu;
                                                                                            EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                            if (editText4 != null) {
                                                                                                i = R.id.v_et_owner;
                                                                                                EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                                if (editText5 != null) {
                                                                                                    i = R.id.v_text_dushu;
                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView8 != null) {
                                                                                                        return new ActivityInitDeviceV1Binding((RelativeLayout) view, textView, textView2, textView3, imageView, radioButton, radioButton2, radioGroup, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, spinner, titleBar, textView4, textView5, button, editText, editText2, textView6, textView7, editText3, editText4, editText5, textView8);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
