package com.legend.common.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.legend.common.utils.exception.BeanToMapException;
import com.legend.common.utils.exception.MapToBeanException;

public class DataUtilTest {

	@Test
	public void testBeanCopy() {
		Templ src = new Templ(1, "name1", new Date());
		Templ des = new Templ();
		DataUtil.beanCopy(src, des);
		Assert.assertEquals(src, des);
	}

	@Test
	public void testIsEmptyString() {
		Assert.assertTrue(DataUtil.isEmpty(""));
		Assert.assertFalse(DataUtil.isEmpty("123"));

	}

	@Test
	public void testIsEmptyCollection() {
		List<String> list = null;
		Assert.assertTrue(DataUtil.isEmpty(list));
		list = new ArrayList<String>();
		Assert.assertTrue(DataUtil.isEmpty(list));
		list.add("aa");
		Assert.assertFalse(DataUtil.isEmpty(list));
	}

	@Test
	public void testBeanToMap() throws BeanToMapException {
		Templ templ = new Templ(1, "name1", new Date());
		Templ templ2 = new Templ(2, "name2", new Date());
		Complex complex = new Complex();
		complex.setId(2);
		complex.setXx("xx");
		complex.setTempl1(templ);
		complex.setTempl2(templ2);
		SuperComplex SuperComplex = new SuperComplex();
		SuperComplex.setDd(5);
		SuperComplex.setNn("nn");
		SuperComplex.setComplex(complex);
		Map<String, Object> map = DataUtil.beanToMap(SuperComplex);
		Assert.assertSame("name2", map.get("supercomplex.complex.templ2.name"));
	}

	@Test
	public void testMapToBean() throws BeanToMapException, MapToBeanException {
		Templ templ = new Templ(1, "name1", new Date());
		Templ templ2 = new Templ(2, "name2", new Date());
		Complex complex = new Complex();
		complex.setId(2);
		complex.setXx("xx");
		complex.setTempl1(templ);
		complex.setTempl2(templ2);
		SuperComplex superComplex = new SuperComplex();
		superComplex.setDd(5);
		superComplex.setNn("nn");
		superComplex.setComplex(complex);
		Map<String, Object> map = null;
		map = DataUtil.beanToMap(superComplex);
		Assert.assertSame("name2", map.get("supercomplex.complex.templ2.name"));

		SuperComplex sc = DataUtil.mapToBean(map, SuperComplex.class);
		Assert.assertSame("name2", sc.getComplex().getTempl2().getName());

	}

	@Test
	public void testFillZeroLeft() {
		String s = DataUtil.fillZeroLeft(1000000000, 12);
		Assert.assertEquals(s, "001000000000");
	}

	@Test
	public void fillSpaceRight() {
		String s = DataUtil.fillSpaceRight("22", 10);
		Assert.assertEquals(s, "22        ");
	}

	@Test
	public void removePoint() {
		String s = DataUtil.removePoint(123456.1211, 12, 2);
		Assert.assertEquals(s, "000012345612");
	}

	@Test
	public void addPoint() {
		Double d = DataUtil.addPoint(123456d, 12, 2);
		Assert.assertEquals(d, Double.valueOf(1234.56d));
	}

}

class SuperComplex {
	private Integer dd;
	private String nn;
	private Complex complex;

	public Integer getDd() {
		return dd;
	}

	public void setDd(Integer dd) {
		this.dd = dd;
	}

	public String getNn() {
		return nn;
	}

	public void setNn(String nn) {
		this.nn = nn;
	}

	public Complex getComplex() {
		return complex;
	}

	public void setComplex(Complex complex) {
		this.complex = complex;
	}

}

class Complex {
	private Integer id;
	private String xx;
	private Templ templ1;
	private Templ templ2;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getXx() {
		return xx;
	}

	public void setXx(String xx) {
		this.xx = xx;
	}

	public Templ getTempl1() {
		return templ1;
	}

	public void setTempl1(Templ templ1) {
		this.templ1 = templ1;
	}

	public Templ getTempl2() {
		return templ2;
	}

	public void setTempl2(Templ templ2) {
		this.templ2 = templ2;
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
		if (!(obj instanceof Templ)) {
			return false;
		}
		Templ templ = (Templ) obj;
		if (id == templ.id && name.equals(templ.name) && birthDate.equals(templ.birthDate)) {
			return true;
		}
		return false;
	}

}
