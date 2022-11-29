package ex2india.com.furnituredrop.dropdialog;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import ex2india.com.furnituredrop.FurnitureDropActivity;
import ex2india.com.furnituredrop.R;

public class FurnitureDropDialog extends BottomSheetDialog {


    public FurnitureDropDialog(@NonNull Context context) {
        super(context);
    }

    public static FurnitureDropDialog newInstance(FurnitureDropActivity activity, OnFurnitureSelectionListener onFurnitureSelectionListener) {
        View dialogView = activity.getLayoutInflater().inflate(R.layout.dialog_furniture_drop_bottom_sheet, null);
        RecyclerView furnitureSetRecyclerView = dialogView.findViewById(R.id.furniture_set_recycler_view);

        //Adding furniture sets
        RecyclerView.LayoutManager furnitureSetLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        furnitureSetRecyclerView.setLayoutManager(furnitureSetLayoutManager);

        Integer[] furnitureSets = new Integer[]{R.drawable.furniture_image1,
                R.drawable.furniture_image2,
                R.drawable.furniture_image3,
                R.drawable.furniture_image4,
                R.drawable.furniture_image5,
                R.drawable.furniture_image6};
        RecyclerView.Adapter furnitureSetAdapter = new DataAdapter(furnitureSets, new OnItemClickListener() {
            @Override
            public void onItemClick(Integer position) {
                onFurnitureSelectionListener.onFurnitureSetSelected(position);
            }
        });

        furnitureSetRecyclerView.setAdapter(furnitureSetAdapter);

        //Creating add furniture dialog
        FurnitureDropDialog furnitureDropDialog = new FurnitureDropDialog(activity);
        furnitureDropDialog.setContentView(dialogView);

        furnitureDropDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        return furnitureDropDialog;
    }


    @Override
    public void show() {
        super.show();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }

}
