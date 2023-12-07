package entity;

public class Tutor {

    private String tutorId;
    private String tutorName;
    private String tutorPassword;

    public Tutor() {
    }

    public Tutor(String id, String name, String password) {
        this.tutorId = id;
        this.tutorName = name;
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

    public String getTutorPassword() {
        return tutorPassword;
    }

    public void setTutorPassword(String tutorPassword) {
        this.tutorPassword = tutorPassword;
    }

    @Override
    public String toString() {
        return "tutorId=" + tutorId + ", tutorName=" + tutorName + ", tutorPassword=" + tutorPassword;
    }

}
