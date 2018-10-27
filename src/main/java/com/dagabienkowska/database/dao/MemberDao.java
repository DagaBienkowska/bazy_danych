package com.dagabienkowska.database.dao;

import com.dagabienkowska.database.entity.Member;
import com.dagabienkowska.database.entity.Run;

import java.sql.SQLException;
import java.util.List;

public interface MemberDao {

    void save(Member member) throws SQLException;
    Member findById(Long id) throws SQLException;
    List<Member> findAll() throws SQLException;
    void update(Member member) throws SQLException;
    void delete(Long id) throws SQLException;
}
