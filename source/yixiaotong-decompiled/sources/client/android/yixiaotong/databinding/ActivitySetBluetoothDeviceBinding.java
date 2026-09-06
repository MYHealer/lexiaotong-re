package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivitySetBluetoothDeviceBinding implements ViewBinding {
    public final Button btnSet;
    public final EditText etLimoney;
    public final EditText etMaichong;
    public final EditText etMaichongq;
    public final EditText etMaxmoney;
    public final EditText etMoney;
    public final EditText etShanqu;
    public final EditText etTime;
    public final EditText etType;
    public final View line1;
    public final View line111;
    public final View line1111;
    public final View line3;
    public final View line4;
    public final TextView litext;
    public final RelativeLayout relLimoney;
    public final RelativeLayout relMaxmoney;
    private final RelativeLayout rootView;
    public final TextView text;
    public final TextView text1;
    public final TextView text11;
    public final TextView text111;
    public final TextView text3;
    public final TextView text31;
    public final TextView text4;
    public final TextView text5;
    public final TextView text6;
    public final TextView text7;
    public final TextView text8;
    public final TitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivitySetBluetoothDeviceBinding(RelativeLayout relativeLayout, Button button, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, EditText editText8, View view, View view2, View view3, View view4, View view5, TextView textView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TitleBar titleBar) {
        this.rootView = relativeLayout;
        this.btnSet = button;
        this.etLimoney = editText;
        this.etMaichong = editText2;
        this.etMaichongq = editText3;
        this.etMaxmoney = editText4;
        this.etMoney = editText5;
        this.etShanqu = editText6;
        this.etTime = editText7;
        this.etType = editText8;
        this.line1 = view;
        this.line111 = view2;
        this.line1111 = view3;
        this.line3 = view4;
        this.line4 = view5;
        this.litext = textView;
        this.relLimoney = relativeLayout2;
        this.relMaxmoney = relativeLayout3;
        this.text = textView2;
        this.text1 = textView3;
        this.text11 = textView4;
        this.text111 = textView5;
        this.text3 = textView6;
        this.text31 = textView7;
        this.text4 = textView8;
        this.text5 = textView9;
        this.text6 = textView10;
        this.text7 = textView11;
        this.text8 = textView12;
        this.titleBar = titleBar;
    }

    public static ActivitySetBluetoothDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySetBluetoothDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_set_bluetooth_device, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySetBluetoothDeviceBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        int i = R.id.btn_set;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_limoney;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et_maichong;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.et_maichongq;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText3 != null) {
                        i = R.id.et_maxmoney;
                        EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText4 != null) {
                            i = R.id.et_money;
                            EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText5 != null) {
                                i = R.id.et_shanqu;
                                EditText editText6 = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText6 != null) {
                                    i = R.id.et_time;
                                    EditText editText7 = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText7 != null) {
                                        i = R.id.et_type;
                                        EditText editText8 = (EditText) ViewBindings.findChildViewById(view, i);
                                        if (editText8 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.line111))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.line1111))) != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.line3))) != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.line4))) != null) {
                                            i = R.id.litext;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = R.id.rel_limoney;
                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout != null) {
                                                    i = R.id.rel_maxmoney;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout2 != null) {
                                                        i = R.id.text;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView2 != null) {
                                                            i = R.id.text1;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView3 != null) {
                                                                i = R.id.text11;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView4 != null) {
                                                                    i = R.id.text111;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.text3;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.text31;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView7 != null) {
                                                                                i = R.id.text4;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.text5;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.text6;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView10 != null) {
                                                                                            i = R.id.text7;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView11 != null) {
                                                                                                i = R.id.text8;
                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView12 != null) {
                                                                                                    i = R.id.titleBar;
                                                                                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                                                    if (titleBar != null) {
                                                                                                        return new ActivitySetBluetoothDeviceBinding((RelativeLayout) view, button, editText, editText2, editText3, editText4, editText5, editText6, editText7, editText8, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, textView, relativeLayout, relativeLayout2, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, titleBar);
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
