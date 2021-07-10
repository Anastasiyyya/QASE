package adapters;

import com.google.gson.Gson;
import objects.SuiteResponse;
import objects.Suite;

public class SuiteAdapter extends BaseAdapter{
    /**
     * This method is used to create a new test suite through API
     * @param projectCode
     * @param suite
     * @return
     */
    public SuiteResponse create(String projectCode, Suite suite) {
        return new Gson().fromJson(post(SUITE_URI + projectCode, converter.toJson(suite)), SuiteResponse.class);
    }

    /**
     *This method completely deletes a test suite from repository
     * @param projectCode
     * @param testSuiteId
     * @return
     */
    public SuiteResponse delete(String projectCode, int testSuiteId) {
        return new Gson().fromJson(delete(SUITE_URI + projectCode + "/" + testSuiteId), SuiteResponse.class);
    }
}
