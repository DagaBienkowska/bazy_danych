package com.dagabienkowska.database;

import com.dagabienkowska.database.dao.MemberDao;
import com.dagabienkowska.database.dao.RunDao;
import com.dagabienkowska.database.entity.Member;
import com.dagabienkowska.database.entity.Run;
import com.dagabienkowska.database.jdbc.utils.JdbcUtils;
import com.dagabienkowska.database.providers.DaoProvider;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class Main {

    public static void main(String[] args) throws SQLException {

        RunDao runDao = DaoProvider.getInstance().getRunDao();
        MemberDao memberDao = DaoProvider.getInstance().getMemberDao();

        //runDao.deleteAll();

        long memberid = 1;
        for (int i = 1; i < 10; i++){
            Run run = new Run();
            run.setId((long) i);
            run.setName(UUID.randomUUID().toString());
            run.setStartDate(new Date());
            run.setStartTime(new Date());
            run.setMembersLimit(100);
            runDao.save(run);

            for (int j = 0; j < 10; j++){
                Member member = new Member();

                member.setId(memberid++);
                member.setName(UUID.randomUUID().toString());
                member.setLast_name(UUID.randomUUID().toString());
                member.setStart_number((int)(Math.random() * 100));
                member.setRun_id(run.getId());

                memberDao.save(member);
            }
        }

        List<Run> runList = runDao.findAll();
        for (Run run : runList){
            run.getMemberList(1l);
        }

    }

}
