package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class DrinkwaterPopupwindowsBinding implements ViewBinding {
    public final Button btn0;
    public final Button btn1;
    public final Button btn2;
    public final Button btn3;
    public final Button btn4;
    public final Button btn5;
    public final Button btn6;
    public final Button btn7;
    public final Button btn8;
    public final Button btn9;
    public final Button btnDot;
    public final Button btnHelp;
    public final Button btnSend;
    public final EditText etMoney;
    public final ImageButton ibExit;
    public final LinearLayout llDrinkwaterMoney;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private DrinkwaterPopupwindowsBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12, Button button13, EditText editText, ImageButton imageButton, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.btn0 = button;
        this.btn1 = button2;
        this.btn2 = button3;
        this.btn3 = button4;
        this.btn4 = button5;
        this.btn5 = button6;
        this.btn6 = button7;
        this.btn7 = button8;
        this.btn8 = button9;
        this.btn9 = button10;
        this.btnDot = button11;
        this.btnHelp = button12;
        this.btnSend = button13;
        this.etMoney = editText;
        this.ibExit = imageButton;
        this.llDrinkwaterMoney = linearLayout2;
    }

    public static DrinkwaterPopupwindowsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DrinkwaterPopupwindowsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.drinkwater_popupwindows, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DrinkwaterPopupwindowsBinding bind(View view) {
        int i = R.id.btn_0;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_1;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.btn_2;
                Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                if (button3 != null) {
                    i = R.id.btn_3;
                    Button button4 = (Button) ViewBindings.findChildViewById(view, i);
                    if (button4 != null) {
                        i = R.id.btn_4;
                        Button button5 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button5 != null) {
                            i = R.id.btn_5;
                            Button button6 = (Button) ViewBindings.findChildViewById(view, i);
                            if (button6 != null) {
                                i = R.id.btn_6;
                                Button button7 = (Button) ViewBindings.findChildViewById(view, i);
                                if (button7 != null) {
                                    i = R.id.btn_7;
                                    Button button8 = (Button) ViewBindings.findChildViewById(view, i);
                                    if (button8 != null) {
                                        i = R.id.btn_8;
                                        Button button9 = (Button) ViewBindings.findChildViewById(view, i);
                                        if (button9 != null) {
                                            i = R.id.btn_9;
                                            Button button10 = (Button) ViewBindings.findChildViewById(view, i);
                                            if (button10 != null) {
                                                i = R.id.btn_dot;
                                                Button button11 = (Button) ViewBindings.findChildViewById(view, i);
                                                if (button11 != null) {
                                                    i = R.id.btn_help;
                                                    Button button12 = (Button) ViewBindings.findChildViewById(view, i);
                                                    if (button12 != null) {
                                                        i = R.id.btn_send;
                                                        Button button13 = (Button) ViewBindings.findChildViewById(view, i);
                                                        if (button13 != null) {
                                                            i = R.id.et_money;
                                                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                            if (editText != null) {
                                                                i = R.id.ib_exit;
                                                                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
                                                                if (imageButton != null) {
                                                                    LinearLayout linearLayout = (LinearLayout) view;
                                                                    return new DrinkwaterPopupwindowsBinding(linearLayout, button, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, editText, imageButton, linearLayout);
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
