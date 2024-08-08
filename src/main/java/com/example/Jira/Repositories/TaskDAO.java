package com.example.Jira.Repositories;

import com.example.Jira.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface TaskDAO extends JpaRepository<Task,String>{

    List<Task> findByPriority(String priority);

    @Modifying
    @Query("delete from Task t where t.id in :ids" )
    void deleteByIds(@Param("ids") List<String> tasksId);
}
