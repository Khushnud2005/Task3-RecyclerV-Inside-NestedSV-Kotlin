package uz.exemple.task3_recyclerv_inside_nestedsv_k.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.task3_recyclerv_inside_nestedsv_k.R

class NestedAdapter(var mList: List<String>):RecyclerView.Adapter<NestedAdapter.NestedViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NestedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.nested_item, parent, false)

        return NestedViewHolder(view)
    }

    override fun onBindViewHolder(holder: NestedViewHolder, position: Int) {
        holder.mTv.setText(mList.get(position))
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class NestedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val mTv: TextView

        init {
            mTv = itemView.findViewById(R.id.nestedItemTV)
        }
    }


}