package com.jd.ad.sdk.jad_zi;

import com.cdo.oaps.ad.OapsKey;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.mdt.service.JADEventService;
import org.json.JSONObject;

/* JADX INFO: compiled from: JADEventServiceImplementor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs implements JADEventService {
    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportClickEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, i5, j, j2, j3, i6, i7, i8, i9, i10, i11, i12, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportCloseEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, i5, j, j2, j3, i6, i7, i8, i9, i10, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportExceptionEvent(String str, int i, String str2) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, i, str2);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportExposureEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, int i6, int i7, int i8, int i9, String str3, int i10, int i11) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, i5, j, j2, i6, i7, i8, i9, JsonUtils.parse2JSONObject(str3), i10, i11, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadClickEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, i5, j, j2, j3, i6, i7, i8, i9, i10, i11, i12, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadCloseEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, i5, j, j2, j3, i6, i7, i8, i9, i10, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadExposureEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, int i6, int i7, int i8, int i9, String str3, int i10, int i11) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, i5, j, j2, i6, i7, i8, i9, JsonUtils.parse2JSONObject(str3), i10, i11, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadRenderSuccessEvent(String str, String str2, int i, int i2, int i3, int i4, long j, long j2, int i5, int i6, int i7, int i8, int i9) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, j, 1, j2, i5, i6, i7, i8, i9, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportPreloadResponseEvent(String str, String str2, int i, int i2, int i3, int i4, long j, int i5, int i6, int i7, int i8, int i9) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, j, 0, 0L, i5, i6, i7, i8, i9, 1);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportRenderFailedEvent(String str, int i, String str2, int i2) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 10, i, str2, i2);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportRenderSuccessEvent(String str, String str2, int i, int i2, int i3, int i4, long j, long j2, int i5, int i6, int i7, int i8, int i9) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, j, 1, j2, i5, i6, i7, i8, i9, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportRequestErrorEvent(String str, int i, String str2) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 7, i, str2, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportResponseEvent(String str, String str2, int i, int i2, int i3, int i4, long j, int i5, int i6, int i7, int i8, int i9) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, str2, 1, i, i2, i3, i4, j, 0, 0L, i5, i6, i7, i8, i9, 0);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportVideoEvent(String str, String str2, int i, int i2, int i3, int i4, long j, long j2, long j3, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, double d) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, OapsKey.KEY_TYPE, 4);
        JsonUtils.put(jSONObject, "adrid", str);
        JsonUtils.put(jSONObject, "pid", str2);
        JsonUtils.put(jSONObject, "pfid", 1);
        JsonUtils.put(jSONObject, OapsKey.KEY_ADAPTER_TYPE, Integer.valueOf(i));
        JsonUtils.put(jSONObject, "clid", UUIDUtils.uuid());
        JsonUtils.put(jSONObject, "tpid", Integer.valueOf(i2));
        JsonUtils.put(jSONObject, "clf", Integer.valueOf(CommonConstants.ClickFrom.VIDEO.ordinal()));
        JsonUtils.put(jSONObject, "sen", Integer.valueOf(i3));
        JsonUtils.put(jSONObject, "rem", Integer.valueOf(i4));
        JsonUtils.put(jSONObject, "dety", 10);
        JsonUtils.put(jSONObject, "scdu", Long.valueOf(j));
        JsonUtils.put(jSONObject, "dcdu", Long.valueOf(j2));
        JsonUtils.put(jSONObject, "ecdu", Long.valueOf(j3));
        JsonUtils.put(jSONObject, "sspt", Integer.valueOf(i5));
        JsonUtils.put(jSONObject, "scav", Integer.valueOf(i6));
        JsonUtils.put(jSONObject, "adat", Integer.valueOf(i7));
        JsonUtils.put(jSONObject, "atst", Integer.valueOf(i8));
        JsonUtils.put(jSONObject, "catp", Integer.valueOf(i9));
        JsonUtils.put(jSONObject, "dstp", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "srtp", Integer.valueOf(i11));
        JsonUtils.put(jSONObject, "ipl", 0);
        JsonUtils.put(jSONObject, "vpst", Integer.valueOf(i12));
        JsonUtils.put(jSONObject, "vpdt", Double.valueOf(d));
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_bo(jSONObject);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADEventService
    public void reportVideoExceptionEvent(String str, int i, String str2) {
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 11, i, str2, 0);
    }
}
