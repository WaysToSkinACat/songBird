package com.js.songBirdTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import qa.com.persistence.repository.SongBirdMapRepository;
import qa.com.persistence.repository.SongBirdRepository;
import qa.com.util.JSONUtil;


public class SongBirdRepositoryTest {

	private SongBirdRepository repo;
	private JSONUtil util;

	@Before
	public void setup() {
		util = new JSONUtil();
		repo = new SongBirdMapRepository();
		
		repo.createAccount(
				"{\"userName\": 1, \"firstName\": \"Phil\", \"lastName\": \"Jerry\"}");
		repo.createAccount(
				"{\"userName\": 2, \"firstName\": \"Ella\", \"lastName\": \"Jerry\"}");
		repo.createAccount(
				"{\"userName\": 3, \"firstName\": \"Ella\", \"lastName\": \"Jerry\"}");
		repo.createAccount(
				"{\"userName\": 4, \"firstName\": \"Sam\", \"lastName\": \"Fisher\"}");
	}
@Ignore
	@Test
	public void addAccountTest() {
		assertNotNull(repo.getAllAccounts());
	}
@Ignore
	@Test
	public void add2AccountsTest() {
		assertNotNull(repo.getAllAccounts());
	}
@Ignore
	@Test
	public void removeAccountTest() {
		repo.deleteAccount("1");
		assertNull(repo.getAllAccounts());
	}
@Ignore
	@Test
	public void remove2AccountsTest() {
		repo.deleteAccount("1");
		repo.deleteAccount("2");
		assertNull(repo.getAllAccounts());
	}
@Ignore
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		repo.deleteAccount("1");
		repo.deleteAccount("2");
		assertEquals("{\"message\": \"no such account\"}", repo.deleteAccount("2"));
	}
//@Ignore
//	@Test
//	public void accountUpdateTest() {
//		repo.updateAccount("1", "{\"firstName\": \"Josh\"}");
//		assertEquals("Josh", repo.getAnAccount("1").getFirstName());
//	}
//@Ignore
//	@Test
//	public void jsonStringToAccountConversionTest() {
//		assertEquals(repo.getAccountMap().get(1L).getAccountNumber(),
//				util.getObjectForJSON(
//						"{\"id\": 1, \"firstName\": \"Phil\", \"lastName\": \"Jerry\", \"accountNumber\": \"102836\"}",
//						Account.class).getAccountNumber());
//	}
//@Ignore
//	@Test
//	public void accountConversionToJSONTest() {
//		assertEquals("{\"id\":1,\"firstName\":\"Phil\",\"lastName\":\"Jerry\",\"accountNumber\":\"102836\"}",
//				util.getJSONForObject(repo.getAccountMap().get(1L)));
//	}
//@Ignore
//	@Test
//	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
//		assertEquals(0, repo.countByName("John"));
//	}
//@Ignore
//	@Test
//	public void getCountForFirstNamesInAccountWhenOne() {
//		assertEquals(1, repo.countByName("Phil"));
//	}
//@Ignore
//	@Test
//	public void getCountForFirstNamesInAccountWhenTwo() {
//		assertEquals(2, repo.countByName("Ella"));
//	}

}

