package edu.easterbunny-school.langtrackapp.screen.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.easterbunny-school.langtrackapp.data.RepositoryFactory

class LoginViewModelFactory(var context: Context): ViewModelProvider.Factory {

    val mMainViewModel =  LoginViewModel(RepositoryFactory.getRepository(context))

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = LoginViewModel(RepositoryFactory.getRepository(context)) as T
}
