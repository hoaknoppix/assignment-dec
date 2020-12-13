package au.com.nab.mainservice.dto;

public class ErrorMessage<T> {

    private Integer code;
    private T message;

    public ErrorMessage() {

    }

    public ErrorMessage(Integer code, T message) {
        this.code = code;
        this.message = message;
    }

    public ErrorMessage(T message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "ErrorMessage{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
