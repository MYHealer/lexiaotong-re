package client.android.yixiaotong.v3.ui.appcontrol.bath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.bean.appointment.AppointmentBean;
import client.android.yixiaotong.v3.bean.appointment.AppointmentListBean;
import client.android.yixiaotong.v3.bean.appointment.AppointmentResultBean;
import client.android.yixiaotong.v3.bean.appointment.UsingBean;
import client.android.yixiaotong.v3.bean.area.AreaListBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.weight.AddressPopWindow;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.google.android.exoplayer2.C;
import com.hihonor.adsdk.base.ErrorCode;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AppointmentBathActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String TAG = "AppointmentBathActivity";
    private AddressPopWindow mAddressPopWindow;
    private AppointmentAdapter mAppointmentAdapter;
    private AppointmentListBean mAppointmentListBean;
    private int mBookState;
    private String mId;
    private boolean mIsEnable;
    ImageView mIvArea;
    ImageView mIvCeng;
    ImageView mIvDong;
    ImageView mIvRoom;
    LinearLayout mLinTitle;
    WrapListView mLvAppointment;
    RelativeLayout mRelAppointment;
    RelativeLayout mRelArea;
    ScrollView mScrollView;
    private String mSiteFlag;
    PullRefreshLayout mSwipeRefreshLayout;
    TitleBar mTitleBar;
    TextView mTvArea;
    TextView mTvCeng;
    TextView mTvDong;
    TextView mTvNoUse;
    TextView mTvRoom;
    TextView mTvUse;
    private int mTypeId;
    private UsingBean mUsingBean;
    private RotateAnimation rotate;
    private List<AreaListBean> mAreaListBeans = new ArrayList();
    private State mState = State.none;
    private List<String> mAddressList = new ArrayList();
    private int mSelectIndex = -1;
    private List<UsingBean> mUsingBeanList = new ArrayList();
    private int mCount = 0;

    public enum State {
        none,
        area,
        areaend,
        dong,
        dongend,
        ceng,
        cengend,
        room
    }

    static {
        StubApp.interface11(9025);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getBtnStr(int i) {
        if (i == -1) {
            return "故障";
        }
        if (i == 0) {
            return "预约";
        }
        if (i == 200) {
            return "停用";
        }
        if (i == 201) {
            return "未授权";
        }
        if (i == 202) {
            return "未初始化";
        }
        if (i == 210) {
            return "不存在";
        }
        return (i < 100 || i > 199) ? "其他" : "使用中";
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public static void launch(Activity activity, int i, int i2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) AppointmentBathActivity.class).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i).putExtra("state", i2));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mLinTitle = (LinearLayout) findViewById(R.id.lin_title);
        this.mRelArea = (RelativeLayout) findViewById(R.id.rel_area);
        this.mTvArea = (TextView) findViewById(R.id.tv_area);
        this.mIvArea = (ImageView) findViewById(R.id.iv_area);
        this.mTvDong = (TextView) findViewById(R.id.tv_dong);
        this.mIvDong = (ImageView) findViewById(R.id.iv_dong);
        this.mTvCeng = (TextView) findViewById(R.id.tv_ceng);
        this.mIvCeng = (ImageView) findViewById(R.id.iv_ceng);
        this.mTvRoom = (TextView) findViewById(R.id.tv_room);
        this.mIvRoom = (ImageView) findViewById(R.id.iv_room);
        this.mRelAppointment = (RelativeLayout) findViewById(R.id.rel_appointment);
        this.mTvUse = (TextView) findViewById(R.id.tv_use);
        this.mTvNoUse = (TextView) findViewById(R.id.tv_nouse);
        this.mLvAppointment = (WrapListView) findViewById(R.id.lv_appointment);
        this.mScrollView = (ScrollView) findViewById(R.id.scrollView);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("预约服务");
        if (this.mBookState == 2) {
            this.mTitleBar.setTitleView("水控状态");
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels / 4;
        this.mTvArea.setMaxWidth(i - ((int) (displayMetrics.density * 25.0f)));
        this.mTvDong.setMaxWidth(i - ((int) (displayMetrics.density * 25.0f)));
        this.mTvCeng.setMaxWidth(i - ((int) (displayMetrics.density * 25.0f)));
        this.mTvRoom.setMaxWidth(i - ((int) (displayMetrics.density * 25.0f)));
        LogUtil.e(TAG, i + "  " + displayMetrics.density + PPSLabelView.Code + ((int) (displayMetrics.density * 20.0f)));
        String appointmentArea = LocalDataUtil.getAppointmentArea(getContext());
        if (StringUtils.isNotEmpty(appointmentArea)) {
            String[] strArrSplit = appointmentArea.split(",");
            if (strArrSplit.length >= 2) {
                this.mId = strArrSplit[0];
                this.mTvArea.setText(strArrSplit[1]);
            }
            if (strArrSplit.length >= 4) {
                this.mId = strArrSplit[2];
                this.mTvDong.setText(strArrSplit[3]);
            }
            if (strArrSplit.length >= 6) {
                this.mId = strArrSplit[4];
                this.mTvCeng.setText(strArrSplit[5]);
            }
            if (strArrSplit.length >= 9) {
                this.mId = strArrSplit[6];
                this.mSiteFlag = strArrSplit[8];
                this.mTvRoom.setText(strArrSplit[7]);
                getReserverDevices();
            }
        }
        AppointmentAdapter appointmentAdapter = new AppointmentAdapter();
        this.mAppointmentAdapter = appointmentAdapter;
        this.mLvAppointment.setAdapter((ListAdapter) appointmentAdapter);
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.1
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                AppointmentBathActivity.this.getReserverDevices();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setView(boolean z) {
        if (z) {
            this.mRelAppointment.setVisibility(8);
            this.mAddressPopWindow.showPop(this.mLinTitle, this.mSelectIndex, this.mAddressList, new AddressPopWindow.PopWindowListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.2
                @Override // client.android.yixiaotong.v3.ui.weight.AddressPopWindow.PopWindowListener
                public void onShow(int i) {
                    LogUtil.e(AppointmentBathActivity.TAG, "onShow:" + i);
                    AppointmentBathActivity.this.mSelectIndex = i;
                    AreaListBean areaListBean = (AreaListBean) AppointmentBathActivity.this.mAreaListBeans.get(AppointmentBathActivity.this.mSelectIndex);
                    if (AppointmentBathActivity.this.mState != State.area) {
                        if (AppointmentBathActivity.this.mState != State.dong) {
                            if (AppointmentBathActivity.this.mState != State.ceng) {
                                if (AppointmentBathActivity.this.mState == State.room) {
                                    AppointmentBathActivity.this.mTvRoom.setText(areaListBean.name);
                                    String appointmentArea = LocalDataUtil.getAppointmentArea(AppointmentBathActivity.this.getContext());
                                    String[] strArrSplit = appointmentArea.split(",");
                                    if (strArrSplit.length > 6) {
                                        appointmentArea = strArrSplit[0] + "," + strArrSplit[1] + "," + strArrSplit[2] + "," + strArrSplit[3] + "," + strArrSplit[4] + "," + strArrSplit[5];
                                    }
                                    LocalDataUtil.saveAppointmentArea(AppointmentBathActivity.this.getContext(), appointmentArea + "," + areaListBean.id + "," + areaListBean.name + "," + areaListBean.siteFlag);
                                    LogUtil.e(AppointmentBathActivity.TAG, areaListBean.id + "  " + areaListBean.name + "  " + areaListBean.siteFlag);
                                    return;
                                }
                                return;
                            }
                            AppointmentBathActivity.this.mTvCeng.setText(areaListBean.name);
                            AppointmentBathActivity.this.mTvRoom.setText("");
                            String appointmentArea2 = LocalDataUtil.getAppointmentArea(AppointmentBathActivity.this.getContext());
                            String[] strArrSplit2 = appointmentArea2.split(",");
                            if (strArrSplit2.length > 4) {
                                appointmentArea2 = strArrSplit2[0] + "," + strArrSplit2[1] + "," + strArrSplit2[2] + "," + strArrSplit2[3];
                            }
                            LocalDataUtil.saveAppointmentArea(AppointmentBathActivity.this.getContext(), appointmentArea2 + "," + areaListBean.id + "," + areaListBean.name);
                            return;
                        }
                        AppointmentBathActivity.this.mTvDong.setText(areaListBean.name);
                        AppointmentBathActivity.this.mTvCeng.setText("");
                        AppointmentBathActivity.this.mTvRoom.setText("");
                        String appointmentArea3 = LocalDataUtil.getAppointmentArea(AppointmentBathActivity.this.getContext());
                        String[] strArrSplit3 = appointmentArea3.split(",");
                        if (strArrSplit3.length > 2) {
                            appointmentArea3 = strArrSplit3[0] + "," + strArrSplit3[1];
                        }
                        LocalDataUtil.saveAppointmentArea(AppointmentBathActivity.this.getContext(), appointmentArea3 + "," + areaListBean.id + "," + areaListBean.name);
                        return;
                    }
                    AppointmentBathActivity.this.mTvArea.setText(areaListBean.name);
                    AppointmentBathActivity.this.mTvDong.setText("");
                    AppointmentBathActivity.this.mTvCeng.setText("");
                    AppointmentBathActivity.this.mTvRoom.setText("");
                    LocalDataUtil.saveAppointmentArea(AppointmentBathActivity.this.getContext(), areaListBean.id + "," + areaListBean.name);
                }

                @Override // client.android.yixiaotong.v3.ui.weight.AddressPopWindow.PopWindowListener
                public void onDiss() {
                    LogUtil.e(AppointmentBathActivity.TAG, "onDiss:" + AppointmentBathActivity.this.mSelectIndex + "  " + AppointmentBathActivity.this.mState + "  " + StringUtils.isNotEmpty(AppointmentBathActivity.this.mTvRoom.getText().toString()));
                    AppointmentBathActivity.this.setViewRotate(false);
                    if (AppointmentBathActivity.this.mState == State.room && StringUtils.isNotEmpty(AppointmentBathActivity.this.mTvRoom.getText().toString())) {
                        String appointmentArea = LocalDataUtil.getAppointmentArea(AppointmentBathActivity.this.getContext());
                        LogUtil.e(AppointmentBathActivity.TAG, appointmentArea);
                        if (StringUtils.isNotEmpty(appointmentArea)) {
                            String[] strArrSplit = appointmentArea.split(",");
                            if (strArrSplit.length >= 9) {
                                AppointmentBathActivity.this.mId = strArrSplit[6];
                                AppointmentBathActivity.this.mSiteFlag = strArrSplit[8];
                            }
                        }
                        LogUtil.e(AppointmentBathActivity.TAG, "onDiss:" + AppointmentBathActivity.this.mId);
                        if (StringUtils.isNotEmpty(AppointmentBathActivity.this.mId)) {
                            AppointmentBathActivity.this.getReserverDevices();
                        }
                    }
                }
            });
            return;
        }
        this.mRelAppointment.setVisibility(0);
        this.mTvUse.setText(this.mAppointmentListBean.usedNum + "");
        this.mTvNoUse.setText(this.mAppointmentListBean.idleNum + "");
        this.mUsingBeanList.clear();
        if (this.mAppointmentListBean.machineStatusList != null && this.mAppointmentListBean.machineStatusList.size() > 0) {
            for (int i = 0; i < this.mAppointmentListBean.machineStatusList.size(); i++) {
                this.mUsingBeanList.add(this.mAppointmentListBean.machineStatusList.get(i));
            }
        }
        this.mAppointmentAdapter.notifyDataSetChanged();
    }

    private void initClickListeners() {
        findViewById(R.id.rel_area).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m235x57c2bf31(view);
            }
        });
        findViewById(R.id.rel_dong).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m236x1ecea632(view);
            }
        });
        findViewById(R.id.rel_ceng).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m237xe5da8d33(view);
            }
        });
        findViewById(R.id.rel_room).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m238xace67434(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-bath-AppointmentBathActivity, reason: not valid java name */
    /* synthetic */ void m235x57c2bf31(View view) {
        this.mSelectIndex = -1;
        this.mState = State.area;
        setViewRotate(true);
        this.mId = UserInfoUtilControl.getInstance().getSchoolId();
        getPublicArea();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-bath-AppointmentBathActivity, reason: not valid java name */
    /* synthetic */ void m236x1ecea632(View view) {
        if (StringUtils.isEmpty(this.mTvArea.getText().toString())) {
            ToastUtils.show(getContext(), "请选择上一层");
            return;
        }
        this.mSelectIndex = -1;
        this.mState = State.dong;
        setViewRotate(true);
        String[] strArrSplit = LocalDataUtil.getAppointmentArea(getContext()).split(",");
        if (strArrSplit.length >= 2) {
            this.mId = strArrSplit[0];
            getPublicArea();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-appcontrol-bath-AppointmentBathActivity, reason: not valid java name */
    /* synthetic */ void m237xe5da8d33(View view) {
        if (StringUtils.isEmpty(this.mTvDong.getText().toString())) {
            ToastUtils.show(getContext(), "请选择上一层");
            return;
        }
        this.mSelectIndex = -1;
        this.mState = State.ceng;
        setViewRotate(true);
        String[] strArrSplit = LocalDataUtil.getAppointmentArea(getContext()).split(",");
        if (strArrSplit.length >= 4) {
            this.mId = strArrSplit[2];
            getPublicArea();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-appcontrol-bath-AppointmentBathActivity, reason: not valid java name */
    /* synthetic */ void m238xace67434(View view) {
        if (StringUtils.isEmpty(this.mTvCeng.getText().toString())) {
            ToastUtils.show(getContext(), "请选择上一层");
            return;
        }
        this.mSelectIndex = -1;
        this.mState = State.room;
        setViewRotate(true);
        String[] strArrSplit = LocalDataUtil.getAppointmentArea(getContext()).split(",");
        if (strArrSplit.length >= 6) {
            this.mId = strArrSplit[4];
            getRoomInfo();
        }
    }

    private void initAnim(float f, float f2) {
        RotateAnimation rotateAnimation = new RotateAnimation(f, f2, 1, 0.5f, 1, 0.5f);
        this.rotate = rotateAnimation;
        rotateAnimation.setDuration(500L);
        this.rotate.setFillAfter(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewRotate(boolean z) {
        if (this.mState == State.area) {
            if (z) {
                initAnim(0.0f, 180.0f);
            } else {
                initAnim(180.0f, 360.0f);
            }
            this.mIvArea.startAnimation(this.rotate);
            return;
        }
        if (this.mState == State.dong) {
            if (z) {
                initAnim(0.0f, 180.0f);
            } else {
                initAnim(180.0f, 360.0f);
            }
            this.mIvDong.startAnimation(this.rotate);
            return;
        }
        if (this.mState == State.ceng) {
            if (z) {
                initAnim(0.0f, 180.0f);
            } else {
                initAnim(180.0f, 360.0f);
            }
            this.mIvCeng.startAnimation(this.rotate);
            return;
        }
        if (this.mState == State.room) {
            if (z) {
                initAnim(0.0f, 180.0f);
            } else {
                initAnim(180.0f, 360.0f);
            }
            this.mIvRoom.startAnimation(this.rotate);
        }
    }

    private void getPublicArea() {
        V3BusinessControllers.getInstance().getLowerAreas(getLoginAccount(), this.mId, new Listener<List<AreaListBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<AreaListBean> list, Object... objArr) {
                if (!AppointmentBathActivity.this.mIsEnable || list == null || list.size() <= 0) {
                    return;
                }
                LogUtil.w(AppointmentBathActivity.TAG, list.size() + "");
                AppointmentBathActivity.this.mAreaListBeans.clear();
                AppointmentBathActivity.this.mAreaListBeans = list;
                AppointmentBathActivity.this.mAddressList.clear();
                for (int i = 0; i < AppointmentBathActivity.this.mAreaListBeans.size(); i++) {
                    AppointmentBathActivity.this.mAddressList.add(((AreaListBean) AppointmentBathActivity.this.mAreaListBeans.get(i)).name);
                    if (AppointmentBathActivity.this.mState != State.area || !((AreaListBean) AppointmentBathActivity.this.mAreaListBeans.get(i)).name.equals(AppointmentBathActivity.this.mTvArea.getText().toString())) {
                        if (AppointmentBathActivity.this.mState != State.dong || !((AreaListBean) AppointmentBathActivity.this.mAreaListBeans.get(i)).name.equals(AppointmentBathActivity.this.mTvDong.getText().toString())) {
                            if (AppointmentBathActivity.this.mState != State.ceng || !((AreaListBean) AppointmentBathActivity.this.mAreaListBeans.get(i)).name.equals(AppointmentBathActivity.this.mTvCeng.getText().toString())) {
                                if (AppointmentBathActivity.this.mState == State.room && ((AreaListBean) AppointmentBathActivity.this.mAreaListBeans.get(i)).name.equals(AppointmentBathActivity.this.mTvRoom.getText().toString())) {
                                    AppointmentBathActivity.this.mSelectIndex = i;
                                }
                            } else {
                                AppointmentBathActivity.this.mSelectIndex = i;
                            }
                        } else {
                            AppointmentBathActivity.this.mSelectIndex = i;
                        }
                    } else {
                        AppointmentBathActivity.this.mSelectIndex = i;
                    }
                }
                AppointmentBathActivity.this.setView(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (AppointmentBathActivity.this.mIsEnable) {
                    AppointmentBathActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getRoomInfo() {
        V3BusinessControllers.getInstance().getDormitoryOrPublicRoom(getLoginAccount(), this.mId, new Listener<List<AreaListBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<AreaListBean> list, Object... objArr) {
                if (!AppointmentBathActivity.this.mIsEnable || list == null) {
                    return;
                }
                LogUtil.w(AppointmentBathActivity.TAG, list.size() + "");
                AppointmentBathActivity.this.mAreaListBeans.clear();
                AppointmentBathActivity.this.mAreaListBeans = list;
                AppointmentBathActivity.this.mAddressList.clear();
                for (int i = 0; i < AppointmentBathActivity.this.mAreaListBeans.size(); i++) {
                    AppointmentBathActivity.this.mAddressList.add(((AreaListBean) AppointmentBathActivity.this.mAreaListBeans.get(i)).name);
                    if (AppointmentBathActivity.this.mState != State.area || !((AreaListBean) AppointmentBathActivity.this.mAreaListBeans.get(i)).name.equals(AppointmentBathActivity.this.mTvArea.getText().toString())) {
                        if (AppointmentBathActivity.this.mState != State.dong || !((AreaListBean) AppointmentBathActivity.this.mAreaListBeans.get(i)).name.equals(AppointmentBathActivity.this.mTvDong.getText().toString())) {
                            if (AppointmentBathActivity.this.mState != State.ceng || !((AreaListBean) AppointmentBathActivity.this.mAreaListBeans.get(i)).name.equals(AppointmentBathActivity.this.mTvCeng.getText().toString())) {
                                if (AppointmentBathActivity.this.mState == State.room && ((AreaListBean) AppointmentBathActivity.this.mAreaListBeans.get(i)).name.equals(AppointmentBathActivity.this.mTvRoom.getText().toString())) {
                                    AppointmentBathActivity.this.mSelectIndex = i;
                                }
                            } else {
                                AppointmentBathActivity.this.mSelectIndex = i;
                            }
                        } else {
                            AppointmentBathActivity.this.mSelectIndex = i;
                        }
                    } else {
                        AppointmentBathActivity.this.mSelectIndex = i;
                    }
                }
                AppointmentBathActivity.this.setView(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (AppointmentBathActivity.this.mIsEnable) {
                    AppointmentBathActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getReserverDevices() {
        V3BusinessControllers.getInstance().getList(getLoginAccount(), UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, this.mId, this.mSiteFlag, this.mTypeId, new Listener<AppointmentListBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (AppointmentBathActivity.this.mSwipeRefreshLayout != null) {
                    AppointmentBathActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AppointmentListBean appointmentListBean, Object... objArr) {
                if (AppointmentBathActivity.this.mIsEnable) {
                    if (AppointmentBathActivity.this.mSwipeRefreshLayout != null) {
                        AppointmentBathActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    }
                    if (AppointmentBathActivity.this.mState == State.none || AppointmentBathActivity.this.mState == State.room) {
                        AppointmentBathActivity.this.mAppointmentListBean = appointmentListBean;
                        AppointmentBathActivity.this.setView(false);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (AppointmentBathActivity.this.mIsEnable) {
                    if (AppointmentBathActivity.this.mSwipeRefreshLayout != null) {
                        AppointmentBathActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    }
                    if (AppointmentBathActivity.this.mState == State.none || AppointmentBathActivity.this.mState == State.room) {
                        AppointmentBathActivity.this.onError(clientException);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reserve(int i) {
        this.mCount = 0;
        this.mUsingBean = null;
        V3BusinessControllers.getInstance().reserve(getLoginAccount(), this.mUsingBeanList.get(i).machineId, 4, this.mTypeId, new Listener<AppointmentBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(AppointmentBathActivity.this.getActivity(), "预约中", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AppointmentBean appointmentBean, Object... objArr) {
                if (AppointmentBathActivity.this.mIsEnable) {
                    if (!StringUtils.isNotEmpty(appointmentBean.communicationWord)) {
                        AppointmentBathActivity.this.showDialog(true, true, ErrorCode.AD_APP_RESERVE_FAIL_MSG);
                    } else {
                        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AppointmentBathActivity.this.getAppiontmentState();
                            }
                        }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (AppointmentBathActivity.this.mIsEnable) {
                    AppointmentBathActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAppiontmentState() {
        int i = this.mCount;
        if (i >= 5) {
            BaseMaterialDialog.dissmisMaterialDialog();
            ToastUtils.show(getContext(), "预约失败，请重试");
            cancel();
        } else {
            this.mCount = i + 1;
            V3BusinessControllers.getInstance().getUsingList(getLoginAccount(), UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, this.mTypeId, new Listener<List<UsingBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.7
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.setConnectMaterialDialog("正在查询预约结果…");
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, List<UsingBean> list, Object... objArr) {
                    if (AppointmentBathActivity.this.mIsEnable) {
                        if (AppointmentBathActivity.this.mSwipeRefreshLayout != null) {
                            AppointmentBathActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        }
                        if (list != null && list.size() > 0) {
                            AppointmentBathActivity.this.mUsingBean = list.get(0);
                            if (list.get(0).curStatus == 121) {
                                BaseMaterialDialog.dissmisMaterialDialog();
                                AppointBathSuccessActivity.launch(AppointmentBathActivity.this.getActivity(), list.get(0), AppointmentBathActivity.this.mTypeId);
                                AppointmentBathActivity.this.finish();
                                return;
                            }
                            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AppointmentBathActivity.this.getAppiontmentState();
                                }
                            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                            return;
                        }
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ToastUtils.show(AppointmentBathActivity.this.getContext(), ErrorCode.AD_APP_RESERVE_FAIL_MSG);
                        AppointmentBathActivity.this.cancel();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (AppointmentBathActivity.this.mIsEnable) {
                        AppointmentBathActivity.this.onError(clientException);
                    }
                }
            });
        }
    }

    private void getResult(int i, String str) {
        V3BusinessControllers.getInstance().getResult(getLoginAccount(), this.mUsingBeanList.get(i).machineId, this.mTypeId, 3, str, new Listener<AppointmentResultBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("预约中..");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AppointmentResultBean appointmentResultBean, Object... objArr) {
                if (AppointmentBathActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (appointmentResultBean.status == 0) {
                        AppointBathSuccessActivity.launch(AppointmentBathActivity.this.getActivity(), AppointmentBathActivity.this.mTypeId);
                        AppointmentBathActivity.this.finish();
                    } else {
                        AppointmentBathActivity.this.showDialog(true, true, ErrorCode.AD_APP_RESERVE_FAIL_MSG);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (AppointmentBathActivity.this.mIsEnable) {
                    AppointmentBathActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel() {
        if (this.mUsingBean == null) {
            return;
        }
        V3BusinessControllers.getInstance().cancelReserve(getLoginAccount(), this.mUsingBean.orderId, this.mUsingBean.machineId, 4, this.mTypeId, 5, new Listener<AppointmentBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AppointmentBean appointmentBean, Object... objArr) {
                boolean unused = AppointmentBathActivity.this.mIsEnable;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                boolean unused = AppointmentBathActivity.this.mIsEnable;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            showDialog(false, true, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(boolean z, boolean z2, String str) {
        if (z2) {
            str = str + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")";
        }
        if (z) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.10
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    AppointmentBathActivity.this.finish();
                }
            }, str);
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), str);
        }
    }

    private class AppointmentAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private AppointmentAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return AppointmentBathActivity.this.mUsingBeanList.size();
        }

        @Override // android.widget.Adapter
        public UsingBean getItem(int i) {
            return (UsingBean) AppointmentBathActivity.this.mUsingBeanList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(AppointmentBathActivity.this.getContext()).inflate(R.layout.appointment_bath_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final UsingBean item = getItem(i);
            if (StringUtils.isNotEmpty(item.machineName)) {
                viewHolder.textView.setText(item.machineName);
            } else if (StringUtils.isNotEmpty(item.machineId)) {
                viewHolder.textView.setText(item.machineId);
            }
            viewHolder.btnAppointment.setText(AppointmentBathActivity.this.getBtnStr(item.curStatus));
            if (item.curStatus == 0) {
                viewHolder.btnAppointment.setBackgroundResource(R.drawable.shape_6f32fd_round_background);
                if (AppointmentBathActivity.this.mBookState == 2) {
                    viewHolder.btnAppointment.setText("空闲");
                }
            } else {
                viewHolder.btnAppointment.setBackgroundResource(R.drawable.shape_a1a6b3_round_background);
            }
            viewHolder.btnAppointment.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.AppointmentAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String str;
                    if (item.curStatus == 0 && AppointmentBathActivity.this.mBookState == 0) {
                        if (StringUtils.isNotEmpty(item.machineName)) {
                            str = "确认预约设备'" + item.machineName + "'吗?";
                        } else {
                            str = "确认预约设备'" + item.machineId + "'吗?";
                        }
                        TwoButtonDialog.getInstance().showDialog(AppointmentBathActivity.this.getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity.AppointmentAdapter.1.1
                            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                            public void onCancle() {
                            }

                            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                            public void onConfirm() {
                                AppointmentBathActivity.this.reserve(i);
                            }
                        }, "提示", str, "取消", "确认预约");
                    }
                }
            });
            return view;
        }

        class ViewHolder {
            public Button btnAppointment;
            public TextView textView;

            public ViewHolder(View view) {
                this.textView = (TextView) view.findViewById(R.id.name);
                this.btnAppointment = (Button) view.findViewById(R.id.btn_appointment);
            }
        }
    }
}
