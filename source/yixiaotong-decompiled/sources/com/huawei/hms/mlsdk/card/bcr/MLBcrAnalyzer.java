package com.huawei.hms.mlsdk.card.bcr;

import android.graphics.Point;
import android.util.SparseArray;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorBorderParcel;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorBorderPointParcel;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorOptionsParcel;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorParcel;
import com.huawei.hms.mlplugin.card.bcr.dynamic.RemoteBcrDecoder;
import com.huawei.hms.mlsdk.common.AppSettingHolder;
import com.huawei.hms.mlsdk.common.BitmapUtils;
import com.huawei.hms.mlsdk.common.MLAnalyzer;
import com.huawei.hms.mlsdk.common.MLApplication;
import com.huawei.hms.mlsdk.common.MLFrame;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class MLBcrAnalyzer extends MLAnalyzer<MLBankCard> {
    private static final String TAG = "MLBcrAnalyzer";
    private static Map<AppSettingHolder<MLBcrAnalyzerSetting>, MLBcrAnalyzer> appOptionDetectMap = new HashMap();
    private MLApplication app;
    private MLBcrAnalyzerSetting setting;

    public static synchronized MLBcrAnalyzer create(MLApplication mLApplication, MLBcrAnalyzerSetting mLBcrAnalyzerSetting) {
        MLBcrAnalyzer mLBcrAnalyzer;
        AppSettingHolder<MLBcrAnalyzerSetting> appSettingHolderCreate = AppSettingHolder.create(mLApplication.getUniqueKey(), mLBcrAnalyzerSetting);
        mLBcrAnalyzer = appOptionDetectMap.get(appSettingHolderCreate);
        if (mLBcrAnalyzer == null) {
            mLBcrAnalyzer = new MLBcrAnalyzer(mLApplication, mLBcrAnalyzerSetting);
            appOptionDetectMap.put(appSettingHolderCreate, mLBcrAnalyzer);
        }
        RemoteBcrDecoder.getInstance().prepare(mLApplication.getAppContext());
        RemoteBcrDecoder.getInstance().initial(mLApplication.getAppContext(), new BcrDetectorOptionsParcel(mLBcrAnalyzerSetting.getLangType(), mLApplication.toBundle(), mLBcrAnalyzerSetting.getRecType(), mLBcrAnalyzerSetting.getRecMode(), mLBcrAnalyzerSetting.getResultType()));
        return mLBcrAnalyzer;
    }

    private MLBcrAnalyzer(MLApplication mLApplication, MLBcrAnalyzerSetting mLBcrAnalyzerSetting) {
        this.app = mLApplication;
        this.setting = mLBcrAnalyzerSetting;
    }

    public Task<MLBankCard> asyncAnalyseFrame(MLFrame mLFrame) {
        if (mLFrame == null) {
            throw new IllegalArgumentException("frame can not be null");
        }
        mLFrame.initialize();
        final MLFrame frame = mLFrame.getFrame(false, true);
        final BcrDetectorOptionsParcel bcrDetectorOptionsParcel = new BcrDetectorOptionsParcel(this.setting.getLangType(), this.app.toBundle(), this.setting.getRecType(), this.setting.getRecMode(), this.setting.getResultType());
        return Tasks.callInBackground(new Callable<MLBankCard>() { // from class: com.huawei.hms.mlsdk.card.bcr.MLBcrAnalyzer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public MLBankCard call() throws Exception {
                return MLBcrAnalyzer.convert(RemoteBcrDecoder.getInstance().detect(MLBcrAnalyzer.this.app.getAppContext(), MLBcrAnalyzer.this.app.toBundle(), frame, bcrDetectorOptionsParcel));
            }
        });
    }

    @Override // com.huawei.hms.mlsdk.common.MLAnalyzer
    public SparseArray<MLBankCard> analyseFrame(MLFrame mLFrame) {
        if (mLFrame == null) {
            throw new IllegalArgumentException("frame can not be null");
        }
        mLFrame.initialize();
        MLFrame frame = mLFrame.getFrame(false, true);
        BcrDetectorOptionsParcel bcrDetectorOptionsParcel = new BcrDetectorOptionsParcel(this.setting.getLangType(), this.app.toBundle(), this.setting.getRecType(), this.setting.getRecMode(), this.setting.getResultType());
        BcrDetectorParcel bcrDetectorParcelDetect = RemoteBcrDecoder.getInstance().detect(this.app.getAppContext(), this.app.toBundle(), frame, bcrDetectorOptionsParcel);
        SparseArray<MLBankCard> sparseArray = new SparseArray<>();
        sparseArray.put(0, convert(bcrDetectorParcelDetect));
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MLBankCard convert(BcrDetectorParcel bcrDetectorParcel) {
        MLBankCard mLBankCard = new MLBankCard();
        if (bcrDetectorParcel == null) {
            return mLBankCard;
        }
        if (bcrDetectorParcel.retCode != 0) {
            mLBankCard.setTipsCode(bcrDetectorParcel.tipsCode);
            mLBankCard.setRetCode(bcrDetectorParcel.retCode);
            return mLBankCard;
        }
        mLBankCard.setNumber(bcrDetectorParcel.cardNumber);
        mLBankCard.setIssuer(bcrDetectorParcel.cardIssuer);
        mLBankCard.setExpire(bcrDetectorParcel.cardExpire);
        mLBankCard.setOwner(bcrDetectorParcel.cardOwner);
        mLBankCard.setType(bcrDetectorParcel.cardType);
        mLBankCard.setOrganization(bcrDetectorParcel.cardOrganization);
        mLBankCard.setRetCode(0);
        mLBankCard.setTipsCode(bcrDetectorParcel.tipsCode);
        mLBankCard.setOriginalBitmap(bcrDetectorParcel.original);
        mLBankCard.setCorrectBitmap(bcrDetectorParcel.correct);
        BcrDetectorBorderParcel bcrDetectorBorderParcel = bcrDetectorParcel.border;
        if (bcrDetectorBorderParcel != null) {
            mLBankCard.addBorder(1, convert(bcrDetectorBorderParcel.cardNumber));
            mLBankCard.addBorder(3, convert(bcrDetectorBorderParcel.cardIssuer));
            mLBankCard.addBorder(2, convert(bcrDetectorBorderParcel.cardExpire));
            mLBankCard.addBorder(4, convert(bcrDetectorBorderParcel.cardOwner));
        }
        mLBankCard.setNumberBitmap(BitmapUtils.cut(bcrDetectorParcel.correct, mLBankCard.getBorder(1), 18));
        return mLBankCard;
    }

    private static Point[] convert(BcrDetectorBorderPointParcel bcrDetectorBorderPointParcel) {
        return bcrDetectorBorderPointParcel == null ? new Point[0] : new Point[]{bcrDetectorBorderPointParcel.leftTop, bcrDetectorBorderPointParcel.rightTop, bcrDetectorBorderPointParcel.rightBottom, bcrDetectorBorderPointParcel.leftBottom};
    }

    public void stop() {
        RemoteBcrDecoder.getInstance().release(this.app.getAppContext());
    }
}
