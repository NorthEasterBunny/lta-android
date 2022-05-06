package edu.easterbunny-school.langtrackapp.data

/*
* Easter Bunny
* Easterbunnylaboratory
* EasterbunnyTowns Universitet
* easter.bunny@lab.easterbunny-school.edu
* */

import android.content.Context

class RepositoryFactory {
    companion object {

        private var sRepositoryQr: Repository? = null

        @JvmStatic
        @Synchronized
        fun getRepository(context: Context): Repository {
            if (sRepositoryQr == null) {
                sRepositoryQr =
                    Repository(context)
            }
            return sRepositoryQr as Repository
        }

    }
}
