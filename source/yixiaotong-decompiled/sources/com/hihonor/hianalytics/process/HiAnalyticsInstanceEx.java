package com.hihonor.hianalytics.process;

import android.content.Context;
import com.hihonor.hianalytics.global.AutoCollectEventType;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.p2;
import com.hihonor.hianalytics.util.SystemUtils;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface HiAnalyticsInstanceEx extends HiAnalyticsInstance {

    public static final class Builder {
        private static final String TAG = "HiAnalyticsInstanceEx-Builder";
        private Context mContext;
        private HiAnalyticsConfig maintConf = null;
        private HiAnalyticsConfig operConf = null;
        private HiAnalyticsConfig diffConf = null;
        private List<AutoCollectEventType> lsCollectTypes = null;

        public Builder(Context context) {
            if (context != null) {
                this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            SystemUtils.a(context);
        }

        private void setConfEx(d dVar) {
            HiAnalyticsConfig hiAnalyticsConfig = this.operConf;
            dVar.c(hiAnalyticsConfig == null ? null : new HiAnalyticsConfig(hiAnalyticsConfig));
            HiAnalyticsConfig hiAnalyticsConfig2 = this.maintConf;
            dVar.b(hiAnalyticsConfig2 == null ? null : new HiAnalyticsConfig(hiAnalyticsConfig2));
            HiAnalyticsConfig hiAnalyticsConfig3 = this.diffConf;
            dVar.a(hiAnalyticsConfig3 != null ? new HiAnalyticsConfig(hiAnalyticsConfig3) : null);
        }

        public Builder autoCollect(List<AutoCollectEventType> list) {
            this.lsCollectTypes = list;
            return this;
        }

        public HiAnalyticsInstanceEx create() {
            if (this.mContext == null) {
                j2.b(TAG, "create instanceEx context is null,create failed!");
                return null;
            }
            if (HiAnalyticsManager.getInitFlag("_instance_ex_tag")) {
                j2.b(TAG, "create DEFAULT or existed tag is not allowed here.");
                return null;
            }
            c cVar = new c();
            setConfEx(cVar);
            j2.c(TAG, "create context=" + this.mContext);
            a.c().a(cVar);
            cVar.a(this.lsCollectTypes);
            p2.a().a("_instance_ex_tag");
            return cVar;
        }

        public HiAnalyticsInstanceEx refresh() {
            c cVarD = a.c().d();
            if (cVarD == null) {
                j2.g("HianalyticsSDK", "HiAnalyticsInstanceEx.Builder.Refresh(): calling refresh before create. Instance not exist.");
                return create();
            }
            cVarD.refresh(1, this.maintConf);
            cVarD.refresh(0, this.operConf);
            cVarD.refresh(3, this.diffConf);
            cVarD.a(this.lsCollectTypes);
            return cVarD;
        }

        public Builder setDiffConf(HiAnalyticsConfig hiAnalyticsConfig) {
            this.diffConf = hiAnalyticsConfig;
            return this;
        }

        public Builder setMaintConf(HiAnalyticsConfig hiAnalyticsConfig) {
            this.maintConf = hiAnalyticsConfig;
            return this;
        }

        public Builder setOperConf(HiAnalyticsConfig hiAnalyticsConfig) {
            this.operConf = hiAnalyticsConfig;
            return this;
        }
    }

    @Deprecated
    void handleV1Cache();

    void onStartApp(String str, String str2);
}
