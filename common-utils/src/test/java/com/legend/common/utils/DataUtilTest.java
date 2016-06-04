package com.legend.common.utils;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DataUtilTest {

	@Test
	public void testBeanCopy() {
		Templ src = new Templ(1,"name1",new Date());
		Templ des = new Templ();
		DataUtil.BeanCopy(src, des);
		Assert.assertEquals(src,des);
	}

	@Test
	public void testIsEmptyString() {
		Assert.assertTrue(DataUtil.isEmpty(""));
		Assert.assertFalse(DataUtil.isEmpty("123"));
	}

	@Test
	public void testIsEmptyCollection() {
		Assert.assertTrue(DataUtil.isEmpty(new ArrayList<String>()));
	}

}

class Templ {
	private Integer id;
	private String name;
	private Date birthDate;
	
	
	public Templ() {
	}

	public Templ(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Templ)){
			return false;
		}
		Templ templ = (Templ) obj;
		if(id==templ.id && name.equals(templ.name) && birthDate.equals(templ.birthDate)){
			return true;
		}
		return false;
	}

}
