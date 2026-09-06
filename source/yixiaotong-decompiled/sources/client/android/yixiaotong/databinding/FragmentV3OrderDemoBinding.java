package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class FragmentV3OrderDemoBinding implements ViewBinding {
    public final Button btnPay;
    public final ImageView ivPaydrop;
    public final ImageView ivTimedrop;
    public final ImageView ivTypedrop;
    public final LinearLayout linPayway;
    public final LinearLayout linTitle;
    public final WrapListView listview;
    public final ListView lvRecord;
    public final MultiStateView multiStateView;
    public final RelativeLayout relPay;
    public final RelativeLayout relPaystate;
    public final RelativeLayout relTime;
    public final RelativeLayout relType;
    private final LinearLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TextView textpayway;
    public final TitleBar titleBar;
    public final TextView tvAppname;
    public final TextView tvPaystate;
    public final TextView tvTime;
    public final TextView tvTotalmoney;
    public final TextView tvTotaltext;
    public final View vLine;
    public final View vPopbg;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private FragmentV3OrderDemoBinding(LinearLayout linearLayout, Button button, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, LinearLayout linearLayout3, WrapListView wrapListView, ListView listView, MultiStateView multiStateView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, PullRefreshLayout pullRefreshLayout, TextView textView, TitleBar titleBar, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view, View view2) {
        this.rootView = linearLayout;
        this.btnPay = button;
        this.ivPaydrop = imageView;
        this.ivTimedrop = imageView2;
        this.ivTypedrop = imageView3;
        this.linPayway = linearLayout2;
        this.linTitle = linearLayout3;
        this.listview = wrapListView;
        this.lvRecord = listView;
        this.multiStateView = multiStateView;
        this.relPay = relativeLayout;
        this.relPaystate = relativeLayout2;
        this.relTime = relativeLayout3;
        this.relType = relativeLayout4;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.textpayway = textView;
        this.titleBar = titleBar;
        this.tvAppname = textView2;
        this.tvPaystate = textView3;
        this.tvTime = textView4;
        this.tvTotalmoney = textView5;
        this.tvTotaltext = textView6;
        this.vLine = view;
        this.vPopbg = view2;
    }

    public static FragmentV3OrderDemoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentV3OrderDemoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v3_order_demo, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentV3OrderDemoBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.btn_pay;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.iv_paydrop;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_timedrop;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.iv_typedrop;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.lin_payway;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.lin_title;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.listview;
                                WrapListView wrapListView = (WrapListView) ViewBindings.findChildViewById(view, i);
                                if (wrapListView != null) {
                                    i = R.id.lv_record;
                                    ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                                    if (listView != null) {
                                        i = R.id.multiStateView;
                                        MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
                                        if (multiStateView != null) {
                                            i = R.id.rel_pay;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout != null) {
                                                i = R.id.rel_paystate;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.rel_time;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout3 != null) {
                                                        i = R.id.rel_type;
                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                        if (relativeLayout4 != null) {
                                                            i = R.id.swipeRefreshLayout;
                                                            PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                                            if (pullRefreshLayout != null) {
                                                                i = R.id.textpayway;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView != null) {
                                                                    i = R.id.titleBar;
                                                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                                    if (titleBar != null) {
                                                                        i = R.id.tv_appname;
                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView2 != null) {
                                                                            i = R.id.tv_paystate;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView3 != null) {
                                                                                i = R.id.tv_time;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.tv_totalmoney;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.tv_totaltext;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView6 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_line))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.v_popbg))) != null) {
                                                                                            return new FragmentV3OrderDemoBinding((LinearLayout) view, button, imageView, imageView2, imageView3, linearLayout, linearLayout2, wrapListView, listView, multiStateView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, pullRefreshLayout, textView, titleBar, textView2, textView3, textView4, textView5, textView6, viewFindChildViewById, viewFindChildViewById2);
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
