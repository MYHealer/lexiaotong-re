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
public final class ActivityWashInitBinding implements ViewBinding {
    public final Button btnInit;
    public final EditText editAddress;
    public final EditText editBluename;
    private final LinearLayout rootView;
    public final TextView tvInvestorid;
    public final TextView tvLine;
    public final TextView tvMachineid;
    public final TextView tvSchoolid;
    public final TextView tvTypeid;
    public final EditText vEtAddress;
    public final EditText vEtAddress1;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityWashInitBinding(LinearLayout linearLayout, Button button, EditText editText, EditText editText2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, EditText editText3, EditText editText4, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.btnInit = button;
        this.editAddress = editText;
        this.editBluename = editText2;
        this.tvInvestorid = textView;
        this.tvLine = textView2;
        this.tvMachineid = textView3;
        this.tvSchoolid = textView4;
        this.tvTypeid = textView5;
        this.vEtAddress = editText3;
        this.vEtAddress1 = editText4;
        this.vTitleBar = titleBar;
    }

    public static ActivityWashInitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWashInitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_wash_init, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWashInitBinding bind(View view) {
        int i = R.id.btn_init;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.edit_address;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.edit_bluename;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.tv_investorid;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tv_line;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_machineid;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.tv_schoolid;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.tv_typeid;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.v_et_address;
                                        EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                        if (editText3 != null) {
                                            i = R.id.v_et_address1;
                                            EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                                            if (editText4 != null) {
                                                i = R.id.v_titleBar;
                                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                if (titleBar != null) {
                                                    return new ActivityWashInitBinding((LinearLayout) view, button, editText, editText2, textView, textView2, textView3, textView4, textView5, editText3, editText4, titleBar);
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
