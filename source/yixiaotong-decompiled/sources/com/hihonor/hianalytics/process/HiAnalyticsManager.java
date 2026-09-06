package com.hihonor.hianalytics.process;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.b1;
import com.hihonor.hianalytics.hnha.g;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.p2;
import com.hihonor.hianalytics.util.HiAnalyticTools;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.hianalytics.util.o;
import com.yfanads.android.utils.YFAdsConst;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class HiAnalyticsManager {
    private static final String TAG = "HiAnalyticsManager";

    public static final class Builder {
        private Context context;
        private boolean isEnableLog = j2.e();
        private int logLevel = j2.a();
        private String globalAppID = g.k();
        private int cacheSize = g.g();
        private String customPkgName = g.h();
        private boolean unusualDataIgnored = g.y();
        private boolean isOpenAegisRandom = g.x();
        private int reportInterval = g.s();
        private int autoReportNum = g.e();
        private boolean isBackToReportOpera = g.w();
        private int dbAutoCloseTime = g.i();
        private int dbCacheSize = g.j();
        private int restrictedStorageCacheSize = g.t();

        private Builder setDbAutoCloseTime(int i) {
            this.dbAutoCloseTime = i <= 0 ? 0 : o.a(i, 7200000, com.alipay.security.mobile.module.http.constant.a.f1701a);
            j2.c(HiAnalyticsManager.TAG, "setDbAutoCloseTime dbAutoCloseTime=" + i + ",newNum=" + this.dbAutoCloseTime);
            return this;
        }

        public void build() {
            if (this.isEnableLog) {
                HiAnalyticTools.enableLog(this.context, this.logLevel);
            }
            b1 b1VarL = g.l();
            b1VarL.d(this.globalAppID);
            b1VarL.b(this.cacheSize);
            b1VarL.c(this.customPkgName);
            b1VarL.d(this.unusualDataIgnored);
            b1VarL.c(this.isOpenAegisRandom);
            b1VarL.e(this.reportInterval);
            b1VarL.a(this.autoReportNum);
            b1VarL.a(this.isBackToReportOpera);
            b1VarL.c(this.dbAutoCloseTime);
            b1VarL.f(this.restrictedStorageCacheSize);
            int i = this.dbCacheSize;
            if (i <= 0) {
                i = -1;
            }
            b1VarL.d(i);
        }

        @Deprecated
        public Builder enableGlobalNewMode() {
            return this;
        }

        public Builder setAppid(String str, String str2) {
            this.globalAppID = o.a(YFAdsConst.REPORT_APPID, str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", str2);
            j2.c(HiAnalyticsManager.TAG, "setGlobalAppID withAppId=" + str + ",newValue=" + this.globalAppID);
            return this;
        }

        public Builder setAutoReportNum(int i) {
            this.autoReportNum = o.a(i, 1000, 30);
            j2.c(HiAnalyticsManager.TAG, "setAutoReportNum autoReportNum=" + i + ",newAutoNum=" + this.autoReportNum);
            return this;
        }

        public Builder setBackToReportOpera(boolean z) {
            j2.c(HiAnalyticsManager.TAG, "setBackToReportOpera withValue=" + z + ",nowValue=" + this.isBackToReportOpera);
            this.isBackToReportOpera = z;
            return this;
        }

        public Builder setCacheSize(int i) {
            this.cacheSize = o.a(i, Integer.MAX_VALUE, 5);
            j2.c(HiAnalyticsManager.TAG, "setCacheSize withSize=" + i + ",newValue=" + this.cacheSize);
            return this;
        }

        public Builder setCustomPkgName(String str) {
            if (TextUtils.isEmpty(str) || str.length() > 256) {
                j2.g(HiAnalyticsManager.TAG, "setCustomPkgName illegalValue=" + str);
                return this;
            }
            this.customPkgName = str;
            return this;
        }

        public Builder setDbCacheSize(int i) {
            this.dbCacheSize = i <= 0 ? -1 : o.a(i, 10485760, 204800);
            j2.c(HiAnalyticsManager.TAG, "setDbCacheSize dbCacheSize=" + i + ",newNum=" + this.dbCacheSize);
            return this;
        }

        public Builder setLogState(Context context, boolean z, int i) {
            j2.c(HiAnalyticsManager.TAG, "setLogState withContext=" + context + ",isEnableLog=" + z + ",logLevel=" + i);
            this.context = context;
            this.isEnableLog = z;
            this.logLevel = i;
            SystemUtils.a(context);
            return this;
        }

        public Builder setOpenAegisRandom(boolean z) {
            j2.c(HiAnalyticsManager.TAG, "setOpenAegisRandom withValue=" + z + ",nowValue=" + this.isOpenAegisRandom);
            this.isOpenAegisRandom = z;
            return this;
        }

        public Builder setReportInterval(int i) {
            this.reportInterval = o.a(i, 14400, 60);
            j2.c(HiAnalyticsManager.TAG, "setReportInterval reportInterval=" + i + ",newInterval=" + this.reportInterval);
            return this;
        }

        public Builder setRestrictedStorageCacheSize(int i) {
            if (i > 10 || i < 5) {
                this.restrictedStorageCacheSize = 5;
            } else {
                this.restrictedStorageCacheSize = i;
            }
            return this;
        }

        public Builder setUnusualDataIgnored(boolean z) {
            j2.c(HiAnalyticsManager.TAG, "setUnusualDataIgnored withValue=" + z + ",nowValue=" + this.unusualDataIgnored);
            this.unusualDataIgnored = z;
            return this;
        }
    }

    public static void clearCachedData() {
        if (SystemUtils.a()) {
            b.a();
        } else {
            j2.g(TAG, "clearCachedData not unlock");
        }
    }

    public static void enableGlobalNewMode() {
    }

    public static List<String> getAllTags() {
        return a.c().b();
    }

    public static boolean getInitFlag(String str) {
        return a.c().b(str);
    }

    public static HiAnalyticsInstance getInstanceByTag(String str) {
        return a.c().c(str);
    }

    public static HiAnalyticsInstanceEx getInstanceEx() {
        return a.c().d();
    }

    public static void openAegisRandom(boolean z) {
        a.c().b(z);
    }

    public static void setAppid(String str) throws IllegalAccessException, InvocationTargetException {
        a.c().e(str);
    }

    public static void setAutoReportNum(int i) {
        a.c().a(i);
    }

    public static void setBackToReportOpera(boolean z) {
        a.c().a(z);
    }

    public static void setCacheSize(int i) {
        a.c().c(i);
    }

    public static void setCustomPkgName(String str) {
        a.c().f(str);
    }

    public static void setReportInterval(int i) {
        a.c().b(i);
        p2.e().c();
    }

    public static void setUnusualDataIgnored(boolean z) {
        a.c().c(z);
    }
}
