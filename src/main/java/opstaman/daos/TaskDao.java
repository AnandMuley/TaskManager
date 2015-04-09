package opstaman.daos;

import opstaman.beans.TaskBean;

import java.util.Date;
import java.util.List;


public interface TaskDao {
    void add(TaskBean taskBean);

    void update(TaskBean taskBean);

    void delete(String id);

    List<TaskBean> findTasks(Date date);

    TaskBean searchById(String id);

    List<TaskBean> findTaskBetween(Date fromDt,Date toDt);
}
