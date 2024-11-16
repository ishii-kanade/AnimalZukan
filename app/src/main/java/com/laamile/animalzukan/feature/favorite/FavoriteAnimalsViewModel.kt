package com.laamile.animalzukan.feature.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laamile.animalzukan.common.db.AnimalDao
import com.laamile.animalzukan.common.db.AnimalEntity
import com.laamile.animalzukan.common.model.AnimalModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteAnimalsViewModel @Inject constructor(
    private val animalDao: AnimalDao
) : ViewModel() {

    private val _favoriteAnimals = MutableStateFlow<List<AnimalModel>>(emptyList())
    val favoriteAnimals: StateFlow<List<AnimalModel>> = _favoriteAnimals

    init {
        loadFavoriteAnimals()
    }

    private fun loadFavoriteAnimals() {
        viewModelScope.launch {
            // お気に入りのリストを取得
            val favorites = animalDao.getAllFavorites()

            // Animalに変換してから、_favoriteAnimalsにセット
            _favoriteAnimals.value = favorites.map { it.toAnimal() }
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