package com.derteuffel.data;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by derteuffel on 25/01/2019.
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long userId;

    /** Identification properties start**/
    private String userName;
    private String userFirstName;
    private String userBirthDate;
    private String userBornPlace;
    private String userAvatar;
    //user  maricule code
    private String userMilitaryCode;
    private String userAccountCode;
    // user identification number
    private String userCNINumber;
    private String userCIMNumber;
    //user phone number
    private String userFlotteTelephonNumber;
    private String userPersonalTelephonNumber;
    // user gun information
    private String userGunType;
    private String userGunNumber;
    //user PA informations
    private String userPAType;
    private String userPANumber;
    //user incomming location informations
    private String userRegion;
    private String userDivision;
    private String userSubDivision;
    private String userCity;
    private String userHome;
    private String userSexe;
    private String userEthnie;
    private String userEmail;
    /**Identification propertoes end**/
    /**User Familly information start**/
    //father informations
    private String fatherName;
    private String fatherFirstName;
    //mother informations
    private String motherName;
    private String motherFirstName;
    // matrimonial status
    private String matrimonialStatus;
    private int childNumber;
    //location
    private String residence;
    //help contact informtion
    private String helpPersonName;
    private String lienParente;
    private String helpPersonPhone;
    /**User Familly information end **/

    /** user level training instruction start**/
    //civil information
    private String userHigerCivilDiplom;
    private String userTrainingLevelInstruction;
    private String userDepartment;

     private String civilHigerDiplomObtainDate;
    private String civilQualification;
    // military information
    private String militaryDiplom;
    private String militaryDiplomObtainDate;
    private String militaryQualification;
    private String talkingLanguage;
    private ArrayList<String> talkingLanguages;
    private String whritingLanguage;
    private ArrayList<String> whritingLanguages;
    /** user level training instruction end **/

    /** professionnal information start **/

    private String gradeStatus;
    private String echelonStatus;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date materialTokenDate;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date serviceTokenDate;

    private String trainingCenter;
    private String naturalLearntraining;
    private String affectation;
    private String fonctionStatus;
    private ArrayList<String> specialities;
    private String specialitie;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date teamAlphaEntrance;
    /** profesionnal information end**/

    /** Other information about the user start **/
    private String userReligion;
    private String bloodGroup;
    private ArrayList<String> medicalBackups;
    private String medicalBackup;
    private Boolean swimmingStatus;
    private ArrayList<String> decorationsAndDates;
    private String decorationsAndDate;
    private ArrayList<String> internshipAndCourses;
    private String internshipAndCourse;
    private ArrayList<String> lastKnowledges;
    private String lastKnowledge;
    private ArrayList<String> sports;
    private String sport;
    private String height;
    private String rectifiedHeight;
    private ArrayList<String> particularMarks;
    private String particularMark;

    /** Other information about the user end **/

    /** Signalization for user start **/
    private String hairColor;
    private String noiseStatus;
    private String eyesStatus;
    private String faceStatus;
    private String foreHeadStatus;
    private String dyedStatus;

    //others
     private String militaryDriverLicencceCategory;
     private String civilDriverLicencceCategory;
    private String driveWithNoDriverLicence;
    private String anotherAboutUser;

    /** Signalization for user end **/

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enrollmentDate;

    private boolean status;

    @ManyToOne
    private Section section;

    public User(String value){
        this.userName=value;
    }

    public User() {
    }

    public User(Long userId, String userName, String userFirstName, String userBirthDate, String userAvatar,
                String userMilitaryCode, String userAccountCode, String userCNINumber, String userCIMNumber,
                String userFlotteTelephonNumber, String userPersonalTelephonNumber, String userGunType,Date enrollmentDate,
                String userGunNumber, String userPAType, String userPANumber, String userRegion, String userDivision,
                String userSubDivision, String userCity, String userHome, String userSexe, String userEthnie,
                String userEmail, String fatherName, String fatherFirstName, String motherName, String motherFirstName,
                String matrimonialStatus, int childNumber, String residence, String helpPersonName, String lienParente,
                String helpPersonPhone, String userHigerCivilDiplom, String userTrainingLevelInstruction, String userDepartment,
                String civilHigerDiplomObtainDate, String civilQualification, String militaryDiplom, String militaryDiplomObtainDate,
                String militaryQualification, String talkingLanguage, ArrayList<String> talkingLanguages,
                ArrayList<String> whritingLanguages, String whritingLanguage, String gradeStatus, String echelonStatus,
                Date materialTokenDate, Date serviceTokenDate, String trainingCenter, String naturalLearntraining, String affectation,
                String fonctionStatus, ArrayList<String> specialities, String specialitie, Date teamAlphaEntrance, String userReligion,
                String bloodGroup, ArrayList<String> medicalBackups, String medicalBackup, Boolean swimmingStatus, ArrayList<String> decorationsAndDates,
                String decorationsAndDate, ArrayList<String> internshipAndCourses, String internshipAndCourse,
                ArrayList<String> lastKnowledges, String lastKnowledge, ArrayList<String> sports, String sport,String rectifiedHeight, String height,
                ArrayList<String> particularMarks, String particularMark, String hairColor, String noiseStatus, String eyesStatus, String faceStatus,
                String foreHeadStatus, String dyedStatus, String militaryDriverLicencceCategory, String civilDriverLicencceCategory, String driveWithNoDriverLicence,
                String anotherAboutUser, boolean status, String userBornPlace) {
        this.userId = userId;
        this.userName = userName;
        this.rectifiedHeight=rectifiedHeight;
        this.enrollmentDate=enrollmentDate;
        this.userFirstName = userFirstName;
        this.userBirthDate = userBirthDate;
        this.userAvatar = userAvatar;
        this.status=status;
        this.userMilitaryCode = userMilitaryCode;
        this.userAccountCode = userAccountCode;
        this.userCNINumber = userCNINumber;
        this.userCIMNumber = userCIMNumber;
        this.userFlotteTelephonNumber = userFlotteTelephonNumber;
        this.userPersonalTelephonNumber = userPersonalTelephonNumber;
        this.userGunType = userGunType;
        this.userGunNumber = userGunNumber;
        this.userBornPlace=userBornPlace;
        this.userPAType = userPAType;
        this.userPANumber = userPANumber;
        this.userRegion = userRegion;
        this.userDivision = userDivision;
        this.userSubDivision = userSubDivision;
        this.userCity = userCity;
        this.userHome = userHome;
        this.userSexe = userSexe;
        this.userEthnie = userEthnie;
        this.userEmail = userEmail;
        this.fatherName = fatherName;
        this.fatherFirstName = fatherFirstName;
        this.motherName = motherName;
        this.motherFirstName = motherFirstName;
        this.matrimonialStatus = matrimonialStatus;
        this.childNumber = childNumber;
        this.residence = residence;
        this.helpPersonName = helpPersonName;
        this.lienParente = lienParente;
        this.helpPersonPhone = helpPersonPhone;
        this.userHigerCivilDiplom = userHigerCivilDiplom;
        this.userTrainingLevelInstruction = userTrainingLevelInstruction;
        this.userDepartment = userDepartment;
        this.civilHigerDiplomObtainDate = civilHigerDiplomObtainDate;
        this.civilQualification = civilQualification;
        this.militaryDiplom = militaryDiplom;
        this.militaryDiplomObtainDate = militaryDiplomObtainDate;
        this.militaryQualification = militaryQualification;
        this.talkingLanguage = talkingLanguage;
        this.talkingLanguages = talkingLanguages;
        this.whritingLanguages= whritingLanguages;
        this.whritingLanguage = whritingLanguage;
        this.gradeStatus = gradeStatus;
        this.echelonStatus = echelonStatus;
        this.materialTokenDate = materialTokenDate;
        this.serviceTokenDate = serviceTokenDate;
        this.trainingCenter = trainingCenter;
        this.naturalLearntraining = naturalLearntraining;
        this.affectation = affectation;
        this.fonctionStatus = fonctionStatus;
        this.specialities = specialities;
        this.specialitie = specialitie;
        this.teamAlphaEntrance = teamAlphaEntrance;
        this.userReligion = userReligion;
        this.bloodGroup = bloodGroup;
        this.medicalBackups = medicalBackups;
        this.medicalBackup = medicalBackup;
        this.swimmingStatus = swimmingStatus;
        this.decorationsAndDates = decorationsAndDates;
        this.decorationsAndDate = decorationsAndDate;
        this.internshipAndCourses = internshipAndCourses;
        this.internshipAndCourse = internshipAndCourse;
        this.lastKnowledges = lastKnowledges;
        this.lastKnowledge = lastKnowledge;
        this.sports = sports;
        this.sport = sport;
        this.height = height;
        this.particularMarks = particularMarks;
        this.particularMark = particularMark;
        this.hairColor = hairColor;
        this.noiseStatus = noiseStatus;
        this.eyesStatus = eyesStatus;
        this.faceStatus = faceStatus;
        this.foreHeadStatus = foreHeadStatus;
        this.dyedStatus = dyedStatus;
        this.militaryDriverLicencceCategory = militaryDriverLicencceCategory;
        this.civilDriverLicencceCategory = civilDriverLicencceCategory;
        this.driveWithNoDriverLicence = driveWithNoDriverLicence;
        this.anotherAboutUser = anotherAboutUser;
    }

    public String getUserBornPlace() {
        return userBornPlace;
    }

    public void setUserBornPlace(String userBornPlace) {
        this.userBornPlace = userBornPlace;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getRectifiedHeight() {
        return rectifiedHeight;
    }

    public void setRectifiedHeight(String rectifiedHeight) {
        this.rectifiedHeight = rectifiedHeight;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserMilitaryCode() {
        return userMilitaryCode;
    }

    public void setUserMilitaryCode(String userMilitaryCode) {
        this.userMilitaryCode = userMilitaryCode;
    }

    public String getUserAccountCode() {
        return userAccountCode;
    }

    public void setUserAccountCode(String userAccountCode) {
        this.userAccountCode = userAccountCode;
    }

    public String getUserCNINumber() {
        return userCNINumber;
    }

    public void setUserCNINumber(String userCNINumber) {
        this.userCNINumber = userCNINumber;
    }

    public String getUserCIMNumber() {
        return userCIMNumber;
    }

    public void setUserCIMNumber(String userCIMNumber) {
        this.userCIMNumber = userCIMNumber;
    }

    public String getUserFlotteTelephonNumber() {
        return userFlotteTelephonNumber;
    }

    public void setUserFlotteTelephonNumber(String userFlotteTelephonNumber) {
        this.userFlotteTelephonNumber = userFlotteTelephonNumber;
    }

    public String getUserPersonalTelephonNumber() {
        return userPersonalTelephonNumber;
    }

    public void setUserPersonalTelephonNumber(String userPersonalTelephonNumber) {
        this.userPersonalTelephonNumber = userPersonalTelephonNumber;
    }

    public String getUserGunType() {
        return userGunType;
    }

    public void setUserGunType(String userGunType) {
        this.userGunType = userGunType;
    }

    public String getUserGunNumber() {
        return userGunNumber;
    }

    public void setUserGunNumber(String userGunNumber) {
        this.userGunNumber = userGunNumber;
    }

    public String getUserPAType() {
        return userPAType;
    }

    public void setUserPAType(String userPAType) {
        this.userPAType = userPAType;
    }

    public String getUserPANumber() {
        return userPANumber;
    }

    public void setUserPANumber(String userPANumber) {
        this.userPANumber = userPANumber;
    }

    public String getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(String userRegion) {
        this.userRegion = userRegion;
    }

    public String getUserDivision() {
        return userDivision;
    }

    public void setUserDivision(String userDivision) {
        this.userDivision = userDivision;
    }

    public String getUserSubDivision() {
        return userSubDivision;
    }

    public void setUserSubDivision(String userSubDivision) {
        this.userSubDivision = userSubDivision;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserHome() {
        return userHome;
    }

    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }

    public String getUserSexe() {
        return userSexe;
    }

    public void setUserSexe(String userSexe) {
        this.userSexe = userSexe;
    }

    public String getUserEthnie() {
        return userEthnie;
    }

    public void setUserEthnie(String userEthnie) {
        this.userEthnie = userEthnie;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherFirstName() {
        return fatherFirstName;
    }

    public void setFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherFirstName() {
        return motherFirstName;
    }

    public void setMotherFirstName(String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }

    public String getMatrimonialStatus() {
        return matrimonialStatus;
    }

    public void setMatrimonialStatus(String matrimonialStatus) {
        this.matrimonialStatus = matrimonialStatus;
    }

    public int getChildNumber() {
        return childNumber;
    }

    public void setChildNumber(int childNumber) {
        this.childNumber = childNumber;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getHelpPersonName() {
        return helpPersonName;
    }

    public void setHelpPersonName(String helpPersonName) {
        this.helpPersonName = helpPersonName;
    }

    public String getLienParente() {
        return lienParente;
    }

    public void setLienParente(String lienParente) {
        this.lienParente = lienParente;
    }

    public String getHelpPersonPhone() {
        return helpPersonPhone;
    }

    public void setHelpPersonPhone(String helpPersonPhone) {
        this.helpPersonPhone = helpPersonPhone;
    }

    public String getUserHigerCivilDiplom() {
        return userHigerCivilDiplom;
    }

    public void setUserHigerCivilDiplom(String userHigerCivilDiplom) {
        this.userHigerCivilDiplom = userHigerCivilDiplom;
    }

    public String getUserTrainingLevelInstruction() {
        return userTrainingLevelInstruction;
    }

    public void setUserTrainingLevelInstruction(String userTrainingLevelInstruction) {
        this.userTrainingLevelInstruction = userTrainingLevelInstruction;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getCivilHigerDiplomObtainDate() {
        return civilHigerDiplomObtainDate;
    }

    public void setCivilHigerDiplomObtainDate(String civilHigerDiplomObtainDate) {
        this.civilHigerDiplomObtainDate = civilHigerDiplomObtainDate;
    }

    public String getCivilQualification() {
        return civilQualification;
    }

    public void setCivilQualification(String civilQualification) {
        this.civilQualification = civilQualification;
    }

    public String getMilitaryDiplom() {
        return militaryDiplom;
    }

    public void setMilitaryDiplom(String militaryDiplom) {
        this.militaryDiplom = militaryDiplom;
    }

    public String getMilitaryDiplomObtainDate() {
        return militaryDiplomObtainDate;
    }

    public void setMilitaryDiplomObtainDate(String militaryDiplomObtainDate) {
        this.militaryDiplomObtainDate = militaryDiplomObtainDate;
    }

    public String getMilitaryQualification() {
        return militaryQualification;
    }

    public void setMilitaryQualification(String militaryQualification) {
        this.militaryQualification = militaryQualification;
    }

    public String getTalkingLanguage() {
        return talkingLanguage;
    }

    public void setTalkingLanguage(String talkingLanguage) {
        this.talkingLanguage = talkingLanguage;
    }

    public ArrayList<String> getTalkingLanguages() {
        return talkingLanguages;
    }

    public void setTalkingLanguages(ArrayList<String> talkingLanguages) {
        this.talkingLanguages = talkingLanguages;
    }

    public ArrayList<String> getWhritingLanguages() {
        return whritingLanguages;
    }

    public void setWhritingLanguages(ArrayList<String> whritingLanguages) {
        this.whritingLanguages = whritingLanguages;
    }

    public String getWhritingLanguage() {
        return whritingLanguage;
    }

    public void setWhritingLanguage(String whritingLanguage) {
        this.whritingLanguage = whritingLanguage;
    }

    public String getGradeStatus() {
        return gradeStatus;
    }

    public void setGradeStatus(String gradeStatus) {
        this.gradeStatus = gradeStatus;
    }

    public String getEchelonStatus() {
        return echelonStatus;
    }

    public void setEchelonStatus(String echelonStatus) {
        this.echelonStatus = echelonStatus;
    }

    public Date getMaterialTokenDate() {
        return materialTokenDate;
    }

    public void setMaterialTokenDate(Date materialTokenDate) {
        this.materialTokenDate = materialTokenDate;
    }

    public Date getServiceTokenDate() {
        return serviceTokenDate;
    }

    public void setServiceTokenDate(Date serviceTokenDate) {
        this.serviceTokenDate = serviceTokenDate;
    }

    public String getTrainingCenter() {
        return trainingCenter;
    }

    public void setTrainingCenter(String trainingCenter) {
        this.trainingCenter = trainingCenter;
    }

    public String getNaturalLearntraining() {
        return naturalLearntraining;
    }

    public void setNaturalLearntraining(String naturalLearntraining) {
        this.naturalLearntraining = naturalLearntraining;
    }

    public String getAffectation() {
        return affectation;
    }

    public void setAffectation(String affectation) {
        this.affectation = affectation;
    }

    public String getFonctionStatus() {
        return fonctionStatus;
    }

    public void setFonctionStatus(String fonctionStatus) {
        this.fonctionStatus = fonctionStatus;
    }

    public ArrayList<String> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(ArrayList<String> specialities) {
        this.specialities = specialities;
    }

    public String getSpecialitie() {
        return specialitie;
    }

    public void setSpecialitie(String specialitie) {
        this.specialitie = specialitie;
    }

    public Date getTeamAlphaEntrance() {
        return teamAlphaEntrance;
    }

    public void setTeamAlphaEntrance(Date teamAlphaEntrance) {
        this.teamAlphaEntrance = teamAlphaEntrance;
    }

    public String getUserReligion() {
        return userReligion;
    }

    public void setUserReligion(String userReligion) {
        this.userReligion = userReligion;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public ArrayList<String> getMedicalBackups() {
        return medicalBackups;
    }

    public void setMedicalBackups(ArrayList<String> medicalBackups) {
        this.medicalBackups = medicalBackups;
    }

    public String getMedicalBackup() {
        return medicalBackup;
    }

    public void setMedicalBackup(String medicalBackup) {
        this.medicalBackup = medicalBackup;
    }

    public Boolean getSwimmingStatus() {
        return swimmingStatus;
    }

    public void setSwimmingStatus(Boolean swimmingStatus) {
        this.swimmingStatus = swimmingStatus;
    }

    public ArrayList<String> getDecorationsAndDates() {
        return decorationsAndDates;
    }

    public void setDecorationsAndDates(ArrayList<String> decorationsAndDates) {
        this.decorationsAndDates = decorationsAndDates;
    }

    public String getDecorationsAndDate() {
        return decorationsAndDate;
    }

    public void setDecorationsAndDate(String decorationsAndDate) {
        this.decorationsAndDate = decorationsAndDate;
    }

    public ArrayList<String> getInternshipAndCourses() {
        return internshipAndCourses;
    }

    public void setInternshipAndCourses(ArrayList<String> internshipAndCourses) {
        this.internshipAndCourses = internshipAndCourses;
    }

    public String getInternshipAndCourse() {
        return internshipAndCourse;
    }

    public void setInternshipAndCourse(String internshipAndCourse) {
        this.internshipAndCourse = internshipAndCourse;
    }

    public ArrayList<String> getLastKnowledges() {
        return lastKnowledges;
    }

    public void setLastKnowledges(ArrayList<String> lastKnowledges) {
        this.lastKnowledges = lastKnowledges;
    }

    public String getLastKnowledge() {
        return lastKnowledge;
    }

    public void setLastKnowledge(String lastKnowledge) {
        this.lastKnowledge = lastKnowledge;
    }

    public ArrayList<String> getSports() {
        return sports;
    }

    public void setSports(ArrayList<String> sports) {
        this.sports = sports;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public ArrayList<String> getParticularMarks() {
        return particularMarks;
    }

    public void setParticularMarks(ArrayList<String> particularMarks) {
        this.particularMarks = particularMarks;
    }

    public String getParticularMark() {
        return particularMark;
    }

    public void setParticularMark(String particularMark) {
        this.particularMark = particularMark;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getNoiseStatus() {
        return noiseStatus;
    }

    public void setNoiseStatus(String noiseStatus) {
        this.noiseStatus = noiseStatus;
    }

    public String getEyesStatus() {
        return eyesStatus;
    }

    public void setEyesStatus(String eyesStatus) {
        this.eyesStatus = eyesStatus;
    }

    public String getFaceStatus() {
        return faceStatus;
    }

    public void setFaceStatus(String faceStatus) {
        this.faceStatus = faceStatus;
    }

    public String getForeHeadStatus() {
        return foreHeadStatus;
    }

    public void setForeHeadStatus(String foreHeadStatus) {
        this.foreHeadStatus = foreHeadStatus;
    }

    public String getDyedStatus() {
        return dyedStatus;
    }

    public void setDyedStatus(String dyedStatus) {
        this.dyedStatus = dyedStatus;
    }

    public String getMilitaryDriverLicencceCategory() {
        return militaryDriverLicencceCategory;
    }

    public void setMilitaryDriverLicencceCategory(String militaryDriverLicencceCategory) {
        this.militaryDriverLicencceCategory = militaryDriverLicencceCategory;
    }

    public String getCivilDriverLicencceCategory() {
        return civilDriverLicencceCategory;
    }

    public void setCivilDriverLicencceCategory(String civilDriverLicencceCategory) {
        this.civilDriverLicencceCategory = civilDriverLicencceCategory;
    }

    public String getDriveWithNoDriverLicence() {
        return driveWithNoDriverLicence;
    }

    public void setDriveWithNoDriverLicence(String driveWithNoDriverLicence) {
        this.driveWithNoDriverLicence = driveWithNoDriverLicence;
    }

    public String getAnotherAboutUser() {
        return anotherAboutUser;
    }

    public void setAnotherAboutUser(String anotherAboutUser) {
        this.anotherAboutUser = anotherAboutUser;
    }
}
