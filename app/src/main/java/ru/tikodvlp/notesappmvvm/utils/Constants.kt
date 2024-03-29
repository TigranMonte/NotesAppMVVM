package ru.tikodvlp.notesappmvvm.utils

import androidx.compose.runtime.mutableStateOf
import ru.tikodvlp.notesappmvvm.database.DatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
const val FIREBASE_ID = "firebaseId"

lateinit var REPOSITORY: DatabaseRepository
lateinit var LOGIN: String
lateinit var PASSWORD: String
var DB_TYPE = mutableStateOf("")

object Constants {
    object Keys {
        const val NOTE_DATABASE = "notes_database"
        const val NOTES_TABLE = "notes_table"
        const val ADD_NEW_NOTE = "Add new note"
        const val ADD_NOTE = "Add note"
        const val NOTE_TITLE = "Note title"
        const val NOTE_SUBTITLE = "Note subtitle"
        const val TITLE = "title"
        const val SUBTITLE = "subtitle"
        const val WHAT_WILL_WE_USE = "What will we use?"
        const val ROOM_DATABASE = "Room database"
        const val FIREBASE_DATABASE = "Firebase database"
        const val ID = "Id"
        const val NONE = "none"
        const val UPDATE = "UPDATE"
        const val UPDATE_NOTE = "Update note"
        const val DELETE = "DELETE"
        const val NAV_BACK = "BACK"
        const val EDIT_NOTE = "Edit note"
        const val LOG_IN = "Log In"
        const val EMPTY = ""
        const val SIGN_IN = "Sign in"
        const val LOGIN_TEXT = "Login"
        const val PASSWORD_TEXT = "Password"

    }
    object Screens {
        const val START_SCREEN = "start_screen"
        const val MAIN_SCREEN = "main_screen"
        const val ADD_SCREEN = "add_screen"
        const val NOTE_SCREEN = "note_screen"
    }
}