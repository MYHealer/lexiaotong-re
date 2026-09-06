package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class lb implements la {
    private static final String Code = "MoreShareProcessor";
    private static final String I = "text/plain";
    private static final String V = "text/plain";
    private static final String Z = "";
    private String B;

    private List<Intent> Code(List<ResolveInfo> list, List<String> list2) {
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : list) {
            if (list2.contains(resolveInfo.activityInfo.packageName)) {
                fh.Code(Code, "%s Not showing", resolveInfo.activityInfo.packageName);
            } else {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", this.B);
                intent.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                arrayList.add(intent);
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.ads.la
    public void Code(Activity activity, le leVar, lg lgVar) {
        if (activity == null || StubApp.getOrigApplicationContext(activity.getApplicationContext()) == null) {
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        this.B = (leVar.I() == null ? "" : leVar.I()) + (leVar.Z() != null ? leVar.Z() : "");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        List<Intent> listCode = Code(origApplicationContext.getPackageManager().queryIntentActivities(intent, 131072), lgVar.Z());
        Intent intentCreateChooser = Intent.createChooser(listCode.remove(0), leVar.V() != null ? leVar.V() : "text/plain");
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) listCode.toArray(new Parcelable[0]));
        intentCreateChooser.setFlags(268435456);
        origApplicationContext.startActivity(intentCreateChooser);
    }

    @Override // com.huawei.hms.ads.la
    public boolean Code() {
        return true;
    }
}
