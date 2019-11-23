package xyz.intellij.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    String[] names;
    String[] contents;
    String[] len;
    String[] url;
    ArrayList<Video> videos = new ArrayList<>();

    public List<Video> getVideos() {
        return videos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        //创建对象列表
        names = getResources().getStringArray(R.array.video_names);
        contents = getResources().getStringArray(R.array.video_contents);
        len = getResources().getStringArray(R.array.video_len);
        url = getResources().getStringArray(R.array.video_urls);
        for (int i = 0; i < names.length; i++) {
            videos.add(new Video(i + 1, names[i], contents[i], len[i], url[i]));
        }
        setContentView(R.layout.activity_main);
        /* 动态加载2个Fragment */


        //创建2个Fragment的实例
        SetTitleFragment TitleFragment = new SetTitleFragment();
        SetContentFragment ContentFragment = new SetContentFragment();

        //获取Fragment事务
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();


        //添加Fragment
        transaction.replace(R.id.settitle, TitleFragment);
        if (findViewById(R.id.setcontent) != null) {
            transaction.replace(R.id.setcontent, ContentFragment);
        }
        //提交事务
        transaction.commit();

    }
}
