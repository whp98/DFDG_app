package xyz.intellij.fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Resources;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity{

    String[] names;
    String[] contents;
    String[] len;
    String[] url;
    ArrayList<Video> videos = new ArrayList<>();

    //设置标题
//    private String titles[] = {"标题一","标题二","标题三"};
//    private String details[][] = {{"标题一","标题一的内容"},{"标题二","标题二的内容"},{"标题三","标题三的内容"}};
    //获取video列表的方法
    public List<Video> getVideos() {
        return videos;
    }
//    //获取标题和内容
//    public String[][] getDetails() {
//        return details;
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建对象列表
        names = getResources().getStringArray(R.array.video_names);
        contents = getResources().getStringArray(R.array.video_contents);
        len = getResources().getStringArray(R.array.video_len);
        url = getResources().getStringArray(R.array.video_urls);
        for (int i=0;i<names.length;i++){
            videos.add(new Video(i+1,names[i],contents[i],len[i],url[i]));
        }
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
        if (findViewById(R.id.setcontent)!=null) {
            transaction.replace(R.id.setcontent,ContentFragment);
        }
        //提交事务
        transaction.commit();

    }
}
