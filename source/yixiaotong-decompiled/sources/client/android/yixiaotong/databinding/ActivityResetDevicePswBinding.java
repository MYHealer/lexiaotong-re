package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityResetDevicePswBinding implements ViewBinding {
    public final Button btnReset;
    public final EditText et10;
    public final EditText et5;
    public final EditText et6;
    public final EditText et7;
    public final EditText et8;
    public final EditText et9;
    public final RelativeLayout flContainer;
    public final LinearLayout lin;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvAdvname;
    public final TextView tvInputtip;
    public final TextView tvPwstip;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityResetDevicePswBinding(LinearLayout linearLayout, Button button, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, RelativeLayout relativeLayout, LinearLayout linearLayout2, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnReset = button;
        this.et10 = editText;
        this.et5 = editText2;
        this.et6 = editText3;
        this.et7 = editText4;
        this.et8 = editText5;
        this.et9 = editText6;
        this.flContainer = relativeLayout;
        this.lin = linearLayout2;
        this.titleBar = titleBar;
        this.tvAdvname = textView;
        this.tvInputtip = textView2;
        this.tvPwstip = textView3;
    }

    public static ActivityResetDevicePswBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityResetDevicePswBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_reset_device_psw, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityResetDevicePswBinding bind(View view) {
        int i = R.id.btn_reset;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et10;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et5;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.et6;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText3 != null) {
                        i = R.id.et7;
                        EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText4 != null) {
                            i = R.id.et8;
                            EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText5 != null) {
                                i = R.id.et9;
                                EditText editText6 = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText6 != null) {
                                    i = R.id.flContainer;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout != null) {
                                        i = R.id.lin;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout != null) {
                                            i = R.id.titleBar;
                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                            if (titleBar != null) {
                                                i = R.id.tv_advname;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = R.id.tv_inputtip;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R.id.tv_pwstip;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            return new ActivityResetDevicePswBinding((LinearLayout) view, button, editText, editText2, editText3, editText4, editText5, editText6, relativeLayout, linearLayout, titleBar, textView, textView2, textView3);
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
