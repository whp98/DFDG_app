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

    private List<Video> videos;
    private ListView listView;
    private boolean isTwoPane;

    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.title_layout, container, false);
        MainActivity activity = (MainActivity) getActivity();
        videos = activity.getVideos();
        if (view != null) {
            init();
        }

        if (((MainActivity) getActivity()).findViewById(R.id.setcontent) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (isTwoPane) {
                    SetContentFragment detail = (SetContentFragment) ((MainActivity) getActivity()).getSupportFragmentManager().findFragmentById(R.id.setcontent);

                    detail.setText(videos.get(i));
                } else {
                    Intent intent = new Intent(getActivity().getApplicationContext(), PlayVideoActivity.class);
                    Bundle data = new Bundle();
                    data.putSerializable("data", videos.get(i));
                    intent.putExtras(data);
                    startActivity(intent);
                }

            }
        });
        return view;
    }

    private void init() {
        listView = (ListView) view.findViewById(R.id.titlelist);


        if (videos != null) {
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
            view = View.inflate(getActivity(), R.layout.title_item_layout, null);

            TextView titletext = (TextView) view.findViewById(R.id.titles);
            titletext.setText(videos.get(i).toString());
            return view;
        }
    }
}
