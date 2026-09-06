package client.android.yixiaotong.ui.bluetoothtwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterBindingRoom;
import client.android.yixiaotong.controller.bean.AmmeterRoomDetail;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.sdk.LeXiaoTongSDK;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.listener.ScanListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.ui.RecordListActivity;
import client.android.yixiaotong.ui.RefundProgressActivity;
import client.android.yixiaotong.ui.WalletDetailActivity;
import client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.BindhamamDialogTip;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.UnBindHamamDialogTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.util.LogUtil;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BathMainFragment extends BaseFragment {
    private static final String TYPE_DEVICEMAC = "type_devicemac";
    private static final String TYPE_PUTBINGDROOMSTATUS1 = "type_putbingdroomstatus1";
    private BluetoothDevice mBluetoothDevice;
    private Activity mContext;
    private State mCurrentState;
    private ImageView mImgSex;
    private SimpleDraweeView mIvMeIcon;
    private OpenController mOpenController;
    private ImageView mQiDong;
    private RelativeLayout mRelMoney;
    private TitleBar mTitleBar;
    private TextView mTvBalance;
    private TextView mTvChakanRecored;
    private TextView mTvMeId;
    private TextView mTvMeName;
    private TextView mTvMeXueHao;
    private TextView mTvQiehuanDevice;
    private TextView mTvRoomAddress;
    private TextView mTvUnbindroom;
    private UserInfoBean mUserInfoBean;
    private WalletModel mWalletModel;
    private boolean mIsBLEMode = true;
    private boolean mIsEnable = true;
    private ScanListener mScanListener = new ScanListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.9
        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onStart() {
            BathMainFragment.this.mCurrentState = State.scaning;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onScan(BluetoothDevice bluetoothDevice) {
            if (BathMainFragment.this.mWalletModel == null || BathMainFragment.this.mContext == null) {
                return;
            }
            String lastConnectBluetoothDeviceMac = LocalBusinessStore.getLastConnectBluetoothDeviceMac(BathMainFragment.this.mContext, BathMainFragment.this.mWalletModel.typeId);
            if (StringUtils.isNotEmpty(lastConnectBluetoothDeviceMac) && bluetoothDevice.address.equals(lastConnectBluetoothDeviceMac)) {
                BathMainFragment.this.mBluetoothDevice = bluetoothDevice;
                BathMainFragment.this.mOpenController.setBluetoothDevice(BathMainFragment.this.mBluetoothDevice);
                BathMainFragment.this.mCurrentState = State.scansuccess;
                LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(BathMainFragment.this.mIsBLEMode);
                if (BaseMaterialDialog.isShowMaterialDialog()) {
                    BaseMaterialDialog.setConnectMaterialDialog("已经搜索到蓝牙水控设备，正在连接设备...");
                    LeXiaoTongSDK.getInstance().setMode(BathMainFragment.this.mIsBLEMode);
                    BaseMaterialDialog.setConnectMaterialDialog("开始连接设备中..");
                    BathMainFragment.this.mOpenController.openDevice();
                }
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onComplete() {
            if (BathMainFragment.this.mCurrentState == State.scaning) {
                BaseMaterialDialog.dissmisMaterialDialog();
                LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(BathMainFragment.this.mIsBLEMode);
                new MaterialDialog.Builder(BathMainFragment.this.mContext).title("搜索蓝牙水控失败").content("1、请检查设备是否有人正在使用。\n2、请把手机靠近设备后再重试。\n3、按一下设备上的按钮，设备重起后再重试！").positiveText("确定").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.9.1
                    @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    }
                }).show();
            }
            BathMainFragment.this.mCurrentState = State.scanend;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onBluetoothException(ClientException clientException) {
            BaseMaterialDialog.dissmisMaterialDialog();
            SystemErrorTip.getInstance().showTipDialog(BathMainFragment.this.getActivity(), clientException.getDetail());
        }
    };
    private UnBindHamamDialogTip.UnBindDialogListener unBindDialogListener = new UnBindHamamDialogTip.UnBindDialogListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.10
        @Override // client.android.yixiaotong.ui.dialog.UnBindHamamDialogTip.UnBindDialogListener
        public void onCanle() {
        }

        @Override // client.android.yixiaotong.ui.dialog.UnBindHamamDialogTip.UnBindDialogListener
        public void onConfirm() {
            BathMainFragment.this.unbind();
        }
    };
    private BindhamamDialogTip.BindDialogListener bindDialogListener = new BindhamamDialogTip.BindDialogListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.11
        @Override // client.android.yixiaotong.ui.dialog.BindhamamDialogTip.BindDialogListener
        public void onCanle() {
        }

        @Override // client.android.yixiaotong.ui.dialog.BindhamamDialogTip.BindDialogListener
        public void onConfirm() {
            SelectAmmeterAddressActivity.launch(BathMainFragment.this.getActivity(), 5, BathMainFragment.this.mWalletModel);
        }
    };

    private enum State {
        scaning,
        scansuccess,
        scanend,
        connecting,
        connected,
        senddata
    }

    private void initViewNew(View view) {
        this.mTitleBar = (TitleBar) view.findViewById(R.id.tb_name);
        this.mIvMeIcon = (SimpleDraweeView) view.findViewById(R.id.iv_me_icon);
        this.mImgSex = (ImageView) view.findViewById(R.id.img_sex);
        this.mTvMeName = (TextView) view.findViewById(R.id.tv_me_name);
        this.mTvMeId = (TextView) view.findViewById(R.id.tv_me_id);
        this.mTvMeXueHao = (TextView) view.findViewById(R.id.tv_me_xuehao);
        this.mQiDong = (ImageView) view.findViewById(R.id.qidong);
        this.mTvQiehuanDevice = (TextView) view.findViewById(R.id.tv_qiehuandevice);
        this.mTvChakanRecored = (TextView) view.findViewById(R.id.tv_chakanrecord);
        this.mTvRoomAddress = (TextView) view.findViewById(R.id.tv_room_address);
        this.mTvUnbindroom = (TextView) view.findViewById(R.id.tv_unbindroom);
        this.mTvBalance = (TextView) view.findViewById(R.id.tv_balance);
        this.mRelMoney = (RelativeLayout) view.findViewById(R.id.rel_money);
    }

    public static BathMainFragment newInstance() {
        return new BathMainFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogUtil.e("BathMainFragment", "onCreateView");
        View viewInflate = layoutInflater.inflate(R.layout.fragment_bath_main, viewGroup, false);
        initViewNew(viewInflate);
        initTitleBar();
        initInfoView();
        this.mOpenController = new OpenController();
        getWalletMonel();
        return viewInflate;
    }

    private void initTitleBar() {
        WalletModel walletModel = this.mWalletModel;
        if (walletModel != null && StringUtils.isNotEmpty(walletModel.name)) {
            this.mTitleBar.setTitleView(this.mWalletModel.name);
        } else {
            this.mTitleBar.setTitleView("洗澡");
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initInfoView() {
        UserInfoBean userInfo = getLoginAccount().getAccountManagetStore().getUserInfo();
        this.mUserInfoBean = userInfo;
        if (userInfo == null) {
            return;
        }
        this.mIvMeIcon.setImageURI(UriUtil.parseUriOrNull(userInfo.Icon));
        if (this.mUserInfoBean.GenderId == 1) {
            this.mImgSex.setImageDrawable(getResources().getDrawable(R.mipmap.l_shouye_boy));
        } else {
            this.mImgSex.setImageDrawable(getResources().getDrawable(R.mipmap.l_shouye_girl));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentName)) {
            this.mTvMeName.setText(this.mUserInfoBean.StudentName);
        }
        String str = this.mUserInfoBean.ID + "";
        if (StringUtils.isNotEmpty(str) && str.length() > 4) {
            this.mTvMeId.setText("ID：**************" + str.substring(str.length() - 4, str.length()));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentNo)) {
            this.mTvMeXueHao.setText("学号：" + this.mUserInfoBean.StudentNo);
        }
    }

    private void getWalletMonel() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null) {
                    for (WalletModel walletModel : list) {
                        if (walletModel.typeId == 1) {
                            BathMainFragment.this.mWalletModel = walletModel;
                            BathMainFragment.this.initView();
                            LocalBusinessStore.saveOrderMoney(BathMainFragment.this.mContext, BathMainFragment.this.mWalletModel.typeId, "0");
                            BathMainFragment.this.mOpenController.initData(BathMainFragment.this.getActivity(), BathMainFragment.this.getLoginAccount(), BathMainFragment.this.mWalletModel);
                        }
                    }
                    return;
                }
                BathMainFragment.this.getActivity().finish();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                SystemErrorTip.getInstance().showTipDialog(BathMainFragment.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.1.1
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        BathMainFragment.this.getActivity().finish();
                    }
                }, clientException.getDetail());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        WalletModel walletModel = this.mWalletModel;
        if (walletModel == null) {
            return;
        }
        Activity activity = this.mContext;
        if (activity != null) {
            String orderMoney = LocalBusinessStore.getOrderMoney(activity, walletModel.typeId);
            if (StringUtils.isNotEmpty(orderMoney) && !orderMoney.equals("0")) {
                this.mTvBalance.setText(DecimalUtil.twoDecimal(orderMoney) + "元");
            } else {
                this.mTvBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(this.mWalletModel.getBalance() + "", "100")) + "元");
            }
        } else {
            this.mTvBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(this.mWalletModel.getBalance() + "", "100")) + "元");
        }
        this.mTvRoomAddress.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BathMainFragment.this.mTvRoomAddress.getText().toString().contains("未绑定")) {
                    SelectAmmeterAddressActivity.launch(BathMainFragment.this.getActivity(), 5, BathMainFragment.this.mWalletModel);
                }
            }
        });
        this.mQiDong.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String lastConnectBluetoothDeviceMac = LocalBusinessStore.getLastConnectBluetoothDeviceMac(BathMainFragment.this.mContext, BathMainFragment.this.mWalletModel.typeId);
                LocalBusinessStore.getLastConnectBluetoothDeviceHexId(BathMainFragment.this.mContext, BathMainFragment.this.mWalletModel.typeId);
                String lastConnectBluetoothDeviceName = LocalBusinessStore.getLastConnectBluetoothDeviceName(BathMainFragment.this.mContext, BathMainFragment.this.mWalletModel.typeId);
                BathMainFragment bathMainFragment = BathMainFragment.this;
                bathMainFragment.mIsBLEMode = LocalBusinessStore.getLastConnectIsBLE(bathMainFragment.mContext);
                BathMainFragment.this.mOpenController.setBLEMode(BathMainFragment.this.mIsBLEMode);
                Log.e("test", lastConnectBluetoothDeviceMac + "  " + BathMainFragment.this.mIsBLEMode);
                if (BathMainFragment.this.mWalletModel.getBalance() == 0) {
                    if (BathMainFragment.this.mWalletModel.refund == 1) {
                        RefundProgressActivity.launch(BathMainFragment.this.getActivity(), BathMainFragment.this.mWalletModel);
                        return;
                    } else {
                        ToastUtils.show(BathMainFragment.this.mContext, "余额为0，请充值后再使用");
                        return;
                    }
                }
                if (BathMainFragment.this.mWalletModel.max > BathMainFragment.this.mWalletModel.getBalance()) {
                    ToastUtils.show(BathMainFragment.this.mContext, "余额不足，请充值后再使用");
                    return;
                }
                if (!StringUtils.isNotEmpty(lastConnectBluetoothDeviceMac)) {
                    if (BathMainFragment.this.mWalletModel.refund == 1) {
                        RefundProgressActivity.launch(BathMainFragment.this.getActivity(), BathMainFragment.this.mWalletModel);
                        return;
                    } else {
                        BluetoothListTwoNewActivity.launch(BathMainFragment.this.getActivity(), BathMainFragment.this.mWalletModel);
                        return;
                    }
                }
                if (BluetoothManager.getInstance().isBluetoothOn()) {
                    LeXiaoTongSDK.getInstance().startScanBluetoothDevices(BathMainFragment.this.mScanListener, BathMainFragment.this.mIsBLEMode);
                    BathMainFragment.this.mCurrentState = State.scaning;
                    BaseMaterialDialog.showMaterialDialog(BathMainFragment.this.getActivity(), "正在搜索" + lastConnectBluetoothDeviceName, false);
                    return;
                }
                BathMainFragment.this.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2001);
            }
        });
        this.mTvUnbindroom.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BathMainFragment.this.showUnBingRoomDialog();
            }
        });
        this.mTvQiehuanDevice.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BathMainFragment.this.mWalletModel.refund == 1) {
                    RefundProgressActivity.launch(BathMainFragment.this.getActivity(), BathMainFragment.this.mWalletModel);
                } else {
                    BluetoothListTwoNewActivity.launch(BathMainFragment.this.getActivity(), BathMainFragment.this.mWalletModel);
                }
            }
        });
        this.mTvChakanRecored.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecordListActivity.launch(BathMainFragment.this.getActivity(), 1);
            }
        });
        this.mQiDong.setOnTouchListener(new View.OnTouchListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getX() < 100.0f || motionEvent.getY() < 70.0f || motionEvent.getX() > 480.0f || motionEvent.getY() > 400.0f;
            }
        });
        this.mRelMoney.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BathMainFragment.this.mWalletModel != null) {
                    WalletDetailActivity.launch(BathMainFragment.this.getActivity(), BathMainFragment.this.mWalletModel);
                }
            }
        });
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.e("BathMainFragment", "onResume");
        this.mIsEnable = true;
        this.mOpenController.onResume();
        if (this.mWalletModel == null) {
            return;
        }
        getBingRoomAddress();
        getWalletMonel();
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        LogUtil.e("BathMainFragment", "onPause");
        this.mIsEnable = false;
        this.mOpenController.onPause();
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        LogUtil.e("BathMainFragment", "onAttach");
        if (activity != null) {
            this.mContext = activity;
        } else {
            this.mContext = getActivity();
            activity = getActivity();
        }
        this.mWalletModel = ((BathMainActivity) activity).getmWalletModel();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        LogUtil.e("BathMainFragment", "onDetach");
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.e("BathMainFragment", "onDestroyView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUnBingRoomDialog() {
        if (!this.mTvRoomAddress.getText().toString().contains("未绑定")) {
            new UnBindHamamDialogTip().showUnBindDialog(getActivity(), this.unBindDialogListener, "您确定要解绑当前房间?", "", "解绑", "不了");
        } else {
            new BindhamamDialogTip().showBindDialog(getActivity(), this.bindDialogListener, "亲，您还未绑定房间哦！", "那么现在去绑定吧～", "再等等", "去绑定");
        }
    }

    private void getBingRoomAddress() {
        BusinessControllers.getInstance().ammeterGetRoomDetailNew(getLoginAccount(), new Listener<AmmeterRoomDetail>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterRoomDetail ammeterRoomDetail, Object... objArr) {
                if (ammeterRoomDetail == null || !BathMainFragment.this.mIsEnable) {
                    return;
                }
                PreferenceUtil.putBingdRoom(BathMainFragment.this.mContext, "bindRoom" + BathMainFragment.this.getLoginAccount().getUid(), Long.parseLong(ammeterRoomDetail.RoomID));
                PreferenceUtil.putBingdRoom(BathMainFragment.this.mContext, ammeterRoomDetail.RoomID, ammeterRoomDetail.Region + ammeterRoomDetail.Building + ammeterRoomDetail.Floor + ammeterRoomDetail.Room);
                BathMainFragment.this.mTvRoomAddress.setText("绑定房间：" + ammeterRoomDetail.Region + ammeterRoomDetail.Building + ammeterRoomDetail.Floor + ammeterRoomDetail.Room);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (BathMainFragment.this.mIsEnable) {
                    long bindRoom = PreferenceUtil.getBindRoom(BathMainFragment.this.mContext, "bindRoom" + BathMainFragment.this.getLoginAccount().getUid(), 0L);
                    String bindRoom2 = PreferenceUtil.getBindRoom(BathMainFragment.this.mContext, bindRoom + "", "0");
                    if (clientException.getCode() != -1000) {
                        BathMainFragment.this.mTvRoomAddress.setText("绑定房间：未绑定");
                    } else if (bindRoom == 0 || bindRoom2.equals("0")) {
                        BathMainFragment.this.mTvRoomAddress.setText("绑定房间：未绑定");
                    } else {
                        BathMainFragment.this.mTvRoomAddress.setText("绑定房间：" + bindRoom2);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unbind() {
        BusinessControllers.getInstance().ammeterUnBindingRoom(getLoginAccount(), this.mWalletModel.typeId, new Listener<AmmeterBindingRoom>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.13
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(BathMainFragment.this.getActivity(), "正在解绑中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterBindingRoom ammeterBindingRoom, Object... objArr) {
                if (ammeterBindingRoom.success == 1 && BathMainFragment.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    LocalBusinessStore.putBingdRoomStatus1(BathMainFragment.this.mContext, BathMainFragment.TYPE_PUTBINGDROOMSTATUS1 + BathMainFragment.this.getLoginAccount().getUid(), 0);
                    PreferenceUtil.putBingdRoom(BathMainFragment.this.mContext, "bindRoom" + BathMainFragment.this.getLoginAccount().getUid(), 0L);
                    PreferenceUtil.putDeviceMac(BathMainFragment.this.getContext(), BathMainFragment.TYPE_DEVICEMAC, "0");
                    PreferenceUtil.putBingdRoomMac(BathMainFragment.this.mContext, "bindRoommac" + BathMainFragment.this.getLoginAccount().getUid(), "0");
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(BaseApplication.app);
                    ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                    ToastUtils.show(BathMainFragment.this.getActivity(), "宿舍解绑成功,请重新登录！");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (BathMainFragment.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ErrorUtil.onFailResult(BathMainFragment.this.getActivity(), BathMainFragment.this.mTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2001 && i2 == -1) {
            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BathMainFragment.14
                @Override // java.lang.Runnable
                public void run() {
                    String lastConnectBluetoothDeviceName = LocalBusinessStore.getLastConnectBluetoothDeviceName(BathMainFragment.this.mContext, BathMainFragment.this.mWalletModel.typeId);
                    LeXiaoTongSDK.getInstance().startScanBluetoothDevices(BathMainFragment.this.mScanListener, BathMainFragment.this.mIsBLEMode);
                    BathMainFragment.this.mCurrentState = State.scaning;
                    BaseMaterialDialog.showMaterialDialog(BathMainFragment.this.getActivity(), "正在搜索" + lastConnectBluetoothDeviceName, false);
                }
            }, 500L);
        }
    }
}
