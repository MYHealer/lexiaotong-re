package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityFaqBinding implements ViewBinding {
    public final GridView gridview;
    public final ImageView img1;
    public final ImageView img2;
    public final ImageView img3;
    public final ImageView img4;
    public final ImageView img5;
    public final ImageView img6;
    public final ImageView imgAddQuestion;
    public final ImageView imgmore;
    public final RelativeLayout rel1;
    public final RelativeLayout rel2;
    private final LinearLayout rootView;
    public final TextView text1;
    public final TextView text2;
    public final TitleBar titlebar;
    public final View view1;
    public final View view2;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityFaqBinding(LinearLayout linearLayout, GridView gridView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TitleBar titleBar, View view, View view2) {
        this.rootView = linearLayout;
        this.gridview = gridView;
        this.img1 = imageView;
        this.img2 = imageView2;
        this.img3 = imageView3;
        this.img4 = imageView4;
        this.img5 = imageView5;
        this.img6 = imageView6;
        this.imgAddQuestion = imageView7;
        this.imgmore = imageView8;
        this.rel1 = relativeLayout;
        this.rel2 = relativeLayout2;
        this.text1 = textView;
        this.text2 = textView2;
        this.titlebar = titleBar;
        this.view1 = view;
        this.view2 = view2;
    }

    public static ActivityFaqBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFaqBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_faq, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFaqBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.gridview;
        GridView gridView = (GridView) ViewBindings.findChildViewById(view, i);
        if (gridView != null) {
            i = R.id.img1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.img2;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.img3;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.img4;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = R.id.img5;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView5 != null) {
                                i = R.id.img6;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView6 != null) {
                                    i = R.id.img_add_question;
                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView7 != null) {
                                        i = R.id.imgmore;
                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView8 != null) {
                                            i = R.id.rel1;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout != null) {
                                                i = R.id.rel2;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.text1;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView != null) {
                                                        i = R.id.text2;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView2 != null) {
                                                            i = R.id.titlebar;
                                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                            if (titleBar != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view2))) != null) {
                                                                return new ActivityFaqBinding((LinearLayout) view, gridView, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, relativeLayout, relativeLayout2, textView, textView2, titleBar, viewFindChildViewById, viewFindChildViewById2);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
