package com.binar.projectgroupmakerbinar.data

import com.binar.projectgroupmakerbinar.model.ListGroup

interface ListGroupDataSource {
    fun getListGroup(): List<ListGroup>
}

class DummyListGroupDataSource : ListGroupDataSource {
    override fun getListGroup(): List<ListGroup> {
        return mutableListOf(
            ListGroup("Touring", "Descripsi Touring"),
            ListGroup("Futsal", "Descripsi Futsal"),
            ListGroup("Basket", "Descripsi Basket"),
            ListGroup("Catur", "Descripsi Catur"),
            ListGroup("Badminton", "Descripsi Badminton"),
            ListGroup("Senam", "Descripsi Senam")
        )
    }
}