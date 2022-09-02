package com.greemoid.ithelps.data.mapper

interface Mapper<in I, out O> {

    fun map(input: I): O
}