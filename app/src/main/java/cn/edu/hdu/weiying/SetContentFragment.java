package cn.edu.hdu.weiying;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

import cn.edu.hdu.weiying.R;


public class SetContentFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView text1;
    private Button btnPlay, btnPause, btnReplay;
    private VideoView videoView;
    private Video def;
    private RatingBar ratingBar;
    private int id_r;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_layout, container, false);

        if (view != null) {
            init();
        }
        if (this.def == null) {
            this.def = new Video(0, "示例", "介绍内容", "8:50", "https://boot-video.xuexi.cn/video/1004/p/2cb12b08f9a07e493a7fda1064a4115e-0c7789377e8c4917b690a9d17fedf470-2.mp4");
        }
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser) {
                    setRate(rating, id_r);
                }
            }
        });
        setText();
        return view;
    }


    private void init() {
        videoView = (VideoView) view.findViewById(R.id.showvideo);
        btnPlay = (Button) view.findViewById(R.id.btnPlay);
        btnPause = (Button) view.findViewById(R.id.btnPause);
        text1 = (TextView) view.findViewById(R.id.video_detail);
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
    }

    private void initVideoPath(Video in) {
        videoView.setVideoURI(Uri.parse(in.url));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }

    private float getRate(int id) {
        SharedPreferences sp = this.getActivity().getSharedPreferences("rates", Context.MODE_PRIVATE);
        return sp.getFloat("" + id, 0);
    }

    private void setRate(float rate, int id) {
        SharedPreferences sp = this.getActivity().getSharedPreferences("rates", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();//获取编辑器
        editor.putFloat("" + id, rate);
        editor.apply();
    }

    public void setText(Video text) {
        this.id_r = text.id;
        initVideoPath(text);
        text1.setText(text.contents);
        ratingBar.setRating(getRate(text.id));
    }

    public void setText() {
        setText(this.def);
    }

    public void setDef(Video def) {
        this.def = def;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:
                if (!videoView.isPlaying()) {
                    videoView.start();
                }
                break;
            case R.id.btnPause:
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
                break;
        }
    }
}
