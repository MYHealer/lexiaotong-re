package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class WarningErrorTipLayoutBinding implements ViewBinding {
    public final ImageView ivError;
    public final RelativeLayout relWarningerror;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private WarningErrorTipLayoutBinding(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.ivError = imageView;
        this.relWarningerror = relativeLayout2;
    }

    public static WarningErrorTipLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WarningErrorTipLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.warning_error_tip_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static WarningErrorTipLayoutBinding bind(View view) {
        int i = R.id.iv_error;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            return new WarningErrorTipLayoutBinding(relativeLayout, imageView, relativeLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
