package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.github.mikephil.charting.charts.LineChart;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4ElecMeterAnalysisBinding implements ViewBinding {
    public final ImageView ivTimedrop;
    public final ImageView ivWaydrop;
    public final LinearLayout linCharname;
    public final LinearLayout linDeviceno;
    public final LinearLayout linTitle;
    public final LineChart linechart;
    public final ListView lvDatas;
    public final PullRefreshLayout pullrefreshlayout;
    public final RelativeLayout relTime;
    public final RelativeLayout relTop;
    public final RelativeLayout relWay;
    private final RelativeLayout rootView;
    public final TitleBar titlebar;
    public final TextView tvDescribe;
    public final TextView tvDeviceno;
    public final TextView tvNodata;
    public final TextView tvTime;
    public final TextView tvWay;
    public final View vLine;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4ElecMeterAnalysisBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LineChart lineChart, ListView listView, PullRefreshLayout pullRefreshLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.rootView = relativeLayout;
        this.ivTimedrop = imageView;
        this.ivWaydrop = imageView2;
        this.linCharname = linearLayout;
        this.linDeviceno = linearLayout2;
        this.linTitle = linearLayout3;
        this.linechart = lineChart;
        this.lvDatas = listView;
        this.pullrefreshlayout = pullRefreshLayout;
        this.relTime = relativeLayout2;
        this.relTop = relativeLayout3;
        this.relWay = relativeLayout4;
        this.titlebar = titleBar;
        this.tvDescribe = textView;
        this.tvDeviceno = textView2;
        this.tvNodata = textView3;
        this.tvTime = textView4;
        this.tvWay = textView5;
        this.vLine = view;
    }

    public static ActivityV4ElecMeterAnalysisBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4ElecMeterAnalysisBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_elec_meter_analysis, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4ElecMeterAnalysisBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.iv_timedrop;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_waydrop;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.lin_charname;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.lin_deviceno;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.lin_title;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null) {
                            i = R.id.linechart;
                            LineChart lineChart = (LineChart) ViewBindings.findChildViewById(view, i);
                            if (lineChart != null) {
                                i = R.id.lv_datas;
                                ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                                if (listView != null) {
                                    i = R.id.pullrefreshlayout;
                                    PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                    if (pullRefreshLayout != null) {
                                        i = R.id.rel_time;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout != null) {
                                            i = R.id.rel_top;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout2 != null) {
                                                i = R.id.rel_way;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout3 != null) {
                                                    i = R.id.titlebar;
                                                    TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                    if (titleBar != null) {
                                                        i = R.id.tv_describe;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView != null) {
                                                            i = R.id.tv_deviceno;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView2 != null) {
                                                                i = R.id.tv_nodata;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView3 != null) {
                                                                    i = R.id.tv_time;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tv_way;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView5 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_line))) != null) {
                                                                            return new ActivityV4ElecMeterAnalysisBinding((RelativeLayout) view, imageView, imageView2, linearLayout, linearLayout2, linearLayout3, lineChart, listView, pullRefreshLayout, relativeLayout, relativeLayout2, relativeLayout3, titleBar, textView, textView2, textView3, textView4, textView5, viewFindChildViewById);
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
