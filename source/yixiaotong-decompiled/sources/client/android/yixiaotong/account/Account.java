package client.android.yixiaotong.account;

import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.controller.store.HttpBusinessStore;
import client.android.yixiaotong.controller.store.HttpBusinessStoreJava;
import client.android.yixiaotong.controller.store.HttpBusinessStoreSmallApp;
import client.android.yixiaotong.controller.store.HttpBusinessStoreSystemError;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.http.V3HttpBusinessStore;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4HttpBusinessStore;
import com.google.gson.annotations.Expose;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class Account {
    private static final String TAG = "Account";
    public static final long VISTOR = 0;

    @Expose
    private String IdentityId;
    private AccountDataManager mAccountDataManager;

    @Expose
    private String mAuthorizedPassword;
    private HttpBusinessStore mHttpBusinessStore;
    private HttpBusinessStore mHttpBusinessStoreGongGao;
    private HttpBusinessStoreJava mHttpBusinessStoreJava;
    private HttpBusinessStoreSmallApp mHttpBusinessStoreSmallApp;
    private HttpBusinessStoreSystemError mHttpBusinessStoreSystemError;
    private LocalBusinessStore mLocalBusinessStore;

    @Expose
    private String mPassword;

    @Expose
    private long mUid;

    @Expose
    private String mUserName;

    @Expose
    private String mUuid;
    private V3HttpBusinessStore mV3HttpBusinessStore;
    private HttpBusinessStore mV3HttpBusinessStoreRepair;
    private V4HttpBusinessStore mV4HttpBusinessStore;

    public String getAuthorizedPassword() {
        return this.mAuthorizedPassword;
    }

    public String getIdentityId() {
        return this.IdentityId;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public long getUid() {
        return this.mUid;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public boolean isVistor() {
        return 0 == this.mUid;
    }

    public void setAuthorizedPassword(String str) {
        this.mAuthorizedPassword = str;
    }

    public void setIdentityId(String str) {
        this.IdentityId = str;
    }

    public void setPassword(String str) {
        this.mPassword = str;
    }

    public void setUid(long j) {
        this.mUid = j;
    }

    public void setUserName(String str) {
        this.mUserName = str;
    }

    private Account() {
    }

    public Account(long j) {
        this.mUuid = UUID.nameUUIDFromBytes(String.valueOf(j).getBytes()).toString();
    }

    public static Account newAccount(long j) {
        return new Account(j);
    }

    public LocalBusinessStore getLocalBusinessStore() {
        if (this.mLocalBusinessStore == null) {
            this.mLocalBusinessStore = new LocalBusinessStore(this);
        }
        return this.mLocalBusinessStore;
    }

    public HttpBusinessStore getHttpBusinessStore() {
        if (this.mHttpBusinessStore == null) {
            this.mHttpBusinessStore = new HttpBusinessStore(this);
        }
        this.mHttpBusinessStore.getServer();
        return this.mHttpBusinessStore;
    }

    public HttpBusinessStore getHttpBusinessStorePre() {
        if (this.mHttpBusinessStore == null) {
            this.mHttpBusinessStore = new HttpBusinessStore(this);
        }
        this.mHttpBusinessStore.getServerPre();
        return this.mHttpBusinessStore;
    }

    public HttpBusinessStore getHttpBusinessStoreTestGongGao() {
        if (this.mHttpBusinessStoreGongGao == null) {
            this.mHttpBusinessStoreGongGao = new HttpBusinessStore(this);
        }
        this.mHttpBusinessStoreGongGao.getServerGonggao();
        return this.mHttpBusinessStoreGongGao;
    }

    public HttpBusinessStoreJava getHttpBusinessStoreJava() {
        if (this.mHttpBusinessStoreJava == null) {
            this.mHttpBusinessStoreJava = new HttpBusinessStoreJava(this);
        }
        this.mHttpBusinessStoreJava.getServer();
        return this.mHttpBusinessStoreJava;
    }

    public HttpBusinessStoreSystemError getHttpBusinessStoreSystemError() {
        if (this.mHttpBusinessStoreSystemError == null) {
            this.mHttpBusinessStoreSystemError = new HttpBusinessStoreSystemError();
        }
        return this.mHttpBusinessStoreSystemError;
    }

    public AccountDataManager getAccountManagetStore() {
        if (this.mAccountDataManager == null) {
            this.mAccountDataManager = new AccountDataManager(BaseApplication.app, this.mUuid);
        }
        return this.mAccountDataManager;
    }

    public HttpBusinessStoreSmallApp getHttpBusinessStoreSmallApp() {
        if (this.mHttpBusinessStoreSmallApp == null) {
            this.mHttpBusinessStoreSmallApp = new HttpBusinessStoreSmallApp(this);
        }
        return this.mHttpBusinessStoreSmallApp;
    }

    public HttpBusinessStore getHttpBusinessStoreV3Repair() {
        if (this.mV3HttpBusinessStoreRepair == null) {
            this.mV3HttpBusinessStoreRepair = new HttpBusinessStore(this);
        }
        this.mV3HttpBusinessStoreRepair.getV3RepairAndAdv();
        return this.mV3HttpBusinessStoreRepair;
    }

    public V3HttpBusinessStore getV3HttpBusinessStore(String str) {
        LocalDataUtil.saveClientTypeInfo(BaseApplication.app, "1");
        if (this.mV3HttpBusinessStore == null) {
            this.mV3HttpBusinessStore = new V3HttpBusinessStore(this);
        }
        if (StringUtils.isNotEmpty(str)) {
            this.mV3HttpBusinessStore.setUrl(str);
        } else {
            String url = LocalDataUtil.getUrl(BaseApplication.app);
            LogUtil.e(TAG, "getV3HttpBusinessStore:" + url);
            if (StringUtils.isNotEmpty(url)) {
                this.mV3HttpBusinessStore.setUrl(url);
            } else {
                this.mV3HttpBusinessStore.setUrl("https://v3-app.lxt6.cn");
            }
        }
        return this.mV3HttpBusinessStore;
    }

    public V3HttpBusinessStore getV3PicHttpBusinessStore() {
        LocalDataUtil.saveClientTypeInfo(BaseApplication.app, "1");
        if (this.mV3HttpBusinessStore == null) {
            this.mV3HttpBusinessStore = new V3HttpBusinessStore(this);
        }
        this.mV3HttpBusinessStore.setUrl("https://web-xhf.lxt6.cn:8089");
        return this.mV3HttpBusinessStore;
    }

    public V4HttpBusinessStore getV4HttpBusinessStore(String str) {
        if (this.mV4HttpBusinessStore == null) {
            this.mV4HttpBusinessStore = new V4HttpBusinessStore(this);
        }
        if (StringUtils.isNotEmpty(str)) {
            this.mV4HttpBusinessStore.setUrl(str);
        } else {
            this.mV4HttpBusinessStore.setUrl("https://ai.lxt6.cn/api");
        }
        return this.mV4HttpBusinessStore;
    }
}
