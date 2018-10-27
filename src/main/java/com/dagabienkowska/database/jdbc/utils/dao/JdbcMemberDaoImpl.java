package com.dagabienkowska.database.jdbc.utils.dao;

import com.dagabienkowska.database.dao.MemberDao;
import com.dagabienkowska.database.entity.Member;
import com.dagabienkowska.database.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JdbcMemberDaoImpl implements MemberDao {
    private Connection connection = JdbcUtils.getInstance().getConnection();


    public void save(Member member) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("INSERT INTO members (id, name, last_name, start_number, run_id)" +
                        "values (?,?,?,?,?)");

        statement.setLong(1, member.getId());
        statement.setString(2, member.getName());
        statement.setString(3, member.getLast_name());
        statement.setInt(4, member.getStart_number());
        statement.setLong(5, member.getRun_id());

        statement.execute();

    }

    public Member findById(Long id) throws SQLException {
        return null;
    }

    public List<Member> findAll() throws SQLException {
        return null;
    }

    public void update(Member member) throws SQLException {

    }

    public void delete(Long id) throws SQLException {

    }
}
