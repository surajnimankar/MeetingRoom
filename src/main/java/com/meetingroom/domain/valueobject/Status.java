package com.meetingroom.domain.valueobject;

public enum Status {

    STATUS_BOOKED(1),
    STATUS_CANCELED(2);

    private int statusId;

    Status(int statusId) {
        this.statusId = statusId;
    }

    public int getStatusId() {
        return statusId;
    }

    public static Status getById(int id) {
        for(Status status: Status.values()) {
            if(status.statusId == id) {
                return status;
            }
        }
        return null;
    }
}
