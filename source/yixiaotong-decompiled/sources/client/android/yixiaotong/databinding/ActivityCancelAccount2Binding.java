package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityCancelAccount2Binding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    private final LinearLayout rootView;
    public final TitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityCancelAccount2Binding(LinearLayout linearLayout, Button button, Button button2, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.titleBar = titleBar;
    }

    public static ActivityCancelAccount2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityCancelAccount2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_cancel_account2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCancelAccount2Binding bind(View view) {
        int i = R.id.btn_cancel;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btn_confirm;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.titleBar;
                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                if (titleBar != null) {
                    return new ActivityCancelAccount2Binding((LinearLayout) view, button, button2, titleBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
