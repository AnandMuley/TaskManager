package opstaman.services;

import opstaman.beans.TaskBean;
import opstaman.daos.TaskDao;
import opstaman.utils.AppConstants;
import opstaman.utils.DateConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ee on 01/01/15.
 */
@Service
public class TaskServiceImpl  implements  TaskService{

    @Autowired
    private TaskDao taskDao;

    @Override
    public void add(TaskBean taskBean) {
        if(StringUtils.isEmpty(taskBean.getClientDate())){
            Date today = new Date();
            taskBean.setDate(today);
        }else{
            taskBean.setDate(DateConvertor.convertDate(taskBean.getClientDate(), AppConstants.CLIENT_DATE_PATTERN));
        }
        taskDao.add(taskBean);
    }

    @Override
    public void update(TaskBean taskBean) {
        taskDao.update(taskBean);
    }

    @Override
    public void delete(String id) {
        taskDao.delete(id);
    }

    @Override
    public List<TaskBean> findTodaysTask() {
        Calendar calendar= Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date today = calendar.getTime();
        return taskDao.findTasks(today);
    }

    @Override
    public List<TaskBean> findTaskOn(String taskDate) {

        Calendar calendar= Calendar.getInstance();
        calendar.setTime(DateConvertor.convertDate(taskDate,AppConstants.CLIENT_DATE_PATTERN));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date fromDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH,1);
        Date tillDate = calendar.getTime();
        return taskDao.findTaskBetween(fromDate,tillDate);
    }

    @Override
    public TaskBean searchById(String id) {
        return taskDao.searchById(id);
    }
}
