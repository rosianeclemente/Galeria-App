package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.database.ClosetRepositoryDao
import com.example.myapplication.model.ClosetGram

class ClosetViewModel(private val closetRepository: ClosetRepositoryDao) : ViewModel(){
    fun insert(closet: ClosetGram) {
        closetRepository.insert(closet)
    }
    fun getAll(): LiveData<List<ClosetGram>> {
        return closetRepository.getAll()
    }
    fun delete(id: ClosetGram) {
        closetRepository.delete(id)
    }
}
class ClosetViewModelFactory(private val repository: ClosetRepositoryDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ClosetViewModel(repository) as T
    }

}