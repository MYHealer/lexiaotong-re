package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import uk.co.senab.photoview.PhotoView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ItemViewpagerBinding implements ViewBinding {
    public final ImageView ivSamllImage;
    public final ProgressBar progressBar;
    public final PhotoView pvBigImage;
    private final RelativeLayout rootView;
    public final RelativeLayout rvSmallImageLayout;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ItemViewpagerBinding(RelativeLayout relativeLayout, ImageView imageView, ProgressBar progressBar, PhotoView photoView, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.ivSamllImage = imageView;
        this.progressBar = progressBar;
        this.pvBigImage = photoView;
        this.rvSmallImageLayout = relativeLayout2;
    }

    public static ItemViewpagerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemViewpagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_viewpager, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemViewpagerBinding bind(View view) {
        int i = R.id.iv_samll_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.progressBar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null) {
                i = R.id.pv_big_image;
                PhotoView photoView = (PhotoView) ViewBindings.findChildViewById(view, i);
                if (photoView != null) {
                    i = R.id.rv_small_image_layout;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        return new ItemViewpagerBinding((RelativeLayout) view, imageView, progressBar, photoView, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
