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
public final class ActivityV4AddRepairBinding implements ViewBinding {
    public final Button btnComplete;
    public final EditText etMobile;
    public final EditText etName;
    public final EditText etReport;
    public final RelativeLayout relSelectaddress;
    private final LinearLayout rootView;
    public final ScrollView scrollview;
    public final TitleBar titlebar;
    public final TextView tvAddress;
    public final TextView tvAppname;
    public final TextView tvMobile;
    public final TextView tvName;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4AddRepairBinding(LinearLayout linearLayout, Button button, EditText editText, EditText editText2, EditText editText3, RelativeLayout relativeLayout, ScrollView scrollView, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.btnComplete = button;
        this.etMobile = editText;
        this.etName = editText2;
        this.etReport = editText3;
        this.relSelectaddress = relativeLayout;
        this.scrollview = scrollView;
        this.titlebar = titleBar;
        this.tvAddress = textView;
        this.tvAppname = textView2;
        this.tvMobile = textView3;
        this.tvName = textView4;
    }

    public static ActivityV4AddRepairBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4AddRepairBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_add_repair, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4AddRepairBinding bind(View view) {
        int i = R.id.btn_complete;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_mobile;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.et_name;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = R.id.et_report;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText3 != null) {
                        i = R.id.rel_selectaddress;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = R.id.scrollview;
                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                            if (scrollView != null) {
                                i = R.id.titlebar;
                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                if (titleBar != null) {
                                    i = R.id.tv_address;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.tv_appname;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.tv_mobile;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.tv_name;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    return new ActivityV4AddRepairBinding((LinearLayout) view, button, editText, editText2, editText3, relativeLayout, scrollView, titleBar, textView, textView2, textView3, textView4);
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
