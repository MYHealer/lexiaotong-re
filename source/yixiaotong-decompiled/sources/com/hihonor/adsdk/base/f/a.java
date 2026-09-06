package com.hihonor.adsdk.base.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.common.f.b0;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a implements f {
    private static final int hnadse = 5000;
    protected BaseAd hnadsa;
    protected int hnadsb;
    private final int hnadsc = hashCode();
    private HandlerC0433a hnadsd;

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.f.a$a, reason: collision with other inner class name */
    private static class HandlerC0433a extends Handler {
        private long hnadsa;
        private long hnadsb;
        private String hnadsc;
        private String hnadsd;
        private com.hihonor.adsdk.base.g.j.d.h1.a hnadse;
        private int hnadsf;
        private List<String> hnadsg;

        public HandlerC0433a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long j;
            super.handleMessage(message);
            if (message.what != this.hnadsf) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa(), "msg what is not CHECK_DEEP_LINK_WHAT.", new Object[0]);
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = this.hnadsa;
            long jCeil = j2 <= 0 ? 0L : (long) Math.ceil(((jCurrentTimeMillis - j2) * 1.0f) / 1000.0f);
            long j3 = this.hnadsb;
            long jCeil2 = j3 <= 0 ? 0L : (long) Math.ceil(((jCurrentTimeMillis - j3) * 1.0f) / 1000.0f);
            long j4 = jCeil;
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "pauseTime:%s, resumeTime:%s, pauseMillis:%s, resumeMillis:%s, pauseDiff：%s", Long.valueOf(jCeil), Long.valueOf(jCeil2), Long.valueOf(this.hnadsa), Long.valueOf(this.hnadsb), Long.valueOf(jCurrentTimeMillis - this.hnadsa));
            if (j4 >= 5) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "ad pause more than or equals 5s.", new Object[0]);
                hnadsa(0, 0L, message.arg1);
                j = 0;
            } else {
                if (jCeil2 < 5) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "ad resume less than 5s.", new Object[0]);
                    hnadsa(1, jCeil2, message.arg1);
                }
                j = 0;
            }
            this.hnadsa = j;
            this.hnadsb = j;
        }

        public void hnadsa(int i) {
            this.hnadsf = i;
        }

        public void hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
            this.hnadse = aVar;
        }

        public void hnadsa(String str) {
            this.hnadsd = str;
        }

        public void hnadsa(List<String> list) {
            this.hnadsg = list;
        }

        public void hnadsa(long j) {
            this.hnadsa = j;
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "setMediaPauseTime: " + j, new Object[0]);
        }

        public String hnadsa() {
            return TextUtils.isEmpty(this.hnadsc) ? "DpHandler" : this.hnadsc;
        }

        public void hnadsb(long j) {
            if (this.hnadsa != 0) {
                this.hnadsb = j;
                this.hnadsa = 0L;
            }
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "setMediaResumeTime: " + this.hnadsb, new Object[0]);
        }

        public void hnadsb(String str) {
            if (TextUtils.isEmpty(this.hnadsc)) {
                this.hnadsc = "DpHandler-" + str;
            }
        }

        private void hnadsa(int i, long j, int i2) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "reportDpStartSuccess scene=" + i, new Object[0]);
            String str = this.hnadsd;
            com.hihonor.adsdk.base.g.j.d.h1.a aVar = this.hnadse;
            new com.hihonor.adsdk.base.g.j.d.k(str, aVar, com.hihonor.adsdk.base.j.f.hnadsa(aVar.hnadsj().intValue()), i, j).hnadsa(i2).hnadse();
            new com.hihonor.adsdk.base.g.k.c.j(com.hihonor.adsdk.base.j.f.hnadsa(this.hnadse.hnadsj().intValue()), i, j, i2).hnadsc(this.hnadse.hnadsa(), this.hnadsd, this.hnadse.hnadsk(), this.hnadsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public interface b {
        void hnadsa(boolean z, int i, int i2, String str);
    }

    public a(BaseAd baseAd) {
        this.hnadsa = baseAd;
    }

    private void hnadsb(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "checkMediaResume isCheckMediaResume=" + hnadsd(), new Object[0]);
        if (!hnadsd()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "checkResume# is check resume false. don't check dp start", new Object[0]);
            return;
        }
        if (!hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "checkResume# base Ad is null.", new Object[0]);
            return;
        }
        HandlerC0433a handlerC0433a = this.hnadsd;
        if (handlerC0433a == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "checkResume# mHandler Ad is null.", new Object[0]);
            return;
        }
        handlerC0433a.hnadsa(com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa));
        this.hnadsd.hnadsb(hnadsa());
        this.hnadsd.hnadsa(this.hnadsc);
        this.hnadsd.hnadsa(this.hnadsa.getTrackUrl().getAdvancedDp());
        this.hnadsd.hnadsa(this.hnadsa.getAdUnitId());
        boolean zHasMessages = this.hnadsd.hasMessages(this.hnadsc);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "send check deeplink has message. hasMessages: " + zHasMessages, new Object[0]);
        if (zHasMessages) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "send check deeplink start message", new Object[0]);
        Message messageObtainMessage = this.hnadsd.obtainMessage(this.hnadsc);
        messageObtainMessage.arg1 = i;
        this.hnadsd.sendMessageDelayed(messageObtainMessage, 5000L);
    }

    @Override // com.hihonor.adsdk.base.f.f
    public void hnadsa(int i) {
        this.hnadsb = i;
    }

    @Override // com.hihonor.adsdk.base.f.f
    public void hnadsa(BaseAd baseAd) {
        this.hnadsa = baseAd;
    }

    protected abstract void hnadsa(b bVar);

    protected abstract int hnadsb();

    protected boolean hnadsc() {
        return Objects.nonNull(this.hnadsa);
    }

    protected abstract boolean hnadsd();

    protected void hnadse() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "abstract handler start default enter.", new Object[0]);
        Context context = HnAds.get().getContext();
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "abstract, context is null, the toast cannot be displayed.", new Object[0]);
            return;
        }
        if (!hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "abstract handler start default fail, Cause by base ad is null.", new Object[0]);
            b0.hnadsb(context.getString(R.string.ads_page_unsupport));
        } else if (TextUtils.isEmpty(this.hnadsa.getLandingPageUrl())) {
            hnadsa(context);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "abstract handler start default web page.", new Object[0]);
            i.hnadsa(this.hnadsa).hnadsa(false).hnadsa(1).hnadsd();
        }
    }

    @Override // com.hihonor.adsdk.base.f.f
    public void release() {
    }

    @Override // com.hihonor.adsdk.base.f.f
    public void start() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "abstract handler start enter.", new Object[0]);
        if (hnadsd() && this.hnadsd == null) {
            this.hnadsd = new HandlerC0433a(Looper.getMainLooper());
        }
        hnadsa(new b() { // from class: com.hihonor.adsdk.base.f.a$$ExternalSyntheticLambda0
            @Override // com.hihonor.adsdk.base.f.a.b
            public final void hnadsa(boolean z, int i, int i2, String str) {
                this.f$0.hnadsa(z, i, i2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(boolean z, int i, int i2, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "abstract handler start internal result=" + z + ",code=" + i + ",startMethod=" + i2 + ",msg=" + str, new Object[0]);
        if (z) {
            hnadsb(i2);
        } else {
            hnadse();
        }
    }

    protected void hnadsa(Context context) {
        b0.hnadsb(context.getString(R.string.ads_page_unsupport));
    }

    protected void hnadsa(boolean z, int i, int i2, String str, b bVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "callBackStartInternal isSuccess=" + z + ",code=" + i + ",startMethod=" + i2 + ",msg=" + str, new Object[0]);
        if (bVar != null) {
            bVar.hnadsa(z, i, i2, str);
        }
    }

    @Override // com.hihonor.adsdk.base.f.f
    public void hnadsa(long j) {
        if (this.hnadsd != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), ">>>>>>>> record media Resume time:" + j, new Object[0]);
            this.hnadsd.hnadsb(j);
        }
    }

    @Override // com.hihonor.adsdk.base.f.f
    public void hnadsb(long j) {
        if (this.hnadsd != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), ">>>>>>>> record media Pause time:" + j, new Object[0]);
            this.hnadsd.hnadsa(j);
        }
    }
}
