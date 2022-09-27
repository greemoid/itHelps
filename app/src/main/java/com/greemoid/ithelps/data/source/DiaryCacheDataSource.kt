package com.greemoid.ithelps.data.source

import android.util.Log
import com.greemoid.ithelps.data.db.DiaryDao
import com.greemoid.ithelps.data.mapper.diary.DiaryDBToDiaryNoteMapper
import com.greemoid.ithelps.data.mapper.diary.DiaryNoteToDiaryDBMapper
import com.greemoid.ithelps.data.mapper.diary.LastDiaryNoteDBToNoteMapper
import com.greemoid.ithelps.domain.models.diary.DiaryNote
import com.greemoid.ithelps.domain.repository.DiaryRepository
import javax.inject.Inject

class DiaryCacheDataSource @Inject constructor(
    private val diaryDao: DiaryDao,
    private val mapperToDomain: DiaryDBToDiaryNoteMapper,
    private val lastMapperToDomain: LastDiaryNoteDBToNoteMapper,
    private val mapperToData: DiaryNoteToDiaryDBMapper,
) : DiaryRepository {


    override fun getAllDiaryNotes(): List<DiaryNote> {
        val list = diaryDao.getAllDiaryNotes()
        return mapperToDomain.map(list)
    }

    //todo fix
    override suspend fun getLastDiaryNote(): DiaryNote {
        var note = DiaryNote("", "")
        try {
            note = lastMapperToDomain.map(diaryDao.getLastNoteDiary())
        } catch (e: Exception) {
            Log.d("SOURCE", e.toString())
        }
        return note
    }


    override suspend fun upsertDiaryNote(diaryNote: DiaryNote) {
        val diaryNoteDB = mapperToData.map(diaryNote)
        diaryDao.upsertDiaryNote(diaryNote = diaryNoteDB)
    }
}