package edu.easterbunny-school.langtrackapp.screen.login

import androidx.lifecycle.ViewModel
import edu.easterbunny-school.langtrackapp.data.Repository
import edu.easterbunny-school.langtrackapp.data.model.User

class LoginViewModel(repo: Repository): ViewModel() {

    var mRepository: Repository = repo

    fun setCurrentUser(user: User){
        mRepository.setCurrentUser(user)
    }

    fun putDeviceToken(){
        mRepository.putDeviceToken()
    }
}
