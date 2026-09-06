package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityScanQrcodeBinding implements ViewBinding {
    public final ImageView captureScanLine;
    public final ImageView flushBtn;
    public final ImageView imgBtn;
    public final FrameLayout rim;
    private final FrameLayout rootView;
    public final ImageView scanArea;
    public final TitleBar titleBar;
    public final TextView tvScantip;

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    private ActivityScanQrcodeBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, FrameLayout frameLayout2, ImageView imageView4, TitleBar titleBar, TextView textView) {
        this.rootView = frameLayout;
        this.captureScanLine = imageView;
        this.flushBtn = imageView2;
        this.imgBtn = imageView3;
        this.rim = frameLayout2;
        this.scanArea = imageView4;
        this.titleBar = titleBar;
        this.tvScantip = textView;
    }

    public static ActivityScanQrcodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityScanQrcodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_scan_qrcode, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityScanQrcodeBinding bind(View view) {
        int i = R.id.capture_scan_line;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.flush_btn;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.img_btn;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.rim;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = R.id.scan_area;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = R.id.titleBar;
                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                            if (titleBar != null) {
                                i = R.id.tv_scantip;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    return new ActivityScanQrcodeBinding((FrameLayout) view, imageView, imageView2, imageView3, frameLayout, imageView4, titleBar, textView);
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
