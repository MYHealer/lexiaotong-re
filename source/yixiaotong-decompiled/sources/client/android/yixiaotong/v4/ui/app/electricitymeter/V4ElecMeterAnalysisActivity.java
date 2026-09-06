package client.android.yixiaotong.v4.ui.app.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.adapter.MyPopWindow;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.elecmeter.MetersTrendBean;
import client.android.yixiaotong.v3.ui.adapter.ElecMeterAnalysisAdapter;
import client.android.yixiaotong.v3.ui.error.ErrorControlUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4MeterConsumeDailySummaryBean;
import client.android.yixiaotong.v4.http.bean.V4MeterConsumeDailySummaryItemBean;
import client.android.yixiaotong.v4.http.bean.V4MetersTrendBean;
import client.android.yixiaotong.v4.http.bean.V4MetersTrendVoListBean;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectConfigInfoUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.google.android.exoplayer2.C;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ElecMeterAnalysisActivity extends BaseActivity {
    private static final int DORM_WALLET_TIME_RANGE = 3;
    private static final String TAG = "V4ElecMeterAnalysisActivity";
    private String mDeviceNo;
    private ElecMeterAnalysisAdapter mElecMeterAnalysisAdapter;
    private boolean mIsDormWallet;
    ImageView mIvTimeDrop;
    ImageView mIvWayDrop;
    LineChart mLineChart;
    ListView mLvDatas;
    private int mProductId;
    PullRefreshLayout mPullRefreshLayout;
    View mRelTop;
    TitleBar mTitleBar;
    View mTopView;
    TextView mTvDescribe;
    TextView mTvDeviceNo;
    TextView mTvNoData;
    TextView mTvTime;
    TextView mTvWay;
    private MyPopWindow myPopWindow;
    private RotateAnimation rotate;
    private boolean mIsEnable = true;
    private List<String> mWayStrs = new ArrayList();
    private List<String> mTimeStrs = new ArrayList();
    private int mSelectWayIndex = 0;
    private int mSelectTimeIndex = 0;
    private List<MetersTrendBean> mDayDatas = new ArrayList();
    private final Handler mHideHandler = new Handler(Looper.getMainLooper());
    private final Runnable mHideHighlightRunnable = new Runnable() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterAnalysisActivity.1
        @Override // java.lang.Runnable
        public void run() {
            V4ElecMeterAnalysisActivity.this.mLineChart.highlightValue(null);
            V4ElecMeterAnalysisActivity.this.mLineChart.invalidate();
        }
    };
    private String mStatisticType = "daily";
    private String mTimeRange = "recentWeek";

    static {
        StubApp.interface11(10738);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4ElecMeterAnalysisActivity.class).putExtra(AmmeterWalletDetailActivity.EXTRA_DEVICENO, str).putExtra("productId", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mPullRefreshLayout = (PullRefreshLayout) findViewById(R.id.pullrefreshlayout);
        this.mTvWay = (TextView) findViewById(R.id.tv_way);
        this.mIvWayDrop = (ImageView) findViewById(R.id.iv_waydrop);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mIvTimeDrop = (ImageView) findViewById(R.id.iv_timedrop);
        this.mTvDeviceNo = (TextView) findViewById(R.id.tv_deviceno);
        this.mLineChart = (LineChart) findViewById(R.id.linechart);
        this.mTvDescribe = (TextView) findViewById(R.id.tv_describe);
        this.mLvDatas = (ListView) findViewById(R.id.lv_datas);
        this.mTvNoData = (TextView) findViewById(R.id.tv_nodata);
        this.mTopView = findViewById(R.id.v_line);
        this.mRelTop = findViewById(R.id.rel_top);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        int i = this.mProductId;
        if (i == 6 || i == 17) {
            this.mTitleBar.setTitleView(getString(R.string.materanalysis));
        } else {
            this.mTitleBar.setTitleView(getString(R.string.elecmeteranalysis));
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewData() {
        this.mWayStrs.clear();
        this.mWayStrs.add(getString(R.string.dailystatistics));
        this.mWayStrs.add(getString(R.string.monthlystatistics));
        this.mTimeStrs.clear();
        int i = this.mSelectWayIndex;
        if (i == 0) {
            this.mTimeStrs.add(getString(R.string.nearlyservendays));
            this.mTimeStrs.add(getString(R.string.nearlythirtydays));
        } else if (i == 1) {
            this.mTimeStrs.add(getString(R.string.thisyear));
            this.mTimeStrs.add(getString(R.string.lastyear));
        }
        this.mTvWay.setText(this.mWayStrs.get(this.mSelectWayIndex));
        this.mTvTime.setText(this.mTimeStrs.get(this.mSelectTimeIndex));
        int i2 = this.mProductId;
        if (i2 == 6 || i2 == 17) {
            this.mTvDescribe.setText(this.mTvTime.getText().toString() + getString(R.string.materanalysis));
        } else {
            this.mTvDescribe.setText(this.mTvTime.getText().toString() + getString(R.string.elecmeteranalysis));
        }
    }

    private void initView() {
        boolean zDormWallet = V4ProjectConfigInfoUtil.getInstance().dormWallet();
        this.mIsDormWallet = zDormWallet;
        if (zDormWallet) {
            this.mPullRefreshLayout.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPullRefreshLayout.getLayoutParams();
            layoutParams.height = 0;
            layoutParams.weight = 0.0f;
            this.mPullRefreshLayout.setLayoutParams(layoutParams);
        }
        this.mTvDeviceNo.setText(this.mDeviceNo);
        this.myPopWindow = new MyPopWindow(getActivity());
        this.mPullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterAnalysisActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                LogUtil.e(V4ElecMeterAnalysisActivity.TAG, "onRefresh:");
                V4ElecMeterAnalysisActivity.this.loadAnalysisData();
            }
        });
        ElecMeterAnalysisAdapter elecMeterAnalysisAdapter = new ElecMeterAnalysisAdapter(getActivity(), new ElecMeterAnalysisAdapter.OnItemClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterAnalysisActivity.3
            @Override // client.android.yixiaotong.v3.ui.adapter.ElecMeterAnalysisAdapter.OnItemClickListener
            public void onItemClick(int i) {
            }
        });
        this.mElecMeterAnalysisAdapter = elecMeterAnalysisAdapter;
        int i = this.mProductId;
        elecMeterAnalysisAdapter.setTypeFlag((i == 6 || i == 17) ? 1 : 0);
        if (V4ProjectConfigInfoUtil.getInstance().dormWallet()) {
            this.mElecMeterAnalysisAdapter.setDailySummaryMode(true);
        }
        this.mLvDatas.setOnItemClickListener(this.mElecMeterAnalysisAdapter);
        this.mLvDatas.setAdapter((ListAdapter) this.mElecMeterAnalysisAdapter);
        findViewById(R.id.rel_way).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterAnalysisActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtil.isFastDoubleClick()) {
                    return;
                }
                V4ElecMeterAnalysisActivity.this.selectWay();
            }
        });
        findViewById(R.id.rel_time).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterAnalysisActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtil.isFastDoubleClick()) {
                    return;
                }
                V4ElecMeterAnalysisActivity.this.selectTime();
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        if (this.mPullRefreshLayout.getVisibility() == 0) {
            this.mPullRefreshLayout.setRefreshing(false);
        }
        ErrorControlUtil.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mHideHandler.removeCallbacks(this.mHideHighlightRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAnalysisData() {
        if (this.mIsDormWallet) {
            getMeterConsumeDailySummary();
        } else {
            getMetersTrend();
        }
    }

    private void getMeterConsumeDailySummary() {
        V4BusinessControllers.getInstance().getMeterConsumeDailySummary(getLoginAccount(), 3, this.mProductId, new Listener<V4MeterConsumeDailySummaryBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterAnalysisActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                V4ElecMeterAnalysisActivity.this.mTvNoData.setVisibility(8);
                if (V4ElecMeterAnalysisActivity.this.mPullRefreshLayout.getVisibility() == 0) {
                    V4ElecMeterAnalysisActivity.this.mPullRefreshLayout.setRefreshing(true);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4MeterConsumeDailySummaryBean v4MeterConsumeDailySummaryBean, Object... objArr) {
                super.onComplete(controller, v4MeterConsumeDailySummaryBean, objArr);
                if (V4ElecMeterAnalysisActivity.this.mIsEnable) {
                    if (V4ElecMeterAnalysisActivity.this.mPullRefreshLayout.getVisibility() == 0) {
                        V4ElecMeterAnalysisActivity.this.mPullRefreshLayout.setRefreshing(false);
                    }
                    V4ElecMeterAnalysisActivity.this.mDayDatas.clear();
                    if (v4MeterConsumeDailySummaryBean == null || v4MeterConsumeDailySummaryBean.list == null || v4MeterConsumeDailySummaryBean.list.isEmpty()) {
                        V4ElecMeterAnalysisActivity.this.mTvNoData.setVisibility(0);
                    } else {
                        V4ElecMeterAnalysisActivity.this.mTvNoData.setVisibility(8);
                        for (V4MeterConsumeDailySummaryItemBean v4MeterConsumeDailySummaryItemBean : v4MeterConsumeDailySummaryBean.list) {
                            if (!StringUtils.isEmpty(v4MeterConsumeDailySummaryItemBean.reportDate)) {
                                MetersTrendBean metersTrendBean = new MetersTrendBean();
                                metersTrendBean.point = v4MeterConsumeDailySummaryItemBean.reportDate;
                                metersTrendBean.usageAmount = DecimalUtil.twoDecimal(String.valueOf(v4MeterConsumeDailySummaryItemBean.usageAmount));
                                metersTrendBean.money = DecimalUtil.twoDecimal(String.valueOf(v4MeterConsumeDailySummaryItemBean.usageAmountMoney));
                                metersTrendBean.consumeCount = String.valueOf(v4MeterConsumeDailySummaryItemBean.consumeCount);
                                V4ElecMeterAnalysisActivity.this.mDayDatas.add(metersTrendBean);
                            }
                        }
                        if (V4ElecMeterAnalysisActivity.this.mDayDatas.isEmpty()) {
                            V4ElecMeterAnalysisActivity.this.mTvNoData.setVisibility(0);
                        }
                    }
                    V4ElecMeterAnalysisActivity.this.mElecMeterAnalysisAdapter.setData(V4ElecMeterAnalysisActivity.this.mDayDatas);
                    V4ElecMeterAnalysisActivity.this.mElecMeterAnalysisAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4ElecMeterAnalysisActivity.this.mIsEnable) {
                    if (V4ElecMeterAnalysisActivity.this.mPullRefreshLayout.getVisibility() == 0) {
                        V4ElecMeterAnalysisActivity.this.mPullRefreshLayout.setRefreshing(false);
                    }
                    ErrorControlUtil.getInstance().onError(V4ElecMeterAnalysisActivity.this.getLoginAccount(), clientException, V4ElecMeterAnalysisActivity.this.getActivity(), false, V4ElecMeterAnalysisActivity.this.mTitleBar.getTitleViewContent());
                }
            }
        });
    }

    private void getMetersTrend() {
        this.mStatisticType = "";
        this.mTimeRange = "";
        int i = this.mSelectWayIndex;
        if (i == 0) {
            this.mStatisticType = "daily";
            this.mTimeRange = "recentWeek";
            if (this.mSelectTimeIndex == 1) {
                this.mTimeRange = "recentMonth";
            }
        } else if (i == 1) {
            this.mStatisticType = "monthly";
            this.mTimeRange = "currentYear";
            if (this.mSelectTimeIndex == 1) {
                this.mTimeRange = "lastYear";
            }
        }
        V4BusinessControllers.getInstance().getMetersTrend(getLoginAccount(), this.mProductId, this.mDeviceNo, this.mStatisticType, this.mTimeRange, new Listener<V4MetersTrendBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterAnalysisActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                V4ElecMeterAnalysisActivity.this.mTvNoData.setVisibility(8);
                V4ElecMeterAnalysisActivity.this.mPullRefreshLayout.setRefreshing(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4MetersTrendBean v4MetersTrendBean, Object... objArr) {
                super.onComplete(controller, v4MetersTrendBean, objArr);
                if (V4ElecMeterAnalysisActivity.this.mIsEnable) {
                    V4ElecMeterAnalysisActivity.this.mPullRefreshLayout.setRefreshing(false);
                    if (v4MetersTrendBean == null || (v4MetersTrendBean != null && v4MetersTrendBean.voList == null)) {
                        V4ElecMeterAnalysisActivity.this.mTvNoData.setVisibility(0);
                        V4ElecMeterAnalysisActivity.this.mDayDatas.clear();
                        V4ElecMeterAnalysisActivity.this.mElecMeterAnalysisAdapter.setData(V4ElecMeterAnalysisActivity.this.mDayDatas);
                        V4ElecMeterAnalysisActivity.this.mElecMeterAnalysisAdapter.notifyDataSetChanged();
                        V4ElecMeterAnalysisActivity.this.mLineChart.clear();
                        V4ElecMeterAnalysisActivity.this.mLineChart.invalidate();
                        return;
                    }
                    if (v4MetersTrendBean.datas != null) {
                        V4ElecMeterAnalysisActivity.this.mTvDescribe.setText(v4MetersTrendBean.datas.name);
                    }
                    V4ElecMeterAnalysisActivity.this.initLineChart(v4MetersTrendBean);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4ElecMeterAnalysisActivity.this.mIsEnable) {
                    V4ElecMeterAnalysisActivity.this.mPullRefreshLayout.setRefreshing(false);
                    ErrorControlUtil.getInstance().onError(V4ElecMeterAnalysisActivity.this.getLoginAccount(), clientException, V4ElecMeterAnalysisActivity.this.getActivity(), false, V4ElecMeterAnalysisActivity.this.mTitleBar.getTitleViewContent());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLineChart(final V4MetersTrendBean v4MetersTrendBean) {
        this.mDayDatas.clear();
        this.mElecMeterAnalysisAdapter.setData(this.mDayDatas);
        this.mElecMeterAnalysisAdapter.notifyDataSetChanged();
        this.mLineChart.clear();
        this.mLineChart.invalidate();
        if (v4MetersTrendBean.voList == null || v4MetersTrendBean.voList.size() == 0) {
            this.mTvNoData.setVisibility(0);
            return;
        }
        this.mTvNoData.setVisibility(8);
        for (V4MetersTrendVoListBean v4MetersTrendVoListBean : v4MetersTrendBean.voList) {
            MetersTrendBean metersTrendBean = new MetersTrendBean();
            metersTrendBean.meters = v4MetersTrendVoListBean.deviceCurrAmount;
            metersTrendBean.usageAmount = v4MetersTrendVoListBean.deviceAmount;
            metersTrendBean.point = v4MetersTrendVoListBean.reportDate;
            this.mDayDatas.add(metersTrendBean);
        }
        this.mElecMeterAnalysisAdapter.setData(this.mDayDatas);
        this.mElecMeterAnalysisAdapter.notifyDataSetChanged();
        XAxis xAxis = this.mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);
        xAxis.setValueFormatter(new ValueFormatter() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterAnalysisActivity.8
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float f) {
                int i = (int) f;
                if (i < 0 || i >= v4MetersTrendBean.lends.size()) {
                    return "";
                }
                String strReplace = v4MetersTrendBean.lends.get(i).replace("日", "");
                if (!StringUtils.isNotEmpty(strReplace) || strReplace.length() <= 5) {
                    return "xx";
                }
                String str = strReplace.substring(5) + "";
                return str.length() > 4 ? str.replace("月", x.A) : str;
            }
        });
        int size = v4MetersTrendBean.lends.size() - 1;
        xAxis.setLabelCount(Math.max(1, size), false);
        xAxis.setAxisMaximum(Math.max(1, size));
        xAxis.setAxisMinimum(0.0f);
        if (this.mSelectTimeIndex == 1 && this.mSelectWayIndex == 0) {
            xAxis.setGranularity(5.0f);
        } else {
            xAxis.setGranularity(1.0f);
        }
        YAxis axisLeft = this.mLineChart.getAxisLeft();
        axisLeft.setDrawGridLines(true);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setLabelCount(5, false);
        float f = 0.0f;
        for (int i = 0; i < v4MetersTrendBean.datas.data.size(); i++) {
            float f2 = Float.parseFloat(v4MetersTrendBean.datas.data.get(i));
            if (f2 > f) {
                f = f2;
            }
        }
        int i2 = this.mProductId;
        float f3 = (i2 == 6 || i2 == 17) ? 50.0f : 10.0f;
        if (f > 0.0f) {
            f3 = 1.2f * f;
        }
        axisLeft.setAxisMaximum(f3);
        axisLeft.setAxisMinimum(0.0f);
        this.mLineChart.getAxisRight().setEnabled(false);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < v4MetersTrendBean.datas.data.size(); i3++) {
            arrayList.add(new Entry(i3, Float.parseFloat(v4MetersTrendBean.datas.data.get(i3))));
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, "");
        lineDataSet.setLineWidth(2.0f);
        lineDataSet.setColor(getResources().getColor(R.color.fffac858));
        boolean z = v4MetersTrendBean.datas.data.size() <= 1;
        lineDataSet.setDrawCircles(z);
        if (z) {
            lineDataSet.setCircleRadius(6.0f);
            lineDataSet.setCircleColor(getResources().getColor(R.color.fffac858));
        }
        lineDataSet.setDrawValues(false);
        lineDataSet.setHighlightEnabled(true);
        lineDataSet.setDrawVerticalHighlightIndicator(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setHighLightColor(getResources().getColor(R.color.fffac858));
        lineDataSet.setHighlightLineWidth(1.5f);
        this.mLineChart.setData(new LineData(lineDataSet));
        this.mLineChart.getDescription().setEnabled(false);
        this.mLineChart.getLegend().setEnabled(false);
        ((LineData) this.mLineChart.getData()).notifyDataChanged();
        this.mLineChart.notifyDataSetChanged();
        this.mLineChart.invalidate();
        this.mLineChart.setDragEnabled(true);
        this.mLineChart.setScaleEnabled(false);
        this.mLineChart.setDoubleTapToZoomEnabled(false);
        this.mLineChart.setPinchZoom(false);
        this.mLineChart.setTouchEnabled(true);
        this.mLineChart.setHighlightPerDragEnabled(true);
        this.mLineChart.setHighlightPerTapEnabled(true);
        ElecMarkerView elecMarkerView = new ElecMarkerView(getActivity());
        elecMarkerView.setLends(v4MetersTrendBean.lends);
        elecMarkerView.setLineChart(this.mLineChart);
        elecMarkerView.setChartView(this.mLineChart);
        this.mLineChart.setMarker(elecMarkerView);
        this.mLineChart.setOnChartGestureListener(new OnChartGestureListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterAnalysisActivity.9
            @Override // com.github.mikephil.charting.listener.OnChartGestureListener
            public void onChartDoubleTapped(MotionEvent motionEvent) {
            }

            @Override // com.github.mikephil.charting.listener.OnChartGestureListener
            public void onChartFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
            }

            @Override // com.github.mikephil.charting.listener.OnChartGestureListener
            public void onChartLongPressed(MotionEvent motionEvent) {
            }

            @Override // com.github.mikephil.charting.listener.OnChartGestureListener
            public void onChartScale(MotionEvent motionEvent, float f4, float f5) {
            }

            @Override // com.github.mikephil.charting.listener.OnChartGestureListener
            public void onChartTranslate(MotionEvent motionEvent, float f4, float f5) {
            }

            @Override // com.github.mikephil.charting.listener.OnChartGestureListener
            public void onChartGestureStart(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture) {
                V4ElecMeterAnalysisActivity.this.mPullRefreshLayout.requestDisallowInterceptTouchEvent(true);
                V4ElecMeterAnalysisActivity.this.mHideHandler.removeCallbacks(V4ElecMeterAnalysisActivity.this.mHideHighlightRunnable);
                V4ElecMeterAnalysisActivity.this.mLineChart.getXAxis().setDrawLabels(false);
                V4ElecMeterAnalysisActivity.this.mLineChart.invalidate();
            }

            @Override // com.github.mikephil.charting.listener.OnChartGestureListener
            public void onChartGestureEnd(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture) {
                V4ElecMeterAnalysisActivity.this.mPullRefreshLayout.requestDisallowInterceptTouchEvent(false);
                V4ElecMeterAnalysisActivity.this.mLineChart.getXAxis().setDrawLabels(true);
                V4ElecMeterAnalysisActivity.this.mLineChart.invalidate();
                V4ElecMeterAnalysisActivity.this.mHideHandler.removeCallbacks(V4ElecMeterAnalysisActivity.this.mHideHighlightRunnable);
                V4ElecMeterAnalysisActivity.this.mHideHandler.postDelayed(V4ElecMeterAnalysisActivity.this.mHideHighlightRunnable, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            }

            @Override // com.github.mikephil.charting.listener.OnChartGestureListener
            public void onChartSingleTapped(MotionEvent motionEvent) {
                V4ElecMeterAnalysisActivity.this.mHideHandler.removeCallbacks(V4ElecMeterAnalysisActivity.this.mHideHighlightRunnable);
                V4ElecMeterAnalysisActivity.this.mHideHandler.postDelayed(V4ElecMeterAnalysisActivity.this.mHideHighlightRunnable, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            }
        });
        this.mLineChart.getDescription().setEnabled(true);
        int i4 = this.mProductId;
        if (i4 == 12 || i4 == 13) {
            this.mLineChart.getDescription().setText(getString(R.string.dosage));
        } else if (i4 == 6 || i4 == 17) {
            this.mLineChart.getDescription().setText(getString(R.string.dosagel));
        }
        this.mLineChart.getDescription().setTextSize(10.0f);
        this.mLineChart.getDescription().setTextColor(getResources().getColor(android.R.color.black));
        this.mLineChart.getDescription().setTextAlign(Paint.Align.LEFT);
        this.mLineChart.getDescription().setPosition(60.0f, 40.0f);
        this.mLineChart.setExtraTopOffset(30.0f);
    }

    private boolean isEnglishLanguage() {
        String lanuage = LocalDataUtil.getLanuage(getActivity());
        return StringUtils.isNotEmpty(lanuage) && lanuage.equals(BaseActivity.LANGUAGEEN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectWay() {
        initAnim(0.0f, 180.0f);
        this.mIvWayDrop.startAnimation(this.rotate);
        this.myPopWindow.showPop(this.mTopView, this.mSelectWayIndex, this.mWayStrs, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterAnalysisActivity.10
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                V4ElecMeterAnalysisActivity.this.mTvWay.setText((CharSequence) V4ElecMeterAnalysisActivity.this.mWayStrs.get(i));
                if (V4ElecMeterAnalysisActivity.this.mSelectWayIndex != i) {
                    V4ElecMeterAnalysisActivity.this.mSelectWayIndex = i;
                    V4ElecMeterAnalysisActivity.this.mSelectTimeIndex = 0;
                    V4ElecMeterAnalysisActivity.this.initViewData();
                    V4ElecMeterAnalysisActivity.this.loadAnalysisData();
                }
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                V4ElecMeterAnalysisActivity.this.initAnim(180.0f, 360.0f);
                V4ElecMeterAnalysisActivity.this.mIvWayDrop.startAnimation(V4ElecMeterAnalysisActivity.this.rotate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectTime() {
        initAnim(0.0f, 180.0f);
        this.mIvTimeDrop.startAnimation(this.rotate);
        this.myPopWindow.showPop(this.mTopView, this.mSelectTimeIndex, this.mTimeStrs, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterAnalysisActivity.11
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                V4ElecMeterAnalysisActivity.this.mTvTime.setText((CharSequence) V4ElecMeterAnalysisActivity.this.mTimeStrs.get(i));
                if (V4ElecMeterAnalysisActivity.this.mSelectTimeIndex != i) {
                    V4ElecMeterAnalysisActivity.this.mSelectTimeIndex = i;
                    V4ElecMeterAnalysisActivity.this.initViewData();
                    V4ElecMeterAnalysisActivity.this.loadAnalysisData();
                }
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                V4ElecMeterAnalysisActivity.this.initAnim(180.0f, 360.0f);
                V4ElecMeterAnalysisActivity.this.mIvTimeDrop.startAnimation(V4ElecMeterAnalysisActivity.this.rotate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAnim(float f, float f2) {
        RotateAnimation rotateAnimation = new RotateAnimation(f, f2, 1, 0.5f, 1, 0.5f);
        this.rotate = rotateAnimation;
        rotateAnimation.setDuration(500L);
        this.rotate.setFillAfter(true);
    }
}
