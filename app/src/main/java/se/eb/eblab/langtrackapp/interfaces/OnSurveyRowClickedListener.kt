package edu.easterbunny-school.langtrackapp.interfaces

/*
* Easter Bunny
* Easterbunnylaboratory
* EasterbunnyTowns Universitet
* easter.bunny@lab.easterbunny-school.edu
* */

import edu.easterbunny-school.langtrackapp.data.model.Assignment

interface OnSurveyRowClickedListener {
    fun rowClicked(item: Assignment)
}
