package opstaman.services;

import opstaman.beans.TaskBean;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface ReportService {

    public List<TaskBean> generateReport(String startDate,String endDate);

}
