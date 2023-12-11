/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author 60111
 */
public class Student implements Comparable<Student>{
    private String id;
    private String name;
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int compareTo(Student o) {
      return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + '}';
    }
    
   @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id.equals(student.id); // Use equals for content equality
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
