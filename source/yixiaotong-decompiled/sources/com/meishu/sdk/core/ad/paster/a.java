package com.meishu.sdk.core.ad.paster;

import android.os.Handler;
import android.os.SystemClock;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.ResultBean;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.nativ.f;

/* JADX INFO: compiled from: MeishuPasterAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends com.meishu.sdk.core.ad.a implements PasterAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f4760a;

    /* JADX INFO: renamed from: com.meishu.sdk.core.ad.paster.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MeishuPasterAd.java */
    public class C0790a extends l {
        public C0790a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            ((NormalMediaView) a.this.getAdView()).replay();
        }
    }

    public a(f fVar) {
        super(null, "MS");
        this.f4760a = fVar;
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void destroy() {
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).d();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public long getCurrentPosition() {
        try {
            if (getAdView() instanceof NormalMediaView) {
                return ((NormalMediaView) getAdView()).getCurrentPosition();
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCid(this.f4760a.getCid());
            resultBean.setCat(this.f4760a.getCat());
            resultBean.setAderId(this.f4760a.getAder_id());
            resultBean.setFromId(this.f4760a.getFromId());
            resultBean.setDrawing(this.f4760a.getDrawing());
            resultBean.setPid(this.f4760a.getPosId());
            resultBean.setReqId(this.f4760a.getReq_id());
            resultBean.setPrice(this.f4760a.getEcpm());
            resultBean.setEcpm(String.valueOf(this.f4760a.getEcpm()));
            resultBean.setS_ext(this.f4760a.getS_ext());
            resultBean.setS_code(this.f4760a.getS_code());
            resultBean.setSdkName("MS");
            resultBean.setAdInfo(com.meishu.sdk.core.utils.a.a((BaseAdSlot) this.f4760a));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBean;
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public long getDuration() {
        try {
            if (getAdView() instanceof NormalMediaView) {
                return ((NormalMediaView) getAdView()).getDuration();
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public boolean isAdValid() {
        try {
            int expire_timestamp = this.f4760a.getExpire_timestamp();
            return SystemClock.uptimeMillis() - this.f4760a.getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void mute() {
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).g();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void onPause() {
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).pause();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void onResume() {
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).resume();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void pause() {
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).pause();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void replay() {
        if (getAdView() instanceof NormalMediaView) {
            new Handler().postDelayed(new C0790a(), 300L);
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void resume() {
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).resume();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void setOnPreparedListener(NormalMediaView.d dVar) {
        try {
            if (getAdView() instanceof NormalMediaView) {
                ((NormalMediaView) getAdView()).setOnPreparedListener(dVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void start() {
        try {
            o1.b(this.f4760a.getEventUrl());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).start();
        }
    }

    @Override // com.meishu.sdk.core.ad.paster.PasterAd
    public void unmute() {
        if (getAdView() instanceof NormalMediaView) {
            ((NormalMediaView) getAdView()).j();
        }
    }
}
