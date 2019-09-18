package ui

import Utils.Constants
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.navinbangar.sampleapplication.R
import kotlinx.android.synthetic.main.people_details_layout.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
/**
 * Created by Navin Bangar on 9/19/2019.
 */

class PeopleDetailActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.people_details_layout)
        setUpPeopleDetails(intent.extras.getString(Constants.PEOPLE_NAME),
                intent.extras.getString(Constants.PEOPLE_SCORE))
        setUpCloseBtnListner()
    }

    private fun setUpPeopleDetails(name:String,score:String) {
        tvPeopleNameDetails.text= name
        tvPeopleScoreDetails.text=score
    }

    private fun setUpCloseBtnListner() {
        closeBtn.setOnClickListener{
            this.finish()
        }
    }
}