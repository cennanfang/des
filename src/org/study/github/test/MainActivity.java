package org.study.github.test;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends ActivityGroup {

	// Tab Activity Layout
	private LocalActivityManager localActivityManager = null;
	private LinearLayout mainTabContainer = null;
	private Intent mainTabIntent = null;

	// Tab banner title
	private ImageView mainHeadLogo = null;
	private TextView mainHeadTitle = null;
	private ImageButton headTitleSearch = null;
	// Tab ImageView
	private Button btnHome = null;
	private Button btnClassification = null;
	private Button btnUserCenter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mainTabContainer = (LinearLayout) findViewById(R.id.main_tab_container);
		localActivityManager = getLocalActivityManager();
		setContainerView("appreciate", HomeTabActivity.class);

		initTitle();
		initTab();

	}
	
	private void initTitle() {
		// 标题
		mainHeadLogo = (ImageView) findViewById(R.id.main_head_logo);
		mainHeadTitle = (TextView) findViewById(R.id.main_head_title);
		headTitleSearch = (ImageButton) findViewById(R.id.main_title_search);
	}

	/**
	 * 初始化Tab项
	 */
	private void initTab() {
		btnHome = (Button) findViewById(R.id.frame_btn_home);
		btnClassification = (Button) findViewById(R.id.frame_btn_classification);
		btnUserCenter = (Button) findViewById(R.id.frame_btn_user_center);
		// 初始化状态
		btnHome.setEnabled(false);
		btnClassification.setEnabled(true);
		btnUserCenter.setEnabled(true);
		// 设置监听
		frameBtnClick(btnHome);
		frameBtnClick(btnClassification);
		frameBtnClick(btnUserCenter);
	}

	// 导航按钮监听
	private void frameBtnClick(final Button btn) {
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (btn == btnHome) {
					btnHome.setEnabled(false);
					mainHeadTitle.setText(R.string.head_title_home);
					mainHeadLogo.setImageResource(R.drawable.head_logo_home);
					setContainerView("appreciate", HomeTabActivity.class);
				} else {
					btnHome.setEnabled(true);
					headTitleSearch.setVisibility(View.GONE);
				}
				if (btn == btnClassification) {
					btnClassification.setEnabled(false);
					mainHeadTitle.setText(R.string.head_title_classification);
					mainHeadLogo.setImageResource(R.drawable.head_logo_classification);
					setContainerView("discuss", ClassificationTabActivity.class);
				} else {
					btnClassification.setEnabled(true);
				}
				if (btn == btnUserCenter) {
					btnUserCenter.setEnabled(false);
					mainHeadTitle.setText(R.string.head_title_user_center);
					mainHeadLogo.setImageResource(R.drawable.head_logo_user_center);
					setContainerView("favorite", UserCenterTabActivity.class);
				} else {
					btnUserCenter.setEnabled(true);
				}
			}
		});
	}

	public void setContainerView(String id, Class<?> activity) {
		mainTabContainer.removeAllViews();
		mainTabIntent = new Intent(this, activity);
		mainTabContainer.addView(localActivityManager.startActivity(id,
				mainTabIntent).getDecorView());
	}
}
