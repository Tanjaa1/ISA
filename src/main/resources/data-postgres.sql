/*
INSERT INTO public.patient(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, category, penalty, points)
	VALUES (1, 'Mileve Maric 5', 'Novi Sad', 'Srbija', '', 'marijavucetic66@gmail.com', false, false, 'Jovana', 'Jovanic', '0628876678', 'Jovanic', 0, 0, 0);
   
INSERT INTO public.patient(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, category, penalty, points)
	VALUES (2, 'Glavna 100', 'Ruma', 'Srbija', '', 'sara@gmail.com', false, false, 'Sara', 'Saric', '0648816428', 'Saric', 0, 0, 0);
INSERT INTO public.patient(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, category, penalty, points)
	VALUES (3, 'Lenjinova 20', 'Ruma', 'Srbija', '', 'aleksandramilijevic98@gmail', false, false, 'Luka', 'Lukic', '0612334555', 'Lukic', 0, 0, 0);
*/
INSERT INTO public.patient(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, category, points)
	VALUES (88, 'Mileve Maric 5', 'Novi Sad', 'Srbija', '', 'marijavucetic66@gmail.com', false, false, 'Jovana', 'Jovanic', '0628876678', 'Jovanic','jocas', 0, 0);
INSERT INTO public.patient(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, category, points)
	VALUES (89, 'Glavna 100', 'Ruma', 'Srbija', '', 'marijavucetic66@gmail.com', false, false, 'Sara', 'Saric', '0648816428', 'Saric','sara', 0, 0);
INSERT INTO public.patient(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, category, points)
	VALUES (90, 'Lenjinova 20', 'Ruma', 'Srbija', '', 'marijavucetic66@gmail.com', false, false, 'Luka', 'Lukic', '0612334555', 'Lukic','luka',0, 0);
INSERT INTO public.patient(
id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, category, points)
	VALUES (69, 'Синђелићева 44', 'Нови Сад', 'Србија', '', 'marijavucetic66@gmail.com', false, false, 'Aлекса', 'sifra', '0612334555', 'Реповић','aleksarep',0, 0);

INSERT INTO public.pharmacy(id, address, name, counseling_price) VALUES (111, 'Stanoja Stanojevica 4,Novi Sad,Srbija', 'Feniks', 1000.0);
INSERT INTO public.pharmacy(id, address, name, counseling_price) VALUES (222, 'Maksima Gorkog 44,Novi Sad,Srbija', 'Benu', 2000.0);

    /*
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (4, 'Ticanova 1', 'Ruma', 'Srbija', '', 'ta.drcelic@gmail.com', false, false, 'Maja', 'Majic', '0654431123', 'Majic', 1);    
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (5, 'Jovana Ducica 9', 'Novi Sad', 'Srbija', '', 'sava@gmail.com', false, false, 'Sava', 'Savic', '06541111123', 'Savic', 2);
*/

INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, pharmacy_id)
	VALUES (41, 'Ticanova 1', 'Ruma', 'Srbija', '', 'ta.drcelic@gmail.com', false, false, 'Maja', 'Majic', '0654431123', 'Majic','majaa', 222);    
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, pharmacy_id)
	VALUES (51, 'Jovana Ducica 9', 'Novi Sad', 'Srbija', '', 'sava@gmail.com', false, false, 'Sava', 'Savic', '06541111123', 'Savic','sava',111);
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, pharmacy_id)
	VALUES (111, 'Jovana Ducica 9', 'Novi Sad', 'Srbija', '', 'pera@gmail.com', false, false, 'Pera', 'Peric', '06541111123', 'Peric','pera',111);
INSERT INTO public.pharmacist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, pharmacy_id)
	VALUES (121, 'Jovana Ducica 9', 'Novi Sad', 'Srbija', '', 'mika@gmail.com', false, false, 'Mika', 'Mikic', '06541111123', 'Mika','mika',111);

