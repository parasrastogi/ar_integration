package ex2india.com.pointofinterest.radius;

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import ex2india.com.pointofinterest.R
import ex2india.com.pointofinterest.filter.POIFilterListener

class POIRadiusAdapter(private val radiusList: List<Radius>, private val selectedRadius: Radius,
                       private val poiFilterListener: POIFilterListener)
    : androidx.recyclerview.widget.RecyclerView.Adapter<POIRadiusAdapter.RadiusAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadiusAdapter {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_poi_category, parent, false)
        return RadiusAdapter(itemView)
    }

    override fun getItemCount(): Int {
        return radiusList.size
    }

    override fun onBindViewHolder(holder: RadiusAdapter, position: Int) {
        if (radiusList[position].radiusMiles == selectedRadius.radiusMiles) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.selected_poi_category))
        } else {
            holder.itemView.setBackgroundColor(Color.LTGRAY)
        }

        holder.titleTV.text = radiusList[position].title

        holder.titleTV.setOnClickListener {
            val radius = radiusList[holder.adapterPosition]

            poiFilterListener.onRadiusSelected(radius)
        }
    }

    class RadiusAdapter(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        val titleTV: TextView = itemView.findViewById<TextView>(R.id.poi_interest)
    }
}