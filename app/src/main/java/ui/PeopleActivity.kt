package ui

import Utils.Constants
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.navinbangar.sampleapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import viewmodel.PeopleListViewModel
import android.support.v7.widget.DividerItemDecoration



/**
 * Created by Navin Bangar on 9/18/2019.
 */

class PeopleActivity: AppCompatActivity(){

    private lateinit var peopleListViewModel: PeopleListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        setUpPeopleList()
        setUpAdapter()
    }

    private fun setUpRecyclerView() {
        peopleListViewModel= ViewModelProviders.of(this).get(PeopleListViewModel::class.java)
    }

    private fun setUpPeopleList() {
        peopleListViewModel.setUpPeopleList()
        peopleListViewModel.filteredPeopleList()
    }
    private fun setUpAdapter() {
        rvPeopleList.apply {
            layoutManager = LinearLayoutManager(this@PeopleActivity)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = PeopleListAdapter(peopleListViewModel.getFilteredPeopleList()){
                val intent = Intent(this@PeopleActivity, PeopleDetailActivity::class.java)
                intent.putExtra(Constants.PEOPLE_NAME,peopleListViewModel.getFilteredPeopleList()[it].name)
                intent.putExtra(Constants.PEOPLE_SCORE,peopleListViewModel.getFilteredPeopleList()[it].score)
                startActivity(intent)
            }
        }
    }
}