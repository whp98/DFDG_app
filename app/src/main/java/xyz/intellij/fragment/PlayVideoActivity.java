package xyz.intellij.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class PlayVideoActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        /**
         * 屏幕旋转会重新创建该Activity
         * 如果屏幕从单屏旋转到双屏模式下，则销毁当前Activity，进入双屏模式
         */
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        /**
         * 向当前的Activity的动态实现DetailsFragment
         */
        if (savedInstanceState == null)
        {
            Intent intent = this.getIntent();
            Video video=(Video) intent.getSerializableExtra("data");
            setContentFragment ContentFragment = new setContentFragment();
            ContentFragment.setDef(video);
            //获取Fragment事务
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (findViewById(R.id.setcontent1)!=null) {
                transaction.replace(R.id.setcontent1,ContentFragment);
            }
            transaction.commit();
        }
    }


}
