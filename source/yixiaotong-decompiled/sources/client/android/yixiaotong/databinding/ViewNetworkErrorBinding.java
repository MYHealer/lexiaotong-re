package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ViewNetworkErrorBinding implements ViewBinding {
    public final Button btnReload;
    public final LinearLayout llError;
    private final LinearLayout rootView;
    public final TextView tvErrortip;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ViewNetworkErrorBinding(LinearLayout linearLayout, Button button, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.btnReload = button;
        this.llError = linearLayout2;
        this.tvErrortip = textView;
    }

    public static ViewNetworkErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewNetworkErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_network_error, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewNetworkErrorBinding bind(View view) {
        int i = R.id.btn_reload;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i2 = R.id.tv_errortip;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i2);
            if (textView != null) {
                return new ViewNetworkErrorBinding(linearLayout, button, linearLayout, textView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
