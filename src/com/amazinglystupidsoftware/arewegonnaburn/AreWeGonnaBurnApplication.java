package com.amazinglystupidsoftware.arewegonnaburn;

import android.app.Application;
import android.content.Context;

public class AreWeGonnaBurnApplication extends Application {
	private static Context appContext;

	@Override
	public void onCreate() {// Always called before anything else in the app
							// so in the rest of your code safe to call
							// MyApplicationClass.getContext();
		super.onCreate();
		appContext = this;
	}

	public static Context getContext() {
		return appContext;
	}
}
