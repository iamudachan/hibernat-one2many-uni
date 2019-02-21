package com.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		Session s = sf.getCurrentSession();
		try {
			s.beginTransaction();

			int id = 1;
			Course course = s.get(Course.class, id);
			
			System.out.println(course);
			System.out.println(course.getReview());
			
			s.delete(course);
			s.getTransaction().commit();
		} finally {
			s.close();
			sf.close();
		}
	}
}
