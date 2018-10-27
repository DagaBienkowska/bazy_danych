package com.dagabienkowska.database.dao;

import com.dagabienkowska.database.entity.Member;
import com.dagabienkowska.database.entity.Run;

import java.sql.SQLException;
import java.util.List;

public interface RunDao {

    void save(Run run) throws SQLException;
    Run findById(Long id) throws SQLException;
    List<Run> findAll() throws SQLException;
    void update(Run run) throws SQLException;
    void delete(Long id) throws SQLException;
    void deleteAll() throws SQLException;
    List<Member> getMemberList(Long id) throws SQLException;
}