/*
INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (6, 'Kneza Milosa 3', 'Novi Sad', 'Srbija', '', 'jovan.jovic838@gmail.com', false, false, 'Jovan', 'Jovic', '0632213455', 'Jovic');
INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (7, 'Kneza Milosa 1', 'Novi Sad', 'Srbija', '', 'lola@gmail.com', false, false, 'Lola', 'Lolic', '0632413455', 'Lola');
    */

INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username)
	VALUES (61, 'Kneza Milosa 3', 'Novi Sad', 'Srbija', '', 'jovan.jovic838@gmail.com', false, false, 'Jovan', 'Jovic', '0632213455', 'Jovic','jokas');
INSERT INTO public.dermatologist(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username)
	VALUES (71, 'Kneza Milosa 1', 'Novi Sad', 'Srbija', '', 'lola@gmail.com', false, false, 'Lola', 'Lolic', '0632413455', 'Lola','neceViseLola');
    
    
	/*
INSERT INTO public.pharmacy_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (8, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'marijavucetic@uns.ac.rs', false, false, 'Marija', 'Vucetic', '06581111123', 'Vucetic', 1);
INSERT INTO public.pharmacy_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, pharmacy_id)
	VALUES (9, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'toma@gmail.com', false, false, 'Toma', 'Tomic', '06581222123', 'Tomic', 2);
   */

INSERT INTO public.pharmacy_admin(

	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, pharmacy)
	VALUES (8, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'marijavucetic@uns.ac.rs', false, false, 'Marija', 'Vucetic', '06581111123', 'Vucetic','maja', 'Feniks');
INSERT INTO public.pharmacy_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username, pharmacy)
	VALUES (9, 'Jovana Ducica 65', 'Novi Sad', 'Srbija', '', 'marijavucetic@uns.ac.rs', false, false, 'Toma', 'Tomic', '06581222123', 'Tomic','toma', 'Benu');
   
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (61, 111);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (71, 222);
INSERT INTO public.pharmacy_dermatologists(dermatologist_id, pharmacy_id)VALUES (61, 222);

/*
INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (10, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'marija998v@gmail.com', false, false, 'Jelena', 'Jokic', '0632211124', 'Jokic');
INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (11, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'goran@gmail.com', false, false, 'Goran', 'Goric', '0632211111', 'Goric');
    */


INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username)
	VALUES (10, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'aleksarep0408@gmail.com', false, false, 'Jelena', 'Jokic', '0632211124', 'Jokic','jeca');
INSERT INTO public.supplier(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username)
	VALUES (11, 'Seljackih Buna 2', 'Novi Sad', 'Srbija', '', 'aleksarep0408@gmail.com', false, false, 'Goran', 'Goric', '0632211111', 'Goric','goran');

/*	
INSERT INTO public.system_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (12, 'Boracka 29', 'Novi Sad', 'Srbija', '', 'goran@gmail.com', true, false, 'Balsa', 'Balsic', '068444777', 'Balsic');
INSERT INTO public.system_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname)
	VALUES (13, 'Cirpanova 9', 'Novi Sad', 'Srbija', '', 'gordana1@gmail.com', true, false, 'Gordana', 'Grbic', '068789654', 'Grbic');
*/
INSERT INTO public.system_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username)
	VALUES (12, 'Boracka 29', 'Novi Sad', 'Srbija', '', 'goran@gmail.com', true, false, 'Balsa', 'Balsic', '068444777', 'Balsic','balsa');
INSERT INTO public.system_admin(
	id, address, city, country, description, email, email_comfirmed, first_time_login, name, password, phone_number, surname, username)
	VALUES (13, 'Cirpanova 9', 'Novi Sad', 'Srbija', '', 'gordana1@gmail.com', true, false, 'Gordana', 'Grbic', '068789654', 'Grbic','gordana');
    


INSERT INTO public.complaint(
	id, subject, text, patient_id,is_answered)
	VALUES (111, 'Jovan Jovic', 'neljubazan', 88,false);
