package client.android.yixiaotong.controller.model;

import client.android.yixiaotong.controller.bean.SubAppBean;
import client.android.yixiaotong.controller.db.LocalSqliteHelper;
import client.android.yixiaotong.util.GsonUtils;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
@DatabaseTable(tableName = LocalSqliteHelper.TABLE_NAME_WALLET)
public class WalletModel implements Serializable {
    private static final long serialVersionUID = 365599922392870978L;

    @DatabaseField
    public int ABCCharge;

    @DatabaseField
    public int AliRefund;

    @DatabaseField
    public long ID;

    @DatabaseField
    public int IsRefund;

    @DatabaseField
    public int IsUseCard;

    @DatabaseField
    public int WeiXinRefund;

    @DatabaseField
    public String WeiXinRefundAppId;

    @DatabaseField
    public String WeiXinRefundSecret;

    @DatabaseField(generatedId = true)
    public long _id;

    @DatabaseField
    public int aliCharge;

    @DatabaseField
    public String icon;

    @DatabaseField
    public int max = 1000;

    @DatabaseField
    public String name;

    @DatabaseField
    public int payType;

    @DatabaseField
    public int refund;

    @DatabaseField
    public String serviceMobile;

    @DatabaseField
    public String subApp;

    @DatabaseField
    public int typeId;

    @DatabaseField
    public int unionCharge;

    @DatabaseField
    public int weiXinCharge;

    @DatabaseField
    public String wxAppid;

    @DatabaseField
    public String wxGhId;

    public long getBalance() {
        List list = (List) GsonUtils.getInstance().parseIfNull(new TypeToken<List<SubAppBean>>() { // from class: client.android.yixiaotong.controller.model.WalletModel.1
        }.getType(), this.subApp);
        long jLongValue = 0;
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jLongValue += new BigDecimal(((SubAppBean) it.next()).Balance).multiply(new BigDecimal(100.0d)).longValue();
            }
        }
        return jLongValue;
    }

    public List<SubAppBean> getSubAccounts() {
        return (List) GsonUtils.getInstance().parseIfNull(new TypeToken<List<SubAppBean>>() { // from class: client.android.yixiaotong.controller.model.WalletModel.2
        }.getType(), this.subApp);
    }

    public String getBaseWallet() {
        List<SubAppBean> subAccounts = getSubAccounts();
        if (subAccounts == null) {
            return "";
        }
        for (SubAppBean subAppBean : subAccounts) {
            if (subAppBean.WalletType == 1) {
                return subAppBean.Balance;
            }
        }
        return "";
    }

    public String getGiveWallet() {
        List<SubAppBean> subAccounts = getSubAccounts();
        if (subAccounts == null) {
            return "";
        }
        for (SubAppBean subAppBean : subAccounts) {
            if (subAppBean.WalletType == 2) {
                return subAppBean.Balance;
            }
        }
        return "";
    }

    public String getPeriodWallet() {
        List<SubAppBean> subAccounts = getSubAccounts();
        if (subAccounts == null) {
            return "";
        }
        for (SubAppBean subAppBean : subAccounts) {
            if (subAppBean.WalletType == 3) {
                return subAppBean.Balance;
            }
        }
        return "";
    }
}
