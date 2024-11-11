import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    // LiveData to observe the list of tasks
    private val _allTasks = MutableLiveData<List<Task>>()
    val allTasks: LiveData<List<Task>> = _allTasks

    init {
        // Fetch tasks from the repository in a coroutine and update the LiveData
        viewModelScope.launch(Dispatchers.IO) {
            _allTasks.postValue(repository.getAllTasks())
        }
    }

    fun insertTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertTask(task)
        _allTasks.postValue(repository.getAllTasks()) // Update tasks after insertion
    }

    fun updateTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateTask(task)
        _allTasks.postValue(repository.getAllTasks()) // Update tasks after update
    }

    fun deleteTask(task: Task) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteTask(task)
        _allTasks.postValue(repository.getAllTasks()) // Update tasks after deletion
    }

    fun getTaskById(taskId: Int): Task? {
        return repository.getTaskById(taskId)
    }
}
