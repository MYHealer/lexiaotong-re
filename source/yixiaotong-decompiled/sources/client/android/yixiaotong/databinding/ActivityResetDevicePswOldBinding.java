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
public final class ActivityResetDevicePswOldBinding implements ViewBinding {
    public final Button btnReset;
    public final EditText et1;
    public final EditText et10;
    public final EditText et2;
    public final EditText et3;
    public final EditText et4;
    public final EditText et5;
    public final EditText et6;
    public final EditText et7;
    public final EditText et8;
    public final EditText et9;
    public final RelativeLayout flContainer;
    public final LinearLayout lin;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvInputtip;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityResetDevicePswOldBinding(LinearLayout linearLayout, Button button, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, EditText editText8, EditText editText9, EditText editText10, RelativeLayout relativeLayout, LinearLayout linearLayout2, TitleBar titleBar, TextView textView) {
        this.rootView = linearLayout;
        this.btnReset = button;
        this.et1 = editText;
        this.et10 = editText2;
        this.et2 = editText3;
        this.et3 = editText4;
        this.et4 = editText5;
        this.et5 = editText6;
        this.et6 = editText7;
        this.et7 = editText8;
        this.et8 = editText9;
        this.et9 = editText10;
        this.flContainer = relativeLayout;
        this.lin = linearLayout2;
        this.titleBar = titleBar;
        this.tvInputtip = textView;
    }

    public static ActivityResetDevicePswOldBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityResetDevicePswOldBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_reset_device_psw_old, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityResetDevicePswOldBinding bind(View view) {
        int i = R.id.btn_reset;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et1;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et10;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.et2;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText3 != null) {
                        i = R.id.et3;
                        EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText4 != null) {
                            i = R.id.et4;
                            EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText5 != null) {
                                i = R.id.et5;
                                EditText editText6 = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText6 != null) {
                                    i = R.id.et6;
                                    EditText editText7 = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText7 != null) {
                                        i = R.id.et7;
                                        EditText editText8 = (EditText) ViewBindings.findChildViewById(view, i);
                                        if (editText8 != null) {
                                            i = R.id.et8;
                                            EditText editText9 = (EditText) ViewBindings.findChildViewById(view, i);
                                            if (editText9 != null) {
                                                i = R.id.et9;
                                                EditText editText10 = (EditText) ViewBindings.findChildViewById(view, i);
                                                if (editText10 != null) {
                                                    i = R.id.flContainer;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout != null) {
                                                        i = R.id.lin;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout != null) {
                                                            i = R.id.titleBar;
                                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                            if (titleBar != null) {
                                                                i = R.id.tv_inputtip;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView != null) {
                                                                    return new ActivityResetDevicePswOldBinding((LinearLayout) view, button, editText, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, relativeLayout, linearLayout, titleBar, textView);
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
