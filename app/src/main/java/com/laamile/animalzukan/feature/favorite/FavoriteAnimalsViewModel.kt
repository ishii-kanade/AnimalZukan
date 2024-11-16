package com.laamile.animalzukan.feature.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laamile.animalzukan.common.db.AnimalDao
import com.laamile.animalzukan.common.db.AnimalEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteAnimalsViewModel @Inject constructor(
    private val animalDao: AnimalDao
) : ViewModel() {

    private val _favoriteAnimals = MutableStateFlow<List<AnimalEntity>>(emptyList())
    val favoriteAnimals: StateFlow<List<AnimalEntity>> = _favoriteAnimals

    init {
        loadFavoriteAnimals()
    }

    private fun loadFavoriteAnimals() {
        viewModelScope.launch {
            _favoriteAnimals.value = animalDao.getAllFavorites()
        }
    }

    // お気に入りの追加
    suspend fun addFavorite(animal: AnimalEntity) {
        animalDao.insertFavorite(animal)
        loadFavoriteAnimals() // 更新されたリストを再取得
    }

    // お気に入りの削除
    suspend fun removeFavorite(animal: AnimalEntity) {
        animalDao.deleteFavorite(animal)
        loadFavoriteAnimals() // 更新されたリストを再取得
    }
}