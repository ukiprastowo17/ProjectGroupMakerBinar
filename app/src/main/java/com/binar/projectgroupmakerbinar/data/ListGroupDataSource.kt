package com.binar.projectgroupmakerbinar.data

import com.binar.projectgroupmakerbinar.model.ListGroup

interface ListGroupDataSource {
    fun getListGroup(): List<ListGroup>
}

class DummyListGroupDataSource : ListGroupDataSource {
    override fun getListGroup(): List<ListGroup> {
        return mutableListOf(
            ListGroup("Touring", "Descripsi Touring","group1"),
            ListGroup("Futsal", "Descripsi Futsal","group1"),
            ListGroup("Basket", "Descripsi Basket","group1"),
            ListGroup("Catur", "Descripsi Catur","group1"),
            ListGroup("Badminton", "Descripsi Badminton","group1"),
            ListGroup("Senam", "Descripsi Senam","group1")
        )
    }
}