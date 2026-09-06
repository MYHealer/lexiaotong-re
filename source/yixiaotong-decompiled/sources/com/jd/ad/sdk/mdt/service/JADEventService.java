package com.jd.ad.sdk.mdt.service;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface JADEventService {
    void reportClickEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10, int i11, int i12);

    void reportCloseEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10);

    void reportExceptionEvent(String str, int i, String str2);

    void reportExposureEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, int i6, int i7, int i8, int i9, String str3, int i10, int i11);

    void reportPreloadClickEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10, int i11, int i12);

    void reportPreloadCloseEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10);

    void reportPreloadExposureEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, int i6, int i7, int i8, int i9, String str3, int i10, int i11);

    void reportPreloadRenderSuccessEvent(String str, String str2, int i, int i2, int i3, int i4, long j, long j2, int i5, int i6, int i7, int i8, int i9);

    void reportPreloadResponseEvent(String str, String str2, int i, int i2, int i3, int i4, long j, int i5, int i6, int i7, int i8, int i9);

    void reportRenderFailedEvent(String str, int i, String str2, int i2);

    void reportRenderSuccessEvent(String str, String str2, int i, int i2, int i3, int i4, long j, long j2, int i5, int i6, int i7, int i8, int i9);

    void reportRequestErrorEvent(String str, int i, String str2);

    void reportResponseEvent(String str, String str2, int i, int i2, int i3, int i4, long j, int i5, int i6, int i7, int i8, int i9);

    void reportVideoEvent(String str, String str2, int i, int i2, int i3, int i4, long j, long j2, long j3, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, double d);

    void reportVideoExceptionEvent(String str, int i, String str2);
}
