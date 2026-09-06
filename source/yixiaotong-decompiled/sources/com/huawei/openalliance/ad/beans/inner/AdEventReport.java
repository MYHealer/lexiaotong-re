package com.huawei.openalliance.ad.beans.inner;

import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.annotations.d;
import com.huawei.openalliance.ad.beans.metadata.CtrlExt;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.z;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class AdEventReport {
    private static final String TAG = "AdEventReport";
    private String activityName;
    private Integer adCardH;
    private Integer adCardW;
    private Integer adCardX;
    private Integer adCardY;
    private int adType;
    private int apiVer;
    private Integer btnClickX;
    private Integer btnClickY;
    private String clickComponent;
    private Long clickDTime;
    private Long clickUTime;
    private Integer clickX;
    private Integer clickY;
    private Integer compH;
    private Integer compW;
    private Integer compX;
    private Integer compY;
    private String contentId;
    private String creativeSize;
    private String ctrlExt;

    @d
    private transient CtrlExt ctrlExtObj;
    private String customData;
    private Float density;
    private String destination;
    private Integer endProgress;
    private Long endTime;
    private Long eventTime;
    private String eventType;
    private List<FeedbackInfo> feedbackInfoList;
    private String installType;
    private Integer intentDest;
    private Integer intentFailReason;
    private String isAdContainerSizeMatched;
    private Boolean isReportNow;
    private String jsVersion;
    private List<String> keyWords;
    private Integer mark;
    private boolean mute;
    private boolean phyShow;
    Integer playedTime;
    private String requestId;
    private Integer screenH;
    private Integer screenOrientation;
    private Integer screenW;
    private Integer screenX;
    private Integer screenY;
    private String shakeAngle;
    private Long showDuration;
    private Integer showRatio;
    private Integer sld;
    private String slotId;
    private String slotPosition;
    private Integer source;
    private Integer startProgress;
    private long startShowTime;
    private Long startTime;
    private String templateId;
    private String uiengineVersion;
    private String uniqueId;
    private Integer upX;
    private Integer upY;
    private String userId;
    private long videoTime;
    private int x;
    private int y;
    private String showId = String.valueOf(z.Code());

    @d
    private boolean isFromExSplash = false;
    private int recallSource = 0;
    private boolean isSupportImpCtrl = true;
    private boolean isSupportClickIntvl = true;

    public Integer A() {
        return this.screenY;
    }

    public String B() {
        return this.contentId;
    }

    public void B(int i) {
        this.recallSource = i;
    }

    public void B(Integer num) {
        this.endProgress = num;
    }

    public void B(Long l) {
        this.clickUTime = l;
    }

    public void B(String str) {
        this.destination = str;
    }

    public int C() {
        return this.adType;
    }

    public void C(Integer num) {
        this.intentDest = num;
    }

    public void C(Long l) {
        this.clickDTime = l;
    }

    public void C(String str) {
        this.showId = str;
    }

    public String Code() {
        return this.uniqueId;
    }

    public void Code(int i) {
        this.adType = i;
    }

    public void Code(long j) {
        this.startShowTime = j;
    }

    public void Code(CtrlExt ctrlExt) {
        this.ctrlExtObj = ctrlExt;
    }

    public void Code(Boolean bool) {
        this.isReportNow = bool;
    }

    public void Code(Float f) {
        this.density = f;
    }

    public void Code(Integer num) {
        this.playedTime = num;
    }

    public void Code(Long l) {
        this.showDuration = l;
    }

    public void Code(String str) {
        this.uniqueId = str;
    }

    public void Code(List<String> list) {
        this.keyWords = list;
    }

    public void Code(boolean z) {
        this.isSupportImpCtrl = z;
    }

    public Long D() {
        return this.showDuration;
    }

    public void D(Integer num) {
        this.clickY = num;
    }

    public void D(String str) {
        this.userId = str;
    }

    public Integer E() {
        return this.screenOrientation;
    }

    public void F(Integer num) {
        this.clickX = num;
    }

    public void F(String str) {
        this.customData = str;
    }

    public boolean F() {
        return this.phyShow;
    }

    public long G() {
        return this.startShowTime;
    }

    public List<FeedbackInfo> H() {
        return this.feedbackInfoList;
    }

    public CtrlExt I() {
        if (this.ctrlExtObj == null) {
            this.ctrlExtObj = (CtrlExt) ad.V(this.ctrlExt, CtrlExt.class, new Class[0]);
        }
        return this.ctrlExtObj;
    }

    public void I(int i) {
        this.y = i;
    }

    public void I(Integer num) {
        this.source = num;
    }

    public void I(Long l) {
        this.endTime = l;
    }

    public void I(String str) {
        this.contentId = str;
    }

    public void I(boolean z) {
        this.mute = z;
    }

    public int J() {
        return this.apiVer;
    }

    public String K() {
        return this.templateId;
    }

    public Integer L() {
        return this.showRatio;
    }

    public void L(Integer num) {
        this.screenX = num;
    }

    public void L(String str) {
        this.activityName = str;
    }

    public String M() {
        return this.slotId;
    }

    public Integer N() {
        return this.sld;
    }

    public Integer O() {
        return this.upX;
    }

    public Integer P() {
        return this.upY;
    }

    public Float Q() {
        return this.density;
    }

    public int R() {
        return this.recallSource;
    }

    public Integer S() {
        return this.playedTime;
    }

    public void S(Integer num) {
        this.intentFailReason = num;
    }

    public void S(String str) {
        this.requestId = str;
    }

    public String T() {
        return this.slotPosition;
    }

    public long U() {
        return this.videoTime;
    }

    public String V() {
        return this.ctrlExt;
    }

    public void V(int i) {
        this.x = i;
    }

    public void V(long j) {
        this.videoTime = j;
    }

    public void V(Integer num) {
        this.showRatio = num;
    }

    public void V(Long l) {
        this.startTime = l;
    }

    public void V(String str) {
        this.ctrlExt = str;
    }

    public void V(List<FeedbackInfo> list) {
        this.feedbackInfoList = list;
    }

    public void V(boolean z) {
        this.phyShow = z;
    }

    public Long W() {
        return this.clickUTime;
    }

    public Long X() {
        return this.clickDTime;
    }

    public String Y() {
        return this.shakeAngle;
    }

    public void Z(int i) {
        this.apiVer = i;
    }

    public void Z(Integer num) {
        this.startProgress = num;
    }

    public void Z(Long l) {
        this.eventTime = l;
    }

    public void Z(String str) {
        this.eventType = str;
    }

    public void Z(boolean z) {
        this.isFromExSplash = z;
    }

    public boolean Z() {
        return this.isSupportImpCtrl;
    }

    public Integer a() {
        return this.source;
    }

    public void a(Integer num) {
        this.screenY = num;
    }

    public void a(String str) {
        this.isAdContainerSizeMatched = str;
    }

    public Integer aa() {
        return this.mark;
    }

    public String ab() {
        return this.uiengineVersion;
    }

    public String ac() {
        return this.jsVersion;
    }

    public String ad() {
        return this.installType;
    }

    public void b(Integer num) {
        this.screenOrientation = num;
    }

    public void b(String str) {
        this.creativeSize = str;
    }

    public boolean b() {
        return this.mute;
    }

    public String c() {
        return this.eventType;
    }

    public void c(Integer num) {
        this.sld = num;
    }

    public void c(String str) {
        this.templateId = str;
    }

    public Long d() {
        return this.startTime;
    }

    public void d(Integer num) {
        this.upX = num;
    }

    public void d(String str) {
        this.slotId = str;
    }

    public Long e() {
        return this.endTime;
    }

    public void e(Integer num) {
        this.upY = num;
    }

    public void e(String str) {
        this.slotPosition = str;
    }

    public Integer f() {
        return this.startProgress;
    }

    public void f(Integer num) {
        this.mark = num;
    }

    public void f(String str) {
        this.shakeAngle = str;
    }

    public Integer g() {
        return this.endProgress;
    }

    public void g(Integer num) {
        this.compX = num;
    }

    public void g(String str) {
        this.uiengineVersion = str;
    }

    public int h() {
        return this.x;
    }

    public void h(Integer num) {
        this.compY = num;
    }

    public void h(String str) {
        this.jsVersion = str;
    }

    public int i() {
        return this.y;
    }

    public void i(Integer num) {
        this.compW = num;
    }

    public void i(String str) {
        this.installType = str;
    }

    public String j() {
        return this.destination;
    }

    public void j(Integer num) {
        this.compH = num;
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            fh.V(TAG, "clickComponent is invalid");
        } else {
            this.clickComponent = str;
        }
    }

    public List<String> k() {
        return this.keyWords;
    }

    public void k(Integer num) {
        this.adCardX = num;
    }

    public Integer l() {
        return this.intentDest;
    }

    public void l(Integer num) {
        this.adCardY = num;
    }

    public Integer m() {
        return this.intentFailReason;
    }

    public void m(Integer num) {
        this.adCardW = num;
    }

    public String n() {
        return this.showId;
    }

    public void n(Integer num) {
        this.adCardH = num;
    }

    public String o() {
        return this.requestId;
    }

    public void o(Integer num) {
        this.screenW = num;
    }

    public String p() {
        return this.customData;
    }

    public void p(Integer num) {
        this.screenH = num;
    }

    public String q() {
        return this.userId;
    }

    public void q(Integer num) {
        this.btnClickX = num;
    }

    public String r() {
        return this.activityName;
    }

    public void r(Integer num) {
        this.btnClickY = num;
    }

    public String s() {
        return this.isAdContainerSizeMatched;
    }

    public Integer t() {
        return this.clickX;
    }

    public Integer u() {
        return this.clickY;
    }

    public String v() {
        return this.creativeSize;
    }

    public boolean w() {
        return this.isFromExSplash;
    }

    public Long x() {
        return this.eventTime;
    }

    public Boolean y() {
        return this.isReportNow;
    }

    public Integer z() {
        return this.screenX;
    }
}
