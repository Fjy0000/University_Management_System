package entity;

/**
 *
 * @author User
 */
public class Programme implements Comparable<Programme>{

    private String programmeId;
    
    public Programme(String programmeId) {
    this.programmeId = programmeId;
  }
    
    public String getprogrammeId() {
        return programmeId;
    }

    public void setprogrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

    @Override
    public String toString() {
        return programmeId;
    }

    @Override
    public int compareTo(Programme o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
