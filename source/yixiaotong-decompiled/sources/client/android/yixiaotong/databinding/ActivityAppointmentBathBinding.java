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
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityAppointmentBathBinding implements ViewBinding {
    public final ImageView ivArea;
    public final ImageView ivCeng;
    public final ImageView ivDong;
    public final ImageView ivRoom;
    public final LinearLayout linTitle;
    public final WrapListView lvAppointment;
    public final RelativeLayout relAppointment;
    public final RelativeLayout relArea;
    public final RelativeLayout relCeng;
    public final RelativeLayout relDong;
    public final RelativeLayout relRoom;
    private final LinearLayout rootView;
    public final ScrollView scrollView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titleBar;
    public final TextView tvArea;
    public final TextView tvCeng;
    public final TextView tvDong;
    public final TextView tvNouse;
    public final TextView tvNousetext;
    public final TextView tvRoom;
    public final TextView tvUse;
    public final TextView tvUsetext;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityAppointmentBathBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, WrapListView wrapListView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, ScrollView scrollView, PullRefreshLayout pullRefreshLayout, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = linearLayout;
        this.ivArea = imageView;
        this.ivCeng = imageView2;
        this.ivDong = imageView3;
        this.ivRoom = imageView4;
        this.linTitle = linearLayout2;
        this.lvAppointment = wrapListView;
        this.relAppointment = relativeLayout;
        this.relArea = relativeLayout2;
        this.relCeng = relativeLayout3;
        this.relDong = relativeLayout4;
        this.relRoom = relativeLayout5;
        this.scrollView = scrollView;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titleBar = titleBar;
        this.tvArea = textView;
        this.tvCeng = textView2;
        this.tvDong = textView3;
        this.tvNouse = textView4;
        this.tvNousetext = textView5;
        this.tvRoom = textView6;
        this.tvUse = textView7;
        this.tvUsetext = textView8;
    }

    public static ActivityAppointmentBathBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAppointmentBathBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_appointment_bath, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAppointmentBathBinding bind(View view) {
        int i = R.id.iv_area;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_ceng;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_dong;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.iv_room;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.lin_title;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.lv_appointment;
                            WrapListView wrapListView = (WrapListView) ViewBindings.findChildViewById(view, i);
                            if (wrapListView != null) {
                                i = R.id.rel_appointment;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout != null) {
                                    i = R.id.rel_area;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout2 != null) {
                                        i = R.id.rel_ceng;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout3 != null) {
                                            i = R.id.rel_dong;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout4 != null) {
                                                i = R.id.rel_room;
                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout5 != null) {
                                                    i = R.id.scrollView;
                                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                    if (scrollView != null) {
                                                        i = R.id.swipeRefreshLayout;
                                                        PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                                        if (pullRefreshLayout != null) {
                                                            i = R.id.titleBar;
                                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                            if (titleBar != null) {
                                                                i = R.id.tv_area;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView != null) {
                                                                    i = R.id.tv_ceng;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView2 != null) {
                                                                        i = R.id.tv_dong;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView3 != null) {
                                                                            i = R.id.tv_nouse;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView4 != null) {
                                                                                i = R.id.tv_nousetext;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView5 != null) {
                                                                                    i = R.id.tv_room;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.tv_use;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.tv_usetext;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView8 != null) {
                                                                                                return new ActivityAppointmentBathBinding((LinearLayout) view, imageView, imageView2, imageView3, imageView4, linearLayout, wrapListView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, scrollView, pullRefreshLayout, titleBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
