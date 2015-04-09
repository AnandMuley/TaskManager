package opstaman.controllers;

import opstaman.beans.TaskBean;
import opstaman.services.ReportService;
import opstaman.utils.PageNames;
import opstaman.utils.reports.ExcelReports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ExcelReports excelReports;

    @RequestMapping("home")
    public String renderReportsHome(){
        return PageNames.REPORTS_HOME;
    }

    @RequestMapping("generate")
    public  void generateReport(String startDate,String endDate,HttpServletResponse response){
        List<TaskBean> tasks = reportService.generateReport(startDate, endDate);
        try {
            response.setHeader("Content-disposition", "attachment; filename=Report_"+startDate+"_to_"+endDate+".xls");
            excelReports.buildExcelDocument(response,tasks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
