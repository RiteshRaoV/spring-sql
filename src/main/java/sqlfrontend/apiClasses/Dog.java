package sqlfrontend.apiClasses;

public class Dog {
    String message;
    String status;

    public Dog(String website, String status) {
        this.message = website;
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
