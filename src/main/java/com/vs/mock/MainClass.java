package com.vs.mock;

import com.vs.mock.dao.DataBaseDao;
import com.vs.mock.dao.NetworkDao;

public class MainClass {

  private DataBaseDao dataBaseDao;
  private NetworkDao networkDao;

  public boolean save(String filename){
    dataBaseDao.save(filename);
    System.out.println("===== Main Class DB Save() ========");
    networkDao.save(filename);
    System.out.println("========== Main Class Network Save() ============");

    return  true;
  }

}
