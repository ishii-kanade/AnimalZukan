package com.laamile.animalzukan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laamile.animalzukan.db.AnimalDao
import com.laamile.animalzukan.db.AnimalEntity
import com.laamile.animalzukan.infra.usecase.GetAnimalByIDUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalDetailViewModel @Inject constructor(
    private val getAnimalByIDUseCase: GetAnimalByIDUseCase,
    private val animalDao: AnimalDao
) : ViewModel() {
    // お気に入り状態を保持する
    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()

    // お気に入りの追加・削除
    fun toggleFavorite(animal: AnimalEntity) {
        viewModelScope.launch {
            if (_isFavorite.value) {
                animalDao.deleteFavorite(animal)
            } else {
                animalDao.insertFavorite(animal)
            }
            _isFavorite.value = !_isFavorite.value
        }
    }

    private val _animalDetail = MutableStateFlow<GetAnimalByIDQuery.Data?>(null)
    val animalDetail: StateFlow<GetAnimalByIDQuery.Data?> = _animalDetail

    fun fetchAnimalDetail(animalId: String) {
        viewModelScope.launch {
            animalDao.getAllFavorites().forEach {
                if (it.animalID == animalId) {
                    _isFavorite.value = true
                }
            }
            try {
                val response = getAnimalByIDUseCase.invoke(animalId)
                if (response != null) {
                    _animalDetail.emit(response.data)
                }

            } catch (e: Exception) {
                // エラーハンドリング
                e.printStackTrace()
            }
        }
    }
}
