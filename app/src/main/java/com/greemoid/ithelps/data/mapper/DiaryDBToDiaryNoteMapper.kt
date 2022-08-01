package com.greemoid.ithelps.data.mapper

import com.greemoid.ithelps.data.models.DiaryNoteDB
import com.greemoid.ithelps.domain.models.DiaryNote

class DiaryDBToDiaryNoteMapper : Mapper<List<DiaryNoteDB>, List<DiaryNote>> {
    override fun invoke(input: List<DiaryNoteDB>): List<DiaryNote> {
        /*return DiaryNote(
            id = input.id,
            title = input.title,
            description = input.description,
            date = input.date
        )*/
        /*val list = mutableListOf<DiaryNote>()
        list.forEach {
            list.add(DiaryNote(
                input.id,
                title = input.title,
                description = input.description,
                date = input.date
            ))
        }
        return list*/
        val list = mutableListOf<DiaryNote>()
        input.forEach {
            list.add(DiaryNote(
                it.id,
                it.title,
                it.description,
                it.date
            ))
        }

        return list
    }
}