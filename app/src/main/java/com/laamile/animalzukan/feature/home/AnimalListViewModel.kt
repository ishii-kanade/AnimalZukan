package com.laamile.animalzukan.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laamile.animalzukan.GetAnimalsQuery
import com.laamile.animalzukan.common.infra.usecase.GetAnimalsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalListViewModel @Inject constructor(
    private val getAnimalsUseCase: GetAnimalsUseCase
) : ViewModel() {

    private val _animals = MutableStateFlow<List<GetAnimalsQuery.Animal>>(emptyList())
    val animals: StateFlow<List<GetAnimalsQuery.Animal>> = _animals

    init {
        fetchAnimals()
    }

    private fun fetchAnimals() {
        viewModelScope.launch {
            val response = getAnimalsUseCase(10)
            response?.data?.animals?.let {
                _animals.value = it // StateFlow の値を更新
            }
        }
    }
}
