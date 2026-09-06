package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivitySettingAmmeterBinding implements ViewBinding {
    public final TextView blanceText;
    public final TextView calendarStateText;
    public final TextView cellStateText;
    public final TextView dateText;
    public final TextView deviceNOText;
    public final TextView deviceText;
    public final TextView deviceTypeText;
    public final TextView electricityconsumptionText;
    public final EditText electrovalenceEdit;
    public final Button getTimeBtn;
    public final TextView powerDirectionalStateText;
    public final Button read;
    public final TextView relayStateText;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView userNOText;
    public final TextView userStateText;
    public final Button write;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivitySettingAmmeterBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, EditText editText, Button button, TextView textView9, Button button2, TextView textView10, TitleBar titleBar, TextView textView11, TextView textView12, Button button3) {
        this.rootView = linearLayout;
        this.blanceText = textView;
        this.calendarStateText = textView2;
        this.cellStateText = textView3;
        this.dateText = textView4;
        this.deviceNOText = textView5;
        this.deviceText = textView6;
        this.deviceTypeText = textView7;
        this.electricityconsumptionText = textView8;
        this.electrovalenceEdit = editText;
        this.getTimeBtn = button;
        this.powerDirectionalStateText = textView9;
        this.read = button2;
        this.relayStateText = textView10;
        this.titleBar = titleBar;
        this.userNOText = textView11;
        this.userStateText = textView12;
        this.write = button3;
    }

    public static ActivitySettingAmmeterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySettingAmmeterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_setting_ammeter, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySettingAmmeterBinding bind(View view) {
        int i = R.id.blance_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.calendar_state_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.cell_state_text;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.date_text;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.deviceNO_text;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView5 != null) {
                            i = R.id.device_text;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView6 != null) {
                                i = R.id.device_type_text;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView7 != null) {
                                    i = R.id.electricityconsumption_text;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView8 != null) {
                                        i = R.id.electrovalence_edit;
                                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                        if (editText != null) {
                                            i = R.id.getTime_btn;
                                            Button button = (Button) ViewBindings.findChildViewById(view, i);
                                            if (button != null) {
                                                i = R.id.power_directional_state_text;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView9 != null) {
                                                    i = R.id.read;
                                                    Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                                                    if (button2 != null) {
                                                        i = R.id.relay_state_text;
                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView10 != null) {
                                                            i = R.id.titleBar;
                                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                            if (titleBar != null) {
                                                                i = R.id.userNO_text;
                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView11 != null) {
                                                                    i = R.id.user_state_text;
                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView12 != null) {
                                                                        i = R.id.write;
                                                                        Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                                                                        if (button3 != null) {
                                                                            return new ActivitySettingAmmeterBinding((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, editText, button, textView9, button2, textView10, titleBar, textView11, textView12, button3);
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
