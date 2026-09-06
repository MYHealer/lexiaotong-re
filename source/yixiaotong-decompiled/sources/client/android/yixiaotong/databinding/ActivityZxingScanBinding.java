package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityZxingScanBinding implements ViewBinding {
    public final RelativeLayout captureContainer;
    public final RelativeLayout captureCropView;
    public final ImageView captureMaskBottom;
    public final ImageView captureMaskLeft;
    public final ImageView captureMaskRight;
    public final ImageView captureMaskTop;
    public final SurfaceView capturePreview;
    public final ImageView captureScanLine;
    private final RelativeLayout rootView;
    public final TitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityZxingScanBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, SurfaceView surfaceView, ImageView imageView5, TitleBar titleBar) {
        this.rootView = relativeLayout;
        this.captureContainer = relativeLayout2;
        this.captureCropView = relativeLayout3;
        this.captureMaskBottom = imageView;
        this.captureMaskLeft = imageView2;
        this.captureMaskRight = imageView3;
        this.captureMaskTop = imageView4;
        this.capturePreview = surfaceView;
        this.captureScanLine = imageView5;
        this.titleBar = titleBar;
    }

    public static ActivityZxingScanBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityZxingScanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_zxing_scan, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityZxingScanBinding bind(View view) {
        int i = R.id.capture_container;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.capture_crop_view;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout2 != null) {
                i = R.id.capture_mask_bottom;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.capture_mask_left;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.capture_mask_right;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.capture_mask_top;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView4 != null) {
                                i = R.id.capture_preview;
                                SurfaceView surfaceView = (SurfaceView) ViewBindings.findChildViewById(view, i);
                                if (surfaceView != null) {
                                    i = R.id.capture_scan_line;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView5 != null) {
                                        i = R.id.titleBar;
                                        TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                        if (titleBar != null) {
                                            return new ActivityZxingScanBinding((RelativeLayout) view, relativeLayout, relativeLayout2, imageView, imageView2, imageView3, imageView4, surfaceView, imageView5, titleBar);
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
