package com.senla.task5.coursebase.filework;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.danco.training.TextFileWorker;
import com.senla.task5.coursebase.datamodel.Course;

public class FileWorker {

	public void writeCoursesToFile(List<Course> courses, String path) throws ParseException {
		TextFileWorker tfw = new TextFileWorker(path);
		String[] str = new String[courses.size()];
		for (Course course : courses) {
			String courseString = new CourseToString().courseToString(course);
			for (int i = 0; i < str.length; i++) {
				if (str[i] == null) {
					str[i] = courseString;
					break;
				}
			}
		}
		tfw.writeToFile(str);
	}

	public List<Course> readCoursesFromFile(String path) throws ParseException {
		TextFileWorker tfw = new TextFileWorker(path);
		String[] coursesString = tfw.readFromFile();
		List<Course> data = new ArrayList<>();
		StringToCourse stc = new StringToCourse();
		for (int i = 0; i < coursesString.length; i++) {
			if (coursesString[i] != null) {
				data.add((stc.stringToCourse(coursesString[i])));
			}
		}
		return data;
	}
}