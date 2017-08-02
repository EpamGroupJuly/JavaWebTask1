package com.teamcore.site.dao.user;

import com.teamcore.site.domain.Project;
import com.teamcore.site.domain.Task;
import com.teamcore.site.domain.User;

import java.util.List;

/**
 * Created by alterG on 1.08.17.
 */
public interface TaskDAO {

    // manager (assign task with users)
    void addUserToTask(User user);

    // manager and developer (browse developer portfolio)
    List<Task> getTaskListbyUser(User user);

    // manager (browse project tasks)
    List<Task> getTaskListbyProject(Project project);
}
