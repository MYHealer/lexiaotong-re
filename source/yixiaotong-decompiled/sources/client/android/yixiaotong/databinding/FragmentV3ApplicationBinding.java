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
import client.android.yixiaotong.ui.pullrefresh.MyViewPager;
import client.android.yixiaotong.ui.widget.MyPagerGalleryView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class FragmentV3ApplicationBinding implements ViewBinding {
    public final MyPagerGalleryView adgallery;
    public final ImageView imgLocation;
    public final ImageView imgQuickbindcard;
    public final ImageView imgScan;
    public final ImageView ivAnnouncement;
    public final ImageView ivLoading;
    public final LinearLayout llDot;
    public final LinearLayout ovalLayout1;
    public final RelativeLayout qweqweqweqwe;
    public final RelativeLayout relApp;
    public final RelativeLayout relSelectschool;
    public final LinearLayout relTopschool;
    public final RelativeLayout rlNative;
    private final RelativeLayout rootView;
    public final ScrollView scrollview;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TextView tvSchoolname;
    public final MyViewPager viewpager;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private FragmentV3ApplicationBinding(RelativeLayout relativeLayout, MyPagerGalleryView myPagerGalleryView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, LinearLayout linearLayout3, RelativeLayout relativeLayout5, ScrollView scrollView, PullRefreshLayout pullRefreshLayout, TextView textView, MyViewPager myViewPager) {
        this.rootView = relativeLayout;
        this.adgallery = myPagerGalleryView;
        this.imgLocation = imageView;
        this.imgQuickbindcard = imageView2;
        this.imgScan = imageView3;
        this.ivAnnouncement = imageView4;
        this.ivLoading = imageView5;
        this.llDot = linearLayout;
        this.ovalLayout1 = linearLayout2;
        this.qweqweqweqwe = relativeLayout2;
        this.relApp = relativeLayout3;
        this.relSelectschool = relativeLayout4;
        this.relTopschool = linearLayout3;
        this.rlNative = relativeLayout5;
        this.scrollview = scrollView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.tvSchoolname = textView;
        this.viewpager = myViewPager;
    }

    public static FragmentV3ApplicationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentV3ApplicationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v3_application, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentV3ApplicationBinding bind(View view) {
        int i = R.id.adgallery;
        MyPagerGalleryView myPagerGalleryView = (MyPagerGalleryView) ViewBindings.findChildViewById(view, i);
        if (myPagerGalleryView != null) {
            i = R.id.img_location;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.img_quickbindcard;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.img_scan;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.iv_announcement;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = R.id.iv_loading;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView5 != null) {
                                i = R.id.ll_dot;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.ovalLayout1;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.qweqweqweqwe;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout != null) {
                                            i = R.id.rel_app;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout2 != null) {
                                                i = R.id.rel_selectschool;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout3 != null) {
                                                    i = R.id.rel_topschool;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout3 != null) {
                                                        i = R.id.rl_native;
                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                        if (relativeLayout4 != null) {
                                                            i = R.id.scrollview;
                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                            if (scrollView != null) {
                                                                i = R.id.swipeRefreshLayout;
                                                                PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                                                if (pullRefreshLayout != null) {
                                                                    i = R.id.tv_schoolname;
                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView != null) {
                                                                        i = R.id.viewpager;
                                                                        MyViewPager myViewPager = (MyViewPager) ViewBindings.findChildViewById(view, i);
                                                                        if (myViewPager != null) {
                                                                            return new FragmentV3ApplicationBinding((RelativeLayout) view, myPagerGalleryView, imageView, imageView2, imageView3, imageView4, imageView5, linearLayout, linearLayout2, relativeLayout, relativeLayout2, relativeLayout3, linearLayout3, relativeLayout4, scrollView, pullRefreshLayout, textView, myViewPager);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
