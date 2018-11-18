package com.bistsmh.escapehell;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<Listviewitem> mItems = new ArrayList<>() ;

    // ListViewAdapter의 생성자
    public ListViewAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return mItems.size() ;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Listviewitem getItem(int position) {
        return mItems.get(position) ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_my, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView partTextView = (TextView) convertView.findViewById(R.id.Type);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.Name) ;
        TextView gradeTextView = (TextView) convertView.findViewById(R.id.Grade) ;
        TextView ageTextView = (TextView) convertView.findViewById(R.id.Age);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        Listviewitem listViewItem = getItem(position);

        // 아이템 내 각 위젯에 데이터 반영
        partTextView.setText(listViewItem.getPart());
        nameTextView.setText(listViewItem.getName());
        gradeTextView.setText(listViewItem.getScore());
        ageTextView.setText(listViewItem.getAge());

        return convertView;
    }


    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String part, String name, String score,String age) {
        Listviewitem item1 = new Listviewitem();

        item1.setPart(part);
        item1.setName(name);
        item1.setScore(score);
        item1.setAge(age);

        mItems.add(item1);
    }
}
