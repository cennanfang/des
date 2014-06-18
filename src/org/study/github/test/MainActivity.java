package org.study.github.test;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends ActivityGroup{

	 //Tab Activity Layout
    private LocalActivityManager localActivityManager = null;
    private LinearLayout mainTabContainer = null;
    private Intent mainTabIntent = null;

    //Tab banner title
    private TextView mainTabTitleTextView = null; 
    //Tab ImageView
    private ImageView appreciateImageView = null;
    private ImageView discussImageView = null;
    private ImageView identificationImageView = null;
    private ImageView favoriteImageView = null;
    private ImageView settingImageView = null;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mainTabContainer = (LinearLayout)findViewById(R.id.main_tab_container);
        localActivityManager = getLocalActivityManager();
        setContainerView("appreciate", AppreciateTabActivity.class);
        
        initTab();
        
    }

    
    /**
     * 初始化Tab项
     */
    private void initTab() {
        mainTabTitleTextView = (TextView)findViewById(R.id.main_tab_banner_title);
        appreciateImageView = (ImageView)findViewById(R.id.appreciate_tab_btn);
        discussImageView = (ImageView)findViewById(R.id.discuss_tab_btn);
        identificationImageView = (ImageView)findViewById(R.id.identification_tab_btn);
        favoriteImageView = (ImageView)findViewById(R.id.favorite_tab_btn);
        settingImageView = (ImageView)findViewById(R.id.setting_tab_btn);
        
        //赏花
        appreciateImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTabTitleTextView.setText("欣赏美花");
                setContainerView("appreciate", AppreciateTabActivity.class);
                appreciateImageView.setImageResource(R.drawable.appreciate_press);
                discussImageView.setImageResource(R.drawable.discuss_normal);
                identificationImageView.setImageResource(R.drawable.identification_normal);
                favoriteImageView.setImageResource(R.drawable.favorite_normal);
                settingImageView.setImageResource(R.drawable.setting_normal);
            }
        });
        
        //评花
        discussImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTabTitleTextView.setText("评花论花");
                setContainerView("discuss", DiscussTabActivity.class);
                appreciateImageView.setImageResource(R.drawable.appreciate_normal);
                discussImageView.setImageResource(R.drawable.discuss_press);
                identificationImageView.setImageResource(R.drawable.identification_normal);
                favoriteImageView.setImageResource(R.drawable.favorite_normal);
                settingImageView.setImageResource(R.drawable.setting_normal);
            }
        });
        
        //识花
        identificationImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTabTitleTextView.setText("亮眼识花");
                setContainerView("identification", IdentificationTabActivity.class);
                appreciateImageView.setImageResource(R.drawable.appreciate_normal);
                discussImageView.setImageResource(R.drawable.discuss_normal);
                identificationImageView.setImageResource(R.drawable.identification_press);
                favoriteImageView.setImageResource(R.drawable.favorite_normal);
                settingImageView.setImageResource(R.drawable.setting_normal);
            }
        });
        
        //收藏
        favoriteImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTabTitleTextView.setText("我的收藏");
                setContainerView("favorite", FavoriteTabActivity.class);
                appreciateImageView.setImageResource(R.drawable.appreciate_normal);
                discussImageView.setImageResource(R.drawable.discuss_normal);
                identificationImageView.setImageResource(R.drawable.identification_normal);
                favoriteImageView.setImageResource(R.drawable.favorite_press);
                settingImageView.setImageResource(R.drawable.setting_normal);
            }
        });
        
        //设置
        settingImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTabTitleTextView.setText("定义设置");
                setContainerView("setting", SettingTabActivity.class);
                appreciateImageView.setImageResource(R.drawable.appreciate_normal);
                discussImageView.setImageResource(R.drawable.discuss_normal);
                identificationImageView.setImageResource(R.drawable.identification_normal);
                favoriteImageView.setImageResource(R.drawable.favorite_normal);
                settingImageView.setImageResource(R.drawable.setting_press);
            }
        });
    }
    
    public void setContainerView(String id,Class<?> activity){
        mainTabContainer.removeAllViews();
        mainTabIntent = new Intent(this,activity);
        mainTabContainer.addView(localActivityManager.startActivity(id, mainTabIntent).getDecorView());
    }
}
