package com.lichao.testliteorm;

import android.app.Application;
import android.content.Context;

public class MyApplcation extends Application {

	public static Context mContext;

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this;
	}
}
