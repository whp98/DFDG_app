package xyz.intellij.fragment;

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
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        if (savedInstanceState == null) {
            Intent intent = this.getIntent();
            Video video = (Video) intent.getSerializableExtra("data");
            SetContentFragment ContentFragment = new SetContentFragment();
            ContentFragment.setDef(video);
            //获取Fragment事务
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (findViewById(R.id.setcontent1) != null) {
                transaction.replace(R.id.setcontent1, ContentFragment);
            }
            transaction.commit();
        }
    }


}
