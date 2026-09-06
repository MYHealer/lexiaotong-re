package com.hihonor.adsdk.base.dp.b;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.cdo.oaps.ad.OapsKey;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.updater.installsdk.api.TraceUrlData;
import com.huawei.openalliance.ad.constant.bf;
import com.opos.mobad.activity.VideoActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class d implements c {
    private final RoomDatabase hnadsa;
    private final EntityInsertionAdapter<BaseAdInfo> hnadsb;
    private final SharedSQLiteStatement hnadsc;

    class a extends EntityInsertionAdapter<BaseAdInfo> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR ABORT INTO `BaseAdInfo` (`id`,`adRequestId`,`adUnitId`,`adId`,`appPackage`,`dpPackageName`,`appVersion`,`permissionsUrl`,`privacyAgreementUrl`,`developerName`,`interactType`,`adType`,`trackUrl`,`landingPageUrl`,`packageUrl`,`logo`,`sequence`,`storeChannel`,`imgWidth`,`imgHeight`,`imgUrls`,`videoUrl`,`title`,`subTitle`,`brand`,`appName`,`homePage`,`appIntro`,`introUrl`,`appIconUrl`,`pkgSizeBytes`,`installPkgType`,`subType`,`promotionPurpose`,`adFlag`,`closeFlag`,`deeplinkUrl`,`style`,`miniProgramType`,`miniProgramId`,`miniProgramPath`,`pkgSign`,`adSpecTemplateType`,`expirationTime`,`responseTimeMillis`,`actionType`,`actionTips`,`targetTips`,`impDuration`,`brandFontSize`,`adFlagFontSize`,`skipFontSize`,`shakeAngle`,`shakeAcc`,`shakeDuration`,`video`,`pkgType`,`landingPageType`,`newLandingPageType`,`price`,`forwardInterval`,`orientation`,`creativeTemplateId`,`incentiveFlag`,`incentivePoints`,`isCarousel`,`detailPageOpenMode`,`channelInfo`,`extraJson`,`subChannel`,`detailType`,`downloadType`,`partner`,`ts`,`sifSign`,`adPositionSets`,`dataType`,`buttonText`,`uninstalleFilter`,`detailPageCtrl`,`wechatExtInfo`,`templateId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, BaseAdInfo baseAdInfo) {
            supportSQLiteStatement.bindLong(1, baseAdInfo.getId());
            if (baseAdInfo.getAdRequestId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, baseAdInfo.getAdRequestId());
            }
            if (baseAdInfo.getAdUnitId() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, baseAdInfo.getAdUnitId());
            }
            if (baseAdInfo.getAdId() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, baseAdInfo.getAdId());
            }
            if (baseAdInfo.getAppPackage() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, baseAdInfo.getAppPackage());
            }
            if (baseAdInfo.getDpPackageName() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, baseAdInfo.getDpPackageName());
            }
            if (baseAdInfo.getAppVersion() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, baseAdInfo.getAppVersion());
            }
            if (baseAdInfo.getPermissionsUrl() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, baseAdInfo.getPermissionsUrl());
            }
            if (baseAdInfo.getPrivacyAgreementUrl() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, baseAdInfo.getPrivacyAgreementUrl());
            }
            if (baseAdInfo.getDeveloperName() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, baseAdInfo.getDeveloperName());
            }
            supportSQLiteStatement.bindLong(11, baseAdInfo.getInteractType());
            supportSQLiteStatement.bindLong(12, baseAdInfo.getAdType());
            String strHnadsa = com.hihonor.adsdk.base.dp.a.hnadsa(baseAdInfo.getTrackUrl());
            if (strHnadsa == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, strHnadsa);
            }
            if (baseAdInfo.getLandingPageUrl() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, baseAdInfo.getLandingPageUrl());
            }
            if (baseAdInfo.getPackageUrl() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, baseAdInfo.getPackageUrl());
            }
            if (baseAdInfo.getLogo() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, baseAdInfo.getLogo());
            }
            supportSQLiteStatement.bindLong(17, baseAdInfo.getSequence());
            if (baseAdInfo.getStoreChannel() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, baseAdInfo.getStoreChannel());
            }
            supportSQLiteStatement.bindLong(19, baseAdInfo.getImgWidth());
            supportSQLiteStatement.bindLong(20, baseAdInfo.getImgHeight());
            String strHnadsb = com.hihonor.adsdk.base.dp.a.hnadsb(baseAdInfo.getImgUrls());
            if (strHnadsb == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, strHnadsb);
            }
            if (baseAdInfo.getVideoUrl() == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, baseAdInfo.getVideoUrl());
            }
            if (baseAdInfo.getTitle() == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, baseAdInfo.getTitle());
            }
            if (baseAdInfo.getSubTitle() == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, baseAdInfo.getSubTitle());
            }
            if (baseAdInfo.getBrand() == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, baseAdInfo.getBrand());
            }
            if (baseAdInfo.getAppName() == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, baseAdInfo.getAppName());
            }
            if (baseAdInfo.getHomePage() == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, baseAdInfo.getHomePage());
            }
            if (baseAdInfo.getAppIntro() == null) {
                supportSQLiteStatement.bindNull(28);
            } else {
                supportSQLiteStatement.bindString(28, baseAdInfo.getAppIntro());
            }
            if (baseAdInfo.getIntroUrl() == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, baseAdInfo.getIntroUrl());
            }
            if (baseAdInfo.getAppIconUrl() == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, baseAdInfo.getAppIconUrl());
            }
            supportSQLiteStatement.bindLong(31, baseAdInfo.getPkgSizeBytes());
            supportSQLiteStatement.bindLong(32, baseAdInfo.getInstallPkgType());
            supportSQLiteStatement.bindLong(33, baseAdInfo.getSubType());
            supportSQLiteStatement.bindLong(34, baseAdInfo.getPromotionPurpose());
            supportSQLiteStatement.bindLong(35, baseAdInfo.getAdFlag());
            supportSQLiteStatement.bindLong(36, baseAdInfo.getCloseFlag());
            if (baseAdInfo.getDeeplinkUrl() == null) {
                supportSQLiteStatement.bindNull(37);
            } else {
                supportSQLiteStatement.bindString(37, baseAdInfo.getDeeplinkUrl());
            }
            String strHnadsa2 = com.hihonor.adsdk.base.dp.a.hnadsa(baseAdInfo.getStyle());
            if (strHnadsa2 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, strHnadsa2);
            }
            supportSQLiteStatement.bindLong(39, baseAdInfo.getMiniProgramType());
            if (baseAdInfo.getMiniProgramId() == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindString(40, baseAdInfo.getMiniProgramId());
            }
            if (baseAdInfo.getMiniProgramPath() == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindString(41, baseAdInfo.getMiniProgramPath());
            }
            if (baseAdInfo.getPkgSign() == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, baseAdInfo.getPkgSign());
            }
            supportSQLiteStatement.bindLong(43, baseAdInfo.getAdSpecTemplateType());
            supportSQLiteStatement.bindLong(44, baseAdInfo.getExpirationTime());
            supportSQLiteStatement.bindLong(45, baseAdInfo.getResponseTimeMillis());
            if (baseAdInfo.getActionType() == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindString(46, baseAdInfo.getActionType());
            }
            if (baseAdInfo.getActionTips() == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, baseAdInfo.getActionTips());
            }
            if (baseAdInfo.getTargetTips() == null) {
                supportSQLiteStatement.bindNull(48);
            } else {
                supportSQLiteStatement.bindString(48, baseAdInfo.getTargetTips());
            }
            supportSQLiteStatement.bindLong(49, baseAdInfo.getImpDuration());
            supportSQLiteStatement.bindLong(50, baseAdInfo.getBrandFontSize());
            supportSQLiteStatement.bindLong(51, baseAdInfo.getAdFlagFontSize());
            supportSQLiteStatement.bindLong(52, baseAdInfo.getSkipFontSize());
            supportSQLiteStatement.bindDouble(53, baseAdInfo.getShakeAngle());
            supportSQLiteStatement.bindDouble(54, baseAdInfo.getShakeAcc());
            supportSQLiteStatement.bindDouble(55, baseAdInfo.getShakeDuration());
            String strHnadsa3 = com.hihonor.adsdk.base.dp.a.hnadsa(baseAdInfo.getVideo());
            if (strHnadsa3 == null) {
                supportSQLiteStatement.bindNull(56);
            } else {
                supportSQLiteStatement.bindString(56, strHnadsa3);
            }
            supportSQLiteStatement.bindLong(57, baseAdInfo.getPkgType());
            supportSQLiteStatement.bindLong(58, baseAdInfo.getLandingPageType());
            supportSQLiteStatement.bindLong(59, baseAdInfo.getNewLandingPageType());
            supportSQLiteStatement.bindLong(60, baseAdInfo.getPrice());
            supportSQLiteStatement.bindLong(61, baseAdInfo.getForwardInterval());
            supportSQLiteStatement.bindLong(62, baseAdInfo.getOrientation());
            supportSQLiteStatement.bindLong(63, baseAdInfo.getCreativeTemplateId());
            supportSQLiteStatement.bindLong(64, baseAdInfo.getIncentiveFlag());
            String strHnadsa4 = com.hihonor.adsdk.base.dp.a.hnadsa(baseAdInfo.getIncentivePoints());
            if (strHnadsa4 == null) {
                supportSQLiteStatement.bindNull(65);
            } else {
                supportSQLiteStatement.bindString(65, strHnadsa4);
            }
            supportSQLiteStatement.bindLong(66, baseAdInfo.getIsCarousel());
            supportSQLiteStatement.bindLong(67, baseAdInfo.getDetailPageOpenMode());
            if (baseAdInfo.getChannelInfo() == null) {
                supportSQLiteStatement.bindNull(68);
            } else {
                supportSQLiteStatement.bindString(68, baseAdInfo.getChannelInfo());
            }
            if (baseAdInfo.getExtraJson() == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindString(69, baseAdInfo.getExtraJson());
            }
            if (baseAdInfo.getSubChannel() == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindString(70, baseAdInfo.getSubChannel());
            }
            supportSQLiteStatement.bindLong(71, baseAdInfo.getDetailType());
            supportSQLiteStatement.bindLong(72, baseAdInfo.getDownloadType());
            if (baseAdInfo.getPartner() == null) {
                supportSQLiteStatement.bindNull(73);
            } else {
                supportSQLiteStatement.bindString(73, baseAdInfo.getPartner());
            }
            supportSQLiteStatement.bindLong(74, baseAdInfo.getTs());
            if (baseAdInfo.getSifSign() == null) {
                supportSQLiteStatement.bindNull(75);
            } else {
                supportSQLiteStatement.bindString(75, baseAdInfo.getSifSign());
            }
            String strHnadsa5 = com.hihonor.adsdk.base.dp.a.hnadsa(baseAdInfo.getAdPositionSets());
            if (strHnadsa5 == null) {
                supportSQLiteStatement.bindNull(76);
            } else {
                supportSQLiteStatement.bindString(76, strHnadsa5);
            }
            supportSQLiteStatement.bindLong(77, baseAdInfo.getDataType());
            if (baseAdInfo.getButtonText() == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindString(78, baseAdInfo.getButtonText());
            }
            supportSQLiteStatement.bindLong(79, baseAdInfo.getUninstalleFilter());
            String strHnadsa6 = com.hihonor.adsdk.base.dp.a.hnadsa(baseAdInfo.getDetailPageCtrl());
            if (strHnadsa6 == null) {
                supportSQLiteStatement.bindNull(80);
            } else {
                supportSQLiteStatement.bindString(80, strHnadsa6);
            }
            String str = baseAdInfo.wechatExtInfo;
            if (str == null) {
                supportSQLiteStatement.bindNull(81);
            } else {
                supportSQLiteStatement.bindString(81, str);
            }
            if (baseAdInfo.getTemplateId() == null) {
                supportSQLiteStatement.bindNull(82);
            } else {
                supportSQLiteStatement.bindString(82, baseAdInfo.getTemplateId());
            }
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "delete from BaseAdInfo where adUnitId = ? and adRequestId = ?";
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.hnadsa = roomDatabase;
        this.hnadsb = new a(roomDatabase);
        this.hnadsc = new b(roomDatabase);
    }

    @Override // com.hihonor.adsdk.base.dp.b.c
    public List<Long> hnadsa(List<BaseAdInfo> list) {
        this.hnadsa.assertNotSuspendingTransaction();
        this.hnadsa.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.hnadsb.insertAndReturnIdsList(list);
            this.hnadsa.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.hnadsa.endTransaction();
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.c
    public int hnadsb(String str, String str2) {
        this.hnadsa.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.hnadsc.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str2);
        }
        this.hnadsa.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.hnadsa.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.hnadsa.endTransaction();
            this.hnadsc.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.c
    public int hnadsc(List<String> list) {
        this.hnadsa.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("delete from BaseAdInfo where adRequestId IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.hnadsa.compileStatement(sbNewStringBuilder.toString());
        int i = 1;
        for (String str : list) {
            if (str == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindString(i, str);
            }
            i++;
        }
        this.hnadsa.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.hnadsa.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.hnadsa.endTransaction();
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.c
    public int hnadsa(String str, long j) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select count(*) from BaseAdInfo where adUnitId = ? and expirationTime * 1000 >= ?", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        roomSQLiteQueryAcquire.bindLong(2, j);
        this.hnadsa.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.hnadsa, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.c
    public List<BaseAdInfo> hnadsb(String str, long j) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from BaseAdInfo where adUnitId = ? and adRequestId = (select BaseAdInfo.adRequestId from BaseAdInfo where adUnitId = ? and expirationTime * 1000 >= ? order by expirationTime asc limit 1)", 3);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        roomSQLiteQueryAcquire.bindLong(3, j);
        this.hnadsa.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.hnadsa, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adRequestId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adUnitId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appPackage");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dpPackageName");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appVersion");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "permissionsUrl");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "privacyAgreementUrl");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "developerName");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interactType");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adType");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TraceUrlData.JsonKeyOld.KEY_TRACK_URL);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "landingPageUrl");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "packageUrl");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "logo");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sequence");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "storeChannel");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgWidth");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgHeight");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgUrls");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoUrl");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subTitle");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brand");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appName");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "homePage");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appIntro");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "introUrl");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appIconUrl");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pkgSizeBytes");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installPkgType");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subType");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "promotionPurpose");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adFlag");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "closeFlag");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deeplinkUrl");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "miniProgramType");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "miniProgramId");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "miniProgramPath");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pkgSign");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adSpecTemplateType");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expirationTime");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "responseTimeMillis");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, VideoActivity.EXTRA_KEY_ACTION_TYPE);
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "actionTips");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "targetTips");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "impDuration");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brandFontSize");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adFlagFontSize");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "skipFontSize");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, bf.aT);
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shakeAcc");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shakeDuration");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pkgType");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "landingPageType");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "newLandingPageType");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, OapsKey.KEY_PRICE);
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forwardInterval");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "orientation");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "creativeTemplateId");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "incentiveFlag");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "incentivePoints");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isCarousel");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "detailPageOpenMode");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelInfo");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extraJson");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subChannel");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "detailType");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadType");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, com.alipay.sdk.app.statistic.c.ab);
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ts");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sifSign");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adPositionSets");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataType");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "buttonText");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "uninstalleFilter");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "detailPageCtrl");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wechatExtInfo");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "templateId");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    BaseAdInfo baseAdInfo = new BaseAdInfo();
                    int i2 = columnIndexOrThrow11;
                    int i3 = columnIndexOrThrow12;
                    baseAdInfo.setId(cursorQuery.getLong(columnIndexOrThrow));
                    baseAdInfo.setAdRequestId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    baseAdInfo.setAdUnitId(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    baseAdInfo.setAdId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    baseAdInfo.setAppPackage(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    baseAdInfo.setDpPackageName(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    baseAdInfo.setAppVersion(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    baseAdInfo.setPermissionsUrl(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    baseAdInfo.setPrivacyAgreementUrl(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    baseAdInfo.setDeveloperName(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    columnIndexOrThrow11 = i2;
                    baseAdInfo.setInteractType(cursorQuery.getInt(columnIndexOrThrow11));
                    int i4 = columnIndexOrThrow;
                    columnIndexOrThrow12 = i3;
                    baseAdInfo.setAdType(cursorQuery.getInt(columnIndexOrThrow12));
                    baseAdInfo.setTrackUrl(com.hihonor.adsdk.base.dp.a.hnadse(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13)));
                    int i5 = i;
                    baseAdInfo.setLandingPageUrl(cursorQuery.isNull(i5) ? null : cursorQuery.getString(i5));
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    baseAdInfo.setPackageUrl(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    baseAdInfo.setLogo(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    int i6 = columnIndexOrThrow17;
                    int i7 = columnIndexOrThrow13;
                    baseAdInfo.setSequence(cursorQuery.getInt(i6));
                    int i8 = columnIndexOrThrow18;
                    baseAdInfo.setStoreChannel(cursorQuery.isNull(i8) ? null : cursorQuery.getString(i8));
                    columnIndexOrThrow18 = i8;
                    int i9 = columnIndexOrThrow19;
                    baseAdInfo.setImgWidth(cursorQuery.getInt(i9));
                    columnIndexOrThrow19 = i9;
                    int i10 = columnIndexOrThrow20;
                    baseAdInfo.setImgHeight(cursorQuery.getInt(i10));
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    baseAdInfo.setImgUrls(com.hihonor.adsdk.base.dp.a.hnadsc(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21)));
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    baseAdInfo.setVideoUrl(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    baseAdInfo.setTitle(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    baseAdInfo.setSubTitle(cursorQuery.isNull(columnIndexOrThrow24) ? null : cursorQuery.getString(columnIndexOrThrow24));
                    columnIndexOrThrow25 = columnIndexOrThrow25;
                    baseAdInfo.setBrand(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                    columnIndexOrThrow26 = columnIndexOrThrow26;
                    baseAdInfo.setAppName(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                    columnIndexOrThrow27 = columnIndexOrThrow27;
                    baseAdInfo.setHomePage(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    columnIndexOrThrow28 = columnIndexOrThrow28;
                    baseAdInfo.setAppIntro(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    columnIndexOrThrow29 = columnIndexOrThrow29;
                    baseAdInfo.setIntroUrl(cursorQuery.isNull(columnIndexOrThrow29) ? null : cursorQuery.getString(columnIndexOrThrow29));
                    columnIndexOrThrow30 = columnIndexOrThrow30;
                    baseAdInfo.setAppIconUrl(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    int i11 = columnIndexOrThrow2;
                    int i12 = columnIndexOrThrow31;
                    baseAdInfo.setPkgSizeBytes(cursorQuery.getLong(i12));
                    int i13 = columnIndexOrThrow32;
                    baseAdInfo.setInstallPkgType(cursorQuery.getInt(i13));
                    int i14 = columnIndexOrThrow33;
                    baseAdInfo.setSubType(cursorQuery.getInt(i14));
                    int i15 = columnIndexOrThrow34;
                    baseAdInfo.setPromotionPurpose(cursorQuery.getInt(i15));
                    columnIndexOrThrow34 = i15;
                    int i16 = columnIndexOrThrow35;
                    baseAdInfo.setAdFlag(cursorQuery.getInt(i16));
                    columnIndexOrThrow35 = i16;
                    int i17 = columnIndexOrThrow36;
                    baseAdInfo.setCloseFlag(cursorQuery.getInt(i17));
                    int i18 = columnIndexOrThrow37;
                    baseAdInfo.setDeeplinkUrl(cursorQuery.isNull(i18) ? null : cursorQuery.getString(i18));
                    columnIndexOrThrow38 = columnIndexOrThrow38;
                    baseAdInfo.setStyle(com.hihonor.adsdk.base.dp.a.hnadsd(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getString(columnIndexOrThrow38)));
                    int i19 = columnIndexOrThrow39;
                    baseAdInfo.setMiniProgramType(cursorQuery.getInt(i19));
                    int i20 = columnIndexOrThrow40;
                    baseAdInfo.setMiniProgramId(cursorQuery.isNull(i20) ? null : cursorQuery.getString(i20));
                    columnIndexOrThrow41 = columnIndexOrThrow41;
                    baseAdInfo.setMiniProgramPath(cursorQuery.isNull(columnIndexOrThrow41) ? null : cursorQuery.getString(columnIndexOrThrow41));
                    columnIndexOrThrow42 = columnIndexOrThrow42;
                    baseAdInfo.setPkgSign(cursorQuery.isNull(columnIndexOrThrow42) ? null : cursorQuery.getString(columnIndexOrThrow42));
                    int i21 = columnIndexOrThrow43;
                    baseAdInfo.setAdSpecTemplateType(cursorQuery.getInt(i21));
                    int i22 = columnIndexOrThrow3;
                    int i23 = columnIndexOrThrow44;
                    baseAdInfo.setExpirationTime(cursorQuery.getLong(i23));
                    int i24 = columnIndexOrThrow45;
                    int i25 = columnIndexOrThrow4;
                    baseAdInfo.setResponseTimeMillis(cursorQuery.getLong(i24));
                    int i26 = columnIndexOrThrow46;
                    baseAdInfo.setActionType(cursorQuery.isNull(i26) ? null : cursorQuery.getString(i26));
                    int i27 = columnIndexOrThrow47;
                    baseAdInfo.setActionTips(cursorQuery.isNull(i27) ? null : cursorQuery.getString(i27));
                    columnIndexOrThrow48 = columnIndexOrThrow48;
                    baseAdInfo.setTargetTips(cursorQuery.isNull(columnIndexOrThrow48) ? null : cursorQuery.getString(columnIndexOrThrow48));
                    int i28 = columnIndexOrThrow49;
                    baseAdInfo.setImpDuration(cursorQuery.getInt(i28));
                    columnIndexOrThrow49 = i28;
                    int i29 = columnIndexOrThrow50;
                    baseAdInfo.setBrandFontSize(cursorQuery.getInt(i29));
                    columnIndexOrThrow50 = i29;
                    int i30 = columnIndexOrThrow51;
                    baseAdInfo.setAdFlagFontSize(cursorQuery.getInt(i30));
                    columnIndexOrThrow51 = i30;
                    int i31 = columnIndexOrThrow52;
                    baseAdInfo.setSkipFontSize(cursorQuery.getInt(i31));
                    int i32 = columnIndexOrThrow53;
                    baseAdInfo.setShakeAngle(cursorQuery.getDouble(i32));
                    int i33 = columnIndexOrThrow54;
                    baseAdInfo.setShakeAcc(cursorQuery.getDouble(i33));
                    int i34 = columnIndexOrThrow55;
                    baseAdInfo.setShakeDuration(cursorQuery.getDouble(i34));
                    int i35 = columnIndexOrThrow56;
                    baseAdInfo.setVideo(com.hihonor.adsdk.base.dp.a.hnadsf(cursorQuery.isNull(i35) ? null : cursorQuery.getString(i35)));
                    int i36 = columnIndexOrThrow57;
                    baseAdInfo.setPkgType(cursorQuery.getInt(i36));
                    int i37 = columnIndexOrThrow58;
                    baseAdInfo.setLandingPageType(cursorQuery.getInt(i37));
                    columnIndexOrThrow58 = i37;
                    int i38 = columnIndexOrThrow59;
                    baseAdInfo.setNewLandingPageType(cursorQuery.getInt(i38));
                    int i39 = columnIndexOrThrow60;
                    baseAdInfo.setPrice(cursorQuery.getLong(i39));
                    int i40 = columnIndexOrThrow61;
                    baseAdInfo.setForwardInterval(cursorQuery.getInt(i40));
                    int i41 = columnIndexOrThrow62;
                    baseAdInfo.setOrientation(cursorQuery.getInt(i41));
                    int i42 = columnIndexOrThrow63;
                    baseAdInfo.setCreativeTemplateId(cursorQuery.getInt(i42));
                    columnIndexOrThrow63 = i42;
                    int i43 = columnIndexOrThrow64;
                    baseAdInfo.setIncentiveFlag(cursorQuery.getInt(i43));
                    columnIndexOrThrow65 = columnIndexOrThrow65;
                    baseAdInfo.setIncentivePoints(com.hihonor.adsdk.base.dp.a.hnadsa(cursorQuery.isNull(columnIndexOrThrow65) ? null : cursorQuery.getString(columnIndexOrThrow65)));
                    columnIndexOrThrow64 = i43;
                    int i44 = columnIndexOrThrow66;
                    baseAdInfo.setIsCarousel(cursorQuery.getInt(i44));
                    columnIndexOrThrow66 = i44;
                    int i45 = columnIndexOrThrow67;
                    baseAdInfo.setDetailPageOpenMode(cursorQuery.getInt(i45));
                    columnIndexOrThrow68 = columnIndexOrThrow68;
                    baseAdInfo.setChannelInfo(cursorQuery.isNull(columnIndexOrThrow68) ? null : cursorQuery.getString(columnIndexOrThrow68));
                    columnIndexOrThrow69 = columnIndexOrThrow69;
                    baseAdInfo.setExtraJson(cursorQuery.isNull(columnIndexOrThrow69) ? null : cursorQuery.getString(columnIndexOrThrow69));
                    columnIndexOrThrow70 = columnIndexOrThrow70;
                    baseAdInfo.setSubChannel(cursorQuery.isNull(columnIndexOrThrow70) ? null : cursorQuery.getString(columnIndexOrThrow70));
                    columnIndexOrThrow67 = i45;
                    int i46 = columnIndexOrThrow71;
                    baseAdInfo.setDetailType(cursorQuery.getInt(i46));
                    columnIndexOrThrow71 = i46;
                    int i47 = columnIndexOrThrow72;
                    baseAdInfo.setDownloadType(cursorQuery.getInt(i47));
                    columnIndexOrThrow73 = columnIndexOrThrow73;
                    baseAdInfo.setPartner(cursorQuery.isNull(columnIndexOrThrow73) ? null : cursorQuery.getString(columnIndexOrThrow73));
                    int i48 = columnIndexOrThrow74;
                    baseAdInfo.setTs(cursorQuery.getLong(i48));
                    int i49 = columnIndexOrThrow75;
                    baseAdInfo.setSifSign(cursorQuery.isNull(i49) ? null : cursorQuery.getString(i49));
                    int i50 = columnIndexOrThrow76;
                    baseAdInfo.setAdPositionSets(com.hihonor.adsdk.base.dp.a.hnadsa(cursorQuery.isNull(i50) ? null : cursorQuery.getString(i50)));
                    columnIndexOrThrow75 = i49;
                    int i51 = columnIndexOrThrow77;
                    baseAdInfo.setDataType(cursorQuery.getInt(i51));
                    int i52 = columnIndexOrThrow78;
                    baseAdInfo.setButtonText(cursorQuery.isNull(i52) ? null : cursorQuery.getString(i52));
                    int i53 = columnIndexOrThrow79;
                    baseAdInfo.setUninstalleFilter(cursorQuery.getInt(i53));
                    int i54 = columnIndexOrThrow80;
                    baseAdInfo.setDetailPageCtrl(com.hihonor.adsdk.base.dp.a.hnadsb(cursorQuery.isNull(i54) ? null : cursorQuery.getString(i54)));
                    int i55 = columnIndexOrThrow81;
                    if (cursorQuery.isNull(i55)) {
                        baseAdInfo.wechatExtInfo = null;
                    } else {
                        baseAdInfo.wechatExtInfo = cursorQuery.getString(i55);
                    }
                    int i56 = columnIndexOrThrow82;
                    baseAdInfo.setTemplateId(cursorQuery.isNull(i56) ? null : cursorQuery.getString(i56));
                    arrayList.add(baseAdInfo);
                    columnIndexOrThrow81 = i55;
                    columnIndexOrThrow = i4;
                    columnIndexOrThrow82 = i56;
                    columnIndexOrThrow13 = i7;
                    columnIndexOrThrow17 = i6;
                    i = i5;
                    columnIndexOrThrow76 = i50;
                    columnIndexOrThrow2 = i11;
                    columnIndexOrThrow20 = i10;
                    columnIndexOrThrow31 = i12;
                    columnIndexOrThrow32 = i13;
                    columnIndexOrThrow33 = i14;
                    columnIndexOrThrow44 = i23;
                    columnIndexOrThrow46 = i26;
                    columnIndexOrThrow54 = i33;
                    columnIndexOrThrow57 = i36;
                    columnIndexOrThrow4 = i25;
                    columnIndexOrThrow45 = i24;
                    columnIndexOrThrow52 = i31;
                    columnIndexOrThrow53 = i32;
                    columnIndexOrThrow56 = i35;
                    columnIndexOrThrow3 = i22;
                    columnIndexOrThrow43 = i21;
                    columnIndexOrThrow47 = i27;
                    columnIndexOrThrow55 = i34;
                    columnIndexOrThrow59 = i38;
                    columnIndexOrThrow60 = i39;
                    columnIndexOrThrow61 = i40;
                    columnIndexOrThrow62 = i41;
                    columnIndexOrThrow72 = i47;
                    columnIndexOrThrow74 = i48;
                    columnIndexOrThrow37 = i18;
                    columnIndexOrThrow36 = i17;
                    columnIndexOrThrow40 = i20;
                    columnIndexOrThrow39 = i19;
                    columnIndexOrThrow78 = i52;
                    columnIndexOrThrow77 = i51;
                    columnIndexOrThrow80 = i54;
                    columnIndexOrThrow79 = i53;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.c
    public List<BaseAdInfo> hnadsa(String str, String str2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from BaseAdInfo where adUnitId = ? and adRequestId = ?", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.hnadsa.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.hnadsa, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adRequestId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adUnitId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appPackage");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dpPackageName");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appVersion");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "permissionsUrl");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "privacyAgreementUrl");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "developerName");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interactType");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adType");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TraceUrlData.JsonKeyOld.KEY_TRACK_URL);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "landingPageUrl");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "packageUrl");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "logo");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sequence");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "storeChannel");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgWidth");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgHeight");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgUrls");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoUrl");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subTitle");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brand");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appName");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "homePage");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appIntro");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "introUrl");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appIconUrl");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pkgSizeBytes");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installPkgType");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subType");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "promotionPurpose");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adFlag");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "closeFlag");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deeplinkUrl");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "miniProgramType");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "miniProgramId");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "miniProgramPath");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pkgSign");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adSpecTemplateType");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expirationTime");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "responseTimeMillis");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, VideoActivity.EXTRA_KEY_ACTION_TYPE);
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "actionTips");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "targetTips");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "impDuration");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brandFontSize");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adFlagFontSize");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "skipFontSize");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, bf.aT);
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shakeAcc");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shakeDuration");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pkgType");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "landingPageType");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "newLandingPageType");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, OapsKey.KEY_PRICE);
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forwardInterval");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "orientation");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "creativeTemplateId");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "incentiveFlag");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "incentivePoints");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isCarousel");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "detailPageOpenMode");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelInfo");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extraJson");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subChannel");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "detailType");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadType");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, com.alipay.sdk.app.statistic.c.ab);
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ts");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sifSign");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adPositionSets");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataType");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "buttonText");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "uninstalleFilter");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "detailPageCtrl");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wechatExtInfo");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "templateId");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    BaseAdInfo baseAdInfo = new BaseAdInfo();
                    ArrayList arrayList2 = arrayList;
                    int i2 = columnIndexOrThrow13;
                    baseAdInfo.setId(cursorQuery.getLong(columnIndexOrThrow));
                    baseAdInfo.setAdRequestId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    baseAdInfo.setAdUnitId(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    baseAdInfo.setAdId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    baseAdInfo.setAppPackage(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    baseAdInfo.setDpPackageName(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    baseAdInfo.setAppVersion(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    baseAdInfo.setPermissionsUrl(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    baseAdInfo.setPrivacyAgreementUrl(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    baseAdInfo.setDeveloperName(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    baseAdInfo.setInteractType(cursorQuery.getInt(columnIndexOrThrow11));
                    baseAdInfo.setAdType(cursorQuery.getInt(columnIndexOrThrow12));
                    baseAdInfo.setTrackUrl(com.hihonor.adsdk.base.dp.a.hnadse(cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2)));
                    int i3 = i;
                    baseAdInfo.setLandingPageUrl(cursorQuery.isNull(i3) ? null : cursorQuery.getString(i3));
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    baseAdInfo.setPackageUrl(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    int i4 = columnIndexOrThrow16;
                    baseAdInfo.setLogo(cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4));
                    int i5 = columnIndexOrThrow17;
                    baseAdInfo.setSequence(cursorQuery.getInt(i5));
                    int i6 = columnIndexOrThrow18;
                    baseAdInfo.setStoreChannel(cursorQuery.isNull(i6) ? null : cursorQuery.getString(i6));
                    int i7 = columnIndexOrThrow19;
                    baseAdInfo.setImgWidth(cursorQuery.getInt(i7));
                    columnIndexOrThrow19 = i7;
                    int i8 = columnIndexOrThrow20;
                    baseAdInfo.setImgHeight(cursorQuery.getInt(i8));
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    baseAdInfo.setImgUrls(com.hihonor.adsdk.base.dp.a.hnadsc(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21)));
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    baseAdInfo.setVideoUrl(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    baseAdInfo.setTitle(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    baseAdInfo.setSubTitle(cursorQuery.isNull(columnIndexOrThrow24) ? null : cursorQuery.getString(columnIndexOrThrow24));
                    columnIndexOrThrow25 = columnIndexOrThrow25;
                    baseAdInfo.setBrand(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                    columnIndexOrThrow26 = columnIndexOrThrow26;
                    baseAdInfo.setAppName(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                    columnIndexOrThrow27 = columnIndexOrThrow27;
                    baseAdInfo.setHomePage(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    columnIndexOrThrow28 = columnIndexOrThrow28;
                    baseAdInfo.setAppIntro(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    columnIndexOrThrow29 = columnIndexOrThrow29;
                    baseAdInfo.setIntroUrl(cursorQuery.isNull(columnIndexOrThrow29) ? null : cursorQuery.getString(columnIndexOrThrow29));
                    columnIndexOrThrow30 = columnIndexOrThrow30;
                    baseAdInfo.setAppIconUrl(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    int i9 = columnIndexOrThrow31;
                    baseAdInfo.setPkgSizeBytes(cursorQuery.getLong(i9));
                    int i10 = columnIndexOrThrow32;
                    baseAdInfo.setInstallPkgType(cursorQuery.getInt(i10));
                    int i11 = columnIndexOrThrow33;
                    baseAdInfo.setSubType(cursorQuery.getInt(i11));
                    int i12 = columnIndexOrThrow34;
                    baseAdInfo.setPromotionPurpose(cursorQuery.getInt(i12));
                    columnIndexOrThrow34 = i12;
                    int i13 = columnIndexOrThrow35;
                    baseAdInfo.setAdFlag(cursorQuery.getInt(i13));
                    columnIndexOrThrow35 = i13;
                    int i14 = columnIndexOrThrow36;
                    baseAdInfo.setCloseFlag(cursorQuery.getInt(i14));
                    int i15 = columnIndexOrThrow37;
                    baseAdInfo.setDeeplinkUrl(cursorQuery.isNull(i15) ? null : cursorQuery.getString(i15));
                    columnIndexOrThrow38 = columnIndexOrThrow38;
                    baseAdInfo.setStyle(com.hihonor.adsdk.base.dp.a.hnadsd(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getString(columnIndexOrThrow38)));
                    int i16 = columnIndexOrThrow39;
                    baseAdInfo.setMiniProgramType(cursorQuery.getInt(i16));
                    int i17 = columnIndexOrThrow40;
                    baseAdInfo.setMiniProgramId(cursorQuery.isNull(i17) ? null : cursorQuery.getString(i17));
                    columnIndexOrThrow41 = columnIndexOrThrow41;
                    baseAdInfo.setMiniProgramPath(cursorQuery.isNull(columnIndexOrThrow41) ? null : cursorQuery.getString(columnIndexOrThrow41));
                    columnIndexOrThrow42 = columnIndexOrThrow42;
                    baseAdInfo.setPkgSign(cursorQuery.isNull(columnIndexOrThrow42) ? null : cursorQuery.getString(columnIndexOrThrow42));
                    int i18 = columnIndexOrThrow43;
                    baseAdInfo.setAdSpecTemplateType(cursorQuery.getInt(i18));
                    int i19 = columnIndexOrThrow2;
                    int i20 = columnIndexOrThrow44;
                    baseAdInfo.setExpirationTime(cursorQuery.getLong(i20));
                    int i21 = columnIndexOrThrow45;
                    int i22 = columnIndexOrThrow3;
                    baseAdInfo.setResponseTimeMillis(cursorQuery.getLong(i21));
                    int i23 = columnIndexOrThrow46;
                    baseAdInfo.setActionType(cursorQuery.isNull(i23) ? null : cursorQuery.getString(i23));
                    int i24 = columnIndexOrThrow47;
                    baseAdInfo.setActionTips(cursorQuery.isNull(i24) ? null : cursorQuery.getString(i24));
                    columnIndexOrThrow48 = columnIndexOrThrow48;
                    baseAdInfo.setTargetTips(cursorQuery.isNull(columnIndexOrThrow48) ? null : cursorQuery.getString(columnIndexOrThrow48));
                    int i25 = columnIndexOrThrow49;
                    baseAdInfo.setImpDuration(cursorQuery.getInt(i25));
                    columnIndexOrThrow49 = i25;
                    int i26 = columnIndexOrThrow50;
                    baseAdInfo.setBrandFontSize(cursorQuery.getInt(i26));
                    columnIndexOrThrow50 = i26;
                    int i27 = columnIndexOrThrow51;
                    baseAdInfo.setAdFlagFontSize(cursorQuery.getInt(i27));
                    columnIndexOrThrow51 = i27;
                    int i28 = columnIndexOrThrow52;
                    baseAdInfo.setSkipFontSize(cursorQuery.getInt(i28));
                    int i29 = columnIndexOrThrow53;
                    baseAdInfo.setShakeAngle(cursorQuery.getDouble(i29));
                    int i30 = columnIndexOrThrow54;
                    baseAdInfo.setShakeAcc(cursorQuery.getDouble(i30));
                    int i31 = columnIndexOrThrow55;
                    baseAdInfo.setShakeDuration(cursorQuery.getDouble(i31));
                    int i32 = columnIndexOrThrow56;
                    baseAdInfo.setVideo(com.hihonor.adsdk.base.dp.a.hnadsf(cursorQuery.isNull(i32) ? null : cursorQuery.getString(i32)));
                    int i33 = columnIndexOrThrow57;
                    baseAdInfo.setPkgType(cursorQuery.getInt(i33));
                    int i34 = columnIndexOrThrow58;
                    baseAdInfo.setLandingPageType(cursorQuery.getInt(i34));
                    columnIndexOrThrow58 = i34;
                    int i35 = columnIndexOrThrow59;
                    baseAdInfo.setNewLandingPageType(cursorQuery.getInt(i35));
                    int i36 = columnIndexOrThrow60;
                    baseAdInfo.setPrice(cursorQuery.getLong(i36));
                    int i37 = columnIndexOrThrow61;
                    baseAdInfo.setForwardInterval(cursorQuery.getInt(i37));
                    int i38 = columnIndexOrThrow62;
                    baseAdInfo.setOrientation(cursorQuery.getInt(i38));
                    int i39 = columnIndexOrThrow63;
                    baseAdInfo.setCreativeTemplateId(cursorQuery.getInt(i39));
                    columnIndexOrThrow63 = i39;
                    int i40 = columnIndexOrThrow64;
                    baseAdInfo.setIncentiveFlag(cursorQuery.getInt(i40));
                    columnIndexOrThrow65 = columnIndexOrThrow65;
                    baseAdInfo.setIncentivePoints(com.hihonor.adsdk.base.dp.a.hnadsa(cursorQuery.isNull(columnIndexOrThrow65) ? null : cursorQuery.getString(columnIndexOrThrow65)));
                    columnIndexOrThrow64 = i40;
                    int i41 = columnIndexOrThrow66;
                    baseAdInfo.setIsCarousel(cursorQuery.getInt(i41));
                    columnIndexOrThrow66 = i41;
                    int i42 = columnIndexOrThrow67;
                    baseAdInfo.setDetailPageOpenMode(cursorQuery.getInt(i42));
                    columnIndexOrThrow68 = columnIndexOrThrow68;
                    baseAdInfo.setChannelInfo(cursorQuery.isNull(columnIndexOrThrow68) ? null : cursorQuery.getString(columnIndexOrThrow68));
                    columnIndexOrThrow69 = columnIndexOrThrow69;
                    baseAdInfo.setExtraJson(cursorQuery.isNull(columnIndexOrThrow69) ? null : cursorQuery.getString(columnIndexOrThrow69));
                    columnIndexOrThrow70 = columnIndexOrThrow70;
                    baseAdInfo.setSubChannel(cursorQuery.isNull(columnIndexOrThrow70) ? null : cursorQuery.getString(columnIndexOrThrow70));
                    columnIndexOrThrow67 = i42;
                    int i43 = columnIndexOrThrow71;
                    baseAdInfo.setDetailType(cursorQuery.getInt(i43));
                    columnIndexOrThrow71 = i43;
                    int i44 = columnIndexOrThrow72;
                    baseAdInfo.setDownloadType(cursorQuery.getInt(i44));
                    columnIndexOrThrow73 = columnIndexOrThrow73;
                    baseAdInfo.setPartner(cursorQuery.isNull(columnIndexOrThrow73) ? null : cursorQuery.getString(columnIndexOrThrow73));
                    int i45 = columnIndexOrThrow74;
                    baseAdInfo.setTs(cursorQuery.getLong(i45));
                    int i46 = columnIndexOrThrow75;
                    baseAdInfo.setSifSign(cursorQuery.isNull(i46) ? null : cursorQuery.getString(i46));
                    int i47 = columnIndexOrThrow76;
                    baseAdInfo.setAdPositionSets(com.hihonor.adsdk.base.dp.a.hnadsa(cursorQuery.isNull(i47) ? null : cursorQuery.getString(i47)));
                    columnIndexOrThrow75 = i46;
                    int i48 = columnIndexOrThrow77;
                    baseAdInfo.setDataType(cursorQuery.getInt(i48));
                    int i49 = columnIndexOrThrow78;
                    baseAdInfo.setButtonText(cursorQuery.isNull(i49) ? null : cursorQuery.getString(i49));
                    int i50 = columnIndexOrThrow79;
                    baseAdInfo.setUninstalleFilter(cursorQuery.getInt(i50));
                    int i51 = columnIndexOrThrow80;
                    baseAdInfo.setDetailPageCtrl(com.hihonor.adsdk.base.dp.a.hnadsb(cursorQuery.isNull(i51) ? null : cursorQuery.getString(i51)));
                    int i52 = columnIndexOrThrow81;
                    if (cursorQuery.isNull(i52)) {
                        baseAdInfo.wechatExtInfo = null;
                    } else {
                        baseAdInfo.wechatExtInfo = cursorQuery.getString(i52);
                    }
                    int i53 = columnIndexOrThrow82;
                    baseAdInfo.setTemplateId(cursorQuery.isNull(i53) ? null : cursorQuery.getString(i53));
                    arrayList2.add(baseAdInfo);
                    columnIndexOrThrow81 = i52;
                    columnIndexOrThrow82 = i53;
                    arrayList = arrayList2;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow76 = i47;
                    columnIndexOrThrow13 = i2;
                    columnIndexOrThrow16 = i4;
                    i = i3;
                    columnIndexOrThrow20 = i8;
                    columnIndexOrThrow31 = i9;
                    columnIndexOrThrow32 = i10;
                    columnIndexOrThrow33 = i11;
                    columnIndexOrThrow44 = i20;
                    columnIndexOrThrow46 = i23;
                    columnIndexOrThrow54 = i30;
                    columnIndexOrThrow57 = i33;
                    columnIndexOrThrow3 = i22;
                    columnIndexOrThrow45 = i21;
                    columnIndexOrThrow52 = i28;
                    columnIndexOrThrow53 = i29;
                    columnIndexOrThrow56 = i32;
                    columnIndexOrThrow2 = i19;
                    columnIndexOrThrow43 = i18;
                    columnIndexOrThrow47 = i24;
                    columnIndexOrThrow55 = i31;
                    columnIndexOrThrow59 = i35;
                    columnIndexOrThrow60 = i36;
                    columnIndexOrThrow61 = i37;
                    columnIndexOrThrow62 = i38;
                    columnIndexOrThrow72 = i44;
                    columnIndexOrThrow74 = i45;
                    columnIndexOrThrow18 = i6;
                    columnIndexOrThrow17 = i5;
                    columnIndexOrThrow37 = i15;
                    columnIndexOrThrow36 = i14;
                    columnIndexOrThrow40 = i17;
                    columnIndexOrThrow39 = i16;
                    columnIndexOrThrow78 = i49;
                    columnIndexOrThrow77 = i48;
                    columnIndexOrThrow80 = i51;
                    columnIndexOrThrow79 = i50;
                }
                ArrayList arrayList3 = arrayList;
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList3;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.c
    public List<BaseAdInfo> hnadsb(List<String> list) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("select * from BaseAdInfo where adRequestId IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i);
            } else {
                roomSQLiteQueryAcquire.bindString(i, str);
            }
            i++;
        }
        this.hnadsa.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.hnadsa, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adRequestId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adUnitId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appPackage");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dpPackageName");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appVersion");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "permissionsUrl");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "privacyAgreementUrl");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "developerName");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interactType");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adType");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TraceUrlData.JsonKeyOld.KEY_TRACK_URL);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "landingPageUrl");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "packageUrl");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "logo");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sequence");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "storeChannel");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgWidth");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgHeight");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgUrls");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoUrl");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subTitle");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brand");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appName");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "homePage");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appIntro");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "introUrl");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appIconUrl");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pkgSizeBytes");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installPkgType");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subType");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "promotionPurpose");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adFlag");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "closeFlag");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deeplinkUrl");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "miniProgramType");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "miniProgramId");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "miniProgramPath");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pkgSign");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adSpecTemplateType");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expirationTime");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "responseTimeMillis");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, VideoActivity.EXTRA_KEY_ACTION_TYPE);
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "actionTips");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "targetTips");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "impDuration");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brandFontSize");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adFlagFontSize");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "skipFontSize");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, bf.aT);
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shakeAcc");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shakeDuration");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pkgType");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "landingPageType");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "newLandingPageType");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, OapsKey.KEY_PRICE);
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forwardInterval");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "orientation");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "creativeTemplateId");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "incentiveFlag");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "incentivePoints");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isCarousel");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "detailPageOpenMode");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelInfo");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extraJson");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subChannel");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "detailType");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadType");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, com.alipay.sdk.app.statistic.c.ab);
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ts");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sifSign");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adPositionSets");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataType");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "buttonText");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "uninstalleFilter");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "detailPageCtrl");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wechatExtInfo");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "templateId");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    BaseAdInfo baseAdInfo = new BaseAdInfo();
                    int i3 = columnIndexOrThrow11;
                    int i4 = columnIndexOrThrow12;
                    baseAdInfo.setId(cursorQuery.getLong(columnIndexOrThrow));
                    baseAdInfo.setAdRequestId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    baseAdInfo.setAdUnitId(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    baseAdInfo.setAdId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    baseAdInfo.setAppPackage(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    baseAdInfo.setDpPackageName(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    baseAdInfo.setAppVersion(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    baseAdInfo.setPermissionsUrl(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    baseAdInfo.setPrivacyAgreementUrl(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    baseAdInfo.setDeveloperName(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    columnIndexOrThrow11 = i3;
                    baseAdInfo.setInteractType(cursorQuery.getInt(columnIndexOrThrow11));
                    int i5 = columnIndexOrThrow;
                    columnIndexOrThrow12 = i4;
                    baseAdInfo.setAdType(cursorQuery.getInt(columnIndexOrThrow12));
                    baseAdInfo.setTrackUrl(com.hihonor.adsdk.base.dp.a.hnadse(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13)));
                    int i6 = i2;
                    baseAdInfo.setLandingPageUrl(cursorQuery.isNull(i6) ? null : cursorQuery.getString(i6));
                    int i7 = columnIndexOrThrow15;
                    baseAdInfo.setPackageUrl(cursorQuery.isNull(i7) ? null : cursorQuery.getString(i7));
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    baseAdInfo.setLogo(cursorQuery.isNull(columnIndexOrThrow16) ? null : cursorQuery.getString(columnIndexOrThrow16));
                    int i8 = columnIndexOrThrow13;
                    int i9 = columnIndexOrThrow17;
                    baseAdInfo.setSequence(cursorQuery.getInt(i9));
                    int i10 = columnIndexOrThrow18;
                    baseAdInfo.setStoreChannel(cursorQuery.isNull(i10) ? null : cursorQuery.getString(i10));
                    int i11 = columnIndexOrThrow19;
                    baseAdInfo.setImgWidth(cursorQuery.getInt(i11));
                    columnIndexOrThrow19 = i11;
                    int i12 = columnIndexOrThrow20;
                    baseAdInfo.setImgHeight(cursorQuery.getInt(i12));
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    baseAdInfo.setImgUrls(com.hihonor.adsdk.base.dp.a.hnadsc(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21)));
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    baseAdInfo.setVideoUrl(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    baseAdInfo.setTitle(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    baseAdInfo.setSubTitle(cursorQuery.isNull(columnIndexOrThrow24) ? null : cursorQuery.getString(columnIndexOrThrow24));
                    columnIndexOrThrow25 = columnIndexOrThrow25;
                    baseAdInfo.setBrand(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                    columnIndexOrThrow26 = columnIndexOrThrow26;
                    baseAdInfo.setAppName(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                    columnIndexOrThrow27 = columnIndexOrThrow27;
                    baseAdInfo.setHomePage(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    columnIndexOrThrow28 = columnIndexOrThrow28;
                    baseAdInfo.setAppIntro(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    columnIndexOrThrow29 = columnIndexOrThrow29;
                    baseAdInfo.setIntroUrl(cursorQuery.isNull(columnIndexOrThrow29) ? null : cursorQuery.getString(columnIndexOrThrow29));
                    columnIndexOrThrow30 = columnIndexOrThrow30;
                    baseAdInfo.setAppIconUrl(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    int i13 = columnIndexOrThrow2;
                    int i14 = columnIndexOrThrow31;
                    baseAdInfo.setPkgSizeBytes(cursorQuery.getLong(i14));
                    int i15 = columnIndexOrThrow32;
                    baseAdInfo.setInstallPkgType(cursorQuery.getInt(i15));
                    int i16 = columnIndexOrThrow33;
                    baseAdInfo.setSubType(cursorQuery.getInt(i16));
                    int i17 = columnIndexOrThrow34;
                    baseAdInfo.setPromotionPurpose(cursorQuery.getInt(i17));
                    columnIndexOrThrow34 = i17;
                    int i18 = columnIndexOrThrow35;
                    baseAdInfo.setAdFlag(cursorQuery.getInt(i18));
                    columnIndexOrThrow35 = i18;
                    int i19 = columnIndexOrThrow36;
                    baseAdInfo.setCloseFlag(cursorQuery.getInt(i19));
                    int i20 = columnIndexOrThrow37;
                    baseAdInfo.setDeeplinkUrl(cursorQuery.isNull(i20) ? null : cursorQuery.getString(i20));
                    columnIndexOrThrow38 = columnIndexOrThrow38;
                    baseAdInfo.setStyle(com.hihonor.adsdk.base.dp.a.hnadsd(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getString(columnIndexOrThrow38)));
                    int i21 = columnIndexOrThrow39;
                    baseAdInfo.setMiniProgramType(cursorQuery.getInt(i21));
                    int i22 = columnIndexOrThrow40;
                    baseAdInfo.setMiniProgramId(cursorQuery.isNull(i22) ? null : cursorQuery.getString(i22));
                    columnIndexOrThrow41 = columnIndexOrThrow41;
                    baseAdInfo.setMiniProgramPath(cursorQuery.isNull(columnIndexOrThrow41) ? null : cursorQuery.getString(columnIndexOrThrow41));
                    columnIndexOrThrow42 = columnIndexOrThrow42;
                    baseAdInfo.setPkgSign(cursorQuery.isNull(columnIndexOrThrow42) ? null : cursorQuery.getString(columnIndexOrThrow42));
                    int i23 = columnIndexOrThrow43;
                    baseAdInfo.setAdSpecTemplateType(cursorQuery.getInt(i23));
                    int i24 = columnIndexOrThrow3;
                    int i25 = columnIndexOrThrow44;
                    baseAdInfo.setExpirationTime(cursorQuery.getLong(i25));
                    int i26 = columnIndexOrThrow45;
                    int i27 = columnIndexOrThrow4;
                    baseAdInfo.setResponseTimeMillis(cursorQuery.getLong(i26));
                    int i28 = columnIndexOrThrow46;
                    baseAdInfo.setActionType(cursorQuery.isNull(i28) ? null : cursorQuery.getString(i28));
                    int i29 = columnIndexOrThrow47;
                    baseAdInfo.setActionTips(cursorQuery.isNull(i29) ? null : cursorQuery.getString(i29));
                    columnIndexOrThrow48 = columnIndexOrThrow48;
                    baseAdInfo.setTargetTips(cursorQuery.isNull(columnIndexOrThrow48) ? null : cursorQuery.getString(columnIndexOrThrow48));
                    int i30 = columnIndexOrThrow49;
                    baseAdInfo.setImpDuration(cursorQuery.getInt(i30));
                    columnIndexOrThrow49 = i30;
                    int i31 = columnIndexOrThrow50;
                    baseAdInfo.setBrandFontSize(cursorQuery.getInt(i31));
                    columnIndexOrThrow50 = i31;
                    int i32 = columnIndexOrThrow51;
                    baseAdInfo.setAdFlagFontSize(cursorQuery.getInt(i32));
                    columnIndexOrThrow51 = i32;
                    int i33 = columnIndexOrThrow52;
                    baseAdInfo.setSkipFontSize(cursorQuery.getInt(i33));
                    int i34 = columnIndexOrThrow53;
                    baseAdInfo.setShakeAngle(cursorQuery.getDouble(i34));
                    int i35 = columnIndexOrThrow54;
                    baseAdInfo.setShakeAcc(cursorQuery.getDouble(i35));
                    int i36 = columnIndexOrThrow55;
                    baseAdInfo.setShakeDuration(cursorQuery.getDouble(i36));
                    int i37 = columnIndexOrThrow56;
                    baseAdInfo.setVideo(com.hihonor.adsdk.base.dp.a.hnadsf(cursorQuery.isNull(i37) ? null : cursorQuery.getString(i37)));
                    int i38 = columnIndexOrThrow57;
                    baseAdInfo.setPkgType(cursorQuery.getInt(i38));
                    int i39 = columnIndexOrThrow58;
                    baseAdInfo.setLandingPageType(cursorQuery.getInt(i39));
                    columnIndexOrThrow58 = i39;
                    int i40 = columnIndexOrThrow59;
                    baseAdInfo.setNewLandingPageType(cursorQuery.getInt(i40));
                    int i41 = columnIndexOrThrow60;
                    baseAdInfo.setPrice(cursorQuery.getLong(i41));
                    int i42 = columnIndexOrThrow61;
                    baseAdInfo.setForwardInterval(cursorQuery.getInt(i42));
                    int i43 = columnIndexOrThrow62;
                    baseAdInfo.setOrientation(cursorQuery.getInt(i43));
                    int i44 = columnIndexOrThrow63;
                    baseAdInfo.setCreativeTemplateId(cursorQuery.getInt(i44));
                    columnIndexOrThrow63 = i44;
                    int i45 = columnIndexOrThrow64;
                    baseAdInfo.setIncentiveFlag(cursorQuery.getInt(i45));
                    columnIndexOrThrow65 = columnIndexOrThrow65;
                    baseAdInfo.setIncentivePoints(com.hihonor.adsdk.base.dp.a.hnadsa(cursorQuery.isNull(columnIndexOrThrow65) ? null : cursorQuery.getString(columnIndexOrThrow65)));
                    columnIndexOrThrow64 = i45;
                    int i46 = columnIndexOrThrow66;
                    baseAdInfo.setIsCarousel(cursorQuery.getInt(i46));
                    columnIndexOrThrow66 = i46;
                    int i47 = columnIndexOrThrow67;
                    baseAdInfo.setDetailPageOpenMode(cursorQuery.getInt(i47));
                    columnIndexOrThrow68 = columnIndexOrThrow68;
                    baseAdInfo.setChannelInfo(cursorQuery.isNull(columnIndexOrThrow68) ? null : cursorQuery.getString(columnIndexOrThrow68));
                    columnIndexOrThrow69 = columnIndexOrThrow69;
                    baseAdInfo.setExtraJson(cursorQuery.isNull(columnIndexOrThrow69) ? null : cursorQuery.getString(columnIndexOrThrow69));
                    columnIndexOrThrow70 = columnIndexOrThrow70;
                    baseAdInfo.setSubChannel(cursorQuery.isNull(columnIndexOrThrow70) ? null : cursorQuery.getString(columnIndexOrThrow70));
                    columnIndexOrThrow67 = i47;
                    int i48 = columnIndexOrThrow71;
                    baseAdInfo.setDetailType(cursorQuery.getInt(i48));
                    columnIndexOrThrow71 = i48;
                    int i49 = columnIndexOrThrow72;
                    baseAdInfo.setDownloadType(cursorQuery.getInt(i49));
                    columnIndexOrThrow73 = columnIndexOrThrow73;
                    baseAdInfo.setPartner(cursorQuery.isNull(columnIndexOrThrow73) ? null : cursorQuery.getString(columnIndexOrThrow73));
                    int i50 = columnIndexOrThrow74;
                    baseAdInfo.setTs(cursorQuery.getLong(i50));
                    int i51 = columnIndexOrThrow75;
                    baseAdInfo.setSifSign(cursorQuery.isNull(i51) ? null : cursorQuery.getString(i51));
                    int i52 = columnIndexOrThrow76;
                    baseAdInfo.setAdPositionSets(com.hihonor.adsdk.base.dp.a.hnadsa(cursorQuery.isNull(i52) ? null : cursorQuery.getString(i52)));
                    columnIndexOrThrow75 = i51;
                    int i53 = columnIndexOrThrow77;
                    baseAdInfo.setDataType(cursorQuery.getInt(i53));
                    int i54 = columnIndexOrThrow78;
                    baseAdInfo.setButtonText(cursorQuery.isNull(i54) ? null : cursorQuery.getString(i54));
                    int i55 = columnIndexOrThrow79;
                    baseAdInfo.setUninstalleFilter(cursorQuery.getInt(i55));
                    int i56 = columnIndexOrThrow80;
                    baseAdInfo.setDetailPageCtrl(com.hihonor.adsdk.base.dp.a.hnadsb(cursorQuery.isNull(i56) ? null : cursorQuery.getString(i56)));
                    int i57 = columnIndexOrThrow81;
                    if (cursorQuery.isNull(i57)) {
                        baseAdInfo.wechatExtInfo = null;
                    } else {
                        baseAdInfo.wechatExtInfo = cursorQuery.getString(i57);
                    }
                    int i58 = columnIndexOrThrow82;
                    baseAdInfo.setTemplateId(cursorQuery.isNull(i58) ? null : cursorQuery.getString(i58));
                    arrayList.add(baseAdInfo);
                    columnIndexOrThrow81 = i57;
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow82 = i58;
                    columnIndexOrThrow13 = i8;
                    columnIndexOrThrow15 = i7;
                    i2 = i6;
                    columnIndexOrThrow76 = i52;
                    columnIndexOrThrow2 = i13;
                    columnIndexOrThrow20 = i12;
                    columnIndexOrThrow31 = i14;
                    columnIndexOrThrow32 = i15;
                    columnIndexOrThrow33 = i16;
                    columnIndexOrThrow44 = i25;
                    columnIndexOrThrow46 = i28;
                    columnIndexOrThrow54 = i35;
                    columnIndexOrThrow57 = i38;
                    columnIndexOrThrow4 = i27;
                    columnIndexOrThrow45 = i26;
                    columnIndexOrThrow52 = i33;
                    columnIndexOrThrow53 = i34;
                    columnIndexOrThrow56 = i37;
                    columnIndexOrThrow3 = i24;
                    columnIndexOrThrow43 = i23;
                    columnIndexOrThrow47 = i29;
                    columnIndexOrThrow55 = i36;
                    columnIndexOrThrow59 = i40;
                    columnIndexOrThrow60 = i41;
                    columnIndexOrThrow61 = i42;
                    columnIndexOrThrow62 = i43;
                    columnIndexOrThrow72 = i49;
                    columnIndexOrThrow74 = i50;
                    columnIndexOrThrow18 = i10;
                    columnIndexOrThrow17 = i9;
                    columnIndexOrThrow37 = i20;
                    columnIndexOrThrow36 = i19;
                    columnIndexOrThrow40 = i22;
                    columnIndexOrThrow39 = i21;
                    columnIndexOrThrow78 = i54;
                    columnIndexOrThrow77 = i53;
                    columnIndexOrThrow80 = i56;
                    columnIndexOrThrow79 = i55;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.c
    public List<BaseAdInfo> hnadsa(long j) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from BaseAdInfo where expirationTime * 1000 < ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.hnadsa.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.hnadsa, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adRequestId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adUnitId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appPackage");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dpPackageName");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appVersion");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "permissionsUrl");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "privacyAgreementUrl");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "developerName");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interactType");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adType");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TraceUrlData.JsonKeyOld.KEY_TRACK_URL);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "landingPageUrl");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "packageUrl");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "logo");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sequence");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "storeChannel");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgWidth");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgHeight");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgUrls");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videoUrl");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subTitle");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brand");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appName");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "homePage");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appIntro");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "introUrl");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "appIconUrl");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pkgSizeBytes");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "installPkgType");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subType");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "promotionPurpose");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adFlag");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "closeFlag");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deeplinkUrl");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "style");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "miniProgramType");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "miniProgramId");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "miniProgramPath");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pkgSign");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adSpecTemplateType");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "expirationTime");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "responseTimeMillis");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, VideoActivity.EXTRA_KEY_ACTION_TYPE);
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "actionTips");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "targetTips");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "impDuration");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brandFontSize");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adFlagFontSize");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "skipFontSize");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, bf.aT);
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shakeAcc");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "shakeDuration");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "video");
                int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pkgType");
                int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "landingPageType");
                int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "newLandingPageType");
                int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, OapsKey.KEY_PRICE);
                int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "forwardInterval");
                int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "orientation");
                int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "creativeTemplateId");
                int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "incentiveFlag");
                int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "incentivePoints");
                int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isCarousel");
                int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "detailPageOpenMode");
                int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelInfo");
                int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extraJson");
                int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "subChannel");
                int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "detailType");
                int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "downloadType");
                int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, com.alipay.sdk.app.statistic.c.ab);
                int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ts");
                int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sifSign");
                int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adPositionSets");
                int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "dataType");
                int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "buttonText");
                int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "uninstalleFilter");
                int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "detailPageCtrl");
                int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "wechatExtInfo");
                int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "templateId");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    BaseAdInfo baseAdInfo = new BaseAdInfo();
                    ArrayList arrayList2 = arrayList;
                    int i2 = columnIndexOrThrow13;
                    baseAdInfo.setId(cursorQuery.getLong(columnIndexOrThrow));
                    baseAdInfo.setAdRequestId(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    baseAdInfo.setAdUnitId(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    baseAdInfo.setAdId(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    baseAdInfo.setAppPackage(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    baseAdInfo.setDpPackageName(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    baseAdInfo.setAppVersion(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    baseAdInfo.setPermissionsUrl(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    baseAdInfo.setPrivacyAgreementUrl(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    baseAdInfo.setDeveloperName(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    baseAdInfo.setInteractType(cursorQuery.getInt(columnIndexOrThrow11));
                    baseAdInfo.setAdType(cursorQuery.getInt(columnIndexOrThrow12));
                    baseAdInfo.setTrackUrl(com.hihonor.adsdk.base.dp.a.hnadse(cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2)));
                    int i3 = i;
                    baseAdInfo.setLandingPageUrl(cursorQuery.isNull(i3) ? null : cursorQuery.getString(i3));
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    baseAdInfo.setPackageUrl(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    int i4 = columnIndexOrThrow16;
                    baseAdInfo.setLogo(cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4));
                    int i5 = columnIndexOrThrow17;
                    baseAdInfo.setSequence(cursorQuery.getInt(i5));
                    int i6 = columnIndexOrThrow18;
                    baseAdInfo.setStoreChannel(cursorQuery.isNull(i6) ? null : cursorQuery.getString(i6));
                    int i7 = columnIndexOrThrow19;
                    baseAdInfo.setImgWidth(cursorQuery.getInt(i7));
                    columnIndexOrThrow19 = i7;
                    int i8 = columnIndexOrThrow20;
                    baseAdInfo.setImgHeight(cursorQuery.getInt(i8));
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    baseAdInfo.setImgUrls(com.hihonor.adsdk.base.dp.a.hnadsc(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21)));
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    baseAdInfo.setVideoUrl(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    baseAdInfo.setTitle(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    baseAdInfo.setSubTitle(cursorQuery.isNull(columnIndexOrThrow24) ? null : cursorQuery.getString(columnIndexOrThrow24));
                    columnIndexOrThrow25 = columnIndexOrThrow25;
                    baseAdInfo.setBrand(cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getString(columnIndexOrThrow25));
                    columnIndexOrThrow26 = columnIndexOrThrow26;
                    baseAdInfo.setAppName(cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26));
                    columnIndexOrThrow27 = columnIndexOrThrow27;
                    baseAdInfo.setHomePage(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    columnIndexOrThrow28 = columnIndexOrThrow28;
                    baseAdInfo.setAppIntro(cursorQuery.isNull(columnIndexOrThrow28) ? null : cursorQuery.getString(columnIndexOrThrow28));
                    columnIndexOrThrow29 = columnIndexOrThrow29;
                    baseAdInfo.setIntroUrl(cursorQuery.isNull(columnIndexOrThrow29) ? null : cursorQuery.getString(columnIndexOrThrow29));
                    columnIndexOrThrow30 = columnIndexOrThrow30;
                    baseAdInfo.setAppIconUrl(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    int i9 = columnIndexOrThrow31;
                    baseAdInfo.setPkgSizeBytes(cursorQuery.getLong(i9));
                    int i10 = columnIndexOrThrow32;
                    baseAdInfo.setInstallPkgType(cursorQuery.getInt(i10));
                    int i11 = columnIndexOrThrow33;
                    baseAdInfo.setSubType(cursorQuery.getInt(i11));
                    int i12 = columnIndexOrThrow34;
                    baseAdInfo.setPromotionPurpose(cursorQuery.getInt(i12));
                    columnIndexOrThrow34 = i12;
                    int i13 = columnIndexOrThrow35;
                    baseAdInfo.setAdFlag(cursorQuery.getInt(i13));
                    columnIndexOrThrow35 = i13;
                    int i14 = columnIndexOrThrow36;
                    baseAdInfo.setCloseFlag(cursorQuery.getInt(i14));
                    int i15 = columnIndexOrThrow37;
                    baseAdInfo.setDeeplinkUrl(cursorQuery.isNull(i15) ? null : cursorQuery.getString(i15));
                    columnIndexOrThrow38 = columnIndexOrThrow38;
                    baseAdInfo.setStyle(com.hihonor.adsdk.base.dp.a.hnadsd(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getString(columnIndexOrThrow38)));
                    int i16 = columnIndexOrThrow39;
                    baseAdInfo.setMiniProgramType(cursorQuery.getInt(i16));
                    int i17 = columnIndexOrThrow40;
                    baseAdInfo.setMiniProgramId(cursorQuery.isNull(i17) ? null : cursorQuery.getString(i17));
                    columnIndexOrThrow41 = columnIndexOrThrow41;
                    baseAdInfo.setMiniProgramPath(cursorQuery.isNull(columnIndexOrThrow41) ? null : cursorQuery.getString(columnIndexOrThrow41));
                    columnIndexOrThrow42 = columnIndexOrThrow42;
                    baseAdInfo.setPkgSign(cursorQuery.isNull(columnIndexOrThrow42) ? null : cursorQuery.getString(columnIndexOrThrow42));
                    int i18 = columnIndexOrThrow43;
                    baseAdInfo.setAdSpecTemplateType(cursorQuery.getInt(i18));
                    int i19 = columnIndexOrThrow2;
                    int i20 = columnIndexOrThrow44;
                    baseAdInfo.setExpirationTime(cursorQuery.getLong(i20));
                    int i21 = columnIndexOrThrow45;
                    int i22 = columnIndexOrThrow3;
                    baseAdInfo.setResponseTimeMillis(cursorQuery.getLong(i21));
                    int i23 = columnIndexOrThrow46;
                    baseAdInfo.setActionType(cursorQuery.isNull(i23) ? null : cursorQuery.getString(i23));
                    int i24 = columnIndexOrThrow47;
                    baseAdInfo.setActionTips(cursorQuery.isNull(i24) ? null : cursorQuery.getString(i24));
                    columnIndexOrThrow48 = columnIndexOrThrow48;
                    baseAdInfo.setTargetTips(cursorQuery.isNull(columnIndexOrThrow48) ? null : cursorQuery.getString(columnIndexOrThrow48));
                    int i25 = columnIndexOrThrow49;
                    baseAdInfo.setImpDuration(cursorQuery.getInt(i25));
                    columnIndexOrThrow49 = i25;
                    int i26 = columnIndexOrThrow50;
                    baseAdInfo.setBrandFontSize(cursorQuery.getInt(i26));
                    columnIndexOrThrow50 = i26;
                    int i27 = columnIndexOrThrow51;
                    baseAdInfo.setAdFlagFontSize(cursorQuery.getInt(i27));
                    columnIndexOrThrow51 = i27;
                    int i28 = columnIndexOrThrow52;
                    baseAdInfo.setSkipFontSize(cursorQuery.getInt(i28));
                    int i29 = columnIndexOrThrow53;
                    baseAdInfo.setShakeAngle(cursorQuery.getDouble(i29));
                    int i30 = columnIndexOrThrow54;
                    baseAdInfo.setShakeAcc(cursorQuery.getDouble(i30));
                    int i31 = columnIndexOrThrow55;
                    baseAdInfo.setShakeDuration(cursorQuery.getDouble(i31));
                    int i32 = columnIndexOrThrow56;
                    baseAdInfo.setVideo(com.hihonor.adsdk.base.dp.a.hnadsf(cursorQuery.isNull(i32) ? null : cursorQuery.getString(i32)));
                    int i33 = columnIndexOrThrow57;
                    baseAdInfo.setPkgType(cursorQuery.getInt(i33));
                    int i34 = columnIndexOrThrow58;
                    baseAdInfo.setLandingPageType(cursorQuery.getInt(i34));
                    columnIndexOrThrow58 = i34;
                    int i35 = columnIndexOrThrow59;
                    baseAdInfo.setNewLandingPageType(cursorQuery.getInt(i35));
                    int i36 = columnIndexOrThrow60;
                    baseAdInfo.setPrice(cursorQuery.getLong(i36));
                    int i37 = columnIndexOrThrow61;
                    baseAdInfo.setForwardInterval(cursorQuery.getInt(i37));
                    int i38 = columnIndexOrThrow62;
                    baseAdInfo.setOrientation(cursorQuery.getInt(i38));
                    int i39 = columnIndexOrThrow63;
                    baseAdInfo.setCreativeTemplateId(cursorQuery.getInt(i39));
                    columnIndexOrThrow63 = i39;
                    int i40 = columnIndexOrThrow64;
                    baseAdInfo.setIncentiveFlag(cursorQuery.getInt(i40));
                    columnIndexOrThrow65 = columnIndexOrThrow65;
                    baseAdInfo.setIncentivePoints(com.hihonor.adsdk.base.dp.a.hnadsa(cursorQuery.isNull(columnIndexOrThrow65) ? null : cursorQuery.getString(columnIndexOrThrow65)));
                    columnIndexOrThrow64 = i40;
                    int i41 = columnIndexOrThrow66;
                    baseAdInfo.setIsCarousel(cursorQuery.getInt(i41));
                    columnIndexOrThrow66 = i41;
                    int i42 = columnIndexOrThrow67;
                    baseAdInfo.setDetailPageOpenMode(cursorQuery.getInt(i42));
                    columnIndexOrThrow68 = columnIndexOrThrow68;
                    baseAdInfo.setChannelInfo(cursorQuery.isNull(columnIndexOrThrow68) ? null : cursorQuery.getString(columnIndexOrThrow68));
                    columnIndexOrThrow69 = columnIndexOrThrow69;
                    baseAdInfo.setExtraJson(cursorQuery.isNull(columnIndexOrThrow69) ? null : cursorQuery.getString(columnIndexOrThrow69));
                    columnIndexOrThrow70 = columnIndexOrThrow70;
                    baseAdInfo.setSubChannel(cursorQuery.isNull(columnIndexOrThrow70) ? null : cursorQuery.getString(columnIndexOrThrow70));
                    columnIndexOrThrow67 = i42;
                    int i43 = columnIndexOrThrow71;
                    baseAdInfo.setDetailType(cursorQuery.getInt(i43));
                    columnIndexOrThrow71 = i43;
                    int i44 = columnIndexOrThrow72;
                    baseAdInfo.setDownloadType(cursorQuery.getInt(i44));
                    columnIndexOrThrow73 = columnIndexOrThrow73;
                    baseAdInfo.setPartner(cursorQuery.isNull(columnIndexOrThrow73) ? null : cursorQuery.getString(columnIndexOrThrow73));
                    int i45 = columnIndexOrThrow74;
                    baseAdInfo.setTs(cursorQuery.getLong(i45));
                    int i46 = columnIndexOrThrow75;
                    baseAdInfo.setSifSign(cursorQuery.isNull(i46) ? null : cursorQuery.getString(i46));
                    int i47 = columnIndexOrThrow76;
                    baseAdInfo.setAdPositionSets(com.hihonor.adsdk.base.dp.a.hnadsa(cursorQuery.isNull(i47) ? null : cursorQuery.getString(i47)));
                    columnIndexOrThrow75 = i46;
                    int i48 = columnIndexOrThrow77;
                    baseAdInfo.setDataType(cursorQuery.getInt(i48));
                    int i49 = columnIndexOrThrow78;
                    baseAdInfo.setButtonText(cursorQuery.isNull(i49) ? null : cursorQuery.getString(i49));
                    int i50 = columnIndexOrThrow79;
                    baseAdInfo.setUninstalleFilter(cursorQuery.getInt(i50));
                    int i51 = columnIndexOrThrow80;
                    baseAdInfo.setDetailPageCtrl(com.hihonor.adsdk.base.dp.a.hnadsb(cursorQuery.isNull(i51) ? null : cursorQuery.getString(i51)));
                    int i52 = columnIndexOrThrow81;
                    if (cursorQuery.isNull(i52)) {
                        baseAdInfo.wechatExtInfo = null;
                    } else {
                        baseAdInfo.wechatExtInfo = cursorQuery.getString(i52);
                    }
                    int i53 = columnIndexOrThrow82;
                    baseAdInfo.setTemplateId(cursorQuery.isNull(i53) ? null : cursorQuery.getString(i53));
                    arrayList2.add(baseAdInfo);
                    columnIndexOrThrow81 = i52;
                    columnIndexOrThrow82 = i53;
                    arrayList = arrayList2;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow76 = i47;
                    columnIndexOrThrow13 = i2;
                    columnIndexOrThrow16 = i4;
                    i = i3;
                    columnIndexOrThrow20 = i8;
                    columnIndexOrThrow31 = i9;
                    columnIndexOrThrow32 = i10;
                    columnIndexOrThrow33 = i11;
                    columnIndexOrThrow44 = i20;
                    columnIndexOrThrow46 = i23;
                    columnIndexOrThrow54 = i30;
                    columnIndexOrThrow57 = i33;
                    columnIndexOrThrow3 = i22;
                    columnIndexOrThrow45 = i21;
                    columnIndexOrThrow52 = i28;
                    columnIndexOrThrow53 = i29;
                    columnIndexOrThrow56 = i32;
                    columnIndexOrThrow2 = i19;
                    columnIndexOrThrow43 = i18;
                    columnIndexOrThrow47 = i24;
                    columnIndexOrThrow55 = i31;
                    columnIndexOrThrow59 = i35;
                    columnIndexOrThrow60 = i36;
                    columnIndexOrThrow61 = i37;
                    columnIndexOrThrow62 = i38;
                    columnIndexOrThrow72 = i44;
                    columnIndexOrThrow74 = i45;
                    columnIndexOrThrow18 = i6;
                    columnIndexOrThrow17 = i5;
                    columnIndexOrThrow37 = i15;
                    columnIndexOrThrow36 = i14;
                    columnIndexOrThrow40 = i17;
                    columnIndexOrThrow39 = i16;
                    columnIndexOrThrow78 = i49;
                    columnIndexOrThrow77 = i48;
                    columnIndexOrThrow80 = i51;
                    columnIndexOrThrow79 = i50;
                }
                ArrayList arrayList3 = arrayList;
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList3;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public static List<Class<?>> hnadsa() {
        return Collections.emptyList();
    }
}
