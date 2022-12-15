package ru.samsung.itschool.mdev.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import org.w3c.dom.Text

class MyAdapter(val list: List<Person>) : RecyclerView.Adapter<MyAdapter.MyView>() {

    class MyView(item: View) : RecyclerView.ViewHolder(item) {
        val textViewName: TextView = item.findViewById(R.id.tvName)
        val textViewPhone: TextView = item.findViewById(R.id.tvPhone)
        val imageViewSex: ImageView = item.findViewById(R.id.imgSex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
       holder.textViewName.text = list.get(position).name
       holder.textViewPhone.text = list.get(position).phoneNumber
       holder.imageViewSex.setImageResource(
           when(list.get(position).sex) {
               'M' -> R.drawable.ic_baseline_man_24
               else -> R.drawable.ic_baseline_woman_24
           }
       )
    }

    override fun getItemCount() = list.size
}