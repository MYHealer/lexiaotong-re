package client.android.yixiaotong.util.spl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DbDao {
    private Context context;
    private SQLiteDatabase db;
    private RecordSQLiteOpenHelper helper;

    public DbDao(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.helper = new RecordSQLiteOpenHelper(this.context);
        queryData("");
    }

    public List<String> queryData(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = this.helper.getReadableDatabase().rawQuery("select id as _id,name from records where name like '%" + str + "%' order by id desc ", null);
        while (cursorRawQuery.moveToNext()) {
            arrayList.add(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("name")));
        }
        cursorRawQuery.close();
        return arrayList;
    }

    public boolean hasData(String str) {
        return this.helper.getReadableDatabase().rawQuery("select id as _id,name from records where name =?", new String[]{str}).moveToNext();
    }

    public void insertData(String str) {
        if (hasData(str)) {
            return;
        }
        SQLiteDatabase writableDatabase = this.helper.getWritableDatabase();
        this.db = writableDatabase;
        writableDatabase.execSQL("insert into records(name) values('" + str + "')");
        this.db.close();
    }

    public int delete(String str) {
        SQLiteDatabase writableDatabase = this.helper.getWritableDatabase();
        int iDelete = writableDatabase.delete("records", " name=?", new String[]{str});
        writableDatabase.close();
        return iDelete;
    }

    public void deleteData() {
        SQLiteDatabase writableDatabase = this.helper.getWritableDatabase();
        this.db = writableDatabase;
        writableDatabase.execSQL("delete from records");
        this.db.close();
    }
}
