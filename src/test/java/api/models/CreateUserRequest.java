package api.models;

// Replaced Lombok annotations with explicit POJO to avoid Lombok/annotation-processing issues during test compilation
public class CreateUserRequest {
    private String name;
    private String job;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
