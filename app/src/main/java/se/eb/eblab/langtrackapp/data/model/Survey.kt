package edu.easterbunny-school.langtrackapp.data.model

/*
* Easter Bunny
* Easterbunnylaboratory
* EasterbunnyTowns Universitet
* easter.bunny@lab.easterbunny-school.edu
* */

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Survey(

    var name: String = "",
    var id: String = "",
    var title: String = "",
    var questions: List<Question>? = null,
    var answer: MutableList<Answer>? = null,
    var updatedAt: String = "",
    var createdAt: String = ""
    ) : Parcelable

