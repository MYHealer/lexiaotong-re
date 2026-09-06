package client.android.yixiaotong.util.permission;

import android.app.Activity;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PermissionUtil {
    public static final int CODE_ACCESS_FIND_LOCATION = 1;
    public static final int CODE_CALL_PHONE = 5;
    public static final int CODE_CAMERA = 0;
    public static final int CODE_READ_EXTERNAL_STORAGE = 2;
    public static final int CODE_READ_PHONE_STATE = 4;
    public static final int CODE_WRITE_EXTERNAL_STORAGE = 3;
    public static final String PERSSION_ACCESS_FIND_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final String PERSSION_BLUETOOTH_ADVERTISE = "android.permission.BLUETOOTH_ADVERTISE";
    public static final String PERSSION_BLUETOOTH_CONNECT = "android.permission.BLUETOOTH_CONNECT";
    public static final String PERSSION_BLUETOOTH_SCAN = "android.permission.BLUETOOTH_SCAN";
    public static final String PERSSION_READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    public static final String PERSSION_READ_MEDIA_AUDIO = "android.permission.READ_MEDIA_AUDIO";
    public static final String PERSSION_READ_MEDIA_IMAGES = "android.permission.READ_MEDIA_IMAGES";
    public static final String PERSSION_READ_MEDIA_VIDEO = "android.permission.READ_MEDIA_VIDEO";
    public static final String PERSSION_READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    public static final String PERSSION_WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String PERSSION_CAMERA = "android.permission.CAMERA";
    public static final String PERSSION_CALL_PHONE = "android.permission.CALL_PHONE";
    public static final String[] requestPermissions = {PERSSION_CAMERA, "android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE", PERSSION_CALL_PHONE};

    public interface PermissionGrant {
        void onPermissionGranted(int i);
    }

    private static boolean isAndroid12OrHigher() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public static boolean isAndroid13OrHigher() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static void requestPerssion(Activity activity, int i, PermissionGrant permissionGrant) {
        if (activity != null && i >= 0) {
            String[] strArr = requestPermissions;
            if (i >= strArr.length) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            String str = strArr[i];
            if (i != 1) {
                if (i == 2) {
                    if (isAndroid13OrHigher()) {
                        arrayList.add(PERSSION_READ_MEDIA_IMAGES);
                        arrayList.add(PERSSION_READ_MEDIA_VIDEO);
                    } else {
                        arrayList.add(str);
                    }
                } else if (i != 3 || !isAndroid13OrHigher()) {
                    arrayList.add(str);
                } else {
                    permissionGrant.onPermissionGranted(i);
                    return;
                }
            } else if (isAndroid12OrHigher()) {
                str = PERSSION_BLUETOOTH_CONNECT;
                arrayList.add(PERSSION_BLUETOOTH_CONNECT);
                arrayList.add(PERSSION_BLUETOOTH_SCAN);
                arrayList.add(PERSSION_BLUETOOTH_ADVERTISE);
            } else {
                arrayList.add(str);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (ActivityCompat.checkSelfPermission(activity, (String) it.next()) != 0) {
                    if (shouldShowRationale(activity, arrayList)) {
                        tip(activity, i, str);
                        return;
                    } else {
                        ActivityCompat.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i);
                        return;
                    }
                }
            }
            permissionGrant.onPermissionGranted(i);
        }
    }

    public static void requestPermissionsResult(Activity activity, int i, String[] strArr, int[] iArr, PermissionGrant permissionGrant) {
        if (activity == null || i < 0 || i >= requestPermissions.length) {
            return;
        }
        for (int i2 : iArr) {
            if (i2 != 0) {
                if (iArr.length > 0) {
                    tip(activity, i, strArr[0]);
                    return;
                }
                return;
            }
        }
        permissionGrant.onPermissionGranted(i);
    }

    private static void tip(final Activity activity, int i, String str) {
        String str2;
        if (i == 0) {
            str2 = "请开启相机权限\n\n（注意：不会开权限的用户可以卸载APP后重新安装即可）";
        } else if (i == 1) {
            str2 = isAndroid12OrHigher() ? "请开启蓝牙相关权限" : "请开启定位/位置信息权限";
        } else if (i == 2) {
            str2 = isAndroid13OrHigher() ? "请允许访问照片和视频" : "请开启读手机存储权限";
        } else if (i == 3) {
            str2 = "请开启写手机存储权限";
        } else if (i != 4) {
            return;
        } else {
            str2 = "";
        }
        if (StringUtils.isEmpty(str2)) {
            return;
        }
        SystemErrorTip.getInstance().showTipDialog(activity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.util.permission.PermissionUtil.1
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() throws Throwable {
                PermissionPageUtils.getInstance().jumpPermissionPage(activity);
            }
        }, str2);
    }

    private static boolean shouldShowRationale(Activity activity, ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, it.next())) {
                return true;
            }
        }
        return false;
    }
}
