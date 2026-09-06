package com.ubix.ssp.ad.e.s.h;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cdo.oaps.ad.OapsKey;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8858a;
    private SQLiteDatabase b;

    public a(Context context) {
        this.f8858a = context;
        this.b = new b(context).getWritableDatabase();
    }

    private boolean c(String str) {
        Cursor cursorQuery = this.b.query("t_ubixad_download_info", null, " id = ? ", new String[]{str}, null, null, null);
        boolean zMoveToNext = cursorQuery.moveToNext();
        cursorQuery.close();
        return zMoveToNext;
    }

    public void a(com.ubix.ssp.ad.e.s.g.b bVar) {
        if (bVar == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", bVar.f());
        contentValues.put("downloadUrl", bVar.c());
        contentValues.put("filePath", bVar.e());
        contentValues.put(OapsKey.KEY_SIZE, Long.valueOf(bVar.g()));
        contentValues.put("downloadLocation", Long.valueOf(bVar.a()));
        contentValues.put("downloadStatus", Integer.valueOf(bVar.b()));
        if (c(bVar.f())) {
            this.b.update("t_ubixad_download_info", contentValues, "id = ?", new String[]{bVar.f()});
        } else {
            this.b.insert("t_ubixad_download_info", null, contentValues);
        }
    }

    public void a(String str) {
        if (c(str)) {
            this.b.delete("t_ubixad_download_info", "id = ?", new String[]{str});
        }
    }

    public com.ubix.ssp.ad.e.s.g.b b(String str) {
        Cursor cursorQuery = this.b.query("t_ubixad_download_info", null, " id = ? ", new String[]{str}, null, null, null);
        com.ubix.ssp.ad.e.s.g.b bVar = null;
        while (cursorQuery.moveToNext()) {
            bVar = new com.ubix.ssp.ad.e.s.g.b();
            bVar.d(cursorQuery.getString(cursorQuery.getColumnIndex("id")));
            bVar.a(cursorQuery.getString(cursorQuery.getColumnIndex("downloadUrl")));
            bVar.c(cursorQuery.getString(cursorQuery.getColumnIndex("filePath")));
            bVar.b(cursorQuery.getLong(cursorQuery.getColumnIndex(OapsKey.KEY_SIZE)));
            bVar.a(cursorQuery.getLong(cursorQuery.getColumnIndex("downloadLocation")));
            bVar.b(cursorQuery.getInt(cursorQuery.getColumnIndex("downloadStatus")));
            if (!new File(bVar.e()).exists()) {
                a(str);
                return null;
            }
        }
        cursorQuery.close();
        return bVar;
    }
}
