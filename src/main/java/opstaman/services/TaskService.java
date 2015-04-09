package opstaman.services;

import opstaman.beans.TaskBean;

import java.util.Date;
import java.util.List;

public interface TaskService {

    void add(TaskBean taskBean);

    void update(TaskBean taskBean);

    void delete(String id);

    List<TaskBean> findTodaysTask();

    List<TaskBean> findTaskOn(String date);

    TaskBean searchById(String id);

}
