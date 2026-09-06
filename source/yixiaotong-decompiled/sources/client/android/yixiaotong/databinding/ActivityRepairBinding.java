package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityRepairBinding implements ViewBinding {
    public final Button btnComplete;
    public final EditText etAddress;
    public final EditText etDeviceno;
    public final EditText etMobile;
    public final EditText etReport;
    public final LinearLayout lin;
    public final RelativeLayout relSelecttype;
    private final LinearLayout rootView;
    public final ScrollView scrollview;
    public final TitleBar titleBar;
    public final TextView tvAddress;
    public final TextView tvAppname;
    public final TextView tvDeviceno;
    public final TextView tvMobile;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityRepairBinding(LinearLayout linearLayout, Button button, EditText editText, EditText editText2, EditText editText3, EditText editText4, LinearLayout linearLayout2, RelativeLayout relativeLayout, ScrollView scrollView, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.btnComplete = button;
        this.etAddress = editText;
        this.etDeviceno = editText2;
        this.etMobile = editText3;
        this.etReport = editText4;
        this.lin = linearLayout2;
        this.relSelecttype = relativeLayout;
        this.scrollview = scrollView;
        this.titleBar = titleBar;
        this.tvAddress = textView;
        this.tvAppname = textView2;
        this.tvDeviceno = textView3;
        this.tvMobile = textView4;
    }

    public static ActivityRepairBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRepairBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_repair, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRepairBinding bind(View view) {
        int i = R.id.btn_complete;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_address;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et_deviceno;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.et_mobile;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText3 != null) {
                        i = R.id.et_report;
                        EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText4 != null) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            i = R.id.rel_selecttype;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout != null) {
                                i = R.id.scrollview;
                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                if (scrollView != null) {
                                    i = R.id.titleBar;
                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                    if (titleBar != null) {
                                        i = R.id.tv_address;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.tv_appname;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.tv_deviceno;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.tv_mobile;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        return new ActivityRepairBinding(linearLayout, button, editText, editText2, editText3, editText4, linearLayout, relativeLayout, scrollView, titleBar, textView, textView2, textView3, textView4);
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
