package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityUpdateInfoBinding implements ViewBinding {
    public final Button btnComfirt;
    public final EditText etData;
    public final ImageView imgDelect;
    private final LinearLayout rootView;
    public final TitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityUpdateInfoBinding(LinearLayout linearLayout, Button button, EditText editText, ImageView imageView, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.btnComfirt = button;
        this.etData = editText;
        this.imgDelect = imageView;
        this.titleBar = titleBar;
    }

    public static ActivityUpdateInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityUpdateInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_update_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityUpdateInfoBinding bind(View view) {
        int i = R.id.btn_comfirt;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_data;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.img_delect;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.titleBar;
                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                    if (titleBar != null) {
                        return new ActivityUpdateInfoBinding((LinearLayout) view, button, editText, imageView, titleBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
