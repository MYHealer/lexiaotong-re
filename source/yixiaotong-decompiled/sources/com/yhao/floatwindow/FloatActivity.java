package com.yhao.floatwindow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FloatActivity extends Activity {
    private static PermissionListener mPermissionListener;
    private static List<PermissionListener> mPermissionListenerList;

    static {
        StubApp.interface11(57484);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void requestAlertWindowPermission() {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, 756232212);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 756232212) {
            if (PermissionUtil.hasPermissionOnActivityResult(this)) {
                mPermissionListener.onSuccess();
            } else {
                mPermissionListener.onFail();
            }
        }
        finish();
    }

    static synchronized void request(Context context, PermissionListener permissionListener) {
        if (PermissionUtil.hasPermission(context)) {
            permissionListener.onSuccess();
            return;
        }
        if (mPermissionListenerList == null) {
            mPermissionListenerList = new ArrayList();
            mPermissionListener = new PermissionListener() { // from class: com.yhao.floatwindow.FloatActivity.1
                @Override // com.yhao.floatwindow.PermissionListener
                public void onSuccess() {
                    Iterator it = FloatActivity.mPermissionListenerList.iterator();
                    while (it.hasNext()) {
                        ((PermissionListener) it.next()).onSuccess();
                    }
                    FloatActivity.mPermissionListenerList.clear();
                }

                @Override // com.yhao.floatwindow.PermissionListener
                public void onFail() {
                    Iterator it = FloatActivity.mPermissionListenerList.iterator();
                    while (it.hasNext()) {
                        ((PermissionListener) it.next()).onFail();
                    }
                    FloatActivity.mPermissionListenerList.clear();
                }
            };
            Intent intent = new Intent(context, (Class<?>) FloatActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
        mPermissionListenerList.add(permissionListener);
    }
}
