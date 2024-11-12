package com.laamile.animalzukan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laamile.animalzukan.infra.usecase.GetAnimalByIDUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalDetailViewModel @Inject constructor(
    private val getAnimalByIDUseCase: GetAnimalByIDUseCase
) : ViewModel() {

    private val _animalDetail = MutableStateFlow<GetAnimalByIDQuery.Data?>(null)
    val animalDetail: StateFlow<GetAnimalByIDQuery.Data?> = _animalDetail

    fun fetchAnimalDetail(animalId: String) {
        viewModelScope.launch {
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
