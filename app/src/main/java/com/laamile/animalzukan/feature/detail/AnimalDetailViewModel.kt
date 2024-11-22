package com.laamile.animalzukan.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laamile.animalzukan.common.db.AnimalDao
import com.laamile.animalzukan.common.db.AnimalEntity
import com.laamile.animalzukan.common.infra.SoundPlayer
import com.laamile.animalzukan.common.infra.usecase.GetAnimalByIDUseCase
import com.laamile.animalzukan.common.model.DetailAnimalModel
import com.laamile.animalzukan.common.util.toDetailAnimalModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalDetailViewModel @Inject constructor(
    private val getAnimalByIDUseCase: GetAnimalByIDUseCase,
    private val animalDao: AnimalDao,
    private val soundPlayer: SoundPlayer
) : ViewModel() {
    // お気に入り状態を保持する
    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()

    fun playAnimalSound(soundURL: String) {
        soundPlayer.playSoundFromUrl(soundURL)
    }

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

    private val _animalDetail = MutableStateFlow<DetailAnimalModel?>(null)
    val animalDetail: StateFlow<DetailAnimalModel?> = _animalDetail

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
                    _animalDetail.emit(response.data?.toDetailAnimalModel())
                }

            } catch (e: Exception) {
                // エラーハンドリング
                e.printStackTrace()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        soundPlayer.stopSound()
    }
}
