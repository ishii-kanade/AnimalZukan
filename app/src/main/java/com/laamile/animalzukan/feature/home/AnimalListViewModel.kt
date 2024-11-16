package com.laamile.animalzukan.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laamile.animalzukan.common.infra.usecase.GetAnimalsUseCase
import com.laamile.animalzukan.common.model.AnimalModel
import com.laamile.animalzukan.common.util.toAnimals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalListViewModel @Inject constructor(
    private val getAnimalsUseCase: GetAnimalsUseCase
) : ViewModel() {

    private val _animals = MutableStateFlow<List<AnimalModel>>(emptyList())
    val animals: StateFlow<List<AnimalModel>> = _animals

    init {
        fetchAnimals()
    }

    private fun fetchAnimals() {
        viewModelScope.launch {
            val response = getAnimalsUseCase(10)
            response?.data?.animals?.let {
                _animals.value = it.toAnimals() // StateFlow の値を更新
            }
        }
    }
}
