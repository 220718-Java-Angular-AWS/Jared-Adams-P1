package p1.pojos;

import java.util.Objects;

public class Request {
    private Integer requestId;
    private String title;
    private Float reimbursementAmount;
    private String message;
    private Integer userId;
    private Boolean completed;

    public Request() {
    }

    public Request(Integer requestId, String title, Float reimbursementAmount, String message, Integer userId, Boolean completed) {
        this.requestId = requestId;
        this.title = title;
        this.reimbursementAmount = reimbursementAmount;
        this.message = message;
        this.userId = userId;
        this.completed = completed;
    }

    public Request(String title, Float reimbursementAmount, String message, Integer userId, Boolean completed) {
        this.title = title;
        this.reimbursementAmount = reimbursementAmount;
        this.message = message;
        this.userId = userId;
        this.completed = completed;
    }

    public Request(String title, Float reimbursementAmount, String message, Integer userId) {
        this.title = title;
        this.reimbursementAmount = reimbursementAmount;
        this.message = message;
        this.userId = userId;
    }

    public Request(Integer requestId, String title, Float reimbursementAmount, String message) {
        this.requestId = requestId;
        this.title = title;
        this.reimbursementAmount = reimbursementAmount;
        this.message = message;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getReimbursementAmount() {
        return reimbursementAmount;
    }

    public void setReimbursementAmount(Float reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(requestId, request.requestId) && Objects.equals(title, request.title) && Objects.equals(reimbursementAmount, request.reimbursementAmount) && Objects.equals(message, request.message) && Objects.equals(userId, request.userId) && Objects.equals(completed, request.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, title, reimbursementAmount, message, userId, completed);
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", title='" + title + '\'' +
                ", reimbursementAmount='" + reimbursementAmount + '\'' +
                ", message='" + message + '\'' +
                ", userId=" + userId +
                ", completed=" + completed +
                '}';
    }
}




