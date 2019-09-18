package ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navinbangar.sampleapplication.R
import model.People
import kotlinx.android.synthetic.main.people_list_item_layout.view.*

/**
 * Created by Navin Bangar on 9/18/2019.
 */

class  PeopleListAdapter(private val peopleList:List<People>,private var onPeopleItemClicked: (Int) -> Unit):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int):RecyclerView.ViewHolder  {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.people_list_item_layout, parent, false)
        return PeopleListViewHolder(view)
    }

    override fun getItemCount(): Int {
       return peopleList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
             holder.itemView.tvPeopleName.text=peopleList.get(position).name
             holder.itemView.tvPeopleScore.text=peopleList.get(position).score
             holder.itemView.setOnClickListener {
              onPeopleItemClicked.invoke(position)
             }
    }

    class PeopleListViewHolder(private var view: View):RecyclerView.ViewHolder(view){
    }
}