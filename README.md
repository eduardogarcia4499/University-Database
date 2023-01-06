# University-Database

Project Description: Our project is about a University Database. We decided to make a few different tables that encompass the entirety of everyone who is a student at a University. We want to have 4 tables that include: Students, Enrollment, Courses, and Teachers. Each table will include an ID number that is unique to each individual as well as their name with a little bit of other information depending on what table they are in.


When we originally started, we wanted to make a database that showed the relationships between students and teachers and the courses they were taking/teaching. We also wanted to show the relationship between teachers and school administrators. However, after a lot of thought and discussion by the time we made it through the normalization process we were left with the four tables: Student, Course, Teacher, and Enrollment. By the end we only cared that our database reflects the logistical side of a university in terms of making sure students are enrolled and that teachers know what courses they are teaching.
	
Our student, course, and teacher tables all include a unique identifier for each unique entry in our table. Each student and teacher get their own id and each individual course has its own unique id. This is so it is easy to identify each entry by a unique integer value. This also makes it easy to consolidate information because instead of saying who teaches what class we can identify them with their id number. 
	
We also created an enrollment table that shows what students are signed up for which classes. This table only has two columns and relies on primary keys from other tables. Because of this the enrollment table has a composite foreign key, as one column on its own is not enough unique information. This also easily allows us to relate the student table to the course table.

We also went ahead and created a view that lets us see what computer science courses are being offered currently. Finally, we created a join that combines the course and student tables and shows the courseID, subject, student first name, and student last name. With this join we can get a roster of which students are in which classes.
