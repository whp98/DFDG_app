package xyz.intellij.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class setContentFragment extends Fragment {
    private View view;
    private TextView text1,text2;

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
        setText(((MainActivity)getActivity()).getDetails()[0]);

        return view;
    }

    private void init() {
        // 获取两个TextView（text1与text2）的实例
        text1 = (TextView)view.findViewById(R.id.show_content);
        text2 = (TextView)view.findViewById(R.id.show_title);

    }
    public void setText(String[] text) {
        // 设置两个TextView的文字
        text1.setText(text[0]);
        text2.setText(text[1]);
    }
}
