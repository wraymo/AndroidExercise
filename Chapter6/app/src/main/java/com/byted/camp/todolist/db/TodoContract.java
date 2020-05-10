package com.byted.camp.todolist.db;

import android.provider.BaseColumns;

import com.byted.camp.todolist.operation.db.FeedReaderContract;

/**
 * Created on 2019/1/22.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public final class TodoContract {

    // TODO 定义表结构和 SQL 语句常量
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TodoContract.TodoEntry.TABLE_NAME + " (" +
                    TodoContract.TodoEntry._ID + " INTEGER PRIMARY KEY," +
                    TodoContract.TodoEntry.COLUMN_NAME_CONTENT + " TEXT," +
                    TodoEntry.COLUMN_NAME_DATE + " DATETIME," +
                    TodoEntry.COLUMN_NAME_STATE + " INT," +
                    TodoContract.TodoEntry.COLUMN_NAME_PRIORITY + " INT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TodoContract.TodoEntry.TABLE_NAME;

    private TodoContract() {
    }

    public static class TodoEntry implements BaseColumns {

        public static final String TABLE_NAME = "todo";

        public static final String COLUMN_NAME_PRIORITY = "priority";

        public static final String COLUMN_NAME_DATE = "date";

        public static final String COLUMN_NAME_STATE = "state";

        public static final String COLUMN_NAME_CONTENT = "content";
    }
}
