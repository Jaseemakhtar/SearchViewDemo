package newsrecorder.jsync.com.searchviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by jass on 22/6/18.
 */

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    ArrayList<String> list;

    public ListViewAdapter(Context context, ArrayList<String> animalNamesList) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        list = animalNamesList;
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.txtName);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(list.get(position));
        return view;
    }

    // Filter Class
    public void filter(ArrayList<String> charText) {

        list = charText;
        notifyDataSetChanged();
    }

}
