package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.api.IPromoteInstallAdInfo;
import com.baidu.mobads.sdk.api.PromoteInstallManager;
import com.stub.StubApp;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1726a = z.n;
    private static final String b = "__sdk_remote_dl_no_install";
    private static final long c = 3600000;
    private Context d;
    private SharedPreferences e;
    private SharedPreferences.Editor f;
    private au g;
    private PromoteInstallManager.PromoteInstallListener h;
    private int i;
    private long j;

    /* synthetic */ aq(ar arVar) {
        this();
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final aq f1727a = new aq(null);

        private a() {
        }
    }

    public static aq a(Context context, PromoteInstallManager.PromoteInstallListener promoteInstallListener) {
        a.f1727a.b(context, promoteInstallListener);
        return a.f1727a;
    }

    private aq() {
        this.i = 0;
        this.j = 0L;
    }

    private void b(Context context, PromoteInstallManager.PromoteInstallListener promoteInstallListener) {
        this.d = context;
        SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(b, 0);
        this.e = sharedPreferences;
        this.f = sharedPreferences.edit();
        this.g = au.a(context, f1726a);
        this.h = promoteInstallListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean a() {
        try {
            Map<String, ?> all = this.e.getAll();
            List<String> listA = a((Map<String, Long>) all);
            if (listA == null) {
                return false;
            }
            for (int i = 0; i < listA.size(); i++) {
                String str = listA.get(i);
                Object objB = this.g.b(null, "getAdDownLoadInfo", this.d, str);
                if ((objB instanceof JSONObject) && ((JSONObject) objB).length() > 0) {
                    Long l = (Long) all.get(str);
                    if (a((JSONObject) objB) && System.currentTimeMillis() - l.longValue() < 3600000 && !bw.a(this.d, str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private List<String> a(Map<String, Long> map) {
        if (map == null || map.size() <= 0) {
            PromoteInstallManager.PromoteInstallListener promoteInstallListener = this.h;
            if (promoteInstallListener != null) {
                promoteInstallListener.onFail("暂无可用物料，请稍后再试");
            }
            return null;
        }
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new ar(this));
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((String) ((Map.Entry) it.next()).getKey());
        }
        if (map.get(arrayList2.get(0)).longValue() > this.j || this.i < 3) {
            return arrayList2;
        }
        PromoteInstallManager.PromoteInstallListener promoteInstallListener2 = this.h;
        if (promoteInstallListener2 != null) {
            promoteInstallListener2.onFail("暂无可用物料，请稍后再试");
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IPromoteInstallAdInfo a(boolean z) {
        String string;
        ap apVar = null;
        try {
            Map<String, ?> all = this.e.getAll();
            List<String> listA = a((Map<String, Long>) all);
            if (listA == null) {
                return null;
            }
            for (int i = 0; i < listA.size(); i++) {
                String str = listA.get(i);
                Object objB = this.g.b(null, "getAdDownLoadInfo", this.d, str);
                if ((objB instanceof JSONObject) && ((JSONObject) objB).length() > 0) {
                    JSONObject jSONObject = (JSONObject) objB;
                    Long l = (Long) all.get(str);
                    if (a(jSONObject) && System.currentTimeMillis() - l.longValue() < 3600000 && !bw.a(this.d, str)) {
                        ap apVar2 = new ap(jSONObject, this.d, this);
                        try {
                            if (z) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                                    jSONObject2.put("install_ts", l);
                                    string = jSONObject2.toString();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    string = null;
                                }
                                this.g.b(null, "startInstallDialogActivity", this.d, string);
                            }
                            int i2 = this.i + 1;
                            this.i = i2;
                            if (i2 <= 3) {
                                this.j = l.longValue();
                            }
                            this.f.remove(str);
                            this.f.commit();
                            PromoteInstallManager.PromoteInstallListener promoteInstallListener = this.h;
                            if (promoteInstallListener != null) {
                                promoteInstallListener.onSuccess();
                            }
                            return apVar2;
                        } catch (Throwable unused) {
                            apVar = apVar2;
                            break;
                        }
                    }
                    this.f.remove(str);
                    this.f.commit();
                } else {
                    this.f.remove(str);
                    this.f.commit();
                }
            }
        } catch (Throwable unused2) {
        }
        PromoteInstallManager.PromoteInstallListener promoteInstallListener2 = this.h;
        if (promoteInstallListener2 != null) {
            promoteInstallListener2.onFail("暂无可用物料，请稍后再试");
        }
        return apVar;
    }

    private boolean a(JSONObject jSONObject) {
        File file = new File(jSONObject.optString("folder") + jSONObject.optString(FileDownloadModel.FILENAME));
        return file.exists() && file.length() > 0;
    }

    public boolean b() {
        Object objB = this.g.b(null, "isInstallPopSwitch", new Object[0]);
        if (objB instanceof Boolean) {
            return ((Boolean) objB).booleanValue();
        }
        return false;
    }

    public int c() {
        Object objB = this.g.b(null, "getInstallPopType", new Object[0]);
        if (objB instanceof Integer) {
            return ((Integer) objB).intValue();
        }
        return 0;
    }

    public void a(Context context, String str) {
        this.g.b(null, "handleAdInstall", context, str);
    }
}
