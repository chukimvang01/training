package com.ckv.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.fluttercode.datafactory.impl.DataFactory;

public class PushData {

	private DataFactory data;

	public PushData() {
		data = new DataFactory();
	}

	public void createData() {

		try {
			File f = new File("E:/datauserinfo.txt");
			FileUtils.touch(f);
			List<String> l = new ArrayList<String>();

			SimpleDateFormat fd = new SimpleDateFormat("yyyy-mm-dd");
			Date maxDate = new Date();
			for (int i = 0; i < 10; i++) {
				String name = data.getFirstName() + "\t" + data.getLastName();
				String sex = data.getItem(Arrays.asList("Male", "Female"));

				Date doB = data.getBirthDate();
				String dOB = fd.format(doB);
				String country = data.getCity();

				String rs = "/N\t" + name + "\t" + sex + "\t" + dOB + "\t" + country;
				System.out.println(rs);
				l.add(rs);
				FileUtils.writeLines(f, l, false);
				System.out.println("Create sucessfull!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new PushData().createData();

	}

}
