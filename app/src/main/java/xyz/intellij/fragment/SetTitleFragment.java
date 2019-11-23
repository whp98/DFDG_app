package xyz.intellij.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class SetTitleFragment extends Fragment {
    private View view;
//    private String[] titles;
//    private String[][] details;
    private List<Video> videos;
    private ListView listView;
    //是否是双页模式。如果一个Activity中包含了两个Fragment，就是双页模式。
    private boolean isTwoPane;
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState){
        //加载布局文件
        view=inflater.inflate(R.layout.title_layout,container,false);
        MainActivity activity=(MainActivity)getActivity();
//        titles = activity.getTitles();
//        // 从activity中获取titles和details
//        details=activity.getDetails();
        videos = activity.getVideos();
        if (view!=null){
            init();
        }

        //判断是是不是分屏
        if (((MainActivity)getActivity()).findViewById(R.id.setcontent) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
        // 为listview添加监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (isTwoPane) {
                    // 通过activity实例获取另一个Fragment（右侧Fragment）对象
                    SetContentFragment detail = (SetContentFragment)((MainActivity)getActivity()).getSupportFragmentManager().findFragmentById(R.id.setcontent);

                    // 设置获取到的Fragment对象的文字内容
                    detail.setText(videos.get(i));
                } else {
                    Intent intent = new Intent(getActivity().getApplicationContext(), PlayVideoActivity.class);
                    //可以携带数据
                    Bundle data = new Bundle();
                    data.putSerializable("data",videos.get(i));
                    intent.putExtras(data);
                    startActivity(intent);
                }

            }
        });
        return view;
    }

    private void init() {
        // 获取ListView（listView）实例
        listView = (ListView)view.findViewById(R.id.titlelist);


        if (videos != null) {
            // 为listView设置adapter
            listView.setAdapter(new MyAdapter());
        }
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return videos.size();
        }

        @Override
        public Object getItem(int i) {
            return videos.get(i).toString();
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            // 加载listView每一项的布局
            view = View.inflate(getActivity(), R.layout.title_item_layout, null);

            // 获取title_item_layout中TextView的实例
            TextView titletext = (TextView)view.findViewById(R.id.titles);
            // 为该TextView设置文字为titles中的第i项
            titletext.setText(videos.get(i).toString());
            return view;
        }
    }
}
