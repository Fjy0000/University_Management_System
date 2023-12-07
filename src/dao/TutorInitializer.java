/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.Set;
import adt.SetInterface;
import entity.Tutor;

/**
 *
 * @author fongj
 */
public class TutorInitializer {

    public SetInterface<Tutor> initializeTutor() {

        SetInterface<Tutor> tutorList = new Set<>();
        tutorList.add(new Tutor("1001", "Mr John", "1234"));
        tutorList.add(new Tutor("1002", "Mr Ben", "1234"));
        tutorList.add(new Tutor("1003", "Mr Yoke", "1234"));
        tutorList.add(new Tutor("1004", "Mrs Emma", "1234"));
        tutorList.add(new Tutor("1005", "Mrs Luna", "1234"));
        return tutorList;
    }

}
