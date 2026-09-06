package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityInformationPermissionsBinding implements ViewBinding {
    public final RelativeLayout relAccountinfo;
    public final RelativeLayout relDeviceinfo;
    public final RelativeLayout relPersoninfo;
    private final LinearLayout rootView;
    public final TitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityInformationPermissionsBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.relAccountinfo = relativeLayout;
        this.relDeviceinfo = relativeLayout2;
        this.relPersoninfo = relativeLayout3;
        this.titleBar = titleBar;
    }

    public static ActivityInformationPermissionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityInformationPermissionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_information_permissions, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityInformationPermissionsBinding bind(View view) {
        int i = R.id.rel_accountinfo;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.rel_deviceinfo;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout2 != null) {
                i = R.id.rel_personinfo;
                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout3 != null) {
                    i = R.id.titleBar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        return new ActivityInformationPermissionsBinding((LinearLayout) view, relativeLayout, relativeLayout2, relativeLayout3, titleBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
