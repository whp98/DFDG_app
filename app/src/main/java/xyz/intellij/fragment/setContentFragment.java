package xyz.intellij.fragment;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

import java.net.URI;
import java.net.URISyntaxException;

public class setContentFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView text1;
    private Button btnPlay,btnPause,btnReplay;
    private VideoView videoView;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //加载布局文件
        view=inflater.inflate(R.layout.content_layout,container,false);

        if (view!=null){
            init();
        }

        // 设置初始化显示文字为activity中details的第一项
        //setText(((MainActivity)getActivity()).getVideos().get(0));

        return view;
    }



    private void init() {
        // 所有实例
        videoView = (VideoView)view.findViewById(R.id.showvideo);
         btnPlay = (Button)view.findViewById(R.id.btnPlay);
         btnPause = (Button)view.findViewById(R.id.btnPause);
         btnReplay = (Button)view.findViewById(R.id.btnReplay);
        text1 = (TextView)view.findViewById(R.id.video_detail);
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnReplay.setOnClickListener(this);
    }

    private void initVideoPath(Video in){
        videoView.setVideoURI(Uri.parse(in.url));//指定视频文件路径
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);//让电影循环播放
            }
        });
    }

    public void setText(Video text) {
        // 设置两个TextView的文字
        initVideoPath(text);
        text1.setText(text.contents);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPlay:
                if(!videoView.isPlaying()){
                    videoView.start();//播放
                }
                break;
            case R.id.btnPause:
                if(videoView.isPlaying()){
                    videoView.pause();//暂停
                }
                break;
            case R.id.btnReplay:
                if(videoView.isPlaying()){
                    videoView.resume();//重新播放
                }
                break;
        }
    }
}
