package opstaman.daos;

import opstaman.beans.TaskBean;
import opstaman.utils.DbCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TaskDaoImpl implements  TaskDao {

    @Qualifier("mongoTemplate")
    @Autowired
    private MongoOperations mongoOperations;


    @Override
    public void add(TaskBean taskBean) {
        mongoOperations.insert(taskBean, DbCollections.TASKS);
    }

    @Override
    public void update(TaskBean taskBean) {
        mongoOperations.save(taskBean, DbCollections.TASKS);
    }

    @Override
    public void delete(String id) {
        TaskBean taskBean = mongoOperations.findById(id,TaskBean.class);
        mongoOperations.remove(taskBean);
    }

    @Override
    public List<TaskBean> findTasks(Date date) {
        Query query = new Query(Criteria.where("date").gt(date));
        return this.mongoOperations.find(query,TaskBean.class);
    }

    @Override
    public TaskBean searchById(String id) {
        return this.mongoOperations.findById(id,TaskBean.class);
    }

    @Override
    public List<TaskBean> findTaskBetween(Date fromDt, Date toDt) {
        Query query = new Query(Criteria.where("date").gte(fromDt).lt(toDt));
        return this.mongoOperations.find(query,TaskBean.class);
    }
}
