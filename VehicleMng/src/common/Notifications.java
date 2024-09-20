package common;

public class Notifications {
    private String notification;

    public Notifications(String notification) {
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
    public void enterSelect(){
        System.out.println("Enter your selection");
    }
    public void dataIsNumeric(){
        System.out.println("Data must be in numeric format");
    }
    public void availableNumber(){
        System.out.println("Please select available numbers");
    }
}
