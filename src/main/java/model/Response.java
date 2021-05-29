package model;

public class Response {
    private final String status;
    private final int code;

    public Response(String status, int code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }
}
