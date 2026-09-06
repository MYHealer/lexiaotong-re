package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.util.Log;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.doorlock.DLHACBean;
import client.android.yixiaotong.controller.bean.doorlock.DLKeyBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockAddKeyBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockAllUsersInfoBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockKeyInfo;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockKeyInfos;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockNotSyncKey;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockNotSyncKeys;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockUserIDInfoBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.HttpBusinessStoreJava;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.error.ErrorTipActivity;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.doorlock.DoorLockCommandUtil;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DoorLockSyncInfoControllerUtil {
    private String EAC;
    private String HAC;
    private String R1;
    private String R2;
    private Account mAccount;
    private Activity mActivity;
    private String mBlackListKeys;
    private List<String> mBlackListUser;
    private int mChangeKeyCount;
    private String mDeleteKeyID;
    private String mDeviceAllKey;
    private String mDeviceAllUserID;
    private String mDeviceUserID;
    private String mDoorStudentMachineKeyId;
    private FunctionState mFunctionState;
    private boolean mIsEnable;
    private String mKeyName;
    private List<DoorLockKeyInfo> mKeys;
    private Listener mListener;
    private String mMachineId;
    private String mManagerUserID;
    private List<DoorLockUserIDInfoBean> mNeedDelectUser;
    private List<DoorLockNotSyncKey> mNeedSyncKeyUser;
    private List<DoorLockKeyInfo> mNeedSyncKeys;
    private List<DoorLockUserIDInfoBean> mNeedSyncUser;
    private String mPswKey;
    private State mState;
    private TimeOut mTimeOut;
    private String mUpdateKeyID;
    private String mUserID;
    private List<DoorLockUserIDInfoBean> mUsers;
    private String mVersion;
    private WalletModel mWalletModel;

    public enum FunctionState {
        none,
        addpswkey,
        addcard,
        addpress,
        changepsw,
        delectpsw,
        delectcard,
        delectpress,
        syncdata
    }

    interface Listener {
        void onEnd();

        void onSendData(String str);

        void onSyncEnd();
    }

    public enum State {
        none,
        getuserid,
        delectuserid,
        syncaddkey,
        syncdelkey,
        syncchangekey,
        addpswkey,
        addcard,
        addpress,
        changepsw,
        delectpsw,
        delectcard,
        delectpress
    }

    private enum TimeOut {
        none,
        sendfail
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    private DoorLockSyncInfoControllerUtil() {
        this.mState = State.none;
        this.mFunctionState = FunctionState.none;
        this.mIsEnable = true;
        this.R1 = "";
        this.R2 = "";
        this.mUserID = "";
        this.mManagerUserID = "";
        this.mDeviceAllUserID = "";
        this.mDeviceUserID = "";
        this.mDeviceAllKey = "";
        this.mMachineId = "";
        this.HAC = "";
        this.EAC = "";
        this.mUsers = new ArrayList();
        this.mNeedDelectUser = new ArrayList();
        this.mBlackListUser = new ArrayList();
        this.mNeedSyncUser = new ArrayList();
        this.mNeedSyncKeyUser = new ArrayList();
        this.mKeys = new ArrayList();
        this.mNeedSyncKeys = new ArrayList();
        this.mChangeKeyCount = 0;
        this.mBlackListKeys = "";
        this.mDoorStudentMachineKeyId = "";
        this.mKeyName = "";
        this.mPswKey = "";
        this.mUpdateKeyID = "";
        this.mDeleteKeyID = "";
        this.mTimeOut = TimeOut.none;
    }

    private static final class SingleHolder {
        private static final DoorLockSyncInfoControllerUtil INSTANCE = new DoorLockSyncInfoControllerUtil();

        private SingleHolder() {
        }
    }

    public static DoorLockSyncInfoControllerUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void initData(Activity activity, Account account, WalletModel walletModel) {
        initData();
        this.mActivity = activity;
        this.mAccount = account;
        this.mWalletModel = walletModel;
    }

    private void initData() {
        this.mState = State.none;
        this.mFunctionState = FunctionState.none;
        this.R1 = "";
        this.R2 = "";
        this.mUserID = "";
        this.mManagerUserID = "";
        this.mDeviceAllUserID = "";
        this.mDeviceUserID = "";
        this.mDeviceAllKey = "";
        this.mMachineId = "";
        this.HAC = "";
        this.EAC = "";
        this.mUsers.clear();
        this.mNeedDelectUser.clear();
        this.mBlackListUser.clear();
        this.mNeedSyncUser.clear();
        this.mNeedSyncKeyUser.clear();
        this.mKeys.clear();
        this.mNeedSyncKeys.clear();
        this.mChangeKeyCount = 0;
        this.mBlackListKeys = "";
        this.mDoorStudentMachineKeyId = "";
    }

    public void setFunctionState(FunctionState functionState, String str, String str2) {
        this.mFunctionState = functionState;
        this.mKeyName = str;
        this.mPswKey = str2;
        this.mState = State.getuserid;
        this.mUserID = this.mAccount.getAccountManagetStore().getUserInfo().stId;
        sendF0();
    }

    public void setFunctionStateUpdate(FunctionState functionState, String str, String str2, String str3) {
        this.mFunctionState = functionState;
        this.mDoorStudentMachineKeyId = str;
        this.mPswKey = str3;
        this.mUpdateKeyID = str2;
        this.mState = State.getuserid;
        this.mUserID = this.mAccount.getAccountManagetStore().getUserInfo().stId;
        sendF0();
    }

    public void setFunctionStateDelete(FunctionState functionState, String str, String str2) {
        this.mFunctionState = functionState;
        this.mDoorStudentMachineKeyId = str;
        this.mDeleteKeyID = str2;
        this.mState = State.getuserid;
        this.mUserID = this.mAccount.getAccountManagetStore().getUserInfo().stId;
        sendF0();
    }

    public void setFunctionStateSyncData(FunctionState functionState) {
        this.mFunctionState = functionState;
        this.mState = State.getuserid;
        this.mUserID = this.mAccount.getAccountManagetStore().getUserInfo().stId;
        sendF0();
    }

    public void onReceivedData(String str) {
        if (str.length() > 6 && str.substring(4, 6).equalsIgnoreCase("B0")) {
            this.mMachineId = DoorLockCommandUtil.getSmallFormatData(str.substring(6, 14));
            uploadStatus((Integer.parseInt(str.substring(14, 16), 16) * 20) + "%", Integer.parseInt(DoorLockCommandUtil.getSmallFormatData(str.substring(16, 20)), 16));
            this.R1 = str.substring(20, 36);
            this.R2 = RandomUtil.getRandNumMaxString(8) + RandomUtil.getRandNumMaxString(8);
            getHAC();
            return;
        }
        if (str.length() > 6 && str.substring(4, 6).equalsIgnoreCase("B1")) {
            Log.e("test", "b1state:" + this.mState);
            if (str.substring(6, 8).equals("00") && str.length() >= 18) {
                String strSubstring = str.substring(8, 16);
                this.mDeviceUserID = str.substring(16, 18);
                if (this.EAC.equals(strSubstring)) {
                    if (this.mState == State.getuserid) {
                        sendBC(0);
                        return;
                    }
                    if (this.mState == State.delectuserid) {
                        sendB4();
                        return;
                    }
                    if (this.mState == State.syncaddkey) {
                        sendBC(1);
                        return;
                    }
                    if (this.mState == State.syncdelkey) {
                        sendB8(0, this.mNeedSyncKeys.get(0).keyid, "");
                        return;
                    }
                    if (this.mState == State.syncchangekey) {
                        this.mChangeKeyCount = 0;
                        getEncryptData(2, this.mNeedSyncKeys.get(0).keyid, this.mNeedSyncKeys.get(0).key_passwrod);
                        return;
                    } else {
                        if (this.mState == State.addpswkey || this.mState == State.changepsw || this.mState == State.delectpsw || this.mState == State.addcard || this.mState == State.delectcard || this.mState == State.addpress || this.mState == State.delectpress) {
                            isRegisterUserID();
                            return;
                        }
                        return;
                    }
                }
                showDialog("授权失败！200005");
                return;
            }
            showDialog("授权失败！200002");
            return;
        }
        if (str.length() > 6 && str.substring(4, 6).equalsIgnoreCase("B4")) {
            if (str.substring(6, 8).equals("00") || str.substring(6, 8).equalsIgnoreCase("0A")) {
                if (this.mNeedDelectUser.size() > 0) {
                    syncServerUserID(this.mNeedDelectUser.get(0));
                    return;
                } else {
                    if (this.mBlackListUser.size() > 0) {
                        this.mBlackListUser.remove(0);
                        syncUserID();
                        return;
                    }
                    return;
                }
            }
            showDialog("授权失败！200006");
            return;
        }
        if (str.length() > 6 && str.substring(4, 6).equalsIgnoreCase("B7")) {
            if (str.substring(6, 8).equals("00")) {
                addUserID(str.substring(8, 10));
                return;
            } else if (str.substring(6, 8).equalsIgnoreCase("0B") && !this.mDeviceUserID.equalsIgnoreCase("FF")) {
                addUserID(this.mDeviceUserID);
                return;
            } else {
                showDialog("添加用户失败！200009");
                return;
            }
        }
        if (str.length() > 6 && str.substring(4, 6).equalsIgnoreCase("B8")) {
            Log.e("test", "state:" + this.mState);
            if (this.mState == State.syncdelkey) {
                if (str.substring(6, 8).equals("00") || str.substring(6, 8).equals("04")) {
                    syncKeyToServer(this.mNeedSyncKeys.get(0).keyid, 0);
                    return;
                } else {
                    showDialog("通讯失败！200007");
                    return;
                }
            }
            if (this.mState == State.syncchangekey) {
                if (str.substring(6, 8).equals("00")) {
                    syncKeyToServer(this.mNeedSyncKeys.get(0).keyid, 1);
                    return;
                }
                int i = this.mChangeKeyCount + 1;
                this.mChangeKeyCount = i;
                if (i >= 2) {
                    this.mChangeKeyCount = 0;
                    showDialog("通讯失败！200008");
                    return;
                } else {
                    getEncryptData(2, this.mNeedSyncKeys.get(0).keyid, this.mNeedSyncKeys.get(0).old_key_passwrod);
                    return;
                }
            }
            if (this.mState == State.syncaddkey) {
                if (str.substring(6, 8).equals("00")) {
                    String str2 = this.mBlackListKeys;
                    String strReplace = str2.replace(str2.substring(0, 2), "");
                    this.mBlackListKeys = strReplace;
                    if (StringUtils.isNotEmpty(strReplace) && this.mBlackListKeys.length() >= 2) {
                        sendB8(0, this.mBlackListKeys.substring(0, 2), "");
                        return;
                    } else {
                        syncKeyToServer("", 0);
                        return;
                    }
                }
                showDialog("通讯失败！200007");
                return;
            }
            if (this.mState == State.addpswkey) {
                if (str.substring(6, 8).equals("00")) {
                    syncKeyToServer(str.substring(8, 10), 1);
                    return;
                } else {
                    showDialog("添加密码失败！200010");
                    return;
                }
            }
            if (this.mState == State.changepsw) {
                if (str.substring(6, 8).equals("00")) {
                    syncKeyToServer(this.mUpdateKeyID, 1);
                    return;
                } else {
                    showDialog("修改密码失败！200008");
                    return;
                }
            }
            if (this.mState == State.delectpsw || this.mState == State.delectcard || this.mState == State.delectpress) {
                if (str.substring(6, 8).equals("00") || str.substring(6, 8).equals("04")) {
                    syncKeyToServer(this.mDeleteKeyID, 0);
                    return;
                } else {
                    showDialog("删除失败！200007");
                    return;
                }
            }
            return;
        }
        if (str.length() > 6 && str.substring(4, 6).equalsIgnoreCase("B9")) {
            this.mTimeOut = TimeOut.none;
            if (str.substring(0, 2).equalsIgnoreCase("D2") && str.substring(6, 8).equals("00")) {
                syncKeyToServer(str.substring(8, 10), 1);
                return;
            }
            if (str.substring(0, 2).equalsIgnoreCase("D3") && str.substring(6, 8).equals("00")) {
                return;
            }
            if (str.substring(0, 2).equalsIgnoreCase("D4") && str.substring(6, 8).equals("00")) {
                syncKeyToServer(str.substring(10, 12), 1);
                return;
            } else if (this.mState == State.addcard) {
                showDialog("添加卡片失败！200011");
                return;
            } else {
                showDialog("添加指纹失败！200011");
                return;
            }
        }
        if (str.length() > 6 && str.substring(4, 6).equalsIgnoreCase("BC")) {
            if (str.length() >= 34) {
                this.mManagerUserID = DoorLockCommandUtil.getSmallFormatData(str.substring(26, 34));
                for (int i2 = 1; i2 <= 10; i2++) {
                    int i3 = i2 * 2;
                    if (!str.substring(i3 + 4, i3 + 6).equalsIgnoreCase("FF")) {
                        if (i2 == 10) {
                            this.mDeviceAllUserID += "0A";
                        } else {
                            this.mDeviceAllUserID += "0" + i2;
                        }
                    }
                }
                getAllUserIDInfo();
                return;
            }
            String upperCase = str.substring(6, 26).toUpperCase();
            this.mDeviceAllKey = upperCase;
            String keys = DoorLockCommandUtil.getKeys(this.mDeviceUserID, upperCase);
            if (StringUtils.isNotEmpty(keys)) {
                for (int i4 = 0; i4 < this.mKeys.size(); i4++) {
                    if (StringUtils.isNotEmpty(this.mKeys.get(i4).keyid) && StringUtils.isNotEmpty(keys) && keys.contains(this.mKeys.get(i4).keyid)) {
                        keys = keys.replace(this.mKeys.get(i4).keyid, "");
                    }
                }
            }
            if (StringUtils.isEmpty(keys)) {
                syncKeyToServer("", 0);
                return;
            }
            if (keys.length() == 2) {
                syncKeyToServer(keys, 1);
                return;
            } else {
                if (keys.length() > 2) {
                    this.mBlackListKeys = keys;
                    sendB8(0, keys.substring(0, 2), "");
                    return;
                }
                return;
            }
        }
        if (str.substring(4, 6).equalsIgnoreCase("F0")) {
            this.mVersion = DoorLockCommandUtil.asciiToString(str.substring(6));
            sendB0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTimeOut(int i, final String str) {
        this.mTimeOut = TimeOut.sendfail;
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.1
            @Override // java.lang.Runnable
            public void run() {
                if (DoorLockSyncInfoControllerUtil.this.mTimeOut != TimeOut.none) {
                    DoorLockSyncInfoControllerUtil.this.showDialog(str);
                }
            }
        }, i);
    }

    private void sendB0() {
        this.mListener.onSendData(DoorLockCommandUtil.getB0Command(this.mUserID));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendB1() {
        this.mListener.onSendData(DoorLockCommandUtil.getB1Command(this.R2, this.HAC));
    }

    private void sendB4() {
        String str;
        if (this.mNeedDelectUser.size() > 0) {
            str = this.mNeedDelectUser.get(0).hardwareUserid;
        } else {
            str = this.mBlackListUser.size() > 0 ? this.mBlackListUser.get(0) : "";
        }
        this.mListener.onSendData(DoorLockCommandUtil.getB4DelectIDCommand(str));
    }

    private void sendB7(int i) {
        this.mListener.onSendData(DoorLockCommandUtil.getB7EditAccountCommand(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendB8(int i, String str, String str2) {
        this.mListener.onSendData(DoorLockCommandUtil.getB8EditKeyCommand(i, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendB9(int i, String str) {
        this.mListener.onSendData(DoorLockCommandUtil.getB9RegFingerprintOrCardIdCommand(i, str));
    }

    private void sendBC(int i) {
        this.mListener.onSendData(DoorLockCommandUtil.getBCAccountInfoCommand(i));
    }

    private void sendF0() {
        this.mListener.onSendData(DoorLockCommandUtil.getF0DeviceInfoCommand());
    }

    private void getHAC() {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().getDLHAC(this.mAccount, this.mWalletModel.typeId, randNumMaxString, this.mMachineId, this.mUserID, this.R1, this.R2, new client.android.yixiaotong.controller.core.Listener<DLHACBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DLHACBean dLHACBean, Object... objArr) {
                if (DoorLockSyncInfoControllerUtil.this.mIsEnable) {
                    if (dLHACBean == null || !randNumMaxString.equals(dLHACBean.random) || !StringUtils.isNotEmpty(dLHACBean.hac) || !StringUtils.isNotEmpty(dLHACBean.eac)) {
                        DoorLockSyncInfoControllerUtil.this.showDialog("获取后台数据HAC异常!");
                        return;
                    }
                    DoorLockSyncInfoControllerUtil.this.HAC = dLHACBean.hac;
                    DoorLockSyncInfoControllerUtil.this.EAC = dLHACBean.eac;
                    DoorLockSyncInfoControllerUtil.this.sendB1();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DoorLockSyncInfoControllerUtil.this.manageError(clientException);
            }
        });
    }

    private void getAllUserIDInfo() {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().getDoorLockAllUserID(this.mAccount, this.mWalletModel.typeId, randNumMaxString, this.mMachineId, LocalBusinessStore.getDoorLockRoomid(this.mActivity), new client.android.yixiaotong.controller.core.Listener<DoorLockAllUsersInfoBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DoorLockAllUsersInfoBean doorLockAllUsersInfoBean, Object... objArr) {
                if (DoorLockSyncInfoControllerUtil.this.mIsEnable) {
                    if (doorLockAllUsersInfoBean == null || !doorLockAllUsersInfoBean.random.equals(randNumMaxString)) {
                        DoorLockSyncInfoControllerUtil.this.showDialog("获取后台数据异常!");
                    } else {
                        DoorLockSyncInfoControllerUtil.this.checkIsNeedSync(doorLockAllUsersInfoBean.hardwareUsers);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DoorLockSyncInfoControllerUtil.this.manageError(clientException);
            }
        });
    }

    private void syncServerUserID(DoorLockUserIDInfoBean doorLockUserIDInfoBean) {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().getDoorLockSyncUserID(this.mAccount, this.mWalletModel.typeId, randNumMaxString, this.mMachineId, doorLockUserIDInfoBean.lcsId, LocalBusinessStore.getDoorLockRoomid(this.mActivity), new client.android.yixiaotong.controller.core.Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (DoorLockSyncInfoControllerUtil.this.mIsEnable) {
                    if (successBean == null || !successBean.random.equals(randNumMaxString)) {
                        DoorLockSyncInfoControllerUtil.this.showDialog("同步数据出错，请稍后再试");
                        return;
                    }
                    if (DoorLockSyncInfoControllerUtil.this.mNeedSyncUser.size() > 0) {
                        DoorLockSyncInfoControllerUtil.this.mNeedSyncUser.remove(0);
                    } else if (DoorLockSyncInfoControllerUtil.this.mNeedDelectUser.size() > 0) {
                        DoorLockSyncInfoControllerUtil.this.mNeedDelectUser.remove(0);
                    }
                    DoorLockSyncInfoControllerUtil.this.syncUserID();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DoorLockSyncInfoControllerUtil.this.manageError(clientException);
            }
        });
    }

    private void getDoorLockNotSyncKeys() {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().getDoorLockNotSyncKeyInfo(this.mAccount, this.mWalletModel.typeId, randNumMaxString, this.mMachineId, LocalBusinessStore.getDoorLockRoomid(this.mActivity), new client.android.yixiaotong.controller.core.Listener<DoorLockNotSyncKeys>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DoorLockNotSyncKeys doorLockNotSyncKeys, Object... objArr) {
                if (DoorLockSyncInfoControllerUtil.this.mIsEnable) {
                    if (doorLockNotSyncKeys == null || !doorLockNotSyncKeys.random.equals(randNumMaxString)) {
                        DoorLockSyncInfoControllerUtil.this.showDialog("获取未同步钥匙信息失败，请稍后重试");
                        return;
                    }
                    if (doorLockNotSyncKeys.users == null) {
                        DoorLockSyncInfoControllerUtil.this.syncSuccess();
                    } else {
                        if (doorLockNotSyncKeys.users.size() == 0) {
                            DoorLockSyncInfoControllerUtil.this.syncSuccess();
                            return;
                        }
                        DoorLockSyncInfoControllerUtil.this.mNeedSyncKeyUser = doorLockNotSyncKeys.users;
                        DoorLockSyncInfoControllerUtil.this.getUserKeys();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DoorLockSyncInfoControllerUtil.this.mIsEnable) {
                    DoorLockSyncInfoControllerUtil.this.manageError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getUserKeys() {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().getDoorLockKeyInfo(this.mAccount, this.mNeedSyncKeyUser.get(0).userid, this.mWalletModel.typeId, randNumMaxString, new client.android.yixiaotong.controller.core.Listener<DoorLockKeyInfos>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DoorLockKeyInfos doorLockKeyInfos, Object... objArr) {
                if (DoorLockSyncInfoControllerUtil.this.mIsEnable) {
                    if (doorLockKeyInfos == null || !doorLockKeyInfos.random.equals(randNumMaxString)) {
                        DoorLockSyncInfoControllerUtil.this.showDialog("获取钥匙信息失败，请稍后重试");
                        return;
                    }
                    if (doorLockKeyInfos.keys == null || doorLockKeyInfos.keys.size() <= 0) {
                        DoorLockSyncInfoControllerUtil.this.mNeedSyncKeyUser.remove(0);
                        if (DoorLockSyncInfoControllerUtil.this.mNeedSyncKeyUser.size() > 0) {
                            DoorLockSyncInfoControllerUtil.this.getUserKeys();
                            return;
                        } else {
                            DoorLockSyncInfoControllerUtil.this.syncSuccess();
                            return;
                        }
                    }
                    DoorLockSyncInfoControllerUtil.this.mKeys = doorLockKeyInfos.keys;
                    for (DoorLockKeyInfo doorLockKeyInfo : doorLockKeyInfos.keys) {
                        if (doorLockKeyInfo.synchronization_flag == 0) {
                            DoorLockSyncInfoControllerUtil.this.mNeedSyncKeys.add(doorLockKeyInfo);
                        }
                    }
                    if (DoorLockSyncInfoControllerUtil.this.mNeedSyncKeys.size() > 0) {
                        DoorLockSyncInfoControllerUtil.this.needSyncKeys();
                        return;
                    }
                    DoorLockSyncInfoControllerUtil.this.mNeedSyncKeyUser.remove(0);
                    if (DoorLockSyncInfoControllerUtil.this.mNeedSyncKeyUser.size() > 0) {
                        DoorLockSyncInfoControllerUtil.this.getUserKeys();
                    } else {
                        DoorLockSyncInfoControllerUtil.this.syncSuccess();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DoorLockSyncInfoControllerUtil.this.manageError(clientException);
            }
        });
    }

    private void syncKeyToServer(String str, int i) {
        String str2;
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        if (this.mState == State.addpswkey || this.mState == State.addcard || this.mState == State.addpress || this.mState == State.changepsw || this.mState == State.delectpress || this.mState == State.delectcard || this.mState == State.delectpsw) {
            str2 = this.mDoorStudentMachineKeyId;
            this.mAccount.getUid();
        } else {
            str2 = this.mNeedSyncKeys.get(0).door_student_machine_key_id;
            long j = this.mNeedSyncKeyUser.get(0).userid;
        }
        BusinessControllers.getInstance().getDoorLockSyncKey(this.mAccount, this.mWalletModel.typeId, randNumMaxString, str2, str, i, new client.android.yixiaotong.controller.core.Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (DoorLockSyncInfoControllerUtil.this.mIsEnable) {
                    if (successBean == null || !successBean.random.equals(randNumMaxString)) {
                        DoorLockSyncInfoControllerUtil.this.showDialog("同步钥匙信息失败，请稍后重试");
                        return;
                    }
                    if (DoorLockSyncInfoControllerUtil.this.mState == State.addpswkey || DoorLockSyncInfoControllerUtil.this.mState == State.addcard || DoorLockSyncInfoControllerUtil.this.mState == State.addpress || DoorLockSyncInfoControllerUtil.this.mState == State.changepsw || DoorLockSyncInfoControllerUtil.this.mState == State.delectpress || DoorLockSyncInfoControllerUtil.this.mState == State.delectcard || DoorLockSyncInfoControllerUtil.this.mState == State.delectpsw) {
                        DoorLockSyncInfoControllerUtil.this.addKeySuccess();
                    } else {
                        DoorLockSyncInfoControllerUtil.this.mNeedSyncKeys.remove(0);
                        DoorLockSyncInfoControllerUtil.this.needSyncKeys();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DoorLockSyncInfoControllerUtil.this.manageError(clientException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIsNeedSync(List<DoorLockUserIDInfoBean> list) {
        this.mNeedSyncUser.clear();
        this.mNeedDelectUser.clear();
        this.mBlackListUser.clear();
        this.mUsers.clear();
        String str = "";
        if (list != null && list.size() > 0) {
            for (DoorLockUserIDInfoBean doorLockUserIDInfoBean : list) {
                str = str + doorLockUserIDInfoBean.hardwareUserid;
                if (doorLockUserIDInfoBean.sysflag == 3 && this.mDeviceAllUserID.contains(doorLockUserIDInfoBean.hardwareUserid)) {
                    this.mNeedDelectUser.add(doorLockUserIDInfoBean);
                } else if (doorLockUserIDInfoBean.sysflag == 3) {
                    this.mNeedSyncUser.add(doorLockUserIDInfoBean);
                } else if (doorLockUserIDInfoBean.sysflag == 2) {
                    this.mUsers.add(doorLockUserIDInfoBean);
                }
            }
        }
        if (StringUtils.isNotEmpty(this.mDeviceAllUserID) && this.mDeviceAllUserID.length() >= 2) {
            for (int i = 0; i < this.mDeviceAllUserID.length() / 2; i++) {
                int i2 = i * 2;
                int i3 = i2 + 2;
                if (!str.contains(this.mDeviceAllUserID.substring(i2, i3))) {
                    this.mBlackListUser.add(this.mDeviceAllUserID.substring(i2, i3));
                }
            }
        }
        Log.e("test", this.mNeedSyncUser.size() + "  " + this.mNeedDelectUser.size() + "  " + this.mBlackListUser.size());
        syncUserID();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncUserID() {
        if (this.mNeedSyncUser.size() > 0) {
            syncServerUserID(this.mNeedSyncUser.get(0));
            return;
        }
        if (this.mNeedDelectUser.size() > 0 || this.mBlackListUser.size() > 0) {
            if (this.mUserID.equalsIgnoreCase(this.mManagerUserID)) {
                sendB4();
                return;
            }
            this.mUserID = this.mManagerUserID;
            this.mState = State.delectuserid;
            sendB0();
            return;
        }
        getDoorLockNotSyncKeys();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needSyncKeys() {
        if (this.mNeedSyncKeys.size() > 0) {
            if (this.mNeedSyncKeys.get(0).sysflag == 1) {
                this.mState = State.syncaddkey;
                if (this.mUserID.equals(this.mNeedSyncKeyUser.get(0).userid_4byte)) {
                    sendBC(1);
                    return;
                } else {
                    this.mUserID = this.mNeedSyncKeyUser.get(0).userid_4byte;
                    sendB0();
                    return;
                }
            }
            if (this.mNeedSyncKeys.get(0).sysflag == 2) {
                this.mState = State.syncdelkey;
                if (this.mUserID.equals(this.mNeedSyncKeyUser.get(0).userid_4byte)) {
                    sendB8(0, this.mNeedSyncKeys.get(0).keyid, "");
                    return;
                } else {
                    this.mUserID = this.mNeedSyncKeyUser.get(0).userid_4byte;
                    sendB0();
                    return;
                }
            }
            if (this.mNeedSyncKeys.get(0).sysflag == 3) {
                this.mState = State.syncchangekey;
                if (this.mUserID.equals(this.mNeedSyncKeyUser.get(0).userid_4byte)) {
                    this.mChangeKeyCount = 0;
                    getEncryptData(2, this.mNeedSyncKeys.get(0).keyid, this.mNeedSyncKeys.get(0).key_passwrod);
                    return;
                } else {
                    this.mUserID = this.mNeedSyncKeyUser.get(0).userid_4byte;
                    sendB0();
                    return;
                }
            }
            if (this.mNeedSyncKeys.get(0).sysflag == 4) {
                this.mNeedSyncKeyUser.remove(0);
                if (this.mNeedSyncKeyUser.size() > 0) {
                    getUserKeys();
                    return;
                } else {
                    syncSuccess();
                    return;
                }
            }
            return;
        }
        this.mNeedSyncKeyUser.remove(0);
        if (this.mNeedSyncKeyUser.size() > 0) {
            getUserKeys();
        } else {
            syncSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.8
            @Override // java.lang.Runnable
            public void run() {
                BaseMaterialDialog.dissmisMaterialDialog();
                SystemErrorTip.getInstance().showTipDialog(DoorLockSyncInfoControllerUtil.this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.8.1
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        if (DoorLockSyncInfoControllerUtil.this.mActivity.getLocalClassName().contains("AddPressActivity")) {
                            DoorLockSyncInfoControllerUtil.this.mActivity.finish();
                        }
                    }
                }, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manageError(ClientException clientException) {
        if (this.mIsEnable) {
            BaseMaterialDialog.dissmisMaterialDialog();
            if (clientException.isNeedExitApp(clientException.getCode())) {
                ToastUtils.show(this.mActivity, "当前用户已下线，请重新登录");
                AccountManager.getInstance().clearLoginAccount();
                LoginActivity.launch(this.mActivity);
                ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                return;
            }
            if (clientException.isNeedTip(clientException.getCode())) {
                showDialog(clientException.getDetail());
            } else {
                ErrorTipActivity.launch(this.mActivity, this.mWalletModel.name, "", clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
                this.mActivity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncSuccess() {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onSyncEnd();
        }
        if (this.mFunctionState == FunctionState.syncdata) {
            return;
        }
        if (this.mFunctionState == FunctionState.addpswkey) {
            this.mState = State.addpswkey;
        } else if (this.mFunctionState == FunctionState.addcard) {
            this.mState = State.addcard;
        } else if (this.mFunctionState == FunctionState.addpress) {
            this.mState = State.addpress;
        } else if (this.mFunctionState == FunctionState.changepsw) {
            this.mState = State.changepsw;
        } else if (this.mFunctionState == FunctionState.delectpsw || this.mFunctionState == FunctionState.delectcard) {
            this.mState = State.delectpsw;
        } else if (this.mFunctionState == FunctionState.delectpress) {
            this.mState = State.delectpress;
        }
        Log.e("test", this.mUserID + "  " + this.mAccount.getAccountManagetStore().getUserInfo().stId);
        if (this.mUserID.equalsIgnoreCase(this.mAccount.getAccountManagetStore().getUserInfo().stId)) {
            isRegisterUserID();
        } else {
            this.mUserID = this.mAccount.getAccountManagetStore().getUserInfo().stId;
            sendB0();
        }
    }

    private void isRegisterUserID() {
        String str;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= this.mUsers.size()) {
                str = "";
                break;
            } else {
                if (this.mUsers.get(i).userid_4byte.equalsIgnoreCase(this.mUserID)) {
                    str = this.mUsers.get(i).hardwareUserid;
                    z = true;
                    break;
                }
                i++;
            }
        }
        if (z) {
            if (this.mState == State.changepsw) {
                updatePsw();
                return;
            } else if (this.mState == State.delectpsw || this.mState == State.delectcard || this.mState == State.delectpress) {
                delectKey();
                return;
            } else {
                addKey(str);
                return;
            }
        }
        if (this.mState == State.changepsw || this.mState == State.delectpsw || this.mState == State.delectcard || this.mState == State.delectpress) {
            showDialog("用户未注册");
        } else {
            sendB7(1);
        }
    }

    private void addUserID(final String str) {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().getDoorLockAddUserID(this.mAccount, this.mWalletModel.typeId, randNumMaxString, LocalBusinessStore.getDoorLockRoomid(this.mActivity), this.mMachineId, str, new client.android.yixiaotong.controller.core.Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (DoorLockSyncInfoControllerUtil.this.mIsEnable) {
                    if (successBean == null || !successBean.random.equals(randNumMaxString)) {
                        DoorLockSyncInfoControllerUtil.this.showDialog("添加用户失败，请稍后重试");
                    } else {
                        DoorLockSyncInfoControllerUtil.this.addKey(str);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DoorLockSyncInfoControllerUtil.this.manageError(clientException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKey(String str) {
        int i;
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        String doorLockRoomid = LocalBusinessStore.getDoorLockRoomid(this.mActivity);
        if (this.mState == State.addpswkey) {
            i = 2;
        } else if (this.mState == State.addcard) {
            i = 3;
        } else {
            i = this.mState == State.addpress ? 1 : 0;
        }
        BusinessControllers.getInstance().getDoorLockAddKey(this.mAccount, this.mWalletModel.typeId, randNumMaxString, doorLockRoomid, this.mMachineId, str, i, this.mKeyName, this.mPswKey, new client.android.yixiaotong.controller.core.Listener<DoorLockAddKeyBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DoorLockAddKeyBean doorLockAddKeyBean, Object... objArr) {
                if (DoorLockSyncInfoControllerUtil.this.mIsEnable) {
                    if (doorLockAddKeyBean == null || !doorLockAddKeyBean.random.equals(randNumMaxString)) {
                        DoorLockSyncInfoControllerUtil.this.showDialog("添加钥匙失败，请稍后重试");
                        return;
                    }
                    DoorLockSyncInfoControllerUtil.this.mDoorStudentMachineKeyId = doorLockAddKeyBean.doorStudentMachineKeyId;
                    if (DoorLockSyncInfoControllerUtil.this.mState == State.addpswkey) {
                        DoorLockSyncInfoControllerUtil doorLockSyncInfoControllerUtil = DoorLockSyncInfoControllerUtil.this;
                        doorLockSyncInfoControllerUtil.getEncryptData(1, "", doorLockSyncInfoControllerUtil.mPswKey);
                    } else if (DoorLockSyncInfoControllerUtil.this.mState == State.addcard) {
                        DoorLockSyncInfoControllerUtil.this.sendB9(3, "");
                        DoorLockSyncInfoControllerUtil.this.checkTimeOut(10000, "添加卡片失败！");
                    } else if (DoorLockSyncInfoControllerUtil.this.mState == State.addpress) {
                        DoorLockSyncInfoControllerUtil.this.sendB9(1, "");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DoorLockSyncInfoControllerUtil.this.manageError(clientException);
            }
        });
    }

    private void updatePsw() {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().getDoorLockUpdateKey(this.mAccount, this.mWalletModel.typeId, randNumMaxString, this.mDoorStudentMachineKeyId, this.mPswKey, new client.android.yixiaotong.controller.core.Listener<DoorLockAddKeyBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.11
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DoorLockAddKeyBean doorLockAddKeyBean, Object... objArr) {
                if (DoorLockSyncInfoControllerUtil.this.mIsEnable) {
                    if (doorLockAddKeyBean == null || !doorLockAddKeyBean.random.equals(randNumMaxString)) {
                        DoorLockSyncInfoControllerUtil.this.showDialog("修改钥匙失败，请稍后重试");
                    } else {
                        DoorLockSyncInfoControllerUtil doorLockSyncInfoControllerUtil = DoorLockSyncInfoControllerUtil.this;
                        doorLockSyncInfoControllerUtil.getEncryptData(2, doorLockSyncInfoControllerUtil.mUpdateKeyID, DoorLockSyncInfoControllerUtil.this.mPswKey);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DoorLockSyncInfoControllerUtil.this.manageError(clientException);
            }
        });
    }

    private void delectKey() {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().getDoorLockDeleteKey(this.mAccount, this.mWalletModel.typeId, randNumMaxString, this.mDoorStudentMachineKeyId, new client.android.yixiaotong.controller.core.Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (DoorLockSyncInfoControllerUtil.this.mIsEnable) {
                    if (successBean == null || !successBean.random.equals(randNumMaxString)) {
                        DoorLockSyncInfoControllerUtil.this.showDialog("修改钥匙失败，请稍后重试");
                    } else {
                        DoorLockSyncInfoControllerUtil doorLockSyncInfoControllerUtil = DoorLockSyncInfoControllerUtil.this;
                        doorLockSyncInfoControllerUtil.sendB8(0, doorLockSyncInfoControllerUtil.mDeleteKeyID, "");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DoorLockSyncInfoControllerUtil.this.manageError(clientException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEncryptData(final int i, final String str, String str2) {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        if (i == 2) {
            if (StringUtils.isNotEmpty(str2) && str2.length() != 8) {
                str2 = HttpBusinessStoreJava.decryptData(str2);
            }
            str2 = "02" + str + str2 + "8000";
        } else if (i == 1) {
            str2 = "01" + str2 + "800000";
        }
        BusinessControllers.getInstance().getDoorLockEntryptData(this.mAccount, this.mWalletModel.typeId, randNumMaxString, this.mMachineId, this.R1, this.R2, str2, new client.android.yixiaotong.controller.core.Listener<DLKeyBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.13
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DLKeyBean dLKeyBean, Object... objArr) {
                if (DoorLockSyncInfoControllerUtil.this.mIsEnable) {
                    if (dLKeyBean == null || !dLKeyBean.rand.equals(randNumMaxString) || !StringUtils.isNotEmpty(dLKeyBean.systemdata)) {
                        DoorLockSyncInfoControllerUtil.this.showDialog("修改钥匙失败，请稍后重试");
                    } else {
                        DoorLockSyncInfoControllerUtil.this.sendB8(i, str, dLKeyBean.systemdata);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DoorLockSyncInfoControllerUtil.this.manageError(clientException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKeySuccess() {
        BaseMaterialDialog.dissmisMaterialDialog();
        BluetoothSDK.getInstance().closeBLE();
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onEnd();
        }
    }

    private void uploadStatus(String str, int i) {
        BusinessControllers.getInstance().getDoorLockStatus(this.mAccount, this.mWalletModel.typeId, RandomUtil.getRandNumMaxString(6), this.mMachineId, LocalBusinessStore.getDoorLockRoomid(this.mActivity), this.mVersion, str, i, new client.android.yixiaotong.controller.core.Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.14
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                boolean unused = DoorLockSyncInfoControllerUtil.this.mIsEnable;
            }
        });
    }
}
