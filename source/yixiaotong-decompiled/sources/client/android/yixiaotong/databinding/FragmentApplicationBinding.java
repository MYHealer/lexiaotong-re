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
import client.android.yixiaotong.ui.pullrefresh.MyViewPager;
import client.android.yixiaotong.ui.widget.MyPagerGalleryView;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class FragmentApplicationBinding implements ViewBinding {
    public final MyPagerGalleryView adgallery;
    public final ImageView imgFaq;
    public final ImageView imgMoreNotice;
    public final ImageView imgQrcode;
    public final ImageView imgSex;
    public final ImageView ivLoading;
    public final SimpleDraweeView ivMeIcon;
    public final LinearLayout llDot;
    public final LinearLayout llMeInfo;
    public final ImageView next;
    public final LinearLayout ovalLayout1;
    public final RelativeLayout qweqweqweqwe;
    private final LinearLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titlebar;
    public final TextView tvInfo;
    public final TextView tvMeId;
    public final TextView tvMeName;
    public final MyViewPager viewpager;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private FragmentApplicationBinding(LinearLayout linearLayout, MyPagerGalleryView myPagerGalleryView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, SimpleDraweeView simpleDraweeView, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView6, LinearLayout linearLayout4, RelativeLayout relativeLayout, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, MyViewPager myViewPager) {
        this.rootView = linearLayout;
        this.adgallery = myPagerGalleryView;
        this.imgFaq = imageView;
        this.imgMoreNotice = imageView2;
        this.imgQrcode = imageView3;
        this.imgSex = imageView4;
        this.ivLoading = imageView5;
        this.ivMeIcon = simpleDraweeView;
        this.llDot = linearLayout2;
        this.llMeInfo = linearLayout3;
        this.next = imageView6;
        this.ovalLayout1 = linearLayout4;
        this.qweqweqweqwe = relativeLayout;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titlebar = titleBar;
        this.tvInfo = textView;
        this.tvMeId = textView2;
        this.tvMeName = textView3;
        this.viewpager = myViewPager;
    }

    public static FragmentApplicationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentApplicationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_application, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentApplicationBinding bind(View view) {
        int i = R.id.adgallery;
        MyPagerGalleryView myPagerGalleryView = (MyPagerGalleryView) ViewBindings.findChildViewById(view, i);
        if (myPagerGalleryView != null) {
            i = R.id.img_faq;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.img_more_notice;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.img_qrcode;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.img_sex;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = R.id.iv_loading;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView5 != null) {
                                i = R.id.iv_me_icon;
                                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i);
                                if (simpleDraweeView != null) {
                                    i = R.id.ll_dot;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        i = R.id.ll_me_info;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout2 != null) {
                                            i = R.id.next;
                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView6 != null) {
                                                i = R.id.ovalLayout1;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout3 != null) {
                                                    i = R.id.qweqweqweqwe;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout != null) {
                                                        i = R.id.swipeRefreshLayout;
                                                        PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                                        if (pullRefreshLayout != null) {
                                                            i = R.id.titlebar;
                                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                            if (titleBar != null) {
                                                                i = R.id.tv_info;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView != null) {
                                                                    i = R.id.tv_me_id;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView2 != null) {
                                                                        i = R.id.tv_me_name;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView3 != null) {
                                                                            i = R.id.viewpager;
                                                                            MyViewPager myViewPager = (MyViewPager) ViewBindings.findChildViewById(view, i);
                                                                            if (myViewPager != null) {
                                                                                return new FragmentApplicationBinding((LinearLayout) view, myPagerGalleryView, imageView, imageView2, imageView3, imageView4, imageView5, simpleDraweeView, linearLayout, linearLayout2, imageView6, linearLayout3, relativeLayout, pullRefreshLayout, titleBar, textView, textView2, textView3, myViewPager);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
