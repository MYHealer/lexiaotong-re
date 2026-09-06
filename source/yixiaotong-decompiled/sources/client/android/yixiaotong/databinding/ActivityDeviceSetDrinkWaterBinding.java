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
public final class ActivityDeviceSetDrinkWaterBinding implements ViewBinding {
    public final Button btn;
    public final EditText etLimoney;
    public final EditText etLimoney2;
    public final EditText etMaichong;
    public final EditText etMaichong1;
    public final EditText etMaichongq;
    public final EditText etMaxmoney;
    public final EditText etMoney;
    public final EditText etMoney1;
    public final EditText etShanqu;
    public final EditText etTime;
    public final EditText etType;
    public final View line1;
    public final View line11;
    public final View line111;
    public final View line1111;
    public final View line3;
    public final View line4;
    public final TextView litext;
    public final RelativeLayout relColdfeilv;
    private final RelativeLayout rootView;
    public final TitleBar tbName;
    public final TextView text;
    public final TextView text1;
    public final TextView text11;
    public final TextView text111;
    public final TextView text2;
    public final TextView text3;
    public final TextView text4;
    public final TextView text5;
    public final TextView text6;
    public final TextView text61;
    public final TextView text7;
    public final TextView text71;
    public final TextView text8;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityDeviceSetDrinkWaterBinding(RelativeLayout relativeLayout, Button button, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, EditText editText8, EditText editText9, EditText editText10, EditText editText11, View view, View view2, View view3, View view4, View view5, View view6, TextView textView, RelativeLayout relativeLayout2, TitleBar titleBar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        this.rootView = relativeLayout;
        this.btn = button;
        this.etLimoney = editText;
        this.etLimoney2 = editText2;
        this.etMaichong = editText3;
        this.etMaichong1 = editText4;
        this.etMaichongq = editText5;
        this.etMaxmoney = editText6;
        this.etMoney = editText7;
        this.etMoney1 = editText8;
        this.etShanqu = editText9;
        this.etTime = editText10;
        this.etType = editText11;
        this.line1 = view;
        this.line11 = view2;
        this.line111 = view3;
        this.line1111 = view4;
        this.line3 = view5;
        this.line4 = view6;
        this.litext = textView;
        this.relColdfeilv = relativeLayout2;
        this.tbName = titleBar;
        this.text = textView2;
        this.text1 = textView3;
        this.text11 = textView4;
        this.text111 = textView5;
        this.text2 = textView6;
        this.text3 = textView7;
        this.text4 = textView8;
        this.text5 = textView9;
        this.text6 = textView10;
        this.text61 = textView11;
        this.text7 = textView12;
        this.text71 = textView13;
        this.text8 = textView14;
    }

    public static ActivityDeviceSetDrinkWaterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDeviceSetDrinkWaterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_device_set_drink_water, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDeviceSetDrinkWaterBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        View viewFindChildViewById6;
        int i = R.id.btn;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_limoney;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et_limoney2;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.et_maichong;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText3 != null) {
                        i = R.id.et_maichong1;
                        EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText4 != null) {
                            i = R.id.et_maichongq;
                            EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText5 != null) {
                                i = R.id.et_maxmoney;
                                EditText editText6 = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText6 != null) {
                                    i = R.id.et_money;
                                    EditText editText7 = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText7 != null) {
                                        i = R.id.et_money1;
                                        EditText editText8 = (EditText) ViewBindings.findChildViewById(view, i);
                                        if (editText8 != null) {
                                            i = R.id.et_shanqu;
                                            EditText editText9 = (EditText) ViewBindings.findChildViewById(view, i);
                                            if (editText9 != null) {
                                                i = R.id.et_time;
                                                EditText editText10 = (EditText) ViewBindings.findChildViewById(view, i);
                                                if (editText10 != null) {
                                                    i = R.id.et_type;
                                                    EditText editText11 = (EditText) ViewBindings.findChildViewById(view, i);
                                                    if (editText11 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.line1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.line11))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.line111))) != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.line1111))) != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.line3))) != null && (viewFindChildViewById6 = ViewBindings.findChildViewById(view, (i = R.id.line4))) != null) {
                                                        i = R.id.litext;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView != null) {
                                                            i = R.id.rel_coldfeilv;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout != null) {
                                                                i = R.id.tb_name;
                                                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                if (titleBar != null) {
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
                                                                                    i = R.id.text2;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.text3;
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
                                                                                                        i = R.id.text61;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView11 != null) {
                                                                                                            i = R.id.text7;
                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView12 != null) {
                                                                                                                i = R.id.text71;
                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView13 != null) {
                                                                                                                    i = R.id.text8;
                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView14 != null) {
                                                                                                                        return new ActivityDeviceSetDrinkWaterBinding((RelativeLayout) view, button, editText, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6, textView, relativeLayout, titleBar, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
