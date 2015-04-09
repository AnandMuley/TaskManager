package opstaman.utils.reports;

import opstaman.beans.TaskBean;
import opstaman.utils.AppConstants;
import opstaman.utils.DateConvertor;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Component
public class ExcelReports {

    public void buildExcelDocument(HttpServletResponse response,List<TaskBean> tasks) throws Exception {
        // Creating a worksheet
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Tasks Report");
        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("Date");
        header.createCell(1).setCellValue("Title");
        header.createCell(2).setCellValue("Category");
        header.createCell(3).setCellValue("Details");
        header.createCell(4).setCellValue("TimeSpent");

        int rowNum =1;
        Date currentDate = null;
//        Double timeSpent = 0d;
        for(TaskBean taskBean : tasks){
//            timeSpent += taskBean.getTimeSpent();
            //Create the row data
            HSSFRow row = sheet.createRow(rowNum++);
//            if(!taskBean.getDate().equals(currentDate)){
                currentDate = taskBean.getDate();
                row.createCell(0).setCellValue(DateConvertor.convertToString(currentDate, AppConstants.CLIENT_DATE_PATTERN));
                row.createCell(1).setCellValue(taskBean.getTitle());
                row.createCell(2).setCellValue(taskBean.getCategory());
                row.createCell(3).setCellValue(taskBean.getDetails());
                row.createCell(4).setCellValue(taskBean.getTimeSpent());
//            }
//            else{
//                row.createCell(0).setCellValue("Total Time Spent");
//                row.createCell(4).setCellValue(timeSpent);
//                HSSFRow rowNew = sheet.createRow(rowNum++);
//                timeSpent = 0d;
//                rowNew.createCell(0).setCellValue(AppConstants.EMPTY_STRING);
//                rowNew.createCell(1).setCellValue(taskBean.getTitle());
//                rowNew.createCell(2).setCellValue(taskBean.getCategory());
//                rowNew.createCell(3).setCellValue(taskBean.getDetails());
//                rowNew.createCell(4).setCellValue(taskBean.getTimeSpent());
//            }


        }
        workbook.write(response.getOutputStream());
    }
}
