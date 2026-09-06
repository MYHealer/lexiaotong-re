package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.MyPagerGalleryView;
import client.android.yixiaotong.ui.widget.WrapGridView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class FragmentV4MainBinding implements ViewBinding {
    public final MyPagerGalleryView adgallery;
    public final WrapGridView gvApp;
    public final ImageView imgLocation;
    public final ImageView imgQuickbindcard;
    public final ImageView imgScan;
    public final ImageView ivLoading;
    public final LinearLayout ovalLayout1;
    public final RelativeLayout qweqweqweqwe;
    public final RelativeLayout relSelectschool;
    public final LinearLayout relTopschool;
    public final RelativeLayout rlNative;
    private final RelativeLayout rootView;
    public final ScrollView scrollview;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TextView tvSchoolname;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private FragmentV4MainBinding(RelativeLayout relativeLayout, MyPagerGalleryView myPagerGalleryView, WrapGridView wrapGridView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, LinearLayout linearLayout2, RelativeLayout relativeLayout4, ScrollView scrollView, PullRefreshLayout pullRefreshLayout, TextView textView) {
        this.rootView = relativeLayout;
        this.adgallery = myPagerGalleryView;
        this.gvApp = wrapGridView;
        this.imgLocation = imageView;
        this.imgQuickbindcard = imageView2;
        this.imgScan = imageView3;
        this.ivLoading = imageView4;
        this.ovalLayout1 = linearLayout;
        this.qweqweqweqwe = relativeLayout2;
        this.relSelectschool = relativeLayout3;
        this.relTopschool = linearLayout2;
        this.rlNative = relativeLayout4;
        this.scrollview = scrollView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.tvSchoolname = textView;
    }

    public static FragmentV4MainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentV4MainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v4_main, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentV4MainBinding bind(View view) {
        int i = R.id.adgallery;
        MyPagerGalleryView myPagerGalleryView = (MyPagerGalleryView) ViewBindings.findChildViewById(view, i);
        if (myPagerGalleryView != null) {
            i = R.id.gv_app;
            WrapGridView wrapGridView = (WrapGridView) ViewBindings.findChildViewById(view, i);
            if (wrapGridView != null) {
                i = R.id.img_location;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.img_quickbindcard;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.img_scan;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.iv_loading;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView4 != null) {
                                i = R.id.ovalLayout1;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.qweqweqweqwe;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout != null) {
                                        i = R.id.rel_selectschool;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout2 != null) {
                                            i = R.id.rel_topschool;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout2 != null) {
                                                i = R.id.rl_native;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout3 != null) {
                                                    i = R.id.scrollview;
                                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                    if (scrollView != null) {
                                                        i = R.id.swipeRefreshLayout;
                                                        PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                                        if (pullRefreshLayout != null) {
                                                            i = R.id.tv_schoolname;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView != null) {
                                                                return new FragmentV4MainBinding((RelativeLayout) view, myPagerGalleryView, wrapGridView, imageView, imageView2, imageView3, imageView4, linearLayout, relativeLayout, relativeLayout2, linearLayout2, relativeLayout3, scrollView, pullRefreshLayout, textView);
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
