package com.greemoid.ithelps.domain.repository

interface DateOfAddingRepository {

    fun saveDateOfAdding(date: String)

    fun getDateOfAdding(): String
}