package ex2india.com.furnituredrop.dropdialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ex2india.com.furnituredrop.R;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private final OnItemClickListener listener;
    private Integer[] dataArray;

    public DataAdapter(Integer[] dataArray, OnItemClickListener listener) {
        this.dataArray = dataArray;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_furniture, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mImageView.setImageResource(dataArray[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataArray.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mImageView = v.findViewById(R.id.image_view);
        }
    }


}
