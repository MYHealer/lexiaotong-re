package client.android.yixiaotong.controller.store;

import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.controller.bean.SystemErrorBean;
import client.android.yixiaotong.exception.HttpException;
import client.android.yixiaotong.ui.login.FillInfoActivity;
import client.android.yixiaotong.util.AESHelper;
import client.android.yixiaotong.util.MD5;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import client.android.yixiaotong.util.http.HttpProtocolFactory;
import client.android.yixiaotong.util.http.bean.BaseBean;
import client.android.yixiaotong.util.http.protocol.BusinessHttpProtocolSystemError;
import cz.msebera.android.httpclient.cookie.ClientCookie;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class HttpBusinessStoreSystemError {
    private BusinessHttpProtocolSystemError mProtocol = (BusinessHttpProtocolSystemError) HttpProtocolFactory.getInstance().getProtocol(HttpComfigUtil.SERVER_SYSTEM_ERROR, BusinessHttpProtocolSystemError.class);

    public SystemErrorBean getSystemError(long j, int i) throws HttpException {
        try {
            BaseBean<SystemErrorBean> systemError = this.mProtocol.getSystemError(j + "", i + "");
            if (systemError.ok()) {
                return systemError.Data;
            }
            throw new HttpException(systemError.Code, systemError.getErrMsg());
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SystemErrorBean getSystemError(String str, long j) throws HttpException {
        try {
            String string = new LocalPreferencesHelper(BaseApplication.app, ClientCookie.PORT_ATTR).getString("localport");
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind(ClientCookie.PORT_ATTR, string);
            String code = getCode(combindBean);
            BaseBean<SystemErrorBean> systemError = this.mProtocol.getSystemError(code, getSign(code), str);
            if (systemError.ok()) {
                return systemError.Data;
            }
            throw HttpException.filter(systemError.Code, systemError.getErrMsg(), systemError.Data);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    private String getCode(CombindBean combindBean) throws HttpException {
        try {
            return AESHelper.encrypt(combindBean.toString(), StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
        } catch (Exception unused) {
            throw new HttpException(-1001, "获取服务器数据失败");
        }
    }

    private String getSign(String str) {
        return MD5.md5(StringUtils.asciiToString("121,107,116,42,37,95,99,79") + str);
    }

    class CombindBean {
        private String returnStr = "";

        CombindBean() {
        }

        public CombindBean combind(String str, String str2) {
            if (str2 != null && !str2.equals("null")) {
                this.returnStr += (str + "=" + str2 + "#?");
            }
            return this;
        }

        public String toString() {
            String str = new String(this.returnStr);
            return str.length() >= 2 ? str.substring(0, str.length() - 2) : str;
        }
    }
}
