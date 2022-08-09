package com.greemoid.ithelps.data.mapper

import com.greemoid.ithelps.data.models.DiaryNoteDB
import com.greemoid.ithelps.domain.models.diary.DiaryNote

class DiaryNoteToDiaryDBMapper : Mapper<DiaryNote, DiaryNoteDB> {
    override fun map(input: DiaryNote): DiaryNoteDB {
        return DiaryNoteDB(
            description = input.description,
            date = input.date
        )
    }

}