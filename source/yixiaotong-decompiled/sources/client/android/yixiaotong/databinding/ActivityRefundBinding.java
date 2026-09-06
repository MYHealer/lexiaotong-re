package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.CrossEditText;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityRefundBinding implements ViewBinding {
    public final CrossEditText etAliaccount;
    public final CrossEditText etPhone;
    private final LinearLayout rootView;
    public final TitleBar vTitleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityRefundBinding(LinearLayout linearLayout, CrossEditText crossEditText, CrossEditText crossEditText2, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.etAliaccount = crossEditText;
        this.etPhone = crossEditText2;
        this.vTitleBar = titleBar;
    }

    public static ActivityRefundBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRefundBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_refund, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRefundBinding bind(View view) {
        int i = R.id.et_aliaccount;
        CrossEditText crossEditText = (CrossEditText) ViewBindings.findChildViewById(view, i);
        if (crossEditText != null) {
            i = R.id.et_phone;
            CrossEditText crossEditText2 = (CrossEditText) ViewBindings.findChildViewById(view, i);
            if (crossEditText2 != null) {
                i = R.id.v_titleBar;
                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                if (titleBar != null) {
                    return new ActivityRefundBinding((LinearLayout) view, crossEditText, crossEditText2, titleBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
