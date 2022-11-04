package com.binar.projectgroupmakerbinar.data.pref

interface SharedPreferenceDataSource {
    fun isSkipIntro() : Boolean
    fun setSkipIntro(isSkipIntro: Boolean)
}

class SharedPreferenceDataSourceImpl(private val preference : SharedPreference)
: SharedPreferenceDataSource {

    override fun isSkipIntro(): Boolean {
        return  preference.isSkipIntro()
    }

    override fun setSkipIntro(isSkipIntro: Boolean) {
        preference.setSkipIntro(isSkipIntro)
    }

}