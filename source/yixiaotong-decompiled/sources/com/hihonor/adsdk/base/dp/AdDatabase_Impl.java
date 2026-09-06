package com.hihonor.adsdk.base.dp;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.cdo.oaps.ad.OapsKey;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hihonor.adsdk.base.dp.b.b;
import com.hihonor.adsdk.base.dp.b.c;
import com.hihonor.adsdk.base.dp.b.d;
import com.hihonor.updater.installsdk.api.TraceUrlData;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.openalliance.ad.constant.ba;
import com.huawei.openalliance.ad.constant.bf;
import com.opos.mobad.activity.VideoActivity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class AdDatabase_Impl extends AdDatabase {
    private volatile com.hihonor.adsdk.base.dp.b.a hnadsh;
    private volatile c hnadsi;

    class a extends RoomOpenHelper.Delegate {
        a(int i) {
            super(i);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `AdTrack` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `time` INTEGER NOT NULL, `trackUrl` TEXT, `trackingType` INTEGER NOT NULL, `reportCnt` INTEGER NOT NULL, `reportState` INTEGER NOT NULL, `reportTime` INTEGER NOT NULL, `method` TEXT, `body` TEXT, `headers` TEXT, `adUnitId` TEXT, `adId` TEXT, `requestId` TEXT, `recordId` TEXT, `recordIds` TEXT, `urlType` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_AdTrack__id` ON `AdTrack` (`_id`)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `BaseAdInfo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `adRequestId` TEXT, `adUnitId` TEXT, `adId` TEXT, `appPackage` TEXT, `dpPackageName` TEXT, `appVersion` TEXT, `permissionsUrl` TEXT, `privacyAgreementUrl` TEXT, `developerName` TEXT, `interactType` INTEGER NOT NULL, `adType` INTEGER NOT NULL, `trackUrl` TEXT, `landingPageUrl` TEXT, `packageUrl` TEXT, `logo` TEXT, `sequence` INTEGER NOT NULL, `storeChannel` TEXT, `imgWidth` INTEGER NOT NULL, `imgHeight` INTEGER NOT NULL, `imgUrls` TEXT, `videoUrl` TEXT, `title` TEXT, `subTitle` TEXT, `brand` TEXT, `appName` TEXT, `homePage` TEXT, `appIntro` TEXT, `introUrl` TEXT, `appIconUrl` TEXT, `pkgSizeBytes` INTEGER NOT NULL, `installPkgType` INTEGER NOT NULL, `subType` INTEGER NOT NULL, `promotionPurpose` INTEGER NOT NULL, `adFlag` INTEGER NOT NULL, `closeFlag` INTEGER NOT NULL, `deeplinkUrl` TEXT, `style` TEXT, `miniProgramType` INTEGER NOT NULL, `miniProgramId` TEXT, `miniProgramPath` TEXT, `pkgSign` TEXT, `adSpecTemplateType` INTEGER NOT NULL, `expirationTime` INTEGER NOT NULL, `responseTimeMillis` INTEGER NOT NULL, `actionType` TEXT, `actionTips` TEXT, `targetTips` TEXT, `impDuration` INTEGER NOT NULL, `brandFontSize` INTEGER NOT NULL, `adFlagFontSize` INTEGER NOT NULL, `skipFontSize` INTEGER NOT NULL, `shakeAngle` REAL NOT NULL, `shakeAcc` REAL NOT NULL, `shakeDuration` REAL NOT NULL, `video` TEXT, `pkgType` INTEGER NOT NULL, `landingPageType` INTEGER NOT NULL, `newLandingPageType` INTEGER NOT NULL, `price` INTEGER NOT NULL, `forwardInterval` INTEGER NOT NULL, `orientation` INTEGER NOT NULL, `creativeTemplateId` INTEGER NOT NULL, `incentiveFlag` INTEGER NOT NULL, `incentivePoints` TEXT, `isCarousel` INTEGER NOT NULL, `detailPageOpenMode` INTEGER NOT NULL, `channelInfo` TEXT, `extraJson` TEXT, `subChannel` TEXT, `detailType` INTEGER NOT NULL, `downloadType` INTEGER NOT NULL, `partner` TEXT, `ts` INTEGER NOT NULL, `sifSign` TEXT, `adPositionSets` TEXT, `dataType` INTEGER NOT NULL, `buttonText` TEXT, `uninstalleFilter` INTEGER NOT NULL, `detailPageCtrl` TEXT, `wechatExtInfo` TEXT, `templateId` TEXT)");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e09e4003e69da16de53a92c53b5cbd5d')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `AdTrack`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `BaseAdInfo`");
            if (((RoomDatabase) AdDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AdDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AdDatabase_Impl.this).mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) AdDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AdDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AdDatabase_Impl.this).mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) AdDatabase_Impl.this).mDatabase = supportSQLiteDatabase;
            AdDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) AdDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AdDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AdDatabase_Impl.this).mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap map = new HashMap(16);
            map.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
            map.put(CrashHianalyticsData.TIME, new TableInfo.Column(CrashHianalyticsData.TIME, "INTEGER", true, 0, null, 1));
            map.put(TraceUrlData.JsonKeyOld.KEY_TRACK_URL, new TableInfo.Column(TraceUrlData.JsonKeyOld.KEY_TRACK_URL, "TEXT", false, 0, null, 1));
            map.put("trackingType", new TableInfo.Column("trackingType", "INTEGER", true, 0, null, 1));
            map.put("reportCnt", new TableInfo.Column("reportCnt", "INTEGER", true, 0, null, 1));
            map.put("reportState", new TableInfo.Column("reportState", "INTEGER", true, 0, null, 1));
            map.put("reportTime", new TableInfo.Column("reportTime", "INTEGER", true, 0, null, 1));
            map.put("method", new TableInfo.Column("method", "TEXT", false, 0, null, 1));
            map.put(TtmlNode.TAG_BODY, new TableInfo.Column(TtmlNode.TAG_BODY, "TEXT", false, 0, null, 1));
            map.put("headers", new TableInfo.Column("headers", "TEXT", false, 0, null, 1));
            map.put("adUnitId", new TableInfo.Column("adUnitId", "TEXT", false, 0, null, 1));
            map.put("adId", new TableInfo.Column("adId", "TEXT", false, 0, null, 1));
            map.put(ba.S, new TableInfo.Column(ba.S, "TEXT", false, 0, null, 1));
            map.put("recordId", new TableInfo.Column("recordId", "TEXT", false, 0, null, 1));
            map.put("recordIds", new TableInfo.Column("recordIds", "TEXT", false, 0, null, 1));
            map.put("urlType", new TableInfo.Column("urlType", "INTEGER", true, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new TableInfo.Index("index_AdTrack__id", false, Arrays.asList("_id")));
            TableInfo tableInfo = new TableInfo("AdTrack", map, hashSet, hashSet2);
            TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "AdTrack");
            if (!tableInfo.equals(tableInfo2)) {
                return new RoomOpenHelper.ValidationResult(false, "AdTrack(com.hihonor.adsdk.base.dp.entity.AdTrack).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
            }
            HashMap map2 = new HashMap(82);
            map2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            map2.put("adRequestId", new TableInfo.Column("adRequestId", "TEXT", false, 0, null, 1));
            map2.put("adUnitId", new TableInfo.Column("adUnitId", "TEXT", false, 0, null, 1));
            map2.put("adId", new TableInfo.Column("adId", "TEXT", false, 0, null, 1));
            map2.put("appPackage", new TableInfo.Column("appPackage", "TEXT", false, 0, null, 1));
            map2.put("dpPackageName", new TableInfo.Column("dpPackageName", "TEXT", false, 0, null, 1));
            map2.put("appVersion", new TableInfo.Column("appVersion", "TEXT", false, 0, null, 1));
            map2.put("permissionsUrl", new TableInfo.Column("permissionsUrl", "TEXT", false, 0, null, 1));
            map2.put("privacyAgreementUrl", new TableInfo.Column("privacyAgreementUrl", "TEXT", false, 0, null, 1));
            map2.put("developerName", new TableInfo.Column("developerName", "TEXT", false, 0, null, 1));
            map2.put("interactType", new TableInfo.Column("interactType", "INTEGER", true, 0, null, 1));
            map2.put("adType", new TableInfo.Column("adType", "INTEGER", true, 0, null, 1));
            map2.put(TraceUrlData.JsonKeyOld.KEY_TRACK_URL, new TableInfo.Column(TraceUrlData.JsonKeyOld.KEY_TRACK_URL, "TEXT", false, 0, null, 1));
            map2.put("landingPageUrl", new TableInfo.Column("landingPageUrl", "TEXT", false, 0, null, 1));
            map2.put("packageUrl", new TableInfo.Column("packageUrl", "TEXT", false, 0, null, 1));
            map2.put("logo", new TableInfo.Column("logo", "TEXT", false, 0, null, 1));
            map2.put("sequence", new TableInfo.Column("sequence", "INTEGER", true, 0, null, 1));
            map2.put("storeChannel", new TableInfo.Column("storeChannel", "TEXT", false, 0, null, 1));
            map2.put("imgWidth", new TableInfo.Column("imgWidth", "INTEGER", true, 0, null, 1));
            map2.put("imgHeight", new TableInfo.Column("imgHeight", "INTEGER", true, 0, null, 1));
            map2.put("imgUrls", new TableInfo.Column("imgUrls", "TEXT", false, 0, null, 1));
            map2.put("videoUrl", new TableInfo.Column("videoUrl", "TEXT", false, 0, null, 1));
            map2.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
            map2.put("subTitle", new TableInfo.Column("subTitle", "TEXT", false, 0, null, 1));
            map2.put("brand", new TableInfo.Column("brand", "TEXT", false, 0, null, 1));
            map2.put("appName", new TableInfo.Column("appName", "TEXT", false, 0, null, 1));
            map2.put("homePage", new TableInfo.Column("homePage", "TEXT", false, 0, null, 1));
            map2.put("appIntro", new TableInfo.Column("appIntro", "TEXT", false, 0, null, 1));
            map2.put("introUrl", new TableInfo.Column("introUrl", "TEXT", false, 0, null, 1));
            map2.put("appIconUrl", new TableInfo.Column("appIconUrl", "TEXT", false, 0, null, 1));
            map2.put("pkgSizeBytes", new TableInfo.Column("pkgSizeBytes", "INTEGER", true, 0, null, 1));
            map2.put("installPkgType", new TableInfo.Column("installPkgType", "INTEGER", true, 0, null, 1));
            map2.put("subType", new TableInfo.Column("subType", "INTEGER", true, 0, null, 1));
            map2.put("promotionPurpose", new TableInfo.Column("promotionPurpose", "INTEGER", true, 0, null, 1));
            map2.put("adFlag", new TableInfo.Column("adFlag", "INTEGER", true, 0, null, 1));
            map2.put("closeFlag", new TableInfo.Column("closeFlag", "INTEGER", true, 0, null, 1));
            map2.put("deeplinkUrl", new TableInfo.Column("deeplinkUrl", "TEXT", false, 0, null, 1));
            map2.put("style", new TableInfo.Column("style", "TEXT", false, 0, null, 1));
            map2.put("miniProgramType", new TableInfo.Column("miniProgramType", "INTEGER", true, 0, null, 1));
            map2.put("miniProgramId", new TableInfo.Column("miniProgramId", "TEXT", false, 0, null, 1));
            map2.put("miniProgramPath", new TableInfo.Column("miniProgramPath", "TEXT", false, 0, null, 1));
            map2.put("pkgSign", new TableInfo.Column("pkgSign", "TEXT", false, 0, null, 1));
            map2.put("adSpecTemplateType", new TableInfo.Column("adSpecTemplateType", "INTEGER", true, 0, null, 1));
            map2.put("expirationTime", new TableInfo.Column("expirationTime", "INTEGER", true, 0, null, 1));
            map2.put("responseTimeMillis", new TableInfo.Column("responseTimeMillis", "INTEGER", true, 0, null, 1));
            map2.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, new TableInfo.Column(VideoActivity.EXTRA_KEY_ACTION_TYPE, "TEXT", false, 0, null, 1));
            map2.put("actionTips", new TableInfo.Column("actionTips", "TEXT", false, 0, null, 1));
            map2.put("targetTips", new TableInfo.Column("targetTips", "TEXT", false, 0, null, 1));
            map2.put("impDuration", new TableInfo.Column("impDuration", "INTEGER", true, 0, null, 1));
            map2.put("brandFontSize", new TableInfo.Column("brandFontSize", "INTEGER", true, 0, null, 1));
            map2.put("adFlagFontSize", new TableInfo.Column("adFlagFontSize", "INTEGER", true, 0, null, 1));
            map2.put("skipFontSize", new TableInfo.Column("skipFontSize", "INTEGER", true, 0, null, 1));
            map2.put(bf.aT, new TableInfo.Column(bf.aT, "REAL", true, 0, null, 1));
            map2.put("shakeAcc", new TableInfo.Column("shakeAcc", "REAL", true, 0, null, 1));
            map2.put("shakeDuration", new TableInfo.Column("shakeDuration", "REAL", true, 0, null, 1));
            map2.put("video", new TableInfo.Column("video", "TEXT", false, 0, null, 1));
            map2.put("pkgType", new TableInfo.Column("pkgType", "INTEGER", true, 0, null, 1));
            map2.put("landingPageType", new TableInfo.Column("landingPageType", "INTEGER", true, 0, null, 1));
            map2.put("newLandingPageType", new TableInfo.Column("newLandingPageType", "INTEGER", true, 0, null, 1));
            map2.put(OapsKey.KEY_PRICE, new TableInfo.Column(OapsKey.KEY_PRICE, "INTEGER", true, 0, null, 1));
            map2.put("forwardInterval", new TableInfo.Column("forwardInterval", "INTEGER", true, 0, null, 1));
            map2.put("orientation", new TableInfo.Column("orientation", "INTEGER", true, 0, null, 1));
            map2.put("creativeTemplateId", new TableInfo.Column("creativeTemplateId", "INTEGER", true, 0, null, 1));
            map2.put("incentiveFlag", new TableInfo.Column("incentiveFlag", "INTEGER", true, 0, null, 1));
            map2.put("incentivePoints", new TableInfo.Column("incentivePoints", "TEXT", false, 0, null, 1));
            map2.put("isCarousel", new TableInfo.Column("isCarousel", "INTEGER", true, 0, null, 1));
            map2.put("detailPageOpenMode", new TableInfo.Column("detailPageOpenMode", "INTEGER", true, 0, null, 1));
            map2.put("channelInfo", new TableInfo.Column("channelInfo", "TEXT", false, 0, null, 1));
            map2.put("extraJson", new TableInfo.Column("extraJson", "TEXT", false, 0, null, 1));
            map2.put("subChannel", new TableInfo.Column("subChannel", "TEXT", false, 0, null, 1));
            map2.put("detailType", new TableInfo.Column("detailType", "INTEGER", true, 0, null, 1));
            map2.put("downloadType", new TableInfo.Column("downloadType", "INTEGER", true, 0, null, 1));
            map2.put(com.alipay.sdk.app.statistic.c.ab, new TableInfo.Column(com.alipay.sdk.app.statistic.c.ab, "TEXT", false, 0, null, 1));
            map2.put("ts", new TableInfo.Column("ts", "INTEGER", true, 0, null, 1));
            map2.put("sifSign", new TableInfo.Column("sifSign", "TEXT", false, 0, null, 1));
            map2.put("adPositionSets", new TableInfo.Column("adPositionSets", "TEXT", false, 0, null, 1));
            map2.put("dataType", new TableInfo.Column("dataType", "INTEGER", true, 0, null, 1));
            map2.put("buttonText", new TableInfo.Column("buttonText", "TEXT", false, 0, null, 1));
            map2.put("uninstalleFilter", new TableInfo.Column("uninstalleFilter", "INTEGER", true, 0, null, 1));
            map2.put("detailPageCtrl", new TableInfo.Column("detailPageCtrl", "TEXT", false, 0, null, 1));
            map2.put("wechatExtInfo", new TableInfo.Column("wechatExtInfo", "TEXT", false, 0, null, 1));
            map2.put("templateId", new TableInfo.Column("templateId", "TEXT", false, 0, null, 1));
            TableInfo tableInfo3 = new TableInfo("BaseAdInfo", map2, new HashSet(0), new HashSet(0));
            TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, "BaseAdInfo");
            return !tableInfo3.equals(tableInfo4) ? new RoomOpenHelper.ValidationResult(false, "BaseAdInfo(com.hihonor.adsdk.base.bean.BaseAdInfo).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4) : new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        try {
            beginTransaction();
            writableDatabase.execSQL("DELETE FROM `AdTrack`");
            writableDatabase.execSQL("DELETE FROM `BaseAdInfo`");
            setTransactionSuccessful();
        } finally {
            endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "AdTrack", "BaseAdInfo");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(16), "e09e4003e69da16de53a92c53b5cbd5d", "691d7ad603cb7185a83d70bfe5c3e1cf")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(com.hihonor.adsdk.base.dp.b.a.class, b.hnadsd());
        map.put(c.class, d.hnadsa());
        return map;
    }

    @Override // com.hihonor.adsdk.base.dp.AdDatabase
    public com.hihonor.adsdk.base.dp.b.a hnadsa() {
        com.hihonor.adsdk.base.dp.b.a aVar;
        if (this.hnadsh != null) {
            return this.hnadsh;
        }
        synchronized (this) {
            if (this.hnadsh == null) {
                this.hnadsh = new b(this);
            }
            aVar = this.hnadsh;
        }
        return aVar;
    }

    @Override // com.hihonor.adsdk.base.dp.AdDatabase
    public c hnadsb() {
        c cVar;
        if (this.hnadsi != null) {
            return this.hnadsi;
        }
        synchronized (this) {
            if (this.hnadsi == null) {
                this.hnadsi = new d(this);
            }
            cVar = this.hnadsi;
        }
        return cVar;
    }
}
