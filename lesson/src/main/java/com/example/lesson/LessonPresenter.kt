package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.util.*

class LessonPresenter(private val activity: LessonActivity) {
    private var lessons: List<Lesson> = ArrayList()
    private val type = object : TypeToken<List<Lesson?>?>() {}.type
    fun fetchData() {
        HttpClient.INSTANCE[LESSON_PATH, type, object : EntityCallback<List<Lesson?>?> {
            override fun onSuccess(entity: List<Lesson?>?) {
                this@LessonPresenter.lessons = entity as List<Lesson>
                activity.runOnUiThread { activity.showResult(lessons) }
            }

            override fun onFailure(message: String?) {
                activity.runOnUiThread { Utils.toast(message) }
            }
        }]
    }

    fun showPlayback() {
        val playbackLessons: MutableList<Lesson> = ArrayList()
        lessons.forEach {
            if (it.state === Lesson.State.PLAYBACK) {
                playbackLessons.add(it)
            }
        }
        activity.showResult(playbackLessons)
    }

    companion object {
        private const val LESSON_PATH = "lessons"
    }

}