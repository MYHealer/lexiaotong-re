package client.android.yixiaotong.ui.drinkwater;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import client.android.yixiaotong.R;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SelectPicPopupWindow extends PopupWindow {
    public static EditText etMoney;
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private final Button btn_dot;
    private final Button btn_help;
    private final Button btn_send;
    private final ImageButton ib_exit;
    private View mMenuView;

    public SelectPicPopupWindow(Activity activity, View.OnClickListener onClickListener) {
        super(activity);
        View viewInflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.drinkwater_popupwindows, (ViewGroup) null);
        this.mMenuView = viewInflate;
        Button button = (Button) viewInflate.findViewById(R.id.btn_send);
        this.btn_send = button;
        Button button2 = (Button) this.mMenuView.findViewById(R.id.btn_help);
        this.btn_help = button2;
        this.btn_1 = (Button) this.mMenuView.findViewById(R.id.btn_1);
        this.btn_2 = (Button) this.mMenuView.findViewById(R.id.btn_2);
        this.btn_3 = (Button) this.mMenuView.findViewById(R.id.btn_3);
        this.btn_4 = (Button) this.mMenuView.findViewById(R.id.btn_4);
        this.btn_5 = (Button) this.mMenuView.findViewById(R.id.btn_5);
        this.btn_6 = (Button) this.mMenuView.findViewById(R.id.btn_6);
        this.btn_7 = (Button) this.mMenuView.findViewById(R.id.btn_7);
        this.btn_8 = (Button) this.mMenuView.findViewById(R.id.btn_8);
        this.btn_9 = (Button) this.mMenuView.findViewById(R.id.btn_9);
        this.btn_0 = (Button) this.mMenuView.findViewById(R.id.btn_0);
        ImageButton imageButton = (ImageButton) this.mMenuView.findViewById(R.id.ib_exit);
        this.ib_exit = imageButton;
        Button button3 = (Button) this.mMenuView.findViewById(R.id.btn_dot);
        this.btn_dot = button3;
        etMoney = (EditText) this.mMenuView.findViewById(R.id.et_money);
        disableShowSoftInput();
        etMoney.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.drinkwater.SelectPicPopupWindow.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.toString().contains(".") && (charSequence.length() - 1) - charSequence.toString().indexOf(".") > 2) {
                    charSequence = charSequence.toString().subSequence(0, charSequence.toString().indexOf(".") + 3);
                    SelectPicPopupWindow.etMoney.setText(charSequence);
                    SelectPicPopupWindow.etMoney.setSelection(charSequence.length());
                }
                if (charSequence.toString().trim().substring(0).equals(".")) {
                    charSequence = "0" + ((Object) charSequence);
                    SelectPicPopupWindow.etMoney.setText(charSequence);
                    SelectPicPopupWindow.etMoney.setSelection(2);
                }
                if (!charSequence.toString().startsWith("0") || charSequence.toString().trim().length() <= 1 || charSequence.toString().substring(1, 2).equals(".")) {
                    return;
                }
                SelectPicPopupWindow.etMoney.setText(charSequence.subSequence(0, 1));
                SelectPicPopupWindow.etMoney.setSelection(1);
            }
        });
        etMoney.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.drinkwater.SelectPicPopupWindow.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.toString().contains(".") && (charSequence.length() - 1) - charSequence.toString().indexOf(".") > 2) {
                    charSequence = charSequence.toString().subSequence(0, charSequence.toString().indexOf(".") + 3);
                    SelectPicPopupWindow.etMoney.setText(charSequence);
                    SelectPicPopupWindow.etMoney.setSelection(charSequence.length());
                }
                if (charSequence.toString().trim().substring(0).equals(".")) {
                    charSequence = "0" + ((Object) charSequence);
                    SelectPicPopupWindow.etMoney.setText(charSequence);
                    SelectPicPopupWindow.etMoney.setSelection(2);
                }
                if (!charSequence.toString().startsWith("0") || charSequence.toString().trim().length() <= 1 || charSequence.toString().substring(1, 2).equals(".")) {
                    return;
                }
                SelectPicPopupWindow.etMoney.setText(charSequence.subSequence(0, 1));
                SelectPicPopupWindow.etMoney.setSelection(1);
            }
        });
        this.btn_1.setOnClickListener(onClickListener);
        this.btn_2.setOnClickListener(onClickListener);
        this.btn_3.setOnClickListener(onClickListener);
        this.btn_4.setOnClickListener(onClickListener);
        this.btn_5.setOnClickListener(onClickListener);
        this.btn_6.setOnClickListener(onClickListener);
        this.btn_7.setOnClickListener(onClickListener);
        this.btn_8.setOnClickListener(onClickListener);
        this.btn_9.setOnClickListener(onClickListener);
        this.btn_0.setOnClickListener(onClickListener);
        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        imageButton.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        setContentView(this.mMenuView);
        setWidth(-1);
        setHeight(((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getHeight() / 3);
        setFocusable(true);
        setAnimationStyle(R.style.AnimBottom);
        setBackgroundDrawable(new ColorDrawable(-1));
        this.mMenuView.setOnTouchListener(new View.OnTouchListener() { // from class: client.android.yixiaotong.ui.drinkwater.SelectPicPopupWindow.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int top = SelectPicPopupWindow.this.mMenuView.findViewById(R.id.ll_drinkwater_money).getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 1 && y < top) {
                    SelectPicPopupWindow.this.dismiss();
                }
                return true;
            }
        });
    }

    public void disableShowSoftInput() {
        try {
            Method method = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(etMoney, false);
        } catch (Exception unused) {
        }
        try {
            Method method2 = EditText.class.getMethod("setSoftInputShownOnFocus", Boolean.TYPE);
            method2.setAccessible(true);
            method2.invoke(etMoney, false);
        } catch (Exception unused2) {
        }
    }
}
