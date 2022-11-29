package ex2india.com.pointofinterest.category;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

import ex2india.com.pointofinterest.R;
import ex2india.com.pointofinterest.nearByPlacesApi.PoiCategory;

public class POICategoryAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<PoiCategory> interestArray;
    private final PoiCategory selected;

    public POICategoryAdapter(Context context, List<PoiCategory> interestArray, PoiCategory selected) {
        this.mContext = context;
        this.interestArray = interestArray;
        this.selected = selected;
    }

    public int getCount() {
        return interestArray.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_poi_category, parent, false);
        }
        if (interestArray.get(position).getNhnCategoryName().equalsIgnoreCase(selected.getNhnCategoryName())) {
            convertView.setBackgroundColor(ContextCompat.getColor(parent.getContext(), R.color.selected_poi_category));
        } else {
            convertView.setBackgroundColor(Color.LTGRAY);
        }

        TextView textView = convertView.findViewById(R.id.poi_interest);
        textView.setText(interestArray.get(position).getNhnCategoryName());
        return convertView;
    }


}
