package adapters;

import com.google.gson.Gson;
import objects.Project;
import objects.ProjectResponse;

public class ProjectAdapter extends  BaseAdapter{
    /**
     * This method is used to create a new project through API
     * @param project
     * @return
     */
    public ProjectResponse create(Project project) {
        return new Gson().fromJson(post(PROJECT_URI, converter.toJson(project)), ProjectResponse.class);
    }
}
