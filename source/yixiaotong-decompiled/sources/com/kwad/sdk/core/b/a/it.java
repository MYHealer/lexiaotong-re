package com.kwad.sdk.core.b.a;

import com.kwad.sdk.monitor.MediaMessageInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class it implements com.kwad.sdk.core.d<MediaMessageInfo.MediaPermissionInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((MediaMessageInfo.MediaPermissionInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((MediaMessageInfo.MediaPermissionInfo) bVar, jSONObject);
    }

    private static void a(MediaMessageInfo.MediaPermissionInfo mediaPermissionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mediaPermissionInfo.canReadLocation = jSONObject.optInt("canReadLocation");
        mediaPermissionInfo.getLocation = jSONObject.optInt("getLocation");
        mediaPermissionInfo.getKsLocation = jSONObject.optInt("getKsLocation");
        mediaPermissionInfo.canUsePhoneState = jSONObject.optInt("canUsePhoneState");
        mediaPermissionInfo.getImei = jSONObject.optInt("getImei");
        mediaPermissionInfo.getImeis = jSONObject.optInt("getImeis");
        mediaPermissionInfo.getAndroidId = jSONObject.optInt("getAndroidId");
        mediaPermissionInfo.canUseOaid = jSONObject.optInt("canUseOaid");
        mediaPermissionInfo.getOaid = jSONObject.optInt("getOaid");
        mediaPermissionInfo.canUseMacAddress = jSONObject.optInt("canUseMacAddress");
        mediaPermissionInfo.getMacAddress = jSONObject.optInt("getMacAddress");
        mediaPermissionInfo.canUseNetworkState = jSONObject.optInt("canUseNetworkState");
        mediaPermissionInfo.canUseStoragePermission = jSONObject.optInt("canUseStoragePermission");
        mediaPermissionInfo.canReadInstalledPackages = jSONObject.optInt("canReadInstalledPackages");
        mediaPermissionInfo.getInstalledPackages = jSONObject.optInt("getInstalledPackages");
        mediaPermissionInfo.canReadMacAddress = jSONObject.optInt("canReadMacAddress");
        mediaPermissionInfo.canReadNearbyWifiList = jSONObject.optInt("canReadNearbyWifiList");
        mediaPermissionInfo.canReadICCID = jSONObject.optInt("canReadICCID");
    }

    private static JSONObject b(MediaMessageInfo.MediaPermissionInfo mediaPermissionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (mediaPermissionInfo.canReadLocation != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canReadLocation", mediaPermissionInfo.canReadLocation);
        }
        if (mediaPermissionInfo.getLocation != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getLocation", mediaPermissionInfo.getLocation);
        }
        if (mediaPermissionInfo.getKsLocation != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getKsLocation", mediaPermissionInfo.getKsLocation);
        }
        if (mediaPermissionInfo.canUsePhoneState != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canUsePhoneState", mediaPermissionInfo.canUsePhoneState);
        }
        if (mediaPermissionInfo.getImei != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getImei", mediaPermissionInfo.getImei);
        }
        if (mediaPermissionInfo.getImeis != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getImeis", mediaPermissionInfo.getImeis);
        }
        if (mediaPermissionInfo.getAndroidId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getAndroidId", mediaPermissionInfo.getAndroidId);
        }
        if (mediaPermissionInfo.canUseOaid != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canUseOaid", mediaPermissionInfo.canUseOaid);
        }
        if (mediaPermissionInfo.getOaid != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getOaid", mediaPermissionInfo.getOaid);
        }
        if (mediaPermissionInfo.canUseMacAddress != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canUseMacAddress", mediaPermissionInfo.canUseMacAddress);
        }
        if (mediaPermissionInfo.getMacAddress != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getMacAddress", mediaPermissionInfo.getMacAddress);
        }
        if (mediaPermissionInfo.canUseNetworkState != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canUseNetworkState", mediaPermissionInfo.canUseNetworkState);
        }
        if (mediaPermissionInfo.canUseStoragePermission != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canUseStoragePermission", mediaPermissionInfo.canUseStoragePermission);
        }
        if (mediaPermissionInfo.canReadInstalledPackages != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canReadInstalledPackages", mediaPermissionInfo.canReadInstalledPackages);
        }
        if (mediaPermissionInfo.getInstalledPackages != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "getInstalledPackages", mediaPermissionInfo.getInstalledPackages);
        }
        if (mediaPermissionInfo.canReadMacAddress != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canReadMacAddress", mediaPermissionInfo.canReadMacAddress);
        }
        if (mediaPermissionInfo.canReadNearbyWifiList != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canReadNearbyWifiList", mediaPermissionInfo.canReadNearbyWifiList);
        }
        if (mediaPermissionInfo.canReadICCID != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "canReadICCID", mediaPermissionInfo.canReadICCID);
        }
        return jSONObject;
    }
}
