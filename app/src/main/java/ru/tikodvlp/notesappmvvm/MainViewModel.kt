package ru.tikodvlp.notesappmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.tikodvlp.notesappmvvm.database.room.AppRoomDatabase
import ru.tikodvlp.notesappmvvm.database.room.repository.RoomRepository
import ru.tikodvlp.notesappmvvm.model.Note
import ru.tikodvlp.notesappmvvm.utils.REPOSITORY
import ru.tikodvlp.notesappmvvm.utils.TYPE_FIREBASE
import ru.tikodvlp.notesappmvvm.utils.TYPE_ROOM
import java.lang.IllegalArgumentException

class MainViewModel (application: Application) : AndroidViewModel(application) {

    val context = application

    fun initDatabase(type: String, onSuccess: ()-> Unit) {
        Log.d("checkData", "MainViewModel initDatabase with $type")
        when(type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
    }

    fun addNote(note: Note, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.create(note = note) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllNotes() = REPOSITORY.readAll
}
class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}