package sample;

public class UserRecord {

    String username;
    String password;
    String description;
    boolean isEmployer;
    ProfileVector profile;
    boolean isCompleted;

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
