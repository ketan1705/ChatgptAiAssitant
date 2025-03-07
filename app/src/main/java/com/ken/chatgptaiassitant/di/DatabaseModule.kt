package com.ken.chatgptaiassitant.di

import android.content.Context
import androidx.room.Room
import com.ken.chatgptaiassitant.database.ChatDao
import com.ken.chatgptaiassitant.database.ChatGptDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ChatGptDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = ChatGptDatabase::class.java,
            name = "chatgpt_db"
        ).build()

    }

    @Singleton
    @Provides
    fun provideDao(database: ChatGptDatabase): ChatDao {
        return database.chatDao()
    }
}