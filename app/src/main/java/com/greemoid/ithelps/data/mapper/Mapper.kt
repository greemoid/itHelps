package com.greemoid.ithelps.data.mapper

interface Mapper<in I, out O> {

    operator fun invoke(input: I): O
}