package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.LimitEditText;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivitySettingDeviceTwoBinding implements ViewBinding {
    public final EditText deviceEdit;
    public final LimitEditText deviceName;
    public final LimitEditText deviceName1;
    public final EditText initEdit;
    public final EditText moneyEdit;
    public final EditText numberEdit;
    public final EditText qvalueEdit;
    public final Button read;
    public final EditText reportEdit;
    private final RelativeLayout rootView;
    public final EditText speedEdit;
    public final TitleBar titleBar;
    public final Button write;
    public final Button writedevicename;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivitySettingDeviceTwoBinding(RelativeLayout relativeLayout, EditText editText, LimitEditText limitEditText, LimitEditText limitEditText2, EditText editText2, EditText editText3, EditText editText4, EditText editText5, Button button, EditText editText6, EditText editText7, TitleBar titleBar, Button button2, Button button3) {
        this.rootView = relativeLayout;
        this.deviceEdit = editText;
        this.deviceName = limitEditText;
        this.deviceName1 = limitEditText2;
        this.initEdit = editText2;
        this.moneyEdit = editText3;
        this.numberEdit = editText4;
        this.qvalueEdit = editText5;
        this.read = button;
        this.reportEdit = editText6;
        this.speedEdit = editText7;
        this.titleBar = titleBar;
        this.write = button2;
        this.writedevicename = button3;
    }

    public static ActivitySettingDeviceTwoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySettingDeviceTwoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_setting_device_two, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySettingDeviceTwoBinding bind(View view) {
        int i = R.id.device_edit;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = R.id.device_name;
            LimitEditText limitEditText = (LimitEditText) ViewBindings.findChildViewById(view, i);
            if (limitEditText != null) {
                i = R.id.device_name1;
                LimitEditText limitEditText2 = (LimitEditText) ViewBindings.findChildViewById(view, i);
                if (limitEditText2 != null) {
                    i = R.id.init_edit;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText2 != null) {
                        i = R.id.money_edit;
                        EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText3 != null) {
                            i = R.id.number_edit;
                            EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText4 != null) {
                                i = R.id.qvalue_edit;
                                EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText5 != null) {
                                    i = R.id.read;
                                    Button button = (Button) ViewBindings.findChildViewById(view, i);
                                    if (button != null) {
                                        i = R.id.report_edit;
                                        EditText editText6 = (EditText) ViewBindings.findChildViewById(view, i);
                                        if (editText6 != null) {
                                            i = R.id.speed_edit;
                                            EditText editText7 = (EditText) ViewBindings.findChildViewById(view, i);
                                            if (editText7 != null) {
                                                i = R.id.titleBar;
                                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                if (titleBar != null) {
                                                    i = R.id.write;
                                                    Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                                                    if (button2 != null) {
                                                        i = R.id.writedevicename;
                                                        Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                                                        if (button3 != null) {
                                                            return new ActivitySettingDeviceTwoBinding((RelativeLayout) view, editText, limitEditText, limitEditText2, editText2, editText3, editText4, editText5, button, editText6, editText7, titleBar, button2, button3);
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
