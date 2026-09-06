package client.android.yixiaotong.v4.util.selectplatform;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SearchCacheManager {
    private static final int MAX_CACHE_SIZE = 5;
    private static final String SEARCH_CACHE_KEY = "search_history";
    private static final Gson gson = new Gson();

    public static void saveSearchItem(Context context, final SearchItem searchItem) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString(SEARCH_CACHE_KEY, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        Type type = new TypeToken<ArrayList<SearchItem>>() { // from class: client.android.yixiaotong.v4.util.selectplatform.SearchCacheManager.1
        }.getType();
        Gson gson2 = gson;
        List list = (List) gson2.fromJson(string, type);
        list.removeIf(new Predicate() { // from class: client.android.yixiaotong.v4.util.selectplatform.SearchCacheManager$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((SearchItem) obj).getSchoolName().equals(searchItem.getSchoolName());
            }
        });
        list.removeIf(new Predicate() { // from class: client.android.yixiaotong.v4.util.selectplatform.SearchCacheManager$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((SearchItem) obj).getId().equals(searchItem.getId());
            }
        });
        list.add(0, searchItem);
        if (list.size() > 5) {
            list.remove(list.size() - 1);
        }
        defaultSharedPreferences.edit().putString(SEARCH_CACHE_KEY, gson2.toJson(list)).apply();
    }

    public static List<SearchItem> getCachedItems(Context context) {
        return (List) gson.fromJson(PreferenceManager.getDefaultSharedPreferences(context).getString(SEARCH_CACHE_KEY, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI), new TypeToken<ArrayList<SearchItem>>() { // from class: client.android.yixiaotong.v4.util.selectplatform.SearchCacheManager.2
        }.getType());
    }

    public static void removeItem(Context context, final String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString(SEARCH_CACHE_KEY, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        Type type = new TypeToken<ArrayList<SearchItem>>() { // from class: client.android.yixiaotong.v4.util.selectplatform.SearchCacheManager.3
        }.getType();
        Gson gson2 = gson;
        List list = (List) gson2.fromJson(string, type);
        list.removeIf(new Predicate() { // from class: client.android.yixiaotong.v4.util.selectplatform.SearchCacheManager$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((SearchItem) obj).getId().equals(str);
            }
        });
        defaultSharedPreferences.edit().putString(SEARCH_CACHE_KEY, gson2.toJson(list)).apply();
    }
}
