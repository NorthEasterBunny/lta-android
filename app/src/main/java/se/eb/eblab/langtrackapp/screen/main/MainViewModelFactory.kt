package edu.easterbunny-school.langtrackapp.screen.main

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

class MainViewModelFactory(var context: Context): ViewModelProvider.Factory {

    val mMainViewModel =  MainViewModel(RepositoryFactory.getRepository(context))

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainViewModel(RepositoryFactory.getRepository(context)) as T
}
