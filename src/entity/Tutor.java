package entity;

public class Tutor {

    private String tutorId;
    private String tutorName;
    private String tutorUsername;
    private String tutorPassword;

    public Tutor() {
    }

    public Tutor(String id, String name, String username, String password) {
        this.tutorId = id;
        this.tutorName = name;
        this.tutorUsername = username;
        this.tutorPassword = password;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getTutorUsername() {
        return tutorUsername;
    }

    public void setTutorUsername(String tutorUsername) {
        this.tutorUsername = tutorUsername;
    }

    public String getTutorPassword() {
        return tutorPassword;
    }

    public void setTutorPassword(String tutorPassword) {
        this.tutorPassword = tutorPassword;
    }

    @Override
    public String toString() {
        return "Tutor{" + "tutorId=" + tutorId + ", tutorName=" + tutorName + ", tutorUsername=" + tutorUsername + ", tutorPassword=" + tutorPassword + '}';
    }

}
