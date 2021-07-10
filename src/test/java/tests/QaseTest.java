package tests;
import adapters.BaseAdapter;
import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import objects.Project;
import objects.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QaseTest {
    /***
     * Test for getting all progects
     */
    @Test
    public void getAllProjectsTest() {
        new BaseAdapter().get("project");
    }

    /**
     * This test checks if a new project creates
     */
    @Test
    public void createProjectTest() {
        Project project =  Project.builder()
                .title("QANTEST")
                .code("QANTEST")
                .description("Test project QANTEST")
                .access("all")
                .group(null)
                .build();
        String createdProjectCode =  new ProjectAdapter().create(project).getResult().getCode();
        System.out.println(createdProjectCode);
        Assert.assertEquals(createdProjectCode, "QANTEST");
    }

    /**
     * This test checks if a new test suite creates
     */
    @Test
    public void createNewTestSuite() {
        Suite suite =  Suite.builder()
                .title("Test Suite")
                .parentId(null)
                .description("Suite description")
                .preconditions("Preconditions")
                .build();
        boolean createsTestSuiteId = new SuiteAdapter().create("QANTEST", suite).isStatus();
        Assert.assertTrue(createsTestSuiteId);
    }

    /**
     * This test checks if a new tets suite creates and then delete this suite
     */
    @Test(description = "Check if test suite is deleted")
    public void createNewSuiteAndDeleteTest() {
        Suite suite = Suite.builder()
                .title("Test suite")
                .parentId(null)
                .description("Suite description")
                .preconditions("Suite preconditions")
                .build();
        int createsTestSuiteId = new SuiteAdapter().create("QANTEST", suite).getResult().getId();
        boolean actualDeletedSuiteStatus = new SuiteAdapter().delete("QANTEST", createsTestSuiteId).isStatus();
        Assert.assertTrue(actualDeletedSuiteStatus);
    }
}
