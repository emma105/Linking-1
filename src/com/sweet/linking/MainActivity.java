package com.sweet.linking;



import android.os.Bundle;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

public class MainActivity extends FragmentActivity
{
	private TabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//取得TabHost对象
		mTabHost = (TabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup();
		//为TabHost添加标签
		mTabHost.addTab(mTabHost.newTabSpec("dialltab").setIndicator("dial",getResources().getDrawable(R.drawable.tab_dial)).setContent(R.id.tab1));
		
		mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("contact",getResources().getDrawable(R.drawable.tab_contact)).setContent(R.id.tab2));
		mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("message",getResources().getDrawable(R.drawable.tab_message)).setContent(R.id.tab3));
		mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator("setting",getResources().getDrawable(R.drawable.tab_setting)).setContent(R.id.tab4));
		
		//设置TabHost的背景颜色
		mTabHost.setBackgroundColor(Color.argb(150, 22, 70, 150));
		//设置当前显示哪一个标签
		mTabHost.setCurrentTab(0);		
		
		//标签切换事件处理，setOnTabChangedListener 
	    mTabHost.setOnTabChangedListener(new OnTabChangeListener()
	    {
            @Override
            public void onTabChanged(String tabId) 
            {
            	Toast.makeText(MainActivity.this, "you choose"+tabId, Toast.LENGTH_SHORT).show();
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
