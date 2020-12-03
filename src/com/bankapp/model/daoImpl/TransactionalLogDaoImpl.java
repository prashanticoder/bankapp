package com.bankapp.model.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.dao.TransactionLogDao;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.TransactionType;
@Repository
public class TransactionalLogDaoImpl implements TransactionLogDao{
	private SessionFactory factory;
	
	@Autowired
	public TransactionalLogDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}
	@Override
	public TransactionLog addTransactionLog(int accountId,String txInfo, Double amount, TransactionType txnType) {
		TransactionLog log=new TransactionLog(txInfo, amount, txnType);
		getSession().persist(log);
		return null;
	}

	@Override
	public List<TransactionLog> getAllTransactionLogs() {
		return getSession().createQuery("select t from TransactionLog t").list();
	}

	@Override
	public List<TransactionLog> getAllTransactionLogsForAccount(int accountId) {
		
		TransactionLog log=getSession().find(TransactionLog.class, accountId);
		return (List<TransactionLog>) log;
	}

}
