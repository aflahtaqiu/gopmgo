package com.gopmgo.data.local;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Context;

import com.gopmgo.model.Questionnaire;
import com.gopmgo.data.local.dao.QuestionnaireDao;


// TODO: add your class model here in entities params and separate with comma
@Database(entities = {Questionnaire.class}, version = 1)
public abstract class LocalDatabase extends RoomDatabase {

    private static LocalDatabase localDatabase;
    private static String dbName = "local_database";

    public static LocalDatabase createDatabase(Context context) {
        synchronized (LocalDatabase.class) {
            if (localDatabase == null)
                localDatabase = Room.databaseBuilder(context, LocalDatabase.class, dbName)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
        }
        return localDatabase;
    }

    public abstract QuestionnaireDao questionnaireDao();
    // TODO: declare your daos as abstract variable and use public access modifier
}