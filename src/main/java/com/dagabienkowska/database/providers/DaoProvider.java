package com.dagabienkowska.database.providers;

import com.dagabienkowska.database.dao.MemberDao;
import com.dagabienkowska.database.dao.RunDao;
import com.dagabienkowska.database.jdbc.utils.dao.JdbcMemberDaoImpl;
import com.dagabienkowska.database.jdbc.utils.dao.JdbcRunDaoImpl;


public class DaoProvider {

    private static final DaoProvider instance = new DaoProvider();
    private RunDao runDao;
    private MemberDao memberDao;

    private DaoProvider() {
        runDao = new JdbcRunDaoImpl();
        memberDao = new JdbcMemberDaoImpl();
    }

    public static DaoProvider getInstance() {
        return instance;
    }

    public RunDao getRunDao() {
        return runDao;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }
}
