package com.example.email_sender_application.dtos.response;



public class ApiResponse {
    public boolean isSucessfull() {
        return isSucessfull;
    }

    public void setSucessfull(boolean sucessfull) {
        isSucessfull = sucessfull;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ApiResponse(boolean isSucessfull, Object data) {
        this.isSucessfull = isSucessfull;
        this.data = data;
    }

    private boolean isSucessfull;
    private Object data;
}
