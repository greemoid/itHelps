package com.greemoid.ithelps.data.source

import com.greemoid.ithelps.data.db.DiaryDao
import com.greemoid.ithelps.data.mapper.diary.DiaryDBToDiaryNoteMapper
import com.greemoid.ithelps.data.mapper.diary.DiaryNoteToDiaryDBMapper
import com.greemoid.ithelps.domain.models.diary.DiaryNote
import com.greemoid.ithelps.domain.repository.DiaryRepository

class DiaryCacheDataSource(
    private val diaryDao: DiaryDao,
    private val mapperToDomain: DiaryDBToDiaryNoteMapper,
    private val mapperToData: DiaryNoteToDiaryDBMapper,
) : DiaryRepository {


    override fun getAllDiaryNotes(): List<DiaryNote> {
        val list = diaryDao.getAllDiaryNotes()
        return mapperToDomain.map(list)
    }


    override suspend fun upsertDiaryNote(diaryNote: DiaryNote) {
        val diaryNoteDB = mapperToData.map(diaryNote)
        diaryDao.upsertDiaryNote(diaryNote = diaryNoteDB)
    }
}