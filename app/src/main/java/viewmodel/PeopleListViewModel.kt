package viewmodel

import android.arch.lifecycle.ViewModel
import model.People

/**
 * Created by Navin Bangar on 9/18/2019.
 */

class PeopleListViewModel:ViewModel(){
    private var peopleList:MutableList<People> = mutableListOf()
    private var filteredPeopleList:MutableList<People> = mutableListOf()

    fun getFilteredPeopleList(): MutableList<People> = filteredPeopleList

    fun filteredPeopleList():MutableList<People>{
        filteredPeopleList.clear()
        peopleList.forEach {
            if(it.score.toInt() > 60){
                filteredPeopleList.add(it)
            }
        }
        return filteredPeopleList
    }

   fun setUpPeopleList(){
       peopleList.clear()
       peopleList.add(People("Stephen","87"))
       peopleList.add(People("Wayne","67"))
       peopleList.add(People("Marcus","92"))
       peopleList.add(People("Andreas","42"))
       peopleList.add(People("Anthony","76"))
       peopleList.add(People("Alexis","81"))
       peopleList.add(People("David","91"))
       peopleList.add(People("Jon","57"))
       peopleList.add(People("Emma","82"))
   }
}