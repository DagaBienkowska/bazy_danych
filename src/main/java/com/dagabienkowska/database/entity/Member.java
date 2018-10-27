package com.dagabienkowska.database.entity;

public class Member {

    private Long id;
    private String name;
    private String last_name;
    private Integer start_number;
    private Long run_id;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getStart_number() {
        return start_number;
    }

    public void setStart_number(Integer start_number) {
        this.start_number = start_number;
    }

    public Long getRun_id() {
        return run_id;
    }

    public void setRun_id(Long run_id) {
        this.run_id = run_id;
    }
}
