public class Sign {
    private String message;
    private int width;

    public Sign(String message, int width) {
        this.message = message;
        this.width = width;
    }

    public String getLines() {
        String returnMessage = "";
        String tmpMessage = message;
        while(tmpMessage.length() > 0 ) {
            if(tmpMessage.length() > width) {
                returnMessage += tmpMessage.substring(0,width) + ";";
            } else {
                returnMessage += tmpMessage;
            }
        }
        return returnMessage;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
}
