package com.framework.junit;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.junit.runner.JUnitCore;

public class JunitRunner {

	public static void main(String[] args) {
		System.out.println(	JUnitCore.runClasses(PracticeTest.class).wasSuccessful());

	}
}
