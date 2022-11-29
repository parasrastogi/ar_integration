package ex2india.com.pointofinterest;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import com.bhi.commonlib.nearByPlaces.model.NearByPlace;
import com.bhi.commonlib.util.Logger;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.rendering.ViewRenderable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import uk.co.appoly.arcorelocation.LocationMarker;
import uk.co.appoly.arcorelocation.LocationScene;

/**
 * This class renders multiple POIs.
 */
class PoiGroupRenderer {

    private final Context context;
    private final LocationScene locationScene;
    private int totalPlaces;
    private int renderedPlaces;

    PoiGroupRenderer(Context context, LocationScene locationScene) {
        this.context = context;
        this.locationScene = locationScene;
    }

    void render(List<NearByPlace> placesList, PoiGroupRenderListener poiGroupRenderListener) {
        totalPlaces = placesList.size();
        renderedPlaces = 0;

        for (NearByPlace place : placesList) {
            render(context, place, locationScene, () -> {
                renderedPlaces++;

                if (totalPlaces == renderedPlaces) {
                    poiGroupRenderListener.onPoiGroupRendered();
                }
            });
            Logger.INSTANCE.d(this, "Added -> " + place.getName() + ", marker count ->" + locationScene.mLocationMarkers.size());
        }
    }

    @TargetApi(Build.VERSION_CODES.N)
    private void render(Context c, NearByPlace place, LocationScene locationScene, PoiRenderListener poiRenderListener) {

        CompletableFuture<ViewRenderable> couponLayout =
                ViewRenderable.builder()
                        .setView(c, R.layout.item_poi_annotation)
                        .build();

        CompletableFuture.allOf(couponLayout)
                .handle(
                        (notUsed, throwable) -> {
                            if (throwable != null) {
                                Logger.INSTANCE.d(this, "Unable to load renderables");
                                return null;
                            }

                            try {
                                // Non scalable info outside location
                                ViewRenderable vr = couponLayout.get();
                                Node base = new Node();
                                base.setRenderable(vr);
                                TextView title = vr.getView().findViewById(R.id.name);
                                title.setText(place.getName());

                                LocationMarker couponLocationMarker = new LocationMarker(
                                        place.getGeometry().getLocation().getLng(),
                                        place.getGeometry().getLocation().getLat(),
                                        base
                                );
                                couponLocationMarker.setRenderEvent(node -> {
                                    View eView = vr.getView();
                                    TextView distanceTextView = eView.findViewById(R.id.distance);
                                    String distance = String.format("%.02f miles", node.getDistance() / 1609.34);
                                    distanceTextView.setText(distance);

                                    if (null != poiRenderListener) {
                                        poiRenderListener.onPoiRendered();
                                    }
                                });
                                locationScene.mLocationMarkers.add(couponLocationMarker);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            return null;
                        });
    }

    private interface PoiRenderListener {
        void onPoiRendered();
    }


    public interface PoiGroupRenderListener {
        void onPoiGroupRendered();
    }

}