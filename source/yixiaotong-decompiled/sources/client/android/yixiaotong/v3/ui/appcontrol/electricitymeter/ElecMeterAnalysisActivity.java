package client.android.yixiaotong.v3.ui.appcontrol.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
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
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterRoomInfoBean;
import client.android.yixiaotong.v3.bean.elecmeter.MetersTrendBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adapter.ElecMeterAnalysisAdapter;
import client.android.yixiaotong.v3.ui.error.ErrorControlUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ElecMeterAnalysisActivity extends BaseActivity {
    private static final String TAG = "ElecMeterAnalysisActivity";
    private BindElecMeterRoomInfoBean mBindElecMeterRoomInfoBean;
    private String mDeviceNo;
    private ElecMeterAnalysisAdapter mElecMeterAnalysisAdapter;
    private String mInvestorId;
    private ImageView mIvTimeDrop;
    private ImageView mIvWayDrop;
    private LineChart mLineChart;
    private ListView mLvDatas;
    private PullRefreshLayout mPullRefreshLayout;
    private String mSchoolId;
    private String mStudentId;
    private TitleBar mTitleBar;
    private View mTopView;
    private TextView mTvDescribe;
    private TextView mTvDeviceNo;
    private TextView mTvNoData;
    private TextView mTvTime;
    private TextView mTvWay;
    private MyPopWindow myPopWindow;
    private RotateAnimation rotate;
    private boolean mIsEnable = true;
    private List<String> mWayStrs = new ArrayList();
    private List<String> mTimeStrs = new ArrayList();
    private int mSelectWayIndex = 0;
    private int mSelectTimeIndex = 0;
    private List<MetersTrendBean> mDayDatas = new ArrayList();

    static {
        StubApp.interface11(9326);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ElecMeterAnalysisActivity.class).putExtra(AmmeterWalletDetailActivity.EXTRA_DEVICENO, str));
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
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setTitleView(getString(R.string.elecmeteranalysis));
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
        this.mTvDescribe.setText(this.mTvTime.getText().toString() + getString(R.string.elecmeteranalysis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData(List<MetersTrendBean> list) {
        if (list == null) {
            return;
        }
        int i = this.mSelectWayIndex;
        if (i == 0 && this.mSelectTimeIndex == 0) {
            initLineChartSevenDay(list);
            return;
        }
        if (i == 0 && this.mSelectTimeIndex == 1) {
            initLineChartMonth(list);
        } else if (i == 1) {
            initLineChartYear(list);
        }
    }

    private void initView() {
        this.mTvDeviceNo.setText(this.mDeviceNo);
        this.myPopWindow = new MyPopWindow(getActivity());
        this.mPullRefreshLayout.setRefreshing(false);
        this.mPullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAnalysisActivity.1
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                LogUtil.e(ElecMeterAnalysisActivity.TAG, "onRefresh:");
                ElecMeterAnalysisActivity.this.mPullRefreshLayout.setRefreshing(true);
                ElecMeterAnalysisActivity.this.getMetersTrend();
            }
        });
        ElecMeterAnalysisAdapter elecMeterAnalysisAdapter = new ElecMeterAnalysisAdapter(getActivity(), new ElecMeterAnalysisAdapter.OnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAnalysisActivity.2
            @Override // client.android.yixiaotong.v3.ui.adapter.ElecMeterAnalysisAdapter.OnItemClickListener
            public void onItemClick(int i) {
            }
        });
        this.mElecMeterAnalysisAdapter = elecMeterAnalysisAdapter;
        this.mLvDatas.setOnItemClickListener(elecMeterAnalysisAdapter);
        this.mLvDatas.setAdapter((ListAdapter) this.mElecMeterAnalysisAdapter);
    }

    private void initClickListeners() {
        findViewById(R.id.rel_way).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAnalysisActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m269x8a337184(view);
            }
        });
        findViewById(R.id.rel_time).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAnalysisActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m270xf8ba82c5(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-electricitymeter-ElecMeterAnalysisActivity, reason: not valid java name */
    /* synthetic */ void m269x8a337184(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        selectWay();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-electricitymeter-ElecMeterAnalysisActivity, reason: not valid java name */
    /* synthetic */ void m270xf8ba82c5(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        selectTime();
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
        this.mPullRefreshLayout.setRefreshing(false);
        ErrorControlUtil.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void getRoomInformationElecMeter() {
        this.mSchoolId = UserInfoUtilControl.getInstance().getSchoolId();
        this.mInvestorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        this.mStudentId = UserInfoUtilControl.getInstance().getStudentId();
        V3BusinessControllers.getInstance().getRoomInformationElecMeter(getLoginAccount(), this.mSchoolId, this.mInvestorId, this.mStudentId, 1, new Listener<BindElecMeterRoomInfoBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAnalysisActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(ElecMeterAnalysisActivity.this.getActivity(), "获取房间信息.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BindElecMeterRoomInfoBean bindElecMeterRoomInfoBean, Object... objArr) {
                super.onComplete(controller, bindElecMeterRoomInfoBean, objArr);
                if (ElecMeterAnalysisActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ElecMeterAnalysisActivity.this.mBindElecMeterRoomInfoBean = bindElecMeterRoomInfoBean;
                    ElecMeterAnalysisActivity.this.getMetersTrend();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ElecMeterAnalysisActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ErrorControlUtil.getInstance().onError(ElecMeterAnalysisActivity.this.getLoginAccount(), clientException, ElecMeterAnalysisActivity.this.getActivity(), true, ElecMeterAnalysisActivity.this.mTitleBar.getTitleViewContent());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x00a2  */
    public void getMetersTrend() {
        String str;
        String date;
        String date2;
        String str2;
        String str3;
        int i = this.mSelectWayIndex;
        if (i == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            long j = jCurrentTimeMillis - 518400;
            if (this.mSelectTimeIndex == 1) {
                j = jCurrentTimeMillis - 2592000;
            }
            date = TimeUtils.formatDate(j * 1000);
            date2 = TimeUtils.formatDate(jCurrentTimeMillis * 1000);
            str2 = "";
            str3 = str2;
            str = "day";
        } else if (i == 1) {
            String date_YEARMONTH = TimeUtils.formatDate_YEARMONTH(System.currentTimeMillis());
            String[] strArrSplit = date_YEARMONTH.split(x.A);
            if (strArrSplit == null || strArrSplit.length != 2) {
                date = "";
                date2 = date;
                str2 = date2;
                str3 = str2;
            } else {
                int i2 = this.mSelectTimeIndex;
                if (i2 == 0) {
                    str3 = date_YEARMONTH;
                    str2 = strArrSplit[0] + "-01";
                } else if (i2 == 1) {
                    str2 = (Integer.parseInt(strArrSplit[0]) - 1) + "-01";
                    str3 = (Integer.parseInt(strArrSplit[0]) - 1) + "-12";
                } else {
                    date = "";
                    date2 = date;
                    str2 = date2;
                    str3 = str2;
                }
                date = "";
                date2 = date;
            }
            str = "month";
        } else {
            str = "";
            date = str;
            date2 = date;
            str2 = date2;
            str3 = str2;
        }
        V3BusinessControllers.getInstance().getMetersTrend(getLoginAccount(), this.mSchoolId, this.mInvestorId, this.mStudentId, 1, str, date, date2, str2, str3, this.mBindElecMeterRoomInfoBean.regionalCode, this.mBindElecMeterRoomInfoBean.buildingCode, this.mBindElecMeterRoomInfoBean.floorCode, this.mBindElecMeterRoomInfoBean.roomCode, new Listener<List<MetersTrendBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAnalysisActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                ElecMeterAnalysisActivity.this.mTvNoData.setVisibility(8);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<MetersTrendBean> list, Object... objArr) {
                super.onComplete(controller, list, objArr);
                if (ElecMeterAnalysisActivity.this.mIsEnable) {
                    ElecMeterAnalysisActivity.this.mPullRefreshLayout.setRefreshing(false);
                    LogUtil.e(ElecMeterAnalysisActivity.TAG, "getMetersTrend:" + list.size());
                    if (list.size() == 0) {
                        ElecMeterAnalysisActivity.this.mTvNoData.setVisibility(0);
                    }
                    ElecMeterAnalysisActivity.this.initData(list);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ElecMeterAnalysisActivity.this.mIsEnable) {
                    ElecMeterAnalysisActivity.this.mPullRefreshLayout.setRefreshing(false);
                    ErrorControlUtil.getInstance().onError(ElecMeterAnalysisActivity.this.getLoginAccount(), clientException, ElecMeterAnalysisActivity.this.getActivity(), false, ElecMeterAnalysisActivity.this.mTitleBar.getTitleViewContent());
                }
            }
        });
    }

    private void initLineChartSevenDay(final List<MetersTrendBean> list) {
        this.mDayDatas.clear();
        this.mElecMeterAnalysisAdapter.setData(this.mDayDatas);
        this.mElecMeterAnalysisAdapter.notifyDataSetChanged();
        this.mLineChart.clear();
        if (list == null || list.size() == 0) {
            return;
        }
        this.mDayDatas = list;
        this.mElecMeterAnalysisAdapter.setData(list);
        this.mElecMeterAnalysisAdapter.notifyDataSetChanged();
        XAxis xAxis = this.mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);
        xAxis.setValueFormatter(new ValueFormatter() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAnalysisActivity.5
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float f) {
                String str = ((MetersTrendBean) list.get((int) f)).point;
                return (!StringUtils.isNotEmpty(str) || str.length() <= 5) ? "xx" : str.substring(5);
            }
        });
        xAxis.setLabelCount(list.size() - 1, false);
        xAxis.setAxisMaximum(list.size() - 1);
        xAxis.setAxisMinimum(0.0f);
        xAxis.setGranularity(1.0f);
        YAxis axisLeft = this.mLineChart.getAxisLeft();
        axisLeft.setDrawGridLines(true);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setLabelCount(5, false);
        axisLeft.setAxisMaximum(100.0f);
        axisLeft.setAxisMinimum(0.0f);
        this.mLineChart.getAxisRight().setEnabled(false);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new Entry(i, Float.parseFloat(list.get(i).usageAmount)));
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, "");
        lineDataSet.setLineWidth(2.0f);
        lineDataSet.setColor(getResources().getColor(R.color.fffac858));
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawValues(false);
        this.mLineChart.setData(new LineData(lineDataSet));
        this.mLineChart.getDescription().setEnabled(false);
        this.mLineChart.getLegend().setEnabled(false);
        ((LineData) this.mLineChart.getData()).notifyDataChanged();
        this.mLineChart.notifyDataSetChanged();
        this.mLineChart.invalidate();
        this.mLineChart.setDragEnabled(false);
        this.mLineChart.setTouchEnabled(false);
    }

    private void initLineChartMonth(final List<MetersTrendBean> list) {
        this.mDayDatas.clear();
        this.mElecMeterAnalysisAdapter.setData(this.mDayDatas);
        this.mElecMeterAnalysisAdapter.notifyDataSetChanged();
        this.mLineChart.clear();
        if (list == null || list.size() == 0) {
            return;
        }
        this.mDayDatas = list;
        this.mElecMeterAnalysisAdapter.setData(list);
        this.mElecMeterAnalysisAdapter.notifyDataSetChanged();
        XAxis xAxis = this.mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);
        xAxis.setValueFormatter(new ValueFormatter() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAnalysisActivity.6
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float f) {
                String str = ((MetersTrendBean) list.get((int) f)).point;
                return (!StringUtils.isNotEmpty(str) || str.length() <= 5) ? "xx" : str.substring(5);
            }
        });
        xAxis.setLabelCount(list.size() - 1, false);
        xAxis.setAxisMaximum(list.size() - 1);
        xAxis.setAxisMinimum(0.0f);
        xAxis.setGranularity(5.0f);
        YAxis axisLeft = this.mLineChart.getAxisLeft();
        axisLeft.setDrawGridLines(true);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setLabelCount(5, false);
        axisLeft.setAxisMaximum(100.0f);
        axisLeft.setAxisMinimum(0.0f);
        this.mLineChart.getAxisRight().setEnabled(false);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new Entry(i, Float.parseFloat(list.get(i).usageAmount)));
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, "");
        lineDataSet.setLineWidth(2.0f);
        lineDataSet.setColor(getResources().getColor(R.color.fffac858));
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawValues(false);
        this.mLineChart.setData(new LineData(lineDataSet));
        this.mLineChart.getDescription().setEnabled(false);
        this.mLineChart.getLegend().setEnabled(false);
        ((LineData) this.mLineChart.getData()).notifyDataChanged();
        this.mLineChart.notifyDataSetChanged();
        this.mLineChart.invalidate();
        this.mLineChart.setDragEnabled(false);
        this.mLineChart.setTouchEnabled(false);
    }

    private void initLineChartYear(final List<MetersTrendBean> list) {
        this.mDayDatas.clear();
        this.mElecMeterAnalysisAdapter.setData(this.mDayDatas);
        this.mElecMeterAnalysisAdapter.notifyDataSetChanged();
        this.mLineChart.clear();
        if (list == null || list.size() == 0) {
            return;
        }
        this.mDayDatas = list;
        this.mElecMeterAnalysisAdapter.setData(list);
        this.mElecMeterAnalysisAdapter.notifyDataSetChanged();
        XAxis xAxis = this.mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);
        xAxis.setValueFormatter(new ValueFormatter() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAnalysisActivity.7
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float f) {
                int i = (int) f;
                LogUtil.e(ElecMeterAnalysisActivity.TAG, "getFormattedValue:" + i + "  " + list.size());
                if (i >= list.size()) {
                    return i + "月";
                }
                String str = ((MetersTrendBean) list.get(i)).point;
                return (!StringUtils.isNotEmpty(str) || str.length() <= 5) ? "xx月" : str.substring(5) + "月";
            }
        });
        xAxis.setLabelCount(list.size() - 1, false);
        xAxis.setAxisMaximum(list.size() - 1);
        xAxis.setAxisMinimum(0.0f);
        xAxis.setGranularity(1.0f);
        YAxis axisLeft = this.mLineChart.getAxisLeft();
        axisLeft.setDrawGridLines(true);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setLabelCount(5, false);
        axisLeft.setAxisMaximum(100.0f);
        axisLeft.setAxisMinimum(0.0f);
        this.mLineChart.getAxisRight().setEnabled(false);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            LogUtil.e(TAG, "getFormattedValue:" + list.get(i).point + "  " + i);
            arrayList.add(new Entry(i, Float.parseFloat(list.get(i).usageAmount)));
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, "");
        lineDataSet.setLineWidth(2.0f);
        lineDataSet.setColor(getResources().getColor(R.color.fffac858));
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawValues(false);
        this.mLineChart.setData(new LineData(lineDataSet));
        this.mLineChart.getDescription().setEnabled(false);
        this.mLineChart.getLegend().setEnabled(false);
        ((LineData) this.mLineChart.getData()).notifyDataChanged();
        this.mLineChart.notifyDataSetChanged();
        this.mLineChart.invalidate();
        this.mLineChart.setDragEnabled(false);
        this.mLineChart.setTouchEnabled(false);
    }

    private void selectWay() {
        initAnim(0.0f, 180.0f);
        this.mIvWayDrop.startAnimation(this.rotate);
        this.myPopWindow.showPop(this.mTopView, this.mSelectWayIndex, this.mWayStrs, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAnalysisActivity.8
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                ElecMeterAnalysisActivity.this.mTvWay.setText((CharSequence) ElecMeterAnalysisActivity.this.mWayStrs.get(i));
                if (ElecMeterAnalysisActivity.this.mSelectWayIndex != i) {
                    ElecMeterAnalysisActivity.this.mSelectWayIndex = i;
                    ElecMeterAnalysisActivity.this.mSelectTimeIndex = 0;
                    ElecMeterAnalysisActivity.this.initViewData();
                    ElecMeterAnalysisActivity.this.getMetersTrend();
                }
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                ElecMeterAnalysisActivity.this.initAnim(180.0f, 360.0f);
                ElecMeterAnalysisActivity.this.mIvWayDrop.startAnimation(ElecMeterAnalysisActivity.this.rotate);
            }
        });
    }

    private void selectTime() {
        initAnim(0.0f, 180.0f);
        this.mIvTimeDrop.startAnimation(this.rotate);
        this.myPopWindow.showPop(this.mTopView, this.mSelectTimeIndex, this.mTimeStrs, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAnalysisActivity.9
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                ElecMeterAnalysisActivity.this.mTvTime.setText((CharSequence) ElecMeterAnalysisActivity.this.mTimeStrs.get(i));
                if (ElecMeterAnalysisActivity.this.mSelectTimeIndex != i) {
                    ElecMeterAnalysisActivity.this.mSelectTimeIndex = i;
                    ElecMeterAnalysisActivity.this.initViewData();
                    ElecMeterAnalysisActivity.this.getMetersTrend();
                }
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                ElecMeterAnalysisActivity.this.initAnim(180.0f, 360.0f);
                ElecMeterAnalysisActivity.this.mIvTimeDrop.startAnimation(ElecMeterAnalysisActivity.this.rotate);
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

    private String getDateTime(int i) {
        long j;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        switch (i) {
            case 0:
                j = 518400;
                jCurrentTimeMillis -= j;
                break;
            case 1:
                j = 432000;
                jCurrentTimeMillis -= j;
                break;
            case 2:
                j = 345600;
                jCurrentTimeMillis -= j;
                break;
            case 3:
                j = 259200;
                jCurrentTimeMillis -= j;
                break;
            case 4:
                j = 172800;
                jCurrentTimeMillis -= j;
                break;
            case 5:
                j = 86400;
                jCurrentTimeMillis -= j;
                break;
            case 6:
                break;
            default:
                jCurrentTimeMillis = 0;
                break;
        }
        String str = new SimpleDateFormat("M-d").format(new Date(jCurrentTimeMillis * 1000));
        LogUtil.e(TAG, "getFormattedValue:" + str);
        return str;
    }

    private String getMonth(int i) {
        long j;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        switch (i) {
            case 0:
                j = 2592000;
                jCurrentTimeMillis -= j;
                break;
            case 1:
                j = 2505600;
                jCurrentTimeMillis -= j;
                break;
            case 2:
                j = 2419200;
                jCurrentTimeMillis -= j;
                break;
            case 3:
                j = 2332800;
                jCurrentTimeMillis -= j;
                break;
            case 4:
                j = 2246400;
                jCurrentTimeMillis -= j;
                break;
            case 5:
                j = 2160000;
                jCurrentTimeMillis -= j;
                break;
            case 6:
                j = 2073600;
                jCurrentTimeMillis -= j;
                break;
            case 7:
                j = 1987200;
                jCurrentTimeMillis -= j;
                break;
            case 8:
                j = 1900800;
                jCurrentTimeMillis -= j;
                break;
            case 9:
                j = 1814400;
                jCurrentTimeMillis -= j;
                break;
            case 10:
                j = 1728000;
                jCurrentTimeMillis -= j;
                break;
            case 11:
                j = 1641600;
                jCurrentTimeMillis -= j;
                break;
            case 12:
                j = 1555200;
                jCurrentTimeMillis -= j;
                break;
            case 13:
                j = 1468800;
                jCurrentTimeMillis -= j;
                break;
            case 14:
                j = 1382400;
                jCurrentTimeMillis -= j;
                break;
            case 15:
                j = 1296000;
                jCurrentTimeMillis -= j;
                break;
            case 16:
                j = 1209600;
                jCurrentTimeMillis -= j;
                break;
            case 17:
                j = 1123200;
                jCurrentTimeMillis -= j;
                break;
            case 18:
                j = 1036800;
                jCurrentTimeMillis -= j;
                break;
            case 19:
                j = 950400;
                jCurrentTimeMillis -= j;
                break;
            case 20:
                j = 864000;
                jCurrentTimeMillis -= j;
                break;
            case 21:
                j = 777600;
                jCurrentTimeMillis -= j;
                break;
            case 22:
                j = 691200;
                jCurrentTimeMillis -= j;
                break;
            case 23:
                j = 604800;
                jCurrentTimeMillis -= j;
                break;
            case 24:
                j = 518400;
                jCurrentTimeMillis -= j;
                break;
            case 25:
                j = 432000;
                jCurrentTimeMillis -= j;
                break;
            case 26:
                j = 345600;
                jCurrentTimeMillis -= j;
                break;
            case 27:
                j = 259200;
                jCurrentTimeMillis -= j;
                break;
            case 28:
                j = 172800;
                jCurrentTimeMillis -= j;
                break;
            case 29:
                j = 86400;
                jCurrentTimeMillis -= j;
                break;
            case 30:
                break;
            default:
                jCurrentTimeMillis = 0;
                break;
        }
        String str = new SimpleDateFormat("M-d").format(new Date(1000 * jCurrentTimeMillis));
        LogUtil.e(TAG, "getFormattedValue: " + str + PPSLabelView.Code + jCurrentTimeMillis);
        return str;
    }

    private String getYear(int i) {
        if (i >= 10) {
            return x.A + i;
        }
        return "-0" + i;
    }
}
