package fi.academy.learningdiary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    @Query("SELECT topic FROM Topic topic WHERE topic.id = :id")
    Topic haeIdlla(@Param("id") Integer id);
}
