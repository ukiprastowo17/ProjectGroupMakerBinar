package com.binar.projectgroupmakerbinar.data

import com.binar.projectgroupmakerbinar.model.ListMember

interface ListMemberDataSource {
    fun getListMember(): List<ListMember>
}

class DummyMemberDataSource : ListMemberDataSource {
    override fun getListMember(): List<ListMember> {
        return mutableListOf(
            ListMember("Member Satu"),
            ListMember("Member Dua"),
            ListMember("Member Tiga"),
            ListMember("Member Empat"),
            ListMember("Member Lima"),
            ListMember("Member Enam"),
            ListMember("Member Tujuh"),
            ListMember("Member Tujuh"),
            ListMember("Member Tujuh"),
            ListMember("Member Tujuh"),
            ListMember("Member Tujuh"),
            ListMember("Member Tujuh"),
            ListMember("Member Tujuh"),
            ListMember("Member Tujuh"),
            ListMember("Member Tujuh"),
            ListMember("Member Tujuh"),
            ListMember("Member Tujuh"),
        )
    }
}