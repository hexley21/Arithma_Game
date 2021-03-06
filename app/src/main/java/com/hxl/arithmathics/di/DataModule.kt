package com.hxl.arithmathics.di

import android.content.Context
import com.hxl.data.repository.CustomRepositoryImpl
import com.hxl.data.repository.GameHistoryRepositoryImpl
import com.hxl.data.repository.PreferenceRepositoryImpl
import com.hxl.data.repository.QuestionRepositoryImpl
import com.hxl.data.storage.InternalStorage
import com.hxl.data.storage.PreferenceStorage
import com.hxl.data.storage.internal.FileStorage
import com.hxl.data.storage.sharedprefs.SharedPreferenceStorage
import com.hxl.domain.repository.CustomRepository
import com.hxl.domain.repository.GameHistoryRepository
import com.hxl.domain.repository.PreferenceRepository
import com.hxl.domain.repository.QuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun providePreferenceStorage(@ApplicationContext context: Context): PreferenceStorage {
        return SharedPreferenceStorage(context)
    }

    @Provides
    @Singleton
    fun providePreferenceRepository(preferenceStorage: PreferenceStorage): PreferenceRepository {
        return PreferenceRepositoryImpl(preferenceStorage)
    }

    @Provides
    @Singleton
    fun provideQuestionRepository(): QuestionRepository {
        return QuestionRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideInternalStorage(@ApplicationContext context: Context): InternalStorage {
        return FileStorage(context)
    }

    @Provides
    @Singleton
    fun provideCustomRepository(internalStorage: InternalStorage): CustomRepository {
        return CustomRepositoryImpl(internalStorage)
    }

    @Provides
    @Singleton
    fun provideGameHistoryRepository(internalStorage: InternalStorage): GameHistoryRepository {
        return GameHistoryRepositoryImpl(internalStorage)
    }
}