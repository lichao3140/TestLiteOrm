package com.lichao.testliteorm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.litesuits.orm.db.model.ConflictAlgorithm;
import com.litesuits.orm.db.assit.SQLiteHelper;

import java.io.File;
import java.util.List;

/**
 * 数据库管理类
 */
public enum DatabaseManager implements SQLiteHelper.OnUpdateListener,
		ApiConstant {
	INSTANCE;

	private LiteOrm mLiteOrm;

	DatabaseManager() {
		DataBaseConfig config = new DataBaseConfig(MyApplcation.mContext);
		config.dbName = DB_NAME_PATH + File.separator + DB_NAME;
		config.dbVersion = 1;
		config.onUpdateListener = this;
		config.debugged = BuildConfig.DEBUG;
		mLiteOrm = LiteOrm.newSingleInstance(config);
	}

	@Override
	public void onUpdate(SQLiteDatabase arg0, int arg1, int arg2) {

	}

	/**
	 * 插入一条数据
	 * @param o
	 */
	public void save(Object o) {
		if (o == null) {
			return;
		}

		mLiteOrm.save(o);
		Log.i("lichao", "save success:"+o.toString());
	}

	/**
	 * 插入多条数据
	 * @param collection
	 */
	public <T> void save(List<T> collection) {
		if (CommonUtil.isEmpty(collection)) {
			return;
		}

		mLiteOrm.save(collection);
		Log.i("lichao", "save success:"+collection.toString());
	}

	/**
	 * 删除一个表
	 * @param tClass
	 */
	public <T> void delete(Class<T> tClass) {
		if (tClass == null) {
			return;
		}

		mLiteOrm.delete(tClass);
	}
	
	/**
	 * 删除所有某字段等于 Vlaue的值
	 * @param tClass
	 * @param field
	 * @param value
	 */
	public <T> void deleteWhere(Class<T> tClass, String field, String [] value){
		if (tClass == null) {
			return;
		}
		mLiteOrm.delete(WhereBuilder.create(tClass).where(field + "=?", value));
		//mLiteOrm.delete(tClass, WhereBuilder.create(tClass).where(field + "=?", value));
    }

	/**
	 * 查询所有
	 * @param tClass
	 * @return
	 */
	public <T> List<T> queryAll(Class<T> tClass) {
		if (tClass == null) {
			return null;
		}

		return mLiteOrm.query(tClass);
	}

}