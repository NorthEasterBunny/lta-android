package edu.easterbunny-school.langtrackapp.screen.overview

import androidx.lifecycle.ViewModel
import edu.easterbunny-school.langtrackapp.data.Repository

class OverviewViewModel(repo: Repository): ViewModel() {
    var mRepository: Repository = repo

}
