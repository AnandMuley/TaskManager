package opstaman.controllers;

import opstaman.beans.TaskBean;
import opstaman.services.TaskService;
import opstaman.utils.PageNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("home")
    public String renderHome(Model model){
        List<TaskBean> tasks = taskService.findTodaysTask();
        model.addAttribute("tasks", tasks);
        return PageNames.TASK_HOME;
    }

    @RequestMapping("datedtasks")
    public String findTaskOn(TaskBean taskBean,Model model){
        List<TaskBean> tasks = taskService.findTaskOn(taskBean.getClientDate());
        model.addAttribute("tasks", tasks);
        model.addAttribute("expectedDate",taskBean.getClientDate());
       return PageNames.TASK_HOME;
    }

    @RequestMapping("add")
    public String renderAddTask(){
        return PageNames.TASK_ADD;
    }

    @RequestMapping("savechanges")
    public String saveChanges(TaskBean taskBean,Model model){
        taskService.update(taskBean);
        return renderHome(model);
    }

    @RequestMapping("create")
    public String createTask(TaskBean taskBean,Model model){
        taskService.add(taskBean);
        return renderHome(model);
    }

    @RequestMapping("edittask")
    public  String renderEditTask(TaskBean taskBean,Model model){
        TaskBean searchedTask = taskService.searchById(taskBean.getId());
        model.addAttribute("task",searchedTask);
        return PageNames.TASK_EDIT;
    }

    @RequestMapping("delete")
    public String deleteTask(TaskBean taskBean,Model model){
        taskService.delete(taskBean.getId());
        return renderHome(model);
    }

    @RequestMapping("livetasks")
    public String renderLiveTasks(){
        return PageNames.TASK_LIVE;
    }

}
