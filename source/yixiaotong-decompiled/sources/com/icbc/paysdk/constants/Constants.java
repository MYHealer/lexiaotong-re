package com.icbc.paysdk.constants;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class Constants {
    public static String Build_NO = "3.0_20190416";
    public static final int HttpFail = 201;
    public static final int HttpSuccess = 200;
    public static final String InterfaceName = "interfaceName";
    public static final String InterfaceVersion = "interfaceVersion";
    public static final String LogFlag = "paySDK";
    public static String PAY_LIST_IP = "https://b2c.icbc.com.cn";
    public static String SERVER_URL = "https://mywap2.icbc.com.cn";
    public static String Start_B2C_IP = "https://mywap2.icbc.com.cn";
    public static String URL_APIP = "https://gw.open.icbc.com.cn/api";
    public static String URL_EPAY = "https://b2c.icbc.com.cn";
    public static String Version = "3.0";
    public static final String checkdate = "checkDate";
    public static final int icbcpackageNum = 4;
    public static final String openFlag = "ICBC_GET_CLIENTLIST";
    public static final String payList = "payList";
    public static final String payPackageFile = "payListFile";
    public static final int version = 300016;
    public String PAY_LIST_URL = PAY_LIST_IP + "/servlet/AppListReqServlet";
    public String Start_B2C_URL_OLD = Start_B2C_IP + "/ICBCWAPBank/servlet/ICBCWAPEBizServlet";
    public String Start_THIRDPAY_URL = PAY_LIST_IP + "/servlet/ICBCWAPEBizServlet";
    public String THIRDPAYLIST_URL = PAY_LIST_IP + "/servlet/ThirdPartyPayFlagReqServlet";
    public String SDK_URL = URL_APIP + "/cardbusiness/aggregatepay/b2c/online/consumptionapforsdk/V1";
    public String TEST_EPAY_URL = URL_APIP + "/cardbusiness/epay/consumptionepayforsdk/V1";
    public String Start_B2C_URL = URL_EPAY + "/servlet/ICBCEPAYVerifyServlet";

    public static class ICBCPackage {
        public static final String ebank = "com.icbc";
        public static final String ebuy = "com.icbc.emallmobile";
        public static final String echat = "com.icbc.im";
        public static final String elife = "";
    }
}
