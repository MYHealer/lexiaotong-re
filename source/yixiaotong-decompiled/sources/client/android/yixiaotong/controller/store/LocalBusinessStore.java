package client.android.yixiaotong.controller.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.controller.db.LocalSqliteHelper;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.DBException;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.opos.acs.st.STManager;
import com.unionpay.tsmservice.mi.data.Constant;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class LocalBusinessStore {
    private Account mAccount;

    public LocalBusinessStore(Account account) {
        this.mAccount = account;
    }

    public static void saveLastConnectIsBLE(Context context, boolean z) {
        new LocalPreferencesHelper(context, "LastConnectBluetoothDevice" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("LastConnectBluetoothDeviceisble", z);
    }

    public static boolean getLastConnectIsBLE(Context context) {
        return new LocalPreferencesHelper(context, "LastConnectBluetoothDevice" + AccountManager.getInstance().getLoginAccount().getUid()).getBooleanDefaultTrue("LastConnectBluetoothDeviceisble");
    }

    public static void saveLastConnectBluetoothDeviceMac(Context context, int i, String str) {
        new LocalPreferencesHelper(context, "LastConnectBluetoothDevice" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("LastConnectBluetoothDeviceMac_" + i, str);
    }

    public static String getLastConnectBluetoothDeviceMac(Context context, int i) {
        return new LocalPreferencesHelper(context, "LastConnectBluetoothDevice" + AccountManager.getInstance().getLoginAccount().getUid()).getString("LastConnectBluetoothDeviceMac_" + i);
    }

    public static void saveLastConnectBluetoothDeviceHexId(Context context, int i, String str) {
        new LocalPreferencesHelper(context, "LastConnectBluetoothDevice" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("LastConnectBluetoothDeviceHexId_" + i, str);
    }

    public static String getLastConnectBluetoothDeviceHexId(Context context, int i) {
        return new LocalPreferencesHelper(context, "LastConnectBluetoothDevice" + AccountManager.getInstance().getLoginAccount().getUid()).getString("LastConnectBluetoothDeviceHexId_" + i);
    }

    public static void saveLastConnectBluetoothDeviceName(Context context, int i, String str) {
        new LocalPreferencesHelper(context, "LastConnectBluetoothDevice" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("LastConnectBluetoothDeviceName_" + i, str);
    }

    public static String getLastConnectBluetoothDeviceName(Context context, int i) {
        return new LocalPreferencesHelper(context, "LastConnectBluetoothDevice" + AccountManager.getInstance().getLoginAccount().getUid()).getString("LastConnectBluetoothDeviceName_" + i);
    }

    public static void saveOfflineCount(Context context, int i) {
        new LocalPreferencesHelper(context, "OfflineCount_" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("OfflineCount", i);
    }

    public static int getOfflineCount(Context context) {
        return new LocalPreferencesHelper(context, "OfflineCount_" + AccountManager.getInstance().getLoginAccount().getUid()).getInt("OfflineCount");
    }

    public static void setQrcodeCountToday(Context context, short s) {
        new LocalPreferencesHelper(context, "app" + AccountManager.getInstance().getLoginAccount().getUuid()).saveOrUpdate("qrcode_today_" + Calendar.getInstance().get(1) + "_" + Calendar.getInstance().get(6), (int) s);
    }

    public static short getQrcodeCountToday(Context context) {
        return (short) new LocalPreferencesHelper(context, "app" + AccountManager.getInstance().getLoginAccount().getUuid()).getInt("qrcode_today_" + Calendar.getInstance().get(1) + "_" + Calendar.getInstance().get(6), 0);
    }

    public static void saveTodayDate(Context context, String str) {
        new LocalPreferencesHelper(context, "TodayDate").saveOrUpdate("todaydate", TimeUtils.formatTime(Long.parseLong(str) * 1000).replace(".", ""));
    }

    public static String getTodayDate(Context context) {
        return new LocalPreferencesHelper(context, "TodayDate").getString("todaydate");
    }

    public static void saveConnectCountToday(Context context, String str, long j) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "connectCount_");
        String todayDate = getTodayDate(context);
        int connectCountToday = getConnectCountToday(context, j);
        if (connectCountToday >= 6 || localPreferencesHelper.getString("connectCount" + j + todayDate + str).equals(str)) {
            return;
        }
        localPreferencesHelper.saveOrUpdate("connectCount" + j + todayDate, connectCountToday + 1);
        localPreferencesHelper.saveOrUpdate("connectCount" + j + todayDate + str, str);
    }

    public static int getConnectCountToday(Context context, long j) {
        return new LocalPreferencesHelper(context, "connectCount_").getInt("connectCount" + j + getTodayDate(context));
    }

    public static String getConnectDeviceToday(Context context, String str, long j) {
        return new LocalPreferencesHelper(context, "connectCount_").getString("connectCount" + j + getTodayDate(context) + str);
    }

    public static void saveEntranceguardRoomId(Context context, long j, String str) {
        new LocalPreferencesHelper(context, "EntranceguardRoomId").saveOrUpdate("roomid" + j, str);
    }

    public static String getEntranceguardRoomId(Context context, long j) {
        return new LocalPreferencesHelper(context, "EntranceguardRoomId").getString("roomid" + j);
    }

    public static void saveHamamRoomId(Context context, long j, String str) {
        new LocalPreferencesHelper(context, "hamamRoomId").saveOrUpdate("roomid" + j, str);
    }

    public static String getHamamRoomId(Context context, long j) {
        return new LocalPreferencesHelper(context, "hamamRoomId").getString("roomid" + j);
    }

    public static void saveHamamIsFirstUse(Context context, long j) {
        new LocalPreferencesHelper(context, "hamamIsFirstUse").saveOrUpdate("firstuse" + j, false);
    }

    public static boolean getHamamIsFirstUse(Context context, long j) {
        return new LocalPreferencesHelper(context, "hamamIsFirstUse").getBooleanDefaultTrue("firstuse" + j);
    }

    public static void saveEntranceguardMac(Context context, long j, String str) {
        new LocalPreferencesHelper(context, "EntranceguardMac").saveOrUpdate(Constant.KEY_MAC + j, str);
    }

    public static String getEntranceguardMac(Context context, long j) {
        return new LocalPreferencesHelper(context, "EntranceguardMac").getString(Constant.KEY_MAC + j);
    }

    public static void saveEntranceguardAuthorizedPassword(Context context, long j, String str) {
        new LocalPreferencesHelper(context, "EntranceguardAuthorizedPassword").saveOrUpdate("AuthorizedPassword" + j, str);
    }

    public static String getEntranceguardAuthorizedPassword(Context context, long j) {
        return new LocalPreferencesHelper(context, "EntranceguardAuthorizedPassword").getString("AuthorizedPassword" + j);
    }

    public static void saveAuthorizedPassword(Context context, long j, String str) {
        new LocalPreferencesHelper(context, "AuthorizedPassword").saveOrUpdate("AuthorizedPassword" + j, str);
    }

    public static String getAuthorizedPassword(Context context, long j) {
        return new LocalPreferencesHelper(context, "AuthorizedPassword").getString("AuthorizedPassword" + j);
    }

    public static void saveLastBathVersion(Context context, int i, String str, int i2) {
        new LocalPreferencesHelper(context, "LastBathVersion" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("LastBathVersion_" + i + str, i2);
    }

    public static int getLastBathVersion(Context context, int i, String str) {
        return new LocalPreferencesHelper(context, "LastBathVersion" + AccountManager.getInstance().getLoginAccount().getUid()).getInt("LastBathVersion_" + i + str, -1);
    }

    public static void saveLastBathStudentId(Context context, int i, String str) {
        new LocalPreferencesHelper(context, "LastBathStudentid" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("LastBathStudentid_" + i, str);
    }

    public static String getLastBathStudentId(Context context, int i) {
        return new LocalPreferencesHelper(context, "LastBathStudentid" + AccountManager.getInstance().getLoginAccount().getUid()).getString("LastBathStudentid_" + i);
    }

    public static void saveLastXiZaoQuYu(Context context, int i, String str) {
        new LocalPreferencesHelper(context, "LastXiZao" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("LastXiZao_" + i, str);
    }

    public static String getLastXiZaoQuYu(Context context, int i) {
        return new LocalPreferencesHelper(context, "LastXiZao" + AccountManager.getInstance().getLoginAccount().getUid()).getString("LastXiZao_" + i);
    }

    public static void saveLastXiZaoId(Context context, int i, String str) {
        new LocalPreferencesHelper(context, "LastXiZao" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("LastXiZaoId_" + i, str);
    }

    public static String getLastXiZaoId(Context context, int i) {
        return new LocalPreferencesHelper(context, "LastXiZao" + AccountManager.getInstance().getLoginAccount().getUid()).getString("LastXiZaoId_" + i);
    }

    public static void saveLastDrinkWaterMoney(Context context, int i, String str) {
        new LocalPreferencesHelper(context, "drinkwater" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("drinkwatermoney_" + i, str);
    }

    public static String getLastDrinkWaterMoney(Context context, int i) {
        return new LocalPreferencesHelper(context, "drinkwater" + AccountManager.getInstance().getLoginAccount().getUid()).getString("drinkwatermoney_" + i);
    }

    public static void saveOrderMoney(Context context, int i, String str) {
        new LocalPreferencesHelper(context, "ordermoney" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("ordermoney_" + i, str);
    }

    public static String getOrderMoney(Context context, int i) {
        return new LocalPreferencesHelper(context, "ordermoney" + AccountManager.getInstance().getLoginAccount().getUid()).getString("ordermoney_" + i);
    }

    public static void saveGetWalletTime(Context context, long j) {
        new LocalPreferencesHelper(context, CrashHianalyticsData.TIME + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate(CrashHianalyticsData.TIME, j);
    }

    public static long getWalletTime(Context context) {
        return new LocalPreferencesHelper(context, CrashHianalyticsData.TIME + AccountManager.getInstance().getLoginAccount().getUid()).getLong(CrashHianalyticsData.TIME);
    }

    public static void saveDeviceFragmentVisable(Context context, boolean z) {
        new LocalPreferencesHelper(context, "devicefragment").saveOrUpdate("visable", z);
    }

    public static boolean getDeviceFragmentVisable(Context context) {
        return new LocalPreferencesHelper(context, "devicefragment").getBooleanDefaultFalse("visable");
    }

    public List<WalletModel> getWallets(LocalSqliteHelper localSqliteHelper) throws DBException {
        try {
            try {
                List<WalletModel> listQueryForAll = getWalletDao(localSqliteHelper.getReadableDatabase()).queryForAll();
                if (localSqliteHelper != null) {
                    localSqliteHelper.close();
                }
                return listQueryForAll;
            } catch (SQLException e) {
                throw new DBException(e);
            }
        } catch (Throwable th) {
            if (localSqliteHelper != null) {
                localSqliteHelper.close();
            }
            throw th;
        }
    }

    public WalletModel getWalletByID(long j) throws Throwable {
        LocalSqliteHelper localSqliteHelper = null;
        try {
            try {
                LocalSqliteHelper localSqliteHelper2 = new LocalSqliteHelper(this.mAccount.getUuid());
                try {
                    WalletModel walletModelQueryForFirst = getWalletDao(localSqliteHelper2.getReadableDatabase()).queryBuilder().where().eq(STManager.REGION_OF_ID, Long.valueOf(j)).queryForFirst();
                    localSqliteHelper2.close();
                    return walletModelQueryForFirst;
                } catch (SQLException e) {
                    e = e;
                    throw new DBException(e);
                } catch (Throwable th) {
                    th = th;
                    localSqliteHelper = localSqliteHelper2;
                    if (localSqliteHelper != null) {
                        localSqliteHelper.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLException e2) {
            e = e2;
        }
    }

    public List<WalletModel> clearAndSaveWallet(LocalSqliteHelper localSqliteHelper, List<WalletModel> list) throws DBException {
        if (list == null) {
            throw new DBException("walletModel is null");
        }
        try {
            try {
                Dao<WalletModel, Integer> walletDao = getWalletDao(localSqliteHelper.getWritableDatabase());
                walletDao.deleteBuilder().delete();
                Iterator<WalletModel> it = list.iterator();
                while (it.hasNext()) {
                    walletDao.create(it.next());
                }
                List<WalletModel> listQueryForAll = walletDao.queryForAll();
                if (localSqliteHelper != null) {
                    localSqliteHelper.close();
                }
                return listQueryForAll;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DBException(e);
            }
        } catch (Throwable th) {
            if (localSqliteHelper != null) {
                localSqliteHelper.close();
            }
            throw th;
        }
    }

    public int saveWallet(LocalSqliteHelper localSqliteHelper, WalletModel walletModel) throws DBException {
        try {
            if (walletModel == null) {
                throw new DBException("walletModel is null");
            }
            try {
                int iCreate = getWalletDao(localSqliteHelper.getWritableDatabase()).create(walletModel);
                if (localSqliteHelper != null) {
                    localSqliteHelper.close();
                }
                return iCreate;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DBException(e);
            }
        } catch (Throwable th) {
            if (localSqliteHelper != null) {
                localSqliteHelper.close();
            }
            throw th;
        }
    }

    public int updateWallet(WalletModel walletModel) throws Throwable {
        if (walletModel == null) {
            throw new DBException("walletModel is null");
        }
        LocalSqliteHelper localSqliteHelper = null;
        try {
            try {
                LocalSqliteHelper localSqliteHelper2 = new LocalSqliteHelper(this.mAccount.getUuid());
                try {
                    int iUpdate = getWalletDao(localSqliteHelper2.getWritableDatabase()).update(walletModel);
                    localSqliteHelper2.close();
                    return iUpdate;
                } catch (SQLException e) {
                    e = e;
                    throw new DBException(e);
                } catch (Throwable th) {
                    th = th;
                    localSqliteHelper = localSqliteHelper2;
                    if (localSqliteHelper != null) {
                        localSqliteHelper.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLException e2) {
            e = e2;
        }
    }

    public Dao.CreateOrUpdateStatus createOrUpdateWallet(WalletModel walletModel) throws Throwable {
        if (walletModel == null) {
            throw new DBException("walletModel is null");
        }
        LocalSqliteHelper localSqliteHelper = null;
        try {
            try {
                LocalSqliteHelper localSqliteHelper2 = new LocalSqliteHelper(this.mAccount.getUuid());
                try {
                    Dao.CreateOrUpdateStatus createOrUpdateStatusCreateOrUpdate = getWalletDao(localSqliteHelper2.getWritableDatabase()).createOrUpdate(walletModel);
                    localSqliteHelper2.close();
                    return createOrUpdateStatusCreateOrUpdate;
                } catch (SQLException e) {
                    e = e;
                    e.printStackTrace();
                    throw new DBException(e);
                } catch (Throwable th) {
                    th = th;
                    localSqliteHelper = localSqliteHelper2;
                    if (localSqliteHelper != null) {
                        localSqliteHelper.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLException e2) {
            e = e2;
        }
    }

    public int deleteWallet(WalletModel walletModel) throws Throwable {
        LocalSqliteHelper localSqliteHelper = null;
        try {
            try {
                LocalSqliteHelper localSqliteHelper2 = new LocalSqliteHelper(this.mAccount.getUuid());
                try {
                    int iDelete = getWalletDao(localSqliteHelper2.getWritableDatabase()).delete(walletModel);
                    localSqliteHelper2.close();
                    return iDelete;
                } catch (SQLException e) {
                    e = e;
                    throw new DBException(e);
                } catch (Throwable th) {
                    th = th;
                    localSqliteHelper = localSqliteHelper2;
                    if (localSqliteHelper != null) {
                        localSqliteHelper.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLException e2) {
            e = e2;
        }
    }

    public int deleteAllWallets(LocalSqliteHelper localSqliteHelper) throws DBException {
        try {
            try {
                int iDelete = getWalletDao(localSqliteHelper.getWritableDatabase()).deleteBuilder().delete();
                if (localSqliteHelper != null) {
                    localSqliteHelper.close();
                }
                return iDelete;
            } catch (SQLException e) {
                throw new DBException(e);
            }
        } catch (Throwable th) {
            if (localSqliteHelper != null) {
                localSqliteHelper.close();
            }
            throw th;
        }
    }

    private synchronized Dao<WalletModel, Integer> getWalletDao(SQLiteDatabase sQLiteDatabase) throws DBException {
        Dao<WalletModel, Integer> daoCreateDao;
        AndroidConnectionSource androidConnectionSource = null;
        try {
            AndroidConnectionSource androidConnectionSource2 = new AndroidConnectionSource(sQLiteDatabase);
            try {
                daoCreateDao = DaoManager.createDao(androidConnectionSource2, WalletModel.class);
                try {
                    DaoManager.clearCache();
                    androidConnectionSource2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e2) {
                e = e2;
                throw new DBException(e);
            } catch (Throwable th) {
                th = th;
                androidConnectionSource = androidConnectionSource2;
                try {
                    DaoManager.clearCache();
                    androidConnectionSource.close();
                } catch (SQLException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        } catch (SQLException e4) {
            e = e4;
        }
        return daoCreateDao;
    }

    public static void saveBingdRoomStatus1(Context context, int i) {
        new LocalPreferencesHelper(context, "BingdRoomStatus1_" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("BingdRoomStatus1", i);
    }

    public static void putBingdRoomStatus1(Context context, String str, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("BingdRoomStatus1", 0).edit();
        editorEdit.putInt(str, i);
        editorEdit.commit();
    }

    public static int getBingdRoomStatus1(Context context, String str, int i) {
        return context.getSharedPreferences("BingdRoomStatus1", 0).getInt(str, i);
    }

    public static void saveBathKey(Context context, String str) {
        new LocalPreferencesHelper(context, "bathkey" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("key_", str);
    }

    public static String getBathKey(Context context) {
        return new LocalPreferencesHelper(context, "bathkey" + AccountManager.getInstance().getLoginAccount().getUid()).getString("key_");
    }

    public static void saveIsUploadRepair(Context context, boolean z) {
        new LocalPreferencesHelper(context, "repair").saveOrUpdate("repair_", z);
    }

    public static boolean getIsUploadRepair(Context context) {
        return new LocalPreferencesHelper(context, "repair").getBooleanDefaultFalse("repair_");
    }

    public static void saveOpenId(Context context, String str) {
        new LocalPreferencesHelper(context, "openid" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("openid_", str);
    }

    public static String getOpenId(Context context) {
        return new LocalPreferencesHelper(context, "openid" + AccountManager.getInstance().getLoginAccount().getUid()).getString("openid_");
    }

    public static void saveName(Context context, String str) {
        new LocalPreferencesHelper(context, "name" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("name_", str);
    }

    public static String getName(Context context) {
        return new LocalPreferencesHelper(context, "name" + AccountManager.getInstance().getLoginAccount().getUid()).getString("name_");
    }

    public static void saveURL(Context context, String str) {
        new LocalPreferencesHelper(context, "url" + AccountManager.getInstance().getLoginAccount().getUid()).saveOrUpdate("url_", str);
    }

    public static String getURL(Context context) {
        return new LocalPreferencesHelper(context, "url" + AccountManager.getInstance().getLoginAccount().getUid()).getString("url_");
    }

    public static void saveDoorLockTip(Context context, boolean z) {
        new LocalPreferencesHelper(context, "doorlocktip").saveOrUpdate("tip_", z);
    }

    public static boolean getDoorLockTip(Context context) {
        return new LocalPreferencesHelper(context, "doorlocktip").getBooleanDefaultFalse("tip_");
    }

    public static void saveDoorLockFirst(Context context, boolean z) {
        new LocalPreferencesHelper(context, "doorlockfirst").saveOrUpdate("first_", z);
    }

    public static boolean getDoorLockFirst(Context context) {
        return new LocalPreferencesHelper(context, "doorlockfirst").getBooleanDefaultTrue("first_");
    }

    public static void saveDoorLockAuthCount(Context context, int i) {
        new LocalPreferencesHelper(context, "doorlockauthcount").saveOrUpdate("count_" + AccountManager.getInstance().getLoginAccount().getUid(), i);
    }

    public static int getDoorLockAuthCount(Context context) {
        return new LocalPreferencesHelper(context, "doorlockauthcount").getInt("count_" + AccountManager.getInstance().getLoginAccount().getUid(), 0);
    }

    public static void saveDoorLockMaxAuthCount(Context context, int i) {
        new LocalPreferencesHelper(context, "doorlockmaxauthcount").saveOrUpdate("count_" + AccountManager.getInstance().getLoginAccount().getUid(), i);
    }

    public static int getDoorLockMaxAuthCount(Context context) {
        return new LocalPreferencesHelper(context, "doorlockmaxauthcount").getInt("count_" + AccountManager.getInstance().getLoginAccount().getUid(), 0);
    }

    public static void saveSystemTime(Context context, long j) {
        new LocalPreferencesHelper(context, CrashHianalyticsData.TIME).saveOrUpdate("time_", j);
    }

    public static long getSystemTime(Context context) {
        return new LocalPreferencesHelper(context, CrashHianalyticsData.TIME).getLong("time_", 0L);
    }

    public static void saveDoorLockMachineid(Context context, String str) {
        new LocalPreferencesHelper(context, "doorlock").saveOrUpdate("machineid_", str);
    }

    public static String getDoorLockMachineid(Context context) {
        return new LocalPreferencesHelper(context, "doorlock").getString("machineid_");
    }

    public static void saveDoorLockRoomid(Context context, String str) {
        new LocalPreferencesHelper(context, "doorlock").saveOrUpdate("roomid_", str);
    }

    public static String getDoorLockRoomid(Context context) {
        return new LocalPreferencesHelper(context, "doorlock").getString("roomid_");
    }

    public static void saveDoorLockRoomAddress(Context context, String str) {
        new LocalPreferencesHelper(context, "doorlock").saveOrUpdate("roomaddress_", str);
    }

    public static String getDoorLockRoomAddress(Context context) {
        return new LocalPreferencesHelper(context, "doorlock").getString("roomaddress_");
    }

    public static void saveDoorLockServerKeyID(Context context, String str) {
        new LocalPreferencesHelper(context, "doorlock").saveOrUpdate("serverkeyid_", str);
    }

    public static String getDoorLockServerKeyID(Context context) {
        return new LocalPreferencesHelper(context, "doorlock").getString("serverkeyid_");
    }

    public static void saveDoorLockDeviceKeyID(Context context, String str) {
        new LocalPreferencesHelper(context, "doorlock").saveOrUpdate("devicekeyid_", str);
    }

    public static String getDoorLockDeviceKeyID(Context context) {
        return new LocalPreferencesHelper(context, "doorlock").getString("devicekeyid_");
    }

    public static void saveDoorLockDangerTime(Context context, long j) {
        new LocalPreferencesHelper(context, "doorlock").saveOrUpdate("dangertime_", j);
    }

    public static long getDoorLockDangerTime(Context context) {
        return new LocalPreferencesHelper(context, "doorlock").getLong("dangertime_");
    }

    public static void saveRefundTypeid(Context context, int i) {
        new LocalPreferencesHelper(context, "refund").saveOrUpdate("tyepid_", i);
    }

    public static int getRefundTypeid(Context context) {
        return new LocalPreferencesHelper(context, "refund").getInt("tyepid_", 0);
    }

    public static void saveRefundAppidSecret(Context context, String str) {
        new LocalPreferencesHelper(context, "refund").saveOrUpdate("appidsecret_", str);
    }

    public static String getRefundAppidSecret(Context context) {
        return new LocalPreferencesHelper(context, "refund").getString("appidsecret_");
    }

    public static void saveDoorLockRrcord(Context context, String str) {
        new LocalPreferencesHelper(context, "doorlock").saveOrUpdate("record_", str);
    }

    public static String getDoorLockRecord(Context context) {
        return new LocalPreferencesHelper(context, "doorlock").getString("record_");
    }

    public static void saveDoorLockPressCount(Context context, int i) {
        new LocalPreferencesHelper(context, "doorlock").saveOrUpdate("presscount_", i);
    }

    public static int getDoorLockPressCount(Context context) {
        return new LocalPreferencesHelper(context, "doorlock").getInt("presscount_", 0);
    }

    public static void saveLicenseTip(Context context, boolean z) {
        new LocalPreferencesHelper(context, "license_").saveOrUpdate("license", z);
    }

    public static boolean getLicenseTip(Context context) {
        return new LocalPreferencesHelper(context, "license_").getBooleanDefaultFalse("license");
    }

    public static void saveLoginLicenseTip(Context context, boolean z) {
        new LocalPreferencesHelper(context, "license_").saveOrUpdate("license_login", z);
    }

    public static boolean getLoginLicenseTip(Context context) {
        return new LocalPreferencesHelper(context, "license_").getBooleanDefaultFalse("license_login");
    }

    public static void savePerssionTip(Context context, int i) {
        new LocalPreferencesHelper(context, "license_").saveOrUpdate("perssion" + i, true);
    }

    public static boolean getPerssionTip(Context context, int i) {
        return new LocalPreferencesHelper(context, "license_").getBooleanDefaultFalse("perssion" + i);
    }

    public static void saveAdvlaunchCount(Context context, String str, int i) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "adv_");
        String time = TimeUtils.formatTime(System.currentTimeMillis());
        String string = localPreferencesHelper.getString("launchtime" + i);
        int advlaunchCount = 1;
        if (StringUtils.isNotEmpty(string) && string.equals(time)) {
            advlaunchCount = 1 + getAdvlaunchCount(context, str, i);
        }
        localPreferencesHelper.saveOrUpdate("launchtime" + i, time);
        localPreferencesHelper.saveOrUpdate("launch" + str + i, advlaunchCount);
    }

    public static int getAdvlaunchCount(Context context, String str, int i) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "adv_");
        String string = localPreferencesHelper.getString("launchtime" + i);
        String time = TimeUtils.formatTime(System.currentTimeMillis());
        Log.e("getAdvlaunchCount", string + "  " + time);
        if (StringUtils.isNotEmpty(string) && string.equals(time)) {
            return localPreferencesHelper.getInt("launch" + str + i, 0);
        }
        return 0;
    }

    public static void saveAdvlaunch(Context context, String str, String str2) {
        new LocalPreferencesHelper(context, "adv_").saveOrUpdate("launch" + str, str2);
    }

    public static String getAdvlaunch(Context context, String str) {
        return new LocalPreferencesHelper(context, "adv_").getString("launch" + str);
    }

    public static void saveAdvBanner(Context context, String str, String str2) {
        new LocalPreferencesHelper(context, "adv_").saveOrUpdate("banner" + str, str2);
    }

    public static String getAdvBanner(Context context, String str) {
        return new LocalPreferencesHelper(context, "adv_").getString("banner" + str);
    }

    public static void saveAdvInsert(Context context, String str, String str2) {
        new LocalPreferencesHelper(context, "adv_").saveOrUpdate("insert_" + str, str2);
    }

    public static String getAdvInsert(Context context, String str) {
        return new LocalPreferencesHelper(context, "adv_").getString("insert_" + str);
    }

    public static void saveIsOpenAdv(Context context, boolean z) {
        new LocalPreferencesHelper(context, "adv_").saveOrUpdate("isopen", z);
    }

    public static boolean getIsOpenAdv(Context context) {
        return new LocalPreferencesHelper(context, "adv_").getBooleanDefaultFalse("isopen");
    }

    public static void saveSchoolId(Context context, String str) {
        new LocalPreferencesHelper(context, "oldschoolid").saveOrUpdate("oldschoolid_", str);
    }

    public static String getSchoolId(Context context) {
        return new LocalPreferencesHelper(context, "oldschoolid").getString("oldschoolid_");
    }
}
