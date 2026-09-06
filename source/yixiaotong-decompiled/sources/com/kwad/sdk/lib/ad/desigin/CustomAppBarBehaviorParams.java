package com.kwad.sdk.lib.ad.desigin;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CustomAppBarBehaviorParams {
    public final boolean mEnableNestedFling;
    public final boolean mEnableRebound;
    public final int mExtraFixedSize;
    public final int mFlingConsumeViewId;
    public final int mReboundMaxOffset;
    public final int mReboundViewId;

    /* JADX INFO: renamed from: com.kwad.sdk.lib.ad.desigin.CustomAppBarBehaviorParams$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ CustomAppBarBehaviorParams(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private CustomAppBarBehaviorParams(a aVar) {
        this.mFlingConsumeViewId = aVar.mFlingConsumeViewId;
        this.mExtraFixedSize = aVar.mExtraFixedSize;
        this.mEnableNestedFling = aVar.mEnableNestedFling;
        this.mReboundMaxOffset = aVar.mReboundMaxOffset;
        this.mReboundViewId = aVar.mReboundViewId;
        this.mEnableRebound = aVar.mEnableRebound;
    }

    public static class a {
        private boolean mEnableNestedFling;
        private boolean mEnableRebound;
        private int mExtraFixedSize;
        private int mFlingConsumeViewId;
        private int mReboundMaxOffset;
        private int mReboundViewId;
    }
}
