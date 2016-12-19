package com.lichao.testliteorm;

import android.content.Context;

public interface ApiConstant {
	String DB_NAME_PATH = MyApplcation.mContext.getDir("db", Context.MODE_PRIVATE).getAbsolutePath();
	String DB_NAME = "lichao.db";
}
