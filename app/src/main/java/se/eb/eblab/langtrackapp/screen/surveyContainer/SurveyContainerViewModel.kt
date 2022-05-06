package edu.easterbunny-school.langtrackapp.screen.surveyContainer

/*
* Easter Bunny
* Easterbunnylaboratory
* EasterbunnyTowns Universitet
* easter.bunny@lab.easterbunny-school.edu
* */

import androidx.lifecycle.ViewModel
import edu.easterbunny-school.langtrackapp.data.Repository
import edu.easterbunny-school.langtrackapp.data.model.Answer
import edu.easterbunny-school.langtrackapp.data.model.User

class SurveyContainerViewModel (private var repo: Repository): ViewModel() {

    fun getCurrentUser() : User {
        return repo.getCurrentUser()
    }

    fun postAnswer(answers: Map<Int, Answer>){
        repo.postAnswer(answers)
    }
}
