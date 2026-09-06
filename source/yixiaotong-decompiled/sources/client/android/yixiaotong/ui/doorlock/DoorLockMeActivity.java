package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AppAccountManager;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.bean.doorlock.AuthUserInfoBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockChangeRoomRecordsBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockRecordsBean;
import client.android.yixiaotong.controller.bean.doorlock.GetRecordBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.event.DoorLockRecordEvent;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.AboutActivity;
import client.android.yixiaotong.ui.adapter.DoorLockRecordAdapter;
import client.android.yixiaotong.ui.baoxiu.MRepairActivity;
import client.android.yixiaotong.ui.baoxiu.MalfunctionRepairActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stub.StubApp;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DoorLockMeActivity extends BaseActivity {
    public static final String EXTRA_AUTHINFO = "extra_authinfo";
    private static final String EXTRA_DEVICE = "bluetoothdevice";
    public static final String EXTRA_WALLET = "extra_wallet";
    private AuthUserInfoBean mAuthUserInfoBean;
    private BluetoothDevice mBluetoothDevice;
    private TextView mBtnRecord;
    private TextView mBtnUserInfo;
    private DoorLockRecordAdapter mDoorLockRecordAdapter;
    private ImageView mImgSex;
    private SimpleDraweeView mIvMeIcon;
    private LinearLayout mLinInfo;
    private ListView mLvList;
    private ScrollView mScrollView;
    private int mTotalCounts;
    private TextView mTvChangeRoomState;
    private TextView mTvGetRecordTop;
    private TextView mTvID;
    private TextView mTvName;
    private TextView mTvRoomAddress;
    private UserInfoBean mUserInfoBean;
    private WalletModel mWalletModel;
    private List<GetRecordBean> mRecordData = new ArrayList();
    private boolean mIsEnable = true;
    private int mAuditStatus = -1;
    private int mPageNum = 1;
    private int mMaxPageSize = 10;
    private boolean mHasNoMoreData = true;
    private boolean mIsGetRecording = false;

    static {
        StubApp.interface11(6969);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$608(DoorLockMeActivity doorLockMeActivity) {
        int i = doorLockMeActivity.mPageNum;
        doorLockMeActivity.mPageNum = i + 1;
        return i;
    }

    public static void launch(Activity activity, WalletModel walletModel, AuthUserInfoBean authUserInfoBean, BluetoothDevice bluetoothDevice) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DoorLockMeActivity.class).putExtra("extra_wallet", walletModel).putExtra("extra_wallet", walletModel).putExtra("extra_authinfo", authUserInfoBean).putExtra("bluetoothdevice", bluetoothDevice));
        }
    }

    private void initViewNew() {
        this.mTvGetRecordTop = (TextView) findViewById(R.id.tv_getrecordtop);
        this.mIvMeIcon = (SimpleDraweeView) findViewById(R.id.iv_me_icon);
        this.mTvName = (TextView) findViewById(R.id.tv_name);
        this.mTvID = (TextView) findViewById(R.id.tv_id);
        this.mImgSex = (ImageView) findViewById(R.id.img_sex);
        this.mBtnUserInfo = (TextView) findViewById(R.id.btn_userinfo);
        this.mBtnRecord = (TextView) findViewById(R.id.btn_record);
        this.mLinInfo = (LinearLayout) findViewById(R.id.lin_info);
        this.mLvList = (ListView) findViewById(R.id.lv_list);
        this.mScrollView = (ScrollView) findViewById(R.id.scrollview);
        this.mTvChangeRoomState = (TextView) findViewById(R.id.tv_tochangeaddress);
        this.mTvRoomAddress = (TextView) findViewById(R.id.tv_roomaddress);
    }

    private void initView() {
        this.mTvRoomAddress.setText(LocalBusinessStore.getDoorLockRoomAddress(getContext()));
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        BluetoothSDK.getInstance().closeBLE();
        RecordController.getInstance().onResume();
        getChangeRoomRecords();
    }

    public void onEventMainThread(DoorLockRecordEvent doorLockRecordEvent) {
        this.mRecordData.clear();
        this.mPageNum = 1;
        getRecords();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        RecordController.getInstance().onPause();
    }

    private void initClickListeners() {
        findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMeActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m105xe358e419(view);
            }
        });
        findViewById(R.id.btn_userinfo).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMeActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m106x7045fb38(view);
            }
        });
        findViewById(R.id.btn_record).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMeActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m107xfd331257(view);
            }
        });
        findViewById(R.id.tv_getrecordtop).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMeActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m108x8a202976(view);
            }
        });
        findViewById(R.id.rel_room).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMeActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m109x170d4095(view);
            }
        });
        findViewById(R.id.rel_repair).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMeActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m110xa3fa57b4(view);
            }
        });
        findViewById(R.id.rel_tofeedback).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMeActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m111x30e76ed3(view);
            }
        });
        findViewById(R.id.rel_aboutme).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMeActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m112xbdd485f2(view);
            }
        });
        findViewById(R.id.rel_indenfity).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMeActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m113x4ac19d11(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-doorlock-DoorLockMeActivity, reason: not valid java name */
    /* synthetic */ void m105xe358e419(View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-ui-doorlock-DoorLockMeActivity, reason: not valid java name */
    /* synthetic */ void m106x7045fb38(View view) {
        this.mBtnUserInfo.setBackground(getResources().getDrawable(R.mipmap.l_doorlock_me_btn_background));
        this.mBtnRecord.setBackgroundResource(R.color.white);
        this.mBtnUserInfo.setTextColor(getResources().getColor(R.color.white));
        this.mBtnRecord.setTextColor(getResources().getColor(R.color.ff666666));
        this.mScrollView.setVisibility(0);
        this.mLvList.setVisibility(8);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-ui-doorlock-DoorLockMeActivity, reason: not valid java name */
    /* synthetic */ void m107xfd331257(View view) {
        this.mBtnRecord.setBackground(getResources().getDrawable(R.mipmap.l_doorlock_me_btn_background));
        this.mBtnUserInfo.setBackgroundResource(R.color.white);
        this.mBtnRecord.setTextColor(getResources().getColor(R.color.white));
        this.mBtnUserInfo.setTextColor(getResources().getColor(R.color.ff666666));
        this.mScrollView.setVisibility(8);
        this.mLvList.setVisibility(0);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-ui-doorlock-DoorLockMeActivity, reason: not valid java name */
    /* synthetic */ void m108x8a202976(View view) {
        toLaunch();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-ui-doorlock-DoorLockMeActivity, reason: not valid java name */
    /* synthetic */ void m109x170d4095(View view) {
        int i = this.mAuditStatus;
        if (i == 1) {
            ChangeRoomingActivity.launch(getActivity());
        } else if (i == 3) {
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMeActivity.1
                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    ChangeRoomActivity.launch(DoorLockMeActivity.this.getActivity(), DoorLockMeActivity.this.mWalletModel);
                }
            }, "温馨提示", "上次提交的申请被管理员驳回了，请联系管理员或重新申请", "返回", "重新申请");
        } else {
            ChangeRoomActivity.launch(getActivity(), this.mWalletModel);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-ui-doorlock-DoorLockMeActivity, reason: not valid java name */
    /* synthetic */ void m110xa3fa57b4(View view) {
        if (AppAccountManager.getInstance().getAppManagerAccount(10) == 10) {
            MRepairActivity.launch(getActivity());
        } else {
            MalfunctionRepairActivity.launch(getActivity(), 10);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$6$client-android-yixiaotong-ui-doorlock-DoorLockMeActivity, reason: not valid java name */
    /* synthetic */ void m111x30e76ed3(View view) {
        ToastUtils.show(getContext(), "暂未开通，敬请期待");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$7$client-android-yixiaotong-ui-doorlock-DoorLockMeActivity, reason: not valid java name */
    /* synthetic */ void m112xbdd485f2(View view) {
        AboutActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$8$client-android-yixiaotong-ui-doorlock-DoorLockMeActivity, reason: not valid java name */
    /* synthetic */ void m113x4ac19d11(View view) {
        AuthenticationSuccessActivity.launch(getActivity(), this.mWalletModel, this.mAuthUserInfoBean, 1);
    }

    private void initInfo() {
        UserInfoBean userInfo = getLoginAccount().getAccountManagetStore().getUserInfo();
        this.mUserInfoBean = userInfo;
        if (userInfo == null) {
            return;
        }
        if (StringUtils.isNotEmpty(userInfo.Icon)) {
            this.mIvMeIcon.setImageURI(UriUtil.parseUriOrNull(this.mUserInfoBean.Icon));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentName)) {
            this.mTvName.setText(this.mUserInfoBean.StudentName);
            if (this.mUserInfoBean.GenderId == 1) {
                this.mImgSex.setImageResource(R.mipmap.l_doorlock_mesex);
            } else {
                this.mImgSex.setImageResource(R.mipmap.l_shouye_girl);
            }
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentNo)) {
            this.mTvID.setText(this.mUserInfoBean.StudentNo);
        } else {
            this.mTvID.setVisibility(4);
        }
    }

    private void initAdapter() {
        this.mRecordData.add(new GetRecordBean());
        this.mRecordData.add(new GetRecordBean());
        DoorLockRecordAdapter doorLockRecordAdapter = new DoorLockRecordAdapter(getActivity(), getLoginAccount(), this.mWalletModel, this.mRecordData, this.mBluetoothDevice);
        this.mDoorLockRecordAdapter = doorLockRecordAdapter;
        this.mLvList.setAdapter((ListAdapter) doorLockRecordAdapter);
        this.mDoorLockRecordAdapter.notifyDataSetChanged();
        this.mLvList.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMeActivity.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    DoorLockMeActivity.this.mTvGetRecordTop.setVisibility(8);
                } else {
                    DoorLockMeActivity.this.mTvGetRecordTop.setVisibility(0);
                }
                if (i + i2 < i3 || i3 == 0 || DoorLockMeActivity.this.mTotalCounts <= i3 - 1 || DoorLockMeActivity.this.mHasNoMoreData) {
                    return;
                }
                DoorLockMeActivity.this.getRecords();
            }
        });
    }

    private void toLaunch() {
        if (this.mBluetoothDevice != null) {
            if (LocalBusinessStore.getDoorLockTip(getContext())) {
                RecordController.getInstance().init(getLoginAccount(), getActivity(), this.mBluetoothDevice);
                return;
            } else {
                RouseTipActivity.launch(getActivity(), 13, this.mBluetoothDevice);
                return;
            }
        }
        ToastUtils.show(getActivity(), "当前宿舍没有设备！");
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BluetoothSDK.getInstance().closeBLE();
        EventBus.getDefault().unregister(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRecords() {
        if (this.mIsGetRecording) {
            return;
        }
        BusinessControllers.getInstance().getDoorLockRecords(getLoginAccount(), this.mWalletModel.typeId, RandomUtil.getRandNumMaxString(6), this.mPageNum, this.mMaxPageSize, new Listener<DoorLockRecordsBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMeActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                DoorLockMeActivity.this.mIsGetRecording = true;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DoorLockRecordsBean doorLockRecordsBean, Object... objArr) {
                if (DoorLockMeActivity.this.mIsEnable) {
                    if (doorLockRecordsBean != null) {
                        DoorLockMeActivity.this.mTotalCounts = doorLockRecordsBean.count;
                        if (DoorLockMeActivity.this.mPageNum == 1) {
                            DoorLockMeActivity.this.mRecordData.clear();
                            DoorLockMeActivity.this.mHasNoMoreData = false;
                            DoorLockMeActivity.this.mRecordData.add(new GetRecordBean());
                        }
                        DoorLockMeActivity.access$608(DoorLockMeActivity.this);
                        DoorLockMeActivity.this.mRecordData.addAll(doorLockRecordsBean.data);
                        if (DoorLockMeActivity.this.mRecordData.size() - 1 == DoorLockMeActivity.this.mTotalCounts) {
                            DoorLockMeActivity.this.mRecordData.add(new GetRecordBean());
                            DoorLockMeActivity.this.mHasNoMoreData = true;
                        }
                        Log.e("test", DoorLockMeActivity.this.mRecordData.size() + "  " + DoorLockMeActivity.this.mTotalCounts);
                        DoorLockMeActivity.this.mDoorLockRecordAdapter.setCount(DoorLockMeActivity.this.mTotalCounts);
                        DoorLockMeActivity.this.mDoorLockRecordAdapter.notifyDataSetChanged();
                    }
                    DoorLockMeActivity.this.mIsGetRecording = false;
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DoorLockMeActivity.this.manageError(clientException);
                DoorLockMeActivity.this.mIsGetRecording = false;
            }
        });
    }

    private void getChangeRoomRecords() {
        BusinessControllers.getInstance().getDoorLockChangeRoomRecords(getLoginAccount(), this.mWalletModel.typeId, RandomUtil.getRandNumMaxString(6), new Listener<DoorLockChangeRoomRecordsBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMeActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                DoorLockMeActivity.this.mAuditStatus = -1;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DoorLockChangeRoomRecordsBean doorLockChangeRoomRecordsBean, Object... objArr) {
                if (!DoorLockMeActivity.this.mIsEnable || doorLockChangeRoomRecordsBean == null || doorLockChangeRoomRecordsBean.changeRoom == null || doorLockChangeRoomRecordsBean.changeRoom.size() <= 0) {
                    return;
                }
                DoorLockMeActivity.this.mAuditStatus = doorLockChangeRoomRecordsBean.changeRoom.get(0).auditstatus;
                if (doorLockChangeRoomRecordsBean.changeRoom.get(0).auditstatus == 1) {
                    DoorLockMeActivity.this.mTvRoomAddress.setText(doorLockChangeRoomRecordsBean.changeRoom.get(0).newRoom);
                    DoorLockMeActivity.this.mTvChangeRoomState.setText("审核中");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DoorLockMeActivity.this.manageError(clientException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manageError(ClientException clientException) {
        if (this.mIsEnable) {
            BaseMaterialDialog.dissmisMaterialDialog();
            ErrorUtil.onFailResult(getActivity(), "我的", clientException, true);
        }
    }
}
