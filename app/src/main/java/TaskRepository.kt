class TaskRepository(private val taskDao: TaskDao) {

    suspend fun getAllTasks(): List<Task> {
        return taskDao.getAllTasks() // Assuming this is a suspend function
    }

    suspend fun insertTask(task: Task) {
        taskDao.insertTask(task) // Assuming this is a suspend function
    }

    suspend fun updateTask(task: Task) {
        taskDao.updateTask(task) // Assuming this is a suspend function
    }

    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task) // Assuming this is a suspend function
    }

    fun getTaskById(taskId: Int): Task? {
        return taskDao.getTaskById(taskId) // Assuming this is a non-suspend function
    }
}
