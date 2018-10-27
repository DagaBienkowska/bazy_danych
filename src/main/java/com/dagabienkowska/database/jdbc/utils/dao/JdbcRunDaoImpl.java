package com.dagabienkowska.database.jdbc.utils.dao;

import com.dagabienkowska.database.dao.RunDao;
import com.dagabienkowska.database.entity.Member;
import com.dagabienkowska.database.entity.Run;
import com.dagabienkowska.database.jdbc.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunDaoImpl implements RunDao {

    private Connection connection = JdbcUtils.getInstance().getConnection();

    public void save(Run run) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("INSERT INTO runs (id, name, place, start_date, start_time, members_limit)" +
                        "values (?,?,?,?,?,?)");

        statement.setLong(1, run.getId());
        statement.setString(2, run.getName());
        statement.setString(3, run.getPlace());

        java.sql.Date sqlStartDate = new Date(run.getStartDate().getTime());
        java.sql.Date sqlStartTime = new Date(run.getStartTime().getTime());
        statement.setDate(4, sqlStartDate);
        statement.setDate(5, sqlStartTime);
        statement.setInt(6, run.getMembersLimit());

        statement.execute();

    }

    private List<Member> getMembersList(Long runId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM members WHERE run_id = ?");
        statement.setLong(1, runId);
        ResultSet resultSet = statement.executeQuery();

        ArrayList<Member> resultList = new ArrayList<Member>();

        while(resultSet.next() == true){
            Member member = new Member();
            member.setId(resultSet.getLong("id"));
            member.setName(resultSet.getString("name"));
            member.setLast_name(resultSet.getString("last_name"));
            member.setStart_number(resultSet.getInt("start_number"));
            member.setRun_id(resultSet.getLong("run_id"));
            resultList.add(member);

            return resultList;
        }
    }

    public Run findById(Long id) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM runs WHERE id = ?");
        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();

        if (result.next()){
            Run run = new Run();
            run.setId(result.getLong("id"));
            run.setName(result.getString("name"));
            run.setPlace(result.getString("place"));
            run.setStartDate(result.getDate("start_date"));
            run.setStartTime(result.getDate("start_time"));
            run.setMembersLimit(result.getInt("member_limit"));

            return run;
        }
        return null;
    }

    public List<Run> findAll() throws SQLException {

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM runs");
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Run> result = new ArrayList<Run>();

        while (resultSet.next() == true){
            Run run = new Run();
            run.setId(resultSet.getLong("id"));
            run.setName(resultSet.getString("name"));
            run.setPlace(resultSet.getString("place"));
            run.setStartDate(resultSet.getDate("start_date"));
            run.setStartTime(resultSet.getDate("start_time"));
            run.setMembersLimit(resultSet.getInt("members_limit"));


            result.add(run);

        }
        resultSet.close();

        return result;
    }

    public void update(Run run) throws SQLException {

    }

    public void delete(Long id) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("DELETE FROM runs WHERE id = ?");
        statement.setLong(1, id);
        statement.executeUpdate();
        statement.close();
    }

    public void deleteAll() throws SQLException{
        PreparedStatement statement = connection.prepareStatement("DELETE FROM runs");
        statement.executeUpdate();
        statement.close();

    }
}
