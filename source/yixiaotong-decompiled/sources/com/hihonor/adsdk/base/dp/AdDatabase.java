package com.hihonor.adsdk.base.dp;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.cdo.oaps.ad.OapsKey;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.g.j.d.x;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class AdDatabase extends RoomDatabase {
    private static final String hnadsa = "AdDatabase";
    private static final String hnadsb = "AdSdk.db";
    private static volatile AdDatabase hnadsc;
    private static final Migration hnadsd = new a(1, 2);
    private static final Migration hnadse = new b(2, 3);
    private static final Migration hnadsf = new c(3, 4);
    private static final Migration hnadsg = new d(4, 5);

    class a extends Migration {
        a(int i, int i2) {
            super(i, i2);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            try {
                if (!com.hihonor.adsdk.base.j.d.hnadsa(supportSQLiteDatabase, "AdTrack", "method").booleanValue()) {
                    supportSQLiteDatabase.execSQL("ALTER TABLE `AdTrack` add column `method` TEXT");
                }
                if (!com.hihonor.adsdk.base.j.d.hnadsa(supportSQLiteDatabase, "AdTrack", TtmlNode.TAG_BODY).booleanValue()) {
                    supportSQLiteDatabase.execSQL("ALTER TABLE `AdTrack` add column `body` TEXT");
                }
                if (com.hihonor.adsdk.base.j.d.hnadsa(supportSQLiteDatabase, "AdTrack", "headers").booleanValue()) {
                    return;
                }
                supportSQLiteDatabase.execSQL("ALTER TABLE `AdTrack` add column `headers` TEXT");
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsb(AdDatabase.hnadsa, "migrate, Exception:  " + e.getMessage(), new Object[0]);
                new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.DB_UPDATE_ERROR, e.getMessage()).hnadse();
            }
        }
    }

    class b extends Migration {
        b(int i, int i2) {
            super(i, i2);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            com.hihonor.adsdk.common.b.b.hnadsc(AdDatabase.hnadsa, "Migration MIGRATION_2_3", new Object[0]);
            try {
                supportSQLiteDatabase.execSQL("CREATE TABLE if not exists BaseAdInfo (id INTEGER NOT NULL, adRequestId TEXT, adUnitId TEXT, adId TEXT, appPackage TEXT, appVersion TEXT,permissionsUrl TEXT, privacyAgreementUrl TEXT, developerName TEXT, interactType INTEGER NOT NULL,adType INTEGER NOT NULL, trackUrl TEXT, landingPageUrl TEXT, packageUrl TEXT, logo TEXT,sequence INTEGER NOT NULL, storeChannel TEXT , imgWidth INTEGER NOT NULL, imgHeight INTEGER NOT NULL,imgUrls TEXT, videoUrl TEXT, title TEXT, subTitle TEXT, brand TEXT, appName TEXT, homePage TEXT,appIconUrl TEXT, pkgSizeBytes INTEGER NOT NULL, installPkgType INTEGER NOT NULL, subType INTEGER NOT NULL,promotionPurpose INTEGER NOT NULL, adFlag INTEGER NOT NULL, closeFlag INTEGER NOT NULL, deeplinkUrl TEXT, style TEXT, miniProgramType INTEGER NOT NULL, miniProgramId TEXT, miniProgramPath TEXT, pkgSign TEXT,adSpecTemplateType INTEGER NOT NULL, expirationTime INTEGER NOT NULL, responseTimeMillis INTEGER NOT NULL, actionType TEXT, actionTips TEXT, targetTips TEXT, impDuration INTEGER NOT NULL, brandFontSize INTEGER NOT NULL, adFlagFontSize INTEGER NOT NULL, skipFontSize INTEGER NOT NULL, shakeAngle REAL NOT NULL, shakeAcc REAL NOT NULL, shakeDuration REAL NOT NULL,PRIMARY KEY(id))");
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsb(AdDatabase.hnadsa, "migrate, execSQL error, Exception:  " + e.getMessage(), new Object[0]);
                new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.DB_UPDATE_ERROR, e.getMessage()).hnadse();
            }
        }
    }

    class c extends Migration {
        c(int i, int i2) {
            super(i, i2);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            try {
                if (!com.hihonor.adsdk.base.j.d.hnadsa(supportSQLiteDatabase, "BaseAdInfo", "video").booleanValue()) {
                    supportSQLiteDatabase.execSQL("ALTER TABLE `BaseAdInfo` add column `video` TEXT");
                }
                if (com.hihonor.adsdk.base.j.d.hnadsa(supportSQLiteDatabase, "BaseAdInfo", "pkgType").booleanValue()) {
                    return;
                }
                supportSQLiteDatabase.execSQL("ALTER TABLE `BaseAdInfo` add column `pkgType` INTEGER NOT NULL DEFAULT 0");
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsb(AdDatabase.hnadsa, "migrate, Error in database update, Exception: " + e.getMessage(), new Object[0]);
                new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.DB_UPDATE_ERROR, e.getMessage()).hnadse();
            }
        }
    }

    class d extends Migration {
        d(int i, int i2) {
            super(i, i2);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            try {
                if (!com.hihonor.adsdk.base.j.d.hnadsa(supportSQLiteDatabase, "BaseAdInfo", OapsKey.KEY_PRICE).booleanValue()) {
                    supportSQLiteDatabase.execSQL("ALTER TABLE `BaseAdInfo` add column `price` INTEGER NOT NULL DEFAULT 0");
                }
                if (!com.hihonor.adsdk.base.j.d.hnadsa(supportSQLiteDatabase, "BaseAdInfo", "landingPageType").booleanValue()) {
                    supportSQLiteDatabase.execSQL("ALTER TABLE `BaseAdInfo` add column `landingPageType` INTEGER NOT NULL DEFAULT 0");
                }
                if (!com.hihonor.adsdk.base.j.d.hnadsa(supportSQLiteDatabase, "BaseAdInfo", "forwardInterval").booleanValue()) {
                    supportSQLiteDatabase.execSQL("ALTER TABLE `BaseAdInfo` add column `forwardInterval` INTEGER NOT NULL DEFAULT 0");
                }
                if (com.hihonor.adsdk.base.j.d.hnadsa(supportSQLiteDatabase, "BaseAdInfo", "orientation").booleanValue()) {
                    return;
                }
                supportSQLiteDatabase.execSQL("ALTER TABLE `BaseAdInfo` add column `orientation` INTEGER NOT NULL DEFAULT 0");
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsb(AdDatabase.hnadsa, "migrate, Error in database update, Exception: " + e.getMessage(), new Object[0]);
                new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.DB_UPDATE_ERROR, e.getMessage()).hnadse();
            }
        }
    }

    public abstract com.hihonor.adsdk.base.dp.b.a hnadsa();

    public abstract com.hihonor.adsdk.base.dp.b.c hnadsb();

    public static AdDatabase hnadsa(Context context) {
        try {
            if (hnadsc == null) {
                synchronized (AdDatabase.class) {
                    if (hnadsc == null) {
                        hnadsc = (AdDatabase) Room.databaseBuilder(StubApp.getOrigApplicationContext(context.getApplicationContext()), AdDatabase.class, hnadsb).fallbackToDestructiveMigration().allowMainThreadQueries().build();
                    }
                }
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "get, Room databaseBuilder error, Exception:  " + e.getMessage(), new Object[0]);
            new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.DB_CREATE_ERROR, e.getMessage()).hnadse();
        }
        return hnadsc;
    }
}
