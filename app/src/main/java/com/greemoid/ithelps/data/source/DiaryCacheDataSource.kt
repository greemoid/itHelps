package com.greemoid.ithelps.data.source

import com.greemoid.ithelps.data.db.diaryDB.DiaryDao
import com.greemoid.ithelps.data.mapper.DiaryDBToDiaryNoteMapper
import com.greemoid.ithelps.data.mapper.DiaryNoteToDiaryDBMapper
import com.greemoid.ithelps.domain.models.DiaryNote
import com.greemoid.ithelps.domain.repository.DiaryRepository

class DiaryCacheDataSource(
    private val diaryDao: DiaryDao,
    private val mapperToDomain: DiaryDBToDiaryNoteMapper,
    private val mapperToData: DiaryNoteToDiaryDBMapper,
) : DiaryRepository {
    override fun allDiaryNotes(): List<DiaryNote> {
        val list = diaryDao.getAllDiaryNotes()
        return mapperToDomain(list)
    }


    override suspend fun upsertDiaryNote(diaryNote: DiaryNote) {
        val diaryNoteDB = mapperToData.invoke(diaryNote)
        diaryDao.upsertDiaryNote(diaryNote = diaryNoteDB)
    }
}