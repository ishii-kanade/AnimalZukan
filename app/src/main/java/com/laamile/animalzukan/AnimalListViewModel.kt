package com.laamile.animalzukan

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalListViewModel @Inject constructor(
    private val animalRepository: AnimalRepository
) : ViewModel() {

    private val _animals = mutableStateListOf<GetAnimalsQuery.Animal>()
    val animals: List<GetAnimalsQuery.Animal> get() = _animals

    init {
        fetchAnimals()
    }

    private fun fetchAnimals() {
        viewModelScope.launch {
            val response = animalRepository.getAnimals(10)
            response?.data?.animals?.let { _animals.addAll(it) }
        }
    }
}
