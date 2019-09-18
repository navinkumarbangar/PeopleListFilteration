package com.example.navinbangar.sampleapplication

import junit.framework.TestCase.assertEquals
import model.People
import org.junit.Assert.assertThat
import org.junit.Test

/**
 * Created by Navin Bangar on 9/19/2019.
 */

class  PeopleListFilteration{

    @Test
    fun filterPeopleList() {
        val peopleList= mutableListOf(People("Stephen","87"),People("Wayne","57"),People("Marcus","76"))
        val filteredPeopleList = peopleList.filter { it.score.toInt() > 60 }
        val expectedPeopleList = mutableListOf(People("Stephen","87"),People("Marcus","76"))

        assertEquals(expectedPeopleList, filteredPeopleList)

    }
}