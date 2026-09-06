package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import uk.co.senab.photoview.PhotoView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ItemViewpagerPhotoviewBinding implements ViewBinding {
    public final CheckBox cbImage;
    public final PhotoView pvBigImage;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ItemViewpagerPhotoviewBinding(RelativeLayout relativeLayout, CheckBox checkBox, PhotoView photoView) {
        this.rootView = relativeLayout;
        this.cbImage = checkBox;
        this.pvBigImage = photoView;
    }

    public static ItemViewpagerPhotoviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemViewpagerPhotoviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_viewpager_photoview, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemViewpagerPhotoviewBinding bind(View view) {
        int i = R.id.cb_image;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
        if (checkBox != null) {
            i = R.id.pv_big_image;
            PhotoView photoView = (PhotoView) ViewBindings.findChildViewById(view, i);
            if (photoView != null) {
                return new ItemViewpagerPhotoviewBinding((RelativeLayout) view, checkBox, photoView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
