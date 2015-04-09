package opstaman.beans;

import opstaman.utils.DbCollections;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = DbCollections.TASKS)
public class TaskBean {

    @Id
    private String id;
    private String title;
    private double timeSpent;
    private String category;
    private String details;
    private Date date;
    private String clientDate;

    public TaskBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(double timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClientDate() {
        return clientDate;
    }

    public void setClientDate(String clientDate) {
        this.clientDate = clientDate;
    }

    @Override
    public String toString() {
        return "TaskBean{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", timeSpent=" + timeSpent +
                ", category='" + category + '\'' +
                ", details='" + details + '\'' +
                ", date=" + date +
                ", clientDate='" + clientDate + '\'' +
                '}';
    }
}
