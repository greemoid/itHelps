package com.greemoid.ithelps.core.data

interface Mapper<in I, out O> {

    fun map(input: I): O
}