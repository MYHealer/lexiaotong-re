package com.kwad.components.core.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class i implements j, Comparable<i> {
    private final String PC;
    private final String PD;
    private final String PE;
    private final long PF;
    private final String Ps;
    private final long createTime;
    private final int ecpm;

    private String oX() {
        return this.PD;
    }

    private int oY() {
        return this.ecpm;
    }

    private long oZ() {
        return this.createTime;
    }

    private String pb() {
        return this.PE;
    }

    public final String oP() {
        return this.Ps;
    }

    public final long pa() {
        return this.PF;
    }

    public final String pc() {
        return this.PC;
    }

    private i(String str, String str2, String str3, int i, String str4, long j, long j2) {
        this.PC = str;
        this.Ps = str2;
        this.PD = str3;
        this.ecpm = i;
        this.PE = str4;
        this.createTime = j;
        this.PF = j2;
    }

    public static List<i> a(e eVar, AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jOS = (jCurrentTimeMillis / 1000) + eVar.oS();
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        Iterator<AdTemplate> it = proceedTemplateList.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            arrayList.add(new i(String.valueOf(com.kwad.sdk.core.response.helper.e.eY(next)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData, defaultAdScene, Collections.singletonList(next)).getResponseJson(), com.kwad.sdk.core.response.helper.e.fc(next), adResultData.getDefaultAdScene().toJson().toString(), jCurrentTimeMillis + ((long) size), jOS));
            size--;
            it = it;
            defaultAdScene = defaultAdScene;
        }
        return arrayList;
    }

    public static List<i> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(c(cursor));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return arrayList;
    }

    private static synchronized i c(Cursor cursor) {
        return new i(cursor.getString(cursor.getColumnIndex("creativeId")), cursor.getString(cursor.getColumnIndex("posId")), cursor.getString(cursor.getColumnIndex("adJson")), cursor.getInt(cursor.getColumnIndex("ecpm")), cursor.getString(cursor.getColumnIndex("adSenseJson")), cursor.getLong(cursor.getColumnIndex("createTime")), cursor.getLong(cursor.getColumnIndex("expireTime")));
    }

    public static AdResultData k(List<i> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultDataC = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<i> it = list.iterator();
        SceneImpl defaultAdScene = null;
        while (it.hasNext()) {
            adResultDataC = c(it.next());
            if (adResultDataC != null) {
                if (defaultAdScene == null) {
                    defaultAdScene = adResultDataC.getDefaultAdScene();
                }
                arrayList.addAll(adResultDataC.getProceedTemplateList());
            }
        }
        AdResultData adResultData = new AdResultData(adResultDataC, defaultAdScene, arrayList);
        adResultData.setAdSource("cache");
        return adResultData;
    }

    private static AdResultData c(i iVar) {
        if (iVar == null) {
            return null;
        }
        if (iVar.oX() == null || iVar.pb() == null) {
            com.kwad.sdk.core.d.c.w("CachedAd", "createAdResultData cachedAd data illegal");
            return null;
        }
        try {
            String strPb = iVar.pb();
            SceneImpl sceneImpl = new SceneImpl();
            sceneImpl.parseJson(new JSONObject(strPb));
            AdResultData adResultDataCreateFromResponseJson = AdResultData.createFromResponseJson(iVar.oX(), sceneImpl);
            Iterator<AdTemplate> it = adResultDataCreateFromResponseJson.getProceedTemplateList().iterator();
            while (it.hasNext()) {
                it.next().fromCache = true;
            }
            return adResultDataCreateFromResponseJson;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }

    @Override // com.kwad.components.core.c.j
    public final ContentValues oT() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.PC);
        contentValues.put("posId", this.Ps);
        contentValues.put("adJson", this.PD);
        contentValues.put("ecpm", Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.PE);
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.PF));
        contentValues.put("playAgainJson", (String) null);
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        if (iVar.oY() == oY()) {
            return (int) (iVar.oZ() - oZ());
        }
        return iVar.oY() - oY();
    }
}
