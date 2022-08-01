package com.greemoid.ithelps.data.mapper

import com.greemoid.ithelps.data.models.DiaryNoteDB
import com.greemoid.ithelps.domain.models.DiaryNote

class DiaryNoteToDiaryDBMapper : Mapper<DiaryNote, DiaryNoteDB> {
    override fun invoke(input: DiaryNote): DiaryNoteDB {
        return DiaryNoteDB(
            id = input.id,
            title = input.title,
            description = input.description,
            date = input.date
        )
    }

}