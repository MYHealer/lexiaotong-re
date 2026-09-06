package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityBitmapScanQrcodeBinding implements ViewBinding {
    public final ImageView backImg;
    public final ImageView imgBtn;
    public final FrameLayout rim;
    private final FrameLayout rootView;
    public final ImageView scanArs;
    public final TextView scanTip;
    public final SurfaceView surfaceView;

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    private ActivityBitmapScanQrcodeBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, FrameLayout frameLayout2, ImageView imageView3, TextView textView, SurfaceView surfaceView) {
        this.rootView = frameLayout;
        this.backImg = imageView;
        this.imgBtn = imageView2;
        this.rim = frameLayout2;
        this.scanArs = imageView3;
        this.scanTip = textView;
        this.surfaceView = surfaceView;
    }

    public static ActivityBitmapScanQrcodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBitmapScanQrcodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_bitmap_scan_qrcode, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBitmapScanQrcodeBinding bind(View view) {
        int i = R.id.back_img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.img_btn;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.rim;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.scan_ars;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.scan_tip;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.surfaceView;
                            SurfaceView surfaceView = (SurfaceView) ViewBindings.findChildViewById(view, i);
                            if (surfaceView != null) {
                                return new ActivityBitmapScanQrcodeBinding((FrameLayout) view, imageView, imageView2, frameLayout, imageView3, textView, surfaceView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
