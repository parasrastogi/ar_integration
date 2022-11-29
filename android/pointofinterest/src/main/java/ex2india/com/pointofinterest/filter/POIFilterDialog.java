package ex2india.com.pointofinterest.filter;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bhi.commonlib.widgets.recyclerview.itemdecorator.ItemDecorationGrid;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

import ex2india.com.pointofinterest.PointOfInterestActivity;
import ex2india.com.pointofinterest.R;
import ex2india.com.pointofinterest.category.POICategoryAdapter;
import ex2india.com.pointofinterest.nearByPlacesApi.PoiCategory;
import ex2india.com.pointofinterest.radius.POIRadiusAdapter;
import ex2india.com.pointofinterest.radius.Radius;

public class POIFilterDialog extends BottomSheetDialog {

    public POIFilterDialog(@NonNull Context context) {
        super(context);
    }

    /**
     * Creates instance of POIFilterDialog.
     */
    public static POIFilterDialog newInstance(PointOfInterestActivity activity, POIFilterListener poiFilterListener,
                                              List<PoiCategory> interestList, List<Radius> radiusList,
                                              Radius selectedRadius, PoiCategory selectedInterest) {

        POIFilterDialog poiFilterDialog = new POIFilterDialog(activity);
        poiFilterDialog.setCancelable(true);
        poiFilterDialog.setCanceledOnTouchOutside(true);
        View sheetView = View.inflate(activity, R.layout.layout_point_of_interest_bottom_sheet, null);
        GridView categoryGridView = sheetView.findViewById(R.id.grid_view_category);
        RecyclerView radiusRV = sheetView.findViewById(R.id.rv_radius);

        POICategoryAdapter poiCategoryAdapter = new POICategoryAdapter(activity, interestList, selectedInterest);
        categoryGridView.setAdapter(poiCategoryAdapter);

        int columnCount = 4;
        POIRadiusAdapter poiRadiusAdapter = new POIRadiusAdapter(radiusList, selectedRadius, poiFilterListener);
        radiusRV.setAdapter(poiRadiusAdapter);
        radiusRV.setLayoutManager(new GridLayoutManager(activity, columnCount));
        radiusRV.addItemDecoration(new ItemDecorationGrid(columnCount,
                (int) activity.getResources().getDimension(R.dimen.space_xxxsmall), false, false));

        categoryGridView.setOnItemClickListener((parent, view, position, id) -> {
            PoiCategory selectedInterest1 = interestList.get(position);

            poiFilterDialog.dismiss();
            poiFilterListener.onCategorySelected(selectedInterest1);
        });

        poiFilterDialog.setContentView(sheetView);

        poiFilterDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        return poiFilterDialog;
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
