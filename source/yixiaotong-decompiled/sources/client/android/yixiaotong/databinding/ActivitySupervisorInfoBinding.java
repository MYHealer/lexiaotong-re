package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivitySupervisorInfoBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnChange;
    private final RelativeLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvName;
    public final TextView tvPhone;
    public final TextView tvRefund;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivitySupervisorInfoBinding(RelativeLayout relativeLayout, Button button, Button button2, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.btnCancel = button;
        this.btnChange = button2;
        this.titleBar = titleBar;
        this.tvName = textView;
        this.tvPhone = textView2;
        this.tvRefund = textView3;
    }

    public static ActivitySupervisorInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySupervisorInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_supervisor_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySupervisorInfoBinding bind(View view) {
        int i = R.id.btn_cancel;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_change;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.titleBar;
                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                if (titleBar != null) {
                    i = R.id.tv_name;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tv_phone;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_refund;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new ActivitySupervisorInfoBinding((RelativeLayout) view, button, button2, titleBar, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
