package client.android.yixiaotong.v3.ui.adv;

import android.app.Activity;
import android.widget.FrameLayout;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BannerUtil {
    private static final String TAG = "BannerUtil";
    private Activity mActivity;
    private AdvControlUtil.AdvListener mAdvListener;
    private boolean mIsEnable;
    private boolean mIsNewPlantion;
    private List<FlowState> mOrderList;
    private int mPlayIndex;
    private String mSchoolId;

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.ui.adv.BannerUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private enum FlowState {
        chuangzhi
    }

    /* synthetic */ BannerUtil(AnonymousClass1 anonymousClass1) {
        this();
    }

    private static class SingletonHolder {
        public static final BannerUtil INSTANCE = new BannerUtil(null);

        private SingletonHolder() {
        }
    }

    public static BannerUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private BannerUtil() {
        this.mIsEnable = true;
        this.mOrderList = new ArrayList();
        this.mPlayIndex = 0;
    }

    public void initBanner(Activity activity, AdvControlUtil.AdvListener advListener, boolean z, String str) {
        this.mActivity = activity;
        this.mAdvListener = advListener;
        this.mIsNewPlantion = z;
        this.mSchoolId = str;
        this.mPlayIndex = 0;
        this.mOrderList.clear();
        String advRuleInfo = LocalDataUtil.getAdvRuleInfo(this.mActivity);
        if (StringUtils.isNotEmpty(advRuleInfo)) {
            String[] strArrSplit = advRuleInfo.split(";");
            if (strArrSplit.length <= 2 || !StringUtils.isNotEmpty(strArrSplit[2])) {
                return;
            }
            for (String str2 : strArrSplit[2].split(",")) {
                if (str2.equals(FlowState.chuangzhi + "")) {
                    this.mOrderList.add(FlowState.chuangzhi);
                    LogUtil.e(TAG, "banner添加广告");
                }
            }
        }
    }

    public void onBanner(FrameLayout frameLayout) {
        this.mPlayIndex = 0;
        List<FlowState> list = this.mOrderList;
        if (list == null || list.size() <= 0) {
            return;
        }
        reqFlow(frameLayout);
    }

    public void onDestroy() {
        List<FlowState> list = this.mOrderList;
        if (list != null) {
            list.size();
        }
    }

    private void reqFlow(FrameLayout frameLayout) {
        LogUtil.e(TAG, "请求banner");
    }
}
