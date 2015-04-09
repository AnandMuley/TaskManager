package opstaman.services;

import opstaman.beans.TaskBean;
import opstaman.daos.TaskDao;
import opstaman.utils.AppConstants;
import opstaman.utils.DateConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    private TaskDao taskDao;

    @Override
    public List<TaskBean> generateReport(String startDate, String endDate) {
        Date fromDate = DateConvertor.convertDate(startDate, AppConstants.CLIENT_DATE_PATTERN);
        Date toDate = DateConvertor.convertDate(endDate, AppConstants.CLIENT_DATE_PATTERN);
        List<TaskBean> tasks = taskDao.findTaskBetween(fromDate, toDate);
        return tasks;
    }
}
