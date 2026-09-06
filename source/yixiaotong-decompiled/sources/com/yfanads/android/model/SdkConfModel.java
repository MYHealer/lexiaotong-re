package com.yfanads.android.model;

import android.text.TextUtils;
import com.yfanads.android.core.f;
import com.yfanads.android.libs.thirdpart.gson.GsonBuilder;
import com.yfanads.android.libs.thirdpart.gson.annotations.Expose;
import com.yfanads.android.libs.thirdpart.gson.annotations.SerializedName;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class SdkConfModel implements Serializable {

    @Expose
    private List<Adn> adnList;

    @Expose
    private int clfu;

    @Expose
    private int dlf;

    @Expose
    private int elun;

    @Expose
    private MobLink mbi;

    @Expose
    private List<PC> pc;

    @Expose
    private String pnl;

    @Expose
    private int pnls;

    @Expose
    public String[] qal;

    @Expose
    public String xcc;

    @Expose
    private String rtel = YFAdsConst.DEFAULT_RT;
    public Map<Integer, AdsInitBean> adsInitBeans = new HashMap();

    @Expose
    private int eps = 1;

    @Expose
    private int mbs = 0;

    @Expose
    private int ver = 0;

    @Expose
    private int el = 0;

    @Expose
    private float er = 1.0f;

    @Expose
    private int jd = 0;

    @Expose
    public int xccr = 100;

    @Expose
    public int ug = 0;

    @Expose
    public int ulf = 0;

    @Expose
    public int plv = 0;

    @Expose
    public String adc = "";

    @Expose
    public String ads = "";

    @Expose
    public int qas = 0;

    public static class Adn implements Serializable {

        @Expose
        @SerializedName("adnID")
        private int adnId;

        @Expose
        @SerializedName(YFAdsConst.REPORT_APPID)
        private String appId;

        @Expose
        @SerializedName("appKey")
        private String appKey;

        @Expose
        @SerializedName("appSecret")
        public String appSecret;

        @Expose
        @SerializedName("appToken")
        public String appToken;

        @Expose
        @SerializedName("wxAppID")
        private String wxAppId;

        public int getAdnId() {
            return this.adnId;
        }

        public String getAppId() {
            return this.appId;
        }

        public String getAppKey() {
            return this.appKey;
        }

        public String getAppSecret() {
            return this.appSecret;
        }

        public String getAppToken() {
            return this.appToken;
        }

        public String getWxAppId() {
            return this.wxAppId;
        }

        public void setAdnId(int i) {
            this.adnId = i;
        }

        public void setAppId(String str) {
            this.appId = str;
        }

        public void setAppKey(String str) {
            this.appKey = str;
        }

        public void setAppSecret(String str) {
            this.appSecret = str;
        }

        public void setAppToken(String str) {
            this.appToken = str;
        }

        public void setWxAppId(String str) {
            this.wxAppId = str;
        }

        public String toString() {
            return "Adn{adnId=" + this.adnId + ", appId='" + this.appId + "', appKey='" + this.appKey + "', appSecret='" + this.appSecret + "', appToken='" + this.appToken + "'}";
        }
    }

    public static class MobLink implements Serializable {
        private String ak;
        private String as;

        public String getAk() {
            return this.ak;
        }

        public String getAs() {
            return this.as;
        }

        public void setAk(String str) {
            this.ak = str;
        }

        public void setAs(String str) {
            this.as = str;
        }
    }

    public static class PC implements Serializable {

        @Expose
        @SerializedName("adnId")
        private int adnId = -1;

        @Expose
        @SerializedName(YFAdsConst.CWE)
        private int cwe = -1;

        @Expose
        @SerializedName(YFAdsConst.CUA)
        private int cua = -1;

        @Expose
        @SerializedName(YFAdsConst.CUAID)
        private int cuaid = -1;

        @Expose
        @SerializedName(YFAdsConst.CUL)
        private int cul = -1;

        @Expose
        @SerializedName(YFAdsConst.CUO)
        private int cuo = -1;

        @Expose
        @SerializedName(YFAdsConst.CUP)
        private int cup = -1;

        @Expose
        @SerializedName(YFAdsConst.CUW)
        private int cuw = -1;

        @Expose
        @SerializedName(YFAdsConst.CAR)
        private int car = -1;

        @Expose
        @SerializedName(YFAdsConst.LP)
        private int lp = -1;

        public int getAdnId() {
            return this.adnId;
        }

        public int getCar() {
            return this.car;
        }

        public int getCua() {
            return this.cua;
        }

        public int getCuaid() {
            return this.cuaid;
        }

        public int getCul() {
            return this.cul;
        }

        public int getCuo() {
            return this.cuo;
        }

        public int getCup() {
            return this.cup;
        }

        public int getCuw() {
            return this.cuw;
        }

        public int getCwe() {
            return this.cwe;
        }

        public int getLp() {
            return this.lp;
        }

        public int getPermissionValue(String str) {
            str.getClass();
            str.hashCode();
            switch (str) {
                case "lp":
                    return this.lp;
                case "car":
                    return this.car;
                case "cua":
                    return this.cua;
                case "cul":
                    return this.cul;
                case "cuo":
                    return this.cuo;
                case "cup":
                    return this.cup;
                case "cuw":
                    return this.cuw;
                case "cwe":
                    return this.cwe;
                case "cuaid":
                    return this.cuaid;
                default:
                    return -1;
            }
        }

        public int[] getPermissionValues() {
            return new int[]{this.cwe, this.cua, this.cuaid, this.cul, this.cuo, this.cup, this.cuw, this.car, this.lp};
        }

        public void setAdnId(int i) {
            this.adnId = i;
        }

        public void setCar(int i) {
            this.car = i;
        }

        public void setCua(int i) {
            this.cua = i;
        }

        public void setCuaid(int i) {
            this.cuaid = i;
        }

        public void setCul(int i) {
            this.cul = i;
        }

        public void setCuo(int i) {
            this.cuo = i;
        }

        public void setCup(int i) {
            this.cup = i;
        }

        public void setCuw(int i) {
            this.cuw = i;
        }

        public void setCwe(int i) {
            this.cwe = i;
        }

        public void setLp(int i) {
            this.lp = i;
        }

        public String toString() {
            return "{adnId:" + this.adnId + ",cwe:" + this.cwe + ",cua:" + this.cua + ",cuaid:" + this.cuaid + ",cul:" + this.cul + ",cuo:" + this.cuo + ",cup:" + this.cup + ",cuw:" + this.cuw + ",car:" + this.car + ",lp:" + this.lp + '}';
        }
    }

    public SdkConfModel() {
        this.elun = 20;
        this.elun = 20;
    }

    public static SdkConfModel covertModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (SdkConfModel) Util.GSON.fromJson(str, SdkConfModel.class);
        } catch (Exception e) {
            f.a(e, new StringBuilder("string covert object error "));
            return null;
        }
    }

    public static String covertString(SdkConfModel sdkConfModel) {
        if (sdkConfModel == null) {
            return null;
        }
        try {
            return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(sdkConfModel);
        } catch (Exception e) {
            f.a(e, new StringBuilder("string covert object error "));
            return null;
        }
    }

    public boolean canQueryJdPackage() {
        return this.jd == 1;
    }

    public void covertSdkInit() {
        try {
            if (YFListUtils.isEmpty(this.adnList)) {
                YFLog.high("covertSdkInit adnList is null, return.");
                return;
            }
            YFLog.high("covertSdkInit start." + this.adnList.size());
            this.adsInitBeans.clear();
            for (Adn adn : this.adnList) {
                if (adn != null) {
                    this.adsInitBeans.put(Integer.valueOf(adn.adnId), new AdsInitBean(adn.adnId, adn.getAppId(), adn.getAppKey(), adn.getWxAppId(), adn.getAppSecret(), adn.getAppToken()));
                }
            }
            YFLog.high("covertSdkInit end.");
        } catch (Exception e) {
            e.printStackTrace();
            f.a(e, new StringBuilder("covertSdkInit exception"));
        }
    }

    public String getAdc() {
        return this.adc;
    }

    public List<Adn> getAdnList() {
        return this.adnList;
    }

    public String getAds() {
        return this.ads;
    }

    public String getAk() {
        MobLink mobLink = this.mbi;
        return mobLink != null ? mobLink.getAk() : "";
    }

    public String getAs() {
        MobLink mobLink = this.mbi;
        return mobLink != null ? mobLink.getAs() : "";
    }

    public int getClfu() {
        return this.clfu;
    }

    public int getDlf() {
        return this.dlf;
    }

    public int getEl() {
        return this.el;
    }

    public int getElun() {
        return this.elun;
    }

    public int getEps() {
        return this.eps;
    }

    public float getEr() {
        return this.er;
    }

    public int getJd() {
        return this.jd;
    }

    public MobLink getMbi() {
        return this.mbi;
    }

    public int getMbs() {
        return this.mbs;
    }

    public List<PC> getPc() {
        return this.pc;
    }

    public int getPermissionValue(int i, String str) {
        if (YFListUtils.isEmpty(this.pc)) {
            return -1;
        }
        for (PC pc : this.pc) {
            if (pc.adnId == i) {
                return pc.getPermissionValue(str);
            }
        }
        return -1;
    }

    public int[] getPermissionValues(int i) {
        if (YFListUtils.isEmpty(this.pc)) {
            return null;
        }
        for (PC pc : this.pc) {
            if (pc.adnId == i) {
                return pc.getPermissionValues();
            }
        }
        return null;
    }

    public String getPnl() {
        return this.pnl;
    }

    public int getPnls() {
        return this.pnls;
    }

    public String[] getQal() {
        return this.qal;
    }

    public int getQas() {
        return this.qas;
    }

    public int getULF() {
        return this.ulf;
    }

    public int getUg() {
        return this.ug;
    }

    public int getVer() {
        return this.ver;
    }

    public int getVideoType() {
        return this.plv;
    }

    public String getXcc() {
        return this.xcc;
    }

    public int getXccr() {
        return this.xccr;
    }

    public boolean isCrashUpd() {
        return this.clfu == 1;
    }

    public boolean isEpsOpen() {
        return this.eps == 1;
    }

    public boolean isEventOpen() {
        return this.el == 1;
    }

    public boolean isLogOpen() {
        return this.dlf == 1;
    }

    public boolean isMbsOpen() {
        return this.mbs == 1;
    }

    public boolean isQabOpen() {
        return this.qas == 1;
    }

    public boolean isQueryAllPackage() {
        return this.pnls == 1;
    }

    public boolean isRTReport(int i) {
        return !TextUtils.isEmpty(this.rtel) && this.rtel.contains(String.valueOf(i));
    }

    public void printPCLog() {
        if (YFListUtils.isEmpty(this.pc)) {
            YFLog.high("PDS:empty");
            return;
        }
        StringBuilder sb = new StringBuilder("PDS:");
        Iterator<PC> it = this.pc.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        YFLog.high(sb.toString());
    }

    public void setAdc(String str) {
        this.adc = str;
    }

    public void setAdnList(List<Adn> list) {
        this.adnList = list;
    }

    public void setAds(String str) {
        this.ads = str;
    }

    public void setClfu(int i) {
        this.clfu = i;
    }

    public void setDlf(int i) {
        this.dlf = i;
    }

    public void setEl(int i) {
        this.el = i;
    }

    public void setEps(int i) {
        this.eps = i;
    }

    public void setJd(int i) {
        this.jd = i;
    }

    public void setMbi(MobLink mobLink) {
        this.mbi = mobLink;
    }

    public void setMbs(int i) {
        this.mbs = i;
    }

    public void setPc(List<PC> list) {
        this.pc = list;
    }

    public void setPnl(String str) {
        this.pnl = str;
    }

    public void setPnls(int i) {
        this.pnls = i;
    }

    public void setQal(String[] strArr) {
        this.qal = strArr;
    }

    public void setQas(int i) {
        this.qas = i;
    }

    public void setULF(int i) {
        this.ulf = i;
    }

    public void setVer(int i) {
        this.ver = i;
    }
}
