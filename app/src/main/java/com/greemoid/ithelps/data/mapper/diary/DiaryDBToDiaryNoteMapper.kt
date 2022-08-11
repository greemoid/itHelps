package com.greemoid.ithelps.data.mapper.diary

import com.greemoid.ithelps.data.mapper.Mapper
import com.greemoid.ithelps.data.models.DiaryNoteDB
import com.greemoid.ithelps.domain.models.diary.DiaryNote

class DiaryDBToDiaryNoteMapper : Mapper<List<DiaryNoteDB>, List<DiaryNote>> {
    override fun map(input: List<DiaryNoteDB>): List<DiaryNote> {

        val list = mutableListOf<DiaryNote>()
        input.forEach {
            list.add(DiaryNote(
                it.description,
                it.date
            ))
        }

        return list
    }
}