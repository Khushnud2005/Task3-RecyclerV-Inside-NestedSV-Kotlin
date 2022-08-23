package uz.exemple.task3_recyclerv_inside_nestedsv_k.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.task3_recyclerv_inside_nestedsv_k.R
import uz.exemple.task3_recyclerv_inside_nestedsv_k.model.DataModel

class ItemAdapter(var mList:List<DataModel> ):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var list: List<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val model = mList[position]
        holder.mTextView.text = model.getItemText()

        val isExpandable = model.isExpandable()
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        if (isExpandable) {
            holder.mArrowImage.setImageResource(R.drawable.arrow_up)
        } else {
            holder.mArrowImage.setImageResource(R.drawable.arrow_down)
        }
        val adapter = NestedAdapter(list)
        holder.nestedRV.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.nestedRV.setHasFixedSize(true)
        holder.nestedRV.adapter = adapter

        holder.linearLayout.setOnClickListener {
            model.setExpandable(!model.isExpandable())
            list = model.getNestedList()!!
            notifyItemChanged(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var linearLayout: LinearLayout
        lateinit var expandableLayout: RelativeLayout
        lateinit var mTextView: TextView
        lateinit var mArrowImage: ImageView
        lateinit var nestedRV: RecyclerView

        init {

            linearLayout = itemView.findViewById(R.id.linear_layout)
            expandableLayout = itemView.findViewById(R.id.expandable_layout)
            mTextView = itemView.findViewById(R.id.itemTv)
            mArrowImage = itemView.findViewById(R.id.arrowIv)
            nestedRV = itemView.findViewById(R.id.child_RV)
        }
    }
}