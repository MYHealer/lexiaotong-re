package com.baidu.mobads.sdk.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ArticleInfo {
    public static final String USER_SEX = "sex";
    public static final String PAGE_TITLE = "page_title";
    public static final String PAGE_ID = "page_content_id";
    public static final String CONTENT_CATEGORY = "page_content_category";
    public static final String CONTENT_LABEL = "page_content_label";
    public static final String FIRST_LEVEL_CONTENTS = "page_ctnts_l1";
    public static final String FAVORITE_BOOK = "fav_book";
    public static final String PAGE_SERIAL_STATUS = "page_series_stat";
    public static final String CHAPTER_NUM = "page_chptr_num";
    public static final String PAGE_AUTHOR_ID = "page_author_id";
    public static final String SECOND_LEVEL_CONTENTS = "page_ctnts_l2";
    public static final String QUERY_WORD = "qw";
    public static final String[] PREDEFINED_KEYS = {USER_SEX, PAGE_TITLE, PAGE_ID, CONTENT_CATEGORY, CONTENT_LABEL, FIRST_LEVEL_CONTENTS, FAVORITE_BOOK, PAGE_SERIAL_STATUS, CHAPTER_NUM, PAGE_AUTHOR_ID, SECOND_LEVEL_CONTENTS, QUERY_WORD};
    public static final String ECAFD_BIND_BONUS = "ecafd_bind_bonus";
    public static final String ECAFD_ORDER_BONUS = "ecafd_order_bonus";
    public static final String ECAFD_UID = "ecafd_uid";
    public static final String[] PREDEFINED_KEYS_UNLIMITED = {ECAFD_BIND_BONUS, ECAFD_ORDER_BONUS, ECAFD_UID};

    public class ValidSexValue {
        int UNKNOWN = 0;
        int MALE = 1;
        int FEMALE = 2;

        public ValidSexValue() {
        }
    }
}
