package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.bean.doorlock.AuthUserInfoBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockInfoBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockUserInfoBean;
import client.android.yixiaotong.controller.bean.doorlock.KeyBean;
import client.android.yixiaotong.controller.bean.region.RoundRectRegion;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.event.DoorLockInfoSyncEvent;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.UserInfoActivity;
import client.android.yixiaotong.ui.adapter.DoorLockKeyAdapter;
import client.android.yixiaotong.ui.adapter.DoorLockPressKeyAdapter;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.LocationUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DoorLockMainActivity extends BaseActivity {
    public static final int ADDCARD = 9;
    public static final int ADDPRESSKEY = 12;
    public static final int ADDPSWKEY = 5;
    private static final int CARD = 2;
    public static final int DELECTCARD = 10;
    public static final int DELECTPRESSKEY = 11;
    public static final int DELECTPSWKEY = 8;
    private static final String EXTRA_WALLET = "extra_wallet";
    public static final int GETOPENRECORD = 13;
    private static final int PRESS = 3;
    private static final int PSW = 1;
    private static final int RQCODe = 4;
    public static final int SEEPSWKEY = 7;
    public static final int SYNCDATA = 14;
    public static final int UPDATEPSWKEY = 6;
    private BluetoothDevice mBluetoothDevice;
    private DoorLockKeyAdapter mDoorLockKeyAdapter;
    private DoorLockPressKeyAdapter mDoorLockPressKeyAdapter;
    private DoorLockUserInfoBean mDoorLockUserInfoBean;
    private ImageView mImgDangerTip;
    private ImageView mImgEye1;
    private ImageView mImgEye2;
    private ImageView mImgEye3;
    private ImageView mImgEye4;
    private LinearLayout mLinCard;
    private LinearLayout mLinPress;
    private LinearLayout mLinPsw;
    private ListView mLvKey;
    private ListView mLvPressKey;
    private RelativeLayout mRelAddCard;
    private RelativeLayout mRelAddPressKey;
    private RelativeLayout mRelAddPswKey;
    private RelativeLayout mRelCardDetail;
    private SimpleDraweeView mSimpleDraweeView;
    private TitleBar mTitleBar;
    private TextView mTvAddCard;
    private TextView mTvAddCardTime;
    private TextView mTvAddPressKey;
    private TextView mTvAddPswKey;
    private TextView mTvAddress;
    private TextView mTvCardOpen;
    private TextView mTvID;
    private TextView mTvName;
    private TextView mTvPressOpen;
    private TextView mTvPswOpen;
    private TextView mTvQrcodeOpen;
    private TextView mTvRoomCard;
    private UserInfoBean mUserInfoBean;
    private WalletModel mWalletModel;
    private boolean mIsEnable = true;
    private boolean mIsVisableGuide = true;
    private int mSelectIndex = 1;
    private List<KeyBean> mListPswData = new ArrayList();
    private List<KeyBean> mListPressData = new ArrayList();
    private KeyBean mCardKeyDetail = null;
    private int mTotalKeys = 0;

    static {
        StubApp.interface11(6955);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DoorLockMainActivity.class).putExtra("extra_wallet", walletModel));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
        this.mSimpleDraweeView = (SimpleDraweeView) findViewById(R.id.iv_me_icon);
        this.mTvName = (TextView) findViewById(R.id.tv_me_name);
        this.mTvID = (TextView) findViewById(R.id.tv_me_id);
        this.mTvPswOpen = (TextView) findViewById(R.id.tv_pswopen);
        this.mTvCardOpen = (TextView) findViewById(R.id.tv_cardopen);
        this.mTvPressOpen = (TextView) findViewById(R.id.tv_pressopen);
        this.mTvQrcodeOpen = (TextView) findViewById(R.id.tv_qrcodeopen);
        this.mImgEye1 = (ImageView) findViewById(R.id.img_eye1);
        this.mImgEye2 = (ImageView) findViewById(R.id.img_eye2);
        this.mImgEye3 = (ImageView) findViewById(R.id.img_eye3);
        this.mImgEye4 = (ImageView) findViewById(R.id.img_eye4);
        this.mLinPsw = (LinearLayout) findViewById(R.id.lin_psw);
        this.mLinCard = (LinearLayout) findViewById(R.id.lin_card);
        this.mLinPress = (LinearLayout) findViewById(R.id.lin_press);
        this.mRelAddCard = (RelativeLayout) findViewById(R.id.rel_addcard);
        this.mRelCardDetail = (RelativeLayout) findViewById(R.id.rel_card);
        this.mTvAddCardTime = (TextView) findViewById(R.id.tv_addcardtime);
        this.mTvAddCard = (TextView) findViewById(R.id.tv_addcard);
        this.mTvRoomCard = (TextView) findViewById(R.id.tv_roomcard);
        this.mLvKey = (ListView) findViewById(R.id.lv_key);
        this.mLvPressKey = (ListView) findViewById(R.id.lv_presskey);
        this.mTvAddPswKey = (TextView) findViewById(R.id.tv_addpswkey);
        this.mRelAddPswKey = (RelativeLayout) findViewById(R.id.rel_addpswkey);
        this.mTvAddPressKey = (TextView) findViewById(R.id.tv_addpresskey);
        this.mRelAddPressKey = (RelativeLayout) findViewById(R.id.rel_addpresskey);
        this.mImgDangerTip = (ImageView) findViewById(R.id.img_dangertip);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(this.mWalletModel.name);
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setRightView(R.mipmap.l_doorlock_righticon);
        this.mTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AuthUserInfoBean authUserInfoBean = new AuthUserInfoBean();
                if (DoorLockMainActivity.this.mDoorLockUserInfoBean != null) {
                    authUserInfoBean.identityid = DoorLockMainActivity.this.mDoorLockUserInfoBean.identityid;
                    authUserInfoBean.sex = DoorLockMainActivity.this.mDoorLockUserInfoBean.sex + "";
                    authUserInfoBean.room = DoorLockMainActivity.this.mDoorLockUserInfoBean.room;
                    authUserInfoBean.studentname = DoorLockMainActivity.this.mDoorLockUserInfoBean.name;
                }
                DoorLockMeActivity.launch(DoorLockMainActivity.this.getActivity(), DoorLockMainActivity.this.mWalletModel, authUserInfoBean, DoorLockMainActivity.this.mBluetoothDevice);
            }
        });
    }

    private void initInfoView() {
        UserInfoBean userInfo = getLoginAccount().getAccountManagetStore().getUserInfo();
        this.mUserInfoBean = userInfo;
        if (userInfo != null) {
            this.mSimpleDraweeView.setImageURI(UriUtil.parseUriOrNull(userInfo.Icon));
            if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentName)) {
                this.mTvName.setText(this.mUserInfoBean.StudentName);
            }
            if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentNo)) {
                this.mTvID.setText(this.mUserInfoBean.StudentNo);
            }
        }
    }

    private void initAdapter() {
        DoorLockKeyAdapter doorLockKeyAdapter = new DoorLockKeyAdapter(getActivity(), getLoginAccount(), this.mWalletModel, this.mListPswData);
        this.mDoorLockKeyAdapter = doorLockKeyAdapter;
        this.mLvKey.setAdapter((ListAdapter) doorLockKeyAdapter);
        this.mDoorLockKeyAdapter.notifyDataSetChanged();
        DoorLockPressKeyAdapter doorLockPressKeyAdapter = new DoorLockPressKeyAdapter(getActivity(), getLoginAccount(), this.mWalletModel, this.mListPressData);
        this.mDoorLockPressKeyAdapter = doorLockPressKeyAdapter;
        this.mLvPressKey.setAdapter((ListAdapter) doorLockPressKeyAdapter);
        this.mDoorLockPressKeyAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView(DoorLockUserInfoBean doorLockUserInfoBean, int i) {
        this.mListPswData.clear();
        this.mListPressData.clear();
        this.mCardKeyDetail = null;
        this.mTotalKeys = 0;
        noCardView();
        if (doorLockUserInfoBean.keys != null) {
            for (KeyBean keyBean : doorLockUserInfoBean.keys) {
                if (keyBean.synchronization_flag == 1 || (keyBean.synchronization_flag == 0 && keyBean.sysflag == 3)) {
                    if (keyBean.keyflag == 1) {
                        this.mListPressData.add(keyBean);
                        this.mTotalKeys++;
                    } else if (keyBean.keyflag == 2) {
                        this.mListPswData.add(keyBean);
                        this.mTotalKeys++;
                    } else if (keyBean.keyflag == 3) {
                        this.mCardKeyDetail = keyBean;
                        this.mTotalKeys++;
                        hasCardView();
                    }
                }
            }
            this.mDoorLockKeyAdapter.setBluetoothDevice(this.mBluetoothDevice);
            this.mDoorLockKeyAdapter.notifyDataSetChanged();
            this.mDoorLockPressKeyAdapter.setBluetoothDevice(this.mBluetoothDevice);
            this.mDoorLockPressKeyAdapter.notifyDataSetChanged();
        }
        if (this.mIsVisableGuide && this.mListPswData.size() == 0 && this.mListPressData.size() == 0 && this.mCardKeyDetail == null) {
            toGuide();
        }
        this.mIsVisableGuide = false;
        LocalBusinessStore.saveDoorLockPressCount(getContext(), this.mListPressData.size());
        if (i == 0) {
            this.mImgDangerTip.setVisibility(0);
            if (LocalBusinessStore.getDoorLockDangerTime(getActivity()) == 0) {
                LocalBusinessStore.saveDoorLockDangerTime(getContext(), System.currentTimeMillis() / 1000);
            }
        } else {
            this.mImgDangerTip.setVisibility(8);
            LocalBusinessStore.saveDoorLockDangerTime(getContext(), 0L);
        }
        if (StringUtils.isNotEmpty(doorLockUserInfoBean.room)) {
            this.mTvAddress.setText("宿舍地址：" + doorLockUserInfoBean.room);
        } else {
            this.mTvAddress.setText("宿舍地址：");
        }
        if (this.mTotalKeys >= 10) {
            this.mTvAddPswKey.setVisibility(4);
            this.mRelAddPswKey.setVisibility(4);
            if (this.mCardKeyDetail == null) {
                this.mTvAddCard.setVisibility(4);
                this.mRelAddCard.setVisibility(4);
            }
            this.mTvAddPressKey.setVisibility(4);
            this.mRelAddPressKey.setVisibility(4);
            return;
        }
        this.mTvAddPswKey.setVisibility(0);
        this.mRelAddPswKey.setVisibility(0);
        if (this.mCardKeyDetail == null) {
            this.mTvAddCard.setVisibility(0);
            this.mRelAddCard.setVisibility(0);
        }
        this.mTvAddPressKey.setVisibility(0);
        this.mRelAddPressKey.setVisibility(0);
    }

    private void hasCardView() {
        this.mTvAddCard.setVisibility(8);
        this.mRelAddCard.setVisibility(8);
        this.mRelCardDetail.setVisibility(0);
        KeyBean keyBean = this.mCardKeyDetail;
        if (keyBean != null) {
            this.mTvAddCardTime.setText(keyBean.key_create_datetime);
            if (StringUtils.isNotEmpty(this.mCardKeyDetail.keyname)) {
                this.mTvRoomCard.setText(this.mCardKeyDetail.keyname);
            }
        }
    }

    private void noCardView() {
        this.mTvAddCard.setVisibility(0);
        this.mRelAddCard.setVisibility(0);
        this.mRelCardDetail.setVisibility(8);
    }

    private void initData() {
        BusinessControllers.getInstance().getDoorLockUserInfo(getLoginAccount(), this.mWalletModel.typeId, RandomUtil.getRandNumMaxString(6), new Listener<DoorLockInfoBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DoorLockInfoBean doorLockInfoBean, Object... objArr) {
                if (DoorLockMainActivity.this.mIsEnable) {
                    if (doorLockInfoBean == null || !doorLockInfoBean.random.equals(doorLockInfoBean.random) || doorLockInfoBean.info == null) {
                        SystemErrorTip.getInstance().showTipDialog(DoorLockMainActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.2.1
                            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                            public void onConfirm() {
                                DoorLockMainActivity.this.finish();
                            }
                        }, "后台返回数据出错");
                        return;
                    }
                    DoorLockMainActivity.this.mDoorLockUserInfoBean = doorLockInfoBean.info;
                    DoorLockMainActivity.this.mBluetoothDevice = null;
                    if (StringUtils.isNotEmpty(doorLockInfoBean.info.mac)) {
                        DoorLockMainActivity.this.mBluetoothDevice = new BluetoothDevice(DoorLockMainActivity.this.getMAC(doorLockInfoBean.info.mac), DoorLockMainActivity.this.getMAC(doorLockInfoBean.info.mac));
                    }
                    DoorLockMainActivity.this.initView(doorLockInfoBean.info, doorLockInfoBean.NOSynchronizationUser);
                    LocalBusinessStore.saveDoorLockMachineid(DoorLockMainActivity.this.getContext(), doorLockInfoBean.info.machineid);
                    LocalBusinessStore.saveDoorLockRoomid(DoorLockMainActivity.this.getContext(), doorLockInfoBean.info.roomid);
                    LocalBusinessStore.saveDoorLockRoomAddress(DoorLockMainActivity.this.getContext(), doorLockInfoBean.info.room);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DoorLockMainActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(DoorLockMainActivity.this.getActivity(), DoorLockMainActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    private void toGuide() {
        ArrayList arrayList = new ArrayList();
        RectF viewLocation = LocationUtils.getViewLocation(this.mTvAddress);
        LocationUtils.expandRectF(viewLocation, 10);
        arrayList.add(new RoundRectRegion(viewLocation, 10.0f, 10.0f));
        RectF viewLocation2 = LocationUtils.getViewLocation(this.mTvAddPswKey);
        LocationUtils.expandRectF(viewLocation2, 20);
        arrayList.add(new RoundRectRegion(viewLocation2, 10.0f, 10.0f));
        RectF viewLocation3 = LocationUtils.getViewLocation(this.mRelAddPswKey);
        LocationUtils.expandRectF(viewLocation3, 10);
        arrayList.add(new RoundRectRegion(viewLocation3, 10.0f, 10.0f));
        DoorLockGuideActivity.launch(getActivity(), arrayList);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    private void initClickListeners() {
        findViewById(R.id.ll_me_info).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserInfoActivity.launch(DoorLockMainActivity.this.getActivity(), DoorLockMainActivity.this.mUserInfoBean);
            }
        });
        findViewById(R.id.tv_pswopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DoorLockMainActivity.this.mSelectIndex = 1;
                DoorLockMainActivity.this.setSelecetView();
            }
        });
        findViewById(R.id.tv_cardopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DoorLockMainActivity.this.mSelectIndex = 2;
                DoorLockMainActivity.this.setSelecetView();
            }
        });
        findViewById(R.id.tv_pressopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DoorLockMainActivity.this.mSelectIndex = 3;
                DoorLockMainActivity.this.setSelecetView();
            }
        });
        findViewById(R.id.tv_qrcodeopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToastUtils.show(DoorLockMainActivity.this.getContext(), "暂未开通，敬请期待");
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DoorLockMainActivity.this.mSelectIndex = 5;
                DoorLockMainActivity.this.toLaunch();
            }
        };
        findViewById(R.id.tv_addpswkey).setOnClickListener(onClickListener);
        findViewById(R.id.rel_addpswkey).setOnClickListener(onClickListener);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DoorLockMainActivity.this.mSelectIndex = 9;
                DoorLockMainActivity.this.toLaunch();
            }
        };
        findViewById(R.id.tv_addcard).setOnClickListener(onClickListener2);
        findViewById(R.id.rel_addcard).setOnClickListener(onClickListener2);
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DoorLockMainActivity.this.mSelectIndex = 12;
                DoorLockMainActivity.this.toLaunch();
            }
        };
        findViewById(R.id.tv_addpresskey).setOnClickListener(onClickListener3);
        findViewById(R.id.rel_addpresskey).setOnClickListener(onClickListener3);
        findViewById(R.id.btn_delectcard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DoorLockMainActivity.this.showDelectDialogTip();
            }
        });
        findViewById(R.id.img_dangertip).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DangerTipActivity.launch(DoorLockMainActivity.this.getActivity(), DoorLockMainActivity.this.mBluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toLaunch() {
        BluetoothDevice bluetoothDevice = this.mBluetoothDevice;
        if (bluetoothDevice != null && StringUtils.isNotEmpty(bluetoothDevice.address)) {
            if (!LocalBusinessStore.getDoorLockTip(getContext())) {
                RouseTipActivity.launch(getActivity(), this.mSelectIndex, this.mBluetoothDevice);
                return;
            }
            Log.e("test", (this.mBluetoothDevice == null) + PPSLabelView.Code + this.mSelectIndex);
            int i = this.mSelectIndex;
            if (i == 5) {
                AddKeyActivity.launch(getActivity(), this.mBluetoothDevice);
                return;
            }
            if (i == 9) {
                AddCardActivity.launch(getActivity(), this.mBluetoothDevice);
                return;
            } else if (i == 10) {
                DelectKeyController.getInstance().init(getActivity(), getLoginAccount(), this.mWalletModel, this.mBluetoothDevice, this.mSelectIndex);
                return;
            } else {
                if (i == 12) {
                    AddPressActivity.launch(getActivity(), this.mBluetoothDevice);
                    return;
                }
                return;
            }
        }
        ToastUtils.show(getActivity(), "当前宿舍没有设备！");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelecetView() {
        int i = this.mSelectIndex;
        if (i == 1) {
            this.mTvPswOpen.getPaint().setFakeBoldText(true);
            this.mTvPswOpen.setTextSize(16.0f);
            this.mTvPswOpen.setTextColor(getResources().getColor(R.color.ffFF8E33));
            this.mTvCardOpen.setTextSize(14.0f);
            this.mTvCardOpen.getPaint().setFakeBoldText(false);
            this.mTvCardOpen.setTextColor(getResources().getColor(R.color.ff666666));
            this.mTvPressOpen.setTextSize(14.0f);
            this.mTvPressOpen.getPaint().setFakeBoldText(false);
            this.mTvPressOpen.setTextColor(getResources().getColor(R.color.ff666666));
            this.mImgEye1.setVisibility(0);
            this.mImgEye2.setVisibility(4);
            this.mImgEye3.setVisibility(4);
            this.mLinPsw.setVisibility(0);
            this.mLinCard.setVisibility(8);
            this.mLinPress.setVisibility(8);
            return;
        }
        if (i == 2) {
            this.mTvPswOpen.setTextSize(14.0f);
            this.mTvPswOpen.getPaint().setFakeBoldText(false);
            this.mTvPswOpen.setTextColor(getResources().getColor(R.color.ff666666));
            this.mTvCardOpen.setTextSize(16.0f);
            this.mTvCardOpen.getPaint().setFakeBoldText(true);
            this.mTvCardOpen.setTextColor(getResources().getColor(R.color.ffFF8E33));
            this.mTvPressOpen.setTextSize(14.0f);
            this.mTvPressOpen.getPaint().setFakeBoldText(false);
            this.mTvPressOpen.setTextColor(getResources().getColor(R.color.ff666666));
            this.mImgEye1.setVisibility(4);
            this.mImgEye2.setVisibility(0);
            this.mImgEye3.setVisibility(4);
            this.mLinPsw.setVisibility(8);
            this.mLinCard.setVisibility(0);
            this.mLinPress.setVisibility(8);
            return;
        }
        if (i == 3) {
            this.mTvPswOpen.setTextSize(14.0f);
            this.mTvPswOpen.getPaint().setFakeBoldText(false);
            this.mTvPswOpen.setTextColor(getResources().getColor(R.color.ff666666));
            this.mTvCardOpen.setTextSize(14.0f);
            this.mTvCardOpen.getPaint().setFakeBoldText(false);
            this.mTvCardOpen.setTextColor(getResources().getColor(R.color.ff666666));
            this.mTvPressOpen.setTextSize(16.0f);
            this.mTvPressOpen.getPaint().setFakeBoldText(true);
            this.mTvPressOpen.setTextColor(getResources().getColor(R.color.ffFF8E33));
            this.mImgEye1.setVisibility(4);
            this.mImgEye2.setVisibility(4);
            this.mImgEye3.setVisibility(0);
            this.mLinPsw.setVisibility(8);
            this.mLinCard.setVisibility(8);
            this.mLinPress.setVisibility(0);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        BluetoothSDK.getInstance().closeBLE();
        DelectKeyController.getInstance().onResume();
        initData();
    }

    public void onEventMainThread(DoorLockInfoSyncEvent doorLockInfoSyncEvent) {
        initData();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        DelectKeyController.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mIsEnable = false;
        BluetoothSDK.getInstance().closeBLE();
        EventBus.getDefault().unregister(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDelectDialogTip() {
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.13
            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                LocalBusinessStore.saveDoorLockDeviceKeyID(DoorLockMainActivity.this.getActivity(), DoorLockMainActivity.this.mCardKeyDetail.keyid);
                LocalBusinessStore.saveDoorLockServerKeyID(DoorLockMainActivity.this.getActivity(), DoorLockMainActivity.this.mCardKeyDetail.door_student_machine_key_id);
                DoorLockMainActivity.this.mSelectIndex = 10;
                DoorLockMainActivity.this.toLaunch();
            }
        }, "", getResources().getString(R.string.doorlock_delectcard_tip), getResources().getString(R.string.cancel), getResources().getString(R.string.delect));
    }

    private void uploadOldRecords() {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        String doorLockRecord = LocalBusinessStore.getDoorLockRecord(getContext());
        if (StringUtils.isNotEmpty(doorLockRecord)) {
            BusinessControllers.getInstance().getDoorLockUploadRecords(getLoginAccount(), this.mWalletModel.typeId, randNumMaxString, doorLockRecord, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockMainActivity.14
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (DoorLockMainActivity.this.mIsEnable && successBean != null && randNumMaxString.equals(successBean.random)) {
                        LocalBusinessStore.saveDoorLockRrcord(DoorLockMainActivity.this.getContext(), "");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMAC(String str) {
        if (!StringUtils.isNotEmpty(str) || str.contains(x.bQ) || str.length() != 12) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = 1; i <= 5; i++) {
            sb.insert(((i * 2) + i) - 1, x.bQ);
        }
        return sb.toString().toUpperCase();
    }
}
