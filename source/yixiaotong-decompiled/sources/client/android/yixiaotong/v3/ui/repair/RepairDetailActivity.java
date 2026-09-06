package client.android.yixiaotong.v3.ui.repair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.report.RepairProgressBean;
import client.android.yixiaotong.controller.bean.report.ReportDetailBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.ListUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RepairDetailActivity extends BaseActivity {
    private String mAppName;
    private String mId;
    private LinearLayout mLinProgress;
    private WrapListView mListProgress;
    private ListAdter mListdAdter;
    private TitleBar mTitleBar;
    private TextView mTvAddress;
    private TextView mTvDetail;
    private TextView mTvDevice;
    private TextView mTvDeviceId;
    private TextView mTvDeviceState;
    private TextView mTvPhone;
    private TextView mTvTime;
    private int mTypeId;
    private int mIsManager = 0;
    private boolean mIsEnable = true;
    private List<RepairProgressBean> mListProDetail = new ArrayList();

    static {
        StubApp.interface11(10179);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, int i, String str2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) RepairDetailActivity.class).putExtra("appname", str).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i).putExtra("id", str2));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvDevice = (TextView) findViewById(R.id.tv_device);
        this.mTvDeviceState = (TextView) findViewById(R.id.tv_devicestate);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mTvDeviceId = (TextView) findViewById(R.id.tv_deviceid);
        this.mTvPhone = (TextView) findViewById(R.id.tv_phone);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
        this.mTvDetail = (TextView) findViewById(R.id.tv_detail);
        this.mListProgress = (WrapListView) findViewById(R.id.list_progress);
        this.mLinProgress = (LinearLayout) findViewById(R.id.lin_progress);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("报修详情");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        ListAdter listAdter = new ListAdter();
        this.mListdAdter = listAdter;
        this.mListProgress.setAdapter((ListAdapter) listAdter);
    }

    private void initData() {
        BusinessControllers.getInstance().getReportDetailV3(getLoginAccount(), "", UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", UserInfoUtil.getInstance().getLoginAccountV3().studentId, this.mTypeId, this.mId, this.mIsManager, new Listener<ReportDetailBean>() { // from class: client.android.yixiaotong.v3.ui.repair.RepairDetailActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(RepairDetailActivity.this.getActivity(), "获取数据中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, ReportDetailBean reportDetailBean, Object... objArr) {
                if (RepairDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (reportDetailBean != null) {
                        RepairDetailActivity.this.initView(reportDetailBean);
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(RepairDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.repair.RepairDetailActivity.1.1
                            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                            public void onConfirm() {
                                RepairDetailActivity.this.finish();
                            }
                        }, "加载数据失败");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (RepairDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    RepairDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.repair.RepairDetailActivity.2
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    RepairDetailActivity.this.finish();
                }
            }, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView(ReportDetailBean reportDetailBean) {
        int i = reportDetailBean.resolutionStatus;
        if (i == 1 || i == 2) {
            this.mTvDeviceState.setText("未解决");
            this.mTvDeviceState.setTextColor(-370604);
        } else if (i == 3) {
            this.mTvDeviceState.setText("处理中");
            this.mTvDeviceState.setTextColor(-13710223);
        } else if (i == 5) {
            this.mTvDeviceState.setText("已解决");
            this.mTvDeviceState.setTextColor(-13710223);
        } else if (i == 6) {
            this.mTvDeviceState.setText("已关闭");
            this.mTvDeviceState.setTextColor(-370604);
        } else if (i == 7) {
            this.mTvDeviceState.setText("待解决");
            this.mTvDeviceState.setTextColor(-13710223);
        } else {
            this.mTvDeviceState.setText("未知");
            this.mTvDeviceState.setTextColor(-370604);
        }
        this.mTvDevice.setText(this.mAppName);
        this.mTvTime.setText(TimeUtils.formatDateTime(reportDetailBean.reportTime));
        this.mTvDeviceId.setText(reportDetailBean.machineId);
        this.mTvPhone.setText(reportDetailBean.mobile);
        this.mTvAddress.setText(reportDetailBean.installLocation);
        this.mTvDetail.setText(reportDetailBean.faultContent);
        if (reportDetailBean.repairProgress == null || reportDetailBean.repairProgress.size() == 0) {
            return;
        }
        this.mLinProgress.setVisibility(0);
        ListUtils.addList(this.mListProDetail, reportDetailBean.repairProgress);
        Collections.sort(this.mListProDetail, new MyComparator());
    }

    static class MyComparator implements Comparator<RepairProgressBean> {
        MyComparator() {
        }

        @Override // java.util.Comparator
        public int compare(RepairProgressBean repairProgressBean, RepairProgressBean repairProgressBean2) {
            return repairProgressBean2.i4_1 - repairProgressBean.i4_1;
        }
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
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    class ListAdter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        ListAdter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return RepairDetailActivity.this.mListProDetail.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return RepairDetailActivity.this.mListProDetail.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(RepairDetailActivity.this.getContext()).inflate(R.layout.repair_progress_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (RepairDetailActivity.this.mListProDetail.size() - 1 == i) {
                viewHolder.viewbackground.setVisibility(4);
            } else {
                viewHolder.viewbackground.setVisibility(0);
            }
            if (StringUtils.isNotEmpty(((RepairProgressBean) RepairDetailActivity.this.mListProDetail.get(i)).handledTime)) {
                String date = TimeUtils.formatDate(Long.parseLong(((RepairProgressBean) RepairDetailActivity.this.mListProDetail.get(i)).handledTime));
                if (StringUtils.isNotEmpty(date) && date.length() > 5) {
                    viewHolder.tv_date.setText(date.substring(5).replace(x.A, "月") + "日");
                }
                viewHolder.tv_time.setText(TimeUtils.formatTime1(Long.parseLong(((RepairProgressBean) RepairDetailActivity.this.mListProDetail.get(i)).handledTime)));
            }
            switch (((RepairProgressBean) RepairDetailActivity.this.mListProDetail.get(i)).status) {
                case 1:
                    viewHolder.tv_state.setText("未解决");
                    viewHolder.tv_detail.setText("");
                    break;
                case 2:
                    viewHolder.tv_state.setText("已分配");
                    viewHolder.tv_detail.setText("");
                    break;
                case 3:
                    viewHolder.tv_state.setText("处理中");
                    viewHolder.tv_detail.setText("维修人员：" + ((RepairProgressBean) RepairDetailActivity.this.mListProDetail.get(i)).handled_name + "\n电话：" + ((RepairProgressBean) RepairDetailActivity.this.mListProDetail.get(i)).mobile);
                    break;
                case 4:
                    viewHolder.tv_state.setText("反馈信息");
                    viewHolder.tv_detail.setText(((RepairProgressBean) RepairDetailActivity.this.mListProDetail.get(i)).handle_content);
                    break;
                case 5:
                    viewHolder.tv_state.setText("已解决");
                    if (((RepairProgressBean) RepairDetailActivity.this.mListProDetail.get(i)).i4_3 == 50) {
                        viewHolder.tv_detail.setText("不必处理");
                    } else {
                        viewHolder.tv_detail.setText("已修正");
                    }
                    break;
                case 6:
                    viewHolder.tv_state.setText("已关闭");
                    viewHolder.tv_detail.setText("");
                    break;
                case 7:
                    viewHolder.tv_state.setText("待解决");
                    viewHolder.tv_detail.setText("维修人员：" + ((RepairProgressBean) RepairDetailActivity.this.mListProDetail.get(i)).handled_name + "\n电话：" + ((RepairProgressBean) RepairDetailActivity.this.mListProDetail.get(i)).mobile);
                    break;
                default:
                    viewHolder.tv_state.setText("未知");
                    viewHolder.tv_detail.setText("");
                    break;
            }
            if (i != 0) {
                viewHolder.img.setImageResource(R.mipmap.l_dot_blue);
                viewHolder.tv_state.setTextColor(-14540254);
            } else {
                viewHolder.img.setImageResource(R.mipmap.l_xiaofei_recored);
                viewHolder.tv_state.setTextColor(-13710223);
            }
            return view;
        }

        class ViewHolder {
            public ImageView img;
            public TextView tv_date;
            public TextView tv_detail;
            public TextView tv_state;
            public TextView tv_time;
            public View viewbackground;

            public ViewHolder(View view) {
                this.tv_date = (TextView) view.findViewById(R.id.tv_date);
                this.tv_time = (TextView) view.findViewById(R.id.tv_time);
                this.img = (ImageView) view.findViewById(R.id.img);
                this.tv_state = (TextView) view.findViewById(R.id.tv_state);
                this.tv_detail = (TextView) view.findViewById(R.id.tv_detail);
                this.viewbackground = view.findViewById(R.id.view);
            }
        }
    }
}
