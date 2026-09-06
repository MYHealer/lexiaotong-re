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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AppAccountManager;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.report.RepairProgressBean;
import client.android.yixiaotong.controller.bean.report.ReportDetailBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.AppTipDialog;
import client.android.yixiaotong.ui.dialog.ChooseDialogTip;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ListUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.imgutil.ImageCachceUitl;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MRepairDetailActivity extends BaseActivity {
    public static final String EXTRA_ADDRESS = "extra_address";
    public static final String EXTRA_DEVICEID = "extra_deviceid";
    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_PHONE = "extra_phone";
    public static final String EXTRA_STATE = "extra_state";
    public static final String EXTRA_TIME = "extra_time";
    public static final String EXTRA_WALLET = "extra_wallet";
    private ImageCachceUitl imageCachceUitl;
    private ImageView[] ivDots;
    private Button mBtnComfirm;
    private Button mBtnIgnored;
    private GridAdter mGridAdter;
    private GridView mGridImg;
    private String mId;
    private RelativeLayout mLin;
    private ViewGroup mLinDot;
    private LinearLayout mLinRepairdetail;
    private MaterialDialog mMaterialDialog;
    private MyPagerAdater mPagerAdater;
    private TitleBar mTitleBar;
    private TextView mTvAddress;
    private TextView mTvDetail;
    private TextView mTvDevice;
    private TextView mTvDeviceId;
    private TextView mTvDeviceState;
    private TextView mTvPhone;
    private TextView mTvRepairId;
    private TextView mTvRepairState;
    private TextView mTvRepairTime;
    private TextView mTvTime;
    private ViewPager mViewPager;
    private WalletModel mWalletModel;
    private int mIsManager = 0;
    private boolean mIsEnable = true;
    private List<String> listimg = new ArrayList();
    private List<Bitmap> bitmapList = new ArrayList();
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -1);
    private List<View> listView = new ArrayList();

    static {
        StubApp.interface11(6402);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) MRepairDetailActivity.class).putExtra("extra_wallet", walletModel).putExtra("extra_id", str));
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
        this.mViewPager = (ViewPager) findViewById(R.id.viewpager);
        this.mLinDot = (ViewGroup) findViewById(R.id.ll_container);
        this.mLin = (RelativeLayout) findViewById(R.id.lin);
        this.mBtnComfirm = (Button) findViewById(R.id.btn_comfirm);
        this.mBtnIgnored = (Button) findViewById(R.id.btn_ignored);
        this.mLinRepairdetail = (LinearLayout) findViewById(R.id.lin_repairdetail);
        this.mTvRepairTime = (TextView) findViewById(R.id.tv_repairtime);
        this.mTvRepairState = (TextView) findViewById(R.id.tv_repairstate);
        this.mTvRepairId = (TextView) findViewById(R.id.tv_repairid);
    }

    private void initTitlebar() {
        this.mTitleBar.setTitleView("报修中心");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        GridAdter gridAdter = new GridAdter();
        this.mGridAdter = gridAdter;
        this.mGridImg.setAdapter((ListAdapter) gridAdter);
        this.mLin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MRepairDetailActivity.this.mLin.setVisibility(8);
            }
        });
        this.mGridImg.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                MRepairDetailActivity.this.mLin.getBackground().setAlpha(120);
                MRepairDetailActivity.this.mLin.setVisibility(0);
                MRepairDetailActivity.this.mViewPager.setCurrentItem(i);
            }
        });
        this.imageCachceUitl = new ImageCachceUitl(getContext(), new Handler() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                Bitmap bitmap = (Bitmap) message.obj;
                int i = message.arg1;
                if (bitmap != null) {
                    MRepairDetailActivity.this.bitmapList.add(bitmap);
                    ImageView imageView = new ImageView(MRepairDetailActivity.this.getContext());
                    imageView.setLayoutParams(MRepairDetailActivity.this.params);
                    imageView.setImageBitmap(bitmap);
                    MRepairDetailActivity.this.listView.add(imageView);
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.3.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MRepairDetailActivity.this.mLin.setVisibility(8);
                        }
                    });
                    MRepairDetailActivity.this.mGridAdter.notifyDataSetChanged();
                    MRepairDetailActivity.this.mPagerAdater.notifyDataSetChanged();
                }
            }
        });
    }

    private void initClickListeners() {
        findViewById(R.id.btn_comfirm).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m91x9c52e09c(view);
            }
        });
        findViewById(R.id.btn_ignored).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m92xad08ad5d(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-baoxiu-MRepairDetailActivity, reason: not valid java name */
    /* synthetic */ void m91x9c52e09c(View view) {
        if (this.mBtnComfirm.getText().toString().equals("已解决问题")) {
            new ChooseDialogTip().showTipDialog(getActivity(), new ChooseDialogTip.ChooseDialogListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.4
                @Override // client.android.yixiaotong.ui.dialog.ChooseDialogTip.ChooseDialogListener
                public void onCanle() {
                }

                @Override // client.android.yixiaotong.ui.dialog.ChooseDialogTip.ChooseDialogListener
                public void onConfirt(boolean z, boolean z2) {
                    if (z) {
                        MRepairDetailActivity.this.comfirmRepair(5, 20);
                    } else {
                        MRepairDetailActivity.this.comfirmRepair(5, 50);
                    }
                }
            }, "已修正", "不必处理", "返回", "确认提交");
        } else {
            new AppTipDialog().showTipDialog(getActivity(), new AppTipDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.5
                @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
                public void onCanle() {
                }

                @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
                public void onConfirt() {
                    MRepairDetailActivity.this.startRepair();
                }
            }, "确认故障信息，并开始处理", "再等等", "确认");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-ui-baoxiu-MRepairDetailActivity, reason: not valid java name */
    /* synthetic */ void m92xad08ad5d(View view) {
        if (this.mBtnIgnored.getText().toString().equals("未解决问题")) {
            new ChooseDialogTip().showTipDialog(getActivity(), new ChooseDialogTip.ChooseDialogListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.6
                @Override // client.android.yixiaotong.ui.dialog.ChooseDialogTip.ChooseDialogListener
                public void onCanle() {
                }

                @Override // client.android.yixiaotong.ui.dialog.ChooseDialogTip.ChooseDialogListener
                public void onConfirt(boolean z, boolean z2) {
                    if (z) {
                        MRepairDetailActivity.this.comfirmRepair(7, 30);
                    } else {
                        MRepairDetailActivity.this.comfirmRepair(7, 60);
                    }
                }
            }, "无法修复", "稍后处理", "返回", "确认提交");
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView(ReportDetailBean reportDetailBean) {
        int i = reportDetailBean.resolutionStatus;
        if (i == 1 || i == 2) {
            this.mBtnComfirm.setVisibility(0);
            this.mBtnIgnored.setVisibility(0);
            this.mTvDeviceState.setText("未解决");
            this.mTvDeviceState.setTextColor(-370604);
        } else if (i == 3) {
            this.mTvDeviceState.setText("处理中");
            this.mTvDeviceState.setTextColor(-13710223);
            this.mBtnComfirm.setVisibility(0);
            this.mBtnIgnored.setVisibility(0);
            this.mBtnComfirm.setText("已解决问题");
            this.mBtnIgnored.setText("未解决问题");
            this.mBtnIgnored.setBackground(getResources().getDrawable(R.drawable.shape_radio_red_button));
        } else if (i == 5) {
            this.mTvDeviceState.setText("已解决");
            this.mTvDeviceState.setTextColor(-13710223);
        } else if (i == 6) {
            this.mTvDeviceState.setText("已关闭");
            this.mTvDeviceState.setTextColor(-370604);
        } else if (i == 7) {
            this.mTvDeviceState.setText("待解决");
            this.mTvDeviceState.setTextColor(-13710223);
            this.mBtnComfirm.setVisibility(0);
            this.mBtnComfirm.setText("已解决问题");
            this.mBtnIgnored.setBackground(getResources().getDrawable(R.drawable.shape_radio_red_button));
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
        if (reportDetailBean.urls.split(",").length > 0) {
            for (int i2 = 0; i2 < reportDetailBean.urls.split(",").length; i2++) {
                this.listimg.add(reportDetailBean.urls.split(",")[i2]);
                this.imageCachceUitl.getBitmapFromNet(this.listimg.get(i2), i2, false);
            }
        }
        if (reportDetailBean.resolutionStatus == 5) {
            this.mLinRepairdetail.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            ListUtils.addList(arrayList, reportDetailBean.repairProgress);
            Collections.sort(arrayList, new MyComparator());
            this.mTvRepairId.setText("ID：" + ((RepairProgressBean) arrayList.get(0)).handled_id);
            if (StringUtils.isNotEmpty(((RepairProgressBean) arrayList.get(0)).handledTime)) {
                this.mTvRepairTime.setText(TimeUtils.formatDateTime(Long.parseLong(((RepairProgressBean) arrayList.get(0)).handledTime)));
            }
            if (((RepairProgressBean) arrayList.get(0)).i4_3 == 50) {
                this.mTvRepairState.setText("不必处理");
            }
        }
        initViewPager();
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

    class GridAdter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        GridAdter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return MRepairDetailActivity.this.bitmapList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return MRepairDetailActivity.this.bitmapList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(MRepairDetailActivity.this.getContext()).inflate(R.layout.grid_item_img, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.delect.setVisibility(8);
            viewHolder.img.setImageBitmap((Bitmap) MRepairDetailActivity.this.bitmapList.get(i));
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

    private void initViewPager() {
        MyPagerAdater myPagerAdater = new MyPagerAdater();
        this.mPagerAdater = myPagerAdater;
        this.mViewPager.setAdapter(myPagerAdater);
        this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.7
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int size = MRepairDetailActivity.this.listimg.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (i2 == i) {
                        MRepairDetailActivity.this.ivDots[i2].setImageResource(R.drawable.dot_white);
                    } else {
                        MRepairDetailActivity.this.ivDots[i2].setImageResource(R.drawable.dot_normal);
                    }
                }
            }
        });
        this.ivDots = new ImageView[this.listimg.size()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(16, 16);
        for (int i = 0; i < this.listimg.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(layoutParams);
            if (i == 0) {
                imageView.setImageResource(R.drawable.dot_white);
            } else {
                layoutParams.leftMargin = 20;
                imageView.setImageResource(R.drawable.dot_normal);
            }
            this.ivDots[i] = imageView;
            this.mLinDot.addView(imageView);
        }
    }

    class MyPagerAdater extends PagerAdapter {
        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        MyPagerAdater() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (MRepairDetailActivity.this.listView != null) {
                return MRepairDetailActivity.this.listView.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) MRepairDetailActivity.this.listView.get(i));
            return MRepairDetailActivity.this.listView.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) MRepairDetailActivity.this.listView.get(i));
        }
    }

    private void initDataDetail() {
        if (AppAccountManager.getInstance().getAppManagerAccount(this.mWalletModel.typeId) == this.mWalletModel.typeId) {
            this.mIsManager = 1;
        }
        BusinessControllers.getInstance().getReportDetail(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().Token, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", getLoginAccount().getUid() + "", this.mWalletModel.typeId, this.mId, this.mIsManager, new Listener<ReportDetailBean>() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                MRepairDetailActivity.this.showDialog();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, ReportDetailBean reportDetailBean, Object... objArr) {
                if (MRepairDetailActivity.this.mIsEnable) {
                    MRepairDetailActivity.this.dismissDialog();
                    if (reportDetailBean != null) {
                        MRepairDetailActivity.this.initView(reportDetailBean);
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(MRepairDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.8.1
                            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                            public void onConfirm() {
                                MRepairDetailActivity.this.finish();
                            }
                        }, "加载数据失败");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (MRepairDetailActivity.this.mIsEnable) {
                    MRepairDetailActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(MRepairDetailActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.8.2
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            MRepairDetailActivity.this.finish();
                        }
                    }, clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRepair() {
        BusinessControllers.getInstance().postConfirmFaultInfo(getLoginAccount(), this.mWalletModel.typeId, this.mId, 1, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                MRepairDetailActivity.this.showDialog();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (MRepairDetailActivity.this.mIsEnable) {
                    MRepairDetailActivity.this.dismissDialog();
                    if (successBean == null || successBean.success != 1) {
                        ToastUtils.show(MRepairDetailActivity.this.getContext(), "处理失败");
                        return;
                    }
                    MRepairDetailActivity.this.mBtnComfirm.setText("已解决问题");
                    MRepairDetailActivity.this.mBtnIgnored.setText("未解决问题");
                    MRepairDetailActivity.this.mBtnIgnored.setBackground(MRepairDetailActivity.this.getResources().getDrawable(R.drawable.shape_radio_red_button));
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (MRepairDetailActivity.this.mIsEnable) {
                    MRepairDetailActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(MRepairDetailActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void comfirmRepair(final int i, int i2) {
        BusinessControllers.getInstance().postSubmitReportInfo(getLoginAccount(), this.mWalletModel.typeId, this.mId, i, i2, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                MRepairDetailActivity.this.showDialog();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (MRepairDetailActivity.this.mIsEnable) {
                    MRepairDetailActivity.this.dismissDialog();
                    if (successBean == null || successBean.success != 1) {
                        ToastUtils.show(MRepairDetailActivity.this.getContext(), "提交失败");
                        return;
                    }
                    ToastUtils.show(MRepairDetailActivity.this.getContext(), "提交成功");
                    if (i == 7) {
                        MRepairDetailActivity.this.mBtnComfirm.setText("已解决问题");
                        MRepairDetailActivity.this.mBtnComfirm.setVisibility(0);
                        MRepairDetailActivity.this.mBtnIgnored.setVisibility(8);
                    } else {
                        MRepairDetailActivity.this.mBtnComfirm.setVisibility(8);
                        MRepairDetailActivity.this.mBtnIgnored.setVisibility(8);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (MRepairDetailActivity.this.mIsEnable) {
                    MRepairDetailActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(MRepairDetailActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        dismissDialog();
        MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("加载中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity.11
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