INSERT INTO public.complaint(
	id, subject, text, patient_id,is_answered)
	VALUES (222, 'Sava Savic', 'neprofesionalan', 89,false);


INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (111, 1000.0, 'Headache', '2021-02-09 16:00:00-07', '2021-02-09 16:25:25-07', false, 88, 51, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (112, 2000.0, '', '2021-02-15 17:00:00-07', '2021-02-15 17:25:25-07', false, 89, 51, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (113, 1000.0, '', '2021-02-15 15:00:00-07', '2021-02-15 15:25:25-07', false, 88, 51, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (114, 2000.0, '', '2021-10-13 17:00:00-07', '2021-10-13 17:25:25-07', false, 89, 51, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (115, 1000.0, '', '2021-02-13 16:00:00-07', '2021-02-13 16:25:25-07', false, 88, 51, 222, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (116, 2000.0, 'Headache', '2021-06-13 17:00:00-07', '2021-06-13 17:25:25-07', false, 89, 51, 222, false);
    
-- INSERT INTO public.eprescription(
-- 	code, issuing_date)
-- 	VALUES (111,'2016-06-22');
-- INSERT INTO public.eprescription(this.vacation.DateStart
-- 	code, issuing_date)
-- 	VALUES (112,'2017-06-22');
    
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (111, 500.0, '', '2021-02-09 19:10:25-07', '2021-02-09 19:20:25-07', false, 61, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (112, 1000.0, 'Headache and nausea', '2021-02-10 16:30:25-07', '2021-02-09 16:40:25-07', true, 61, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (113, 800.0, 'Headache and nausea', '2021-02-11 15:10:25-07', '2021-02-11 15:20:25-07', true, 61, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (114, 900.0, 'Headache and nausea', '2021-02-11 14:10:25-07', '2021-02-11 14:20:25-07', true, 61, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (115, 2000.0, '', '2021-02-13 15:10:25-07', '2021-02-13 15:20:25-07', true, 61, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id,is_canceled)
	VALUES (116, 3000.0, 'izvjestaj 2', '2021-08-13 18:00:25-07', '2021-08-13 18:10:25-07', false, 61, 88, 111,false);
    
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (117, 900.0, 'Headache and nausea', '2016-05-22 14:45:25-07', '2016-05-22 14:25:25-07', true, 61, 89, 111, false);

	
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (118, 500.0, '', '2021-02-15 19:10:25-07', '2021-02-15 19:20:25-07', false, 61, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (119, 1000.0, 'Headache and nausea', '2021-02-15 16:30:25-07', '2021-02-15 16:40:25-07', true, 61, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (120, 800.0, '', '2021-02-23 09:10:25-07', '2021-02-23 09:20:25-07', false, 61, 89, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (121, 900.0, '', '2021-02-23 10:10:25-07', '2021-02-23 10:20:25-07', false, 61, 88, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id, is_canceled)
	VALUES (122, 2000.0, '', '2021-02-12 15:10:25-07', '2021-02-12 15:20:25-07', true, 61, null, 111, false);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (123, 3000.0, '', '2021-02-17 08:00:25-07', '2021-02-17 10:10:25-07', false, 61, 88, 222);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (124, 3000.0, '', '2021-02-17 11:00:25-07', '2021-02-17 11:10:25-07', false, 61, null, 222);
INSERT INTO public.examination(
	id, price, report, start_time, end_time, is_done, dermatologist_id, patient_id, pharmacy_id)
	VALUES (125, 3000.0, '', '2021-02-17 12:00:25-07', '2021-02-17 12:10:25-07', false, 61, null, 222);
/*
INSERT INTO public.medicine(
	code, composition, form, manufacturer, name, note, on_prescription, type)
	VALUES (222, 'sastav 1', 3, 'galenika', 'brufen', 'napomena 1', true, 'analgetik');
INSERT INTO public.medicine(
	code, composition, form, manufacturer, name, note, on_prescription, type)
	VALUES (223, 'sastav 2', 4, 'hemofarm', 'amoksicilin','napomena 2', false, 'amoksicilin');
*/

  
INSERT INTO public.medicine(
id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, type)
	VALUES (222,'222','/','Headache','2 per day',3,'Galenika','Brufen','/',true,5);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, type)
	VALUES (223,'223','/','Headache','2 per day',4,'Hemofarm','Andol','/',false,7);
INSERT INTO public.medicine(
	id, code, composition, contraindications, daily_dose, form, manufacturer, name, note, on_prescription, type)
	VALUES (224,'224','/','Headache','3 per day',4,'Hemofarm','Klindomicin','/',false,7);


INSERT INTO public.action_or_promotion(
	id, text, medicine_id, pharmacy_id)
	VALUES (222, 'akcija 50%', 222,  111);
INSERT INTO public.action_or_promotion(
	id, text, medicine_id, pharmacy_id)
	VALUES (223, 'akcija 30%', 223, 111);


INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (11, 250.0, 3, 222);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (21, 200.0, 3, 223);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (31, 200.0, 5, 223);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (41, 200.0, 5, 222);
INSERT INTO public.medicine_price_and_quantity(
	id, price, quantity, medicine_id)
	VALUES (51,200.0, 4, 224);

-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (6, 0);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (6, 2);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (6, 4);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (7, 1);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (7, 5);
-- INSERT INTO public.dermatologist_marks(dermatologist_id, marks) VALUES (7, 4);



INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (111, 5, 222, 10);
INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (211, 10, 223, 11);
    
INSERT INTO public.patient_drug_allargies(patient_id, drug_allargies) VALUES (88, 'brufen');
INSERT INTO public.patient_drug_allargies(patient_id, drug_allargies) VALUES (88, 'cefalosporini');
INSERT INTO public.patient_drug_allargies(patient_id, drug_allargies) VALUES (89, 'tetraciklini');
    
-- INSERT INTO public.pharmacist_marks(
-- 	pharmacist_id, marks)
-- 	VALUES (4, 4);
-- INSERT INTO public.pharmacist_marks(
-- 	pharmacist_id, marks)
-- 	VALUES (4, 2);
-- INSERT INTO public.pharmacist_marks(
-- 	pharmacist_id, marks)
-- 	VALUES (4, 1);
-- INSERT INTO public.pharmacist_marks(
-- 	pharmacist_id, marks)
-- 	VALUES (5, 2);
-- INSERT INTO public.pharmacist_marks(
-- 	pharmacist_id, marks)
-- 	VALUES (5, 4);
-- INSERT INTO public.pharmacist_marks(
-- 	pharmacist_id, marks)
-- 	VALUES (5, 2);
    
-- INSERT INTO public.pharmacy_marks(
-- 	pharmacy_id, marks)
-- 	VALUES (111, 4);
-- INSERT INTO public.pharmacy_marks(
-- 	pharmacy_id, marks)
-- 	VALUES (111, 5);
-- INSERT INTO public.pharmacy_marks(
-- 	pharmacy_id, marks)
-- 	VALUES (111, 1);
-- INSERT INTO public.pharmacy_marks(
-- 	pharmacy_id, marks)
-- 	VALUES (222, 4);
-- INSERT INTO public.pharmacy_marks(
-- 	pharmacy_id, marks)
-- 	VALUES (222, 2);
-- INSERT INTO public.pharmacy_marks(
-- 	pharmacy_id, marks)
-- 	VALUES (222, 1);
    
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (100, '2021-03-22', false, 11, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (101, '2021-03-22', true, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (102, '2021-05-12', false, 21, 89, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (103, '2020-03-22', false, 21, 88, 111, false);
INSERT INTO public.reservation(
	id, expiration_date, is_received, medicine_id, patient_id,pharmacy_id, is_canceled)
	VALUES (104, '2021-01-22', false, 21, 88, 111, false);
    

-- INSERT INTO public.therapy(
-- 	id, amount, therapy_duration, medicine_id)
-- 	VALUES (1, 2, 5, 222);
-- INSERT INTO public.therapy(
-- 	id, amount, therapy_duration, medicine_id)
-- 	VALUES (2, 3, 12, 223);
    
-- INSERT INTO public.pharmacy_subscribed_users(patient_id, pharmacy_id) VALUES (88, 111);
-- INSERT INTO public.pharmacy_subscribed_users(patient_id, pharmacy_id) VALUES (88, 222);
-- INSERT INTO public.pharmacy_subscribed_users(patient_id, pharmacy_id) VALUES (89, 111);
-- INSERT INTO public.pharmacy_subscribed_users(patient_id, pharmacy_id) VALUES (90, 222);


INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start)
	VALUES (111, true, '2021-02-12', '2021-02-12');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start)
	VALUES (112, true, '2021-02-22','2021-02-18');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start)
	VALUES (113, true, '2021-02-22', '2021-02-19');
INSERT INTO public.vacation_interval(
	id, approved, date_end, date_start)
	VALUES (114, true, '2021-01-29', '2021-01-19');


INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (61, 111);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (61, 112);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (71, 113);
INSERT INTO public.dermatologist_vacation_schedule(
	dermatologist_id, vacation_interval_id)
	VALUES (61, 114);

INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (41, 111);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (51, 112);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (51, 114);
INSERT INTO public.pharmacist_vacation_schedule(
	pharmacist_id, vacation_interval_id)
	VALUES (41, 113);

INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (111, '2021-05-09 20:00:00-07','2021-05-09 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (112, '2021-06-10 20:00:00-07','2021-06-10 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (113, '2021-06-11 20:00:00-07','2021-06-11 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (114, '2021-06-12 20:00:00-07','2021-06-12 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (115, '2021-06-13 20:00:00-07','2021-06-13 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (116, '2021-06-14 20:00:00-07','2021-06-14 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (117, '2021-06-15 20:00:00-07','2021-06-15 14:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (118, '2021-06-16 20:00:00-07','2021-06-16 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (119, '2021-06-17 20:00:00-07','2021-06-17 11:00:00-07','111');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (120, '2021-06-23 20:00:00-07','2021-06-23 14:00:00-07','111');

INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (211, '2021-05-09 15:00:00-07','2021-05-09 07:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (212, '2021-06-10 14:00:00-07','2021-06-10 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (213, '2021-06-11 15:00:00-07','2021-06-11 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (214, '2021-06-12 14:00:00-07','2021-06-12 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (215, '2021-06-13 15:00:00-07','2021-06-13 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (216, '2021-06-14 14:00:00-07','2021-06-14 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (217, '2021-06-15 14:00:00-07','2021-06-15 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (218, '2021-06-16 15:00:00-07','2021-06-16 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (219, '2021-06-17 14:00:00-07','2021-06-17 08:00:00-07','222');
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (220, '2021-05-23 15:00:00-07','2021-05-23 08:00:00-07','222');

INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 111);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 112);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 213);
	INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 115);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 116);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 117);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 219);
INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 220);

INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (71, 112);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (41, 112);

INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 111);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 114);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 115);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (41, 115);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 116);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 117);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 118);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 119);
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (51, 120);
-- INSERT INTO public.pharmacist_working_schedule(
-- 	pharmacist_id, working_time_id)
-- 	VALUES (5, 111);

-- INSERT INTO public.eprescription_therapies(
-- 	eprescription_code, therapies_id)
-- 	VALUES (111, 1);
-- INSERT INTO public.eprescription_therapies(
-- 	eprescription_code, therapies_id)
-- 	VALUES (112, 2);

INSERT INTO public.eprescription(
	code, issuing_date,therapy_duration, medicine_id,status,pharmacy_id)
	VALUES (111,'2016-10-09',2,11,0,111);
INSERT INTO public.eprescription(
	code, issuing_date,therapy_duration, medicine_id,status,pharmacy_id)
	VALUES (112,'2017-06-22',2,21,1,111);

INSERT INTO public.patient_eprescriptions(
	patient_id, eprescriptions_code)
	VALUES (88, 111);
INSERT INTO public.patient_eprescriptions(
	patient_id, eprescriptions_code)
	VALUES (88, 112);
-- INSERT INTO public.pharmacy_list_actions_or_promotions(
-- 	pharmacy_id, list_actions_or_promotions_id)
-- 	VALUES (1, 11);
-- INSERT INTO public.pharmacy_list_actions_or_promotions(
-- 	pharmacy_id, list_actions_or_promotions_id)
-- 	VALUES (2, 12);



INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (111, 11);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (111, 31);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (222, 21);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (222, 41);
INSERT INTO public.pharmacy_pricelist(
	pharmacy_id, pricelist_id)
	VALUES (222, 51);

INSERT INTO public.medicine_replacement(
	medicine_id, replacement)
	VALUES (222, 'sinacilin');
INSERT INTO public.medicine_replacement(
	medicine_id, replacement)
	VALUES (223, 'panadol');

INSERT INTO public.patient_action_or_promotions(
	patient_id, action_or_promotions_id)
	VALUES (88, 222);
INSERT INTO public.patient_action_or_promotions(
	patient_id, action_or_promotions_id)
	VALUES (88, 223);


INSERT INTO public.pharmacy_subscribed_users(
pharmacy_id,patient_id)
VALUES('111','69');

INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (500, 4, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (501, 1, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (502, 2, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (503, 3, 88);
INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (504, 5, 89);

INSERT INTO public.medicine_marks(
	medicine_id, marks_id)
	VALUES (222, 500);
INSERT INTO public.medicine_marks(
	medicine_id, marks_id)
	VALUES (223, 504);
INSERT INTO public.medicine_marks(
	medicine_id, marks_id)
	VALUES (224, 503);

INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (51, 501);



	
INSERT INTO public.order_medicine(
	id, due_date, pharmacy_admin_id,is_processed)
	VALUES (111,'2008-11-11 13:23:44', 8,false);
	
INSERT INTO public.order_medicine(
	id, due_date, pharmacy_admin_id,is_processed)
	VALUES (211,'2008-11-11 13:23:44', 9,false);

INSERT INTO public.order_medicine(
	id, due_date, pharmacy_admin_id,is_processed)
	VALUES (311,'2008-11-11 13:23:44', 8,false);

INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (211, 111);
INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (211, 211);
INSERT INTO public.medicine_quantity(
	id, quantity, medicine_id, supplier_id)
	VALUES (311, 3, 223, 10);
INSERT INTO public.order_medicine_orders(
	order_id, orders_id)
	VALUES (311, 311);


	INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (557, 'neki datum', 14000.00, 2, 311, 10);
	
	INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (556, 'neki datum', 15000.00, 1, 211, 10);
	
	INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (555, 'neki datum', 16000.00, 0, 111, 10);

	INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (555, 5, 88);
	INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (556, 4, 88);
	INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (557, 3, 88);
	INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (558, 5, 88);

	INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (565, 5, 88);
	INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (566, 4, 88);
	INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (567, 3, 88);
	INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (568, 5, 88);
	INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (569, 3, 88);
	INSERT INTO public.mark(
	id, marks, patient_id)
	VALUES (570, 5, 88);

INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (51, 565);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (121, 566);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (111, 567);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (121, 568);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (111, 569);
INSERT INTO public.pharmacist_marks(
	pharmacist_id, marks_id)
	VALUES (121, 570);


 INSERT INTO public.pharmacy_marks(
 	pharmacy_id, marks_id)
 	VALUES (111, 555);
	 
 INSERT INTO public.pharmacy_marks(
 	pharmacy_id, marks_id)
 	VALUES (111, 556);
	 
 INSERT INTO public.pharmacy_marks(
 	pharmacy_id, marks_id)
 	VALUES (111, 557);

 INSERT INTO public.pharmacy_marks(
 	pharmacy_id, marks_id)
 	VALUES (111, 558);

	 		
INSERT INTO public.examination(
	id, price, start_time, end_time, is_done, dermatologist_id, pharmacy_id, is_canceled)
	VALUES (312, 500.0,  '2021-06-15 19:10:25-07', '2021-06-15 19:20:25-07', false, 61, 111, false);
INSERT INTO public.examination(
	id, price, start_time, end_time, is_done, dermatologist_id, pharmacy_id, is_canceled)
	VALUES (313, 1000.0, '2021-06-15 16:30:25-07', '2021-06-15 16:40:25-07', true, 61, 111, false);
INSERT INTO public.examination(
	id, price, start_time, end_time, is_done, dermatologist_id, pharmacy_id, is_canceled)
	VALUES (314, 800.0, '2021-06-23 09:10:25-07', '2021-06-23 09:20:25-07', false, 61, 111, false);
	
INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (69, '2021-07-23 00:00:00-07','2021-05-1 14:00:00-07','111');

INSERT INTO public.dermatologist_working_schedule(
	dermatologist_id, working_time_id)
	VALUES (61, 69);

INSERT INTO public.working_time(
	id, time_end, time_start,pharmacy_id)
	VALUES (333, '2021-06-10 20:00:00-07','2021-06-10 11:00:00-07','111');
INSERT INTO public.pharmacist_working_schedule(
	pharmacist_id, working_time_id)
	VALUES (41, 333);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, patient_id, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (333, 1000.0, 'Headache', '2021-06-10 16:00:00-07', '2021-06-10 16:25:25-07', false, 88, 41, 111, false);

INSERT INTO public.medicine_request(
	id,medicine_id,date,pharmacy_id,solved)
	VALUES (333,223, '2021-05-10 16:00:00-07',111,false);
INSERT INTO public.medicine_request(
	id,medicine_id,date,pharmacy_id,solved)
	VALUES (334,223, '2021-06-07 16:00:00-07',111,false);

INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (155, 2000.0, '', '2021-08-16 17:00:00-07', '2021-08-16 17:25:25-07', false, 51, 111, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (156, 1000.0, '', '2021-09-13 16:00:00-07', '2021-09-13 16:25:25-07', false, 51, 111, false);
INSERT INTO public.counseling(
	id, price, report, start_time, end_time, is_done, pharmacist_id, pharmacy_id, is_canceled)
	VALUES (157, 2000.0, '', '2021-08-13 17:00:00-07', '2021-08-13 17:25:25-07', false, 51, 111, false);

INSERT INTO public.action_or_promotion(
	id, text, medicine_id, pharmacy_id,start_time,end_time)
	VALUES (331, 'akcija 350%', 222,  111,'2019-08-13 17:00:00-07', '2024-08-13 17:25:25-07');
INSERT INTO public.action_or_promotion(
	id, text, medicine_id, pharmacy_id,start_time,end_time)
	VALUES (443, 'akcija 530%', 223, 111,'2019-08-13 17:00:00-07', '2024-08-13 17:25:25-07');
	VALUES (334,223, '2021-05-13 16:00:00-07',111,false);


INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (345, 'neki datum', 14000.00, 2, 311, 10);
	
INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (432, 'neki datum', 15000.00, 2, 211, 10);
	
INSERT INTO public.supplier_offer(
	id, due_date, offer_price, status, order_medicine_id, supplier_id)
	VALUES (855, 'neki datum', 16000.00, 2, 111, 11);
