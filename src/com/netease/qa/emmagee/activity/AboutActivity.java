/*
 * Copyright (c) 2012-2013 NetEase, Inc. and other contributors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.netease.qa.emmagee.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.netease.qa.emmagee.R;

/**
 * About Page of Emmagee
 * @students Team Six
 * @author andrewleo
 */
public class AboutActivity extends Activity {
	//子类继承自Activity父类

	private static final String LOG_TAG = "Emmagee-"
			+ AboutActivity.class.getSimpleName();

	private TextView appVersion;
	private ImageView goBack;
	//声明3个私有类，包括1个final类型（不可更改）的字符串和2个自定义View控件类

	@Override
	public void onCreate(Bundle savedInstanceState) {
		//创建类，新建Activity的运行入口
		Log.i(LOG_TAG, "onCreate");
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.about);//设置布局
		//以下基本为布局中各类控件与Activity的绑定并进行强制类型转换
		appVersion = (TextView)findViewById(R.id.app_version);
		appVersion.setText(getVersion());
		
		TextView title = (TextView)findViewById(R.id.nb_title);
		title.setText(R.string.about);
		
		ImageView btnSave = (ImageView) findViewById(R.id.btn_set);
		btnSave.setVisibility(ImageView.INVISIBLE);
		
		goBack = (ImageView)findViewById(R.id.go_back);
		LinearLayout layGoBack = (LinearLayout) findViewById(R.id.lay_go_back);
		
		layGoBack.setOnClickListener(new OnClickListener() {
			//此处设置监听，监听用户操作
			@Override
			public void onClick(View arg0) {
				AboutActivity.this.finish();
			}
		});
	}
	
	/**
	 * get app version
	 * @return app version
	 */
	public String getVersion() {
	    try {
	        PackageManager manager = this.getPackageManager();
	        PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
	        String version = info.versionName;
	        return  version;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "-";
	    }
	}

	@Override
	public void finish() {
		//结束Activity，即关闭当前最前端的Activity
		super.finish();
	}

	@Override
	protected void onDestroy() {
		//销毁Activity（手动或被系统销毁），即销毁相关活动进程，释放内存
		super.onDestroy();
	}

}
