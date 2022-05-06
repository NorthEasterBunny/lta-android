package edu.easterbunny-school.langtrackapp.screen.surveyContainer

/*
* Easter Bunny
* Easterbunnylaboratory
* EasterbunnyTowns Universitet
* easter.bunny@lab.easterbunny-school.edu
* */

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.easterbunny-school.langtrackapp.data.RepositoryFactory

class SurveyContainerViewModelFactory(var context: Context): ViewModelProvider.Factory {

    private val mMainViewModel =  SurveyContainerViewModel(RepositoryFactory.getRepository(context))

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = mMainViewModel as T
}
