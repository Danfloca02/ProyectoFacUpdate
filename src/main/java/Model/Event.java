package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Event {
    private String title;
    private LocalDateTime date;
    private String location;
    private String summary;
    private int maxCapacity;
    private List<Integer> participants;

    public Event(String var1, LocalDateTime var2, String var3, String var4, int var5) {
        this.title = var1;
        this.date = var2;
        this.location = var3;
        this.summary = var4;
        this.maxCapacity = var5;
        this.participants = new ArrayList();
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public String getLocation() {
        return this.location;
    }

    public String getSummary() {
       return this.summary;
    }

    public Integer getMaxCapacity() {
       return this.maxCapacity;
    }

    public List<Integer> getParticipants() {
        return this.participants;
    }

    public void setParticipants(Integer var1) {
        if (this.participants.size() < this.maxCapacity) {
            this.participants.add(var1);
            --this.maxCapacity;
        } else {
            System.out.println("n");
        }
    }
}