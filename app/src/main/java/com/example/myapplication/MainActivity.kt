import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main31)

        // Initialize the ViewModel
        val taskDao = TaskDatabase.getDatabase(application).taskDao()
        val repository = TaskRepository(taskDao)
        taskViewModel = TaskViewModel(repository)

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recycler_view_tasks)
        recyclerView.layoutManager = LinearLayoutManager(this)
        taskAdapter = TaskAdapter(emptyList())  // Start with an empty list
        recyclerView.adapter = taskAdapter

        // Fetch and observe tasks
        taskViewModel.allTasks.observe(this, Observer { tasks ->
            taskAdapter = TaskAdapter(tasks)
            recyclerView.adapter = taskAdapter
        })

        // Button to add a new task
        findViewById<View>(R.id.button_add_task).setOnClickListener {
            val newTask = Task(title = "Sample Task", description = "Task description", status = false, date = "2024-10-11")
            taskViewModel.insertTask(newTask)
        }
    }
}
