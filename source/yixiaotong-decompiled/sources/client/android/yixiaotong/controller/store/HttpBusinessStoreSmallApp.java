package client.android.yixiaotong.controller.store;

import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.bindcard.BindCardBean;
import client.android.yixiaotong.controller.bean.bindcard.IsBindCardBean;
import client.android.yixiaotong.controller.bean.bindcard.IsHasBindCardFunctionBean;
import client.android.yixiaotong.controller.bean.bindcard.PasswordStateBean;
import client.android.yixiaotong.exception.HttpException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.util.MD5;
import client.android.yixiaotong.util.http.HttpProtocolFactorySmallApp;
import client.android.yixiaotong.util.http.bean.BaseBean;
import client.android.yixiaotong.util.http.protocol.BusinessHttpProtocolSmallApp;
import client.android.yixiaotong.v3.util.LogUtil;
import java.net.URLEncoder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class HttpBusinessStoreSmallApp {
    private static final String TAG = "HttpBusinessStoreSmallApp";
    private BusinessHttpProtocolSmallApp mProtocol = (BusinessHttpProtocolSmallApp) HttpProtocolFactorySmallApp.getInstance().getProtocol("https://d.lxt6.cn", BusinessHttpProtocolSmallApp.class);

    public HttpBusinessStoreSmallApp(Account account) {
    }

    public PasswordStateBean whetherPassword(String str, String str2, String str3) throws HttpException {
        try {
            String str4 = "schoolid=" + str2 + "*_studentid=" + str3 + "*_rand=" + RandomUtil.getRandNumMaxString(6);
            String sign = getSign(URLEncoder.encode(str4, "UTF-8"));
            LogUtil.log(str4);
            BaseBean<PasswordStateBean> baseBeanWhetherPassword = this.mProtocol.whetherPassword(str4, sign, str, "140000000000000001", 1);
            if (baseBeanWhetherPassword.ok() && baseBeanWhetherPassword != null) {
                return baseBeanWhetherPassword.Data;
            }
            throw HttpException.filter(baseBeanWhetherPassword.Code, baseBeanWhetherPassword.getErrMsg(), baseBeanWhetherPassword.Data, baseBeanWhetherPassword.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean addPassword(String str, String str2, String str3, String str4) throws HttpException {
        try {
            String str5 = "schoolid=" + str2 + "*_studentid=" + str3 + "*password=" + str4 + "*_rand=" + RandomUtil.getRandNumMaxString(6);
            String sign = getSign(URLEncoder.encode(str5, "UTF-8"));
            LogUtil.log(str5);
            BaseBean<SuccessBean> baseBeanAddPassword = this.mProtocol.addPassword(str5, sign, str, "140000000000000001", 1);
            if (baseBeanAddPassword.ok()) {
                return baseBeanAddPassword.Data;
            }
            throw HttpException.filter(baseBeanAddPassword.Code, baseBeanAddPassword.getErrMsg(), baseBeanAddPassword.Data, baseBeanAddPassword.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean updatePassword(String str, String str2, String str3, String str4, String str5) throws HttpException {
        try {
            String str6 = "schoolid=" + str2 + "*_studentid=" + str3 + "*_oldPassword=" + str4 + "*_newPassword=" + str5 + "*_rand=" + RandomUtil.getRandNumMaxString(6);
            String sign = getSign(URLEncoder.encode(str6, "UTF-8"));
            LogUtil.log(str6);
            BaseBean<SuccessBean> baseBeanUpdatePassword = this.mProtocol.updatePassword(str6, sign, str, "140000000000000001", 1);
            if (baseBeanUpdatePassword.ok()) {
                return baseBeanUpdatePassword.Data;
            }
            throw HttpException.filter(baseBeanUpdatePassword.Code, baseBeanUpdatePassword.getErrMsg(), baseBeanUpdatePassword.Data, baseBeanUpdatePassword.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public IsHasBindCardFunctionBean isHasCardFunction(String str, String str2, int i) throws HttpException {
        try {
            String str3 = "schoolid=" + str2 + "*_typeid=" + i + "*_rand=" + RandomUtil.getRandNumMaxString(6);
            String sign = getSign(URLEncoder.encode(str3, "UTF-8"));
            LogUtil.log(str3);
            BaseBean<IsHasBindCardFunctionBean> baseBeanIsHasCardFunction = this.mProtocol.isHasCardFunction(str3, sign, str, "140000000000000001", 1);
            if (baseBeanIsHasCardFunction.ok() && baseBeanIsHasCardFunction != null) {
                return baseBeanIsHasCardFunction.Data;
            }
            throw HttpException.filter(baseBeanIsHasCardFunction.Code, baseBeanIsHasCardFunction.getErrMsg(), baseBeanIsHasCardFunction.Data, baseBeanIsHasCardFunction.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public IsBindCardBean getIsBindCard(String str, String str2, String str3, int i, int i2) throws HttpException {
        try {
            String str4 = "schoolid=" + str2 + "*_studentid=" + str3 + "*_typeid=" + i + "*_managerflag=" + i2 + "*_rand=" + RandomUtil.getRandNumMaxString(6) + "*_clinettype=4";
            String sign = getSign(URLEncoder.encode(str4, "UTF-8"));
            LogUtil.log(str4);
            BaseBean<IsBindCardBean> isBindCard = this.mProtocol.getIsBindCard(str4, sign, str, "140000000000000001", 1);
            if (isBindCard.ok() && isBindCard != null) {
                return isBindCard.Data;
            }
            throw HttpException.filter(isBindCard.Code, isBindCard.getErrMsg(), isBindCard.Data, isBindCard.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BindCardBean bindCard(String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, String str7) throws HttpException {
        try {
            String str8 = "schoolid=" + str2 + "*_studentid=" + str3 + "*_typeid=" + i + "*_managerflag=" + i2 + "*_rand=" + RandomUtil.getRandNumMaxString(6) + "*_clinettype=4*_machineid=" + str4 + "*_machinedata=" + str5 + "*_alleywaytype=3*_version=" + str6 + "*_machineidRandom=" + str7 + "*_model=1";
            String sign = getSign(URLEncoder.encode(str8, "UTF-8"));
            LogUtil.log(str8);
            BaseBean<BindCardBean> baseBeanBindCard = this.mProtocol.bindCard(str8, sign, str, "140000000000000001", 1);
            if (baseBeanBindCard.ok() && baseBeanBindCard != null) {
                return baseBeanBindCard.Data;
            }
            throw HttpException.filter(baseBeanBindCard.Code, baseBeanBindCard.getErrMsg(), baseBeanBindCard.Data, baseBeanBindCard.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BindCardBean bindCard2(String str, String str2, String str3, int i, String str4, String str5, String str6) throws HttpException {
        try {
            String str7 = "schoolid=" + str2 + "*_studentid=" + str3 + "*_typeid=" + i + "*_rand=" + RandomUtil.getRandNumMaxString(6) + "*_alleywaytype=3*_version=" + str4 + "*_cardid=" + str5 + "*_machineid=" + str6 + "*_model=1";
            String sign = getSign(URLEncoder.encode(str7, "UTF-8"));
            LogUtil.log(str7);
            BaseBean<BindCardBean> baseBeanBindCard2 = this.mProtocol.bindCard2(str7, sign, str, "140000000000000001", 1);
            if (baseBeanBindCard2.ok() && baseBeanBindCard2 != null) {
                return baseBeanBindCard2.Data;
            }
            throw HttpException.filter(baseBeanBindCard2.Code, baseBeanBindCard2.getErrMsg(), baseBeanBindCard2.Data, baseBeanBindCard2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean unBindCard(String str, String str2, String str3, int i, int i2, String str4, String str5) throws HttpException {
        try {
            String str6 = "schoolid=" + str2 + "*_studentid=" + str3 + "*_typeid=" + i + "*_rand=" + RandomUtil.getRandNumMaxString(6) + "*_clinettype=3*_cardid=" + str4 + "*_machineid=" + str5 + "*_managerflag=" + i2;
            String sign = getSign(URLEncoder.encode(str6, "UTF-8"));
            LogUtil.log(str6);
            BaseBean<SuccessBean> baseBeanUnBindCard = this.mProtocol.unBindCard(str6, sign, str, "140000000000000001", 1);
            if (baseBeanUnBindCard.ok() && baseBeanUnBindCard != null) {
                return baseBeanUnBindCard.Data;
            }
            throw HttpException.filter(baseBeanUnBindCard.Code, baseBeanUnBindCard.getErrMsg(), baseBeanUnBindCard.Data, baseBeanUnBindCard.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean openCard(String str, String str2, String str3, int i, String str4) throws HttpException {
        try {
            String str5 = "schoolid=" + str2 + "*_studentid=" + str3 + "*_typeid=" + i + "*_rand=" + RandomUtil.getRandNumMaxString(6) + "*_cardid=" + str4;
            String sign = getSign(URLEncoder.encode(str5, "UTF-8"));
            LogUtil.log(str5);
            BaseBean<SuccessBean> baseBeanOpenCard = this.mProtocol.openCard(str5, sign, str, "140000000000000001", 1);
            if (baseBeanOpenCard.ok() && baseBeanOpenCard != null) {
                return baseBeanOpenCard.Data;
            }
            throw HttpException.filter(baseBeanOpenCard.Code, baseBeanOpenCard.getErrMsg(), baseBeanOpenCard.Data, baseBeanOpenCard.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean closeCard(String str, String str2, String str3, int i, String str4) throws HttpException {
        try {
            String str5 = "schoolid=" + str2 + "*_studentid=" + str3 + "*_typeid=" + i + "*_rand=" + RandomUtil.getRandNumMaxString(6) + "*_cardid=" + str4;
            String sign = getSign(URLEncoder.encode(str5, "UTF-8"));
            LogUtil.log(str5);
            BaseBean<SuccessBean> baseBeanCloseCard = this.mProtocol.closeCard(str5, sign, str, "140000000000000001", 1);
            if (baseBeanCloseCard.ok() && baseBeanCloseCard != null) {
                return baseBeanCloseCard.Data;
            }
            throw HttpException.filter(baseBeanCloseCard.Code, baseBeanCloseCard.getErrMsg(), baseBeanCloseCard.Data, baseBeanCloseCard.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    private String getSign(String str) {
        return MD5.md5_SmallRoutine("applets_test_001" + str);
    }
}
