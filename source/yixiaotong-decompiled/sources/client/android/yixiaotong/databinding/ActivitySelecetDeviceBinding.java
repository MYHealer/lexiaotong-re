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
public final class ActivitySelecetDeviceBinding implements ViewBinding {
    public final ImageView ivScandevice;
    public final ImageView ivScanschoolqr;
    public final RelativeLayout relScanDeviceQrcode;
    public final RelativeLayout relSelectaddress;
    private final LinearLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvScandevice1;
    public final TextView tvScandeviceqrcode;
    public final TextView tvScanschoolqr;
    public final TextView tvScanschoolqrcode;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivitySelecetDeviceBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.ivScandevice = imageView;
        this.ivScanschoolqr = imageView2;
        this.relScanDeviceQrcode = relativeLayout;
        this.relSelectaddress = relativeLayout2;
        this.titleBar = titleBar;
        this.tvScandevice1 = textView;
        this.tvScandeviceqrcode = textView2;
        this.tvScanschoolqr = textView3;
        this.tvScanschoolqrcode = textView4;
    }

    public static ActivitySelecetDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySelecetDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_selecet_device, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySelecetDeviceBinding bind(View view) {
        int i = R.id.iv_scandevice;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_scanschoolqr;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.rel_scan_device_qrcode;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.rel_selectaddress;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = R.id.titleBar;
                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                        if (titleBar != null) {
                            i = R.id.tv_scandevice1;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tv_scandeviceqrcode;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.tv_scanschoolqr;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.tv_scanschoolqrcode;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            return new ActivitySelecetDeviceBinding((LinearLayout) view, imageView, imageView2, relativeLayout, relativeLayout2, titleBar, textView, textView2, textView3, textView4);
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
