package sample;

public class UserRecord {

    String username;
    String password;
    String description;
    boolean isEmployer;
    ProfileVector profile;
    boolean isCompleted;

    public static final int REALISTIC = 0;
    public static final int INVESTIGATIVE = 1;
    public static final int ARTISTIC = 2;
    public static final int SOCIAL = 3;
    public static final int ENTERPRISING = 4;
    public static final int CONVENTIONAL = 5;
    public static final int LATITUDE = 6;
    public static final int LONGITUDE = 7;
    public static final int EXPECTED_INCOME = 8;
    public static final int AQ = 9;
    public static final int ANXIETY = 10;
    public static final int DEPRESSION = 11;
    public static final int CAT_Q = 12;
    public static final int RBQ_2A = 13;

    public static final int ADMINISTRATION_AND_MANAGEMENT = 0;
    public static final int BIOLOGY = 1;
    public static final int BODY_COORDINATION = 2;
    public static final int BUILDING_AND_CONSTRUCTION = 3;
    public static final int CHEMISTRY = 4;
    public static final int CLERICAL = 5;
    public static final int COMPLEX_PROBLEM_SOLVING = 6;
    public static final int COMPUTERS_AND_ELECTRONICS = 7;
    public static final int CUSTOMER_AND_PERSONAL_SERVICE = 8;
    public static final int ECONOMICS_AND_ACCOUNTING = 9;
    public static final int FINE_ARTS = 10;
    public static final int FOREIGN_LANGUAGE = 11;
    public static final int HELPING_PEOPLE = 12;
    public static final int INSTRUCTING = 13;
    public static final int MANAGEMENT_OF_FINANCIAL_RESOURCES = 14;
    public static final int MATHEMATICS = 15;
    public static final int MECHANICAL = 16;
    public static final int MEDICINE_AND_DENTISTRY = 17;
    public static final int MEMORIZATION = 18;
    public static final int MONITORING = 19;
    public static final int NEGOTIATION = 20;
    public static final int OPERATIONS_ANALYSIS = 21;
    public static final int PERSONNEL_AND_HUMAN_RESOURCES = 22;
    public static final int PRODUCTION_AND_PROCESSING = 23;
    public static final int PROGRAMMING = 24;
    public static final int PSYCHOLOGY = 25;
    public static final int PUBLIC_SAFETY_AND_SECURITY = 26;
    public static final int QUALITY_CONTROL_ANALYSIS = 27;
    public static final int REPAIRING = 28;
    public static final int SALES_AND_MARKETING = 29;
    public static final int SCIENCE = 30;
    public static final int SOCIOLOGY_AND_ANTHROPOLOGY = 31;
    public static final int SPEAKING = 32;
    public static final int SYSTEMS_ANALYSIS = 33;
    public static final int TEACHING_AND_COURSE_DESIGN = 34;
    public static final int TELECOMMUNICATIONS = 35;
    public static final int THERAPY_AND_COUNSELING = 36;
    public static final int TIME_MANAGEMENT = 37;
    public static final int TROUBLESHOOTING = 38;
    public static final int WRITING = 39;
    public static final int HOURS = 40;
    public static final int START_TIME = 41;
    public static final int END_TIME = 42;
    public static final int MONDAY = 43;
    public static final int TUESDAY = 44;
    public static final int WEDNESDAY = 45;
    public static final int THURSDAY = 46;
    public static final int FRIDAY = 47;
    public static final int SATURDAY = 48;
    public static final int SUNDAY = 49;
    public static final int BUISINESS = 50;
    public static final int EDUCATION = 51;
    public static final int ENGINEERING = 52;
    public static final int SOCIAL_SCIENCES = 53;
    public static final int FINE_ARTS_STUDIES = 54;
    public static final int HUMANITIES = 55;
    public static final int INTERNATIONAL_STUDIES = 56;
    public static final int LAW = 57;
    public static final int LIFE_SCIENCES = 58;
    public static final int NURSING = 59;
    public static final int PHYSICAL_AND_MATHEMATICAL_SCIENCES = 60;
    public static final int RELIGIOUS_EDUCATION = 61;
    public static final int UNDERSTANDING_AND_COMMUNICATION = 62;
    public static final int GETTING_AROUND = 63;
    public static final int SELF_CARE = 64;
    public static final int GETTING_ALONG_WITH_PEOPLE = 65;
    public static final int LIFE_ACTIVITIES = 66;
    public static final int PARTICIPATION_IN_SOCIETY = 67;
    public static final int VOCATIONAL_INDEX = 68;



    public UserRecord(String username, String password, String description, boolean isEmployer, ProfileVector profile, boolean isCompleted) {
        this.username = username;
        this.password = password;
        this.description = description;
        this.isEmployer = isEmployer;
        this.profile = profile;
        this.isCompleted = isCompleted;
    }

    public static UserRecord stringToRecord(String contents){
        String[] fields = contents.split("#");
        String[] vector = fields[4].split("&");
        String[] ihalf = vector[0].split("@");
        double[] interests = new double[ihalf.length];
        for(int j = 0; j < ihalf.length; j++){
            interests[j] = Double.parseDouble(ihalf[j]);
        }
        String[] ahalf = vector[1].split("@");
        double[] aptitude = new double[ahalf.length];
        for(int j = 0; j < ahalf.length; j++){
            aptitude[j] = Double.parseDouble(ahalf[j]);
        }
        return new UserRecord(fields[0], fields[1], fields[2], fields[3].equals("Y"), new ProfileVector(interests, aptitude), fields[5].equals("Y"));

    }

    public static String recordToString(UserRecord value){
        String contents = "";
        contents += value.username + "#";
        contents += value.password + "#";
        contents += value.description + "#";
        if(value.isEmployer) contents += 'Y'; else contents += "N";
        contents += "#";
        for(int i = 0; i < value.profile.interests.length; i++){
            contents += value.profile.interests[i];
            if(i < value.profile.interests.length - 1){
                contents += "@";
            }
        }
        contents += "&";
        for(int i = 0; i < value.profile.aptitude.length; i++){
            contents += value.profile.aptitude[i];
            if(i < value.profile.aptitude.length - 1){
                contents += "@";
            }
        }
        contents += "#";
        if(value.isCompleted) contents += 'Y'; else contents += "N";
        return contents;
    }
}
