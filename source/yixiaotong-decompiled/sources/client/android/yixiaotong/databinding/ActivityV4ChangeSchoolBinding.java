package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4ChangeSchoolBinding implements ViewBinding {
    public final RelativeLayout flContainer;
    public final ImageView ivScandevice;
    public final ImageView ivScanschoolqr;
    public final RelativeLayout relScanDeviceQrcode;
    public final RelativeLayout relScanqrcode;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvAdvname;
    public final TextView tvScandevice1;
    public final TextView tvScandeviceqrcode;
    public final TextView tvScanschoolqr;
    public final TextView tvScanschoolqrcode;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4ChangeSchoolBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.flContainer = relativeLayout;
        this.ivScandevice = imageView;
        this.ivScanschoolqr = imageView2;
        this.relScanDeviceQrcode = relativeLayout2;
        this.relScanqrcode = relativeLayout3;
        this.titleBar = titleBar;
        this.tvAdvname = textView;
        this.tvScandevice1 = textView2;
        this.tvScandeviceqrcode = textView3;
        this.tvScanschoolqr = textView4;
        this.tvScanschoolqrcode = textView5;
    }

    public static ActivityV4ChangeSchoolBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4ChangeSchoolBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_change_school, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4ChangeSchoolBinding bind(View view) {
        int i = R.id.flContainer;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.iv_scandevice;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_scanschoolqr;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.rel_scan_device_qrcode;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = R.id.rel_scanqrcode;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout3 != null) {
                            i = R.id.titleBar;
                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                            if (titleBar != null) {
                                i = R.id.tv_advname;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tv_scandevice1;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.tv_scandeviceqrcode;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.tv_scanschoolqr;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.tv_scanschoolqrcode;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    return new ActivityV4ChangeSchoolBinding((LinearLayout) view, relativeLayout, imageView, imageView2, relativeLayout2, relativeLayout3, titleBar, textView, textView2, textView3, textView4, textView5);
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
