package CRM.Object;

import java.util.Date;

public class Interaction {
    private String id;
    private Date interDate;
    private String lead;
    private String mean;
    private String potential;

    public Interaction(String id, Date interDate, String lead, String mean, String potential) {
        this.id = id;
        this.interDate = interDate;
        this.lead = lead;
        this.mean = mean;
        this.potential = potential;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInterDate() {
        return interDate;
    }

    public void setInterDate(Date interDate) {
        this.interDate = interDate;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getPotential() {
        return potential;
    }

    public void setPotential(String potential) {
        this.potential = potential;
    }
}
