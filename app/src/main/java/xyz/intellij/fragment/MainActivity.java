package xyz.intellij.fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends FragmentActivity{
    //设置标题
    private String titles[] = {"标题一","标题二","标题三"};
    private String details[][] = {{"标题一","标题一的内容"},{"标题二","标题二的内容"},{"标题三","标题三的内容"}};
    //获取标题数组的方法
    public String[] getTitles() {
        return titles;
    }
    //获取标题和内容
    public String[][] getDetails() {
        return details;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* 动态加载2个Fragment */


        //创建2个Fragment的实例
        setTitleFragment TitleFragment = new setTitleFragment();
        setContentFragment ContentFragment = new setContentFragment();

        //获取Fragment事务
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();


        //添加Fragment
        transaction.replace(R.id.settitle,TitleFragment);
        transaction.replace(R.id.setcontent,ContentFragment);


        //提交事务
        transaction.commit();

    }
}
