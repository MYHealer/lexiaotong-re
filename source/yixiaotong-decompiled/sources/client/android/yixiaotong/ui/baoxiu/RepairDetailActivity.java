package client.android.yixiaotong.ui.baoxiu;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AppAccountManager;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.report.RepairProgressBean;
import client.android.yixiaotong.controller.bean.report.ReportDetailBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.ListUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.imgutil.ImageCachceUitl;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RepairDetailActivity extends BaseActivity {
    public static final String EXTRA_ADDRESS = "extra_address";
    public static final String EXTRA_DEVICEID = "extra_deviceid";
    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_PHONE = "extra_phone";
    public static final String EXTRA_STATE = "extra_state";
    public static final String EXTRA_TIME = "extra_time";
    public static final String EXTRA_WALLET = "extra_wallet";
    private ImageCachceUitl imageCachceUitl;
    private GridAdter mGridAdter;
    private GridView mGridImg;
    private String mId;
    private LinearLayout mLinProgress;
    private WrapListView mListProgress;
    private ListAdter mListdAdter;
    private MaterialDialog mMaterialDialog;
    private TitleBar mTitleBar;
    private TextView mTvAddress;
    private TextView mTvDetail;
    private TextView mTvDevice;
    private TextView mTvDeviceId;
    private TextView mTvDeviceState;
    private TextView mTvPhone;
    private TextView mTvTime;
    private WalletModel mWalletModel;
    private int mIsManager = 0;
    private boolean mIsEnable = true;
    private List<RepairProgressBean> mListProDetail = new ArrayList();
    private List<String> listimg = new ArrayList();
    private List<Bitmap> bitmapList = new ArrayList();

    static {
        StubApp.interface11(6422);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) RepairDetailActivity.class).putExtra("extra_wallet", walletModel).putExtra("extra_id", str));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvDevice = (TextView) findViewById(R.id.tv_device);
        this.mTvDeviceState = (TextView) findViewById(R.id.tv_devicestate);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mTvDeviceId = (TextView) findViewById(R.id.tv_deviceid);
        this.mTvPhone = (TextView) findViewById(R.id.tv_phone);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
        this.mTvDetail = (TextView) findViewById(R.id.tv_detail);
        this.mGridImg = (GridView) findViewById(R.id.gridimg);
        this.mListProgress = (WrapListView) findViewById(R.id.list_progress);
        this.mLinProgress = (LinearLayout) findViewById(R.id.lin_progress);
    }

    private void initTitlebar() {
        this.mTitleBar.setTitleView("报修详情");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        GridAdter gridAdter = new GridAdter();
        this.mGridAdter = gridAdter;
        this.mGridImg.setAdapter((ListAdapter) gridAdter);
        ListAdter listAdter = new ListAdter();
        this.mListdAdter = listAdter;
        this.mListProgress.setAdapter((ListAdapter) listAdter);
        this.imageCachceUitl = new ImageCachceUitl(getContext(), new Handler() { // from class: client.android.yixiaotong.ui.baoxiu.RepairDetailActivity.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                Bitmap bitmap = (Bitmap) message.obj;
                int i = message.arg1;
                if (bitmap != null) {
                    RepairDetailActivity.this.bitmapList.add(bitmap);
                }
                RepairDetailActivity.this.mGridAdter.notifyDataSetChanged();
            }
        });
    }

    private void initData() {
        if (AppAccountManager.getInstance().getAppManagerAccount(this.mWalletModel.typeId) == this.mWalletModel.typeId) {
            this.mIsManager = 1;
        }
        BusinessControllers.getInstance().getReportDetail(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().Token, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", getLoginAccount().getUid() + "", this.mWalletModel.typeId, this.mId, this.mIsManager, new Listener<ReportDetailBean>() { // from class: client.android.yixiaotong.ui.baoxiu.RepairDetailActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                RepairDetailActivity.this.showDialog();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, ReportDetailBean reportDetailBean, Object... objArr) {
                if (RepairDetailActivity.this.mIsEnable) {
                    RepairDetailActivity.this.dismissDialog();
                    if (reportDetailBean != null) {
                        RepairDetailActivity.this.initView(reportDetailBean);
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(RepairDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.baoxiu.RepairDetailActivity.2.1
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
                    RepairDetailActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(RepairDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.baoxiu.RepairDetailActivity.2.2
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            RepairDetailActivity.this.finish();
                        }
                    }, clientException.getDetail());
                }
            }
        });
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
        this.mTvDevice.setText(this.mWalletModel.name + "设备");
        this.mTvTime.setText(TimeUtils.formatDateTime(reportDetailBean.reportTime));
        this.mTvDeviceId.setText(reportDetailBean.machineId);
        this.mTvPhone.setText(reportDetailBean.mobile);
        this.mTvAddress.setText(reportDetailBean.installLocation);
        this.mTvDetail.setText(reportDetailBean.faultContent);
        if (StringUtils.isNotEmpty(reportDetailBean.urls) && reportDetailBean.urls.split(",").length > 0) {
            for (int i2 = 0; i2 < reportDetailBean.urls.split(",").length; i2++) {
                this.listimg.add(reportDetailBean.urls.split(",")[i2]);
                this.imageCachceUitl.getBitmapFromNet(this.listimg.get(i2), i2, false);
            }
        }
        if (reportDetailBean.repairProgress != null && reportDetailBean.repairProgress.size() != 0) {
            this.mLinProgress.setVisibility(0);
            ListUtils.addList(this.mListProDetail, reportDetailBean.repairProgress);
            Collections.sort(this.mListProDetail, new MyComparator());
        }
        if (this.listimg.size() < 1) {
            this.mGridImg.setVisibility(8);
        }
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

    class GridAdter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        GridAdter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return RepairDetailActivity.this.bitmapList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return RepairDetailActivity.this.bitmapList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(RepairDetailActivity.this.getContext()).inflate(R.layout.grid_item_img, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.delect.setVisibility(8);
            viewHolder.img.setImageBitmap((Bitmap) RepairDetailActivity.this.bitmapList.get(i));
            return view;
        }

        class ViewHolder {
            public ImageView delect;
            public ImageView img;

            public ViewHolder(View view) {
                this.img = (ImageView) view.findViewById(R.id.img);
                this.delect = (ImageView) view.findViewById(R.id.delect);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        dismissDialog();
        MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("加载中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.baoxiu.RepairDetailActivity.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        }).show();
        this.mMaterialDialog = materialDialogShow;
        materialDialogShow.setCanceledOnTouchOutside(false);
    }

    private boolean isShowDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        return materialDialog != null && materialDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog == null || !materialDialog.isShowing()) {
            return;
        }
        this.mMaterialDialog.dismiss();
        this.mMaterialDialog = null;
    }
}
